package com.collince.rolexcore.entity.sprite;

import android.graphics.Canvas;

import com.collince.rolexcore.camera.Camera;
import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.texture.Texture;
import com.collince.rolexcore.texture.TextureGroup;



public class FrameSprite extends Sprite {

    protected TextureGroup<? extends Texture> mTextureGroup;
    protected int mCurrentFrameIndex;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public FrameSprite(Core core, TextureGroup<? extends Texture> textureGroup) {
        this(core, 0, 0, textureGroup, 0);
    }

    public FrameSprite(Core core, TextureGroup<? extends Texture> textureGroup, int startFrameIndex) {
        this(core, 0, 0, textureGroup, startFrameIndex);
    }

    public FrameSprite(Core core, float x, float y, TextureGroup<? extends Texture> textureGroup) {
        this(core, x, y, textureGroup, 0);
    }

    public FrameSprite(Core core, float x, float y, TextureGroup<? extends Texture> textureGroup, int startFrameIndex) {
        super(core, x, y, textureGroup.getTextures().get(startFrameIndex));
        mTextureGroup = textureGroup;
        mCurrentFrameIndex = startFrameIndex;
    }
    //========================================================

    //--------------------------------------------------------
    // Getter and Setter
    //--------------------------------------------------------
    public TextureGroup<? extends Texture> getTextureGroup() {
        return mTextureGroup;
    }

    public void setTextureGroup(TextureGroup<? extends Texture> textureGroup) {
        mTextureGroup = textureGroup;
    }

    public int getCurrentFrameIndex() {
        return mCurrentFrameIndex;
    }

    public void setCurrentFrameIndex(int currentFrameIndex) {
        mCurrentFrameIndex = currentFrameIndex;
    }

    public int getFrameCount() {
        return mTextureGroup.getTextureCount();
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    protected void onPreDraw(Canvas canvas, Camera camera) {
        mTexture = mTextureGroup.getTextures().get(mCurrentFrameIndex);
    }

    @Override
    public void reset() {
        super.reset();
        mTexture = mTextureGroup.getTextures().get(mCurrentFrameIndex);
    }
    //========================================================

}
