package com.avito.android.blueprints.range.cre_range;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CreRangePresenterImpl_Factory implements Factory<CreRangePresenterImpl> {
    public final Provider<AttributedTextFormatter> a;

    public CreRangePresenterImpl_Factory(Provider<AttributedTextFormatter> provider) {
        this.a = provider;
    }

    public static CreRangePresenterImpl_Factory create(Provider<AttributedTextFormatter> provider) {
        return new CreRangePresenterImpl_Factory(provider);
    }

    public static CreRangePresenterImpl newInstance(AttributedTextFormatter attributedTextFormatter) {
        return new CreRangePresenterImpl(attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public CreRangePresenterImpl get() {
        return newInstance(this.a.get());
    }
}
