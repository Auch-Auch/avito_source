package a2.a.a.o1.d.a0.f;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.CreateFileResponse;
public final class c<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends CreateFileResponse>> {
    public final /* synthetic */ String a;

    public c(String str) {
        this.a = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends CreateFileResponse> apply(AvitoMessengerApi avitoMessengerApi) {
        AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
        Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
        return avitoMessengerApi2.createFile(this.a);
    }
}
