package com.avito.android.social_management.di;

import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.preferences.SocialNotificationStateStorage;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/social_management/di/SocialManagementPluginModule;", "", "Lcom/avito/android/preferences/SocialNotificationStateStorage;", "socialNotificationStateStorage", "Lcom/avito/android/account/plugin/AuthorizationPlugin;", "provideAuthorizationPlugin", "(Lcom/avito/android/preferences/SocialNotificationStateStorage;)Lcom/avito/android/account/plugin/AuthorizationPlugin;", "<init>", "()V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class SocialManagementPluginModule {
    @NotNull
    public static final SocialManagementPluginModule INSTANCE = new SocialManagementPluginModule();

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @Singleton
    public static final AuthorizationPlugin provideAuthorizationPlugin(@NotNull SocialNotificationStateStorage socialNotificationStateStorage) {
        Intrinsics.checkNotNullParameter(socialNotificationStateStorage, "socialNotificationStateStorage");
        return new AuthorizationPlugin(socialNotificationStateStorage) { // from class: com.avito.android.social_management.di.SocialManagementPluginModule$provideAuthorizationPlugin$1
            public final /* synthetic */ SocialNotificationStateStorage a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onLogin() {
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onLogout() {
                this.a.clear();
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onStateChanged() {
                AuthorizationPlugin.DefaultImpls.onStateChanged(this);
            }
        };
    }
}
