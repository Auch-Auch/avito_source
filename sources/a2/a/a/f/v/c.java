package a2.a.a.f.v;

import com.avito.android.advert.closed.ClosedAdvertPresenterImpl;
import com.avito.android.advert.closed.ClosedAdvertView;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<Throwable> {
    public final /* synthetic */ ClosedAdvertPresenterImpl a;
    public final /* synthetic */ ClosedAdvertView b;

    public c(ClosedAdvertPresenterImpl closedAdvertPresenterImpl, ClosedAdvertView closedAdvertView) {
        this.a = closedAdvertPresenterImpl;
        this.b = closedAdvertView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        ClosedAdvertPresenterImpl closedAdvertPresenterImpl = this.a;
        ClosedAdvertView closedAdvertView = this.b;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        ClosedAdvertPresenterImpl.access$showError(closedAdvertPresenterImpl, closedAdvertView, th2);
    }
}
