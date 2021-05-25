package com.avito.android.di.module;

import com.avito.android.messenger.MessengerPluginModule;
import com.avito.android.search.subscriptions.di.SearchSubscriptionPluginModule;
import com.avito.android.social_management.di.SocialManagementPluginModule;
import com.avito.android.user_adverts.expired_count.di.UserAdvertsInfoPluginModule;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/di/module/AvitoAuthPluginsModule;", "", "<init>", "()V", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SearchSubscriptionPluginModule.class, FavoritePluginModule.class, MessengerPluginModule.class, SocialManagementPluginModule.class, UserAdvertsInfoPluginModule.class})
public final class AvitoAuthPluginsModule {
    @NotNull
    public static final AvitoAuthPluginsModule INSTANCE = new AvitoAuthPluginsModule();
}
