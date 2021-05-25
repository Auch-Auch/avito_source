package com.avito.android.publish_limits_info.history.di;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.di.PerActivity;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.progress_overlay.LoadingProgressOverlayImpl;
import com.avito.android.progress_overlay.ProgressDialogRouter;
import com.avito.android.publish_limits_info.history.PublishLimitsHistoryInteractor;
import com.avito.android.publish_limits_info.history.PublishLimitsHistoryInteractorImpl;
import com.avito.android.publish_limits_info.history.PublishLimitsHistoryViewModel;
import com.avito.android.publish_limits_info.history.PublishLimitsHistoryViewModelFactory;
import com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryProvider;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish_limits_info/history/di/PublishLimitsHistoryModule;", "", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/avito/android/progress_overlay/ProgressDialogRouter;", "provideDialogRouter", "(Landroidx/fragment/app/FragmentActivity;)Lcom/avito/android/progress_overlay/ProgressDialogRouter;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryViewModel;", "provideViewModel", "(Landroidx/fragment/app/FragmentActivity;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryViewModel;", "viewModel", "Lcom/avito/android/publish_limits_info/history/tab/PublishAdvertsHistoryProvider;", "provideHistoryProvider", "(Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryViewModel;)Lcom/avito/android/publish_limits_info/history/tab/PublishAdvertsHistoryProvider;", "<init>", "()V", "Declarations", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class PublishLimitsHistoryModule {
    @NotNull
    public static final PublishLimitsHistoryModule INSTANCE = new PublishLimitsHistoryModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/publish_limits_info/history/di/PublishLimitsHistoryModule$Declarations;", "", "Lcom/avito/android/progress_overlay/LoadingProgressOverlayImpl;", "progressOverlay", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "provideLoadingProgressOverlay", "(Lcom/avito/android/progress_overlay/LoadingProgressOverlayImpl;)Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryInteractorImpl;", "interactor", "Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryInteractor;", "provideHistoryInteractor", "(Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryInteractorImpl;)Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryInteractor;", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        PublishLimitsHistoryInteractor provideHistoryInteractor(@NotNull PublishLimitsHistoryInteractorImpl publishLimitsHistoryInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        LoadingProgressOverlay provideLoadingProgressOverlay(@NotNull LoadingProgressOverlayImpl loadingProgressOverlayImpl);

        @PerActivity
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull PublishLimitsHistoryViewModelFactory publishLimitsHistoryViewModelFactory);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ProgressDialogRouter provideDialogRouter(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        return new ProgressDialogRouter(fragmentActivity);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PublishAdvertsHistoryProvider provideHistoryProvider(@NotNull PublishLimitsHistoryViewModel publishLimitsHistoryViewModel) {
        Intrinsics.checkNotNullParameter(publishLimitsHistoryViewModel, "viewModel");
        return publishLimitsHistoryViewModel;
    }

    @Provides
    @PerActivity
    @NotNull
    public final PublishLimitsHistoryViewModel provideViewModel(@NotNull FragmentActivity fragmentActivity, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragmentActivity, factory).get(PublishLimitsHistoryViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi…oryViewModel::class.java)");
        return (PublishLimitsHistoryViewModel) viewModel;
    }
}
