package a2.a.a.n2;

import com.avito.android.serp.SerpPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class t<T> implements Consumer<Throwable> {
    public final /* synthetic */ SerpPresenterImpl a;

    public t(SerpPresenterImpl serpPresenterImpl) {
        this.a = serpPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        this.a.s = false;
        int page = this.a.k.getPage();
        this.a.h0.trackAdvertsErrorPrepare(page);
        this.a.h0.trackAdvertsErrorDraw(page);
        SerpPresenterImpl serpPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        SerpPresenterImpl.access$onFatalErrorReceived(serpPresenterImpl, th2);
    }
}
