package a2.a.a.c2.e;

import com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class f<T> implements Consumer<Throwable> {
    public final /* synthetic */ PhoneManagementPresenterImpl a;

    public f(PhoneManagementPresenterImpl phoneManagementPresenterImpl) {
        this.a = phoneManagementPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        PhoneManagementPresenterImpl phoneManagementPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        PhoneManagementPresenterImpl.access$handleRequestError(phoneManagementPresenterImpl, th2);
    }
}
