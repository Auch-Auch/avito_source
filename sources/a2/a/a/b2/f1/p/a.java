package a2.a.a.b2.f1.p;

import com.avito.android.profile.password_change.business.PasswordChangeInteractorImpl;
import com.avito.android.remote.model.Session;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.password.PasswordChangeResult;
import com.avito.android.util.preferences.Preference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
public final class a extends Lambda implements Function0<Session> {
    public final /* synthetic */ PasswordChangeInteractorImpl.b a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ String c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(PasswordChangeInteractorImpl.b bVar, Ref.ObjectRef objectRef, String str) {
        super(0);
        this.a = bVar;
        this.b = objectRef;
        this.c = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Session invoke() {
        Ref.ObjectRef objectRef = this.b;
        PasswordChangeInteractorImpl.b bVar = this.a;
        objectRef.element = (T) PasswordChangeInteractorImpl.access$changePasswordSync(bVar.a, bVar.b, bVar.c, this.c, bVar.d, bVar.e);
        T t = this.b.element;
        if (!(t instanceof TypedResult.OfResult)) {
            t = null;
        }
        if (t == null) {
            return null;
        }
        T t2 = t;
        Session session = new Session(((PasswordChangeResult) t2.getResult()).getSession(), ((PasswordChangeResult) t2.getResult()).getRefreshToken(), ((PasswordChangeResult) t2.getResult()).getPushToken());
        this.a.a.c.trackSessionUpdate(session, Preference.PASSWORD);
        return session;
    }
}
