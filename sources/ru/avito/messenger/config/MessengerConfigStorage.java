package ru.avito.messenger.config;

import com.avito.android.remote.model.Navigation;
import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lru/avito/messenger/config/MessengerConfigStorage;", "", "Lru/avito/messenger/config/MessengerConfig;", Navigation.CONFIG, "Lio/reactivex/Completable;", "saveConfig", "(Lru/avito/messenger/config/MessengerConfig;)Lio/reactivex/Completable;", "defaultConfig", "Lio/reactivex/Single;", "loadConfig", "(Lru/avito/messenger/config/MessengerConfig;)Lio/reactivex/Single;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerConfigStorage {
    @NotNull
    Single<MessengerConfig> loadConfig(@NotNull MessengerConfig messengerConfig);

    @NotNull
    Completable saveConfig(@NotNull MessengerConfig messengerConfig);
}
