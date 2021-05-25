package com.avito.android.advert_core.marketplace;

import android.os.Bundle;
import com.avito.android.advert_core.contactbar.AdvertContactsView;
import com.avito.android.analytics.event.cart.OpenCartEvent;
import com.avito.android.cart_fab.CartFabView;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.ParametrizedEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0015H&¢\u0006\u0004\b\u001a\u0010\u0018J\u0019\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001fH&¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;", "", "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "view", "", "attachView", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsView;)V", "Lcom/avito/android/cart_fab/CartFabView;", "(Lcom/avito/android/cart_fab/CartFabView;)V", "detachViews", "()V", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "state", "restoreState", "(Landroid/os/Bundle;)V", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "bindAdvert", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "", "context", "setSearchContext", "(Ljava/lang/String;)V", "itemId", "addItemToCart", "Lcom/avito/android/remote/model/ParametrizedEvent;", "event", "setContactEvent", "(Lcom/avito/android/remote/model/ParametrizedEvent;)V", "Lcom/avito/android/analytics/event/cart/OpenCartEvent$Source;", "source", "trackGoToCartClicked", "(Lcom/avito/android/analytics/event/cart/OpenCartEvent$Source;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface MarketplacePresenter {
    void addItemToCart(@NotNull String str);

    void attachView(@NotNull AdvertContactsView advertContactsView);

    void attachView(@NotNull CartFabView cartFabView);

    void bindAdvert(@NotNull AdvertDetails advertDetails);

    void detachViews();

    void restoreState(@Nullable Bundle bundle);

    @NotNull
    Bundle saveState();

    void setContactEvent(@Nullable ParametrizedEvent parametrizedEvent);

    void setSearchContext(@Nullable String str);

    void trackGoToCartClicked(@Nullable OpenCartEvent.Source source);
}
