package com.avito.android.service_subscription.di;

import android.content.Context;
import com.avito.android.design.ProgressLineColorProvider;
import com.avito.android.design.ProgressLineColorProviderImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.lib.design.R;
import com.avito.android.service_subscription.ServiceSubscriptionInteractor;
import com.avito.android.service_subscription.ServiceSubscriptionResourceProvider;
import com.avito.android.service_subscription.ServiceSubscriptionResourceProviderImpl;
import com.avito.android.service_subscription.lf_packages.LfPackagesInteractorImpl;
import com.avito.android.service_subscription.subscription_new.ColorParser;
import com.avito.android.service_subscription.subscription_new.ColorParserImpl;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionInteractorImpl;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionPresenter;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionPresenterImpl;
import com.avito.android.util.Contexts;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\r\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/service_subscription/di/SubscriptionFragmentModule;", "", "Lcom/avito/android/service_subscription/ServiceSubscriptionInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/service_subscription/subscription_new/ColorParser;", "colorParser", "Lcom/avito/android/util/Kundle;", "state", "Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionPresenter;", "provideSubscriptionPresenter", "(Lcom/avito/android/service_subscription/ServiceSubscriptionInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/service_subscription/subscription_new/ColorParser;Lcom/avito/android/util/Kundle;)Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionPresenter;", "provideLfPackagesPresenter", "Landroid/content/Context;", "context", "provideColorParser", "(Landroid/content/Context;)Lcom/avito/android/service_subscription/subscription_new/ColorParser;", "<init>", "()V", "Declarations", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class SubscriptionFragmentModule {
    @NotNull
    public static final SubscriptionFragmentModule INSTANCE = new SubscriptionFragmentModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/service_subscription/di/SubscriptionFragmentModule$Declarations;", "", "Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionInteractorImpl;", "interactor", "Lcom/avito/android/service_subscription/ServiceSubscriptionInteractor;", "bindServiceSubscriptionInteractor", "(Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionInteractorImpl;)Lcom/avito/android/service_subscription/ServiceSubscriptionInteractor;", "Lcom/avito/android/service_subscription/lf_packages/LfPackagesInteractorImpl;", "bindLfPackagesInteractor", "(Lcom/avito/android/service_subscription/lf_packages/LfPackagesInteractorImpl;)Lcom/avito/android/service_subscription/ServiceSubscriptionInteractor;", "Lcom/avito/android/design/ProgressLineColorProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/design/ProgressLineColorProvider;", "bindProgressLineColorProvider", "(Lcom/avito/android/design/ProgressLineColorProviderImpl;)Lcom/avito/android/design/ProgressLineColorProvider;", "Lcom/avito/android/service_subscription/ServiceSubscriptionResourceProviderImpl;", "Lcom/avito/android/service_subscription/ServiceSubscriptionResourceProvider;", "bindServiceSubscriptionResourceProvider", "(Lcom/avito/android/service_subscription/ServiceSubscriptionResourceProviderImpl;)Lcom/avito/android/service_subscription/ServiceSubscriptionResourceProvider;", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @LfInteractor
        @Binds
        @NotNull
        @PerFragment
        ServiceSubscriptionInteractor bindLfPackagesInteractor(@NotNull LfPackagesInteractorImpl lfPackagesInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        ProgressLineColorProvider bindProgressLineColorProvider(@NotNull ProgressLineColorProviderImpl progressLineColorProviderImpl);

        @SsInteractor
        @Binds
        @NotNull
        @PerFragment
        ServiceSubscriptionInteractor bindServiceSubscriptionInteractor(@NotNull ServiceSubscriptionInteractorImpl serviceSubscriptionInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        ServiceSubscriptionResourceProvider bindServiceSubscriptionResourceProvider(@NotNull ServiceSubscriptionResourceProviderImpl serviceSubscriptionResourceProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ColorParser provideColorParser(@LocalContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorParserImpl(Contexts.getColorByAttr(context, R.attr.red50));
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    @LfPresenter
    public static final ServiceSubscriptionPresenter provideLfPackagesPresenter(@LfInteractor @NotNull ServiceSubscriptionInteractor serviceSubscriptionInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ColorParser colorParser, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(serviceSubscriptionInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(colorParser, "colorParser");
        return new ServiceSubscriptionPresenterImpl(serviceSubscriptionInteractor, schedulersFactory, colorParser, kundle);
    }

    @Provides
    @JvmStatic
    @NotNull
    @SubscriptionPresenter
    @PerFragment
    public static final ServiceSubscriptionPresenter provideSubscriptionPresenter(@SsInteractor @NotNull ServiceSubscriptionInteractor serviceSubscriptionInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ColorParser colorParser, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(serviceSubscriptionInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(colorParser, "colorParser");
        return new ServiceSubscriptionPresenterImpl(serviceSubscriptionInteractor, schedulersFactory, colorParser, kundle);
    }
}
