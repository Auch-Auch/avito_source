package com.avito.android.developments_catalog;

import android.os.Bundle;
import com.avito.android.advert_core.RetryListener;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.developments_catalog.items.avitoOffers.AvitoOfferListener;
import com.avito.android.developments_catalog.items.contactbar.PhoneCallListener;
import com.avito.android.developments_catalog.items.description.DescriptionExpandListener;
import com.avito.android.developments_catalog.items.disclaimer.DisclaimerDetailsClickListener;
import com.avito.android.photo_gallery.common.GalleryPageListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH&¢\u0006\u0004\b\u0012\u0010\rJ\u000f\u0010\u0013\u001a\u00020\tH&¢\u0006\u0004\b\u0013\u0010\rJ\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\tH&¢\u0006\u0004\b\u001e\u0010\rJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b#\u0010\u001d¨\u0006$"}, d2 = {"Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;", "Lcom/avito/android/advert_core/RetryListener;", "Lcom/avito/android/photo_gallery/common/GalleryPageListener;", "Lcom/avito/android/developments_catalog/items/contactbar/PhoneCallListener;", "Lcom/avito/android/developments_catalog/items/description/DescriptionExpandListener;", "Lcom/avito/android/developments_catalog/items/avitoOffers/AvitoOfferListener;", "Lcom/avito/android/developments_catalog/items/disclaimer/DisclaimerDetailsClickListener;", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogView;", "view", "", "attachView", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogView;)V", "detachView", "()V", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "router", "attachRouter", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;)V", "detachRouter", "startLoadingData", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "state", "restoreState", "(Landroid/os/Bundle;)V", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "onCallButtonClick", "(Lcom/avito/android/deep_linking/links/PhoneLink;)V", "trackContactButtonClick", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "call", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface DevelopmentsCatalogPresenter extends RetryListener, GalleryPageListener, PhoneCallListener, DescriptionExpandListener, AvitoOfferListener, DisclaimerDetailsClickListener {
    void attachRouter(@Nullable DevelopmentsCatalogRouter developmentsCatalogRouter);

    void attachView(@NotNull DevelopmentsCatalogView developmentsCatalogView);

    void call(@NotNull PhoneLink phoneLink);

    void detachRouter();

    void detachView();

    void followDeepLink(@NotNull DeepLink deepLink);

    void onCallButtonClick(@NotNull PhoneLink phoneLink);

    void restoreState(@Nullable Bundle bundle);

    @NotNull
    Bundle saveState();

    void startLoadingData();

    void trackContactButtonClick();
}
