package com.collince.rolexcore.util.pool;



public class SafeFixedObjectPool<T> extends FixedObjectPool<T> {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public SafeFixedObjectPool(PoolObjectFactory<T> factory, int minCount) {
        super(factory, minCount);
    }

    public SafeFixedObjectPool(PoolObjectFactory<T> factory, int minCount, int maxCount) {
        super(factory, minCount, maxCount);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    protected T getDefaultObject() {
        return getFactory().createObject();
    }
    //========================================================

}
