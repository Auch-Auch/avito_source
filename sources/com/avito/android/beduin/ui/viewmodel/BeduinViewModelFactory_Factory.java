package com.avito.android.beduin.ui.viewmodel;

import com.avito.android.beduin.common.BeduinInteractor;
import com.avito.android.beduin.core.ComponentsContext;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.beduin.core.form.ComponentsForm;
import com.avito.android.beduin.core.registry.BeduinRegistry;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
public final class BeduinViewModelFactory_Factory implements Factory<BeduinViewModelFactory> {
    public final Provider<BeduinRegistry> a;
    public final Provider<BeduinInteractor> b;
    public final Provider<Set<BeduinActionHandler>> c;
    public final Provider<String> d;
    public final Provider<ComponentsForm> e;
    public final Provider<ComponentsContext> f;

    public BeduinViewModelFactory_Factory(Provider<BeduinRegistry> provider, Provider<BeduinInteractor> provider2, Provider<Set<BeduinActionHandler>> provider3, Provider<String> provider4, Provider<ComponentsForm> provider5, Provider<ComponentsContext> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static BeduinViewModelFactory_Factory create(Provider<BeduinRegistry> provider, Provider<BeduinInteractor> provider2, Provider<Set<BeduinActionHandler>> provider3, Provider<String> provider4, Provider<ComponentsForm> provider5, Provider<ComponentsContext> provider6) {
        return new BeduinViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static BeduinViewModelFactory newInstance(BeduinRegistry beduinRegistry, BeduinInteractor beduinInteractor, Set<BeduinActionHandler> set, String str, ComponentsForm componentsForm, ComponentsContext componentsContext) {
        return new BeduinViewModelFactory(beduinRegistry, beduinInteractor, set, str, componentsForm, componentsContext);
    }

    @Override // javax.inject.Provider
    public BeduinViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
