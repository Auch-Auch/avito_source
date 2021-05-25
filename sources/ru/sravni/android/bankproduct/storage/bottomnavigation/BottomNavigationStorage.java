package ru.sravni.android.bankproduct.storage.bottomnavigation;

import android.content.Context;
import android.content.SharedPreferences;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.repository.bottomnavigation.IBottomNavigationStorage;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u001e\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lru/sravni/android/bankproduct/storage/bottomnavigation/BottomNavigationStorage;", "Lru/sravni/android/bankproduct/repository/bottomnavigation/IBottomNavigationStorage;", "", "value", "", "saveSelectedItemBottomNavigation", "(I)V", "getSelectedItemBottomNavigation", "()I", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "prefsName", AuthSource.BOOKING_ORDER, "selectedItemName", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "c", "Landroid/content/SharedPreferences;", "prefs", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class BottomNavigationStorage implements IBottomNavigationStorage {
    public final String a = "SravniBottomNavigationSP";
    public final String b = "selectedItem";
    public final SharedPreferences c;

    public BottomNavigationStorage(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.c = context.getSharedPreferences("SravniBottomNavigationSP", 0);
    }

    @Override // ru.sravni.android.bankproduct.repository.bottomnavigation.IBottomNavigationStorage
    public int getSelectedItemBottomNavigation() {
        return this.c.getInt(this.b, 0);
    }

    @Override // ru.sravni.android.bankproduct.repository.bottomnavigation.IBottomNavigationStorage
    public void saveSelectedItemBottomNavigation(int i) {
        this.c.edit().putInt(this.b, i).apply();
    }
}
