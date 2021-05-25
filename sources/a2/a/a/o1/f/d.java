package a2.a.a.o1.f;

import com.avito.android.messenger.search.ChannelsSearchInteractorImpl;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.ChannelsSearchResponse;
public final class d<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends ChannelsSearchResponse>> {
    public final /* synthetic */ ChannelsSearchInteractorImpl.e a;

    public d(ChannelsSearchInteractorImpl.e eVar) {
        this.a = eVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends ChannelsSearchResponse> apply(AvitoMessengerApi avitoMessengerApi) {
        AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
        Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
        return avitoMessengerApi2.searchChats(0, 10, this.a.c.getText()).subscribeOn(this.a.d.getSchedulers().computation());
    }
}
