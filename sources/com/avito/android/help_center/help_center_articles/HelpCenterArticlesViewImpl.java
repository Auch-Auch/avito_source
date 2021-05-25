package com.avito.android.help_center.help_center_articles;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.analytics.Analytics;
import com.avito.android.deprecated_design.R;
import com.avito.android.help_center.HelpCenterJSInterface;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0017R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R#\u0010)\u001a\b\u0012\u0004\u0012\u00020$0#8V@\u0016X\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001e\u0010.\u001a\n +*\u0004\u0018\u00010*0*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u0006;"}, d2 = {"Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesViewImpl;", "Lcom/avito/android/help_center/help_center_articles/HelpCenterArticlesView;", "", "url", "", "loadUrl", "(Ljava/lang/String;)V", "", "pageBack", "()Z", "startLoad", "()V", "showData", "showError", "Lcom/avito/android/help_center/HelpCenterJSInterface;", "jsInterface", "name", "addJavascriptInterface", "(Lcom/avito/android/help_center/HelpCenterJSInterface;Ljava/lang/String;)V", "removeJavascriptInterface", "Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;", "interceptor", "addInterceptor", "(Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;)V", "removeInterceptor", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "getNavigationClick", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "navigationClick", "Landroid/view/View;", "f", "Landroid/view/View;", "view", "Lio/reactivex/Observable;", "Lcom/yatatsu/powerwebview/rx/PowerWebViewStateChangeEvent;", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getStateChangeEvents", "()Lio/reactivex/Observable;", "stateChangeEvents", "Landroidx/appcompat/widget/Toolbar;", "kotlin.jvm.PlatformType", "c", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "e", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/ui/view/PowerWebViewWrapperImpl;", "d", "Lcom/avito/android/ui/view/PowerWebViewWrapperImpl;", "webView", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;)V", "help-center_release"}, k = 1, mv = {1, 4, 2})
public final class HelpCenterArticlesViewImpl implements HelpCenterArticlesView {
    @NotNull
    public final PublishRelay<Unit> a;
    @NotNull
    public final Lazy b = c.lazy(new b(this));
    public final Toolbar c;
    public final PowerWebViewWrapperImpl d;
    public final ProgressOverlay e;
    public final View f;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ HelpCenterArticlesViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(HelpCenterArticlesViewImpl helpCenterArticlesViewImpl) {
            super(0);
            this.a = helpCenterArticlesViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.d.reloadPage();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Observable<PowerWebViewStateChangeEvent>> {
        public final /* synthetic */ HelpCenterArticlesViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(HelpCenterArticlesViewImpl helpCenterArticlesViewImpl) {
            super(0);
            this.a = helpCenterArticlesViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Observable<PowerWebViewStateChangeEvent> invoke() {
            return InteropKt.toV2(this.a.d.getStateChangeEvents());
        }
    }

    public HelpCenterArticlesViewImpl(@NotNull View view, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.f = view;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        this.c = toolbar;
        int i = com.avito.android.help_center.R.id.webview;
        View findViewById = view.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.webview)");
        this.d = new PowerWebViewWrapperImpl((PowerWebView) findViewById);
        View findViewById2 = view.findViewById(com.avito.android.help_center.R.id.content_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.content_holder)");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById2, i, analytics, false, 0, 24, null);
        this.e = progressOverlay;
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24_blue);
        toolbar.setNavigationOnClickListener(new a2.a.a.y0.c.a(this));
        progressOverlay.setOnRefreshListener(new a(this));
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesView
    public void addInterceptor(@NotNull PowerWebViewInterceptor powerWebViewInterceptor) {
        Intrinsics.checkNotNullParameter(powerWebViewInterceptor, "interceptor");
        this.d.addInterceptor(powerWebViewInterceptor);
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesView
    public void addJavascriptInterface(@NotNull HelpCenterJSInterface helpCenterJSInterface, @NotNull String str) {
        Intrinsics.checkNotNullParameter(helpCenterJSInterface, "jsInterface");
        Intrinsics.checkNotNullParameter(str, "name");
        this.d.addJavascriptInterface(helpCenterJSInterface, str);
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesView
    @NotNull
    public Observable<PowerWebViewStateChangeEvent> getStateChangeEvents() {
        return (Observable) this.b.getValue();
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesView
    public void loadUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.d.loadUrl(str);
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesView
    public boolean pageBack() {
        return this.d.goBack();
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesView
    public void removeInterceptor(@NotNull PowerWebViewInterceptor powerWebViewInterceptor) {
        Intrinsics.checkNotNullParameter(powerWebViewInterceptor, "interceptor");
        this.d.removeInterceptor(powerWebViewInterceptor);
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesView
    public void removeJavascriptInterface(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.d.removeJavascriptInterface(str);
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesView
    public void showData() {
        this.e.showContent();
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesView
    public void showError() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.e, null, 1, null);
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesView
    public void startLoad() {
        this.e.showLoading();
    }

    @Override // com.avito.android.help_center.help_center_articles.HelpCenterArticlesView
    @NotNull
    public PublishRelay<Unit> getNavigationClick() {
        return this.a;
    }
}
