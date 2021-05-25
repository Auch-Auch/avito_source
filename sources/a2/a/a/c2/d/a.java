package a2.a.a.c2.d;

import android.content.Intent;
import androidx.lifecycle.Observer;
import com.avito.android.profile_phones.phone_action.PhoneActionFragment;
import com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModel;
import com.avito.android.ui.fragments.TabBaseFragment;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Observer<PhoneActionViewModel.Navigation> {
    public final /* synthetic */ PhoneActionFragment a;

    public a(PhoneActionFragment phoneActionFragment) {
        this.a = phoneActionFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(PhoneActionViewModel.Navigation navigation) {
        PhoneActionViewModel.Navigation navigation2 = navigation;
        if (navigation2 instanceof PhoneActionViewModel.Navigation.FinishWithSuccess) {
            Intent intent = new Intent();
            intent.putExtra("result_message", ((PhoneActionViewModel.Navigation.FinishWithSuccess) navigation2).getMessage());
            this.a.setResult(-1, intent);
            this.a.finish();
        } else if (Intrinsics.areEqual(navigation2, PhoneActionViewModel.Navigation.FinishWithCancel.INSTANCE)) {
            TabBaseFragment.setResult$default(this.a, 0, null, 2, null);
            this.a.finish();
        }
    }
}
