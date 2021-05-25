package com.avito.android.messenger.conversation.create.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.conversation.create.CreateChannelInteractor;
import com.avito.android.messenger.conversation.create.CreateChannelInteractorImpl;
import com.avito.android.messenger.conversation.create.CreateChannelPresenter;
import com.avito.android.messenger.conversation.create.CreateChannelPresenterImpl;
import com.avito.android.messenger.di.MessengerRepoModule;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/create/di/CreateChannelFragmentModule;", "", "Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "viewModelFactory", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter;", "provideCreateChannelPresenter$messenger_release", "(Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;Landroidx/fragment/app/Fragment;)Lcom/avito/android/messenger/conversation/create/CreateChannelPresenter;", "provideCreateChannelPresenter", "<init>", "()V", "Declarations", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, MessengerRepoModule.class})
public final class CreateChannelFragmentModule {
    @NotNull
    public static final CreateChannelFragmentModule INSTANCE = new CreateChannelFragmentModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/conversation/create/di/CreateChannelFragmentModule$Declarations;", "", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractorImpl;", "impl", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor;", "createChannelInteractor", "(Lcom/avito/android/messenger/conversation/create/CreateChannelInteractorImpl;)Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor;", "Lcom/avito/android/messenger/conversation/create/CreateChannelPresenterImpl;", "Landroidx/lifecycle/ViewModel;", "createChannelPresenterViewModel", "(Lcom/avito/android/messenger/conversation/create/CreateChannelPresenterImpl;)Landroidx/lifecycle/ViewModel;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        CreateChannelInteractor createChannelInteractor(@NotNull CreateChannelInteractorImpl createChannelInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(CreateChannelPresenterImpl.class)
        @IntoMap
        ViewModel createChannelPresenterViewModel(@NotNull CreateChannelPresenterImpl createChannelPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final CreateChannelPresenter provideCreateChannelPresenter$messenger_release(@NotNull ViewModelFactory viewModelFactory, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(CreateChannelPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (CreateChannelPresenter) viewModel;
    }
}
