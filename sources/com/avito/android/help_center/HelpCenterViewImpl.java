package com.avito.android.help_center;

import a2.g.r.g;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.analytics.Analytics;
import com.avito.android.deprecated_design.R;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.view.PowerWebViewWrapperImpl;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.PublishRelay;
import com.yatatsu.powerwebview.PowerWebView;
import com.yatatsu.powerwebview.PowerWebViewInterceptor;
import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.Observable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0006J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010$\u001a\n !*\u0004\u0018\u00010 0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040)8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R#\u00105\u001a\b\u0012\u0004\u0012\u0002000/8V@\u0016X\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\"\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040)8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u0010+\u001a\u0004\b7\u0010-R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006C"}, d2 = {"Lcom/avito/android/help_center/HelpCenterViewImpl;", "Lcom/avito/android/help_center/HelpCenterView;", "", "url", "", "loadUrl", "(Ljava/lang/String;)V", "", "pageBack", "()Z", "visible", "setMenuHomeButtonVisible", "(Z)V", "startLoad", "()V", "showData", "showError", "Lcom/avito/android/help_center/HelpCenterJSInterface;", "jsInterface", "name", "addJavascriptInterface", "(Lcom/avito/android/help_center/HelpCenterJSInterface;Ljava/lang/String;)V", "removeJavascriptInterface", "Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;", "interceptor", "addInterceptor", "(Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;)V", "removeInterceptor", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "f", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/appcompat/widget/Toolbar;", "kotlin.jvm.PlatformType", "d", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/view/MenuItem;", g.a, "Landroid/view/MenuItem;", "menuHomeItem", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "getNavigationClick", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "navigationClick", "Lio/reactivex/Observable;", "Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", "c", "Lkotlin/Lazy;", "getStateChangeEvents", "()Lio/reactivex/Observable;", "stateChangeEvents", AuthSource.SEND_ABUSE, "getHomeClick", "homeClick", "Lcom/avito/android/ui/view/PowerWebViewWrapperImpl;", "e", "Lcom/avito/android/ui/view/PowerWebViewWrapperImpl;", "webView", "Landroid/view/View;", "view", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;)V", "help-center_release"}, k = 1, mv = {1, 4, 2})
public final class HelpCenterViewImpl implements HelpCenterView {
    @NotNull
    public final PublishRelay<Unit> a;
    @NotNull
    public final PublishRelay<Unit> b;
    @NotNull
    public final Lazy c = c.lazy(new b(this));
    public final Toolbar d;
    public final PowerWebViewWrapperImpl e;
    public final ProgressOverlay f;
    public MenuItem g;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ HelpCenterViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(HelpCenterViewImpl helpCenterViewImpl) {
            super(0);
            this.a = helpCenterViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.e.reloadPage();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Observable<PowerWebViewStateChangeEvent>> {
        public final /* synthetic */ HelpCenterViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(HelpCenterViewImpl helpCenterViewImpl) {
            super(0);
            this.a = helpCenterViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Observable<PowerWebViewStateChangeEvent> invoke() {
            return InteropKt.toV2(this.a.e.getStateChangeEvents());
        }
    }

    public HelpCenterViewImpl(@NotNull View view, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.b = create2;
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        this.d = toolbar;
        int i = R.id.webview;
        View findViewById = view.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<PowerWebView>(R.id.webview)");
        this.e = new PowerWebViewWrapperImpl((PowerWebView) findViewById);
        View findViewById2 = view.findViewById(R.id.content_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.content_holder)");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById2, i, analytics, false, 0, 24, null);
        this.f = progressOverlay;
        toolbar.inflateMenu(R.menu.help_center);
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        MenuItem findItem = toolbar.getMenu().findItem(R.id.home);
        Intrinsics.checkNotNullExpressionValue(findItem, "toolbar.menu.findItem(R.id.home)");
        this.g = findItem;
        if (findItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuHomeItem");
        }
        findItem.setOnMenuItemClickListener(new a2.a.a.y0.a(this));
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24_blue);
        toolbar.setNavigationOnClickListener(new a2.a.a.y0.b(this));
        progressOverlay.setOnRefreshListener(new a(this));
    }

    @Override // com.avito.android.help_center.HelpCenterView
    public void addInterceptor(@NotNull PowerWebViewInterceptor powerWebViewInterceptor) {
        Intrinsics.checkNotNullParameter(powerWebViewInterceptor, "interceptor");
        this.e.addInterceptor(powerWebViewInterceptor);
    }

    @Override // com.avito.android.help_center.HelpCenterView
    public void addJavascriptInterface(@NotNull HelpCenterJSInterface helpCenterJSInterface, @NotNull String str) {
        Intrinsics.checkNotNullParameter(helpCenterJSInterface, "jsInterface");
        Intrinsics.checkNotNullParameter(str, "name");
        this.e.addJavascriptInterface(helpCenterJSInterface, str);
    }

    @Override // com.avito.android.help_center.HelpCenterView
    @NotNull
    public Observable<PowerWebViewStateChangeEvent> getStateChangeEvents() {
        return (Observable) this.c.getValue();
    }

    @Override // com.avito.android.help_center.HelpCenterView
    public void loadUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.e.loadUrl(str);
    }

    @Override // com.avito.android.help_center.HelpCenterView
    public boolean pageBack() {
        return this.e.goBack();
    }

    @Override // com.avito.android.help_center.HelpCenterView
    public void removeInterceptor(@NotNull PowerWebViewInterceptor powerWebViewInterceptor) {
        Intrinsics.checkNotNullParameter(powerWebViewInterceptor, "interceptor");
        this.e.removeInterceptor(powerWebViewInterceptor);
    }

    @Override // com.avito.android.help_center.HelpCenterView
    public void removeJavascriptInterface(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.e.removeJavascriptInterface(str);
    }

    @Override // com.avito.android.help_center.HelpCenterView
    public void setMenuHomeButtonVisible(boolean z) {
        MenuItem menuItem = this.g;
        if (menuItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuHomeItem");
        }
        menuItem.setVisible(z);
    }

    @Override // com.avito.android.help_center.HelpCenterView
    public void showData() {
        this.f.showContent();
    }

    @Override // com.avito.android.help_center.HelpCenterView
    public void showError() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.f, null, 1, null);
    }

    @Override // com.avito.android.help_center.HelpCenterView
    public void startLoad() {
        this.f.showLoading();
    }

    @Override // com.avito.android.help_center.HelpCenterView
    @NotNull
    public PublishRelay<Unit> getHomeClick() {
        return this.a;
    }

    @Override // com.avito.android.help_center.HelpCenterView
    @NotNull
    public PublishRelay<Unit> getNavigationClick() {
        return this.b;
    }
}
