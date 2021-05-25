package ru.avito.messenger.internal.di;

import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lru/avito/messenger/internal/di/ServiceModule;", "", "Ljava/lang/Class;", "Lru/avito/messenger/MessengerApi;", "provideService", "()Ljava/lang/Class;", AuthSource.SEND_ABUSE, "Ljava/lang/Class;", NotificationCompat.CATEGORY_SERVICE, "<init>", "(Ljava/lang/Class;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ServiceModule {
    public final Class<? extends MessengerApi> a;

    public ServiceModule(@NotNull Class<? extends MessengerApi> cls) {
        Intrinsics.checkNotNullParameter(cls, NotificationCompat.CATEGORY_SERVICE);
        this.a = cls;
    }

    @Provides
    @PerMessenger
    @NotNull
    public final Class<? extends MessengerApi> provideService() {
        return this.a;
    }
}
