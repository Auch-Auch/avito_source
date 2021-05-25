package com.avito.android.progress_overlay;

import android.view.ViewGroup;
import androidx.annotation.IdRes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\nJ\u0019\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0011\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "", "Landroid/view/ViewGroup;", "containerView", "", "contentViewId", "", "setup", "(Landroid/view/ViewGroup;I)V", "showContent", "()V", "showFullScreenLoading", "", "text", "showFullScreenLoadingProblem", "(Ljava/lang/String;)V", "showLoadingDialog", "showErrorMessage", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnRefreshListener", "(Lkotlin/jvm/functions/Function0;)V", "progress-overlay_release"}, k = 1, mv = {1, 4, 2})
public interface LoadingProgressOverlay {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void showErrorMessage$default(LoadingProgressOverlay loadingProgressOverlay, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = "";
                }
                loadingProgressOverlay.showErrorMessage(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorMessage");
        }

        public static /* synthetic */ void showFullScreenLoadingProblem$default(LoadingProgressOverlay loadingProgressOverlay, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = "";
                }
                loadingProgressOverlay.showFullScreenLoadingProblem(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFullScreenLoadingProblem");
        }
    }

    void setOnRefreshListener(@NotNull Function0<Unit> function0);

    void setup(@NotNull ViewGroup viewGroup, @IdRes int i);

    void showContent();

    void showErrorMessage(@NotNull String str);

    void showFullScreenLoading();

    void showFullScreenLoadingProblem(@NotNull String str);

    void showLoadingDialog();
}
