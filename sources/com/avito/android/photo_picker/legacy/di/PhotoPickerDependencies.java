package com.avito.android.photo_picker.legacy.di;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/photo_picker/legacy/di/PhotoPickerDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "computerVisionInteractor", "()Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "photoPickerEventTracker", "()Lcom/avito/android/analytics/PhotoPickerEventTracker;", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "sharedPhotosStorage", "()Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "()Lcom/avito/android/util/PrivatePhotosStorage;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoPickerDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AbTestsConfigProvider abTestConfigProvider();

    @NotNull
    ComputerVisionInteractor computerVisionInteractor();

    @NotNull
    PhotoPickerEventTracker photoPickerEventTracker();

    @Override // com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.photo_wizard.di.WizardImageUploadDependencies
    @NotNull
    PrivatePhotosStorage privatePhotosStorage();

    @Override // com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.photo_wizard.di.WizardImageUploadDependencies
    @NotNull
    SharedPhotosStorage sharedPhotosStorage();
}
