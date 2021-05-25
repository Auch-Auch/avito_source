package a2.a.a.r3.b;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.verification.verifications_list.VerificationsListFragment;
import com.avito.android.verification.verifications_list.VerificationsListViewModel;
public final class b<T> implements Observer<VerificationsListViewModel.RouterAction> {
    public final /* synthetic */ VerificationsListFragment a;

    public b(VerificationsListFragment verificationsListFragment) {
        this.a = verificationsListFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(VerificationsListViewModel.RouterAction routerAction) {
        VerificationsListViewModel.RouterAction routerAction2 = routerAction;
        if (routerAction2 instanceof VerificationsListViewModel.RouterAction.ToVerificationStatus) {
            FragmentActivity requireActivity = this.a.requireActivity();
            if (!(requireActivity instanceof VerificationsListFragment.VerificationsListRouter)) {
                requireActivity = null;
            }
            VerificationsListFragment.VerificationsListRouter verificationsListRouter = (VerificationsListFragment.VerificationsListRouter) requireActivity;
            if (verificationsListRouter != null) {
                verificationsListRouter.navigateToVerificationStatus(((VerificationsListViewModel.RouterAction.ToVerificationStatus) routerAction2).getType());
            }
        }
    }
}
