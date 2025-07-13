package com.collince.rolexcore.scene;

import com.collince.rolexcore.entity.Updatable;
import com.collince.rolexcore.util.exception.CoreRuntimeException;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseScene implements Scene {

    private boolean mIsRunning = false;
    private boolean mIsPause = false;

    private final List<Updatable> mUpdatables = new ArrayList<>();

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    protected BaseScene() {
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public List<Updatable> getAllChild() {
        return mUpdatables;
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public void addToScene(Updatable updatable) {
        mUpdatables.add(updatable);
    }

    @Override
    public void removeFromScene(Updatable updatable) {
        mUpdatables.remove(updatable);
    }

    @Override
    public void startScene() {
        if (mIsRunning) {
            throw new CoreRuntimeException("'" + getName() + "' is already started!");
        }
        mIsRunning = true;
        mIsPause = false;
        int updatableCount = mUpdatables.size();
        for (int i = 0; i < updatableCount; i++) {
            Updatable u = mUpdatables.get(i);
            if (!u.isRunning()) {
                // Add the child directly to the game,
                // since they are already in the scene
                u.addToGame();
            }
        }
        onStartScene();
    }

    @Override
    public void stopScene() {
        if (!mIsRunning) {
            throw new CoreRuntimeException("'" + getName() + "' is not started yet!");
        }
        mIsRunning = false;
        int updatableCount = mUpdatables.size();
        for (int i = updatableCount - 1; i >= 0; i--) {
            Updatable u = mUpdatables.get(i);
            if (u.isRunning()) {
                // Remove the child from the game, but not
                // remove from scene, so scene can be reused
                u.removeFromGame();
            }
        }
        onStopScene();
    }

    @Override
    public void pauseScene() {
        if (mIsPause) {
            throw new CoreRuntimeException("'" + getName() + "' is already paused!");
        }
        mIsPause = true;
        onPauseScene();
    }

    @Override
    public void resumeScene() {
        if (!mIsPause) {
            throw new CoreRuntimeException("'" + getName() + "' is not paused yet!");
        }
        mIsPause = false;
        onPauseScene();
    }
    //========================================================

    //--------------------------------------------------------
    // Methods
    //--------------------------------------------------------
    protected void onStartScene() {
    }

    protected void onStopScene() {
    }

    protected void onPauseScene() {
    }

    protected void onResumeScene() {
    }
    //========================================================

}
