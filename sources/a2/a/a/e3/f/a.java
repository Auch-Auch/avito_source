package a2.a.a.e3.f;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.tariff.info.TariffInfoFragment;
import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import java.util.List;
public final class a<T> implements Observer<LoadingState<? super List<? extends Item>>> {
    public final /* synthetic */ TariffInfoFragment a;

    public a(TariffInfoFragment tariffInfoFragment) {
        this.a = tariffInfoFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<? super List<? extends Item>> loadingState) {
        LoadingState<? super List<? extends Item>> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            TariffInfoFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Error) {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(TariffInfoFragment.access$getProgressOverlay$p(this.a), null, 1, null);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            TariffInfoFragment.access$getProgressOverlay$p(this.a).showContent();
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
            a2.b.a.a.a.s1((List) loaded.getData(), this.a.getAdapterPresenter());
            RecyclerView.Adapter adapter = this.a.a().getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            TariffInfoFragment.access$addDividerToList(this.a, (List) loaded.getData());
        }
    }
}
