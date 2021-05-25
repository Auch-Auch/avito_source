package a2.a.a.e2.w;

import com.avito.android.publish.input_vin.InputVinViewModel;
import com.avito.android.util.MultiStateLoading;
import io.reactivex.functions.Consumer;
public final class h<T> implements Consumer<MultiStateLoading.Loading> {
    public final /* synthetic */ InputVinViewModel a;

    public h(InputVinViewModel inputVinViewModel) {
        this.a = inputVinViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(MultiStateLoading.Loading loading) {
        this.a.d.setValue(InputVinViewModel.InputVinEvents.ShowProgressDialog.INSTANCE);
    }
}
