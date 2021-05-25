package com.avito.android.user_advert.contact;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\u0010\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/avito/android/user_advert/contact/MyAdvertContactsPresenterImpl;", "Lcom/avito/android/user_advert/contact/MyAdvertContactsPresenter;", "Lcom/avito/android/user_advert/contact/MyAdvertContactsView;", "view", "", "attachView", "(Lcom/avito/android/user_advert/contact/MyAdvertContactsView;)V", "detachView", "()V", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Seller;", "advertSeller", "", "isFromCompany", "isShopItem", "", "phone", "bindContacts", "(Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Seller;ZZLjava/lang/String;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_advert/contact/MyAdvertContactsView;", "<init>", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertContactsPresenterImpl implements MyAdvertContactsPresenter {
    public MyAdvertContactsView a;

    @Override // com.avito.android.user_advert.contact.MyAdvertContactsPresenter
    public void attachView(@NotNull MyAdvertContactsView myAdvertContactsView) {
        Intrinsics.checkNotNullParameter(myAdvertContactsView, "view");
        this.a = myAdvertContactsView;
    }

    @Override // com.avito.android.user_advert.contact.MyAdvertContactsPresenter
    public void bindContacts(@Nullable MyAdvertDetails.Seller seller, boolean z, boolean z2, @Nullable String str) {
        UserIconType userIconType;
        MyAdvertContact myAdvertContact;
        String manager;
        String str2;
        if (z2) {
            userIconType = UserIconType.SHOP;
        } else if (z) {
            userIconType = UserIconType.COMPANY;
        } else {
            userIconType = UserIconType.PRIVATE;
        }
        MyAdvertContactsView myAdvertContactsView = this.a;
        if (myAdvertContactsView != null) {
            MyAdvertContact myAdvertContact2 = null;
            if (seller != null) {
                String name = seller.getName();
                if (z || z2) {
                    str2 = seller.getPostfix();
                } else {
                    str2 = str;
                }
                myAdvertContact = new MyAdvertContact(name, str2, userIconType, seller.getImage());
            } else {
                myAdvertContact = null;
            }
            if (myAdvertContact != null) {
                if (!(seller == null || (manager = seller.getManager()) == null)) {
                    myAdvertContact2 = new MyAdvertContact(manager, str, null, null, 12, null);
                }
                myAdvertContactsView.showContacts(CollectionsKt___CollectionsKt.filterNotNull(CollectionsKt__CollectionsKt.listOf((Object[]) new MyAdvertContact[]{myAdvertContact, myAdvertContact2})));
            }
        }
    }

    @Override // com.avito.android.user_advert.contact.MyAdvertContactsPresenter
    public void detachView() {
        this.a = null;
    }
}
