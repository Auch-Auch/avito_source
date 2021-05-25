package com.avito.android.imv.di;

import android.net.Uri;
import android.webkit.CookieManager;
import com.avito.android.CalledFrom;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.cookie_provider.CookieExpiredTime;
import com.avito.android.cookie_provider.CookieExpiredTimeImpl;
import com.avito.android.cookie_provider.CookieExpiredTimeImpl_Factory;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.imv.ImvWebViewBottomSheetActivity;
import com.avito.android.imv.ImvWebViewBottomSheetActivity_MembersInjector;
import com.avito.android.imv.di.ImvWebViewBottomSheetComponent;
import com.avito.android.remote.interceptor.SessionCookieProvider;
import com.avito.android.remote.interceptor.SessionCookieProvider_Factory;
import com.avito.android.server_time.ServerTimeSource;
import com.avito.android.webview.WebViewPresenter;
import com.avito.android.webview.WebViewPresenterImpl;
import com.avito.android.webview.WebViewPresenterImpl_Factory;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractor;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorImpl;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorImpl_Factory;
import com.avito.android.webview.di.WebViewDependencies;
import com.avito.android.webview.di.WebViewModule_ProvideCookieManager$webview_releaseFactory;
import com.avito.android.webview.di.WebViewModule_ProvideCookieProvider$webview_releaseFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerImvWebViewBottomSheetComponent implements ImvWebViewBottomSheetComponent {
    public final WebViewDependencies a;
    public Provider<DeepLinkFactory> b;
    public Provider<Uri> c;
    public Provider<Boolean> d;
    public Provider<Boolean> e;
    public Provider<CalledFrom> f;
    public Provider<CookieManager> g = DoubleCheck.provider(WebViewModule_ProvideCookieManager$webview_releaseFactory.create());
    public Provider<AccountStorageInteractor> h;
    public Provider<SessionCookieProvider> i;
    public Provider<ServerTimeSource> j;
    public Provider<CookieExpiredTimeImpl> k;
    public Provider<CookieExpiredTime> l;
    public Provider<CookieProvider> m;
    public Provider<Analytics> n;
    public Provider<WebViewAnalyticsInteractorImpl> o;
    public Provider<WebViewAnalyticsInteractor> p;
    public Provider<WebViewPresenterImpl> q;
    public Provider<WebViewPresenter> r;

    public static final class b implements ImvWebViewBottomSheetComponent.Builder {
        public WebViewDependencies a;
        public Uri b;
        public Boolean c;
        public Boolean d;
        public CalledFrom e;

        public b(a aVar) {
        }

        @Override // com.avito.android.imv.di.ImvWebViewBottomSheetComponent.Builder
        public ImvWebViewBottomSheetComponent build() {
            Preconditions.checkBuilderRequirement(this.a, WebViewDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Uri.class);
            Preconditions.checkBuilderRequirement(this.c, Boolean.class);
            Preconditions.checkBuilderRequirement(this.d, Boolean.class);
            return new DaggerImvWebViewBottomSheetComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.imv.di.ImvWebViewBottomSheetComponent.Builder
        public ImvWebViewBottomSheetComponent.Builder dependencies(WebViewDependencies webViewDependencies) {
            this.a = (WebViewDependencies) Preconditions.checkNotNull(webViewDependencies);
            return this;
        }

        @Override // com.avito.android.imv.di.ImvWebViewBottomSheetComponent.Builder
        public ImvWebViewBottomSheetComponent.Builder withAuthorization(boolean z) {
            this.d = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.imv.di.ImvWebViewBottomSheetComponent.Builder
        public ImvWebViewBottomSheetComponent.Builder withCalledFrom(CalledFrom calledFrom) {
            this.e = null;
            return this;
        }

        @Override // com.avito.android.imv.di.ImvWebViewBottomSheetComponent.Builder
        public ImvWebViewBottomSheetComponent.Builder withFullScreen(boolean z) {
            this.c = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.imv.di.ImvWebViewBottomSheetComponent.Builder
        public ImvWebViewBottomSheetComponent.Builder withUri(Uri uri) {
            this.b = (Uri) Preconditions.checkNotNull(uri);
            return this;
        }
    }

    public static class c implements Provider<AccountStorageInteractor> {
        public final WebViewDependencies a;

        public c(WebViewDependencies webViewDependencies) {
            this.a = webViewDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStorageInteractor get() {
            return (AccountStorageInteractor) Preconditions.checkNotNullFromComponent(this.a.accountStorageInteractor());
        }
    }

    public static class d implements Provider<Analytics> {
        public final WebViewDependencies a;

        public d(WebViewDependencies webViewDependencies) {
            this.a = webViewDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<DeepLinkFactory> {
        public final WebViewDependencies a;

        public e(WebViewDependencies webViewDependencies) {
            this.a = webViewDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class f implements Provider<ServerTimeSource> {
        public final WebViewDependencies a;

        public f(WebViewDependencies webViewDependencies) {
            this.a = webViewDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ServerTimeSource get() {
            return (ServerTimeSource) Preconditions.checkNotNullFromComponent(this.a.serverTimeSource());
        }
    }

    public DaggerImvWebViewBottomSheetComponent(WebViewDependencies webViewDependencies, Uri uri, Boolean bool, Boolean bool2, CalledFrom calledFrom, a aVar) {
        this.a = webViewDependencies;
        this.b = new e(webViewDependencies);
        this.c = InstanceFactory.create(uri);
        this.d = InstanceFactory.create(bool);
        this.e = InstanceFactory.create(bool2);
        this.f = InstanceFactory.createNullable(calledFrom);
        c cVar = new c(webViewDependencies);
        this.h = cVar;
        this.i = SessionCookieProvider_Factory.create(cVar);
        f fVar = new f(webViewDependencies);
        this.j = fVar;
        CookieExpiredTimeImpl_Factory create = CookieExpiredTimeImpl_Factory.create(fVar);
        this.k = create;
        Provider<CookieExpiredTime> provider = DoubleCheck.provider(create);
        this.l = provider;
        this.m = DoubleCheck.provider(WebViewModule_ProvideCookieProvider$webview_releaseFactory.create(this.i, provider));
        d dVar = new d(webViewDependencies);
        this.n = dVar;
        WebViewAnalyticsInteractorImpl_Factory create2 = WebViewAnalyticsInteractorImpl_Factory.create(dVar);
        this.o = create2;
        Provider<WebViewAnalyticsInteractor> provider2 = DoubleCheck.provider(create2);
        this.p = provider2;
        WebViewPresenterImpl_Factory create3 = WebViewPresenterImpl_Factory.create(this.b, this.c, this.d, this.e, this.f, this.g, this.m, provider2);
        this.q = create3;
        this.r = DoubleCheck.provider(create3);
    }

    public static ImvWebViewBottomSheetComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.imv.di.ImvWebViewBottomSheetComponent
    public void inject(ImvWebViewBottomSheetActivity imvWebViewBottomSheetActivity) {
        ImvWebViewBottomSheetActivity_MembersInjector.injectPresenter(imvWebViewBottomSheetActivity, this.r.get());
        ImvWebViewBottomSheetActivity_MembersInjector.injectIntentFactory(imvWebViewBottomSheetActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        ImvWebViewBottomSheetActivity_MembersInjector.injectAnalytics(imvWebViewBottomSheetActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        ImvWebViewBottomSheetActivity_MembersInjector.injectAnalyticsInteractor(imvWebViewBottomSheetActivity, this.p.get());
    }
}
