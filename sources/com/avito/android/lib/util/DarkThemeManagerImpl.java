package com.avito.android.lib.util;

import android.os.Build;
import androidx.appcompat.app.AppCompatDelegate;
import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.remote.auth.AuthSource;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00058V@VX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0007\u001a\u0004\b\u001b\u0010\t¨\u0006 "}, d2 = {"Lcom/avito/android/lib/util/DarkThemeManagerImpl;", "Lcom/avito/android/lib/util/DarkThemeManager;", "", "applyMode", "()V", "Lcom/avito/android/lib/util/DarkThemeManager$Mode;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/util/DarkThemeManager$Mode;", "getAutoMode", "()Lcom/avito/android/lib/util/DarkThemeManager$Mode;", "autoMode", "Lcom/avito/android/lib/util/DarkThemeManagerImpl$Storage;", "d", "Lcom/avito/android/lib/util/DarkThemeManagerImpl$Storage;", "storage", "value", "getCurrentMode", "setCurrentMode", "(Lcom/avito/android/lib/util/DarkThemeManager$Mode;)V", "currentMode", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getAvailableModes", "()Ljava/util/List;", "availableModes", "c", "getDefaultMode", "defaultMode", "<init>", "(Lcom/avito/android/lib/util/DarkThemeManagerImpl$Storage;)V", "Storage", "components_release"}, k = 1, mv = {1, 4, 2})
public final class DarkThemeManagerImpl implements DarkThemeManager {
    @Deprecated
    @NotNull
    public static final List<DarkThemeManager.Mode> e;
    @Deprecated
    @NotNull
    public static final List<DarkThemeManager.Mode> f;
    @NotNull
    public final List<DarkThemeManager.Mode> a;
    @NotNull
    public final DarkThemeManager.Mode b;
    @NotNull
    public final DarkThemeManager.Mode c;
    public final Storage d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/lib/util/DarkThemeManagerImpl$Storage;", "", "", "value", "", "put", "(I)V", "defaultValue", "get", "(I)I", "components_release"}, k = 1, mv = {1, 4, 2})
    public interface Storage {
        int get(int i);

        void put(int i);
    }

    static {
        DarkThemeManager.Mode.LightAlways lightAlways = DarkThemeManager.Mode.LightAlways.INSTANCE;
        DarkThemeManager.Mode.DarkAlways darkAlways = DarkThemeManager.Mode.DarkAlways.INSTANCE;
        e = CollectionsKt__CollectionsKt.listOf((Object[]) new DarkThemeManager.Mode[]{DarkThemeManager.Mode.AutoBattery.INSTANCE, lightAlways, darkAlways});
        f = CollectionsKt__CollectionsKt.listOf((Object[]) new DarkThemeManager.Mode[]{DarkThemeManager.Mode.FollowSystem.INSTANCE, lightAlways, darkAlways});
    }

    public DarkThemeManagerImpl(@NotNull Storage storage) {
        List<DarkThemeManager.Mode> list;
        DarkThemeManager.Mode mode;
        Intrinsics.checkNotNullParameter(storage, "storage");
        this.d = storage;
        int i = Build.VERSION.SDK_INT;
        if (i < 29) {
            list = e;
        } else {
            list = f;
        }
        this.a = list;
        if (i < 29) {
            mode = DarkThemeManager.Mode.AutoBattery.INSTANCE;
        } else {
            mode = DarkThemeManager.Mode.FollowSystem.INSTANCE;
        }
        this.b = mode;
        this.c = getAutoMode();
    }

    @Override // com.avito.android.lib.util.DarkThemeManager
    public void applyMode() {
        AppCompatDelegate.setDefaultNightMode(getCurrentMode().getNightModeId());
    }

    @Override // com.avito.android.lib.util.DarkThemeManager
    @NotNull
    public DarkThemeManager.Mode getAutoMode() {
        return this.b;
    }

    @Override // com.avito.android.lib.util.DarkThemeManager
    @NotNull
    public List<DarkThemeManager.Mode> getAvailableModes() {
        return this.a;
    }

    @Override // com.avito.android.lib.util.DarkThemeManager
    @NotNull
    public DarkThemeManager.Mode getCurrentMode() {
        T t;
        boolean z;
        int i = this.d.get(getDefaultMode().getNightModeId());
        Iterator<T> it = getAvailableModes().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.getNightModeId() == i) {
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
        T t2 = t;
        return t2 != null ? t2 : getDefaultMode();
    }

    @Override // com.avito.android.lib.util.DarkThemeManager
    @NotNull
    public DarkThemeManager.Mode getDefaultMode() {
        return this.c;
    }

    @Override // com.avito.android.lib.util.DarkThemeManager
    public void setCurrentMode(@NotNull DarkThemeManager.Mode mode) {
        Intrinsics.checkNotNullParameter(mode, "value");
        this.d.put(mode.getNightModeId());
        AppCompatDelegate.setDefaultNightMode(mode.getNightModeId());
    }
}
