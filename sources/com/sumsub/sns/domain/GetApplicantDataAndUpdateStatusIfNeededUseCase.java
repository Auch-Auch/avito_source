package com.sumsub.sns.domain;

import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.source.applicant.ApplicantRepository;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.data.source.settings.SettingsRepository;
import com.sumsub.sns.core.domain.base.BaseUseCase;
import com.sumsub.sns.core.domain.model.Either;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002 \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002\u0012\u0004\u0012\u00020\u00060\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u0017\u0010\u001bJ=\u0010\u000b\u001a$\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/sumsub/sns/domain/GetApplicantDataAndUpdateStatusIfNeededUseCase;", "Lcom/sumsub/sns/core/domain/base/BaseUseCase;", "Lkotlin/Pair;", "Lcom/sumsub/sns/core/data/model/Applicant;", "", "Lcom/sumsub/sns/core/data/model/Document;", "Lcom/sumsub/sns/domain/GetApplicantDataAndUpdateStatusIfNeededUseCase$Params;", "params", "Lcom/sumsub/sns/core/domain/model/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "run", "(Lcom/sumsub/sns/domain/GetApplicantDataAndUpdateStatusIfNeededUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", "applicantRepository", "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "c", "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "settingsRepository", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;)V", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "(Lcom/sumsub/sns/core/ServiceLocator;)V", "Params", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class GetApplicantDataAndUpdateStatusIfNeededUseCase extends BaseUseCase<Pair<? extends Applicant, ? extends List<? extends Document>>, Params> {
    public final ApplicantRepository b;
    public final SettingsRepository c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/sumsub/sns/domain/GetApplicantDataAndUpdateStatusIfNeededUseCase$Params;", "", "", "component1", "()Z", "force", "copy", "(Z)Lcom/sumsub/sns/domain/GetApplicantDataAndUpdateStatusIfNeededUseCase$Params;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Z", "getForce", "<init>", "(Z)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
        public final boolean a;

        public Params() {
            this(false, 1, null);
        }

        public Params(boolean z) {
            this.a = z;
        }

        public static /* synthetic */ Params copy$default(Params params, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = params.a;
            }
            return params.copy(z);
        }

        public final boolean component1() {
            return this.a;
        }

        @NotNull
        public final Params copy(boolean z) {
            return new Params(z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Params) && this.a == ((Params) obj).a;
            }
            return true;
        }

        public final boolean getForce() {
            return this.a;
        }

        public int hashCode() {
            boolean z = this.a;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return a2.b.a.a.a.B(a2.b.a.a.a.L("Params(force="), this.a, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Params(boolean z, int i, j jVar) {
            this((i & 1) != 0 ? false : z);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.domain.GetApplicantDataAndUpdateStatusIfNeededUseCase", f = "GetApplicantDataAndUpdateStatusIfNeededUseCase.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5}, l = {22, 23, 27, 30, 43, 45, 48}, m = "run", n = {"this", "params", "applicantId", "this", "params", "applicantId", "applicant", "this", "params", "applicantId", "applicant", "this", "applicantId", "applicant", "this", "applicant", "documents", "this", "applicant", "documents"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ GetApplicantDataAndUpdateStatusIfNeededUseCase c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GetApplicantDataAndUpdateStatusIfNeededUseCase getApplicantDataAndUpdateStatusIfNeededUseCase, Continuation continuation) {
            super(continuation);
            this.c = getApplicantDataAndUpdateStatusIfNeededUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.run((Params) null, (Continuation<? super Either<? extends Exception, ? extends Pair<Applicant, ? extends List<Document>>>>) this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetApplicantDataAndUpdateStatusIfNeededUseCase(@NotNull CommonRepository commonRepository, @NotNull ApplicantRepository applicantRepository, @NotNull SettingsRepository settingsRepository) {
        super(commonRepository);
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(applicantRepository, "applicantRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        this.b = applicantRepository;
        this.c = settingsRepository;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.coroutines.Continuation] */
    @Override // com.sumsub.sns.core.domain.base.BaseUseCase
    public /* bridge */ /* synthetic */ Object run(Params params, Continuation<? super Either<? extends Exception, ? extends Pair<? extends Applicant, ? extends List<? extends Document>>>> continuation) {
        return run(params, (Continuation<? super Either<? extends Exception, ? extends Pair<Applicant, ? extends List<Document>>>>) continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetApplicantDataAndUpdateStatusIfNeededUseCase(@NotNull ServiceLocator serviceLocator) {
        this(serviceLocator.getCommonRepository(), serviceLocator.getApplicantRepository(), serviceLocator.getSettingsRepository());
        Intrinsics.checkNotNullParameter(serviceLocator, "serviceLocator");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x027a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01f1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00fc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0157 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(@org.jetbrains.annotations.NotNull com.sumsub.sns.domain.GetApplicantDataAndUpdateStatusIfNeededUseCase.Params r22, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.domain.model.Either<? extends java.lang.Exception, ? extends kotlin.Pair<com.sumsub.sns.core.data.model.Applicant, ? extends java.util.List<com.sumsub.sns.core.data.model.Document>>>> r23) {
        /*
        // Method dump skipped, instructions count: 662
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.domain.GetApplicantDataAndUpdateStatusIfNeededUseCase.run(com.sumsub.sns.domain.GetApplicantDataAndUpdateStatusIfNeededUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
