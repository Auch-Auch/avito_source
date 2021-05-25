package com.sumsub.sns.presentation.screen.verification;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import com.avito.android.remote.auth.AuthSource;
import com.google.gson.Gson;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.ApplicantStatus;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.ReviewStatusType;
import com.sumsub.sns.core.domain.GetConfigUseCase;
import com.sumsub.sns.core.domain.model.Either;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.domain.GetApplicantDataAndUpdateStatusIfNeededUseCase;
import com.sumsub.sns.domain.GetApplicantStateUseCase;
import com.sumsub.sns.presentation.screen.base.SNSBaseViewModel;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001eB/\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR%\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/sumsub/sns/presentation/screen/verification/SNSVerificationViewModel;", "Lcom/sumsub/sns/presentation/screen/base/SNSBaseViewModel;", "Lcom/sumsub/sns/domain/GetApplicantDataAndUpdateStatusIfNeededUseCase;", "k", "Lcom/sumsub/sns/domain/GetApplicantDataAndUpdateStatusIfNeededUseCase;", "getRequiredDocumentsAndApplicantUseCase", "Lcom/google/gson/Gson;", "n", "Lcom/google/gson/Gson;", "gson", "Landroidx/lifecycle/LiveData;", "Lcom/sumsub/sns/core/presentation/base/Event;", "Lcom/sumsub/sns/presentation/screen/verification/SNSVerificationViewModel$Params;", "j", "Landroidx/lifecycle/LiveData;", "getShowDocumentsStatusScreen", "()Landroidx/lifecycle/LiveData;", "showDocumentsStatusScreen", "Lcom/sumsub/sns/core/domain/GetConfigUseCase;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/sumsub/sns/core/domain/GetConfigUseCase;", "getConfigUseCase", "Lcom/sumsub/sns/domain/GetApplicantStateUseCase;", "l", "Lcom/sumsub/sns/domain/GetApplicantStateUseCase;", "getApplicantStateUseCase", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Lcom/sumsub/sns/domain/GetApplicantDataAndUpdateStatusIfNeededUseCase;Lcom/sumsub/sns/domain/GetApplicantStateUseCase;Lcom/sumsub/sns/core/domain/GetConfigUseCase;Lcom/google/gson/Gson;)V", "Params", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSVerificationViewModel extends SNSBaseViewModel {
    @NotNull
    public final LiveData<Event<Params>> j = FlowLiveDataConversions.asLiveData$default(FlowKt.flow(new SNSVerificationViewModel$$special$$inlined$transform$1(FlowKt.flow(new a(this, null)), null, this)), (CoroutineContext) null, 0, 3, (Object) null);
    public final GetApplicantDataAndUpdateStatusIfNeededUseCase k;
    public final GetApplicantStateUseCase l;
    public final GetConfigUseCase m;
    public final Gson n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u000b¨\u0006&"}, d2 = {"Lcom/sumsub/sns/presentation/screen/verification/SNSVerificationViewModel$Params;", "", "Lcom/sumsub/sns/core/data/model/ApplicantStatus;", "component1", "()Lcom/sumsub/sns/core/data/model/ApplicantStatus;", "Lcom/sumsub/sns/core/data/model/Applicant;", "component2", "()Lcom/sumsub/sns/core/data/model/Applicant;", "", "Lcom/sumsub/sns/core/data/model/Document;", "component3", "()Ljava/util/List;", "status", "applicant", "documents", "copy", "(Lcom/sumsub/sns/core/data/model/ApplicantStatus;Lcom/sumsub/sns/core/data/model/Applicant;Ljava/util/List;)Lcom/sumsub/sns/presentation/screen/verification/SNSVerificationViewModel$Params;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/model/Applicant;", "getApplicant", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/model/ApplicantStatus;", "getStatus", "c", "Ljava/util/List;", "getDocuments", "<init>", "(Lcom/sumsub/sns/core/data/model/ApplicantStatus;Lcom/sumsub/sns/core/data/model/Applicant;Ljava/util/List;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params {
        @NotNull
        public final ApplicantStatus a;
        @NotNull
        public final Applicant b;
        @NotNull
        public final List<Document> c;

        public Params(@NotNull ApplicantStatus applicantStatus, @NotNull Applicant applicant, @NotNull List<Document> list) {
            Intrinsics.checkNotNullParameter(applicantStatus, "status");
            Intrinsics.checkNotNullParameter(applicant, "applicant");
            Intrinsics.checkNotNullParameter(list, "documents");
            this.a = applicantStatus;
            this.b = applicant;
            this.c = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.presentation.screen.verification.SNSVerificationViewModel$Params */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Params copy$default(Params params, ApplicantStatus applicantStatus, Applicant applicant, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                applicantStatus = params.a;
            }
            if ((i & 2) != 0) {
                applicant = params.b;
            }
            if ((i & 4) != 0) {
                list = params.c;
            }
            return params.copy(applicantStatus, applicant, list);
        }

        @NotNull
        public final ApplicantStatus component1() {
            return this.a;
        }

        @NotNull
        public final Applicant component2() {
            return this.b;
        }

        @NotNull
        public final List<Document> component3() {
            return this.c;
        }

        @NotNull
        public final Params copy(@NotNull ApplicantStatus applicantStatus, @NotNull Applicant applicant, @NotNull List<Document> list) {
            Intrinsics.checkNotNullParameter(applicantStatus, "status");
            Intrinsics.checkNotNullParameter(applicant, "applicant");
            Intrinsics.checkNotNullParameter(list, "documents");
            return new Params(applicantStatus, applicant, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.a, params.a) && Intrinsics.areEqual(this.b, params.b) && Intrinsics.areEqual(this.c, params.c);
        }

        @NotNull
        public final Applicant getApplicant() {
            return this.b;
        }

        @NotNull
        public final List<Document> getDocuments() {
            return this.c;
        }

        @NotNull
        public final ApplicantStatus getStatus() {
            return this.a;
        }

        public int hashCode() {
            ApplicantStatus applicantStatus = this.a;
            int i = 0;
            int hashCode = (applicantStatus != null ? applicantStatus.hashCode() : 0) * 31;
            Applicant applicant = this.b;
            int hashCode2 = (hashCode + (applicant != null ? applicant.hashCode() : 0)) * 31;
            List<Document> list = this.c;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Params(status=");
            L.append(this.a);
            L.append(", applicant=");
            L.append(this.b);
            L.append(", documents=");
            return a2.b.a.a.a.w(L, this.c, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ReviewStatusType.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            ReviewStatusType reviewStatusType = ReviewStatusType.Completed;
            iArr[2] = 1;
            ReviewStatusType reviewStatusType2 = ReviewStatusType.Queued;
            iArr[1] = 2;
            ReviewStatusType reviewStatusType3 = ReviewStatusType.Pending;
            iArr[3] = 3;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.verification.SNSVerificationViewModel$showDocumentsStatusScreen$1", f = "SNSVerificationViewModel.kt", i = {0}, l = {34, 123}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
    public static final class a extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object b;
        public int c;
        public final /* synthetic */ SNSVerificationViewModel d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSVerificationViewModel sNSVerificationViewModel, Continuation continuation) {
            super(2, continuation);
            this.d = sNSVerificationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            a aVar = new a(this.d, continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            a aVar = new a(this.d, continuation2);
            aVar.b = flowCollector;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            FlowCollector flowCollector;
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.c;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.b;
                GetApplicantStateUseCase getApplicantStateUseCase = this.d.l;
                GetApplicantStateUseCase.Params params = new GetApplicantStateUseCase.Params();
                this.b = flowCollector;
                this.c = 1;
                obj = getApplicantStateUseCase.run(params, (Continuation<? super Either<? extends Exception, ? extends Flow<String>>>) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                flowCollector = (FlowCollector) this.b;
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Either either = (Either) obj;
            if (either instanceof Either.Right) {
                this.b = null;
                this.c = 2;
                if (((Flow) ((Either.Right) either).getB()).collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (either instanceof Either.Left) {
                SNSVerificationViewModel.access$onLoadDataError(this.d, (Exception) ((Either.Left) either).getA());
            }
            return Unit.INSTANCE;
        }
    }

    public SNSVerificationViewModel(@NotNull SavedStateHandle savedStateHandle, @NotNull GetApplicantDataAndUpdateStatusIfNeededUseCase getApplicantDataAndUpdateStatusIfNeededUseCase, @NotNull GetApplicantStateUseCase getApplicantStateUseCase, @NotNull GetConfigUseCase getConfigUseCase, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(getApplicantDataAndUpdateStatusIfNeededUseCase, "getRequiredDocumentsAndApplicantUseCase");
        Intrinsics.checkNotNullParameter(getApplicantStateUseCase, "getApplicantStateUseCase");
        Intrinsics.checkNotNullParameter(getConfigUseCase, "getConfigUseCase");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.k = getApplicantDataAndUpdateStatusIfNeededUseCase;
        this.l = getApplicantStateUseCase;
        this.m = getConfigUseCase;
        this.n = gson;
        Timber.i("Verification is created", new Object[0]);
        onLoad();
    }

    public static final void access$onLoadDataError(SNSVerificationViewModel sNSVerificationViewModel, Exception exc) {
        Objects.requireNonNull(sNSVerificationViewModel);
        Timber.e(exc, "Error when getting data...", new Object[0]);
        sNSVerificationViewModel.get_throwErrorActionLiveData().setValue(new Event<>(exc));
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.sumsub.sns.core.presentation.base.Event access$onLoadDataSuccess(com.sumsub.sns.presentation.screen.verification.SNSVerificationViewModel r11, kotlin.Pair r12, com.sumsub.sns.core.data.model.AppConfig r13) {
        /*
        // Method dump skipped, instructions count: 406
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.verification.SNSVerificationViewModel.access$onLoadDataSuccess(com.sumsub.sns.presentation.screen.verification.SNSVerificationViewModel, kotlin.Pair, com.sumsub.sns.core.data.model.AppConfig):com.sumsub.sns.core.presentation.base.Event");
    }

    @NotNull
    public final LiveData<Event<Params>> getShowDocumentsStatusScreen() {
        return this.j;
    }
}
