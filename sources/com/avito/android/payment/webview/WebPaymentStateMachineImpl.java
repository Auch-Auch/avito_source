package com.avito.android.payment.webview;

import com.avito.android.payment.webview.DialogState;
import com.avito.android.payment.webview.ScreenState;
import com.avito.android.payment.webview.WebPaymentResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0006\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\nJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/payment/webview/WebPaymentStateMachineImpl;", "Lcom/avito/android/payment/webview/WebPaymentStateMachine;", "Lcom/avito/android/payment/webview/ScreenState;", "screenState", "Lcom/avito/android/payment/webview/WebViewState;", "webViewState", "onWebViewStateChanged", "(Lcom/avito/android/payment/webview/ScreenState;Lcom/avito/android/payment/webview/WebViewState;)Lcom/avito/android/payment/webview/ScreenState;", "Lcom/avito/android/payment/webview/DialogState;", "dialogState", "(Lcom/avito/android/payment/webview/DialogState;Lcom/avito/android/payment/webview/WebViewState;)Lcom/avito/android/payment/webview/DialogState;", "state", "onRetry", "(Lcom/avito/android/payment/webview/ScreenState;)Lcom/avito/android/payment/webview/ScreenState;", "onCloseClicked", "(Lcom/avito/android/payment/webview/DialogState;)Lcom/avito/android/payment/webview/DialogState;", "onDialogNegative", "onDialogPositive", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class WebPaymentStateMachineImpl implements WebPaymentStateMachine {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            WebViewState.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[2] = 1;
            WebViewState.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[1] = 1;
            WebViewState.values();
            int[] iArr3 = new int[3];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[0] = 1;
            iArr3[1] = 2;
            iArr3[2] = 3;
        }
    }

    @Override // com.avito.android.payment.webview.WebPaymentStateMachine
    @NotNull
    public DialogState onCloseClicked(@NotNull DialogState dialogState) {
        Intrinsics.checkNotNullParameter(dialogState, "state");
        if (dialogState instanceof DialogState.Preloading) {
            return new DialogState.Cancellation();
        }
        if (dialogState instanceof DialogState.Content) {
            return new DialogState.Cancellation();
        }
        throw new IllegalStateException(("Clicking on close is unsupported for state " + dialogState).toString());
    }

    @Override // com.avito.android.payment.webview.WebPaymentStateMachine
    @NotNull
    public DialogState onDialogNegative(@NotNull DialogState dialogState) {
        Intrinsics.checkNotNullParameter(dialogState, "state");
        if (dialogState instanceof DialogState.Cancellation) {
            return new DialogState.Content();
        }
        throw new IllegalStateException(("Clicking dialog negative button is unsupported for state " + dialogState).toString());
    }

    @Override // com.avito.android.payment.webview.WebPaymentStateMachine
    @NotNull
    public DialogState onDialogPositive(@NotNull DialogState dialogState) {
        Intrinsics.checkNotNullParameter(dialogState, "state");
        if (dialogState instanceof DialogState.Cancellation) {
            return new DialogState.Terminated(new WebPaymentResult.Cancelled());
        }
        if (dialogState instanceof DialogState.ErrorAlert) {
            return new DialogState.Terminated(new WebPaymentResult.Error());
        }
        throw new IllegalStateException(("Clicking dialog positive button is unsupported for state " + dialogState).toString());
    }

    @Override // com.avito.android.payment.webview.WebPaymentStateMachine
    @NotNull
    public ScreenState onRetry(@NotNull ScreenState screenState) {
        Intrinsics.checkNotNullParameter(screenState, "state");
        if (screenState instanceof ScreenState.FullScreenError) {
            return new ScreenState.FullScreenLoading();
        }
        throw new IllegalStateException(("Loading restart is unsupported for state " + screenState).toString());
    }

    @Override // com.avito.android.payment.webview.WebPaymentStateMachine
    @NotNull
    public ScreenState onWebViewStateChanged(@NotNull ScreenState screenState, @NotNull WebViewState webViewState) {
        Intrinsics.checkNotNullParameter(screenState, "screenState");
        Intrinsics.checkNotNullParameter(webViewState, "webViewState");
        if (screenState instanceof ScreenState.Content) {
            return screenState;
        }
        if (screenState instanceof ScreenState.FullScreenLoading) {
            int ordinal = webViewState.ordinal();
            if (ordinal == 0) {
                return new ScreenState.FullScreenLoading();
            }
            if (ordinal == 1) {
                return new ScreenState.Content();
            }
            if (ordinal == 2) {
                return new ScreenState.FullScreenError();
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException(("WebView state changes are not considered for state " + screenState).toString());
    }

    @Override // com.avito.android.payment.webview.WebPaymentStateMachine
    @NotNull
    public DialogState onWebViewStateChanged(@NotNull DialogState dialogState, @NotNull WebViewState webViewState) {
        Intrinsics.checkNotNullParameter(dialogState, "dialogState");
        Intrinsics.checkNotNullParameter(webViewState, "webViewState");
        if (dialogState instanceof DialogState.Preloading) {
            if (webViewState.ordinal() != 1) {
                return dialogState;
            }
            return new DialogState.Content();
        } else if (dialogState instanceof DialogState.Content) {
            return webViewState.ordinal() != 2 ? dialogState : new DialogState.ErrorAlert();
        } else {
            throw new IllegalStateException(("WebView state changes are not considered for state " + dialogState).toString());
        }
    }
}
