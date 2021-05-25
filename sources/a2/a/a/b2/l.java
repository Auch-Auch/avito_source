package a2.a.a.b2;

import com.avito.android.profile.UserProfilePresenterImpl;
import com.avito.android.profile.UserProfileView;
import com.avito.android.remote.model.user_profile.Phone;
import com.avito.android.util.Maybies;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class l<T, R> implements Function<Unit, MaybeSource<? extends Unit>> {
    public final /* synthetic */ UserProfilePresenterImpl a;
    public final /* synthetic */ Phone b;
    public final /* synthetic */ UserProfileView c;

    public l(UserProfilePresenterImpl userProfilePresenterImpl, Phone phone, UserProfileView userProfileView) {
        this.a = userProfilePresenterImpl;
        this.b = phone;
        this.c = userProfileView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public MaybeSource<? extends Unit> apply(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return this.a.h.setPhoneForAllAdverts(this.b.getPhone()).observeOn(this.a.j.mainThread()).doOnSubscribe(new j(this)).doAfterTerminate(new k(this)).andThen(Maybies.toMaybe(Unit.INSTANCE));
    }
}
