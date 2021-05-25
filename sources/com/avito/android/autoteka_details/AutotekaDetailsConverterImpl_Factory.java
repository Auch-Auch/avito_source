package com.avito.android.autoteka_details;

import android.content.res.Resources;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutotekaDetailsConverterImpl_Factory implements Factory<AutotekaDetailsConverterImpl> {
    public final Provider<Resources> a;
    public final Provider<AttributedTextFormatter> b;

    public AutotekaDetailsConverterImpl_Factory(Provider<Resources> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AutotekaDetailsConverterImpl_Factory create(Provider<Resources> provider, Provider<AttributedTextFormatter> provider2) {
        return new AutotekaDetailsConverterImpl_Factory(provider, provider2);
    }

    public static AutotekaDetailsConverterImpl newInstance(Resources resources, AttributedTextFormatter attributedTextFormatter) {
        return new AutotekaDetailsConverterImpl(resources, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public AutotekaDetailsConverterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
