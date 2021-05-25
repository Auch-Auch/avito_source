package com.avito.android.util.architecture_components;

import dagger.internal.Factory;
public final class SingleLiveEvent_Factory<T> implements Factory<SingleLiveEvent<T>> {

    public static final class a {
        public static final SingleLiveEvent_Factory a = new SingleLiveEvent_Factory();
    }

    public static <T> SingleLiveEvent_Factory<T> create() {
        return a.a;
    }

    public static <T> SingleLiveEvent<T> newInstance() {
        return new SingleLiveEvent<>();
    }

    @Override // javax.inject.Provider
    public SingleLiveEvent<T> get() {
        return newInstance();
    }
}
