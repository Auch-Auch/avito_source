package ru.sravni.android.bankproduct.storage.welcome;

import android.content.Context;
import android.content.SharedPreferences;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.repository.splash.ISplashScreenInfoStorage;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\r\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0018"}, d2 = {"Lru/sravni/android/bankproduct/storage/welcome/SplashScreenInfoStorage;", "Lru/sravni/android/bankproduct/repository/splash/ISplashScreenInfoStorage;", "", "value", "", "setWelcomeScreenShowCount", "(I)V", "getWelcomeScreenShowCount", "()I", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "c", "Landroid/content/SharedPreferences;", "prefs", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "prefsName", AuthSource.BOOKING_ORDER, "countFieldName", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SplashScreenInfoStorage implements ISplashScreenInfoStorage {
    public final String a = "SravniWelcomeSP";
    public final String b = "shownCount";
    public final SharedPreferences c;

    public SplashScreenInfoStorage(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.c = context.getSharedPreferences("SravniWelcomeSP", 0);
    }

    @Override // ru.sravni.android.bankproduct.repository.splash.ISplashScreenInfoStorage
    public int getWelcomeScreenShowCount() {
        return this.c.getInt(this.b, 0);
    }

    @Override // ru.sravni.android.bankproduct.repository.splash.ISplashScreenInfoStorage
    public void setWelcomeScreenShowCount(int i) {
        this.c.edit().putInt(this.b, i).apply();
    }
}
