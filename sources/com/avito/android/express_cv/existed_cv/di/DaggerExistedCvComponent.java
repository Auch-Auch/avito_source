package com.avito.android.express_cv.existed_cv.di;

import com.avito.android.blueprints.ButtonItemBlueprint;
import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.express_cv.ExistedCvDataProvider;
import com.avito.android.express_cv.existed_cv.ExistedCvFragment;
import com.avito.android.express_cv.existed_cv.ExistedCvFragment_MembersInjector;
import com.avito.android.express_cv.existed_cv.di.ExistedCvComponent;
import com.avito.android.express_cv.existed_cv.item.CvItemClickListener;
import com.avito.android.express_cv.existed_cv.item.DisclaimerBlueprint;
import com.avito.android.express_cv.existed_cv.item.ExistedCvItemBlueprint;
import com.avito.android.express_cv.existed_cv.item.ExistedCvItemPresenter;
import com.avito.android.express_cv.existed_cv.item.FlatButtonBlueprint;
import com.avito.android.express_cv.existed_cv.item.TextItemBlueprint;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerExistedCvComponent implements ExistedCvComponent {
    public final ExistedCvComponentDependencies a;
    public Provider<TextItemBlueprint> b;
    public Provider<CvItemClickListener> c;
    public Provider<ExistedCvItemPresenter> d;
    public Provider<ExistedCvItemBlueprint> e;
    public Provider<ButtonItemPresenter.Listener> f;
    public Provider<ButtonItemPresenter> g;
    public Provider<ButtonItemBlueprint> h;
    public Provider<DisclaimerBlueprint> i;
    public Provider<FlatButtonBlueprint> j;
    public Provider<ItemBinder> k;
    public Provider<AdapterPresenter> l;

    public static final class b implements ExistedCvComponent.Builder {
        public ExistedCvModule a;
        public ExistedCvComponentDependencies b;

        public b(a aVar) {
        }

        @Override // com.avito.android.express_cv.existed_cv.di.ExistedCvComponent.Builder
        public ExistedCvComponent build() {
            if (this.a == null) {
                this.a = new ExistedCvModule();
            }
            Preconditions.checkBuilderRequirement(this.b, ExistedCvComponentDependencies.class);
            return new DaggerExistedCvComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.express_cv.existed_cv.di.ExistedCvComponent.Builder
        public ExistedCvComponent.Builder dependencies(ExistedCvComponentDependencies existedCvComponentDependencies) {
            this.b = (ExistedCvComponentDependencies) Preconditions.checkNotNull(existedCvComponentDependencies);
            return this;
        }

        @Override // com.avito.android.express_cv.existed_cv.di.ExistedCvComponent.Builder
        public ExistedCvComponent.Builder existedCvModule(ExistedCvModule existedCvModule) {
            this.a = (ExistedCvModule) Preconditions.checkNotNull(existedCvModule);
            return this;
        }
    }

    public static class c implements Provider<ButtonItemPresenter.Listener> {
        public final ExistedCvComponentDependencies a;

        public c(ExistedCvComponentDependencies existedCvComponentDependencies) {
            this.a = existedCvComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ButtonItemPresenter.Listener get() {
            return (ButtonItemPresenter.Listener) Preconditions.checkNotNullFromComponent(this.a.buttonItemPresenterListener());
        }
    }

    public static class d implements Provider<CvItemClickListener> {
        public final ExistedCvComponentDependencies a;

        public d(ExistedCvComponentDependencies existedCvComponentDependencies) {
            this.a = existedCvComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CvItemClickListener get() {
            return (CvItemClickListener) Preconditions.checkNotNullFromComponent(this.a.cvItemClickListener());
        }
    }

    public static class e implements Provider<DisclaimerBlueprint> {
        public final ExistedCvComponentDependencies a;

        public e(ExistedCvComponentDependencies existedCvComponentDependencies) {
            this.a = existedCvComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DisclaimerBlueprint get() {
            return (DisclaimerBlueprint) Preconditions.checkNotNullFromComponent(this.a.disclaimerBlueprint());
        }
    }

    public static class f implements Provider<FlatButtonBlueprint> {
        public final ExistedCvComponentDependencies a;

        public f(ExistedCvComponentDependencies existedCvComponentDependencies) {
            this.a = existedCvComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FlatButtonBlueprint get() {
            return (FlatButtonBlueprint) Preconditions.checkNotNullFromComponent(this.a.flatButtonBlueprint());
        }
    }

    public static class g implements Provider<TextItemBlueprint> {
        public final ExistedCvComponentDependencies a;

        public g(ExistedCvComponentDependencies existedCvComponentDependencies) {
            this.a = existedCvComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TextItemBlueprint get() {
            return (TextItemBlueprint) Preconditions.checkNotNullFromComponent(this.a.textItemBlueprint());
        }
    }

    public DaggerExistedCvComponent(ExistedCvModule existedCvModule, ExistedCvComponentDependencies existedCvComponentDependencies, a aVar) {
        this.a = existedCvComponentDependencies;
        this.b = new g(existedCvComponentDependencies);
        d dVar = new d(existedCvComponentDependencies);
        this.c = dVar;
        Provider<ExistedCvItemPresenter> provider = DoubleCheck.provider(ExistedCvModule_ProvideExistedCvItemPresenter$express_cv_releaseFactory.create(existedCvModule, dVar));
        this.d = provider;
        this.e = DoubleCheck.provider(ExistedCvModule_ProvideExistedCvBlueprint$express_cv_releaseFactory.create(existedCvModule, provider));
        c cVar = new c(existedCvComponentDependencies);
        this.f = cVar;
        Provider<ButtonItemPresenter> provider2 = DoubleCheck.provider(ExistedCvModule_ProvideButtonItemPresenterFactory.create(existedCvModule, cVar));
        this.g = provider2;
        Provider<ButtonItemBlueprint> provider3 = DoubleCheck.provider(ExistedCvModule_ProvideButtonBlueprintFactory.create(existedCvModule, provider2));
        this.h = provider3;
        e eVar = new e(existedCvComponentDependencies);
        this.i = eVar;
        f fVar = new f(existedCvComponentDependencies);
        this.j = fVar;
        Provider<ItemBinder> provider4 = DoubleCheck.provider(ExistedCvModule_ProvideExistedCvItemBinder$express_cv_releaseFactory.create(existedCvModule, this.b, this.e, provider3, eVar, fVar));
        this.k = provider4;
        this.l = DoubleCheck.provider(ExistedCvModule_ProvideSimpleAdapter$express_cv_releaseFactory.create(existedCvModule, provider4));
    }

    public static ExistedCvComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.express_cv.existed_cv.di.ExistedCvComponent
    public void inject(ExistedCvFragment existedCvFragment) {
        ExistedCvFragment_MembersInjector.injectViewModel(existedCvFragment, (ExistedCvDataProvider) Preconditions.checkNotNullFromComponent(this.a.existedCvDataProvider()));
        ExistedCvFragment_MembersInjector.injectItemBinder(existedCvFragment, this.k.get());
        ExistedCvFragment_MembersInjector.injectDeviceMetrics(existedCvFragment, (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics()));
        ExistedCvFragment_MembersInjector.injectAdapterPresenter(existedCvFragment, this.l.get());
    }
}
