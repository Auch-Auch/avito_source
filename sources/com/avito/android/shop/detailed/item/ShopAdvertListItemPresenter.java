package com.avito.android.shop.detailed.item;

import com.avito.android.di.PerFragment;
import com.avito.android.recycler.responsive.ResponsiveItemPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.AdvertListItemPresenter;
import com.avito.android.serp.adapter.AdvertListItemView;
import com.avito.android.shop.detailed.ShopItemVisibilityRecorder;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ(\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopAdvertListItemPresenter;", "Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;", "Lcom/avito/android/serp/adapter/AdvertListItemView;", "Lcom/avito/android/serp/adapter/AdvertItem;", "Lcom/avito/android/serp/adapter/AdvertListItemPresenter;", "view", "", VKApiConst.POSITION, "", "viewAttached", "(Lcom/avito/android/serp/adapter/AdvertListItemView;I)V", "viewDetached", "item", "bindView", "(Lcom/avito/android/serp/adapter/AdvertListItemView;Lcom/avito/android/serp/adapter/AdvertItem;I)V", "Lcom/avito/android/shop/detailed/ShopItemVisibilityRecorder;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/shop/detailed/ShopItemVisibilityRecorder;", "shopItemVisibilityRecorder", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/AdvertListItemPresenter;", "advertListItemPresenter", "<init>", "(Lcom/avito/android/serp/adapter/AdvertListItemPresenter;Lcom/avito/android/shop/detailed/ShopItemVisibilityRecorder;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopAdvertListItemPresenter implements ResponsiveItemPresenter<AdvertListItemView, AdvertItem>, AdvertListItemPresenter {
    public final AdvertListItemPresenter a;
    public final ShopItemVisibilityRecorder b;

    @Inject
    public ShopAdvertListItemPresenter(@NotNull AdvertListItemPresenter advertListItemPresenter, @NotNull ShopItemVisibilityRecorder shopItemVisibilityRecorder) {
        Intrinsics.checkNotNullParameter(advertListItemPresenter, "advertListItemPresenter");
        Intrinsics.checkNotNullParameter(shopItemVisibilityRecorder, "shopItemVisibilityRecorder");
        this.a = advertListItemPresenter;
        this.b = shopItemVisibilityRecorder;
    }

    public void bindView(@NotNull AdvertListItemView advertListItemView, @NotNull AdvertItem advertItem, int i) {
        Intrinsics.checkNotNullParameter(advertListItemView, "view");
        Intrinsics.checkNotNullParameter(advertItem, "item");
        this.a.bindView(advertListItemView, advertItem, i);
    }

    public void viewAttached(@NotNull AdvertListItemView advertListItemView, int i) {
        Intrinsics.checkNotNullParameter(advertListItemView, "view");
        this.b.onItemBecomeVisible(i);
    }

    public void viewDetached(@NotNull AdvertListItemView advertListItemView, int i) {
        Intrinsics.checkNotNullParameter(advertListItemView, "view");
        this.b.onItemBecomeInvisible(i);
    }
}
