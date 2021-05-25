package com.sumsub.camera.selfie.with.document.presentation;

import android.content.Context;
import com.sumsub.sns.camera.R;
import com.sumsub.sns.camera.SNSCameraPhotoViewModel;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.DocumentType;
import com.sumsub.sns.core.domain.AddDirectFileToCacheUseCase;
import com.sumsub.sns.core.domain.SendLogUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/sumsub/camera/selfie/with/document/presentation/SNSSelfieWithDocumentPickerViewModel;", "Lcom/sumsub/sns/camera/SNSCameraPhotoViewModel;", "Landroid/content/Context;", "context", "", "initHelper", "(Landroid/content/Context;)V", "Lcom/sumsub/sns/core/data/model/Applicant;", "applicant", "Lcom/sumsub/sns/core/data/model/DocumentType;", "type", "Lcom/sumsub/sns/core/domain/AddDirectFileToCacheUseCase;", "addDirectFileToCacheUseCase", "Lcom/sumsub/sns/core/domain/SendLogUseCase;", "sendLogUseCase", "<init>", "(Lcom/sumsub/sns/core/data/model/Applicant;Lcom/sumsub/sns/core/data/model/DocumentType;Lcom/sumsub/sns/core/domain/AddDirectFileToCacheUseCase;Lcom/sumsub/sns/core/domain/SendLogUseCase;)V", "sns-camera-selfie-with-document-picker_release"}, k = 1, mv = {1, 4, 2})
public final class SNSSelfieWithDocumentPickerViewModel extends SNSCameraPhotoViewModel {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSSelfieWithDocumentPickerViewModel(@NotNull Applicant applicant, @NotNull DocumentType documentType, @NotNull AddDirectFileToCacheUseCase addDirectFileToCacheUseCase, @NotNull SendLogUseCase sendLogUseCase) {
        super(applicant, documentType, null, null, addDirectFileToCacheUseCase, sendLogUseCase, 12, null);
        Intrinsics.checkNotNullParameter(applicant, "applicant");
        Intrinsics.checkNotNullParameter(documentType, "type");
        Intrinsics.checkNotNullParameter(addDirectFileToCacheUseCase, "addDirectFileToCacheUseCase");
        Intrinsics.checkNotNullParameter(sendLogUseCase, "sendLogUseCase");
    }

    @Override // com.sumsub.sns.camera.SNSCameraViewModel
    public void initHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Timber.i("Selfie With Document Picker", new Object[0]);
        get_showProgressLiveData().setValue(Boolean.FALSE);
        get_helperTitleLiveData().setValue(ExtensionsKt.getStringResource$default(context, R.string.sns_step_SELFIE_photo_title, (String) null, 2, (Object) null));
        get_helperBriefLiveData().setValue(ExtensionsKt.getStringResource$default(context, R.string.sns_step_SELFIE_photo_brief, (String) null, 2, (Object) null));
        get_helperDetailsLiveData().setValue(ExtensionsKt.getStringResource$default(context, R.string.sns_step_SELFIE_photo_details, (String) null, 2, (Object) null));
    }
}
