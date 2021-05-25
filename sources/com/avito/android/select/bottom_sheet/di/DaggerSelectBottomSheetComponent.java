package com.avito.android.select.bottom_sheet.di;

import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.AutoBrandModelTypoCorrectionTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.remote.SearchApi;
import com.avito.android.select.Arguments;
import com.avito.android.select.SelectDialogInteractor;
import com.avito.android.select.SelectDialogPresenter;
import com.avito.android.select.SelectDialogPresenterImpl;
import com.avito.android.select.SelectDialogPresenterImpl_Factory;
import com.avito.android.select.SelectDialogPresenterResourceProvider;
import com.avito.android.select.SelectDialogPresenterResourceProvider_Factory;
import com.avito.android.select.bottom_sheet.SelectBottomSheetFragment;
import com.avito.android.select.bottom_sheet.SelectBottomSheetFragment_MembersInjector;
import com.avito.android.select.bottom_sheet.blueprints.CheckableImageItemBlueprint;
import com.avito.android.select.bottom_sheet.blueprints.CheckableImageItemBlueprintImpl;
import com.avito.android.select.bottom_sheet.blueprints.CheckableImageItemBlueprintImpl_Factory;
import com.avito.android.select.bottom_sheet.blueprints.CheckableItemBlueprint;
import com.avito.android.select.bottom_sheet.blueprints.CheckableItemBlueprintImpl;
import com.avito.android.select.bottom_sheet.blueprints.CheckableItemBlueprintImpl_Factory;
import com.avito.android.select.bottom_sheet.blueprints.CheckableItemPresenter;
import com.avito.android.select.bottom_sheet.blueprints.CheckableItemPresenterImpl_Factory;
import com.avito.android.select.bottom_sheet.di.SelectBottomSheetComponent;
import com.avito.android.select.di.SelectDialogDependencies;
import com.avito.android.select.title.TitleItemPresenter;
import com.avito.android.select.title.TitleItemPresenterImpl_Factory;
import com.avito.android.select.title.TitleItemViewBlueprint;
import com.avito.android.select.title.TitleItemViewBlueprintImpl;
import com.avito.android.select.title.TitleItemViewBlueprintImpl_Factory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerSelectBottomSheetComponent implements SelectBottomSheetComponent {
    public final SelectDialogDependencies a;
    public Provider<TitleItemPresenter> b;
    public Provider<TitleItemViewBlueprintImpl> c;
    public Provider<TitleItemViewBlueprint> d;
    public Provider<CheckableItemPresenter> e;
    public Provider<CheckableImageItemBlueprintImpl> f;
    public Provider<CheckableImageItemBlueprint> g;
    public Provider<CheckableItemBlueprintImpl> h;
    public Provider<CheckableItemBlueprint> i;
    public Provider<Arguments> j;
    public Provider<ItemBinder> k;
    public Provider<AdapterPresenter> l;
    public Provider<SearchApi> m;
    public Provider<SingleManuallyExposedAbTestGroup<AutoBrandModelTypoCorrectionTestGroup>> n;
    public Provider<SelectDialogInteractor> o;
    public Provider<SchedulersFactory3> p;
    public Provider<Resources> q;
    public Provider<SelectDialogPresenterResourceProvider> r;
    public Provider<SelectDialogPresenter.ResourceProvider> s;
    public Provider<Bundle> t;
    public Provider<Set<ItemPresenter<?, ?>>> u;
    public Provider<Features> v;
    public Provider<SelectDialogPresenterImpl> w;
    public Provider<SelectDialogPresenter> x;

    public static final class b implements SelectBottomSheetComponent.Builder {
        public SelectDialogDependencies a;
        public Bundle b;
        public Arguments c;
        public Resources d;

        public b(a aVar) {
        }

        @Override // com.avito.android.select.bottom_sheet.di.SelectBottomSheetComponent.Builder
        public SelectBottomSheetComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SelectDialogDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Arguments.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            return new DaggerSelectBottomSheetComponent(this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.select.bottom_sheet.di.SelectBottomSheetComponent.Builder
        public SelectBottomSheetComponent.Builder dependentOn(SelectDialogDependencies selectDialogDependencies) {
            this.a = (SelectDialogDependencies) Preconditions.checkNotNull(selectDialogDependencies);
            return this;
        }

        @Override // com.avito.android.select.bottom_sheet.di.SelectBottomSheetComponent.Builder
        public SelectBottomSheetComponent.Builder withArguments(Arguments arguments) {
            this.c = (Arguments) Preconditions.checkNotNull(arguments);
            return this;
        }

        @Override // com.avito.android.select.bottom_sheet.di.SelectBottomSheetComponent.Builder
        public SelectBottomSheetComponent.Builder withPresenterState(Bundle bundle) {
            this.b = bundle;
            return this;
        }

        @Override // com.avito.android.select.bottom_sheet.di.SelectBottomSheetComponent.Builder
        public SelectBottomSheetComponent.Builder withResources(Resources resources) {
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

    public DaggerSelectBottomSheetComponent(SelectDialogDependencies selectDialogDependencies, Bundle bundle, Arguments arguments, Resources resources, a aVar) {
        this.a = selectDialogDependencies;
        Provider<TitleItemPresenter> provider = DoubleCheck.provider(TitleItemPresenterImpl_Factory.create());
        this.b = provider;
        TitleItemViewBlueprintImpl_Factory create = TitleItemViewBlueprintImpl_Factory.create(provider);
        this.c = create;
        this.d = DoubleCheck.provider(create);
        Provider<CheckableItemPresenter> provider2 = DoubleCheck.provider(CheckableItemPresenterImpl_Factory.create());
        this.e = provider2;
        CheckableImageItemBlueprintImpl_Factory create2 = CheckableImageItemBlueprintImpl_Factory.create(provider2);
        this.f = create2;
        this.g = DoubleCheck.provider(create2);
        CheckableItemBlueprintImpl_Factory create3 = CheckableItemBlueprintImpl_Factory.create(this.e);
        this.h = create3;
        this.i = DoubleCheck.provider(create3);
        Factory create4 = InstanceFactory.create(arguments);
        this.j = create4;
        Provider<ItemBinder> provider3 = DoubleCheck.provider(SelectBottomSheetModule_ProvideItemBinder$select_releaseFactory.create(this.d, this.g, this.i, create4));
        this.k = provider3;
        this.l = DoubleCheck.provider(SelectBottomSheetModule_ProvideAdapterPresenter$select_releaseFactory.create(provider3));
        f fVar = new f(selectDialogDependencies);
        this.m = fVar;
        c cVar = new c(selectDialogDependencies);
        this.n = cVar;
        this.o = DoubleCheck.provider(SelectBottomSheetModule_ProvideSelectDialogInteractor$select_releaseFactory.create(fVar, this.j, cVar));
        this.p = new e(selectDialogDependencies);
        Factory create5 = InstanceFactory.create(resources);
        this.q = create5;
        SelectDialogPresenterResourceProvider_Factory create6 = SelectDialogPresenterResourceProvider_Factory.create(create5);
        this.r = create6;
        this.s = DoubleCheck.provider(create6);
        this.t = InstanceFactory.createNullable(bundle);
        Provider<Set<ItemPresenter<?, ?>>> provider4 = DoubleCheck.provider(SelectBottomSheetModule_ProvideItemPresentersSet$select_releaseFactory.create(this.e));
        this.u = provider4;
        d dVar = new d(selectDialogDependencies);
        this.v = dVar;
        SelectDialogPresenterImpl_Factory create7 = SelectDialogPresenterImpl_Factory.create(this.o, this.l, this.p, this.s, this.j, this.t, provider4, dVar);
        this.w = create7;
        this.x = DoubleCheck.provider(create7);
    }

    public static SelectBottomSheetComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.select.bottom_sheet.di.SelectBottomSheetComponent
    public void inject(SelectBottomSheetFragment selectBottomSheetFragment) {
        SelectBottomSheetFragment_MembersInjector.injectAdapterPresenter(selectBottomSheetFragment, this.l.get());
        SelectBottomSheetFragment_MembersInjector.injectItemBinder(selectBottomSheetFragment, this.k.get());
        SelectBottomSheetFragment_MembersInjector.injectPresenter(selectBottomSheetFragment, this.x.get());
        SelectBottomSheetFragment_MembersInjector.injectFilterWithPhotosGroup(selectBottomSheetFragment, (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.autoGenerationsFilterWithPhotosTestGroup()));
    }
}
