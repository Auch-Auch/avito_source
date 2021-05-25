package com.avito.android.messenger.support.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.support.SupportChatFormInteractor;
import com.avito.android.messenger.support.SupportChatFormInteractorImpl;
import com.avito.android.messenger.support.SupportChatFormPresenter;
import com.avito.android.messenger.support.SupportChatFormPresenterImpl;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/support/di/SupportChatFormModule;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/Formatter;", "", "provideErrorFormatter", "(Landroid/content/res/Resources;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "viewModelFactory", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/messenger/support/SupportChatFormPresenter;", "provideSupportChatFormPresenter", "(Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;Landroidx/fragment/app/Fragment;)Lcom/avito/android/messenger/support/SupportChatFormPresenter;", "<init>", "()V", "Declarations", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class SupportChatFormModule {
    @NotNull
    public static final SupportChatFormModule INSTANCE = new SupportChatFormModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/support/di/SupportChatFormModule$Declarations;", "", "Lcom/avito/android/messenger/support/SupportChatFormPresenterImpl;", "impl", "Landroidx/lifecycle/ViewModel;", "bindSupportChatFormPresenterViewModel", "(Lcom/avito/android/messenger/support/SupportChatFormPresenterImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/support/SupportChatFormInteractorImpl;", "Lcom/avito/android/messenger/support/SupportChatFormInteractor;", "bindSupportChatFormInteractor", "(Lcom/avito/android/messenger/support/SupportChatFormInteractorImpl;)Lcom/avito/android/messenger/support/SupportChatFormInteractor;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        SupportChatFormInteractor bindSupportChatFormInteractor(@NotNull SupportChatFormInteractorImpl supportChatFormInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(SupportChatFormPresenterImpl.class)
        @IntoMap
        ViewModel bindSupportChatFormPresenterViewModel(@NotNull SupportChatFormPresenterImpl supportChatFormPresenterImpl);
    }

    @Provides
    @NotNull
    public final Formatter<Throwable> provideErrorFormatter(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ErrorFormatterImpl(resources);
    }

    @Provides
    @NotNull
    public final SupportChatFormPresenter provideSupportChatFormPresenter(@NotNull ViewModelFactory viewModelFactory, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(SupportChatFormPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (SupportChatFormPresenter) viewModel;
    }
}
