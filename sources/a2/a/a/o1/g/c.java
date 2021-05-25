package a2.a.a.o1.g;

import com.avito.android.remote.model.messenger.UnreadMessagesCounter;
import com.avito.android.util.Logs;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.MessengerClient;
public final class c<T, R> implements Function<Boolean, SingleSource<? extends UnreadMessagesCounter>> {
    public final /* synthetic */ MessengerClient a;
    public final /* synthetic */ String b;

    public c(MessengerClient messengerClient, String str) {
        this.a = messengerClient;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends UnreadMessagesCounter> apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullParameter(bool2, "isAuthorized");
        if (bool2.booleanValue()) {
            return this.a.withMessengerApi().flatMap(a.a).map(new b(this));
        }
        Logs.debug$default("getUpdatedUnreadChatsCounter", "accountStateProvider.isAuthorized() == false", null, 4, null);
        return Single.just(new UnreadMessagesCounter(0, 0));
    }
}
