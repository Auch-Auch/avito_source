package a2.a.a.b.a;

import com.avito.android.account.Credentials;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.authorization.smart_lock.SmartLockLoaderImpl;
import com.google.android.gms.auth.api.credentials.Credential;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
public final class d<T, R> implements Function<Credential, MaybeSource<? extends Credentials.PasswordCredentials>> {
    public final /* synthetic */ SmartLockLoaderImpl a;
    public final /* synthetic */ boolean b;

    public d(SmartLockLoaderImpl smartLockLoaderImpl, boolean z) {
        this.a = smartLockLoaderImpl;
        this.b = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public MaybeSource<? extends Credentials.PasswordCredentials> apply(Credential credential) {
        Credential credential2 = credential;
        if (credential2 == null) {
            return null;
        }
        if (this.b) {
            return this.a.run(new SmartLockLoader.Command.Finish(credential2));
        }
        SmartLockLoader.Command.Confirm confirm = new SmartLockLoader.Command.Confirm(credential2);
        this.a.a = confirm;
        return this.a.run(confirm);
    }
}
