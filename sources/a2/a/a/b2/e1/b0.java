package a2.a.a.b2.e1;

import com.avito.android.profile.edit.ProfileSavingResult;
import com.avito.android.profile.edit.SaveProfileInteractorImpl;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class b0<T, R> implements Function<ProfileSavingResult, ObservableSource<? extends ProfileSavingResult>> {
    public final /* synthetic */ SaveProfileInteractorImpl a;
    public final /* synthetic */ String b;

    public b0(SaveProfileInteractorImpl saveProfileInteractorImpl, String str) {
        this.a = saveProfileInteractorImpl;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: io.reactivex.Completable */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends ProfileSavingResult> apply(ProfileSavingResult profileSavingResult) {
        ProfileSavingResult profileSavingResult2 = profileSavingResult;
        Intrinsics.checkNotNullParameter(profileSavingResult2, "result");
        return InteropKt.toV2(SaveProfileInteractorImpl.access$getAccountStorageInteractor$p(this.a).profileInfo()).firstOrError().flatMapCompletable(new a0(this)).toSingleDefault(profileSavingResult2).toObservable();
    }
}
