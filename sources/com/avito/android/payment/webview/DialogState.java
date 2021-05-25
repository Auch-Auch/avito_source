package com.avito.android.payment.webview;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/payment/webview/DialogState;", "", "<init>", "()V", "Cancellation", "Content", "ErrorAlert", "Preloading", "Terminated", "Lcom/avito/android/payment/webview/DialogState$Preloading;", "Lcom/avito/android/payment/webview/DialogState$Content;", "Lcom/avito/android/payment/webview/DialogState$Cancellation;", "Lcom/avito/android/payment/webview/DialogState$ErrorAlert;", "Lcom/avito/android/payment/webview/DialogState$Terminated;", "payment_release"}, k = 1, mv = {1, 4, 2})
public abstract class DialogState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/webview/DialogState$Cancellation;", "Lcom/avito/android/payment/webview/DialogState;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Cancellation extends DialogState {
        public Cancellation() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/webview/DialogState$Content;", "Lcom/avito/android/payment/webview/DialogState;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Content extends DialogState {
        public Content() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/webview/DialogState$ErrorAlert;", "Lcom/avito/android/payment/webview/DialogState;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class ErrorAlert extends DialogState {
        public ErrorAlert() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/webview/DialogState$Preloading;", "Lcom/avito/android/payment/webview/DialogState;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Preloading extends DialogState {
        public Preloading() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/webview/DialogState$Terminated;", "Lcom/avito/android/payment/webview/DialogState;", "Lcom/avito/android/payment/webview/WebPaymentResult;", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/webview/WebPaymentResult;", "getResult", "()Lcom/avito/android/payment/webview/WebPaymentResult;", "result", "<init>", "(Lcom/avito/android/payment/webview/WebPaymentResult;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Terminated extends DialogState {
        @NotNull
        public final WebPaymentResult a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Terminated(@NotNull WebPaymentResult webPaymentResult) {
            super(null);
            Intrinsics.checkNotNullParameter(webPaymentResult, "result");
            this.a = webPaymentResult;
        }

        @NotNull
        public final WebPaymentResult getResult() {
            return this.a;
        }
    }

    public DialogState() {
    }

    public DialogState(j jVar) {
    }
}
