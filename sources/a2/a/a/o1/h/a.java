package a2.a.a.o1.h;

import io.reactivex.rxjava3.functions.Function;
import ru.avito.messenger.api.entity.ChatMessage;
public final class a<T, R> implements Function<ChatMessage, String> {
    public final /* synthetic */ String a;

    public a(String str) {
        this.a = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public String apply(ChatMessage chatMessage) {
        return this.a;
    }
}
