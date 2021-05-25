package com.avito.android.payment.webview;

import a2.a.a.t1.g.i;
import a2.g.r.g;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.analytics.Analytics;
import com.avito.android.payment.R;
import com.avito.android.payment.WebPaymentResourceProvider;
import com.avito.android.payment.webview.DialogState;
import com.avito.android.payment.webview.ScreenState;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Toolbars;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.PublishRelay;
import com.yatatsu.powerwebview.PowerWebView;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bJ\u0010KJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\tR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R:\u0010\u0019\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00020\u0002 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR:\u0010\u001f\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00020\u0002 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\"\u0010&\u001a\b\u0012\u0004\u0012\u00020!0 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\"\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000fR\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010\r\u001a\u0004\b+\u0010\u000fR\"\u00100\u001a\b\u0012\u0004\u0012\u00020-0 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010#\u001a\u0004\b/\u0010%R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\"\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b5\u0010\r\u001a\u0004\b6\u0010\u000fR\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R:\u0010=\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00020\u0002 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010\u0018R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006L"}, d2 = {"Lcom/avito/android/payment/webview/WebPaymentViewImpl;", "Lcom/avito/android/payment/webview/WebPaymentView;", "", "initWebView", "()V", "destroyWebView", "Lcom/avito/android/payment/webview/PaymentWebViewStateWatcher;", "stateWatcher", "attachWebViewStateWatcher", "(Lcom/avito/android/payment/webview/PaymentWebViewStateWatcher;)V", "detachWebViewStateWatcher", "Lio/reactivex/Observable;", "k", "Lio/reactivex/Observable;", "getDialogNegativeClicks", "()Lio/reactivex/Observable;", "dialogNegativeClicks", "Lcom/avito/android/payment/WebPaymentResourceProvider;", "o", "Lcom/avito/android/payment/WebPaymentResourceProvider;", "resourceProvider", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "f", "Lcom/jakewharton/rxrelay2/PublishRelay;", "dialogPositiveClicksRelay", "Lcom/avito/android/util/DialogRouter;", "n", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "e", "retryClicksRelay", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/payment/webview/DialogState;", "l", "Lio/reactivex/functions/Consumer;", "getDialogBinding", "()Lio/reactivex/functions/Consumer;", "dialogBinding", "i", "getRetryClicks", "retryClicks", "j", "getDialogPositiveClicks", "dialogPositiveClicks", "Lcom/avito/android/payment/webview/ScreenState;", AuthSource.OPEN_CHANNEL_LIST, "getScreenBinding", "screenBinding", "Landroid/app/Dialog;", "d", "Landroid/app/Dialog;", "dialog", "h", "getToolbarCloseClicks", "toolbarCloseClicks", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", g.a, "dialogNegativeClicksRelay", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/yatatsu/powerwebview/PowerWebView;", "c", "Lcom/yatatsu/powerwebview/PowerWebView;", "webView", "Landroid/view/View;", "view", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/util/DialogRouter;Lcom/avito/android/payment/WebPaymentResourceProvider;Lcom/avito/android/analytics/Analytics;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class WebPaymentViewImpl implements WebPaymentView {
    public final Toolbar a;
    public final ProgressOverlay b;
    public final PowerWebView c;
    public Dialog d;
    public final PublishRelay<Unit> e;
    public final PublishRelay<Unit> f;
    public final PublishRelay<Unit> g;
    @NotNull
    public final Observable<Unit> h;
    @NotNull
    public final Observable<Unit> i;
    @NotNull
    public final Observable<Unit> j;
    @NotNull
    public final Observable<Unit> k;
    @NotNull
    public final Consumer<DialogState> l = new c(this);
    @NotNull
    public final Consumer<ScreenState> m = new e(this);
    public final DialogRouter n;
    public final WebPaymentResourceProvider o;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WebPaymentViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(WebPaymentViewImpl webPaymentViewImpl) {
            super(0);
            this.a = webPaymentViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishRelay publishRelay = this.a.e;
            Unit unit = Unit.INSTANCE;
            publishRelay.accept(unit);
            return unit;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ WebPaymentViewImpl a;

        public b(WebPaymentViewImpl webPaymentViewImpl) {
            this.a = webPaymentViewImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c.destroy();
        }
    }

    public static final class c<T> implements Consumer<DialogState> {
        public final /* synthetic */ WebPaymentViewImpl a;

        public c(WebPaymentViewImpl webPaymentViewImpl) {
            this.a = webPaymentViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DialogState dialogState) {
            DialogState dialogState2 = dialogState;
            if (dialogState2 instanceof DialogState.Cancellation) {
                WebPaymentViewImpl.access$showCancellationDialog(this.a);
            } else if (dialogState2 instanceof DialogState.ErrorAlert) {
                WebPaymentViewImpl.access$showErrorDialog(this.a);
            } else {
                WebPaymentViewImpl.access$dismissDialog(this.a);
            }
        }
    }

    public static final class d implements View.OnTouchListener {
        public static final d a = new d();

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
            int action = motionEvent.getAction();
            if ((action != 0 && action != 1) || view.hasFocus()) {
                return false;
            }
            view.requestFocus();
            return false;
        }
    }

    public static final class e<T> implements Consumer<ScreenState> {
        public final /* synthetic */ WebPaymentViewImpl a;

        public e(WebPaymentViewImpl webPaymentViewImpl) {
            this.a = webPaymentViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ScreenState screenState) {
            ScreenState screenState2 = screenState;
            if (screenState2 instanceof ScreenState.Content) {
                this.a.b.showContent();
            } else if (screenState2 instanceof ScreenState.FullScreenLoading) {
                this.a.b.showLoading();
            } else if (screenState2 instanceof ScreenState.FullScreenError) {
                this.a.b.showLoadingProblem(this.a.o.getPreloadingErrorMessage());
            } else {
                boolean z = screenState2 instanceof ScreenState.Terminated;
            }
        }
    }

    public WebPaymentViewImpl(@NotNull View view, @NotNull DialogRouter dialogRouter, @NotNull WebPaymentResourceProvider webPaymentResourceProvider, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(webPaymentResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.n = dialogRouter;
        this.o = webPaymentResourceProvider;
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.a = toolbar;
        View findViewById2 = view.findViewById(R.id.web_payment_content_holder);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        int i2 = R.id.web_payment_webview;
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById2, i2, analytics, false, 0, 24, null);
        this.b = progressOverlay;
        View findViewById3 = view.findViewById(i2);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.yatatsu.powerwebview.PowerWebView");
        this.c = (PowerWebView) findViewById3;
        PublishRelay<Unit> create = PublishRelay.create();
        this.e = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        this.f = create2;
        PublishRelay<Unit> create3 = PublishRelay.create();
        this.g = create3;
        progressOverlay.setOnRefreshListener(new a(this));
        toolbar.setTitle(webPaymentResourceProvider.getToolbarTitle());
        toolbar.setNavigationIcon(webPaymentResourceProvider.getToolbarUpIconRes());
        this.h = InteropKt.toV2(Toolbars.upClicks(toolbar));
        Intrinsics.checkNotNullExpressionValue(create, "retryClicksRelay");
        this.i = create;
        Intrinsics.checkNotNullExpressionValue(create2, "dialogPositiveClicksRelay");
        this.j = create2;
        Intrinsics.checkNotNullExpressionValue(create3, "dialogNegativeClicksRelay");
        this.k = create3;
    }

    public static final Unit access$dismissDialog(WebPaymentViewImpl webPaymentViewImpl) {
        Dialog dialog = webPaymentViewImpl.d;
        if (dialog == null) {
            return null;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    public static final void access$showCancellationDialog(WebPaymentViewImpl webPaymentViewImpl) {
        webPaymentViewImpl.d = DialogRouter.DefaultImpls.showCancelableNotifyingDialog$default(webPaymentViewImpl.n, null, false, webPaymentViewImpl.o.getCancellationDialogMessage(), webPaymentViewImpl.o.getCancellationDialogNegativeButtonText(), new p5(1, webPaymentViewImpl), webPaymentViewImpl.o.getCancellationDialogPositiveButtonText(), new p5(0, webPaymentViewImpl), 3, null);
    }

    public static final void access$showErrorDialog(WebPaymentViewImpl webPaymentViewImpl) {
        webPaymentViewImpl.d = webPaymentViewImpl.n.showSimpleNotifyingDialog(webPaymentViewImpl.o.getErrorDialogTitle(), webPaymentViewImpl.o.getErrorDialogMessage(), webPaymentViewImpl.o.getErrorDialogButtonText(), new i(webPaymentViewImpl));
    }

    @Override // com.avito.android.payment.webview.WebPaymentView
    public void attachWebViewStateWatcher(@NotNull PaymentWebViewStateWatcher paymentWebViewStateWatcher) {
        Intrinsics.checkNotNullParameter(paymentWebViewStateWatcher, "stateWatcher");
        this.c.addLoadStateWatcher(paymentWebViewStateWatcher);
        this.c.setSslErrorHandlerDelegate(paymentWebViewStateWatcher);
    }

    @Override // com.avito.android.payment.webview.WebPaymentView
    public void destroyWebView() {
        ViewParent parent = this.c.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(this.c);
        this.c.clearHistory();
        this.c.removeAllViews();
        this.c.post(new b(this));
    }

    @Override // com.avito.android.payment.webview.WebPaymentView
    public void detachWebViewStateWatcher(@NotNull PaymentWebViewStateWatcher paymentWebViewStateWatcher) {
        Intrinsics.checkNotNullParameter(paymentWebViewStateWatcher, "stateWatcher");
        this.c.removeLoadStateWatcher(paymentWebViewStateWatcher);
        this.c.setSslErrorHandlerDelegate(null);
    }

    @Override // com.avito.android.payment.webview.WebPaymentView
    @NotNull
    public Consumer<DialogState> getDialogBinding() {
        return this.l;
    }

    @Override // com.avito.android.payment.webview.WebPaymentView
    @NotNull
    public Observable<Unit> getDialogNegativeClicks() {
        return this.k;
    }

    @Override // com.avito.android.payment.webview.WebPaymentView
    @NotNull
    public Observable<Unit> getDialogPositiveClicks() {
        return this.j;
    }

    @Override // com.avito.android.payment.webview.WebPaymentView
    @NotNull
    public Observable<Unit> getRetryClicks() {
        return this.i;
    }

    @Override // com.avito.android.payment.webview.WebPaymentView
    @NotNull
    public Consumer<ScreenState> getScreenBinding() {
        return this.m;
    }

    @Override // com.avito.android.payment.webview.WebPaymentView
    @NotNull
    public Observable<Unit> getToolbarCloseClicks() {
        return this.h;
    }

    @Override // com.avito.android.payment.webview.WebPaymentView
    @SuppressLint({"SetJavaScriptEnabled", "ClickableViewAccessibility"})
    public void initWebView() {
        this.c.requestFocus(130);
        this.c.setOnTouchListener(d.a);
        CookieManager instance = CookieManager.getInstance();
        instance.flush();
        instance.setAcceptCookie(true);
        WebSettings settings = this.c.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSaveFormData(false);
        settings.setAllowFileAccess(false);
        this.c.setBackgroundColor(0);
    }
}
