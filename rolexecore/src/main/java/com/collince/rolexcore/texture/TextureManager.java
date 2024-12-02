package com.collince.rolexcore.texture;

import android.graphics.Bitmap;



public interface TextureManager<T extends Texture, S extends TextureGroup<T>> {

    T loadTexture(int drawableId);

    T loadTexture(Bitmap bitmap);

    S loadTextureGroup(int[] drawableIds);

    S loadTextureGroup(Bitmap[] bitmaps);

    void release();

    void addTexture(T graphic);

    void removeTexture(T graphic);

}
