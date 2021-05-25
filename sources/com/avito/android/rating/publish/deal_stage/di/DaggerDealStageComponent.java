package com.avito.android.rating.publish.deal_stage.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.dialog.DialogPresenterImpl;
import com.avito.android.dialog.DialogPresenterImpl_Factory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.deal_stage.DealStageFragment;
import com.avito.android.rating.publish.deal_stage.DealStageFragment_MembersInjector;
import com.avito.android.rating.publish.deal_stage.DealStageInteractorImpl;
import com.avito.android.rating.publish.deal_stage.DealStagePresenterImpl;
import com.avito.android.rating.publish.deal_stage.adapter.DealStageItem;
import com.avito.android.rating.publish.deal_stage.adapter.stage.StageItemBlueprint;
import com.avito.android.rating.publish.deal_stage.adapter.stage.StageItemBlueprint_Factory;
import com.avito.android.rating.publish.deal_stage.adapter.stage.StageItemPresenterImpl;
import com.avito.android.rating.publish.deal_stage.adapter.stage.StageItemPresenterImpl_Factory;
import com.avito.android.rating.publish.deal_stage.di.DealStageComponent;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerDealStageComponent implements DealStageComponent {
    public final DealStageDependencies a;
    public final StepListener b;
    public final PublishRelay<DealStageItem> c;
    public final RatingPublishData d;
    public final RatingPublishViewData e;
    public final Kundle f;
    public Provider<Set<ItemBlueprint<?, ?>>> g = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PublishRelay<DealStageItem>> h;
    public Provider<StageItemPresenterImpl> i;
    public Provider<StageItemBlueprint> j;
    public Provider<Set<ItemBlueprint<?, ?>>> k;
    public Provider<ItemBinder> l;
    public Provider<AdapterPresenter> m;
    public Provider<Activity> n;
    public Provider<DialogRouter> o;
    public Provider<DialogPresenterImpl> p;
    public Provider<DialogPresenter> q;
    public Provider<Resources> r;
    public Provider<ErrorFormatterImpl> s;
    public Provider<ErrorFormatter> t;
    public Provider<ErrorHelperImpl> u;
    public Provider<ErrorHelper> v;

    public static final class b implements DealStageComponent.Builder {
        public DealStageDependencies a;
        public Kundle b;
        public Activity c;
        public Resources d;
        public PublishRelay<DealStageItem> e;
        public StepListener f;
        public RatingPublishData g;
        public RatingPublishViewData h;

        public b(a aVar) {
        }

        @Override // com.avito.android.rating.publish.deal_stage.di.DealStageComponent.Builder
        public DealStageComponent build() {
            Preconditions.checkBuilderRequirement(this.a, DealStageDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, PublishRelay.class);
            Preconditions.checkBuilderRequirement(this.f, StepListener.class);
            Preconditions.checkBuilderRequirement(this.g, RatingPublishData.class);
            Preconditions.checkBuilderRequirement(this.h, RatingPublishViewData.class);
            return new DaggerDealStageComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
        }

        @Override // com.avito.android.rating.publish.deal_stage.di.DealStageComponent.Builder
        public DealStageComponent.Builder dependentOn(DealStageDependencies dealStageDependencies) {
            this.a = (DealStageDependencies) Preconditions.checkNotNull(dealStageDependencies);
            return this;
        }

        @Override // com.avito.android.rating.publish.deal_stage.di.DealStageComponent.Builder
        public DealStageComponent.Builder with(Kundle kundle) {
            this.b = kundle;
            return this;
        }

        @Override // com.avito.android.rating.publish.deal_stage.di.DealStageComponent.Builder
        public DealStageComponent.Builder with(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.rating.publish.deal_stage.di.DealStageComponent.Builder
        public DealStageComponent.Builder with(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.rating.publish.deal_stage.di.DealStageComponent.Builder
        public DealStageComponent.Builder with(PublishRelay publishRelay) {
            this.e = (PublishRelay) Preconditions.checkNotNull(publishRelay);
            return this;
        }

        @Override // com.avito.android.rating.publish.deal_stage.di.DealStageComponent.Builder
        public DealStageComponent.Builder with(StepListener stepListener) {
            this.f = (StepListener) Preconditions.checkNotNull(stepListener);
            return this;
        }

        @Override // com.avito.android.rating.publish.deal_stage.di.DealStageComponent.Builder
        public DealStageComponent.Builder with(RatingPublishData ratingPublishData) {
            this.g = (RatingPublishData) Preconditions.checkNotNull(ratingPublishData);
            return this;
        }

        @Override // com.avito.android.rating.publish.deal_stage.di.DealStageComponent.Builder
        public DealStageComponent.Builder with(RatingPublishViewData ratingPublishViewData) {
            this.h = (RatingPublishViewData) Preconditions.checkNotNull(ratingPublishViewData);
            return this;
        }
    }

    public DaggerDealStageComponent(DealStageDependencies dealStageDependencies, Kundle kundle, Activity activity, Resources resources, PublishRelay publishRelay, StepListener stepListener, RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData, a aVar) {
        this.a = dealStageDependencies;
        this.b = stepListener;
        this.c = publishRelay;
        this.d = ratingPublishData;
        this.e = ratingPublishViewData;
        this.f = kundle;
        Factory create = InstanceFactory.create(publishRelay);
        this.h = create;
        StageItemPresenterImpl_Factory create2 = StageItemPresenterImpl_Factory.create(create);
        this.i = create2;
        this.j = StageItemBlueprint_Factory.create(create2);
        SetFactory build = SetFactory.builder(1, 1).addCollectionProvider(this.g).addProvider(this.j).build();
        this.k = build;
        Provider<ItemBinder> provider = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.l = provider;
        this.m = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider));
        Factory create3 = InstanceFactory.create(activity);
        this.n = create3;
        Provider<DialogRouter> provider2 = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create3));
        this.o = provider2;
        DialogPresenterImpl_Factory create4 = DialogPresenterImpl_Factory.create(this.n, provider2);
        this.p = create4;
        this.q = SingleCheck.provider(create4);
        Factory create5 = InstanceFactory.create(resources);
        this.r = create5;
        ErrorFormatterImpl_Factory create6 = ErrorFormatterImpl_Factory.create(create5);
        this.s = create6;
        Provider<ErrorFormatter> provider3 = SingleCheck.provider(create6);
        this.t = provider3;
        ErrorHelperImpl_Factory create7 = ErrorHelperImpl_Factory.create(provider3);
        this.u = create7;
        this.v = SingleCheck.provider(create7);
    }

    public static DealStageComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.rating.publish.deal_stage.di.DealStageComponent
    public void inject(DealStageFragment dealStageFragment) {
        DealStageFragment_MembersInjector.injectDeepLinkIntentFactory(dealStageFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        DealStageFragment_MembersInjector.injectAdapterPresenter(dealStageFragment, this.m.get());
        DealStageFragment_MembersInjector.injectItemBinder(dealStageFragment, this.l.get());
        DealStageFragment_MembersInjector.injectAnalytics(dealStageFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        DealStageFragment_MembersInjector.injectPresenter(dealStageFragment, new DealStagePresenterImpl(this.b, new DealStageInteractorImpl((RatingApi) Preconditions.checkNotNullFromComponent(this.a.ratingApi()), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3())), this.m.get(), this.c, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()), this.q.get(), this.v.get(), this.d, this.e, this.f));
        DealStageFragment_MembersInjector.injectStepListener(dealStageFragment, this.b);
        DealStageFragment_MembersInjector.injectRatingViewData(dealStageFragment, this.e);
        DealStageFragment_MembersInjector.injectRatingData(dealStageFragment, this.d);
    }
}
