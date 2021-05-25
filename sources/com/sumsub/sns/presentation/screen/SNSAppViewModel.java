package com.sumsub.sns.presentation.screen;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.google.gson.Gson;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.data.listener.SNSCompleteHandler;
import com.sumsub.sns.core.data.listener.SNSEvent;
import com.sumsub.sns.core.data.listener.SNSEventHandler;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.Error;
import com.sumsub.sns.core.data.model.FlowType;
import com.sumsub.sns.core.data.model.LogType;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.core.domain.GetApplicantUseCase;
import com.sumsub.sns.core.domain.GetConfigUseCase;
import com.sumsub.sns.core.domain.GetStringResourcesUseCase;
import com.sumsub.sns.core.domain.SendLogUseCase;
import com.sumsub.sns.core.domain.model.Either;
import com.sumsub.sns.core.presentation.base.ActionLiveData;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.core.presentation.base.SNSBaseViewModel;
import com.sumsub.sns.domain.GetRequiredDocumentsUseCase;
import com.sumsub.sns.domain.PrepareSDKUseCase;
import com.vk.sdk.api.VKApiConst;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001BN\u0012\u0006\u0010Y\u001a\u00020V\u0012\u0006\u0010b\u001a\u00020_\u0012\u0006\u0010o\u001a\u00020l\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010H\u001a\u00020E\u0012\u0007\u0010\u0001\u001a\u00020}\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010|\u001a\u00020y¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0013\u001a\u00020\u00042\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010\bJQ\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#2 \u0010&\u001a\u001c\u0012\u0004\u0012\u00020$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#\u0018\u00010#H@ø\u0001\u0000¢\u0006\u0004\b'\u0010(J1\u0010+\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0)H@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0013\u0010-\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u001b\u0010/\u001a\u00020\u00042\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0002¢\u0006\u0004\b/\u0010\u0014J\u0017\u00100\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b0\u0010\u000eJ\u0017\u00101\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b1\u0010\bJ\u001b\u00102\u001a\u00020\u00042\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0002¢\u0006\u0004\b2\u0010\u0014J\u0017\u00103\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b3\u0010\bJ0\u00108\u001a\u00020\u00042\u001c\u00107\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000405\u0012\u0006\u0012\u0004\u0018\u00010604H\u0002ø\u0001\u0000¢\u0006\u0004\b8\u00109R\"\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0;0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R%\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0;0?8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001f\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0;0I8F@\u0006¢\u0006\u0006\u001a\u0004\bJ\u0010KR\"\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0;0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010=R\"\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060;0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010=R\"\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0;0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010=R$\u0010U\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010\u000eR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001f\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150;0I8F@\u0006¢\u0006\u0006\u001a\u0004\bZ\u0010KR\u0016\u0010^\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\"\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0;0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010=R\u001f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00020I8\u0006@\u0006¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010KR\u001f\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0;0I8F@\u0006¢\u0006\u0006\u001a\u0004\bh\u0010KR\u001f\u0010k\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0;0I8F@\u0006¢\u0006\u0006\u001a\u0004\bj\u0010KR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u001c\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00020p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u001f\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0;0I8F@\u0006¢\u0006\u0006\u001a\u0004\bt\u0010KR7\u0010x\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#0#0?8\u0006@\u0006¢\u0006\f\n\u0004\bv\u0010A\u001a\u0004\bw\u0010CR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0017\u0010\u0001\u001a\u00020}8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b~\u0010R!\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0;0I8F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010KR!\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0;0I8F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010KR#\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150;0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010=R!\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0;0I8F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010KR!\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060;0I8F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010KR.\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#0?8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010A\u001a\u0005\b\u0001\u0010CR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R#\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0;0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010=R$\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0;0:8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010=R#\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0;0:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010=R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/presentation/screen/SNSAppViewModel;", "Lcom/sumsub/sns/core/presentation/base/SNSBaseViewModel;", "", "startModule", "", a2.g.r.g.a, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onMoveToNextDocument", "(Z)V", "isCancelled", "onMoveToVerificationScreen", "Lcom/sumsub/sns/core/data/model/Document;", "document", "onDocumentUploaded", "(Lcom/sumsub/sns/core/data/model/Document;)V", "onDocumentClicked", "Ljava/lang/Exception;", "Lkotlin/Exception;", OkListener.KEY_EXCEPTION, "onThrowError", "(Ljava/lang/Exception;)V", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "result", "onCancel", "(Lcom/sumsub/sns/core/data/model/SNSCompletionResult;)V", AuthSource.OPEN_CHANNEL_LIST, "(Lcom/sumsub/sns/core/data/model/Document;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/model/Error;", "error", "onHandleError", "(Lcom/sumsub/sns/core/data/model/Error;)V", "show", "onProgress", "Lcom/sumsub/sns/core/data/model/AppConfig;", Navigation.CONFIG, "", "", "strings", "dict", "j", "(Lcom/sumsub/sns/core/data/model/AppConfig;Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "documents", "h", "(Lcom/sumsub/sns/core/data/model/AppConfig;ZLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "k", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "c", "d", "f", "l", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "e", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "Lcom/sumsub/sns/core/presentation/base/Event;", "o", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "_showPreviewCommonDataActionLiveData", "Landroidx/lifecycle/MutableLiveData;", "p", "Landroidx/lifecycle/MutableLiveData;", "getShowLiveness", "()Landroidx/lifecycle/MutableLiveData;", "showLiveness", "Lcom/sumsub/sns/core/domain/GetStringResourcesUseCase;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/sumsub/sns/core/domain/GetStringResourcesUseCase;", "getStringResourcesUseCase", "Landroidx/lifecycle/LiveData;", "getHandleErrorAction", "()Landroidx/lifecycle/LiveData;", "handleErrorAction", "_handleErrorActionLiveData", "_showVerificationScreenActionLiveData", "_showPreviewSelfieActionLiveData", "t", "Lcom/sumsub/sns/core/data/model/Document;", "getDocumentStarted", "()Lcom/sumsub/sns/core/data/model/Document;", "setDocumentStarted", "documentStarted", "Landroidx/lifecycle/SavedStateHandle;", "w", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "getCancel", "cancel", VKApiConst.Q, "Z", "isSdkPrepared", "Lcom/sumsub/sns/domain/PrepareSDKUseCase;", "x", "Lcom/sumsub/sns/domain/PrepareSDKUseCase;", "prepareSDKUseCase", "_showPreviewIdentityActionLiveData", VKApiConst.VERSION, "Landroidx/lifecycle/LiveData;", "getProgress", "progress", "getShowError", "showError", "getShowPreviewSelfie", "showPreviewSelfie", "Lcom/sumsub/sns/core/domain/GetApplicantUseCase;", "y", "Lcom/sumsub/sns/core/domain/GetApplicantUseCase;", "getApplicantUseCase", "Lkotlinx/coroutines/flow/MutableStateFlow;", "u", "Lkotlinx/coroutines/flow/MutableStateFlow;", "progressFlow", "getShowPreviewCommonData", "showPreviewCommonData", "s", "getDictData", "dictData", "Lcom/google/gson/Gson;", "D", "Lcom/google/gson/Gson;", "gson", "Lcom/sumsub/sns/core/domain/GetConfigUseCase;", "B", "Lcom/sumsub/sns/core/domain/GetConfigUseCase;", "getConfigUseCase", "getShowPreviewApplicant", "showPreviewApplicant", "getShowActionsScreen", "showActionsScreen", "_cancelActionLiveData", "getShowPreviewIdentity", "showPreviewIdentity", "getShowVerificationScreen", "showVerificationScreen", "r", "getStringsData", "stringsData", "Lcom/sumsub/sns/domain/GetRequiredDocumentsUseCase;", "z", "Lcom/sumsub/sns/domain/GetRequiredDocumentsUseCase;", "getRequiredDocumentsUseCase", "_showActionsScreenActionLiveData", "n", "_showPreviewApplicantDataActionLiveData", "_showErrorActionLiveData", "Lcom/sumsub/sns/core/domain/SendLogUseCase;", "C", "Lcom/sumsub/sns/core/domain/SendLogUseCase;", "sendLogUseCase", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Lcom/sumsub/sns/domain/PrepareSDKUseCase;Lcom/sumsub/sns/core/domain/GetApplicantUseCase;Lcom/sumsub/sns/domain/GetRequiredDocumentsUseCase;Lcom/sumsub/sns/core/domain/GetStringResourcesUseCase;Lcom/sumsub/sns/core/domain/GetConfigUseCase;Lcom/sumsub/sns/core/domain/SendLogUseCase;Lcom/google/gson/Gson;)V", "Companion", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSAppViewModel extends SNSBaseViewModel {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String KEY_SDK_PREPARED = "KEY_SDK_PREPARED";
    public final GetStringResourcesUseCase A;
    public final GetConfigUseCase B;
    public final SendLogUseCase C;
    public final Gson D;
    public final ActionLiveData<Event<SNSCompletionResult>> g = new ActionLiveData<>();
    public final ActionLiveData<Event<Object>> h = new ActionLiveData<>();
    public final ActionLiveData<Event<String>> i = new ActionLiveData<>();
    public final ActionLiveData<Event<Error>> j = new ActionLiveData<>();
    public final ActionLiveData<Event<Error>> k = new ActionLiveData<>();
    public final ActionLiveData<Event<Document>> l = new ActionLiveData<>();
    public final ActionLiveData<Event<Document>> m = new ActionLiveData<>();
    public final ActionLiveData<Event<Document>> n = new ActionLiveData<>();
    public final ActionLiveData<Event<Document>> o = new ActionLiveData<>();
    @NotNull
    public final MutableLiveData<Event<Document>> p = new MutableLiveData<>();
    public final boolean q;
    @NotNull
    public final MutableLiveData<Map<String, String>> r;
    @NotNull
    public final MutableLiveData<Map<String, Map<String, String>>> s;
    @Nullable
    public Document t;
    public final MutableStateFlow<Boolean> u;
    @NotNull
    public final LiveData<Boolean> v;
    public final SavedStateHandle w;
    public final PrepareSDKUseCase x;
    public final GetApplicantUseCase y;
    public final GetRequiredDocumentsUseCase z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/presentation/screen/SNSAppViewModel$Companion;", "", "", SNSAppViewModel.KEY_SDK_PREPARED, "Ljava/lang/String;", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(t6.r.a.j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            FlowType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            FlowType flowType = FlowType.Standalone;
            iArr[1] = 1;
            FlowType flowType2 = FlowType.Actions;
            iArr[0] = 2;
            FlowType flowType3 = FlowType.Module;
            iArr[2] = 3;
            FlowType.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[2] = 1;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$launchOnViewModelScope$1", f = "SNSAppViewModel.kt", i = {}, l = {403}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ SNSAppViewModel c;
        public final /* synthetic */ Function1 d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSAppViewModel sNSAppViewModel, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.c = sNSAppViewModel;
            this.d = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new a(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new a(this.c, this.d, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1 function1 = this.d;
                this.b = 1;
                if (function1.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (CancellationException unused) {
                    Timber.d("CancellationException happend", new Object[0]);
                } catch (Exception e) {
                    this.c.onThrowError(e);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$logError$1", f = "SNSAppViewModel.kt", i = {}, l = {362}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ SNSAppViewModel c;
        public final /* synthetic */ Exception d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SNSAppViewModel sNSAppViewModel, Exception exc, Continuation continuation) {
            super(2, continuation);
            this.c = sNSAppViewModel;
            this.d = exc;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new b(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new b(this.c, this.d, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SendLogUseCase sendLogUseCase = this.c.C;
                LogType logType = LogType.Error;
                Exception exc = this.d;
                SendLogUseCase.Params params = new SendLogUseCase.Params(logType, exc, exc.getMessage());
                this.b = 1;
                if (sendLogUseCase.run(params, (Continuation<? super Either<? extends Exception, ? extends Object>>) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel", f = "SNSAppViewModel.kt", i = {0, 0, 1, 1, 1}, l = {129, 135, 139}, m = "moveToNextDocument", n = {"this", "startModule", "this", Navigation.CONFIG, "startModule"}, s = {"L$0", "Z$0", "L$0", "L$1", "Z$0"})
    public static final class c extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ SNSAppViewModel c;
        public Object d;
        public Object e;
        public boolean f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SNSAppViewModel sNSAppViewModel, Continuation continuation) {
            super(continuation);
            this.c = sNSAppViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.g(false, this);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$onDocumentClicked$1", f = "SNSAppViewModel.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ SNSAppViewModel c;
        public final /* synthetic */ Document d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(SNSAppViewModel sNSAppViewModel, Document document, Continuation continuation) {
            super(1, continuation);
            this.c = sNSAppViewModel;
            this.d = document;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new d(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new d(this.c, this.d, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Timber.d("A user has clicked on document: " + this.d.getType().getValue(), new Object[0]);
                this.c.c(this.d);
                SNSAppViewModel sNSAppViewModel = this.c;
                Document document = this.d;
                this.b = 1;
                if (sNSAppViewModel.m(document, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$onMoveToNextDocument$1", f = "SNSAppViewModel.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ SNSAppViewModel c;
        public final /* synthetic */ boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(SNSAppViewModel sNSAppViewModel, boolean z, Continuation continuation) {
            super(1, continuation);
            this.c = sNSAppViewModel;
            this.d = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new e(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new e(this.c, this.d, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SNSAppViewModel sNSAppViewModel = this.c;
                boolean z = this.d;
                this.b = 1;
                if (sNSAppViewModel.g(z, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel", f = "SNSAppViewModel.kt", i = {0, 0, 0, 0, 1, 1, 4, 4}, l = {311, 314, 316, 318, 324, 326}, m = "onMoveToNextDocumentSuccess", n = {"this", Navigation.CONFIG, "documents", "startModule", "this", "it", "this", "it"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$2", "L$0", "L$2"})
    public static final class f extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ SNSAppViewModel c;
        public Object d;
        public Object e;
        public Object f;
        public boolean g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(SNSAppViewModel sNSAppViewModel, Continuation continuation) {
            super(continuation);
            this.c = sNSAppViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.h(null, false, null, this);
        }
    }

    public static final class g extends Lambda implements Function1<Document, CharSequence> {
        public static final g a = new g();

        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(Document document) {
            Document document2 = document;
            Intrinsics.checkNotNullParameter(document2, "it");
            return document2.getType().getValue();
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$onMoveToVerificationScreen$1", f = "SNSAppViewModel.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ SNSAppViewModel c;
        public final /* synthetic */ boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(SNSAppViewModel sNSAppViewModel, boolean z, Continuation continuation) {
            super(1, continuation);
            this.c = sNSAppViewModel;
            this.d = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new h(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new h(this.c, this.d, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.c.d(this.d);
                SNSAppViewModel sNSAppViewModel = this.c;
                this.b = 1;
                if (sNSAppViewModel.k(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.c.l(this.d);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel", f = "SNSAppViewModel.kt", i = {}, l = {294}, m = "onSdkPreparedSuccess", n = {}, s = {})
    public static final class i extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ SNSAppViewModel c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(SNSAppViewModel sNSAppViewModel, Continuation continuation) {
            super(continuation);
            this.c = sNSAppViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.j(null, null, null, this);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel", f = "SNSAppViewModel.kt", i = {0}, l = {331}, m = "onStepComplete", n = {"this"}, s = {"L$0"})
    public static final class j extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ SNSAppViewModel c;
        public Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(SNSAppViewModel sNSAppViewModel, Continuation continuation) {
            super(continuation);
            this.c = sNSAppViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.k(this);
        }
    }

    public static final class k extends Lambda implements Function1<Boolean, Long> {
        public static final k a = new k();

        public k() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Long invoke(Boolean bool) {
            return Long.valueOf(bool.booleanValue() ? 0 : 250);
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel$resolveVerificationScreen$1", f = "SNSAppViewModel.kt", i = {1, 2, 2}, l = {375, 376, 377}, m = "invokeSuspend", n = {Navigation.CONFIG, Navigation.CONFIG, "applicant"}, s = {"L$0", "L$0", "L$1"})
    public static final class l extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        public Object b;
        public Object c;
        public int d;
        public final /* synthetic */ SNSAppViewModel e;
        public final /* synthetic */ boolean f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(SNSAppViewModel sNSAppViewModel, boolean z, Continuation continuation) {
            super(1, continuation);
            this.e = sNSAppViewModel;
            this.f = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new l(this.e, this.f, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new l(this.e, this.f, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0078  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0084  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x009c A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00a9  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00b0  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x00f6 A[ADDED_TO_REGION] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
            // Method dump skipped, instructions count: 543
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.SNSAppViewModel.l.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.presentation.screen.SNSAppViewModel", f = "SNSAppViewModel.kt", i = {0, 0}, l = {230}, m = "showPreview", n = {"this", "document"}, s = {"L$0", "L$1"})
    public static final class m extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ SNSAppViewModel c;
        public Object d;
        public Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(SNSAppViewModel sNSAppViewModel, Continuation continuation) {
            super(continuation);
            this.c = sNSAppViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.m(null, this);
        }
    }

    public SNSAppViewModel(@NotNull SavedStateHandle savedStateHandle, @NotNull PrepareSDKUseCase prepareSDKUseCase, @NotNull GetApplicantUseCase getApplicantUseCase, @NotNull GetRequiredDocumentsUseCase getRequiredDocumentsUseCase, @NotNull GetStringResourcesUseCase getStringResourcesUseCase, @NotNull GetConfigUseCase getConfigUseCase, @NotNull SendLogUseCase sendLogUseCase, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(prepareSDKUseCase, "prepareSDKUseCase");
        Intrinsics.checkNotNullParameter(getApplicantUseCase, "getApplicantUseCase");
        Intrinsics.checkNotNullParameter(getRequiredDocumentsUseCase, "getRequiredDocumentsUseCase");
        Intrinsics.checkNotNullParameter(getStringResourcesUseCase, "getStringResourcesUseCase");
        Intrinsics.checkNotNullParameter(getConfigUseCase, "getConfigUseCase");
        Intrinsics.checkNotNullParameter(sendLogUseCase, "sendLogUseCase");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.w = savedStateHandle;
        this.x = prepareSDKUseCase;
        this.y = getApplicantUseCase;
        this.z = getRequiredDocumentsUseCase;
        this.A = getStringResourcesUseCase;
        this.B = getConfigUseCase;
        this.C = sendLogUseCase;
        this.D = gson;
        Boolean bool = (Boolean) savedStateHandle.get(KEY_SDK_PREPARED);
        bool = bool == null ? Boolean.FALSE : bool;
        Intrinsics.checkNotNullExpressionValue(bool, "savedStateHandle.get<Boo…EY_SDK_PREPARED) ?: false");
        boolean booleanValue = bool.booleanValue();
        this.q = booleanValue;
        this.r = new MutableLiveData<>();
        this.s = new MutableLiveData<>();
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.u = MutableStateFlow;
        this.v = FlowLiveDataConversions.asLiveData$default(FlowKt.debounce(MutableStateFlow, k.a), (CoroutineContext) null, 0, 3, (Object) null);
        if (!booleanValue) {
            onProgress(true);
            e(new a2.q.a.d.a.b(this, null));
        }
    }

    public static /* synthetic */ void onMoveToNextDocument$default(SNSAppViewModel sNSAppViewModel, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        sNSAppViewModel.onMoveToNextDocument(z2);
    }

    public final void c(Document document) {
        this.t = document;
        SNSEvent.SNSEventStepInitiated sNSEventStepInitiated = new SNSEvent.SNSEventStepInitiated(document.getType().getValue());
        try {
            SNSEventHandler eventHandler = SNSMobileSDK.INSTANCE.getEventHandler();
            if (eventHandler != null) {
                eventHandler.onEvent(sNSEventStepInitiated);
            }
        } catch (Throwable unused) {
        }
    }

    public final void d(boolean z2) {
        Document document = this.t;
        if (document != null) {
            this.t = null;
            SNSEvent.SNSEventStepCompleted sNSEventStepCompleted = new SNSEvent.SNSEventStepCompleted(document.getType().getValue(), z2);
            try {
                SNSEventHandler eventHandler = SNSMobileSDK.INSTANCE.getEventHandler();
                if (eventHandler != null) {
                    eventHandler.onEvent(sNSEventStepCompleted);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void e(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new a(this, function1, null), 3, null);
    }

    public final void f(Exception exc) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), NonCancellable.INSTANCE, null, new b(this, exc, null), 2, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ab A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(boolean r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
        // Method dump skipped, instructions count: 229
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.SNSAppViewModel.g(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final LiveData<Event<SNSCompletionResult>> getCancel() {
        return this.g;
    }

    @NotNull
    public final MutableLiveData<Map<String, Map<String, String>>> getDictData() {
        return this.s;
    }

    @Nullable
    public final Document getDocumentStarted() {
        return this.t;
    }

    @NotNull
    public final LiveData<Event<Error>> getHandleErrorAction() {
        return this.k;
    }

    @NotNull
    public final LiveData<Boolean> getProgress() {
        return this.v;
    }

    @NotNull
    public final LiveData<Event<String>> getShowActionsScreen() {
        return this.i;
    }

    @NotNull
    public final LiveData<Event<Error>> getShowError() {
        return this.j;
    }

    @NotNull
    public final MutableLiveData<Event<Document>> getShowLiveness() {
        return this.p;
    }

    @NotNull
    public final LiveData<Event<Document>> getShowPreviewApplicant() {
        return this.n;
    }

    @NotNull
    public final LiveData<Event<Document>> getShowPreviewCommonData() {
        return this.o;
    }

    @NotNull
    public final LiveData<Event<Document>> getShowPreviewIdentity() {
        return this.l;
    }

    @NotNull
    public final LiveData<Event<Document>> getShowPreviewSelfie() {
        return this.m;
    }

    @NotNull
    public final LiveData<Event<Object>> getShowVerificationScreen() {
        return this.h;
    }

    @NotNull
    public final MutableLiveData<Map<String, String>> getStringsData() {
        return this.r;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a5, code lost:
        if (r6 == null) goto L_0x01a9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x015c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object h(com.sumsub.sns.core.data.model.AppConfig r19, boolean r20, java.util.List<com.sumsub.sns.core.data.model.Document> r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
        // Method dump skipped, instructions count: 462
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.SNSAppViewModel.h(com.sumsub.sns.core.data.model.AppConfig, boolean, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void i(Exception exc) {
        onProgress(false);
        Timber.e(exc, "An error while preparing the sdk...", new Object[0]);
        this.j.setValue(new Event<>(new Error.Init(exc)));
        f(exc);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object j(com.sumsub.sns.core.data.model.AppConfig r6, java.util.Map<java.lang.String, java.lang.String> r7, java.util.Map<java.lang.String, ? extends java.util.Map<java.lang.String, java.lang.String>> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.presentation.screen.SNSAppViewModel.i
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.presentation.screen.SNSAppViewModel$i r0 = (com.sumsub.sns.presentation.screen.SNSAppViewModel.i) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.presentation.screen.SNSAppViewModel$i r0 = new com.sumsub.sns.presentation.screen.SNSAppViewModel$i
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00ac
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "SDK is prepared. Applicant - "
            r9.append(r2)
            java.lang.String r2 = r6.getApplicantId()
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            r2 = 0
            java.lang.Object[] r4 = new java.lang.Object[r2]
            timber.log.Timber.d(r9, r4)
            androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.String, java.lang.String>> r9 = r5.r
            r9.postValue(r7)
            if (r8 == 0) goto L_0x005c
            androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>>> r7 = r5.s
            r7.postValue(r8)
        L_0x005c:
            androidx.lifecycle.SavedStateHandle r7 = r5.w
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            java.lang.String r9 = "KEY_SDK_PREPARED"
            r7.set(r9, r8)
            com.sumsub.sns.core.data.model.FlowType r7 = r6.getFlowType()
            int r7 = r7.ordinal()
            if (r7 == 0) goto L_0x0084
            if (r7 == r3) goto L_0x0080
            r6 = 2
            if (r7 == r6) goto L_0x0077
            goto L_0x00ac
        L_0x0077:
            r0.b = r3
            java.lang.Object r6 = r5.g(r3, r0)
            if (r6 != r1) goto L_0x00ac
            return r1
        L_0x0080:
            r5.l(r2)
            goto L_0x00ac
        L_0x0084:
            java.lang.String r7 = "com.sumsub.sns.actions.presentation.SNSActionsFragment"
            java.lang.Class.forName(r7)     // Catch:{ Exception -> 0x009d }
            com.sumsub.sns.core.presentation.base.ActionLiveData<com.sumsub.sns.core.presentation.base.Event<java.lang.String>> r7 = r5.i     // Catch:{ Exception -> 0x009d }
            com.sumsub.sns.core.presentation.base.Event r8 = new com.sumsub.sns.core.presentation.base.Event     // Catch:{ Exception -> 0x009d }
            java.lang.String r6 = r6.getActionId()     // Catch:{ Exception -> 0x009d }
            if (r6 == 0) goto L_0x0094
            goto L_0x0096
        L_0x0094:
            java.lang.String r6 = "<unknown>"
        L_0x0096:
            r8.<init>(r6)     // Catch:{ Exception -> 0x009d }
            r7.setValue(r8)     // Catch:{ Exception -> 0x009d }
            goto L_0x00ac
        L_0x009d:
            r6 = move-exception
            java.lang.String r7 = "Actions is not available: "
            java.lang.String r7 = a2.b.a.a.a.a3(r7, r6)
            java.lang.Object[] r8 = new java.lang.Object[r2]
            timber.log.Timber.e(r7, r8)
            r5.onThrowError(r6)
        L_0x00ac:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.SNSAppViewModel.j(com.sumsub.sns.core.data.model.AppConfig, java.util.Map, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object k(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.sumsub.sns.presentation.screen.SNSAppViewModel.j
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.presentation.screen.SNSAppViewModel$j r0 = (com.sumsub.sns.presentation.screen.SNSAppViewModel.j) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.presentation.screen.SNSAppViewModel$j r0 = new com.sumsub.sns.presentation.screen.SNSAppViewModel$j
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.d
            com.sumsub.sns.presentation.screen.SNSAppViewModel r0 = (com.sumsub.sns.presentation.screen.SNSAppViewModel) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004b
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            com.sumsub.sns.core.domain.GetConfigUseCase r5 = r4.B
            com.sumsub.sns.core.domain.GetConfigUseCase$Params r2 = new com.sumsub.sns.core.domain.GetConfigUseCase$Params
            r2.<init>()
            r0.d = r4
            r0.b = r3
            java.lang.Object r5 = r5.invoke(r2, r0)
            if (r5 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r0 = r4
        L_0x004b:
            com.sumsub.sns.core.domain.model.Either r5 = (com.sumsub.sns.core.domain.model.Either) r5
            boolean r1 = r5 instanceof com.sumsub.sns.core.domain.model.Either.Right
            if (r1 != 0) goto L_0x0053
            r1 = 0
            goto L_0x0054
        L_0x0053:
            r1 = r5
        L_0x0054:
            com.sumsub.sns.core.domain.model.Either$Right r1 = (com.sumsub.sns.core.domain.model.Either.Right) r1
            if (r1 == 0) goto L_0x0076
            java.lang.Object r1 = r1.getB()
            com.sumsub.sns.core.data.model.AppConfig r1 = (com.sumsub.sns.core.data.model.AppConfig) r1
            if (r1 == 0) goto L_0x0076
            com.sumsub.sns.core.data.model.FlowType r5 = r1.getFlowType()
            int r5 = r5.ordinal()
            r1 = 2
            if (r5 == r1) goto L_0x0070
            r5 = 0
            r0.l(r5)
            goto L_0x0086
        L_0x0070:
            com.sumsub.sns.core.data.model.SNSCompletionResult$SuccessTermination r5 = com.sumsub.sns.core.data.model.SNSCompletionResult.SuccessTermination.INSTANCE
            r0.onCancel(r5)
            goto L_0x0086
        L_0x0076:
        */
        //  java.lang.String r1 = "null cannot be cast to non-null type com.sumsub.sns.core.domain.model.Either.Left<kotlin.Exception /* = java.lang.Exception */>"
        /*
            java.util.Objects.requireNonNull(r5, r1)
            com.sumsub.sns.core.domain.model.Either$Left r5 = (com.sumsub.sns.core.domain.model.Either.Left) r5
            java.lang.Object r5 = r5.getA()
            java.lang.Exception r5 = (java.lang.Exception) r5
            r0.i(r5)
        L_0x0086:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.SNSAppViewModel.k(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void l(boolean z2) {
        e(new l(this, z2, null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object m(com.sumsub.sns.core.data.model.Document r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
        // Method dump skipped, instructions count: 281
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.SNSAppViewModel.m(com.sumsub.sns.core.data.model.Document, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onCancel(@NotNull SNSCompletionResult sNSCompletionResult) {
        Intrinsics.checkNotNullParameter(sNSCompletionResult, "result");
        Timber.d("Cancel verification with reason - " + sNSCompletionResult, new Object[0]);
        CoroutineScopeKt.cancel(ViewModelKt.getViewModelScope(this), "Cancel verification with reason - " + sNSCompletionResult, new CancellationException("Cancel verification with reason - " + sNSCompletionResult));
        this.g.setValue(new Event<>(sNSCompletionResult));
        try {
            SNSMobileSDK sNSMobileSDK = SNSMobileSDK.INSTANCE;
            SNSCompleteHandler completeHandler = sNSMobileSDK.getCompleteHandler();
            if (completeHandler != null) {
                completeHandler.onComplete(sNSCompletionResult, sNSMobileSDK.getState());
            }
        } catch (Exception e2) {
            Timber.e(e2);
        }
        SNSMobileSDK.INSTANCE.shutdown();
    }

    public final void onDocumentClicked(@NotNull Document document) {
        Intrinsics.checkNotNullParameter(document, "document");
        e(new d(this, document, null));
    }

    public final void onDocumentUploaded(@NotNull Document document) {
        Intrinsics.checkNotNullParameter(document, "document");
        Timber.d("A user has uploaded document: " + document.getType().getValue(), new Object[0]);
        onMoveToNextDocument$default(this, false, 1, null);
    }

    @Override // com.sumsub.sns.core.presentation.base.SNSBaseViewModel
    public void onHandleError(@NotNull Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Timber.d("On handle error - " + error, new Object[0]);
        if (error instanceof Error.Common) {
            onCancel(new SNSCompletionResult.AbnormalTermination(((Error.Common) error).getException()));
        } else if (!(error instanceof Error.Init)) {
            this.k.setValue(new Event<>(error));
        } else if (!this.q) {
            onProgress(true);
            e(new a2.q.a.d.a.b(this, null));
        }
    }

    public final void onMoveToNextDocument(boolean z2) {
        e(new e(this, z2, null));
    }

    public final void onMoveToVerificationScreen(boolean z2) {
        Timber.i("Show verification screen", new Object[0]);
        e(new h(this, z2, null));
    }

    public final void onProgress(boolean z2) {
        this.u.setValue(Boolean.valueOf(z2));
    }

    public final void onThrowError(@NotNull Exception exc) {
        Object obj;
        Intrinsics.checkNotNullParameter(exc, OkListener.KEY_EXCEPTION);
        Timber.e(exc, "An error happens...", new Object[0]);
        if (exc instanceof SNSException.Api) {
            f(exc);
            SNSException.Api api = (SNSException.Api) exc;
            Integer errorCode = api.getErrorCode();
            if ((errorCode != null && errorCode.intValue() == 1000) || ((errorCode != null && errorCode.intValue() == 1001) || ((errorCode != null && errorCode.intValue() == 1002) || ((errorCode != null && errorCode.intValue() == 1003) || ((errorCode != null && errorCode.intValue() == 1004) || ((errorCode != null && errorCode.intValue() == 1005) || ((errorCode != null && errorCode.intValue() == 1006) || ((errorCode != null && errorCode.intValue() == 1007) || ((errorCode != null && errorCode.intValue() == 2000) || ((errorCode != null && errorCode.intValue() == 2001) || ((errorCode != null && errorCode.intValue() == 2002) || ((errorCode != null && errorCode.intValue() == 2003) || ((errorCode != null && errorCode.intValue() == 2004) || (errorCode != null && errorCode.intValue() == 2005)))))))))))))) {
                obj = new Error.Upload(api.getDescription(), api);
            } else {
                obj = new Error.Common(api);
            }
        } else if (exc instanceof SNSException.Network) {
            obj = new Error.Network(exc);
        } else if (exc instanceof IOException) {
            obj = new Error.Network(exc);
        } else if (exc instanceof CancellationException) {
            obj = null;
        } else {
            f(exc);
            obj = new Error.Common(exc);
        }
        if (obj != null) {
            this.j.setValue(new Event<>(obj));
        }
    }

    public final void setDocumentStarted(@Nullable Document document) {
        this.t = document;
    }
}
