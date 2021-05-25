package a2.a.a.e;

import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.LoginResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import kotlin.NoWhenBranchMatchedException;
public final class i<T, R> implements Function<TypedResult<LoginResult>, LoadingState<? super LoginResult>> {
    public static final i a = new i();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super LoginResult> apply(TypedResult<LoginResult> typedResult) {
        LoadingState.Error error;
        TypedResult<LoginResult> typedResult2 = typedResult;
        if (typedResult2 instanceof TypedResult.OfError) {
            return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
        }
        if (typedResult2 instanceof TypedResult.OfResult) {
            TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult2;
            LoginResult loginResult = (LoginResult) ofResult.getResult();
            if (loginResult instanceof LoginResult.Ok) {
                return new LoadingState.Loaded(ofResult.getResult());
            }
            if (loginResult instanceof LoginResult.AntihackCheck) {
                return new LoadingState.Loaded(ofResult.getResult());
            }
            if (loginResult instanceof LoginResult.AntihackCheckPhone) {
                return new LoadingState.Loaded(ofResult.getResult());
            }
            if (loginResult instanceof LoginResult.NeedPhoneVerification) {
                return new LoadingState.Loaded(ofResult.getResult());
            }
            if (loginResult instanceof LoginResult.TfaCheck) {
                return new LoadingState.Loaded(ofResult.getResult());
            }
            if (loginResult instanceof LoginResult.FailedWithMessage) {
                error = new LoadingState.Error(new ErrorWithMessage.SimpleMessageError(((LoginResult.FailedWithMessage) loginResult).getMessage()));
            } else if (loginResult instanceof LoginResult.FailedWithMessages) {
                error = new LoadingState.Error(new TypedError.ErrorMap(((LoginResult.FailedWithMessages) loginResult).getMessages()));
            } else if (loginResult instanceof LoginResult.FailedWithDialog) {
                error = new LoadingState.Error(new ErrorWithMessage.ErrorDialog(((LoginResult.FailedWithDialog) loginResult).getUserDialog()));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return error;
        }
        throw new NoWhenBranchMatchedException();
    }
}
