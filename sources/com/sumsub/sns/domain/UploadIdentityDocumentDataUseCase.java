package com.sumsub.sns.domain;

import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.DocumentPickerResult;
import com.sumsub.sns.core.data.model.remote.RemoteIdDoc;
import com.sumsub.sns.core.data.source.applicant.ApplicantRepository;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.data.source.settings.SettingsRepository;
import com.sumsub.sns.core.domain.base.BaseUseCase;
import com.sumsub.sns.core.domain.model.Either;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0014\u0010\u0018J-\u0010\b\u001a\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/sumsub/sns/domain/UploadIdentityDocumentDataUseCase;", "Lcom/sumsub/sns/core/domain/base/BaseUseCase;", "Lcom/sumsub/sns/core/data/model/remote/RemoteIdDoc;", "Lcom/sumsub/sns/domain/UploadIdentityDocumentDataUseCase$Params;", "params", "Lcom/sumsub/sns/core/domain/model/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "run", "(Lcom/sumsub/sns/domain/UploadIdentityDocumentDataUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", "applicantRepository", "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "c", "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "settingsRepository", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;)V", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "(Lcom/sumsub/sns/core/ServiceLocator;)V", "Params", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class UploadIdentityDocumentDataUseCase extends BaseUseCase<RemoteIdDoc, Params> {
    public final ApplicantRepository b;
    public final SettingsRepository c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/domain/UploadIdentityDocumentDataUseCase$Params;", "", "Lcom/sumsub/sns/core/data/model/DocumentPickerResult;", "d", "Lcom/sumsub/sns/core/data/model/DocumentPickerResult;", "getResult", "()Lcom/sumsub/sns/core/data/model/DocumentPickerResult;", "result", "", "c", "Ljava/lang/String;", "getIdentityType", "()Ljava/lang/String;", "identityType", AuthSource.BOOKING_ORDER, "getCountry", "country", "Lcom/sumsub/sns/core/data/model/Document;", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/model/Document;", "getDocument", "()Lcom/sumsub/sns/core/data/model/Document;", "document", "<init>", "(Lcom/sumsub/sns/core/data/model/Document;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/DocumentPickerResult;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
        @NotNull
        public final Document a;
        @Nullable
        public final String b;
        @NotNull
        public final String c;
        @NotNull
        public final DocumentPickerResult d;

        public Params(@NotNull Document document, @Nullable String str, @NotNull String str2, @NotNull DocumentPickerResult documentPickerResult) {
            Intrinsics.checkNotNullParameter(document, "document");
            Intrinsics.checkNotNullParameter(str2, "identityType");
            Intrinsics.checkNotNullParameter(documentPickerResult, "result");
            this.a = document;
            this.b = str;
            this.c = str2;
            this.d = documentPickerResult;
        }

        @Nullable
        public final String getCountry() {
            return this.b;
        }

        @NotNull
        public final Document getDocument() {
            return this.a;
        }

        @NotNull
        public final String getIdentityType() {
            return this.c;
        }

        @NotNull
        public final DocumentPickerResult getResult() {
            return this.d;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.domain.UploadIdentityDocumentDataUseCase", f = "UploadIdentityDocumentDataUseCase.kt", i = {0, 0, 0, 1, 1, 1, 1, 2}, l = {27, 28, 37, 40}, m = "run", n = {"this", "params", "applicantId", "this", "params", "applicantId", "applicant", "this"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ UploadIdentityDocumentDataUseCase c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(UploadIdentityDocumentDataUseCase uploadIdentityDocumentDataUseCase, Continuation continuation) {
            super(continuation);
            this.c = uploadIdentityDocumentDataUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.run((Params) null, (Continuation<? super Either<? extends Exception, RemoteIdDoc>>) this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadIdentityDocumentDataUseCase(@NotNull CommonRepository commonRepository, @NotNull ApplicantRepository applicantRepository, @NotNull SettingsRepository settingsRepository) {
        super(commonRepository);
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(applicantRepository, "applicantRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        this.b = applicantRepository;
        this.c = settingsRepository;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.coroutines.Continuation] */
    @Override // com.sumsub.sns.core.domain.base.BaseUseCase
    public /* bridge */ /* synthetic */ Object run(Params params, Continuation<? super Either<? extends Exception, ? extends RemoteIdDoc>> continuation) {
        return run(params, (Continuation<? super Either<? extends Exception, RemoteIdDoc>>) continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadIdentityDocumentDataUseCase(@NotNull ServiceLocator serviceLocator) {
        this(serviceLocator.getCommonRepository(), serviceLocator.getApplicantRepository(), serviceLocator.getSettingsRepository());
        Intrinsics.checkNotNullParameter(serviceLocator, "serviceLocator");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x014c, code lost:
        if (kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11).booleanValue() != false) goto L_0x0150;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01ab A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x010f A[EDGE_INSN: B:111:0x010f->B:70:0x010f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d7 A[Catch:{ Exception -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d9 A[Catch:{ Exception -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00fc A[Catch:{ Exception -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00fe A[Catch:{ Exception -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x017b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x017c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(@org.jetbrains.annotations.NotNull com.sumsub.sns.domain.UploadIdentityDocumentDataUseCase.Params r21, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.domain.model.Either<? extends java.lang.Exception, com.sumsub.sns.core.data.model.remote.RemoteIdDoc>> r22) {
        /*
        // Method dump skipped, instructions count: 434
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.domain.UploadIdentityDocumentDataUseCase.run(com.sumsub.sns.domain.UploadIdentityDocumentDataUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
