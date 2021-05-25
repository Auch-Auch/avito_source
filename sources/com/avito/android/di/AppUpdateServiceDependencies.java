package com.avito.android.di;

import com.avito.android.preferences.TokenStorage;
import com.avito.android.preferences.VersionStorage;
import com.avito.android.push.provider.PushTokenProvider;
import com.avito.android.service.short_task.app_update.AppUpdateApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/di/AppUpdateServiceDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/service/short_task/app_update/AppUpdateApi;", "appUpdateApi", "()Lcom/avito/android/service/short_task/app_update/AppUpdateApi;", "Lcom/avito/android/preferences/TokenStorage;", "tokenStorage", "()Lcom/avito/android/preferences/TokenStorage;", "Lcom/avito/android/push/provider/PushTokenProvider;", "pushTokenProvider", "()Lcom/avito/android/push/provider/PushTokenProvider;", "Lcom/avito/android/preferences/VersionStorage;", "versionStorage", "()Lcom/avito/android/preferences/VersionStorage;", "application_release"}, k = 1, mv = {1, 4, 2})
public interface AppUpdateServiceDependencies extends CoreComponentDependencies {
    @NotNull
    AppUpdateApi appUpdateApi();

    @Override // com.avito.android.push.MessagingDependencies, com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies
    @NotNull
    PushTokenProvider pushTokenProvider();

    @NotNull
    TokenStorage tokenStorage();

    @NotNull
    VersionStorage versionStorage();
}
