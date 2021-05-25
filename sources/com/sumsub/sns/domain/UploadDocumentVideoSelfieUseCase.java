package com.sumsub.sns.domain;

import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.remote.RemoteIdDoc;
import com.sumsub.sns.core.data.source.applicant.ApplicantRepository;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.data.source.settings.SettingsRepository;
import com.sumsub.sns.domain.UploadBaseDocumentDataUseCase;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0016J3\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/domain/UploadDocumentVideoSelfieUseCase;", "Lcom/sumsub/sns/domain/UploadBaseDocumentDataUseCase;", "Lcom/sumsub/sns/domain/UploadDocumentVideoSelfieUseCase$Params;", "params", "Lcom/sumsub/sns/core/data/model/Applicant;", "applicant", "", "country", "", "Lcom/sumsub/sns/core/data/model/remote/RemoteIdDoc;", "upload", "(Lcom/sumsub/sns/domain/UploadDocumentVideoSelfieUseCase$Params;Lcom/sumsub/sns/core/data/model/Applicant;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", "applicantRepository", "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "settingsRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;)V", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "(Lcom/sumsub/sns/core/ServiceLocator;)V", "Params", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class UploadDocumentVideoSelfieUseCase extends UploadBaseDocumentDataUseCase<Params> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/domain/UploadDocumentVideoSelfieUseCase$Params;", "Lcom/sumsub/sns/domain/UploadBaseDocumentDataUseCase$BaseParams;", "Ljava/io/File;", "c", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "file", "", "d", "Ljava/lang/String;", "getPhrase", "()Ljava/lang/String;", "phrase", "Lcom/sumsub/sns/core/data/model/Document;", "document", "<init>", "(Lcom/sumsub/sns/core/data/model/Document;Ljava/io/File;Ljava/lang/String;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params extends UploadBaseDocumentDataUseCase.BaseParams {
        @NotNull
        public final File c;
        @NotNull
        public final String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Params(@NotNull Document document, @NotNull File file, @NotNull String str) {
            super(document, null, 2, null);
            Intrinsics.checkNotNullParameter(document, "document");
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(str, "phrase");
            this.c = file;
            this.d = str;
        }

        @NotNull
        public final File getFile() {
            return this.c;
        }

        @NotNull
        public final String getPhrase() {
            return this.d;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.domain.UploadDocumentVideoSelfieUseCase", f = "UploadDocumentVideoSelfieUseCase.kt", i = {}, l = {30}, m = "upload", n = {}, s = {})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ UploadDocumentVideoSelfieUseCase c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(UploadDocumentVideoSelfieUseCase uploadDocumentVideoSelfieUseCase, Continuation continuation) {
            super(continuation);
            this.c = uploadDocumentVideoSelfieUseCase;
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
    public UploadDocumentVideoSelfieUseCase(@NotNull CommonRepository commonRepository, @NotNull ApplicantRepository applicantRepository, @NotNull SettingsRepository settingsRepository) {
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
    public UploadDocumentVideoSelfieUseCase(@NotNull ServiceLocator serviceLocator) {
        this(serviceLocator.getCommonRepository(), serviceLocator.getApplicantRepository(), serviceLocator.getSettingsRepository());
        Intrinsics.checkNotNullParameter(serviceLocator, "serviceLocator");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object upload(@org.jetbrains.annotations.NotNull com.sumsub.sns.domain.UploadDocumentVideoSelfieUseCase.Params r15, @org.jetbrains.annotations.NotNull com.sumsub.sns.core.data.model.Applicant r16, @org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.sumsub.sns.core.data.model.remote.RemoteIdDoc>> r18) {
        /*
            r14 = this;
            r0 = r18
            boolean r1 = r0 instanceof com.sumsub.sns.domain.UploadDocumentVideoSelfieUseCase.a
            if (r1 == 0) goto L_0x0016
            r1 = r0
            com.sumsub.sns.domain.UploadDocumentVideoSelfieUseCase$a r1 = (com.sumsub.sns.domain.UploadDocumentVideoSelfieUseCase.a) r1
            int r2 = r1.b
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0016
            int r2 = r2 - r3
            r1.b = r2
            r2 = r14
            goto L_0x001c
        L_0x0016:
            com.sumsub.sns.domain.UploadDocumentVideoSelfieUseCase$a r1 = new com.sumsub.sns.domain.UploadDocumentVideoSelfieUseCase$a
            r2 = r14
            r1.<init>(r14, r0)
        L_0x001c:
            r11 = r1
            java.lang.Object r0 = r11.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r3 = r11.b
            r4 = 1
            if (r3 == 0) goto L_0x0036
            if (r3 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0092
        L_0x002e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r0)
            com.sumsub.sns.core.data.source.settings.SettingsRepository r0 = r14.getSettingsRepository()
            java.lang.String r0 = r0.getApplicantId()
            com.sumsub.sns.core.data.model.Document r3 = r15.getDocument()
            com.sumsub.sns.core.data.model.DocumentType r3 = r3.getType()
            r5 = r16
            java.util.List r3 = r5.getIdentityList(r3)
            java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r3)
            com.sumsub.sns.core.data.model.IdentityType r3 = (com.sumsub.sns.core.data.model.IdentityType) r3
            if (r3 == 0) goto L_0x005c
            java.lang.String r3 = r3.m209unboximpl()
            goto L_0x005d
        L_0x005c:
            r3 = 0
        L_0x005d:
            if (r3 == 0) goto L_0x0060
            goto L_0x0066
        L_0x0060:
            com.sumsub.sns.core.data.model.IdentityType$Companion r3 = com.sumsub.sns.core.data.model.IdentityType.Companion
            java.lang.String r3 = r3.m215getSelfieGm96dUI()
        L_0x0066:
            r7 = r3
            java.lang.String r3 = r15.getPhrase()
            java.lang.String r3 = com.sumsub.sns.core.common.ExtensionsKt.toBase64(r3)
            java.lang.String r5 = "X-Video-Selfie-Phrase"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r5, r3)
            java.util.Map r9 = t6.n.q.mapOf(r3)
            com.sumsub.sns.core.data.source.applicant.ApplicantRepository r3 = r14.getApplicantRepository()
            java.io.File r6 = r15.getFile()
            r8 = 0
            r10 = 0
            r12 = 80
            r13 = 0
            r11.b = r4
            r4 = r0
            r5 = r17
            java.lang.Object r0 = com.sumsub.sns.core.data.source.applicant.ApplicantRepository.DefaultImpls.uploadFile$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            if (r0 != r1) goto L_0x0092
            return r1
        L_0x0092:
            java.util.List r0 = t6.n.d.listOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.domain.UploadDocumentVideoSelfieUseCase.upload(com.sumsub.sns.domain.UploadDocumentVideoSelfieUseCase$Params, com.sumsub.sns.core.data.model.Applicant, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
