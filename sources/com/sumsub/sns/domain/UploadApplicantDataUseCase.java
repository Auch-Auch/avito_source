package com.sumsub.sns.domain;

import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.remote.Metavalue;
import com.sumsub.sns.core.data.source.applicant.ApplicantRepository;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.data.source.settings.SettingsRepository;
import com.sumsub.sns.core.domain.base.BaseUseCase;
import com.sumsub.sns.core.domain.model.Either;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0014\u0010\u0018J+\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/sumsub/sns/domain/UploadApplicantDataUseCase;", "Lcom/sumsub/sns/core/domain/base/BaseUseCase;", "Lcom/sumsub/sns/core/data/model/Applicant;", "Lcom/sumsub/sns/domain/UploadApplicantDataUseCase$Params;", "params", "Lcom/sumsub/sns/core/domain/model/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "run", "(Lcom/sumsub/sns/domain/UploadApplicantDataUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", "c", "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", "applicantRepository", "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "settingsRepository", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;)V", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "(Lcom/sumsub/sns/core/ServiceLocator;)V", "Params", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class UploadApplicantDataUseCase extends BaseUseCase<Applicant, Params> {
    public final SettingsRepository b;
    public final ApplicantRepository c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001BI\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b%\u0010&J\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJZ\u0010\u0010\u001a\u00020\u00002\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR!\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\bR%\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0005R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\bR!\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\b¨\u0006'"}, d2 = {"Lcom/sumsub/sns/domain/UploadApplicantDataUseCase$Params;", "", "", "", "component1", "()Ljava/util/Map;", "", "component2", "()Ljava/util/List;", "Lcom/sumsub/sns/core/data/model/remote/Metavalue;", "component3", "component4", "fields", "unsetFields", "customFields", "unsetCoreFields", "copy", "(Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/sumsub/sns/domain/UploadApplicantDataUseCase$Params;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getUnsetFields", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getFields", "c", "getCustomFields", "d", "getUnsetCoreFields", "<init>", "(Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
        @NotNull
        public final Map<String, Object> a;
        @Nullable
        public final List<String> b;
        @NotNull
        public final List<Metavalue> c;
        @Nullable
        public final List<String> d;

        public Params(@NotNull Map<String, ? extends Object> map, @Nullable List<String> list, @NotNull List<Metavalue> list2, @Nullable List<String> list3) {
            Intrinsics.checkNotNullParameter(map, "fields");
            Intrinsics.checkNotNullParameter(list2, "customFields");
            this.a = map;
            this.b = list;
            this.c = list2;
            this.d = list3;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.domain.UploadApplicantDataUseCase$Params */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Params copy$default(Params params, Map map, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                map = params.a;
            }
            if ((i & 2) != 0) {
                list = params.b;
            }
            if ((i & 4) != 0) {
                list2 = params.c;
            }
            if ((i & 8) != 0) {
                list3 = params.d;
            }
            return params.copy(map, list, list2, list3);
        }

        @NotNull
        public final Map<String, Object> component1() {
            return this.a;
        }

        @Nullable
        public final List<String> component2() {
            return this.b;
        }

        @NotNull
        public final List<Metavalue> component3() {
            return this.c;
        }

        @Nullable
        public final List<String> component4() {
            return this.d;
        }

        @NotNull
        public final Params copy(@NotNull Map<String, ? extends Object> map, @Nullable List<String> list, @NotNull List<Metavalue> list2, @Nullable List<String> list3) {
            Intrinsics.checkNotNullParameter(map, "fields");
            Intrinsics.checkNotNullParameter(list2, "customFields");
            return new Params(map, list, list2, list3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.a, params.a) && Intrinsics.areEqual(this.b, params.b) && Intrinsics.areEqual(this.c, params.c) && Intrinsics.areEqual(this.d, params.d);
        }

        @NotNull
        public final List<Metavalue> getCustomFields() {
            return this.c;
        }

        @NotNull
        public final Map<String, Object> getFields() {
            return this.a;
        }

        @Nullable
        public final List<String> getUnsetCoreFields() {
            return this.d;
        }

        @Nullable
        public final List<String> getUnsetFields() {
            return this.b;
        }

        public int hashCode() {
            Map<String, Object> map = this.a;
            int i = 0;
            int hashCode = (map != null ? map.hashCode() : 0) * 31;
            List<String> list = this.b;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            List<Metavalue> list2 = this.c;
            int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<String> list3 = this.d;
            if (list3 != null) {
                i = list3.hashCode();
            }
            return hashCode3 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Params(fields=");
            L.append(this.a);
            L.append(", unsetFields=");
            L.append(this.b);
            L.append(", customFields=");
            L.append(this.c);
            L.append(", unsetCoreFields=");
            return a2.b.a.a.a.w(L, this.d, ")");
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.domain.UploadApplicantDataUseCase", f = "UploadApplicantDataUseCase.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {25, 36, 43}, m = "run", n = {"this", "params", "applicantId", "this", "params", "applicantId", "applicant"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ UploadApplicantDataUseCase c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(UploadApplicantDataUseCase uploadApplicantDataUseCase, Continuation continuation) {
            super(continuation);
            this.c = uploadApplicantDataUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.run((Params) null, (Continuation<? super Either<? extends Exception, Applicant>>) this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadApplicantDataUseCase(@NotNull CommonRepository commonRepository, @NotNull SettingsRepository settingsRepository, @NotNull ApplicantRepository applicantRepository) {
        super(commonRepository);
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(applicantRepository, "applicantRepository");
        this.b = settingsRepository;
        this.c = applicantRepository;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.coroutines.Continuation] */
    @Override // com.sumsub.sns.core.domain.base.BaseUseCase
    public /* bridge */ /* synthetic */ Object run(Params params, Continuation<? super Either<? extends Exception, ? extends Applicant>> continuation) {
        return run(params, (Continuation<? super Either<? extends Exception, Applicant>>) continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadApplicantDataUseCase(@NotNull ServiceLocator serviceLocator) {
        this(serviceLocator.getCommonRepository(), serviceLocator.getSettingsRepository(), serviceLocator.getApplicantRepository());
        Intrinsics.checkNotNullParameter(serviceLocator, "serviceLocator");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0134 A[LOOP:1: B:47:0x012e->B:49:0x0134, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x016f A[LOOP:2: B:51:0x0169->B:53:0x016f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01a5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(@org.jetbrains.annotations.NotNull com.sumsub.sns.domain.UploadApplicantDataUseCase.Params r18, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.domain.model.Either<? extends java.lang.Exception, com.sumsub.sns.core.data.model.Applicant>> r19) {
        /*
        // Method dump skipped, instructions count: 436
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.domain.UploadApplicantDataUseCase.run(com.sumsub.sns.domain.UploadApplicantDataUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
