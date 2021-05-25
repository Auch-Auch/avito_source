package a2.a.a.a1;

import com.avito.android.home.HomePresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class r<T> implements Consumer<Unit> {
    public final /* synthetic */ HomePresenterImpl a;

    public r(HomePresenterImpl homePresenterImpl) {
        this.a = homePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        if (this.a.h == null || Intrinsics.areEqual(this.a.h, Boolean.TRUE)) {
            this.a.p();
        }
    }
}
