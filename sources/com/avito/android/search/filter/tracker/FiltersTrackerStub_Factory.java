package com.avito.android.search.filter.tracker;

import dagger.internal.Factory;
public final class FiltersTrackerStub_Factory implements Factory<FiltersTrackerStub> {

    public static final class a {
        public static final FiltersTrackerStub_Factory a = new FiltersTrackerStub_Factory();
    }

    public static FiltersTrackerStub_Factory create() {
        return a.a;
    }

    public static FiltersTrackerStub newInstance() {
        return new FiltersTrackerStub();
    }

    @Override // javax.inject.Provider
    public FiltersTrackerStub get() {
        return newInstance();
    }
}
