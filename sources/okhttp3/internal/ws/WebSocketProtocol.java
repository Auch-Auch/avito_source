package okhttp3.internal.ws;

import a2.b.a.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00158\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u000b8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0016\u0010\u001b\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0016\u0010\u001c\u001a\u00020\u00158\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013R\u0016\u0010\u001f\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u0013R\u0016\u0010 \u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b \u0010\u0013R\u0016\u0010!\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b!\u0010\u0013R\u0016\u0010\"\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\"\u0010\u0013R\u0016\u0010#\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b#\u0010\u0013R\u0016\u0010$\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b$\u0010\u0013R\u0016\u0010%\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b%\u0010\u0013R\u0016\u0010&\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b&\u0010\u0013R\u0016\u0010'\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b'\u0010\u0013R\u0016\u0010(\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b(\u0010\u0013R\u0016\u0010)\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b)\u0010\u0013R\u0016\u0010*\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b*\u0010\u0013R\u0016\u0010+\u001a\u00020\u00158\u0000@\u0000XT¢\u0006\u0006\n\u0004\b+\u0010\u0017¨\u0006."}, d2 = {"Lokhttp3/internal/ws/WebSocketProtocol;", "", "Lokio/Buffer$UnsafeCursor;", "cursor", "", "key", "", "toggleMask", "(Lokio/Buffer$UnsafeCursor;[B)V", "", "code", "", "closeCodeExceptionMessage", "(I)Ljava/lang/String;", "validateCloseCode", "(I)V", "acceptHeader", "(Ljava/lang/String;)Ljava/lang/String;", "B0_FLAG_RSV3", "I", "OPCODE_BINARY", "", "PAYLOAD_SHORT_MAX", "J", "ACCEPT_MAGIC", "Ljava/lang/String;", "B0_FLAG_FIN", "B1_MASK_LENGTH", "PAYLOAD_BYTE_MAX", "CLOSE_CLIENT_GOING_AWAY", "OPCODE_CONTINUATION", "PAYLOAD_SHORT", "PAYLOAD_LONG", "B0_FLAG_RSV1", "B0_FLAG_RSV2", "B0_MASK_OPCODE", "OPCODE_TEXT", "OPCODE_FLAG_CONTROL", "OPCODE_CONTROL_CLOSE", "OPCODE_CONTROL_PONG", "CLOSE_NO_STATUS_CODE", "OPCODE_CONTROL_PING", "B1_FLAG_MASK", "CLOSE_MESSAGE_MAX", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class WebSocketProtocol {
    @NotNull
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    @NotNull
    public final String acceptHeader(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        ByteString.Companion companion = ByteString.Companion;
        return companion.encodeUtf8(str + ACCEPT_MAGIC).sha1().base64();
    }

    @Nullable
    public final String closeCodeExceptionMessage(int i) {
        if (i < 1000 || i >= 5000) {
            return a.M2("Code must be in range [1000,5000): ", i);
        }
        if ((1004 > i || 1006 < i) && (1015 > i || 2999 < i)) {
            return null;
        }
        return a.Q2("Code ", i, " is reserved and may not be used.");
    }

    public final void toggleMask(@NotNull Buffer.UnsafeCursor unsafeCursor, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "cursor");
        Intrinsics.checkNotNullParameter(bArr, "key");
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = unsafeCursor.data;
            int i2 = unsafeCursor.start;
            int i3 = unsafeCursor.end;
            if (bArr2 != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
        } while (unsafeCursor.next() != -1);
    }

    public final void validateCloseCode(int i) {
        String closeCodeExceptionMessage = closeCodeExceptionMessage(i);
        if (!(closeCodeExceptionMessage == null)) {
            Intrinsics.checkNotNull(closeCodeExceptionMessage);
            throw new IllegalArgumentException(closeCodeExceptionMessage.toString());
        }
    }
}
