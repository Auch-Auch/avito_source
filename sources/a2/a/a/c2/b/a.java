package a2.a.a.c2.b;

import android.content.Intent;
import androidx.lifecycle.Observer;
import com.avito.android.profile_phones.R;
import com.avito.android.profile_phones.add_phone.AddPhoneFragmentKt;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneFragment;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModel;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Keyboards;
public final class a<T> implements Observer<ConfirmPhoneViewModel.RoutingAction> {
    public final /* synthetic */ ConfirmPhoneFragment a;

    public a(ConfirmPhoneFragment confirmPhoneFragment) {
        this.a = confirmPhoneFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ConfirmPhoneViewModel.RoutingAction routingAction) {
        ConfirmPhoneViewModel.RoutingAction routingAction2 = routingAction;
        if (routingAction2 instanceof ConfirmPhoneViewModel.RoutingAction.GoToPhonesList) {
            Keyboards.hideKeyboard$default(ConfirmPhoneFragment.access$getCodeInput$p(this.a), false, 1, null);
            ConfirmPhoneFragment confirmPhoneFragment = this.a;
            Intent intent = new Intent();
            ConfirmPhoneViewModel.RoutingAction.GoToPhonesList goToPhonesList = (ConfirmPhoneViewModel.RoutingAction.GoToPhonesList) routingAction2;
            intent.putExtra(AddPhoneFragmentKt.EXTRA_PHONE, goToPhonesList.getPhone());
            intent.putExtra("result_message", this.a.getString(R.string.f6onfirm_phone_success, goToPhonesList.getPhone()));
            confirmPhoneFragment.setResult(-1, intent);
            this.a.finish();
        } else if (routingAction2 instanceof ConfirmPhoneViewModel.RoutingAction.GoBack) {
            TabBaseFragment.setResult$default(this.a, 0, null, 2, null);
            this.a.finish();
        }
    }
}
