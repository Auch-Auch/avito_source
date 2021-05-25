package a2.a.a.d.a;

import com.avito.android.abuse.details.AbuseDetailsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<Throwable> {
    public final /* synthetic */ AbuseDetailsPresenterImpl a;

    public c(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl) {
        this.a = abuseDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        AbuseDetailsPresenterImpl abuseDetailsPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        AbuseDetailsPresenterImpl.access$handleSendingError(abuseDetailsPresenterImpl, th2);
    }
}
