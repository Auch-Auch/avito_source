package a2.a.a.f1.f;

import com.avito.android.in_app_calls.service.CallManagerServiceDelegate;
import io.reactivex.functions.Action;
public final class h implements Action {
    public final /* synthetic */ i a;

    public h(i iVar) {
        this.a = iVar;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.a.a.a.getReducerQueue().plusAssign(new CallManagerServiceDelegate.i(this.a.a.a));
    }
}
