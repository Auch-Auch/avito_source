package com.avito.android.settings;

import com.avito.android.remote.model.Location;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/avito/android/settings/SettingsPresenter;", "", "Lcom/avito/android/settings/SettingsView;", "view", "", "attachView", "(Lcom/avito/android/settings/SettingsView;)V", "detachView", "()V", "Lcom/avito/android/settings/SettingsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/settings/SettingsPresenter$Router;)V", "detachRouter", "Lcom/avito/android/remote/model/Location;", "location", "onLocationSelected", "(Lcom/avito/android/remote/model/Location;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Router", "settings_release"}, k = 1, mv = {1, 4, 2})
public interface SettingsPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/settings/SettingsPresenter$Router;", "", "", "openHelpCenter", "()V", "openB2bHub", "openAppsLicenceScreen", "openUserAgreementScreen", "openOfferScreen", "openSourceLicencesScreen", "openDebugScreen", "openThemeSettings", "Lcom/avito/android/remote/model/Location;", "location", "openLocationScreen", "(Lcom/avito/android/remote/model/Location;)V", "", "email", "subject", "text", "openSupportInfoScreen", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "openNotifications", "close", "settings_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void close();

        void openAppsLicenceScreen();

        void openB2bHub();

        void openDebugScreen();

        void openHelpCenter();

        void openLocationScreen(@NotNull Location location);

        void openNotifications();

        void openOfferScreen();

        void openSourceLicencesScreen();

        void openSupportInfoScreen(@NotNull String str, @NotNull String str2, @NotNull String str3);

        void openThemeSettings();

        void openUserAgreementScreen();
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull SettingsView settingsView);

    void detachRouter();

    void detachView();

    void onLocationSelected(@Nullable Location location);

    @NotNull
    Kundle onSaveState();
}
