package com.sumsub.sns.core;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.SessionContract;
import com.google.gson.Gson;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.common.SNSSession;
import com.sumsub.sns.core.common.StringRepository;
import com.sumsub.sns.core.common.StringResourceRepository;
import com.sumsub.sns.core.data.adapter.network.ApiResponseAdapterFactory;
import com.sumsub.sns.core.data.deserializer.RemoteRequiredDocImagePreviewResultDeserializer;
import com.sumsub.sns.core.data.deserializer.RequiredDocsDeserializer;
import com.sumsub.sns.core.data.model.remote.RemoteRequiredDoc;
import com.sumsub.sns.core.data.model.remote.response.RequiredDocsResponse;
import com.sumsub.sns.core.data.network.interceptor.AdditionalHeaderInterceptor;
import com.sumsub.sns.core.data.network.interceptor.TokenInterceptor;
import com.sumsub.sns.core.data.source.applicant.ApplicantRepository;
import com.sumsub.sns.core.data.source.applicant.RealApplicantRepository;
import com.sumsub.sns.core.data.source.applicant.remote.ApplicantRemoteDataSource;
import com.sumsub.sns.core.data.source.applicant.remote.ApplicantService;
import com.sumsub.sns.core.data.source.cache.CacheRepository;
import com.sumsub.sns.core.data.source.cache.CacheRepositoryImpl;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.data.source.common.CommonService;
import com.sumsub.sns.core.data.source.common.RealCommonRepository;
import com.sumsub.sns.core.data.source.log.LogRepository;
import com.sumsub.sns.core.data.source.log.LogService;
import com.sumsub.sns.core.data.source.log.RealLogRepository;
import com.sumsub.sns.core.data.source.settings.RealSettingsRepository;
import com.sumsub.sns.core.data.source.settings.SettingsRepository;
import com.sumsub.sns.core.domain.FaceDetector;
import com.sumsub.sns.core.domain.MLKitFaceDetector;
import com.vk.sdk.api.VKApiConst;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import t6.n.r;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 q2\u00020\u0001:\u0001qB\u001d\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010L\u001a\u00020G¢\u0006\u0004\bo\u0010pJ!\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\t\u001a\u00020\u00052\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0002¢\u0006\u0004\b\t\u0010\u0007R\u001d\u0010\u000f\u001a\u00020\n8F@\u0006X\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR!\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u00020\u00138F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001f\u001a\u00020\u00198F@\u0006¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010$\u001a\u00020 8B@\u0002X\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\"\u0010#R\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0013\u0010*\u001a\u00020'8F@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001d\u0010/\u001a\u00020+8B@\u0002X\u0002¢\u0006\f\n\u0004\b,\u0010\f\u001a\u0004\b-\u0010.R\u001d\u00104\u001a\u0002008B@\u0002X\u0002¢\u0006\f\n\u0004\b1\u0010\f\u001a\u0004\b2\u00103R\u001d\u00109\u001a\u0002058F@\u0006X\u0002¢\u0006\f\n\u0004\b6\u0010\f\u001a\u0004\b7\u00108R\u001d\u0010>\u001a\u00020:8F@\u0006X\u0002¢\u0006\f\n\u0004\b;\u0010\f\u001a\u0004\b<\u0010=R\u0013\u0010A\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001d\u0010F\u001a\u00020B8B@\u0002X\u0002¢\u0006\f\n\u0004\bC\u0010\f\u001a\u0004\bD\u0010ER\u0019\u0010L\u001a\u00020G8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001d\u0010Q\u001a\u00020M8F@\u0006X\u0002¢\u0006\f\n\u0004\bN\u0010\f\u001a\u0004\bO\u0010PR.\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010&R\u001d\u0010W\u001a\u00020S8F@\u0006X\u0002¢\u0006\f\n\u0004\bT\u0010\f\u001a\u0004\bU\u0010VR\u0019\u0010]\u001a\u00020X8\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u0019\u0010c\u001a\u00020^8\u0006@\u0006¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u001d\u0010h\u001a\u00020d8F@\u0006X\u0002¢\u0006\f\n\u0004\be\u0010\f\u001a\u0004\bf\u0010gR\u001f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00030i8\u0006@\u0006¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m¨\u0006r"}, d2 = {"Lcom/sumsub/sns/core/ServiceLocator;", "", "", "", "strings", "", "setStrings", "(Ljava/util/Map;)V", "dictionaries", "setDictionaries", "Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getSettingsRepository", "()Lcom/sumsub/sns/core/data/source/settings/SettingsRepository;", "settingsRepository", "getErrorCodes", "()Ljava/util/Map;", "errorCodes", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", AuthSource.BOOKING_ORDER, "getCommonRepository", "()Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", VKApiConst.Q, "Ljava/lang/ref/WeakReference;", "context", "getApplicationContext", "()Landroid/content/Context;", "applicationContext", "Lcom/sumsub/sns/core/data/source/common/CommonService;", "l", "getCommonService", "()Lcom/sumsub/sns/core/data/source/common/CommonService;", "commonService", "o", "Ljava/util/Map;", "Lcom/sumsub/sns/core/domain/FaceDetector;", "getFaceDetector", "()Lcom/sumsub/sns/core/domain/FaceDetector;", "faceDetector", "Lretrofit2/Retrofit;", "j", "getRetrofit", "()Lretrofit2/Retrofit;", "retrofit", "Lcom/sumsub/sns/core/data/source/applicant/remote/ApplicantService;", AuthSource.OPEN_CHANNEL_LIST, "getApplicantService", "()Lcom/sumsub/sns/core/data/source/applicant/remote/ApplicantService;", "applicantService", "Lcom/sumsub/sns/core/data/source/log/LogRepository;", "d", "getLogRepository", "()Lcom/sumsub/sns/core/data/source/log/LogRepository;", "logRepository", "Lokhttp3/OkHttpClient;", "i", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient", "getFlowName", "()Ljava/lang/String;", "flowName", "Lcom/sumsub/sns/core/data/source/log/LogService;", "n", "getLogService", "()Lcom/sumsub/sns/core/data/source/log/LogService;", "logService", "Lcom/sumsub/sns/core/common/SNSSession;", "r", "Lcom/sumsub/sns/core/common/SNSSession;", "getSession", "()Lcom/sumsub/sns/core/common/SNSSession;", SessionContract.SESSION, "Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", "c", "getApplicantRepository", "()Lcom/sumsub/sns/core/data/source/applicant/ApplicantRepository;", "applicantRepository", "p", "Lcom/google/gson/Gson;", "h", "getGson", "()Lcom/google/gson/Gson;", "gson", "Lcom/sumsub/sns/core/common/StringRepository;", "f", "Lcom/sumsub/sns/core/common/StringRepository;", "getStringRepository", "()Lcom/sumsub/sns/core/common/StringRepository;", "stringRepository", "Lcom/sumsub/sns/core/common/StringResourceRepository;", a2.g.r.g.a, "Lcom/sumsub/sns/core/common/StringResourceRepository;", "getStringResourceRepository", "()Lcom/sumsub/sns/core/common/StringResourceRepository;", "stringResourceRepository", "Lcom/sumsub/sns/core/data/source/cache/CacheRepository;", "e", "getCacheRepository", "()Lcom/sumsub/sns/core/data/source/cache/CacheRepository;", "cacheRepository", "Lcom/sumsub/sns/core/ValueProvider;", "k", "Lcom/sumsub/sns/core/ValueProvider;", "getTokenProvider", "()Lcom/sumsub/sns/core/ValueProvider;", "tokenProvider", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/sumsub/sns/core/common/SNSSession;)V", "Companion", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceLocator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static ServiceLocator s;
    @NotNull
    public final Lazy a = t6.c.lazy(new k(this));
    @NotNull
    public final Lazy b = t6.c.lazy(new d(this));
    @NotNull
    public final Lazy c = t6.c.lazy(new a(this));
    @NotNull
    public final Lazy d = t6.c.lazy(new g(this));
    @NotNull
    public final Lazy e = t6.c.lazy(new c(this));
    @NotNull
    public final StringRepository f = new StringRepository(this) { // from class: com.sumsub.sns.core.ServiceLocator$stringRepository$1
        public final /* synthetic */ ServiceLocator a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.a = r1;
        }

        @Override // com.sumsub.sns.core.common.StringRepository
        @Nullable
        public CharSequence getText(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "resourceKey");
            String str2 = (String) this.a.o.get(str);
            if (str2 != null) {
                return str2;
            }
            Timber.d(a.e3("StringRepository: ", str, " is not found"), new Object[0]);
            return null;
        }
    };
    @NotNull
    public final StringResourceRepository g = new StringResourceRepository(this) { // from class: com.sumsub.sns.core.ServiceLocator$stringResourceRepository$1
        public final /* synthetic */ ServiceLocator a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.a = r1;
        }

        @Override // com.sumsub.sns.core.common.StringResourceRepository
        @NotNull
        public CharSequence getString(int i2) {
            String resourceEntryName = this.a.getApplicationContext().getResources().getResourceEntryName(i2);
            StringRepository stringRepository = this.a.getStringRepository();
            Intrinsics.checkNotNullExpressionValue(resourceEntryName, "resourceName");
            CharSequence text = stringRepository.getText(resourceEntryName);
            if (text != null) {
                return text;
            }
            CharSequence text2 = this.a.getApplicationContext().getResources().getText(i2);
            Intrinsics.checkNotNullExpressionValue(text2, "applicationContext.resources.getText(resourceId)");
            return text2;
        }
    };
    @NotNull
    public final Lazy h = t6.c.lazy(f.a);
    @NotNull
    public final Lazy i = t6.c.lazy(new i(this));
    public final Lazy j = t6.c.lazy(new j(this));
    @NotNull
    public final ValueProvider<String> k = new ValueProvider<String>(this) { // from class: com.sumsub.sns.core.ServiceLocator$tokenProvider$1
        public final /* synthetic */ ServiceLocator a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.a = r1;
        }

        @Override // com.sumsub.sns.core.ValueProvider
        @NotNull
        public String get() {
            return this.a.getSession().getAccessToken();
        }

        public void put(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "newValue");
            this.a.getSession().setAccessToken(str);
        }
    };
    public final Lazy l = t6.c.lazy(new e(this));
    public final Lazy m = t6.c.lazy(new b(this));
    public final Lazy n = t6.c.lazy(new h(this));
    public Map<String, String> o = r.emptyMap();
    public Map<String, ? extends Map<String, String>> p = r.emptyMap();
    public final WeakReference<Context> q;
    @NotNull
    public final SNSSession r;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/core/ServiceLocator$Companion;", "", "Landroid/app/Activity;", "activity", "Lcom/sumsub/sns/core/common/SNSSession;", SessionContract.SESSION, "Lcom/sumsub/sns/core/ServiceLocator;", "instance", "(Landroid/app/Activity;Lcom/sumsub/sns/core/common/SNSSession;)Lcom/sumsub/sns/core/ServiceLocator;", "INSTANCE", "Lcom/sumsub/sns/core/ServiceLocator;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ServiceLocator instance(@NotNull Activity activity, @NotNull SNSSession sNSSession) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(sNSSession, SessionContract.SESSION);
            ServiceLocator serviceLocator = ServiceLocator.s;
            if (serviceLocator != null) {
                if (!Intrinsics.areEqual(serviceLocator.getSession(), sNSSession)) {
                    serviceLocator = null;
                }
                if (serviceLocator != null) {
                    return serviceLocator;
                }
            }
            ServiceLocator serviceLocator2 = new ServiceLocator(new WeakReference(activity.getApplicationContext()), sNSSession);
            ServiceLocator.s = serviceLocator2;
            return serviceLocator2;
        }

        public Companion(t6.r.a.j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<RealApplicantRepository> {
        public final /* synthetic */ ServiceLocator a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ServiceLocator serviceLocator) {
            super(0);
            this.a = serviceLocator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public RealApplicantRepository invoke() {
            return new RealApplicantRepository(new ApplicantRemoteDataSource(ServiceLocator.access$getApplicantService$p(this.a), this.a.getOkHttpClient(), this.a.getSession().getUrl()));
        }
    }

    public static final class b extends Lambda implements Function0<ApplicantService> {
        public final /* synthetic */ ServiceLocator a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ServiceLocator serviceLocator) {
            super(0);
            this.a = serviceLocator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ApplicantService invoke() {
            return (ApplicantService) ServiceLocator.access$getRetrofit$p(this.a).create(ApplicantService.class);
        }
    }

    public static final class c extends Lambda implements Function0<CacheRepositoryImpl> {
        public final /* synthetic */ ServiceLocator a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ServiceLocator serviceLocator) {
            super(0);
            this.a = serviceLocator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public CacheRepositoryImpl invoke() {
            return new CacheRepositoryImpl(this.a.getApplicationContext());
        }
    }

    public static final class d extends Lambda implements Function0<RealCommonRepository> {
        public final /* synthetic */ ServiceLocator a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ServiceLocator serviceLocator) {
            super(0);
            this.a = serviceLocator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public RealCommonRepository invoke() {
            return new RealCommonRepository(ServiceLocator.access$getCommonService$p(this.a));
        }
    }

    public static final class e extends Lambda implements Function0<CommonService> {
        public final /* synthetic */ ServiceLocator a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ServiceLocator serviceLocator) {
            super(0);
            this.a = serviceLocator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public CommonService invoke() {
            return (CommonService) ServiceLocator.access$getRetrofit$p(this.a).create(CommonService.class);
        }
    }

    public static final class f extends Lambda implements Function0<Gson> {
        public static final f a = new f();

        public f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Gson invoke() {
            return new Gson().newBuilder().registerTypeAdapter(RequiredDocsResponse.class, new RequiredDocsDeserializer()).registerTypeAdapter(RemoteRequiredDoc.ImageReviewResult.class, new RemoteRequiredDocImagePreviewResultDeserializer()).create();
        }
    }

    public static final class g extends Lambda implements Function0<RealLogRepository> {
        public final /* synthetic */ ServiceLocator a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ServiceLocator serviceLocator) {
            super(0);
            this.a = serviceLocator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public RealLogRepository invoke() {
            return new RealLogRepository(ServiceLocator.access$getLogService$p(this.a));
        }
    }

    public static final class h extends Lambda implements Function0<LogService> {
        public final /* synthetic */ ServiceLocator a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ServiceLocator serviceLocator) {
            super(0);
            this.a = serviceLocator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public LogService invoke() {
            return (LogService) ServiceLocator.access$getRetrofit$p(this.a).create(LogService.class);
        }
    }

    public static final class i extends Lambda implements Function0<OkHttpClient> {
        public final /* synthetic */ ServiceLocator a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ServiceLocator serviceLocator) {
            super(0);
            this.a = serviceLocator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public OkHttpClient invoke() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient.Builder addInterceptor = builder.callTimeout(30, timeUnit).connectTimeout(30, timeUnit).readTimeout(30, timeUnit).writeTimeout(30, timeUnit).pingInterval(20, timeUnit).addInterceptor(new AdditionalHeaderInterceptor(this.a.getSettingsRepository())).addInterceptor(new TokenInterceptor(this.a.getTokenProvider()));
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(SNSMobileSDK.INSTANCE.isDebug() ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
            return addInterceptor.addInterceptor(httpLoggingInterceptor).build();
        }
    }

    public static final class j extends Lambda implements Function0<Retrofit> {
        public final /* synthetic */ ServiceLocator a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(ServiceLocator serviceLocator) {
            super(0);
            this.a = serviceLocator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Retrofit invoke() {
            return new Retrofit.Builder().baseUrl(this.a.getSession().getUrl()).client(this.a.getOkHttpClient()).addCallAdapterFactory(new ApiResponseAdapterFactory(new ServiceLocator$retrofit$2$1(this))).addConverterFactory(GsonConverterFactory.create(this.a.getGson())).build();
        }
    }

    public static final class k extends Lambda implements Function0<RealSettingsRepository> {
        public final /* synthetic */ ServiceLocator a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(ServiceLocator serviceLocator) {
            super(0);
            this.a = serviceLocator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public RealSettingsRepository invoke() {
            SharedPreferences sharedPreferences = this.a.getApplicationContext().getSharedPreferences(SNSConstants.PREFERENCES_NAME, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "applicationContext.getSh…ME, Context.MODE_PRIVATE)");
            return new RealSettingsRepository(sharedPreferences);
        }
    }

    public ServiceLocator(@NotNull WeakReference<Context> weakReference, @NotNull SNSSession sNSSession) {
        Intrinsics.checkNotNullParameter(weakReference, "context");
        Intrinsics.checkNotNullParameter(sNSSession, SessionContract.SESSION);
        this.q = weakReference;
        this.r = sNSSession;
    }

    public static final ApplicantService access$getApplicantService$p(ServiceLocator serviceLocator) {
        return (ApplicantService) serviceLocator.m.getValue();
    }

    public static final CommonService access$getCommonService$p(ServiceLocator serviceLocator) {
        return (CommonService) serviceLocator.l.getValue();
    }

    public static final LogService access$getLogService$p(ServiceLocator serviceLocator) {
        return (LogService) serviceLocator.n.getValue();
    }

    public static final Retrofit access$getRetrofit$p(ServiceLocator serviceLocator) {
        return (Retrofit) serviceLocator.j.getValue();
    }

    @NotNull
    public final ApplicantRepository getApplicantRepository() {
        return (ApplicantRepository) this.c.getValue();
    }

    @NotNull
    public final Context getApplicationContext() {
        Context context = this.q.get();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context.get()!!");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.get()!!.applicationContext");
        return applicationContext;
    }

    @NotNull
    public final CacheRepository getCacheRepository() {
        return (CacheRepository) this.e.getValue();
    }

    @NotNull
    public final CommonRepository getCommonRepository() {
        return (CommonRepository) this.b.getValue();
    }

    @Nullable
    public final Map<String, String> getErrorCodes() {
        return (Map) this.p.get("errorCodes");
    }

    @NotNull
    public final FaceDetector getFaceDetector() {
        return new MLKitFaceDetector();
    }

    @NotNull
    public final String getFlowName() {
        return this.r.getFlowName();
    }

    @NotNull
    public final Gson getGson() {
        return (Gson) this.h.getValue();
    }

    @NotNull
    public final LogRepository getLogRepository() {
        return (LogRepository) this.d.getValue();
    }

    @NotNull
    public final OkHttpClient getOkHttpClient() {
        return (OkHttpClient) this.i.getValue();
    }

    @NotNull
    public final SNSSession getSession() {
        return this.r;
    }

    @NotNull
    public final SettingsRepository getSettingsRepository() {
        return (SettingsRepository) this.a.getValue();
    }

    @NotNull
    public final StringRepository getStringRepository() {
        return this.f;
    }

    @NotNull
    public final StringResourceRepository getStringResourceRepository() {
        return this.g;
    }

    @NotNull
    public final ValueProvider<String> getTokenProvider() {
        return this.k;
    }

    public final void setDictionaries(@NotNull Map<String, ? extends Map<String, String>> map) {
        Intrinsics.checkNotNullParameter(map, "dictionaries");
        this.p = map;
    }

    public final void setStrings(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "strings");
        this.o = map;
    }
}
