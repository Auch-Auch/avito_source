package a2.a.a.s.a.a;

import androidx.lifecycle.Observer;
import com.avito.android.beduin.ui.fragment.BeduinFragment;
import com.avito.android.beduin.ui.viewmodel.BeduinViewModel;
import com.avito.android.util.LoadingState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Observer<LoadingState<? super BeduinViewModel.BeduinScreen>> {
    public final /* synthetic */ BeduinFragment a;

    public a(BeduinFragment beduinFragment) {
        this.a = beduinFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<? super BeduinViewModel.BeduinScreen> loadingState) {
        LoadingState<? super BeduinViewModel.BeduinScreen> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            BeduinFragment.access$getProgressOverlay$p(this.a).showContent();
            BeduinFragment.access$getToolbar$p(this.a).setTitle(((BeduinViewModel.BeduinScreen) ((LoadingState.Loaded) loadingState2).getData()).getTitle());
        } else if (Intrinsics.areEqual(loadingState2, LoadingState.Loading.INSTANCE)) {
            BeduinFragment.access$getProgressOverlay$p(this.a).showLoading();
        } else if (loadingState2 instanceof LoadingState.Error) {
            BeduinFragment.access$getProgressOverlay$p(this.a).showLoadingProblem(BeduinFragment.access$toErrorMessage(this.a, ((LoadingState.Error) loadingState2).getError()));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
