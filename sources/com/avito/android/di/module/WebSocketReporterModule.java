package com.avito.android.di.module;

import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.reporter.StubWebSocketReporter;
import ru.avito.reporter.WebSocketReporter;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/module/WebSocketReporterModule;", "", "Lru/avito/reporter/WebSocketReporter;", "provideWebsocketReporter", "()Lru/avito/reporter/WebSocketReporter;", "<init>", "()V", "avito-release_release"}, k = 1, mv = {1, 4, 2})
@Module
public class WebSocketReporterModule {
    @Provides
    @NotNull
    public final WebSocketReporter provideWebsocketReporter() {
        return new StubWebSocketReporter();
    }
}
