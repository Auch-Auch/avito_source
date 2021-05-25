package com.sumsub.sns.domain;

import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.source.applicant.ApplicantRepository;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.domain.base.BaseUseCase;
import com.sumsub.sns.core.domain.model.Either;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0010\u0010\u0014J+\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/sumsub/sns/domain/DeleteDocumentImagesUseCase;", "Lcom/sumsub/sns/core/domain/base/BaseUseCase;", "", "Lcom/sumsub/sns/domain/DeleteDocumentImagesUseCase$Params;", "params", "Lcom/sumsub/sns/core/domain/model/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "run", "(Lcom/sumsub/sns/domain/DeleteDocumentImagesUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", "repository", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;)V", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "(Lcom/sumsub/sns/core/ServiceLocator;)V", "Params", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class DeleteDocumentImagesUseCase extends BaseUseCase<Object, Params> {
    public final ApplicantRepository b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/sumsub/sns/domain/DeleteDocumentImagesUseCase$Params;", "", "", "component1", "()Ljava/lang/String;", "", "", "component2", "()Ljava/util/List;", "applicantId", "imageIds", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/sumsub/sns/domain/DeleteDocumentImagesUseCase$Params;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getImageIds", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getApplicantId", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
        @NotNull
        public final String a;
        @NotNull
        public final List<Integer> b;

        public Params(@NotNull String str, @NotNull List<Integer> list) {
            Intrinsics.checkNotNullParameter(str, "applicantId");
            Intrinsics.checkNotNullParameter(list, "imageIds");
            this.a = str;
            this.b = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.domain.DeleteDocumentImagesUseCase$Params */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Params copy$default(Params params, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.a;
            }
            if ((i & 2) != 0) {
                list = params.b;
            }
            return params.copy(str, list);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final List<Integer> component2() {
            return this.b;
        }

        @NotNull
        public final Params copy(@NotNull String str, @NotNull List<Integer> list) {
            Intrinsics.checkNotNullParameter(str, "applicantId");
            Intrinsics.checkNotNullParameter(list, "imageIds");
            return new Params(str, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.a, params.a) && Intrinsics.areEqual(this.b, params.b);
        }

        @NotNull
        public final String getApplicantId() {
            return this.a;
        }

        @NotNull
        public final List<Integer> getImageIds() {
            return this.b;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<Integer> list = this.b;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Params(applicantId=");
            L.append(this.a);
            L.append(", imageIds=");
            return a2.b.a.a.a.w(L, this.b, ")");
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.domain.DeleteDocumentImagesUseCase", f = "DeleteDocumentImagesUseCase.kt", i = {0, 0, 1}, l = {19, 20, 23}, m = "run", n = {"this", "params", "this"}, s = {"L$0", "L$1", "L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ DeleteDocumentImagesUseCase c;
        public Object d;
        public Object e;
        public Object f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DeleteDocumentImagesUseCase deleteDocumentImagesUseCase, Continuation continuation) {
            super(continuation);
            this.c = deleteDocumentImagesUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.run((Params) null, (Continuation<? super Either<? extends Exception, ? extends Object>>) this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeleteDocumentImagesUseCase(@NotNull CommonRepository commonRepository, @NotNull ApplicantRepository applicantRepository) {
        super(commonRepository);
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(applicantRepository, "repository");
        this.b = applicantRepository;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeleteDocumentImagesUseCase(@NotNull ServiceLocator serviceLocator) {
        this(serviceLocator.getCommonRepository(), serviceLocator.getApplicantRepository());
        Intrinsics.checkNotNullParameter(serviceLocator, "serviceLocator");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074 A[Catch:{ Exception -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0093 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(@org.jetbrains.annotations.NotNull com.sumsub.sns.domain.DeleteDocumentImagesUseCase.Params r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.domain.model.Either<? extends java.lang.Exception, ? extends java.lang.Object>> r13) {
        /*
        // Method dump skipped, instructions count: 212
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.domain.DeleteDocumentImagesUseCase.run(com.sumsub.sns.domain.DeleteDocumentImagesUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
