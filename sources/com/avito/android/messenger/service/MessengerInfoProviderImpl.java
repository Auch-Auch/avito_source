package com.avito.android.messenger.service;

import a2.b.a.a.a;
import android.net.Uri;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.preferences.Preference;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u001b\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/service/MessengerInfoProviderImpl;", "Lcom/avito/android/messenger/service/MessengerInfoProvider;", "", "provideEndpoint", "()Ljava/lang/String;", "provideOrigin", "provideImageUploadEndpoint", "provideFileTransferEndpoint", "", "provideHandshakeHeaders", "()Ljava/util/Map;", "provideConnectionParameters", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "connectionParameters", AuthSource.SEND_ABUSE, "handshakeHeaders", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "<init>", "(Lcom/avito/android/Features;Lcom/avito/android/util/BuildInfo;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerInfoProviderImpl implements MessengerInfoProvider {
    public final Map<String, String> a = q.mapOf(TuplesKt.to("X-Geo-required", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
    public final Map<String, String> b;
    public final Features c;

    public MessengerInfoProviderImpl(@NotNull Features features, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.c = features;
        this.b = r.mapOf(TuplesKt.to(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, "android"), TuplesKt.to(Preference.APP_VERSION, features.getAppVersionName().invoke()), TuplesKt.to("app_version_code", String.valueOf(buildInfo.getVersionCode())));
    }

    @Override // com.avito.android.messenger.service.MessengerInfoProvider
    @NotNull
    public Map<String, String> provideConnectionParameters() {
        return this.b;
    }

    @Override // com.avito.android.messenger.service.MessengerInfoProvider
    @NotNull
    public String provideEndpoint() {
        String invoke = this.c.getWebsocketEndpoint().invoke();
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.CharSequence");
        return StringsKt__StringsKt.trim(invoke).toString();
    }

    @Override // com.avito.android.messenger.service.MessengerInfoProvider
    @NotNull
    public String provideFileTransferEndpoint() {
        String invoke = this.c.getMessengerFileTransferEndpoint().invoke();
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.CharSequence");
        return StringsKt__StringsKt.trim(invoke).toString();
    }

    @Override // com.avito.android.messenger.service.MessengerInfoProvider
    @NotNull
    public Map<String, String> provideHandshakeHeaders() {
        return this.a;
    }

    @Override // com.avito.android.messenger.service.MessengerInfoProvider
    @NotNull
    public String provideImageUploadEndpoint() {
        String invoke = this.c.getMessengerImageUploadEndpoint().invoke();
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.CharSequence");
        return StringsKt__StringsKt.trim(invoke).toString();
    }

    @Override // com.avito.android.messenger.service.MessengerInfoProvider
    @NotNull
    public String provideOrigin() {
        Uri parse = Uri.parse(this.c.getApiUrl().invoke());
        Intrinsics.checkNotNullExpressionValue(parse, "url");
        StringBuilder L = a.L(Intrinsics.stringPlus(parse.getScheme(), "://"));
        L.append(parse.getHost());
        String sb = L.toString();
        Objects.requireNonNull(sb, "null cannot be cast to non-null type kotlin.CharSequence");
        return StringsKt__StringsKt.trim(sb).toString();
    }
}
