package a2.a.a.e2.z;

import androidx.lifecycle.Observer;
import com.avito.android.publish.pretend.PretendFragment;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.util.MultiStateLoading;
public final class a<T> implements Observer<MultiStateLoading<? super PretendResult>> {
    public final /* synthetic */ PretendFragment a;

    public a(PretendFragment pretendFragment) {
        this.a = pretendFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(MultiStateLoading<? super PretendResult> multiStateLoading) {
        MultiStateLoading<? super PretendResult> multiStateLoading2 = multiStateLoading;
        if (multiStateLoading2 instanceof MultiStateLoading.InitLoading) {
            this.a.getLoadingProgress().showFullScreenLoading();
        } else if (multiStateLoading2 instanceof MultiStateLoading.Error) {
            this.a.getLoadingProgress().showFullScreenLoadingProblem(((MultiStateLoading.Error) multiStateLoading2).getError().getMessage());
        }
    }
}
