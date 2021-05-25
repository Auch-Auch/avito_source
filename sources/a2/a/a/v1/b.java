package a2.a.a.v1;

import com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState;
import com.avito.android.util.AvitoResponseException;
import com.avito.android.util.ForbiddenException;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<Throwable, PhoneConfirmationScreenState> {
    public final /* synthetic */ PhoneConfirmationScreenState a;

    public b(PhoneConfirmationScreenState phoneConfirmationScreenState) {
        this.a = phoneConfirmationScreenState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public PhoneConfirmationScreenState apply(Throwable th) {
        String str;
        String str2;
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "it");
        if (th2 instanceof ForbiddenException) {
            PhoneConfirmationScreenState phoneConfirmationScreenState = this.a;
            String str3 = ((ForbiddenException) th2).getError().simpleMessage;
            if (str3 != null) {
                str2 = str3;
            } else {
                str2 = "";
            }
            return PhoneConfirmationScreenState.copy$default(phoneConfirmationScreenState, null, false, false, false, null, false, null, null, str2, null, 767, null);
        } else if (!(th2 instanceof AvitoResponseException)) {
            return PhoneConfirmationScreenState.copy$default(this.a, null, false, false, false, null, true, null, null, null, null, 991, null);
        } else {
            PhoneConfirmationScreenState phoneConfirmationScreenState2 = this.a;
            String str4 = ((AvitoResponseException) th2).getError().simpleMessage;
            if (str4 != null) {
                str = str4;
            } else {
                str = "";
            }
            return PhoneConfirmationScreenState.copy$default(phoneConfirmationScreenState2, null, false, false, false, null, false, null, str, null, null, 895, null);
        }
    }
}
