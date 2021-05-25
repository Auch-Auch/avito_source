package a2.a.a.b2.e1;

import com.avito.android.profile.edit.ProfileSavingResult;
import com.avito.android.remote.model.SuccessResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class z<T, R> implements Function<SuccessResult, ProfileSavingResult> {
    public static final z a = new z();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ProfileSavingResult apply(SuccessResult successResult) {
        Intrinsics.checkNotNullParameter(successResult, "it");
        return new ProfileSavingResult.Completed();
    }
}
