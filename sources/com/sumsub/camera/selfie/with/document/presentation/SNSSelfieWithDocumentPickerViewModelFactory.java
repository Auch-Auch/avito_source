package com.sumsub.camera.selfie.with.document.presentation;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import com.avito.android.util.UrlParams;
import com.sumsub.sns.camera.SNSCameraActivity;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.DocumentType;
import com.sumsub.sns.core.domain.AddDirectFileToCacheUseCase;
import com.sumsub.sns.core.domain.SendLogUseCase;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\n\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/sumsub/camera/selfie/with/document/presentation/SNSSelfieWithDocumentPickerViewModelFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModel;", "T", "", "key", "Ljava/lang/Class;", "modelClass", "Landroidx/lifecycle/SavedStateHandle;", "state", "create", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "Lcom/sumsub/sns/core/ServiceLocator;", "d", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "Landroidx/savedstate/SavedStateRegistryOwner;", UrlParams.OWNER, "Landroid/os/Bundle;", "args", "<init>", "(Landroidx/savedstate/SavedStateRegistryOwner;Lcom/sumsub/sns/core/ServiceLocator;Landroid/os/Bundle;)V", "sns-camera-selfie-with-document-picker_release"}, k = 1, mv = {1, 4, 2})
public final class SNSSelfieWithDocumentPickerViewModelFactory extends AbstractSavedStateViewModelFactory {
    public final ServiceLocator d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSSelfieWithDocumentPickerViewModelFactory(SavedStateRegistryOwner savedStateRegistryOwner, ServiceLocator serviceLocator, Bundle bundle, int i, j jVar) {
        this(savedStateRegistryOwner, serviceLocator, (i & 4) != 0 ? null : bundle);
    }

    @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
    public <T extends ViewModel> T create(@NotNull String str, @NotNull Class<T> cls, @NotNull SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Intrinsics.checkNotNullParameter(savedStateHandle, "state");
        Object obj = savedStateHandle.get(SNSCameraActivity.EXTRA_APPLICANT);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.sumsub.sns.core.data.model.Applicant");
        return new SNSSelfieWithDocumentPickerViewModel((Applicant) obj, DocumentType.Companion.create((String) savedStateHandle.get(SNSCameraActivity.EXTRA_DOCUMENT_TYPE)), new AddDirectFileToCacheUseCase(this.d), new SendLogUseCase(this.d));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSSelfieWithDocumentPickerViewModelFactory(@NotNull SavedStateRegistryOwner savedStateRegistryOwner, @NotNull ServiceLocator serviceLocator, @Nullable Bundle bundle) {
        super(savedStateRegistryOwner, bundle);
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, UrlParams.OWNER);
        Intrinsics.checkNotNullParameter(serviceLocator, "serviceLocator");
        this.d = serviceLocator;
    }
}
