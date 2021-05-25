package defpackage;

import androidx.lifecycle.Observer;
import com.avito.android.express_cv.ExpressCvActivity;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Views;
/* compiled from: java-style lambda group */
/* renamed from: h0  reason: default package */
public final class h0<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public h0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(LoadingState<?> loadingState) {
        int i = this.a;
        if (i == 0) {
            LoadingState<?> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                ExpressCvActivity.access$getProgressOverlay$p((ExpressCvActivity) this.b).showLoading();
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                ExpressCvActivity.access$getProgressOverlay$p((ExpressCvActivity) this.b).showContent();
            } else if (loadingState2 instanceof LoadingState.Error) {
                LoadingOverlay.DefaultImpls.showLoadingProblem$default(ExpressCvActivity.access$getProgressOverlay$p((ExpressCvActivity) this.b), null, 1, null);
            }
        } else if (i == 1) {
            LoadingState<?> loadingState3 = loadingState;
            if (loadingState3 instanceof LoadingState.Loading) {
                Views.show(ExpressCvActivity.access$getProgressBar$p((ExpressCvActivity) this.b));
            } else if (loadingState3 instanceof LoadingState.Loaded) {
                Views.hide(ExpressCvActivity.access$getProgressBar$p((ExpressCvActivity) this.b));
            } else if (loadingState3 instanceof LoadingState.Error) {
                Views.hide(ExpressCvActivity.access$getProgressBar$p((ExpressCvActivity) this.b));
            }
        } else {
            throw null;
        }
    }
}
