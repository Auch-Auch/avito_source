package a2.a.a.b2.e1;

import com.avito.android.profile.edit.SaveProfileInteractorImpl;
import com.avito.android.remote.model.AuthResult;
import com.avito.android.remote.model.Session;
import com.avito.android.util.preferences.SessionContract;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
public final class u<T, R> implements Function<Session, ObservableSource<? extends AuthResult>> {
    public final /* synthetic */ Map a;
    public final /* synthetic */ SaveProfileInteractorImpl b;
    public final /* synthetic */ String c;

    public u(Map map, SaveProfileInteractorImpl saveProfileInteractorImpl, String str, boolean z) {
        this.a = map;
        this.b = saveProfileInteractorImpl;
        this.c = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends AuthResult> apply(Session session) {
        Session session2 = session;
        Intrinsics.checkNotNullParameter(session2, SessionContract.SESSION);
        return InteropKt.toV2(this.b.a.registerSocial(session2.getSession(), this.b.a(this.a, 7), this.c, this.b.a(this.a, 5), true, this.b.b(this.a), SaveProfileInteractorImpl.access$getMetroValue(this.b, this.a), SaveProfileInteractorImpl.access$getDistrictValue(this.b, this.a)));
    }
}
