package com.avito.android.rating.publish.deal_proofs.di;

import android.app.Activity;
import android.content.ContentResolver;
import android.os.Looper;
import com.avito.android.DealProofsIntentFactory;
import com.avito.android.di.PerFragment;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.PhotoInteractorImpl;
import com.avito.android.photo_picker.legacy.service.UploadingInteractor;
import com.avito.android.photo_picker.legacy.service.UploadingInteractorImpl;
import com.avito.android.photo_view.ImageListInteractor;
import com.avito.android.photo_view.ImageListInteractorImpl;
import com.avito.android.photo_view.ImageListPresenter;
import com.avito.android.photo_view.ImageListPresenterImpl;
import com.avito.android.rating.publish.deal_proofs.DealProofsIntentFactoryImpl;
import com.avito.android.rating.publish.deal_proofs.DealProofsPresenter;
import com.avito.android.rating.publish.deal_proofs.DealProofsPresenterImpl;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/avito/android/rating/publish/deal_proofs/di/DealProofsModule;", "", "Landroid/app/Activity;", "context", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "providePhotoInteractor$rating_release", "(Landroid/app/Activity;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "providePhotoInteractor", "Lcom/avito/android/photo_view/ImageListInteractor;", "imageListInteractor", "Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "uploadingInteractor", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/photo_view/ImageListPresenter;", "provideImageListPresenter$rating_release", "(Lcom/avito/android/photo_view/ImageListInteractor;Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/photo_view/ImageListPresenter;", "provideImageListPresenter", "", "operationId", "provideUploadingInteractor$rating_release", "(Landroid/app/Activity;Ljava/lang/String;)Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "provideUploadingInteractor", "photoInteractor", "provideImageListInteractor$rating_release", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/photo_picker/legacy/PhotoInteractor;Ljava/lang/String;)Lcom/avito/android/photo_view/ImageListInteractor;", "provideImageListInteractor", "<init>", "()V", "Declarations", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class DealProofsModule {
    @NotNull
    public static final DealProofsModule INSTANCE = new DealProofsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/rating/publish/deal_proofs/di/DealProofsModule$Declarations;", "", "Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenterImpl;", "presenter", "Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenter;", "bindDealProofsPresenter", "(Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenterImpl;)Lcom/avito/android/rating/publish/deal_proofs/DealProofsPresenter;", "Lcom/avito/android/rating/publish/deal_proofs/DealProofsIntentFactoryImpl;", "Lcom/avito/android/DealProofsIntentFactory;", "bindRatingsIntentFactory", "(Lcom/avito/android/rating/publish/deal_proofs/DealProofsIntentFactoryImpl;)Lcom/avito/android/DealProofsIntentFactory;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        DealProofsPresenter bindDealProofsPresenter(@NotNull DealProofsPresenterImpl dealProofsPresenterImpl);

        @Binds
        @NotNull
        DealProofsIntentFactory bindRatingsIntentFactory(@NotNull DealProofsIntentFactoryImpl dealProofsIntentFactoryImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ImageListInteractor provideImageListInteractor$rating_release(@NotNull SchedulersFactory schedulersFactory, @NotNull PhotoInteractor photoInteractor, @NotNull String str) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        Intrinsics.checkNotNullParameter(str, "operationId");
        return new ImageListInteractorImpl(str, schedulersFactory, photoInteractor);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ImageListPresenter provideImageListPresenter$rating_release(@NotNull ImageListInteractor imageListInteractor, @NotNull UploadingInteractor uploadingInteractor, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(imageListInteractor, "imageListInteractor");
        Intrinsics.checkNotNullParameter(uploadingInteractor, "uploadingInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new ImageListPresenterImpl(imageListInteractor, uploadingInteractor, schedulersFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final PhotoInteractor providePhotoInteractor$rating_release(@NotNull Activity activity, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Looper mainLooper = activity.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "context.mainLooper");
        ContentResolver contentResolver = activity.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
        return new PhotoInteractorImpl(mainLooper, buildInfo, contentResolver, null, 8, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final UploadingInteractor provideUploadingInteractor$rating_release(@NotNull Activity activity, @NotNull String str) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(str, "operationId");
        return new UploadingInteractorImpl(activity, str, false, 4, null);
    }
}
