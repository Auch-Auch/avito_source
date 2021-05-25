package com.avito.android.serp;

import android.os.Parcelable;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.design.widget.dfp_debug.DfpDebugRouter;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.serp.adapter.advert_xl.PhoneCallRouter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u00012\u00020\u0002J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u000bJ\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0013\u0010\u0017Jc\u0010#\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b#\u0010$J3\u0010&\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010%\u001a\u00020!H&¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0007H&¢\u0006\u0004\b(\u0010\u000bJ\u0017\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0003H&¢\u0006\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/avito/android/serp/SerpRouter;", "Lcom/avito/android/design/widget/dfp_debug/DfpDebugRouter;", "Lcom/avito/android/serp/adapter/advert_xl/PhoneCallRouter;", "", "src", "Landroid/os/Parcelable;", "authPendingData", "", "showAuth", "(Ljava/lang/String;Landroid/os/Parcelable;)V", "leaveScreen", "()V", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "showClarifyScreen", "(Lcom/avito/android/remote/model/SearchParams;)V", "showNotificationSettingsScreen", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "itemId", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "", "galleryPosition", "", "isMarketplace", "openAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/Integer;Z)V", "showJobNearbyBanner", "openSerpWithBackstack", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Z)V", "closeSearch", "channelId", "openMessenger", "(Ljava/lang/String;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface SerpRouter extends DfpDebugRouter, PhoneCallRouter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void openSerpWithBackstack$default(SerpRouter serpRouter, SearchParams searchParams, String str, TreeClickStreamParent treeClickStreamParent, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    z = false;
                }
                serpRouter.openSerpWithBackstack(searchParams, str, treeClickStreamParent, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openSerpWithBackstack");
        }

        public static /* synthetic */ void showAuth$default(SerpRouter serpRouter, String str, Parcelable parcelable, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    parcelable = null;
                }
                serpRouter.showAuth(str, parcelable);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAuth");
        }
    }

    void closeSearch();

    void followDeepLink(@NotNull DeepLink deepLink);

    void followDeepLink(@NotNull DeepLink deepLink, @NotNull TreeClickStreamParent treeClickStreamParent);

    void leaveScreen();

    void openAdvertDetails(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable Integer num, boolean z);

    void openMessenger(@NotNull String str);

    void openSerpWithBackstack(@NotNull SearchParams searchParams, @Nullable String str, @NotNull TreeClickStreamParent treeClickStreamParent, boolean z);

    void showAuth(@NotNull String str, @Nullable Parcelable parcelable);

    void showClarifyScreen(@NotNull SearchParams searchParams);

    void showNotificationSettingsScreen();
}
