package com.avito.android.user_subscribers.di;

import android.content.res.Resources;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.user_subscribers.UserSubscribersActivity;
import com.avito.android.user_subscribers.UserSubscribersActivity_MembersInjector;
import com.avito.android.user_subscribers.UserSubscribersConverter;
import com.avito.android.user_subscribers.UserSubscribersConverterImpl_Factory;
import com.avito.android.user_subscribers.UserSubscribersInteractor;
import com.avito.android.user_subscribers.UserSubscribersInteractorImpl;
import com.avito.android.user_subscribers.UserSubscribersInteractorImpl_Factory;
import com.avito.android.user_subscribers.UserSubscribersPresenter;
import com.avito.android.user_subscribers.UserSubscribersPresenterImpl;
import com.avito.android.user_subscribers.UserSubscribersPresenterImpl_Factory;
import com.avito.android.user_subscribers.action.SubscriberAction;
import com.avito.android.user_subscribers.adapter.error.ErrorItemBlueprint;
import com.avito.android.user_subscribers.adapter.error.ErrorItemBlueprint_Factory;
import com.avito.android.user_subscribers.adapter.error.ErrorItemPresenterImpl;
import com.avito.android.user_subscribers.adapter.error.ErrorItemPresenterImpl_Factory;
import com.avito.android.user_subscribers.adapter.loading.LoadingItemBlueprint;
import com.avito.android.user_subscribers.adapter.loading.LoadingItemBlueprint_Factory;
import com.avito.android.user_subscribers.adapter.loading.LoadingItemPresenterImpl;
import com.avito.android.user_subscribers.adapter.loading.LoadingItemPresenterImpl_Factory;
import com.avito.android.user_subscribers.adapter.subscriber.SubscriberItemBlueprint;
import com.avito.android.user_subscribers.adapter.subscriber.SubscriberItemBlueprint_Factory;
import com.avito.android.user_subscribers.adapter.subscriber.SubscriberItemPresenterImpl;
import com.avito.android.user_subscribers.adapter.subscriber.SubscriberItemPresenterImpl_Factory;
import com.avito.android.user_subscribers.di.UserSubscribersComponent;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay2.Relay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerUserSubscribersComponent implements UserSubscribersComponent {
    public final UserSubscribersDependencies a;
    public Provider<FavoriteSellersApi> b;
    public Provider<SchedulersFactory> c;
    public Provider<UserSubscribersConverter> d;
    public Provider<UserSubscribersInteractorImpl> e;
    public Provider<UserSubscribersInteractor> f;
    public Provider<Relay<SubscriberAction>> g = DoubleCheck.provider(UserSubscribersModule_ProvideRelayFactory.create());
    public Provider<Resources> h;
    public Provider<ErrorFormatterImpl> i;
    public Provider<ErrorFormatter> j;
    public Provider<ErrorHelperImpl> k;
    public Provider<ErrorHelper> l;
    public Provider<Kundle> m;
    public Provider<UserSubscribersPresenterImpl> n;
    public Provider<UserSubscribersPresenter> o;
    public Provider<Set<ItemBlueprint<?, ?>>> p;
    public Provider<SubscriberItemPresenterImpl> q;
    public Provider<SubscriberItemBlueprint> r;
    public Provider<LoadingItemPresenterImpl> s;
    public Provider<LoadingItemBlueprint> t;
    public Provider<ErrorItemPresenterImpl> u;
    public Provider<ErrorItemBlueprint> v;
    public Provider<Set<ItemBlueprint<?, ?>>> w;
    public Provider<ItemBinder> x;
    public Provider<AdapterPresenter> y;

    public static final class b implements UserSubscribersComponent.Builder {
        public UserSubscribersDependencies a;
        public Kundle b;
        public Resources c;

        public b(a aVar) {
        }

        @Override // com.avito.android.user_subscribers.di.UserSubscribersComponent.Builder
        public UserSubscribersComponent build() {
            Preconditions.checkBuilderRequirement(this.a, UserSubscribersDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            return new DaggerUserSubscribersComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.user_subscribers.di.UserSubscribersComponent.Builder
        public UserSubscribersComponent.Builder dependentOn(UserSubscribersDependencies userSubscribersDependencies) {
            this.a = (UserSubscribersDependencies) Preconditions.checkNotNull(userSubscribersDependencies);
            return this;
        }

        @Override // com.avito.android.user_subscribers.di.UserSubscribersComponent.Builder
        public UserSubscribersComponent.Builder with(Kundle kundle) {
            this.b = kundle;
            return this;
        }

        @Override // com.avito.android.user_subscribers.di.UserSubscribersComponent.Builder
        public UserSubscribersComponent.Builder with(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<FavoriteSellersApi> {
        public final UserSubscribersDependencies a;

        public c(UserSubscribersDependencies userSubscribersDependencies) {
            this.a = userSubscribersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteSellersApi get() {
            return (FavoriteSellersApi) Preconditions.checkNotNullFromComponent(this.a.favoriteSellersApi());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final UserSubscribersDependencies a;

        public d(UserSubscribersDependencies userSubscribersDependencies) {
            this.a = userSubscribersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulers());
        }
    }

    public DaggerUserSubscribersComponent(UserSubscribersDependencies userSubscribersDependencies, Kundle kundle, Resources resources, a aVar) {
        this.a = userSubscribersDependencies;
        this.b = new c(userSubscribersDependencies);
        this.c = new d(userSubscribersDependencies);
        Provider<UserSubscribersConverter> provider = DoubleCheck.provider(UserSubscribersConverterImpl_Factory.create());
        this.d = provider;
        UserSubscribersInteractorImpl_Factory create = UserSubscribersInteractorImpl_Factory.create(this.b, this.c, provider);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.h = create2;
        ErrorFormatterImpl_Factory create3 = ErrorFormatterImpl_Factory.create(create2);
        this.i = create3;
        Provider<ErrorFormatter> provider2 = SingleCheck.provider(create3);
        this.j = provider2;
        ErrorHelperImpl_Factory create4 = ErrorHelperImpl_Factory.create(provider2);
        this.k = create4;
        this.l = SingleCheck.provider(create4);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.m = createNullable;
        UserSubscribersPresenterImpl_Factory create5 = UserSubscribersPresenterImpl_Factory.create(this.f, this.c, this.g, this.l, createNullable);
        this.n = create5;
        this.o = DoubleCheck.provider(create5);
        this.p = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
        SubscriberItemPresenterImpl_Factory create6 = SubscriberItemPresenterImpl_Factory.create(this.g);
        this.q = create6;
        this.r = SubscriberItemBlueprint_Factory.create(create6);
        LoadingItemPresenterImpl_Factory create7 = LoadingItemPresenterImpl_Factory.create(this.g);
        this.s = create7;
        this.t = LoadingItemBlueprint_Factory.create(create7);
        ErrorItemPresenterImpl_Factory create8 = ErrorItemPresenterImpl_Factory.create(this.g);
        this.u = create8;
        this.v = ErrorItemBlueprint_Factory.create(create8);
        SetFactory build = SetFactory.builder(3, 1).addCollectionProvider(this.p).addProvider(this.r).addProvider(this.t).addProvider(this.v).build();
        this.w = build;
        Provider<ItemBinder> provider3 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.x = provider3;
        this.y = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider3));
    }

    public static UserSubscribersComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.user_subscribers.di.UserSubscribersComponent
    public void inject(UserSubscribersActivity userSubscribersActivity) {
        UserSubscribersActivity_MembersInjector.injectPresenter(userSubscribersActivity, this.o.get());
        UserSubscribersActivity_MembersInjector.injectAdapterPresenter(userSubscribersActivity, this.y.get());
        UserSubscribersActivity_MembersInjector.injectItemBinder(userSubscribersActivity, this.x.get());
        UserSubscribersActivity_MembersInjector.injectDeepLinkIntentFactory(userSubscribersActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
    }
}
