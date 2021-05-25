package com.avito.android.fps;

import android.app.Application;
import android.view.Display;
import android.view.WindowManager;
import com.avito.android.util.Strings;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0007\u001a\u00020\u0004*\u00020\u00048@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroid/app/Application;", "", "refreshRate", "(Landroid/app/Application;)D", "", "getDotPrefixed", "(Ljava/lang/String;)Ljava/lang/String;", "dotPrefixed", "analytics-screens_release"}, k = 2, mv = {1, 4, 2})
public final class FpsReporterKt {
    @NotNull
    public static final String getDotPrefixed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$dotPrefixed");
        return str.length() > 0 ? Strings.ensureStartsWith(str, ".") : str;
    }

    public static final double refreshRate(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "$this$refreshRate");
        Object systemService = application.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "(getSystemService(Contex…owManager).defaultDisplay");
        return (double) defaultDisplay.getRefreshRate();
    }
}
