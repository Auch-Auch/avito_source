package com.avito.android.publish.select.di;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.select.SelectFragment;
import com.avito.android.publish.select.SelectFragment_MembersInjector;
import com.avito.android.publish.select.SelectViewModelFactory;
import com.avito.android.publish.select.blueprints.CheckableItemBlueprint;
import com.avito.android.publish.select.blueprints.CheckableItemPresenter;
import com.avito.android.publish.select.di.SelectComponent;
import com.avito.android.select.title.TitleItemPresenter;
import com.avito.android.select.title.TitleItemViewBlueprint;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerSelectComponent implements SelectComponent {
    public Provider<SchedulersFactory> a;
    public Provider<SelectViewModelFactory> b;
    public Provider<CheckableItemPresenter> c;
    public Provider<CheckableItemBlueprint> d;
    public Provider<TitleItemPresenter> e;
    public Provider<TitleItemViewBlueprint> f;
    public Provider<ItemBinder> g;
    public Provider<AdapterPresenter> h;
    public Provider<RecyclerView.Adapter<?>> i;
    public Provider<Set<ItemPresenter<?, ?>>> j;

    public static final class b implements SelectComponent.Builder {
        public PublishComponent a;
        public SelectModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.select.di.SelectComponent.Builder
        public SelectComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PublishComponent.class);
            if (this.b == null) {
                this.b = new SelectModule();
            }
            return new DaggerSelectComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.publish.select.di.SelectComponent.Builder
        public SelectComponent.Builder publishComponent(PublishComponent publishComponent) {
            this.a = (PublishComponent) Preconditions.checkNotNull(publishComponent);
            return this;
        }

        @Override // com.avito.android.publish.select.di.SelectComponent.Builder
        public SelectComponent.Builder selectModule(SelectModule selectModule) {
            this.b = (SelectModule) Preconditions.checkNotNull(selectModule);
            return this;
        }
    }

    public static class c implements Provider<SchedulersFactory> {
        public final PublishComponent a;

        public c(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerSelectComponent(SelectModule selectModule, PublishComponent publishComponent, a aVar) {
        c cVar = new c(publishComponent);
        this.a = cVar;
        this.b = DoubleCheck.provider(SelectModule_ProvideSelectViewModelFactoryFactory.create(selectModule, cVar));
        Provider<CheckableItemPresenter> provider = DoubleCheck.provider(SelectModule_ProvideCheckableItemPresenterFactory.create(selectModule));
        this.c = provider;
        this.d = DoubleCheck.provider(SelectModule_ProvideCheckableItemBlueprintFactory.create(selectModule, provider));
        Provider<TitleItemPresenter> provider2 = DoubleCheck.provider(SelectModule_ProvideTitleItemPresenter$publish_releaseFactory.create(selectModule));
        this.e = provider2;
        Provider<TitleItemViewBlueprint> provider3 = DoubleCheck.provider(SelectModule_ProvideTitleItemViewBlueprint$publish_releaseFactory.create(selectModule, provider2));
        this.f = provider3;
        Provider<ItemBinder> provider4 = DoubleCheck.provider(SelectModule_ProvideItemBinderFactory.create(selectModule, this.d, provider3));
        this.g = provider4;
        Provider<AdapterPresenter> provider5 = DoubleCheck.provider(SelectModule_ProvideAdapterPresenterFactory.create(selectModule, provider4));
        this.h = provider5;
        this.i = DoubleCheck.provider(SelectModule_ProvideAdapterFactory.create(selectModule, provider5, this.g));
        this.j = DoubleCheck.provider(SelectModule_ProvideItemPresentersSetFactory.create(selectModule, this.c));
    }

    public static SelectComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.select.di.SelectComponent
    public void inject(SelectFragment selectFragment) {
        SelectFragment_MembersInjector.injectViewModelFactory(selectFragment, this.b.get());
        SelectFragment_MembersInjector.injectAdapter(selectFragment, this.i.get());
        SelectFragment_MembersInjector.injectAdapterPresenter(selectFragment, this.h.get());
        SelectFragment_MembersInjector.injectItemPresenterSet(selectFragment, this.j.get());
    }
}
