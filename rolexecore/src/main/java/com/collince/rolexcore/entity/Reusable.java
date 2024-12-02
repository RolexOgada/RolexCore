package com.collince.rolexcore.entity;



public interface Reusable<T> {

    RecycleListener<T> getRecycleListener();

    void setRecycleListener(RecycleListener<T> listener);

    public interface RecycleListener<T> {

        void recycle(T object);

    }

}
