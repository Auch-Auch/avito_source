package a2.a.a.e2.y;

import androidx.lifecycle.Observer;
import com.avito.android.publish.premoderation.PremoderationRequestFragment;
import com.avito.android.remote.model.AdvertDuplicateResult;
import com.avito.android.util.MultiStateLoading;
public final class c<T> implements Observer<MultiStateLoading<? super AdvertDuplicateResult>> {
    public final /* synthetic */ PremoderationRequestFragment a;

    public c(PremoderationRequestFragment premoderationRequestFragment) {
        this.a = premoderationRequestFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(MultiStateLoading<? super AdvertDuplicateResult> multiStateLoading) {
        MultiStateLoading<? super AdvertDuplicateResult> multiStateLoading2 = multiStateLoading;
        if (multiStateLoading2 instanceof MultiStateLoading.InitLoading) {
            this.a.getLoadingProgress().showFullScreenLoading();
        } else if (multiStateLoading2 instanceof MultiStateLoading.LoadingComplete) {
            this.a.getLoadingProgress().showContent();
        } else if (multiStateLoading2 instanceof MultiStateLoading.InitError) {
            this.a.getLoadingProgress().showFullScreenLoadingProblem(((MultiStateLoading.InitError) multiStateLoading2).getError().getMessage());
        }
    }
}
