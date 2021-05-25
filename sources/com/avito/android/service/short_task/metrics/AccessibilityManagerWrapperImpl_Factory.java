package com.avito.android.service.short_task.metrics;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AccessibilityManagerWrapperImpl_Factory implements Factory<AccessibilityManagerWrapperImpl> {
    public final Provider<Context> a;

    public AccessibilityManagerWrapperImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static AccessibilityManagerWrapperImpl_Factory create(Provider<Context> provider) {
        return new AccessibilityManagerWrapperImpl_Factory(provider);
    }

    public static AccessibilityManagerWrapperImpl newInstance(Context context) {
        return new AccessibilityManagerWrapperImpl(context);
    }

    @Override // javax.inject.Provider
    public AccessibilityManagerWrapperImpl get() {
        return newInstance(this.a.get());
    }
}
