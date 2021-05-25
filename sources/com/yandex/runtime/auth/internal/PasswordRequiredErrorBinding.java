package com.yandex.runtime.auth.internal;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.auth.PasswordRequiredError;
import com.yandex.runtime.internal.ErrorBinding;
public class PasswordRequiredErrorBinding extends ErrorBinding implements PasswordRequiredError {
    public PasswordRequiredErrorBinding(NativeObject nativeObject) {
        super(nativeObject);
    }

    @Override // com.yandex.runtime.auth.PasswordRequiredError
    @NonNull
    public native Object getData();
}
