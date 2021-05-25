package com.avito.android;

import android.content.Intent;
import android.net.Uri;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.model.ConsultationFormData;
import com.avito.android.remote.model.CpoDescription;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ModelSpecifications;
import com.vk.sdk.api.model.VKApiUserFull;
import com.vk.sdk.api.model.VKAttachments;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0001\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0013H&¢\u0006\u0004\b\"\u0010#J1\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020\rH&¢\u0006\u0004\b'\u0010(J=\u0010-\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010\u00022\b\u0010+\u001a\u0004\u0018\u00010\u00152\b\u0010,\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b-\u0010.Jq\u00105\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u000207H&¢\u0006\u0004\b9\u0010:J3\u0010>\u001a\u00020\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<H&¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020@H&¢\u0006\u0004\bB\u0010CJ;\u0010H\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00022\u0006\u0010F\u001a\u00020E2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00152\u0006\u0010$\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u0002H&¢\u0006\u0004\bH\u0010I¨\u0006J"}, d2 = {"Lcom/avito/android/AdvertDetailsIntentFactory;", "", "", "itemId", "Landroid/content/Intent;", "inactiveItemIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "", "isMarketplace", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "", "clickTime", "", "galleryPosition", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", "Lcom/avito/android/rec/ScreenSource;", "screenSource", "advertDetailsIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;ZLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;JLjava/lang/Integer;Lcom/avito/android/bottom_navigation/NavigationTab;Lcom/avito/android/rec/ScreenSource;)Landroid/content/Intent;", "serviceId", "externalId", "contactAccessService", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "objectId", "objectEntity", "badgeId", "badgeDetailsIntent", "(Ljava/lang/String;Ljava/lang/String;I)Landroid/content/Intent;", BookingInfoActivity.EXTRA_ITEM_ID, VKAttachments.TYPE_NOTE, "isFavorite", "advertDetailsNoteIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Landroid/content/Intent;", "id", "searchContext", "currentTab", "fromPage", "developmentsCatalog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/bottom_navigation/NavigationTab;Ljava/lang/String;)Landroid/content/Intent;", "generationId", "bodyTypeId", "modificationId", "from", "locationId", "advertMcid", "autoCatalog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/bottom_navigation/NavigationTab;)Landroid/content/Intent;", "Lcom/avito/android/remote/model/CpoDescription;", "description", "cpoProgram", "(Lcom/avito/android/remote/model/CpoDescription;)Landroid/content/Intent;", "developmentId", "Lcom/avito/android/remote/model/ConsultationFormData;", "form", "consultationForm", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ConsultationFormData;)Landroid/content/Intent;", "Lcom/avito/android/remote/model/ModelSpecifications;", "specifications", "advertSpecificationsIntent", "(Lcom/avito/android/remote/model/ModelSpecifications;)Landroid/content/Intent;", VKApiUserFull.RelativeType.PARTNER, "Landroid/net/Uri;", "url", "brokerSession", "creditPartnerIntent", "(Ljava/lang/String;Landroid/net/Uri;Lcom/avito/android/bottom_navigation/NavigationTab;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent advertDetailsIntent$default(AdvertDetailsIntentFactory advertDetailsIntentFactory, String str, String str2, String str3, String str4, String str5, Image image, boolean z, TreeClickStreamParent treeClickStreamParent, long j, Integer num, NavigationTab navigationTab, ScreenSource screenSource, int i, Object obj) {
            if (obj == null) {
                NavigationTab navigationTab2 = null;
                String str6 = (i & 2) != 0 ? null : str2;
                String str7 = (i & 4) != 0 ? null : str3;
                String str8 = (i & 8) != 0 ? null : str4;
                String str9 = (i & 16) != 0 ? null : str5;
                Image image2 = (i & 32) != 0 ? null : image;
                boolean z2 = (i & 64) != 0 ? false : z;
                TreeClickStreamParent treeClickStreamParent2 = (i & 128) != 0 ? null : treeClickStreamParent;
                long j2 = (i & 256) != 0 ? 0 : j;
                Integer num2 = (i & 512) != 0 ? null : num;
                if ((i & 1024) == 0) {
                    navigationTab2 = navigationTab;
                }
                return advertDetailsIntentFactory.advertDetailsIntent(str, str6, str7, str8, str9, image2, z2, treeClickStreamParent2, j2, num2, navigationTab2, (i & 2048) != 0 ? ScreenSource.EMPTY.INSTANCE : screenSource);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: advertDetailsIntent");
        }

        public static /* synthetic */ Intent autoCatalog$default(AdvertDetailsIntentFactory advertDetailsIntentFactory, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, NavigationTab navigationTab, int i, Object obj) {
            if (obj == null) {
                return advertDetailsIntentFactory.autoCatalog(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : navigationTab);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: autoCatalog");
        }

        public static /* synthetic */ Intent consultationForm$default(AdvertDetailsIntentFactory advertDetailsIntentFactory, String str, String str2, ConsultationFormData consultationFormData, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    consultationFormData = null;
                }
                return advertDetailsIntentFactory.consultationForm(str, str2, consultationFormData);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: consultationForm");
        }

        public static /* synthetic */ Intent creditPartnerIntent$default(AdvertDetailsIntentFactory advertDetailsIntentFactory, String str, Uri uri, NavigationTab navigationTab, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    navigationTab = null;
                }
                return advertDetailsIntentFactory.creditPartnerIntent(str, uri, navigationTab, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: creditPartnerIntent");
        }
    }

    @NotNull
    Intent advertDetailsIntent(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, boolean z, @Nullable TreeClickStreamParent treeClickStreamParent, long j, @Nullable Integer num, @Nullable NavigationTab navigationTab, @NotNull ScreenSource screenSource);

    @NotNull
    Intent advertDetailsNoteIntent(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z);

    @NotNull
    Intent advertSpecificationsIntent(@NotNull ModelSpecifications modelSpecifications);

    @NotNull
    Intent autoCatalog(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable NavigationTab navigationTab);

    @NotNull
    Intent badgeDetailsIntent(@NotNull String str, @NotNull String str2, int i);

    @NotNull
    Intent consultationForm(@Nullable String str, @Nullable String str2, @Nullable ConsultationFormData consultationFormData);

    @NotNull
    Intent contactAccessService(@NotNull String str, @Nullable String str2, @Nullable String str3);

    @NotNull
    Intent cpoProgram(@NotNull CpoDescription cpoDescription);

    @NotNull
    Intent creditPartnerIntent(@NotNull String str, @NotNull Uri uri, @Nullable NavigationTab navigationTab, @NotNull String str2, @NotNull String str3);

    @NotNull
    Intent developmentsCatalog(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable NavigationTab navigationTab, @Nullable String str4);

    @NotNull
    Intent inactiveItemIntent(@NotNull String str);
}
