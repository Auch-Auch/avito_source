package com.yandex.mobile.ads.impl;

import android.content.Intent;
public final class se extends sl {
    private Intent b;

    public se() {
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        if (this.b != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }

    public se(rx rxVar) {
        super(rxVar);
    }
}
