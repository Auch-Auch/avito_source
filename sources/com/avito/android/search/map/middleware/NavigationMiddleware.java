package com.avito.android.search.map.middleware;

import android.os.Parcelable;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.redux.Middleware;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.serp.adapter.advert_xl.PhoneCallRouter;
import com.avito.android.util.UrlParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/search/map/middleware/NavigationMiddleware;", "Lcom/avito/android/redux/Middleware;", "Lcom/avito/android/search/map/SearchMapState;", "Lcom/avito/android/search/map/action/MapAction;", "Lcom/avito/android/search/map/middleware/NavigationMiddleware$Router;", "router", "", "attachRouter", "(Lcom/avito/android/search/map/middleware/NavigationMiddleware$Router;)V", "detachRouter", "()V", "Router", "map_release"}, k = 1, mv = {1, 4, 2})
public interface NavigationMiddleware extends Middleware<SearchMapState, MapAction> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u00018J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ3\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0014\u0010\tJ#\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0014\u0010\u0017J[\u0010 \u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u001f\u001a\u00020\u0010H&¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0002H&¢\u0006\u0004\b\"\u0010\u0004J#\u0010'\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%H&¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)H&¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-H&¢\u0006\u0004\b/\u00100J'\u00105\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u0010H&¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0002H&¢\u0006\u0004\b7\u0010\u0004¨\u00069"}, d2 = {"Lcom/avito/android/search/map/middleware/NavigationMiddleware$Router;", "Lcom/avito/android/serp/adapter/advert_xl/PhoneCallRouter;", "", "close", "()V", "leaveScreen", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "clarifySearchByDeeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/remote/model/search/map/Area;", "area", "", "mapSerpState", "", UrlParams.SIMPLE_MAP, "showFiltersScreen", "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;Z)V", "followDeepLink", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "itemId", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "isMarketplace", "openAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)V", "showApplicationPermissionsSettings", "Lcom/avito/android/search/map/middleware/NavigationMiddleware$Router$Reason;", "reason", "Landroid/os/Parcelable;", "successAuthResultData", "showAuth", "(Lcom/avito/android/search/map/middleware/NavigationMiddleware$Router$Reason;Landroid/os/Parcelable;)V", "", "message", "showToastMessage", "(I)V", "", "error", "showErrorMessage", "(Ljava/lang/Throwable;)V", "Lcom/avito/android/deep_linking/links/PhoneLink;", "link", BookingInfoActivity.EXTRA_ITEM_ID, "fromXl", "showCallDialog", "(Lcom/avito/android/deep_linking/links/PhoneLink;Ljava/lang/String;Z)V", "showNotificationSettingsScreen", "Reason", "map_release"}, k = 1, mv = {1, 4, 2})
    public interface Router extends PhoneCallRouter {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static /* synthetic */ void followDeepLink$default(Router router, DeepLink deepLink, TreeClickStreamParent treeClickStreamParent, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        treeClickStreamParent = null;
                    }
                    router.followDeepLink(deepLink, treeClickStreamParent);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: followDeepLink");
            }

            public static /* synthetic */ void openAdvertDetails$default(Router router, String str, String str2, String str3, String str4, String str5, Image image, TreeClickStreamParent treeClickStreamParent, boolean z, int i, Object obj) {
                if (obj == null) {
                    router.openAdvertDetails(str, str2, str3, str4, str5, image, treeClickStreamParent, (i & 128) != 0 ? false : z);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openAdvertDetails");
            }

            public static /* synthetic */ void showAuth$default(Router router, Reason reason, Parcelable parcelable, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        parcelable = null;
                    }
                    router.showAuth(reason, parcelable);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAuth");
            }

            public static /* synthetic */ void showFiltersScreen$default(Router router, SearchParams searchParams, Area area, String str, boolean z, int i, Object obj) {
                if (obj == null) {
                    if ((i & 8) != 0) {
                        z = false;
                    }
                    router.showFiltersScreen(searchParams, area, str, z);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFiltersScreen");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/search/map/middleware/NavigationMiddleware$Router$Reason;", "", "<init>", "(Ljava/lang/String;I)V", "SEARCH_SUBSCRIPTION", "PHONE_REQUEST", "map_release"}, k = 1, mv = {1, 4, 2})
        public enum Reason {
            SEARCH_SUBSCRIPTION,
            PHONE_REQUEST
        }

        void clarifySearchByDeeplink(@NotNull DeepLink deepLink);

        void close();

        void followDeepLink(@NotNull DeepLink deepLink);

        void followDeepLink(@NotNull DeepLink deepLink, @Nullable TreeClickStreamParent treeClickStreamParent);

        void leaveScreen();

        void openAdvertDetails(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, @Nullable TreeClickStreamParent treeClickStreamParent, boolean z);

        void showApplicationPermissionsSettings();

        void showAuth(@NotNull Reason reason, @Nullable Parcelable parcelable);

        void showCallDialog(@NotNull PhoneLink phoneLink, @NotNull String str, boolean z);

        void showErrorMessage(@NotNull Throwable th);

        void showFiltersScreen(@NotNull SearchParams searchParams, @Nullable Area area, @NotNull String str, boolean z);

        void showNotificationSettingsScreen();

        void showToastMessage(int i);
    }

    void attachRouter(@NotNull Router router);

    void detachRouter();
}
