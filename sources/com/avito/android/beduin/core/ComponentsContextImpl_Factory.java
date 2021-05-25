package com.avito.android.beduin.core;

import com.avito.android.beduin.core.form.ComponentsForm;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ComponentsContextImpl_Factory implements Factory<ComponentsContextImpl> {
    public final Provider<ComponentsForm> a;

    public ComponentsContextImpl_Factory(Provider<ComponentsForm> provider) {
        this.a = provider;
    }

    public static ComponentsContextImpl_Factory create(Provider<ComponentsForm> provider) {
        return new ComponentsContextImpl_Factory(provider);
    }

    public static ComponentsContextImpl newInstance(ComponentsForm componentsForm) {
        return new ComponentsContextImpl(componentsForm);
    }

    @Override // javax.inject.Provider
    public ComponentsContextImpl get() {
        return newInstance(this.a.get());
    }
}
