package com.facebook.imageutils;

import android.util.Pair;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
public class WebpUtil {
    public static boolean a(byte[] bArr, String str) {
        if (bArr.length != str.length()) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (str.charAt(i) != bArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static int b(InputStream inputStream) throws IOException {
        return ((((byte) inputStream.read()) << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) | ((((byte) inputStream.read()) << Ascii.DLE) & 16711680) | ((((byte) inputStream.read()) << 8) & 65280) | (((byte) inputStream.read()) & 255);
    }

    @Nullable
    public static Pair<Integer, Integer> c(InputStream inputStream) throws IOException {
        inputStream.skip(7);
        short read = (short) (inputStream.read() & 255);
        short read2 = (short) (inputStream.read() & 255);
        short read3 = (short) (inputStream.read() & 255);
        if (read == 157 && read2 == 1 && read3 == 42) {
            return new Pair<>(Integer.valueOf(get2BytesAsInt(inputStream)), Integer.valueOf(get2BytesAsInt(inputStream)));
        }
        return null;
    }

    @Nullable
    public static Pair<Integer, Integer> d(InputStream inputStream) throws IOException {
        b(inputStream);
        if (((byte) (inputStream.read() & 255)) != 47) {
            return null;
        }
        int read = ((byte) inputStream.read()) & 255;
        return new Pair<>(Integer.valueOf(((((byte) inputStream.read()) & 255) | ((read & 63) << 8)) + 1), Integer.valueOf(((((((byte) inputStream.read()) & 255) & 15) << 10) | ((((byte) inputStream.read()) & 255) << 2) | ((read & 192) >> 6)) + 1));
    }

    public static int e(InputStream inputStream) throws IOException {
        return ((((byte) (inputStream.read() & 255)) << Ascii.DLE) & 16711680) | ((((byte) (inputStream.read() & 255)) << 8) & 65280) | (((byte) (inputStream.read() & 255)) & 255);
    }

    public static int get2BytesAsInt(InputStream inputStream) throws IOException {
        return ((((byte) inputStream.read()) << 8) & 65280) | (((byte) inputStream.read()) & 255);
    }

    @Nullable
    public static Pair<Integer, Integer> getSize(InputStream inputStream) {
        byte[] bArr = new byte[4];
        try {
            inputStream.read(bArr);
            if (!a(bArr, "RIFF")) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            b(inputStream);
            inputStream.read(bArr);
            if (!a(bArr, "WEBP")) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return null;
            }
            inputStream.read(bArr);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append((char) bArr[i]);
            }
            String sb2 = sb.toString();
            if ("VP8 ".equals(sb2)) {
                Pair<Integer, Integer> c = c(inputStream);
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return c;
            } else if ("VP8L".equals(sb2)) {
                Pair<Integer, Integer> d = d(inputStream);
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return d;
            } else if ("VP8X".equals(sb2)) {
                inputStream.skip(8);
                Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(e(inputStream) + 1), Integer.valueOf(e(inputStream) + 1));
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return pair;
            } else {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                return null;
            }
        } catch (IOException e7) {
            e7.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            throw th;
        }
    }
}
