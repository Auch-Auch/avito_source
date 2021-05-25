package a2.a.a.c2.d;

import androidx.lifecycle.Observer;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.Input;
import com.avito.android.profile_phones.phone_action.PhoneActionFragment;
import com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModel;
import com.avito.android.util.Views;
import kotlin.jvm.internal.Intrinsics;
public final class e<T> implements Observer<PhoneActionViewModel.PhoneInputState> {
    public final /* synthetic */ PhoneActionFragment a;

    public e(PhoneActionFragment phoneActionFragment) {
        this.a = phoneActionFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(PhoneActionViewModel.PhoneInputState phoneInputState) {
        PhoneActionViewModel.PhoneInputState phoneInputState2 = phoneInputState;
        if (phoneInputState2 instanceof PhoneActionViewModel.PhoneInputState.Input) {
            Views.show(PhoneActionFragment.access$getPhoneInput$p(this.a));
            PhoneActionFragment.access$getPhoneInput$p(this.a).setOnClickListener(new d(this));
            PhoneActionViewModel.PhoneInputState.Input input = (PhoneActionViewModel.PhoneInputState.Input) phoneInputState2;
            PhoneActionFragment.access$getPhoneInput$p(this.a).setHint(input.getPlaceholderText());
            Input.setText$default(PhoneActionFragment.access$getPhoneInput$p(this.a), input.getValueText(), false, 2, null);
            PhoneActionFragment.access$getComponentContainer$p(this.a).setMessage(input.getMotivationText());
            if (input.getErrorText() == null) {
                PhoneActionFragment.access$getPhoneInput$p(this.a).setState(Input.Companion.getSTATE_NORMAL());
                return;
            }
            PhoneActionFragment.access$getPhoneInput$p(this.a).setState(Input.Companion.getSTATE_ERROR());
            ComponentContainer.showError$default(PhoneActionFragment.access$getComponentContainer$p(this.a), new int[]{PhoneActionFragment.access$getPhoneInput$p(this.a).getId()}, input.getErrorText(), null, 4, null);
        } else if (Intrinsics.areEqual(phoneInputState2, PhoneActionViewModel.PhoneInputState.NoInput.INSTANCE)) {
            Views.hide(PhoneActionFragment.access$getPhoneInput$p(this.a));
        }
    }
}
