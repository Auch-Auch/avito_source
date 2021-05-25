package com.avito.android.publish.sts_scanner.di;

import android.app.Application;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.permissions.FragmentPermissionHelper;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.legacy.DeviceOrientationProvider;
import com.avito.android.photo_picker.legacy.DeviceOrientationProviderImpl;
import com.avito.android.photo_picker.legacy.GalleryResultsExtractor;
import com.avito.android.photo_picker.legacy.LegacyPhotoResizer;
import com.avito.android.photo_picker.legacy.PhotoResizer;
import com.avito.android.photo_picker.legacy.RotationInteractor;
import com.avito.android.photo_picker.legacy.StoppableRotationInteractor;
import com.avito.android.photo_picker.legacy.StoppableRotationInteractorImpl;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.di.PublishParametersModule;
import com.avito.android.publish.sts_scanner.StsScannerPresenter;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.NoOpCallableResponsiveItemPresenterRegistry;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u00108\u001a\u000205¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u001a\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010%\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0001¢\u0006\u0004\b#\u0010$J\u000f\u0010)\u001a\u00020&H\u0001¢\u0006\u0004\b'\u0010(J'\u0010/\u001a\u00020\u00112\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020 H\u0007¢\u0006\u0004\b/\u00100R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/avito/android/publish/sts_scanner/di/StsScannerModule;", "", "Lcom/avito/android/permissions/PermissionHelper;", "providePermissionHelper$publish_release", "()Lcom/avito/android/permissions/PermissionHelper;", "providePermissionHelper", "Lcom/avito/android/photo_picker/legacy/DeviceOrientationProvider;", "orientationProvider", "Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;", "provideStoppableRotationInteractor$publish_release", "(Lcom/avito/android/photo_picker/legacy/DeviceOrientationProvider;)Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;", "provideStoppableRotationInteractor", "stoppableRotationInteractor", "Lcom/avito/android/photo_picker/legacy/RotationInteractor;", "provideRotationInteractor$publish_release", "(Lcom/avito/android/photo_picker/legacy/StoppableRotationInteractor;)Lcom/avito/android/photo_picker/legacy/RotationInteractor;", "provideRotationInteractor", "Lcom/avito/android/publish/sts_scanner/StsScannerPresenter;", "presenter", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Listener;", "provideListener$publish_release", "(Lcom/avito/android/publish/sts_scanner/StsScannerPresenter;)Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Listener;", "provideListener", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideCallableResponsiveItemPresenterRegistry$publish_release", "()Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "provideCallableResponsiveItemPresenterRegistry", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "provideDeviceOrientationProvider$publish_release", "(Landroid/app/Application;)Lcom/avito/android/photo_picker/legacy/DeviceOrientationProvider;", "provideDeviceOrientationProvider", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "providePhotoSaver$publish_release", "(Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "providePhotoSaver", "Lcom/avito/android/photo_picker/legacy/GalleryResultsExtractor;", "provideGalleryResultsExtractor$publish_release", "()Lcom/avito/android/photo_picker/legacy/GalleryResultsExtractor;", "provideGalleryResultsExtractor", "Lcom/avito/android/publish/PublishParametersInteractor;", "publishParametersInteractor", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "schedulersFactory", "providerStsScannerPresenter", "(Lcom/avito/android/publish/PublishParametersInteractor;Lcom/avito/android/publish/analytics/PublishEventTracker;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/publish/sts_scanner/StsScannerPresenter;", "Landroidx/fragment/app/Fragment;", AuthSource.SEND_ABUSE, "Landroidx/fragment/app/Fragment;", "fragment", "", AuthSource.BOOKING_ORDER, "I", "stepIndex", "<init>", "(Landroidx/fragment/app/Fragment;I)V", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PublishParametersModule.class})
public final class StsScannerModule {
    public final Fragment a;
    public final int b;

    public StsScannerModule(@NotNull Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.a = fragment;
        this.b = i;
    }

    @Provides
    @PerFragment
    @NotNull
    public final CallableResponsiveItemPresenterRegistry provideCallableResponsiveItemPresenterRegistry$publish_release() {
        return new NoOpCallableResponsiveItemPresenterRegistry();
    }

    @Provides
    @PerFragment
    @NotNull
    public final DeviceOrientationProvider provideDeviceOrientationProvider$publish_release(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        return new DeviceOrientationProviderImpl(application);
    }

    @Provides
    @PerFragment
    @NotNull
    public final GalleryResultsExtractor provideGalleryResultsExtractor$publish_release() {
        return new GalleryResultsExtractor();
    }

    @Provides
    @PerFragment
    @NotNull
    public final CameraItemPresenter.Listener provideListener$publish_release(@NotNull StsScannerPresenter stsScannerPresenter) {
        Intrinsics.checkNotNullParameter(stsScannerPresenter, "presenter");
        return stsScannerPresenter;
    }

    @Provides
    @PerFragment
    @NotNull
    public final PermissionHelper providePermissionHelper$publish_release() {
        return new FragmentPermissionHelper(this.a);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PhotoResizer providePhotoSaver$publish_release(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        return new LegacyPhotoResizer(schedulersFactory, 95);
    }

    @Provides
    @PerFragment
    @NotNull
    public final RotationInteractor provideRotationInteractor$publish_release(@NotNull StoppableRotationInteractor stoppableRotationInteractor) {
        Intrinsics.checkNotNullParameter(stoppableRotationInteractor, "stoppableRotationInteractor");
        return stoppableRotationInteractor;
    }

    @Provides
    @PerFragment
    @NotNull
    public final StoppableRotationInteractor provideStoppableRotationInteractor$publish_release(@NotNull DeviceOrientationProvider deviceOrientationProvider) {
        Intrinsics.checkNotNullParameter(deviceOrientationProvider, "orientationProvider");
        return new StoppableRotationInteractorImpl(deviceOrientationProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final StsScannerPresenter providerStsScannerPresenter(@NotNull PublishParametersInteractor publishParametersInteractor, @NotNull PublishEventTracker publishEventTracker, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(publishParametersInteractor, "publishParametersInteractor");
        Intrinsics.checkNotNullParameter(publishEventTracker, "publishEventTracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new StsScannerPresenter(publishParametersInteractor, publishEventTracker, schedulersFactory, this.b);
    }
}
