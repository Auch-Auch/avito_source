package com.avito.android.advert_core.car_market_price.badge;

import dagger.internal.Factory;
public final class AdvertDetailsImvBadgeItemConverterImpl_Factory implements Factory<AdvertDetailsImvBadgeItemConverterImpl> {

    public static final class a {
        public static final AdvertDetailsImvBadgeItemConverterImpl_Factory a = new AdvertDetailsImvBadgeItemConverterImpl_Factory();
    }

    public static AdvertDetailsImvBadgeItemConverterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsImvBadgeItemConverterImpl newInstance() {
        return new AdvertDetailsImvBadgeItemConverterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsImvBadgeItemConverterImpl get() {
        return newInstance();
    }
}
