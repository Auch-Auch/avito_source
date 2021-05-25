package com.avito.android.service_subscription.di;

import android.content.Context;
import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.service_subscription.lf_packages.LfPackagesFragment;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionFragment;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/service_subscription/di/SubscriptionFragmentComponent;", "", "Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionFragment;", "fragment", "", "inject", "(Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionFragment;)V", "Lcom/avito/android/service_subscription/lf_packages/LfPackagesFragment;", "(Lcom/avito/android/service_subscription/lf_packages/LfPackagesFragment;)V", "Builder", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SubscriptionFragmentDependencies.class}, modules = {SubscriptionFragmentModule.class})
@PerFragment
public interface SubscriptionFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\nH'¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/service_subscription/di/SubscriptionFragmentComponent$Builder;", "", "Lcom/avito/android/service_subscription/di/SubscriptionFragmentDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/service_subscription/di/SubscriptionFragmentDependencies;)Lcom/avito/android/service_subscription/di/SubscriptionFragmentComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/service_subscription/di/SubscriptionFragmentComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/service_subscription/di/SubscriptionFragmentComponent$Builder;", "Landroid/content/Context;", "context", "withContext", "(Landroid/content/Context;)Lcom/avito/android/service_subscription/di/SubscriptionFragmentComponent$Builder;", "Lcom/avito/android/service_subscription/di/SubscriptionFragmentComponent;", "build", "()Lcom/avito/android/service_subscription/di/SubscriptionFragmentComponent;", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        SubscriptionFragmentComponent build();

        @NotNull
        Builder dependentOn(@NotNull SubscriptionFragmentDependencies subscriptionFragmentDependencies);

        @BindsInstance
        @NotNull
        Builder withContext(@LocalContext @NotNull Context context);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withState(@Nullable Kundle kundle);
    }

    void inject(@NotNull LfPackagesFragment lfPackagesFragment);

    void inject(@NotNull ServiceSubscriptionFragment serviceSubscriptionFragment);
}
