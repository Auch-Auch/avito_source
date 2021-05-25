package com.avito.android.select.di;

import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.AutoBrandModelTypoCorrectionTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.remote.SearchApi;
import com.avito.android.select.Arguments;
import com.avito.android.select.SelectDialog;
import com.avito.android.select.SelectDialogBlueprintProvider;
import com.avito.android.select.SelectDialogInteractor;
import com.avito.android.select.SelectDialogPresenter;
import com.avito.android.select.SelectDialogPresenterImpl;
import com.avito.android.select.SelectDialogPresenterImpl_Factory;
import com.avito.android.select.SelectDialogPresenterResourceProvider;
import com.avito.android.select.SelectDialogPresenterResourceProvider_Factory;
import com.avito.android.select.SelectDialog_MembersInjector;
import com.avito.android.select.VariantCheckableItemBlueprint;
import com.avito.android.select.VariantCheckableItemBlueprintImpl;
import com.avito.android.select.VariantCheckableItemBlueprintImpl_Factory;
import com.avito.android.select.VariantItemCheckBoxBlueprint;
import com.avito.android.select.VariantItemCheckBoxBlueprintImpl;
import com.avito.android.select.VariantItemCheckBoxBlueprintImpl_Factory;
import com.avito.android.select.VariantItemImageBlueprint;
import com.avito.android.select.VariantItemImageBlueprintImpl;
import com.avito.android.select.VariantItemImageBlueprintImpl_Factory;
import com.avito.android.select.VariantItemPresenter;
import com.avito.android.select.VariantItemPresenterImpl;
import com.avito.android.select.VariantItemPresenterImpl_Factory;
import com.avito.android.select.VariantItemRadioButtonBlueprint;
import com.avito.android.select.VariantItemRadioButtonBlueprintImpl;
import com.avito.android.select.VariantItemRadioButtonBlueprintImpl_Factory;
import com.avito.android.select.di.SelectDialogComponent;
import com.avito.android.select.title.TitleItemPresenter;
import com.avito.android.select.title.TitleItemPresenterImpl_Factory;
import com.avito.android.select.title.TitleItemViewBlueprint;
import com.avito.android.select.title.TitleItemViewBlueprintImpl;
import com.avito.android.select.title.TitleItemViewBlueprintImpl_Factory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerSelectDialogComponent implements SelectDialogComponent {
    public Provider<Bundle> A;
    public Provider<Set<ItemPresenter<?, ?>>> B;
    public Provider<Features> C;
    public Provider<SelectDialogPresenterImpl> D;
    public final SelectDialogDependencies a;
    public Provider<SearchApi> b;
    public Provider<Arguments> c;
    public Provider<SingleManuallyExposedAbTestGroup<AutoBrandModelTypoCorrectionTestGroup>> d;
    public Provider<SelectDialogInteractor> e;
    public Provider<SelectDialogPresenter> f;
    public Provider<VariantItemPresenterImpl> g;
    public Provider<VariantItemPresenter> h;
    public Provider<VariantItemRadioButtonBlueprintImpl> i;
    public Provider<VariantItemRadioButtonBlueprint> j;
    public Provider<VariantItemCheckBoxBlueprintImpl> k;
    public Provider<VariantItemCheckBoxBlueprint> l;
    public Provider<VariantCheckableItemBlueprintImpl> m;
    public Provider<VariantCheckableItemBlueprint> n;
    public Provider<VariantItemImageBlueprintImpl> o;
    public Provider<VariantItemImageBlueprint> p;
    public Provider<SelectDialogBlueprintProvider> q;
    public Provider<TitleItemPresenter> r;
    public Provider<TitleItemViewBlueprintImpl> s;
    public Provider<TitleItemViewBlueprint> t;
    public Provider<ItemBinder> u;
    public Provider<AdapterPresenter> v;
    public Provider<SchedulersFactory3> w;
    public Provider<Resources> x;
    public Provider<SelectDialogPresenterResourceProvider> y;
    public Provider<SelectDialogPresenter.ResourceProvider> z;

    public static final class b implements SelectDialogComponent.Builder {
        public SelectDialogDependencies a;
        public Bundle b;
        public Arguments c;
        public Resources d;

        public b(a aVar) {
        }

        @Override // com.avito.android.select.di.SelectDialogComponent.Builder
        public SelectDialogComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SelectDialogDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Arguments.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            return new DaggerSelectDialogComponent(this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.select.di.SelectDialogComponent.Builder
        public SelectDialogComponent.Builder dependentOn(SelectDialogDependencies selectDialogDependencies) {
            this.a = (SelectDialogDependencies) Preconditions.checkNotNull(selectDialogDependencies);
            return this;
        }

        @Override // com.avito.android.select.di.SelectDialogComponent.Builder
        public SelectDialogComponent.Builder withArguments(Arguments arguments) {
            this.c = (Arguments) Preconditions.checkNotNull(arguments);
            return this;
        }

        @Override // com.avito.android.select.di.SelectDialogComponent.Builder
        public SelectDialogComponent.Builder withPresenterState(Bundle bundle) {
            this.b = bundle;
            return this;
        }

        @Override // com.avito.android.select.di.SelectDialogComponent.Builder
        public SelectDialogComponent.Builder withResources(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<SingleManuallyExposedAbTestGroup<AutoBrandModelTypoCorrectionTestGroup>> {
        public final SelectDialogDependencies a;

        public c(SelectDialogDependencies selectDialogDependencies) {
            this.a = selectDialogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SingleManuallyExposedAbTestGroup<AutoBrandModelTypoCorrectionTestGroup> get() {
            return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.autoBrandModelTypoCorrectionTestGroup());
        }
    }

    public static class d implements Provider<Features> {
        public final SelectDialogDependencies a;

        public d(SelectDialogDependencies selectDialogDependencies) {
            this.a = selectDialogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class e implements Provider<SchedulersFactory3> {
        public final SelectDialogDependencies a;

        public e(SelectDialogDependencies selectDialogDependencies) {
            this.a = selectDialogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class f implements Provider<SearchApi> {
        public final SelectDialogDependencies a;

        public f(SelectDialogDependencies selectDialogDependencies) {
            this.a = selectDialogDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchApi get() {
            return (SearchApi) Preconditions.checkNotNullFromComponent(this.a.searchApi());
        }
    }

    public DaggerSelectDialogComponent(SelectDialogDependencies selectDialogDependencies, Bundle bundle, Arguments arguments, Resources resources, a aVar) {
        this.a = selectDialogDependencies;
        this.b = new f(selectDialogDependencies);
        Factory create = InstanceFactory.create(arguments);
        this.c = create;
        c cVar = new c(selectDialogDependencies);
        this.d = cVar;
        this.e = DoubleCheck.provider(SelectDialogModule_ProvideSelectDialogInteractor$select_releaseFactory.create(this.b, create, cVar));
        DelegateFactory delegateFactory = new DelegateFactory();
        this.f = delegateFactory;
        VariantItemPresenterImpl_Factory create2 = VariantItemPresenterImpl_Factory.create(delegateFactory);
        this.g = create2;
        Provider<VariantItemPresenter> provider = DoubleCheck.provider(create2);
        this.h = provider;
        VariantItemRadioButtonBlueprintImpl_Factory create3 = VariantItemRadioButtonBlueprintImpl_Factory.create(provider);
        this.i = create3;
        this.j = DoubleCheck.provider(create3);
        VariantItemCheckBoxBlueprintImpl_Factory create4 = VariantItemCheckBoxBlueprintImpl_Factory.create(this.h);
        this.k = create4;
        this.l = DoubleCheck.provider(create4);
        VariantCheckableItemBlueprintImpl_Factory create5 = VariantCheckableItemBlueprintImpl_Factory.create(this.h);
        this.m = create5;
        this.n = DoubleCheck.provider(create5);
        VariantItemImageBlueprintImpl_Factory create6 = VariantItemImageBlueprintImpl_Factory.create(this.h);
        this.o = create6;
        Provider<VariantItemImageBlueprint> provider2 = DoubleCheck.provider(create6);
        this.p = provider2;
        this.q = DoubleCheck.provider(SelectDialogModule_ProvideSelectDialogBlueprintProvider$select_releaseFactory.create(this.j, this.l, this.n, provider2, this.c));
        Provider<TitleItemPresenter> provider3 = DoubleCheck.provider(TitleItemPresenterImpl_Factory.create());
        this.r = provider3;
        TitleItemViewBlueprintImpl_Factory create7 = TitleItemViewBlueprintImpl_Factory.create(provider3);
        this.s = create7;
        Provider<TitleItemViewBlueprint> provider4 = DoubleCheck.provider(create7);
        this.t = provider4;
        Provider<ItemBinder> provider5 = DoubleCheck.provider(SelectDialogModule_ProvideItemBinder$select_releaseFactory.create(this.q, provider4));
        this.u = provider5;
        this.v = DoubleCheck.provider(SelectDialogModule_ProvideAdapterPresenter$select_releaseFactory.create(provider5));
        this.w = new e(selectDialogDependencies);
        Factory create8 = InstanceFactory.create(resources);
        this.x = create8;
        SelectDialogPresenterResourceProvider_Factory create9 = SelectDialogPresenterResourceProvider_Factory.create(create8);
        this.y = create9;
        this.z = DoubleCheck.provider(create9);
        this.A = InstanceFactory.createNullable(bundle);
        Provider<Set<ItemPresenter<?, ?>>> provider6 = DoubleCheck.provider(SelectDialogModule_ProvideItemPresentersSet$select_releaseFactory.create());
        this.B = provider6;
        d dVar = new d(selectDialogDependencies);
        this.C = dVar;
        SelectDialogPresenterImpl_Factory create10 = SelectDialogPresenterImpl_Factory.create(this.e, this.v, this.w, this.z, this.c, this.A, provider6, dVar);
        this.D = create10;
        DelegateFactory.setDelegate(this.f, DoubleCheck.provider(create10));
    }

    public static SelectDialogComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.select.di.SelectDialogComponent
    public void inject(SelectDialog selectDialog) {
        SelectDialog_MembersInjector.injectInteractor(selectDialog, this.e.get());
        SelectDialog_MembersInjector.injectPresenter(selectDialog, this.f.get());
        SelectDialog_MembersInjector.injectItemBinder(selectDialog, this.u.get());
        SelectDialog_MembersInjector.injectAdapterPresenter(selectDialog, this.v.get());
        SelectDialog_MembersInjector.injectFilterWithPhotosGroup(selectDialog, (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.autoGenerationsFilterWithPhotosTestGroup()));
    }
}
