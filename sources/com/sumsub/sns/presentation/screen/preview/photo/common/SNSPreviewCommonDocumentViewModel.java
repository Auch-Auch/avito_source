package com.sumsub.sns.presentation.screen.preview.photo.common;

import androidx.lifecycle.SavedStateHandle;
import com.google.gson.Gson;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.domain.GetApplicantUseCase;
import com.sumsub.sns.core.domain.GetConfigUseCase;
import com.sumsub.sns.core.domain.SendLogUseCase;
import com.sumsub.sns.domain.UploadDocumentImagesUseCase;
import com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/common/SNSPreviewCommonDocumentViewModel;", "Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel;", "Lcom/sumsub/sns/core/domain/GetConfigUseCase;", "getConfigUseCase", "Lcom/sumsub/sns/core/domain/GetApplicantUseCase;", "getApplicantUseCase", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "Lcom/sumsub/sns/domain/UploadDocumentImagesUseCase;", "uploadDocumentImagesUseCase", "Lcom/sumsub/sns/core/domain/SendLogUseCase;", "sendLogUseCase", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/sumsub/sns/core/domain/GetConfigUseCase;Lcom/sumsub/sns/core/domain/GetApplicantUseCase;Landroidx/lifecycle/SavedStateHandle;Lcom/sumsub/sns/domain/UploadDocumentImagesUseCase;Lcom/sumsub/sns/core/domain/SendLogUseCase;Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/google/gson/Gson;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSPreviewCommonDocumentViewModel extends SNSPreviewPhotoDocumentViewModel {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSPreviewCommonDocumentViewModel(@NotNull GetConfigUseCase getConfigUseCase, @NotNull GetApplicantUseCase getApplicantUseCase, @NotNull SavedStateHandle savedStateHandle, @NotNull UploadDocumentImagesUseCase uploadDocumentImagesUseCase, @NotNull SendLogUseCase sendLogUseCase, @NotNull CommonRepository commonRepository, @NotNull Gson gson) {
        super(getConfigUseCase, getApplicantUseCase, savedStateHandle, commonRepository, uploadDocumentImagesUseCase, sendLogUseCase, gson);
        Intrinsics.checkNotNullParameter(getConfigUseCase, "getConfigUseCase");
        Intrinsics.checkNotNullParameter(getApplicantUseCase, "getApplicantUseCase");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(uploadDocumentImagesUseCase, "uploadDocumentImagesUseCase");
        Intrinsics.checkNotNullParameter(sendLogUseCase, "sendLogUseCase");
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Timber.i("Preview Common Document is created", new Object[0]);
        onLoad();
    }
}
