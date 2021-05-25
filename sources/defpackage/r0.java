package defpackage;

import com.avito.android.authorization.phone_proving.PhoneProvingPresenterImpl;
import com.avito.android.authorization.phone_proving.PhoneProvingView;
import io.reactivex.functions.Action;
/* compiled from: java-style lambda group */
/* renamed from: r0  reason: default package */
public final class r0 implements Action {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public r0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        int i = this.a;
        if (i == 0) {
            PhoneProvingView phoneProvingView = ((PhoneProvingPresenterImpl) this.b).a;
            if (phoneProvingView != null) {
                phoneProvingView.hideProgress();
            }
        } else if (i == 1) {
            PhoneProvingPresenterImpl.access$handlePhoneProvingCompleted((PhoneProvingPresenterImpl) this.b);
        } else {
            throw null;
        }
    }
}
