package com.avito.android.advert_core.discount;

import com.avito.android.advert_core.discount.item.contact.ContactItem;
import com.avito.android.advert_core.discount.item.discount.DiscountItem;
import com.avito.android.advert_core.discount.item.divider.DividerItem;
import com.avito.android.advert_core.discount.item.information.InformationItem;
import com.avito.android.advert_core.discount.item.title.TitleItem;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.photo_gallery.LegacyPhotoGalleryActivityKt;
import com.avito.android.remote.model.AdvertDiscounts;
import com.avito.android.remote.model.Discount;
import com.avito.android.remote.model.MinPrice;
import com.avito.android.remote.model.TotalDiscount;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.conveyor_item.Item;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ5\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert_core/discount/AdvertDiscountItemConverterImpl;", "Lcom/avito/android/advert_core/discount/AdvertDiscountItemConverter;", "Lcom/avito/android/remote/model/AdvertDiscounts;", FirebaseAnalytics.Param.DISCOUNT, "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "actions", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", LegacyPhotoGalleryActivityKt.LEGACY_PHOTO_GALLERY_KEY_CONTACT_DATA, "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/AdvertDiscounts;Ljava/util/List;Lcom/avito/android/remote/model/advert_details/ContactBarData;)Ljava/util/List;", "<init>", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDiscountItemConverterImpl implements AdvertDiscountItemConverter {
    @Override // com.avito.android.advert_core.discount.AdvertDiscountItemConverter
    @NotNull
    public List<Item> convert(@NotNull AdvertDiscounts advertDiscounts, @NotNull List<ContactBar.Action> list, @Nullable ContactBarData contactBarData) {
        List<ContactBar.Action> listOf;
        boolean z;
        Intrinsics.checkNotNullParameter(advertDiscounts, FirebaseAnalytics.Param.DISCOUNT);
        Intrinsics.checkNotNullParameter(list, "actions");
        ArrayList arrayList = new ArrayList();
        String title = advertDiscounts.getTitle();
        T t = null;
        if (title != null) {
            arrayList.add(new TitleItem(null, title, 1, null));
        }
        List<Discount> discounts = advertDiscounts.getDiscounts();
        if (discounts != null) {
            for (T t2 : discounts) {
                arrayList.add(new DiscountItem(null, t2.getTitle(), t2.getValue(), t2.getValueColorName(), t2.getDescription(), false, 33, null));
            }
        }
        arrayList.add(new DividerItem(null, 1, null));
        TotalDiscount total = advertDiscounts.getTotal();
        if (total != null) {
            arrayList.add(new DiscountItem(null, total.getTitle(), total.getValue(), null, total.getDescription(), false, 41, null));
        }
        MinPrice minPrice = advertDiscounts.getMinPrice();
        if (minPrice != null) {
            arrayList.add(new DiscountItem(null, minPrice.getTitle(), minPrice.getValue(), null, null, true, 25, null));
        }
        String information = advertDiscounts.getInformation();
        if (information != null) {
            arrayList.add(new InformationItem(null, information, 1, null));
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (next.getType() == ContactBar.ActionType.PHONE) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        T t3 = t;
        arrayList.add(new ContactItem(null, (t3 == null || (listOf = d.listOf(t3)) == null) ? list : listOf, contactBarData, 1, null));
        return arrayList;
    }
}
