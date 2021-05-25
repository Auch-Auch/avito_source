package com.avito.android.advert.item.sellerprofile;

import com.avito.android.advert.item.AdvertDeeplinkRouter;
import com.avito.android.advert_core.contactbar.AdvertContactsView;
import com.avito.android.advert_core.sellerprofile.ShowSellersProfileSource;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.AdvertDetails;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\nJ\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/advert/item/sellerprofile/AdvertSellerPresenter;", "", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfileView;", "view", "", "attachView", "(Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfileView;)V", "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsView;)V", "detachViews", "()V", "Lcom/avito/android/advert/item/AdvertDeeplinkRouter;", "router", "attachRouter", "(Lcom/avito/android/advert/item/AdvertDeeplinkRouter;)V", "detachRouter", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "bindData", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "bindExistingProfileData", "", "online", "updateOnlineStatus", "(Z)V", "Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;", "source", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "sendAnalyticsShowProfile", "(Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;Lcom/avito/android/deep_linking/links/DeepLink;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertSellerPresenter {
    void attachRouter(@NotNull AdvertDeeplinkRouter advertDeeplinkRouter);

    void attachView(@NotNull AdvertSellerProfileView advertSellerProfileView);

    void attachView(@NotNull AdvertContactsView advertContactsView);

    void bindData(@NotNull AdvertDetails advertDetails);

    void bindExistingProfileData();

    void detachRouter();

    void detachViews();

    void sendAnalyticsShowProfile(@NotNull ShowSellersProfileSource showSellersProfileSource, @NotNull DeepLink deepLink);

    void updateOnlineStatus(boolean z);
}
