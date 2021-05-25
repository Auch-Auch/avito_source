package org.spongycastle.util.encoders;

import a2.b.a.a.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class UrlBase64 {
    public static final Encoder a = new UrlBase64Encoder();

    public static byte[] decode(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a.decode(bArr, 0, bArr.length, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new DecoderException(a.F2(e, a.L("exception decoding URL safe base64 string: ")), e);
        }
    }

    public static byte[] encode(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a.encode(bArr, 0, bArr.length, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new EncoderException(a.F2(e, a.L("exception encoding URL safe base64 data: ")), e);
        }
    }

    public static int decode(byte[] bArr, OutputStream outputStream) throws IOException {
        return a.decode(bArr, 0, bArr.length, outputStream);
    }

    public static int encode(byte[] bArr, OutputStream outputStream) throws IOException {
        return a.encode(bArr, 0, bArr.length, outputStream);
    }

    public static byte[] decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a.decode(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new DecoderException(a.F2(e, a.L("exception decoding URL safe base64 string: ")), e);
        }
    }

    public static int decode(String str, OutputStream outputStream) throws IOException {
        return a.decode(str, outputStream);
    }
}
