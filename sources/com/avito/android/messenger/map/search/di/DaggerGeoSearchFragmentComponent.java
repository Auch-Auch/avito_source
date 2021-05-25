package com.avito.android.messenger.map.search.di;

import androidx.lifecycle.ViewModel;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory_Factory;
import com.avito.android.messenger.map.search.GeoSearchFragment;
import com.avito.android.messenger.map.search.GeoSearchFragment_MembersInjector;
import com.avito.android.messenger.map.search.GeoSearchInteractor;
import com.avito.android.messenger.map.search.GeoSearchInteractorImpl;
import com.avito.android.messenger.map.search.GeoSearchInteractorImpl_Factory;
import com.avito.android.messenger.map.search.GeoSearchPresenter;
import com.avito.android.messenger.map.search.GeoSearchPresenterImpl;
import com.avito.android.messenger.map.search.GeoSearchPresenterImpl_Factory;
import com.avito.android.messenger.map.search.di.GeoSearchFragmentComponent;
import com.avito.android.remote.model.messenger.geo.GeoPoint;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import dagger.internal.DelegateFactory;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Map;
import javax.inject.Provider;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class DaggerGeoSearchFragmentComponent implements GeoSearchFragmentComponent {
    public final GeoSearchFragment a;
    public Provider<AccountStateProvider> b;
    public Provider<String> c;
    public Provider<GeoPoint> d;
    public Provider<GeoPoint> e;
    public Provider<MessengerClient<AvitoMessengerApi>> f;
    public Provider<SchedulersFactory> g;
    public Provider<GeoSearchInteractorImpl> h;
    public Provider<GeoSearchFragment> i;
    public Provider<ViewModelFactory> j;
    public Provider<GeoSearchInteractor> k;
    public Provider<String> l;
    public Provider<String> m;
    public Provider<Analytics> n;
    public Provider<GeoSearchPresenter.State> o;
    public Provider<GeoSearchPresenterImpl> p;
    public Provider<Map<Class<?>, Provider<ViewModel>>> q;

    public static final class b implements GeoSearchFragmentComponent.Builder {
        public GeoSearchFragment a;
        public String b;
        public GeoPoint c;
        public GeoPoint d;
        public String e;
        public String f;
        public GeoSearchPresenter.State g;
        public GeoSearchFragmentDependencies h;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.map.search.di.GeoSearchFragmentComponent.Builder
        public GeoSearchFragmentComponent.Builder bindCenterPoint(GeoPoint geoPoint) {
            this.c = geoPoint;
            return this;
        }

        @Override // com.avito.android.messenger.map.search.di.GeoSearchFragmentComponent.Builder
        public GeoSearchFragmentComponent.Builder bindChannelId(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.messenger.map.search.di.GeoSearchFragmentComponent.Builder
        public GeoSearchFragmentComponent.Builder bindDefaultState(GeoSearchPresenter.State state) {
            this.g = (GeoSearchPresenter.State) Preconditions.checkNotNull(state);
            return this;
        }

        @Override // com.avito.android.messenger.map.search.di.GeoSearchFragmentComponent.Builder
        public GeoSearchFragmentComponent.Builder bindErrorIndicatorActionName(String str) {
            this.f = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.messenger.map.search.di.GeoSearchFragmentComponent.Builder
        public GeoSearchFragmentComponent.Builder bindErrorIndicatorMessage(String str) {
            this.e = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.messenger.map.search.di.GeoSearchFragmentComponent.Builder
        public GeoSearchFragmentComponent.Builder bindFragment(GeoSearchFragment geoSearchFragment) {
            this.a = (GeoSearchFragment) Preconditions.checkNotNull(geoSearchFragment);
            return this;
        }

        @Override // com.avito.android.messenger.map.search.di.GeoSearchFragmentComponent.Builder
        public GeoSearchFragmentComponent.Builder bindItemLocation(GeoPoint geoPoint) {
            this.d = geoPoint;
            return this;
        }

        @Override // com.avito.android.messenger.map.search.di.GeoSearchFragmentComponent.Builder
        public GeoSearchFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, GeoSearchFragment.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.e, String.class);
            Preconditions.checkBuilderRequirement(this.f, String.class);
            Preconditions.checkBuilderRequirement(this.g, GeoSearchPresenter.State.class);
            Preconditions.checkBuilderRequirement(this.h, GeoSearchFragmentDependencies.class);
            return new DaggerGeoSearchFragmentComponent(this.h, this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
        }

        @Override // com.avito.android.messenger.map.search.di.GeoSearchFragmentComponent.Builder
        public GeoSearchFragmentComponent.Builder dependencies(GeoSearchFragmentDependencies geoSearchFragmentDependencies) {
            this.h = (GeoSearchFragmentDependencies) Preconditions.checkNotNull(geoSearchFragmentDependencies);
            return this;
        }

        @Override // com.avito.android.messenger.map.search.di.GeoSearchFragmentComponent.Builder
        @Deprecated
        public GeoSearchFragmentComponent.Builder module(GeoSearchFragmentModule geoSearchFragmentModule) {
            Preconditions.checkNotNull(geoSearchFragmentModule);
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final GeoSearchFragmentDependencies a;

        public c(GeoSearchFragmentDependencies geoSearchFragmentDependencies) {
            this.a = geoSearchFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final GeoSearchFragmentDependencies a;

        public d(GeoSearchFragmentDependencies geoSearchFragmentDependencies) {
            this.a = geoSearchFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<MessengerClient<AvitoMessengerApi>> {
        public final GeoSearchFragmentDependencies a;

        public e(GeoSearchFragmentDependencies geoSearchFragmentDependencies) {
            this.a = geoSearchFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MessengerClient<AvitoMessengerApi> get() {
            return (MessengerClient) Preconditions.checkNotNullFromComponent(this.a.messengerClient());
        }
    }

    public static class f implements Provider<SchedulersFactory> {
        public final GeoSearchFragmentDependencies a;

        public f(GeoSearchFragmentDependencies geoSearchFragmentDependencies) {
            this.a = geoSearchFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerGeoSearchFragmentComponent(GeoSearchFragmentDependencies geoSearchFragmentDependencies, GeoSearchFragment geoSearchFragment, String str, GeoPoint geoPoint, GeoPoint geoPoint2, String str2, String str3, GeoSearchPresenter.State state, a aVar) {
        this.a = geoSearchFragment;
        this.b = new c(geoSearchFragmentDependencies);
        this.c = InstanceFactory.create(str);
        this.d = InstanceFactory.createNullable(geoPoint2);
        Factory createNullable = InstanceFactory.createNullable(geoPoint);
        this.e = createNullable;
        e eVar = new e(geoSearchFragmentDependencies);
        this.f = eVar;
        f fVar = new f(geoSearchFragmentDependencies);
        this.g = fVar;
        this.h = GeoSearchInteractorImpl_Factory.create(this.b, this.c, this.d, createNullable, eVar, fVar);
        this.i = InstanceFactory.create(geoSearchFragment);
        DelegateFactory delegateFactory = new DelegateFactory();
        this.j = delegateFactory;
        this.k = GeoSearchFragmentModule_ProvideGeoSearchInteractorFactory.create(this.i, delegateFactory);
        this.l = InstanceFactory.create(str2);
        this.m = InstanceFactory.create(str3);
        this.n = new d(geoSearchFragmentDependencies);
        Factory create = InstanceFactory.create(state);
        this.o = create;
        this.p = GeoSearchPresenterImpl_Factory.create(this.g, this.k, this.l, this.m, this.n, this.c, create, this.f);
        MapProviderFactory build = MapProviderFactory.builder(2).put((MapProviderFactory.Builder) GeoSearchInteractorImpl.class, (Provider) this.h).put((MapProviderFactory.Builder) GeoSearchPresenterImpl.class, (Provider) this.p).build();
        this.q = build;
        DelegateFactory.setDelegate(this.j, SingleCheck.provider(ViewModelFactory_Factory.create(build)));
    }

    public static GeoSearchFragmentComponent.Builder builder() {
        return new b(null);
    }

    public final ItemBinder a() {
        return GeoSearchFragmentModule_ProvideItemBinderFactory.provideItemBinder(GeoSearchFragmentModule_ProvideGeoSearchSuggestItemBlueprintFactory.provideGeoSearchSuggestItemBlueprint(GeoSearchFragmentModule_ProvideGeoSearchSuggestItemPresenterFactory.provideGeoSearchSuggestItemPresenter(GeoSearchFragmentModule_ProvideGeoSearchPresenterFactory.provideGeoSearchPresenter(this.a, this.j.get()))));
    }

    @Override // com.avito.android.messenger.map.search.di.GeoSearchFragmentComponent
    public void inject(GeoSearchFragment geoSearchFragment) {
        GeoSearchFragment_MembersInjector.injectPresenter(geoSearchFragment, GeoSearchFragmentModule_ProvideGeoSearchPresenterFactory.provideGeoSearchPresenter(this.a, this.j.get()));
        GeoSearchFragment_MembersInjector.injectAdapterPresenter(geoSearchFragment, GeoSearchFragmentModule_ProvideAdapterPresenterFactory.provideAdapterPresenter(a()));
        GeoSearchFragment_MembersInjector.injectItemBinder(geoSearchFragment, a());
    }
}
