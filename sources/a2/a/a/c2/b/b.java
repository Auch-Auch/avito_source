package a2.a.a.c2.b;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.snackbar.Snackbar;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.profile_phones.R;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneFragment;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModel;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<ConfirmPhoneViewModel.ScreenState> {
    public final /* synthetic */ ConfirmPhoneFragment a;

    public b(ConfirmPhoneFragment confirmPhoneFragment) {
        this.a = confirmPhoneFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ConfirmPhoneViewModel.ScreenState screenState) {
        ConfirmPhoneViewModel.ScreenState screenState2 = screenState;
        if (screenState2 instanceof ConfirmPhoneViewModel.ScreenState.Ready) {
            ConfirmPhoneFragment.access$getCodeInput$p(this.a).setEnabled(true);
            ConfirmPhoneFragment.access$getCodeInput$p(this.a).setLoading(false);
            ConfirmPhoneFragment.access$getCodeInput$p(this.a).setState(Input.Companion.getSTATE_NORMAL());
            ConfirmPhoneFragment.access$getComponentContainer$p(this.a).setSubtitle(ConfirmPhoneFragment.access$getSubtitle(this.a, ((ConfirmPhoneViewModel.ScreenState.Ready) screenState2).getPhone()));
        } else if (Intrinsics.areEqual(screenState2, ConfirmPhoneViewModel.ScreenState.Progress.INSTANCE)) {
            ConfirmPhoneFragment.access$getCodeInput$p(this.a).setEnabled(false);
            ConfirmPhoneFragment.access$getCodeInput$p(this.a).setLoading(true);
        } else if (screenState2 instanceof ConfirmPhoneViewModel.ScreenState.InputError) {
            ConfirmPhoneFragment.access$getCodeInput$p(this.a).setEnabled(true);
            ConfirmPhoneFragment.access$getCodeInput$p(this.a).showKeyboard();
            ConfirmPhoneFragment.access$getCodeInput$p(this.a).setLoading(false);
            ConfirmPhoneViewModel.ScreenState.InputError inputError = (ConfirmPhoneViewModel.ScreenState.InputError) screenState2;
            if (inputError.getMessage() == null) {
                Context requireContext = this.a.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                String string = this.a.getString(R.string.phone_action_error);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.phone_action_error)");
                new Snackbar(requireContext, string).setType(SnackbarType.ERROR).setAnchorView(ConfirmPhoneFragment.access$getAnchorView$p(this.a)).setPosition(SnackbarPosition.BELOW_VIEW).show();
                return;
            }
            ConfirmPhoneFragment.access$getCodeInput$p(this.a).setState(Input.Companion.getSTATE_ERROR());
            ComponentContainer.showError$default(ConfirmPhoneFragment.access$getComponentContainer$p(this.a), new int[]{ConfirmPhoneFragment.access$getCodeInput$p(this.a).getId()}, inputError.getMessage(), null, 4, null);
        }
    }
}
