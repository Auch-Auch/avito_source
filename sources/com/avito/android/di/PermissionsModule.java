package com.avito.android.di;

import com.avito.android.permissions.PermissionChecker;
import com.avito.android.permissions.PermissionCheckerImpl;
import com.avito.android.permissions.PermissionStateProvider;
import com.avito.android.permissions.PermissionStateProviderImpl;
import com.avito.android.permissions.PermissionStorage;
import com.avito.android.permissions.PermissionStorageImpl;
import dagger.Binds;
import dagger.Module;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/di/PermissionsModule;", "", "<init>", "()V", "Bindings", "permissions_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Bindings.class})
public final class PermissionsModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/di/PermissionsModule$Bindings;", "", "Lcom/avito/android/permissions/PermissionStorageImpl;", "impl", "Lcom/avito/android/permissions/PermissionStorage;", "bindsPermissionStorage", "(Lcom/avito/android/permissions/PermissionStorageImpl;)Lcom/avito/android/permissions/PermissionStorage;", "Lcom/avito/android/permissions/PermissionCheckerImpl;", "checker", "Lcom/avito/android/permissions/PermissionChecker;", "bindsPermissionChecker", "(Lcom/avito/android/permissions/PermissionCheckerImpl;)Lcom/avito/android/permissions/PermissionChecker;", "Lcom/avito/android/permissions/PermissionStateProviderImpl;", "Lcom/avito/android/permissions/PermissionStateProvider;", "bindsPermissionState", "(Lcom/avito/android/permissions/PermissionStateProviderImpl;)Lcom/avito/android/permissions/PermissionStateProvider;", "permissions_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Bindings {
        @Binds
        @NotNull
        PermissionChecker bindsPermissionChecker(@NotNull PermissionCheckerImpl permissionCheckerImpl);

        @Singleton
        @Binds
        @NotNull
        PermissionStateProvider bindsPermissionState(@NotNull PermissionStateProviderImpl permissionStateProviderImpl);

        @Binds
        @NotNull
        PermissionStorage bindsPermissionStorage(@NotNull PermissionStorageImpl permissionStorageImpl);
    }
}
