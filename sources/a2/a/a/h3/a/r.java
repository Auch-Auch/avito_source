package a2.a.a.h3.a;

import com.avito.android.util.LoadingState;
import java.util.concurrent.Callable;
import kotlin.Unit;
public final class r<V> implements Callable<Unit> {
    public final /* synthetic */ s a;
    public final /* synthetic */ LoadingState b;

    public r(s sVar, LoadingState loadingState) {
        this.a = sVar;
        this.b = loadingState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Unit call() {
        this.a.a.O.startDeactivateAdvertDraw();
        this.a.a.d(((LoadingState.Error) this.b).getError());
        this.a.a.O.trackDeactivateAdvertDrawError();
        return Unit.INSTANCE;
    }
}
