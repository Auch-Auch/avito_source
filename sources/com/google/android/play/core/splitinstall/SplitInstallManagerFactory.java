package com.google.android.play.core.splitinstall;

import a2.j.b.e.a.i.g;
import a2.j.b.e.a.i.r0;
import android.content.Context;
import com.google.android.play.core.splitcompat.d;
public class SplitInstallManagerFactory {
    public static SplitInstallManager create(Context context) {
        return new r0(context, d.a(), new g());
    }
}
