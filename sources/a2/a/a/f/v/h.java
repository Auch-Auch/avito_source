package a2.a.a.f.v;

import com.avito.android.advert.closed.ClosedAdvertPresenterImpl;
import com.avito.android.advert.closed.ClosedAdvertRouter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ ClosedAdvertPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(ClosedAdvertPresenterImpl closedAdvertPresenterImpl) {
        super(1);
        this.a = closedAdvertPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Unit unit) {
        ClosedAdvertRouter closedAdvertRouter = this.a.c;
        if (closedAdvertRouter != null) {
            closedAdvertRouter.closeScreen();
        }
        return Unit.INSTANCE;
    }
}
