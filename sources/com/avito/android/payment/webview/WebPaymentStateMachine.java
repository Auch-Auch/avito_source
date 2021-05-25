package com.avito.android.payment.webview;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0006\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\nJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/payment/webview/WebPaymentStateMachine;", "", "Lcom/avito/android/payment/webview/ScreenState;", "screenState", "Lcom/avito/android/payment/webview/WebViewState;", "webViewState", "onWebViewStateChanged", "(Lcom/avito/android/payment/webview/ScreenState;Lcom/avito/android/payment/webview/WebViewState;)Lcom/avito/android/payment/webview/ScreenState;", "Lcom/avito/android/payment/webview/DialogState;", "dialogState", "(Lcom/avito/android/payment/webview/DialogState;Lcom/avito/android/payment/webview/WebViewState;)Lcom/avito/android/payment/webview/DialogState;", "state", "onRetry", "(Lcom/avito/android/payment/webview/ScreenState;)Lcom/avito/android/payment/webview/ScreenState;", "onCloseClicked", "(Lcom/avito/android/payment/webview/DialogState;)Lcom/avito/android/payment/webview/DialogState;", "onDialogNegative", "onDialogPositive", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface WebPaymentStateMachine {
    @NotNull
    DialogState onCloseClicked(@NotNull DialogState dialogState);

    @NotNull
    DialogState onDialogNegative(@NotNull DialogState dialogState);

    @NotNull
    DialogState onDialogPositive(@NotNull DialogState dialogState);

    @NotNull
    ScreenState onRetry(@NotNull ScreenState screenState);

    @NotNull
    DialogState onWebViewStateChanged(@NotNull DialogState dialogState, @NotNull WebViewState webViewState);

    @NotNull
    ScreenState onWebViewStateChanged(@NotNull ScreenState screenState, @NotNull WebViewState webViewState);
}
