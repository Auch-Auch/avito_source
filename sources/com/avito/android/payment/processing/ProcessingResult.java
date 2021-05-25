package com.avito.android.payment.processing;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.status.PaymentStatusResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/payment/processing/ProcessingResult;", "", "<init>", "()V", "Canceled", "Error", "Finished", "Redirect", "Lcom/avito/android/payment/processing/ProcessingResult$Canceled;", "Lcom/avito/android/payment/processing/ProcessingResult$Error;", "Lcom/avito/android/payment/processing/ProcessingResult$Redirect;", "Lcom/avito/android/payment/processing/ProcessingResult$Finished;", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class ProcessingResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/processing/ProcessingResult$Canceled;", "Lcom/avito/android/payment/processing/ProcessingResult;", "<init>", "()V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Canceled extends ProcessingResult {
        public Canceled() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/processing/ProcessingResult$Error;", "Lcom/avito/android/payment/processing/ProcessingResult;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends ProcessingResult {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @NotNull
        public final String getMessage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/processing/ProcessingResult$Finished;", "Lcom/avito/android/payment/processing/ProcessingResult;", "Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus;", "getPaymentStatus", "()Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus;", "paymentStatus", "<init>", "(Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus;)V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Finished extends ProcessingResult {
        @NotNull
        public final PaymentStatusResult.PaymentStatus a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Finished(@NotNull PaymentStatusResult.PaymentStatus paymentStatus) {
            super(null);
            Intrinsics.checkNotNullParameter(paymentStatus, "paymentStatus");
            this.a = paymentStatus;
        }

        @NotNull
        public final PaymentStatusResult.PaymentStatus getPaymentStatus() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/processing/ProcessingResult$Redirect;", "Lcom/avito/android/payment/processing/ProcessingResult;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUriString", "()Ljava/lang/String;", "uriString", "<init>", "(Ljava/lang/String;)V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Redirect extends ProcessingResult {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Redirect(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "uriString");
            this.a = str;
        }

        @NotNull
        public final String getUriString() {
            return this.a;
        }
    }

    public ProcessingResult() {
    }

    public ProcessingResult(j jVar) {
    }
}
