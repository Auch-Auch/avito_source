package com.avito.android.theme_settings.viewmodel;

import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/theme_settings/viewmodel/ThemeModeItemState;", "", "Lcom/avito/android/lib/util/DarkThemeManager$Mode;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/util/DarkThemeManager$Mode;", "getMode", "()Lcom/avito/android/lib/util/DarkThemeManager$Mode;", "mode", "", AuthSource.BOOKING_ORDER, "Z", "isChecked", "()Z", "<init>", "(Lcom/avito/android/lib/util/DarkThemeManager$Mode;Z)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class ThemeModeItemState {
    @NotNull
    public final DarkThemeManager.Mode a;
    public final boolean b;

    public ThemeModeItemState(@NotNull DarkThemeManager.Mode mode, boolean z) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.a = mode;
        this.b = z;
    }

    @NotNull
    public final DarkThemeManager.Mode getMode() {
        return this.a;
    }

    public final boolean isChecked() {
        return this.b;
    }
}
