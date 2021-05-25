package a2.a.a.e;

import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.model.SocialAuthResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
public final class j<T, R> implements Function<TypedResult<SocialAuthResult>, LoadingState<? super SocialAuthResult>> {
    public static final j a = new j();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super SocialAuthResult> apply(TypedResult<SocialAuthResult> typedResult) {
        TypedResult<SocialAuthResult> typedResult2 = typedResult;
        if (typedResult2 instanceof TypedResult.OfResult) {
            TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult2;
            SocialAuthResult socialAuthResult = (SocialAuthResult) ofResult.getResult();
            if (socialAuthResult instanceof SocialAuthResult.Ok) {
                return new LoadingState.Loaded(ofResult.getResult());
            }
            if (socialAuthResult instanceof SocialAuthResult.AccountSuggest) {
                return new LoadingState.Loaded(ofResult.getResult());
            }
            if (socialAuthResult instanceof SocialAuthResult.WrongSocialUser) {
                Object result = ofResult.getResult();
                Objects.requireNonNull(result, "null cannot be cast to non-null type com.avito.android.remote.model.SocialAuthResult.WrongSocialUser");
                return new LoadingState.Error(new ErrorWithMessage.ErrorDialog(((SocialAuthResult.WrongSocialUser) result).getUserDialog()));
            }
            throw new NoWhenBranchMatchedException();
        } else if (typedResult2 instanceof TypedResult.OfError) {
            return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
