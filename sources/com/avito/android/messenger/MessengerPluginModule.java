package com.avito.android.messenger;

import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.preferences.MessengerStorage;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/MessengerPluginModule;", "", "Lcom/avito/android/preferences/MessengerStorage;", "messengerStorage", "Lcom/avito/android/account/plugin/AuthorizationPlugin;", "provideAuthorizationPlugin", "(Lcom/avito/android/preferences/MessengerStorage;)Lcom/avito/android/account/plugin/AuthorizationPlugin;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class MessengerPluginModule {
    @NotNull
    public static final MessengerPluginModule INSTANCE = new MessengerPluginModule();

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @Singleton
    public static final AuthorizationPlugin provideAuthorizationPlugin(@NotNull MessengerStorage messengerStorage) {
        Intrinsics.checkNotNullParameter(messengerStorage, "messengerStorage");
        return new AuthorizationPlugin(messengerStorage) { // from class: com.avito.android.messenger.MessengerPluginModule$provideAuthorizationPlugin$1
            public final /* synthetic */ MessengerStorage a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onLogin() {
                AuthorizationPlugin.DefaultImpls.onLogin(this);
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
