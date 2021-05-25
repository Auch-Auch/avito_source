package com.avito.android.profile.sessions.list.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.profile.sessions.adapter.action.SessionsItemAction;
import com.avito.android.profile.sessions.adapter.error.SessionsErrorItemBlueprint;
import com.avito.android.profile.sessions.adapter.error.SessionsErrorItemBlueprint_Factory;
import com.avito.android.profile.sessions.adapter.error.SessionsErrorItemPresenter;
import com.avito.android.profile.sessions.adapter.error.SessionsErrorItemPresenterImpl;
import com.avito.android.profile.sessions.adapter.error.SessionsErrorItemPresenterImpl_Factory;
import com.avito.android.profile.sessions.adapter.header.SessionsHeaderItemBlueprint;
import com.avito.android.profile.sessions.adapter.header.SessionsHeaderItemBlueprint_Factory;
import com.avito.android.profile.sessions.adapter.header.SessionsHeaderItemPresenter;
import com.avito.android.profile.sessions.adapter.header.SessionsHeaderItemPresenterImpl_Factory;
import com.avito.android.profile.sessions.adapter.info.SessionsInfoItemBlueprint;
import com.avito.android.profile.sessions.adapter.info.SessionsInfoItemBlueprint_Factory;
import com.avito.android.profile.sessions.adapter.info.SessionsInfoItemPresenter;
import com.avito.android.profile.sessions.adapter.info.SessionsInfoItemPresenterImpl_Factory;
import com.avito.android.profile.sessions.adapter.loading.SessionsLoadingItemBlueprint;
import com.avito.android.profile.sessions.adapter.loading.SessionsLoadingItemBlueprint_Factory;
import com.avito.android.profile.sessions.adapter.loading.SessionsLoadingItemPresenter;
import com.avito.android.profile.sessions.adapter.loading.SessionsLoadingItemPresenterImpl;
import com.avito.android.profile.sessions.adapter.loading.SessionsLoadingItemPresenterImpl_Factory;
import com.avito.android.profile.sessions.adapter.session.SessionItemBlueprint;
import com.avito.android.profile.sessions.adapter.session.SessionItemBlueprint_Factory;
import com.avito.android.profile.sessions.adapter.session.SessionItemPresenter;
import com.avito.android.profile.sessions.adapter.session.SessionItemPresenterImpl;
import com.avito.android.profile.sessions.adapter.session.SessionItemPresenterImpl_Factory;
import com.avito.android.profile.sessions.list.SessionsListFragment;
import com.avito.android.profile.sessions.list.SessionsListFragment_MembersInjector;
import com.avito.android.profile.sessions.list.SessionsListInteractor;
import com.avito.android.profile.sessions.list.SessionsListInteractorImpl;
import com.avito.android.profile.sessions.list.SessionsListInteractorImpl_Factory;
import com.avito.android.profile.sessions.list.SessionsListPresenter;
import com.avito.android.profile.sessions.list.SessionsListPresenterImpl;
import com.avito.android.profile.sessions.list.SessionsListPresenterImpl_Factory;
import com.avito.android.profile.sessions.list.SessionsListResourceProviderImpl;
import com.avito.android.profile.sessions.list.SessionsListResourceProviderImpl_Factory;
import com.avito.android.profile.sessions.list.di.SessionsListComponent;
import com.avito.android.remote.SessionsApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerSessionsListComponent implements SessionsListComponent {
    public Provider<Set<ItemBlueprint<?, ?>>> A;
    public Provider<ItemBinder> B;
    public Provider<AdapterPresenter> C;
    public Provider<CompositeSnackbarPresenter> D;
    public Provider<Resources> E;
    public Provider<ErrorFormatterImpl> F;
    public Provider<ErrorFormatter> G;
    public Provider<ErrorHelperImpl> H;
    public Provider<ErrorHelper> I;
    public Provider<SessionsListResourceProviderImpl> J;
    public Provider<Kundle> K;
    public Provider<Analytics> L;
    public Provider<String> M;
    public Provider<SessionsListPresenterImpl> N;
    public Provider<SessionsListPresenter> O;
    public final SessionsListDependencies a;
    public Provider<SessionsApi> b;
    public Provider<TypedErrorThrowableConverter> c;
    public Provider<SchedulersFactory3> d;
    public Provider<SessionsListInteractorImpl> e;
    public Provider<SessionsListInteractor> f;
    public Provider<Set<ItemBlueprint<?, ?>>> g = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PublishRelay<SessionsItemAction>> h;
    public Provider<SessionItemPresenterImpl> i;
    public Provider<SessionItemPresenter> j;
    public Provider<SessionItemBlueprint> k;
    public Provider<ItemBlueprint<?, ?>> l;
    public Provider<SessionsHeaderItemPresenter> m;
    public Provider<SessionsHeaderItemBlueprint> n;
    public Provider<ItemBlueprint<?, ?>> o;
    public Provider<SessionsInfoItemPresenter> p;
    public Provider<SessionsInfoItemBlueprint> q;
    public Provider<ItemBlueprint<?, ?>> r;
    public Provider<SessionsLoadingItemPresenterImpl> s;
    public Provider<SessionsLoadingItemPresenter> t;
    public Provider<SessionsLoadingItemBlueprint> u;
    public Provider<ItemBlueprint<?, ?>> v;
    public Provider<SessionsErrorItemPresenterImpl> w;
    public Provider<SessionsErrorItemPresenter> x;
    public Provider<SessionsErrorItemBlueprint> y;
    public Provider<ItemBlueprint<?, ?>> z;

    public static final class b implements SessionsListComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.profile.sessions.list.di.SessionsListComponent.Factory
        public SessionsListComponent create(Resources resources, Kundle kundle, String str, SessionsListDependencies sessionsListDependencies) {
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(sessionsListDependencies);
            return new DaggerSessionsListComponent(sessionsListDependencies, resources, kundle, str, null);
        }
    }

    public static class c implements Provider<Analytics> {
        public final SessionsListDependencies a;

        public c(SessionsListDependencies sessionsListDependencies) {
            this.a = sessionsListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final SessionsListDependencies a;

        public d(SessionsListDependencies sessionsListDependencies) {
            this.a = sessionsListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class e implements Provider<SessionsApi> {
        public final SessionsListDependencies a;

        public e(SessionsListDependencies sessionsListDependencies) {
            this.a = sessionsListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SessionsApi get() {
            return (SessionsApi) Preconditions.checkNotNullFromComponent(this.a.sessionsApi());
        }
    }

    public static class f implements Provider<TypedErrorThrowableConverter> {
        public final SessionsListDependencies a;

        public f(SessionsListDependencies sessionsListDependencies) {
            this.a = sessionsListDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerSessionsListComponent(SessionsListDependencies sessionsListDependencies, Resources resources, Kundle kundle, String str, a aVar) {
        this.a = sessionsListDependencies;
        e eVar = new e(sessionsListDependencies);
        this.b = eVar;
        f fVar = new f(sessionsListDependencies);
        this.c = fVar;
        d dVar = new d(sessionsListDependencies);
        this.d = dVar;
        SessionsListInteractorImpl_Factory create = SessionsListInteractorImpl_Factory.create(eVar, fVar, dVar);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        Provider<PublishRelay<SessionsItemAction>> provider = DoubleCheck.provider(SessionsListModule_ProvideActionRelayFactory.create());
        this.h = provider;
        SessionItemPresenterImpl_Factory create2 = SessionItemPresenterImpl_Factory.create(provider);
        this.i = create2;
        Provider<SessionItemPresenter> provider2 = DoubleCheck.provider(create2);
        this.j = provider2;
        SessionItemBlueprint_Factory create3 = SessionItemBlueprint_Factory.create(provider2);
        this.k = create3;
        this.l = DoubleCheck.provider(create3);
        Provider<SessionsHeaderItemPresenter> provider3 = DoubleCheck.provider(SessionsHeaderItemPresenterImpl_Factory.create());
        this.m = provider3;
        SessionsHeaderItemBlueprint_Factory create4 = SessionsHeaderItemBlueprint_Factory.create(provider3);
        this.n = create4;
        this.o = DoubleCheck.provider(create4);
        Provider<SessionsInfoItemPresenter> provider4 = DoubleCheck.provider(SessionsInfoItemPresenterImpl_Factory.create());
        this.p = provider4;
        SessionsInfoItemBlueprint_Factory create5 = SessionsInfoItemBlueprint_Factory.create(provider4);
        this.q = create5;
        this.r = DoubleCheck.provider(create5);
        SessionsLoadingItemPresenterImpl_Factory create6 = SessionsLoadingItemPresenterImpl_Factory.create(this.h);
        this.s = create6;
        Provider<SessionsLoadingItemPresenter> provider5 = DoubleCheck.provider(create6);
        this.t = provider5;
        SessionsLoadingItemBlueprint_Factory create7 = SessionsLoadingItemBlueprint_Factory.create(provider5);
        this.u = create7;
        this.v = DoubleCheck.provider(create7);
        SessionsErrorItemPresenterImpl_Factory create8 = SessionsErrorItemPresenterImpl_Factory.create(this.h);
        this.w = create8;
        Provider<SessionsErrorItemPresenter> provider6 = DoubleCheck.provider(create8);
        this.x = provider6;
        SessionsErrorItemBlueprint_Factory create9 = SessionsErrorItemBlueprint_Factory.create(provider6);
        this.y = create9;
        this.z = DoubleCheck.provider(create9);
        SetFactory build = SetFactory.builder(5, 1).addCollectionProvider(this.g).addProvider(this.l).addProvider(this.o).addProvider(this.r).addProvider(this.v).addProvider(this.z).build();
        this.A = build;
        Provider<ItemBinder> provider7 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.B = provider7;
        this.C = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider7));
        this.D = SingleCheck.provider(CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory.create());
        Factory create10 = InstanceFactory.create(resources);
        this.E = create10;
        ErrorFormatterImpl_Factory create11 = ErrorFormatterImpl_Factory.create(create10);
        this.F = create11;
        Provider<ErrorFormatter> provider8 = SingleCheck.provider(create11);
        this.G = provider8;
        ErrorHelperImpl_Factory create12 = ErrorHelperImpl_Factory.create(provider8);
        this.H = create12;
        this.I = SingleCheck.provider(create12);
        this.J = SessionsListResourceProviderImpl_Factory.create(this.E);
        this.K = InstanceFactory.createNullable(kundle);
        this.L = new c(sessionsListDependencies);
        Factory createNullable = InstanceFactory.createNullable(str);
        this.M = createNullable;
        SessionsListPresenterImpl_Factory create13 = SessionsListPresenterImpl_Factory.create(this.f, this.C, this.D, this.I, this.h, this.J, this.d, this.K, this.L, createNullable);
        this.N = create13;
        this.O = DoubleCheck.provider(create13);
    }

    public static SessionsListComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.profile.sessions.list.di.SessionsListComponent
    public void inject(SessionsListFragment sessionsListFragment) {
        SessionsListFragment_MembersInjector.injectPresenter(sessionsListFragment, this.O.get());
        SessionsListFragment_MembersInjector.injectAdapterPresenter(sessionsListFragment, this.C.get());
        SessionsListFragment_MembersInjector.injectItemBinder(sessionsListFragment, this.B.get());
        SessionsListFragment_MembersInjector.injectAnalytics(sessionsListFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        SessionsListFragment_MembersInjector.injectActivityIntentFactory(sessionsListFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        SessionsListFragment_MembersInjector.injectSnackbarPresenter(sessionsListFragment, this.D.get());
    }
}
