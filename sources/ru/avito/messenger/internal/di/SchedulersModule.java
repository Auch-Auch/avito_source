package ru.avito.messenger.internal.di;

import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactoryImpl;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lru/avito/messenger/internal/di/SchedulersModule;", "", "Lcom/avito/android/util/SchedulersFactory;", "provideSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class SchedulersModule {
    @Provides
    @PerMessenger
    @NotNull
    public final SchedulersFactory provideSchedulers() {
        return new SchedulersFactoryImpl();
    }
}
