package com.avito.android.beduin.di;

import androidx.fragment.app.Fragment;
import com.avito.android.beduin.BeduinApi;
import com.avito.android.beduin.common.BeduinInteractor;
import com.avito.android.beduin.core.ComponentsContext;
import com.avito.android.beduin.core.ComponentsContextImpl;
import com.avito.android.beduin.core.ComponentsContextImpl_Factory;
import com.avito.android.beduin.core.form.ComponentsForm;
import com.avito.android.beduin.core.form.ComponentsFormImpl_Factory;
import com.avito.android.beduin.core.registry.BeduinRegistry;
import com.avito.android.beduin.di.BeduinFragmentComponent;
import com.avito.android.beduin.ui.adapter.BeduinAdapter;
import com.avito.android.beduin.ui.fragment.BeduinFragment;
import com.avito.android.beduin.ui.fragment.BeduinFragment_MembersInjector;
import com.avito.android.beduin.ui.viewmodel.BeduinViewModelFactory;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import javax.inject.Provider;
public final class DaggerBeduinFragmentComponent implements BeduinFragmentComponent {
    public final Fragment a;
    public final BeduinDependencies b;
    public final String c;
    public Provider<ComponentsForm> d;
    public Provider<ComponentsContextImpl> e;
    public Provider<ComponentsContext> f;

    public static final class b implements BeduinFragmentComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.beduin.di.BeduinFragmentComponent.Factory
        public BeduinFragmentComponent create(Fragment fragment, String str, BeduinDependencies beduinDependencies) {
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(beduinDependencies);
            return new DaggerBeduinFragmentComponent(beduinDependencies, fragment, str, null);
        }
    }

    public DaggerBeduinFragmentComponent(BeduinDependencies beduinDependencies, Fragment fragment, String str, a aVar) {
        this.a = fragment;
        this.b = beduinDependencies;
        this.c = str;
        Provider<ComponentsForm> provider = DoubleCheck.provider(ComponentsFormImpl_Factory.create());
        this.d = provider;
        ComponentsContextImpl_Factory create = ComponentsContextImpl_Factory.create(provider);
        this.e = create;
        this.f = DoubleCheck.provider(create);
    }

    public static BeduinFragmentComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.beduin.di.BeduinFragmentComponent
    public void inject(BeduinFragment beduinFragment) {
        BeduinFragment_MembersInjector.injectBeduinViewModel(beduinFragment, BeduinFragmentModule_ProvideViewModel$beduin_releaseFactory.provideViewModel$beduin_release(this.a, new BeduinViewModelFactory((BeduinRegistry) Preconditions.checkNotNullFromComponent(this.b.beduinRegistry()), new BeduinInteractor((BeduinApi) Preconditions.checkNotNullFromComponent(this.b.beduinApi()), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.b.schedulersFactory3())), SetBuilder.newSetBuilder(2).add(BeduinActionHandlerModule_ProvideOpenLinkActionHandlerFactory.provideOpenLinkActionHandler((DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.b.deepLinkIntentFactory()), (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.b.deepLinkFactory()), this.a)).add(BeduinActionHandlerModule_ProvideOpenDeeplinkActionHandlerFactory.provideOpenDeeplinkActionHandler((DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.b.deepLinkIntentFactory()), this.a)).build(), this.c, this.d.get(), this.f.get())));
        BeduinFragment_MembersInjector.injectBeduinAdapter(beduinFragment, new BeduinAdapter(this.f.get()));
    }
}
