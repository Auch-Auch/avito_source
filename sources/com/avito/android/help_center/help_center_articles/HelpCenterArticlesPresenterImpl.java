package com.avito.android.help_center.help_center_articles;

import a2.g.r.g;
import android.net.Uri;
import android.webkit.CookieManager;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.help_center.HelpCenterJSEvent;
import com.avito.android.help_center.HelpCenterJSInterface;
import com.avito.android.help_center.HelpCenterUrlInterceptor;
import com.avito.android.help_center.HelpCenterUrlProvider;
import com.avito.android.help_center.help_center_articles.HelpCenterArticlesPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.facebook.share.internal.ShareConstants;
import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002Bg\b\u0007\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\b\u0001\u0010:\u001a\u00020,\u0012\n\b\u0001\u0010;\u001a\u0004\u0018\u00010,\u0012\n\b\u0001\u0010<\u001a\u0004\u0018\u00010,\u0012\n\b\u0001\u0010=\u001a\u0004\u0018\u00010,¢\u0006\u0004\b>\u0010?J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\tR\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006@"}, d2 = {"Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesPresenterImpl;", "Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesPresenter;", "Lcom/avito/android/help_center/HelpCenterUrlInterceptor$CallBack;", "Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesView;", "view", "", "attachView", "(Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesView;)V", "detachView", "()V", "Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesPresenter$Router;)V", "detachRouter", "", "handleBack", "()Z", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "doesNotSupportUrl", "(Landroid/net/Uri;)V", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/help_center/HelpCenterUrlInterceptor;", "j", "Lcom/avito/android/help_center/HelpCenterUrlInterceptor;", "urlInterceptor", "Lcom/avito/android/cookie_provider/CookieProvider;", g.a, "Lcom/avito/android/cookie_provider/CookieProvider;", "cookieProvider", AuthSource.BOOKING_ORDER, "Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesView;", "Lcom/avito/android/util/SchedulersFactory;", "e", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Landroid/webkit/CookieManager;", "f", "Landroid/webkit/CookieManager;", "cookieManager", "", "d", "Ljava/lang/String;", "currentUrl", "c", "Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesPresenter$Router;", "Lcom/avito/android/help_center/HelpCenterUrlProvider;", "i", "Lcom/avito/android/help_center/HelpCenterUrlProvider;", "helpCenterUrlProvider", "Lcom/avito/android/help_center/HelpCenterJSInterface;", "h", "Lcom/avito/android/help_center/HelpCenterJSInterface;", "jsInterface", "articleId", "theme", "advertisementId", "contextId", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Landroid/webkit/CookieManager;Lcom/avito/android/cookie_provider/CookieProvider;Lcom/avito/android/help_center/HelpCenterJSInterface;Lcom/avito/android/help_center/HelpCenterUrlProvider;Lcom/avito/android/help_center/HelpCenterUrlInterceptor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "help-center_release"}, k = 1, mv = {1, 4, 2})
public final class HelpCenterArticlesPresenterImpl implements HelpCenterArticlesPresenter, HelpCenterUrlInterceptor.CallBack {
    public final CompositeDisposable a = new CompositeDisposable();
    public HelpCenterArticlesView b;
    public HelpCenterArticlesPresenter.Router c;
    public String d;
    public final SchedulersFactory e;
    public final CookieManager f;
    public final CookieProvider g;
    public final HelpCenterJSInterface h;
    public final HelpCenterUrlProvider i;
    public final HelpCenterUrlInterceptor j;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PowerWebViewStateChangeEvent.State.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[3] = 3;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                return;
            }
            if (i != 1) {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<HelpCenterJSEvent, Unit> {
        public final /* synthetic */ HelpCenterArticlesPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(HelpCenterArticlesPresenterImpl helpCenterArticlesPresenterImpl) {
            super(1);
            this.a = helpCenterArticlesPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(HelpCenterJSEvent helpCenterJSEvent) {
            if (helpCenterJSEvent instanceof HelpCenterJSEvent.UpdateCookie) {
                this.a.a();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Consumer<PowerWebViewStateChangeEvent> {
        public final /* synthetic */ HelpCenterArticlesView a;

        public c(HelpCenterArticlesView helpCenterArticlesView) {
            this.a = helpCenterArticlesView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(PowerWebViewStateChangeEvent powerWebViewStateChangeEvent) {
            PowerWebViewStateChangeEvent powerWebViewStateChangeEvent2 = powerWebViewStateChangeEvent;
            int ordinal = powerWebViewStateChangeEvent2.getState().ordinal();
            boolean z = true;
            if (ordinal == 0) {
                String url = powerWebViewStateChangeEvent2.getUrl();
                if (!(url == null || url.length() == 0)) {
                    z = false;
                }
                if (!z) {
                    this.a.startLoad();
                }
            } else if (ordinal == 1) {
                this.a.showData();
            } else if (ordinal == 3) {
                this.a.showError();
            }
        }
    }

    public static final class d<T> implements Consumer<Unit> {
        public final /* synthetic */ HelpCenterArticlesPresenterImpl a;

        public d(HelpCenterArticlesPresenterImpl helpCenterArticlesPresenterImpl) {
            this.a = helpCenterArticlesPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            HelpCenterArticlesPresenter.Router router = this.a.c;
            if (router != null) {
                router.leaveScreen();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007b, code lost:
        if ((r11 == null || t6.y.m.isBlank(r11)) == false) goto L_0x007d;
     */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HelpCenterArticlesPresenterImpl(@org.jetbrains.annotations.NotNull com.avito.android.util.SchedulersFactory r2, @org.jetbrains.annotations.NotNull android.webkit.CookieManager r3, @org.jetbrains.annotations.NotNull com.avito.android.cookie_provider.CookieProvider r4, @org.jetbrains.annotations.NotNull com.avito.android.help_center.HelpCenterJSInterface r5, @org.jetbrains.annotations.NotNull com.avito.android.help_center.HelpCenterUrlProvider r6, @org.jetbrains.annotations.NotNull com.avito.android.help_center.HelpCenterUrlInterceptor r7, @com.avito.android.help_center.help_center_articles.di.ArticleId @org.jetbrains.annotations.NotNull java.lang.String r8, @com.avito.android.help_center.help_center_articles.di.Theme @org.jetbrains.annotations.Nullable java.lang.String r9, @com.avito.android.help_center.help_center_articles.di.AdvertisementId @org.jetbrains.annotations.Nullable java.lang.String r10, @com.avito.android.help_center.help_center_articles.di.ContextId @org.jetbrains.annotations.Nullable java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.help_center.help_center_articles.HelpCenterArticlesPresenterImpl.<init>(com.avito.android.util.SchedulersFactory, android.webkit.CookieManager, com.avito.android.cookie_provider.CookieProvider, com.avito.android.help_center.HelpCenterJSInterface, com.avito.android.help_center.HelpCenterUrlProvider, com.avito.android.help_center.HelpCenterUrlInterceptor, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final void a() {
        CookieManager cookieManager = this.f;
        cookieManager.setAcceptCookie(true);
        Iterator<T> it = this.g.getCookies().iterator();
        while (it.hasNext()) {
            cookieManager.setCookie(".avito.ru", it.next());
        }
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesPresenter
    public void attachRouter(@NotNull HelpCenterArticlesPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.c = router;
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesPresenter
    public void attachView(@NotNull HelpCenterArticlesView helpCenterArticlesView) {
        Intrinsics.checkNotNullParameter(helpCenterArticlesView, "view");
        this.b = helpCenterArticlesView;
        this.j.setCallBack(this);
        helpCenterArticlesView.addJavascriptInterface(this.h, "android");
        helpCenterArticlesView.addInterceptor(this.j);
        a();
        helpCenterArticlesView.loadUrl(this.d);
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.e, this.h.getEvents(), "jsInterface.events\n     …lersFactory.mainThread())"), new b(this)));
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = helpCenterArticlesView.getStateChangeEvents().observeOn(this.e.mainThread()).subscribe(new c(helpCenterArticlesView), a.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.stateChangeEvents\n …         {}\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.a;
        Disposable subscribe2 = helpCenterArticlesView.getNavigationClick().observeOn(this.e.mainThread()).subscribe(new d(this), a.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.navigationClick\n   …ter?.leaveScreen() }, {})");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesPresenter
    public void detachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesPresenter
    public void detachView() {
        HelpCenterArticlesView helpCenterArticlesView = this.b;
        if (helpCenterArticlesView != null) {
            helpCenterArticlesView.removeJavascriptInterface("android");
        }
        HelpCenterArticlesView helpCenterArticlesView2 = this.b;
        if (helpCenterArticlesView2 != null) {
            helpCenterArticlesView2.removeInterceptor(this.j);
        }
        this.b = null;
        this.a.clear();
    }

    @Override // com.avito.android.help_center.HelpCenterUrlInterceptor.CallBack
    public void doesNotSupportUrl(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        HelpCenterArticlesPresenter.Router router = this.c;
        if (router != null) {
            router.openUriViewIntent(uri);
        }
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesPresenter
    public boolean handleBack() {
        HelpCenterArticlesView helpCenterArticlesView = this.b;
        if (helpCenterArticlesView != null) {
            return helpCenterArticlesView.pageBack();
        }
        return false;
    }
}
