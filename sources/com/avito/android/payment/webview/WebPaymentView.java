package com.avito.android.payment.webview;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\rR\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\rR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/avito/android/payment/webview/WebPaymentView;", "", "", "initWebView", "()V", "destroyWebView", "Lcom/avito/android/payment/webview/PaymentWebViewStateWatcher;", "stateWatcher", "attachWebViewStateWatcher", "(Lcom/avito/android/payment/webview/PaymentWebViewStateWatcher;)V", "detachWebViewStateWatcher", "Lio/reactivex/Observable;", "getRetryClicks", "()Lio/reactivex/Observable;", "retryClicks", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/payment/webview/DialogState;", "getDialogBinding", "()Lio/reactivex/functions/Consumer;", "dialogBinding", "getDialogPositiveClicks", "dialogPositiveClicks", "getDialogNegativeClicks", "dialogNegativeClicks", "getToolbarCloseClicks", "toolbarCloseClicks", "Lcom/avito/android/payment/webview/ScreenState;", "getScreenBinding", "screenBinding", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface WebPaymentView {
    void attachWebViewStateWatcher(@NotNull PaymentWebViewStateWatcher paymentWebViewStateWatcher);

    void destroyWebView();

    void detachWebViewStateWatcher(@NotNull PaymentWebViewStateWatcher paymentWebViewStateWatcher);

    @NotNull
    Consumer<DialogState> getDialogBinding();

    @NotNull
    Observable<Unit> getDialogNegativeClicks();

    @NotNull
    Observable<Unit> getDialogPositiveClicks();

    @NotNull
    Observable<Unit> getRetryClicks();

    @NotNull
    Consumer<ScreenState> getScreenBinding();

    @NotNull
    Observable<Unit> getToolbarCloseClicks();

    void initWebView();
}
