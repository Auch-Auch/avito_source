package com.avito.android.publish_limits_info.history;

import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PublishLimitsHistoryActivity_MembersInjector implements MembersInjector<PublishLimitsHistoryActivity> {
    public final Provider<PublishLimitsHistoryViewModel> a;
    public final Provider<LoadingProgressOverlay> b;
    public final Provider<PublishLimitsEventTracker> c;

    public PublishLimitsHistoryActivity_MembersInjector(Provider<PublishLimitsHistoryViewModel> provider, Provider<LoadingProgressOverlay> provider2, Provider<PublishLimitsEventTracker> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<PublishLimitsHistoryActivity> create(Provider<PublishLimitsHistoryViewModel> provider, Provider<LoadingProgressOverlay> provider2, Provider<PublishLimitsEventTracker> provider3) {
        return new PublishLimitsHistoryActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.publish_limits_info.history.PublishLimitsHistoryActivity.historyViewModel")
    public static void injectHistoryViewModel(PublishLimitsHistoryActivity publishLimitsHistoryActivity, PublishLimitsHistoryViewModel publishLimitsHistoryViewModel) {
        publishLimitsHistoryActivity.historyViewModel = publishLimitsHistoryViewModel;
    }

    @InjectedFieldSignature("com.avito.android.publish_limits_info.history.PublishLimitsHistoryActivity.limitsEventTracker")
    public static void injectLimitsEventTracker(PublishLimitsHistoryActivity publishLimitsHistoryActivity, PublishLimitsEventTracker publishLimitsEventTracker) {
        publishLimitsHistoryActivity.limitsEventTracker = publishLimitsEventTracker;
    }

    @InjectedFieldSignature("com.avito.android.publish_limits_info.history.PublishLimitsHistoryActivity.loadingProgress")
    public static void injectLoadingProgress(PublishLimitsHistoryActivity publishLimitsHistoryActivity, LoadingProgressOverlay loadingProgressOverlay) {
        publishLimitsHistoryActivity.loadingProgress = loadingProgressOverlay;
    }

    public void injectMembers(PublishLimitsHistoryActivity publishLimitsHistoryActivity) {
        injectHistoryViewModel(publishLimitsHistoryActivity, this.a.get());
        injectLoadingProgress(publishLimitsHistoryActivity, this.b.get());
        injectLimitsEventTracker(publishLimitsHistoryActivity, this.c.get());
    }
}
