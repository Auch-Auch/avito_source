package com.avito.android.remote.model.payment.history;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/payment/history/Receipt;", "", "Lcom/avito/android/remote/model/payment/history/ReceiptStatus;", "component1", "()Lcom/avito/android/remote/model/payment/history/ReceiptStatus;", "", "component2", "()Ljava/lang/String;", "status", "receiptUrl", "copy", "(Lcom/avito/android/remote/model/payment/history/ReceiptStatus;Ljava/lang/String;)Lcom/avito/android/remote/model/payment/history/Receipt;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/payment/history/ReceiptStatus;", "getStatus", "Ljava/lang/String;", "getReceiptUrl", "<init>", "(Lcom/avito/android/remote/model/payment/history/ReceiptStatus;Ljava/lang/String;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class Receipt {
    @SerializedName("receiptUrl")
    @Nullable
    private final String receiptUrl;
    @SerializedName("status")
    @NotNull
    private final ReceiptStatus status;

    public Receipt(@NotNull ReceiptStatus receiptStatus, @Nullable String str) {
        Intrinsics.checkNotNullParameter(receiptStatus, "status");
        this.status = receiptStatus;
        this.receiptUrl = str;
    }

    public static /* synthetic */ Receipt copy$default(Receipt receipt, ReceiptStatus receiptStatus, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            receiptStatus = receipt.status;
        }
        if ((i & 2) != 0) {
            str = receipt.receiptUrl;
        }
        return receipt.copy(receiptStatus, str);
    }

    @NotNull
    public final ReceiptStatus component1() {
        return this.status;
    }

    @Nullable
    public final String component2() {
        return this.receiptUrl;
    }

    @NotNull
    public final Receipt copy(@NotNull ReceiptStatus receiptStatus, @Nullable String str) {
        Intrinsics.checkNotNullParameter(receiptStatus, "status");
        return new Receipt(receiptStatus, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Receipt)) {
            return false;
        }
        Receipt receipt = (Receipt) obj;
        return Intrinsics.areEqual(this.status, receipt.status) && Intrinsics.areEqual(this.receiptUrl, receipt.receiptUrl);
    }

    @Nullable
    public final String getReceiptUrl() {
        return this.receiptUrl;
    }

    @NotNull
    public final ReceiptStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        ReceiptStatus receiptStatus = this.status;
        int i = 0;
        int hashCode = (receiptStatus != null ? receiptStatus.hashCode() : 0) * 31;
        String str = this.receiptUrl;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Receipt(status=");
        L.append(this.status);
        L.append(", receiptUrl=");
        return a.t(L, this.receiptUrl, ")");
    }
}
