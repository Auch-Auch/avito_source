package com.avito.android.publish.view;

import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.item_legacy.details.SelectParameterClickListener;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BasicParameterClickListenerImpl_Factory implements Factory<BasicParameterClickListenerImpl> {
    public final Provider<LocationParameterClickListener> a;
    public final Provider<SelectParameterClickListener> b;
    public final Provider<DeepLinkFactory> c;

    public BasicParameterClickListenerImpl_Factory(Provider<LocationParameterClickListener> provider, Provider<SelectParameterClickListener> provider2, Provider<DeepLinkFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static BasicParameterClickListenerImpl_Factory create(Provider<LocationParameterClickListener> provider, Provider<SelectParameterClickListener> provider2, Provider<DeepLinkFactory> provider3) {
        return new BasicParameterClickListenerImpl_Factory(provider, provider2, provider3);
    }

    public static BasicParameterClickListenerImpl newInstance(LocationParameterClickListener locationParameterClickListener, SelectParameterClickListener selectParameterClickListener, DeepLinkFactory deepLinkFactory) {
        return new BasicParameterClickListenerImpl(locationParameterClickListener, selectParameterClickListener, deepLinkFactory);
    }

    @Override // javax.inject.Provider
    public BasicParameterClickListenerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
