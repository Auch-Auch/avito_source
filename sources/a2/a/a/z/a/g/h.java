package a2.a.a.z.a.g;

import arrow.core.Option;
import com.avito.android.push.PushToken;
import io.reactivex.rxjava3.functions.Function;
public final class h<T, R> implements Function<Option<? extends PushToken>, String> {
    public static final h a = new h();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public String apply(Option<? extends PushToken> option) {
        PushToken pushToken = (PushToken) option.orNull();
        return pushToken instanceof PushToken.GcmToken ? pushToken.getToken() : "";
    }
}
