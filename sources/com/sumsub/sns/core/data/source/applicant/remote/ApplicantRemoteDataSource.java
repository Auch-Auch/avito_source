package com.sumsub.sns.core.data.source.applicant.remote;

import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.JsonObject;
import com.sumsub.sns.core.common.WebSocketFlowKt;
import com.sumsub.sns.core.data.model.DocumentType;
import com.sumsub.sns.core.data.model.IdentitySide;
import com.sumsub.sns.core.data.model.remote.RemoteIdDoc;
import com.sumsub.sns.core.data.source.applicant.ApplicantDataSource;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010/\u001a\u00020\u0002¢\u0006\u0004\b8\u00109J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J_\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0007J\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010 J?\u0010%\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0\u000e2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0004\b%\u0010&JC\u0010+\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00022\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00042\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lcom/sumsub/sns/core/data/source/applicant/remote/ApplicantRemoteDataSource;", "Lcom/sumsub/sns/core/data/source/applicant/ApplicantDataSource;", "", "applicantId", "", "Lcom/sumsub/sns/core/data/model/Document;", "getRequiredDocuments", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "country", "Ljava/io/File;", "file", "identityType", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "side", "", "headers", "Lcom/sumsub/sns/core/data/model/DocumentType;", "idDocSetType", "Lcom/sumsub/sns/core/data/model/remote/RemoteIdDoc;", "uploadFile", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/IdentitySide;Ljava/util/Map;Lcom/sumsub/sns/core/data/model/DocumentType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inspectionId", "", "imageId", "", "deleteImage", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/model/Applicant$Review;", "setPending", SDKConstants.PARAM_ACCESS_TOKEN, "Lkotlinx/coroutines/flow/Flow;", "applicantState", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "", "fields", "unsetFields", "Lcom/sumsub/sns/core/data/model/Applicant$Info;", "setFields", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "email", "Lcom/sumsub/sns/core/data/model/remote/Metavalue;", "customFields", "Lcom/sumsub/sns/core/data/model/Applicant;", "setCustomFields", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "Ljava/lang/String;", "baseUrl", "Lcom/sumsub/sns/core/data/source/applicant/remote/ApplicantService;", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/source/applicant/remote/ApplicantService;", NotificationCompat.CATEGORY_SERVICE, "Lokhttp3/OkHttpClient;", AuthSource.BOOKING_ORDER, "Lokhttp3/OkHttpClient;", "httpClient", "<init>", "(Lcom/sumsub/sns/core/data/source/applicant/remote/ApplicantService;Lokhttp3/OkHttpClient;Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class ApplicantRemoteDataSource implements ApplicantDataSource {
    public final ApplicantService a;
    public final OkHttpClient b;
    public final String c;

    @DebugMetadata(c = "com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource", f = "ApplicantRemoteDataSource.kt", i = {}, l = {33}, m = "getRequiredDocuments", n = {}, s = {})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ ApplicantRemoteDataSource c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ApplicantRemoteDataSource applicantRemoteDataSource, Continuation continuation) {
            super(continuation);
            this.c = applicantRemoteDataSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.getRequiredDocuments(null, this);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource", f = "ApplicantRemoteDataSource.kt", i = {}, l = {71}, m = "setCustomFields", n = {}, s = {})
    public static final class b extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ ApplicantRemoteDataSource c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ApplicantRemoteDataSource applicantRemoteDataSource, Continuation continuation) {
            super(continuation);
            this.c = applicantRemoteDataSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.setCustomFields(null, null, null, null, this);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource", f = "ApplicantRemoteDataSource.kt", i = {}, l = {67}, m = "setFields", n = {}, s = {})
    public static final class c extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ ApplicantRemoteDataSource c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ApplicantRemoteDataSource applicantRemoteDataSource, Continuation continuation) {
            super(continuation);
            this.c = applicantRemoteDataSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.setFields(null, null, null, this);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource", f = "ApplicantRemoteDataSource.kt", i = {}, l = {58}, m = "setPending", n = {}, s = {})
    public static final class d extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ ApplicantRemoteDataSource c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ApplicantRemoteDataSource applicantRemoteDataSource, Continuation continuation) {
            super(continuation);
            this.c = applicantRemoteDataSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.setPending(null, this);
        }
    }

    public ApplicantRemoteDataSource(@NotNull ApplicantService applicantService, @NotNull OkHttpClient okHttpClient, @NotNull String str) {
        Intrinsics.checkNotNullParameter(applicantService, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(okHttpClient, "httpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        this.a = applicantService;
        this.b = okHttpClient;
        this.c = str;
    }

    @Override // com.sumsub.sns.core.data.source.applicant.ApplicantDataSource
    @NotNull
    public Flow<String> applicantState(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_ACCESS_TOKEN);
        return WebSocketFlowKt.webSocketFlow(this.b, a2.b.a.a.a.u(new StringBuilder(), this.c, "ws/iframe?token=", str));
    }

    @Override // com.sumsub.sns.core.data.source.applicant.ApplicantDataSource
    @Nullable
    public Object deleteImage(@NotNull String str, int i, @NotNull Continuation<? super Unit> continuation) {
        Object deleteImage = this.a.deleteImage(str, i, continuation);
        return deleteImage == t6.p.a.a.getCOROUTINE_SUSPENDED() ? deleteImage : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.sumsub.sns.core.data.source.applicant.ApplicantDataSource
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getRequiredDocuments(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.sumsub.sns.core.data.model.Document>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource$a r0 = (com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource$a r0 = new com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource$a
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            com.sumsub.sns.core.data.source.applicant.remote.ApplicantService r6 = r4.a
            r0.b = r3
            java.lang.Object r6 = r6.getRequiredDocuments(r5, r0)
            if (r6 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.sumsub.sns.core.data.model.remote.response.RequiredDocsResponse r6 = (com.sumsub.sns.core.data.model.remote.response.RequiredDocsResponse) r6
            java.util.Map r5 = r6.getData()
            java.util.ArrayList r6 = new java.util.ArrayList
            int r0 = r5.size()
            r6.<init>(r0)
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0056:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x007f
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            com.sumsub.sns.core.data.model.Document r1 = new com.sumsub.sns.core.data.model.Document
            java.lang.Object r2 = r0.getKey()
            com.sumsub.sns.core.data.model.DocumentType r2 = (com.sumsub.sns.core.data.model.DocumentType) r2
            java.lang.Object r0 = r0.getValue()
            com.sumsub.sns.core.data.model.remote.RemoteRequiredDoc r0 = (com.sumsub.sns.core.data.model.remote.RemoteRequiredDoc) r0
            if (r0 == 0) goto L_0x0077
            com.sumsub.sns.core.data.model.Document$Result r0 = com.sumsub.sns.core.data.model.remote.RemoteRequiredDocKt.toRequiredDoc(r0)
            goto L_0x0078
        L_0x0077:
            r0 = 0
        L_0x0078:
            r1.<init>(r2, r0)
            r6.add(r1)
            goto L_0x0056
        L_0x007f:
            java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource.getRequiredDocuments(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.sumsub.sns.core.data.source.applicant.ApplicantDataSource
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setCustomFields(@org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.Nullable java.lang.String r17, @org.jetbrains.annotations.NotNull java.util.List<com.sumsub.sns.core.data.model.remote.Metavalue> r18, @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> r19, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.data.model.Applicant> r20) {
        /*
            r15 = this;
            r0 = r15
            r1 = r20
            boolean r2 = r1 instanceof com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource.b
            if (r2 == 0) goto L_0x0016
            r2 = r1
            com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource$b r2 = (com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource.b) r2
            int r3 = r2.b
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.b = r3
            goto L_0x001b
        L_0x0016:
            com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource$b r2 = new com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource$b
            r2.<init>(r15, r1)
        L_0x001b:
            java.lang.Object r1 = r2.a
            java.lang.Object r3 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r4 = r2.b
            r5 = 1
            if (r4 == 0) goto L_0x0034
            if (r4 != r5) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0061
        L_0x002c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r1)
            com.sumsub.sns.core.data.source.applicant.remote.ApplicantService r1 = r0.a
            com.sumsub.sns.core.data.model.remote.Metadata r4 = new com.sumsub.sns.core.data.model.remote.Metadata
            r6 = r16
            r7 = r17
            r8 = r18
            r4.<init>(r6, r7, r8)
            if (r19 == 0) goto L_0x0057
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 62
            r14 = 0
            java.lang.String r7 = ","
            r6 = r19
            java.lang.String r6 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0058
        L_0x0057:
            r6 = 0
        L_0x0058:
            r2.b = r5
            java.lang.Object r1 = r1.setCustomFiends(r4, r6, r2)
            if (r1 != r3) goto L_0x0061
            return r3
        L_0x0061:
            com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse$Data$Item r1 = (com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse.Data.Item) r1
            com.sumsub.sns.core.data.model.Applicant r1 = com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponseKt.toApplicant(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource.setCustomFields(java.lang.String, java.lang.String, java.util.List, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    @Override // com.sumsub.sns.core.data.source.applicant.ApplicantDataSource
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setFields(@org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, ? extends java.lang.Object> r18, @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> r19, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.data.model.Applicant.Info> r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r20
            boolean r2 = r1 instanceof com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource.c
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource$c r2 = (com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource.c) r2
            int r3 = r2.b
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.b = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource$c r2 = new com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource$c
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.a
            java.lang.Object r3 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r4 = r2.b
            r5 = 1
            if (r4 == 0) goto L_0x0035
            if (r4 != r5) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x007f
        L_0x002d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r1)
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            com.google.gson.GsonBuilder r1 = r1.newBuilder()
            com.google.gson.GsonBuilder r1 = r1.setPrettyPrinting()
            com.google.gson.Gson r1 = r1.create()
            r4 = r18
            java.lang.String r1 = r1.toJson(r4)
            com.sumsub.sns.core.data.source.applicant.remote.ApplicantService r4 = r0.a
            java.lang.String r6 = "application/json; charset=utf-8"
            okhttp3.MediaType r6 = okhttp3.MediaType.parse(r6)
            okhttp3.RequestBody r1 = okhttp3.RequestBody.create(r6, r1)
            java.lang.String r6 = "RequestBody.create(Media…n; charset=utf-8\"), data)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
            if (r19 == 0) goto L_0x0073
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 62
            r15 = 0
            java.lang.String r8 = ","
            r7 = r19
            java.lang.String r6 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r7, r8, r9, r10, r11, r12, r13, r14, r15)
            goto L_0x0074
        L_0x0073:
            r6 = 0
        L_0x0074:
            r2.b = r5
            r5 = r17
            java.lang.Object r1 = r4.setFields(r5, r1, r6, r2)
            if (r1 != r3) goto L_0x007f
            return r3
        L_0x007f:
            com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse$Data$Info r1 = (com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse.Data.Info) r1
            com.sumsub.sns.core.data.model.Applicant$Info r1 = com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponseKt.toInfo(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource.setFields(java.lang.String, java.util.Map, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.sumsub.sns.core.data.source.applicant.ApplicantDataSource
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setPending(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.data.model.Applicant.Review> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource.d
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource$d r0 = (com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource.d) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource$d r0 = new com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource$d
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            com.sumsub.sns.core.data.source.applicant.remote.ApplicantService r6 = r4.a
            r0.b = r3
            java.lang.Object r6 = r6.setPending(r5, r0)
            if (r6 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse$Data$Review r6 = (com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse.Data.Review) r6
            com.sumsub.sns.core.data.model.Applicant$Review r5 = com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponseKt.toReview(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource.setPending(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.sumsub.sns.core.data.source.applicant.ApplicantDataSource
    @Nullable
    public Object uploadFile(@NotNull String str, @NotNull String str2, @NotNull File file, @Nullable String str3, @Nullable IdentitySide identitySide, @NotNull Map<String, String> map, @Nullable DocumentType documentType, @NotNull Continuation<? super RemoteIdDoc> continuation) {
        String value;
        MultipartBody.Part createFormData = MultipartBody.Part.createFormData("content", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("country", str2);
        if (str3 != null) {
            jsonObject.addProperty("idDocType", str3);
        }
        if (!(identitySide == null || (value = identitySide.getValue()) == null)) {
            jsonObject.addProperty("idDocSubType", value);
        }
        RequestBody create = RequestBody.create(MediaType.parse("multipart/form-data"), jsonObject.toString());
        StringBuilder L = a2.b.a.a.a.L("ApplicantRemoteDataSource.uploadFile: meta=");
        L.append(jsonObject.toString());
        Timber.d(L.toString(), new Object[0]);
        ApplicantService applicantService = this.a;
        Intrinsics.checkNotNullExpressionValue(createFormData, "filePart");
        Intrinsics.checkNotNullExpressionValue(create, "meta");
        return applicantService.uploadImage(str, createFormData, create, map, documentType != null ? documentType.getValue() : null, continuation);
    }
}
