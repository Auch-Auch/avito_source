package com.avito.android.user_adverts.expired_count.di;

import android.app.Application;
import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.preferences.UserAdvertsInfoStorage;
import com.avito.android.user_advert.UserAdvertsInfoUpdateRunner;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/user_adverts/expired_count/di/UserAdvertsInfoPluginModule;", "", "Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "userAdvertsInfoUpdateRunner", "Lcom/avito/android/preferences/UserAdvertsInfoStorage;", "userAdvertsInfoStorage", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/account/plugin/AuthorizationPlugin;", "provideAuthorizationPlugin", "(Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;Lcom/avito/android/preferences/UserAdvertsInfoStorage;Landroid/app/Application;)Lcom/avito/android/account/plugin/AuthorizationPlugin;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class UserAdvertsInfoPluginModule {
    @NotNull
    public static final UserAdvertsInfoPluginModule INSTANCE = new UserAdvertsInfoPluginModule();

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @Singleton
    public static final AuthorizationPlugin provideAuthorizationPlugin(@NotNull UserAdvertsInfoUpdateRunner userAdvertsInfoUpdateRunner, @NotNull UserAdvertsInfoStorage userAdvertsInfoStorage, @NotNull Application application) {
        Intrinsics.checkNotNullParameter(userAdvertsInfoUpdateRunner, "userAdvertsInfoUpdateRunner");
        Intrinsics.checkNotNullParameter(userAdvertsInfoStorage, "userAdvertsInfoStorage");
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        return new AuthorizationPlugin(userAdvertsInfoUpdateRunner, application, userAdvertsInfoStorage) { // from class: com.avito.android.user_adverts.expired_count.di.UserAdvertsInfoPluginModule$provideAuthorizationPlugin$1
            public final /* synthetic */ UserAdvertsInfoUpdateRunner a;
            public final /* synthetic */ Application b;
            public final /* synthetic */ UserAdvertsInfoStorage c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onLogin() {
                this.a.forceUpdate(this.b);
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onLogout() {
                this.c.clear();
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onStateChanged() {
                AuthorizationPlugin.DefaultImpls.onStateChanged(this);
            }
        };
    }
}
