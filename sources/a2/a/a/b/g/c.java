package a2.a.a.b.g;

import com.avito.android.authorization.phone_proving.PhoneProvingPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<Throwable> {
    public final /* synthetic */ PhoneProvingPresenterImpl a;

    public c(PhoneProvingPresenterImpl phoneProvingPresenterImpl) {
        this.a = phoneProvingPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        PhoneProvingPresenterImpl phoneProvingPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "error");
        PhoneProvingPresenterImpl.access$handleError(phoneProvingPresenterImpl, th2);
    }
}
