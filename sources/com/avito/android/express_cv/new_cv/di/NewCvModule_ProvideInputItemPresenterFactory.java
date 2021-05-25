package com.avito.android.express_cv.new_cv.di;

import android.text.TextWatcher;
import com.avito.android.blueprints.InputItemPresenter;
import com.avito.android.blueprints.publish.PrimaryParametersListener;
import com.avito.android.provider.InputItemFormatterProvider;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NewCvModule_ProvideInputItemPresenterFactory implements Factory<InputItemPresenter> {
    public final NewCvModule a;
    public final Provider<PrimaryParametersListener> b;
    public final Provider<TextWatcher> c;
    public final Provider<InputItemFormatterProvider> d;

    public NewCvModule_ProvideInputItemPresenterFactory(NewCvModule newCvModule, Provider<PrimaryParametersListener> provider, Provider<TextWatcher> provider2, Provider<InputItemFormatterProvider> provider3) {
        this.a = newCvModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static NewCvModule_ProvideInputItemPresenterFactory create(NewCvModule newCvModule, Provider<PrimaryParametersListener> provider, Provider<TextWatcher> provider2, Provider<InputItemFormatterProvider> provider3) {
        return new NewCvModule_ProvideInputItemPresenterFactory(newCvModule, provider, provider2, provider3);
    }

    public static InputItemPresenter provideInputItemPresenter(NewCvModule newCvModule, Lazy<PrimaryParametersListener> lazy, TextWatcher textWatcher, InputItemFormatterProvider inputItemFormatterProvider) {
        return (InputItemPresenter) Preconditions.checkNotNullFromProvides(newCvModule.provideInputItemPresenter(lazy, textWatcher, inputItemFormatterProvider));
    }

    @Override // javax.inject.Provider
    public InputItemPresenter get() {
        return provideInputItemPresenter(this.a, DoubleCheck.lazy(this.b), this.c.get(), this.d.get());
    }
}
