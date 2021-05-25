package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolverImpl;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.AvitoMessengerApi;
public final class d<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends Map<String, ? extends String>>> {
    public final /* synthetic */ List a;
    public final /* synthetic */ MessageBodyResolverImpl b;

    public d(List list, MessageBodyResolverImpl messageBodyResolverImpl) {
        this.a = list;
        this.b = messageBodyResolverImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends Map<String, ? extends String>> apply(AvitoMessengerApi avitoMessengerApi) {
        AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
        Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
        return avitoMessengerApi2.getUnknownMessageBodies(this.a).subscribeOn(this.b.c.io());
    }
}
