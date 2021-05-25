package com.avito.android.messenger.di;

import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolver;
import com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolverImpl;
import com.avito.android.util.SchedulersFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ2\u0010\r\u001a\u00020\n2\u0011\u0010\u0005\u001a\r\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/di/IncompleteMessageLoaderModule;", "", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "client", "Lcom/avito/android/messenger/MessengerEntityConverter;", "entityConverter", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;", "provideMessageBodyResolver$messenger_release", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/MessengerEntityConverter;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;", "provideMessageBodyResolver", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {MessengerRepoModule.class})
public final class IncompleteMessageLoaderModule {
    @NotNull
    public static final IncompleteMessageLoaderModule INSTANCE = new IncompleteMessageLoaderModule();

    @Provides
    @JvmStatic
    @NotNull
    public static final MessageBodyResolver provideMessageBodyResolver$messenger_release(@NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "entityConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        return new MessageBodyResolverImpl(messengerClient, messengerEntityConverter, schedulersFactory);
    }
}
