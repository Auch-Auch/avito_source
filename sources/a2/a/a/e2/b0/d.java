package a2.a.a.e2.b0;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.publish.residential_complex_search.ResidentialComplexActivity;
import com.avito.android.publish.residential_complex_search.ResidentialComplexViewModel;
public final class d<T> implements Observer<ResidentialComplexViewModel.ViewState> {
    public final /* synthetic */ ResidentialComplexActivity a;

    public d(ResidentialComplexActivity residentialComplexActivity) {
        this.a = residentialComplexActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ResidentialComplexViewModel.ViewState viewState) {
        ResidentialComplexViewModel.ViewState viewState2 = viewState;
        if (viewState2 instanceof ResidentialComplexViewModel.ViewState.Loaded) {
            this.a.getAdapterPresenter().onDataSourceChanged(((ResidentialComplexViewModel.ViewState.Loaded) viewState2).getItems());
            RecyclerView.Adapter adapter = ResidentialComplexActivity.access$getRecyclerView$p(this.a).getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        boolean z = viewState2 instanceof ResidentialComplexViewModel.ViewState.Error;
    }
}
