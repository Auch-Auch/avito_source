package com.avito.android.payment.webview;

import a2.a.a.t1.g.j;
import android.net.Uri;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.CarBookingOrderPaymentSuccessLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeliveryCourierOrderPaymentSuccessLink;
import com.avito.android.deep_linking.links.DeliveryOrderPaymentSuccessLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.StrBookingPaymentSuccessLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.view.PowerWebViewWrapper;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0014\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b6\u00107J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8V@\u0016X\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R:\u0010\u001c\u001a&\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00020\u0002 \u0019*\u0012\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0012R:\u0010(\u001a&\u0012\f\u0012\n \u0019*\u0004\u0018\u00010%0% \u0019*\u0012\u0012\f\u0012\n \u0019*\u0004\u0018\u00010%0%\u0018\u00010$0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R:\u00102\u001a&\u0012\f\u0012\n \u0019*\u0004\u0018\u00010000 \u0019*\u0012\u0012\f\u0012\n \u0019*\u0004\u0018\u00010000\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010\u001bR:\u00105\u001a&\u0012\f\u0012\n \u0019*\u0004\u0018\u00010303 \u0019*\u0012\u0012\f\u0012\n \u0019*\u0004\u0018\u00010303\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010\u001b¨\u00068"}, d2 = {"Lcom/avito/android/payment/webview/WebViewStatePresenterImpl;", "Lcom/avito/android/payment/webview/WebViewStatePresenter;", "", "url", "", "loadUrl", "(Ljava/lang/String;)V", "Lcom/avito/android/ui/view/PowerWebViewWrapper;", "powerWebView", "attachView", "(Lcom/avito/android/ui/view/PowerWebViewWrapper;)V", "detachView", "()V", "Lio/reactivex/Observable;", "Lcom/avito/android/payment/webview/WebViewState;", "f", "Lkotlin/Lazy;", "getLoadingState", "()Lio/reactivex/Observable;", "loadingState", "com/avito/android/payment/webview/WebViewStatePresenterImpl$urlInterceptor$1", a2.g.r.g.a, "Lcom/avito/android/payment/webview/WebViewStatePresenterImpl$urlInterceptor$1;", "urlInterceptor", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "kotlin.jvm.PlatformType", "c", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "loadUrlState", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/deep_linking/links/DeepLink;", "getFinalDeepLink", "finalDeepLink", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", "d", "Lcom/jakewharton/rxrelay2/PublishRelay;", "webViewEvents", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "h", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", AuthSource.SEND_ABUSE, "Lcom/avito/android/ui/view/PowerWebViewWrapper;", "webView", "Landroid/net/Uri;", "e", "redirects", "", AuthSource.BOOKING_ORDER, "attachState", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/util/SchedulersFactory;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class WebViewStatePresenterImpl implements WebViewStatePresenter {
    public PowerWebViewWrapper a;
    public final BehaviorRelay<Boolean> b;
    public final BehaviorRelay<String> c;
    public final PublishRelay<PowerWebViewStateChangeEvent> d;
    public final BehaviorRelay<Uri> e = BehaviorRelay.create();
    @NotNull
    public final Lazy f;
    public final WebViewStatePresenterImpl$urlInterceptor$1 g;
    public final DeepLinkFactory h;
    public final SchedulersFactory i;

    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ WebViewStatePresenterImpl a;

        public a(WebViewStatePresenterImpl webViewStatePresenterImpl) {
            this.a = webViewStatePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            PowerWebViewWrapper powerWebViewWrapper = this.a.a;
            if (powerWebViewWrapper != null) {
                Intrinsics.checkNotNullExpressionValue(str2, "it");
                powerWebViewWrapper.loadUrl(str2);
            }
        }
    }

    public static final class b<T, R> implements Function<Boolean, ObservableSource<? extends PowerWebViewStateChangeEvent>> {
        public final /* synthetic */ WebViewStatePresenterImpl a;

        public b(WebViewStatePresenterImpl webViewStatePresenterImpl) {
            this.a = webViewStatePresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends PowerWebViewStateChangeEvent> apply(Boolean bool) {
            if (!bool.booleanValue()) {
                return Observable.never();
            }
            PowerWebViewWrapper powerWebViewWrapper = this.a.a;
            Intrinsics.checkNotNull(powerWebViewWrapper);
            return InteropKt.toV2(powerWebViewWrapper.getStateChangeEvents());
        }
    }

    public static final class c<T> implements Predicate<Pair<? extends String, ? extends Boolean>> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Pair<? extends String, ? extends Boolean> pair) {
            Pair<? extends String, ? extends Boolean> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "it");
            Object second = pair2.getSecond();
            Intrinsics.checkNotNullExpressionValue(second, "it.second");
            return ((Boolean) second).booleanValue();
        }
    }

    public static final class d<T, R> implements Function<Pair<? extends String, ? extends Boolean>, String> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public String apply(Pair<? extends String, ? extends Boolean> pair) {
            Pair<? extends String, ? extends Boolean> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "it");
            return (String) pair2.getFirst();
        }
    }

    public static final class e<T, R> implements Function<Uri, DeepLink> {
        public final /* synthetic */ WebViewStatePresenterImpl a;

        public e(WebViewStatePresenterImpl webViewStatePresenterImpl) {
            this.a = webViewStatePresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public DeepLink apply(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, "it");
            return WebViewStatePresenterImpl.access$processRedirectDeepLink(this.a, uri2);
        }
    }

    public static final class f extends Lambda implements Function1<DeepLink, Boolean> {
        public static final f a = new f();

        public f() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(DeepLink deepLink) {
            return Boolean.valueOf(deepLink instanceof NoMatchLink);
        }
    }

    public static final class g extends Lambda implements Function0<Observable<WebViewState>> {
        public final /* synthetic */ WebViewStatePresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(WebViewStatePresenterImpl webViewStatePresenterImpl) {
            super(0);
            this.a = webViewStatePresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Observable<WebViewState> invoke() {
            Observable map = this.a.d.filter(j1.e).take(1).map(n0.d);
            Observable map2 = this.a.d.filter(j1.b).map(n0.b);
            Observable filter = this.a.d.filter(j1.c);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Observable map3 = filter.debounce(1000, timeUnit, this.a.i.computation()).filter(j1.d).map(n0.c);
            Scheduler computation = this.a.i.computation();
            Observable just = Observable.just(WebViewState.ERROR);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return Observable.merge(map, map3.timeout(30000, timeUnit, computation, just).take(1), map2).takeUntil(j.a).share();
        }
    }

    public WebViewStatePresenterImpl(@NotNull DeepLinkFactory deepLinkFactory, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.h = deepLinkFactory;
        this.i = schedulersFactory;
        BehaviorRelay<Boolean> create = BehaviorRelay.create();
        this.b = create;
        BehaviorRelay<String> create2 = BehaviorRelay.create();
        this.c = create2;
        PublishRelay<PowerWebViewStateChangeEvent> create3 = PublishRelay.create();
        this.d = create3;
        Intrinsics.checkNotNullExpressionValue(create2, "loadUrlState");
        Intrinsics.checkNotNullExpressionValue(create, "attachState");
        Observable combineLatest = Observable.combineLatest(create2, create, new BiFunction<T1, T2, R>() { // from class: com.avito.android.payment.webview.WebViewStatePresenterImpl$$special$$inlined$combineLatestWith$1
            @Override // io.reactivex.functions.BiFunction
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                return (R) TuplesKt.to(t1, t2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        Observable map = combineLatest.filter(c.a).map(d.a);
        Intrinsics.checkNotNullExpressionValue(map, "loadUrlState.combineLate…        .map { it.first }");
        Observable<R> switchMap = create.switchMap(new b(this));
        Intrinsics.checkNotNullExpressionValue(switchMap, "attachState.switchMap { …          }\n            }");
        map.subscribe(new a(this));
        switchMap.subscribe(create3);
        this.f = t6.c.lazy(new g(this));
        this.g = new WebViewStatePresenterImpl$urlInterceptor$1(this);
    }

    public static final DeepLink access$processRedirectDeepLink(WebViewStatePresenterImpl webViewStatePresenterImpl, Uri uri) {
        DeepLink createFromUri = webViewStatePresenterImpl.h.createFromUri(uri);
        if (createFromUri instanceof DeliveryOrderPaymentSuccessLink) {
            return webViewStatePresenterImpl.h.createFromUri(((DeliveryOrderPaymentSuccessLink) createFromUri).getRedirectUri());
        }
        if (createFromUri instanceof CarBookingOrderPaymentSuccessLink) {
            return webViewStatePresenterImpl.h.createFromUri(((CarBookingOrderPaymentSuccessLink) createFromUri).getRedirectUri());
        }
        if (createFromUri instanceof StrBookingPaymentSuccessLink) {
            return webViewStatePresenterImpl.h.createFromUri(((StrBookingPaymentSuccessLink) createFromUri).getRedirectUri());
        }
        return createFromUri instanceof DeliveryCourierOrderPaymentSuccessLink ? webViewStatePresenterImpl.h.createFromUri(((DeliveryCourierOrderPaymentSuccessLink) createFromUri).getRedirectUri()) : createFromUri;
    }

    @Override // com.avito.android.payment.webview.WebViewStatePresenter
    public void attachView(@NotNull PowerWebViewWrapper powerWebViewWrapper) {
        Intrinsics.checkNotNullParameter(powerWebViewWrapper, "powerWebView");
        this.a = powerWebViewWrapper;
        if (powerWebViewWrapper != null) {
            powerWebViewWrapper.addInterceptor(this.g);
            this.b.accept(Boolean.TRUE);
        }
    }

    @Override // com.avito.android.payment.webview.WebViewStatePresenter
    public void detachView() {
        this.b.accept(Boolean.FALSE);
        PowerWebViewWrapper powerWebViewWrapper = this.a;
        if (powerWebViewWrapper != null) {
            powerWebViewWrapper.removeInterceptor(this.g);
        }
        this.a = null;
    }

    @Override // com.avito.android.payment.webview.WebViewStatePresenter
    @NotNull
    public Observable<DeepLink> getFinalDeepLink() {
        Observable<R> map = this.e.map(new e(this));
        Intrinsics.checkNotNullExpressionValue(map, "redirects\n            .m…essRedirectDeepLink(it) }");
        Observable<DeepLink> take = Observables.filterNot(map, f.a).take(1);
        Intrinsics.checkNotNullExpressionValue(take, "redirects\n            .m…nk }\n            .take(1)");
        return take;
    }

    @Override // com.avito.android.payment.webview.WebViewStatePresenter
    @NotNull
    public Observable<WebViewState> getLoadingState() {
        return (Observable) this.f.getValue();
    }

    @Override // com.avito.android.payment.webview.WebViewStatePresenter
    public void loadUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.c.accept(str);
    }
}
