package com.avito.android.help_center.help_center_request;

import a2.g.r.g;
import android.net.Uri;
import android.webkit.CookieManager;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.help_center.HelpCenterJSEvent;
import com.avito.android.help_center.HelpCenterJSInterface;
import com.avito.android.help_center.HelpCenterUrlInterceptor;
import com.avito.android.help_center.HelpCenterUrlProvider;
import com.avito.android.help_center.help_center_request.HelpCenterRequestPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.facebook.share.internal.ShareConstants;
import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B]\b\u0007\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u00109\u001a\u000206\u0012\n\b\u0001\u0010:\u001a\u0004\u0018\u00010\"\u0012\n\b\u0001\u0010;\u001a\u0004\u0018\u00010\"\u0012\n\b\u0001\u0010<\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b=\u0010>J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006?"}, d2 = {"Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenterImpl;", "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenter;", "Lcom/avito/android/help_center/HelpCenterUrlInterceptor$CallBack;", "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestView;", "view", "", "attachView", "(Lcom/avito/android/help_center/help_center_request/HelpCenterRequestView;)V", "detachView", "()V", "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenter$Router;)V", "detachRouter", "", "handleBack", "()Z", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "doesNotSupportUrl", "(Landroid/net/Uri;)V", AuthSource.SEND_ABUSE, "c", "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenter$Router;", "Lcom/avito/android/help_center/HelpCenterUrlProvider;", "i", "Lcom/avito/android/help_center/HelpCenterUrlProvider;", "helpCenterUrlProvider", AuthSource.BOOKING_ORDER, "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestView;", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "", "d", "Ljava/lang/String;", "currentUrl", "Landroid/webkit/CookieManager;", "f", "Landroid/webkit/CookieManager;", "cookieManager", "Lcom/avito/android/help_center/HelpCenterJSInterface;", "h", "Lcom/avito/android/help_center/HelpCenterJSInterface;", "jsInterface", "Lcom/avito/android/cookie_provider/CookieProvider;", g.a, "Lcom/avito/android/cookie_provider/CookieProvider;", "cookieProvider", "Lcom/avito/android/util/SchedulersFactory;", "e", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/help_center/HelpCenterUrlInterceptor;", "j", "Lcom/avito/android/help_center/HelpCenterUrlInterceptor;", "urlInterceptor", "theme", "advertisementId", "contextId", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Landroid/webkit/CookieManager;Lcom/avito/android/cookie_provider/CookieProvider;Lcom/avito/android/help_center/HelpCenterJSInterface;Lcom/avito/android/help_center/HelpCenterUrlProvider;Lcom/avito/android/help_center/HelpCenterUrlInterceptor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "help-center_release"}, k = 1, mv = {1, 4, 2})
public final class HelpCenterRequestPresenterImpl implements HelpCenterRequestPresenter, HelpCenterUrlInterceptor.CallBack {
    public final CompositeDisposable a = new CompositeDisposable();
    public HelpCenterRequestView b;
    public HelpCenterRequestPresenter.Router c;
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

    public static final class a extends Lambda implements Function1<HelpCenterJSEvent, Unit> {
        public final /* synthetic */ HelpCenterRequestPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(HelpCenterRequestPresenterImpl helpCenterRequestPresenterImpl) {
            super(1);
            this.a = helpCenterRequestPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(HelpCenterJSEvent helpCenterJSEvent) {
            HelpCenterJSEvent helpCenterJSEvent2 = helpCenterJSEvent;
            if (helpCenterJSEvent2 instanceof HelpCenterJSEvent.UpdateCookie) {
                this.a.a();
            } else if (helpCenterJSEvent2 instanceof HelpCenterJSEvent.SendHelpRequest) {
                HelpCenterRequestPresenterImpl.access$handleSendHelpRequest(this.a);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<PowerWebViewStateChangeEvent, Unit> {
        public final /* synthetic */ HelpCenterRequestView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(HelpCenterRequestView helpCenterRequestView) {
            super(1);
            this.a = helpCenterRequestView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(PowerWebViewStateChangeEvent powerWebViewStateChangeEvent) {
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
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ HelpCenterRequestPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(HelpCenterRequestPresenterImpl helpCenterRequestPresenterImpl) {
            super(1);
            this.a = helpCenterRequestPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Unit unit) {
            HelpCenterRequestPresenter.Router router = this.a.c;
            if (router != null) {
                router.closeActivity();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0073, code lost:
        if ((r10 == null || t6.y.m.isBlank(r10)) == false) goto L_0x0075;
     */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HelpCenterRequestPresenterImpl(@org.jetbrains.annotations.NotNull com.avito.android.util.SchedulersFactory r2, @org.jetbrains.annotations.NotNull android.webkit.CookieManager r3, @org.jetbrains.annotations.NotNull com.avito.android.cookie_provider.CookieProvider r4, @org.jetbrains.annotations.NotNull com.avito.android.help_center.HelpCenterJSInterface r5, @org.jetbrains.annotations.NotNull com.avito.android.help_center.HelpCenterUrlProvider r6, @org.jetbrains.annotations.NotNull com.avito.android.help_center.HelpCenterUrlInterceptor r7, @com.avito.android.help_center.help_center_request.di.Theme @org.jetbrains.annotations.Nullable java.lang.String r8, @com.avito.android.help_center.help_center_request.di.AdvertisementId @org.jetbrains.annotations.Nullable java.lang.String r9, @com.avito.android.help_center.help_center_request.di.ContextId @org.jetbrains.annotations.Nullable java.lang.String r10) {
        /*
            r1 = this;
            java.lang.String r0 = "schedulersFactory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "cookieManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "cookieProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "jsInterface"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "helpCenterUrlProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "urlInterceptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r1.<init>()
            r1.e = r2
            r1.f = r3
            r1.g = r4
            r1.h = r5
            r1.i = r6
            r1.j = r7
            io.reactivex.disposables.CompositeDisposable r2 = new io.reactivex.disposables.CompositeDisposable
            r2.<init>()
            r1.a = r2
            android.net.Uri r2 = r6.getUrl()
            r3 = 0
            if (r2 == 0) goto L_0x0048
            android.net.Uri$Builder r2 = r2.buildUpon()
            if (r2 == 0) goto L_0x0048
            java.lang.String r4 = "request"
            android.net.Uri$Builder r2 = r2.path(r4)
            goto L_0x0049
        L_0x0048:
            r2 = r3
        L_0x0049:
            r4 = 1
            r5 = 0
            if (r8 == 0) goto L_0x0056
            boolean r6 = t6.y.m.isBlank(r8)
            if (r6 == 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r6 = 0
            goto L_0x0057
        L_0x0056:
            r6 = 1
        L_0x0057:
            if (r6 == 0) goto L_0x0075
            if (r9 == 0) goto L_0x0064
            boolean r6 = t6.y.m.isBlank(r9)
            if (r6 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r6 = 0
            goto L_0x0065
        L_0x0064:
            r6 = 1
        L_0x0065:
            if (r6 == 0) goto L_0x0075
            if (r10 == 0) goto L_0x0072
            boolean r6 = t6.y.m.isBlank(r10)
            if (r6 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r6 = 0
            goto L_0x0073
        L_0x0072:
            r6 = 1
        L_0x0073:
            if (r6 != 0) goto L_0x00bb
        L_0x0075:
            if (r2 == 0) goto L_0x007e
            java.lang.String r6 = "appId"
            java.lang.String r7 = "3"
            r2.appendQueryParameter(r6, r7)
        L_0x007e:
            if (r8 == 0) goto L_0x0089
            boolean r6 = t6.y.m.isBlank(r8)
            if (r6 == 0) goto L_0x0087
            goto L_0x0089
        L_0x0087:
            r6 = 0
            goto L_0x008a
        L_0x0089:
            r6 = 1
        L_0x008a:
            if (r6 != 0) goto L_0x0093
            if (r2 == 0) goto L_0x0093
            java.lang.String r6 = "theme"
            r2.appendQueryParameter(r6, r8)
        L_0x0093:
            if (r9 == 0) goto L_0x009e
            boolean r6 = t6.y.m.isBlank(r9)
            if (r6 == 0) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r6 = 0
            goto L_0x009f
        L_0x009e:
            r6 = 1
        L_0x009f:
            if (r6 != 0) goto L_0x00a8
            if (r2 == 0) goto L_0x00a8
            java.lang.String r6 = "problemInfo[itemId]"
            r2.appendQueryParameter(r6, r9)
        L_0x00a8:
            if (r10 == 0) goto L_0x00b2
            boolean r6 = t6.y.m.isBlank(r10)
            if (r6 == 0) goto L_0x00b1
            goto L_0x00b2
        L_0x00b1:
            r4 = 0
        L_0x00b2:
            if (r4 != 0) goto L_0x00bb
            if (r2 == 0) goto L_0x00bb
            java.lang.String r4 = "eventData[contextId]"
            r2.appendQueryParameter(r4, r10)
        L_0x00bb:
            if (r2 == 0) goto L_0x00c1
            android.net.Uri r3 = r2.build()
        L_0x00c1:
            java.lang.String r2 = java.lang.String.valueOf(r3)
            java.lang.String r2 = android.net.Uri.decode(r2)
            java.lang.String r3 = "Uri.decode(requestBuilder?.build().toString())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r1.d = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.help_center.help_center_request.HelpCenterRequestPresenterImpl.<init>(com.avito.android.util.SchedulersFactory, android.webkit.CookieManager, com.avito.android.cookie_provider.CookieProvider, com.avito.android.help_center.HelpCenterJSInterface, com.avito.android.help_center.HelpCenterUrlProvider, com.avito.android.help_center.HelpCenterUrlInterceptor, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static final void access$handleSendHelpRequest(HelpCenterRequestPresenterImpl helpCenterRequestPresenterImpl) {
        HelpCenterRequestView helpCenterRequestView = helpCenterRequestPresenterImpl.b;
        if (helpCenterRequestView != null) {
            helpCenterRequestView.hideScreen();
        }
        HelpCenterRequestView helpCenterRequestView2 = helpCenterRequestPresenterImpl.b;
        if (helpCenterRequestView2 != null) {
            helpCenterRequestView2.showResultMessage();
        }
        HelpCenterRequestPresenter.Router router = helpCenterRequestPresenterImpl.c;
        if (router != null) {
            router.closeActivity();
        }
    }

    public final void a() {
        CookieManager cookieManager = this.f;
        cookieManager.setAcceptCookie(true);
        Iterator<T> it = this.g.getCookies().iterator();
        while (it.hasNext()) {
            cookieManager.setCookie(".avito.ru", it.next());
        }
    }

    @Override // com.avito.android.help_center.help_center_request.HelpCenterRequestPresenter
    public void attachRouter(@NotNull HelpCenterRequestPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.c = router;
    }

    @Override // com.avito.android.help_center.help_center_request.HelpCenterRequestPresenter
    public void attachView(@NotNull HelpCenterRequestView helpCenterRequestView) {
        Intrinsics.checkNotNullParameter(helpCenterRequestView, "view");
        this.b = helpCenterRequestView;
        this.j.setCallBack(this);
        helpCenterRequestView.addJavascriptInterface(this.h, "android");
        helpCenterRequestView.addInterceptor(this.j);
        a();
        helpCenterRequestView.loadUrl(this.d);
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.e, this.h.getEvents(), "jsInterface.events\n     …lersFactory.mainThread())"), new a(this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.e, helpCenterRequestView.getStateChangeEvents(), "view.stateChangeEvents\n …lersFactory.mainThread())"), new b(helpCenterRequestView)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.e, helpCenterRequestView.getNavigationClick(), "view.navigationClick\n   …lersFactory.mainThread())"), new c(this)));
    }

    @Override // com.avito.android.help_center.help_center_request.HelpCenterRequestPresenter
    public void detachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.help_center.help_center_request.HelpCenterRequestPresenter
    public void detachView() {
        HelpCenterRequestView helpCenterRequestView = this.b;
        if (helpCenterRequestView != null) {
            helpCenterRequestView.removeJavascriptInterface("android");
        }
        HelpCenterRequestView helpCenterRequestView2 = this.b;
        if (helpCenterRequestView2 != null) {
            helpCenterRequestView2.removeInterceptor(this.j);
        }
        this.b = null;
        this.a.clear();
    }

    @Override // com.avito.android.help_center.HelpCenterUrlInterceptor.CallBack
    public void doesNotSupportUrl(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        HelpCenterRequestPresenter.Router router = this.c;
        if (router != null) {
            router.openUriViewIntent(uri);
        }
    }

    @Override // com.avito.android.help_center.help_center_request.HelpCenterRequestPresenter
    public boolean handleBack() {
        HelpCenterRequestView helpCenterRequestView = this.b;
        if (helpCenterRequestView != null) {
            return helpCenterRequestView.pageBack();
        }
        return false;
    }
}
