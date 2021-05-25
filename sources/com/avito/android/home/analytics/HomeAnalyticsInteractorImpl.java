package com.avito.android.home.analytics;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ClickSearchActionEvent;
import com.avito.android.analytics.event.ClickShortcutEvent;
import com.avito.android.analytics.event.ClickSuggestParametrizedEvent;
import com.avito.android.analytics.event.LoadHomeEvent;
import com.avito.android.analytics.event.NotRestoreStateEvent;
import com.avito.android.analytics.event.ShopButtonClickEvent;
import com.avito.android.analytics.event.ShowAllCategoriesEvent;
import com.avito.android.analytics.event.ShowHomeEvent;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010-\u001a\u00020*¢\u0006\u0004\b0\u00101J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u000eJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/avito/android/home/analytics/HomeAnalyticsInteractorImpl;", "Lcom/avito/android/home/analytics/HomeAnalyticsInteractor;", "", "locationId", "", "sendHomeLoad", "(Ljava/lang/String;)V", "mainAppearanceUuid", "sendHomeShownEvent", "shortcutTitle", "categoryId", "sendClickShortcut", "(Ljava/lang/String;Ljava/lang/String;)V", "sendClickShopShortcut", "()V", "sendShowAllCategories", "fromPage", "targetPage", "sendTabSelected", "sendNotRestoreState", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;", "event", "sendClickSearchSuggest", "(Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;)V", "sendSearchSubmit", "", "saveState", "()J", "stateId", "restoreState", "(J)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "c", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", AuthSource.SEND_ABUSE, "J", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;Lcom/avito/android/Features;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class HomeAnalyticsInteractorImpl implements HomeAnalyticsInteractor {
    public long a;
    public final Analytics b;
    public final TreeStateIdGenerator c;
    public final Features d;

    @Inject
    public HomeAnalyticsInteractorImpl(@NotNull Analytics analytics, @NotNull TreeStateIdGenerator treeStateIdGenerator, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = analytics;
        this.c = treeStateIdGenerator;
        this.d = features;
        this.a = treeStateIdGenerator.nextStateId();
    }

    @Override // com.avito.android.home.analytics.HomeAnalyticsInteractor
    @NotNull
    public TreeClickStreamParent getParent() {
        return new TreeClickStreamParent(this.a, ScreenIdField.MAIN.name(), null, null);
    }

    @Override // com.avito.android.home.analytics.HomeAnalyticsInteractor
    public void restoreState(long j) {
        this.a = j;
    }

    @Override // com.avito.android.home.analytics.HomeAnalyticsInteractor
    public long saveState() {
        return this.a;
    }

    @Override // com.avito.android.home.analytics.HomeAnalyticsInteractor
    public void sendClickSearchSuggest(@NotNull SuggestAnalyticsEvent suggestAnalyticsEvent) {
        Intrinsics.checkNotNullParameter(suggestAnalyticsEvent, "event");
        this.b.track(ClickSuggestParametrizedEvent.Companion.fromAction(suggestAnalyticsEvent));
    }

    @Override // com.avito.android.home.analytics.HomeAnalyticsInteractor
    public void sendClickShopShortcut() {
        this.b.track(new ShopButtonClickEvent("main"));
    }

    @Override // com.avito.android.home.analytics.HomeAnalyticsInteractor
    public void sendClickShortcut(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "shortcutTitle");
        this.b.track(new ClickShortcutEvent(this.c.nextStateId(), getParent(), null, null, str, str2, 12, null));
    }

    @Override // com.avito.android.home.analytics.HomeAnalyticsInteractor
    public void sendHomeLoad(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "locationId");
        long nextStateId = this.c.nextStateId();
        this.a = nextStateId;
        this.b.track(new LoadHomeEvent(nextStateId, str));
    }

    @Override // com.avito.android.home.analytics.HomeAnalyticsInteractor
    public void sendHomeShownEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "mainAppearanceUuid");
        if (this.d.getNewShowScreenClickstreamEvents().invoke().booleanValue()) {
            this.b.track(new ShowHomeEvent(str));
        }
    }

    @Override // com.avito.android.home.analytics.HomeAnalyticsInteractor
    public void sendNotRestoreState() {
        this.b.track(new NotRestoreStateEvent(ScreenIdField.MAIN.name()));
    }

    @Override // com.avito.android.home.analytics.HomeAnalyticsInteractor
    public void sendSearchSubmit() {
        this.b.track(new ClickSearchActionEvent());
    }

    @Override // com.avito.android.home.analytics.HomeAnalyticsInteractor
    public void sendShowAllCategories() {
        this.b.track(new ShowAllCategoriesEvent(this.c.nextStateId(), getParent()));
    }

    @Override // com.avito.android.home.analytics.HomeAnalyticsInteractor
    public void sendTabSelected(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "fromPage");
        Intrinsics.checkNotNullParameter(str2, "targetPage");
        this.b.track(new HomeTabSelectEvent(str, str2, this.c.nextStateId(), getParent()));
    }
}
