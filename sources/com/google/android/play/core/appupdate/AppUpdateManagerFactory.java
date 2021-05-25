package com.google.android.play.core.appupdate;

import a2.j.b.e.a.a.c;
import a2.j.b.e.a.a.j;
import android.content.Context;
public class AppUpdateManagerFactory {
    public static AppUpdateManager create(Context context) {
        return new c(new j(context), context);
    }
}
