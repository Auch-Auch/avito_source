package com.avito.android.safedeal.delivery_type.items.title;

import android.content.Context;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TitlePresenterImpl_Factory implements Factory<TitlePresenterImpl> {
    public final Provider<Context> a;
    public final Provider<AttributedTextFormatter> b;

    public TitlePresenterImpl_Factory(Provider<Context> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TitlePresenterImpl_Factory create(Provider<Context> provider, Provider<AttributedTextFormatter> provider2) {
        return new TitlePresenterImpl_Factory(provider, provider2);
    }

    public static TitlePresenterImpl newInstance(Context context, AttributedTextFormatter attributedTextFormatter) {
        return new TitlePresenterImpl(context, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public TitlePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
