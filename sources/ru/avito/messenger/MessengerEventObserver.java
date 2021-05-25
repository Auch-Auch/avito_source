package ru.avito.messenger;

import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lru/avito/messenger/MessengerEventObserver;", "", "T", "Ljava/lang/Class;", "clazz", "Lio/reactivex/Observable;", "observeChatEvents", "(Ljava/lang/Class;)Lio/reactivex/Observable;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerEventObserver {
    @NotNull
    <T> Observable<T> observeChatEvents(@NotNull Class<T> cls);
}
