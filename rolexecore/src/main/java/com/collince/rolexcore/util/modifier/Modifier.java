package com.collince.rolexcore.util.modifier;



public interface Modifier<T> {

    ModifierListener getListener();

    void setListener(ModifierListener listener);

    long getDuration();

    void setDuration(long duration);

    long getStartDelay();

    void setStartDelay(long startDelay);

    long getElapsedDuration();

    boolean isRunning();

    void setRunning(boolean running);

    boolean isLooping();

    void setLooping(boolean looping);

    void init(T entity);

    void update(T entity, long elapsedMillis);

    void reset(T entity);

    public interface ModifierListener {

        void onModifierComplete();

    }

}
