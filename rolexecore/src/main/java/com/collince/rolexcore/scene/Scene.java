package com.collince.rolexcore.scene;

import com.collince.rolexcore.entity.Updatable;

import java.util.List;



public interface Scene {

    List<Updatable> getAllChild();

    String getName();

    void addToScene(Updatable updatable);

    void removeFromScene(Updatable updatable);

    void startScene();

    void stopScene();

    void pauseScene();

    void resumeScene();

}
