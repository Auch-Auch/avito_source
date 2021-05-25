package com.avito.android.payment.webview;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/payment/webview/ScreenState;", "", "<init>", "()V", "Content", "FullScreenError", "FullScreenLoading", "Terminated", "Lcom/avito/android/payment/webview/ScreenState$Content;", "Lcom/avito/android/payment/webview/ScreenState$FullScreenLoading;", "Lcom/avito/android/payment/webview/ScreenState$FullScreenError;", "Lcom/avito/android/payment/webview/ScreenState$Terminated;", "payment_release"}, k = 1, mv = {1, 4, 2})
public abstract class ScreenState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/webview/ScreenState$Content;", "Lcom/avito/android/payment/webview/ScreenState;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Content extends ScreenState {
        public Content() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/webview/ScreenState$FullScreenError;", "Lcom/avito/android/payment/webview/ScreenState;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class FullScreenError extends ScreenState {
        public FullScreenError() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/webview/ScreenState$FullScreenLoading;", "Lcom/avito/android/payment/webview/ScreenState;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class FullScreenLoading extends ScreenState {
        public FullScreenLoading() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/webview/ScreenState$Terminated;", "Lcom/avito/android/payment/webview/ScreenState;", "Lcom/avito/android/payment/webview/WebPaymentResult;", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/webview/WebPaymentResult;", "getResult", "()Lcom/avito/android/payment/webview/WebPaymentResult;", "result", "<init>", "(Lcom/avito/android/payment/webview/WebPaymentResult;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Terminated extends ScreenState {
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

    public ScreenState() {
    }

    public ScreenState(j jVar) {
    }
}
