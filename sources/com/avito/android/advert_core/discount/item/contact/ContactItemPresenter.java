package com.avito.android.advert_core.discount.item.contact;

import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert_core/discount/item/contact/ContactItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert_core/discount/item/contact/ContactItemView;", "Lcom/avito/android/advert_core/discount/item/contact/ContactItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert_core/discount/item/contact/ContactItemView;Lcom/avito/android/advert_core/discount/item/contact/ContactItem;I)V", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "advertContactsPresenter", "<init>", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class ContactItemPresenter implements ItemPresenter<ContactItemView, ContactItem> {
    public final AdvertContactsPresenter a;

    @Inject
    public ContactItemPresenter(@NotNull AdvertContactsPresenter advertContactsPresenter) {
        Intrinsics.checkNotNullParameter(advertContactsPresenter, "advertContactsPresenter");
        this.a = advertContactsPresenter;
    }

    public void bindView(@NotNull ContactItemView contactItemView, @NotNull ContactItem contactItem, int i) {
        Intrinsics.checkNotNullParameter(contactItemView, "view");
        Intrinsics.checkNotNullParameter(contactItem, "item");
        this.a.attachEmbeddedView(contactItemView);
        this.a.bindEmbeddedData(contactItem.getActions(), contactItem.getContactBarData());
    }
}
