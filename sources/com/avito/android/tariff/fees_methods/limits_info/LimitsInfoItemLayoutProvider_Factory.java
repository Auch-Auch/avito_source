package com.avito.android.tariff.fees_methods.limits_info;

import dagger.internal.Factory;
public final class LimitsInfoItemLayoutProvider_Factory implements Factory<LimitsInfoItemLayoutProvider> {

    public static final class a {
        public static final LimitsInfoItemLayoutProvider_Factory a = new LimitsInfoItemLayoutProvider_Factory();
    }

    public static LimitsInfoItemLayoutProvider_Factory create() {
        return a.a;
    }

    public static LimitsInfoItemLayoutProvider newInstance() {
        return new LimitsInfoItemLayoutProvider();
    }

    @Override // javax.inject.Provider
    public LimitsInfoItemLayoutProvider get() {
        return newInstance();
    }
}
