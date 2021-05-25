package com.avito.android.short_term_rent.di.module;

import android.text.TextWatcher;
import com.avito.android.blueprints.InputItemPresenter;
import com.avito.android.provider.InputItemFormatterProvider;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StrConfirmBookingBlueprintsModule_ProvideInputItemPresenterFactory implements Factory<InputItemPresenter> {
    public final Provider<StrConfirmBookingViewModel> a;
    public final Provider<TextWatcher> b;
    public final Provider<InputItemFormatterProvider> c;

    public StrConfirmBookingBlueprintsModule_ProvideInputItemPresenterFactory(Provider<StrConfirmBookingViewModel> provider, Provider<TextWatcher> provider2, Provider<InputItemFormatterProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static StrConfirmBookingBlueprintsModule_ProvideInputItemPresenterFactory create(Provider<StrConfirmBookingViewModel> provider, Provider<TextWatcher> provider2, Provider<InputItemFormatterProvider> provider3) {
        return new StrConfirmBookingBlueprintsModule_ProvideInputItemPresenterFactory(provider, provider2, provider3);
    }

    public static InputItemPresenter provideInputItemPresenter(Lazy<StrConfirmBookingViewModel> lazy, TextWatcher textWatcher, InputItemFormatterProvider inputItemFormatterProvider) {
        return (InputItemPresenter) Preconditions.checkNotNullFromProvides(StrConfirmBookingBlueprintsModule.provideInputItemPresenter(lazy, textWatcher, inputItemFormatterProvider));
    }

    @Override // javax.inject.Provider
    public InputItemPresenter get() {
        return provideInputItemPresenter(DoubleCheck.lazy(this.a), this.b.get(), this.c.get());
    }
}
