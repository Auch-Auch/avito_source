package com.avito.android.messenger.search.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.messenger.di.RelativeDateFormatterModule;
import com.avito.android.messenger.search.ChannelsSearchFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/search/di/ChannelsSearchFragmentComponent;", "", "Lcom/avito/android/messenger/search/ChannelsSearchFragment;", "fragment", "", "inject", "(Lcom/avito/android/messenger/search/ChannelsSearchFragment;)V", "Builder", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ChannelsSearchComponentDependencies.class}, modules = {RelativeDateFormatterModule.class, ChannelsSearchModule.class})
@PerFragment
public interface ChannelsSearchFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/search/di/ChannelsSearchFragmentComponent$Builder;", "", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/messenger/search/di/ChannelsSearchFragmentComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/messenger/search/di/ChannelsSearchFragmentComponent$Builder;", "Lcom/avito/android/messenger/search/di/ChannelsSearchComponentDependencies;", "dependencies", "channelsSearchDependencies", "(Lcom/avito/android/messenger/search/di/ChannelsSearchComponentDependencies;)Lcom/avito/android/messenger/search/di/ChannelsSearchFragmentComponent$Builder;", "Lcom/avito/android/messenger/search/di/ChannelsSearchFragmentComponent;", "build", "()Lcom/avito/android/messenger/search/di/ChannelsSearchFragmentComponent;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ChannelsSearchFragmentComponent build();

        @NotNull
        Builder channelsSearchDependencies(@NotNull ChannelsSearchComponentDependencies channelsSearchComponentDependencies);

        @BindsInstance
        @NotNull
        Builder fragment(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);
    }

    void inject(@NotNull ChannelsSearchFragment channelsSearchFragment);
}
