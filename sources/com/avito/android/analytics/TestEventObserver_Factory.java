package com.avito.android.analytics;

import dagger.internal.Factory;
public final class TestEventObserver_Factory implements Factory<TestEventObserver> {

    public static final class a {
        public static final TestEventObserver_Factory a = new TestEventObserver_Factory();
    }

    public static TestEventObserver_Factory create() {
        return a.a;
    }

    public static TestEventObserver newInstance() {
        return new TestEventObserver();
    }

    @Override // javax.inject.Provider
    public TestEventObserver get() {
        return newInstance();
    }
}
