package com.avito.android.str_calendar.di.module;

import com.avito.android.str_calendar.seller.edit.konveyor.header.HeaderItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StrSellerCalendarParametersModule_ProvideHeaderItemPresenter$str_calendar_releaseFactory implements Factory<HeaderItemPresenter> {

    public static final class a {
        public static final StrSellerCalendarParametersModule_ProvideHeaderItemPresenter$str_calendar_releaseFactory a = new StrSellerCalendarParametersModule_ProvideHeaderItemPresenter$str_calendar_releaseFactory();
    }

    public static StrSellerCalendarParametersModule_ProvideHeaderItemPresenter$str_calendar_releaseFactory create() {
        return a.a;
    }

    public static HeaderItemPresenter provideHeaderItemPresenter$str_calendar_release() {
        return (HeaderItemPresenter) Preconditions.checkNotNullFromProvides(StrSellerCalendarParametersModule.provideHeaderItemPresenter$str_calendar_release());
    }

    @Override // javax.inject.Provider
    public HeaderItemPresenter get() {
        return provideHeaderItemPresenter$str_calendar_release();
    }
}
