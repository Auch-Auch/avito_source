package com.avito.android.vas_discount.di;

import com.avito.android.component.user_advert.UserAdvertItemClickListener;
import com.avito.android.component.user_advert.UserAdvertItemPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PickerModule_ProvideUserAdvertPresenterFactory implements Factory<UserAdvertItemPresenter> {
    public final PickerModule a;
    public final Provider<UserAdvertItemClickListener> b;

    public PickerModule_ProvideUserAdvertPresenterFactory(PickerModule pickerModule, Provider<UserAdvertItemClickListener> provider) {
        this.a = pickerModule;
        this.b = provider;
    }

    public static PickerModule_ProvideUserAdvertPresenterFactory create(PickerModule pickerModule, Provider<UserAdvertItemClickListener> provider) {
        return new PickerModule_ProvideUserAdvertPresenterFactory(pickerModule, provider);
    }

    public static UserAdvertItemPresenter provideUserAdvertPresenter(PickerModule pickerModule, Lazy<UserAdvertItemClickListener> lazy) {
        return (UserAdvertItemPresenter) Preconditions.checkNotNullFromProvides(pickerModule.provideUserAdvertPresenter(lazy));
    }

    @Override // javax.inject.Provider
    public UserAdvertItemPresenter get() {
        return provideUserAdvertPresenter(this.a, DoubleCheck.lazy(this.b));
    }
}
