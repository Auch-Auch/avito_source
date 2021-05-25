package com.sumsub.sns.core.data.source.common;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.data.listener.SNSStateChangedHandler;
import com.sumsub.sns.core.data.model.Action;
import com.sumsub.sns.core.data.model.AppConfig;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.SNSSDKState;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00102\u001a\u00020/¢\u0006\u0004\b5\u00106J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\bJ%\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\bJ'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0012\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u000eJ\u001b\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010 \u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0004\b \u0010\u001eJ#\u0010!\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b!\u0010\u000eJ!\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H@ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u001eR$\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u00103\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lcom/sumsub/sns/core/data/source/common/RealCommonRepository;", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "", "id", "", "force", "Lcom/sumsub/sns/core/data/model/Applicant;", "getApplicantById", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/model/Action;", "getActionById", "applicantId", ChannelContext.Item.USER_ID, "getAccessToken", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flowName", "Lcom/sumsub/sns/core/data/model/AppConfig;", "getConfig", "language", "", "", "getStringResources", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "setApplicantLanguage", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "state", "setSDKState", "(Lcom/sumsub/sns/core/data/model/SNSSDKState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSDKState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/Locale;", "getLocale", AuthSource.SEND_ABUSE, "getClientIntegrationSettings", "e", "Ljava/util/Map;", "clientIntegrationSettings", "c", "Lcom/sumsub/sns/core/data/model/AppConfig;", Navigation.CONFIG, AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/model/Action;", "action", "d", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "sdkState", "Lcom/sumsub/sns/core/data/source/common/CommonService;", "f", "Lcom/sumsub/sns/core/data/source/common/CommonService;", "remote", "Lcom/sumsub/sns/core/data/model/Applicant;", "applicant", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonService;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class RealCommonRepository implements CommonRepository {
    public Applicant a;
    public Action b;
    public AppConfig c;
    public SNSSDKState d = SNSSDKState.Ready.INSTANCE;
    public Map<String, ? extends Object> e;
    public final CommonService f;

    @DebugMetadata(c = "com.sumsub.sns.core.data.source.common.RealCommonRepository", f = "RealCommonRepository.kt", i = {}, l = {40}, m = "getAccessToken", n = {}, s = {})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ RealCommonRepository c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RealCommonRepository realCommonRepository, Continuation continuation) {
            super(continuation);
            this.c = realCommonRepository;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.getAccessToken(null, null, this);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.core.data.source.common.RealCommonRepository", f = "RealCommonRepository.kt", i = {0}, l = {34}, m = "getActionById", n = {"this"}, s = {"L$0"})
    public static final class b extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ RealCommonRepository c;
        public Object d;
        public Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(RealCommonRepository realCommonRepository, Continuation continuation) {
            super(continuation);
            this.c = realCommonRepository;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.getActionById(null, false, this);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.core.data.source.common.RealCommonRepository", f = "RealCommonRepository.kt", i = {0}, l = {25}, m = "getApplicantById", n = {"this"}, s = {"L$0"})
    public static final class c extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ RealCommonRepository c;
        public Object d;
        public Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(RealCommonRepository realCommonRepository, Continuation continuation) {
            super(continuation);
            this.c = realCommonRepository;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.getApplicantById(null, false, this);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.core.data.source.common.RealCommonRepository", f = "RealCommonRepository.kt", i = {0}, l = {84}, m = "getClientIntegrationSettings", n = {"this"}, s = {"L$0"})
    public static final class d extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ RealCommonRepository c;
        public Object d;
        public Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(RealCommonRepository realCommonRepository, Continuation continuation) {
            super(continuation);
            this.c = realCommonRepository;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.getClientIntegrationSettings(this);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.core.data.source.common.RealCommonRepository", f = "RealCommonRepository.kt", i = {0}, l = {46}, m = "getConfig", n = {"this"}, s = {"L$0"})
    public static final class e extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ RealCommonRepository c;
        public Object d;
        public Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(RealCommonRepository realCommonRepository, Continuation continuation) {
            super(continuation);
            this.c = realCommonRepository;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.getConfig(null, false, this);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.core.data.source.common.RealCommonRepository", f = "RealCommonRepository.kt", i = {}, l = {79}, m = "getRemoteAppConfigAndSave", n = {}, s = {})
    public static final class f extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ RealCommonRepository c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(RealCommonRepository realCommonRepository, Continuation continuation) {
            super(continuation);
            this.c = realCommonRepository;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.a(null, null, this);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.core.data.source.common.RealCommonRepository", f = "RealCommonRepository.kt", i = {0, 0}, l = {56, 57}, m = "setApplicantLanguage", n = {"this", "applicantId"}, s = {"L$0", "L$1"})
    public static final class g extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ RealCommonRepository c;
        public Object d;
        public Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(RealCommonRepository realCommonRepository, Continuation continuation) {
            super(continuation);
            this.c = realCommonRepository;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.setApplicantLanguage(null, null, this);
        }
    }

    public RealCommonRepository(@NotNull CommonService commonService) {
        Intrinsics.checkNotNullParameter(commonService, "remote");
        this.f = commonService;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object a(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.sumsub.sns.core.data.model.AppConfig> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.sumsub.sns.core.data.source.common.RealCommonRepository.f
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.sumsub.sns.core.data.source.common.RealCommonRepository$f r0 = (com.sumsub.sns.core.data.source.common.RealCommonRepository.f) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.data.source.common.RealCommonRepository$f r0 = new com.sumsub.sns.core.data.source.common.RealCommonRepository$f
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0055
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 0
            java.lang.Object[] r2 = new java.lang.Object[r8]
            java.lang.String r4 = "Memory cache for a config is empty"
            timber.log.Timber.d(r4, r2)
            int r2 = r6.length()
            if (r2 <= 0) goto L_0x0043
            r8 = 1
        L_0x0043:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            r8.booleanValue()
            com.sumsub.sns.core.data.source.common.CommonService r8 = r5.f
            r0.b = r3
            java.lang.Object r8 = r8.getConfig(r6, r7, r0)
            if (r8 != r1) goto L_0x0055
            return r1
        L_0x0055:
            com.sumsub.sns.core.data.model.remote.RemoteConfig r8 = (com.sumsub.sns.core.data.model.remote.RemoteConfig) r8
            com.sumsub.sns.core.data.model.AppConfig r6 = com.sumsub.sns.core.data.model.remote.RemoteConfigKt.toConfig(r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.source.common.RealCommonRepository.a(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.sumsub.sns.core.data.source.common.CommonRepository
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getAccessToken(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.sumsub.sns.core.data.source.common.RealCommonRepository.a
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.sumsub.sns.core.data.source.common.RealCommonRepository$a r0 = (com.sumsub.sns.core.data.source.common.RealCommonRepository.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.data.source.common.RealCommonRepository$a r0 = new com.sumsub.sns.core.data.source.common.RealCommonRepository$a
            r0.<init>(r8, r11)
        L_0x0018:
            r5 = r0
            java.lang.Object r11 = r5.a
            java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r1 = r5.b
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0045
        L_0x002a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r11)
            com.sumsub.sns.core.data.source.common.CommonService r1 = r8.f
            r4 = 0
            r6 = 4
            r7 = 0
            r5.b = r2
            r2 = r9
            r3 = r10
            java.lang.Object r11 = com.sumsub.sns.core.data.source.common.CommonService.DefaultImpls.getAccessToken$default(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L_0x0045
            return r0
        L_0x0045:
            com.sumsub.sns.core.data.model.remote.response.AccessTokenResponse r11 = (com.sumsub.sns.core.data.model.remote.response.AccessTokenResponse) r11
            java.lang.String r9 = r11.getToken()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.source.common.RealCommonRepository.getAccessToken(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.sumsub.sns.core.data.source.common.CommonRepository
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getActionById(@org.jetbrains.annotations.NotNull java.lang.String r5, boolean r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.data.model.Action> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.core.data.source.common.RealCommonRepository.b
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.core.data.source.common.RealCommonRepository$b r0 = (com.sumsub.sns.core.data.source.common.RealCommonRepository.b) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.data.source.common.RealCommonRepository$b r0 = new com.sumsub.sns.core.data.source.common.RealCommonRepository$b
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r5 = r0.e
            com.sumsub.sns.core.data.source.common.RealCommonRepository r5 = (com.sumsub.sns.core.data.source.common.RealCommonRepository) r5
            java.lang.Object r6 = r0.d
            com.sumsub.sns.core.data.source.common.RealCommonRepository r6 = (com.sumsub.sns.core.data.source.common.RealCommonRepository) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0075
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = "Trying to get an action("
            r7.append(r2)
            r7.append(r5)
            java.lang.String r2 = "). Force flag is "
            r7.append(r2)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            timber.log.Timber.d(r7, r2)
            com.sumsub.sns.core.data.model.Action r7 = r4.b
            if (r7 == 0) goto L_0x0064
            if (r6 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r6 = r4
            goto L_0x007d
        L_0x0064:
            com.sumsub.sns.core.data.source.common.CommonService r6 = r4.f
            r0.d = r4
            r0.e = r4
            r0.b = r3
            java.lang.Object r7 = r6.getActionById(r5, r0)
            if (r7 != r1) goto L_0x0073
            return r1
        L_0x0073:
            r5 = r4
            r6 = r5
        L_0x0075:
            com.sumsub.sns.core.data.model.remote.RemoteAction r7 = (com.sumsub.sns.core.data.model.remote.RemoteAction) r7
            com.sumsub.sns.core.data.model.Action r7 = com.sumsub.sns.core.data.model.remote.RemoteActionKt.toAction(r7)
            r5.b = r7
        L_0x007d:
            com.sumsub.sns.core.data.model.Action r5 = r6.b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.source.common.RealCommonRepository.getActionById(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.sumsub.sns.core.data.source.common.CommonRepository
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getApplicantById(@org.jetbrains.annotations.NotNull java.lang.String r5, boolean r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.data.model.Applicant> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.core.data.source.common.RealCommonRepository.c
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.core.data.source.common.RealCommonRepository$c r0 = (com.sumsub.sns.core.data.source.common.RealCommonRepository.c) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.data.source.common.RealCommonRepository$c r0 = new com.sumsub.sns.core.data.source.common.RealCommonRepository$c
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r5 = r0.e
            com.sumsub.sns.core.data.source.common.RealCommonRepository r5 = (com.sumsub.sns.core.data.source.common.RealCommonRepository) r5
            java.lang.Object r6 = r0.d
            com.sumsub.sns.core.data.source.common.RealCommonRepository r6 = (com.sumsub.sns.core.data.source.common.RealCommonRepository) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x007f
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = "Trying to get an applicant("
            r7.append(r2)
            r7.append(r5)
            java.lang.String r2 = "). Force flag is "
            r7.append(r2)
            r7.append(r6)
            java.lang.String r2 = ". Applicant: "
            r7.append(r2)
            com.sumsub.sns.core.data.model.Applicant r2 = r4.a
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            timber.log.Timber.d(r7, r2)
            com.sumsub.sns.core.data.model.Applicant r7 = r4.a
            if (r7 == 0) goto L_0x006e
            if (r6 == 0) goto L_0x006c
            goto L_0x006e
        L_0x006c:
            r6 = r4
            goto L_0x0087
        L_0x006e:
            com.sumsub.sns.core.data.source.common.CommonService r6 = r4.f
            r0.d = r4
            r0.e = r4
            r0.b = r3
            java.lang.Object r7 = r6.getApplicantById(r5, r0)
            if (r7 != r1) goto L_0x007d
            return r1
        L_0x007d:
            r5 = r4
            r6 = r5
        L_0x007f:
            com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse$Data$Item r7 = (com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse.Data.Item) r7
            com.sumsub.sns.core.data.model.Applicant r7 = com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponseKt.toApplicant(r7)
            r5.a = r7
        L_0x0087:
            com.sumsub.sns.core.data.model.Applicant r5 = r6.a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.source.common.RealCommonRepository.getApplicantById(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.sumsub.sns.core.data.source.common.CommonRepository
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getClientIntegrationSettings(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.sumsub.sns.core.data.source.common.RealCommonRepository.d
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.core.data.source.common.RealCommonRepository$d r0 = (com.sumsub.sns.core.data.source.common.RealCommonRepository.d) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.data.source.common.RealCommonRepository$d r0 = new com.sumsub.sns.core.data.source.common.RealCommonRepository$d
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r1 = r0.e
            com.sumsub.sns.core.data.source.common.RealCommonRepository r1 = (com.sumsub.sns.core.data.source.common.RealCommonRepository) r1
            java.lang.Object r0 = r0.d
            com.sumsub.sns.core.data.source.common.RealCommonRepository r0 = (com.sumsub.sns.core.data.source.common.RealCommonRepository) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0051
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r5)
            java.util.Map<java.lang.String, ? extends java.lang.Object> r5 = r4.e
            if (r5 != 0) goto L_0x0056
            com.sumsub.sns.core.data.source.common.CommonService r5 = r4.f
            r0.d = r4
            r0.e = r4
            r0.b = r3
            java.lang.Object r5 = r5.getClientIntegrationSettings(r0)
            if (r5 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r0 = r4
            r1 = r0
        L_0x0051:
            java.util.Map r5 = (java.util.Map) r5
            r1.e = r5
            goto L_0x0057
        L_0x0056:
            r0 = r4
        L_0x0057:
            java.util.Map<java.lang.String, ? extends java.lang.Object> r5 = r0.e
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.source.common.RealCommonRepository.getClientIntegrationSettings(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.sumsub.sns.core.data.source.common.CommonRepository
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getConfig(@org.jetbrains.annotations.NotNull java.lang.String r5, boolean r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.data.model.AppConfig> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.core.data.source.common.RealCommonRepository.e
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.core.data.source.common.RealCommonRepository$e r0 = (com.sumsub.sns.core.data.source.common.RealCommonRepository.e) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.data.source.common.RealCommonRepository$e r0 = new com.sumsub.sns.core.data.source.common.RealCommonRepository$e
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r5 = r0.e
            com.sumsub.sns.core.data.source.common.RealCommonRepository r5 = (com.sumsub.sns.core.data.source.common.RealCommonRepository) r5
            java.lang.Object r6 = r0.d
            com.sumsub.sns.core.data.source.common.RealCommonRepository r6 = (com.sumsub.sns.core.data.source.common.RealCommonRepository) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0082
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = "Trying to get config. Flow name is "
            r7.append(r2)
            r7.append(r5)
            java.lang.String r2 = " Force flag is "
            r7.append(r2)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            timber.log.Timber.d(r7, r2)
            com.sumsub.sns.core.SNSMobileSDK r7 = com.sumsub.sns.core.SNSMobileSDK.INSTANCE
            java.util.Locale r7 = r7.getLocale()
            java.lang.String r7 = r7.getLanguage()
            com.sumsub.sns.core.data.model.AppConfig r2 = r4.c
            if (r2 == 0) goto L_0x006e
            if (r6 == 0) goto L_0x006c
            goto L_0x006e
        L_0x006c:
            r6 = r4
            goto L_0x0086
        L_0x006e:
            java.lang.String r6 = "language"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            r0.d = r4
            r0.e = r4
            r0.b = r3
            java.lang.Object r7 = r4.a(r5, r7, r0)
            if (r7 != r1) goto L_0x0080
            return r1
        L_0x0080:
            r5 = r4
            r6 = r5
        L_0x0082:
            com.sumsub.sns.core.data.model.AppConfig r7 = (com.sumsub.sns.core.data.model.AppConfig) r7
            r5.c = r7
        L_0x0086:
            com.sumsub.sns.core.data.model.AppConfig r5 = r6.c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.source.common.RealCommonRepository.getConfig(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.sumsub.sns.core.data.source.common.CommonRepository
    @Nullable
    public Object getLocale(@NotNull Continuation<? super Locale> continuation) {
        return SNSMobileSDK.INSTANCE.getLocale();
    }

    @Override // com.sumsub.sns.core.data.source.common.CommonRepository
    @Nullable
    public Object getSDKState(@NotNull Continuation<? super SNSSDKState> continuation) {
        return this.d;
    }

    @Override // com.sumsub.sns.core.data.source.common.CommonRepository
    @Nullable
    public Object getStringResources(@NotNull String str, @NotNull Continuation<? super Map<String, ? extends Object>> continuation) {
        return this.f.getStringResources(str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.sumsub.sns.core.data.source.common.CommonRepository
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setApplicantLanguage(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.core.data.source.common.RealCommonRepository.g
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.core.data.source.common.RealCommonRepository$g r0 = (com.sumsub.sns.core.data.source.common.RealCommonRepository.g) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.data.source.common.RealCommonRepository$g r0 = new com.sumsub.sns.core.data.source.common.RealCommonRepository$g
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r7 = r0.d
            com.sumsub.sns.core.data.source.common.RealCommonRepository r7 = (com.sumsub.sns.core.data.source.common.RealCommonRepository) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x008f
        L_0x0030:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0038:
            java.lang.Object r7 = r0.e
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.d
            com.sumsub.sns.core.data.source.common.RealCommonRepository r8 = (com.sumsub.sns.core.data.source.common.RealCommonRepository) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x007f
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "Set language "
            r9.append(r2)
            r9.append(r8)
            java.lang.String r2 = " for applicant "
            r9.append(r2)
            r9.append(r7)
            java.lang.String r9 = r9.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            timber.log.Timber.d(r9, r2)
            com.sumsub.sns.core.data.source.common.CommonService r9 = r6.f
            com.sumsub.sns.core.data.model.remote.ApplicantLanguage r2 = new com.sumsub.sns.core.data.model.remote.ApplicantLanguage
            r2.<init>(r7, r8)
            r0.d = r6
            r0.e = r7
            r0.b = r4
            java.lang.Object r8 = r9.setApplicantLanguage(r2, r0)
            if (r8 != r1) goto L_0x007d
            return r1
        L_0x007d:
            r8 = r7
            r7 = r6
        L_0x007f:
            com.sumsub.sns.core.data.source.common.CommonService r9 = r7.f
            r0.d = r7
            r2 = 0
            r0.e = r2
            r0.b = r3
            java.lang.Object r9 = r9.getApplicantById(r8, r0)
            if (r9 != r1) goto L_0x008f
            return r1
        L_0x008f:
            com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse$Data$Item r9 = (com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse.Data.Item) r9
            com.sumsub.sns.core.data.model.Applicant r8 = com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponseKt.toApplicant(r9)
            r7.a = r8
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.source.common.RealCommonRepository.setApplicantLanguage(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.sumsub.sns.core.data.source.common.CommonRepository
    @Nullable
    public Object setSDKState(@NotNull SNSSDKState sNSSDKState, @NotNull Continuation<? super Unit> continuation) {
        if (!Intrinsics.areEqual(this.d, sNSSDKState)) {
            StringBuilder L = a2.b.a.a.a.L("The SDK state was changed: ");
            L.append(this.d);
            L.append(" -> ");
            L.append(sNSSDKState);
            Timber.d(L.toString(), new Object[0]);
            try {
                SNSStateChangedHandler stateChangedHandler = SNSMobileSDK.INSTANCE.getStateChangedHandler();
                if (stateChangedHandler != null) {
                    stateChangedHandler.onStateChanged(this.d, sNSSDKState);
                }
            } catch (Exception e2) {
                Timber.e(e2);
            }
            SNSMobileSDK.INSTANCE.setState$sns_core_release(sNSSDKState);
            this.d = sNSSDKState;
        }
        return Unit.INSTANCE;
    }
}
