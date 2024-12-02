package com.collince.rolexcore.entity;



public interface Updatable {

    boolean isRunning();

    void setRunning(boolean running);

    boolean isActive();

    void setActive(boolean active);

    void addToGame();

    void removeFromGame();

    void addToScene();

    void removeFromScene();

    void update(long elapsedMillis);

    void reset();

    String getName();

}
