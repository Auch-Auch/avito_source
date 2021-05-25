package a2.a.a.b2.e1;

import com.avito.android.remote.model.AuthResult;
import io.reactivex.functions.Action;
public final class v implements Action {
    public final /* synthetic */ w a;
    public final /* synthetic */ AuthResult b;

    public v(w wVar, AuthResult authResult) {
        this.a = wVar;
        this.b = authResult;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.a.a.c.trackSessionUpdate(this.b.getSession(), "profile");
    }
}
