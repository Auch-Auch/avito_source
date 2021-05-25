package a2.a.a.h3.a;

import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import java.util.concurrent.Callable;
import kotlin.Unit;
public final class n<V> implements Callable<Unit> {
    public final /* synthetic */ o a;

    public n(o oVar) {
        this.a = oVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Unit call() {
        o oVar = this.a;
        MyAdvertDetailsPresenterImpl.access$share(oVar.a, oVar.c);
        return Unit.INSTANCE;
    }
}
