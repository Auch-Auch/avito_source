package com.avito.android.advert.item;

import android.os.Bundle;
import com.avito.android.advert.AdvertDetailsInteractor;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo;
import com.avito.android.advert.item.similars.ComplementarySection;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractorKt;
import com.avito.android.photo_gallery.common.GalleryPageListener;
import com.avito.android.remote.marketplace.AdvertMarketPlace;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.DeliveryInfoResponse;
import com.avito.android.remote.model.Location;
import com.avito.android.section.expand_sections_button.ExpandComplementarySectionsListener;
import com.avito.android.serp.adapter.PersistableSpannedItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H&¢\u0006\u0004\b\u001a\u0010\nJ%\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH&¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H&¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020%H&¢\u0006\u0004\b(\u0010'J#\u0010-\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+H&¢\u0006\u0004\b-\u0010.J\u0019\u00101\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010/H&¢\u0006\u0004\b1\u00102J\u001f\u00107\u001a\u00020\u00062\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205H&¢\u0006\u0004\b7\u00108¨\u00069"}, d2 = {"Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "Lcom/avito/android/photo_gallery/common/GalleryPageListener;", "Lcom/avito/android/advert/item/AdvertDetailsItemsHolder;", "Lcom/avito/android/section/expand_sections_button/ExpandComplementarySectionsListener;", "Lcom/avito/android/advert/item/AdvertDetailsView;", "view", "", "attachView", "(Lcom/avito/android/advert/item/AdvertDetailsView;)V", "detachView", "()V", "clearItems", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "bundle", "restoreState", "(Landroid/os/Bundle;)V", "Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsWithMeta;", "advert", "bindAdvertData", "(Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsWithMeta;)V", "Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;", "fastOpenParams", "bindFastAdvertData", "(Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;)V", "refreshAdvertData", "Lcom/avito/android/remote/model/AdvertDetails;", "", "Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "similarsItems", "legacyBindComplementaryItems", "(Lcom/avito/android/remote/model/AdvertDetails;Ljava/util/List;)V", "Lcom/avito/android/advert/item/similars/ComplementarySection;", "complementarySection", "bindComplementarySection", "(Lcom/avito/android/remote/model/AdvertDetails;Lcom/avito/android/advert/item/similars/ComplementarySection;)V", "", "isComplementaryLoaded", "()Z", "hasComplementaryItems", "Lcom/avito/android/remote/marketplace/AdvertMarketPlace;", AdvertDetailsAnalyticsInteractorKt.SAFEDEAL_SERVICE_MARKETPLACE, "Lcom/avito/android/remote/model/DeliveryInfoResponse;", CommonKt.EXTRA_RESPONSE, "updateMarketplaceDeliveryInfoItem", "(Lcom/avito/android/remote/marketplace/AdvertMarketPlace;Lcom/avito/android/remote/model/DeliveryInfoResponse;)V", "Lcom/avito/android/remote/model/Location;", "location", "updateSelectedLocation", "(Lcom/avito/android/remote/model/Location;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$CalculatorLinkType;", "linkType", "", "monthlyPayment", "bindCreditBrokerLink", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$CalculatorLinkType;Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsItemsPresenter extends GalleryPageListener, AdvertDetailsItemsHolder, ExpandComplementarySectionsListener {
    void attachView(@Nullable AdvertDetailsView advertDetailsView);

    void bindAdvertData(@NotNull AdvertDetailsInteractor.AdvertDetailsWithMeta advertDetailsWithMeta);

    void bindComplementarySection(@NotNull AdvertDetails advertDetails, @NotNull ComplementarySection complementarySection);

    void bindCreditBrokerLink(@NotNull DfpCreditInfo.CreditCalculator.CalculatorLinkType calculatorLinkType, @NotNull String str);

    void bindFastAdvertData(@Nullable AdvertDetailsFastOpenParams advertDetailsFastOpenParams);

    void clearItems();

    void detachView();

    boolean hasComplementaryItems();

    boolean isComplementaryLoaded();

    void legacyBindComplementaryItems(@NotNull AdvertDetails advertDetails, @NotNull List<? extends PersistableSpannedItem> list);

    void refreshAdvertData();

    void restoreState(@NotNull Bundle bundle);

    @NotNull
    Bundle saveState();

    void updateMarketplaceDeliveryInfoItem(@Nullable AdvertMarketPlace advertMarketPlace, @Nullable DeliveryInfoResponse deliveryInfoResponse);

    void updateSelectedLocation(@Nullable Location location);
}
