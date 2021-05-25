package a2.a.a.e2.e0;

import com.avito.android.remote.model.PublishDraftResponse;
import io.reactivex.rxjava3.functions.Function;
public final class e<T, R> implements Function<Throwable, PublishDraftResponse> {
    public static final e a = new e();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public PublishDraftResponse apply(Throwable th) {
        return PublishDraftResponse.NotFound.INSTANCE;
    }
}
