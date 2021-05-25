package a2.a.a.n1.w0;

import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.location_picker.AddressByCoordinatesResult;
import io.reactivex.rxjava3.functions.Function;
import kotlin.NoWhenBranchMatchedException;
public final class b<T, R> implements Function<TypedResult<AddressByCoordinatesResult>, AddressByCoordinatesResult> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public AddressByCoordinatesResult apply(TypedResult<AddressByCoordinatesResult> typedResult) {
        TypedResult<AddressByCoordinatesResult> typedResult2 = typedResult;
        if (typedResult2 instanceof TypedResult.OfResult) {
            return (AddressByCoordinatesResult) ((TypedResult.OfResult) typedResult2).getResult();
        }
        if (typedResult2 instanceof TypedResult.OfError) {
            TypedResult.OfError ofError = (TypedResult.OfError) typedResult2;
            if (ofError.getError() instanceof ErrorResult.NetworkIOError) {
                return new AddressByCoordinatesResult.NetworkError();
            }
            return new AddressByCoordinatesResult.Error(ofError.getError().getMessage());
        }
        throw new NoWhenBranchMatchedException();
    }
}
