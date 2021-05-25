package com.avito.android.payment.form.status;

import a2.g.r.g;
import android.net.Uri;
import com.avito.android.payment.form.status.ScreenState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.status.form.PaymentStatusFormResult;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0011R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u0011R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0011R\"\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0015R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010\u0015¨\u0006="}, d2 = {"Lcom/avito/android/payment/form/status/PaymentStatusFormPresenterImpl;", "Lcom/avito/android/payment/form/status/PaymentStatusFormPresenter;", "Lcom/avito/android/payment/form/status/PaymentStatusFormRouter;", "router", "", "attachRouter", "(Lcom/avito/android/payment/form/status/PaymentStatusFormRouter;)V", "Lcom/avito/android/payment/form/status/PaymentStatusFormView;", "view", "attachView", "(Lcom/avito/android/payment/form/status/PaymentStatusFormView;)V", "detachView", "()V", "detachRouter", "dispose", "Lcom/jakewharton/rxrelay2/PublishRelay;", "e", "Lcom/jakewharton/rxrelay2/PublishRelay;", "submitClicks", "Lio/reactivex/disposables/CompositeDisposable;", g.a, "Lio/reactivex/disposables/CompositeDisposable;", "routerDisposable", "c", "routerClose", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Landroid/net/Uri;", "f", "routerSubmit", AuthSource.BOOKING_ORDER, "toolbarUpClicks", "d", "retryClicks", "Lkotlin/Function0;", "j", "Lkotlin/jvm/functions/Function0;", "getSubmitButtonListener", "()Lkotlin/jvm/functions/Function0;", "submitButtonListener", "i", "lifecycleDisposable", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "Lcom/avito/android/payment/form/status/ScreenState;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "state", "Lcom/avito/android/payment/form/status/PaymentStatusFormItemConverter;", "l", "Lcom/avito/android/payment/form/status/PaymentStatusFormItemConverter;", "itemConverter", "Lcom/avito/android/payment/form/status/PaymentStatusFormInteractor;", "k", "Lcom/avito/android/payment/form/status/PaymentStatusFormInteractor;", "interactor", "h", "viewDisposable", "<init>", "(Lcom/avito/android/payment/form/status/PaymentStatusFormInteractor;Lcom/avito/android/payment/form/status/PaymentStatusFormItemConverter;Lcom/avito/android/util/SchedulersFactory;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentStatusFormPresenterImpl implements PaymentStatusFormPresenter {
    public final BehaviorRelay<ScreenState> a;
    public final PublishRelay<Unit> b;
    public final PublishRelay<Unit> c;
    public final PublishRelay<Unit> d;
    public final PublishRelay<Unit> e;
    public final PublishRelay<Uri> f;
    public final CompositeDisposable g = new CompositeDisposable();
    public final CompositeDisposable h = new CompositeDisposable();
    public final CompositeDisposable i;
    @NotNull
    public final Function0<Unit> j;
    public final PaymentStatusFormInteractor k;
    public final PaymentStatusFormItemConverter l;
    public final SchedulersFactory m;

    public static final class a<T, R> implements Function<ScreenState, ObservableSource<? extends ScreenState>> {
        public final /* synthetic */ PaymentStatusFormPresenterImpl a;

        public a(PaymentStatusFormPresenterImpl paymentStatusFormPresenterImpl) {
            this.a = paymentStatusFormPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ScreenState> apply(ScreenState screenState) {
            ScreenState screenState2 = screenState;
            Intrinsics.checkNotNullParameter(screenState2, "currentState");
            if (screenState2 instanceof ScreenState.Content) {
                return Observable.never();
            }
            if (screenState2 instanceof ScreenState.FullScreenLoading) {
                return PaymentStatusFormPresenterImpl.access$requestInitialContent(this.a);
            }
            if (screenState2 instanceof ScreenState.FullScreenError) {
                return PaymentStatusFormPresenterImpl.access$reloadDataByRetryClicks(this.a);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T> implements Consumer<ScreenState> {
        public final /* synthetic */ PaymentStatusFormPresenterImpl a;

        public b(PaymentStatusFormPresenterImpl paymentStatusFormPresenterImpl) {
            this.a = paymentStatusFormPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay2.BehaviorRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(ScreenState screenState) {
            this.a.a.accept(screenState);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.warning("PaymentStatusFormPresenter", "Error while processing state", th);
        }
    }

    public static final class d<T> implements Consumer<Uri> {
        public final /* synthetic */ PaymentStatusFormRouter a;

        public d(PaymentStatusFormRouter paymentStatusFormRouter) {
            this.a = paymentStatusFormRouter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Uri uri) {
            Uri uri2 = uri;
            PaymentStatusFormRouter paymentStatusFormRouter = this.a;
            Intrinsics.checkNotNullExpressionValue(uri2, "it");
            paymentStatusFormRouter.followUri(uri2);
        }
    }

    public static final class e<T> implements Consumer<Unit> {
        public final /* synthetic */ PaymentStatusFormRouter a;

        public e(PaymentStatusFormRouter paymentStatusFormRouter) {
            this.a = paymentStatusFormRouter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.closeScreen();
        }
    }

    public PaymentStatusFormPresenterImpl(@NotNull PaymentStatusFormInteractor paymentStatusFormInteractor, @NotNull PaymentStatusFormItemConverter paymentStatusFormItemConverter, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(paymentStatusFormInteractor, "interactor");
        Intrinsics.checkNotNullParameter(paymentStatusFormItemConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.k = paymentStatusFormInteractor;
        this.l = paymentStatusFormItemConverter;
        this.m = schedulersFactory;
        BehaviorRelay<ScreenState> createDefault = BehaviorRelay.createDefault(new ScreenState.FullScreenLoading());
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefa…tate.FullScreenLoading())");
        this.a = createDefault;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.b = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.c = create2;
        PublishRelay<Unit> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.d = create3;
        PublishRelay<Unit> create4 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
        this.e = create4;
        PublishRelay<Uri> create5 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create5, "PublishRelay.create()");
        this.f = create5;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.i = compositeDisposable;
        this.j = new a2.a.a.t1.b.n.a(create4);
        create.subscribe(create2);
        Observable<ScreenState> distinctUntilChanged = createDefault.distinctUntilChanged(PaymentStatusFormPresenterImpl$$special$$inlined$distinctTypes$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "this.distinctUntilChange…vaClass == t2.javaClass }");
        Disposable subscribe = distinctUntilChanged.switchMap(new a(this)).subscribe(new b(this), c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "state\n            .disti…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final ScreenState access$bindContent(PaymentStatusFormPresenterImpl paymentStatusFormPresenterImpl, PaymentStatusFormResult.StatusForm statusForm) {
        paymentStatusFormPresenterImpl.e.subscribe(new a2.a.a.t1.b.n.b(paymentStatusFormPresenterImpl, statusForm));
        return paymentStatusFormPresenterImpl.l.convert(statusForm);
    }

    public static final Observable access$reloadDataByRetryClicks(PaymentStatusFormPresenterImpl paymentStatusFormPresenterImpl) {
        return paymentStatusFormPresenterImpl.d.map(a2.a.a.t1.b.n.c.a);
    }

    public static final Observable access$requestInitialContent(PaymentStatusFormPresenterImpl paymentStatusFormPresenterImpl) {
        Observable<R> map = paymentStatusFormPresenterImpl.k.getPaymentStatusForm().map(new a2.a.a.t1.b.n.d(paymentStatusFormPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(map, "interactor.getPaymentSta…)\n            }\n        }");
        return map;
    }

    @Override // com.avito.android.payment.form.status.PaymentStatusFormPresenter
    public void attachRouter(@NotNull PaymentStatusFormRouter paymentStatusFormRouter) {
        Intrinsics.checkNotNullParameter(paymentStatusFormRouter, "router");
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = this.f.subscribe(new d(paymentStatusFormRouter));
        Intrinsics.checkNotNullExpressionValue(subscribe, "routerSubmit\n           … { router.followUri(it) }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.g;
        Disposable subscribe2 = this.c.subscribe(new e(paymentStatusFormRouter));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "routerClose\n            … { router.closeScreen() }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    @Override // com.avito.android.payment.form.status.PaymentStatusFormPresenter
    public void attachView(@NotNull PaymentStatusFormView paymentStatusFormView) {
        Intrinsics.checkNotNullParameter(paymentStatusFormView, "view");
        CompositeDisposable compositeDisposable = this.h;
        Disposable subscribe = paymentStatusFormView.getToolbarUpClicks().subscribe(this.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.toolbarUpClicks.subscribe(toolbarUpClicks)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.h;
        Disposable subscribe2 = paymentStatusFormView.getRetryClicks().subscribe(this.d);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.retryClicks.subscribe(retryClicks)");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.h;
        Disposable subscribe3 = this.a.observeOn(this.m.mainThread()).subscribe(paymentStatusFormView.getScreenBinding());
        Intrinsics.checkNotNullExpressionValue(subscribe3, "state\n            .obser…cribe(view.screenBinding)");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
    }

    @Override // com.avito.android.payment.form.status.PaymentStatusFormPresenter
    public void detachRouter() {
        this.g.clear();
    }

    @Override // com.avito.android.payment.form.status.PaymentStatusFormPresenter
    public void detachView() {
        this.h.clear();
    }

    @Override // com.avito.android.payment.form.status.PaymentStatusFormPresenter
    public void dispose() {
        this.i.dispose();
    }

    @Override // com.avito.android.payment.form.status.PaymentStatusFormViewListener
    @NotNull
    public Function0<Unit> getSubmitButtonListener() {
        return this.j;
    }
}
