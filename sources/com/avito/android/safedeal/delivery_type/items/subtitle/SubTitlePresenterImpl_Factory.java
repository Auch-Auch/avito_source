package com.avito.android.safedeal.delivery_type.items.subtitle;

import android.content.Context;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SubTitlePresenterImpl_Factory implements Factory<SubTitlePresenterImpl> {
    public final Provider<Context> a;
    public final Provider<AttributedTextFormatter> b;

    public SubTitlePresenterImpl_Factory(Provider<Context> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SubTitlePresenterImpl_Factory create(Provider<Context> provider, Provider<AttributedTextFormatter> provider2) {
        return new SubTitlePresenterImpl_Factory(provider, provider2);
    }

    public static SubTitlePresenterImpl newInstance(Context context, AttributedTextFormatter attributedTextFormatter) {
        return new SubTitlePresenterImpl(context, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public SubTitlePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
