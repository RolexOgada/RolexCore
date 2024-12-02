package com.collince.rolexcore;

import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.ui.GameActivity;
import com.collince.rolexcore.ui.GameView;




public class Game {

    private final GameActivity mActivity;
    private final GameView mGameView;
    private final Core mCore;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public Game(GameActivity activity, GameView gameView, Core core) {
        mActivity = activity;
        mGameView = gameView;
        mCore = core;
        mCore.setGameView(gameView);
    }
    //========================================================

    //--------------------------------------------------------
    // Getter and Setter
    //--------------------------------------------------------
    public GameActivity getActivity() {
        return mActivity;
    }

    public GameView getGameView() {
        return mGameView;
    }

    public Core getEngine() {
        return mCore;
    }
    //========================================================

    //--------------------------------------------------------
    // Methods
    //--------------------------------------------------------
    public final void start() {
        if (!mCore.isRunning()) {
            mCore.start();
            onStart();
        }
    }

    public final void stop() {
        if (mCore.isRunning()) {
            mCore.stop();
            mCore.release();
            onStop();
        }
    }

    public final void pause() {
        if (mCore.isRunning() && !mCore.isPaused()) {
            mCore.pause();
            onPause();
        }
    }

    public final void resume() {
        if (mCore.isRunning() && mCore.isPaused()) {
            mCore.resume();
            onResume();
        }
    }

    protected void onStart() {
    }

    protected void onStop() {
    }

    protected void onPause() {
    }

    protected void onResume() {
    }
    //========================================================

}
