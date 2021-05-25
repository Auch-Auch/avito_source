package com.avito.android.photo_wizard.di;

import android.content.res.Resources;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_wizard.PhotoWizardFragment;
import com.avito.android.photo_wizard.di.module.PhotoWizardModule;
import com.avito.android.photo_wizard.di.module.WizardPhotoPickerPresenterModule;
import com.avito.android.photo_wizard.di.qualifier.AdvertId;
import com.avito.android.remote.model.VerificationStep;
import dagger.BindsInstance;
import dagger.Component;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/photo_wizard/di/PhotoWizardComponent;", "", "Lcom/avito/android/photo_wizard/PhotoWizardFragment;", "fragment", "", "inject", "(Lcom/avito/android/photo_wizard/PhotoWizardFragment;)V", "Builder", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {WizardImageUploadDependencies.class}, modules = {PhotoWizardModule.class, WizardPhotoPickerPresenterModule.class})
@PerFragment
public interface PhotoWizardComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/photo_wizard/di/PhotoWizardComponent$Builder;", "", "Lcom/avito/android/photo_wizard/di/WizardImageUploadDependencies;", "dependencies", "(Lcom/avito/android/photo_wizard/di/WizardImageUploadDependencies;)Lcom/avito/android/photo_wizard/di/PhotoWizardComponent$Builder;", "", BookingInfoActivity.EXTRA_ITEM_ID, "withAdvertId", "(Ljava/lang/String;)Lcom/avito/android/photo_wizard/di/PhotoWizardComponent$Builder;", "", "Lcom/avito/android/remote/model/VerificationStep;", "steps", "withVerificationSteps", "(Ljava/util/List;)Lcom/avito/android/photo_wizard/di/PhotoWizardComponent$Builder;", "Lcom/avito/android/permissions/PermissionHelper;", "helper", "withPermissionHelper", "(Lcom/avito/android/permissions/PermissionHelper;)Lcom/avito/android/photo_wizard/di/PhotoWizardComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/photo_wizard/di/PhotoWizardComponent$Builder;", "Lcom/avito/android/photo_wizard/di/PhotoWizardComponent;", "build", "()Lcom/avito/android/photo_wizard/di/PhotoWizardComponent;", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PhotoWizardComponent build();

        @NotNull
        Builder dependencies(@NotNull WizardImageUploadDependencies wizardImageUploadDependencies);

        @BindsInstance
        @NotNull
        Builder withAdvertId(@AdvertId @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withPermissionHelper(@NotNull PermissionHelper permissionHelper);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withVerificationSteps(@NotNull List<VerificationStep> list);
    }

    void inject(@NotNull PhotoWizardFragment photoWizardFragment);
}
