package ru.avito.messenger.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.avito.messenger.internal.log.Logger;
public final class LoggerModule_ProvideLoggerFactory implements Factory<Logger> {
    public final LoggerModule a;

    public LoggerModule_ProvideLoggerFactory(LoggerModule loggerModule) {
        this.a = loggerModule;
    }

    public static LoggerModule_ProvideLoggerFactory create(LoggerModule loggerModule) {
        return new LoggerModule_ProvideLoggerFactory(loggerModule);
    }

    public static Logger provideLogger(LoggerModule loggerModule) {
        return (Logger) Preconditions.checkNotNullFromProvides(loggerModule.provideLogger());
    }

    @Override // javax.inject.Provider
    public Logger get() {
        return provideLogger(this.a);
    }
}
