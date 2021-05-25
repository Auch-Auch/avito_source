package a2.a.a.f.v;

import com.avito.android.advert.closed.ClosedAdvertPresenterImpl;
import com.avito.android.advert.closed.ClosedAdvertView;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class f<T> implements Consumer<Unit> {
    public final /* synthetic */ ClosedAdvertPresenterImpl a;

    public f(ClosedAdvertPresenterImpl closedAdvertPresenterImpl) {
        this.a = closedAdvertPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        ClosedAdvertView closedAdvertView = this.a.b;
        if (closedAdvertView != null) {
            this.a.a(closedAdvertView);
        }
    }
}
