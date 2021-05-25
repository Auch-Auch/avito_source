package defpackage;

import com.avito.android.authorization.reset_password.StartRegistrationView;
import com.avito.android.authorization.start_registration.StartRegistrationPresenterImpl;
import io.reactivex.functions.Action;
/* compiled from: java-style lambda group */
/* renamed from: h1  reason: default package */
public final class h1 implements Action {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public h1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        int i = this.a;
        if (i == 0) {
            StartRegistrationPresenterImpl.access$clearFieldErrors((StartRegistrationPresenterImpl) this.b);
        } else if (i == 1) {
            StartRegistrationView startRegistrationView = ((StartRegistrationPresenterImpl) this.b).a;
            if (startRegistrationView != null) {
                startRegistrationView.hideProgress();
            }
        } else {
            throw null;
        }
    }
}
