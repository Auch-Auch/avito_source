package a2.a.a.t1.g;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.payment.webview.WebPaymentResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<DeepLink, WebPaymentResult.Finished> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public WebPaymentResult.Finished apply(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        Intrinsics.checkNotNullParameter(deepLink2, "it");
        return new WebPaymentResult.Finished(deepLink2);
    }
}
