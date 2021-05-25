package com.avito.android.rating.publish.radio_select.adapter.radio_select;

import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class RadioSelectItemPresenterImpl_Factory implements Factory<RadioSelectItemPresenterImpl> {
    public final Provider<Consumer<RadioSelectItem>> a;

    public RadioSelectItemPresenterImpl_Factory(Provider<Consumer<RadioSelectItem>> provider) {
        this.a = provider;
    }

    public static RadioSelectItemPresenterImpl_Factory create(Provider<Consumer<RadioSelectItem>> provider) {
        return new RadioSelectItemPresenterImpl_Factory(provider);
    }

    public static RadioSelectItemPresenterImpl newInstance(Consumer<RadioSelectItem> consumer) {
        return new RadioSelectItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public RadioSelectItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
