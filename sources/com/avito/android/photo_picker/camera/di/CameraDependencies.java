package com.avito.android.photo_picker.camera.di;

import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/photo_picker/camera/di/CameraDependencies;", "", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "()Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/permissions/PermissionHelper;", "permissionHelper", "()Lcom/avito/android/permissions/PermissionHelper;", "Lcom/avito/android/analytics/Analytics;", "analytics", "()Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/Features;", "features", "()Lcom/avito/android/Features;", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "exifExtraDataSerializer", "()Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "sharedPhotosStorage", "()Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "()Lcom/avito/android/util/PrivatePhotosStorage;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface CameraDependencies {
    @NotNull
    AbTestsConfigProvider abTestConfigProvider();

    @NotNull
    Analytics analytics();

    @NotNull
    ExifExtraDataSerializer exifExtraDataSerializer();

    @Override // com.avito.android.photo_picker.edit.di.EditPhotoDependencies
    @NotNull
    Features features();

    @NotNull
    PermissionHelper permissionHelper();

    @NotNull
    PrivatePhotosStorage privatePhotosStorage();

    @NotNull
    SchedulersFactory schedulersFactory();

    @NotNull
    SharedPhotosStorage sharedPhotosStorage();
}
