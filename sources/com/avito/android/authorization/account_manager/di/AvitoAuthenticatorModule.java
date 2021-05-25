package com.avito.android.authorization.account_manager.di;

import android.accounts.AccountManager;
import android.app.Service;
import androidx.core.app.NotificationCompat;
import com.avito.android.Features;
import com.avito.android.authorization.account_manager.AvitoAccountAuthenticator;
import com.avito.android.di.PerService;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.remote.ProfileApi;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J7\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/account_manager/di/AvitoAuthenticatorModule;", "", "Landroid/app/Service;", NotificationCompat.CATEGORY_SERVICE, "Landroid/accounts/AccountManager;", "accountManager", "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/preferences/TokenStorage;", "tokenStorage", "Lcom/avito/android/authorization/account_manager/AvitoAccountAuthenticator;", "provideAvitoAccountAuthenticator$authorization_release", "(Landroid/app/Service;Landroid/accounts/AccountManager;Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/Features;Lcom/avito/android/preferences/TokenStorage;)Lcom/avito/android/authorization/account_manager/AvitoAccountAuthenticator;", "provideAvitoAccountAuthenticator", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AvitoAuthenticatorModule {
    @NotNull
    public static final AvitoAuthenticatorModule INSTANCE = new AvitoAuthenticatorModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerService
    public static final AvitoAccountAuthenticator provideAvitoAccountAuthenticator$authorization_release(@NotNull Service service, @NotNull AccountManager accountManager, @NotNull ProfileApi profileApi, @NotNull Features features, @NotNull TokenStorage tokenStorage) {
        Intrinsics.checkNotNullParameter(service, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(accountManager, "accountManager");
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(tokenStorage, "tokenStorage");
        return new AvitoAccountAuthenticator(service, accountManager, profileApi, tokenStorage, features);
    }
}
