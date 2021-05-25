package com.avito.android.messenger.channels.mvi.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.fps.di.FpsModule;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.messenger.channels.mvi.di.ChannelsListComponent;
import com.avito.android.messenger.channels.mvi.view.ChannelsFragment;
import com.avito.android.messenger.di.RelativeDateFormatterModule;
import com.avito.android.serp.analytics.BannerPageSource;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\nJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/di/ChannelsComponent;", "", "Lcom/avito/android/messenger/channels/mvi/di/ChannelsListComponent$Builder;", "listComponentBuilder", "()Lcom/avito/android/messenger/channels/mvi/di/ChannelsListComponent$Builder;", "Lcom/avito/android/messenger/channels/mvi/view/ChannelsFragment;", "fragment", "", "inject", "(Lcom/avito/android/messenger/channels/mvi/view/ChannelsFragment;)V", "Builder", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ChannelsDependencies.class, LocationDependencies.class, ScreenAnalyticsDependencies.class}, modules = {RelativeDateFormatterModule.class, FpsModule.class, ChannelsModule.class})
@PerFragment
public interface ChannelsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/messenger/channels/mvi/di/ChannelsComponent$Builder;", "", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/messenger/channels/mvi/di/ChannelsComponent$Builder;", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/messenger/channels/mvi/di/ChannelsComponent$Builder;", "Lcom/avito/android/di/module/ScreenAnalyticsDependencies;", "dependencies", "screenAnalyticsDependencies", "(Lcom/avito/android/di/module/ScreenAnalyticsDependencies;)Lcom/avito/android/messenger/channels/mvi/di/ChannelsComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/messenger/channels/mvi/di/ChannelsComponent$Builder;", "Lcom/avito/android/serp/analytics/BannerPageSource;", "pageSource", "adBannerPageSource", "(Lcom/avito/android/serp/analytics/BannerPageSource;)Lcom/avito/android/messenger/channels/mvi/di/ChannelsComponent$Builder;", "Lcom/avito/android/messenger/di/RelativeDateFormatterModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "relativeDateFormatterModule", "(Lcom/avito/android/messenger/di/RelativeDateFormatterModule;)Lcom/avito/android/messenger/channels/mvi/di/ChannelsComponent$Builder;", "Lcom/avito/android/messenger/channels/mvi/di/ChannelsDependencies;", "channelsMviDependencies", "(Lcom/avito/android/messenger/channels/mvi/di/ChannelsDependencies;)Lcom/avito/android/messenger/channels/mvi/di/ChannelsComponent$Builder;", "Lcom/avito/android/location/di/LocationDependencies;", "locationDependencies", "(Lcom/avito/android/location/di/LocationDependencies;)Lcom/avito/android/messenger/channels/mvi/di/ChannelsComponent$Builder;", "Lcom/avito/android/messenger/channels/mvi/di/ChannelsComponent;", "build", "()Lcom/avito/android/messenger/channels/mvi/di/ChannelsComponent;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder adBannerPageSource(@NotNull BannerPageSource bannerPageSource);

        @NotNull
        ChannelsComponent build();

        @NotNull
        Builder channelsMviDependencies(@NotNull ChannelsDependencies channelsDependencies);

        @BindsInstance
        @NotNull
        Builder fragment(@NotNull Fragment fragment);

        @NotNull
        Builder locationDependencies(@NotNull LocationDependencies locationDependencies);

        @NotNull
        Builder relativeDateFormatterModule(@NotNull RelativeDateFormatterModule relativeDateFormatterModule);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder screen(@NotNull Screen screen);

        @NotNull
        Builder screenAnalyticsDependencies(@NotNull ScreenAnalyticsDependencies screenAnalyticsDependencies);
    }

    void inject(@NotNull ChannelsFragment channelsFragment);

    @NotNull
    ChannelsListComponent.Builder listComponentBuilder();
}
