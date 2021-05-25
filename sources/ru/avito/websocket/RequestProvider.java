package ru.avito.websocket;

import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.Pair;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00070\u00050\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/avito/websocket/RequestProvider;", "", "", "sequenceId", "Lio/reactivex/Single;", "Lkotlin/Pair;", "Lokhttp3/Request;", "Lru/avito/websocket/RequestIdHeader;", "request", "(Ljava/lang/String;)Lio/reactivex/Single;", "rx-websocket"}, k = 1, mv = {1, 4, 2})
public interface RequestProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single request$default(RequestProvider requestProvider, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                return requestProvider.request(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: request");
        }
    }

    @NotNull
    Single<Pair<Request, String>> request(@Nullable String str);
}
