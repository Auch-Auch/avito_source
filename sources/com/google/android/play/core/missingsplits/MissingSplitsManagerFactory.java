package com.google.android.play.core.missingsplits;

import a2.j.b.e.a.g.a;
import a2.j.b.e.a.g.b;
import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;
public class MissingSplitsManagerFactory {
    public static final AtomicReference<Boolean> a = new AtomicReference<>(null);

    public static MissingSplitsManager create(Context context) {
        return new b(context, Runtime.getRuntime(), new a(context, context.getPackageManager()), a);
    }
}
