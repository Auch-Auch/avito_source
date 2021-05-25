package com.avito.android.profile.cards.tfa;

import com.avito.android.profile.cards.CardItem;
import dagger.internal.Factory;
import io.reactivex.functions.Consumer;
import javax.inject.Provider;
public final class TfaSettingsItemPresenterImpl_Factory implements Factory<TfaSettingsItemPresenterImpl> {
    public final Provider<Consumer<CardItem.TfaSettingsCardItem>> a;

    public TfaSettingsItemPresenterImpl_Factory(Provider<Consumer<CardItem.TfaSettingsCardItem>> provider) {
        this.a = provider;
    }

    public static TfaSettingsItemPresenterImpl_Factory create(Provider<Consumer<CardItem.TfaSettingsCardItem>> provider) {
        return new TfaSettingsItemPresenterImpl_Factory(provider);
    }

    public static TfaSettingsItemPresenterImpl newInstance(Consumer<CardItem.TfaSettingsCardItem> consumer) {
        return new TfaSettingsItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public TfaSettingsItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
