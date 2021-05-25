package a2.a.a.p0;

import com.avito.android.epress_cv.remote.model.CvResult;
import com.avito.android.express_cv.ExpressCvViewModelImpl;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.MessageEvent;
import io.reactivex.functions.Consumer;
public final class h<T> implements Consumer<LoadingState<? super CvResult>> {
    public final /* synthetic */ ExpressCvViewModelImpl a;

    public h(ExpressCvViewModelImpl expressCvViewModelImpl) {
        this.a = expressCvViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super CvResult> loadingState) {
        LoadingState<? super CvResult> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            ExpressCvViewModelImpl expressCvViewModelImpl = this.a;
            ExpressCvViewModelImpl.access$processCvResult(expressCvViewModelImpl, expressCvViewModelImpl.R.getActivatedCvDialogTitle(), this.a.R.getActivatedCvDescription(), ((CvResult) ((LoadingState.Loaded) loadingState2).getData()).getDeepLink());
        } else if (loadingState2 instanceof LoadingState.Error) {
            TypedError error = ((LoadingState.Error) loadingState2).getError();
            if (error instanceof ErrorWithMessage) {
                this.a.getMessageEvents().postValue(new MessageEvent(((ErrorWithMessage) error).getMessage()));
            }
        }
        this.a.i.postValue(loadingState2);
    }
}
