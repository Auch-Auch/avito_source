package com.avito.android.basket_legacy.di.fees;

import android.content.res.Resources;
import com.avito.android.util.ErrorFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FeesBasketModule_ProvideErrorFormatterFactory implements Factory<ErrorFormatter> {
    public final FeesBasketModule a;
    public final Provider<Resources> b;

    public FeesBasketModule_ProvideErrorFormatterFactory(FeesBasketModule feesBasketModule, Provider<Resources> provider) {
        this.a = feesBasketModule;
        this.b = provider;
    }

    public static FeesBasketModule_ProvideErrorFormatterFactory create(FeesBasketModule feesBasketModule, Provider<Resources> provider) {
        return new FeesBasketModule_ProvideErrorFormatterFactory(feesBasketModule, provider);
    }

    public static ErrorFormatter provideErrorFormatter(FeesBasketModule feesBasketModule, Resources resources) {
        return (ErrorFormatter) Preconditions.checkNotNullFromProvides(feesBasketModule.provideErrorFormatter(resources));
    }

    @Override // javax.inject.Provider
    public ErrorFormatter get() {
        return provideErrorFormatter(this.a, this.b.get());
    }
}
