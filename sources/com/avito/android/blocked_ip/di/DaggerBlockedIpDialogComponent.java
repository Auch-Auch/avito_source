package com.avito.android.blocked_ip.di;

import android.app.Activity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.blocked_ip.BlockedIpDialogActivity;
import com.avito.android.blocked_ip.BlockedIpDialogActivity_MembersInjector;
import com.avito.android.blocked_ip.BlockedIpDialogPresenterImpl;
import com.avito.android.blocked_ip.di.BlockedIpDialogComponent;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.util.DialogRouter;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerBlockedIpDialogComponent implements BlockedIpDialogComponent {
    public final BlockedIpDependencies a;
    public Provider<Activity> b;
    public Provider<DialogRouter> c;

    public static final class b implements BlockedIpDialogComponent.Builder {
        public BlockedIpDependencies a;
        public Activity b;

        public b(a aVar) {
        }

        @Override // com.avito.android.blocked_ip.di.BlockedIpDialogComponent.Builder
        public BlockedIpDialogComponent.Builder blockedIpDependencies(BlockedIpDependencies blockedIpDependencies) {
            this.a = (BlockedIpDependencies) Preconditions.checkNotNull(blockedIpDependencies);
            return this;
        }

        @Override // com.avito.android.blocked_ip.di.BlockedIpDialogComponent.Builder
        public BlockedIpDialogComponent build() {
            Preconditions.checkBuilderRequirement(this.a, BlockedIpDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            return new DaggerBlockedIpDialogComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.blocked_ip.di.BlockedIpDialogComponent.Builder
        public BlockedIpDialogComponent.Builder withActivity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }
    }

    public DaggerBlockedIpDialogComponent(BlockedIpDependencies blockedIpDependencies, Activity activity, a aVar) {
        this.a = blockedIpDependencies;
        Factory create = InstanceFactory.create(activity);
        this.b = create;
        this.c = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create));
    }

    public static BlockedIpDialogComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.blocked_ip.di.BlockedIpDialogComponent
    public void inject(BlockedIpDialogActivity blockedIpDialogActivity) {
        BlockedIpDialogActivity_MembersInjector.injectPresenter(blockedIpDialogActivity, new BlockedIpDialogPresenterImpl());
        BlockedIpDialogActivity_MembersInjector.injectDialogRouter(blockedIpDialogActivity, this.c.get());
        BlockedIpDialogActivity_MembersInjector.injectActivityIntentFactory(blockedIpDialogActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}
