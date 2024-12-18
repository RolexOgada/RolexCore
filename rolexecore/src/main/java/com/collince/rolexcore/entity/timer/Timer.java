package com.collince.rolexcore.entity.timer;

import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.entity.Entity;

import java.util.ArrayList;
import java.util.List;



public class Timer extends Entity {

    private int mEventCount;
    private long mTotalEventTime;
    private long mTotalTime;
    private boolean mIsLooping;
    private boolean mIsTimerRunning = false;

    private final List<TimerEvent> mEvents = new ArrayList<>();

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public Timer(Core core) {
        this(core, false);
    }

    public Timer(Core core, boolean isLooping) {
        super(core);
        mIsLooping = isLooping;
    }
    //========================================================

    //--------------------------------------------------------
    // Getter and Setter
    //--------------------------------------------------------
    public boolean isLooping() {
        return mIsLooping;
    }

    public void setLooping(boolean looping) {
        mIsLooping = looping;
    }

    public List<TimerEvent> getAllTimerEvents() {
        return mEvents;
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void onUpdate(long elapsedMillis) {
        if (!mIsTimerRunning) {
            return;
        }
        mTotalTime += elapsedMillis;

        // Dispatch timer event
        int eventCount = mEvents.size();
        for (int i = 0; i < eventCount; i++) {
            TimerEvent event = mEvents.get(i);
            // Dispatch one event if time passed
            if (!event.isTimerEventDispatch() && mTotalTime >= event.getEventTime()) {
                event.dispatchTimerEvent();
                mEventCount--;
            }
        }

        // Check is total time passed
        if (mEventCount <= 0) {
            if (mIsLooping) {
                mTotalTime = mTotalTime % mTotalEventTime;
                // Reset event state
                for (int i = 0; i < mEventCount; i++) {
                    TimerEvent event = mEvents.get(i);
                    event.resetTimerEvent();
                }
            } else {
                stop();
            }
        }
    }

    @Override
    public void reset() {
        super.reset();
        mIsLooping = false;
        stop();
        clearTimerEvent();
    }
    //========================================================

    //--------------------------------------------------------
    // Methods
    //--------------------------------------------------------
    public void start() {
        mIsTimerRunning = true;
        resetTimerEvent();
        addToGame();
    }

    public void stop() {
        // Check has timer been started yet
        if (isRunning()) {
            removeFromGame();
        }
        mIsTimerRunning = false;
        mEventCount = 0;
        mTotalEventTime = 0;
        mTotalTime = 0;
    }

    public void pause() {
        mIsTimerRunning = false;
    }

    public void resume() {
        mIsTimerRunning = true;
    }

    public void addTimerEvent(TimerEvent event) {
        mEvents.add(event);
    }

    public void removeTimerEvent(TimerEvent event) {
        mEvents.remove(event);
    }

    public void clearTimerEvent() {
        mEvents.clear();
    }

    public void resetTimerEvent() {
        mEventCount = mEvents.size();
        mTotalEventTime = 0;
        mTotalTime = 0;
        // Reset event state
        for (int i = 0; i < mEventCount; i++) {
            TimerEvent event = mEvents.get(i);
            event.resetTimerEvent();
            if (event.getEventTime() > mTotalEventTime) {
                mTotalEventTime = event.getEventTime();
            }
        }
    }
    //========================================================

}
