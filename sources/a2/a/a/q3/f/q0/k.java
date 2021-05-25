package a2.a.a.q3.f.q0;

import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.util.LoadingState;
import com.avito.android.vas_performance.ui.applied_services.AppliedServicesViewModelImpl;
import io.reactivex.functions.Consumer;
public final class k<T> implements Consumer<Throwable> {
    public final /* synthetic */ AppliedServicesViewModelImpl a;

    public k(AppliedServicesViewModelImpl appliedServicesViewModelImpl) {
        this.a = appliedServicesViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        this.a.c.postValue(new LoadingState.Error(new ErrorWithMessage.SimpleMessageError(th.toString())));
    }
}
