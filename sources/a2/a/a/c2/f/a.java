package a2.a.a.c2.f;

import androidx.lifecycle.Observer;
import com.avito.android.profile_phones.phones_list.PhonesListFragment;
import com.avito.android.profile_phones.phones_list.PhonesListViewModel;
import com.avito.konveyor.util.AdapterPresentersKt;
public final class a<T> implements Observer<PhonesListViewModel.ListState> {
    public final /* synthetic */ PhonesListFragment a;

    public a(PhonesListFragment phonesListFragment) {
        this.a = phonesListFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(PhonesListViewModel.ListState listState) {
        PhonesListViewModel.ListState listState2 = listState;
        if (listState2 instanceof PhonesListViewModel.ListState.Loading) {
            PhonesListFragment.access$getAppBarLayout$p(this.a).setExpanded(false);
            PhonesListFragment.access$getRecycler$p(this.a).setNestedScrollingEnabled(false);
            PhonesListFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (listState2 instanceof PhonesListViewModel.ListState.Loaded) {
            PhonesListFragment.access$getAppBarLayout$p(this.a).setExpanded(true);
            PhonesListFragment.access$getRecycler$p(this.a).setNestedScrollingEnabled(true);
            PhonesListFragment.access$getProgressOverlay$p(this.a).showContent();
            AdapterPresentersKt.updateItems(this.a.getAdapterPresenter(), ((PhonesListViewModel.ListState.Loaded) listState2).getList());
            this.a.getAdapter().notifyDataSetChanged();
        } else if (listState2 instanceof PhonesListViewModel.ListState.Error) {
            PhonesListFragment.access$getAppBarLayout$p(this.a).setExpanded(false);
            PhonesListFragment.access$getRecycler$p(this.a).setNestedScrollingEnabled(false);
            PhonesListFragment.access$handleError(this.a, ((PhonesListViewModel.ListState.Error) listState2).getType());
        }
    }
}
