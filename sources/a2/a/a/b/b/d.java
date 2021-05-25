package a2.a.a.b.b;

import com.avito.android.account.Credentials;
import com.avito.android.authorization.auth.AuthPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<Credentials.PasswordCredentials> {
    public final /* synthetic */ AuthPresenterImpl.c a;

    public d(AuthPresenterImpl.c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Credentials.PasswordCredentials passwordCredentials) {
        Credentials.PasswordCredentials passwordCredentials2 = passwordCredentials;
        this.a.b.openLogin(passwordCredentials2.getUserName(), passwordCredentials2.getPassword());
    }
}
