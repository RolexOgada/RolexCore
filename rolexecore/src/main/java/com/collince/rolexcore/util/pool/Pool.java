package com.collince.rolexcore.util.pool;

import java.util.List;



public interface Pool<T> {

    PoolObjectFactory<T> getFactory();

    List<T> getAllObjects();

    int getObjectCount();

    T obtainObject();

    void returnObject(T object);

    void release();

    public interface PoolObjectFactory<T> {

        T createObject();

    }

}
