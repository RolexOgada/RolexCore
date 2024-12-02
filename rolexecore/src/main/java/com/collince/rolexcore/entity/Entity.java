package com.collince.rolexcore.entity;

import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.event.Event;



public abstract class Entity implements Updatable, Releasable {

    protected final Core mCore;

    private boolean mIsRunning = false;
    private boolean mIsActive = true;
    private boolean mIsRelease = false;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    protected Entity(Core core) {
        mCore = core;
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public boolean isRunning() {
        return mIsRunning;
    }

    @Override
    public void setRunning(boolean running) {
        mIsRunning = running;
    }

    @Override
    public boolean isActive() {
        return mIsActive;
    }

    @Override
    public void setActive(boolean active) {
        mIsActive = active;
    }

    @Override
    public void addToGame() {
        mCore.addToEngine(this);
        onStart();
    }

    @Override
    public void removeFromGame() {
        mCore.removeFromEngine(this);
        onRemove();
    }

    @Override
    public void addToScene() {
        mCore.addToScene(this);
        onStart();
    }

    @Override
    public void removeFromScene() {
        mCore.removeFromScene(this);
        onRemove();
    }

    @Override
    public void update(long elapsedMillis) {
        onPreUpdate(elapsedMillis);
        onUpdate(elapsedMillis);
        onPostUpdate(elapsedMillis);
    }

    @Override
    public void reset() {
        mIsActive = true;
    }

    @Override
    public void release() {
        mIsRelease = true;
        onRelease();
    }

    @Override
    public boolean isRelease() {
        return mIsRelease;
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
    //========================================================

    //--------------------------------------------------------
    // Methods
    //--------------------------------------------------------
    protected void onStart() {
    }

    protected void onRemove() {
    }

    protected void onRelease() {
    }

    protected void onPreUpdate(long elapsedMillis) {
    }

    protected void onUpdate(long elapsedMillis) {
    }

    protected void onPostUpdate(long elapsedMillis) {
    }

    public void dispatchEvent(Event event) {
        mCore.dispatchEvent(event);
    }
    //========================================================

}
