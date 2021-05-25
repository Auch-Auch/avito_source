package com.avito.android.messenger.conversation.create.di;

import androidx.fragment.app.Fragment;
import com.avito.android.di.PerActivity;
import com.avito.android.messenger.conversation.create.CreateChannelFragment;
import com.avito.android.messenger.conversation.create.CreateChannelPresenter;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/create/di/CreateChannelFragmentComponent;", "", "Lcom/avito/android/messenger/conversation/create/CreateChannelFragment;", "fragment", "", "inject", "(Lcom/avito/android/messenger/conversation/create/CreateChannelFragment;)V", "Builder", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {CreateChannelFragmentDependencies.class}, modules = {CreateChannelFragmentModule.class})
@PerActivity
public interface CreateChannelFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/create/di/CreateChannelFragmentComponent$Builder;", "", "Lcom/avito/android/messenger/conversation/create/di/CreateChannelFragmentDependencies;", "dependencies", "createChannelFragmentDependencies", "(Lcom/avito/android/messenger/conversation/create/di/CreateChannelFragmentDependencies;)Lcom/avito/android/messenger/conversation/create/di/CreateChannelFragmentComponent$Builder;", "Landroidx/fragment/app/Fragment;", "reference", "fragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/messenger/conversation/create/di/CreateChannelFragmentComponent$Builder;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;", "state", "presenterState", "(Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter$State;)Lcom/avito/android/messenger/conversation/create/di/CreateChannelFragmentComponent$Builder;", "Lcom/avito/android/messenger/conversation/create/di/CreateChannelFragmentComponent;", "build", "()Lcom/avito/android/messenger/conversation/create/di/CreateChannelFragmentComponent;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        CreateChannelFragmentComponent build();

        @NotNull
        Builder createChannelFragmentDependencies(@NotNull CreateChannelFragmentDependencies createChannelFragmentDependencies);

        @BindsInstance
        @NotNull
        Builder fragment(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder presenterState(@NotNull CreateChannelPresenter.State state);
    }

    void inject(@NotNull CreateChannelFragment createChannelFragment);
}
