package com.avito.android.basket.checkout;

import android.content.res.Resources;
import com.avito.android.basket.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/avito/android/basket/checkout/ResourceProviderImpl;", "Lcom/avito/android/basket/checkout/ResourceProvider;", "", AuthSource.BOOKING_ORDER, "I", "getDefaultItemOffset", "()I", "defaultItemOffset", "d", "getNoPadding", "noPadding", "c", "getCheckoutItemDefaultPadding", "checkoutItemDefaultPadding", AuthSource.SEND_ABUSE, "getProlongationTariffOffset", "prolongationTariffOffset", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class ResourceProviderImpl implements ResourceProvider {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    @Inject
    public ResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources.getDimensionPixelOffset(R.dimen.padding_prolongation_tariff);
        this.b = resources.getDimensionPixelOffset(R.dimen.padding_checkout_side);
        this.c = resources.getDimensionPixelOffset(R.dimen.padding_checkout_item_bottom);
        this.d = resources.getDimensionPixelOffset(R.dimen.padding_checkout_item_prolongation);
    }

    @Override // com.avito.android.basket.checkout.ResourceProvider
    public int getCheckoutItemDefaultPadding() {
        return this.c;
    }

    @Override // com.avito.android.basket.checkout.ResourceProvider
    public int getDefaultItemOffset() {
        return this.b;
    }

    @Override // com.avito.android.basket.checkout.ResourceProvider
    public int getNoPadding() {
        return this.d;
    }

    @Override // com.avito.android.basket.checkout.ResourceProvider
    public int getProlongationTariffOffset() {
        return this.a;
    }
}
