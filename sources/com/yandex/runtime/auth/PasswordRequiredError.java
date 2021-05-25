package com.yandex.runtime.auth;

import androidx.annotation.NonNull;
import com.yandex.runtime.Error;
public interface PasswordRequiredError extends Error {
    @NonNull
    Object getData();
}
