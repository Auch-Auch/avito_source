package okhttp3.internal.http2;

import a2.b.a.a.a;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b-\u0010.J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0016\u0010\u0019\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0016\u0010\u001a\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012R\u0016\u0010\u001c\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u0016\u0010\u001d\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u0012R\u001e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\"\u0010\u0012R\u0016\u0010#\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b#\u0010\u0012R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010%\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b%\u0010\u0012R\u0016\u0010&\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b&\u0010\u0012R\u0016\u0010'\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b'\u0010\u0012R\u0016\u0010(\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b(\u0010\u0012R\u0016\u0010)\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b)\u0010\u0012R\u0016\u0010*\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b*\u0010\u0012R\u0016\u0010+\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b+\u0010\u0012R\u0016\u0010,\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b,\u0010\u0012¨\u0006/"}, d2 = {"Lokhttp3/internal/http2/Http2;", "", "", "inbound", "", "streamId", "length", "type", "flags", "", "frameLog", "(ZIIII)Ljava/lang/String;", "formattedType$okhttp", "(I)Ljava/lang/String;", "formattedType", "formatFlags", "(II)Ljava/lang/String;", "TYPE_SETTINGS", "I", "TYPE_PRIORITY", "TYPE_RST_STREAM", "Lokio/ByteString;", "CONNECTION_PREFACE", "Lokio/ByteString;", "INITIAL_MAX_FRAME_SIZE", "TYPE_CONTINUATION", "FLAG_PADDED", "FLAG_ACK", "FLAG_END_STREAM", "FLAG_PRIORITY", "", "FLAGS", "[Ljava/lang/String;", "FRAME_NAMES", "TYPE_HEADERS", "FLAG_COMPRESSED", "BINARY", "TYPE_PING", "TYPE_WINDOW_UPDATE", "TYPE_PUSH_PROMISE", "TYPE_GOAWAY", "TYPE_DATA", "FLAG_END_HEADERS", "FLAG_NONE", "FLAG_END_PUSH_PROMISE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http2 {
    private static final String[] BINARY;
    @JvmField
    @NotNull
    public static final ByteString CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] FLAGS = new String[64];
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final Http2 INSTANCE = new Http2();
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            Intrinsics.checkNotNullExpressionValue(binaryString, "Integer.toBinaryString(it)");
            strArr[i] = m.replace$default(Util.format("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i2 = 0; i2 < 1; i2++) {
            int i3 = iArr[i2];
            String[] strArr3 = FLAGS;
            strArr3[i3 | 8] = Intrinsics.stringPlus(strArr3[i3], "|PADDED");
        }
        String[] strArr4 = FLAGS;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr2[i4];
            for (int i6 = 0; i6 < 1; i6++) {
                int i7 = iArr[i6];
                String[] strArr5 = FLAGS;
                int i8 = i7 | i5;
                strArr5[i8] = strArr5[i7] + "|" + strArr5[i5];
                StringBuilder sb = new StringBuilder();
                sb.append(strArr5[i7]);
                sb.append("|");
                strArr5[i8 | 8] = a.t(sb, strArr5[i5], "|PADDED");
            }
        }
        int length = FLAGS.length;
        for (int i9 = 0; i9 < length; i9++) {
            String[] strArr6 = FLAGS;
            if (strArr6[i9] == null) {
                strArr6[i9] = BINARY[i9];
            }
        }
    }

    private Http2() {
    }

    @NotNull
    public final String formatFlags(int i, int i2) {
        String str;
        if (i2 == 0) {
            return "";
        }
        if (!(i == 2 || i == 3)) {
            if (i == 4 || i == 6) {
                if (i2 == 1) {
                    return "ACK";
                }
                return BINARY[i2];
            } else if (!(i == 7 || i == 8)) {
                String[] strArr = FLAGS;
                if (i2 < strArr.length) {
                    str = strArr[i2];
                    Intrinsics.checkNotNull(str);
                } else {
                    str = BINARY[i2];
                }
                if (i != 5 || (i2 & 4) == 0) {
                    return (i != 0 || (i2 & 32) == 0) ? str : m.replace$default(str, "PRIORITY", "COMPRESSED", false, 4, (Object) null);
                }
                return m.replace$default(str, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
            }
        }
        return BINARY[i2];
    }

    @NotNull
    public final String formattedType$okhttp(int i) {
        String[] strArr = FRAME_NAMES;
        return i < strArr.length ? strArr[i] : Util.format("0x%02x", Integer.valueOf(i));
    }

    @NotNull
    public final String frameLog(boolean z, int i, int i2, int i3, int i4) {
        return Util.format("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), formattedType$okhttp(i3), formatFlags(i3, i4));
    }
}
