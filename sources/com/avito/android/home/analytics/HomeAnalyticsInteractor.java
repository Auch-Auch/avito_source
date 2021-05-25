package com.avito.android.home.analytics;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\u000eJ\u001f\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\u000eJ\u000f\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001cH&¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/avito/android/home/analytics/HomeAnalyticsInteractor;", "", "", "locationId", "", "sendHomeLoad", "(Ljava/lang/String;)V", "mainAppearanceUuid", "sendHomeShownEvent", "shortcutTitle", "categoryId", "sendClickShortcut", "(Ljava/lang/String;Ljava/lang/String;)V", "sendClickShopShortcut", "()V", "sendShowAllCategories", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;", "event", "sendClickSearchSuggest", "(Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;)V", "sendSearchSubmit", "fromPage", "targetPage", "sendTabSelected", "sendNotRestoreState", "", "saveState", "()J", "stateId", "restoreState", "(J)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface HomeAnalyticsInteractor {
    @NotNull
    TreeClickStreamParent getParent();

    void restoreState(long j);

    long saveState();

    void sendClickSearchSuggest(@NotNull SuggestAnalyticsEvent suggestAnalyticsEvent);

    void sendClickShopShortcut();

    void sendClickShortcut(@NotNull String str, @Nullable String str2);

    void sendHomeLoad(@NotNull String str);

    void sendHomeShownEvent(@NotNull String str);

    void sendNotRestoreState();

    void sendSearchSubmit();

    void sendShowAllCategories();

    void sendTabSelected(@NotNull String str, @NotNull String str2);
}
