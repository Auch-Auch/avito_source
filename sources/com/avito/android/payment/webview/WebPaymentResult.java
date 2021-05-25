package com.avito.android.payment.webview;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/webview/WebPaymentResult;", "", "<init>", "()V", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED, "Error", "Finished", "Lcom/avito/android/payment/webview/WebPaymentResult$Cancelled;", "Lcom/avito/android/payment/webview/WebPaymentResult$Error;", "Lcom/avito/android/payment/webview/WebPaymentResult$Finished;", "payment_release"}, k = 1, mv = {1, 4, 2})
public abstract class WebPaymentResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/webview/WebPaymentResult$Cancelled;", "Lcom/avito/android/payment/webview/WebPaymentResult;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Cancelled extends WebPaymentResult {
        public Cancelled() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/webview/WebPaymentResult$Error;", "Lcom/avito/android/payment/webview/WebPaymentResult;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends WebPaymentResult {
        public Error() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/webview/WebPaymentResult$Finished;", "Lcom/avito/android/payment/webview/WebPaymentResult;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Finished extends WebPaymentResult {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Finished(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deeplink");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getDeeplink() {
            return this.a;
        }
    }

    public WebPaymentResult() {
    }

    public WebPaymentResult(j jVar) {
    }
}
