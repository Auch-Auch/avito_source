package androidx.core.util;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class AtomicFile {
    public final File a;
    public final File b;

    public AtomicFile(@NonNull File file) {
        this.a = file;
        this.b = new File(file.getPath() + ".bak");
    }

    public void delete() {
        this.a.delete();
        this.b.delete();
    }

    public void failWrite(@Nullable FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException unused) {
            }
            try {
                fileOutputStream.close();
                this.a.delete();
                this.b.renameTo(this.a);
            } catch (IOException unused2) {
            }
        }
    }

    public void finishWrite(@Nullable FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException unused) {
            }
            try {
                fileOutputStream.close();
                this.b.delete();
            } catch (IOException unused2) {
            }
        }
    }

    @NonNull
    public File getBaseFile() {
        return this.a;
    }

    @NonNull
    public FileInputStream openRead() throws FileNotFoundException {
        if (this.b.exists()) {
            this.a.delete();
            this.b.renameTo(this.a);
        }
        return new FileInputStream(this.a);
    }

    @NonNull
    public byte[] readFully() throws IOException {
        FileInputStream openRead = openRead();
        try {
            byte[] bArr = new byte[openRead.available()];
            int i = 0;
            while (true) {
                int read = openRead.read(bArr, i, bArr.length - i);
                if (read <= 0) {
                    return bArr;
                }
                i += read;
                int available = openRead.available();
                if (available > bArr.length - i) {
                    byte[] bArr2 = new byte[(available + i)];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    bArr = bArr2;
                }
            }
        } finally {
            openRead.close();
        }
    }

    @NonNull
    public FileOutputStream startWrite() throws IOException {
        if (this.a.exists()) {
            if (this.b.exists()) {
                this.a.delete();
            } else if (!this.a.renameTo(this.b)) {
                StringBuilder L = a.L("Couldn't rename file ");
                L.append(this.a);
                L.append(" to backup file ");
                L.append(this.b);
                L.toString();
            }
        }
        try {
            return new FileOutputStream(this.a);
        } catch (FileNotFoundException unused) {
            if (this.a.getParentFile().mkdirs()) {
                try {
                    return new FileOutputStream(this.a);
                } catch (FileNotFoundException unused2) {
                    StringBuilder L2 = a.L("Couldn't create ");
                    L2.append(this.a);
                    throw new IOException(L2.toString());
                }
            } else {
                StringBuilder L3 = a.L("Couldn't create directory ");
                L3.append(this.a);
                throw new IOException(L3.toString());
            }
        }
    }
}
