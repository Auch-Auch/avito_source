package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Base64;
import com.adjust.sdk.Constants;
import com.yandex.metrica.impl.ob.vf;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
public final class ax {
    public static String a(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        StringWriter stringWriter = new StringWriter();
        a(inputStreamReader, stringWriter);
        return stringWriter.toString();
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(a(str.getBytes("UTF-8")), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public static String c(String str) {
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        String str2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str, 0));
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    str2 = a(gZIPInputStream);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                gZIPInputStream = null;
            }
        } catch (Throwable unused3) {
            gZIPInputStream = null;
            byteArrayInputStream = null;
        }
        dl.a((Closeable) gZIPInputStream);
        dl.a((Closeable) byteArrayInputStream);
        return str2;
    }

    public static byte[] b(byte[] bArr) throws IOException {
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] b = b(gZIPInputStream);
                    dl.a((Closeable) gZIPInputStream);
                    dl.a((Closeable) byteArrayInputStream);
                    return b;
                } catch (Throwable th2) {
                    th = th2;
                    dl.a((Closeable) gZIPInputStream);
                    dl.a((Closeable) byteArrayInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                gZIPInputStream = null;
                dl.a((Closeable) gZIPInputStream);
                dl.a((Closeable) byteArrayInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            gZIPInputStream = null;
            dl.a((Closeable) gZIPInputStream);
            dl.a((Closeable) byteArrayInputStream);
            throw th;
        }
    }

    public static String a(String str) throws IOException {
        Throwable th;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                String a = a(fileInputStream2);
                dl.a((Closeable) fileInputStream2);
                return a;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                dl.a((Closeable) fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            dl.a((Closeable) fileInputStream);
            throw th;
        }
    }

    @RequiresApi(api = 21)
    private static void c(@NonNull Context context, @NonNull String str) {
        try {
            File file = new File(context.getNoBackupFilesDir(), str);
            if (file.exists() && file.canWrite()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    public static int a(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[4096];
        int i = 0;
        while (true) {
            int read = reader.read(cArr, 0, 4096);
            if (-1 == read) {
                return i;
            }
            writer.write(cArr, 0, read);
            i += read;
        }
    }

    public static byte[] b(@Nullable InputStream inputStream) throws IOException {
        return a(inputStream, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] bArr) throws IOException {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    dl.a((Closeable) gZIPOutputStream2);
                    dl.a((Closeable) byteArrayOutputStream);
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream = gZIPOutputStream2;
                    dl.a((Closeable) gZIPOutputStream);
                    dl.a((Closeable) byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                dl.a((Closeable) gZIPOutputStream);
                dl.a((Closeable) byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            dl.a((Closeable) gZIPOutputStream);
            dl.a((Closeable) byteArrayOutputStream);
            throw th;
        }
    }

    @Nullable
    public static byte[] b(Context context, File file) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        Throwable th;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                fileLock = channel.lock(0, Long.MAX_VALUE, true);
                try {
                    ByteBuffer allocate = ByteBuffer.allocate((int) file.length());
                    channel.read(allocate);
                    allocate.flip();
                    byte[] array = allocate.array();
                    a(file.getAbsolutePath(), fileLock);
                    dl.a((Closeable) randomAccessFile);
                    return array;
                } catch (IOException | SecurityException unused) {
                    a(file.getAbsolutePath(), fileLock);
                    dl.a((Closeable) randomAccessFile);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        xa.a().reportError("error_during_file_reading", th);
                        a(file.getAbsolutePath(), fileLock);
                        dl.a((Closeable) randomAccessFile);
                        return null;
                    } catch (Throwable th3) {
                        a(file.getAbsolutePath(), fileLock);
                        dl.a((Closeable) randomAccessFile);
                        throw th3;
                    }
                }
            } catch (IOException | SecurityException unused2) {
                fileLock = null;
                a(file.getAbsolutePath(), fileLock);
                dl.a((Closeable) randomAccessFile);
                return null;
            } catch (Throwable th4) {
                th = th4;
                fileLock = null;
                xa.a().reportError("error_during_file_reading", th);
                a(file.getAbsolutePath(), fileLock);
                dl.a((Closeable) randomAccessFile);
                return null;
            }
        } catch (IOException | SecurityException unused3) {
            randomAccessFile = null;
            fileLock = null;
            a(file.getAbsolutePath(), fileLock);
            dl.a((Closeable) randomAccessFile);
            return null;
        } catch (Throwable th5) {
            th = th5;
            randomAccessFile = null;
            fileLock = null;
            xa.a().reportError("error_during_file_reading", th);
            a(file.getAbsolutePath(), fileLock);
            dl.a((Closeable) randomAccessFile);
            return null;
        }
    }

    @SuppressLint({"SetWorldReadable"})
    @TargetApi(9)
    public static void c(Context context, File file) {
        if (file.exists()) {
            file.setReadable(true, false);
            if (b()) {
                new File(context.getApplicationInfo().dataDir).setExecutable(true, false);
                return;
            }
            return;
        }
        xa.a().reportEvent("make_non_existed_world_readable", new HashMap<String, Object>(file, context) { // from class: com.yandex.metrica.impl.ob.ax.1
            public final /* synthetic */ File a;
            public final /* synthetic */ Context b;

            {
                this.a = r2;
                this.b = r3;
                put("file_name", r2.getName());
                put("applicationId", r3.getPackageName());
            }
        });
    }

    public static byte[] c(@NonNull byte[] bArr) {
        try {
            return MessageDigest.getInstance(Constants.MD5).digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return new byte[0];
        }
    }

    public static byte[] a(@Nullable InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    break;
                } else if (i2 > i) {
                    break;
                } else if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                    i2 += read;
                }
            } finally {
                dl.a((Closeable) byteArrayOutputStream);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static void b(@NonNull Context context, @NonNull String str) {
        try {
            File file = new File(context.getFileStreamPath(str).getAbsolutePath());
            if (file.exists() && file.canWrite()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public static String a(Context context, File file) {
        byte[] b = b(context, file);
        try {
            return new String(b, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            String str = new String(b);
            xa.a().reportError("read_share_file_with_unsupported_encoding", e);
            return str;
        }
    }

    @TargetApi(21)
    public static void b(Context context, String str, String str2) {
        File file = new File(context.getNoBackupFilesDir(), str);
        try {
            a(str2, str, new FileOutputStream(file));
            c(context, file);
        } catch (FileNotFoundException unused) {
        }
    }

    public static void a(String str, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException unused) {
            }
        }
    }

    @SuppressLint({"WorldReadableFiles"})
    public static void a(Context context, String str, String str2) {
        try {
            if (b()) {
                a(str2, str, context.openFileOutput(str, 0));
                c(context, context.getFileStreamPath(str));
                return;
            }
            a(str2, str, context.openFileOutput(str, 1));
        } catch (FileNotFoundException unused) {
        }
    }

    private static boolean b() {
        return dl.a(24);
    }

    @SuppressLint({"WorldReadableFiles"})
    public static void a(@NonNull Context context, @NonNull String str) {
        if (b()) {
            c(context, str);
        }
        b(context, str);
    }

    private static void a(String str, String str2, FileOutputStream fileOutputStream) {
        FileLock fileLock = null;
        try {
            FileChannel channel = fileOutputStream.getChannel();
            fileLock = channel.lock();
            byte[] bytes = str.getBytes("UTF-8");
            ByteBuffer allocate = ByteBuffer.allocate(bytes.length);
            allocate.put(bytes);
            allocate.flip();
            channel.write(allocate);
            channel.force(true);
        } catch (IOException unused) {
        } catch (Throwable th) {
            a(str2, fileLock);
            dl.a((Closeable) fileOutputStream);
            throw th;
        }
        a(str2, fileLock);
        dl.a((Closeable) fileOutputStream);
    }

    public static void a(@NonNull HttpURLConnection httpURLConnection, vf.a.b bVar, @NonNull String str, int i) {
        try {
            bVar.a(a(httpURLConnection.getInputStream(), i));
        } catch (IOException unused) {
        }
        try {
            bVar.b(a(httpURLConnection.getErrorStream(), i));
        } catch (IOException unused2) {
        }
    }

    public static boolean a() {
        return dl.a(21);
    }
}
