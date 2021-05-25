package com.avito.android.publish.start_publish;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b(\u0010)J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;", "e", "Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;", "sessionIdGenerator", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/account/AccountStateProvider;", "accountState", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "d", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "h", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "eventTracker", "Lcom/avito/android/publish/start_publish/StartPublishInteractor;", "c", "Lcom/avito/android/publish/start_publish/StartPublishInteractor;", "interactor", "Lcom/avito/android/analytics/Analytics;", g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/publish/start_publish/StartPublishResourceProvider;", "f", "Lcom/avito/android/publish/start_publish/StartPublishResourceProvider;", "resourcesProvider", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/publish/start_publish/StartPublishInteractor;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;Lcom/avito/android/publish/start_publish/StartPublishResourceProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/publish/analytics/PublishEventTracker;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class StartPublishViewModelFactory implements ViewModelProvider.Factory {
    public final AccountStateProvider a;
    public final SchedulersFactory3 b;
    public final StartPublishInteractor c;
    public final PublishAnalyticsDataProvider d;
    public final PublishSessionIdGenerator e;
    public final StartPublishResourceProvider f;
    public final Analytics g;
    public final PublishEventTracker h;

    @Inject
    public StartPublishViewModelFactory(@NotNull AccountStateProvider accountStateProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull StartPublishInteractor startPublishInteractor, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull PublishSessionIdGenerator publishSessionIdGenerator, @NotNull StartPublishResourceProvider startPublishResourceProvider, @NotNull Analytics analytics, @NotNull PublishEventTracker publishEventTracker) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountState");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(startPublishInteractor, "interactor");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(publishSessionIdGenerator, "sessionIdGenerator");
        Intrinsics.checkNotNullParameter(startPublishResourceProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(publishEventTracker, "eventTracker");
        this.a = accountStateProvider;
        this.b = schedulersFactory3;
        this.c = startPublishInteractor;
        this.d = publishAnalyticsDataProvider;
        this.e = publishSessionIdGenerator;
        this.f = startPublishResourceProvider;
        this.g = analytics;
        this.h = publishEventTracker;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(StartPublishViewModel.class)) {
            return new StartPublishViewModel(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
