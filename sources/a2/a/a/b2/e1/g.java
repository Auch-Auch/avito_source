package a2.a.a.b2.e1;

import com.avito.android.profile.edit.ProfileSavingResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<Throwable, ProfileSavingResult.Failed> {
    public final /* synthetic */ Throwable a;

    public g(Throwable th) {
        this.a = th;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ProfileSavingResult.Failed apply(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return new ProfileSavingResult.Failed(this.a);
    }
}
