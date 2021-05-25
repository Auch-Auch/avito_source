package com.avito.android.publish.sts_scanner.di;

import android.app.Application;
import android.content.Context;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H&¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H&¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H&¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H&¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H&¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H&¢\u0006\u0004\b6\u00107J\u000f\u00109\u001a\u000208H&¢\u0006\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lcom/avito/android/publish/sts_scanner/di/StsScannerDependencies;", "", "Lcom/avito/android/analytics/Analytics;", "analytics", "()Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "()Lcom/avito/android/util/SchedulersFactory;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "()Landroid/app/Application;", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "()Lcom/avito/android/publish/analytics/PublishEventTracker;", "Lcom/avito/android/remote/PublishApi;", "publishApi", "()Lcom/avito/android/remote/PublishApi;", "Lcom/avito/android/remote/ProfileApi;", "profileApi", "()Lcom/avito/android/remote/ProfileApi;", "Lcom/avito/android/remote/LocationApi;", "locationApi", "()Lcom/avito/android/remote/LocationApi;", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "publishAnalyticsDataProvider", "()Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", "publishDraftRepository", "()Lcom/avito/android/publish/drafts/PublishDraftRepository;", "Lcom/avito/android/Features;", "features", "()Lcom/avito/android/Features;", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "Landroid/content/Context;", "context", "()Landroid/content/Context;", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "()Lcom/avito/android/util/DeviceMetrics;", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "sharedPhotosStorage", "()Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "()Lcom/avito/android/util/PrivatePhotosStorage;", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "categoryParametersConverter", "()Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface StsScannerDependencies {
    @NotNull
    AbTestsConfigProvider abTestsConfigProvider();

    @NotNull
    ActivityIntentFactory activityIntentFactory();

    @NotNull
    Analytics analytics();

    @NotNull
    Application application();

    @NotNull
    CategoryParametersConverter categoryParametersConverter();

    @NotNull
    Context context();

    @NotNull
    DeepLinkIntentFactory deepLinkIntentFactory();

    @NotNull
    DeviceMetrics deviceMetrics();

    @NotNull
    Features features();

    @NotNull
    ImplicitIntentFactory implicitIntentFactory();

    @NotNull
    LocationApi locationApi();

    @NotNull
    PrivatePhotosStorage privatePhotosStorage();

    @NotNull
    ProfileApi profileApi();

    @NotNull
    PublishAnalyticsDataProvider publishAnalyticsDataProvider();

    @NotNull
    PublishApi publishApi();

    @NotNull
    PublishDraftRepository publishDraftRepository();

    @NotNull
    PublishEventTracker publishEventTracker();

    @NotNull
    SchedulersFactory schedulersFactory();

    @NotNull
    SharedPhotosStorage sharedPhotosStorage();
}
