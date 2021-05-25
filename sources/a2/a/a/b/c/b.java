package a2.a.a.b.c;

import com.avito.android.authorization.complete_registration.CompleteRegistrationPresenterImpl;
import io.reactivex.functions.Action;
public final class b implements Action {
    public final /* synthetic */ CompleteRegistrationPresenterImpl.c a;

    public b(CompleteRegistrationPresenterImpl.c cVar) {
        this.a = cVar;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        CompleteRegistrationPresenterImpl.access$hideProgress(this.a.a);
    }
}
