package com.avito.android.short_term_rent.di.module;

import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountClickListener;
import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountItemPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StrStartBookingModule_ProvideGuestCountItemPresenterFactory implements Factory<GuestsCountItemPresenter> {
    public final Provider<GuestsCountClickListener> a;

    public StrStartBookingModule_ProvideGuestCountItemPresenterFactory(Provider<GuestsCountClickListener> provider) {
        this.a = provider;
    }

    public static StrStartBookingModule_ProvideGuestCountItemPresenterFactory create(Provider<GuestsCountClickListener> provider) {
        return new StrStartBookingModule_ProvideGuestCountItemPresenterFactory(provider);
    }

    public static GuestsCountItemPresenter provideGuestCountItemPresenter(Lazy<GuestsCountClickListener> lazy) {
        return (GuestsCountItemPresenter) Preconditions.checkNotNullFromProvides(StrStartBookingModule.provideGuestCountItemPresenter(lazy));
    }

    @Override // javax.inject.Provider
    public GuestsCountItemPresenter get() {
        return provideGuestCountItemPresenter(DoubleCheck.lazy(this.a));
    }
}
