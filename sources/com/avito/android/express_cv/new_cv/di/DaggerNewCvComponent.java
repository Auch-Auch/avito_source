package com.avito.android.express_cv.new_cv.di;

import android.text.TextWatcher;
import com.avito.android.blueprints.ButtonItemBlueprint;
import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.blueprints.InputItemBlueprint;
import com.avito.android.blueprints.InputItemPresenter;
import com.avito.android.blueprints.publish.PrimaryParametersListener;
import com.avito.android.blueprints.publish.SelectItemBlueprint;
import com.avito.android.blueprints.publish.SelectItemPresenter;
import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItemBlueprint;
import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItemPresenter;
import com.avito.android.di.module.InputItemFormatterProviderModule_ProvideInputItemFormatter$formatters_provider_releaseFactory;
import com.avito.android.express_cv.NewCvDataProvider;
import com.avito.android.express_cv.existed_cv.item.DisclaimerBlueprint;
import com.avito.android.express_cv.existed_cv.item.FlatButtonBlueprint;
import com.avito.android.express_cv.existed_cv.item.TextItemBlueprint;
import com.avito.android.express_cv.new_cv.NewCvFragment;
import com.avito.android.express_cv.new_cv.NewCvFragment_MembersInjector;
import com.avito.android.express_cv.new_cv.di.NewCvComponent;
import com.avito.android.provider.InputItemFormatterProvider;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterTextWatcherWithCountryCodeFactory;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerNewCvComponent implements NewCvComponent {
    public final NewCvComponentDependencies a;
    public Provider<TextItemBlueprint> b;
    public Provider<SelectItemPresenter.ClickListener> c;
    public Provider<SelectItemPresenter> d;
    public Provider<SelectItemBlueprint> e;
    public Provider<PrimaryParametersListener> f;
    public Provider<TextWatcher> g = PhoneNumberFormatterModule_ProvidePhoneNumberFormatterTextWatcherWithCountryCodeFactory.create(PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create());
    public Provider<InputItemFormatterProvider> h;
    public Provider<InputItemPresenter> i;
    public Provider<InputItemBlueprint> j;
    public Provider<ButtonItemPresenter.Listener> k;
    public Provider<ButtonItemPresenter> l;
    public Provider<ButtonItemBlueprint> m;
    public Provider<PhoneInputItemPresenter> n;
    public Provider<PhoneInputItemBlueprint> o;
    public Provider<DisclaimerBlueprint> p;
    public Provider<FlatButtonBlueprint> q;
    public Provider<ItemBinder> r;
    public Provider<AdapterPresenter> s;

    public static final class b implements NewCvComponent.Builder {
        public NewCvModule a;
        public NewCvComponentDependencies b;

        public b(a aVar) {
        }

        @Override // com.avito.android.express_cv.new_cv.di.NewCvComponent.Builder
        public NewCvComponent build() {
            Preconditions.checkBuilderRequirement(this.a, NewCvModule.class);
            Preconditions.checkBuilderRequirement(this.b, NewCvComponentDependencies.class);
            return new DaggerNewCvComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.express_cv.new_cv.di.NewCvComponent.Builder
        public NewCvComponent.Builder dependencies(NewCvComponentDependencies newCvComponentDependencies) {
            this.b = (NewCvComponentDependencies) Preconditions.checkNotNull(newCvComponentDependencies);
            return this;
        }

        @Override // com.avito.android.express_cv.new_cv.di.NewCvComponent.Builder
        public NewCvComponent.Builder newCvModule(NewCvModule newCvModule) {
            this.a = (NewCvModule) Preconditions.checkNotNull(newCvModule);
            return this;
        }
    }

    public static class c implements Provider<ButtonItemPresenter.Listener> {
        public final NewCvComponentDependencies a;

        public c(NewCvComponentDependencies newCvComponentDependencies) {
            this.a = newCvComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ButtonItemPresenter.Listener get() {
            return (ButtonItemPresenter.Listener) Preconditions.checkNotNullFromComponent(this.a.buttonItemPresenterListener());
        }
    }

    public static class d implements Provider<DisclaimerBlueprint> {
        public final NewCvComponentDependencies a;

        public d(NewCvComponentDependencies newCvComponentDependencies) {
            this.a = newCvComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DisclaimerBlueprint get() {
            return (DisclaimerBlueprint) Preconditions.checkNotNullFromComponent(this.a.disclaimerBlueprint());
        }
    }

    public static class e implements Provider<FlatButtonBlueprint> {
        public final NewCvComponentDependencies a;

        public e(NewCvComponentDependencies newCvComponentDependencies) {
            this.a = newCvComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FlatButtonBlueprint get() {
            return (FlatButtonBlueprint) Preconditions.checkNotNullFromComponent(this.a.flatButtonBlueprint());
        }
    }

    public static class f implements Provider<PrimaryParametersListener> {
        public final NewCvComponentDependencies a;

        public f(NewCvComponentDependencies newCvComponentDependencies) {
            this.a = newCvComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PrimaryParametersListener get() {
            return (PrimaryParametersListener) Preconditions.checkNotNullFromComponent(this.a.primaryParametersListener());
        }
    }

    public static class g implements Provider<SelectItemPresenter.ClickListener> {
        public final NewCvComponentDependencies a;

        public g(NewCvComponentDependencies newCvComponentDependencies) {
            this.a = newCvComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SelectItemPresenter.ClickListener get() {
            return (SelectItemPresenter.ClickListener) Preconditions.checkNotNullFromComponent(this.a.selectItemPresenter());
        }
    }

    public static class h implements Provider<TextItemBlueprint> {
        public final NewCvComponentDependencies a;

        public h(NewCvComponentDependencies newCvComponentDependencies) {
            this.a = newCvComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TextItemBlueprint get() {
            return (TextItemBlueprint) Preconditions.checkNotNullFromComponent(this.a.textItemBlueprint());
        }
    }

    public DaggerNewCvComponent(NewCvModule newCvModule, NewCvComponentDependencies newCvComponentDependencies, a aVar) {
        this.a = newCvComponentDependencies;
        this.b = new h(newCvComponentDependencies);
        g gVar = new g(newCvComponentDependencies);
        this.c = gVar;
        Provider<SelectItemPresenter> provider = DoubleCheck.provider(NewCvModule_SelectItemPresenterFactory.create(newCvModule, gVar));
        this.d = provider;
        this.e = DoubleCheck.provider(NewCvModule_LocationSelectItemBluePrintFactory.create(newCvModule, provider));
        this.f = new f(newCvComponentDependencies);
        Provider<InputItemFormatterProvider> provider2 = SingleCheck.provider(InputItemFormatterProviderModule_ProvideInputItemFormatter$formatters_provider_releaseFactory.create());
        this.h = provider2;
        Provider<InputItemPresenter> provider3 = DoubleCheck.provider(NewCvModule_ProvideInputItemPresenterFactory.create(newCvModule, this.f, this.g, provider2));
        this.i = provider3;
        this.j = DoubleCheck.provider(NewCvModule_ProvideInputItemBluePrintFactory.create(newCvModule, provider3));
        c cVar = new c(newCvComponentDependencies);
        this.k = cVar;
        Provider<ButtonItemPresenter> provider4 = DoubleCheck.provider(NewCvModule_ProvideButtonItemPresenterFactory.create(newCvModule, cVar));
        this.l = provider4;
        this.m = DoubleCheck.provider(NewCvModule_ProvideButtonBlueprintFactory.create(newCvModule, provider4));
        Provider<PhoneInputItemPresenter> provider5 = DoubleCheck.provider(NewCvModule_ProvidePhoneInputItemPresenter$express_cv_releaseFactory.create(newCvModule));
        this.n = provider5;
        Provider<PhoneInputItemBlueprint> provider6 = DoubleCheck.provider(NewCvModule_ProvidePhoneInputItemBlueprint$express_cv_releaseFactory.create(newCvModule, provider5));
        this.o = provider6;
        d dVar = new d(newCvComponentDependencies);
        this.p = dVar;
        e eVar = new e(newCvComponentDependencies);
        this.q = eVar;
        Provider<ItemBinder> provider7 = DoubleCheck.provider(NewCvModule_ProvideNewCvItemBinder$express_cv_releaseFactory.create(newCvModule, this.b, this.e, this.j, this.m, provider6, dVar, eVar));
        this.r = provider7;
        this.s = DoubleCheck.provider(NewCvModule_ProvideSimpleAdapter$express_cv_releaseFactory.create(newCvModule, provider7));
    }

    public static NewCvComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.express_cv.new_cv.di.NewCvComponent
    public void inject(NewCvFragment newCvFragment) {
        NewCvFragment_MembersInjector.injectViewModel(newCvFragment, (NewCvDataProvider) Preconditions.checkNotNullFromComponent(this.a.newCvDataProvider()));
        NewCvFragment_MembersInjector.injectItemBinder(newCvFragment, this.r.get());
        NewCvFragment_MembersInjector.injectAdapterPresenter(newCvFragment, this.s.get());
        NewCvFragment_MembersInjector.injectDeviceMetrics(newCvFragment, (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics()));
    }
}
