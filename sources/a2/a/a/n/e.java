package a2.a.a.n;

import com.avito.android.autodeal_details.AutoDealDetailsActivity;
import com.avito.android.progress_overlay.LoadingOverlay;
import io.reactivex.functions.Consumer;
public final class e<T> implements Consumer<Throwable> {
    public final /* synthetic */ AutoDealDetailsActivity a;

    public e(AutoDealDetailsActivity autoDealDetailsActivity) {
        this.a = autoDealDetailsActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(AutoDealDetailsActivity.access$getProgressOverlay$p(this.a), null, 1, null);
    }
}
