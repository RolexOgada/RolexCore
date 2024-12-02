package com.collince.rolexcore.texture;

import android.graphics.Bitmap;



public interface Texture {

    TextureFormat getFormat();

    Bitmap getBitmap();

    int getWidth();

    int getHeight();

    void release();

}
