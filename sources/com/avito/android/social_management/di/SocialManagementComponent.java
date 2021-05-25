package com.avito.android.social_management.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.di.PerActivity;
import com.avito.android.dialog.di.DialogModule;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.social_management.SocialManagementActivity;
import com.avito.android.social_management.adapter.available.di.AvailableItemModule;
import com.avito.android.social_management.adapter.connected.di.ConnectedItemModule;
import com.avito.android.social_management.adapter.header.di.HeaderItemModule;
import com.avito.android.social_management.adapter.notification.di.NotificationItemModule;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/social_management/di/SocialManagementComponent;", "", "Lcom/avito/android/social_management/SocialManagementActivity;", "activity", "", "inject", "(Lcom/avito/android/social_management/SocialManagementActivity;)V", "Builder", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SocialManagementDependencies.class}, modules = {ConnectedItemModule.class, HeaderItemModule.class, AvailableItemModule.class, NotificationItemModule.class, SocialManagementModule.class, DialogModule.class, ErrorHelperModule.class})
@PerActivity
public interface SocialManagementComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/social_management/di/SocialManagementComponent$Builder;", "", "Lcom/avito/android/social_management/di/SocialManagementDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/social_management/di/SocialManagementDependencies;)Lcom/avito/android/social_management/di/SocialManagementComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/social_management/di/SocialManagementComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/social_management/di/SocialManagementComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/social_management/di/SocialManagementComponent$Builder;", "Lcom/avito/android/social_management/di/SocialManagementComponent;", "build", "()Lcom/avito/android/social_management/di/SocialManagementComponent;", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        SocialManagementComponent build();

        @NotNull
        Builder dependentOn(@NotNull SocialManagementDependencies socialManagementDependencies);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);
    }

    void inject(@NotNull SocialManagementActivity socialManagementActivity);
}
