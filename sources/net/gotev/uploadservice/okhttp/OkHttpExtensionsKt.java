package net.gotev.uploadservice.okhttp;

import androidx.browser.trusted.sharing.ShareTarget;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import net.gotev.uploadservice.network.ServerResponse;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "", "hasBody", "(Ljava/lang/String;)Z", "Lokhttp3/Response;", "Lnet/gotev/uploadservice/network/ServerResponse;", "asServerResponse", "(Lokhttp3/Response;)Lnet/gotev/uploadservice/network/ServerResponse;", "uploadservice-okhttp_release"}, k = 2, mv = {1, 4, 0})
public final class OkHttpExtensionsKt {
    @NotNull
    public static final ServerResponse asServerResponse(@NotNull Response response) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(response, "$this$asServerResponse");
        int code = response.code();
        ResponseBody body = response.body();
        if (body == null || (bArr = body.bytes()) == null) {
            bArr = new byte[0];
        }
        return new ServerResponse(code, bArr, new LinkedHashMap(r.toMap(response.headers())));
    }

    public static final boolean hasBody(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$hasBody");
        String obj = StringsKt__StringsKt.trim(str).toString();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
        String upperCase = obj.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        if (!Intrinsics.areEqual(upperCase, ShareTarget.METHOD_GET) && !Intrinsics.areEqual(upperCase, "HEAD")) {
            return true;
        }
        if (Intrinsics.areEqual(upperCase, ShareTarget.METHOD_POST) || Intrinsics.areEqual(upperCase, "PUT") || Intrinsics.areEqual(upperCase, "PATCH") || Intrinsics.areEqual(upperCase, "PROPPATCH") || Intrinsics.areEqual(upperCase, "REPORT")) {
            return true;
        }
        return false;
    }
}
