package a2.a.a.q3.f.q0;

import androidx.lifecycle.Observer;
import com.avito.android.util.LoadingState;
import com.avito.android.vas_performance.ui.applied_services.AppliedServiceListener;
import com.avito.android.vas_performance.ui.applied_services.AppliedServicesDialogFragment;
import java.util.List;
import java.util.Objects;
public final class d<T> implements Observer<LoadingState<?>> {
    public final /* synthetic */ AppliedServicesDialogFragment a;

    public d(AppliedServicesDialogFragment appliedServicesDialogFragment) {
        this.a = appliedServicesDialogFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(LoadingState<?> loadingState) {
        AppliedServiceListener appliedServiceListener;
        LoadingState<?> loadingState2 = loadingState;
        if (loadingState2 == null) {
            return;
        }
        if (loadingState2 instanceof LoadingState.Loaded) {
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
            if (loaded.getData() instanceof List) {
                AppliedServicesDialogFragment appliedServicesDialogFragment = this.a;
                Object data = loaded.getData();
                Objects.requireNonNull(data, "null cannot be cast to non-null type kotlin.collections.List<com.avito.konveyor.blueprint.Item>");
                AppliedServicesDialogFragment.access$showList(appliedServicesDialogFragment, (List) data);
            }
        } else if (loadingState2 instanceof LoadingState.Error) {
            AppliedServiceListener appliedServiceListener2 = this.a.b;
            if (appliedServiceListener2 != null) {
                appliedServiceListener2.closeWithError();
            }
        } else if ((loadingState2 instanceof LoadingState.Loading) && (appliedServiceListener = this.a.b) != null) {
            appliedServiceListener.showProgress();
        }
    }
}
