package com.collince.rolexcore.audio;



public abstract class BaseAudio implements Audio {

    private final AudioManager<? extends Audio> mParent;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    protected BaseAudio(AudioManager<? extends Audio> audioManager) {
        mParent = audioManager;
    }
    //========================================================

    //--------------------------------------------------------
    // Getter and Setter
    //--------------------------------------------------------
    protected AudioManager<? extends Audio> getParent() {
        return mParent;
    }
    //========================================================

}
