package a2.a.a.v1;

import com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTime;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<PhoneConfirmationTime, PhoneConfirmationScreenState> {
    public final /* synthetic */ PhoneConfirmationScreenState a;

    public f(PhoneConfirmationScreenState phoneConfirmationScreenState) {
        this.a = phoneConfirmationScreenState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public PhoneConfirmationScreenState apply(PhoneConfirmationTime phoneConfirmationTime) {
        PhoneConfirmationTime phoneConfirmationTime2 = phoneConfirmationTime;
        Intrinsics.checkNotNullParameter(phoneConfirmationTime2, "it");
        return new PhoneConfirmationScreenState(this.a.getPhone(), this.a.isCompany(), true, false, phoneConfirmationTime2, false, null, null, null, null, 1000, null);
    }
}
