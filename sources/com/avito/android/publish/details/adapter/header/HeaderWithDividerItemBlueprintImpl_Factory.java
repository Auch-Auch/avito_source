package com.avito.android.publish.details.adapter.header;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class HeaderWithDividerItemBlueprintImpl_Factory implements Factory<HeaderWithDividerItemBlueprintImpl> {
    public final Provider<HeaderWithDividerItemPresenter> a;

    public HeaderWithDividerItemBlueprintImpl_Factory(Provider<HeaderWithDividerItemPresenter> provider) {
        this.a = provider;
    }

    public static HeaderWithDividerItemBlueprintImpl_Factory create(Provider<HeaderWithDividerItemPresenter> provider) {
        return new HeaderWithDividerItemBlueprintImpl_Factory(provider);
    }

    public static HeaderWithDividerItemBlueprintImpl newInstance(HeaderWithDividerItemPresenter headerWithDividerItemPresenter) {
        return new HeaderWithDividerItemBlueprintImpl(headerWithDividerItemPresenter);
    }

    @Override // javax.inject.Provider
    public HeaderWithDividerItemBlueprintImpl get() {
        return newInstance(this.a.get());
    }
}
