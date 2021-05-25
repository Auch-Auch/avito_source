package okio.internal;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.Platform;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0006\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u0007\u0010\b\u001a\u0014\u0010\t\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\t\u0010\b\u001a$\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\n*\u00020\u0000H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0014\u0010\u0016\u001a\u00020\u0015*\u00020\u0000H\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0015*\u00020\u0000H\b¢\u0006\u0004\b\u0018\u0010\u0017\u001a4\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a4\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\b¢\u0006\u0004\b\u001e\u0010 \u001a\u001c\u0010\"\u001a\u00020\u001d*\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\b¢\u0006\u0004\b\"\u0010#\u001a\u001c\u0010\"\u001a\u00020\u001d*\u00020\u00002\u0006\u0010!\u001a\u00020\u0015H\b¢\u0006\u0004\b\"\u0010$\u001a\u001c\u0010&\u001a\u00020\u001d*\u00020\u00002\u0006\u0010%\u001a\u00020\u0000H\b¢\u0006\u0004\b&\u0010#\u001a\u001c\u0010&\u001a\u00020\u001d*\u00020\u00002\u0006\u0010%\u001a\u00020\u0015H\b¢\u0006\u0004\b&\u0010$\u001a$\u0010(\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\nH\b¢\u0006\u0004\b(\u0010)\u001a$\u0010*\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\nH\b¢\u0006\u0004\b*\u0010+\u001a$\u0010*\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\nH\b¢\u0006\u0004\b*\u0010)\u001a\u001e\u0010-\u001a\u00020\u001d*\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010,H\b¢\u0006\u0004\b-\u0010.\u001a\u0014\u0010/\u001a\u00020\n*\u00020\u0000H\b¢\u0006\u0004\b/\u0010\u0014\u001a\u001c\u00100\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0000H\b¢\u0006\u0004\b0\u00101\u001a\u0018\u00103\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0015H\b¢\u0006\u0004\b3\u00104\u001a$\u00105\u001a\u00020\u0000*\u00020\u00152\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\b¢\u0006\u0004\b5\u00106\u001a\u0014\u00107\u001a\u00020\u0000*\u00020\u0001H\b¢\u0006\u0004\b7\u00108\u001a\u0016\u00109\u001a\u0004\u0018\u00010\u0000*\u00020\u0001H\b¢\u0006\u0004\b9\u00108\u001a\u0014\u0010:\u001a\u00020\u0000*\u00020\u0001H\b¢\u0006\u0004\b:\u00108\u001a+\u0010>\u001a\u00020=*\u00020\u00002\u0006\u0010<\u001a\u00020;2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0000¢\u0006\u0004\b>\u0010?\u001a\u0014\u0010@\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b@\u0010\u0003\"\u001c\u0010F\u001a\u00020A8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lokio/ByteString;", "", "commonUtf8", "(Lokio/ByteString;)Ljava/lang/String;", "commonBase64", "commonBase64Url", "commonHex", "commonToAsciiLowercase", "(Lokio/ByteString;)Lokio/ByteString;", "commonToAsciiUppercase", "", "beginIndex", "endIndex", "commonSubstring", "(Lokio/ByteString;II)Lokio/ByteString;", "pos", "", "commonGetByte", "(Lokio/ByteString;I)B", "commonGetSize", "(Lokio/ByteString;)I", "", "commonToByteArray", "(Lokio/ByteString;)[B", "commonInternalArray", "offset", "other", "otherOffset", DecodeProducer.EXTRA_BITMAP_BYTES, "", "commonRangeEquals", "(Lokio/ByteString;ILokio/ByteString;II)Z", "(Lokio/ByteString;I[BII)Z", "prefix", "commonStartsWith", "(Lokio/ByteString;Lokio/ByteString;)Z", "(Lokio/ByteString;[B)Z", "suffix", "commonEndsWith", "fromIndex", "commonIndexOf", "(Lokio/ByteString;[BI)I", "commonLastIndexOf", "(Lokio/ByteString;Lokio/ByteString;I)I", "", "commonEquals", "(Lokio/ByteString;Ljava/lang/Object;)Z", "commonHashCode", "commonCompareTo", "(Lokio/ByteString;Lokio/ByteString;)I", "data", "commonOf", "([B)Lokio/ByteString;", "commonToByteString", "([BII)Lokio/ByteString;", "commonEncodeUtf8", "(Ljava/lang/String;)Lokio/ByteString;", "commonDecodeBase64", "commonDecodeHex", "Lokio/Buffer;", "buffer", "", "commonWrite", "(Lokio/ByteString;Lokio/Buffer;II)V", "commonToString", "", AuthSource.SEND_ABUSE, "[C", "getHEX_DIGIT_CHARS", "()[C", "HEX_DIGIT_CHARS", "okio"}, k = 2, mv = {1, 4, 0})
public final class ByteStringKt {
    @NotNull
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int access$codePointIndexToCharIndex(byte[] bArr, int i) {
        int i2;
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        loop0:
        while (i3 < length) {
            byte b = bArr[i3];
            int i6 = 2;
            if (b >= 0) {
                int i7 = i5 + 1;
                if (i5 == i) {
                    return i4;
                }
                if (!(b == 10 || b == 13)) {
                    if ((b >= 0 && 31 >= b) || (Byte.MAX_VALUE <= b && 159 >= b)) {
                    }
                }
                if (b != 65533) {
                    i4 += b < 65536 ? 1 : 2;
                    i3++;
                    while (true) {
                        i5 = i7;
                        if (i3 >= length || bArr[i3] < 0) {
                            break;
                        }
                        int i8 = i3 + 1;
                        byte b2 = bArr[i3];
                        i7 = i5 + 1;
                        if (i5 == i) {
                            return i4;
                        }
                        if (!(b2 == 10 || b2 == 13)) {
                            if ((b2 >= 0 && 31 >= b2) || (Byte.MAX_VALUE <= b2 && 159 >= b2)) {
                                break loop0;
                            }
                        }
                        if (b2 == 65533) {
                            break loop0;
                        }
                        i4 += b2 < 65536 ? 1 : 2;
                        i3 = i8;
                    }
                }
            } else {
                if ((b >> 5) == -2) {
                    int i9 = i3 + 1;
                    if (length > i9) {
                        byte b3 = bArr[i3];
                        byte b4 = bArr[i9];
                        if ((b4 & 192) == 128) {
                            int i10 = (b4 ^ 3968) ^ (b3 << 6);
                            if (i10 >= 128) {
                                i2 = i5 + 1;
                                if (i5 == i) {
                                    return i4;
                                }
                                if (!(i10 == 10 || i10 == 13)) {
                                    if ((i10 >= 0 && 31 >= i10) || (127 <= i10 && 159 >= i10)) {
                                    }
                                }
                                if (i10 != 65533) {
                                    if (i10 < 65536) {
                                        i6 = 1;
                                    }
                                    i4 += i6;
                                    Unit unit = Unit.INSTANCE;
                                    i3 += 2;
                                }
                            } else if (i5 == i) {
                                return i4;
                            }
                        } else if (i5 == i) {
                            return i4;
                        }
                    } else if (i5 == i) {
                        return i4;
                    }
                } else if ((b >> 4) == -2) {
                    int i11 = i3 + 2;
                    if (length > i11) {
                        byte b5 = bArr[i3];
                        byte b6 = bArr[i3 + 1];
                        if ((b6 & 192) == 128) {
                            byte b8 = bArr[i11];
                            if ((b8 & 192) == 128) {
                                int i12 = ((b8 ^ -123008) ^ (b6 << 6)) ^ (b5 << Ascii.FF);
                                if (i12 < 2048) {
                                    if (i5 == i) {
                                        return i4;
                                    }
                                } else if (55296 > i12 || 57343 < i12) {
                                    i2 = i5 + 1;
                                    if (i5 == i) {
                                        return i4;
                                    }
                                    if (!(i12 == 10 || i12 == 13)) {
                                        if ((i12 >= 0 && 31 >= i12) || (127 <= i12 && 159 >= i12)) {
                                        }
                                    }
                                    if (i12 != 65533) {
                                        if (i12 < 65536) {
                                            i6 = 1;
                                        }
                                        i4 += i6;
                                        Unit unit2 = Unit.INSTANCE;
                                        i3 += 3;
                                    }
                                } else if (i5 == i) {
                                    return i4;
                                }
                            } else if (i5 == i) {
                                return i4;
                            }
                        } else if (i5 == i) {
                            return i4;
                        }
                    } else if (i5 == i) {
                        return i4;
                    }
                } else if ((b >> 3) == -2) {
                    int i13 = i3 + 3;
                    if (length > i13) {
                        byte b9 = bArr[i3];
                        byte b10 = bArr[i3 + 1];
                        if ((b10 & 192) == 128) {
                            byte b11 = bArr[i3 + 2];
                            if ((b11 & 192) == 128) {
                                byte b12 = bArr[i13];
                                if ((b12 & 192) == 128) {
                                    int i14 = (((b12 ^ 3678080) ^ (b11 << 6)) ^ (b10 << Ascii.FF)) ^ (b9 << Ascii.DC2);
                                    if (i14 > 1114111) {
                                        if (i5 == i) {
                                            return i4;
                                        }
                                    } else if (55296 <= i14 && 57343 >= i14) {
                                        if (i5 == i) {
                                            return i4;
                                        }
                                    } else if (i14 >= 65536) {
                                        i2 = i5 + 1;
                                        if (i5 == i) {
                                            return i4;
                                        }
                                        if (!(i14 == 10 || i14 == 13)) {
                                            if ((i14 >= 0 && 31 >= i14) || (127 <= i14 && 159 >= i14)) {
                                            }
                                        }
                                        if (i14 != 65533) {
                                            if (i14 < 65536) {
                                                i6 = 1;
                                            }
                                            i4 += i6;
                                            Unit unit3 = Unit.INSTANCE;
                                            i3 += 4;
                                        }
                                    } else if (i5 == i) {
                                        return i4;
                                    }
                                } else if (i5 == i) {
                                    return i4;
                                }
                            } else if (i5 == i) {
                                return i4;
                            }
                        } else if (i5 == i) {
                            return i4;
                        }
                    } else if (i5 == i) {
                        return i4;
                    }
                } else if (i5 == i) {
                    return i4;
                }
                i5 = i2;
            }
            return -1;
        }
        return i4;
    }

    public static final int access$decodeHexDigit(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        char c2 = 'a';
        if ('a' > c || 'f' < c) {
            c2 = 'A';
            if ('A' > c || 'F' < c) {
                throw new IllegalArgumentException(a.K2("Unexpected hex digit: ", c));
            }
        }
        return (c - c2) + 10;
    }

    @NotNull
    public static final String commonBase64(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonBase64");
        return Base64.encodeBase64$default(byteString.getData$okio(), null, 1, null);
    }

    @NotNull
    public static final String commonBase64Url(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonBase64Url");
        return Base64.encodeBase64(byteString.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@NotNull ByteString byteString, @NotNull ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonCompareTo");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        int size = byteString.size();
        int size2 = byteString2.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            int i2 = byteString.getByte(i) & 255;
            int i3 = byteString2.getByte(i) & 255;
            if (i2 != i3) {
                if (i2 < i3) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size < size2) {
            return -1;
        }
        return 1;
    }

    @Nullable
    public static final ByteString commonDecodeBase64(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$commonDecodeBase64");
        byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    @NotNull
    public static final ByteString commonDecodeHex(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$commonDecodeHex");
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (access$decodeHexDigit(str.charAt(i2 + 1)) + (access$decodeHexDigit(str.charAt(i2)) << 4));
            }
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException(a.c3("Unexpected hex string: ", str).toString());
    }

    @NotNull
    public static final ByteString commonEncodeUtf8(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$commonEncodeUtf8");
        ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(@NotNull ByteString byteString, @NotNull ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonEndsWith");
        Intrinsics.checkNotNullParameter(byteString2, "suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean commonEquals(@NotNull ByteString byteString, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonEquals");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            if (byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@NotNull ByteString byteString, int i) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonGetByte");
        return byteString.getData$okio()[i];
    }

    public static final int commonGetSize(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonGetSize");
        return byteString.getData$okio().length;
    }

    public static final int commonHashCode(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonHashCode");
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }

    @NotNull
    public static final String commonHex(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonHex");
        char[] cArr = new char[(byteString.getData$okio().length * 2)];
        byte[] data$okio = byteString.getData$okio();
        int i = 0;
        for (byte b : data$okio) {
            int i2 = i + 1;
            cArr[i] = getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = getHEX_DIGIT_CHARS()[b & Ascii.SI];
        }
        return new String(cArr);
    }

    public static final int commonIndexOf(@NotNull ByteString byteString, @NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonIndexOf");
        Intrinsics.checkNotNullParameter(bArr, "other");
        int length = byteString.getData$okio().length - bArr.length;
        int max = Math.max(i, 0);
        if (max > length) {
            return -1;
        }
        while (!Util.arrayRangeEquals(byteString.getData$okio(), max, bArr, 0, bArr.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    @NotNull
    public static final byte[] commonInternalArray(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonInternalArray");
        return byteString.getData$okio();
    }

    public static final int commonLastIndexOf(@NotNull ByteString byteString, @NotNull ByteString byteString2, int i) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonLastIndexOf");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        return byteString.lastIndexOf(byteString2.internalArray$okio(), i);
    }

    @NotNull
    public static final ByteString commonOf(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(@NotNull ByteString byteString, int i, @NotNull ByteString byteString2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonRangeEquals");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        return byteString2.rangeEquals(i2, byteString.getData$okio(), i, i3);
    }

    public static final boolean commonStartsWith(@NotNull ByteString byteString, @NotNull ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonStartsWith");
        Intrinsics.checkNotNullParameter(byteString2, "prefix");
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonSubstring");
        boolean z = true;
        if (i >= 0) {
            if (i2 <= byteString.getData$okio().length) {
                if (i2 - i < 0) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                } else if (i == 0 && i2 == byteString.getData$okio().length) {
                    return byteString;
                } else {
                    return new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(byteString.getData$okio(), i, i2));
                }
            } else {
                throw new IllegalArgumentException(a.i(a.L("endIndex > length("), byteString.getData$okio().length, ')').toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
    }

    @NotNull
    public static final ByteString commonToAsciiLowercase(@NotNull ByteString byteString) {
        byte b;
        Intrinsics.checkNotNullParameter(byteString, "$this$commonToAsciiLowercase");
        for (int i = 0; i < byteString.getData$okio().length; i++) {
            byte b2 = byteString.getData$okio()[i];
            byte b3 = (byte) 65;
            if (b2 >= b3 && b2 <= (b = (byte) 90)) {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final ByteString commonToAsciiUppercase(@NotNull ByteString byteString) {
        byte b;
        Intrinsics.checkNotNullParameter(byteString, "$this$commonToAsciiUppercase");
        for (int i = 0; i < byteString.getData$okio().length; i++) {
            byte b2 = byteString.getData$okio()[i];
            byte b3 = (byte) 97;
            if (b2 >= b3 && b2 <= (b = (byte) 122)) {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b2 - 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonToByteArray");
        byte[] data$okio = byteString.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public static final ByteString commonToByteString(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$commonToByteString");
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        return new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(bArr, i, i2 + i));
    }

    @NotNull
    public static final String commonToString(@NotNull ByteString byteString) {
        ByteString byteString2 = byteString;
        Intrinsics.checkNotNullParameter(byteString2, "$this$commonToString");
        boolean z = true;
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int access$codePointIndexToCharIndex = access$codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (access$codePointIndexToCharIndex != -1) {
            String utf8 = byteString.utf8();
            Objects.requireNonNull(utf8, "null cannot be cast to non-null type java.lang.String");
            String substring = utf8.substring(0, access$codePointIndexToCharIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String replace$default = m.replace$default(m.replace$default(m.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            if (access$codePointIndexToCharIndex >= utf8.length()) {
                return a.d3("[text=", replace$default, ']');
            }
            StringBuilder L = a.L("[size=");
            L.append(byteString.getData$okio().length);
            L.append(" text=");
            L.append(replace$default);
            L.append("…]");
            return L.toString();
        } else if (byteString.getData$okio().length <= 64) {
            StringBuilder L2 = a.L("[hex=");
            L2.append(byteString.hex());
            L2.append(']');
            return L2.toString();
        } else {
            StringBuilder L3 = a.L("[size=");
            L3.append(byteString.getData$okio().length);
            L3.append(" hex=");
            if (64 > byteString.getData$okio().length) {
                z = false;
            }
            if (z) {
                if (64 != byteString.getData$okio().length) {
                    byteString2 = new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(byteString.getData$okio(), 0, 64));
                }
                L3.append(byteString2.hex());
                L3.append("…]");
                return L3.toString();
            }
            throw new IllegalArgumentException(a.i(a.L("endIndex > length("), byteString.getData$okio().length, ')').toString());
        }
    }

    @NotNull
    public static final String commonUtf8(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonUtf8");
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = Platform.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(@NotNull ByteString byteString, @NotNull Buffer buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.write(byteString.getData$okio(), i, i2);
    }

    @NotNull
    public static final char[] getHEX_DIGIT_CHARS() {
        return a;
    }

    public static final boolean commonEndsWith(@NotNull ByteString byteString, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonEndsWith");
        Intrinsics.checkNotNullParameter(bArr, "suffix");
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }

    public static final int commonLastIndexOf(@NotNull ByteString byteString, @NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonLastIndexOf");
        Intrinsics.checkNotNullParameter(bArr, "other");
        for (int min = Math.min(i, byteString.getData$okio().length - bArr.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(byteString.getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(@NotNull ByteString byteString, int i, @NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonRangeEquals");
        Intrinsics.checkNotNullParameter(bArr, "other");
        return i >= 0 && i <= byteString.getData$okio().length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && Util.arrayRangeEquals(byteString.getData$okio(), i, bArr, i2, i3);
    }

    public static final boolean commonStartsWith(@NotNull ByteString byteString, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(byteString, "$this$commonStartsWith");
        Intrinsics.checkNotNullParameter(bArr, "prefix");
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }
}
