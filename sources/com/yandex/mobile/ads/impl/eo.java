package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
public final class eo extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(@NonNull ConsoleMessage consoleMessage) {
        consoleMessage.message();
        consoleMessage.sourceId();
        consoleMessage.lineNumber();
        return true;
    }
}
