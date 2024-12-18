package com.collince.rolexcore.core.loop;



public class DrawLoop extends BaseLoop {

    private DrawListener mListener;

    private static final int DELTA_TIME = 16;   // This is 60 fps

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public DrawLoop() {
        super();
    }
    //========================================================

    //--------------------------------------------------------
    // Getter and Setter
    //--------------------------------------------------------
    public DrawListener getListener() {
        return mListener;
    }

    public void setListener(DrawListener listener) {
        mListener = listener;
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void onUpdateLoop(long elapsedMillis) {
        if (elapsedMillis < DELTA_TIME) {
            try {
                // We make sure each loop is fixed
                Thread.sleep(DELTA_TIME - elapsedMillis);
            } catch (InterruptedException e) {
                // We stay on the loop
            }
        }
        mListener.draw();
    }
    //========================================================

    //--------------------------------------------------------
    // Inner Classes
    //--------------------------------------------------------
    public interface DrawListener {

        void draw();

    }
    //========================================================

}
