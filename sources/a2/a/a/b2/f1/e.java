package a2.a.a.b2.f1;

import com.avito.android.account.Credentials;
import com.avito.android.profile.password_change.PasswordChangeView;
import io.reactivex.functions.Consumer;
public final class e<T> implements Consumer<Credentials.PasswordCredentials> {
    public final /* synthetic */ g a;

    public e(g gVar) {
        this.a = gVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Credentials.PasswordCredentials passwordCredentials) {
        PasswordChangeView passwordChangeView;
        Credentials.PasswordCredentials passwordCredentials2 = passwordCredentials;
        this.a.a.i = passwordCredentials2.getUserName();
        PasswordChangeView passwordChangeView2 = this.a.a.a;
        if (passwordChangeView2 != null) {
            passwordChangeView2.fillOldPassword(passwordCredentials2.getPassword());
        }
        if (!this.a.a.t.isSessionsFlow() && (passwordChangeView = this.a.a.a) != null) {
            passwordChangeView.highlightNewPassword();
        }
    }
}
