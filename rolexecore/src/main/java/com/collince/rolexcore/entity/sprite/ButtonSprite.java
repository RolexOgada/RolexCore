package com.collince.rolexcore.entity.sprite;

import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.input.touch.BoundTouchEventListener;
import com.collince.rolexcore.input.touch.TouchEvent;
import com.collince.rolexcore.input.touch.TouchEventListener;
import com.collince.rolexcore.texture.Texture;
import com.collince.rolexcore.texture.TextureGroup;



public class ButtonSprite extends FrameSprite implements BoundTouchEventListener, TouchEventListener {

    private ButtonListener mListener;
    private ButtonState mState = ButtonState.ENABLE;

    public enum ButtonState {
        ENABLE,
        PRESSED,
        DISABLE
    }

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public ButtonSprite(Core core, TextureGroup<? extends Texture> textureGroup) {
        super(core, textureGroup);
    }

    public ButtonSprite(Core core, float x, float y, TextureGroup<? extends Texture> textureGroup) {
        super(core, x, y, textureGroup);
    }
    //========================================================

    //--------------------------------------------------------
    // Getter and Setter
    //--------------------------------------------------------
    public ButtonListener getButtonListener() {
        return mListener;
    }

    public void setButtonListener(ButtonListener listener) {
        mListener = listener;
    }

    public ButtonState getButtonState() {
        return mState;
    }

    public void setButtonState(ButtonState state) {
        mState = state;
        onUpdateButtonState();
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void onBoundTouchEvent(int type, float relativeTouchX, float relativeTouchY) {
        if (mState == ButtonState.DISABLE) {
            return;
        }
        if (type == TouchEvent.TOUCH_DOWN) {
            mState = ButtonState.PRESSED;
            onUpdateButtonState();
        }
    }

    @Override
    public void onTouchEvent(int type, float touchX, float touchY) {
        if (mState == ButtonState.DISABLE) {
            return;
        }
        // Check the touch up event when pressed state to prevent
        // pressing the button in bounds and release somewhere else
        if (type == TouchEvent.TOUCH_UP && mState == ButtonState.PRESSED) {
            mState = ButtonState.ENABLE;
            onUpdateButtonState();
        }
    }
    //========================================================

    //--------------------------------------------------------
    // Methods
    //--------------------------------------------------------
    protected void onUpdateButtonState() {
        if (mListener == null) {
            return;
        }
        switch (mState) {
            case ENABLE:
                setCurrentFrameIndex(0);
                mListener.onEnableButton(this);
                break;
            case PRESSED:
                if (getFrameCount() >= 2) {
                    setCurrentFrameIndex(1);
                }
                mListener.onPressedButton(this);
                break;
            case DISABLE:
                if (getFrameCount() >= 3) {
                    setCurrentFrameIndex(2);
                }
                mListener.onDisableButton(this);
                break;
        }
    }
    //========================================================

    //--------------------------------------------------------
    // Inner Classes
    //--------------------------------------------------------
    public interface ButtonListener {

        void onEnableButton(ButtonSprite button);

        void onDisableButton(ButtonSprite button);

        void onPressedButton(ButtonSprite button);

    }
    //========================================================

}
