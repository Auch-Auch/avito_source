package ru.sravni.android.bankproduct.repository.offer.product;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0013"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/product/EmptyProductCompanyNameForProductListCompany;", "", "", "c", "Ljava/lang/String;", "getSavedSearchID", "()Ljava/lang/String;", "savedSearchID", "d", "getProductID", "productID", AuthSource.SEND_ABUSE, "getOrderID", "orderID", AuthSource.BOOKING_ORDER, "getBankID", "bankID", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class EmptyProductCompanyNameForProductListCompany extends Throwable {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;

    public EmptyProductCompanyNameForProductListCompany(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "orderID");
        Intrinsics.checkParameterIsNotNull(str2, "bankID");
        Intrinsics.checkParameterIsNotNull(str3, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(str4, "productID");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    @NotNull
    public final String getBankID() {
        return this.b;
    }

    @NotNull
    public final String getOrderID() {
        return this.a;
    }

    @NotNull
    public final String getProductID() {
        return this.d;
    }

    @NotNull
    public final String getSavedSearchID() {
        return this.c;
    }
}
