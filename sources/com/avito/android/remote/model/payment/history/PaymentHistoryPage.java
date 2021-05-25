package com.avito.android.remote.model.payment.history;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/payment/history/PaymentHistoryPage;", "", "", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "history", "nextPageToken", "copy", "(Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/remote/model/payment/history/PaymentHistoryPage;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getHistory", "Ljava/lang/String;", "getNextPageToken", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentHistoryPage {
    @SerializedName("history")
    @NotNull
    private final List<PaymentHistoryListElement> history;
    @SerializedName("nextPageToken")
    @Nullable
    private final String nextPageToken;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.payment.history.PaymentHistoryListElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public PaymentHistoryPage(@NotNull List<? extends PaymentHistoryListElement> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, "history");
        this.history = list;
        this.nextPageToken = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.payment.history.PaymentHistoryPage */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaymentHistoryPage copy$default(PaymentHistoryPage paymentHistoryPage, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = paymentHistoryPage.history;
        }
        if ((i & 2) != 0) {
            str = paymentHistoryPage.nextPageToken;
        }
        return paymentHistoryPage.copy(list, str);
    }

    @NotNull
    public final List<PaymentHistoryListElement> component1() {
        return this.history;
    }

    @Nullable
    public final String component2() {
        return this.nextPageToken;
    }

    @NotNull
    public final PaymentHistoryPage copy(@NotNull List<? extends PaymentHistoryListElement> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, "history");
        return new PaymentHistoryPage(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentHistoryPage)) {
            return false;
        }
        PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) obj;
        return Intrinsics.areEqual(this.history, paymentHistoryPage.history) && Intrinsics.areEqual(this.nextPageToken, paymentHistoryPage.nextPageToken);
    }

    @NotNull
    public final List<PaymentHistoryListElement> getHistory() {
        return this.history;
    }

    @Nullable
    public final String getNextPageToken() {
        return this.nextPageToken;
    }

    public int hashCode() {
        List<PaymentHistoryListElement> list = this.history;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.nextPageToken;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("PaymentHistoryPage(history=");
        L.append(this.history);
        L.append(", nextPageToken=");
        return a.t(L, this.nextPageToken, ")");
    }
}
