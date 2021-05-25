package a2.a.a.b2.e1;

import com.avito.android.profile.edit.ProfileSavingResult;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Unit, ProfileSavingResult> {
    public static final d a = new d();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ProfileSavingResult apply(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return new ProfileSavingResult.Completed();
    }
}
