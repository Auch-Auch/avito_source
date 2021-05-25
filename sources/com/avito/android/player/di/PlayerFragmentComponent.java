package com.avito.android.player.di;

import android.content.Context;
import android.content.res.Resources;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.player.view.PlayerFragment;
import com.avito.android.rec.ScreenSource;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/player/di/PlayerFragmentComponent;", "", "Lcom/avito/android/player/view/PlayerFragment;", "fragment", "", "inject", "(Lcom/avito/android/player/view/PlayerFragment;)V", "Builder", "player_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PlayerFragmentDependencies.class, ScreenAnalyticsDependencies.class}, modules = {PlayerFragmentModule.class})
@PerFragment
public interface PlayerFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00002\b\b\u0001\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H'¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001a\u001a\u00020\u00002\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0011H'¢\u0006\u0004\b\u001a\u0010\u0014J\u001b\u0010\u001c\u001a\u00020\u00002\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0011H'¢\u0006\u0004\b\u001c\u0010\u0014J\u0017\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dH'¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/avito/android/player/di/PlayerFragmentComponent$Builder;", "", "Lcom/avito/android/player/di/PlayerFragmentDependencies;", "dependencies", "withPlayerDependencies", "(Lcom/avito/android/player/di/PlayerFragmentDependencies;)Lcom/avito/android/player/di/PlayerFragmentComponent$Builder;", "Lcom/avito/android/di/module/ScreenAnalyticsDependencies;", "withScreenAnalyticsDependencies", "(Lcom/avito/android/di/module/ScreenAnalyticsDependencies;)Lcom/avito/android/player/di/PlayerFragmentComponent$Builder;", "Landroid/content/Context;", "context", "withViewContext", "(Landroid/content/Context;)Lcom/avito/android/player/di/PlayerFragmentComponent$Builder;", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "withScreen", "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/player/di/PlayerFragmentComponent$Builder;", "", "url", "withMediaUrl", "(Ljava/lang/String;)Lcom/avito/android/player/di/PlayerFragmentComponent$Builder;", "Lcom/avito/android/rec/ScreenSource;", "screenSource", "withScreenSource", "(Lcom/avito/android/rec/ScreenSource;)Lcom/avito/android/player/di/PlayerFragmentComponent$Builder;", "slug", "withMediaSlug", "blockType", "withMediaBlockType", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/player/di/PlayerFragmentComponent$Builder;", "Lcom/avito/android/player/di/PlayerFragmentComponent;", "build", "()Lcom/avito/android/player/di/PlayerFragmentComponent;", "player_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PlayerFragmentComponent build();

        @BindsInstance
        @NotNull
        Builder withMediaBlockType(@PlayerMediaBockType @Nullable String str);

        @BindsInstance
        @NotNull
        Builder withMediaSlug(@PlayerMediaSlug @Nullable String str);

        @BindsInstance
        @NotNull
        Builder withMediaUrl(@PlayerMediaUrl @NotNull String str);

        @NotNull
        Builder withPlayerDependencies(@NotNull PlayerFragmentDependencies playerFragmentDependencies);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withScreen(@NotNull Screen screen);

        @NotNull
        Builder withScreenAnalyticsDependencies(@NotNull ScreenAnalyticsDependencies screenAnalyticsDependencies);

        @BindsInstance
        @NotNull
        Builder withScreenSource(@NotNull ScreenSource screenSource);

        @BindsInstance
        @NotNull
        Builder withViewContext(@ViewContext @NotNull Context context);
    }

    void inject(@NotNull PlayerFragment playerFragment);
}
