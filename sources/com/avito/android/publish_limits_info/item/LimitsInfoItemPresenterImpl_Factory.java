package com.avito.android.publish_limits_info.item;

import com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LimitsInfoItemPresenterImpl_Factory implements Factory<LimitsInfoItemPresenterImpl> {
    public final Provider<PublishLimitsEventTracker> a;

    public LimitsInfoItemPresenterImpl_Factory(Provider<PublishLimitsEventTracker> provider) {
        this.a = provider;
    }

    public static LimitsInfoItemPresenterImpl_Factory create(Provider<PublishLimitsEventTracker> provider) {
        return new LimitsInfoItemPresenterImpl_Factory(provider);
    }

    public static LimitsInfoItemPresenterImpl newInstance(PublishLimitsEventTracker publishLimitsEventTracker) {
        return new LimitsInfoItemPresenterImpl(publishLimitsEventTracker);
    }

    @Override // javax.inject.Provider
    public LimitsInfoItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
