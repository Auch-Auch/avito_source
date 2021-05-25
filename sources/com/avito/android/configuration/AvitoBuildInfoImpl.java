package com.avito.android.configuration;

import a2.g.r.g;
import android.content.Context;
import android.os.Build;
import com.avito.android.BuildConfig;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.AvitoBuildInfo;
import com.avito.android.util.BuildInfo;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b \b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\bA\u0010BJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00048\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u0016\u0010\n\u001a\u00020\u00048V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u00020\u00178\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001f\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u000eR\u001c\u0010\"\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u000eR\u001d\u0010(\u001a\u00020#8V@\u0016X\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010-\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\u0012\n\u0004\b)\u0010\f\u0012\u0004\b+\u0010,\u001a\u0004\b*\u0010\u000eR\u001c\u00100\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b.\u0010\f\u001a\u0004\b/\u0010\u000eR\u001c\u00103\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b1\u0010\f\u001a\u0004\b2\u0010\u000eR\u001c\u00106\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u0010\f\u001a\u0004\b5\u0010\u000eR\u001c\u00109\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u0010\u0019\u001a\u0004\b8\u0010\u001bR\u001c\u0010<\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b:\u0010\f\u001a\u0004\b;\u0010\u000eR\u001c\u0010?\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u0010\f\u001a\u0004\b>\u0010\u000eR\u001c\u0010@\u001a\u00020\u00048\u0016@\u0016XD¢\u0006\f\n\u0004\b@\u0010\b\u001a\u0004\b@\u0010\t¨\u0006C"}, d2 = {"Lcom/avito/android/configuration/AvitoBuildInfoImpl;", "Lcom/avito/android/util/AvitoBuildInfo;", "", "company", "", "isManufacturer", "(Ljava/lang/String;)Z", "isStaging", "Z", "()Z", "isEmulator", "l", "Ljava/lang/String;", "getAdjustDefaultTracker", "()Ljava/lang/String;", "adjustDefaultTracker", "d", "getApplicationPackageId", "applicationPackageId", "Landroid/content/Context;", "n", "Landroid/content/Context;", "context", "", g.a, "I", "getVersionCode", "()I", "versionCode", "i", "getApiUrl", "apiUrl", "j", "getWebSocketEndpoint", "webSocketEndpoint", "Lcom/avito/android/util/BuildInfo$VariableBuildProperties;", AuthSource.OPEN_CHANNEL_LIST, "Lkotlin/Lazy;", "getBuildProperties", "()Lcom/avito/android/util/BuildInfo$VariableBuildProperties;", "buildProperties", "h", "getVersionName", "getVersionName$annotations", "()V", "versionName", "k", "getMessengerImageUploadEndpoint", "messengerImageUploadEndpoint", "f", "getBuildType", "buildType", "c", "getVersion", "version", "e", "getSdkVersion", "sdkVersion", AuthSource.BOOKING_ORDER, "getManufacturer", "manufacturer", AuthSource.SEND_ABUSE, "getModel", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "isDebug", "<init>", "(Landroid/content/Context;)V", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
public class AvitoBuildInfoImpl implements AvitoBuildInfo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    public final int e = Build.VERSION.SDK_INT;
    @NotNull
    public final String f = "release";
    public final int g = 1342;
    @NotNull
    public final String h = BuildConfig.VERSION_NAME;
    @NotNull
    public final String i = BuildConfig.API_URL;
    @NotNull
    public final String j = "https://socket.avito.ru/socket";
    @NotNull
    public final String k = "https://socket.avito.ru/images";
    @Nullable
    public final String l = BuildConfig.ADJUST_DEFAULT_TRACKER;
    @NotNull
    public final Lazy m = c.lazy(new a(this));
    public final Context n;

    public static final class a extends Lambda implements Function0<BuildInfo.VariableBuildProperties> {
        public final /* synthetic */ AvitoBuildInfoImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AvitoBuildInfoImpl avitoBuildInfoImpl) {
            super(0);
            this.a = avitoBuildInfoImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public BuildInfo.VariableBuildProperties invoke() {
            return BuildInfo.VariableBuildProperties.Companion.fromContext(this.a.n);
        }
    }

    public AvitoBuildInfoImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.n = context;
        String str = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str, "Build.MODEL");
        this.a = str;
        String str2 = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str2, "Build.MANUFACTURER");
        this.b = str2;
        String str3 = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str3, "Build.VERSION.RELEASE");
        this.c = str3;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        this.d = packageName;
    }

    public static /* synthetic */ void getVersionName$annotations() {
    }

    @Override // com.avito.android.util.AvitoBuildInfo
    @Nullable
    public String getAdjustDefaultTracker() {
        return this.l;
    }

    @Override // com.avito.android.util.AvitoBuildInfo, com.avito.android.util.BuildInfo
    @NotNull
    public String getApiKey() {
        return AvitoBuildInfo.DefaultImpls.getApiKey(this);
    }

    @Override // com.avito.android.util.BuildInfo
    @NotNull
    public String getApiUrl() {
        return this.i;
    }

    @Override // com.avito.android.util.BuildInfo
    @NotNull
    public String getApplicationPackageId() {
        return this.d;
    }

    @Override // com.avito.android.util.BuildInfo
    @NotNull
    public BuildInfo.VariableBuildProperties getBuildProperties() {
        return (BuildInfo.VariableBuildProperties) this.m.getValue();
    }

    @Override // com.avito.android.util.BuildInfo
    @NotNull
    public String getBuildType() {
        return this.f;
    }

    @Override // com.avito.android.util.BuildInfo
    @NotNull
    public String getManufacturer() {
        return this.b;
    }

    @Override // com.avito.android.util.AvitoBuildInfo
    @NotNull
    public String getMessengerImageUploadEndpoint() {
        return this.k;
    }

    @Override // com.avito.android.util.BuildInfo
    @NotNull
    public String getModel() {
        return this.a;
    }

    @Override // com.avito.android.util.BuildInfo
    public int getSdkVersion() {
        return this.e;
    }

    @Override // com.avito.android.util.BuildInfo
    @NotNull
    public String getVersion() {
        return this.c;
    }

    @Override // com.avito.android.util.BuildInfo
    public int getVersionCode() {
        return this.g;
    }

    @Override // com.avito.android.util.BuildInfo
    @NotNull
    public String getVersionName() {
        return this.h;
    }

    @Override // com.avito.android.util.AvitoBuildInfo
    @NotNull
    public String getWebSocketEndpoint() {
        return this.j;
    }

    @Override // com.avito.android.util.BuildInfo
    public boolean isDebug() {
        return false;
    }

    @Override // com.avito.android.util.BuildInfo
    public boolean isEmulator() {
        String str = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(str, "Build.FINGERPRINT");
        if (!m.startsWith$default(str, MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE, false, 2, null)) {
            String str2 = Build.PRODUCT;
            Intrinsics.checkNotNullExpressionValue(str2, "Build.PRODUCT");
            if (!StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "vbox", false, 2, (Object) null)) {
                Intrinsics.checkNotNullExpressionValue(str2, "Build.PRODUCT");
                if (!StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "sdk_phone", false, 2, (Object) null)) {
                    String str3 = Build.HARDWARE;
                    Intrinsics.checkNotNullExpressionValue(str3, "Build.HARDWARE");
                    if (!StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) "vbox", false, 2, (Object) null)) {
                        Intrinsics.checkNotNullExpressionValue(str3, "Build.HARDWARE");
                        if (!StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) "goldfish", false, 2, (Object) null)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // com.avito.android.util.BuildInfo
    public boolean isManufacturer(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "company");
        String str2 = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str2, "Build.MANUFACTURER");
        return StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) str, false, 2, (Object) null);
    }

    @Override // com.avito.android.util.BuildInfo
    public boolean isStaging() {
        return false;
    }
}
