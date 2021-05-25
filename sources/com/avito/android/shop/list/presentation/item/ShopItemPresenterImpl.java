package com.avito.android.shop.list.presentation.item;

import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/shop/list/presentation/item/ShopItemPresenterImpl;", "Lcom/avito/android/shop/list/presentation/item/ShopItemPresenter;", "Lcom/avito/android/shop/list/presentation/item/ShopItemView;", "view", "Lcom/avito/android/shop/list/presentation/item/ShopItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/shop/list/presentation/item/ShopItemView;Lcom/avito/android/shop/list/presentation/item/ShopItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/shop/list/presentation/item/ShopClickListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopItemPresenterImpl implements ShopItemPresenter {
    public final Lazy<ShopClickListener> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ShopItemPresenterImpl a;
        public final /* synthetic */ ShopItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ShopItemPresenterImpl shopItemPresenterImpl, ShopItem shopItem) {
            super(0);
            this.a = shopItemPresenterImpl;
            this.b = shopItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((ShopClickListener) this.a.a.get()).onShopClick(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ShopItemPresenterImpl(@NotNull Lazy<ShopClickListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
    }

    public void bindView(@NotNull ShopItemView shopItemView, @NotNull ShopItem shopItem, int i) {
        Intrinsics.checkNotNullParameter(shopItemView, "view");
        Intrinsics.checkNotNullParameter(shopItem, "item");
        shopItemView.setTitle(shopItem.getName());
        shopItemView.setCategory(shopItem.getCategory());
        shopItemView.setDescription(shopItem.getItemsCountDescription());
        shopItemView.setPicture(AvitoPictureKt.pictureOf$default(shopItem.getLogo(), true, 0.0f, 0.0f, null, 28, null));
        shopItemView.setClickListener(new a(this, shopItem));
    }
}
