package com.avito.android.photo_wizard.di;

import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.photo_wizard.remote.PhotoWizardApi;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/photo_wizard/di/WizardImageUploadDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/photo_wizard/remote/PhotoWizardApi;", "photoWizardApi", "()Lcom/avito/android/photo_wizard/remote/PhotoWizardApi;", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "sharedPhotosStorage", "()Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "()Lcom/avito/android/util/PrivatePhotosStorage;", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public interface WizardImageUploadDependencies extends CoreComponentDependencies {
    @NotNull
    PhotoWizardApi photoWizardApi();

    @NotNull
    PrivatePhotosStorage privatePhotosStorage();

    @NotNull
    SharedPhotosStorage sharedPhotosStorage();
}
