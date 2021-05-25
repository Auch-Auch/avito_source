package a2.a.a.o1.d.a0.l;

import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsInteractorImpl;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.AvitoMessengerApi;
import t6.n.d;
public final class a<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends Map<String, ? extends List<? extends String>>>> {
    public final /* synthetic */ ChannelReplySuggestsInteractorImpl.c a;

    public a(ChannelReplySuggestsInteractorImpl.c cVar) {
        this.a = cVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends Map<String, ? extends List<? extends String>>> apply(AvitoMessengerApi avitoMessengerApi) {
        AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
        Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
        return avitoMessengerApi2.getReplySuggest(d.listOf(this.a.a.b)).subscribeOn(this.a.a.a);
    }
}
