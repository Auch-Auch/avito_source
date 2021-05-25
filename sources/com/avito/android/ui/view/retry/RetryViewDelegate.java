package com.avito.android.ui.view.retry;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.Observable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0010\"\u00020\u0001\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/ui/view/retry/RetryViewDelegate;", "Lcom/avito/android/ui/view/retry/RetryView;", "", "showRetry", "()V", "showContent", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRetryListener", "(Lkotlin/jvm/functions/Function0;)V", "Lio/reactivex/Observable;", "retryClicks", "()Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "retryListener", "", AuthSource.SEND_ABUSE, "[Lcom/avito/android/ui/view/retry/RetryView;", "retryViews", "<init>", "([Lcom/avito/android/ui/view/retry/RetryView;Lkotlin/jvm/functions/Function0;)V", "progress-overlay_release"}, k = 1, mv = {1, 4, 2})
public final class RetryViewDelegate implements RetryView {
    public final RetryView[] a;
    public final Function0<Unit> b;

    public RetryViewDelegate(@NotNull RetryView[] retryViewArr, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(retryViewArr, "retryViews");
        Intrinsics.checkNotNullParameter(function0, "retryListener");
        this.a = retryViewArr;
        this.b = function0;
        setRetryListener(function0);
    }

    @Override // com.avito.android.ui.view.retry.RetryView
    @NotNull
    public Observable<Unit> retryClicks() {
        ArrayList arrayList = new ArrayList();
        for (RetryView retryView : this.a) {
            arrayList.add(retryView.retryClicks());
        }
        Observable<Unit> merge = Observable.merge(arrayList);
        Intrinsics.checkNotNullExpressionValue(merge, "Observable.merge(getClickObservablesArray())");
        return merge;
    }

    @Override // com.avito.android.ui.view.retry.RetryView
    public void setRetryListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        for (RetryView retryView : this.a) {
            retryView.setRetryListener(this.b);
        }
    }

    @Override // com.avito.android.ui.view.retry.RetryView
    public void showContent() {
        for (RetryView retryView : this.a) {
            retryView.showContent();
        }
    }

    @Override // com.avito.android.ui.view.retry.RetryView
    public void showRetry() {
        for (RetryView retryView : this.a) {
            retryView.showRetry();
        }
    }
}
