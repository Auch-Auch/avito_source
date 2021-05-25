package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.m2;
import com.google.android.play.core.internal.bl;
import com.google.android.play.core.internal.ci;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public final class v implements ci<Executor> {
    public static Executor b() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(m2.a);
        bl.a(newSingleThreadExecutor, "Cannot return null from a non-@Nullable @Provides method");
        return newSingleThreadExecutor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.ci
    public final /* bridge */ /* synthetic */ Executor a() {
        return b();
    }
}
