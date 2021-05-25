package a2.a.a.c2.a;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.snackbar.Snackbar;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.profile_phones.R;
import com.avito.android.profile_phones.add_phone.AddPhoneFragment;
import com.avito.android.profile_phones.add_phone.AddPhoneViewModel;
import com.avito.android.util.Views;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<AddPhoneViewModel.ScreenState> {
    public final /* synthetic */ AddPhoneFragment a;

    public b(AddPhoneFragment addPhoneFragment) {
        this.a = addPhoneFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(AddPhoneViewModel.ScreenState screenState) {
        AddPhoneViewModel.ScreenState screenState2 = screenState;
        if (Intrinsics.areEqual(screenState2, AddPhoneViewModel.ScreenState.Loading.INSTANCE)) {
            AddPhoneFragment.access$getPhoneInput$p(this.a).setState(Input.Companion.getSTATE_NORMAL());
            Views.disable(AddPhoneFragment.access$getButton$p(this.a));
            AddPhoneFragment.access$getButton$p(this.a).setLoading(true);
        } else if (Intrinsics.areEqual(screenState2, AddPhoneViewModel.ScreenState.Ok.INSTANCE)) {
            AddPhoneFragment.access$getPhoneInput$p(this.a).setState(Input.Companion.getSTATE_NORMAL());
            Views.enable(AddPhoneFragment.access$getButton$p(this.a));
            AddPhoneFragment.access$getButton$p(this.a).setLoading(false);
        } else if (screenState2 instanceof AddPhoneViewModel.ScreenState.Error) {
            AddPhoneViewModel.ScreenState.Error error = (AddPhoneViewModel.ScreenState.Error) screenState2;
            if (error.getText() == null) {
                Context requireContext = this.a.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                String string = this.a.getString(R.string.phone_action_error);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.phone_action_error)");
                new Snackbar(requireContext, string).setType(SnackbarType.ERROR).setAnchorView(AddPhoneFragment.access$getAnchorView$p(this.a)).setPosition(SnackbarPosition.BELOW_VIEW).show();
            } else {
                ComponentContainer.showError$default(AddPhoneFragment.access$getComponentContainer$p(this.a), new int[]{AddPhoneFragment.access$getPhoneInput$p(this.a).getId()}, error.getText(), null, 4, null);
                AddPhoneFragment.access$getPhoneInput$p(this.a).setState(Input.Companion.getSTATE_ERROR());
            }
            Views.enable(AddPhoneFragment.access$getButton$p(this.a));
            AddPhoneFragment.access$getButton$p(this.a).setLoading(false);
        }
    }
}
