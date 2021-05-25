package ru.sravni.android.bankproduct.di.buildlevel;

import a2.b.a.a.a;
import android.os.Build;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.BuildConfig;
import ru.sravni.android.bankproduct.domain.AppBuildInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0019\u0010\u0005\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lru/sravni/android/bankproduct/domain/AppBuildInfo;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/AppBuildInfo;", "getAppBuildInfo", "()Lru/sravni/android/bankproduct/domain/AppBuildInfo;", "appBuildInfo", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class AppBuildInfoObjectKt {
    @NotNull
    public static final AppBuildInfo a;

    static {
        StringBuilder L = a.L("ANDROID ");
        String str = Build.VERSION.RELEASE;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        L.append((Object) str);
        L.append(" (");
        L.append(Integer.valueOf(Build.VERSION.SDK_INT));
        L.append(")");
        String sb = L.toString();
        StringBuilder sb2 = new StringBuilder();
        String str3 = Build.MANUFACTURER;
        if (str3 == null) {
            str3 = str2;
        }
        sb2.append(str3);
        sb2.append(" - ");
        String str4 = Build.MODEL;
        if (str4 != null) {
            str2 = str4;
        }
        sb2.append((Object) str2);
        a = new AppBuildInfo(13, false, BuildConfig.VERSION_NAME, "release", "LIBRARY", sb, sb2.toString(), "avito android app");
    }

    @NotNull
    public static final AppBuildInfo getAppBuildInfo() {
        return a;
    }
}
