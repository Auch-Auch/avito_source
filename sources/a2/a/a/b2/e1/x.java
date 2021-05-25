package a2.a.a.b2.e1;

import com.avito.android.profile.edit.SaveProfileInteractorImpl;
import com.avito.android.remote.model.Profile;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class x<T, R> implements Function<Profile, ObservableSource<? extends Boolean>> {
    public final /* synthetic */ SaveProfileInteractorImpl a;
    public final /* synthetic */ String b;

    public x(SaveProfileInteractorImpl saveProfileInteractorImpl, String str, boolean z) {
        this.a = saveProfileInteractorImpl;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends Boolean> apply(Profile profile) {
        Intrinsics.checkNotNullParameter(profile, "it");
        return SaveProfileInteractorImpl.access$checkPhoneNumber(this.a, this.b);
    }
}
