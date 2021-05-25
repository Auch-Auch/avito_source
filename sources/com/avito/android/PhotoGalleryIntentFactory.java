package com.avito.android;

import android.content.Intent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0001\u0010\u001a\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001c\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/PhotoGalleryIntentFactory;", "", "Lcom/avito/android/remote/model/Video;", "video", "", "Lcom/avito/android/remote/model/Image;", "images", "", VKApiConst.POSITION, "", BookingInfoActivity.EXTRA_ITEM_ID, "categoryId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Lcom/avito/android/remote/model/AdvertActions;", "actions", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "data", "", "stateId", "searchContext", "Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "autotekaTeaser", "Landroid/content/Intent;", "legacyPhotoGalleryIntent", "(Lcom/avito/android/remote/model/Video;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/remote/model/AdvertActions;Lcom/avito/android/remote/model/advert_details/ContactBarData;Ljava/lang/Long;Ljava/lang/String;Lcom/avito/android/remote/model/ForegroundImage;Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;)Landroid/content/Intent;", "photoGalleryIntent", "(Lcom/avito/android/remote/model/Video;Ljava/util/List;I)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoGalleryIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent legacyPhotoGalleryIntent$default(PhotoGalleryIntentFactory photoGalleryIntentFactory, Video video, List list, int i, String str, String str2, TreeClickStreamParent treeClickStreamParent, AdvertActions advertActions, ContactBarData contactBarData, Long l, String str3, ForegroundImage foregroundImage, AutotekaTeaserGalleryModel autotekaTeaserGalleryModel, int i2, Object obj) {
            if (obj == null) {
                return photoGalleryIntentFactory.legacyPhotoGalleryIntent(video, list, i, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? null : treeClickStreamParent, (i2 & 64) != 0 ? null : advertActions, (i2 & 128) != 0 ? null : contactBarData, (i2 & 256) != 0 ? null : l, (i2 & 512) != 0 ? null : str3, (i2 & 1024) != 0 ? null : foregroundImage, (i2 & 2048) != 0 ? null : autotekaTeaserGalleryModel);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: legacyPhotoGalleryIntent");
        }
    }

    @NotNull
    Intent legacyPhotoGalleryIntent(@Nullable Video video, @NotNull List<Image> list, int i, @Nullable String str, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable AdvertActions advertActions, @Nullable ContactBarData contactBarData, @Nullable Long l, @Nullable String str3, @Nullable ForegroundImage foregroundImage, @Nullable AutotekaTeaserGalleryModel autotekaTeaserGalleryModel);

    @NotNull
    Intent photoGalleryIntent(@Nullable Video video, @NotNull List<Image> list, int i);
}
