package com.avito.android.service.short_task.metrics;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AccessibilityInfoProvider_Factory implements Factory<AccessibilityInfoProvider> {
    public final Provider<AccessibilityManagerWrapper> a;

    public AccessibilityInfoProvider_Factory(Provider<AccessibilityManagerWrapper> provider) {
        this.a = provider;
    }

    public static AccessibilityInfoProvider_Factory create(Provider<AccessibilityManagerWrapper> provider) {
        return new AccessibilityInfoProvider_Factory(provider);
    }

    public static AccessibilityInfoProvider newInstance(AccessibilityManagerWrapper accessibilityManagerWrapper) {
        return new AccessibilityInfoProvider(accessibilityManagerWrapper);
    }

    @Override // javax.inject.Provider
    public AccessibilityInfoProvider get() {
        return newInstance(this.a.get());
    }
}
