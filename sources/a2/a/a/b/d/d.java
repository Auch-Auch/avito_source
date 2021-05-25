package a2.a.a.b.d;

import com.avito.android.authorization.login.LoginPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class d<T> implements Consumer<Unit> {
    public final /* synthetic */ LoginPresenterImpl.c a;

    public d(LoginPresenterImpl.c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        this.a.b.completeLogin();
    }
}
