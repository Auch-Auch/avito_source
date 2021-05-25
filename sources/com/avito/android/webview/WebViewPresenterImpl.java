package com.avito.android.webview;

import a2.g.r.g;
import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.CookieManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.avito.android.CalledFrom;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeepLinkKt;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.webview.WebViewPresenter;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractor;
import com.facebook.common.util.UriUtil;
import com.facebook.share.internal.ShareConstants;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0001\u0010!\u001a\u00020\t\u0012\b\b\u0001\u0010#\u001a\u00020\t\u0012\b\u0010)\u001a\u0004\u0018\u00010&\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00106\u001a\u000203¢\u0006\u0004\b7\u00108J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/avito/android/webview/WebViewPresenterImpl;", "Lcom/avito/android/webview/WebViewPresenter;", "Lcom/avito/android/webview/WebViewView;", "view", "", "onAttachView", "(Lcom/avito/android/webview/WebViewView;)V", "onRefresh", "()V", "", "isFullScreen", "()Z", "onDetachView", "Lcom/avito/android/webview/WebViewPresenter$Router;", "router", "onAttachRouter", "(Lcom/avito/android/webview/WebViewPresenter$Router;)V", "onDetachRouter", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "onNewUri", "(Landroid/net/Uri;)V", "onBackPressed", "onCloseClicked", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "Lcom/avito/android/webview/WebViewPresenter$Router;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "c", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "e", "Z", "fullScreen", "f", "withAuthorization", "d", "Landroid/net/Uri;", "Lcom/avito/android/CalledFrom;", g.a, "Lcom/avito/android/CalledFrom;", "calledFrom", "Lcom/avito/android/cookie_provider/CookieProvider;", "i", "Lcom/avito/android/cookie_provider/CookieProvider;", "cookieProvider", "Lcom/avito/android/webview/WebViewView;", "Landroid/webkit/CookieManager;", "h", "Landroid/webkit/CookieManager;", "cookieManager", "Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;", "j", "Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;", "analyticsInteractor", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkFactory;Landroid/net/Uri;ZZLcom/avito/android/CalledFrom;Landroid/webkit/CookieManager;Lcom/avito/android/cookie_provider/CookieProvider;Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;)V", "webview_release"}, k = 1, mv = {1, 4, 2})
public final class WebViewPresenterImpl implements WebViewPresenter {
    public WebViewView a;
    public WebViewPresenter.Router b;
    public final DeepLinkFactory c;
    public Uri d;
    public boolean e;
    public boolean f;
    public final CalledFrom g;
    public final CookieManager h;
    public final CookieProvider i;
    public final WebViewAnalyticsInteractor j;

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WebViewPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(WebViewPresenterImpl webViewPresenterImpl) {
            super(0);
            this.a = webViewPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            WebViewPresenter.Router router = this.a.b;
            if (router != null) {
                router.leaveScreen();
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public WebViewPresenterImpl(@NotNull DeepLinkFactory deepLinkFactory, @NotNull Uri uri, @Named("fullScreen") boolean z, @Named("withAuthorization") boolean z2, @Nullable CalledFrom calledFrom, @NotNull CookieManager cookieManager, @NotNull CookieProvider cookieProvider, @NotNull WebViewAnalyticsInteractor webViewAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(cookieManager, "cookieManager");
        Intrinsics.checkNotNullParameter(cookieProvider, "cookieProvider");
        Intrinsics.checkNotNullParameter(webViewAnalyticsInteractor, "analyticsInteractor");
        this.c = deepLinkFactory;
        this.d = uri;
        this.e = z;
        this.f = z2;
        this.g = calledFrom;
        this.h = cookieManager;
        this.i = cookieProvider;
        this.j = webViewAnalyticsInteractor;
    }

    public static final void access$onScrolled(WebViewPresenterImpl webViewPresenterImpl, String str) {
        WebViewView webViewView = webViewPresenterImpl.a;
        if (webViewView != null && !webViewView.canScrollDown()) {
            WebViewAnalyticsInteractor webViewAnalyticsInteractor = webViewPresenterImpl.j;
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
            webViewAnalyticsInteractor.trackPageScrolledToEnd(parse);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final boolean access$openLink(WebViewPresenterImpl webViewPresenterImpl, Uri uri) {
        WebViewPresenter.Router router = webViewPresenterImpl.b;
        if (router == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (scheme != null) {
            switch (scheme.hashCode()) {
                case -1014226716:
                    if (scheme.equals(DeepLinkKt.DEEPLINK_URI_SCHEME)) {
                        DeepLink createFromUri = webViewPresenterImpl.c.createFromUri(uri);
                        if (!(createFromUri instanceof NoMatchLink)) {
                            webViewPresenterImpl.j.trackLinkClicked(webViewPresenterImpl.g);
                            router.openDeepLink(createFromUri);
                            if (!webViewPresenterImpl.e) {
                                router.leaveScreen();
                                break;
                            }
                        } else {
                            return false;
                        }
                    }
                    break;
                case 114715:
                    if (scheme.equals("tel")) {
                        String uri2 = uri.toString();
                        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
                        router.openDeepLink(new PhoneLink.Call(StringsKt__StringsKt.substringAfter$default(uri2, "tel:", (String) null, 2, (Object) null), null, 2, null));
                        break;
                    }
                    break;
                case 3213448:
                    if (scheme.equals(UriUtil.HTTP_SCHEME)) {
                        return false;
                    }
                    break;
                case 99617003:
                    if (scheme.equals("https")) {
                        return false;
                    }
                    break;
            }
            return true;
        }
        router.openUrl(uri);
        return true;
    }

    public final void a() {
        WebViewView webViewView = this.a;
        if (webViewView != null) {
            webViewView.showLoading();
        }
        WebViewView webViewView2 = this.a;
        if (webViewView2 != null) {
            String uri = this.d.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "uri.toString()");
            webViewView2.loadContent(uri, new WebViewClient(this) { // from class: com.avito.android.webview.WebViewPresenterImpl$startLoading$1
                public boolean a;
                public boolean b;
                public final /* synthetic */ WebViewPresenterImpl c;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.c = r1;
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(@NotNull WebView webView, @NotNull String str) {
                    Intrinsics.checkNotNullParameter(webView, "webView");
                    Intrinsics.checkNotNullParameter(str, "url");
                    if (!this.a) {
                        this.a = false;
                        this.b = true;
                        WebViewView webViewView3 = this.c.a;
                        if (webViewView3 != null) {
                            webViewView3.showContent();
                        }
                        this.c.j.trackPageOpened(this.c.d);
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(@NotNull WebView webView, int i2, @NotNull String str, @NotNull String str2) {
                    Intrinsics.checkNotNullParameter(webView, "webView");
                    Intrinsics.checkNotNullParameter(str, "description");
                    Intrinsics.checkNotNullParameter(str2, "failingUrl");
                    if (Intrinsics.areEqual(str2, this.c.d.toString())) {
                        this.a = true;
                        WebViewView webViewView3 = this.c.a;
                        if (webViewView3 != null) {
                            webViewView3.showLoadingProblem();
                        }
                    }
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String str) {
                    Intrinsics.checkNotNullParameter(webView, "view");
                    Intrinsics.checkNotNullParameter(str, "url");
                    if (!this.b) {
                        return false;
                    }
                    WebViewPresenterImpl webViewPresenterImpl = this.c;
                    Uri parse = Uri.parse(str);
                    Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
                    return WebViewPresenterImpl.access$openLink(webViewPresenterImpl, parse);
                }

                @Override // android.webkit.WebViewClient
                @TargetApi(24)
                public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull WebResourceRequest webResourceRequest) {
                    Intrinsics.checkNotNullParameter(webView, "view");
                    Intrinsics.checkNotNullParameter(webResourceRequest, "request");
                    if (!this.b) {
                        return false;
                    }
                    WebViewPresenterImpl webViewPresenterImpl = this.c;
                    Uri url = webResourceRequest.getUrl();
                    Intrinsics.checkNotNullExpressionValue(url, "request.url");
                    return WebViewPresenterImpl.access$openLink(webViewPresenterImpl, url);
                }

                @Override // android.webkit.WebViewClient
                @TargetApi(23)
                public void onReceivedError(@NotNull WebView webView, @NotNull WebResourceRequest webResourceRequest, @NotNull WebResourceError webResourceError) {
                    Intrinsics.checkNotNullParameter(webView, "webView");
                    Intrinsics.checkNotNullParameter(webResourceRequest, "req");
                    Intrinsics.checkNotNullParameter(webResourceError, "error");
                    if (Intrinsics.areEqual(webResourceRequest.getUrl(), this.c.d)) {
                        this.a = true;
                        WebViewView webViewView3 = this.c.a;
                        if (webViewView3 != null) {
                            webViewView3.showLoadingProblem();
                        }
                    }
                }
            }, new WebAppInterface(this.j, new b(this)));
        }
    }

    @Override // com.avito.android.webview.WebViewView.Presenter
    public boolean isFullScreen() {
        return this.e;
    }

    @Override // com.avito.android.webview.WebViewPresenter
    public void onAttachRouter(@NotNull WebViewPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.webview.WebViewPresenter
    public void onAttachView(@NotNull WebViewView webViewView) {
        Intrinsics.checkNotNullParameter(webViewView, "view");
        this.a = webViewView;
        webViewView.setOnScrollListener(new Function1<String, Unit>(this) { // from class: com.avito.android.webview.WebViewPresenterImpl.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(String str) {
                String str2 = str;
                Intrinsics.checkNotNullParameter(str2, "p1");
                WebViewPresenterImpl.access$onScrolled((WebViewPresenterImpl) this.receiver, str2);
                return Unit.INSTANCE;
            }
        });
        a();
        if (this.f) {
            CookieManager cookieManager = this.h;
            cookieManager.setAcceptCookie(true);
            Iterator<T> it = this.i.getCookies().iterator();
            while (it.hasNext()) {
                cookieManager.setCookie(".avito.ru", it.next());
            }
        }
    }

    @Override // com.avito.android.webview.WebViewPresenter
    public void onBackPressed() {
        WebViewView webViewView = this.a;
        if (webViewView != null ? webViewView.canGoBack() : false) {
            WebViewView webViewView2 = this.a;
            if (webViewView2 != null) {
                webViewView2.goBack();
                return;
            }
            return;
        }
        WebViewPresenter.Router router = this.b;
        if (router != null) {
            router.leaveScreen();
        }
    }

    @Override // com.avito.android.webview.WebViewView.Presenter
    public void onCloseClicked() {
        WebViewPresenter.Router router = this.b;
        if (router != null) {
            router.leaveScreen();
        }
    }

    @Override // com.avito.android.webview.WebViewPresenter
    public void onDetachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.webview.WebViewPresenter
    public void onDetachView() {
        if (this.f) {
            this.h.removeAllCookies(null);
        }
        WebViewView webViewView = this.a;
        if (webViewView != null) {
            webViewView.setOnScrollListener(null);
        }
        this.a = null;
    }

    @Override // com.avito.android.webview.WebViewPresenter
    public void onNewUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        this.d = uri;
        onRefresh();
    }

    @Override // com.avito.android.webview.WebViewView.Presenter
    public void onRefresh() {
        a();
    }
}
