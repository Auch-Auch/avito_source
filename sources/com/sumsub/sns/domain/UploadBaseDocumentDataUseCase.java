package com.sumsub.sns.domain;

import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.remote.RemoteIdDoc;
import com.sumsub.sns.core.data.source.applicant.ApplicantRepository;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.data.source.settings.SettingsRepository;
import com.sumsub.sns.core.domain.base.BaseUseCase;
import com.sumsub.sns.core.domain.model.Either;
import com.sumsub.sns.domain.UploadBaseDocumentDataUseCase.BaseParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\"B\u001f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b \u0010!J3\u0010\n\u001a\u001a\u0012\b\u0012\u00060\bj\u0002`\t\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00072\u0006\u0010\u0006\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\u00020\u00128\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001d\u001a\u00020\u00188\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/sumsub/sns/domain/UploadBaseDocumentDataUseCase;", "Lcom/sumsub/sns/domain/UploadBaseDocumentDataUseCase$BaseParams;", "P", "Lcom/sumsub/sns/core/domain/base/BaseUseCase;", "", "Lcom/sumsub/sns/core/data/model/remote/RemoteIdDoc;", "params", "Lcom/sumsub/sns/core/domain/model/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "run", "(Lcom/sumsub/sns/domain/UploadBaseDocumentDataUseCase$BaseParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/model/Applicant;", "applicant", "", "country", "upload", "(Lcom/sumsub/sns/domain/UploadBaseDocumentDataUseCase$BaseParams;Lcom/sumsub/sns/core/data/model/Applicant;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", "getApplicantRepository", "()Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", "applicantRepository", "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "c", "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "getSettingsRepository", "()Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "settingsRepository", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;)V", "BaseParams", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public abstract class UploadBaseDocumentDataUseCase<P extends BaseParams> extends BaseUseCase<List<? extends RemoteIdDoc>, P> {
    @NotNull
    public final ApplicantRepository b;
    @NotNull
    public final SettingsRepository c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/sumsub/sns/domain/UploadBaseDocumentDataUseCase$BaseParams;", "", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getCountry", "()Ljava/lang/String;", "country", "Lcom/sumsub/sns/core/data/model/Document;", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/model/Document;", "getDocument", "()Lcom/sumsub/sns/core/data/model/Document;", "document", "<init>", "(Lcom/sumsub/sns/core/data/model/Document;Ljava/lang/String;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class BaseParams {
        @NotNull
        public final Document a;
        @Nullable
        public final String b;

        public BaseParams(@NotNull Document document, @Nullable String str) {
            Intrinsics.checkNotNullParameter(document, "document");
            this.a = document;
            this.b = str;
        }

        @Nullable
        public final String getCountry() {
            return this.b;
        }

        @NotNull
        public final Document getDocument() {
            return this.a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ BaseParams(Document document, String str, int i, j jVar) {
            this(document, (i & 2) != 0 ? null : str);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.domain.UploadBaseDocumentDataUseCase", f = "UploadBaseDocumentDataUseCase.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 3}, l = {21, 22, 26, 28, 31}, m = "run$suspendImpl", n = {"this", "params", "applicantId", "this", "params", "applicant", "this", "params", "applicant", "country", "this"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ UploadBaseDocumentDataUseCase c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(UploadBaseDocumentDataUseCase uploadBaseDocumentDataUseCase, Continuation continuation) {
            super(continuation);
            this.c = uploadBaseDocumentDataUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return UploadBaseDocumentDataUseCase.b(this.c, null, this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadBaseDocumentDataUseCase(@NotNull CommonRepository commonRepository, @NotNull ApplicantRepository applicantRepository, @NotNull SettingsRepository settingsRepository) {
        super(commonRepository);
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(applicantRepository, "applicantRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        this.b = applicantRepository;
        this.c = settingsRepository;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13, types: [com.sumsub.sns.domain.UploadBaseDocumentDataUseCase$BaseParams] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0155 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01c9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01e5 A[RETURN] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object b(com.sumsub.sns.domain.UploadBaseDocumentDataUseCase r17, com.sumsub.sns.domain.UploadBaseDocumentDataUseCase.BaseParams r18, kotlin.coroutines.Continuation r19) {
        /*
        // Method dump skipped, instructions count: 492
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.domain.UploadBaseDocumentDataUseCase.b(com.sumsub.sns.domain.UploadBaseDocumentDataUseCase, com.sumsub.sns.domain.UploadBaseDocumentDataUseCase$BaseParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final ApplicantRepository getApplicantRepository() {
        return this.b;
    }

    @NotNull
    public final SettingsRepository getSettingsRepository() {
        return this.c;
    }

    @Nullable
    public Object run(@NotNull P p, @NotNull Continuation<? super Either<? extends Exception, ? extends List<RemoteIdDoc>>> continuation) {
        return b(this, p, continuation);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.coroutines.Continuation] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.domain.UploadBaseDocumentDataUseCase<P extends com.sumsub.sns.domain.UploadBaseDocumentDataUseCase$BaseParams> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sumsub.sns.core.domain.base.BaseUseCase
    public /* bridge */ /* synthetic */ Object run(Object obj, Continuation<? super Either<? extends Exception, ? extends List<? extends RemoteIdDoc>>> continuation) {
        return run((UploadBaseDocumentDataUseCase<P>) ((BaseParams) obj), (Continuation<? super Either<? extends Exception, ? extends List<RemoteIdDoc>>>) continuation);
    }

    @Nullable
    public abstract Object upload(@NotNull P p, @NotNull Applicant applicant, @NotNull String str, @NotNull Continuation<? super List<RemoteIdDoc>> continuation);
}
