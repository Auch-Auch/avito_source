package com.avito.android.publish.infomodel_request.di;

import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.di.PerFragment;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.progress_overlay.LoadingProgressOverlayImpl;
import com.avito.android.publish.di.GsonModule;
import com.avito.android.publish.di.PublishParametersModule;
import com.avito.android.publish.infomodel_request.InfomodelRequestViewModelFactory;
import com.avito.android.publish.infomodel_request.InfomodelRequestViewModelFactoryImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/publish/infomodel_request/di/InfomodelRequestModule;", "", "Lcom/avito/android/publish/infomodel_request/InfomodelRequestViewModelFactoryImpl;", "viewModelFactory", "Lcom/avito/android/publish/infomodel_request/InfomodelRequestViewModelFactory;", "provideInfomodelRequestViewModelFactory", "(Lcom/avito/android/publish/infomodel_request/InfomodelRequestViewModelFactoryImpl;)Lcom/avito/android/publish/infomodel_request/InfomodelRequestViewModelFactory;", "Lcom/avito/android/progress_overlay/LoadingProgressOverlayImpl;", "progressOverlay", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "provideLoadingProgressOverlay", "(Lcom/avito/android/progress_overlay/LoadingProgressOverlayImpl;)Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker$Impl;", "resolver", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "UnknownScreenTracker", "(Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker$Impl;)Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PublishParametersModule.class, GsonModule.class})
public interface InfomodelRequestModule {
    @PerFragment
    @Binds
    @NotNull
    UnknownScreenTracker UnknownScreenTracker(@NotNull UnknownScreenTracker.Impl impl);

    @PerFragment
    @Binds
    @NotNull
    InfomodelRequestViewModelFactory provideInfomodelRequestViewModelFactory(@NotNull InfomodelRequestViewModelFactoryImpl infomodelRequestViewModelFactoryImpl);

    @PerFragment
    @Binds
    @NotNull
    LoadingProgressOverlay provideLoadingProgressOverlay(@NotNull LoadingProgressOverlayImpl loadingProgressOverlayImpl);
}
