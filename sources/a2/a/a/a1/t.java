package a2.a.a.a1;

import com.avito.android.home.HomePresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class t<T> implements Consumer<Unit> {
    public final /* synthetic */ HomePresenterImpl a;

    public t(HomePresenterImpl homePresenterImpl) {
        this.a = homePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        this.a.onResetPageState();
    }
}
