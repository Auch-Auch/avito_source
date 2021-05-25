package com.avito.android.deep_linking;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\b\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/avito/android/deep_linking/AppLinkViewImpl;", "Lcom/avito/android/deep_linking/AppLinkView;", "Lio/reactivex/Observable;", "", "getRefreshes", "()Lio/reactivex/Observable;", "showLoading", "()V", "showError", "", "message", "(Ljava/lang/String;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.SEND_ABUSE, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroid/view/View;", "view", "<init>", "(Lcom/avito/android/analytics/Analytics;Landroid/view/View;)V", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public final class AppLinkViewImpl implements AppLinkView {
    public final ProgressOverlay a;

    public AppLinkViewImpl(@NotNull Analytics analytics, @NotNull View view) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(viewGroup, "containerView");
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, R.id.content, analytics, false, 0, 24, null);
        this.a = progressOverlay;
        progressOverlay.refreshes();
    }

    @Override // com.avito.android.deep_linking.AppLinkView
    @NotNull
    public Observable<Unit> getRefreshes() {
        return this.a.refreshes();
    }

    @Override // com.avito.android.deep_linking.AppLinkView
    public void showError() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.a, null, 1, null);
    }

    @Override // com.avito.android.deep_linking.AppLinkView
    public void showLoading() {
        this.a.showLoading();
    }

    @Override // com.avito.android.deep_linking.AppLinkView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.a.showLoadingProblem(str);
    }
}
