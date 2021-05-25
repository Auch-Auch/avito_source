package ru.avito.messenger.internal.di;

import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.MessengerImpl;
@Component(modules = {MessengerClientModule.class})
@PerMessenger
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lru/avito/messenger/internal/di/MessengerComponent;", "", "Lru/avito/messenger/MessengerImpl;", "Lru/avito/messenger/MessengerApi;", "createMessenger", "()Lru/avito/messenger/MessengerImpl;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerComponent {
    @NotNull
    MessengerImpl<MessengerApi> createMessenger();
}
