package com.avito.android.abuse.details.adapter;

import com.avito.android.deep_linking.links.DeepLink;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class SecondaryButtonItemPresenterImpl_Factory implements Factory<SecondaryButtonItemPresenterImpl> {
    public final Provider<Consumer<DeepLink>> a;

    public SecondaryButtonItemPresenterImpl_Factory(Provider<Consumer<DeepLink>> provider) {
        this.a = provider;
    }

    public static SecondaryButtonItemPresenterImpl_Factory create(Provider<Consumer<DeepLink>> provider) {
        return new SecondaryButtonItemPresenterImpl_Factory(provider);
    }

    public static SecondaryButtonItemPresenterImpl newInstance(Consumer<DeepLink> consumer) {
        return new SecondaryButtonItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public SecondaryButtonItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
