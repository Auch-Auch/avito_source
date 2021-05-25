package a2.j.b.e.a.b;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.model.category_parameters.DateTimeParameterKt;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.cd;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
public final class a2 {
    public static final aa h = new aa("SliceMetadataManager");
    public final byte[] a = new byte[8192];
    public final a0 b;
    public final String c;
    public final int d;
    public final long e;
    public final String f;
    public int g;

    public a2(a0 a0Var, String str, int i, long j, String str2) {
        this.b = a0Var;
        this.c = str;
        this.d = i;
        this.e = j;
        this.f = str2;
        this.g = 0;
    }

    public final z1 a() throws IOException {
        File k = this.b.k(this.c, this.d, this.e, this.f);
        if (k.exists()) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(k);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                    throw new q0("Slice checkpoint file corrupt.");
                }
                try {
                    int parseInt = Integer.parseInt(properties.getProperty("fileStatus"));
                    String property = properties.getProperty("fileName");
                    long parseLong = Long.parseLong(properties.getProperty("fileOffset", DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME));
                    long parseLong2 = Long.parseLong(properties.getProperty("remainingBytes", DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME));
                    int parseInt2 = Integer.parseInt(properties.getProperty("previousChunk"));
                    this.g = Integer.parseInt(properties.getProperty("metadataFileCounter", "0"));
                    return new h0(parseInt, property, parseLong, parseLong2, parseInt2);
                } catch (NumberFormatException e2) {
                    throw new q0("Slice checkpoint file corrupt.", e2);
                }
            } catch (Throwable th) {
                cd.a(th, th);
            }
        } else {
            throw new q0("Slice checkpoint file does not exist.");
        }
        throw th;
    }

    public final void b(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", ExifInterface.GPS_MEASUREMENT_3D);
        properties.put("fileOffset", String.valueOf(g().length()));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream fileOutputStream = new FileOutputStream(l());
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    public final void c(String str, long j, long j2, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put("fileName", str);
        properties.put("fileOffset", String.valueOf(j));
        properties.put("remainingBytes", String.valueOf(j2));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream fileOutputStream = new FileOutputStream(l());
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    public final void d(byte[] bArr) throws IOException {
        File k = k();
        int i = this.g;
        this.g = i + 1;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(k, String.format("%s-LFH.dat", Integer.valueOf(i))));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                return;
            } catch (Throwable th) {
                cd.a(th, th);
            }
            throw th;
        } catch (IOException e2) {
            throw new q0("Could not write metadata file.", e2);
        }
    }

    public final void e(byte[] bArr, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", ExifInterface.GPS_MEASUREMENT_2D);
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream fileOutputStream = new FileOutputStream(l());
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
        a0 a0Var = this.b;
        String str = this.c;
        int i2 = this.d;
        long j = this.e;
        String str2 = this.f;
        Objects.requireNonNull(a0Var);
        File file = new File(a0Var.s(str, i2, j, str2), "checkpoint_ext.dat");
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
        fileOutputStream2.write(bArr);
        fileOutputStream2.close();
    }

    public final void f(byte[] bArr, InputStream inputStream) throws IOException {
        File k = k();
        int i = this.g;
        this.g = i + 1;
        FileOutputStream fileOutputStream = new FileOutputStream(new File(k, String.format("%s-NAM.dat", Integer.valueOf(i))));
        fileOutputStream.write(bArr);
        int read = inputStream.read(this.a);
        while (read > 0) {
            fileOutputStream.write(this.a, 0, read);
            read = inputStream.read(this.a);
        }
        fileOutputStream.close();
    }

    public final File g() {
        return new File(k(), String.format("%s-NAM.dat", Integer.valueOf(this.g - 1)));
    }

    public final void h(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "4");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream fileOutputStream = new FileOutputStream(l());
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    public final int i() throws IOException {
        File k = this.b.k(this.c, this.d, this.e, this.f);
        if (!k.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(k);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        if (Integer.parseInt(properties.getProperty("fileStatus", DateTimeParameterKt.DATE_TIME_PARAMETER_PRESENT_TIME)) == 4) {
            return -1;
        }
        if (properties.getProperty("previousChunk") != null) {
            return Integer.parseInt(properties.getProperty("previousChunk")) + 1;
        }
        throw new q0("Slice checkpoint file corrupt.");
    }

    public final boolean j() {
        File k = this.b.k(this.c, this.d, this.e, this.f);
        if (k.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(k);
                Properties properties = new Properties();
                properties.load(fileInputStream);
                if (properties.getProperty("fileStatus") != null) {
                    return Integer.parseInt(properties.getProperty("fileStatus")) == 4;
                }
                h.b("Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
                return false;
            } catch (IOException e2) {
                h.b("Could not read checkpoint while checking if extraction finished. %s", e2);
            }
        }
        return false;
    }

    public final File k() {
        File s = this.b.s(this.c, this.d, this.e, this.f);
        if (!s.exists()) {
            s.mkdirs();
        }
        return s;
    }

    public final File l() throws IOException {
        File k = this.b.k(this.c, this.d, this.e, this.f);
        k.getParentFile().mkdirs();
        k.createNewFile();
        return k;
    }
}
