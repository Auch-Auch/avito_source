package com.avito.android.progress_overlay;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u000f\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H&¢\u0006\u0004\b\u000f\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/progress_overlay/LoadingOverlay;", "", "", "showContent", "()V", "showLoading", "", "text", "showLoadingProblem", "(Ljava/lang/String;)V", "Lio/reactivex/Observable;", "refreshes", "()Lio/reactivex/Observable;", "Lcom/avito/android/progress_overlay/OnRefreshListener;", "onRefreshListener", "setOnRefreshListener", "(Lcom/avito/android/progress_overlay/OnRefreshListener;)V", "setToolbarPadding", "", "paddingDimenRes", "setBottomPadding", "(I)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Lkotlin/jvm/functions/Function0;)V", "progress-overlay_release"}, k = 1, mv = {1, 4, 2})
public interface LoadingOverlay {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void showLoadingProblem$default(LoadingOverlay loadingOverlay, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = "";
                }
                loadingOverlay.showLoadingProblem(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoadingProblem");
        }
    }

    @NotNull
    Observable<Unit> refreshes();

    void setBottomPadding(int i);

    void setOnRefreshListener(@Nullable OnRefreshListener onRefreshListener);

    void setOnRefreshListener(@NotNull Function0<Unit> function0);

    void setToolbarPadding();

    void showContent();

    void showLoading();

    void showLoadingProblem(@NotNull String str);
}
