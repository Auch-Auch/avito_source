package com.avito.android.analytics.grafana;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/avito/android/analytics/grafana/GraphitePrefixImpl;", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "", AuthSource.BOOKING_ORDER, "I", "appVersion", "", "d", "Ljava/lang/String;", "getVersionsPrefix", "()Ljava/lang/String;", "versionsPrefix", AuthSource.SEND_ABUSE, "getAppType", "appType", "c", "sdkVersion", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "<init>", "(Lcom/avito/android/util/BuildInfo;)V", "analytics-core_release"}, k = 1, mv = {1, 4, 2})
public final class GraphitePrefixImpl implements GraphitePrefix {
    @NotNull
    public final String a;
    public final int b;
    public final int c;
    @NotNull
    public final String d;

    @Inject
    public GraphitePrefixImpl(@NotNull BuildInfo buildInfo) {
        String str;
        boolean z;
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        String applicationPackageId = buildInfo.getApplicationPackageId();
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"com.avito.android", "ru.domofond.app"});
        boolean z2 = true;
        if (!(listOf instanceof Collection) || !listOf.isEmpty()) {
            Iterator it = listOf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str2 = (String) it.next();
                String substringAfter$default = StringsKt__StringsKt.substringAfter$default(applicationPackageId, a.K2(str2, FormatterType.defaultDecimalSeparator), (String) null, 2, (Object) null);
                boolean z3 = !StringsKt__StringsKt.contains$default((CharSequence) substringAfter$default, (char) FormatterType.defaultDecimalSeparator, false, 2, (Object) null);
                boolean contains$default = StringsKt__StringsKt.contains$default((CharSequence) substringAfter$default, (CharSequence) ".demo", false, 2, (Object) null);
                boolean contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) substringAfter$default, (CharSequence) ".test", false, 2, (Object) null);
                if (Intrinsics.areEqual(applicationPackageId, str2) || z3 || contains$default || contains$default2) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            if (m.startsWith$default(applicationPackageId, "com.avito.android", false, 2, null)) {
                String buildType = buildInfo.getBuildType();
                if (buildType.hashCode() == 1090594823 && buildType.equals("release")) {
                    str = "android";
                } else {
                    StringBuilder L = a.L("android-");
                    L.append(buildInfo.getBuildType());
                    str = L.toString();
                }
            } else if (m.startsWith$default(applicationPackageId, "ru.domofond.app", false, 2, null)) {
                StringBuilder L2 = a.L("android-domofond-");
                L2.append(buildInfo.getBuildType());
                str = L2.toString();
            } else {
                throw new IllegalStateException(a.d3("Unsupported application [", applicationPackageId, ']').toString());
            }
            this.a = str;
            int versionCode = buildInfo.getVersionCode();
            this.b = versionCode;
            int sdkVersion = buildInfo.getSdkVersion();
            this.c = sdkVersion;
            this.d = versionCode + ".os." + sdkVersion;
            return;
        }
        throw new IllegalArgumentException(a.e3("Unsupported application [", applicationPackageId, "]. Please add prefix").toString());
    }

    @Override // com.avito.android.analytics.grafana.GraphitePrefix
    @NotNull
    public String getAppType() {
        return this.a;
    }

    @Override // com.avito.android.analytics.grafana.GraphitePrefix
    @NotNull
    public String getVersionsPrefix() {
        return this.d;
    }
}
