package com.avito.android.user_advert.contact;

import com.avito.android.remote.model.adverts.MyAdvertDetails;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/user_advert/contact/MyAdvertContactsPresenter;", "", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Seller;", "advertSeller", "", "isFromCompany", "isShopItem", "", "phone", "", "bindContacts", "(Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Seller;ZZLjava/lang/String;)V", "Lcom/avito/android/user_advert/contact/MyAdvertContactsView;", "view", "attachView", "(Lcom/avito/android/user_advert/contact/MyAdvertContactsView;)V", "detachView", "()V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface MyAdvertContactsPresenter {
    void attachView(@NotNull MyAdvertContactsView myAdvertContactsView);

    void bindContacts(@Nullable MyAdvertDetails.Seller seller, boolean z, boolean z2, @Nullable String str);

    void detachView();
}
