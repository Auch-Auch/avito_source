package com.avito.android.rating.publish.select_advert;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.select_advert.tracker.SelectAdvertTracker;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.konveyor.ItemBinder;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SelectAdvertFragment_MembersInjector implements MembersInjector<SelectAdvertFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<ResponsiveAdapterPresenter> c;
    public final Provider<ItemBinder> d;
    public final Provider<SelectAdvertPresenter> e;
    public final Provider<StepListener> f;
    public final Provider<SelectAdvertTracker> g;
    public final Provider<RatingPublishData> h;

    public SelectAdvertFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ResponsiveAdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<SelectAdvertPresenter> provider5, Provider<StepListener> provider6, Provider<SelectAdvertTracker> provider7, Provider<RatingPublishData> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static MembersInjector<SelectAdvertFragment> create(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ResponsiveAdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<SelectAdvertPresenter> provider5, Provider<StepListener> provider6, Provider<SelectAdvertTracker> provider7, Provider<RatingPublishData> provider8) {
        return new SelectAdvertFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.select_advert.SelectAdvertFragment.adapterPresenter")
    public static void injectAdapterPresenter(SelectAdvertFragment selectAdvertFragment, ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        selectAdvertFragment.adapterPresenter = responsiveAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.select_advert.SelectAdvertFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(SelectAdvertFragment selectAdvertFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        selectAdvertFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.select_advert.SelectAdvertFragment.intentFactory")
    public static void injectIntentFactory(SelectAdvertFragment selectAdvertFragment, ActivityIntentFactory activityIntentFactory) {
        selectAdvertFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.select_advert.SelectAdvertFragment.itemBinder")
    public static void injectItemBinder(SelectAdvertFragment selectAdvertFragment, ItemBinder itemBinder) {
        selectAdvertFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.select_advert.SelectAdvertFragment.presenter")
    public static void injectPresenter(SelectAdvertFragment selectAdvertFragment, SelectAdvertPresenter selectAdvertPresenter) {
        selectAdvertFragment.presenter = selectAdvertPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.select_advert.SelectAdvertFragment.ratingData")
    public static void injectRatingData(SelectAdvertFragment selectAdvertFragment, RatingPublishData ratingPublishData) {
        selectAdvertFragment.ratingData = ratingPublishData;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.select_advert.SelectAdvertFragment.stepListener")
    public static void injectStepListener(SelectAdvertFragment selectAdvertFragment, StepListener stepListener) {
        selectAdvertFragment.stepListener = stepListener;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.select_advert.SelectAdvertFragment.tracker")
    public static void injectTracker(SelectAdvertFragment selectAdvertFragment, SelectAdvertTracker selectAdvertTracker) {
        selectAdvertFragment.tracker = selectAdvertTracker;
    }

    public void injectMembers(SelectAdvertFragment selectAdvertFragment) {
        injectIntentFactory(selectAdvertFragment, this.a.get());
        injectDeepLinkIntentFactory(selectAdvertFragment, this.b.get());
        injectAdapterPresenter(selectAdvertFragment, this.c.get());
        injectItemBinder(selectAdvertFragment, this.d.get());
        injectPresenter(selectAdvertFragment, this.e.get());
        injectStepListener(selectAdvertFragment, this.f.get());
        injectTracker(selectAdvertFragment, this.g.get());
        injectRatingData(selectAdvertFragment, this.h.get());
    }
}
