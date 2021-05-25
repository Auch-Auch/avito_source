package a2.a.a.c2.a;

import androidx.lifecycle.Observer;
import com.avito.android.code_confirmation.Source;
import com.avito.android.code_confirmation.event.CodeConfirmationOpenedEvent;
import com.avito.android.profile_phones.add_phone.AddPhoneFragment;
import com.avito.android.profile_phones.add_phone.AddPhoneViewModel;
import com.avito.android.ui.fragments.TabBaseFragment;
public final class a<T> implements Observer<AddPhoneViewModel.RoutingAction> {
    public final /* synthetic */ AddPhoneFragment a;

    public a(AddPhoneFragment addPhoneFragment) {
        this.a = addPhoneFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(AddPhoneViewModel.RoutingAction routingAction) {
        AddPhoneViewModel.RoutingAction routingAction2 = routingAction;
        if (routingAction2 instanceof AddPhoneViewModel.RoutingAction.GoToPhoneConfirmation) {
            AddPhoneViewModel.RoutingAction.GoToPhoneConfirmation goToPhoneConfirmation = (AddPhoneViewModel.RoutingAction.GoToPhoneConfirmation) routingAction2;
            this.a.getAnalytics().track(new CodeConfirmationOpenedEvent(goToPhoneConfirmation.getPhone(), Source.PHONE_ADD));
            AddPhoneFragment addPhoneFragment = this.a;
            addPhoneFragment.startForResult(addPhoneFragment.getActivityIntentFactory().confirmPhoneIntent(goToPhoneConfirmation.getPhone(), goToPhoneConfirmation.getCodeLength(), goToPhoneConfirmation.getTimeout()), 10);
        } else if (routingAction2 instanceof AddPhoneViewModel.RoutingAction.GoByDeeplink) {
            AddPhoneFragment.access$openDeepLinkIntent(this.a, ((AddPhoneViewModel.RoutingAction.GoByDeeplink) routingAction2).getDeeplink());
        } else if (routingAction2 instanceof AddPhoneViewModel.RoutingAction.GoBack) {
            TabBaseFragment.setResult$default(this.a, 0, null, 2, null);
            this.a.finish();
        }
    }
}
