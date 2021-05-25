package com.yandex.runtime.recording;

import androidx.annotation.NonNull;
import java.util.Map;
public interface EventListener {
    void onEvent(@NonNull String str, @NonNull Map<String, String> map);

    void onValue(@NonNull String str, double d);
}
