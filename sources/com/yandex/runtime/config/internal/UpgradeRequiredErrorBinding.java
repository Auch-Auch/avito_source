package com.yandex.runtime.config.internal;

import com.yandex.runtime.NativeObject;
import com.yandex.runtime.config.UpgradeRequiredError;
import com.yandex.runtime.internal.ErrorBinding;
public class UpgradeRequiredErrorBinding extends ErrorBinding implements UpgradeRequiredError {
    public UpgradeRequiredErrorBinding(NativeObject nativeObject) {
        super(nativeObject);
    }
}
