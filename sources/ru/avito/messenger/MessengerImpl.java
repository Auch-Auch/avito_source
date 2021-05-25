package ru.avito.messenger;

import com.avito.android.remote.auth.AuthSource;
import com.google.gson.Gson;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.config.MessengerConfigProvider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B/\b\u0007\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lru/avito/messenger/MessengerImpl;", "Lru/avito/messenger/MessengerApi;", "T", "Lru/avito/messenger/Messenger;", "Lru/avito/messenger/MessengerImageUploadApi;", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/MessengerImageUploadApi;", "getImageUploadApi", "()Lru/avito/messenger/MessengerImageUploadApi;", "imageUploadApi", "Lru/avito/messenger/config/MessengerConfigProvider;", "d", "Lru/avito/messenger/config/MessengerConfigProvider;", "getConfigProvider", "()Lru/avito/messenger/config/MessengerConfigProvider;", "configProvider", "Lcom/google/gson/Gson;", "c", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson", "Lru/avito/messenger/MessengerClient;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/MessengerClient;", "getClient", "()Lru/avito/messenger/MessengerClient;", "client", "<init>", "(Lru/avito/messenger/MessengerClient;Lru/avito/messenger/MessengerImageUploadApi;Lcom/google/gson/Gson;Lru/avito/messenger/config/MessengerConfigProvider;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerImpl<T extends MessengerApi> implements Messenger<T> {
    @NotNull
    public final MessengerClient<T> a;
    @NotNull
    public final MessengerImageUploadApi b;
    @NotNull
    public final Gson c;
    @NotNull
    public final MessengerConfigProvider d;

    @Inject
    public MessengerImpl(@NotNull MessengerClient<T> messengerClient, @NotNull MessengerImageUploadApi messengerImageUploadApi, @NotNull Gson gson, @NotNull MessengerConfigProvider messengerConfigProvider) {
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(messengerImageUploadApi, "imageUploadApi");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(messengerConfigProvider, "configProvider");
        this.a = messengerClient;
        this.b = messengerImageUploadApi;
        this.c = gson;
        this.d = messengerConfigProvider;
    }

    @Override // ru.avito.messenger.Messenger
    @NotNull
    public MessengerClient<T> getClient() {
        return this.a;
    }

    @Override // ru.avito.messenger.Messenger
    @NotNull
    public MessengerConfigProvider getConfigProvider() {
        return this.d;
    }

    @Override // ru.avito.messenger.Messenger
    @NotNull
    public Gson getGson() {
        return this.c;
    }

    @Override // ru.avito.messenger.Messenger
    @NotNull
    public MessengerImageUploadApi getImageUploadApi() {
        return this.b;
    }
}
