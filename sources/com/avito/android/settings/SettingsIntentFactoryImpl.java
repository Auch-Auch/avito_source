package com.avito.android.settings;

import android.app.Application;
import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.SettingsIntentFactory;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.settings.ui.SettingsActivity;
import com.avito.android.settings.ui.SettingsFragmentData;
import com.avito.android.theme_settings.ThemeSettingsActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/settings/SettingsIntentFactoryImpl;", "Lcom/avito/android/SettingsIntentFactory;", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", "Landroid/content/Intent;", "settingsIntent", "(Lcom/avito/android/bottom_navigation/NavigationTab;)Landroid/content/Intent;", "()Landroid/content/Intent;", "themeSettingsIntent", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "Lcom/avito/android/CoreActivityIntentFactory;", "c", "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/app/Application;Lcom/avito/android/Features;Lcom/avito/android/CoreActivityIntentFactory;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class SettingsIntentFactoryImpl implements SettingsIntentFactory {
    public final Application a;
    public final Features b;
    public final CoreActivityIntentFactory c;

    @Inject
    public SettingsIntentFactoryImpl(@NotNull Application application, @NotNull Features features, @NotNull CoreActivityIntentFactory coreActivityIntentFactory) {
        Intrinsics.checkNotNullParameter(application, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        this.a = application;
        this.b = features;
        this.c = coreActivityIntentFactory;
    }

    @Override // com.avito.android.SettingsIntentFactory
    @NotNull
    public Intent settingsIntent(@Nullable NavigationTab navigationTab) {
        if (!this.b.getSettingsWithoutActivity().invoke().booleanValue() || navigationTab == null) {
            return new Intent(this.a, SettingsActivity.class);
        }
        return this.c.mainScreenWithTab(new SettingsFragmentData(navigationTab));
    }

    @Override // com.avito.android.SettingsIntentFactory
    @NotNull
    public Intent themeSettingsIntent() {
        return ThemeSettingsActivity.Companion.createIntent$settings_release(this.a);
    }

    @Override // com.avito.android.SettingsIntentFactory
    @NotNull
    public Intent settingsIntent() {
        return new Intent(this.a, SettingsActivity.class);
    }
}
