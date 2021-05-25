package com.avito.android.remote.model.payment.history;

import a2.b.a.a.a;
import com.avito.android.remote.model.Sort;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement;", "", "<init>", "()V", "Header", "Operation", "Order", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement$Order;", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement$Operation;", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement$Header;", "payment_release"}, k = 1, mv = {1, 4, 2})
public abstract class PaymentHistoryListElement {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement$Header;", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement;", "", "component1", "()Ljava/lang/String;", "title", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement$Header;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Header extends PaymentHistoryListElement {
        @SerializedName("title")
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Header(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
        }

        public static /* synthetic */ Header copy$default(Header header, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = header.title;
            }
            return header.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final Header copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new Header(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Header) && Intrinsics.areEqual(this.title, ((Header) obj).title);
            }
            return true;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.title;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.t(a.L("Header(title="), this.title, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJN\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001c\u0010\u0011\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\u000bR\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b#\u0010\u0004R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement$Operation;", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;", "component6", "()Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;", "operationId", "title", "amount", "description", Sort.DATE, "status", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;)Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement$Operation;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDate", "getOperationId", "getAmount", "Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;", "getStatus", "getTitle", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Operation extends PaymentHistoryListElement {
        @SerializedName("amount")
        @NotNull
        private final String amount;
        @SerializedName(Sort.DATE)
        @NotNull
        private final String date;
        @SerializedName("description")
        @Nullable
        private final String description;
        @SerializedName("operationId")
        @NotNull
        private final String operationId;
        @SerializedName("status")
        @NotNull
        private final PaymentOrderStatus status;
        @SerializedName("title")
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Operation(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull String str5, @NotNull PaymentOrderStatus paymentOrderStatus) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "operationId");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "amount");
            Intrinsics.checkNotNullParameter(str5, Sort.DATE);
            Intrinsics.checkNotNullParameter(paymentOrderStatus, "status");
            this.operationId = str;
            this.title = str2;
            this.amount = str3;
            this.description = str4;
            this.date = str5;
            this.status = paymentOrderStatus;
        }

        public static /* synthetic */ Operation copy$default(Operation operation, String str, String str2, String str3, String str4, String str5, PaymentOrderStatus paymentOrderStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                str = operation.operationId;
            }
            if ((i & 2) != 0) {
                str2 = operation.title;
            }
            if ((i & 4) != 0) {
                str3 = operation.amount;
            }
            if ((i & 8) != 0) {
                str4 = operation.description;
            }
            if ((i & 16) != 0) {
                str5 = operation.date;
            }
            if ((i & 32) != 0) {
                paymentOrderStatus = operation.status;
            }
            return operation.copy(str, str2, str3, str4, str5, paymentOrderStatus);
        }

        @NotNull
        public final String component1() {
            return this.operationId;
        }

        @NotNull
        public final String component2() {
            return this.title;
        }

        @NotNull
        public final String component3() {
            return this.amount;
        }

        @Nullable
        public final String component4() {
            return this.description;
        }

        @NotNull
        public final String component5() {
            return this.date;
        }

        @NotNull
        public final PaymentOrderStatus component6() {
            return this.status;
        }

        @NotNull
        public final Operation copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull String str5, @NotNull PaymentOrderStatus paymentOrderStatus) {
            Intrinsics.checkNotNullParameter(str, "operationId");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "amount");
            Intrinsics.checkNotNullParameter(str5, Sort.DATE);
            Intrinsics.checkNotNullParameter(paymentOrderStatus, "status");
            return new Operation(str, str2, str3, str4, str5, paymentOrderStatus);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Operation)) {
                return false;
            }
            Operation operation = (Operation) obj;
            return Intrinsics.areEqual(this.operationId, operation.operationId) && Intrinsics.areEqual(this.title, operation.title) && Intrinsics.areEqual(this.amount, operation.amount) && Intrinsics.areEqual(this.description, operation.description) && Intrinsics.areEqual(this.date, operation.date) && Intrinsics.areEqual(this.status, operation.status);
        }

        @NotNull
        public final String getAmount() {
            return this.amount;
        }

        @NotNull
        public final String getDate() {
            return this.date;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final String getOperationId() {
            return this.operationId;
        }

        @NotNull
        public final PaymentOrderStatus getStatus() {
            return this.status;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.operationId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.title;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.amount;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.description;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.date;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            PaymentOrderStatus paymentOrderStatus = this.status;
            if (paymentOrderStatus != null) {
                i = paymentOrderStatus.hashCode();
            }
            return hashCode5 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Operation(operationId=");
            L.append(this.operationId);
            L.append(", title=");
            L.append(this.title);
            L.append(", amount=");
            L.append(this.amount);
            L.append(", description=");
            L.append(this.description);
            L.append(", date=");
            L.append(this.date);
            L.append(", status=");
            L.append(this.status);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJN\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b!\u0010\u0004R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\u000b¨\u0006'"}, d2 = {"Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement$Order;", "Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;", "component6", "()Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;", AnalyticFieldsName.orderId, "title", "amount", "description", Sort.DATE, "status", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;)Lcom/avito/android/remote/model/payment/history/PaymentHistoryListElement$Order;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAmount", "getDate", "getOrderId", "getDescription", "getTitle", "Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;", "getStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Order extends PaymentHistoryListElement {
        @SerializedName("amount")
        @NotNull
        private final String amount;
        @SerializedName(Sort.DATE)
        @NotNull
        private final String date;
        @SerializedName("description")
        @Nullable
        private final String description;
        @SerializedName(AnalyticFieldsName.orderId)
        @NotNull
        private final String orderId;
        @SerializedName("status")
        @NotNull
        private final PaymentOrderStatus status;
        @SerializedName("title")
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Order(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull String str5, @NotNull PaymentOrderStatus paymentOrderStatus) {
            super(null);
            Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "amount");
            Intrinsics.checkNotNullParameter(str5, Sort.DATE);
            Intrinsics.checkNotNullParameter(paymentOrderStatus, "status");
            this.orderId = str;
            this.title = str2;
            this.amount = str3;
            this.description = str4;
            this.date = str5;
            this.status = paymentOrderStatus;
        }

        public static /* synthetic */ Order copy$default(Order order, String str, String str2, String str3, String str4, String str5, PaymentOrderStatus paymentOrderStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                str = order.orderId;
            }
            if ((i & 2) != 0) {
                str2 = order.title;
            }
            if ((i & 4) != 0) {
                str3 = order.amount;
            }
            if ((i & 8) != 0) {
                str4 = order.description;
            }
            if ((i & 16) != 0) {
                str5 = order.date;
            }
            if ((i & 32) != 0) {
                paymentOrderStatus = order.status;
            }
            return order.copy(str, str2, str3, str4, str5, paymentOrderStatus);
        }

        @NotNull
        public final String component1() {
            return this.orderId;
        }

        @NotNull
        public final String component2() {
            return this.title;
        }

        @NotNull
        public final String component3() {
            return this.amount;
        }

        @Nullable
        public final String component4() {
            return this.description;
        }

        @NotNull
        public final String component5() {
            return this.date;
        }

        @NotNull
        public final PaymentOrderStatus component6() {
            return this.status;
        }

        @NotNull
        public final Order copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull String str5, @NotNull PaymentOrderStatus paymentOrderStatus) {
            Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "amount");
            Intrinsics.checkNotNullParameter(str5, Sort.DATE);
            Intrinsics.checkNotNullParameter(paymentOrderStatus, "status");
            return new Order(str, str2, str3, str4, str5, paymentOrderStatus);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Order)) {
                return false;
            }
            Order order = (Order) obj;
            return Intrinsics.areEqual(this.orderId, order.orderId) && Intrinsics.areEqual(this.title, order.title) && Intrinsics.areEqual(this.amount, order.amount) && Intrinsics.areEqual(this.description, order.description) && Intrinsics.areEqual(this.date, order.date) && Intrinsics.areEqual(this.status, order.status);
        }

        @NotNull
        public final String getAmount() {
            return this.amount;
        }

        @NotNull
        public final String getDate() {
            return this.date;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final String getOrderId() {
            return this.orderId;
        }

        @NotNull
        public final PaymentOrderStatus getStatus() {
            return this.status;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.orderId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.title;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.amount;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.description;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.date;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            PaymentOrderStatus paymentOrderStatus = this.status;
            if (paymentOrderStatus != null) {
                i = paymentOrderStatus.hashCode();
            }
            return hashCode5 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Order(orderId=");
            L.append(this.orderId);
            L.append(", title=");
            L.append(this.title);
            L.append(", amount=");
            L.append(this.amount);
            L.append(", description=");
            L.append(this.description);
            L.append(", date=");
            L.append(this.date);
            L.append(", status=");
            L.append(this.status);
            L.append(")");
            return L.toString();
        }
    }

    private PaymentHistoryListElement() {
    }

    public /* synthetic */ PaymentHistoryListElement(j jVar) {
        this();
    }
}
