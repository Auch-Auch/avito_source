package com.avito.android.in_app_calls.logging;

import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallLogWriterImpl_Factory implements Factory<CallLogWriterImpl> {
    public final Provider<LogFileProvider> a;
    public final Provider<LogFormatter> b;
    public final Provider<Gson> c;

    public CallLogWriterImpl_Factory(Provider<LogFileProvider> provider, Provider<LogFormatter> provider2, Provider<Gson> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static CallLogWriterImpl_Factory create(Provider<LogFileProvider> provider, Provider<LogFormatter> provider2, Provider<Gson> provider3) {
        return new CallLogWriterImpl_Factory(provider, provider2, provider3);
    }

    public static CallLogWriterImpl newInstance(LogFileProvider logFileProvider, LogFormatter logFormatter, Gson gson) {
        return new CallLogWriterImpl(logFileProvider, logFormatter, gson);
    }

    @Override // javax.inject.Provider
    public CallLogWriterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
