package com.collince.rolexcore.core.loop;



public interface Loop {

    void startLoop();

    void stopLoop();

    void pauseLoop();

    void resumeLoop();

    boolean isRunning();

    boolean isPaused();

}
