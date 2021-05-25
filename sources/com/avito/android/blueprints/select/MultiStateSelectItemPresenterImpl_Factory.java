package com.avito.android.blueprints.select;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MultiStateSelectItemPresenterImpl_Factory implements Factory<MultiStateSelectItemPresenterImpl> {
    public final Provider<AttributedTextFormatter> a;

    public MultiStateSelectItemPresenterImpl_Factory(Provider<AttributedTextFormatter> provider) {
        this.a = provider;
    }

    public static MultiStateSelectItemPresenterImpl_Factory create(Provider<AttributedTextFormatter> provider) {
        return new MultiStateSelectItemPresenterImpl_Factory(provider);
    }

    public static MultiStateSelectItemPresenterImpl newInstance(AttributedTextFormatter attributedTextFormatter) {
        return new MultiStateSelectItemPresenterImpl(attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public MultiStateSelectItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
