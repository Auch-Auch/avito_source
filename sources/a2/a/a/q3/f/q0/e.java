package a2.a.a.q3.f.q0;

import com.avito.android.remote.model.vas.applied.AppliedVasResult;
import com.avito.android.util.LoadingState;
import com.avito.android.vas_performance.ui.applied_services.AppliedServicesViewModelImpl;
import io.reactivex.functions.Consumer;
public final class e<T> implements Consumer<LoadingState<? super AppliedVasResult>> {
    public final /* synthetic */ AppliedServicesViewModelImpl a;

    public e(AppliedServicesViewModelImpl appliedServicesViewModelImpl) {
        this.a = appliedServicesViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super AppliedVasResult> loadingState) {
        this.a.c.postValue(loadingState);
    }
}
