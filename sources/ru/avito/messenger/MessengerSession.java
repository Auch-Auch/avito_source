package ru.avito.messenger;

import io.reactivex.Observable;
import kotlin.Metadata;
import org.funktionale.option.Option;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.entity.messenger.UserSession;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"Lru/avito/messenger/MessengerSession;", "", "Lio/reactivex/Observable;", "Lorg/funktionale/option/Option;", "", "currentUserId", "()Lio/reactivex/Observable;", "Lru/avito/messenger/internal/entity/messenger/UserSession;", "getSessionObservable", "sessionObservable", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerSession {
    @NotNull
    Observable<Option<String>> currentUserId();

    @NotNull
    Observable<Option<UserSession>> getSessionObservable();
}
