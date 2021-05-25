package com.avito.android.beduin.ui.adapter;

import com.avito.android.beduin.core.ComponentsContext;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BeduinAdapter_Factory implements Factory<BeduinAdapter> {
    public final Provider<ComponentsContext> a;

    public BeduinAdapter_Factory(Provider<ComponentsContext> provider) {
        this.a = provider;
    }

    public static BeduinAdapter_Factory create(Provider<ComponentsContext> provider) {
        return new BeduinAdapter_Factory(provider);
    }

    public static BeduinAdapter newInstance(ComponentsContext componentsContext) {
        return new BeduinAdapter(componentsContext);
    }

    @Override // javax.inject.Provider
    public BeduinAdapter get() {
        return newInstance(this.a.get());
    }
}
