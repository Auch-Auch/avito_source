package com.avito.android.blueprints.range;

import com.avito.android.items.RangeItem;
import com.avito.android.util.text.AttributedTextFormatter;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RangePresenterImpl_Factory implements Factory<RangePresenterImpl> {
    public final Provider<AttributedTextFormatter> a;
    public final Provider<PublishRelay<RangeItem>> b;

    public RangePresenterImpl_Factory(Provider<AttributedTextFormatter> provider, Provider<PublishRelay<RangeItem>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static RangePresenterImpl_Factory create(Provider<AttributedTextFormatter> provider, Provider<PublishRelay<RangeItem>> provider2) {
        return new RangePresenterImpl_Factory(provider, provider2);
    }

    public static RangePresenterImpl newInstance(AttributedTextFormatter attributedTextFormatter, PublishRelay<RangeItem> publishRelay) {
        return new RangePresenterImpl(attributedTextFormatter, publishRelay);
    }

    @Override // javax.inject.Provider
    public RangePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
