package com.collince.rolexcore.entity.modifier;

import com.collince.rolexcore.entity.Updatable;
import com.collince.rolexcore.util.modifier.BaseModifier;



public class DurationModifier extends BaseModifier<Updatable> {

    private boolean mIsAutoRemove = false;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public DurationModifier(long duration) {
        super(duration, 0);
    }

    public DurationModifier(long duration, long startDelay) {
        super(duration, startDelay);
    }
    //========================================================

    //--------------------------------------------------------
    // Getter and Setter
    //--------------------------------------------------------
    public boolean isAutoRemove() {
        return mIsAutoRemove;
    }

    public void setAutoRemove(boolean autoRemove) {
        mIsAutoRemove = autoRemove;
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    protected void onStartModifier(Updatable entity) {
    }

    @Override
    protected void onUpdateModifier(Updatable entity, float durationPercentage) {
    }

    @Override
    protected void onEndModifier(Updatable entity) {
        if (mIsAutoRemove) {
            entity.removeFromGame();
        }
    }

    @Override
    protected void onResetModifier(Updatable entity) {
    }
    //========================================================

}
