package a2.a.a.e2.w;

import androidx.lifecycle.Observer;
import com.avito.android.publish.input_vin.InputVinFragment;
import com.avito.android.publish.input_vin.RoutingAction;
import com.avito.android.util.Keyboards;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Observer<RoutingAction> {
    public final /* synthetic */ InputVinFragment a;
    public final /* synthetic */ int b;

    public a(InputVinFragment inputVinFragment, int i) {
        this.a = inputVinFragment;
        this.b = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(RoutingAction routingAction) {
        RoutingAction routingAction2 = routingAction;
        Keyboards.hideKeyboard(this.a);
        if (Intrinsics.areEqual(routingAction2, RoutingAction.SaveAndExitPublishing.INSTANCE)) {
            InputVinFragment.access$getRouter$p(this.a).saveDraftAndExitPublishing();
        } else if (Intrinsics.areEqual(routingAction2, RoutingAction.ScanVin.INSTANCE)) {
            InputVinFragment.access$getRouter$p(this.a).scanVinFromSts(this.b);
        } else if (routingAction2 instanceof RoutingAction.OpenLink) {
            InputVinFragment.access$openLink(this.a, ((RoutingAction.OpenLink) routingAction2).getUrl());
        } else if (routingAction2 instanceof RoutingAction.ShowOnboarding) {
            InputVinFragment.access$getAppbarView$p(this.a).showActionOnboarding(((RoutingAction.ShowOnboarding) routingAction2).getOnboardingData());
        }
    }
}
