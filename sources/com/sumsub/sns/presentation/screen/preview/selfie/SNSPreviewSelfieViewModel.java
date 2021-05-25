package com.sumsub.sns.presentation.screen.preview.selfie;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelKt;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.SNSLivenessReason;
import com.sumsub.sns.core.data.model.VideoRequiredType;
import com.sumsub.sns.core.data.model.remote.RemoteIdDoc;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.domain.GetApplicantUseCase;
import com.sumsub.sns.core.domain.GetConfigUseCase;
import com.sumsub.sns.core.domain.model.Either;
import com.sumsub.sns.core.presentation.base.ActionLiveData;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.domain.UploadDocumentVideoSelfieUseCase;
import com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel;
import java.io.File;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u000267B/\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b4\u00105J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0004R$\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u000e0\u000e0\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001f\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0$8F@\u0006¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0019\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0$8F@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u00068"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/selfie/SNSPreviewSelfieViewModel;", "Lcom/sumsub/sns/presentation/screen/preview/SNSBaseDocumentPreviewViewModel;", "", "onDataLoaded", "()V", "onTakeAnotherDataClicked", "", "rotation", "onDataIsReadableClicked", "(I)V", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "reason", "onHandleLiveness", "(Lcom/sumsub/sns/core/data/model/SNSLivenessReason;)V", "Ljava/io/File;", "file", "", "phrase", "onHandleVideoSelfie", "(Ljava/io/File;Ljava/lang/String;)V", "d", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "y", "Landroidx/lifecycle/MutableLiveData;", "_videoSelfieLiveData", "Lcom/sumsub/sns/domain/UploadDocumentVideoSelfieUseCase;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/sumsub/sns/domain/UploadDocumentVideoSelfieUseCase;", "uploadDocumentVideoSelfieUseCase", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "Lcom/sumsub/sns/core/presentation/base/Event;", "Lcom/sumsub/sns/presentation/screen/preview/selfie/SNSPreviewSelfieViewModel$VideoParams;", "x", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "_showVideoSelfiePickerActionLiveData", "Landroidx/lifecycle/LiveData;", "getShowVideoSelfiePicker", "()Landroidx/lifecycle/LiveData;", "showVideoSelfiePicker", "getVideoSelfie", "videoSelfie", "z", "Ljava/lang/String;", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "Lcom/sumsub/sns/core/domain/GetConfigUseCase;", "getConfigUseCase", "Lcom/sumsub/sns/core/domain/GetApplicantUseCase;", "getApplicantUseCase", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Lcom/sumsub/sns/core/domain/GetConfigUseCase;Lcom/sumsub/sns/core/domain/GetApplicantUseCase;Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/sumsub/sns/domain/UploadDocumentVideoSelfieUseCase;)V", "Companion", "VideoParams", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSPreviewSelfieViewModel extends SNSBaseDocumentPreviewViewModel {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final UploadDocumentVideoSelfieUseCase A;
    public final ActionLiveData<Event<VideoParams>> x = new ActionLiveData<>();
    public final MutableLiveData<File> y;
    public String z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/selfie/SNSPreviewSelfieViewModel$Companion;", "", "", "KEY_FILE", "Ljava/lang/String;", "KEY_PHRASE", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/selfie/SNSPreviewSelfieViewModel$VideoParams;", "", "Lcom/sumsub/sns/core/data/model/Document;", "component1", "()Lcom/sumsub/sns/core/data/model/Document;", "document", "copy", "(Lcom/sumsub/sns/core/data/model/Document;)Lcom/sumsub/sns/presentation/screen/preview/selfie/SNSPreviewSelfieViewModel$VideoParams;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/model/Document;", "getDocument", "<init>", "(Lcom/sumsub/sns/core/data/model/Document;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class VideoParams {
        @NotNull
        public final Document a;

        public VideoParams(@NotNull Document document) {
            Intrinsics.checkNotNullParameter(document, "document");
            this.a = document;
        }

        public static /* synthetic */ VideoParams copy$default(VideoParams videoParams, Document document, int i, Object obj) {
            if ((i & 1) != 0) {
                document = videoParams.a;
            }
            return videoParams.copy(document);
        }

        @NotNull
        public final Document component1() {
            return this.a;
        }

        @NotNull
        public final VideoParams copy(@NotNull Document document) {
            Intrinsics.checkNotNullParameter(document, "document");
            return new VideoParams(document);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof VideoParams) && Intrinsics.areEqual(this.a, ((VideoParams) obj).a);
            }
            return true;
        }

        @NotNull
        public final Document getDocument() {
            return this.a;
        }

        public int hashCode() {
            Document document = this.a;
            if (document != null) {
                return document.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("VideoParams(document=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.preview.selfie.SNSPreviewSelfieViewModel$onDataIsReadableClicked$1", f = "SNSPreviewSelfieViewModel.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ SNSPreviewSelfieViewModel c;
        public final /* synthetic */ File d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSPreviewSelfieViewModel sNSPreviewSelfieViewModel, File file, Continuation continuation) {
            super(2, continuation);
            this.c = sNSPreviewSelfieViewModel;
            this.d = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new a(this.c, this.d, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new a(this.c, this.d, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                UploadDocumentVideoSelfieUseCase uploadDocumentVideoSelfieUseCase = this.c.A;
                Document document = this.c.getDocument();
                File file = this.d;
                String str = this.c.z;
                Intrinsics.checkNotNull(str);
                UploadDocumentVideoSelfieUseCase.Params params = new UploadDocumentVideoSelfieUseCase.Params(document, file, str);
                this.b = 1;
                obj = uploadDocumentVideoSelfieUseCase.run((UploadDocumentVideoSelfieUseCase) params, (Continuation<? super Either<? extends Exception, ? extends List<RemoteIdDoc>>>) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Either either = (Either) obj;
            SNSPreviewSelfieViewModel sNSPreviewSelfieViewModel = this.c;
            if (either.isRight()) {
                SNSPreviewSelfieViewModel.access$onVideoSelfieUploadedSuccess(sNSPreviewSelfieViewModel, ((Either.Right) either).getB());
            } else if (either.isLeft()) {
                SNSPreviewSelfieViewModel.access$onVideoSelfieUploadedError(sNSPreviewSelfieViewModel, (Exception) ((Either.Left) either).getA());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSPreviewSelfieViewModel(@NotNull SavedStateHandle savedStateHandle, @NotNull GetConfigUseCase getConfigUseCase, @NotNull GetApplicantUseCase getApplicantUseCase, @NotNull CommonRepository commonRepository, @NotNull UploadDocumentVideoSelfieUseCase uploadDocumentVideoSelfieUseCase) {
        super(savedStateHandle, getConfigUseCase, getApplicantUseCase, commonRepository);
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(getConfigUseCase, "getConfigUseCase");
        Intrinsics.checkNotNullParameter(getApplicantUseCase, "getApplicantUseCase");
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(uploadDocumentVideoSelfieUseCase, "uploadDocumentVideoSelfieUseCase");
        this.A = uploadDocumentVideoSelfieUseCase;
        MutableLiveData<File> liveData = savedStateHandle.getLiveData("KEY_FILE");
        Intrinsics.checkNotNullExpressionValue(liveData, "savedStateHandle.getLiveData<File>(KEY_FILE)");
        this.y = liveData;
        this.z = (String) savedStateHandle.get("KEY_PHRASE");
        Timber.i("Preview Selfie is created", new Object[0]);
        onLoad();
    }

    public static final void access$onVideoSelfieUploadedError(SNSPreviewSelfieViewModel sNSPreviewSelfieViewModel, Exception exc) {
        Objects.requireNonNull(sNSPreviewSelfieViewModel);
        Timber.e(exc, "An error while uploading video selfie", new Object[0]);
        sNSPreviewSelfieViewModel.get_showProgressLiveData().setValue(Boolean.FALSE);
        sNSPreviewSelfieViewModel.get_throwErrorActionLiveData().setValue(new Event<>(exc));
    }

    public static final void access$onVideoSelfieUploadedSuccess(SNSPreviewSelfieViewModel sNSPreviewSelfieViewModel, Object obj) {
        Objects.requireNonNull(sNSPreviewSelfieViewModel);
        Timber.d("Video Selfie uploaded successful. Document is " + sNSPreviewSelfieViewModel.getDocument().getType(), new Object[0]);
        sNSPreviewSelfieViewModel.onDocumentUploaded(sNSPreviewSelfieViewModel.getDocument());
    }

    public final void d() {
        Applicant.RequiredIdDocs.DocSetsItem docSetByType = getApplicant().getDocSetByType(getDocument().getType());
        Timber.d("SNSPreviewSelfieViewModel.showPicker: docSet=" + docSetByType, new Object[0]);
        if (Intrinsics.areEqual(docSetByType != null ? docSetByType.getVideoRequired() : null, VideoRequiredType.Companion.m230getEnabledu2aduso())) {
            Timber.d("SNSPreviewSelfieViewModel.showPicker: show video selfie", new Object[0]);
            this.x.setValue(new Event<>(new VideoParams(getDocument())));
        }
    }

    @NotNull
    public final LiveData<Event<VideoParams>> getShowVideoSelfiePicker() {
        return this.x;
    }

    @NotNull
    public final LiveData<File> getVideoSelfie() {
        return this.y;
    }

    @Override // com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel
    public void onDataIsReadableClicked(int i) {
        File value = this.y.getValue();
        if (value != null) {
            String str = this.z;
            if (!(str == null || str.length() == 0)) {
                get_showProgressLiveData().setValue(Boolean.TRUE);
                Timber.d("Uploading video selfie fallback. File - " + value.getAbsolutePath() + ", Phrase - " + this.z, new Object[0]);
                BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new a(this, value, null), 3, null);
                return;
            }
        }
        onMoveToVerificationScreen(true);
    }

    @Override // com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel
    public void onDataLoaded() {
        d();
    }

    public final void onHandleLiveness(@Nullable SNSLivenessReason sNSLivenessReason) {
        Timber.d("onHandleLiveness: reason=" + sNSLivenessReason, new Object[0]);
        this.z = null;
        get_showContentLiveData().setValue(Boolean.FALSE);
        get_showProgressLiveData().setValue(Boolean.TRUE);
        if (sNSLivenessReason instanceof SNSLivenessReason.VeritifcationSuccessfully) {
            onDocumentUploaded(getDocument());
        } else if (sNSLivenessReason instanceof SNSLivenessReason.UserCancelled) {
            onMoveToVerificationScreen(true);
        } else if (sNSLivenessReason instanceof SNSLivenessReason.CompletedUnsuccessfullyAllowContinue) {
            onMoveToNextDocument();
        } else {
            this.x.setValue(new Event<>(new VideoParams(getDocument())));
        }
    }

    public final void onHandleVideoSelfie(@Nullable File file, @Nullable String str) {
        if (file != null) {
            if (!(str == null || str.length() == 0)) {
                this.z = str;
                getSavedStateHandle().set("KEY_FILE", file);
                getSavedStateHandle().set("KEY_PHRASE", str);
                get_showProgressLiveData().setValue(Boolean.FALSE);
                get_showContentLiveData().setValue(Boolean.TRUE);
                this.y.setValue(file);
                return;
            }
        }
        if (this.y.getValue() == null) {
            onMoveToVerificationScreen(true);
        }
    }

    @Override // com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel
    public void onTakeAnotherDataClicked() {
        d();
    }
}
