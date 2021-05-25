package com.avito.android.advert.item.sellerprofile;

import com.avito.android.advert_core.sellerprofile.SellerProfileClickSource;
import com.avito.android.remote.model.AdvertSeller;
import com.avito.android.remote.model.advert_details.UserIconType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfilePresenter;", "Lcom/avito/android/advert_core/sellerprofile/SellerProfileClickSource;", "Lcom/avito/android/remote/model/AdvertSeller;", "seller", "", "isShopAdvert", "isFromCompany", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "iconType", "", "bindSellerInfo", "(Lcom/avito/android/remote/model/AdvertSeller;ZZLcom/avito/android/remote/model/advert_details/UserIconType;)V", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfileView;", "view", "attachView", "(Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfileView;)V", "detachView", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertSellerProfilePresenter extends SellerProfileClickSource {
    void attachView(@NotNull AdvertSellerProfileView advertSellerProfileView);

    void bindSellerInfo(@NotNull AdvertSeller advertSeller, boolean z, boolean z2, @NotNull UserIconType userIconType);

    void detachView();
}
