package com.avito.android.advert_core.discount.item.contact;

import com.avito.android.advert_core.contactbar.AdvertContactsView;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/avito/android/advert_core/discount/item/contact/ContactItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface ContactItemView extends ItemView, AdvertContactsView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ContactItemView contactItemView) {
            ItemView.DefaultImpls.onUnbind(contactItemView);
        }
    }
}
