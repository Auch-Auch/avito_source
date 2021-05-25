package com.avito.android.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.avito.reporter.WebSocketReporter;
public final class WebSocketReporterModule_ProvideWebsocketReporterFactory implements Factory<WebSocketReporter> {
    public final WebSocketReporterModule a;

    public WebSocketReporterModule_ProvideWebsocketReporterFactory(WebSocketReporterModule webSocketReporterModule) {
        this.a = webSocketReporterModule;
    }

    public static WebSocketReporterModule_ProvideWebsocketReporterFactory create(WebSocketReporterModule webSocketReporterModule) {
        return new WebSocketReporterModule_ProvideWebsocketReporterFactory(webSocketReporterModule);
    }

    public static WebSocketReporter provideWebsocketReporter(WebSocketReporterModule webSocketReporterModule) {
        return (WebSocketReporter) Preconditions.checkNotNullFromProvides(webSocketReporterModule.provideWebsocketReporter());
    }

    @Override // javax.inject.Provider
    public WebSocketReporter get() {
        return provideWebsocketReporter(this.a);
    }
}
