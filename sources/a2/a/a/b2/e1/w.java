package a2.a.a.b2.e1;

import com.avito.android.profile.edit.SaveProfileInteractorImpl;
import com.avito.android.remote.model.AuthResult;
import com.avito.android.remote.model.Profile;
import com.avito.android.util.ProfilesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class w<T, R> implements Function<AuthResult, ObservableSource<? extends Profile>> {
    public final /* synthetic */ SaveProfileInteractorImpl a;

    public w(SaveProfileInteractorImpl saveProfileInteractorImpl, String str, boolean z) {
        this.a = saveProfileInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends Profile> apply(AuthResult authResult) {
        AuthResult authResult2 = authResult;
        Intrinsics.checkNotNullParameter(authResult2, "authResult");
        Profile profile = authResult2.getProfile();
        return InteropKt.toV2(this.a.b.save(ProfilesKt.toProfileInfo(profile), authResult2.getSession())).doOnComplete(new v(this, authResult2)).toSingleDefault(profile).toObservable();
    }
}
