package a2.a.a.q3;

import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.util.LoadingState;
import com.avito.android.vas_performance.VisualVasViewModelImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<LoadingState<? super DeepLinkResponse>> {
    public final /* synthetic */ VisualVasViewModelImpl a;

    public b(VisualVasViewModelImpl visualVasViewModelImpl) {
        this.a = visualVasViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super DeepLinkResponse> loadingState) {
        LoadingState<? super DeepLinkResponse> loadingState2 = loadingState;
        VisualVasViewModelImpl visualVasViewModelImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
        VisualVasViewModelImpl.access$handleVasContextLoadingState(visualVasViewModelImpl, loadingState2);
    }
}
