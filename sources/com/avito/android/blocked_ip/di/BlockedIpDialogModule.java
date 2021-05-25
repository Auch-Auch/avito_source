package com.avito.android.blocked_ip.di;

import com.avito.android.blocked_ip.BlockedIpDialogPresenter;
import com.avito.android.blocked_ip.BlockedIpDialogPresenterImpl;
import com.avito.android.di.DialogRouterModule;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/blocked_ip/di/BlockedIpDialogModule;", "", "Lcom/avito/android/blocked_ip/BlockedIpDialogPresenterImpl;", "presenter", "Lcom/avito/android/blocked_ip/BlockedIpDialogPresenter;", "bindBlockedIpDialogPresenter", "(Lcom/avito/android/blocked_ip/BlockedIpDialogPresenterImpl;)Lcom/avito/android/blocked_ip/BlockedIpDialogPresenter;", "blocked-ip_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class})
public interface BlockedIpDialogModule {
    @Binds
    @NotNull
    BlockedIpDialogPresenter bindBlockedIpDialogPresenter(@NotNull BlockedIpDialogPresenterImpl blockedIpDialogPresenterImpl);
}
