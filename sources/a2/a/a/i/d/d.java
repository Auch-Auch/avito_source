package a2.a.a.i.d;

import com.avito.android.analytics.clickstream.ClickStreamSender;
import io.reactivex.functions.Function;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Throwable, ClickStreamSender.UploadResult> {
    public static final d a = new d();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ClickStreamSender.UploadResult apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "error");
        if (th2 instanceof IOException) {
            return new ClickStreamSender.UploadResult.RecoverableError(th2);
        }
        return new ClickStreamSender.UploadResult.UnrecoverableError(th2);
    }
}
