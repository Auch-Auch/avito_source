package com.avito.android.advert.item.safedeal.label;

import android.content.Context;
import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSafeDealLabelPresenterImpl_Factory implements Factory<AdvertDetailsSafeDealLabelPresenterImpl> {
    public final Provider<Context> a;
    public final Provider<AdvertSafeDealPresenter> b;
    public final Provider<AttributedTextFormatter> c;

    public AdvertDetailsSafeDealLabelPresenterImpl_Factory(Provider<Context> provider, Provider<AdvertSafeDealPresenter> provider2, Provider<AttributedTextFormatter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertDetailsSafeDealLabelPresenterImpl_Factory create(Provider<Context> provider, Provider<AdvertSafeDealPresenter> provider2, Provider<AttributedTextFormatter> provider3) {
        return new AdvertDetailsSafeDealLabelPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static AdvertDetailsSafeDealLabelPresenterImpl newInstance(Context context, AdvertSafeDealPresenter advertSafeDealPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new AdvertDetailsSafeDealLabelPresenterImpl(context, advertSafeDealPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSafeDealLabelPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
