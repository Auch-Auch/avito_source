package a2.a.a.b.c;

import com.avito.android.authorization.complete_registration.CompleteRegistrationPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class c<T> implements Consumer<Unit> {
    public final /* synthetic */ CompleteRegistrationPresenterImpl.c a;

    public c(CompleteRegistrationPresenterImpl.c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        this.a.b.completeRegistration();
    }
}
