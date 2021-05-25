package com.sumsub.sns.camera.photo.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder;
import com.sumsub.sns.camera.SNSCameraPhotoViewModel;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.DocumentType;
import com.sumsub.sns.core.data.model.IdentitySide;
import com.sumsub.sns.core.data.model.IdentityType;
import com.sumsub.sns.core.domain.AddDirectFileToCacheUseCase;
import com.sumsub.sns.core.domain.SendLogUseCase;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/camera/photo/presentation/SNSPhotoDocumentPickerViewModel;", "Lcom/sumsub/sns/camera/SNSCameraPhotoViewModel;", "Landroidx/lifecycle/LiveData;", "", "getFrame", "()Landroidx/lifecycle/LiveData;", TextureMediaEncoder.FRAME_EVENT, "Landroidx/lifecycle/MutableLiveData;", "x", "Landroidx/lifecycle/MutableLiveData;", "_frameLiveData", "Lcom/sumsub/sns/core/data/model/Applicant;", "applicant", "Lcom/sumsub/sns/core/data/model/DocumentType;", "type", "", "identityType", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "side", "Lcom/sumsub/sns/core/domain/AddDirectFileToCacheUseCase;", "addDirectFileToCacheUseCase", "Lcom/sumsub/sns/core/domain/SendLogUseCase;", "sendLogUseCase", "<init>", "(Lcom/sumsub/sns/core/data/model/Applicant;Lcom/sumsub/sns/core/data/model/DocumentType;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/IdentitySide;Lcom/sumsub/sns/core/domain/AddDirectFileToCacheUseCase;Lcom/sumsub/sns/core/domain/SendLogUseCase;)V", "sns-camera-photo-document-picker_release"}, k = 1, mv = {1, 4, 2})
public final class SNSPhotoDocumentPickerViewModel extends SNSCameraPhotoViewModel {
    public final MutableLiveData<Integer> x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSPhotoDocumentPickerViewModel(@NotNull Applicant applicant, @NotNull DocumentType documentType, @Nullable String str, @Nullable IdentitySide identitySide, @NotNull AddDirectFileToCacheUseCase addDirectFileToCacheUseCase, @NotNull SendLogUseCase sendLogUseCase) {
        super(applicant, documentType, str, identitySide, addDirectFileToCacheUseCase, sendLogUseCase);
        Intrinsics.checkNotNullParameter(applicant, "applicant");
        Intrinsics.checkNotNullParameter(documentType, "type");
        Intrinsics.checkNotNullParameter(addDirectFileToCacheUseCase, "addDirectFileToCacheUseCase");
        Intrinsics.checkNotNullParameter(sendLogUseCase, "sendLogUseCase");
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this.x = mutableLiveData;
        Timber.i("Photo document picker is created", new Object[0]);
        IdentityType identityType = (IdentityType) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) applicant.getIdentityList(documentType));
        Integer num = null;
        String r2 = identityType != null ? identityType.m209unboximpl() : null;
        mutableLiveData.setValue(r2 != null ? Integer.valueOf(IdentityType.m205getFrameIdimpl(r2)) : num);
        get_showProgressLiveData().setValue(Boolean.FALSE);
        get_showTakePictureLiveData().setValue(Boolean.TRUE);
        Timber.d("SDK is using - " + String.valueOf(r2), new Object[0]);
    }

    @NotNull
    public final LiveData<Integer> getFrame() {
        return this.x;
    }
}
