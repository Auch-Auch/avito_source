package ru.avito.messenger.internal.di;

import com.avito.android.remote.auth.AuthSource;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.LogLevel;
import ru.avito.messenger.internal.log.AndroidLogger;
import ru.avito.messenger.internal.log.LeveledLogger;
import ru.avito.messenger.internal.log.Logger;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0001\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lru/avito/messenger/internal/di/LoggerModule;", "", "Lru/avito/messenger/internal/log/Logger;", "provideLogger", "()Lru/avito/messenger/internal/log/Logger;", "", AuthSource.SEND_ABUSE, "I", "logLevel", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/internal/log/Logger;", "logger", "<init>", "(ILru/avito/messenger/internal/log/Logger;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class LoggerModule {
    public final int a;
    public final Logger b;

    public LoggerModule(@LogLevel int i, @Nullable Logger logger) {
        this.a = i;
        this.b = logger;
    }

    @Provides
    @PerMessenger
    @NotNull
    public final Logger provideLogger() {
        Logger logger = this.b;
        return logger != null ? logger : new LeveledLogger(this.a, new AndroidLogger());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoggerModule(int i, Logger logger, int i2, j jVar) {
        this(i, (i2 & 2) != 0 ? null : logger);
    }
}
