package com.yandex.runtime.rpc;
public final class RPC {
    private static IServiceDelegate delegate_;

    public static void initialize(IServiceDelegate iServiceDelegate) {
        delegate_ = iServiceDelegate;
    }

    public static void notifyOnFirstConnect() {
        delegate_.onFirstConnect();
    }
}
