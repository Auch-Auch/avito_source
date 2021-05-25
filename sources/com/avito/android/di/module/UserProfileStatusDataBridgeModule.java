package com.avito.android.di.module;

import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/di/module/UserProfileStatusDataBridgeModule;", "", "<init>", "()V", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AvitoApplicationModule.class, AvitoDaoModule.class, AvitoStorageModule.class, UnreadNotificationsModule.class})
public final class UserProfileStatusDataBridgeModule {
    @NotNull
    public static final UserProfileStatusDataBridgeModule INSTANCE = new UserProfileStatusDataBridgeModule();
}
