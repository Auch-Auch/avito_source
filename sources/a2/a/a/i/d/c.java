package a2.a.a.i.d;

import com.avito.android.analytics.clickstream.ClickStreamSender;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
public final class c<T, R> implements Function<ResponseBody, ClickStreamSender.UploadResult> {
    public final /* synthetic */ List a;

    public c(List list) {
        this.a = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ClickStreamSender.UploadResult apply(ResponseBody responseBody) {
        Intrinsics.checkNotNullParameter(responseBody, "it");
        return new ClickStreamSender.UploadResult.Success(this.a);
    }
}
