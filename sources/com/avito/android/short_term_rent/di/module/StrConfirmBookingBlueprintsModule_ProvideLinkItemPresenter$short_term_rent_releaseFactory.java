package com.avito.android.short_term_rent.di.module;

import com.avito.android.short_term_rent.confirm_booking.items.link.LinkItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class StrConfirmBookingBlueprintsModule_ProvideLinkItemPresenter$short_term_rent_releaseFactory implements Factory<LinkItemPresenter> {

    public static final class a {
        public static final StrConfirmBookingBlueprintsModule_ProvideLinkItemPresenter$short_term_rent_releaseFactory a = new StrConfirmBookingBlueprintsModule_ProvideLinkItemPresenter$short_term_rent_releaseFactory();
    }

    public static StrConfirmBookingBlueprintsModule_ProvideLinkItemPresenter$short_term_rent_releaseFactory create() {
        return a.a;
    }

    public static LinkItemPresenter provideLinkItemPresenter$short_term_rent_release() {
        return (LinkItemPresenter) Preconditions.checkNotNullFromProvides(StrConfirmBookingBlueprintsModule.provideLinkItemPresenter$short_term_rent_release());
    }

    @Override // javax.inject.Provider
    public LinkItemPresenter get() {
        return provideLinkItemPresenter$short_term_rent_release();
    }
}
