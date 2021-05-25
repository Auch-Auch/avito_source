package com.yandex.runtime.logging;

import androidx.annotation.NonNull;
public interface LogListener {
    void onMessageRecieved(@NonNull LogMessage logMessage);
}
