package com.avito.android.authorization.select_social.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.select_social.SelectSocialActivity;
import com.avito.android.authorization.select_social.SelectSocialActivity_MembersInjector;
import com.avito.android.authorization.select_social.SelectSocialInteractor;
import com.avito.android.authorization.select_social.SelectSocialInteractorImpl;
import com.avito.android.authorization.select_social.SelectSocialInteractorImpl_Factory;
import com.avito.android.authorization.select_social.SelectSocialPresenter;
import com.avito.android.authorization.select_social.SelectSocialPresenterImpl;
import com.avito.android.authorization.select_social.SelectSocialPresenterImpl_Factory;
import com.avito.android.authorization.select_social.SelectSocialResourceProvider;
import com.avito.android.authorization.select_social.SelectSocialResourceProviderImpl;
import com.avito.android.authorization.select_social.SelectSocialResourceProviderImpl_Factory;
import com.avito.android.authorization.select_social.adapter.SelectSocialField;
import com.avito.android.authorization.select_social.adapter.SocialItemBlueprint;
import com.avito.android.authorization.select_social.adapter.SocialItemBlueprintImpl;
import com.avito.android.authorization.select_social.adapter.SocialItemBlueprintImpl_Factory;
import com.avito.android.authorization.select_social.adapter.SocialItemPresenter;
import com.avito.android.authorization.select_social.adapter.SocialItemPresenterImpl;
import com.avito.android.authorization.select_social.adapter.SocialItemPresenterImpl_Factory;
import com.avito.android.authorization.select_social.adapter.TextItemBlueprint;
import com.avito.android.authorization.select_social.adapter.TextItemBlueprintImpl;
import com.avito.android.authorization.select_social.adapter.TextItemBlueprintImpl_Factory;
import com.avito.android.authorization.select_social.adapter.TextItemPresenter;
import com.avito.android.authorization.select_social.adapter.TextItemPresenterImpl_Factory;
import com.avito.android.authorization.select_social.di.SelectSocialComponent;
import com.avito.android.remote.model.registration.ProfileSocial;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.List;
import javax.inject.Provider;
public final class DaggerSelectSocialComponent implements SelectSocialComponent {
    public final SelectSocialDependencies a;
    public Provider<List<ProfileSocial>> b;
    public Provider<AccountInteractor> c;
    public Provider<Resources> d;
    public Provider<SelectSocialResourceProviderImpl> e;
    public Provider<SelectSocialResourceProvider> f;
    public Provider<SelectSocialInteractorImpl> g;
    public Provider<SelectSocialInteractor> h;
    public Provider<PublishRelay<SelectSocialField>> i;
    public Provider<SocialItemPresenterImpl> j;
    public Provider<SocialItemPresenter> k;
    public Provider<SocialItemBlueprintImpl> l;
    public Provider<SocialItemBlueprint> m;
    public Provider<TextItemPresenter> n;
    public Provider<TextItemBlueprintImpl> o;
    public Provider<TextItemBlueprint> p;
    public Provider<ItemBinder> q;
    public Provider<AdapterPresenter> r;
    public Provider<SchedulersFactory> s;
    public Provider<ErrorFormatterImpl> t;
    public Provider<ErrorFormatter> u;
    public Provider<Analytics> v;
    public Provider<String> w;
    public Provider<Kundle> x;
    public Provider<SelectSocialPresenterImpl> y;
    public Provider<SelectSocialPresenter> z;

    public static final class b implements SelectSocialComponent.Builder {
        public SelectSocialDependencies a;
        public Resources b;
        public Kundle c;
        public List<ProfileSocial> d;
        public String e;

        public b(a aVar) {
        }

        @Override // com.avito.android.authorization.select_social.di.SelectSocialComponent.Builder
        public SelectSocialComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SelectSocialDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.d, List.class);
            Preconditions.checkBuilderRequirement(this.e, String.class);
            return new DaggerSelectSocialComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.authorization.select_social.di.SelectSocialComponent.Builder
        public SelectSocialComponent.Builder dependentOn(SelectSocialDependencies selectSocialDependencies) {
            this.a = (SelectSocialDependencies) Preconditions.checkNotNull(selectSocialDependencies);
            return this;
        }

        @Override // com.avito.android.authorization.select_social.di.SelectSocialComponent.Builder
        public SelectSocialComponent.Builder withPresenterState(Kundle kundle) {
            this.c = kundle;
            return this;
        }

        @Override // com.avito.android.authorization.select_social.di.SelectSocialComponent.Builder
        public SelectSocialComponent.Builder withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.authorization.select_social.di.SelectSocialComponent.Builder
        public SelectSocialComponent.Builder withSocialList(List list) {
            this.d = (List) Preconditions.checkNotNull(list);
            return this;
        }

        @Override // com.avito.android.authorization.select_social.di.SelectSocialComponent.Builder
        public SelectSocialComponent.Builder withSuggestKey(String str) {
            this.e = (String) Preconditions.checkNotNull(str);
            return this;
        }
    }

    public static class c implements Provider<AccountInteractor> {
        public final SelectSocialDependencies a;

        public c(SelectSocialDependencies selectSocialDependencies) {
            this.a = selectSocialDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountInteractor get() {
            return (AccountInteractor) Preconditions.checkNotNullFromComponent(this.a.accountInteractor());
        }
    }

    public static class d implements Provider<Analytics> {
        public final SelectSocialDependencies a;

        public d(SelectSocialDependencies selectSocialDependencies) {
            this.a = selectSocialDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final SelectSocialDependencies a;

        public e(SelectSocialDependencies selectSocialDependencies) {
            this.a = selectSocialDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerSelectSocialComponent(SelectSocialDependencies selectSocialDependencies, Resources resources, Kundle kundle, List list, String str, a aVar) {
        this.a = selectSocialDependencies;
        this.b = InstanceFactory.create(list);
        this.c = new c(selectSocialDependencies);
        Factory create = InstanceFactory.create(resources);
        this.d = create;
        SelectSocialResourceProviderImpl_Factory create2 = SelectSocialResourceProviderImpl_Factory.create(create);
        this.e = create2;
        Provider<SelectSocialResourceProvider> provider = DoubleCheck.provider(create2);
        this.f = provider;
        SelectSocialInteractorImpl_Factory create3 = SelectSocialInteractorImpl_Factory.create(this.b, this.c, provider);
        this.g = create3;
        this.h = DoubleCheck.provider(create3);
        Provider<PublishRelay<SelectSocialField>> provider2 = DoubleCheck.provider(SelectSocialModule_ProvideFieldClickStreamFactory.create());
        this.i = provider2;
        SocialItemPresenterImpl_Factory create4 = SocialItemPresenterImpl_Factory.create(provider2);
        this.j = create4;
        Provider<SocialItemPresenter> provider3 = DoubleCheck.provider(create4);
        this.k = provider3;
        SocialItemBlueprintImpl_Factory create5 = SocialItemBlueprintImpl_Factory.create(provider3);
        this.l = create5;
        this.m = DoubleCheck.provider(create5);
        Provider<TextItemPresenter> provider4 = DoubleCheck.provider(TextItemPresenterImpl_Factory.create());
        this.n = provider4;
        TextItemBlueprintImpl_Factory create6 = TextItemBlueprintImpl_Factory.create(provider4);
        this.o = create6;
        Provider<TextItemBlueprint> provider5 = DoubleCheck.provider(create6);
        this.p = provider5;
        Provider<ItemBinder> provider6 = DoubleCheck.provider(SelectSocialModule_ProvideItemBinder$authorization_releaseFactory.create(this.m, provider5));
        this.q = provider6;
        this.r = DoubleCheck.provider(SelectSocialModule_ProvideAdapterPresenter$authorization_releaseFactory.create(provider6));
        this.s = new e(selectSocialDependencies);
        ErrorFormatterImpl_Factory create7 = ErrorFormatterImpl_Factory.create(this.d);
        this.t = create7;
        this.u = SingleCheck.provider(create7);
        this.v = new d(selectSocialDependencies);
        this.w = InstanceFactory.create(str);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.x = createNullable;
        SelectSocialPresenterImpl_Factory create8 = SelectSocialPresenterImpl_Factory.create(this.h, this.r, this.s, this.u, this.i, this.f, this.v, this.w, createNullable);
        this.y = create8;
        this.z = DoubleCheck.provider(create8);
    }

    public static SelectSocialComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.authorization.select_social.di.SelectSocialComponent
    public void inject(SelectSocialActivity selectSocialActivity) {
        SelectSocialActivity_MembersInjector.injectIntentFactory(selectSocialActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        SelectSocialActivity_MembersInjector.injectPresenter(selectSocialActivity, this.z.get());
        SelectSocialActivity_MembersInjector.injectAdapterPresenter(selectSocialActivity, this.r.get());
        SelectSocialActivity_MembersInjector.injectItemBinder(selectSocialActivity, this.q.get());
        SelectSocialActivity_MembersInjector.injectSocialTypeToStringMapper(selectSocialActivity, (SocialTypeToStringMapper) Preconditions.checkNotNullFromComponent(this.a.socialTypeToStringMapper()));
    }
}
