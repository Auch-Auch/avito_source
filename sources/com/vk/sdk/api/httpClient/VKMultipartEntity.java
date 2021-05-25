package com.vk.sdk.api.httpClient;

import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.vk.sdk.api.model.VKAttachments;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Random;
public class VKMultipartEntity {
    public final String a = String.format(Locale.US, "Boundary(======VK_SDK_%d======)", Integer.valueOf(new Random().nextInt()));
    public final File[] b;
    public String c;

    public VKMultipartEntity(File[] fileArr) {
        this.b = fileArr;
    }

    public static String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public long getContentLength() {
        long j = 0;
        int i = 0;
        while (true) {
            File[] fileArr = this.b;
            if (i >= fileArr.length) {
                return j + ((long) String.format("\r\n--%s--\r\n", this.a).length());
            }
            File file = fileArr[i];
            j = ((long) getFileDescription(file, i).length()) + file.length() + j;
            i++;
        }
    }

    public Pair<String, String> getContentType() {
        return new Pair<>("Content-Type", String.format("multipart/form-data; boundary=%s", this.a));
    }

    public String getFileDescription(File file, int i) {
        String str;
        String str2 = this.c;
        if (str2 == null || !str2.equals(VKAttachments.TYPE_DOC)) {
            str = String.format(Locale.US, "file%d", Integer.valueOf(i + 1));
        } else {
            str = "file";
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(file.getAbsolutePath());
        return String.format("\r\n--%s\r\n", this.a) + String.format("Content-Disposition: form-data; name=\"%s\"; filename=\"%s.%s\"\r\n", str, str, fileExtensionFromUrl) + String.format("Content-Type: %s\r\n\r\n", getMimeType(file.getAbsolutePath()));
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        int i = 0;
        while (true) {
            File[] fileArr = this.b;
            if (i < fileArr.length) {
                File file = fileArr[i];
                outputStream.write(getFileDescription(file, i).getBytes("UTF-8"));
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                i++;
            } else {
                outputStream.write(String.format("\r\n--%s--\r\n", this.a).getBytes("UTF-8"));
                return;
            }
        }
    }

    public VKMultipartEntity(File[] fileArr, String str) {
        this.b = fileArr;
        this.c = str;
    }
}
