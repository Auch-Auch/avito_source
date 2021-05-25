package com.sumsub.sns.core.data.source.applicant;

import com.avito.android.remote.auth.AuthSource;
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
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00103\u001a\u000200¢\u0006\u0004\b7\u00108J)\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ_\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020!2\u0006\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010#J?\u0010(\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$0\u00102\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0004\b(\u0010)JC\u0010.\u001a\u00020-2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00062\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0004\b.\u0010/R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105\u0002\u0004\n\u0002\b\u0019¨\u00069"}, d2 = {"Lcom/sumsub/sns/core/data/source/applicant/RealApplicantRepository;", "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", "", "applicantId", "", "force", "", "Lcom/sumsub/sns/core/data/model/Document;", "getRequiredDocuments", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "country", "Ljava/io/File;", "file", "identityType", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "side", "", "headers", "Lcom/sumsub/sns/core/data/model/DocumentType;", "idDocSetType", "Lcom/sumsub/sns/core/data/model/remote/RemoteIdDoc;", "uploadFile", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/IdentitySide;Ljava/util/Map;Lcom/sumsub/sns/core/data/model/DocumentType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inspectionId", "", "imageId", "", "deleteImage", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/model/Applicant$Review;", "setPending", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", SDKConstants.PARAM_ACCESS_TOKEN, "Lkotlinx/coroutines/flow/Flow;", "applicantState", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "", "fields", "unsetFields", "Lcom/sumsub/sns/core/data/model/Applicant$Info;", "setFields", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "email", "Lcom/sumsub/sns/core/data/model/remote/Metavalue;", "customFields", "Lcom/sumsub/sns/core/data/model/Applicant;", "setCustomFields", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/source/applicant/ApplicantDataSource;", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/source/applicant/ApplicantDataSource;", "remote", AuthSource.SEND_ABUSE, "Ljava/util/List;", "data", "<init>", "(Lcom/sumsub/sns/core/data/source/applicant/ApplicantDataSource;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class RealApplicantRepository implements ApplicantRepository {
    public List<Document> a = CollectionsKt__CollectionsKt.emptyList();
    public final ApplicantDataSource b;

    @DebugMetadata(c = "com.sumsub.sns.core.data.source.applicant.RealApplicantRepository", f = "RealApplicantRepository.kt", i = {0}, l = {16}, m = "getRequiredDocuments", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ RealApplicantRepository c;
        public Object d;
        public Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RealApplicantRepository realApplicantRepository, Continuation continuation) {
            super(continuation);
            this.c = realApplicantRepository;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.getRequiredDocuments(null, false, this);
        }
    }

    public RealApplicantRepository(@NotNull ApplicantDataSource applicantDataSource) {
        Intrinsics.checkNotNullParameter(applicantDataSource, "remote");
        this.b = applicantDataSource;
    }

    @Override // com.sumsub.sns.core.data.source.applicant.ApplicantRepository
    @NotNull
    public Flow<String> applicantState(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_ACCESS_TOKEN);
        return this.b.applicantState(str);
    }

    @Override // com.sumsub.sns.core.data.source.applicant.ApplicantRepository
    @Nullable
    public Object deleteImage(@NotNull String str, int i, @NotNull Continuation<? super Unit> continuation) {
        Object deleteImage = this.b.deleteImage(str, i, continuation);
        return deleteImage == t6.p.a.a.getCOROUTINE_SUSPENDED() ? deleteImage : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.sumsub.sns.core.data.source.applicant.ApplicantRepository
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getRequiredDocuments(@org.jetbrains.annotations.NotNull java.lang.String r5, boolean r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.sumsub.sns.core.data.model.Document>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.core.data.source.applicant.RealApplicantRepository.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.core.data.source.applicant.RealApplicantRepository$a r0 = (com.sumsub.sns.core.data.source.applicant.RealApplicantRepository.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.data.source.applicant.RealApplicantRepository$a r0 = new com.sumsub.sns.core.data.source.applicant.RealApplicantRepository$a
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r5 = r0.e
            com.sumsub.sns.core.data.source.applicant.RealApplicantRepository r5 = (com.sumsub.sns.core.data.source.applicant.RealApplicantRepository) r5
            java.lang.Object r6 = r0.d
            com.sumsub.sns.core.data.source.applicant.RealApplicantRepository r6 = (com.sumsub.sns.core.data.source.applicant.RealApplicantRepository) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005a
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.List<com.sumsub.sns.core.data.model.Document> r7 = r4.a
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x0049
            if (r6 == 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r6 = r4
            goto L_0x005e
        L_0x0049:
            com.sumsub.sns.core.data.source.applicant.ApplicantDataSource r6 = r4.b
            r0.d = r4
            r0.e = r4
            r0.b = r3
            java.lang.Object r7 = r6.getRequiredDocuments(r5, r0)
            if (r7 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r5 = r4
            r6 = r5
        L_0x005a:
            java.util.List r7 = (java.util.List) r7
            r5.a = r7
        L_0x005e:
            java.util.List<com.sumsub.sns.core.data.model.Document> r5 = r6.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.source.applicant.RealApplicantRepository.getRequiredDocuments(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.sumsub.sns.core.data.source.applicant.ApplicantRepository
    @Nullable
    public Object setCustomFields(@NotNull String str, @Nullable String str2, @NotNull List<Metavalue> list, @Nullable List<String> list2, @NotNull Continuation<? super Applicant> continuation) {
        return this.b.setCustomFields(str, str2, list, list2, continuation);
    }

    @Override // com.sumsub.sns.core.data.source.applicant.ApplicantRepository
    @Nullable
    public Object setFields(@NotNull String str, @NotNull Map<String, ? extends Object> map, @Nullable List<String> list, @NotNull Continuation<? super Applicant.Info> continuation) {
        return this.b.setFields(str, map, list, continuation);
    }

    @Override // com.sumsub.sns.core.data.source.applicant.ApplicantRepository
    @Nullable
    public Object setPending(@NotNull String str, @NotNull Continuation<? super Applicant.Review> continuation) {
        return this.b.setPending(str, continuation);
    }

    @Override // com.sumsub.sns.core.data.source.applicant.ApplicantRepository
    @Nullable
    public Object uploadFile(@NotNull String str, @NotNull String str2, @NotNull File file, @Nullable String str3, @Nullable IdentitySide identitySide, @NotNull Map<String, String> map, @Nullable DocumentType documentType, @NotNull Continuation<? super RemoteIdDoc> continuation) {
        return this.b.uploadFile(str, str2, file, str3, identitySide, map, documentType, continuation);
    }
}
