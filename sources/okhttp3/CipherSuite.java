package okhttp3;

import com.avito.android.remote.auth.AuthSource;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004R\u0019\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u000b"}, d2 = {"Lokhttp3/CipherSuite;", "", "", "-deprecated_javaName", "()Ljava/lang/String;", "javaName", "toString", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CipherSuite {
    public static final Companion Companion;
    private static final Map<String, CipherSuite> INSTANCES = new LinkedHashMap();
    @NotNull
    private static final Comparator<String> ORDER_BY_NAME = new Comparator<String>() { // from class: okhttp3.CipherSuite$Companion$ORDER_BY_NAME$1
        public int compare(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, AuthSource.SEND_ABUSE);
            Intrinsics.checkNotNullParameter(str2, AuthSource.BOOKING_ORDER);
            int min = Math.min(str.length(), str2.length());
            for (int i = 4; i < min; i++) {
                char charAt = str.charAt(i);
                char charAt2 = str2.charAt(i);
                if (charAt != charAt2) {
                    if (Intrinsics.compare((int) charAt, (int) charAt2) < 0) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length == length2) {
                return 0;
            }
            if (length < length2) {
                return -1;
            }
            return 1;
        }
    };
    @JvmField
    @NotNull
    public static final CipherSuite TLS_AES_128_CCM_8_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_AES_128_CCM_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_AES_128_GCM_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_AES_256_GCM_SHA384;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_CHACHA20_POLY1305_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_GCM_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_GCM_SHA384;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_DES_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_GCM_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_GCM_SHA384;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_DES_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_RC4_40_MD5;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_3DES_EDE_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_GCM_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_GCM_SHA384;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_DES_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_RC4_128_MD5;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_anon_WITH_NULL_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_EMPTY_RENEGOTIATION_INFO_SCSV;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_FALLBACK_SCSV;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_MD5;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_MD5;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_MD5;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_MD5;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_PSK_WITH_3DES_EDE_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_PSK_WITH_AES_128_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_PSK_WITH_AES_256_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_PSK_WITH_RC4_128_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_EXPORT_WITH_DES40_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_EXPORT_WITH_RC4_40_MD5;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_128_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_256_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_DES_CBC_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_NULL_MD5;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA256;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_RC4_128_MD5;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_RC4_128_SHA;
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_SEED_CBC_SHA;
    @NotNull
    private final String javaName;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b}\b\u0003\u0018\u00002\u00020\u0001B\u000b\b\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\fR,\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\rj\b\u0012\u0004\u0012\u00020\u0002`\u000e8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0016\u0010\u001f\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0016\u0010 \u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b \u0010\u0017R\u0016\u0010!\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0017R\u0016\u0010\"\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0016\u0010#\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0017R\u0016\u0010$\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0017R\u0016\u0010%\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0017R\u0016\u0010&\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0017R\u0016\u0010'\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0017R\u0016\u0010(\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b(\u0010\u0017R\u0016\u0010)\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u0017R\u0016\u0010*\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0017R\u0016\u0010+\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u0017R\u0016\u0010,\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b,\u0010\u0017R\u0016\u0010-\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b-\u0010\u0017R\u0016\u0010.\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0017R\u0016\u0010/\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b/\u0010\u0017R\u0016\u00100\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b0\u0010\u0017R\u0016\u00101\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b1\u0010\u0017R\u0016\u00102\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b2\u0010\u0017R\u0016\u00103\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b3\u0010\u0017R\u0016\u00104\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b4\u0010\u0017R\u0016\u00105\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b5\u0010\u0017R\u0016\u00106\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b6\u0010\u0017R\u0016\u00107\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b7\u0010\u0017R\u0016\u00108\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b8\u0010\u0017R\u0016\u00109\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b9\u0010\u0017R\u0016\u0010:\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b:\u0010\u0017R\u0016\u0010;\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b;\u0010\u0017R\u0016\u0010<\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b<\u0010\u0017R\u0016\u0010=\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b=\u0010\u0017R\u0016\u0010>\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b>\u0010\u0017R\u0016\u0010?\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b?\u0010\u0017R\u0016\u0010@\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b@\u0010\u0017R\u0016\u0010A\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bA\u0010\u0017R\u0016\u0010B\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bB\u0010\u0017R\u0016\u0010C\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bC\u0010\u0017R\u0016\u0010D\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bD\u0010\u0017R\u0016\u0010E\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bE\u0010\u0017R\u0016\u0010F\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bF\u0010\u0017R\u0016\u0010G\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bG\u0010\u0017R\u0016\u0010H\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bH\u0010\u0017R\u0016\u0010I\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bI\u0010\u0017R\u0016\u0010J\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bJ\u0010\u0017R\u0016\u0010K\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bK\u0010\u0017R\u0016\u0010L\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bL\u0010\u0017R\u0016\u0010M\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bM\u0010\u0017R\u0016\u0010N\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bN\u0010\u0017R\u0016\u0010O\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bO\u0010\u0017R\u0016\u0010P\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bP\u0010\u0017R\u0016\u0010Q\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bQ\u0010\u0017R\u0016\u0010R\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bR\u0010\u0017R\u0016\u0010S\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bS\u0010\u0017R\u0016\u0010T\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bT\u0010\u0017R\u0016\u0010U\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bU\u0010\u0017R\u0016\u0010V\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bV\u0010\u0017R\u0016\u0010W\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bW\u0010\u0017R\u0016\u0010X\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bX\u0010\u0017R\u0016\u0010Y\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bY\u0010\u0017R\u0016\u0010Z\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bZ\u0010\u0017R\u0016\u0010[\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b[\u0010\u0017R\u0016\u0010\\\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\\\u0010\u0017R\u0016\u0010]\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b]\u0010\u0017R\u0016\u0010^\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b^\u0010\u0017R\u0016\u0010_\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b_\u0010\u0017R\u0016\u0010`\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b`\u0010\u0017R\u0016\u0010a\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\ba\u0010\u0017R\u0016\u0010b\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bb\u0010\u0017R\u0016\u0010c\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bc\u0010\u0017R\u0016\u0010d\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bd\u0010\u0017R\u0016\u0010e\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\be\u0010\u0017R\u0016\u0010f\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bf\u0010\u0017R\u0016\u0010g\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bg\u0010\u0017R\u0016\u0010h\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bh\u0010\u0017R\u0016\u0010i\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bi\u0010\u0017R\u0016\u0010j\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bj\u0010\u0017R\u0016\u0010k\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bk\u0010\u0017R\u0016\u0010l\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bl\u0010\u0017R\u0016\u0010m\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bm\u0010\u0017R\u0016\u0010n\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bn\u0010\u0017R\u0016\u0010o\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bo\u0010\u0017R\u0016\u0010p\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bp\u0010\u0017R\u0016\u0010q\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bq\u0010\u0017R\u0016\u0010r\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\br\u0010\u0017R\u0016\u0010s\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bs\u0010\u0017R\u0016\u0010t\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bt\u0010\u0017R\u0016\u0010u\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bu\u0010\u0017R\u0016\u0010v\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bv\u0010\u0017R\u0016\u0010w\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bw\u0010\u0017R\u0016\u0010x\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bx\u0010\u0017R\u0016\u0010y\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\by\u0010\u0017R\u0016\u0010z\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bz\u0010\u0017R\u0016\u0010{\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b{\u0010\u0017R\u0016\u0010|\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b|\u0010\u0017R\u0016\u0010}\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b}\u0010\u0017R\u0016\u0010~\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b~\u0010\u0017R\u0016\u0010\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0017R\u0018\u0010\u0001\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010\u0017R\u0018\u0010\u0001\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010\u0017R\u0018\u0010\u0001\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010\u0017R\u0018\u0010\u0001\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010\u0017R\u0018\u0010\u0001\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010\u0017R\u0018\u0010\u0001\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010\u0017R\u0018\u0010\u0001\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010\u0017R\u0018\u0010\u0001\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010\u0017R\u0018\u0010\u0001\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010\u0017R\u0018\u0010\u0001\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010\u0017R\u0018\u0010\u0001\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010\u0017R\u0018\u0010\u0001\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010\u0017R\u0018\u0010\u0001\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010\u0017R\u0018\u0010\u0001\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010\u0017¨\u0006\u0001"}, d2 = {"Lokhttp3/CipherSuite$Companion;", "", "", "javaName", "secondaryName", "(Ljava/lang/String;)Ljava/lang/String;", "", "value", "Lokhttp3/CipherSuite;", "init", "(Ljava/lang/String;I)Lokhttp3/CipherSuite;", "forJavaName", "(Ljava/lang/String;)Lokhttp3/CipherSuite;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "ORDER_BY_NAME", "Ljava/util/Comparator;", "getORDER_BY_NAME$okhttp", "()Ljava/util/Comparator;", "", "INSTANCES", "Ljava/util/Map;", "TLS_AES_128_CCM_8_SHA256", "Lokhttp3/CipherSuite;", "TLS_AES_128_CCM_SHA256", "TLS_AES_128_GCM_SHA256", "TLS_AES_256_GCM_SHA384", "TLS_CHACHA20_POLY1305_SHA256", "TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", "TLS_DHE_DSS_WITH_DES_CBC_SHA", "TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_DHE_RSA_WITH_DES_CBC_SHA", "TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA", "TLS_DH_anon_EXPORT_WITH_RC4_40_MD5", "TLS_DH_anon_WITH_3DES_EDE_CBC_SHA", "TLS_DH_anon_WITH_AES_128_CBC_SHA", "TLS_DH_anon_WITH_AES_128_CBC_SHA256", "TLS_DH_anon_WITH_AES_128_GCM_SHA256", "TLS_DH_anon_WITH_AES_256_CBC_SHA", "TLS_DH_anon_WITH_AES_256_CBC_SHA256", "TLS_DH_anon_WITH_AES_256_GCM_SHA384", "TLS_DH_anon_WITH_DES_CBC_SHA", "TLS_DH_anon_WITH_RC4_128_MD5", "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_ECDSA_WITH_NULL_SHA", "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_NULL_SHA", "TLS_ECDHE_RSA_WITH_RC4_128_SHA", "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_ECDSA_WITH_NULL_SHA", "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_RSA_WITH_NULL_SHA", "TLS_ECDH_RSA_WITH_RC4_128_SHA", "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", "TLS_ECDH_anon_WITH_NULL_SHA", "TLS_ECDH_anon_WITH_RC4_128_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_FALLBACK_SCSV", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", "TLS_KRB5_WITH_DES_CBC_MD5", "TLS_KRB5_WITH_DES_CBC_SHA", "TLS_KRB5_WITH_RC4_128_MD5", "TLS_KRB5_WITH_RC4_128_SHA", "TLS_PSK_WITH_3DES_EDE_CBC_SHA", "TLS_PSK_WITH_AES_128_CBC_SHA", "TLS_PSK_WITH_AES_256_CBC_SHA", "TLS_PSK_WITH_RC4_128_SHA", "TLS_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_RSA_EXPORT_WITH_RC4_40_MD5", "TLS_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA256", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", "TLS_RSA_WITH_DES_CBC_SHA", "TLS_RSA_WITH_NULL_MD5", "TLS_RSA_WITH_NULL_SHA", "TLS_RSA_WITH_NULL_SHA256", "TLS_RSA_WITH_RC4_128_MD5", "TLS_RSA_WITH_RC4_128_SHA", "TLS_RSA_WITH_SEED_CBC_SHA", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final CipherSuite init(String str, int i) {
            CipherSuite cipherSuite = new CipherSuite(str, null);
            CipherSuite.INSTANCES.put(str, cipherSuite);
            return cipherSuite;
        }

        private final String secondaryName(String str) {
            if (m.startsWith$default(str, "TLS_", false, 2, null)) {
                StringBuilder sb = new StringBuilder();
                sb.append("SSL_");
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring = str.substring(4);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring);
                return sb.toString();
            } else if (!m.startsWith$default(str, "SSL_", false, 2, null)) {
                return str;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("TLS_");
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring2 = str.substring(4);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                sb2.append(substring2);
                return sb2.toString();
            }
        }

        @JvmStatic
        @NotNull
        public final synchronized CipherSuite forJavaName(@NotNull String str) {
            CipherSuite cipherSuite;
            Intrinsics.checkNotNullParameter(str, "javaName");
            cipherSuite = (CipherSuite) CipherSuite.INSTANCES.get(str);
            if (cipherSuite == null) {
                cipherSuite = (CipherSuite) CipherSuite.INSTANCES.get(secondaryName(str));
                if (cipherSuite == null) {
                    cipherSuite = new CipherSuite(str, null);
                }
                CipherSuite.INSTANCES.put(str, cipherSuite);
            }
            return cipherSuite;
        }

        @NotNull
        public final Comparator<String> getORDER_BY_NAME$okhttp() {
            return CipherSuite.ORDER_BY_NAME;
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        TLS_RSA_WITH_NULL_MD5 = companion.init("SSL_RSA_WITH_NULL_MD5", 1);
        TLS_RSA_WITH_NULL_SHA = companion.init("SSL_RSA_WITH_NULL_SHA", 2);
        TLS_RSA_EXPORT_WITH_RC4_40_MD5 = companion.init("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        TLS_RSA_WITH_RC4_128_MD5 = companion.init("SSL_RSA_WITH_RC4_128_MD5", 4);
        TLS_RSA_WITH_RC4_128_SHA = companion.init("SSL_RSA_WITH_RC4_128_SHA", 5);
        TLS_RSA_EXPORT_WITH_DES40_CBC_SHA = companion.init("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        TLS_RSA_WITH_DES_CBC_SHA = companion.init("SSL_RSA_WITH_DES_CBC_SHA", 9);
        TLS_RSA_WITH_3DES_EDE_CBC_SHA = companion.init("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = companion.init("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        TLS_DHE_DSS_WITH_DES_CBC_SHA = companion.init("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA = companion.init("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = companion.init("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        TLS_DHE_RSA_WITH_DES_CBC_SHA = companion.init("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA = companion.init("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        TLS_DH_anon_EXPORT_WITH_RC4_40_MD5 = companion.init("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        TLS_DH_anon_WITH_RC4_128_MD5 = companion.init("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA = companion.init("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        TLS_DH_anon_WITH_DES_CBC_SHA = companion.init("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        TLS_DH_anon_WITH_3DES_EDE_CBC_SHA = companion.init("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        TLS_KRB5_WITH_DES_CBC_SHA = companion.init("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        TLS_KRB5_WITH_3DES_EDE_CBC_SHA = companion.init("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        TLS_KRB5_WITH_RC4_128_SHA = companion.init("TLS_KRB5_WITH_RC4_128_SHA", 32);
        TLS_KRB5_WITH_DES_CBC_MD5 = companion.init("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        TLS_KRB5_WITH_3DES_EDE_CBC_MD5 = companion.init("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        TLS_KRB5_WITH_RC4_128_MD5 = companion.init("TLS_KRB5_WITH_RC4_128_MD5", 36);
        TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA = companion.init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        TLS_KRB5_EXPORT_WITH_RC4_40_SHA = companion.init("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5 = companion.init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        TLS_KRB5_EXPORT_WITH_RC4_40_MD5 = companion.init("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        TLS_RSA_WITH_AES_128_CBC_SHA = companion.init("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        TLS_DHE_DSS_WITH_AES_128_CBC_SHA = companion.init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        TLS_DHE_RSA_WITH_AES_128_CBC_SHA = companion.init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        TLS_DH_anon_WITH_AES_128_CBC_SHA = companion.init("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        TLS_RSA_WITH_AES_256_CBC_SHA = companion.init("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        TLS_DHE_DSS_WITH_AES_256_CBC_SHA = companion.init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        TLS_DHE_RSA_WITH_AES_256_CBC_SHA = companion.init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        TLS_DH_anon_WITH_AES_256_CBC_SHA = companion.init("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        TLS_RSA_WITH_NULL_SHA256 = companion.init("TLS_RSA_WITH_NULL_SHA256", 59);
        TLS_RSA_WITH_AES_128_CBC_SHA256 = companion.init("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        TLS_RSA_WITH_AES_256_CBC_SHA256 = companion.init("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        TLS_DHE_DSS_WITH_AES_128_CBC_SHA256 = companion.init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        TLS_RSA_WITH_CAMELLIA_128_CBC_SHA = companion.init("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA = companion.init("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA = companion.init("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        TLS_DHE_RSA_WITH_AES_128_CBC_SHA256 = companion.init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 = companion.init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        TLS_DHE_RSA_WITH_AES_256_CBC_SHA256 = companion.init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        TLS_DH_anon_WITH_AES_128_CBC_SHA256 = companion.init("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        Companion companion2 = Companion;
        TLS_DH_anon_WITH_AES_256_CBC_SHA256 = companion2.init("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        TLS_RSA_WITH_CAMELLIA_256_CBC_SHA = companion2.init("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA = companion2.init("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA = companion2.init("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        TLS_PSK_WITH_RC4_128_SHA = companion2.init("TLS_PSK_WITH_RC4_128_SHA", 138);
        TLS_PSK_WITH_3DES_EDE_CBC_SHA = companion2.init("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        TLS_PSK_WITH_AES_128_CBC_SHA = companion2.init("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        TLS_PSK_WITH_AES_256_CBC_SHA = companion2.init("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        TLS_RSA_WITH_SEED_CBC_SHA = companion2.init("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        TLS_RSA_WITH_AES_128_GCM_SHA256 = companion2.init("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        TLS_RSA_WITH_AES_256_GCM_SHA384 = companion2.init("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 = companion2.init("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 = companion2.init("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 = companion2.init("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 = companion2.init("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        TLS_DH_anon_WITH_AES_128_GCM_SHA256 = companion2.init("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        TLS_DH_anon_WITH_AES_256_GCM_SHA384 = companion2.init("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        TLS_EMPTY_RENEGOTIATION_INFO_SCSV = companion2.init("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        TLS_FALLBACK_SCSV = companion2.init("TLS_FALLBACK_SCSV", org.spongycastle.crypto.tls.CipherSuite.TLS_FALLBACK_SCSV);
        TLS_ECDH_ECDSA_WITH_NULL_SHA = companion2.init("TLS_ECDH_ECDSA_WITH_NULL_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_NULL_SHA);
        TLS_ECDH_ECDSA_WITH_RC4_128_SHA = companion2.init("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_RC4_128_SHA);
        TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = companion2.init("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA);
        TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = companion2.init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA);
        TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = companion2.init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA);
        TLS_ECDHE_ECDSA_WITH_NULL_SHA = companion2.init("TLS_ECDHE_ECDSA_WITH_NULL_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_NULL_SHA);
        TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = companion2.init("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_RC4_128_SHA);
        TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = companion2.init("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA);
        TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = companion2.init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA);
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = companion2.init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA);
        TLS_ECDH_RSA_WITH_NULL_SHA = companion2.init("TLS_ECDH_RSA_WITH_NULL_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_NULL_SHA);
        TLS_ECDH_RSA_WITH_RC4_128_SHA = companion2.init("TLS_ECDH_RSA_WITH_RC4_128_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_RC4_128_SHA);
        TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = companion2.init("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA);
        TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = companion2.init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA);
        TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = companion2.init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA);
        TLS_ECDHE_RSA_WITH_NULL_SHA = companion2.init("TLS_ECDHE_RSA_WITH_NULL_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_NULL_SHA);
        TLS_ECDHE_RSA_WITH_RC4_128_SHA = companion2.init("TLS_ECDHE_RSA_WITH_RC4_128_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_RC4_128_SHA);
        TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = companion2.init("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA);
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = companion2.init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA);
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = companion2.init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA);
        TLS_ECDH_anon_WITH_NULL_SHA = companion2.init("TLS_ECDH_anon_WITH_NULL_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_anon_WITH_NULL_SHA);
        TLS_ECDH_anon_WITH_RC4_128_SHA = companion2.init("TLS_ECDH_anon_WITH_RC4_128_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_anon_WITH_RC4_128_SHA);
        TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = companion2.init("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA);
        TLS_ECDH_anon_WITH_AES_128_CBC_SHA = companion2.init("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_anon_WITH_AES_128_CBC_SHA);
        TLS_ECDH_anon_WITH_AES_256_CBC_SHA = companion2.init("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_anon_WITH_AES_256_CBC_SHA);
        TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 = companion2.init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256);
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 = companion2.init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384);
        TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 = companion2.init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256);
        TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 = companion2.init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384);
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 = companion2.init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256);
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 = companion2.init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384);
        Companion companion3 = Companion;
        TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 = companion3.init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256);
        TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 = companion3.init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384);
        TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = companion3.init("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256);
        TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = companion3.init("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384);
        TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 = companion3.init("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256);
        TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 = companion3.init("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384);
        TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = companion3.init("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256);
        TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = companion3.init("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384);
        TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 = companion3.init("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256);
        TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 = companion3.init("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384);
        TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA = companion3.init("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA);
        TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA = companion3.init("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA);
        TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = companion3.init("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", org.spongycastle.crypto.tls.CipherSuite.DRAFT_TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256);
        TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = companion3.init("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", org.spongycastle.crypto.tls.CipherSuite.DRAFT_TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256);
        TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = companion3.init("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", org.spongycastle.crypto.tls.CipherSuite.DRAFT_TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256);
        TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256 = companion3.init("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", org.spongycastle.crypto.tls.CipherSuite.DRAFT_TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256);
        TLS_AES_128_GCM_SHA256 = companion3.init("TLS_AES_128_GCM_SHA256", 4865);
        TLS_AES_256_GCM_SHA384 = companion3.init("TLS_AES_256_GCM_SHA384", 4866);
        TLS_CHACHA20_POLY1305_SHA256 = companion3.init("TLS_CHACHA20_POLY1305_SHA256", 4867);
        TLS_AES_128_CCM_SHA256 = companion3.init("TLS_AES_128_CCM_SHA256", 4868);
        TLS_AES_128_CCM_8_SHA256 = companion3.init("TLS_AES_128_CCM_8_SHA256", 4869);
    }

    private CipherSuite(String str) {
        this.javaName = str;
    }

    @JvmStatic
    @NotNull
    public static final synchronized CipherSuite forJavaName(@NotNull String str) {
        CipherSuite forJavaName;
        synchronized (CipherSuite.class) {
            forJavaName = Companion.forJavaName(str);
        }
        return forJavaName;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "javaName", imports = {}))
    @JvmName(name = "-deprecated_javaName")
    @NotNull
    /* renamed from: -deprecated_javaName  reason: not valid java name */
    public final String m568deprecated_javaName() {
        return this.javaName;
    }

    @JvmName(name = "javaName")
    @NotNull
    public final String javaName() {
        return this.javaName;
    }

    @NotNull
    public String toString() {
        return this.javaName;
    }

    public /* synthetic */ CipherSuite(String str, j jVar) {
        this(str);
    }
}
