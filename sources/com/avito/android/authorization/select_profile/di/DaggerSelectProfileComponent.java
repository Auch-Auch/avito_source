package com.avito.android.authorization.select_profile.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.select_profile.SelectProfileActivity;
import com.avito.android.authorization.select_profile.SelectProfileActivity_MembersInjector;
import com.avito.android.authorization.select_profile.SelectProfileInteractor;
import com.avito.android.authorization.select_profile.SelectProfileInteractorImpl;
import com.avito.android.authorization.select_profile.SelectProfileInteractorImpl_Factory;
import com.avito.android.authorization.select_profile.SelectProfilePresenter;
import com.avito.android.authorization.select_profile.SelectProfilePresenterImpl;
import com.avito.android.authorization.select_profile.SelectProfilePresenterImpl_Factory;
import com.avito.android.authorization.select_profile.SelectProfileResourceProvider;
import com.avito.android.authorization.select_profile.SelectProfileResourceProviderImpl;
import com.avito.android.authorization.select_profile.SelectProfileResourceProviderImpl_Factory;
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
import com.avito.android.authorization.select_profile.di.SelectProfileComponent;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.remote.ProfileApi;
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
public final class DaggerSelectProfileComponent implements SelectProfileComponent {
    public final SelectProfileDependencies a;
    public Provider<String> b;
    public Provider<ProfileApi> c;
    public Provider<SchedulersFactory3> d;
    public Provider<Resources> e;
    public Provider<SelectProfileResourceProviderImpl> f;
    public Provider<SelectProfileResourceProvider> g;
    public Provider<SelectProfileInteractorImpl> h;
    public Provider<SelectProfileInteractor> i;
    public Provider<Set<ItemBlueprint<?, ?>>> j = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PublishRelay<SelectProfileField>> k;
    public Provider<CreateProfileItemPresenter> l;
    public Provider<ItemBlueprint<?, ?>> m;
    public Provider<ProfileItemPresenter> n;
    public Provider<ItemBlueprint<?, ?>> o;
    public Provider<TextItemPresenter> p;
    public Provider<ItemBlueprint<?, ?>> q;
    public Provider<Set<ItemBlueprint<?, ?>>> r;
    public Provider<ItemBinder> s;
    public Provider<AdapterPresenter> t;
    public Provider<ErrorFormatterImpl> u;
    public Provider<ErrorFormatter> v;
    public Provider<Analytics> w;
    public Provider<Kundle> x;
    public Provider<SelectProfilePresenterImpl> y;
    public Provider<SelectProfilePresenter> z;

    public static final class b implements SelectProfileComponent.Builder {
        public SelectProfileDependencies a;
        public Resources b;
        public Kundle c;
        public String d;

        public b(a aVar) {
        }

        @Override // com.avito.android.authorization.select_profile.di.SelectProfileComponent.Builder
        public SelectProfileComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SelectProfileDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.d, String.class);
            return new DaggerSelectProfileComponent(new CreateProfileItemModule(), new ProfileItemModule(), new TextItemModule(), this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.authorization.select_profile.di.SelectProfileComponent.Builder
        public SelectProfileComponent.Builder dependentOn(SelectProfileDependencies selectProfileDependencies) {
            this.a = (SelectProfileDependencies) Preconditions.checkNotNull(selectProfileDependencies);
            return this;
        }

        @Override // com.avito.android.authorization.select_profile.di.SelectProfileComponent.Builder
        public SelectProfileComponent.Builder withHash(String str) {
            this.d = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.authorization.select_profile.di.SelectProfileComponent.Builder
        public SelectProfileComponent.Builder withPresenterState(Kundle kundle) {
            this.c = kundle;
            return this;
        }

        @Override // com.avito.android.authorization.select_profile.di.SelectProfileComponent.Builder
        public SelectProfileComponent.Builder withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final SelectProfileDependencies a;

        public c(SelectProfileDependencies selectProfileDependencies) {
            this.a = selectProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<ProfileApi> {
        public final SelectProfileDependencies a;

        public d(SelectProfileDependencies selectProfileDependencies) {
            this.a = selectProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class e implements Provider<SchedulersFactory3> {
        public final SelectProfileDependencies a;

        public e(SelectProfileDependencies selectProfileDependencies) {
            this.a = selectProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerSelectProfileComponent(CreateProfileItemModule createProfileItemModule, ProfileItemModule profileItemModule, TextItemModule textItemModule, SelectProfileDependencies selectProfileDependencies, Resources resources, Kundle kundle, String str, a aVar) {
        this.a = selectProfileDependencies;
        this.b = InstanceFactory.create(str);
        this.c = new d(selectProfileDependencies);
        this.d = new e(selectProfileDependencies);
        Factory create = InstanceFactory.create(resources);
        this.e = create;
        SelectProfileResourceProviderImpl_Factory create2 = SelectProfileResourceProviderImpl_Factory.create(create);
        this.f = create2;
        Provider<SelectProfileResourceProvider> provider = DoubleCheck.provider(create2);
        this.g = provider;
        SelectProfileInteractorImpl_Factory create3 = SelectProfileInteractorImpl_Factory.create(this.b, this.c, this.d, provider);
        this.h = create3;
        this.i = DoubleCheck.provider(create3);
        Provider<PublishRelay<SelectProfileField>> provider2 = DoubleCheck.provider(SelectProfileModule_ProvideFieldClicksStream$authorization_releaseFactory.create());
        this.k = provider2;
        Provider<CreateProfileItemPresenter> provider3 = DoubleCheck.provider(CreateProfileItemModule_ProvideCreateProfileItemPresenter$authorization_releaseFactory.create(createProfileItemModule, provider2));
        this.l = provider3;
        this.m = DoubleCheck.provider(CreateProfileItemModule_ProvideCreateProfileItemBlueprint$authorization_releaseFactory.create(createProfileItemModule, provider3));
        Provider<ProfileItemPresenter> provider4 = DoubleCheck.provider(ProfileItemModule_ProvidePresenter$authorization_releaseFactory.create(profileItemModule, this.k));
        this.n = provider4;
        this.o = DoubleCheck.provider(ProfileItemModule_ProvideBlueprint$authorization_releaseFactory.create(profileItemModule, provider4));
        Provider<TextItemPresenter> provider5 = DoubleCheck.provider(TextItemModule_ProvidePresenter$authorization_releaseFactory.create(textItemModule));
        this.p = provider5;
        this.q = DoubleCheck.provider(TextItemModule_ProvideBlueprint$authorization_releaseFactory.create(textItemModule, provider5));
        SetFactory build = SetFactory.builder(3, 1).addCollectionProvider(this.j).addProvider(this.m).addProvider(this.o).addProvider(this.q).build();
        this.r = build;
        Provider<ItemBinder> provider6 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.s = provider6;
        this.t = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider6));
        ErrorFormatterImpl_Factory create4 = ErrorFormatterImpl_Factory.create(this.e);
        this.u = create4;
        this.v = SingleCheck.provider(create4);
        this.w = new c(selectProfileDependencies);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.x = createNullable;
        SelectProfilePresenterImpl_Factory create5 = SelectProfilePresenterImpl_Factory.create(this.i, this.t, this.d, this.v, this.k, this.w, createNullable);
        this.y = create5;
        this.z = DoubleCheck.provider(create5);
    }

    public static SelectProfileComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.authorization.select_profile.di.SelectProfileComponent
    public void inject(SelectProfileActivity selectProfileActivity) {
        SelectProfileActivity_MembersInjector.injectPresenter(selectProfileActivity, this.z.get());
        SelectProfileActivity_MembersInjector.injectAdapterPresenter(selectProfileActivity, this.t.get());
        SelectProfileActivity_MembersInjector.injectItemBinder(selectProfileActivity, this.s.get());
        SelectProfileActivity_MembersInjector.injectAnalytics(selectProfileActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        SelectProfileActivity_MembersInjector.injectIntentFactory(selectProfileActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}
