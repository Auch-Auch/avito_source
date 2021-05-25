package com.avito.android.publish.category_suggest.di;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsFragment;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsFragment_MembersInjector;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsInteractor;
import com.avito.android.publish.category_suggest.CategoriesSuggestionsViewModelFactory;
import com.avito.android.publish.category_suggest.di.CategoriesSuggestionsComponent;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.drafts.PublishDraftDataHolder;
import com.avito.android.publish.select.blueprints.CheckableItemBlueprint;
import com.avito.android.publish.select.blueprints.CheckableItemPresenter;
import com.avito.android.publish.wizard.blueprint.WizardItemBlueprint;
import com.avito.android.publish.wizard.blueprint.WizardItemPresenter;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerCategoriesSuggestionsComponent implements CategoriesSuggestionsComponent {
    public final PublishComponent a;
    public Provider<SchedulersFactory> b;
    public Provider<PublishApi> c;
    public Provider<PublishAnalyticsDataProvider> d;
    public Provider<CategoryParametersConverter> e;
    public Provider<Features> f;
    public Provider<CategoriesSuggestionsInteractor> g;
    public Provider<PublishEventTracker> h;
    public Provider<CategoriesSuggestionsViewModelFactory> i;
    public Provider<WizardItemPresenter> j;
    public Provider<WizardItemBlueprint> k;
    public Provider<CheckableItemPresenter> l;
    public Provider<CheckableItemBlueprint> m;
    public Provider<ItemBinder> n;
    public Provider<AdapterPresenter> o;
    public Provider<RecyclerView.Adapter<?>> p;
    public Provider<Set<ItemPresenter<?, ?>>> q;

    public static final class b implements CategoriesSuggestionsComponent.Builder {
        public PublishComponent a;
        public CategoriesSuggestionsModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.category_suggest.di.CategoriesSuggestionsComponent.Builder
        public CategoriesSuggestionsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PublishComponent.class);
            if (this.b == null) {
                this.b = new CategoriesSuggestionsModule();
            }
            return new DaggerCategoriesSuggestionsComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.publish.category_suggest.di.CategoriesSuggestionsComponent.Builder
        public CategoriesSuggestionsComponent.Builder categoriesSuggestionsModule(CategoriesSuggestionsModule categoriesSuggestionsModule) {
            this.b = (CategoriesSuggestionsModule) Preconditions.checkNotNull(categoriesSuggestionsModule);
            return this;
        }

        @Override // com.avito.android.publish.category_suggest.di.CategoriesSuggestionsComponent.Builder
        public CategoriesSuggestionsComponent.Builder publishComponent(PublishComponent publishComponent) {
            this.a = (PublishComponent) Preconditions.checkNotNull(publishComponent);
            return this;
        }
    }

    public static class c implements Provider<CategoryParametersConverter> {
        public final PublishComponent a;

        public c(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CategoryParametersConverter get() {
            return (CategoryParametersConverter) Preconditions.checkNotNullFromComponent(this.a.categoryParametersConverter());
        }
    }

    public static class d implements Provider<Features> {
        public final PublishComponent a;

        public d(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class e implements Provider<PublishAnalyticsDataProvider> {
        public final PublishComponent a;

        public e(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishAnalyticsDataProvider get() {
            return (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider());
        }
    }

    public static class f implements Provider<PublishApi> {
        public final PublishComponent a;

        public f(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishApi get() {
            return (PublishApi) Preconditions.checkNotNullFromComponent(this.a.publishApi());
        }
    }

    public static class g implements Provider<PublishEventTracker> {
        public final PublishComponent a;

        public g(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishEventTracker get() {
            return (PublishEventTracker) Preconditions.checkNotNullFromComponent(this.a.publishEventTracker());
        }
    }

    public static class h implements Provider<SchedulersFactory> {
        public final PublishComponent a;

        public h(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerCategoriesSuggestionsComponent(CategoriesSuggestionsModule categoriesSuggestionsModule, PublishComponent publishComponent, a aVar) {
        this.a = publishComponent;
        this.b = new h(publishComponent);
        f fVar = new f(publishComponent);
        this.c = fVar;
        e eVar = new e(publishComponent);
        this.d = eVar;
        c cVar = new c(publishComponent);
        this.e = cVar;
        d dVar = new d(publishComponent);
        this.f = dVar;
        Provider<CategoriesSuggestionsInteractor> provider = DoubleCheck.provider(CategoriesSuggestionsModule_ProviderInteractorFactory.create(categoriesSuggestionsModule, fVar, eVar, cVar, dVar));
        this.g = provider;
        g gVar = new g(publishComponent);
        this.h = gVar;
        this.i = DoubleCheck.provider(CategoriesSuggestionsModule_ProviderViewModuleFactoryFactory.create(categoriesSuggestionsModule, this.b, provider, gVar));
        Provider<WizardItemPresenter> provider2 = DoubleCheck.provider(CategoriesSuggestionsModule_ProvideWizardItemPresenter$publish_releaseFactory.create(categoriesSuggestionsModule));
        this.j = provider2;
        this.k = DoubleCheck.provider(CategoriesSuggestionsModule_ProvideCategoryItemBluePrint$publish_releaseFactory.create(categoriesSuggestionsModule, provider2));
        Provider<CheckableItemPresenter> provider3 = DoubleCheck.provider(CategoriesSuggestionsModule_ProvideCheckableItemPresenterFactory.create(categoriesSuggestionsModule));
        this.l = provider3;
        Provider<CheckableItemBlueprint> provider4 = DoubleCheck.provider(CategoriesSuggestionsModule_ProvideCheckableItemBlueprintFactory.create(categoriesSuggestionsModule, provider3));
        this.m = provider4;
        Provider<ItemBinder> provider5 = DoubleCheck.provider(CategoriesSuggestionsModule_ProvideItemBinder$publish_releaseFactory.create(categoriesSuggestionsModule, this.k, provider4));
        this.n = provider5;
        Provider<AdapterPresenter> provider6 = DoubleCheck.provider(CategoriesSuggestionsModule_ProvideAdapterPresenter$publish_releaseFactory.create(categoriesSuggestionsModule, provider5));
        this.o = provider6;
        this.p = DoubleCheck.provider(CategoriesSuggestionsModule_ProvideAdapterFactory.create(categoriesSuggestionsModule, provider6, this.n));
        this.q = DoubleCheck.provider(CategoriesSuggestionsModule_ProvideItemPresentersSetFactory.create(categoriesSuggestionsModule, this.j));
    }

    public static CategoriesSuggestionsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.category_suggest.di.CategoriesSuggestionsComponent
    public void inject(CategoriesSuggestionsFragment categoriesSuggestionsFragment) {
        CategoriesSuggestionsFragment_MembersInjector.injectViewModelFactory(categoriesSuggestionsFragment, this.i.get());
        CategoriesSuggestionsFragment_MembersInjector.injectAdapter(categoriesSuggestionsFragment, this.p.get());
        CategoriesSuggestionsFragment_MembersInjector.injectAdapterPresenter(categoriesSuggestionsFragment, this.o.get());
        CategoriesSuggestionsFragment_MembersInjector.injectAnalytics(categoriesSuggestionsFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        CategoriesSuggestionsFragment_MembersInjector.injectItemPresenterSet(categoriesSuggestionsFragment, this.q.get());
        CategoriesSuggestionsFragment_MembersInjector.injectPublishDraftDataHolder(categoriesSuggestionsFragment, (PublishDraftDataHolder) Preconditions.checkNotNullFromComponent(this.a.publishDraftDataHolder()));
        CategoriesSuggestionsFragment_MembersInjector.injectPublishEventTracker(categoriesSuggestionsFragment, (PublishEventTracker) Preconditions.checkNotNullFromComponent(this.a.publishEventTracker()));
    }
}
