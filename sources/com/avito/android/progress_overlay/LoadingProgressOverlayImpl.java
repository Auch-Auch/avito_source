package com.avito.android.progress_overlay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/progress_overlay/LoadingProgressOverlayImpl;", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "Landroid/view/ViewGroup;", "containerView", "", "contentViewId", "", "setup", "(Landroid/view/ViewGroup;I)V", "showContent", "()V", "showFullScreenLoading", "", "text", "showFullScreenLoadingProblem", "(Ljava/lang/String;)V", "showLoadingDialog", "showErrorMessage", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnRefreshListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/progress_overlay/ProgressDialogRouter;", "d", "Lcom/avito/android/progress_overlay/ProgressDialogRouter;", "progressDialogRouter", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", AuthSource.SEND_ABUSE, "Landroid/view/ViewGroup;", "contentView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/progress_overlay/ProgressDialogRouter;)V", "progress-overlay_release"}, k = 1, mv = {1, 4, 2})
public final class LoadingProgressOverlayImpl implements LoadingProgressOverlay {
    public ViewGroup a;
    public ProgressOverlay b;
    public final Analytics c;
    public final ProgressDialogRouter d;

    @Inject
    public LoadingProgressOverlayImpl(@NotNull Analytics analytics, @NotNull ProgressDialogRouter progressDialogRouter) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(progressDialogRouter, "progressDialogRouter");
        this.c = analytics;
        this.d = progressDialogRouter;
    }

    @Override // com.avito.android.progress_overlay.LoadingProgressOverlay
    public void setOnRefreshListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ProgressOverlay progressOverlay = this.b;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        progressOverlay.setOnRefreshListener(function0);
    }

    @Override // com.avito.android.progress_overlay.LoadingProgressOverlay
    public void setup(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "containerView");
        View findViewById = viewGroup.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(contentViewId)");
        this.a = (ViewGroup) findViewById;
        this.b = new ProgressOverlay(viewGroup, i, this.c, false, 0, 24, null);
    }

    @Override // com.avito.android.progress_overlay.LoadingProgressOverlay
    public void showContent() {
        if (!this.d.removeDialog()) {
            ProgressOverlay progressOverlay = this.b;
            if (progressOverlay == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
            }
            progressOverlay.showContent();
        }
    }

    @Override // com.avito.android.progress_overlay.LoadingProgressOverlay
    public void showErrorMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.d.removeDialog();
        if (!(!m.isBlank(str))) {
            ViewGroup viewGroup = this.a;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentView");
            }
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            str = context.getResources().getString(R.string.something_went_wrong);
            Intrinsics.checkNotNullExpressionValue(str, "context.resources.getStr…ing.something_went_wrong)");
        }
        ViewGroup viewGroup2 = this.a;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        Views.showSnackBar$default(viewGroup2, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 124, (Object) null);
    }

    @Override // com.avito.android.progress_overlay.LoadingProgressOverlay
    public void showFullScreenLoading() {
        ProgressOverlay progressOverlay = this.b;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        progressOverlay.showLoading();
    }

    @Override // com.avito.android.progress_overlay.LoadingProgressOverlay
    public void showFullScreenLoadingProblem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        ProgressOverlay progressOverlay = this.b;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        progressOverlay.showLoadingProblem(str);
    }

    @Override // com.avito.android.progress_overlay.LoadingProgressOverlay
    public void showLoadingDialog() {
        this.d.showDialog();
    }
}
