package com.avito.android.enabler;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.preferences.Names;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\u0004\"\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/util/BuildInfo;", "info", "", "basePrefix", "(Lcom/avito/android/util/BuildInfo;)Ljava/lang/String;", "buildInfo", "", "appVersion", "(Lcom/avito/android/util/BuildInfo;)I", "appName", "METRIC_NAME", "Ljava/lang/String;", "features-enabler_release"}, k = 2, mv = {1, 4, 2})
public final class MonitorsKt {
    private static final String METRIC_NAME = "remote-toggle";

    private static final String appName(BuildInfo buildInfo) {
        return buildInfo.isDebug() ? Names.DEBUG : m.replace$default(buildInfo.getVersionName(), (char) FormatterType.defaultDecimalSeparator, '_', false, 4, (Object) null);
    }

    private static final int appVersion(BuildInfo buildInfo) {
        return buildInfo.getVersionCode();
    }

    @NotNull
    public static final String basePrefix(@NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(buildInfo, "info");
        StringBuilder sb = new StringBuilder();
        sb.append(appName(buildInfo));
        sb.append(FormatterType.defaultDecimalSeparator);
        return a.j(sb, appVersion(buildInfo), ".remote-toggle");
    }
}
