package com.avito.android.basket_legacy.item;

import com.avito.android.basket_legacy.utils.CrossClickListener;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/basket_legacy/item/BasketItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/basket_legacy/item/BasketItemView;", "Lcom/avito/android/basket_legacy/item/BasketItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/basket_legacy/item/BasketItemView;Lcom/avito/android/basket_legacy/item/BasketItem;I)V", "Lcom/avito/android/basket_legacy/utils/CrossClickListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/basket_legacy/utils/CrossClickListener;", "crossClickListener", "<init>", "(Lcom/avito/android/basket_legacy/utils/CrossClickListener;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class BasketItemPresenter implements ItemPresenter<BasketItemView, BasketItem> {
    public final CrossClickListener a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ BasketItemPresenter a;
        public final /* synthetic */ BasketItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BasketItemPresenter basketItemPresenter, BasketItem basketItem) {
            super(0);
            this.a = basketItemPresenter;
            this.b = basketItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.onCrossClick(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public BasketItemPresenter(@NotNull CrossClickListener crossClickListener) {
        Intrinsics.checkNotNullParameter(crossClickListener, "crossClickListener");
        this.a = crossClickListener;
    }

    public void bindView(@NotNull BasketItemView basketItemView, @NotNull BasketItem basketItem, int i) {
        Intrinsics.checkNotNullParameter(basketItemView, "view");
        Intrinsics.checkNotNullParameter(basketItem, "item");
        basketItemView.setTitle(basketItem.getTitle());
        basketItemView.setPrice(basketItem.getPrice());
        basketItemView.setOldPrice(basketItem.getOldPrice());
        basketItemView.setSubtitle(basketItem.getSubTitle());
        basketItemView.setCancelable(basketItem.isCancelable());
        basketItemView.setPicture(AvitoPictureKt.pictureOf$default(basketItem.getIcon(), true, 0.0f, 0.0f, null, 28, null));
        basketItemView.setCrossClickListener(new a(this, basketItem));
    }
}
