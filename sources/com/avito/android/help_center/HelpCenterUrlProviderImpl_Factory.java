package com.avito.android.help_center;

import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HelpCenterUrlProviderImpl_Factory implements Factory<HelpCenterUrlProviderImpl> {
    public final Provider<Features> a;

    public HelpCenterUrlProviderImpl_Factory(Provider<Features> provider) {
        this.a = provider;
    }

    public static HelpCenterUrlProviderImpl_Factory create(Provider<Features> provider) {
        return new HelpCenterUrlProviderImpl_Factory(provider);
    }

    public static HelpCenterUrlProviderImpl newInstance(Features features) {
        return new HelpCenterUrlProviderImpl(features);
    }

    @Override // javax.inject.Provider
    public HelpCenterUrlProviderImpl get() {
        return newInstance(this.a.get());
    }
}
