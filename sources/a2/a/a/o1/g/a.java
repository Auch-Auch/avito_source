package a2.a.a.o1.g;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.ChannelsCounters;
public final class a<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends ChannelsCounters>> {
    public static final a a = new a();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends ChannelsCounters> apply(AvitoMessengerApi avitoMessengerApi) {
        AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
        Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
        return avitoMessengerApi2.getChatCounters();
    }
}
