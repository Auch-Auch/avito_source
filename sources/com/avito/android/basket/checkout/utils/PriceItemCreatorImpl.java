package com.avito.android.basket.checkout.utils;

import com.avito.android.basket_legacy.utils.PriceFormatter;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/basket/checkout/utils/PriceItemCreatorImpl;", "Lcom/avito/android/basket/checkout/utils/PriceItemCreator;", "", "template", "", "value", "Lcom/avito/android/basket/checkout/item/price/PriceItem;", "createPriceItem", "(Ljava/lang/String;I)Lcom/avito/android/basket/checkout/item/price/PriceItem;", "Lcom/avito/android/basket_legacy/utils/PriceFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/basket_legacy/utils/PriceFormatter;", "formatter", "<init>", "(Lcom/avito/android/basket_legacy/utils/PriceFormatter;)V", "Companion", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class PriceItemCreatorImpl implements PriceItemCreator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final PriceFormatter a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/basket/checkout/utils/PriceItemCreatorImpl$Companion;", "", "", "PRICE_ID", "Ljava/lang/String;", "PRICE_TEMPLATE_PLACEHOLDER", "<init>", "()V", "basket_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Inject
    public PriceItemCreatorImpl(@NotNull PriceFormatter priceFormatter) {
        Intrinsics.checkNotNullParameter(priceFormatter, "formatter");
        this.a = priceFormatter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    @Override // com.avito.android.basket.checkout.utils.PriceItemCreator
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.basket.checkout.item.price.PriceItem createPriceItem(@org.jetbrains.annotations.Nullable java.lang.String r11, int r12) {
        /*
            r10 = this;
            r0 = 0
            if (r12 != 0) goto L_0x0004
            goto L_0x0018
        L_0x0004:
            com.avito.android.basket_legacy.utils.PriceFormatter r1 = r10.a
            long r2 = (long) r12
            java.lang.String r6 = r1.format(r2)
            if (r11 == 0) goto L_0x0018
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r5 = "%price"
            r4 = r11
            java.lang.String r11 = t6.y.m.replace$default(r4, r5, r6, r7, r8, r9)
            goto L_0x0019
        L_0x0018:
            r11 = r0
        L_0x0019:
            if (r11 == 0) goto L_0x0022
            com.avito.android.basket.checkout.item.price.PriceItem r0 = new com.avito.android.basket.checkout.item.price.PriceItem
            java.lang.String r12 = "price"
            r0.<init>(r12, r11)
        L_0x0022:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.basket.checkout.utils.PriceItemCreatorImpl.createPriceItem(java.lang.String, int):com.avito.android.basket.checkout.item.price.PriceItem");
    }
}
