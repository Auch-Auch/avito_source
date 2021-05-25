package com.sumsub.sns.core.data.source.applicant;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.DocumentType;
import com.sumsub.sns.core.data.model.IdentitySide;
import com.sumsub.sns.core.data.model.remote.Metavalue;
import com.sumsub.sns.core.data.model.remote.RemoteIdDoc;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007Je\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0007J\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010 J?\u0010$\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000e2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0004\b$\u0010%JC\u0010*\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010\u00022\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00042\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/sumsub/sns/core/data/source/applicant/ApplicantDataSource;", "", "", "applicantId", "", "Lcom/sumsub/sns/core/data/model/Document;", "getRequiredDocuments", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "country", "Ljava/io/File;", "file", "identityType", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "side", "", "headers", "Lcom/sumsub/sns/core/data/model/DocumentType;", "idDocSetType", "Lcom/sumsub/sns/core/data/model/remote/RemoteIdDoc;", "uploadFile", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/IdentitySide;Ljava/util/Map;Lcom/sumsub/sns/core/data/model/DocumentType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inspectionId", "", "imageId", "", "deleteImage", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/model/Applicant$Review;", "setPending", SDKConstants.PARAM_ACCESS_TOKEN, "Lkotlinx/coroutines/flow/Flow;", "applicantState", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "fields", "unsetFields", "Lcom/sumsub/sns/core/data/model/Applicant$Info;", "setFields", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "email", "Lcom/sumsub/sns/core/data/model/remote/Metavalue;", "customFields", "Lcom/sumsub/sns/core/data/model/Applicant;", "setCustomFields", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public interface ApplicantDataSource {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Flow<String> applicantState(@NotNull ApplicantDataSource applicantDataSource, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_ACCESS_TOKEN);
            throw new UnsupportedOperationException();
        }

        @Nullable
        public static Object deleteImage(@NotNull ApplicantDataSource applicantDataSource, @NotNull String str, int i, @NotNull Continuation<? super Unit> continuation) {
            throw new UnsupportedOperationException();
        }

        @Nullable
        public static Object getRequiredDocuments(@NotNull ApplicantDataSource applicantDataSource, @NotNull String str, @NotNull Continuation<? super List<Document>> continuation) {
            throw new UnsupportedOperationException();
        }

        @Nullable
        public static Object setCustomFields(@NotNull ApplicantDataSource applicantDataSource, @NotNull String str, @Nullable String str2, @NotNull List<Metavalue> list, @Nullable List<String> list2, @NotNull Continuation<? super Applicant> continuation) {
            throw new UnsupportedOperationException();
        }

        @Nullable
        public static Object setFields(@NotNull ApplicantDataSource applicantDataSource, @NotNull String str, @NotNull Map<String, ? extends Object> map, @Nullable List<String> list, @NotNull Continuation<? super Applicant.Info> continuation) {
            throw new UnsupportedOperationException();
        }

        @Nullable
        public static Object setPending(@NotNull ApplicantDataSource applicantDataSource, @NotNull String str, @NotNull Continuation<? super Applicant.Review> continuation) {
            throw new UnsupportedOperationException();
        }

        @Nullable
        public static Object uploadFile(@NotNull ApplicantDataSource applicantDataSource, @NotNull String str, @NotNull String str2, @NotNull File file, @Nullable String str3, @Nullable IdentitySide identitySide, @NotNull Map<String, String> map, @Nullable DocumentType documentType, @NotNull Continuation<? super RemoteIdDoc> continuation) {
            throw new UnsupportedOperationException();
        }

        public static /* synthetic */ Object uploadFile$default(ApplicantDataSource applicantDataSource, String str, String str2, File file, String str3, IdentitySide identitySide, Map map, DocumentType documentType, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                return applicantDataSource.uploadFile(str, str2, file, str3, (i & 16) != 0 ? null : identitySide, (i & 32) != 0 ? r.emptyMap() : map, (i & 64) != 0 ? null : documentType, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFile");
        }
    }

    @NotNull
    Flow<String> applicantState(@NotNull String str);

    @Nullable
    Object deleteImage(@NotNull String str, int i, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object getRequiredDocuments(@NotNull String str, @NotNull Continuation<? super List<Document>> continuation);

    @Nullable
    Object setCustomFields(@NotNull String str, @Nullable String str2, @NotNull List<Metavalue> list, @Nullable List<String> list2, @NotNull Continuation<? super Applicant> continuation);

    @Nullable
    Object setFields(@NotNull String str, @NotNull Map<String, ? extends Object> map, @Nullable List<String> list, @NotNull Continuation<? super Applicant.Info> continuation);

    @Nullable
    Object setPending(@NotNull String str, @NotNull Continuation<? super Applicant.Review> continuation);

    @Nullable
    Object uploadFile(@NotNull String str, @NotNull String str2, @NotNull File file, @Nullable String str3, @Nullable IdentitySide identitySide, @NotNull Map<String, String> map, @Nullable DocumentType documentType, @NotNull Continuation<? super RemoteIdDoc> continuation);
}
