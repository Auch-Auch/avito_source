package com.avito.android.publish.slots.limits_info;

import dagger.internal.Factory;
public final class LimitsInfoSlotLayoutProvider_Factory implements Factory<LimitsInfoSlotLayoutProvider> {

    public static final class a {
        public static final LimitsInfoSlotLayoutProvider_Factory a = new LimitsInfoSlotLayoutProvider_Factory();
    }

    public static LimitsInfoSlotLayoutProvider_Factory create() {
        return a.a;
    }

    public static LimitsInfoSlotLayoutProvider newInstance() {
        return new LimitsInfoSlotLayoutProvider();
    }

    @Override // javax.inject.Provider
    public LimitsInfoSlotLayoutProvider get() {
        return newInstance();
    }
}
