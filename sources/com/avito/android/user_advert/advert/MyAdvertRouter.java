package com.avito.android.user_advert.advert;

import android.net.Uri;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.CloseReason;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.VerificationStep;
import com.avito.android.remote.model.Video;
import com.avito.android.user_advert.AdvertActionTransferData;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\nJ9\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00072\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u001b\u0010\nJ7\u0010#\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!H&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0004H&¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H&¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0004H&¢\u0006\u0004\b*\u0010&J9\u00102\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u00162\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00101\u001a\u00020\u001cH&¢\u0006\u0004\b2\u00103J\u001b\u00104\u001a\u00020\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!H&¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b6\u0010\u0006J\u0017\u00108\u001a\u00020\u00042\u0006\u0010'\u001a\u000207H&¢\u0006\u0004\b8\u00109J%\u0010<\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\u0016H&¢\u0006\u0004\b<\u0010=J%\u0010@\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u0016H&¢\u0006\u0004\b@\u0010=J\u0017\u0010A\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0007H&¢\u0006\u0004\bA\u0010\nJ\u0017\u0010B\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\bB\u0010C¨\u0006D"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertRouter;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", BookingInfoActivity.EXTRA_ITEM_ID, "openFees", "(Ljava/lang/String;)V", "itemId", "action", "focusId", "openEdit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "draftId", "openDraftEdit", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "title", "", "Lcom/avito/android/remote/model/GeoReference;", "geoReferences", "showAddressOnMap", "(Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Ljava/util/List;)V", "showInactiveItem", "", "codeResult", "", "shouldShowAppRater", "soaUpdateMessage", "Lcom/avito/android/user_advert/AdvertActionTransferData;", "advertAction", "finish", "(IZLjava/lang/String;Lcom/avito/android/user_advert/AdvertActionTransferData;)V", "openAuth", "()V", "url", "openSharing", "(Ljava/lang/String;Ljava/lang/String;)V", "reopenScreen", "Lcom/avito/android/remote/model/Video;", "video", "Lcom/avito/android/remote/model/Image;", "images", "Lcom/avito/android/remote/model/ForegroundImage;", "infoImage", "currentItem", "showGalleryFullscreen", "(Lcom/avito/android/remote/model/Video;Ljava/util/List;Lcom/avito/android/remote/model/ForegroundImage;I)V", "openUserAdvertsScreen", "(Lcom/avito/android/user_advert/AdvertActionTransferData;)V", "showSellerCalendar", "Landroid/net/Uri;", "openUrl", "(Landroid/net/Uri;)V", "Lcom/avito/android/remote/model/CloseReason;", "reasons", "openSoaWithPriceBottomSheet", "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/avito/android/remote/model/VerificationStep;", "steps", "openVerificationWizard", "showHelpCenterScreen", "launchNestedIntent", "(Z)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface MyAdvertRouter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void finish$default(MyAdvertRouter myAdvertRouter, int i, boolean z, String str, AdvertActionTransferData advertActionTransferData, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    str = null;
                }
                if ((i2 & 8) != 0) {
                    advertActionTransferData = null;
                }
                myAdvertRouter.finish(i, z, str, advertActionTransferData);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finish");
        }

        public static /* synthetic */ void openEdit$default(MyAdvertRouter myAdvertRouter, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    str3 = null;
                }
                myAdvertRouter.openEdit(str, str2, str3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openEdit");
        }

        public static /* synthetic */ void openUserAdvertsScreen$default(MyAdvertRouter myAdvertRouter, AdvertActionTransferData advertActionTransferData, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    advertActionTransferData = null;
                }
                myAdvertRouter.openUserAdvertsScreen(advertActionTransferData);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openUserAdvertsScreen");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.user_advert.advert.MyAdvertRouter */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void showAddressOnMap$default(MyAdvertRouter myAdvertRouter, String str, Coordinates coordinates, String str2, List list, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    list = null;
                }
                myAdvertRouter.showAddressOnMap(str, coordinates, str2, list);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAddressOnMap");
        }
    }

    void finish(int i, boolean z, @Nullable String str, @Nullable AdvertActionTransferData advertActionTransferData);

    void launchNestedIntent(boolean z);

    void openAuth();

    @Override // com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel.DeepLinkRouter
    void openDeepLink(@NotNull DeepLink deepLink);

    void openDraftEdit(@NotNull String str);

    void openEdit(@NotNull String str, @Nullable String str2, @Nullable String str3);

    void openFees(@NotNull String str);

    void openSharing(@NotNull String str, @NotNull String str2);

    void openSoaWithPriceBottomSheet(@NotNull String str, @NotNull List<CloseReason> list);

    void openUrl(@NotNull Uri uri);

    void openUserAdvertsScreen(@Nullable AdvertActionTransferData advertActionTransferData);

    void openVerificationWizard(@NotNull String str, @NotNull List<VerificationStep> list);

    void reopenScreen();

    void showAddressOnMap(@NotNull String str, @NotNull Coordinates coordinates, @NotNull String str2, @Nullable List<GeoReference> list);

    void showGalleryFullscreen(@Nullable Video video, @NotNull List<Image> list, @Nullable ForegroundImage foregroundImage, int i);

    void showHelpCenterScreen(@NotNull String str);

    void showInactiveItem(@NotNull String str);

    @Override // com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel.DeepLinkRouter
    void showSellerCalendar(@NotNull DeepLink deepLink);
}
