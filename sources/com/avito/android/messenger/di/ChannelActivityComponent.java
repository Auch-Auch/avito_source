package com.avito.android.messenger.di;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.di.PerActivity;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.fps.di.FpsModule;
import com.avito.android.messenger.conversation.ChannelActivityFragment;
import com.avito.android.messenger.di.ChannelFragmentComponent;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\nJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/di/ChannelActivityComponent;", "", "Lcom/avito/android/messenger/di/ChannelFragmentComponent$Builder;", "channelFragmentComponent", "()Lcom/avito/android/messenger/di/ChannelFragmentComponent$Builder;", "Lcom/avito/android/messenger/conversation/ChannelActivityFragment;", "fragment", "", "inject", "(Lcom/avito/android/messenger/conversation/ChannelActivityFragment;)V", "Builder", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ChannelActivityDependencies.class, ScreenAnalyticsDependencies.class}, modules = {ChannelActivityModule.class, FpsModule.class})
@PerActivity
public interface ChannelActivityComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/di/ChannelActivityComponent$Builder;", "", "Lcom/avito/android/messenger/di/ChannelActivityDependencies;", "dependencies", "channelActivityDependencies", "(Lcom/avito/android/messenger/di/ChannelActivityDependencies;)Lcom/avito/android/messenger/di/ChannelActivityComponent$Builder;", "Lcom/avito/android/di/module/ScreenAnalyticsDependencies;", "screenAnalyticsDependencies", "(Lcom/avito/android/di/module/ScreenAnalyticsDependencies;)Lcom/avito/android/messenger/di/ChannelActivityComponent$Builder;", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/messenger/di/ChannelActivityComponent$Builder;", "Lcom/avito/android/messenger/di/ChannelActivityComponent;", "build", "()Lcom/avito/android/messenger/di/ChannelActivityComponent;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ChannelActivityComponent build();

        @NotNull
        Builder channelActivityDependencies(@NotNull ChannelActivityDependencies channelActivityDependencies);

        @BindsInstance
        @NotNull
        Builder screen(@NotNull Screen screen);

        @NotNull
        Builder screenAnalyticsDependencies(@NotNull ScreenAnalyticsDependencies screenAnalyticsDependencies);
    }

    @NotNull
    ChannelFragmentComponent.Builder channelFragmentComponent();

    void inject(@NotNull ChannelActivityFragment channelActivityFragment);
}
