package a2.a.a.e3.e;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.tariff.fees_methods.FeesMethodsFragment;
import com.avito.android.tariff.fees_methods.viewmodel.FeesScreenState;
import com.avito.android.util.LoadingState;
public final class a<T> implements Observer<LoadingState<? super FeesScreenState>> {
    public final /* synthetic */ FeesMethodsFragment a;

    public a(FeesMethodsFragment feesMethodsFragment) {
        this.a = feesMethodsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<? super FeesScreenState> loadingState) {
        LoadingState<? super FeesScreenState> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            FeesMethodsFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(FeesMethodsFragment.access$getProgressOverlay$p(this.a), null, 1, null);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            FeesMethodsFragment.access$getProgressOverlay$p(this.a).showContent();
            a2.b.a.a.a.s1(((FeesScreenState) ((LoadingState.Loaded) loadingState2).getData()).getItems(), this.a.getAdapterPresenter());
            RecyclerView.Adapter adapter = this.a.a().getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }
}
