package com.sumsub.sns.presentation.screen.preview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.sumsub.sns.core.data.model.AppConfig;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.IdentityType;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.domain.GetApplicantUseCase;
import com.sumsub.sns.core.domain.GetConfigUseCase;
import com.sumsub.sns.core.presentation.base.ActionLiveData;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.presentation.screen.base.SNSBaseViewModel;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import t6.r.a.j;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000 l2\u00020\u0001:\u0002lmB'\u0012\u0006\u0010\\\u001a\u00020W\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010@\u001a\u00020;\u0012\u0006\u00103\u001a\u000200¢\u0006\u0004\bj\u0010kJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\bø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001a\u0010\u0004J\u001b\u0010\u001e\u001a\u00020\u00022\n\u0010\u001d\u001a\u00060\u001bj\u0002`\u001cH\u0004¢\u0006\u0004\b\u001e\u0010\u001fR+\u0010(\u001a\u00020 2\u0006\u0010!\u001a\u00020 8D@DX\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001d\u0010\u000e\u001a\u00020\r8D@\u0004X\u0002¢\u0006\f\n\u0004\b-\u0010#\u001a\u0004\b.\u0010/R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R%\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r05048\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001c\u0010@\u001a\u00020;8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001f\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t050A8F@\u0006¢\u0006\u0006\u001a\u0004\bB\u0010CR/\u0010J\u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\u00058D@DX\u0002¢\u0006\u0012\n\u0004\bE\u0010#\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001f\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K050A8F@\u0006¢\u0006\u0006\u001a\u0004\bL\u0010CR\u0019\u0010O\u001a\b\u0012\u0004\u0012\u00020\t0A8F@\u0006¢\u0006\u0006\u001a\u0004\bN\u0010CR\"\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K050P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010V\u001a\b\u0012\u0004\u0012\u00020\t048\u0004@\u0004X\u0004¢\u0006\f\n\u0004\bT\u00107\u001a\u0004\bU\u00109R\u001c\u0010\\\u001a\u00020W8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\"\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t050P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010RR+\u0010e\u001a\u00020_2\u0006\u0010!\u001a\u00020_8D@DX\u0002¢\u0006\u0012\n\u0004\b`\u0010#\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR+\u0010i\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00058D@DX\u0002¢\u0006\u0012\n\u0004\bf\u0010#\u001a\u0004\bg\u0010G\"\u0004\bh\u0010I\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006n"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/SNSBaseDocumentPreviewViewModel;", "Lcom/sumsub/sns/presentation/screen/base/SNSBaseViewModel;", "", "onLoad", "()V", "", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onMoveToNextDocument", "", "isCancelled", "onMoveToVerificationScreen", "(Z)V", "Lcom/sumsub/sns/core/data/model/Document;", "document", "onDocumentUploaded", "(Lcom/sumsub/sns/core/data/model/Document;)V", "onTakeAnotherDataClicked", "", "rotation", "onDataIsReadableClicked", "(I)V", "Lkotlin/Function0;", "block", "withProgress", "(Lkotlin/jvm/functions/Function0;)V", "onDataLoaded", "Ljava/lang/Exception;", "Lkotlin/Exception;", OkListener.KEY_EXCEPTION, "onDataError", "(Ljava/lang/Exception;)V", "Lcom/sumsub/sns/core/data/model/AppConfig;", "<set-?>", "n", "Lcom/sumsub/sns/presentation/screen/preview/SNSBaseDocumentPreviewViewModel$StateHandleDelegate;", "getConfig", "()Lcom/sumsub/sns/core/data/model/AppConfig;", "setConfig", "(Lcom/sumsub/sns/core/data/model/AppConfig;)V", Navigation.CONFIG, "Lcom/sumsub/sns/core/domain/GetConfigUseCase;", "t", "Lcom/sumsub/sns/core/domain/GetConfigUseCase;", "getConfigUseCase", "o", "getDocument", "()Lcom/sumsub/sns/core/data/model/Document;", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", VKApiConst.VERSION, "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "Landroidx/lifecycle/MutableLiveData;", "Lcom/sumsub/sns/core/presentation/base/Event;", AuthSource.OPEN_CHANNEL_LIST, "Landroidx/lifecycle/MutableLiveData;", "getDocumentUploaded", "()Landroidx/lifecycle/MutableLiveData;", "documentUploaded", "Lcom/sumsub/sns/core/domain/GetApplicantUseCase;", "u", "Lcom/sumsub/sns/core/domain/GetApplicantUseCase;", "getGetApplicantUseCase", "()Lcom/sumsub/sns/core/domain/GetApplicantUseCase;", "getApplicantUseCase", "Landroidx/lifecycle/LiveData;", "getShowVerificationScreen", "()Landroidx/lifecycle/LiveData;", "showVerificationScreen", VKApiConst.Q, "getCountry", "()Ljava/lang/String;", "setCountry", "(Ljava/lang/String;)V", "country", "", "getShowNextDocument", "showNextDocument", "getShowContent", "showContent", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "j", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "_showNextDocumentActionLiveData", "l", "get_showContentLiveData", "_showContentLiveData", "Landroidx/lifecycle/SavedStateHandle;", "s", "Landroidx/lifecycle/SavedStateHandle;", "getSavedStateHandle", "()Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "k", "_showVerificationScreenActionLiveData", "Lcom/sumsub/sns/core/data/model/Applicant;", "p", "getApplicant", "()Lcom/sumsub/sns/core/data/model/Applicant;", "setApplicant", "(Lcom/sumsub/sns/core/data/model/Applicant;)V", "applicant", "r", "getIdDocType", "setIdDocType", "idDocType", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Lcom/sumsub/sns/core/domain/GetConfigUseCase;Lcom/sumsub/sns/core/domain/GetApplicantUseCase;Lcom/sumsub/sns/core/data/source/common/CommonRepository;)V", "Companion", "StateHandleDelegate", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSBaseDocumentPreviewViewModel extends SNSBaseViewModel {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty[] w = {a2.b.a.a.a.u0(SNSBaseDocumentPreviewViewModel.class, Navigation.CONFIG, "getConfig()Lcom/sumsub/sns/core/data/model/AppConfig;", 0), a2.b.a.a.a.v0(SNSBaseDocumentPreviewViewModel.class, "document", "getDocument()Lcom/sumsub/sns/core/data/model/Document;", 0), a2.b.a.a.a.u0(SNSBaseDocumentPreviewViewModel.class, "applicant", "getApplicant()Lcom/sumsub/sns/core/data/model/Applicant;", 0), a2.b.a.a.a.u0(SNSBaseDocumentPreviewViewModel.class, "country", "getCountry()Ljava/lang/String;", 0), a2.b.a.a.a.u0(SNSBaseDocumentPreviewViewModel.class, "idDocType", "getIdDocType()Ljava/lang/String;", 0)};
    public final ActionLiveData<Event<Object>> j = new ActionLiveData<>();
    public final ActionLiveData<Event<Boolean>> k = new ActionLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> l = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Event<Document>> m = new MutableLiveData<>();
    @NotNull
    public final StateHandleDelegate n;
    @NotNull
    public final StateHandleDelegate o;
    @NotNull
    public final StateHandleDelegate p;
    @Nullable
    public final StateHandleDelegate q;
    @NotNull
    public final StateHandleDelegate r;
    @NotNull
    public final SavedStateHandle s;
    public final GetConfigUseCase t;
    @NotNull
    public final GetApplicantUseCase u;
    public final CommonRepository v;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/SNSBaseDocumentPreviewViewModel$Companion;", "", "", "KEY_APPLICANT", "Ljava/lang/String;", "KEY_CONFIG", "KEY_COUNTRY", "KEY_ID_DOC_TYPE", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0017\u0010\u0018J&\u0010\u0006\u001a\u00028\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/SNSBaseDocumentPreviewViewModel$StateHandleDelegate;", "T", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "value", "", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Landroidx/lifecycle/SavedStateHandle;", AuthSource.SEND_ABUSE, "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "c", "Ljava/lang/Object;", "default", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "key", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/Object;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class StateHandleDelegate<T> {
        public final SavedStateHandle a;
        public final String b;
        public final T c;

        public StateHandleDelegate(@NotNull SavedStateHandle savedStateHandle, @NotNull String str, @Nullable T t) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            Intrinsics.checkNotNullParameter(str, "key");
            this.a = savedStateHandle;
            this.b = str;
            this.c = t;
        }

        public final T getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
            Intrinsics.checkNotNullParameter(kProperty, "property");
            T t = (T) this.a.get(this.b);
            if (t != null) {
                return t;
            }
            T t2 = this.c;
            Intrinsics.checkNotNull(t2);
            return t2;
        }

        public final void setValue(@Nullable Object obj, @NotNull KProperty<?> kProperty, T t) {
            Intrinsics.checkNotNullParameter(kProperty, "property");
            this.a.set(this.b, t);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ StateHandleDelegate(SavedStateHandle savedStateHandle, String str, Object obj, int i, j jVar) {
            this(savedStateHandle, str, (i & 4) != 0 ? null : obj);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel", f = "SNSBaseDocumentPreviewViewModel.kt", i = {}, l = {88}, m = "countryByIP", n = {}, s = {})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ SNSBaseDocumentPreviewViewModel c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSBaseDocumentPreviewViewModel sNSBaseDocumentPreviewViewModel, Continuation continuation) {
            super(continuation);
            this.c = sNSBaseDocumentPreviewViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.c(this);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel$onLoad$1", f = "SNSBaseDocumentPreviewViewModel.kt", i = {}, l = {62, 70, 79}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object b;
        public int c;
        public final /* synthetic */ SNSBaseDocumentPreviewViewModel d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SNSBaseDocumentPreviewViewModel sNSBaseDocumentPreviewViewModel, Continuation continuation) {
            super(2, continuation);
            this.d = sNSBaseDocumentPreviewViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new b(this.d, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new b(this.d, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x009e  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00ae  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0111  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
            // Method dump skipped, instructions count: 299
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public SNSBaseDocumentPreviewViewModel(@NotNull SavedStateHandle savedStateHandle, @NotNull GetConfigUseCase getConfigUseCase, @NotNull GetApplicantUseCase getApplicantUseCase, @NotNull CommonRepository commonRepository) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(getConfigUseCase, "getConfigUseCase");
        Intrinsics.checkNotNullParameter(getApplicantUseCase, "getApplicantUseCase");
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        this.s = savedStateHandle;
        this.t = getConfigUseCase;
        this.u = getApplicantUseCase;
        this.v = commonRepository;
        this.n = new StateHandleDelegate(savedStateHandle, "KEY_CONFIG", null, 4, null);
        this.o = new StateHandleDelegate(savedStateHandle, SNSBaseDocumentPreviewFragment.ARGS_DOCUMENT, null, 4, null);
        this.p = new StateHandleDelegate(savedStateHandle, "KEY_APPLICANT", null, 4, null);
        this.q = new StateHandleDelegate(savedStateHandle, "KEY_COUNTRY", "");
        this.r = new StateHandleDelegate(savedStateHandle, "KEY_ID_DOC_TYPE", IdentityType.Companion.m212getOtherGm96dUI());
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object c(kotlin.coroutines.Continuation<? super java.lang.String> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel.a
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel$a r0 = (com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel$a r0 = new com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel$a
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ Exception -> 0x0092 }
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r12)
            com.sumsub.sns.core.data.source.common.CommonRepository r12 = r11.v
            r0.b = r3
            java.lang.Object r12 = r12.getClientIntegrationSettings(r0)
            if (r12 != r1) goto L_0x0040
            return r1
        L_0x0040:
            java.util.Map r12 = (java.util.Map) r12
            if (r12 == 0) goto L_0x0092
            java.lang.String r5 = "geoIpCountry"
            r0 = 47
            char[] r6 = new char[r3]
            char r0 = (char) r0
            r1 = 0
            r6[r1] = r0
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            java.util.List r0 = kotlin.text.StringsKt__StringsKt.split$default(r5, r6, r7, r8, r9, r10)
            int r2 = r0.size()
            int r2 = r2 - r3
            kotlin.ranges.IntRange r1 = t6.v.e.until(r1, r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x0063:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0082
            r2 = r1
            kotlin.collections.IntIterator r2 = (kotlin.collections.IntIterator) r2
            int r2 = r2.nextInt()
            java.lang.Object r2 = r0.get(r2)
            java.lang.Object r12 = r12.get(r2)
            boolean r2 = r12 instanceof java.util.Map
            if (r2 != 0) goto L_0x007d
            r12 = r4
        L_0x007d:
            java.util.Map r12 = (java.util.Map) r12
            if (r12 == 0) goto L_0x0092
            goto L_0x0063
        L_0x0082:
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r0)
            java.lang.Object r12 = r12.get(r0)
            boolean r0 = r12 instanceof java.lang.String
            if (r0 != 0) goto L_0x008f
            r12 = r4
        L_0x008f:
            java.lang.String r12 = (java.lang.String) r12
            r4 = r12
        L_0x0092:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final Applicant getApplicant() {
        return (Applicant) this.p.getValue(this, w[2]);
    }

    @NotNull
    public final AppConfig getConfig() {
        return (AppConfig) this.n.getValue(this, w[0]);
    }

    @Nullable
    public final String getCountry() {
        return (String) this.q.getValue(this, w[3]);
    }

    @NotNull
    public final Document getDocument() {
        return (Document) this.o.getValue(this, w[1]);
    }

    @NotNull
    public final MutableLiveData<Event<Document>> getDocumentUploaded() {
        return this.m;
    }

    @NotNull
    public final GetApplicantUseCase getGetApplicantUseCase() {
        return this.u;
    }

    @NotNull
    public final String getIdDocType() {
        return (String) this.r.getValue(this, w[4]);
    }

    @NotNull
    public final SavedStateHandle getSavedStateHandle() {
        return this.s;
    }

    @NotNull
    public final LiveData<Boolean> getShowContent() {
        return this.l;
    }

    @NotNull
    public final LiveData<Event<Object>> getShowNextDocument() {
        return this.j;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getShowVerificationScreen() {
        return this.k;
    }

    @NotNull
    public final MutableLiveData<Boolean> get_showContentLiveData() {
        return this.l;
    }

    public final void onDataError(@NotNull Exception exc) {
        Intrinsics.checkNotNullParameter(exc, OkListener.KEY_EXCEPTION);
        Timber.e(exc, "Exception while getting a data", new Object[0]);
        get_showProgressLiveData().setValue(Boolean.FALSE);
        get_throwErrorActionLiveData().setValue(new Event<>(exc));
    }

    public abstract void onDataIsReadableClicked(int i);

    public void onDataLoaded() {
    }

    public final void onDocumentUploaded(@NotNull Document document) {
        Intrinsics.checkNotNullParameter(document, "document");
        this.m.postValue(new Event<>(document));
    }

    @Override // com.sumsub.sns.presentation.screen.base.SNSBaseViewModel
    public void onLoad() {
        super.onLoad();
        String country = getCountry();
        if (country == null || country.length() == 0) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new b(this, null), 3, null);
        }
    }

    public final void onMoveToNextDocument() {
        this.j.setValue(new Event<>(new Object()));
    }

    public final void onMoveToVerificationScreen(boolean z) {
        this.k.setValue(new Event<>(Boolean.valueOf(z)));
    }

    public abstract void onTakeAnotherDataClicked();

    public final void setApplicant(@NotNull Applicant applicant) {
        Intrinsics.checkNotNullParameter(applicant, "<set-?>");
        this.p.setValue(this, w[2], applicant);
    }

    public final void setConfig(@NotNull AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(appConfig, "<set-?>");
        this.n.setValue(this, w[0], appConfig);
    }

    public final void setCountry(@Nullable String str) {
        this.q.setValue(this, w[3], str);
    }

    public final void setIdDocType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.r.setValue(this, w[4], str);
    }

    public final void withProgress(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        MutableLiveData mutableLiveData = get_showProgressLiveData();
        Boolean bool = Boolean.TRUE;
        mutableLiveData.postValue(bool);
        MutableLiveData mutableLiveData2 = this.l;
        Boolean bool2 = Boolean.FALSE;
        mutableLiveData2.postValue(bool2);
        function0.invoke();
        get_showProgressLiveData().postValue(bool2);
        this.l.postValue(bool);
    }
}
