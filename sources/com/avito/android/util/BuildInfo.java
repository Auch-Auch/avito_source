package com.avito.android.util;

import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001:\u0001(J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0011\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0016\u0010\u0014\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\bR\u0016\u0010\u0019\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u0016\u0010\u001b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\bR\u0016\u0010\u001c\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\u001e\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\bR\u0016\u0010\"\u001a\u00020\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0015R\u001c\u0010'\u001a\u00020\u00028&@'X§\u0004¢\u0006\f\u0012\u0004\b%\u0010&\u001a\u0004\b$\u0010\b¨\u0006)"}, d2 = {"Lcom/avito/android/util/BuildInfo;", "", "", "company", "", "isManufacturer", "(Ljava/lang/String;)Z", "getVersion", "()Ljava/lang/String;", "version", "", "getSdkVersion", "()I", "sdkVersion", "getVersionCode", "versionCode", "getApplicationPackageId", "applicationPackageId", "getBuildType", "buildType", "isStaging", "()Z", "getManufacturer", "manufacturer", "getApiKey", "apiKey", "getModel", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "isDebug", "getApiUrl", "apiUrl", "Lcom/avito/android/util/BuildInfo$VariableBuildProperties;", "getBuildProperties", "()Lcom/avito/android/util/BuildInfo$VariableBuildProperties;", "buildProperties", "isEmulator", "getVersionName", "getVersionName$annotations", "()V", "versionName", "VariableBuildProperties", "config_release"}, k = 1, mv = {1, 4, 2})
public interface BuildInfo {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @Deprecated(message = "Use features.appVersionName")
        public static /* synthetic */ void getVersionName$annotations() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/avito/android/util/BuildInfo$VariableBuildProperties;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getGitCommit", "()Ljava/lang/String;", "gitCommit", AuthSource.BOOKING_ORDER, "getGitBranch", "gitBranch", "c", "getBuildNumber", "buildNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "config_release"}, k = 1, mv = {1, 4, 2})
    public static final class VariableBuildProperties {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @Nullable
        public final String a;
        @Nullable
        public final String b;
        @Nullable
        public final String c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/util/BuildInfo$VariableBuildProperties$Companion;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/util/BuildInfo$VariableBuildProperties;", "fromContext", "(Landroid/content/Context;)Lcom/avito/android/util/BuildInfo$VariableBuildProperties;", "<init>", "()V", "config_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x003b, code lost:
                throw r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0037, code lost:
                r1 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
                kotlin.io.CloseableKt.closeFinally(r5, r0);
             */
            @org.jetbrains.annotations.NotNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final com.avito.android.util.BuildInfo.VariableBuildProperties fromContext(@org.jetbrains.annotations.NotNull android.content.Context r5) {
                /*
                    r4 = this;
                    java.lang.String r0 = "context"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                    java.util.Properties r0 = new java.util.Properties
                    r0.<init>()
                    android.content.res.AssetManager r5 = r5.getAssets()
                    java.lang.String r1 = "app-build-info.properties"
                    java.io.InputStream r5 = r5.open(r1)
                    r0.load(r5)     // Catch:{ all -> 0x0035 }
                    kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0035 }
                    r1 = 0
                    kotlin.io.CloseableKt.closeFinally(r5, r1)
                    com.avito.android.util.BuildInfo$VariableBuildProperties r5 = new com.avito.android.util.BuildInfo$VariableBuildProperties
                    java.lang.String r1 = "GIT_COMMIT"
                    java.lang.String r1 = r0.getProperty(r1)
                    java.lang.String r2 = "GIT_BRANCH"
                    java.lang.String r2 = r0.getProperty(r2)
                    java.lang.String r3 = "BUILD_NUMBER"
                    java.lang.String r0 = r0.getProperty(r3)
                    r5.<init>(r1, r2, r0)
                    return r5
                L_0x0035:
                    r0 = move-exception
                    throw r0     // Catch:{ all -> 0x0037 }
                L_0x0037:
                    r1 = move-exception
                    kotlin.io.CloseableKt.closeFinally(r5, r0)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.BuildInfo.VariableBuildProperties.Companion.fromContext(android.content.Context):com.avito.android.util.BuildInfo$VariableBuildProperties");
            }

            public Companion(j jVar) {
            }
        }

        public VariableBuildProperties() {
            this(null, null, null, 7, null);
        }

        public VariableBuildProperties(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Nullable
        public final String getBuildNumber() {
            return this.c;
        }

        @Nullable
        public final String getGitBranch() {
            return this.b;
        }

        @Nullable
        public final String getGitCommit() {
            return this.a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ VariableBuildProperties(String str, String str2, String str3, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }
    }

    @NotNull
    String getApiKey();

    @NotNull
    String getApiUrl();

    @NotNull
    String getApplicationPackageId();

    @NotNull
    VariableBuildProperties getBuildProperties();

    @NotNull
    String getBuildType();

    @NotNull
    String getManufacturer();

    @NotNull
    String getModel();

    int getSdkVersion();

    @NotNull
    String getVersion();

    int getVersionCode();

    @NotNull
    String getVersionName();

    boolean isDebug();

    boolean isEmulator();

    boolean isManufacturer(@NotNull String str);

    boolean isStaging();
}
