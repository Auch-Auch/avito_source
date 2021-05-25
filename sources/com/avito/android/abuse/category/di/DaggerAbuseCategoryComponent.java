package com.avito.android.abuse.category.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.abuse.category.AbuseCategoryActivity;
import com.avito.android.abuse.category.AbuseCategoryActivity_MembersInjector;
import com.avito.android.abuse.category.AbuseCategoryInteractor;
import com.avito.android.abuse.category.AbuseCategoryInteractorImpl;
import com.avito.android.abuse.category.AbuseCategoryInteractorImpl_Factory;
import com.avito.android.abuse.category.AbuseCategoryPresenter;
import com.avito.android.abuse.category.AbuseCategoryPresenterImpl;
import com.avito.android.abuse.category.AbuseCategoryPresenterImpl_Factory;
import com.avito.android.abuse.category.di.AbuseCategoryComponent;
import com.avito.android.abuse.category.item.AbuseCategoryItemBlueprint;
import com.avito.android.abuse.category.item.AbuseCategoryItemBlueprint_Factory;
import com.avito.android.abuse.category.item.AbuseCategoryItemPresenter;
import com.avito.android.abuse.category.item.AbuseCategoryItemPresenterImpl;
import com.avito.android.abuse.category.item.AbuseCategoryItemPresenterImpl_Factory;
import com.avito.android.abuse.details.remote.AbuseApi;
import com.avito.android.analytics.Analytics;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerAbuseCategoryComponent implements AbuseCategoryComponent {
    public final AbuseCategoryDependencies a;
    public Provider<String> b;
    public Provider<AbuseApi> c;
    public Provider<SchedulersFactory3> d;
    public Provider<AbuseCategoryInteractorImpl> e;
    public Provider<AbuseCategoryInteractor> f;
    public Provider<Set<ItemBlueprint<?, ?>>> g = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<AbuseCategoryPresenter> h;
    public Provider<AbuseCategoryItemPresenterImpl> i;
    public Provider<AbuseCategoryItemPresenter> j;
    public Provider<AbuseCategoryItemBlueprint> k;
    public Provider<ItemBlueprint<?, ?>> l;
    public Provider<Set<ItemBlueprint<?, ?>>> m;
    public Provider<ItemBinder> n;
    public Provider<AdapterPresenter> o;
    public Provider<Resources> p;
    public Provider<ErrorFormatter> q;
    public Provider<Kundle> r;
    public Provider<AbuseCategoryPresenterImpl> s;
    public Provider<SimpleRecyclerAdapter> t;

    public static final class b implements AbuseCategoryComponent.Builder {
        public AbuseCategoryDependencies a;
        public String b;
        public Resources c;
        public Kundle d;

        public b(a aVar) {
        }

        @Override // com.avito.android.abuse.category.di.AbuseCategoryComponent.Builder
        public AbuseCategoryComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AbuseCategoryDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            return new DaggerAbuseCategoryComponent(this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.abuse.category.di.AbuseCategoryComponent.Builder
        public AbuseCategoryComponent.Builder dependentOn(AbuseCategoryDependencies abuseCategoryDependencies) {
            this.a = (AbuseCategoryDependencies) Preconditions.checkNotNull(abuseCategoryDependencies);
            return this;
        }

        @Override // com.avito.android.abuse.category.di.AbuseCategoryComponent.Builder
        public AbuseCategoryComponent.Builder with(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.abuse.category.di.AbuseCategoryComponent.Builder
        public AbuseCategoryComponent.Builder with(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.abuse.category.di.AbuseCategoryComponent.Builder
        public AbuseCategoryComponent.Builder with(Kundle kundle) {
            this.d = kundle;
            return this;
        }
    }

    public static class c implements Provider<AbuseApi> {
        public final AbuseCategoryDependencies a;

        public c(AbuseCategoryDependencies abuseCategoryDependencies) {
            this.a = abuseCategoryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AbuseApi get() {
            return (AbuseApi) Preconditions.checkNotNullFromComponent(this.a.api());
        }
    }

    public static class d implements Provider<SchedulersFactory3> {
        public final AbuseCategoryDependencies a;

        public d(AbuseCategoryDependencies abuseCategoryDependencies) {
            this.a = abuseCategoryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerAbuseCategoryComponent(AbuseCategoryDependencies abuseCategoryDependencies, String str, Resources resources, Kundle kundle, a aVar) {
        this.a = abuseCategoryDependencies;
        this.b = InstanceFactory.create(str);
        c cVar = new c(abuseCategoryDependencies);
        this.c = cVar;
        d dVar = new d(abuseCategoryDependencies);
        this.d = dVar;
        AbuseCategoryInteractorImpl_Factory create = AbuseCategoryInteractorImpl_Factory.create(cVar, dVar);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        DelegateFactory delegateFactory = new DelegateFactory();
        this.h = delegateFactory;
        AbuseCategoryItemPresenterImpl_Factory create2 = AbuseCategoryItemPresenterImpl_Factory.create(delegateFactory);
        this.i = create2;
        Provider<AbuseCategoryItemPresenter> provider = DoubleCheck.provider(create2);
        this.j = provider;
        AbuseCategoryItemBlueprint_Factory create3 = AbuseCategoryItemBlueprint_Factory.create(provider);
        this.k = create3;
        this.l = DoubleCheck.provider(create3);
        SetFactory build = SetFactory.builder(1, 1).addCollectionProvider(this.g).addProvider(this.l).build();
        this.m = build;
        Provider<ItemBinder> provider2 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.n = provider2;
        this.o = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider2));
        Factory create4 = InstanceFactory.create(resources);
        this.p = create4;
        this.q = DoubleCheck.provider(AbuseCategoryModule_ProvideErrorFormatter$abuse_releaseFactory.create(create4));
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.r = createNullable;
        AbuseCategoryPresenterImpl_Factory create5 = AbuseCategoryPresenterImpl_Factory.create(this.b, this.f, this.o, this.d, this.q, createNullable);
        this.s = create5;
        DelegateFactory.setDelegate(this.h, DoubleCheck.provider(create5));
        this.t = DoubleCheck.provider(AbuseCategoryModule_ProvideRecyclerAdapterFactory.create(this.o, this.n));
    }

    public static AbuseCategoryComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.abuse.category.di.AbuseCategoryComponent
    public void inject(AbuseCategoryActivity abuseCategoryActivity) {
        AbuseCategoryActivity_MembersInjector.injectPresenter(abuseCategoryActivity, this.h.get());
        AbuseCategoryActivity_MembersInjector.injectInteractor(abuseCategoryActivity, this.f.get());
        AbuseCategoryActivity_MembersInjector.injectRecyclerAdapter(abuseCategoryActivity, this.t.get());
        AbuseCategoryActivity_MembersInjector.injectAnalytics(abuseCategoryActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        AbuseCategoryActivity_MembersInjector.injectFeatures(abuseCategoryActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        AbuseCategoryActivity_MembersInjector.injectIntentFactory(abuseCategoryActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}
