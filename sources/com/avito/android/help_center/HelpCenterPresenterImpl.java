package com.avito.android.help_center;

import a2.g.r.g;
import android.net.Uri;
import android.webkit.CookieManager;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.help_center.HelpCenterJSEvent;
import com.avito.android.help_center.HelpCenterPresenter;
import com.avito.android.help_center.HelpCenterUrlInterceptor;
import com.avito.android.help_center.di.Url;
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
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.Shared;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002BO\b\u0007\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0001\u0010=\u001a\u0004\u0018\u000101\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b?\u0010@J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u00103¨\u0006A"}, d2 = {"Lcom/avito/android/help_center/HelpCenterPresenterImpl;", "Lcom/avito/android/help_center/HelpCenterPresenter;", "Lcom/avito/android/help_center/HelpCenterUrlInterceptor$CallBack;", "Lcom/avito/android/help_center/HelpCenterView;", "view", "", "attachView", "(Lcom/avito/android/help_center/HelpCenterView;)V", "detachView", "()V", "Lcom/avito/android/help_center/HelpCenterPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/help_center/HelpCenterPresenter$Router;)V", "detachRouter", "", "handleBack", "()Z", "Lcom/avito/android/help_center/HelpCenterPresenterState;", "onSaveState", "()Lcom/avito/android/help_center/HelpCenterPresenterState;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "doesNotSupportUrl", "(Landroid/net/Uri;)V", "c", "Lcom/avito/android/help_center/HelpCenterPresenter$Router;", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposable", "Landroid/webkit/CookieManager;", g.a, "Landroid/webkit/CookieManager;", "cookieManager", "Lcom/avito/android/help_center/HelpCenterJSInterface;", "i", "Lcom/avito/android/help_center/HelpCenterJSInterface;", "jsInterface", AuthSource.BOOKING_ORDER, "Lcom/avito/android/help_center/HelpCenterView;", "Lcom/avito/android/cookie_provider/CookieProvider;", "h", "Lcom/avito/android/cookie_provider/CookieProvider;", "cookieProvider", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "", "d", "Ljava/lang/String;", "homeUrl", "Lcom/avito/android/help_center/HelpCenterUrlInterceptor;", "j", "Lcom/avito/android/help_center/HelpCenterUrlInterceptor;", "urlInterceptor", "e", "currentUrl", "Lcom/avito/android/help_center/HelpCenterUrlProvider;", "helpCenterUrlProvider", "url", "state", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Landroid/webkit/CookieManager;Lcom/avito/android/cookie_provider/CookieProvider;Lcom/avito/android/help_center/HelpCenterJSInterface;Lcom/avito/android/help_center/HelpCenterUrlInterceptor;Lcom/avito/android/help_center/HelpCenterUrlProvider;Ljava/lang/String;Lcom/avito/android/help_center/HelpCenterPresenterState;)V", "help-center_release"}, k = 1, mv = {1, 4, 2})
public final class HelpCenterPresenterImpl implements HelpCenterPresenter, HelpCenterUrlInterceptor.CallBack {
    public final CompositeDisposable a = new CompositeDisposable();
    public HelpCenterView b;
    public HelpCenterPresenter.Router c;
    public final String d;
    public String e;
    public final SchedulersFactory f;
    public final CookieManager g;
    public final CookieProvider h;
    public final HelpCenterJSInterface i;
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

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                HelpCenterView helpCenterView = ((HelpCenterPresenterImpl) this.b).b;
                if (helpCenterView != null) {
                    helpCenterView.loadUrl(((HelpCenterPresenterImpl) this.b).d);
                }
            } else if (i == 1) {
                HelpCenterPresenter.Router router = ((HelpCenterPresenterImpl) this.b).c;
                if (router != null) {
                    router.closeActivity();
                }
            } else {
                throw null;
            }
        }
    }

    public static final class c extends Lambda implements Function1<HelpCenterJSEvent, Unit> {
        public final /* synthetic */ HelpCenterPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(HelpCenterPresenterImpl helpCenterPresenterImpl) {
            super(1);
            this.a = helpCenterPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(HelpCenterJSEvent helpCenterJSEvent) {
            HelpCenterJSEvent helpCenterJSEvent2 = helpCenterJSEvent;
            if (helpCenterJSEvent2 instanceof HelpCenterJSEvent.UpdateUrl) {
                HelpCenterPresenterImpl.access$urlUpdated(this.a, ((HelpCenterJSEvent.UpdateUrl) helpCenterJSEvent2).getUrl());
            } else if (helpCenterJSEvent2 instanceof HelpCenterJSEvent.UpdateCookie) {
                HelpCenterPresenterImpl.access$updateCookies(this.a);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<PowerWebViewStateChangeEvent, Unit> {
        public final /* synthetic */ HelpCenterPresenterImpl a;
        public final /* synthetic */ HelpCenterView b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(HelpCenterPresenterImpl helpCenterPresenterImpl, HelpCenterView helpCenterView) {
            super(1);
            this.a = helpCenterPresenterImpl;
            this.b = helpCenterView;
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
                    HelpCenterPresenterImpl helpCenterPresenterImpl = this.a;
                    String url2 = powerWebViewStateChangeEvent2.getUrl();
                    Intrinsics.checkNotNull(url2);
                    HelpCenterPresenterImpl.access$urlUpdated(helpCenterPresenterImpl, url2);
                    this.b.startLoad();
                }
            } else if (ordinal == 1) {
                this.b.showData();
            } else if (ordinal == 3) {
                this.b.showError();
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public HelpCenterPresenterImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull CookieManager cookieManager, @NotNull CookieProvider cookieProvider, @NotNull HelpCenterJSInterface helpCenterJSInterface, @NotNull HelpCenterUrlInterceptor helpCenterUrlInterceptor, @NotNull HelpCenterUrlProvider helpCenterUrlProvider, @Url @Nullable String str, @Nullable HelpCenterPresenterState helpCenterPresenterState) {
        String url;
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(cookieManager, "cookieManager");
        Intrinsics.checkNotNullParameter(cookieProvider, "cookieProvider");
        Intrinsics.checkNotNullParameter(helpCenterJSInterface, "jsInterface");
        Intrinsics.checkNotNullParameter(helpCenterUrlInterceptor, "urlInterceptor");
        Intrinsics.checkNotNullParameter(helpCenterUrlProvider, "helpCenterUrlProvider");
        this.f = schedulersFactory;
        this.g = cookieManager;
        this.h = cookieProvider;
        this.i = helpCenterJSInterface;
        this.j = helpCenterUrlInterceptor;
        String valueOf = String.valueOf(helpCenterUrlProvider.getUrl());
        if (str != null) {
            if (m.endsWith$default(valueOf, "/", false, 2, null)) {
                valueOf = a2.b.a.a.a.c3(valueOf, str);
            } else {
                valueOf = a2.b.a.a.a.e3(valueOf, "/", str);
            }
        }
        String uri = Uri.parse(valueOf).buildUpon().appendQueryParameter(Shared.PARAM_APP_ID, ExifInterface.GPS_MEASUREMENT_3D).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "Uri\n            .parse(l…)\n            .toString()");
        this.d = uri;
        if (!(helpCenterPresenterState == null || (url = helpCenterPresenterState.getUrl()) == null)) {
            uri = url;
        }
        this.e = uri;
    }

    public static final void access$updateCookies(HelpCenterPresenterImpl helpCenterPresenterImpl) {
        CookieManager cookieManager = helpCenterPresenterImpl.g;
        cookieManager.setAcceptCookie(true);
        Iterator<T> it = helpCenterPresenterImpl.h.getCookies().iterator();
        while (it.hasNext()) {
            cookieManager.setCookie(".avito.ru", it.next());
        }
    }

    public static final void access$urlUpdated(HelpCenterPresenterImpl helpCenterPresenterImpl, String str) {
        helpCenterPresenterImpl.e = str;
        HelpCenterView helpCenterView = helpCenterPresenterImpl.b;
        if (helpCenterView != null) {
            helpCenterView.setMenuHomeButtonVisible(!Intrinsics.areEqual(str, helpCenterPresenterImpl.d));
        }
    }

    @Override // com.avito.android.help_center.HelpCenterPresenter
    public void attachRouter(@NotNull HelpCenterPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.c = router;
    }

    @Override // com.avito.android.help_center.HelpCenterPresenter
    public void attachView(@NotNull HelpCenterView helpCenterView) {
        Intrinsics.checkNotNullParameter(helpCenterView, "view");
        this.b = helpCenterView;
        this.j.setCallBack(this);
        helpCenterView.addJavascriptInterface(this.i, "android");
        helpCenterView.addInterceptor(this.j);
        helpCenterView.loadUrl(this.e);
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.f, this.i.getEvents(), "jsInterface.events\n     …lersFactory.mainThread())"), new c(this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.f, helpCenterView.getStateChangeEvents(), "view.stateChangeEvents\n …lersFactory.mainThread())"), new d(this, helpCenterView)));
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = helpCenterView.getHomeClick().subscribe(new b(0, this), a.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.homeClick.subscribe…?.loadUrl(homeUrl) }, {})");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.a;
        Disposable subscribe2 = helpCenterView.getNavigationClick().subscribe(new b(1, this), a.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.navigationClick.sub…r?.closeActivity() }, {})");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    @Override // com.avito.android.help_center.HelpCenterPresenter
    public void detachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.help_center.HelpCenterPresenter
    public void detachView() {
        HelpCenterView helpCenterView = this.b;
        if (helpCenterView != null) {
            helpCenterView.removeJavascriptInterface("android");
        }
        HelpCenterView helpCenterView2 = this.b;
        if (helpCenterView2 != null) {
            helpCenterView2.removeInterceptor(this.j);
        }
        this.b = null;
        this.a.clear();
    }

    @Override // com.avito.android.help_center.HelpCenterUrlInterceptor.CallBack
    public void doesNotSupportUrl(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        HelpCenterPresenter.Router router = this.c;
        if (router != null) {
            router.openUriViewIntent(uri);
        }
    }

    @Override // com.avito.android.help_center.HelpCenterPresenter
    public boolean handleBack() {
        HelpCenterView helpCenterView = this.b;
        if (helpCenterView != null) {
            return helpCenterView.pageBack();
        }
        return false;
    }

    @Override // com.avito.android.help_center.HelpCenterPresenter
    @NotNull
    public HelpCenterPresenterState onSaveState() {
        return new HelpCenterPresenterState(this.e);
    }
}
