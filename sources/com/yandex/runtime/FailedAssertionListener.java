package com.yandex.runtime;

import androidx.annotation.NonNull;
import java.util.List;
public interface FailedAssertionListener {
    void onFailedAssertion(@NonNull String str, int i, @NonNull String str2, @NonNull String str3, @NonNull List<String> list);
}
