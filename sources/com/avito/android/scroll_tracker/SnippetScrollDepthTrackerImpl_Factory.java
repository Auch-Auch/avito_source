package com.avito.android.scroll_tracker;

import dagger.internal.Factory;
public final class SnippetScrollDepthTrackerImpl_Factory implements Factory<SnippetScrollDepthTrackerImpl> {

    public static final class a {
        public static final SnippetScrollDepthTrackerImpl_Factory a = new SnippetScrollDepthTrackerImpl_Factory();
    }

    public static SnippetScrollDepthTrackerImpl_Factory create() {
        return a.a;
    }

    public static SnippetScrollDepthTrackerImpl newInstance() {
        return new SnippetScrollDepthTrackerImpl();
    }

    @Override // javax.inject.Provider
    public SnippetScrollDepthTrackerImpl get() {
        return newInstance();
    }
}
