package a2.a.a.e2.e0;

import com.avito.android.publish.start_publish.StartPublishViewModel;
import io.reactivex.rxjava3.functions.Consumer;
public final class g<T> implements Consumer<Throwable> {
    public final /* synthetic */ StartPublishViewModel a;

    public g(StartPublishViewModel startPublishViewModel) {
        this.a = startPublishViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        this.a.d.setValue(new StartPublishViewModel.State.Error(this.a.k.getNetworkErrorMessage()));
    }
}
