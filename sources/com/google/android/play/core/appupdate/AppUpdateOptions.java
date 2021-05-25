package com.google.android.play.core.appupdate;

import a2.j.b.e.a.a.l;
import com.google.android.play.core.install.model.AppUpdateType;
public abstract class AppUpdateOptions {

    public static abstract class Builder {
        public abstract void a();

        public abstract AppUpdateOptions build();

        public abstract Builder setAppUpdateType(@AppUpdateType int i);
    }

    public static AppUpdateOptions defaultOptions(@AppUpdateType int i) {
        return newBuilder(i).build();
    }

    public static Builder newBuilder(@AppUpdateType int i) {
        l lVar = new l();
        lVar.a = Integer.valueOf(i);
        lVar.b = Boolean.FALSE;
        return lVar;
    }

    public abstract boolean a();

    @AppUpdateType
    public abstract int appUpdateType();
}
