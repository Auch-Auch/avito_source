package a2.a.a.r3.b;

import androidx.lifecycle.Observer;
import com.avito.android.verification.verifications_list.VerificationsListFragment;
import com.avito.android.verification.verifications_list.VerificationsListViewModel;
public final class a<T> implements Observer<VerificationsListViewModel.State> {
    public final /* synthetic */ VerificationsListFragment a;

    public a(VerificationsListFragment verificationsListFragment) {
        this.a = verificationsListFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(VerificationsListViewModel.State state) {
        VerificationsListViewModel.State state2 = state;
        if (state2 instanceof VerificationsListViewModel.State.Loaded) {
            VerificationsListFragment.access$getVerificationsListView$p(this.a).showContent();
            VerificationsListViewModel.State.Loaded loaded = (VerificationsListViewModel.State.Loaded) state2;
            VerificationsListFragment.access$getVerificationsListView$p(this.a).setTitle(loaded.getScreenData().getTitle());
            VerificationsListFragment.access$getVerificationsListView$p(this.a).updateItems(loaded.getScreenData().getVerificationsList());
        } else if (state2 instanceof VerificationsListViewModel.State.Loading) {
            VerificationsListFragment.access$getVerificationsListView$p(this.a).showLoading();
        } else if (state2 instanceof VerificationsListViewModel.State.Error) {
            VerificationsListFragment.access$getVerificationsListView$p(this.a).showError(((VerificationsListViewModel.State.Error) state2).getMessage());
        }
    }
}
