package com.avito.android.publish.view;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ItemDetailsParameterClickListenerImpl_Factory implements Factory<ItemDetailsParameterClickListenerImpl> {
    public final Provider<BasicParameterClickListener> a;

    public ItemDetailsParameterClickListenerImpl_Factory(Provider<BasicParameterClickListener> provider) {
        this.a = provider;
    }

    public static ItemDetailsParameterClickListenerImpl_Factory create(Provider<BasicParameterClickListener> provider) {
        return new ItemDetailsParameterClickListenerImpl_Factory(provider);
    }

    public static ItemDetailsParameterClickListenerImpl newInstance(BasicParameterClickListener basicParameterClickListener) {
        return new ItemDetailsParameterClickListenerImpl(basicParameterClickListener);
    }

    @Override // javax.inject.Provider
    public ItemDetailsParameterClickListenerImpl get() {
        return newInstance(this.a.get());
    }
}
