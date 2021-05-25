package a2.a.a.v1;

import com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState;
import com.avito.android.util.AvitoResponseException;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<Throwable, PhoneConfirmationScreenState> {
    public final /* synthetic */ PhoneConfirmationScreenState a;

    public g(PhoneConfirmationScreenState phoneConfirmationScreenState) {
        this.a = phoneConfirmationScreenState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public PhoneConfirmationScreenState apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "it");
        if (!(th2 instanceof AvitoResponseException)) {
            return PhoneConfirmationScreenState.copy$default(this.a, null, false, false, false, null, true, null, null, null, null, 991, null);
        }
        PhoneConfirmationScreenState phoneConfirmationScreenState = this.a;
        String str = ((AvitoResponseException) th2).getError().simpleMessage;
        if (str == null) {
            str = "";
        }
        return PhoneConfirmationScreenState.copy$default(phoneConfirmationScreenState, null, false, false, false, null, false, str, null, null, null, 959, null);
    }
}
