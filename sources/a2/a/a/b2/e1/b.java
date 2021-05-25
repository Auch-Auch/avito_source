package a2.a.a.b2.e1;

import com.avito.android.profile.edit.ProfileSavingResult;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<ProfileSavingResult, ObservableSource<? extends ProfileSavingResult>> {
    public final /* synthetic */ Function1 a;

    public b(Function1 function1) {
        this.a = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends ProfileSavingResult> apply(ProfileSavingResult profileSavingResult) {
        ProfileSavingResult profileSavingResult2 = profileSavingResult;
        Intrinsics.checkNotNullParameter(profileSavingResult2, "result");
        if (profileSavingResult2 instanceof ProfileSavingResult.Completed) {
            return (Observable) this.a.invoke(profileSavingResult2);
        }
        Observable just = Observable.just(profileSavingResult2);
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
        return just;
    }
}
