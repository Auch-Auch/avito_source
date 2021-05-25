package a2.a.a.n1.w0;

import com.avito.android.remote.model.location_picker.AddressSuggestionResult;
import io.reactivex.rxjava3.functions.Function;
public final class e<T, R> implements Function<Throwable, AddressSuggestionResult> {
    public static final e a = new e();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public AddressSuggestionResult apply(Throwable th) {
        return new AddressSuggestionResult.NetworkError();
    }
}
