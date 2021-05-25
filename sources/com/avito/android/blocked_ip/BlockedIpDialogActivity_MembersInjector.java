package com.avito.android.blocked_ip;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.util.DialogRouter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class BlockedIpDialogActivity_MembersInjector implements MembersInjector<BlockedIpDialogActivity> {
    public final Provider<BlockedIpDialogPresenter> a;
    public final Provider<DialogRouter> b;
    public final Provider<ActivityIntentFactory> c;

    public BlockedIpDialogActivity_MembersInjector(Provider<BlockedIpDialogPresenter> provider, Provider<DialogRouter> provider2, Provider<ActivityIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<BlockedIpDialogActivity> create(Provider<BlockedIpDialogPresenter> provider, Provider<DialogRouter> provider2, Provider<ActivityIntentFactory> provider3) {
        return new BlockedIpDialogActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.blocked_ip.BlockedIpDialogActivity.activityIntentFactory")
    public static void injectActivityIntentFactory(BlockedIpDialogActivity blockedIpDialogActivity, ActivityIntentFactory activityIntentFactory) {
        blockedIpDialogActivity.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.blocked_ip.BlockedIpDialogActivity.dialogRouter")
    public static void injectDialogRouter(BlockedIpDialogActivity blockedIpDialogActivity, DialogRouter dialogRouter) {
        blockedIpDialogActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.blocked_ip.BlockedIpDialogActivity.presenter")
    public static void injectPresenter(BlockedIpDialogActivity blockedIpDialogActivity, BlockedIpDialogPresenter blockedIpDialogPresenter) {
        blockedIpDialogActivity.presenter = blockedIpDialogPresenter;
    }

    public void injectMembers(BlockedIpDialogActivity blockedIpDialogActivity) {
        injectPresenter(blockedIpDialogActivity, this.a.get());
        injectDialogRouter(blockedIpDialogActivity, this.b.get());
        injectActivityIntentFactory(blockedIpDialogActivity, this.c.get());
    }
}
