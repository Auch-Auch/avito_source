package a2.a.a.e2.c0;

import androidx.lifecycle.Observer;
import com.avito.android.publish.select.SelectFragment;
import com.avito.android.publish.select.SelectViewModel;
public final class a<T> implements Observer<SelectViewModel.RoutingAction> {
    public final /* synthetic */ SelectFragment a;

    public a(SelectFragment selectFragment) {
        this.a = selectFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(SelectViewModel.RoutingAction routingAction) {
        SelectViewModel.RoutingAction routingAction2 = routingAction;
        if (routingAction2 instanceof SelectViewModel.RoutingAction.ShowOnboarding) {
            SelectFragment.access$getAppbarView$p(this.a).showActionOnboarding(((SelectViewModel.RoutingAction.ShowOnboarding) routingAction2).getOnboardingData());
        }
    }
}
