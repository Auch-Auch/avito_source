package com.avito.android.info.ui;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.analytics.Analytics;
import com.avito.android.deprecated_design.R;
import com.avito.android.info.ui.InfoView;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Toolbars;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\fR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/avito/android/info/ui/InfoViewImpl;", "Lcom/avito/android/info/ui/InfoView;", "", "baseUrl", "text", "", "setContent", "(Ljava/lang/String;Ljava/lang/String;)V", "title", "setTitle", "(Ljava/lang/String;)V", "showError", "()V", "showContent", "showProgress", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.SEND_ABUSE, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/webkit/WebView;", "c", "Landroid/webkit/WebView;", "webView", "Landroid/view/View;", "view", "Lcom/avito/android/info/ui/InfoView$Callback;", "callback", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/info/ui/InfoView$Callback;Lcom/avito/android/analytics/Analytics;)V", "info_release"}, k = 1, mv = {1, 4, 2})
public final class InfoViewImpl implements InfoView {
    public final ProgressOverlay a;
    public final Toolbar b;
    public final WebView c;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ InfoView.Callback a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InfoView.Callback callback) {
            super(0);
            this.a = callback;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.refresh();
            return Unit.INSTANCE;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ InfoView.Callback a;

        public b(InfoView.Callback callback) {
            this.a = callback;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.close();
        }
    }

    public InfoViewImpl(@NotNull View view, @NotNull InfoView.Callback callback, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.b = toolbar;
        int i = com.avito.android.info.R.id.web_view;
        View findViewById2 = view.findViewById(i);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.webkit.WebView");
        WebView webView = (WebView) findViewById2;
        this.c = webView;
        View findViewById3 = view.findViewById(com.avito.android.info.R.id.content_holder);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.FrameLayout");
        ProgressOverlay progressOverlay = new ProgressOverlay((FrameLayout) findViewById3, i, analytics, false, 0, 24, null);
        this.a = progressOverlay;
        progressOverlay.setOnRefreshListener(new a(callback));
        toolbar.setNavigationOnClickListener(new b(callback));
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
        settings.setDefaultTextEncodingName("UTF-8");
    }

    @Override // com.avito.android.info.ui.InfoView
    public void setContent(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "text");
        this.c.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
    }

    @Override // com.avito.android.info.ui.InfoView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        Toolbars.setSpannedTitle(this.b, str);
    }

    @Override // com.avito.android.info.ui.InfoView
    public void showContent() {
        this.a.showContent();
    }

    @Override // com.avito.android.info.ui.InfoView
    public void showError() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.a, null, 1, null);
    }

    @Override // com.avito.android.info.ui.InfoView
    public void showProgress() {
        this.a.showLoading();
    }
}
