package com.avito.android.util;

import com.avito.android.AppConfigurationToggles;
import com.avito.android.remote.UserAgentProvider;
import com.avito.android.remote.auth.AuthSource;
import java.util.Locale;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0007\u001a\u00020\u00028V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/avito/android/util/UserAgentProviderImpl;", "Lcom/avito/android/remote/UserAgentProvider;", "", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getUserAgent", "()Ljava/lang/String;", "userAgent", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Ljava/util/Locale;", "locale", "Lcom/avito/android/AppConfigurationToggles;", "appConfigurationToggles", "<init>", "(Lcom/avito/android/util/BuildInfo;Ljava/util/Locale;Lcom/avito/android/AppConfigurationToggles;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class UserAgentProviderImpl implements UserAgentProvider {
    @NotNull
    public final Lazy a;

    public static final class a extends Lambda implements Function0<String> {
        public final /* synthetic */ UserAgentProviderImpl a;
        public final /* synthetic */ BuildInfo b;
        public final /* synthetic */ AppConfigurationToggles c;
        public final /* synthetic */ Locale d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(UserAgentProviderImpl userAgentProviderImpl, BuildInfo buildInfo, AppConfigurationToggles appConfigurationToggles, Locale locale) {
            super(0);
            this.a = userAgentProviderImpl;
            this.b = buildInfo;
            this.c = appConfigurationToggles;
            this.d = locale;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            MimeEncoder mimeEncoder = new MimeEncoder();
            return a2.b.a.a.a.H(new Object[]{UserAgentProviderImpl.access$version(this.a, this.b, this.c), mimeEncoder.encodeWord(this.b.getManufacturer()), mimeEncoder.encodeWord(this.b.getModel()), this.b.getVersion(), this.d.toString()}, 5, "AVITO %s (%s %s; Android %s; %s)", "java.lang.String.format(format, *args)");
        }
    }

    @Inject
    public UserAgentProviderImpl(@NotNull BuildInfo buildInfo, @NotNull Locale locale, @NotNull AppConfigurationToggles appConfigurationToggles) {
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(appConfigurationToggles, "appConfigurationToggles");
        this.a = c.lazy(new a(this, buildInfo, appConfigurationToggles, locale));
    }

    public static final String access$version(UserAgentProviderImpl userAgentProviderImpl, BuildInfo buildInfo, AppConfigurationToggles appConfigurationToggles) {
        Objects.requireNonNull(userAgentProviderImpl);
        String value = appConfigurationToggles.getAppVersionName().getValue();
        if (new Regex(buildInfo.isDebug() ? "\\d+\\.\\d+(_[\\d\\.]+)?" : "\\d+\\.\\d+").matches(value)) {
            return value;
        }
        throw new IllegalArgumentException("Version is parsed from User-Agent header (https://cf.avito.ru/x/V9joAQ).\nIt's crucial for DWH, Firewall, Mobile API services and others.".toString());
    }

    @Override // com.avito.android.remote.UserAgentProvider
    @NotNull
    public String getUserAgent() {
        return (String) this.a.getValue();
    }
}
