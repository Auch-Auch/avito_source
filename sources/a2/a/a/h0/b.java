package a2.a.a.h0;

import com.avito.android.contact_access.ContactAccessPackagePresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ ContactAccessPackagePresenterImpl a;

    public b(ContactAccessPackagePresenterImpl contactAccessPackagePresenterImpl) {
        this.a = contactAccessPackagePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        this.a.e = null;
        ContactAccessPackagePresenterImpl contactAccessPackagePresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        ContactAccessPackagePresenterImpl.access$error(contactAccessPackagePresenterImpl, th2);
    }
}
