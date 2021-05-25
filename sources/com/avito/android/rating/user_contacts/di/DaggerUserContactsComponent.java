package com.avito.android.rating.user_contacts.di;

import android.content.res.Resources;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.error_snippet.ErrorSnippetItemPresenter;
import com.avito.android.rating.details.adapter.error_snippet.di.ErrorSnippetItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.details.adapter.error_snippet.di.ErrorSnippetItemModule_ProvidePresenter$rating_releaseFactory;
import com.avito.android.rating.details.adapter.loading.LoadingItemNextPageAction;
import com.avito.android.rating.details.adapter.loading.LoadingItemPresenterImpl;
import com.avito.android.rating.details.adapter.loading.LoadingItemPresenterImpl_Factory;
import com.avito.android.rating.details.adapter.loading.di.LoadingItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.details.adapter.loading.di.LoadingItemModule_ProvideLoadingItemShownAction$rating_releaseFactory;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.rating.user_contacts.UserContactsActivity;
import com.avito.android.rating.user_contacts.UserContactsActivity_MembersInjector;
import com.avito.android.rating.user_contacts.UserContactsConverter;
import com.avito.android.rating.user_contacts.UserContactsConverterImpl_Factory;
import com.avito.android.rating.user_contacts.UserContactsInteractor;
import com.avito.android.rating.user_contacts.UserContactsInteractorImpl;
import com.avito.android.rating.user_contacts.UserContactsInteractorImpl_Factory;
import com.avito.android.rating.user_contacts.UserContactsPresenter;
import com.avito.android.rating.user_contacts.UserContactsPresenterImpl;
import com.avito.android.rating.user_contacts.UserContactsPresenterImpl_Factory;
import com.avito.android.rating.user_contacts.UserContactsSpanProvider;
import com.avito.android.rating.user_contacts.UserContactsSpanProviderImpl_Factory;
import com.avito.android.rating.user_contacts.action.UserContactAction;
import com.avito.android.rating.user_contacts.adapter.contact.ContactItemBlueprint;
import com.avito.android.rating.user_contacts.adapter.contact.ContactItemBlueprint_Factory;
import com.avito.android.rating.user_contacts.adapter.contact.ContactItemPresenterImpl;
import com.avito.android.rating.user_contacts.adapter.contact.ContactItemPresenterImpl_Factory;
import com.avito.android.rating.user_contacts.adapter.info.InfoItemBlueprint;
import com.avito.android.rating.user_contacts.adapter.info.InfoItemBlueprint_Factory;
import com.avito.android.rating.user_contacts.adapter.info.InfoItemPresenterImpl_Factory;
import com.avito.android.rating.user_contacts.di.UserContactsComponent;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
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
public final class DaggerUserContactsComponent implements UserContactsComponent {
    public Provider<ContactItemBlueprint> A;
    public Provider<Set<ItemBlueprint<?, ?>>> B;
    public Provider<ItemBinder> C;
    public Provider<AdapterPresenter> D;
    public Provider<CallableResponsiveItemPresenterRegistry> E;
    public Provider<ResponsiveAdapterPresenter> F;
    public final UserContactsDependencies a;
    public Provider<RatingApi> b;
    public Provider<String> c;
    public Provider<SchedulersFactory3> d;
    public Provider<UserContactsInteractorImpl> e;
    public Provider<UserContactsInteractor> f;
    public Provider<UserContactsConverter> g = DoubleCheck.provider(UserContactsConverterImpl_Factory.create());
    public Provider<PublishRelay<UserContactAction>> h = DoubleCheck.provider(UserContactsModule_ProvideRatingStreamFactory.create());
    public Provider<Resources> i;
    public Provider<ErrorFormatterImpl> j;
    public Provider<ErrorFormatter> k;
    public Provider<ErrorHelperImpl> l;
    public Provider<ErrorHelper> m;
    public Provider<UserContactsSpanProvider> n;
    public Provider<PublishRelay<LoadingItemNextPageAction>> o;
    public Provider<Kundle> p;
    public Provider<UserContactsPresenterImpl> q;
    public Provider<UserContactsPresenter> r;
    public Provider<Set<ItemBlueprint<?, ?>>> s;
    public Provider<PublishRelay<RatingDetailsItem>> t;
    public Provider<ErrorSnippetItemPresenter> u;
    public Provider<ItemBlueprint<?, ?>> v;
    public Provider<LoadingItemPresenterImpl> w;
    public Provider<ItemBlueprint<?, ?>> x;
    public Provider<InfoItemBlueprint> y;
    public Provider<ContactItemPresenterImpl> z;

    public static final class b implements UserContactsComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.rating.user_contacts.di.UserContactsComponent.Factory
        public UserContactsComponent create(UserContactsDependencies userContactsDependencies, Kundle kundle, Resources resources, String str) {
            Preconditions.checkNotNull(userContactsDependencies);
            Preconditions.checkNotNull(resources);
            return new DaggerUserContactsComponent(userContactsDependencies, kundle, resources, str, null);
        }
    }

    public static class c implements Provider<RatingApi> {
        public final UserContactsDependencies a;

        public c(UserContactsDependencies userContactsDependencies) {
            this.a = userContactsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RatingApi get() {
            return (RatingApi) Preconditions.checkNotNullFromComponent(this.a.ratingApi());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final UserContactsDependencies a;

        public d(UserContactsDependencies userContactsDependencies) {
            this.a = userContactsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerUserContactsComponent(UserContactsDependencies userContactsDependencies, Kundle kundle, Resources resources, String str, a aVar) {
        this.a = userContactsDependencies;
        this.b = new c(userContactsDependencies);
        Factory createNullable = InstanceFactory.createNullable(str);
        this.c = createNullable;
        d dVar = new d(userContactsDependencies);
        this.d = dVar;
        UserContactsInteractorImpl_Factory create = UserContactsInteractorImpl_Factory.create(this.b, createNullable, dVar);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.i = create2;
        ErrorFormatterImpl_Factory create3 = ErrorFormatterImpl_Factory.create(create2);
        this.j = create3;
        Provider<ErrorFormatter> provider = SingleCheck.provider(create3);
        this.k = provider;
        ErrorHelperImpl_Factory create4 = ErrorHelperImpl_Factory.create(provider);
        this.l = create4;
        this.m = SingleCheck.provider(create4);
        this.n = DoubleCheck.provider(UserContactsSpanProviderImpl_Factory.create());
        this.o = DoubleCheck.provider(LoadingItemModule_ProvideLoadingItemShownAction$rating_releaseFactory.create());
        Factory createNullable2 = InstanceFactory.createNullable(kundle);
        this.p = createNullable2;
        UserContactsPresenterImpl_Factory create5 = UserContactsPresenterImpl_Factory.create(this.f, this.g, this.d, this.h, this.m, this.n, this.o, createNullable2);
        this.q = create5;
        this.r = DoubleCheck.provider(create5);
        this.s = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
        Provider<PublishRelay<RatingDetailsItem>> provider2 = DoubleCheck.provider(UserContactsModule_ProvideItemClicksStream$rating_releaseFactory.create());
        this.t = provider2;
        Provider<ErrorSnippetItemPresenter> provider3 = DoubleCheck.provider(ErrorSnippetItemModule_ProvidePresenter$rating_releaseFactory.create(provider2));
        this.u = provider3;
        this.v = DoubleCheck.provider(ErrorSnippetItemModule_ProvideBlueprint$rating_releaseFactory.create(provider3));
        LoadingItemPresenterImpl_Factory create6 = LoadingItemPresenterImpl_Factory.create(this.o);
        this.w = create6;
        this.x = DoubleCheck.provider(LoadingItemModule_ProvideBlueprint$rating_releaseFactory.create(create6));
        this.y = InfoItemBlueprint_Factory.create(InfoItemPresenterImpl_Factory.create());
        ContactItemPresenterImpl_Factory create7 = ContactItemPresenterImpl_Factory.create(this.h);
        this.z = create7;
        this.A = ContactItemBlueprint_Factory.create(create7);
        SetFactory build = SetFactory.builder(4, 1).addCollectionProvider(this.s).addProvider(this.v).addProvider(this.x).addProvider(this.y).addProvider(this.A).build();
        this.B = build;
        Provider<ItemBinder> provider4 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.C = provider4;
        this.D = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider4));
        Provider<CallableResponsiveItemPresenterRegistry> provider5 = DoubleCheck.provider(UserContactsModule_ProvideResponsiveItemPresenterRegistry$rating_releaseFactory.create());
        this.E = provider5;
        this.F = DoubleCheck.provider(UserContactsModule_ProvideAdapterPresenter$rating_releaseFactory.create(this.D, provider5));
    }

    public static UserContactsComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.rating.user_contacts.di.UserContactsComponent
    public void inject(UserContactsActivity userContactsActivity) {
        UserContactsActivity_MembersInjector.injectPresenter(userContactsActivity, this.r.get());
        UserContactsActivity_MembersInjector.injectAdapterPresenter(userContactsActivity, this.F.get());
        UserContactsActivity_MembersInjector.injectItemBinder(userContactsActivity, this.C.get());
        UserContactsActivity_MembersInjector.injectDeepLinkIntentFactory(userContactsActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        UserContactsActivity_MembersInjector.injectSpanProvider(userContactsActivity, this.n.get());
        UserContactsActivity_MembersInjector.injectAnalytics(userContactsActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
