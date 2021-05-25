package a2.a.a.e2.d0.e;

import com.avito.android.publish.slots.contact_info.ContactInfoSlotWrapper;
import com.avito.android.remote.model.AuthResult;
import com.avito.android.remote.model.Profile;
import com.avito.android.util.ProfilesKt;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
public final class b<T, R> implements Function<AuthResult, ObservableSource<? extends Profile>> {
    public final /* synthetic */ d a;

    public b(d dVar) {
        this.a = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends Profile> apply(AuthResult authResult) {
        AuthResult authResult2 = authResult;
        ContactInfoSlotWrapper.access$setShouldRegisterUser$p(this.a.a, false);
        Profile profile = authResult2.getProfile();
        return ContactInfoSlotWrapper.access$getAccountStorageInteractor$p(this.a.a).save(ProfilesKt.toProfileInfo(profile), authResult2.getSession()).doOnComplete(new a(this, authResult2)).toSingleDefault(profile).toObservable();
    }
}
