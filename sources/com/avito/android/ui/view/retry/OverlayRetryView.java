package com.avito.android.ui.view.retry;

import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.view.retry.RetryView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/ui/view/retry/OverlayRetryView;", "Lcom/avito/android/ui/view/retry/RetryView;", "", "showRetry", "()V", "showContent", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRetryListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.SEND_ABUSE, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "<init>", "(Lcom/avito/android/progress_overlay/ProgressOverlay;)V", "progress-overlay_release"}, k = 1, mv = {1, 4, 2})
public final class OverlayRetryView implements RetryView {
    public final ProgressOverlay a;

    public OverlayRetryView(@NotNull ProgressOverlay progressOverlay) {
        Intrinsics.checkNotNullParameter(progressOverlay, "progressOverlay");
        this.a = progressOverlay;
    }

    @Override // com.avito.android.ui.view.retry.RetryView
    @NotNull
    public Observable<Unit> retryClicks() {
        return RetryView.DefaultImpls.retryClicks(this);
    }

    @Override // com.avito.android.ui.view.retry.RetryView
    public void setRetryListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a.setOnRefreshListener(function0);
    }

    @Override // com.avito.android.ui.view.retry.RetryView
    public void showContent() {
        this.a.showContent();
    }

    @Override // com.avito.android.ui.view.retry.RetryView
    public void showRetry() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.a, null, 1, null);
    }
}
