package com.avito.android.user_advert.advert.autopublish_block;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutoPublishBlockResourceProvider_Factory implements Factory<AutoPublishBlockResourceProvider> {
    public final Provider<Resources> a;

    public AutoPublishBlockResourceProvider_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static AutoPublishBlockResourceProvider_Factory create(Provider<Resources> provider) {
        return new AutoPublishBlockResourceProvider_Factory(provider);
    }

    public static AutoPublishBlockResourceProvider newInstance(Resources resources) {
        return new AutoPublishBlockResourceProvider(resources);
    }

    @Override // javax.inject.Provider
    public AutoPublishBlockResourceProvider get() {
        return newInstance(this.a.get());
    }
}
