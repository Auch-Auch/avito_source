package a2.a.a.c2.f;

import androidx.lifecycle.Observer;
import com.avito.android.profile_phones.phones_list.PhonesListFragment;
import com.avito.android.profile_phones.phones_list.PhonesListViewModel;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<PhonesListViewModel.RoutingAction> {
    public final /* synthetic */ PhonesListFragment a;

    public b(PhonesListFragment phonesListFragment) {
        this.a = phonesListFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(PhonesListViewModel.RoutingAction routingAction) {
        PhonesListViewModel.RoutingAction routingAction2 = routingAction;
        if (routingAction2 instanceof PhonesListViewModel.RoutingAction.OpenActionsSheet) {
            PhonesListViewModel.RoutingAction.OpenActionsSheet openActionsSheet = (PhonesListViewModel.RoutingAction.OpenActionsSheet) routingAction2;
            PhonesListFragment.access$openActionsSheet(this.a, openActionsSheet.getPhone(), openActionsSheet.getActions());
        } else if (Intrinsics.areEqual(routingAction2, PhonesListViewModel.RoutingAction.OpenPhoneAddScreen.INSTANCE)) {
            PhonesListFragment.access$openAddPhoneScreen(this.a);
        } else if (routingAction2 instanceof PhonesListViewModel.RoutingAction.OpenActionByDeepLink) {
            PhonesListFragment.access$openDeepLinkIntent(this.a, ((PhonesListViewModel.RoutingAction.OpenActionByDeepLink) routingAction2).getDeepLink());
        } else if (routingAction2 instanceof PhonesListViewModel.RoutingAction.OpenVerificationStatusStubDialog) {
            PhonesListFragment.access$showVerificationStatusStub(this.a, ((PhonesListViewModel.RoutingAction.OpenVerificationStatusStubDialog) routingAction2).getPhone());
        } else if (Intrinsics.areEqual(routingAction2, PhonesListViewModel.RoutingAction.OpenVerificationStubDialog.INSTANCE)) {
            PhonesListFragment.access$showVerificationStub(this.a);
        }
    }
}
