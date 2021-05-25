package com.avito.android.authorization.select_profile.social_login.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.select_profile.adapter.SelectProfileField;
import com.avito.android.authorization.select_profile.adapter.create_profile.CreateProfileItemPresenter;
import com.avito.android.authorization.select_profile.adapter.create_profile.di.CreateProfileItemModule;
import com.avito.android.authorization.select_profile.adapter.create_profile.di.CreateProfileItemModule_ProvideCreateProfileItemBlueprint$authorization_releaseFactory;
import com.avito.android.authorization.select_profile.adapter.create_profile.di.CreateProfileItemModule_ProvideCreateProfileItemPresenter$authorization_releaseFactory;
import com.avito.android.authorization.select_profile.adapter.profile.ProfileItemPresenter;
import com.avito.android.authorization.select_profile.adapter.profile.di.ProfileItemModule;
import com.avito.android.authorization.select_profile.adapter.profile.di.ProfileItemModule_ProvideBlueprint$authorization_releaseFactory;
import com.avito.android.authorization.select_profile.adapter.profile.di.ProfileItemModule_ProvidePresenter$authorization_releaseFactory;
import com.avito.android.authorization.select_profile.adapter.text.TextItemPresenter;
import com.avito.android.authorization.select_profile.adapter.text.di.TextItemModule;
import com.avito.android.authorization.select_profile.adapter.text.di.TextItemModule_ProvideBlueprint$authorization_releaseFactory;
import com.avito.android.authorization.select_profile.adapter.text.di.TextItemModule_ProvidePresenter$authorization_releaseFactory;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsFragment;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsFragment_MembersInjector;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenter;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenterImpl;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenterImpl_Factory;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsResourceProvider;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsResourceProviderImpl;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsResourceProviderImpl_Factory;
import com.avito.android.authorization.select_profile.social_login.di.SocialRegistrationSuggestsComponent;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.remote.model.registration.RegisteredProfile;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
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
import java.util.List;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerSocialRegistrationSuggestsComponent implements SocialRegistrationSuggestsComponent {
    public Provider<SocialRegistrationSuggestsPresenterImpl> A;
    public Provider<SocialRegistrationSuggestsPresenter> B;
    public final SocialRegistrationSuggestsDependencies a;
    public Provider<String> b;
    public Provider<String> c;
    public Provider<String> d;
    public Provider<AccountInteractor> e;
    public Provider<List<RegisteredProfile>> f;
    public Provider<Set<ItemBlueprint<?, ?>>> g = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PublishRelay<SelectProfileField>> h;
    public Provider<CreateProfileItemPresenter> i;
    public Provider<ItemBlueprint<?, ?>> j;
    public Provider<ProfileItemPresenter> k;
    public Provider<ItemBlueprint<?, ?>> l;
    public Provider<TextItemPresenter> m;
    public Provider<ItemBlueprint<?, ?>> n;
    public Provider<Set<ItemBlueprint<?, ?>>> o;
    public Provider<ItemBinder> p;
    public Provider<AdapterPresenter> q;
    public Provider<SchedulersFactory3> r;
    public Provider<Resources> s;
    public Provider<SocialRegistrationSuggestsResourceProviderImpl> t;
    public Provider<SocialRegistrationSuggestsResourceProvider> u;
    public Provider<ErrorFormatterImpl> v;
    public Provider<ErrorFormatter> w;
    public Provider<ErrorHelperImpl> x;
    public Provider<ErrorHelper> y;
    public Provider<Analytics> z;

    public static final class b implements SocialRegistrationSuggestsComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.authorization.select_profile.social_login.di.SocialRegistrationSuggestsComponent.Factory
        public SocialRegistrationSuggestsComponent create(String str, String str2, String str3, List<RegisteredProfile> list, Resources resources, SocialRegistrationSuggestsDependencies socialRegistrationSuggestsDependencies) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(str2);
            Preconditions.checkNotNull(str3);
            Preconditions.checkNotNull(list);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(socialRegistrationSuggestsDependencies);
            return new DaggerSocialRegistrationSuggestsComponent(new CreateProfileItemModule(), new ProfileItemModule(), new TextItemModule(), socialRegistrationSuggestsDependencies, str, str2, str3, list, resources, null);
        }
    }

    public static class c implements Provider<AccountInteractor> {
        public final SocialRegistrationSuggestsDependencies a;

        public c(SocialRegistrationSuggestsDependencies socialRegistrationSuggestsDependencies) {
            this.a = socialRegistrationSuggestsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountInteractor get() {
            return (AccountInteractor) Preconditions.checkNotNullFromComponent(this.a.accountInteractor());
        }
    }

    public static class d implements Provider<Analytics> {
        public final SocialRegistrationSuggestsDependencies a;

        public d(SocialRegistrationSuggestsDependencies socialRegistrationSuggestsDependencies) {
            this.a = socialRegistrationSuggestsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<SchedulersFactory3> {
        public final SocialRegistrationSuggestsDependencies a;

        public e(SocialRegistrationSuggestsDependencies socialRegistrationSuggestsDependencies) {
            this.a = socialRegistrationSuggestsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerSocialRegistrationSuggestsComponent(CreateProfileItemModule createProfileItemModule, ProfileItemModule profileItemModule, TextItemModule textItemModule, SocialRegistrationSuggestsDependencies socialRegistrationSuggestsDependencies, String str, String str2, String str3, List list, Resources resources, a aVar) {
        this.a = socialRegistrationSuggestsDependencies;
        this.b = InstanceFactory.create(str);
        this.c = InstanceFactory.create(str2);
        this.d = InstanceFactory.create(str3);
        this.e = new c(socialRegistrationSuggestsDependencies);
        this.f = InstanceFactory.create(list);
        Provider<PublishRelay<SelectProfileField>> provider = DoubleCheck.provider(SocialRegistrationSuggestsModule_ProvideFieldClicksStream$authorization_releaseFactory.create());
        this.h = provider;
        Provider<CreateProfileItemPresenter> provider2 = DoubleCheck.provider(CreateProfileItemModule_ProvideCreateProfileItemPresenter$authorization_releaseFactory.create(createProfileItemModule, provider));
        this.i = provider2;
        this.j = DoubleCheck.provider(CreateProfileItemModule_ProvideCreateProfileItemBlueprint$authorization_releaseFactory.create(createProfileItemModule, provider2));
        Provider<ProfileItemPresenter> provider3 = DoubleCheck.provider(ProfileItemModule_ProvidePresenter$authorization_releaseFactory.create(profileItemModule, this.h));
        this.k = provider3;
        this.l = DoubleCheck.provider(ProfileItemModule_ProvideBlueprint$authorization_releaseFactory.create(profileItemModule, provider3));
        Provider<TextItemPresenter> provider4 = DoubleCheck.provider(TextItemModule_ProvidePresenter$authorization_releaseFactory.create(textItemModule));
        this.m = provider4;
        this.n = DoubleCheck.provider(TextItemModule_ProvideBlueprint$authorization_releaseFactory.create(textItemModule, provider4));
        SetFactory build = SetFactory.builder(3, 1).addCollectionProvider(this.g).addProvider(this.j).addProvider(this.l).addProvider(this.n).build();
        this.o = build;
        Provider<ItemBinder> provider5 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.p = provider5;
        this.q = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider5));
        this.r = new e(socialRegistrationSuggestsDependencies);
        Factory create = InstanceFactory.create(resources);
        this.s = create;
        SocialRegistrationSuggestsResourceProviderImpl_Factory create2 = SocialRegistrationSuggestsResourceProviderImpl_Factory.create(create);
        this.t = create2;
        this.u = DoubleCheck.provider(create2);
        ErrorFormatterImpl_Factory create3 = ErrorFormatterImpl_Factory.create(this.s);
        this.v = create3;
        Provider<ErrorFormatter> provider6 = SingleCheck.provider(create3);
        this.w = provider6;
        ErrorHelperImpl_Factory create4 = ErrorHelperImpl_Factory.create(provider6);
        this.x = create4;
        Provider<ErrorHelper> provider7 = SingleCheck.provider(create4);
        this.y = provider7;
        d dVar = new d(socialRegistrationSuggestsDependencies);
        this.z = dVar;
        SocialRegistrationSuggestsPresenterImpl_Factory create5 = SocialRegistrationSuggestsPresenterImpl_Factory.create(this.b, this.c, this.d, this.e, this.f, this.q, this.h, this.r, this.u, provider7, dVar);
        this.A = create5;
        this.B = DoubleCheck.provider(create5);
    }

    public static SocialRegistrationSuggestsComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.authorization.select_profile.social_login.di.SocialRegistrationSuggestsComponent
    public void inject(SocialRegistrationSuggestsFragment socialRegistrationSuggestsFragment) {
        SocialRegistrationSuggestsFragment_MembersInjector.injectPresenter(socialRegistrationSuggestsFragment, this.B.get());
        SocialRegistrationSuggestsFragment_MembersInjector.injectAdapterPresenter(socialRegistrationSuggestsFragment, this.q.get());
        SocialRegistrationSuggestsFragment_MembersInjector.injectItemBinder(socialRegistrationSuggestsFragment, this.p.get());
        SocialRegistrationSuggestsFragment_MembersInjector.injectIntentFactory(socialRegistrationSuggestsFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}
