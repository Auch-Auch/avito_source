package com.avito.android.ui.view.retry;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.view.retry.RetryView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.Observable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/ui/view/retry/PullToRefreshRetryView;", "Lcom/avito/android/ui/view/retry/RetryView;", "", "showRetry", "()V", "showContent", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", AuthSource.SEND_ABUSE, "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "swipeRefreshLayout", "<init>", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;)V", "progress-overlay_release"}, k = 1, mv = {1, 4, 2})
public final class PullToRefreshRetryView implements RetryView {
    public final SwipeRefreshLayout a;

    public PullToRefreshRetryView(@NotNull SwipeRefreshLayout swipeRefreshLayout) {
        Intrinsics.checkNotNullParameter(swipeRefreshLayout, "swipeRefreshLayout");
        this.a = swipeRefreshLayout;
    }

    @Override // com.avito.android.ui.view.retry.RetryView
    @NotNull
    public Observable<Unit> retryClicks() {
        return RetryView.DefaultImpls.retryClicks(this);
    }

    @Override // com.avito.android.ui.view.retry.RetryView
    @Deprecated(message = "Consider using Rx with retryClicks() if possible")
    public void setRetryListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        RetryView.DefaultImpls.setRetryListener(this, function0);
    }

    @Override // com.avito.android.ui.view.retry.RetryView
    public void showContent() {
        this.a.setRefreshing(false);
        this.a.setEnabled(true);
    }

    @Override // com.avito.android.ui.view.retry.RetryView
    public void showRetry() {
        this.a.setRefreshing(false);
        this.a.setEnabled(false);
    }
}
