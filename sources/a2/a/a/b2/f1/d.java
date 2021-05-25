package a2.a.a.b2.f1;

import com.avito.android.profile.password_change.PasswordChangeView;
import io.reactivex.functions.Action;
public final class d implements Action {
    public final /* synthetic */ g a;

    public d(g gVar) {
        this.a = gVar;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        PasswordChangeView passwordChangeView = this.a.a.a;
        if (passwordChangeView != null) {
            passwordChangeView.hideProgress();
        }
    }
}
