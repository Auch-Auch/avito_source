package com.avito.android.advert.item;

import android.os.Bundle;
import com.avito.android.advert.item.abuse.AdvertDetailsAbusePresenter;
import com.avito.android.advert.item.additionalSeller.AdditionalSellerView;
import com.avito.android.advert.item.address.AdvertDetailsAddressView;
import com.avito.android.advert.item.consultation.AdvertDetailsConsultationView;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditViewModel;
import com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkPresenter;
import com.avito.android.advert.item.georeference.AdvertDetailsGeoReferencePresenter;
import com.avito.android.advert.item.marketplace_contactbar.MarketplaceContactBarPresenter;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter;
import com.avito.android.advert.item.marketplace_faq.MarketplaceFaqPresenter;
import com.avito.android.advert.item.marketplace_info.MarketplaceInfoPresenter;
import com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsPresenter;
import com.avito.android.advert.item.price_subscription.AdvertDetailsPriceSubscriptionView;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentView;
import com.avito.android.advert.item.show_description_button.ShowDescriptionClickListener;
import com.avito.android.advert.item.show_on_map.AdvertDetailsShowOnMapView;
import com.avito.android.advert.item.similars_button.SimilarsButtonClickListener;
import com.avito.android.advert.item.verification.AdvertVerificationPresenter;
import com.avito.android.advert_core.advert.AdvertDetailsFlatsListener;
import com.avito.android.advert_core.advert.AdvertDetailsGroupsListener;
import com.avito.android.advert_core.advert.DescriptionListener;
import com.avito.android.advert_core.contactbar.AddToCartData;
import com.avito.android.home.HomeAdapterListener;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.delivery.DeliveryFlowResult;
import com.avito.android.section.SectionRouter;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.facebook.share.internal.ShareConstants;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u00122\u00020\u00132\u00020\u00142\u00020\u00152\u00020\u00162\u00020\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u001aH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u001aH&¢\u0006\u0004\b#\u0010\u001eJ\u0017\u0010&\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u001aH&¢\u0006\u0004\b(\u0010\u001eJ\u000f\u0010)\u001a\u00020\u001aH&¢\u0006\u0004\b)\u0010\u001eJ\u000f\u0010*\u001a\u00020\u001aH&¢\u0006\u0004\b*\u0010\u001eJ\u000f\u0010+\u001a\u00020\u001aH&¢\u0006\u0004\b+\u0010\u001eJ\u000f\u0010,\u001a\u00020\u001aH&¢\u0006\u0004\b,\u0010\u001eJ!\u00101\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010/H&¢\u0006\u0004\b1\u00102J!\u00103\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010/H&¢\u0006\u0004\b3\u00102J\u0017\u00104\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020-H&¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020\u001a2\u0006\u00107\u001a\u000206H&¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u001aH&¢\u0006\u0004\b:\u0010\u001eJ\u0019\u0010=\u001a\u00020\u001a2\b\u0010<\u001a\u0004\u0018\u00010;H&¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u001aH&¢\u0006\u0004\b?\u0010\u001eJ\u000f\u0010@\u001a\u00020\u001aH&¢\u0006\u0004\b@\u0010\u001eJ\u0011\u0010B\u001a\u0004\u0018\u00010AH&¢\u0006\u0004\bB\u0010CJ\u0019\u0010E\u001a\u00020\u001a2\b\u0010D\u001a\u0004\u0018\u00010AH&¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u001aH&¢\u0006\u0004\bG\u0010\u001eJ\u0017\u0010I\u001a\u00020\u001a2\u0006\u0010H\u001a\u000206H&¢\u0006\u0004\bI\u00109J\u000f\u0010J\u001a\u00020\u001aH&¢\u0006\u0004\bJ\u0010\u001eJ\u0017\u0010M\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020KH&¢\u0006\u0004\bM\u0010NJ\u0017\u0010Q\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020OH&¢\u0006\u0004\bQ\u0010R¨\u0006S"}, d2 = {"Lcom/avito/android/advert/item/AdvertDetailsPresenter;", "Lcom/avito/android/advert/item/address/AdvertDetailsAddressView$Listener;", "Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapView$Listener;", "Lcom/avito/android/advert/item/price_subscription/AdvertDetailsPriceSubscriptionView$Listener;", "Lcom/avito/android/advert/item/georeference/AdvertDetailsGeoReferencePresenter$OpenMapListener;", "Lcom/avito/android/advert/item/abuse/AdvertDetailsAbusePresenter$Listener;", "Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsPresenter$Listener;", "Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoPresenter$Listener;", "Lcom/avito/android/advert/item/marketplace_contactbar/MarketplaceContactBarPresenter$Listener;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter$Listener;", "Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqPresenter$Listener;", "Lcom/avito/android/advert_core/advert/DescriptionListener;", "Lcom/avito/android/home/HomeAdapterListener;", "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatsListener;", "Lcom/avito/android/advert_core/advert/AdvertDetailsGroupsListener;", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView$Listener;", "Lcom/avito/android/advert/item/consultation/AdvertDetailsConsultationView$Listener;", "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerView$Listener;", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", "Lcom/avito/android/advert/item/similars_button/SimilarsButtonClickListener;", "Lcom/avito/android/advert/item/show_description_button/ShowDescriptionClickListener;", "Lcom/avito/android/advert/item/verification/AdvertVerificationPresenter$OnHelpCenterClickedListener;", "Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkPresenter$Listener;", "Lcom/avito/android/section/SectionRouter;", "Lcom/avito/android/advert/item/AdvertDetailsRouter;", "router", "", "attachRouter", "(Lcom/avito/android/advert/item/AdvertDetailsRouter;)V", "detachRouter", "()V", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModel;", "dfpCreditViewModel", "attachDfpCreditViewModel", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModel;)V", "detachDfpCreditViewModel", "Lcom/avito/android/advert/item/AdvertDetailsView;", "view", "attachView", "(Lcom/avito/android/advert/item/AdvertDetailsView;)V", "detachView", "refresh", Tracker.Events.CREATIVE_START, "stop", "updateContacts", "", "currentPosition", "", "stateId", "handleGalleryClick", "(ILjava/lang/Long;)V", "handleVideoGalleryClick", "handleGalleryChangePosition", "(I)V", "", ShareConstants.MEDIA_URI, "handleAutoDealClick", "(Ljava/lang/String;)V", "handleExpressCvOkResult", "Lcom/avito/android/remote/model/delivery/DeliveryFlowResult;", "result", "handleDeliveryResults", "(Lcom/avito/android/remote/model/delivery/DeliveryFlowResult;)V", "handleUpdateAuthAddNoteResult", "onResume", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "savedInstanceState", "onRestoreState", "(Landroid/os/Bundle;)V", "showLoadingIndicatorAfterOnActivityResult", "message", "handleMessageResult", "trackEnableNotificationClick", "Lcom/avito/android/remote/model/Location;", "location", "handleLocationUpdate", "(Lcom/avito/android/remote/model/Location;)V", "Lcom/avito/android/advert_core/contactbar/AddToCartData;", "data", "handleOnCartActionAuthSuccess", "(Lcom/avito/android/advert_core/contactbar/AddToCartData;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsPresenter extends AdvertDetailsAddressView.Listener, AdvertDetailsShowOnMapView.Listener, AdvertDetailsPriceSubscriptionView.Listener, AdvertDetailsGeoReferencePresenter.OpenMapListener, AdvertDetailsAbusePresenter.Listener, MarketplaceSpecsPresenter.Listener, MarketplaceInfoPresenter.Listener, MarketplaceContactBarPresenter.Listener, MarketplaceDeliveryPresenter.Listener, MarketplaceFaqPresenter.Listener, DescriptionListener, HomeAdapterListener, AdvertDetailsFlatsListener, AdvertDetailsGroupsListener, AdvertDetailsShortTermRentView.Listener, AdvertDetailsConsultationView.Listener, AdditionalSellerView.Listener, AdBannerEventListener, SimilarsButtonClickListener, ShowDescriptionClickListener, AdvertVerificationPresenter.OnHelpCenterClickedListener, CreditBrokerLinkPresenter.Listener, SectionRouter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onMoreActionsClicked(@NotNull AdvertDetailsPresenter advertDetailsPresenter, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            HomeAdapterListener.DefaultImpls.onMoreActionsClicked(advertDetailsPresenter, str);
        }
    }

    void attachDfpCreditViewModel(@NotNull DfpCreditViewModel dfpCreditViewModel);

    void attachRouter(@NotNull AdvertDetailsRouter advertDetailsRouter);

    void attachView(@NotNull AdvertDetailsView advertDetailsView);

    void detachDfpCreditViewModel();

    void detachRouter();

    void detachView();

    void handleAutoDealClick(@NotNull String str);

    void handleDeliveryResults(@Nullable DeliveryFlowResult deliveryFlowResult);

    void handleExpressCvOkResult();

    void handleGalleryChangePosition(int i);

    void handleGalleryClick(int i, @Nullable Long l);

    void handleLocationUpdate(@NotNull Location location);

    void handleMessageResult(@NotNull String str);

    void handleOnCartActionAuthSuccess(@NotNull AddToCartData addToCartData);

    void handleUpdateAuthAddNoteResult();

    void handleVideoGalleryClick(int i, @Nullable Long l);

    void onRestoreState(@Nullable Bundle bundle);

    void onResume();

    @Nullable
    Bundle onSaveState();

    void refresh();

    void showLoadingIndicatorAfterOnActivityResult();

    void start();

    void stop();

    void trackEnableNotificationClick();

    void updateContacts();
}
