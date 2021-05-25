package a2.a.a.e2.w;

import androidx.lifecycle.Observer;
import com.avito.android.publish.input_vin.InputVinFragment;
import com.avito.android.publish.input_vin.InputVinViewModel;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<InputVinViewModel.InputVinEvents> {
    public final /* synthetic */ InputVinFragment a;

    public b(InputVinFragment inputVinFragment) {
        this.a = inputVinFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(InputVinViewModel.InputVinEvents inputVinEvents) {
        InputVinViewModel.InputVinEvents inputVinEvents2 = inputVinEvents;
        if (Intrinsics.areEqual(inputVinEvents2, InputVinViewModel.InputVinEvents.ShowProgressDialog.INSTANCE)) {
            this.a.getLoadingProgress().showLoadingDialog();
        } else if (Intrinsics.areEqual(inputVinEvents2, InputVinViewModel.InputVinEvents.DismissProgressDialog.INSTANCE)) {
            this.a.getLoadingProgress().showContent();
        } else if (inputVinEvents2 instanceof InputVinViewModel.InputVinEvents.ShowErrorMessage) {
            this.a.getLoadingProgress().showErrorMessage(((InputVinViewModel.InputVinEvents.ShowErrorMessage) inputVinEvents2).getText());
        }
    }
}
