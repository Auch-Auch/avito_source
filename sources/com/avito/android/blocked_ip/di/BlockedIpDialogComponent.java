package com.avito.android.blocked_ip.di;

import android.app.Activity;
import com.avito.android.blocked_ip.BlockedIpDialogActivity;
import com.avito.android.di.PerActivity;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/blocked_ip/di/BlockedIpDialogComponent;", "", "Lcom/avito/android/blocked_ip/BlockedIpDialogActivity;", "blockedIpDialogActivity", "", "inject", "(Lcom/avito/android/blocked_ip/BlockedIpDialogActivity;)V", "Builder", "blocked-ip_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {BlockedIpDependencies.class}, modules = {BlockedIpDialogModule.class})
@PerActivity
public interface BlockedIpDialogComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/blocked_ip/di/BlockedIpDialogComponent$Builder;", "", "Lcom/avito/android/blocked_ip/di/BlockedIpDependencies;", "dependencies", "blockedIpDependencies", "(Lcom/avito/android/blocked_ip/di/BlockedIpDependencies;)Lcom/avito/android/blocked_ip/di/BlockedIpDialogComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/blocked_ip/di/BlockedIpDialogComponent$Builder;", "Lcom/avito/android/blocked_ip/di/BlockedIpDialogComponent;", "build", "()Lcom/avito/android/blocked_ip/di/BlockedIpDialogComponent;", "blocked-ip_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        Builder blockedIpDependencies(@NotNull BlockedIpDependencies blockedIpDependencies);

        @NotNull
        BlockedIpDialogComponent build();

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);
    }

    void inject(@NotNull BlockedIpDialogActivity blockedIpDialogActivity);
}
