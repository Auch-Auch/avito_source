package a2.a.a.i.j;

import com.avito.android.analytics.inhouse_transport.UploadResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
public final class c<T, R> implements Function<ResponseBody, UploadResult> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public UploadResult apply(ResponseBody responseBody) {
        Intrinsics.checkNotNullParameter(responseBody, "it");
        return new UploadResult.Success();
    }
}
