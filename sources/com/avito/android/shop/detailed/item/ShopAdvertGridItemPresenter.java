package com.avito.android.shop.detailed.item;

import com.avito.android.di.PerFragment;
import com.avito.android.recycler.responsive.ResponsiveItemPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.AdvertGridItemPresenter;
import com.avito.android.serp.adapter.AdvertGridItemView;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.shop.detailed.ShopItemVisibilityRecorder;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ(\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\r\u0010\u000eJ6\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0001¢\u0006\u0004\b\r\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopAdvertGridItemPresenter;", "Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;", "Lcom/avito/android/serp/adapter/AdvertGridItemView;", "Lcom/avito/android/serp/adapter/AdvertItem;", "Lcom/avito/android/serp/adapter/AdvertGridItemPresenter;", "view", "", VKApiConst.POSITION, "", "viewAttached", "(Lcom/avito/android/serp/adapter/AdvertGridItemView;I)V", "viewDetached", "item", "bindView", "(Lcom/avito/android/serp/adapter/AdvertGridItemView;Lcom/avito/android/serp/adapter/AdvertItem;I)V", "", "", "payloads", "(Lcom/avito/android/serp/adapter/AdvertGridItemView;Lcom/avito/android/serp/adapter/AdvertItem;ILjava/util/List;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/AdvertGridItemPresenter;", "advertGridItemPresenter", "Lcom/avito/android/shop/detailed/ShopItemVisibilityRecorder;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/shop/detailed/ShopItemVisibilityRecorder;", "shopItemVisibilityRecorder", "<init>", "(Lcom/avito/android/serp/adapter/AdvertGridItemPresenter;Lcom/avito/android/shop/detailed/ShopItemVisibilityRecorder;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopAdvertGridItemPresenter implements ResponsiveItemPresenter<AdvertGridItemView, AdvertItem>, AdvertGridItemPresenter {
    public final AdvertGridItemPresenter a;
    public final ShopItemVisibilityRecorder b;

    @Inject
    public ShopAdvertGridItemPresenter(@NotNull AdvertGridItemPresenter advertGridItemPresenter, @NotNull ShopItemVisibilityRecorder shopItemVisibilityRecorder) {
        Intrinsics.checkNotNullParameter(advertGridItemPresenter, "advertGridItemPresenter");
        Intrinsics.checkNotNullParameter(shopItemVisibilityRecorder, "shopItemVisibilityRecorder");
        this.a = advertGridItemPresenter;
        this.b = shopItemVisibilityRecorder;
    }

    public void bindView(@NotNull AdvertGridItemView advertGridItemView, @NotNull AdvertItem advertItem, int i) {
        Intrinsics.checkNotNullParameter(advertGridItemView, "view");
        Intrinsics.checkNotNullParameter(advertItem, "item");
        this.a.bindView(advertGridItemView, advertItem, i);
    }

    public void bindView(@NotNull AdvertGridItemView advertGridItemView, @NotNull AdvertItem advertItem, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(advertGridItemView, "view");
        Intrinsics.checkNotNullParameter(advertItem, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
        this.a.bindView(advertGridItemView, advertItem, i, list);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.konveyor.blueprint.ItemView, com.avito.konveyor.blueprint.Item, int, java.util.List] */
    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public /* bridge */ /* synthetic */ void bindView(AdvertGridItemView advertGridItemView, AdvertItem advertItem, int i, List list) {
        bindView(advertGridItemView, advertItem, i, (List<? extends Object>) list);
    }

    public void viewAttached(@NotNull AdvertGridItemView advertGridItemView, int i) {
        Intrinsics.checkNotNullParameter(advertGridItemView, "view");
        this.b.onItemBecomeVisible(i);
    }

    public void viewDetached(@NotNull AdvertGridItemView advertGridItemView, int i) {
        Intrinsics.checkNotNullParameter(advertGridItemView, "view");
        this.b.onItemBecomeInvisible(i);
    }
}
