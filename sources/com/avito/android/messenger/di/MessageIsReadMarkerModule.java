package com.avito.android.messenger.di;

import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.MessengerHistory;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\u0011\u0010\u0005\u001a\r\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u00040\u0002H'¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/di/MessageIsReadMarkerModule;", "", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "implementation", "Lru/avito/messenger/MessengerHistory;", "messengerHistory", "(Lru/avito/messenger/MessengerClient;)Lru/avito/messenger/MessengerHistory;", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {MessengerRepoModule.class})
public interface MessageIsReadMarkerModule {
    @Binds
    @NotNull
    MessengerHistory messengerHistory(@NotNull MessengerClient<AvitoMessengerApi> messengerClient);
}
