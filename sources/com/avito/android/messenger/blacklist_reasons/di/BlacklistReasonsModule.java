package com.avito.android.messenger.blacklist_reasons.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsPresenter;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsPresenterImpl;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/di/BlacklistReasonsModule;", "", "Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "factory", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsPresenter;", "provideBlacklistReasonsPresenter", "(Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;Landroidx/fragment/app/Fragment;)Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsPresenter;", "Lcom/avito/android/util/Formatter;", "", "provideErrorFormatter", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/util/Formatter;", "<init>", "()V", "Declarations", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class BlacklistReasonsModule {
    @NotNull
    public static final BlacklistReasonsModule INSTANCE = new BlacklistReasonsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/di/BlacklistReasonsModule$Declarations;", "", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsPresenterImpl;", "impl", "Landroidx/lifecycle/ViewModel;", "blacklistReasonsPresenterViewModel", "(Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsPresenterImpl;)Landroidx/lifecycle/ViewModel;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        @ClassKey(BlacklistReasonsPresenterImpl.class)
        @IntoMap
        ViewModel blacklistReasonsPresenterViewModel(@NotNull BlacklistReasonsPresenterImpl blacklistReasonsPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final BlacklistReasonsPresenter provideBlacklistReasonsPresenter(@NotNull ViewModelFactory viewModelFactory, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "factory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(BlacklistReasonsPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (BlacklistReasonsPresenter) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final Formatter<Throwable> provideErrorFormatter(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Resources resources = fragment.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "fragment.resources");
        return new ErrorFormatterImpl(resources);
    }
}
