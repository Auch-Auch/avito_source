package a2.a.a.c2.d;

import androidx.lifecycle.Observer;
import com.avito.android.profile_phones.phone_action.PhoneActionFragment;
import com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModel;
import com.avito.android.util.Views;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<PhoneActionViewModel.ScreenState> {
    public final /* synthetic */ PhoneActionFragment a;

    public b(PhoneActionFragment phoneActionFragment) {
        this.a = phoneActionFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(PhoneActionViewModel.ScreenState screenState) {
        PhoneActionViewModel.ScreenState screenState2 = screenState;
        if (screenState2 instanceof PhoneActionViewModel.ScreenState.Initial) {
            PhoneActionViewModel.ScreenState.Initial initial = (PhoneActionViewModel.ScreenState.Initial) screenState2;
            PhoneActionFragment.access$getAppBarLayout$p(this.a).setTitle(initial.getTitle());
            PhoneActionFragment.access$getAppBarLayout$p(this.a).setShortTitle(initial.getTitle());
            PhoneActionFragment.access$getComponentContainer$p(this.a).setSubtitle(initial.getMessage());
            PhoneActionFragment.access$getButton$p(this.a).setText(initial.getButtonText());
            Views.enable(PhoneActionFragment.access$getButton$p(this.a));
            PhoneActionFragment.access$getButton$p(this.a).setLoading(false);
        } else if (Intrinsics.areEqual(screenState2, PhoneActionViewModel.ScreenState.Loading.INSTANCE)) {
            Views.disable(PhoneActionFragment.access$getButton$p(this.a));
            PhoneActionFragment.access$getButton$p(this.a).setLoading(true);
        }
    }
}
