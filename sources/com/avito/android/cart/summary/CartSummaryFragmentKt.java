package com.avito.android.cart.summary;

import com.avito.android.cart.analytics.summary.StepperUsageType;
import com.avito.android.cart.summary.konveyor.product.ProductItem;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay3.PublishRelay;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"'\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u00028B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"3\u0010\r\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b0\u0000j\u0002`\n8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0016\u0010\u000e\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"'\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00100\u0000j\u0002`\u00118B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"3\u0010\u0019\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00150\b0\u0000j\u0002`\u00168B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/cart/summary/konveyor/product/ProductItem;", "Lcom/avito/android/cart/summary/DeleteItemRelay;", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getDeleteItemRelay", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "deleteItemRelay", "Lkotlin/Pair;", "", "Lcom/avito/android/cart/summary/QuantityChangesRelay;", AuthSource.SEND_ABUSE, "getProductQuantityRelay", "productQuantityRelay", "AUTH_REQUEST_CODE", "I", "", "Lcom/avito/android/cart/summary/OpenAdvertDetailsRelay;", "c", "getOpenAdvertDetailsRelay", "openAdvertDetailsRelay", "Lcom/avito/android/cart/analytics/summary/StepperUsageType;", "Lcom/avito/android/cart/summary/StepperUsageRelay;", "d", "getStepperUsageRelay", "stepperUsageRelay", "cart_release"}, k = 2, mv = {1, 4, 2})
public final class CartSummaryFragmentKt {
    public static final int AUTH_REQUEST_CODE = 11;
    public static final Lazy a;
    public static final Lazy b;
    public static final Lazy c;
    public static final Lazy d;

    public static final class a extends Lambda implements Function0<PublishRelay<ProductItem>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public PublishRelay<ProductItem> invoke() {
            return PublishRelay.create();
        }
    }

    public static final class b extends Lambda implements Function0<PublishRelay<String>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public PublishRelay<String> invoke() {
            return PublishRelay.create();
        }
    }

    public static final class c extends Lambda implements Function0<PublishRelay<Pair<? extends ProductItem, ? extends Integer>>> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public PublishRelay<Pair<? extends ProductItem, ? extends Integer>> invoke() {
            return PublishRelay.create();
        }
    }

    public static final class d extends Lambda implements Function0<PublishRelay<Pair<? extends ProductItem, ? extends StepperUsageType>>> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public PublishRelay<Pair<? extends ProductItem, ? extends StepperUsageType>> invoke() {
            return PublishRelay.create();
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        a = t6.c.lazy(lazyThreadSafetyMode, (Function0) c.a);
        b = t6.c.lazy(lazyThreadSafetyMode, (Function0) a.a);
        c = t6.c.lazy(lazyThreadSafetyMode, (Function0) b.a);
        d = t6.c.lazy(lazyThreadSafetyMode, (Function0) d.a);
    }

    public static final PublishRelay access$getDeleteItemRelay$p() {
        return (PublishRelay) b.getValue();
    }

    public static final PublishRelay access$getOpenAdvertDetailsRelay$p() {
        return (PublishRelay) c.getValue();
    }

    public static final PublishRelay access$getProductQuantityRelay$p() {
        return (PublishRelay) a.getValue();
    }

    public static final PublishRelay access$getStepperUsageRelay$p() {
        return (PublishRelay) d.getValue();
    }
}
