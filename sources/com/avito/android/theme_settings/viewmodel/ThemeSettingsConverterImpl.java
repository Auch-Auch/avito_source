package com.avito.android.theme_settings.viewmodel;

import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.text.FontStyleKt;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.theme_settings.item.switcher.SwitcherItem;
import com.avito.android.theme_settings.item.theme_checkmark.ThemeCheckmarkItem;
import com.avito.android.theme_settings.utils.ThemeSettingsResourceProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsConverterImpl;", "Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsConverter;", "Lcom/avito/android/theme_settings/viewmodel/ThemeModeItemState;", "item", "Lcom/avito/android/serp/adapter/SpannedItem;", "convert", "(Lcom/avito/android/theme_settings/viewmodel/ThemeModeItemState;)Lcom/avito/android/serp/adapter/SpannedItem;", "Lcom/avito/android/theme_settings/utils/ThemeSettingsResourceProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/theme_settings/utils/ThemeSettingsResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/theme_settings/utils/ThemeSettingsResourceProvider;)V", "Companion", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class ThemeSettingsConverterImpl implements ThemeSettingsConverter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final ThemeSettingsResourceProvider a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsConverterImpl$Companion;", "", "", "ID_BATTTERY", "Ljava/lang/String;", "ID_DARK", "ID_LIGHT", "ID_SYSTEM", "<init>", "()V", "settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Inject
    public ThemeSettingsConverterImpl(@NotNull ThemeSettingsResourceProvider themeSettingsResourceProvider) {
        Intrinsics.checkNotNullParameter(themeSettingsResourceProvider, "resourceProvider");
        this.a = themeSettingsResourceProvider;
    }

    @Override // com.avito.android.theme_settings.viewmodel.ThemeSettingsConverter
    @NotNull
    public SpannedItem convert(@NotNull ThemeModeItemState themeModeItemState) {
        Intrinsics.checkNotNullParameter(themeModeItemState, "item");
        DarkThemeManager.Mode mode = themeModeItemState.getMode();
        if (Intrinsics.areEqual(mode, DarkThemeManager.Mode.LightAlways.INSTANCE)) {
            return new ThemeCheckmarkItem(FontStyleKt.LIGHT, this.a.getLightThemeTitle(), this.a.getLightThemeImage(), themeModeItemState);
        }
        if (Intrinsics.areEqual(mode, DarkThemeManager.Mode.DarkAlways.INSTANCE)) {
            return new ThemeCheckmarkItem("dark", this.a.getDarkThemeTitle(), this.a.getDarkThemeImage(), themeModeItemState);
        }
        if (Intrinsics.areEqual(mode, DarkThemeManager.Mode.AutoBattery.INSTANCE)) {
            return new SwitcherItem("battery", this.a.getAutoBatteryTitle(), this.a.getAutoBatterySubtitle(), themeModeItemState);
        }
        if (Intrinsics.areEqual(mode, DarkThemeManager.Mode.FollowSystem.INSTANCE)) {
            return new SwitcherItem(ChannelContext.System.TYPE, this.a.getFollowSystemTitle(), this.a.getFollowSystemSubtitle(), themeModeItemState);
        }
        throw new NoWhenBranchMatchedException();
    }
}
