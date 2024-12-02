package com.collince.rolexcore.entity.sprite;

import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.texture.Texture;
import com.collince.rolexcore.texture.TextureGroup;
import com.collince.rolexcore.util.MathUtils;



public class AnimateSprite extends FrameSprite {

    private AnimationListener mListener;
    private int mStartFrameIndex;
    private int mEndFrameIndex;
    private long mTotalTime;
    private boolean mIsAutoStart = true;
    private boolean mIsAutoRemove = false;
    private boolean mIsPlaying = false;

    private final Animation mAnimation = new Animation();

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public AnimateSprite(Core core, TextureGroup<? extends Texture> textureGroup) {
        this(core, 0, 0, textureGroup, 0, textureGroup.getTextureCount() - 1);
    }

    public AnimateSprite(Core core, TextureGroup<? extends Texture> textureGroup, int startFrameIndex) {
        this(core, 0, 0, textureGroup, startFrameIndex, textureGroup.getTextureCount() - 1);
    }

    public AnimateSprite(Core core, TextureGroup<? extends Texture> textureGroup, int startFrameIndex, int endFrameIndex) {
        this(core, 0, 0, textureGroup, startFrameIndex, endFrameIndex);
    }

    public AnimateSprite(Core core, float x, float y, TextureGroup<? extends Texture> textureGroup) {
        this(core, x, y, textureGroup, 0, textureGroup.getTextureCount() - 1);
    }

    public AnimateSprite(Core core, float x, float y, TextureGroup<? extends Texture> textureGroup, int startFrameIndex) {
        this(core, x, y, textureGroup, startFrameIndex, textureGroup.getTextureCount() - 1);
    }

    public AnimateSprite(Core core, float x, float y, TextureGroup<? extends Texture> textureGroup, int startFrameIndex, int endFrameIndex) {
        super(core, x, y, textureGroup, startFrameIndex);
        mStartFrameIndex = startFrameIndex;
        mEndFrameIndex = endFrameIndex;
    }
    //========================================================

    //--------------------------------------------------------
    // Getter and Setter
    //--------------------------------------------------------
    public AnimationListener getAnimationListener() {
        return mListener;
    }

    public void setAnimationListener(AnimationListener listener) {
        mListener = listener;
    }

    public int getStartFrameIndex() {
        return mStartFrameIndex;
    }

    public void setStartFrameIndex(int startFrameIndex) {
        mStartFrameIndex = startFrameIndex;
    }

    public int getEndFrameIndex() {
        return mEndFrameIndex;
    }

    public void setEndFrameIndex(int endFrameIndex) {
        mEndFrameIndex = endFrameIndex;
    }

    public boolean isAnimationAutoStart() {
        return mIsAutoStart;
    }

    public void setAnimationAutoStart(boolean autoStart) {
        mIsAutoStart = autoStart;
    }

    public boolean isAnimationAutoRemove() {
        return mIsAutoRemove;
    }

    public void setAnimationAutoRemove(boolean autoRemove) {
        mIsAutoRemove = autoRemove;
    }

    public boolean isPlaying() {
        return mIsPlaying;
    }

    public void setAnimation(long frameDuration) {
        mAnimation.set(frameDuration, mTextureGroup.getTextureCount());
    }

    public void setAnimation(long frameDuration, boolean looping) {
        mAnimation.set(frameDuration, mTextureGroup.getTextureCount(), looping);
    }

    public void setAnimation(long frameDuration, int frameCount) {
        mAnimation.set(frameDuration, frameCount);
    }

    public void setAnimation(long frameDuration, int frameCount, boolean looping) {
        mAnimation.set(frameDuration, frameCount, looping);
    }

    public void setAnimation(long[] frameDurations) {
        mAnimation.set(frameDurations);
    }

    public void setAnimation(long[] frameDurations, boolean looping) {
        mAnimation.set(frameDurations, looping);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void addToGame() {
        super.addToGame();
        if (mIsAutoStart) {
            startAnimation();
        }
    }

    @Override
    protected void onPreUpdate(long elapsedMillis) {
        if (!mIsPlaying) {
            return;
        }

        // Calculate animation duration
        long duration = 0;
        for (int i = mStartFrameIndex; i <= mEndFrameIndex; i++) {
            duration += mAnimation.getFrameDurations()[i];
        }

        // Update animation duration
        mTotalTime += elapsedMillis;
        if (mTotalTime >= duration) {
            if (mAnimation.isLooping()) {
                if (mListener != null) {
                    mListener.onAnimationRepeat();
                }
                mTotalTime = mTotalTime % duration;
            } else {
                stopAnimation();
                return;
            }
        }

        // Update animation frame
        long animationElapsedTime = 0;
        for (int i = mStartFrameIndex; i <= mEndFrameIndex; i++) {
            animationElapsedTime += mAnimation.getFrameDurations()[i];
            if (animationElapsedTime > mTotalTime) {
                mCurrentFrameIndex = i;
                break;
            }
        }
    }

    @Override
    public void reset() {
        mCurrentFrameIndex = mStartFrameIndex;
        super.reset();
        stopAnimation();
        mIsAutoStart = true;
        mIsAutoRemove = false;
        mTotalTime = 0;
    }
    //========================================================

    //--------------------------------------------------------
    // Methods
    //--------------------------------------------------------
    public void startAnimation() {
        if (mIsPlaying) {
            return;
        }
        mCurrentFrameIndex = mStartFrameIndex;
        mIsPlaying = true;
        mTotalTime = 0;
        if (mListener != null) {
            mListener.onAnimationStart();
        }
    }

    public void stopAnimation() {
        if (!mIsPlaying) {
            return;
        }
        mIsPlaying = false;
        mTotalTime = 0;
        if (mIsAutoRemove) {
            removeFromGame();
        }
        if (mListener != null) {
            mListener.onAnimationStop();
        }
    }

    public void pauseAnimation() {
        if (!mIsPlaying) {
            return;
        }
        mIsPlaying = false;
        if (mListener != null) {
            mListener.onAnimationPause();
        }
    }

    public void resumeAnimation() {
        if (mIsPlaying) {
            return;
        }
        mIsPlaying = true;
        if (mListener != null) {
            mListener.onAnimationResume();
        }
    }

    public void resetAnimation() {
        mCurrentFrameIndex = mStartFrameIndex;
        mTotalTime = 0;
        if (mListener != null) {
            mListener.onAnimationReset();
        }
    }
    //========================================================

    //--------------------------------------------------------
    // Inner Classes
    //--------------------------------------------------------
    private static class Animation {

        private long[] mFrameDurations;
        private long mDuration;
        private int mFrameCount;
        private boolean mIsLooping;

        //--------------------------------------------------------
        // Constructors
        //--------------------------------------------------------
        public Animation() {
        }
        //========================================================

        //--------------------------------------------------------
        // Getter and Setter
        //--------------------------------------------------------
        public long[] getFrameDurations() {
            return mFrameDurations;
        }

        public long getDuration() {
            return mDuration;
        }

        public int getFrameCount() {
            return mFrameCount;
        }

        public boolean isLooping() {
            return mIsLooping;
        }

        public void set(long frameDuration, int frameCount) {
            set(MathUtils.fill(frameDuration, frameCount), false);
        }

        public void set(long frameDuration, int frameCount, boolean looping) {
            set(MathUtils.fill(frameDuration, frameCount), looping);
        }

        public void set(long[] frameDurations) {
            set(frameDurations, false);
        }

        public void set(long[] frameDurations, boolean looping) {
            mFrameDurations = frameDurations;
            mDuration = MathUtils.sum(frameDurations);
            mFrameCount = frameDurations.length;
            mIsLooping = looping;
        }
        //========================================================

    }

    public interface AnimationListener {

        default void onAnimationStart() {
        }

        default void onAnimationStop() {
        }

        default void onAnimationPause() {
        }

        default void onAnimationResume() {
        }

        default void onAnimationReset() {
        }

        default void onAnimationRepeat() {
        }

    }
    //========================================================

}
