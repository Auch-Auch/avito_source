package com.otaliastudios.cameraview.engine.action;

import a2.m.a.b.j.a;
import a2.m.a.b.j.b;
import a2.m.a.b.j.c;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Arrays;
@RequiresApi(21)
public class Actions {
    @NonNull
    public static BaseAction sequence(@NonNull BaseAction... baseActionArr) {
        return new a(Arrays.asList(baseActionArr));
    }

    @NonNull
    public static BaseAction timeout(long j, @NonNull BaseAction baseAction) {
        return new b(j, baseAction);
    }

    @NonNull
    public static BaseAction together(@NonNull BaseAction... baseActionArr) {
        return new c(Arrays.asList(baseActionArr));
    }
}
