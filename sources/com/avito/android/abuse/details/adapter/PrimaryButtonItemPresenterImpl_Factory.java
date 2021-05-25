package com.avito.android.abuse.details.adapter;

import com.avito.android.deep_linking.links.DeepLink;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class PrimaryButtonItemPresenterImpl_Factory implements Factory<PrimaryButtonItemPresenterImpl> {
    public final Provider<Consumer<DeepLink>> a;

    public PrimaryButtonItemPresenterImpl_Factory(Provider<Consumer<DeepLink>> provider) {
        this.a = provider;
    }

    public static PrimaryButtonItemPresenterImpl_Factory create(Provider<Consumer<DeepLink>> provider) {
        return new PrimaryButtonItemPresenterImpl_Factory(provider);
    }

    public static PrimaryButtonItemPresenterImpl newInstance(Consumer<DeepLink> consumer) {
        return new PrimaryButtonItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public PrimaryButtonItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
