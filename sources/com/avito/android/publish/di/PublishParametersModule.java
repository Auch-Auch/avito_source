package com.avito.android.publish.di;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.photo.ImageConvertOptions;
import com.avito.android.photo_picker.legacy.api.UploadConverter;
import com.avito.android.photo_picker.legacy.service.BitmapConverterForGallery;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.PublishParametersInteractorImpl;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.AttributesTreeConverter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 JQ\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/avito/android/publish/di/PublishParametersModule;", "", "Lcom/avito/android/remote/PublishApi;", "publishApi", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", "publishDraftRepository", "Lcom/avito/android/photo_picker/legacy/api/UploadConverter;", "converter", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "paramConverter", "Lcom/avito/android/remote/model/category_parameters/AttributesTreeConverter;", "attributesTreeConverter", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "publishDraftWiper", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/publish/PublishParametersInteractor;", "providePublishParametersInteractor", "(Lcom/avito/android/remote/PublishApi;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/publish/drafts/PublishDraftRepository;Lcom/avito/android/photo_picker/legacy/api/UploadConverter;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/remote/model/category_parameters/AttributesTreeConverter;Lcom/avito/android/publish/drafts/PublishDraftWiper;Lcom/avito/android/Features;)Lcom/avito/android/publish/PublishParametersInteractor;", "Landroid/content/Context;", "context", "Lcom/avito/android/analytics/Analytics;", "analytics", "provideUploadConverter", "(Landroid/content/Context;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/photo_picker/legacy/api/UploadConverter;", "Lcom/avito/android/photo/ImageConvertOptions;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo/ImageConvertOptions;", "IMAGE_CONVERT_OPTIONS", "<init>", "()V", "GalleryPhotoConverter", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PublishParametersModule {
    public final ImageConvertOptions a = new ImageConvertOptions(960, 1280, 95, 4194304);

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/di/PublishParametersModule$GalleryPhotoConverter;", "", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface GalleryPhotoConverter {
    }

    @Provides
    @Reusable
    @NotNull
    public final PublishParametersInteractor providePublishParametersInteractor(@NotNull PublishApi publishApi, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull PublishDraftRepository publishDraftRepository, @GalleryPhotoConverter @NotNull UploadConverter uploadConverter, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull AttributesTreeConverter attributesTreeConverter, @NotNull PublishDraftWiper publishDraftWiper, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(publishDraftRepository, "publishDraftRepository");
        Intrinsics.checkNotNullParameter(uploadConverter, "converter");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "paramConverter");
        Intrinsics.checkNotNullParameter(attributesTreeConverter, "attributesTreeConverter");
        Intrinsics.checkNotNullParameter(publishDraftWiper, "publishDraftWiper");
        Intrinsics.checkNotNullParameter(features, "features");
        return new PublishParametersInteractorImpl(publishApi, publishDraftRepository, new MutablePropertyReference0Impl(publishAnalyticsDataProvider) { // from class: a2.a.a.e2.s.a
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            @Nullable
            public Object get() {
                return ((PublishAnalyticsDataProvider) this.receiver).getSessionId();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(@Nullable Object obj) {
                ((PublishAnalyticsDataProvider) this.receiver).setSessionId((String) obj);
            }
        }, uploadConverter, categoryParametersConverter, publishDraftWiper, attributesTreeConverter, features);
    }

    @Provides
    @Reusable
    @NotNull
    @GalleryPhotoConverter
    public final UploadConverter provideUploadConverter(@NotNull Context context, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new BitmapConverterForGallery(context, this.a, analytics);
    }
}
