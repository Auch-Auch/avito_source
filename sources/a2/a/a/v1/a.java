package a2.a.a.v1;

import com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState;
import com.avito.android.remote.model.SuccessResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<SuccessResult, PhoneConfirmationScreenState> {
    public final /* synthetic */ PhoneConfirmationScreenState a;

    public a(PhoneConfirmationScreenState phoneConfirmationScreenState) {
        this.a = phoneConfirmationScreenState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public PhoneConfirmationScreenState apply(SuccessResult successResult) {
        Intrinsics.checkNotNullParameter(successResult, "it");
        return PhoneConfirmationScreenState.copy$default(this.a, null, false, false, true, null, false, null, null, null, null, 599, null);
    }
}
