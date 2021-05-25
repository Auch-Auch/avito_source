package com.avito.android.photo_gallery;

import android.app.Application;
import android.content.Intent;
import com.avito.android.PhotoGalleryIntentFactory;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.photo_gallery.LegacyPhotoGalleryActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import com.avito.android.util.AvitoCollectionUtils;
import com.avito.android.util.Constants;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010#J\u0001\u0010\u001a\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001c\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/photo_gallery/PhotoGalleryIntentFactoryImpl;", "Lcom/avito/android/PhotoGalleryIntentFactory;", "Lcom/avito/android/remote/model/Video;", "video", "", "Lcom/avito/android/remote/model/Image;", "images", "", VKApiConst.POSITION, "", BookingInfoActivity.EXTRA_ITEM_ID, "categoryId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Lcom/avito/android/remote/model/AdvertActions;", "actions", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "data", "", "stateId", "searchContext", "Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "autotekaTeaser", "Landroid/content/Intent;", "legacyPhotoGalleryIntent", "(Lcom/avito/android/remote/model/Video;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/remote/model/AdvertActions;Lcom/avito/android/remote/model/advert_details/ContactBarData;Ljava/lang/Long;Ljava/lang/String;Lcom/avito/android/remote/model/ForegroundImage;Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;)Landroid/content/Intent;", "photoGalleryIntent", "(Lcom/avito/android/remote/model/Video;Ljava/util/List;I)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoGalleryIntentFactoryImpl implements PhotoGalleryIntentFactory {
    public final Application a;

    @Inject
    public PhotoGalleryIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @Override // com.avito.android.PhotoGalleryIntentFactory
    @NotNull
    public Intent legacyPhotoGalleryIntent(@Nullable Video video, @NotNull List<Image> list, int i, @Nullable String str, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable AdvertActions advertActions, @Nullable ContactBarData contactBarData, @Nullable Long l, @Nullable String str3, @Nullable ForegroundImage foregroundImage, @Nullable AutotekaTeaserGalleryModel autotekaTeaserGalleryModel) {
        Intrinsics.checkNotNullParameter(list, "images");
        return new LegacyPhotoGalleryActivity.Factory().createIntent(this.a, video, list, i, str, str2, treeClickStreamParent, advertActions, contactBarData, l, str3, foregroundImage, autotekaTeaserGalleryModel);
    }

    @Override // com.avito.android.PhotoGalleryIntentFactory
    @NotNull
    public Intent photoGalleryIntent(@Nullable Video video, @NotNull List<Image> list, int i) {
        Intrinsics.checkNotNullParameter(list, "images");
        Intent putExtra = new Intent(this.a, PhotoGalleryActivity.class).putParcelableArrayListExtra("images", AvitoCollectionUtils.INSTANCE.asArrayList(list)).putExtra(Constants.IMAGE_POSITION, i).putExtra("video", video);
        Intrinsics.checkNotNullExpressionValue(putExtra, "createIntent<PhotoGaller…CTIVITY_KEY_VIDEO, video)");
        return putExtra;
    }
}
