package com.collince.rolexcore.audio;



public interface AudioManager<T extends Audio> {

    T load(int audioId);

    void play();

    void stop();

    void pause();

    void resume();

    void release();

    void addAudio(T audio);

    void removeAudio(T audio);

    boolean isAudioEnable();

    void setAudioEnable(boolean audioEnable);

}
