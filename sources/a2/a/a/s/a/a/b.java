package a2.a.a.s.a.a;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.beduin.R;
import com.avito.android.beduin.ui.fragment.BeduinFragment;
import com.avito.android.beduin.ui.viewmodel.BeduinViewModel;
import com.avito.android.util.ToastsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<BeduinViewModel.BeduinEvent> {
    public final /* synthetic */ BeduinFragment a;

    public b(BeduinFragment beduinFragment) {
        this.a = beduinFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(BeduinViewModel.BeduinEvent beduinEvent) {
        BeduinViewModel.BeduinEvent beduinEvent2 = beduinEvent;
        if (beduinEvent2 != null) {
            int ordinal = beduinEvent2.ordinal();
            if (ordinal == 0) {
                FragmentActivity requireActivity = this.a.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                ToastsKt.showToast$default(requireActivity, R.string.update_app_error, 0, 2, (Object) null);
                return;
            } else if (ordinal == 1) {
                FragmentActivity requireActivity2 = this.a.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                ToastsKt.showToast$default(requireActivity2, R.string.general_beduin_error, 0, 2, (Object) null);
                return;
            }
        }
        throw new NoWhenBranchMatchedException();
    }
}
