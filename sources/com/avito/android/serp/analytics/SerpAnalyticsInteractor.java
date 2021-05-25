package com.avito.android.serp.analytics;

import com.avito.android.analytics.event.ContactSource;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001JA\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u000bH&¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u000bH&¢\u0006\u0004\b*\u0010)J\u000f\u0010+\u001a\u00020\u000bH&¢\u0006\u0004\b+\u0010)J\u000f\u0010,\u001a\u00020\u0004H&¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0004H&¢\u0006\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;", "", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "total", "Lcom/avito/android/remote/model/SerpDisplayType;", "serpDisplayType", "", "fromSource", "xHash", "", "sendSerpLoad", "(Lcom/avito/android/remote/model/SearchParams;JLcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;Ljava/lang/String;)V", "serpAppearanceUuid", "sendSerpShownEvent", "(Ljava/lang/String;)V", "shortcutTitle", "categoryId", "sendClickShortcut", "(Ljava/lang/String;Ljava/lang/String;)V", "", "fromActionBar", "sendBackClick", "(Ljava/lang/String;Z)V", BookingInfoActivity.EXTRA_ITEM_ID, "context", "Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "sendCallToSellerClick", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/event/ContactSource;)V", "sendWriteToSellerClick", "(Ljava/lang/String;Lcom/avito/android/analytics/event/ContactSource;Ljava/lang/String;)V", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;", "event", "sendClickSearchSuggest", "(Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;)V", "sendSearchSubmit", "()V", "sendResetActionClick", "sendNotRestoreState", "saveState", "()J", "stateId", "restoreState", "(J)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SerpAnalyticsInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void sendBackClick$default(SerpAnalyticsInteractor serpAnalyticsInteractor, String str, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                serpAnalyticsInteractor.sendBackClick(str, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendBackClick");
        }

        public static /* synthetic */ void sendSerpLoad$default(SerpAnalyticsInteractor serpAnalyticsInteractor, SearchParams searchParams, long j, SerpDisplayType serpDisplayType, String str, String str2, int i, Object obj) {
            if (obj == null) {
                serpAnalyticsInteractor.sendSerpLoad(searchParams, j, serpDisplayType, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendSerpLoad");
        }
    }

    @NotNull
    TreeClickStreamParent getParent();

    void restoreState(long j);

    long saveState();

    void sendBackClick(@NotNull String str, boolean z);

    void sendCallToSellerClick(@NotNull String str, @Nullable String str2, @NotNull ContactSource contactSource);

    void sendClickSearchSuggest(@NotNull SuggestAnalyticsEvent suggestAnalyticsEvent);

    void sendClickShortcut(@NotNull String str, @Nullable String str2);

    void sendNotRestoreState();

    void sendResetActionClick();

    void sendSearchSubmit();

    void sendSerpLoad(@NotNull SearchParams searchParams, long j, @Nullable SerpDisplayType serpDisplayType, @Nullable String str, @Nullable String str2);

    void sendSerpShownEvent(@NotNull String str);

    void sendWriteToSellerClick(@NotNull String str, @NotNull ContactSource contactSource, @Nullable String str2);
}
