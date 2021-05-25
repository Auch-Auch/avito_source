package com.sumsub.sns.core;

import a2.g.r.g;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.annotation.CallSuper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Names;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.security.ProviderInstaller;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.common.ParamValidationKt;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.common.SNSDebugLogTree;
import com.sumsub.sns.core.common.SNSLogTree;
import com.sumsub.sns.core.common.SNSSession;
import com.sumsub.sns.core.data.listener.SNSActionResultHandler;
import com.sumsub.sns.core.data.listener.SNSCompleteHandler;
import com.sumsub.sns.core.data.listener.SNSErrorHandler;
import com.sumsub.sns.core.data.listener.SNSEvent;
import com.sumsub.sns.core.data.listener.SNSEventHandler;
import com.sumsub.sns.core.data.listener.SNSStateChangedHandler;
import com.sumsub.sns.core.data.listener.TokenExpirationHandler;
import com.sumsub.sns.core.data.model.LogParams;
import com.sumsub.sns.core.data.model.LogParamsKt;
import com.sumsub.sns.core.data.model.LogType;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.core.data.model.SNSInvalidParametersException;
import com.sumsub.sns.core.data.model.SNSSDKState;
import com.sumsub.sns.core.data.model.SNSSupportItem;
import com.sumsub.sns.core.data.network.interceptor.AdditionalHeaderInterceptor;
import com.sumsub.sns.core.data.source.log.LogService;
import com.sumsub.sns.core.data.source.settings.RealSettingsRepository;
import com.vk.sdk.api.VKApiConst;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.NonCancellable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.ok.android.sdk.OkListener;
import t6.n.d;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004PQ\u0012RB\t\b\u0002¢\u0006\u0004\bO\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0013\u0010\u0010\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0004R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0015\u001a\u00020\t8G@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u001c8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010#\u001a\u0004\u0018\u00010 8F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0015\u0010'\u001a\u0004\u0018\u00010$8F@\u0006¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0013\u0010)\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010\u0004R\u0016\u0010,\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0015\u00100\u001a\u0004\u0018\u00010-8F@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060\u00178B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u001aR\u0013\u00105\u001a\u0002028G@\u0006¢\u0006\u0006\u001a\u0004\b3\u00104R\u0013\u00109\u001a\u0002068F@\u0006¢\u0006\u0006\u001a\u0004\b7\u00108R\u0015\u0010=\u001a\u0004\u0018\u00010:8F@\u0006¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0013\u0010A\u001a\u00020>8F@\u0006¢\u0006\u0006\u001a\u0004\b?\u0010@R*\u0010J\u001a\u00020B2\u0006\u0010C\u001a\u00020B8\u0006@@X\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0015\u0010N\u001a\u0004\u0018\u00010K8F@\u0006¢\u0006\u0006\u001a\u0004\bL\u0010M¨\u0006S"}, d2 = {"Lcom/sumsub/sns/core/SNSMobileSDK;", "", "", "toString", "()Ljava/lang/String;", "className", "Lcom/sumsub/sns/core/SNSModule;", "getPluggedModule", "(Ljava/lang/String;)Lcom/sumsub/sns/core/SNSModule;", "", "isModuleAvailable", "(Ljava/lang/String;)Z", "", "shutdown", "()V", "getVersionName", "versionName", "Lcom/sumsub/sns/core/SNSMobileSDK$SDK;", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/SNSMobileSDK$SDK;", "_sdk", "isDebug", "()Z", "", "Lcom/sumsub/sns/core/data/model/SNSSupportItem;", "getSupportItems", "()Ljava/util/List;", "supportItems", "Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "getTokenExpirationHandler", "()Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "tokenExpirationHandler", "Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "getStateChangedHandler", "()Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "stateChangedHandler", "Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "getEventHandler", "()Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "eventHandler", "getPackageName", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "c", "Lcom/sumsub/sns/core/data/model/SNSSupportItem;", "DEFAULT_SUPPORT_ITEM", "Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "getCompleteHandler", "()Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "completeHandler", "modules", "", "getVersionCode", "()I", "versionCode", "Lcom/sumsub/sns/core/common/SNSLogTree;", "getLogTree", "()Lcom/sumsub/sns/core/common/SNSLogTree;", "logTree", "Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "getActionResultHandler", "()Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "actionResultHandler", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "locale", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "<set-?>", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "getState", "()Lcom/sumsub/sns/core/data/model/SNSSDKState;", "setState$sns_core_release", "(Lcom/sumsub/sns/core/data/model/SNSSDKState;)V", "state", "Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "getErrorHandler", "()Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "errorHandler", "<init>", "Builder", "SDK", "SNSSDK", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SNSMobileSDK {
    @NotNull
    public static final SNSMobileSDK INSTANCE = new SNSMobileSDK();
    public static SDK a;
    @NotNull
    public static SNSSDKState b = SNSSDKState.Initial.INSTANCE;
    public static final SNSSupportItem c = new SNSSupportItem(R.string.sns_support_EMAIL_title, R.string.sns_support_EMAIL_description, R.drawable.sns_ic_email, SNSSupportItem.Type.Email, "support@sumsub.com", null, 32, null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\"\u0012\u0007\u0010\u0001\u001a\u00020t\u0012\u0006\u0010]\u001a\u00020\u0002\u0012\u0006\u0010h\u001a\u00020\u0002¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0002\u0010\u001e\u001a\u00020\u00002%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\b2:\b\u0002\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f2:\b\u0002\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f2<\b\u0002\u0010\u001a\u001a6\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000f2%\b\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\r\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00002\b\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b2\u00103J\u001b\u00107\u001a\u00020\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00020504¢\u0006\u0004\b7\u00108J\u001b\u0010;\u001a\u00020\u00002\f\u0010:\u001a\b\u0012\u0004\u0012\u00020904¢\u0006\u0004\b;\u00108J\u0015\u0010>\u001a\u00020\u00002\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J\u0015\u0010B\u001a\u00020\u00002\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CJ\u0015\u0010F\u001a\u00020\u00002\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bF\u0010GJ\r\u0010I\u001a\u00020H¢\u0006\u0004\bI\u0010JR$\u0010P\u001a\u00020<2\u0006\u0010K\u001a\u00020<8\u0000@BX\u000e¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR$\u0010A\u001a\u00020@2\u0006\u0010K\u001a\u00020@8\u0000@BX\u000e¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR(\u00101\u001a\u0004\u0018\u0001002\b\u0010K\u001a\u0004\u0018\u0001008\u0000@BX\u000e¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u001c\u0010]\u001a\u00020\u00028\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R$\u0010E\u001a\u00020D2\u0006\u0010K\u001a\u00020D8\u0000@BX\u000e¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR0\u00106\u001a\b\u0012\u0004\u0012\u000205042\f\u0010K\u001a\b\u0012\u0004\u0012\u000205048\u0000@BX\u000e¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u001c\u0010h\u001a\u00020\u00028\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bf\u0010Z\u001a\u0004\bg\u0010\\R(\u0010)\u001a\u0004\u0018\u00010(2\b\u0010K\u001a\u0004\u0018\u00010(8\u0000@BX\u000e¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR(\u0010%\u001a\u0004\u0018\u00010$2\b\u0010K\u001a\u0004\u0018\u00010$8\u0000@BX\u000e¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010K\u001a\u0004\u0018\u00010\u00028\u0000@BX\u000e¢\u0006\f\n\u0004\bq\u0010Z\u001a\u0004\br\u0010\\R\"\u0010y\u001a\b\u0012\u0004\u0012\u00020t0s8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR(\u0010!\u001a\u0004\u0018\u00010 2\b\u0010K\u001a\u0004\u0018\u00010 8\u0000@BX\u000e¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R*\u0010-\u001a\u0004\u0018\u00010,2\b\u0010K\u001a\u0004\u0018\u00010,8\u0000@BX\u000e¢\u0006\u000e\n\u0004\b~\u0010\u001a\u0006\b\u0001\u0010\u0001R3\u0010\u0001\u001a\b\u0012\u0004\u0012\u000209042\f\u0010K\u001a\b\u0012\u0004\u0012\u000209048\u0000@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010c\u001a\u0005\b\u0001\u0010eR,\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010K\u001a\u0004\u0018\u00010\u00048\u0000@BX\u000e¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "", "", SDKConstants.PARAM_ACCESS_TOKEN, "Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "onTokenExpiration", "withAccessToken", "(Ljava/lang/String;Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;)Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "Lkotlin/Function1;", "Lcom/sumsub/sns/core/data/model/SNSException;", "Lkotlin/ParameterName;", "name", OkListener.KEY_EXCEPTION, "", "onError", "Lkotlin/Function2;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "state", "prevState", "onStateChanged", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "result", "onCompleted", "actionId", "answer", "Lcom/sumsub/sns/core/SNSActionResult;", "onActionResult", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "event", "onEvent", "withHandlers", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "stateChangedHandler", "withStateChangedHandler", "(Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;)Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "completeHandler", "withCompleteHandler", "(Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;)Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "errorHandler", "withErrorHandler", "(Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;)Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "actionResultHandler", "withActionResultHandler", "(Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;)Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "eventHandler", "withEventHandler", "(Lcom/sumsub/sns/core/data/listener/SNSEventHandler;)Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "", "Lcom/sumsub/sns/core/SNSModule;", "modules", "withModules", "(Ljava/util/List;)Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "Lcom/sumsub/sns/core/data/model/SNSSupportItem;", "items", "withSupportItems", "", Names.DEBUG, "withDebug", "(Z)Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "Lcom/sumsub/sns/core/common/SNSLogTree;", "logTree", "withLogTree", "(Lcom/sumsub/sns/core/common/SNSLogTree;)Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "Ljava/util/Locale;", "locale", "withLocale", "(Ljava/util/Locale;)Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "Lcom/sumsub/sns/core/SNSMobileSDK$SDK;", "build", "()Lcom/sumsub/sns/core/SNSMobileSDK$SDK;", "<set-?>", "k", "Z", "isDebug$sns_core_release", "()Z", "isDebug", "l", "Lcom/sumsub/sns/core/common/SNSLogTree;", "getLogTree$sns_core_release", "()Lcom/sumsub/sns/core/common/SNSLogTree;", "h", "Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "getEventHandler$sns_core_release", "()Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "n", "Ljava/lang/String;", "getUrl$sns_core_release", "()Ljava/lang/String;", "url", AuthSource.OPEN_CHANNEL_LIST, "Ljava/util/Locale;", "getLocale$sns_core_release", "()Ljava/util/Locale;", "i", "Ljava/util/List;", "getModules$sns_core_release", "()Ljava/util/List;", "o", "getFlowName$sns_core_release", "flowName", "f", "Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "getErrorHandler$sns_core_release", "()Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "e", "Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "getCompleteHandler$sns_core_release", "()Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", AuthSource.BOOKING_ORDER, "getAccessToken$sns_core_release", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", AuthSource.SEND_ABUSE, "Ljava/lang/ref/WeakReference;", "getWeakActivity$sns_core_release", "()Ljava/lang/ref/WeakReference;", "weakActivity", "d", "Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "getStateChangedHandler$sns_core_release", "()Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", g.a, "Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "getActionResultHandler$sns_core_release", "()Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "j", "getSupportItems$sns_core_release", "supportItems", "c", "Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "getOnTokenExpiration$sns_core_release", "()Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "activity", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Builder {
        @NotNull
        public final WeakReference<Activity> a;
        @Nullable
        public String b;
        @Nullable
        public TokenExpirationHandler c;
        @Nullable
        public SNSStateChangedHandler d;
        @Nullable
        public SNSCompleteHandler e;
        @Nullable
        public SNSErrorHandler f;
        @Nullable
        public SNSActionResultHandler g;
        @Nullable
        public SNSEventHandler h;
        @NotNull
        public List<? extends SNSModule> i = CollectionsKt__CollectionsKt.emptyList();
        @NotNull
        public List<SNSSupportItem> j;
        public boolean k;
        @NotNull
        public SNSLogTree l;
        @NotNull
        public Locale m;
        @NotNull
        public final String n;
        @NotNull
        public final String o;

        public Builder(@NotNull Activity activity, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(str2, "flowName");
            this.n = str;
            this.o = str2;
            this.a = new WeakReference<>(activity);
            SNSMobileSDK sNSMobileSDK = SNSMobileSDK.INSTANCE;
            this.j = d.listOf(SNSMobileSDK.c);
            this.l = new SNSDebugLogTree();
            this.m = ExtensionsKt.getDeviceLocale();
        }

        public static /* synthetic */ Builder withAccessToken$default(Builder builder, String str, TokenExpirationHandler tokenExpirationHandler, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            return builder.withAccessToken(str, tokenExpirationHandler);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.sumsub.sns.core.SNSMobileSDK$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder withHandlers$default(Builder builder, Function1 function1, Function2 function2, Function2 function22, Function2 function23, Function1 function12, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                function1 = null;
            }
            if ((i2 & 2) != 0) {
                function2 = null;
            }
            if ((i2 & 4) != 0) {
                function22 = null;
            }
            if ((i2 & 8) != 0) {
                function23 = null;
            }
            if ((i2 & 16) != 0) {
                function12 = null;
            }
            return builder.withHandlers(function1, function2, function22, function23, function12);
        }

        @NotNull
        public final SDK build() throws SNSInvalidParametersException {
            return new SNSSDK(this);
        }

        @Nullable
        public final String getAccessToken$sns_core_release() {
            return this.b;
        }

        @Nullable
        public final SNSActionResultHandler getActionResultHandler$sns_core_release() {
            return this.g;
        }

        @Nullable
        public final SNSCompleteHandler getCompleteHandler$sns_core_release() {
            return this.e;
        }

        @Nullable
        public final SNSErrorHandler getErrorHandler$sns_core_release() {
            return this.f;
        }

        @Nullable
        public final SNSEventHandler getEventHandler$sns_core_release() {
            return this.h;
        }

        @NotNull
        public final String getFlowName$sns_core_release() {
            return this.o;
        }

        @NotNull
        public final Locale getLocale$sns_core_release() {
            return this.m;
        }

        @NotNull
        public final SNSLogTree getLogTree$sns_core_release() {
            return this.l;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.sumsub.sns.core.SNSModule>, java.util.List<com.sumsub.sns.core.SNSModule> */
        @NotNull
        public final List<SNSModule> getModules$sns_core_release() {
            return this.i;
        }

        @Nullable
        public final TokenExpirationHandler getOnTokenExpiration$sns_core_release() {
            return this.c;
        }

        @Nullable
        public final SNSStateChangedHandler getStateChangedHandler$sns_core_release() {
            return this.d;
        }

        @NotNull
        public final List<SNSSupportItem> getSupportItems$sns_core_release() {
            return this.j;
        }

        @NotNull
        public final String getUrl$sns_core_release() {
            return this.n;
        }

        @NotNull
        public final WeakReference<Activity> getWeakActivity$sns_core_release() {
            return this.a;
        }

        public final boolean isDebug$sns_core_release() {
            return this.k;
        }

        @NotNull
        public final Builder withAccessToken(@Nullable String str, @NotNull TokenExpirationHandler tokenExpirationHandler) {
            Intrinsics.checkNotNullParameter(tokenExpirationHandler, "onTokenExpiration");
            this.b = str;
            this.c = tokenExpirationHandler;
            return this;
        }

        @NotNull
        public final Builder withActionResultHandler(@Nullable SNSActionResultHandler sNSActionResultHandler) {
            this.g = sNSActionResultHandler;
            return this;
        }

        @NotNull
        public final Builder withCompleteHandler(@Nullable SNSCompleteHandler sNSCompleteHandler) {
            this.e = sNSCompleteHandler;
            return this;
        }

        @NotNull
        public final Builder withDebug(boolean z) {
            this.k = z;
            return this;
        }

        @NotNull
        public final Builder withErrorHandler(@Nullable SNSErrorHandler sNSErrorHandler) {
            this.f = sNSErrorHandler;
            return this;
        }

        @NotNull
        public final Builder withEventHandler(@Nullable SNSEventHandler sNSEventHandler) {
            this.h = sNSEventHandler;
            return this;
        }

        @NotNull
        public final Builder withHandlers(@Nullable Function1<? super SNSException, Unit> function1, @Nullable Function2<? super SNSSDKState, ? super SNSSDKState, Unit> function2, @Nullable Function2<? super SNSCompletionResult, ? super SNSSDKState, Unit> function22, @Nullable Function2<? super String, ? super String, ? extends SNSActionResult> function23, @Nullable Function1<? super SNSEvent, Unit> function12) {
            SNSMobileSDK$Builder$withHandlers$1$5$1 sNSMobileSDK$Builder$withHandlers$1$5$1 = null;
            this.f = function1 != null ? new SNSMobileSDK$Builder$withHandlers$1$1$1(function1) : null;
            this.d = function2 != null ? new SNSMobileSDK$Builder$withHandlers$1$2$1(function2) : null;
            this.e = function22 != null ? new SNSMobileSDK$Builder$withHandlers$1$3$1(function22) : null;
            this.g = function23 != null ? new SNSMobileSDK$Builder$withHandlers$1$4$1(function23) : null;
            if (function12 != null) {
                sNSMobileSDK$Builder$withHandlers$1$5$1 = new SNSMobileSDK$Builder$withHandlers$1$5$1(function12);
            }
            this.h = sNSMobileSDK$Builder$withHandlers$1$5$1;
            return this;
        }

        @NotNull
        public final Builder withLocale(@NotNull Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            this.m = locale;
            return this;
        }

        @NotNull
        public final Builder withLogTree(@NotNull SNSLogTree sNSLogTree) {
            Intrinsics.checkNotNullParameter(sNSLogTree, "logTree");
            this.l = sNSLogTree;
            return this;
        }

        @NotNull
        public final Builder withModules(@NotNull List<? extends SNSModule> list) {
            Intrinsics.checkNotNullParameter(list, "modules");
            this.i = list;
            return this;
        }

        @NotNull
        public final Builder withStateChangedHandler(@Nullable SNSStateChangedHandler sNSStateChangedHandler) {
            this.d = sNSStateChangedHandler;
            return this;
        }

        @NotNull
        public final Builder withSupportItems(@NotNull List<SNSSupportItem> list) {
            Intrinsics.checkNotNullParameter(list, "items");
            this.j = list;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010l\u001a\u00020k¢\u0006\u0004\bm\u0010nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010%\u001a\u0004\u0018\u00010 8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010*\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001e\u00100\u001a\u0004\u0018\u00010+8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001c\u00106\u001a\u0002018\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001e\u0010=\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b;\u0010'\u001a\u0004\b<\u0010)R\u001c\u0010C\u001a\u00020>8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001c\u0010F\u001a\u00020\u00068\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bD\u0010'\u001a\u0004\bE\u0010)R\u001e\u0010L\u001a\u0004\u0018\u00010G8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001c\u0010O\u001a\u00020\u00068\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bM\u0010'\u001a\u0004\bN\u0010)R$\u0010S\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bP\u0010'\u001a\u0004\bQ\u0010)\"\u0004\bR\u0010\tR\"\u0010Z\u001a\b\u0012\u0004\u0012\u00020U0T8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\"\u0010^\u001a\b\u0012\u0004\u0012\u00020[0\u00198\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\\\u0010\u001c\u001a\u0004\b]\u0010\u001eR\u001c\u0010d\u001a\u00020_8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u001e\u0010j\u001a\u0004\u0018\u00010e8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i¨\u0006o"}, d2 = {"Lcom/sumsub/sns/core/SNSMobileSDK$SDK;", "", "", "launch", "()V", "dismiss", "", "apiUrl", "installUncaughtExceptionHandler$sns_core_release", "(Ljava/lang/String;)V", "installUncaughtExceptionHandler", "removeUncaughtExceptionHandler$sns_core_release", "removeUncaughtExceptionHandler", "Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "n", "Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "getEventHandler$sns_core_release", "()Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "eventHandler", "Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "l", "Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "getErrorHandler$sns_core_release", "()Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "errorHandler", "", "Lcom/sumsub/sns/core/SNSModule;", "e", "Ljava/util/List;", "getModules$sns_core_release", "()Ljava/util/List;", "modules", "Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "k", "Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "getCompleteHandler$sns_core_release", "()Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "completeHandler", "h", "Ljava/lang/String;", "getVersionName$sns_core_release", "()Ljava/lang/String;", "versionName", "", "i", "Ljava/lang/Integer;", "getVersionCode$sns_core_release", "()Ljava/lang/Integer;", "versionCode", "", "o", "Z", "isDebug$sns_core_release", "()Z", "isDebug", "Ljava/lang/Thread$UncaughtExceptionHandler;", "r", "Ljava/lang/Thread$UncaughtExceptionHandler;", "exceptionHandler", g.a, "getPackageName$sns_core_release", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "Ljava/util/Locale;", VKApiConst.Q, "Ljava/util/Locale;", "getLocale$sns_core_release", "()Ljava/util/Locale;", "locale", "c", "getFlowName$sns_core_release", "flowName", "Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "getActionResultHandler$sns_core_release", "()Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "actionResultHandler", AuthSource.BOOKING_ORDER, "getUrl$sns_core_release", "url", "d", "getAccessToken$sns_core_release", "setAccessToken$sns_core_release", SDKConstants.PARAM_ACCESS_TOKEN, "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", AuthSource.SEND_ABUSE, "Ljava/lang/ref/WeakReference;", "getWeakActivity$sns_core_release", "()Ljava/lang/ref/WeakReference;", "weakActivity", "Lcom/sumsub/sns/core/data/model/SNSSupportItem;", "f", "getSupportItems$sns_core_release", "supportItems", "Lcom/sumsub/sns/core/common/SNSLogTree;", "p", "Lcom/sumsub/sns/core/common/SNSLogTree;", "getLogTree$sns_core_release", "()Lcom/sumsub/sns/core/common/SNSLogTree;", "logTree", "Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "j", "Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "getOnTokenExpiration$sns_core_release", "()Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "onTokenExpiration", "Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "builder", "<init>", "(Lcom/sumsub/sns/core/SNSMobileSDK$Builder;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class SDK {
        @NotNull
        public final WeakReference<Activity> a;
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @Nullable
        public String d;
        @NotNull
        public final List<SNSModule> e;
        @NotNull
        public final List<SNSSupportItem> f;
        @Nullable
        public final String g;
        @Nullable
        public final String h;
        @Nullable
        public final Integer i;
        @Nullable
        public final TokenExpirationHandler j;
        @Nullable
        public final SNSCompleteHandler k;
        @Nullable
        public final SNSErrorHandler l;
        @Nullable
        public final SNSActionResultHandler m;
        @Nullable
        public final SNSEventHandler n;
        public final boolean o;
        @NotNull
        public final SNSLogTree p;
        @NotNull
        public final Locale q;
        public Thread.UncaughtExceptionHandler r;

        public SDK(@NotNull Builder builder) {
            String str;
            String str2;
            Context applicationContext;
            String versionName;
            Intrinsics.checkNotNullParameter(builder, "builder");
            this.a = builder.getWeakActivity$sns_core_release();
            boolean z = false;
            Context context = null;
            if (StringsKt__StringsKt.endsWith$default((CharSequence) builder.getUrl$sns_core_release(), '/', false, 2, (Object) null)) {
                str = builder.getUrl$sns_core_release();
            } else {
                str = builder.getUrl$sns_core_release() + "/";
            }
            this.b = str;
            String flowName$sns_core_release = builder.getFlowName$sns_core_release();
            this.c = flowName$sns_core_release;
            this.d = builder.getAccessToken$sns_core_release();
            this.e = builder.getModules$sns_core_release();
            List<SNSSupportItem> supportItems$sns_core_release = builder.getSupportItems$sns_core_release();
            this.f = supportItems$sns_core_release;
            this.j = builder.getOnTokenExpiration$sns_core_release();
            this.k = builder.getCompleteHandler$sns_core_release();
            this.l = builder.getErrorHandler$sns_core_release();
            this.m = builder.getActionResultHandler$sns_core_release();
            this.n = builder.getEventHandler$sns_core_release();
            this.o = builder.isDebug$sns_core_release();
            this.p = builder.getLogTree$sns_core_release();
            this.q = builder.getLocale$sns_core_release();
            ArrayList arrayList = new ArrayList();
            if (str.length() == 0) {
                arrayList.add("Api url must be non-empty. url=" + str);
            }
            if (!ParamValidationKt.isValidUrl(str)) {
                arrayList.add("Api url must be valid. url=" + str);
            }
            if (!ParamValidationKt.isValidToken(this.d)) {
                arrayList.add("Access token must be specified");
            }
            if (flowName$sns_core_release.length() == 0 ? true : z) {
                arrayList.add("Flow name must be specified");
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = supportItems$sns_core_release.iterator();
            while (it.hasNext()) {
                String isValid = it.next().isValid();
                if (isValid != null) {
                    arrayList2.add(isValid);
                }
            }
            if (!arrayList2.isEmpty()) {
                StringBuilder L = a2.b.a.a.a.L("Support items have invalid support items. Why are support items invalid? (");
                L.append(CollectionsKt___CollectionsKt.joinToString$default(arrayList2, null, null, null, 0, null, a2.q.a.c.a.a, 31, null));
                L.append(')');
                arrayList.add(L.toString());
            }
            if (!(!arrayList.isEmpty())) {
                Activity activity = builder.getWeakActivity$sns_core_release().get();
                context = activity != null ? activity.getApplicationContext() : context;
                String str3 = "<unknown>";
                this.g = (context == null || (str2 = context.getPackageName()) == null) ? str3 : str2;
                if (!(context == null || (versionName = ExtensionsKt.getVersionName(context)) == null)) {
                    str3 = versionName;
                }
                this.h = str3;
                this.i = Integer.valueOf(context != null ? ExtensionsKt.getVersionCode(context) : -1);
                if (context != null && (applicationContext = context.getApplicationContext()) != null) {
                    ProviderInstaller.installIfNeededAsync(applicationContext, new SNSMobileSDK$SDK$1$1());
                    return;
                }
                return;
            }
            throw new SNSInvalidParametersException(arrayList);
        }

        public final void dismiss() {
            Activity activity = this.a.get();
            if (activity != null) {
                activity.sendBroadcast(new Intent(SNSConstants.Intent.SNS_ACTION_CLOSE));
            }
        }

        @Nullable
        public final String getAccessToken$sns_core_release() {
            return this.d;
        }

        @Nullable
        public final SNSActionResultHandler getActionResultHandler$sns_core_release() {
            return this.m;
        }

        @Nullable
        public final SNSCompleteHandler getCompleteHandler$sns_core_release() {
            return this.k;
        }

        @Nullable
        public final SNSErrorHandler getErrorHandler$sns_core_release() {
            return this.l;
        }

        @Nullable
        public final SNSEventHandler getEventHandler$sns_core_release() {
            return this.n;
        }

        @NotNull
        public final String getFlowName$sns_core_release() {
            return this.c;
        }

        @NotNull
        public final Locale getLocale$sns_core_release() {
            return this.q;
        }

        @NotNull
        public final SNSLogTree getLogTree$sns_core_release() {
            return this.p;
        }

        @NotNull
        public final List<SNSModule> getModules$sns_core_release() {
            return this.e;
        }

        @Nullable
        public final TokenExpirationHandler getOnTokenExpiration$sns_core_release() {
            return this.j;
        }

        @Nullable
        public final String getPackageName$sns_core_release() {
            return this.g;
        }

        @NotNull
        public final List<SNSSupportItem> getSupportItems$sns_core_release() {
            return this.f;
        }

        @NotNull
        public final String getUrl$sns_core_release() {
            return this.b;
        }

        @Nullable
        public final Integer getVersionCode$sns_core_release() {
            return this.i;
        }

        @Nullable
        public final String getVersionName$sns_core_release() {
            return this.h;
        }

        @NotNull
        public final WeakReference<Activity> getWeakActivity$sns_core_release() {
            return this.a;
        }

        public final void installUncaughtExceptionHandler$sns_core_release(@NotNull String str) {
            Context applicationContext;
            Intrinsics.checkNotNullParameter(str, "apiUrl");
            this.r = Thread.getDefaultUncaughtExceptionHandler();
            Activity activity = this.a.get();
            if (activity != null && (applicationContext = activity.getApplicationContext()) != null) {
                Thread.setDefaultUncaughtExceptionHandler(new a(this.r, applicationContext, str));
            }
        }

        public final boolean isDebug$sns_core_release() {
            return this.o;
        }

        @CallSuper
        public void launch() {
        }

        public final void removeUncaughtExceptionHandler$sns_core_release() {
            Thread.setDefaultUncaughtExceptionHandler(this.r);
        }

        public final void setAccessToken$sns_core_release(@Nullable String str) {
            this.d = str;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/core/SNSMobileSDK$SNSSDK;", "Lcom/sumsub/sns/core/SNSMobileSDK$SDK;", "", "launch", "()V", "Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "s", "Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "getStateChangedHandler$sns_core_release", "()Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "stateChangedHandler", "Lcom/sumsub/sns/core/SNSMobileSDK$Builder;", "builder", "<init>", "(Lcom/sumsub/sns/core/SNSMobileSDK$Builder;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class SNSSDK extends SDK {
        @Nullable
        public final SNSStateChangedHandler s;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SNSSDK(@NotNull Builder builder) {
            super(builder);
            Intrinsics.checkNotNullParameter(builder, "builder");
            this.s = builder.getStateChangedHandler$sns_core_release();
        }

        @Nullable
        public final SNSStateChangedHandler getStateChangedHandler$sns_core_release() {
            return this.s;
        }

        @Override // com.sumsub.sns.core.SNSMobileSDK.SDK
        public void launch() {
            installUncaughtExceptionHandler$sns_core_release(getUrl$sns_core_release());
            super.launch();
            SNSMobileSDK.access$start(SNSMobileSDK.INSTANCE, this);
        }
    }

    public static final class a implements Thread.UncaughtExceptionHandler {
        @Nullable
        public final Thread.UncaughtExceptionHandler a;
        @NotNull
        public final Context b;
        @NotNull
        public final String c;

        @DebugMetadata(c = "com.sumsub.sns.core.SNSMobileSDK$SNSExceptionHandler$uncaughtException$1", f = "SNSMobileSDK.kt", i = {}, l = {453}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.sumsub.sns.core.SNSMobileSDK$a$a */
        public static final class C0316a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int b;
            public final /* synthetic */ a c;
            public final /* synthetic */ Throwable d;
            public final /* synthetic */ Thread e;

            /* renamed from: com.sumsub.sns.core.SNSMobileSDK$a$a$a */
            public static final class C0317a implements HttpLoggingInterceptor.Logger {
                public static final C0317a a = new C0317a();

                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public final void log(String str) {
                    System.out.println((Object) str);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0316a(a aVar, Throwable th, Thread thread, Continuation continuation) {
                super(2, continuation);
                this.c = aVar;
                this.d = th;
                this.e = thread;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                Intrinsics.checkNotNullParameter(continuation, "completion");
                return new C0316a(this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                Continuation<? super Unit> continuation2 = continuation;
                Intrinsics.checkNotNullParameter(continuation2, "completion");
                return new C0316a(this.c, this.d, this.e, continuation2).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                String str;
                String str2;
                Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
                int i = this.b;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Gson create = new Gson().newBuilder().create();
                    SharedPreferences sharedPreferences = this.c.b.getSharedPreferences(SNSConstants.PREFERENCES_NAME, 0);
                    Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
                    RealSettingsRepository realSettingsRepository = new RealSettingsRepository(sharedPreferences);
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    OkHttpClient.Builder addInterceptor = builder.callTimeout(30, timeUnit).connectTimeout(30, timeUnit).readTimeout(30, timeUnit).writeTimeout(30, timeUnit).addInterceptor(new AdditionalHeaderInterceptor(realSettingsRepository));
                    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(C0317a.a);
                    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    LogService logService = (LogService) new Retrofit.Builder().baseUrl(this.c.c).client(addInterceptor.addInterceptor(httpLoggingInterceptor).build()).addConverterFactory(GsonConverterFactory.create(create)).build().create(LogService.class);
                    String string = this.c.b.getSharedPreferences(SNSConstants.PREFERENCES_NAME, 0).getString(SNSConstants.Preference.KEY_APPLICANT_ID, "");
                    if (string != null) {
                        str = string;
                    } else {
                        str = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "preferences.getString(SN…Y_APPLICANT_ID, \"\") ?: \"\"");
                    StackTraceElement[] stackTrace = this.d.getStackTrace();
                    StringWriter stringWriter = new StringWriter();
                    this.d.printStackTrace(new PrintWriter(stringWriter));
                    StackTraceElement stackTraceElement = stackTrace[2];
                    Intrinsics.checkNotNullExpressionValue(stackTraceElement, "stack[2]");
                    String valueOf = String.valueOf(stackTraceElement.getLineNumber());
                    StackTraceElement stackTraceElement2 = stackTrace[2];
                    Intrinsics.checkNotNullExpressionValue(stackTraceElement2, "stack[2]");
                    String fileName = stackTraceElement2.getFileName();
                    String str3 = fileName + ':' + valueOf;
                    Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
                    String message = this.d.getMessage();
                    if (message != null) {
                        str2 = message;
                    } else {
                        str2 = "";
                    }
                    String stringWriter2 = stringWriter.toString();
                    Intrinsics.checkNotNullExpressionValue(stringWriter2, "sw.toString()");
                    LogParams logParams = new LogParams("uncaughtException", str3, null, fileName, str, str2, null, stringWriter2, 64, null);
                    String value = LogType.Error.getValue();
                    Map<String, String> map = LogParamsKt.toMap(logParams);
                    this.b = 1;
                    if (logService.send(value, map, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e2) {
                        Timber.e(a2.b.a.a.a.a3("Can't send exception: ", e2), new Object[0]);
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.c.a;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(this.e, this.d);
                }
                return Unit.INSTANCE;
            }
        }

        public a(@Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NotNull Context context, @NotNull String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "url");
            this.a = uncaughtExceptionHandler;
            this.b = context;
            this.c = str;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@NotNull Thread thread, @NotNull Throwable th) {
            Intrinsics.checkNotNullParameter(thread, "t");
            Intrinsics.checkNotNullParameter(th, "e");
            Timber.e("uncaughtException", new Object[0]);
            Timber.e(th);
            BuildersKt.launch$default(GlobalScope.INSTANCE, NonCancellable.INSTANCE, null, new C0316a(this, th, thread, null), 2, null);
        }
    }

    public static final class b extends Lambda implements Function1<SNSModule, CharSequence> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(SNSModule sNSModule) {
            SNSModule sNSModule2 = sNSModule;
            Intrinsics.checkNotNullParameter(sNSModule2, "it");
            return sNSModule2.getName();
        }
    }

    public static final void access$start(SNSMobileSDK sNSMobileSDK, SDK sdk) {
        SNSErrorHandler errorHandler$sns_core_release;
        Objects.requireNonNull(sNSMobileSDK);
        Activity activity = sdk.getWeakActivity$sns_core_release().get();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "sdk.weakActivity.get() ?: return");
            a = sdk;
            try {
                Intent intent = new Intent();
                intent.setClassName(sNSMobileSDK.getPackageName(), SNSConstants.Intent.SNS_APP);
                String url$sns_core_release = sdk.getUrl$sns_core_release();
                String flowName$sns_core_release = sdk.getFlowName$sns_core_release();
                String accessToken$sns_core_release = sdk.getAccessToken$sns_core_release();
                if (accessToken$sns_core_release == null) {
                    accessToken$sns_core_release = "";
                }
                intent.putExtra(SNSConstants.Intent.SNS_EXTRA_SESSION, new SNSSession(url$sns_core_release, flowName$sns_core_release, accessToken$sns_core_release, sNSMobileSDK.getLocale(), sNSMobileSDK.isDebug(), sNSMobileSDK.getPackageName(), sNSMobileSDK.getVersionName(), sNSMobileSDK.getVersionCode()));
                activity.startActivity(intent);
            } catch (Exception e) {
                SDK sdk2 = a;
                if (sdk2 != null && (errorHandler$sns_core_release = sdk2.getErrorHandler$sns_core_release()) != null) {
                    errorHandler$sns_core_release.onError(new SNSException.Unknown(e));
                }
            }
        }
    }

    public final List<SNSModule> a() {
        List<SNSModule> modules$sns_core_release;
        SDK sdk = a;
        return (sdk == null || (modules$sns_core_release = sdk.getModules$sns_core_release()) == null) ? CollectionsKt__CollectionsKt.emptyList() : modules$sns_core_release;
    }

    @Nullable
    public final SNSActionResultHandler getActionResultHandler() {
        SDK sdk = a;
        if (sdk != null) {
            return sdk.getActionResultHandler$sns_core_release();
        }
        return null;
    }

    @Nullable
    public final SNSCompleteHandler getCompleteHandler() {
        SDK sdk = a;
        if (sdk != null) {
            return sdk.getCompleteHandler$sns_core_release();
        }
        return null;
    }

    @Nullable
    public final SNSErrorHandler getErrorHandler() {
        SDK sdk = a;
        if (sdk != null) {
            return sdk.getErrorHandler$sns_core_release();
        }
        return null;
    }

    @Nullable
    public final SNSEventHandler getEventHandler() {
        SDK sdk = a;
        if (sdk != null) {
            return sdk.getEventHandler$sns_core_release();
        }
        return null;
    }

    @NotNull
    public final Locale getLocale() {
        Locale locale$sns_core_release;
        SDK sdk = a;
        return (sdk == null || (locale$sns_core_release = sdk.getLocale$sns_core_release()) == null) ? ExtensionsKt.getDeviceLocale() : locale$sns_core_release;
    }

    @NotNull
    public final SNSLogTree getLogTree() {
        SNSLogTree logTree$sns_core_release;
        SDK sdk = a;
        return (sdk == null || (logTree$sns_core_release = sdk.getLogTree$sns_core_release()) == null) ? new SNSDebugLogTree() : logTree$sns_core_release;
    }

    @NotNull
    public final String getPackageName() {
        String packageName$sns_core_release;
        SDK sdk = a;
        return (sdk == null || (packageName$sns_core_release = sdk.getPackageName$sns_core_release()) == null) ? "" : packageName$sns_core_release;
    }

    @Nullable
    public final SNSModule getPluggedModule(@NotNull String str) {
        SNSModule sNSModule;
        Intrinsics.checkNotNullParameter(str, "className");
        List<SNSModule> a3 = a();
        ListIterator<SNSModule> listIterator = a3.listIterator(a3.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                sNSModule = null;
                break;
            }
            sNSModule = listIterator.previous();
            if (Intrinsics.areEqual(sNSModule.getClass().getName(), str)) {
                break;
            }
        }
        return sNSModule;
    }

    @NotNull
    public final SNSSDKState getState() {
        return b;
    }

    @Nullable
    public final SNSStateChangedHandler getStateChangedHandler() {
        SDK sdk = a;
        if (!(sdk instanceof SNSSDK)) {
            sdk = null;
        }
        SNSSDK snssdk = (SNSSDK) sdk;
        if (snssdk != null) {
            return snssdk.getStateChangedHandler$sns_core_release();
        }
        return null;
    }

    @NotNull
    public final List<SNSSupportItem> getSupportItems() {
        List<SNSSupportItem> supportItems$sns_core_release;
        SDK sdk = a;
        return (sdk == null || (supportItems$sns_core_release = sdk.getSupportItems$sns_core_release()) == null) ? CollectionsKt__CollectionsKt.emptyList() : supportItems$sns_core_release;
    }

    @Nullable
    public final TokenExpirationHandler getTokenExpirationHandler() {
        SDK sdk = a;
        if (sdk != null) {
            return sdk.getOnTokenExpiration$sns_core_release();
        }
        return null;
    }

    @SuppressLint({"Assert"})
    public final int getVersionCode() {
        Integer versionCode$sns_core_release;
        SDK sdk = a;
        if (sdk == null || (versionCode$sns_core_release = sdk.getVersionCode$sns_core_release()) == null) {
            return -1;
        }
        return versionCode$sns_core_release.intValue();
    }

    @NotNull
    public final String getVersionName() {
        String versionName$sns_core_release;
        SDK sdk = a;
        return (sdk == null || (versionName$sns_core_release = sdk.getVersionName$sns_core_release()) == null) ? "" : versionName$sns_core_release;
    }

    @SuppressLint({"Assert"})
    public final boolean isDebug() {
        SDK sdk = a;
        if (sdk != null) {
            return sdk.isDebug$sns_core_release();
        }
        return false;
    }

    public final boolean isModuleAvailable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "className");
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void setState$sns_core_release(@NotNull SNSSDKState sNSSDKState) {
        Intrinsics.checkNotNullParameter(sNSSDKState, "<set-?>");
        b = sNSSDKState;
    }

    public final void shutdown() {
        SDK sdk = a;
        if (sdk != null) {
            sdk.removeUncaughtExceptionHandler$sns_core_release();
        }
        a = null;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("SNSMobileSDK: Api Url: ");
        SDK sdk = a;
        String str = null;
        L.append(sdk != null ? sdk.getUrl$sns_core_release() : null);
        L.append(", Access Token: ");
        SDK sdk2 = a;
        if (sdk2 != null) {
            str = sdk2.getAccessToken$sns_core_release();
        }
        L.append(str);
        L.append(", Modules: ");
        L.append(a().isEmpty() ? "Empty" : a2.b.a.a.a.s(a2.b.a.a.a.I('['), CollectionsKt___CollectionsKt.joinToString$default(a(), null, null, null, 0, null, b.a, 31, null), ']'));
        L.append(", isDebug: ");
        L.append(isDebug());
        return L.toString();
    }
}
