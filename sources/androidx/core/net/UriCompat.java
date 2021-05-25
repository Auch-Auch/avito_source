package androidx.core.net;

import a2.b.a.a.a;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import com.facebook.common.util.UriUtil;
import com.vk.sdk.api.model.VKApiPhotoSize;
public final class UriCompat {
    @NonNull
    public static String toSafeString(@NonNull Uri uri) {
        String scheme = uri.getScheme();
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (scheme != null) {
            if (scheme.equalsIgnoreCase("tel") || scheme.equalsIgnoreCase("sip") || scheme.equalsIgnoreCase(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_SMS) || scheme.equalsIgnoreCase("smsto") || scheme.equalsIgnoreCase("mailto") || scheme.equalsIgnoreCase("nfc")) {
                StringBuilder sb = new StringBuilder(64);
                sb.append(scheme);
                sb.append(':');
                if (schemeSpecificPart != null) {
                    for (int i = 0; i < schemeSpecificPart.length(); i++) {
                        char charAt = schemeSpecificPart.charAt(i);
                        if (charAt == '-' || charAt == '@' || charAt == '.') {
                            sb.append(charAt);
                        } else {
                            sb.append(VKApiPhotoSize.X);
                        }
                    }
                }
                return sb.toString();
            } else if (scheme.equalsIgnoreCase(UriUtil.HTTP_SCHEME) || scheme.equalsIgnoreCase("https") || scheme.equalsIgnoreCase("ftp") || scheme.equalsIgnoreCase("rtsp")) {
                StringBuilder L = a.L("//");
                String str = "";
                L.append(uri.getHost() != null ? uri.getHost() : str);
                if (uri.getPort() != -1) {
                    StringBuilder L2 = a.L(":");
                    L2.append(uri.getPort());
                    str = L2.toString();
                }
                schemeSpecificPart = a.t(L, str, "/...");
            }
        }
        StringBuilder sb2 = new StringBuilder(64);
        if (scheme != null) {
            sb2.append(scheme);
            sb2.append(':');
        }
        if (schemeSpecificPart != null) {
            sb2.append(schemeSpecificPart);
        }
        return sb2.toString();
    }
}
