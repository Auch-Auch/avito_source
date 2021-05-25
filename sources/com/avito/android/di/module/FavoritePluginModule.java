package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.favorites.FavoriteAdvertsSyncRunner;
import com.avito.android.favorites.di.FavoriteAdvertsSyncRunnerModule;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/di/module/FavoritePluginModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/favorites/FavoriteAdvertsSyncRunner;", "favoriteAdvertsSyncRunner", "Lcom/avito/android/account/plugin/AuthorizationPlugin;", "provideAuthorizationPlugin", "(Landroid/app/Application;Lcom/avito/android/favorites/FavoriteAdvertsSyncRunner;)Lcom/avito/android/account/plugin/AuthorizationPlugin;", "<init>", "()V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {FavoriteAdvertsSyncRunnerModule.class})
public final class FavoritePluginModule {
    @NotNull
    public static final FavoritePluginModule INSTANCE = new FavoritePluginModule();

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @Singleton
    public static final AuthorizationPlugin provideAuthorizationPlugin(@NotNull Application application, @NotNull FavoriteAdvertsSyncRunner favoriteAdvertsSyncRunner) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(favoriteAdvertsSyncRunner, "favoriteAdvertsSyncRunner");
        return new AuthorizationPlugin(favoriteAdvertsSyncRunner, application) { // from class: com.avito.android.di.module.FavoritePluginModule$provideAuthorizationPlugin$1
            public final /* synthetic */ FavoriteAdvertsSyncRunner a;
            public final /* synthetic */ Application b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onLogin() {
                this.a.startSync(this.b);
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onLogout() {
                this.a.startWipeLocal(this.b);
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onStateChanged() {
                AuthorizationPlugin.DefaultImpls.onStateChanged(this);
            }
        };
    }
}
