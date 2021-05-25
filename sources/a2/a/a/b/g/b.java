package a2.a.a.b.g;

import com.avito.android.authorization.phone_proving.PhoneProvingPresenterImpl;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class b<T> implements Consumer<Disposable> {
    public final /* synthetic */ PhoneProvingPresenterImpl a;

    public b(PhoneProvingPresenterImpl phoneProvingPresenterImpl) {
        this.a = phoneProvingPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        PhoneProvingPresenterImpl.access$handleResetPasswordStarted(this.a);
    }
}
