package a2.a.a.q3.f.q0;

import com.avito.android.util.LoadingState;
import com.avito.android.vas_performance.ui.applied_services.AppliedServicesViewModelImpl;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Consumer;
import java.util.List;
public final class j<T> implements Consumer<LoadingState.Loaded<List<? extends Item>>> {
    public final /* synthetic */ AppliedServicesViewModelImpl a;

    public j(AppliedServicesViewModelImpl appliedServicesViewModelImpl) {
        this.a = appliedServicesViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState.Loaded<List<? extends Item>> loaded) {
        this.a.c.postValue(loaded);
    }
}
