package com.avito.android.remote.model.payment.history;

import a2.b.a.a.a;
import com.avito.android.remote.model.Sort;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/payment/history/PaymentDetails;", "", "<init>", "()V", "OperationDetails", "OrderDetails", "Lcom/avito/android/remote/model/payment/history/PaymentDetails$OrderDetails;", "Lcom/avito/android/remote/model/payment/history/PaymentDetails$OperationDetails;", "payment_release"}, k = 1, mv = {1, 4, 2})
public abstract class PaymentDetails {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JX\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b$\u0010\u0010R\u001c\u0010\u0015\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0016\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b(\u0010\rR\u001c\u0010\u0012\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b*\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b-\u0010\u0004¨\u00060"}, d2 = {"Lcom/avito/android/remote/model/payment/history/PaymentDetails$OperationDetails;", "Lcom/avito/android/remote/model/payment/history/PaymentDetails;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/payment/history/OperationTarget;", "component2", "()Lcom/avito/android/remote/model/payment/history/OperationTarget;", "component3", "component4", "component5", "Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;", "component6", "()Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;", "Lcom/avito/android/remote/model/payment/history/Receipt;", "component7", "()Lcom/avito/android/remote/model/payment/history/Receipt;", "operationId", "target", "amount", "paymentMethod", Sort.DATE, "status", "receipt", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/payment/history/OperationTarget;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;Lcom/avito/android/remote/model/payment/history/Receipt;)Lcom/avito/android/remote/model/payment/history/PaymentDetails$OperationDetails;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/payment/history/Receipt;", "getReceipt", "Ljava/lang/String;", "getDate", "Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;", "getStatus", "Lcom/avito/android/remote/model/payment/history/OperationTarget;", "getTarget", "getPaymentMethod", "getAmount", "getOperationId", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/payment/history/OperationTarget;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;Lcom/avito/android/remote/model/payment/history/Receipt;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class OperationDetails extends PaymentDetails {
        @SerializedName("amount")
        @NotNull
        private final String amount;
        @SerializedName(Sort.DATE)
        @NotNull
        private final String date;
        @SerializedName("operationId")
        @NotNull
        private final String operationId;
        @SerializedName("paymentMethod")
        @NotNull
        private final String paymentMethod;
        @SerializedName("receipt")
        @Nullable
        private final Receipt receipt;
        @SerializedName("status")
        @NotNull
        private final PaymentOrderStatus status;
        @SerializedName("target")
        @NotNull
        private final OperationTarget target;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OperationDetails(@NotNull String str, @NotNull OperationTarget operationTarget, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull PaymentOrderStatus paymentOrderStatus, @Nullable Receipt receipt2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "operationId");
            Intrinsics.checkNotNullParameter(operationTarget, "target");
            Intrinsics.checkNotNullParameter(str2, "amount");
            Intrinsics.checkNotNullParameter(str3, "paymentMethod");
            Intrinsics.checkNotNullParameter(str4, Sort.DATE);
            Intrinsics.checkNotNullParameter(paymentOrderStatus, "status");
            this.operationId = str;
            this.target = operationTarget;
            this.amount = str2;
            this.paymentMethod = str3;
            this.date = str4;
            this.status = paymentOrderStatus;
            this.receipt = receipt2;
        }

        public static /* synthetic */ OperationDetails copy$default(OperationDetails operationDetails, String str, OperationTarget operationTarget, String str2, String str3, String str4, PaymentOrderStatus paymentOrderStatus, Receipt receipt2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = operationDetails.operationId;
            }
            if ((i & 2) != 0) {
                operationTarget = operationDetails.target;
            }
            if ((i & 4) != 0) {
                str2 = operationDetails.amount;
            }
            if ((i & 8) != 0) {
                str3 = operationDetails.paymentMethod;
            }
            if ((i & 16) != 0) {
                str4 = operationDetails.date;
            }
            if ((i & 32) != 0) {
                paymentOrderStatus = operationDetails.status;
            }
            if ((i & 64) != 0) {
                receipt2 = operationDetails.receipt;
            }
            return operationDetails.copy(str, operationTarget, str2, str3, str4, paymentOrderStatus, receipt2);
        }

        @NotNull
        public final String component1() {
            return this.operationId;
        }

        @NotNull
        public final OperationTarget component2() {
            return this.target;
        }

        @NotNull
        public final String component3() {
            return this.amount;
        }

        @NotNull
        public final String component4() {
            return this.paymentMethod;
        }

        @NotNull
        public final String component5() {
            return this.date;
        }

        @NotNull
        public final PaymentOrderStatus component6() {
            return this.status;
        }

        @Nullable
        public final Receipt component7() {
            return this.receipt;
        }

        @NotNull
        public final OperationDetails copy(@NotNull String str, @NotNull OperationTarget operationTarget, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull PaymentOrderStatus paymentOrderStatus, @Nullable Receipt receipt2) {
            Intrinsics.checkNotNullParameter(str, "operationId");
            Intrinsics.checkNotNullParameter(operationTarget, "target");
            Intrinsics.checkNotNullParameter(str2, "amount");
            Intrinsics.checkNotNullParameter(str3, "paymentMethod");
            Intrinsics.checkNotNullParameter(str4, Sort.DATE);
            Intrinsics.checkNotNullParameter(paymentOrderStatus, "status");
            return new OperationDetails(str, operationTarget, str2, str3, str4, paymentOrderStatus, receipt2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OperationDetails)) {
                return false;
            }
            OperationDetails operationDetails = (OperationDetails) obj;
            return Intrinsics.areEqual(this.operationId, operationDetails.operationId) && Intrinsics.areEqual(this.target, operationDetails.target) && Intrinsics.areEqual(this.amount, operationDetails.amount) && Intrinsics.areEqual(this.paymentMethod, operationDetails.paymentMethod) && Intrinsics.areEqual(this.date, operationDetails.date) && Intrinsics.areEqual(this.status, operationDetails.status) && Intrinsics.areEqual(this.receipt, operationDetails.receipt);
        }

        @NotNull
        public final String getAmount() {
            return this.amount;
        }

        @NotNull
        public final String getDate() {
            return this.date;
        }

        @NotNull
        public final String getOperationId() {
            return this.operationId;
        }

        @NotNull
        public final String getPaymentMethod() {
            return this.paymentMethod;
        }

        @Nullable
        public final Receipt getReceipt() {
            return this.receipt;
        }

        @NotNull
        public final PaymentOrderStatus getStatus() {
            return this.status;
        }

        @NotNull
        public final OperationTarget getTarget() {
            return this.target;
        }

        public int hashCode() {
            String str = this.operationId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            OperationTarget operationTarget = this.target;
            int hashCode2 = (hashCode + (operationTarget != null ? operationTarget.hashCode() : 0)) * 31;
            String str2 = this.amount;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.paymentMethod;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.date;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            PaymentOrderStatus paymentOrderStatus = this.status;
            int hashCode6 = (hashCode5 + (paymentOrderStatus != null ? paymentOrderStatus.hashCode() : 0)) * 31;
            Receipt receipt2 = this.receipt;
            if (receipt2 != null) {
                i = receipt2.hashCode();
            }
            return hashCode6 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("OperationDetails(operationId=");
            L.append(this.operationId);
            L.append(", target=");
            L.append(this.target);
            L.append(", amount=");
            L.append(this.amount);
            L.append(", paymentMethod=");
            L.append(this.paymentMethod);
            L.append(", date=");
            L.append(this.date);
            L.append(", status=");
            L.append(this.status);
            L.append(", receipt=");
            L.append(this.receipt);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J^\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001c\u0010\u0012\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b'\u0010\u0004R\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010\bR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b+\u0010\u0011R\u001c\u0010\u0017\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010\u000eR\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b.\u0010\u0004¨\u00061"}, d2 = {"Lcom/avito/android/remote/model/payment/history/PaymentDetails$OrderDetails;", "Lcom/avito/android/remote/model/payment/history/PaymentDetails;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/payment/history/OrderTarget;", "component2", "()Ljava/util/List;", "component3", "component4", "component5", "Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;", "component6", "()Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;", "Lcom/avito/android/remote/model/payment/history/Receipt;", "component7", "()Lcom/avito/android/remote/model/payment/history/Receipt;", AnalyticFieldsName.orderId, "targets", "amount", "paymentMethod", Sort.DATE, "status", "receipt", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;Lcom/avito/android/remote/model/payment/history/Receipt;)Lcom/avito/android/remote/model/payment/history/PaymentDetails$OrderDetails;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOrderId", "getPaymentMethod", "getAmount", "Ljava/util/List;", "getTargets", "Lcom/avito/android/remote/model/payment/history/Receipt;", "getReceipt", "Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;", "getStatus", "getDate", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;Lcom/avito/android/remote/model/payment/history/Receipt;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class OrderDetails extends PaymentDetails {
        @SerializedName("amount")
        @NotNull
        private final String amount;
        @SerializedName(Sort.DATE)
        @NotNull
        private final String date;
        @SerializedName(AnalyticFieldsName.orderId)
        @NotNull
        private final String orderId;
        @SerializedName("paymentMethod")
        @NotNull
        private final String paymentMethod;
        @SerializedName("receipt")
        @Nullable
        private final Receipt receipt;
        @SerializedName("status")
        @NotNull
        private final PaymentOrderStatus status;
        @SerializedName("targets")
        @NotNull
        private final List<OrderTarget> targets;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.payment.history.OrderTarget> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OrderDetails(@NotNull String str, @NotNull List<? extends OrderTarget> list, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull PaymentOrderStatus paymentOrderStatus, @Nullable Receipt receipt2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
            Intrinsics.checkNotNullParameter(list, "targets");
            Intrinsics.checkNotNullParameter(str2, "amount");
            Intrinsics.checkNotNullParameter(str3, "paymentMethod");
            Intrinsics.checkNotNullParameter(str4, Sort.DATE);
            Intrinsics.checkNotNullParameter(paymentOrderStatus, "status");
            this.orderId = str;
            this.targets = list;
            this.amount = str2;
            this.paymentMethod = str3;
            this.date = str4;
            this.status = paymentOrderStatus;
            this.receipt = receipt2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.remote.model.payment.history.PaymentDetails$OrderDetails */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OrderDetails copy$default(OrderDetails orderDetails, String str, List list, String str2, String str3, String str4, PaymentOrderStatus paymentOrderStatus, Receipt receipt2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = orderDetails.orderId;
            }
            if ((i & 2) != 0) {
                list = orderDetails.targets;
            }
            if ((i & 4) != 0) {
                str2 = orderDetails.amount;
            }
            if ((i & 8) != 0) {
                str3 = orderDetails.paymentMethod;
            }
            if ((i & 16) != 0) {
                str4 = orderDetails.date;
            }
            if ((i & 32) != 0) {
                paymentOrderStatus = orderDetails.status;
            }
            if ((i & 64) != 0) {
                receipt2 = orderDetails.receipt;
            }
            return orderDetails.copy(str, list, str2, str3, str4, paymentOrderStatus, receipt2);
        }

        @NotNull
        public final String component1() {
            return this.orderId;
        }

        @NotNull
        public final List<OrderTarget> component2() {
            return this.targets;
        }

        @NotNull
        public final String component3() {
            return this.amount;
        }

        @NotNull
        public final String component4() {
            return this.paymentMethod;
        }

        @NotNull
        public final String component5() {
            return this.date;
        }

        @NotNull
        public final PaymentOrderStatus component6() {
            return this.status;
        }

        @Nullable
        public final Receipt component7() {
            return this.receipt;
        }

        @NotNull
        public final OrderDetails copy(@NotNull String str, @NotNull List<? extends OrderTarget> list, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull PaymentOrderStatus paymentOrderStatus, @Nullable Receipt receipt2) {
            Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
            Intrinsics.checkNotNullParameter(list, "targets");
            Intrinsics.checkNotNullParameter(str2, "amount");
            Intrinsics.checkNotNullParameter(str3, "paymentMethod");
            Intrinsics.checkNotNullParameter(str4, Sort.DATE);
            Intrinsics.checkNotNullParameter(paymentOrderStatus, "status");
            return new OrderDetails(str, list, str2, str3, str4, paymentOrderStatus, receipt2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OrderDetails)) {
                return false;
            }
            OrderDetails orderDetails = (OrderDetails) obj;
            return Intrinsics.areEqual(this.orderId, orderDetails.orderId) && Intrinsics.areEqual(this.targets, orderDetails.targets) && Intrinsics.areEqual(this.amount, orderDetails.amount) && Intrinsics.areEqual(this.paymentMethod, orderDetails.paymentMethod) && Intrinsics.areEqual(this.date, orderDetails.date) && Intrinsics.areEqual(this.status, orderDetails.status) && Intrinsics.areEqual(this.receipt, orderDetails.receipt);
        }

        @NotNull
        public final String getAmount() {
            return this.amount;
        }

        @NotNull
        public final String getDate() {
            return this.date;
        }

        @NotNull
        public final String getOrderId() {
            return this.orderId;
        }

        @NotNull
        public final String getPaymentMethod() {
            return this.paymentMethod;
        }

        @Nullable
        public final Receipt getReceipt() {
            return this.receipt;
        }

        @NotNull
        public final PaymentOrderStatus getStatus() {
            return this.status;
        }

        @NotNull
        public final List<OrderTarget> getTargets() {
            return this.targets;
        }

        public int hashCode() {
            String str = this.orderId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<OrderTarget> list = this.targets;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            String str2 = this.amount;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.paymentMethod;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.date;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            PaymentOrderStatus paymentOrderStatus = this.status;
            int hashCode6 = (hashCode5 + (paymentOrderStatus != null ? paymentOrderStatus.hashCode() : 0)) * 31;
            Receipt receipt2 = this.receipt;
            if (receipt2 != null) {
                i = receipt2.hashCode();
            }
            return hashCode6 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("OrderDetails(orderId=");
            L.append(this.orderId);
            L.append(", targets=");
            L.append(this.targets);
            L.append(", amount=");
            L.append(this.amount);
            L.append(", paymentMethod=");
            L.append(this.paymentMethod);
            L.append(", date=");
            L.append(this.date);
            L.append(", status=");
            L.append(this.status);
            L.append(", receipt=");
            L.append(this.receipt);
            L.append(")");
            return L.toString();
        }
    }

    private PaymentDetails() {
    }

    public /* synthetic */ PaymentDetails(j jVar) {
        this();
    }
}
