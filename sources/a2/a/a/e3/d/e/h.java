package a2.a.a.e3.d.e;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModelImpl;
import io.reactivex.functions.Consumer;
public final class h<T> implements Consumer<DeepLink> {
    public final /* synthetic */ EditInfoViewModelImpl a;

    public h(EditInfoViewModelImpl editInfoViewModelImpl) {
        this.a = editInfoViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(DeepLink deepLink) {
        this.a.l.postValue(deepLink);
    }
}
