package com.collince.rolexcore.texture;

import java.util.List;



public interface TextureGroup<T extends Texture> {

    List<T> getTextures();

    int getTextureCount();

    void addTexture(T texture);

    void removeTexture(T texture);

    void addTextures(List<T> textures);

    void removeTextures(List<T> textures);

    void release();

}
