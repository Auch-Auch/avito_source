package com.avito.android.serp.analytics;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.BackPressSerpTreeEvent;
import com.avito.android.analytics.event.CallToSellerEvent;
import com.avito.android.analytics.event.CallToSellerEventKt;
import com.avito.android.analytics.event.ClickResetSerpEvent;
import com.avito.android.analytics.event.ClickSearchActionEvent;
import com.avito.android.analytics.event.ClickShortcutEvent;
import com.avito.android.analytics.event.ClickSuggestParametrizedEvent;
import com.avito.android.analytics.event.ContactSource;
import com.avito.android.analytics.event.LoadSerpEvent;
import com.avito.android.analytics.event.NotRestoreStateEvent;
import com.avito.android.analytics.event.ShowSerpEvent;
import com.avito.android.analytics.event.WriteToSellerTreeEvent;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u00107\u001a\u000204\u0012\b\u00103\u001a\u0004\u0018\u00010!\u0012\b\u0010>\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010B\u001a\u00020?¢\u0006\u0004\bE\u0010FJ=\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u000bH\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010)J\u000f\u0010+\u001a\u00020\u000bH\u0016¢\u0006\u0004\b+\u0010)J\u000f\u0010,\u001a\u00020\u0004H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lcom/avito/android/serp/analytics/SerpAnalyticsInteractorImpl;", "Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "total", "Lcom/avito/android/remote/model/SerpDisplayType;", "serpDisplayType", "", "fromSource", "xHash", "", "sendSerpLoad", "(Lcom/avito/android/remote/model/SearchParams;JLcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;Ljava/lang/String;)V", "serpAppearanceUuid", "sendSerpShownEvent", "(Ljava/lang/String;)V", "shortcutTitle", "categoryId", "sendClickShortcut", "(Ljava/lang/String;Ljava/lang/String;)V", "", "fromActionBar", "sendBackClick", "(Ljava/lang/String;Z)V", BookingInfoActivity.EXTRA_ITEM_ID, "context", "Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "sendCallToSellerClick", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/event/ContactSource;)V", "sendWriteToSellerClick", "(Ljava/lang/String;Lcom/avito/android/analytics/event/ContactSource;Ljava/lang/String;)V", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;", "event", "sendClickSearchSuggest", "(Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;)V", "sendSearchSubmit", "()V", "sendResetActionClick", "sendNotRestoreState", "saveState", "()J", "stateId", "restoreState", "(J)V", "d", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "c", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "e", "Ljava/lang/String;", "fromPage", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", AuthSource.SEND_ABUSE, "J", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Lcom/avito/android/Features;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpAnalyticsInteractorImpl implements SerpAnalyticsInteractor {
    public long a;
    public final Analytics b;
    public final TreeStateIdGenerator c;
    public TreeClickStreamParent d;
    public final String e;
    public final Features f;

    public SerpAnalyticsInteractorImpl(@NotNull Analytics analytics, @NotNull TreeStateIdGenerator treeStateIdGenerator, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable String str, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = analytics;
        this.c = treeStateIdGenerator;
        this.d = treeClickStreamParent;
        this.e = str;
        this.f = features;
        this.a = treeStateIdGenerator.nextStateId();
    }

    @Override // com.avito.android.serp.analytics.SerpAnalyticsInteractor
    @NotNull
    public TreeClickStreamParent getParent() {
        return new TreeClickStreamParent(this.a, ScreenIdField.SERP.name(), null, null);
    }

    @Override // com.avito.android.serp.analytics.SerpAnalyticsInteractor
    public void restoreState(long j) {
        this.a = j;
        this.d = getParent();
    }

    @Override // com.avito.android.serp.analytics.SerpAnalyticsInteractor
    public long saveState() {
        return this.a;
    }

    @Override // com.avito.android.serp.analytics.SerpAnalyticsInteractor
    public void sendBackClick(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "categoryId");
        this.b.track(new BackPressSerpTreeEvent(this.c.nextStateId(), getParent(), str, z));
    }

    @Override // com.avito.android.serp.analytics.SerpAnalyticsInteractor
    public void sendCallToSellerClick(@NotNull String str, @Nullable String str2, @NotNull ContactSource contactSource) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        this.b.track(new CallToSellerEvent(str, null, str2, contactSource.getFromXl() ? CallToSellerEventKt.CALL_SOURCE_XL_ITEM : "s", 0));
    }

    @Override // com.avito.android.serp.analytics.SerpAnalyticsInteractor
    public void sendClickSearchSuggest(@NotNull SuggestAnalyticsEvent suggestAnalyticsEvent) {
        Intrinsics.checkNotNullParameter(suggestAnalyticsEvent, "event");
        this.b.track(ClickSuggestParametrizedEvent.Companion.fromAction(suggestAnalyticsEvent));
    }

    @Override // com.avito.android.serp.analytics.SerpAnalyticsInteractor
    public void sendClickShortcut(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "shortcutTitle");
        this.b.track(new ClickShortcutEvent(this.c.nextStateId(), getParent(), null, null, str, str2, 12, null));
    }

    @Override // com.avito.android.serp.analytics.SerpAnalyticsInteractor
    public void sendNotRestoreState() {
        this.b.track(new NotRestoreStateEvent(ScreenIdField.SERP.name()));
    }

    @Override // com.avito.android.serp.analytics.SerpAnalyticsInteractor
    public void sendResetActionClick() {
        this.b.track(new ClickResetSerpEvent());
    }

    @Override // com.avito.android.serp.analytics.SerpAnalyticsInteractor
    public void sendSearchSubmit() {
        this.b.track(new ClickSearchActionEvent());
    }

    @Override // com.avito.android.serp.analytics.SerpAnalyticsInteractor
    public void sendSerpLoad(@NotNull SearchParams searchParams, long j, @Nullable SerpDisplayType serpDisplayType, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        long nextStateId = this.c.nextStateId();
        this.a = nextStateId;
        this.b.track(new LoadSerpEvent(nextStateId, this.d, searchParams, j, null, serpDisplayType, this.e, str, str2));
        this.d = getParent();
    }

    @Override // com.avito.android.serp.analytics.SerpAnalyticsInteractor
    public void sendSerpShownEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "serpAppearanceUuid");
        if (this.f.getNewShowScreenClickstreamEvents().invoke().booleanValue()) {
            this.b.track(new ShowSerpEvent(str));
        }
    }

    @Override // com.avito.android.serp.analytics.SerpAnalyticsInteractor
    public void sendWriteToSellerClick(@NotNull String str, @NotNull ContactSource contactSource, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        this.b.track(new WriteToSellerTreeEvent(this.c.nextStateId(), this.d, str, contactSource.getFromXl() ? WriteToSellerTreeEvent.SOURCE_XL_ADVERT_SNIPPET : "s", contactSource.getBlock(), ScreenIdField.SERP.getId(), str2));
    }
}
