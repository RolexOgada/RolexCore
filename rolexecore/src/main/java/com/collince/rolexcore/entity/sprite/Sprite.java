package com.collince.rolexcore.entity.sprite;

import android.graphics.Canvas;

import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.entity.shape.RectangleShapeEntity;
import com.collince.rolexcore.texture.Texture;



public class Sprite extends RectangleShapeEntity {

    protected Texture mTexture;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public Sprite(Core core, Texture texture) {
        this(core, 0, 0, texture);
    }

    public Sprite(Core core, float x, float y, Texture texture) {
        super(core, x, y, texture.getWidth(), texture.getHeight());
        mTexture = texture;
    }
    //========================================================

    //--------------------------------------------------------
    // Getter and Setter
    //--------------------------------------------------------
    public Texture getTexture() {
        return mTexture;
    }

    public void setTexture(Texture texture) {
        mTexture = texture;
        setWidth(mTexture.getWidth());
        setHeight(mTexture.getHeight());
        resetScalePivot();
        resetRotationPivot();
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    protected void onDrawCanvas(Canvas canvas) {
        canvas.drawBitmap(mTexture.getBitmap(), 0, 0, mPaint);
    }
    //========================================================

}
