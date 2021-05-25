package com.avito.android.ui.view.retry;

import android.view.View;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u0005\u001a\u00020\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/ui/view/retry/RetryViewBuilder;", "", "", "Landroid/view/View;", "views", "hideOnRetry", "([Landroid/view/View;)Lcom/avito/android/ui/view/retry/RetryViewBuilder;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "swipeRefreshLayout", "withSwipeRefresh", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;)Lcom/avito/android/ui/view/retry/RetryViewBuilder;", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "withOverlay", "(Lcom/avito/android/progress_overlay/ProgressOverlay;)Lcom/avito/android/ui/view/retry/RetryViewBuilder;", "Lcom/avito/android/ui/view/retry/RetryViewDelegate;", "build", "()Lcom/avito/android/ui/view/retry/RetryViewDelegate;", "", "Lcom/avito/android/ui/view/retry/RetryView;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "retryViews", "Lkotlin/Function0;", "", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "retryListener", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "progress-overlay_release"}, k = 1, mv = {1, 4, 2})
public final class RetryViewBuilder {
    public final List<RetryView> a = new ArrayList();
    public final Function0<Unit> b;

    public RetryViewBuilder(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "retryListener");
        this.b = function0;
    }

    @NotNull
    public final RetryViewDelegate build() {
        Object[] array = this.a.toArray(new RetryView[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        RetryView[] retryViewArr = (RetryView[]) array;
        return new RetryViewDelegate((RetryView[]) Arrays.copyOf(retryViewArr, retryViewArr.length), this.b);
    }

    @NotNull
    public final RetryViewBuilder hideOnRetry(@NotNull View... viewArr) {
        Intrinsics.checkNotNullParameter(viewArr, "views");
        for (View view : viewArr) {
            this.a.add(new HideOnRetryRetryView(view));
        }
        return this;
    }

    @NotNull
    public final RetryViewBuilder withOverlay(@NotNull ProgressOverlay progressOverlay) {
        Intrinsics.checkNotNullParameter(progressOverlay, "progressOverlay");
        this.a.add(new OverlayRetryView(progressOverlay));
        return this;
    }

    @NotNull
    public final RetryViewBuilder withSwipeRefresh(@NotNull SwipeRefreshLayout swipeRefreshLayout) {
        Intrinsics.checkNotNullParameter(swipeRefreshLayout, "swipeRefreshLayout");
        this.a.add(new PullToRefreshRetryView(swipeRefreshLayout));
        return this;
    }
}
