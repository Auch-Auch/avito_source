package a2.a.a.q0;

import com.avito.android.extended_profile.ExtendedProfileViewModelImpl;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class w<T> implements Consumer<Disposable> {
    public final /* synthetic */ ExtendedProfileViewModelImpl a;

    public w(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        this.a = extendedProfileViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        ExtendedProfileViewModelImpl.access$showProgressAsDialog(this.a);
    }
}
