package com.avito.android.payment.di.module;

import android.text.TextWatcher;
import com.avito.android.blueprints.InputItemPresenter;
import com.avito.android.blueprints.publish.PrimaryParametersListener;
import com.avito.android.provider.InputItemFormatterProvider;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentGenericFormModule_ProvideInputItemPresenterFactory implements Factory<InputItemPresenter> {
    public final PaymentGenericFormModule a;
    public final Provider<PrimaryParametersListener> b;
    public final Provider<TextWatcher> c;
    public final Provider<InputItemFormatterProvider> d;

    public PaymentGenericFormModule_ProvideInputItemPresenterFactory(PaymentGenericFormModule paymentGenericFormModule, Provider<PrimaryParametersListener> provider, Provider<TextWatcher> provider2, Provider<InputItemFormatterProvider> provider3) {
        this.a = paymentGenericFormModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static PaymentGenericFormModule_ProvideInputItemPresenterFactory create(PaymentGenericFormModule paymentGenericFormModule, Provider<PrimaryParametersListener> provider, Provider<TextWatcher> provider2, Provider<InputItemFormatterProvider> provider3) {
        return new PaymentGenericFormModule_ProvideInputItemPresenterFactory(paymentGenericFormModule, provider, provider2, provider3);
    }

    public static InputItemPresenter provideInputItemPresenter(PaymentGenericFormModule paymentGenericFormModule, Lazy<PrimaryParametersListener> lazy, TextWatcher textWatcher, InputItemFormatterProvider inputItemFormatterProvider) {
        return (InputItemPresenter) Preconditions.checkNotNullFromProvides(paymentGenericFormModule.provideInputItemPresenter(lazy, textWatcher, inputItemFormatterProvider));
    }

    @Override // javax.inject.Provider
    public InputItemPresenter get() {
        return provideInputItemPresenter(this.a, DoubleCheck.lazy(this.b), this.c.get(), this.d.get());
    }
}
