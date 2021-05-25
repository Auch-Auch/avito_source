package a2.a.a.c2.c;

import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationInteractor;
import com.avito.android.remote.model.LandlinePhoneVerificationStatusResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.rx3.Singles;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Throwable, SingleSource<? extends TypedResult<LandlinePhoneVerificationStatusResult>>> {
    public final /* synthetic */ LandlinePhoneVerificationInteractor.a a;

    public d(LandlinePhoneVerificationInteractor.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends TypedResult<LandlinePhoneVerificationStatusResult>> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "error");
        return Singles.toSingle((Throwable) new TypedResultException(this.a.a.c.convert(th2)));
    }
}
