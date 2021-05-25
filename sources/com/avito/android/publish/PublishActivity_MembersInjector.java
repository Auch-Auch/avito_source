package com.avito.android.publish;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.publish.analytics.PhotoPickerOnPublishEventTracker;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.drafts.PublishDraftDataHolder;
import com.avito.android.util.DialogRouter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PublishActivity_MembersInjector implements MembersInjector<PublishActivity> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<SubmissionPresenter> c;
    public final Provider<PublishDraftDataHolder> d;
    public final Provider<Analytics> e;
    public final Provider<PublishAnalyticsDataProvider> f;
    public final Provider<PublishEventTracker> g;
    public final Provider<PhotoPickerOnPublishEventTracker> h;
    public final Provider<Features> i;
    public final Provider<AbTestsConfigProvider> j;
    public final Provider<PublishViewModelFactory> k;
    public final Provider<DialogRouter> l;

    public PublishActivity_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<ActivityIntentFactory> provider2, Provider<SubmissionPresenter> provider3, Provider<PublishDraftDataHolder> provider4, Provider<Analytics> provider5, Provider<PublishAnalyticsDataProvider> provider6, Provider<PublishEventTracker> provider7, Provider<PhotoPickerOnPublishEventTracker> provider8, Provider<Features> provider9, Provider<AbTestsConfigProvider> provider10, Provider<PublishViewModelFactory> provider11, Provider<DialogRouter> provider12) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
    }

    public static MembersInjector<PublishActivity> create(Provider<DeepLinkIntentFactory> provider, Provider<ActivityIntentFactory> provider2, Provider<SubmissionPresenter> provider3, Provider<PublishDraftDataHolder> provider4, Provider<Analytics> provider5, Provider<PublishAnalyticsDataProvider> provider6, Provider<PublishEventTracker> provider7, Provider<PhotoPickerOnPublishEventTracker> provider8, Provider<Features> provider9, Provider<AbTestsConfigProvider> provider10, Provider<PublishViewModelFactory> provider11, Provider<DialogRouter> provider12) {
        return new PublishActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    @InjectedFieldSignature("com.avito.android.publish.PublishActivity.abTestsConfigProvider")
    public static void injectAbTestsConfigProvider(PublishActivity publishActivity, AbTestsConfigProvider abTestsConfigProvider) {
        publishActivity.abTestsConfigProvider = abTestsConfigProvider;
    }

    @InjectedFieldSignature("com.avito.android.publish.PublishActivity.analytics")
    public static void injectAnalytics(PublishActivity publishActivity, Analytics analytics) {
        publishActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.publish.PublishActivity.analyticsData")
    public static void injectAnalyticsData(PublishActivity publishActivity, PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        publishActivity.analyticsData = publishAnalyticsDataProvider;
    }

    @InjectedFieldSignature("com.avito.android.publish.PublishActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PublishActivity publishActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        publishActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.PublishActivity.dialogRouter")
    public static void injectDialogRouter(PublishActivity publishActivity, DialogRouter dialogRouter) {
        publishActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.publish.PublishActivity.features")
    public static void injectFeatures(PublishActivity publishActivity, Features features) {
        publishActivity.features = features;
    }

    @InjectedFieldSignature("com.avito.android.publish.PublishActivity.intentFactory")
    public static void injectIntentFactory(PublishActivity publishActivity, ActivityIntentFactory activityIntentFactory) {
        publishActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.PublishActivity.photoPickerEventTracker")
    public static void injectPhotoPickerEventTracker(PublishActivity publishActivity, PhotoPickerOnPublishEventTracker photoPickerOnPublishEventTracker) {
        publishActivity.photoPickerEventTracker = photoPickerOnPublishEventTracker;
    }

    @InjectedFieldSignature("com.avito.android.publish.PublishActivity.presenter")
    public static void injectPresenter(PublishActivity publishActivity, SubmissionPresenter submissionPresenter) {
        publishActivity.presenter = submissionPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.PublishActivity.publishDraftDataHolder")
    public static void injectPublishDraftDataHolder(PublishActivity publishActivity, PublishDraftDataHolder publishDraftDataHolder) {
        publishActivity.publishDraftDataHolder = publishDraftDataHolder;
    }

    @InjectedFieldSignature("com.avito.android.publish.PublishActivity.publishEventTracker")
    public static void injectPublishEventTracker(PublishActivity publishActivity, PublishEventTracker publishEventTracker) {
        publishActivity.publishEventTracker = publishEventTracker;
    }

    @InjectedFieldSignature("com.avito.android.publish.PublishActivity.viewModelFactory")
    public static void injectViewModelFactory(PublishActivity publishActivity, PublishViewModelFactory publishViewModelFactory) {
        publishActivity.viewModelFactory = publishViewModelFactory;
    }

    public void injectMembers(PublishActivity publishActivity) {
        injectDeepLinkIntentFactory(publishActivity, this.a.get());
        injectIntentFactory(publishActivity, this.b.get());
        injectPresenter(publishActivity, this.c.get());
        injectPublishDraftDataHolder(publishActivity, this.d.get());
        injectAnalytics(publishActivity, this.e.get());
        injectAnalyticsData(publishActivity, this.f.get());
        injectPublishEventTracker(publishActivity, this.g.get());
        injectPhotoPickerEventTracker(publishActivity, this.h.get());
        injectFeatures(publishActivity, this.i.get());
        injectAbTestsConfigProvider(publishActivity, this.j.get());
        injectViewModelFactory(publishActivity, this.k.get());
        injectDialogRouter(publishActivity, this.l.get());
    }
}
