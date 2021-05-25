package ru.avito.messenger;

import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lru/avito/messenger/MessengerApiProvider;", "Lru/avito/messenger/MessengerApi;", "T", "", "Lio/reactivex/Single;", "withMessengerApi", "()Lio/reactivex/Single;", "getFallbackApi", "()Lru/avito/messenger/MessengerApi;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerApiProvider<T extends MessengerApi> {
    @NotNull
    T getFallbackApi();

    @NotNull
    Single<T> withMessengerApi();
}
