package com.avito.android.util;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/util/ViewCompatIdGenerator;", "", "", "generate", "()I", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class ViewCompatIdGenerator {
    @NotNull
    public static final ViewCompatIdGenerator INSTANCE = new ViewCompatIdGenerator();

    public final int generate() {
        return View.generateViewId();
    }
}
