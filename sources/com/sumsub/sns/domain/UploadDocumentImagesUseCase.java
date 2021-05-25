package com.sumsub.sns.domain;

import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.DocumentPickerResult;
import com.sumsub.sns.core.data.model.remote.RemoteIdDoc;
import com.sumsub.sns.core.data.source.applicant.ApplicantRepository;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.data.source.settings.SettingsRepository;
import com.sumsub.sns.domain.UploadBaseDocumentDataUseCase;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0016J3\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/domain/UploadDocumentImagesUseCase;", "Lcom/sumsub/sns/domain/UploadBaseDocumentDataUseCase;", "Lcom/sumsub/sns/domain/UploadDocumentImagesUseCase$Params;", "params", "Lcom/sumsub/sns/core/data/model/Applicant;", "applicant", "", "country", "", "Lcom/sumsub/sns/core/data/model/remote/RemoteIdDoc;", "upload", "(Lcom/sumsub/sns/domain/UploadDocumentImagesUseCase$Params;Lcom/sumsub/sns/core/data/model/Applicant;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", "applicantRepository", "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "settingsRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;)V", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "(Lcom/sumsub/sns/core/ServiceLocator;)V", "Params", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class UploadDocumentImagesUseCase extends UploadBaseDocumentDataUseCase<Params> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/domain/UploadDocumentImagesUseCase$Params;", "Lcom/sumsub/sns/domain/UploadBaseDocumentDataUseCase$BaseParams;", "", "Lcom/sumsub/sns/core/data/model/DocumentPickerResult;", "c", "Ljava/util/List;", "getResults", "()Ljava/util/List;", "results", "Lcom/sumsub/sns/core/data/model/Document;", "document", "", "country", "<init>", "(Lcom/sumsub/sns/core/data/model/Document;Ljava/lang/String;Ljava/util/List;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params extends UploadBaseDocumentDataUseCase.BaseParams {
        @NotNull
        public final List<DocumentPickerResult> c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Params(@NotNull Document document, @Nullable String str, @NotNull List<DocumentPickerResult> list) {
            super(document, str);
            Intrinsics.checkNotNullParameter(document, "document");
            Intrinsics.checkNotNullParameter(list, "results");
            this.c = list;
        }

        @NotNull
        public final List<DocumentPickerResult> getResults() {
            return this.c;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.domain.UploadDocumentImagesUseCase", f = "UploadDocumentImagesUseCase.kt", i = {0, 0, 0, 0, 0}, l = {24}, m = "upload", n = {"this", "params", "applicant", "country", "destination$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ UploadDocumentImagesUseCase c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public Object j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(UploadDocumentImagesUseCase uploadDocumentImagesUseCase, Continuation continuation) {
            super(continuation);
            this.c = uploadDocumentImagesUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.upload((Params) null, (Applicant) null, (String) null, (Continuation<? super List<RemoteIdDoc>>) this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadDocumentImagesUseCase(@NotNull CommonRepository commonRepository, @NotNull ApplicantRepository applicantRepository, @NotNull SettingsRepository settingsRepository) {
        super(commonRepository, applicantRepository, settingsRepository);
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(applicantRepository, "applicantRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.sumsub.sns.domain.UploadBaseDocumentDataUseCase$BaseParams, com.sumsub.sns.core.data.model.Applicant, java.lang.String, kotlin.coroutines.Continuation] */
    @Override // com.sumsub.sns.domain.UploadBaseDocumentDataUseCase
    public /* bridge */ /* synthetic */ Object upload(Params params, Applicant applicant, String str, Continuation continuation) {
        return upload(params, applicant, str, (Continuation<? super List<RemoteIdDoc>>) continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadDocumentImagesUseCase(@NotNull ServiceLocator serviceLocator) {
        this(serviceLocator.getCommonRepository(), serviceLocator.getApplicantRepository(), serviceLocator.getSettingsRepository());
        Intrinsics.checkNotNullParameter(serviceLocator, "serviceLocator");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object upload(@org.jetbrains.annotations.NotNull com.sumsub.sns.domain.UploadDocumentImagesUseCase.Params r23, @org.jetbrains.annotations.NotNull com.sumsub.sns.core.data.model.Applicant r24, @org.jetbrains.annotations.NotNull java.lang.String r25, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.sumsub.sns.core.data.model.remote.RemoteIdDoc>> r26) {
        /*
        // Method dump skipped, instructions count: 242
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.domain.UploadDocumentImagesUseCase.upload(com.sumsub.sns.domain.UploadDocumentImagesUseCase$Params, com.sumsub.sns.core.data.model.Applicant, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
