package com.yandex.runtime.rpc.internal;

import androidx.annotation.NonNull;
public class ServiceManagerFactory {
    @NonNull
    public static native ServiceManager getServiceManager();
}
