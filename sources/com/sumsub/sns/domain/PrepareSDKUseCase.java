package com.sumsub.sns.domain;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.data.model.AppConfig;
import com.sumsub.sns.core.data.model.DocumentType;
import com.sumsub.sns.core.data.model.FlowType;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.data.source.log.LogRepository;
import com.sumsub.sns.core.data.source.settings.SettingsRepository;
import com.sumsub.sns.core.domain.base.BaseUseCase;
import com.sumsub.sns.core.domain.model.Either;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB'\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u0018\u0010\u001cJ+\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sns/domain/PrepareSDKUseCase;", "Lcom/sumsub/sns/core/domain/base/BaseUseCase;", "Lcom/sumsub/sns/core/data/model/AppConfig;", "Lcom/sumsub/sns/domain/PrepareSDKUseCase$Params;", "params", "Lcom/sumsub/sns/core/domain/model/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "run", "(Lcom/sumsub/sns/domain/PrepareSDKUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "c", "Ljava/lang/String;", "flowName", "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "settingsRepository", "Lcom/sumsub/sns/core/data/source/log/LogRepository;", "d", "Lcom/sumsub/sns/core/data/source/log/LogRepository;", "logRepository", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;Ljava/lang/String;Lcom/sumsub/sns/core/data/source/log/LogRepository;)V", "Lcom/sumsub/sns/core/ServiceLocator;", "serviceLocator", "(Lcom/sumsub/sns/core/ServiceLocator;)V", "Params", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class PrepareSDKUseCase extends BaseUseCase<AppConfig, Params> {
    public final SettingsRepository b;
    public final String c;
    public final LogRepository d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/domain/PrepareSDKUseCase$Params;", "", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FlowType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            FlowType flowType = FlowType.Standalone;
            iArr[1] = 1;
            FlowType flowType2 = FlowType.Module;
            iArr[2] = 2;
            FlowType flowType3 = FlowType.Actions;
            iArr[0] = 3;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.domain.PrepareSDKUseCase", f = "PrepareSDKUseCase.kt", i = {0, 1, 1, 2, 2, 3, 3, 4, 4, 6}, l = {25, 33, 39, 50, 55, 60, 67}, m = "run", n = {"this", "this", Navigation.CONFIG, "this", Navigation.CONFIG, "this", Navigation.CONFIG, "this", Navigation.CONFIG, "e"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0"})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ PrepareSDKUseCase c;
        public Object d;
        public Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PrepareSDKUseCase prepareSDKUseCase, Continuation continuation) {
            super(continuation);
            this.c = prepareSDKUseCase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.run((Params) null, (Continuation<? super Either<? extends Exception, AppConfig>>) this);
        }
    }

    public static final class b extends Lambda implements Function1<DocumentType, CharSequence> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(DocumentType documentType) {
            DocumentType documentType2 = documentType;
            Intrinsics.checkNotNullParameter(documentType2, "it");
            return documentType2.getValue();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrepareSDKUseCase(@NotNull CommonRepository commonRepository, @NotNull SettingsRepository settingsRepository, @NotNull String str, @NotNull LogRepository logRepository) {
        super(commonRepository);
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(str, "flowName");
        Intrinsics.checkNotNullParameter(logRepository, "logRepository");
        this.b = settingsRepository;
        this.c = str;
        this.d = logRepository;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.coroutines.Continuation] */
    @Override // com.sumsub.sns.core.domain.base.BaseUseCase
    public /* bridge */ /* synthetic */ Object run(Params params, Continuation<? super Either<? extends Exception, ? extends AppConfig>> continuation) {
        return run(params, (Continuation<? super Either<? extends Exception, AppConfig>>) continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PrepareSDKUseCase(@NotNull ServiceLocator serviceLocator) {
        this(serviceLocator.getCommonRepository(), serviceLocator.getSettingsRepository(), serviceLocator.getSession().getFlowName(), serviceLocator.getLogRepository());
        Intrinsics.checkNotNullParameter(serviceLocator, "serviceLocator");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0084, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0085, code lost:
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0088, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0089, code lost:
        r7 = r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x025f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0084 A[ExcHandler: Exception (e java.lang.Exception), PHI: r4 
      PHI: (r4v17 com.sumsub.sns.domain.PrepareSDKUseCase) = (r4v11 com.sumsub.sns.domain.PrepareSDKUseCase), (r4v11 com.sumsub.sns.domain.PrepareSDKUseCase), (r4v19 com.sumsub.sns.domain.PrepareSDKUseCase), (r4v19 com.sumsub.sns.domain.PrepareSDKUseCase) binds: [B:86:0x0215, B:87:?, B:28:0x0080, B:29:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:28:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01e8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0247 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(@org.jetbrains.annotations.NotNull com.sumsub.sns.domain.PrepareSDKUseCase.Params r27, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.sumsub.sns.core.domain.model.Either<? extends java.lang.Exception, com.sumsub.sns.core.data.model.AppConfig>> r28) {
        /*
        // Method dump skipped, instructions count: 636
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.domain.PrepareSDKUseCase.run(com.sumsub.sns.domain.PrepareSDKUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
