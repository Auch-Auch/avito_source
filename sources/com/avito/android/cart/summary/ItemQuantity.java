package com.avito.android.cart.summary;

import a2.b.a.a.a;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\bJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/avito/android/cart/summary/ItemQuantity;", "", "", "toString", "()Ljava/lang/String;", "component1", "", "component2", "()I", BookingInfoActivity.EXTRA_ITEM_ID, FirebaseAnalytics.Param.QUANTITY, "copy", "(Ljava/lang/String;I)Lcom/avito/android/cart/summary/ItemQuantity;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "I", "getQuantity", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAdvertId", "<init>", "(Ljava/lang/String;I)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class ItemQuantity {
    @NotNull
    public final String a;
    public final int b;

    public ItemQuantity(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.a = str;
        this.b = i;
    }

    public static /* synthetic */ ItemQuantity copy$default(ItemQuantity itemQuantity, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = itemQuantity.a;
        }
        if ((i2 & 2) != 0) {
            i = itemQuantity.b;
        }
        return itemQuantity.copy(str, i);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final ItemQuantity copy(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return new ItemQuantity(str, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemQuantity)) {
            return false;
        }
        ItemQuantity itemQuantity = (ItemQuantity) obj;
        return Intrinsics.areEqual(this.a, itemQuantity.a) && this.b == itemQuantity.b;
    }

    @NotNull
    public final String getAdvertId() {
        return this.a;
    }

    public final int getQuantity() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        return ((str != null ? str.hashCode() : 0) * 31) + this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder I = a.I(Typography.quote);
        I.append(this.a);
        I.append("\": ");
        I.append(this.b);
        return I.toString();
    }
}
