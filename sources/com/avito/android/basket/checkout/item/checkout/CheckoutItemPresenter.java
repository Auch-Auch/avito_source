package com.avito.android.basket.checkout.item.checkout;

import com.avito.android.basket.checkout.ResourceProvider;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemView;", "Lcom/avito/android/basket/checkout/item/checkout/CheckoutItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemView;Lcom/avito/android/basket/checkout/item/checkout/CheckoutItem;I)V", "Lcom/avito/android/basket/checkout/ResourceProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/basket/checkout/ResourceProvider;", "resourceProvider", "Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemClickListener;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemClickListener;", "checkoutItemClickListener", "<init>", "(Lcom/avito/android/basket/checkout/ResourceProvider;Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemClickListener;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutItemPresenter implements ItemPresenter<CheckoutItemView, CheckoutItem> {
    public final ResourceProvider a;
    public final CheckoutItemClickListener b;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((CheckoutItemPresenter) this.b).b.onCrossButtonClicked((CheckoutItem) this.c);
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((CheckoutItemPresenter) this.b).b.onBackToBasketButtonClicked((CheckoutItem) this.c);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @Inject
    public CheckoutItemPresenter(@NotNull ResourceProvider resourceProvider, @NotNull CheckoutItemClickListener checkoutItemClickListener) {
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(checkoutItemClickListener, "checkoutItemClickListener");
        this.a = resourceProvider;
        this.b = checkoutItemClickListener;
    }

    public void bindView(@NotNull CheckoutItemView checkoutItemView, @NotNull CheckoutItem checkoutItem, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(checkoutItemView, "view");
        Intrinsics.checkNotNullParameter(checkoutItem, "item");
        checkoutItemView.setTitle(checkoutItem.getTitle());
        checkoutItemView.setPrice(checkoutItem.getPrice());
        checkoutItemView.setOldPrice(checkoutItem.getOldPrice());
        checkoutItemView.setPicture(AvitoPictureKt.pictureOf$default(checkoutItem.getPicture(), true, 0.0f, 0.0f, null, 28, null));
        boolean hasProlongation = checkoutItem.getHasProlongation();
        if (hasProlongation) {
            i2 = this.a.getNoPadding();
        } else if (!hasProlongation) {
            i2 = this.a.getCheckoutItemDefaultPadding();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        checkoutItemView.setBottomPadding(i2);
        if (checkoutItem.isActive()) {
            checkoutItemView.setItemActive(checkoutItem.isCancellable());
        } else {
            checkoutItemView.setItemInactive(checkoutItem.isCancellable());
        }
        checkoutItemView.setOnCrossClickListener(new a(0, this, checkoutItem));
        checkoutItemView.setOnBackToBasketClickListener(new a(1, this, checkoutItem));
    }
}
