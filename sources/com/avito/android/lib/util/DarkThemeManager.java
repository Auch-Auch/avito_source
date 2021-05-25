package com.avito.android.lib.util;

import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001:\u0001\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0012\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/avito/android/lib/util/DarkThemeManager;", "", "", "applyMode", "()V", "", "Lcom/avito/android/lib/util/DarkThemeManager$Mode;", "getAvailableModes", "()Ljava/util/List;", "availableModes", "getCurrentMode", "()Lcom/avito/android/lib/util/DarkThemeManager$Mode;", "setCurrentMode", "(Lcom/avito/android/lib/util/DarkThemeManager$Mode;)V", "currentMode", "getAutoMode", "autoMode", "getDefaultMode", "defaultMode", "Mode", "components_release"}, k = 1, mv = {1, 4, 2})
public interface DarkThemeManager {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\r\u000e\u000f\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u0001\u0004\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/lib/util/DarkThemeManager$Mode;", "", "", AuthSource.BOOKING_ORDER, "Z", "isAutoChangeable", "()Z", "", AuthSource.SEND_ABUSE, "I", "getNightModeId", "()I", "nightModeId", "AutoBattery", "DarkAlways", "FollowSystem", "LightAlways", "Lcom/avito/android/lib/util/DarkThemeManager$Mode$FollowSystem;", "Lcom/avito/android/lib/util/DarkThemeManager$Mode$DarkAlways;", "Lcom/avito/android/lib/util/DarkThemeManager$Mode$LightAlways;", "Lcom/avito/android/lib/util/DarkThemeManager$Mode$AutoBattery;", "components_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Mode {
        public final int a;
        public final boolean b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/lib/util/DarkThemeManager$Mode$AutoBattery;", "Lcom/avito/android/lib/util/DarkThemeManager$Mode;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
        public static final class AutoBattery extends Mode {
            @NotNull
            public static final AutoBattery INSTANCE = new AutoBattery();

            public AutoBattery() {
                super(3, true, (j) null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/lib/util/DarkThemeManager$Mode$DarkAlways;", "Lcom/avito/android/lib/util/DarkThemeManager$Mode;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
        public static final class DarkAlways extends Mode {
            @NotNull
            public static final DarkAlways INSTANCE = new DarkAlways();

            public DarkAlways() {
                super(2, false, 2);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/lib/util/DarkThemeManager$Mode$FollowSystem;", "Lcom/avito/android/lib/util/DarkThemeManager$Mode;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
        public static final class FollowSystem extends Mode {
            @NotNull
            public static final FollowSystem INSTANCE = new FollowSystem();

            public FollowSystem() {
                super(-1, true, (j) null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/lib/util/DarkThemeManager$Mode$LightAlways;", "Lcom/avito/android/lib/util/DarkThemeManager$Mode;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
        public static final class LightAlways extends Mode {
            @NotNull
            public static final LightAlways INSTANCE = new LightAlways();

            public LightAlways() {
                super(1, false, 2);
            }
        }

        public Mode(int i, boolean z, int i2) {
            z = (i2 & 2) != 0 ? false : z;
            this.a = i;
            this.b = z;
        }

        public final int getNightModeId() {
            return this.a;
        }

        public final boolean isAutoChangeable() {
            return this.b;
        }

        public Mode(int i, boolean z, j jVar) {
            this.a = i;
            this.b = z;
        }
    }

    void applyMode();

    @NotNull
    Mode getAutoMode();

    @NotNull
    List<Mode> getAvailableModes();

    @NotNull
    Mode getCurrentMode();

    @NotNull
    Mode getDefaultMode();

    void setCurrentMode(@NotNull Mode mode);
}
