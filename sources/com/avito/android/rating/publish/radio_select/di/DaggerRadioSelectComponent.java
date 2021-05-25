package com.avito.android.rating.publish.radio_select.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.radio_select.RadioSelectFragment;
import com.avito.android.rating.publish.radio_select.RadioSelectFragment_MembersInjector;
import com.avito.android.rating.publish.radio_select.RadioSelectPresenterImpl;
import com.avito.android.rating.publish.radio_select.adapter.radio_select.RadioSelectItem;
import com.avito.android.rating.publish.radio_select.adapter.radio_select.RadioSelectItemBlueprint;
import com.avito.android.rating.publish.radio_select.adapter.radio_select.RadioSelectItemBlueprint_Factory;
import com.avito.android.rating.publish.radio_select.adapter.radio_select.RadioSelectItemPresenterImpl;
import com.avito.android.rating.publish.radio_select.adapter.radio_select.RadioSelectItemPresenterImpl_Factory;
import com.avito.android.rating.publish.radio_select.di.RadioSelectComponent;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.model.publish.NextStagePayload;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerRadioSelectComponent implements RadioSelectComponent {
    public final RadioSelectDependencies a;
    public final StepListener b;
    public final RatingPublishData c;
    public final RatingPublishViewData d;
    public final NextStagePayload e;
    public final Kundle f;
    public Provider<Set<ItemBlueprint<?, ?>>> g = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PublishRelay<RadioSelectItem>> h;
    public Provider<RadioSelectItemPresenterImpl> i;
    public Provider<RadioSelectItemBlueprint> j;
    public Provider<Set<ItemBlueprint<?, ?>>> k;
    public Provider<ItemBinder> l;
    public Provider<AdapterPresenter> m;

    public static final class b implements RadioSelectComponent.Builder {
        public RadioSelectDependencies a;
        public Kundle b;
        public Activity c;
        public Resources d;
        public StepListener e;
        public RatingPublishData f;
        public RatingPublishViewData g;
        public NextStagePayload h;

        public b(a aVar) {
        }

        @Override // com.avito.android.rating.publish.radio_select.di.RadioSelectComponent.Builder
        public RadioSelectComponent build() {
            Preconditions.checkBuilderRequirement(this.a, RadioSelectDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, StepListener.class);
            Preconditions.checkBuilderRequirement(this.f, RatingPublishData.class);
            Preconditions.checkBuilderRequirement(this.g, RatingPublishViewData.class);
            Preconditions.checkBuilderRequirement(this.h, NextStagePayload.class);
            return new DaggerRadioSelectComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
        }

        @Override // com.avito.android.rating.publish.radio_select.di.RadioSelectComponent.Builder
        public RadioSelectComponent.Builder dependentOn(RadioSelectDependencies radioSelectDependencies) {
            this.a = (RadioSelectDependencies) Preconditions.checkNotNull(radioSelectDependencies);
            return this;
        }

        @Override // com.avito.android.rating.publish.radio_select.di.RadioSelectComponent.Builder
        public RadioSelectComponent.Builder with(Kundle kundle) {
            this.b = kundle;
            return this;
        }

        @Override // com.avito.android.rating.publish.radio_select.di.RadioSelectComponent.Builder
        public RadioSelectComponent.Builder with(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.rating.publish.radio_select.di.RadioSelectComponent.Builder
        public RadioSelectComponent.Builder with(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.rating.publish.radio_select.di.RadioSelectComponent.Builder
        public RadioSelectComponent.Builder with(StepListener stepListener) {
            this.e = (StepListener) Preconditions.checkNotNull(stepListener);
            return this;
        }

        @Override // com.avito.android.rating.publish.radio_select.di.RadioSelectComponent.Builder
        public RadioSelectComponent.Builder with(RatingPublishData ratingPublishData) {
            this.f = (RatingPublishData) Preconditions.checkNotNull(ratingPublishData);
            return this;
        }

        @Override // com.avito.android.rating.publish.radio_select.di.RadioSelectComponent.Builder
        public RadioSelectComponent.Builder with(RatingPublishViewData ratingPublishViewData) {
            this.g = (RatingPublishViewData) Preconditions.checkNotNull(ratingPublishViewData);
            return this;
        }

        @Override // com.avito.android.rating.publish.radio_select.di.RadioSelectComponent.Builder
        public RadioSelectComponent.Builder with(NextStagePayload nextStagePayload) {
            this.h = (NextStagePayload) Preconditions.checkNotNull(nextStagePayload);
            return this;
        }
    }

    public DaggerRadioSelectComponent(RadioSelectDependencies radioSelectDependencies, Kundle kundle, Activity activity, Resources resources, StepListener stepListener, RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData, NextStagePayload nextStagePayload, a aVar) {
        this.a = radioSelectDependencies;
        this.b = stepListener;
        this.c = ratingPublishData;
        this.d = ratingPublishViewData;
        this.e = nextStagePayload;
        this.f = kundle;
        Provider<PublishRelay<RadioSelectItem>> provider = DoubleCheck.provider(RadioSelectModule_ProvideRadioSelectPublishRelay$rating_releaseFactory.create());
        this.h = provider;
        RadioSelectItemPresenterImpl_Factory create = RadioSelectItemPresenterImpl_Factory.create(provider);
        this.i = create;
        this.j = RadioSelectItemBlueprint_Factory.create(create);
        SetFactory build = SetFactory.builder(1, 1).addCollectionProvider(this.g).addProvider(this.j).build();
        this.k = build;
        Provider<ItemBinder> provider2 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.l = provider2;
        this.m = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider2));
    }

    public static RadioSelectComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.rating.publish.radio_select.di.RadioSelectComponent
    public void inject(RadioSelectFragment radioSelectFragment) {
        RadioSelectFragment_MembersInjector.injectDeepLinkIntentFactory(radioSelectFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        RadioSelectFragment_MembersInjector.injectItemBinder(radioSelectFragment, this.l.get());
        RadioSelectFragment_MembersInjector.injectPresenter(radioSelectFragment, new RadioSelectPresenterImpl(this.b, this.m.get(), this.h.get(), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()), this.c, this.d, this.e, this.f));
        RadioSelectFragment_MembersInjector.injectAdapterPresenter(radioSelectFragment, this.m.get());
        RadioSelectFragment_MembersInjector.injectStepListener(radioSelectFragment, this.b);
        RadioSelectFragment_MembersInjector.injectAnalytics(radioSelectFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
