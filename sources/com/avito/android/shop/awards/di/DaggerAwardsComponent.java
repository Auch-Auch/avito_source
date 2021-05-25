package com.avito.android.shop.awards.di;

import android.content.res.Resources;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.shop.awards.AwardsActivity;
import com.avito.android.shop.awards.AwardsActivity_MembersInjector;
import com.avito.android.shop.awards.AwardsInteractor;
import com.avito.android.shop.awards.AwardsPresenter;
import com.avito.android.shop.awards.AwardsResourceProvider;
import com.avito.android.shop.awards.ShopAwardsItemsConverter;
import com.avito.android.shop.awards.di.AwardsComponent;
import com.avito.android.shop.awards.item.action.ActionClickProvider;
import com.avito.android.shop.awards.item.action.ActionClickProviderImpl_Factory;
import com.avito.android.shop.awards.item.action.ActionItemBlueprint;
import com.avito.android.shop.awards.item.action.ActionItemBlueprint_Factory;
import com.avito.android.shop.awards.item.action.ActionItemPresenter;
import com.avito.android.shop.awards.item.award.AwardItemBlueprint;
import com.avito.android.shop.awards.item.award.AwardItemBlueprint_Factory;
import com.avito.android.shop.awards.item.award.AwardItemPresenter_Factory;
import com.avito.android.shop.awards.item.subtitle.SubtitleItemBlueprint;
import com.avito.android.shop.awards.item.subtitle.SubtitleItemBlueprint_Factory;
import com.avito.android.shop.awards.item.subtitle.SubtitleItemPresenter_Factory;
import com.avito.android.shop.awards.item.title.TitleItemBlueprint;
import com.avito.android.shop.awards.item.title.TitleItemBlueprint_Factory;
import com.avito.android.shop.awards.item.title.TitleItemPresenter_Factory;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerAwardsComponent implements AwardsComponent {
    public final ShopDetailedDependencies a;
    public Provider<SellerVerification.AwardsItem> b;
    public Provider<AwardsInteractor> c;
    public Provider<SchedulersFactory3> d;
    public Provider<Resources> e;
    public Provider<AwardsResourceProvider> f;
    public Provider<TitleItemBlueprint> g = TitleItemBlueprint_Factory.create(TitleItemPresenter_Factory.create());
    public Provider<SubtitleItemBlueprint> h = SubtitleItemBlueprint_Factory.create(SubtitleItemPresenter_Factory.create());
    public Provider<AwardItemBlueprint> i = AwardItemBlueprint_Factory.create(AwardItemPresenter_Factory.create());
    public Provider<ActionClickProvider> j;
    public Provider<ActionItemPresenter> k;
    public Provider<ActionItemBlueprint> l;
    public Provider<ItemBinder> m;
    public Provider<AdapterPresenter> n;
    public Provider<ShopAwardsItemsConverter> o;
    public Provider<Kundle> p;
    public Provider<AwardsPresenter> q;
    public Provider<SimpleRecyclerAdapter> r;

    public static final class b implements AwardsComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.shop.awards.di.AwardsComponent.Factory
        public AwardsComponent create(Resources resources, SellerVerification.AwardsItem awardsItem, Kundle kundle, ShopDetailedDependencies shopDetailedDependencies) {
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(awardsItem);
            Preconditions.checkNotNull(shopDetailedDependencies);
            return new DaggerAwardsComponent(shopDetailedDependencies, resources, awardsItem, kundle, null);
        }
    }

    public static class c implements Provider<SchedulersFactory3> {
        public final ShopDetailedDependencies a;

        public c(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerAwardsComponent(ShopDetailedDependencies shopDetailedDependencies, Resources resources, SellerVerification.AwardsItem awardsItem, Kundle kundle, a aVar) {
        this.a = shopDetailedDependencies;
        Factory create = InstanceFactory.create(awardsItem);
        this.b = create;
        this.c = DoubleCheck.provider(AwardsModule_ProvideInteractorFactory.create(create));
        this.d = new c(shopDetailedDependencies);
        Factory create2 = InstanceFactory.create(resources);
        this.e = create2;
        this.f = DoubleCheck.provider(AwardsModule_ProvideResourceProviderFactory.create(create2));
        Provider<ActionClickProvider> provider = DoubleCheck.provider(ActionClickProviderImpl_Factory.create());
        this.j = provider;
        Provider<ActionItemPresenter> provider2 = DoubleCheck.provider(AwardsModule_ProvideActionItemPresenterFactory.create(provider));
        this.k = provider2;
        ActionItemBlueprint_Factory create3 = ActionItemBlueprint_Factory.create(provider2);
        this.l = create3;
        Provider<ItemBinder> provider3 = DoubleCheck.provider(AwardsModule_ProvideItemBinderFactory.create(this.g, this.h, this.i, create3));
        this.m = provider3;
        this.n = DoubleCheck.provider(AwardsModule_ProvideAdapterPresenterFactory.create(provider3));
        this.o = DoubleCheck.provider(AwardsModule_ProvideShopAwardsItemsConverterFactory.create());
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.p = createNullable;
        this.q = DoubleCheck.provider(AwardsModule_ProvidePresenterFactory.create(this.c, this.d, this.f, this.n, this.o, this.j, createNullable));
        this.r = DoubleCheck.provider(AwardsModule_ProvideAdapterFactory.create(this.n, this.m));
    }

    public static AwardsComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.shop.awards.di.AwardsComponent
    public void inject(AwardsActivity awardsActivity) {
        AwardsActivity_MembersInjector.injectPresenter(awardsActivity, this.q.get());
        AwardsActivity_MembersInjector.injectAnalytics(awardsActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        AwardsActivity_MembersInjector.injectInteractor(awardsActivity, this.c.get());
        AwardsActivity_MembersInjector.injectAdapter(awardsActivity, this.r.get());
        AwardsActivity_MembersInjector.injectIntentFactory(awardsActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
    }
}
