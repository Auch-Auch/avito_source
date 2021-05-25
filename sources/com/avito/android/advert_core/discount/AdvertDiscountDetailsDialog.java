package com.avito.android.advert_core.discount;

import android.content.Context;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.photo_gallery.LegacyPhotoGalleryActivityKt;
import com.avito.android.remote.model.AdvertDiscounts;
import com.avito.android.remote.model.advert_details.ContactBarData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialog;", "", "Lcom/avito/android/remote/model/AdvertDiscounts;", "discounts", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "actions", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", LegacyPhotoGalleryActivityKt.LEGACY_PHOTO_GALLERY_KEY_CONTACT_DATA, "", "bindData", "(Lcom/avito/android/remote/model/AdvertDiscounts;Ljava/util/List;Lcom/avito/android/remote/model/advert_details/ContactBarData;)V", "Landroid/content/Context;", "context", "show", "(Landroid/content/Context;)V", "dismiss", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDiscountDetailsDialog {
    void bindData(@NotNull AdvertDiscounts advertDiscounts, @NotNull List<ContactBar.Action> list, @Nullable ContactBarData contactBarData);

    void dismiss();

    void show(@NotNull Context context);
}
