package com.avito.android.webview.di;

import android.webkit.CookieManager;
import com.avito.android.cookie_provider.CookieExpiredTime;
import com.avito.android.cookie_provider.CookieExpiredTimeImpl;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.cookie_provider.CookieProviderImpl;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.interceptor.SessionCookieProvider;
import com.avito.android.webview.WebViewPresenter;
import com.avito.android.webview.WebViewPresenterImpl;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractor;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/webview/di/WebViewModule;", "", "Landroid/webkit/CookieManager;", "provideCookieManager$webview_release", "()Landroid/webkit/CookieManager;", "provideCookieManager", "Lcom/avito/android/remote/interceptor/SessionCookieProvider;", "sessionCookieProvider", "Lcom/avito/android/cookie_provider/CookieExpiredTime;", "cookieExpiredTime", "Lcom/avito/android/cookie_provider/CookieProvider;", "provideCookieProvider$webview_release", "(Lcom/avito/android/remote/interceptor/SessionCookieProvider;Lcom/avito/android/cookie_provider/CookieExpiredTime;)Lcom/avito/android/cookie_provider/CookieProvider;", "provideCookieProvider", "<init>", "()V", "Declarations", "webview_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class WebViewModule {
    @NotNull
    public static final WebViewModule INSTANCE = new WebViewModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/webview/di/WebViewModule$Declarations;", "", "Lcom/avito/android/webview/WebViewPresenterImpl;", "presenter", "Lcom/avito/android/webview/WebViewPresenter;", "bindWebViewPresenter", "(Lcom/avito/android/webview/WebViewPresenterImpl;)Lcom/avito/android/webview/WebViewPresenter;", "Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractorImpl;", "analytics", "Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;", "bindWebViewAnalyticsInteractor", "(Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractorImpl;)Lcom/avito/android/webview/analytics/WebViewAnalyticsInteractor;", "Lcom/avito/android/cookie_provider/CookieExpiredTimeImpl;", "time", "Lcom/avito/android/cookie_provider/CookieExpiredTime;", "bindCookieExpiredTime", "(Lcom/avito/android/cookie_provider/CookieExpiredTimeImpl;)Lcom/avito/android/cookie_provider/CookieExpiredTime;", "webview_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        CookieExpiredTime bindCookieExpiredTime(@NotNull CookieExpiredTimeImpl cookieExpiredTimeImpl);

        @PerActivity
        @Binds
        @NotNull
        WebViewAnalyticsInteractor bindWebViewAnalyticsInteractor(@NotNull WebViewAnalyticsInteractorImpl webViewAnalyticsInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        WebViewPresenter bindWebViewPresenter(@NotNull WebViewPresenterImpl webViewPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final CookieManager provideCookieManager$webview_release() {
        CookieManager instance = CookieManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "CookieManager.getInstance()");
        return instance;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final CookieProvider provideCookieProvider$webview_release(@NotNull SessionCookieProvider sessionCookieProvider, @NotNull CookieExpiredTime cookieExpiredTime) {
        Intrinsics.checkNotNullParameter(sessionCookieProvider, "sessionCookieProvider");
        Intrinsics.checkNotNullParameter(cookieExpiredTime, "cookieExpiredTime");
        return new CookieProviderImpl(d.listOf(sessionCookieProvider), cookieExpiredTime);
    }
}
