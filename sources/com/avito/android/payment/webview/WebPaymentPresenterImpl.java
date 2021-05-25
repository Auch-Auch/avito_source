package com.avito.android.payment.webview;

import a2.a.a.t1.g.d;
import a2.a.a.t1.g.e;
import a2.a.a.t1.g.f;
import a2.a.a.t1.g.h;
import a2.g.r.g;
import com.avito.android.payment.webview.DialogState;
import com.avito.android.payment.webview.ScreenState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0002\u0010H\u001a\u00020?¢\u0006\u0004\bI\u0010JJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020&0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010$R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001fR\u0016\u0010,\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b+\u0010\u001bR\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010\u001bR\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010\u001fR\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010\u001fR\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020?0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010$R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010\u001fR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006K"}, d2 = {"Lcom/avito/android/payment/webview/WebPaymentPresenterImpl;", "Lcom/avito/android/payment/webview/WebPaymentPresenter;", "Lcom/avito/android/payment/webview/WebPaymentView;", "view", "", "attachView", "(Lcom/avito/android/payment/webview/WebPaymentView;)V", "detachView", "()V", "Lcom/avito/android/payment/webview/WebPaymentRouter;", "router", "attachRouter", "(Lcom/avito/android/payment/webview/WebPaymentRouter;)V", "detachRouter", "", "onBackPressed", "()Z", "dispose", "Lcom/avito/android/payment/webview/PaymentWebViewStateWatcher;", VKApiConst.Q, "Lcom/avito/android/payment/webview/PaymentWebViewStateWatcher;", "webViewStateWatcher", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/webview/WebPaymentView;", "webView", "Lio/reactivex/disposables/CompositeDisposable;", "k", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposable", "Lcom/jakewharton/rxrelay2/PublishRelay;", g.a, "Lcom/jakewharton/rxrelay2/PublishRelay;", "backClicks", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "Lcom/avito/android/payment/webview/DialogState;", "c", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "dialogState", "Lcom/avito/android/payment/webview/WebPaymentResult;", "d", "resultState", "e", "toolbarCloseClicks", "j", "routerDisposable", "Lcom/avito/android/payment/webview/WebViewStatePresenter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/payment/webview/WebViewStatePresenter;", "webViewStatePresenter", "l", "lifecycleDisposable", "Lcom/avito/android/payment/webview/WebPaymentStateMachine;", "n", "Lcom/avito/android/payment/webview/WebPaymentStateMachine;", "stateMachine", "Lcom/avito/android/util/SchedulersFactory;", "p", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "f", "retryClicks", "h", "dialogPositiveClicks", "Lcom/avito/android/payment/webview/ScreenState;", AuthSource.BOOKING_ORDER, "state", "i", "dialogNegativeClicks", "", "o", "Ljava/lang/String;", "startUrl", "defaultState", "<init>", "(Lcom/avito/android/payment/webview/WebViewStatePresenter;Lcom/avito/android/payment/webview/WebPaymentStateMachine;Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/webview/PaymentWebViewStateWatcher;Lcom/avito/android/payment/webview/ScreenState;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class WebPaymentPresenterImpl implements WebPaymentPresenter {
    public WebPaymentView a;
    public final BehaviorRelay<ScreenState> b;
    public final BehaviorRelay<DialogState> c;
    public final BehaviorRelay<WebPaymentResult> d;
    public final PublishRelay<Unit> e;
    public final PublishRelay<Unit> f;
    public final PublishRelay<Unit> g;
    public final PublishRelay<Unit> h;
    public final PublishRelay<Unit> i;
    public CompositeDisposable j;
    public CompositeDisposable k;
    public final CompositeDisposable l;
    public final WebViewStatePresenter m;
    public final WebPaymentStateMachine n;
    public final String o;
    public final SchedulersFactory p;
    public final PaymentWebViewStateWatcher q;

    public static final class a<T, R> implements Function<ScreenState, ObservableSource<? extends ScreenState>> {
        public final /* synthetic */ WebPaymentPresenterImpl a;

        public a(WebPaymentPresenterImpl webPaymentPresenterImpl) {
            this.a = webPaymentPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ScreenState> apply(ScreenState screenState) {
            ScreenState screenState2 = screenState;
            Intrinsics.checkNotNullParameter(screenState2, "currentState");
            if (screenState2 instanceof ScreenState.Content) {
                return WebPaymentPresenterImpl.access$listenToWebViewEvents(this.a, screenState2);
            }
            if (screenState2 instanceof ScreenState.FullScreenLoading) {
                return WebPaymentPresenterImpl.access$startLoadWebView(this.a, screenState2);
            }
            if (screenState2 instanceof ScreenState.FullScreenError) {
                return WebPaymentPresenterImpl.access$reloadPageByRetryClicks(this.a, screenState2);
            }
            if (screenState2 instanceof ScreenState.Terminated) {
                return WebPaymentPresenterImpl.access$routeResult(this.a, (ScreenState.Terminated) screenState2);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<DialogState, ObservableSource<? extends DialogState>> {
        public final /* synthetic */ WebPaymentPresenterImpl a;

        public b(WebPaymentPresenterImpl webPaymentPresenterImpl) {
            this.a = webPaymentPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends DialogState> apply(DialogState dialogState) {
            DialogState dialogState2 = dialogState;
            Intrinsics.checkNotNullParameter(dialogState2, "currentState");
            if (dialogState2 instanceof DialogState.Preloading) {
                return WebPaymentPresenterImpl.access$listenToCloseClicksAndWebViewEvents(this.a, dialogState2);
            }
            if (dialogState2 instanceof DialogState.Content) {
                return WebPaymentPresenterImpl.access$listenToCloseClicksAndWebViewEvents(this.a, dialogState2);
            }
            if (dialogState2 instanceof DialogState.Cancellation) {
                return WebPaymentPresenterImpl.access$listenToCancellationDialog(this.a, dialogState2);
            }
            if (dialogState2 instanceof DialogState.ErrorAlert) {
                return WebPaymentPresenterImpl.access$listenToErrorDialog(this.a, dialogState2);
            }
            if (dialogState2 instanceof DialogState.Terminated) {
                return WebPaymentPresenterImpl.access$routeResult(this.a, (DialogState.Terminated) dialogState2);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c<T> implements Consumer<WebPaymentResult> {
        public final /* synthetic */ WebPaymentRouter a;

        public c(WebPaymentRouter webPaymentRouter) {
            this.a = webPaymentRouter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(WebPaymentResult webPaymentResult) {
            WebPaymentResult webPaymentResult2 = webPaymentResult;
            WebPaymentRouter webPaymentRouter = this.a;
            Intrinsics.checkNotNullExpressionValue(webPaymentResult2, "it");
            webPaymentRouter.closeScreenWithResult(webPaymentResult2);
        }
    }

    public WebPaymentPresenterImpl(@NotNull WebViewStatePresenter webViewStatePresenter, @NotNull WebPaymentStateMachine webPaymentStateMachine, @NotNull String str, @NotNull SchedulersFactory schedulersFactory, @NotNull PaymentWebViewStateWatcher paymentWebViewStateWatcher, @NotNull ScreenState screenState) {
        Intrinsics.checkNotNullParameter(webViewStatePresenter, "webViewStatePresenter");
        Intrinsics.checkNotNullParameter(webPaymentStateMachine, "stateMachine");
        Intrinsics.checkNotNullParameter(str, "startUrl");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(paymentWebViewStateWatcher, "webViewStateWatcher");
        Intrinsics.checkNotNullParameter(screenState, "defaultState");
        this.m = webViewStatePresenter;
        this.n = webPaymentStateMachine;
        this.o = str;
        this.p = schedulersFactory;
        this.q = paymentWebViewStateWatcher;
        BehaviorRelay<ScreenState> createDefault = BehaviorRelay.createDefault(screenState);
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefault(defaultState)");
        this.b = createDefault;
        BehaviorRelay<DialogState> createDefault2 = BehaviorRelay.createDefault(new DialogState.Preloading());
        Intrinsics.checkNotNullExpressionValue(createDefault2, "BehaviorRelay.createDefa…gState.Preloading()\n    )");
        this.c = createDefault2;
        BehaviorRelay<WebPaymentResult> create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        this.d = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.e = create2;
        PublishRelay<Unit> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.f = create3;
        PublishRelay<Unit> create4 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
        this.g = create4;
        PublishRelay<Unit> create5 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create5, "PublishRelay.create()");
        this.h = create5;
        PublishRelay<Unit> create6 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create6, "PublishRelay.create()");
        this.i = create6;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.l = compositeDisposable;
        Disposable subscribe = webViewStatePresenter.getFinalDeepLink().map(a2.a.a.t1.g.b.a).subscribe(create);
        Intrinsics.checkNotNullExpressionValue(subscribe, "listenToDeeplinkRedirect()");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        Observable<ScreenState> distinctUntilChanged = createDefault.distinctUntilChanged(WebPaymentPresenterImpl$$special$$inlined$distinctTypes$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "this.distinctUntilChange…vaClass == t2.javaClass }");
        Observable<R> switchMap = distinctUntilChanged.switchMap(new a(this));
        Intrinsics.checkNotNullExpressionValue(switchMap, "state\n            .disti…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, Observables.subscribeOnNext(switchMap, createDefault));
        Observable<DialogState> distinctUntilChanged2 = createDefault2.distinctUntilChanged(WebPaymentPresenterImpl$$special$$inlined$distinctTypes$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged2, "this.distinctUntilChange…vaClass == t2.javaClass }");
        Observable<R> switchMap2 = distinctUntilChanged2.switchMap(new b(this));
        Intrinsics.checkNotNullExpressionValue(switchMap2, "dialogState\n            …          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, Observables.subscribeOnNext(switchMap2, createDefault2));
    }

    public static final Observable access$listenToCancellationDialog(WebPaymentPresenterImpl webPaymentPresenterImpl, DialogState dialogState) {
        return Observable.merge(webPaymentPresenterImpl.i.map(new a1(0, webPaymentPresenterImpl, dialogState)), webPaymentPresenterImpl.h.map(new a1(1, webPaymentPresenterImpl, dialogState)));
    }

    public static final Observable access$listenToCloseClicksAndWebViewEvents(WebPaymentPresenterImpl webPaymentPresenterImpl, DialogState dialogState) {
        return Observable.merge(webPaymentPresenterImpl.e.map(new q(0, webPaymentPresenterImpl, dialogState)), webPaymentPresenterImpl.g.map(new q(1, webPaymentPresenterImpl, dialogState)), webPaymentPresenterImpl.m.getLoadingState().map(new a2.a.a.t1.g.a(webPaymentPresenterImpl, dialogState)));
    }

    public static final Observable access$listenToErrorDialog(WebPaymentPresenterImpl webPaymentPresenterImpl, DialogState dialogState) {
        return webPaymentPresenterImpl.h.map(new a2.a.a.t1.g.c(webPaymentPresenterImpl, dialogState));
    }

    public static final Observable access$listenToWebViewEvents(WebPaymentPresenterImpl webPaymentPresenterImpl, ScreenState screenState) {
        return webPaymentPresenterImpl.m.getLoadingState().map(new d(webPaymentPresenterImpl, screenState));
    }

    public static final Observable access$reloadPageByRetryClicks(WebPaymentPresenterImpl webPaymentPresenterImpl, ScreenState screenState) {
        return webPaymentPresenterImpl.f.map(new e(webPaymentPresenterImpl, screenState));
    }

    public static final Observable access$routeResult(WebPaymentPresenterImpl webPaymentPresenterImpl, DialogState.Terminated terminated) {
        Objects.requireNonNull(webPaymentPresenterImpl);
        Observable just = Observable.just(terminated);
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
        return just.doOnNext(new a2.a.a.t1.g.g(webPaymentPresenterImpl));
    }

    public static final Observable access$startLoadWebView(WebPaymentPresenterImpl webPaymentPresenterImpl, ScreenState screenState) {
        webPaymentPresenterImpl.m.loadUrl(webPaymentPresenterImpl.o);
        Observable<R> map = webPaymentPresenterImpl.m.getLoadingState().map(new h(webPaymentPresenterImpl, screenState));
        Intrinsics.checkNotNullExpressionValue(map, "webViewStatePresenter.lo…ate, webViewState = it) }");
        return map;
    }

    @Override // com.avito.android.payment.webview.WebPaymentPresenter
    public void attachRouter(@NotNull WebPaymentRouter webPaymentRouter) {
        Intrinsics.checkNotNullParameter(webPaymentRouter, "router");
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.j = compositeDisposable;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("routerDisposable");
        }
        Disposable subscribe = this.d.observeOn(this.p.mainThread()).subscribe(new c(webPaymentRouter));
        Intrinsics.checkNotNullExpressionValue(subscribe, "resultState\n            …hResult(it)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.payment.webview.WebPaymentPresenter
    public void attachView(@NotNull WebPaymentView webPaymentView) {
        Intrinsics.checkNotNullParameter(webPaymentView, "view");
        webPaymentView.initWebView();
        webPaymentView.attachWebViewStateWatcher(this.q);
        this.a = webPaymentView;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.k = compositeDisposable;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDisposable");
        }
        Disposable subscribe = webPaymentView.getToolbarCloseClicks().subscribe(this.e);
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.toolbarCloseClicks.…cribe(toolbarCloseClicks)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.k;
        if (compositeDisposable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDisposable");
        }
        Disposable subscribe2 = webPaymentView.getDialogNegativeClicks().subscribe(this.i);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.dialogNegativeClick…ibe(dialogNegativeClicks)");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.k;
        if (compositeDisposable3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDisposable");
        }
        Disposable subscribe3 = webPaymentView.getDialogPositiveClicks().subscribe(this.h);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.dialogPositiveClick…ibe(dialogPositiveClicks)");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.k;
        if (compositeDisposable4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDisposable");
        }
        Disposable subscribe4 = webPaymentView.getRetryClicks().subscribe(this.f);
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.retryClicks.subscribe(retryClicks)");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.k;
        if (compositeDisposable5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDisposable");
        }
        Observable<ScreenState> observeOn = this.b.observeOn(this.p.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "state\n            .obser…(schedulers.mainThread())");
        DisposableKt.plusAssign(compositeDisposable5, Observables.subscribeOnNext(observeOn, webPaymentView.getScreenBinding()));
        CompositeDisposable compositeDisposable6 = this.k;
        if (compositeDisposable6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDisposable");
        }
        Observable<DialogState> observeOn2 = this.c.observeOn(this.p.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn2, "dialogState\n            …(schedulers.mainThread())");
        DisposableKt.plusAssign(compositeDisposable6, Observables.subscribeOnNext(observeOn2, webPaymentView.getDialogBinding()));
    }

    @Override // com.avito.android.payment.webview.WebPaymentPresenter
    public void detachRouter() {
        CompositeDisposable compositeDisposable = this.j;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("routerDisposable");
        }
        compositeDisposable.dispose();
    }

    @Override // com.avito.android.payment.webview.WebPaymentPresenter
    public void detachView() {
        WebPaymentView webPaymentView = this.a;
        if (webPaymentView != null) {
            webPaymentView.detachWebViewStateWatcher(this.q);
        }
        WebPaymentView webPaymentView2 = this.a;
        if (webPaymentView2 != null) {
            webPaymentView2.destroyWebView();
        }
        CompositeDisposable compositeDisposable = this.k;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDisposable");
        }
        compositeDisposable.dispose();
    }

    @Override // com.avito.android.payment.webview.WebPaymentPresenter
    public void dispose() {
        this.l.dispose();
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        this.g.accept(Unit.INSTANCE);
        return true;
    }

    public static final Observable access$routeResult(WebPaymentPresenterImpl webPaymentPresenterImpl, ScreenState.Terminated terminated) {
        Objects.requireNonNull(webPaymentPresenterImpl);
        Observable just = Observable.just(terminated);
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
        return just.doOnNext(new f(webPaymentPresenterImpl));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebPaymentPresenterImpl(WebViewStatePresenter webViewStatePresenter, WebPaymentStateMachine webPaymentStateMachine, String str, SchedulersFactory schedulersFactory, PaymentWebViewStateWatcher paymentWebViewStateWatcher, ScreenState screenState, int i2, j jVar) {
        this(webViewStatePresenter, webPaymentStateMachine, str, schedulersFactory, paymentWebViewStateWatcher, (i2 & 32) != 0 ? new ScreenState.FullScreenLoading() : screenState);
    }
}
