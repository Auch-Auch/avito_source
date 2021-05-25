package a2.a.a.e3.d.e;

import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModelImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class s<T> implements Consumer<Throwable> {
    public final /* synthetic */ EditInfoViewModelImpl a;

    public s(EditInfoViewModelImpl editInfoViewModelImpl) {
        this.a = editInfoViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        this.a.k.setValue(new LoadingState.Error(new ErrorWithMessage.Unknown("", th2)));
    }
}
