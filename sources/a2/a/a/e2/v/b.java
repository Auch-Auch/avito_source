package a2.a.a.e2.v;

import androidx.lifecycle.Observer;
import com.avito.android.publish.infomodel_request.InfomodelRequestFragment;
import com.avito.android.util.MultiStateLoading;
public final class b<T> implements Observer<MultiStateLoading<?>> {
    public final /* synthetic */ InfomodelRequestFragment a;

    public b(InfomodelRequestFragment infomodelRequestFragment) {
        this.a = infomodelRequestFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(MultiStateLoading<?> multiStateLoading) {
        MultiStateLoading<?> multiStateLoading2 = multiStateLoading;
        if (multiStateLoading2 instanceof MultiStateLoading.InitLoading) {
            this.a.getLoadingProgress().showFullScreenLoading();
        } else if (multiStateLoading2 instanceof MultiStateLoading.InitError) {
            this.a.getLoadingProgress().showFullScreenLoadingProblem(((MultiStateLoading.InitError) multiStateLoading2).getError().getMessage());
        }
    }
}
