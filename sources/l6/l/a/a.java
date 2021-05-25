package l6.l.a;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
public class a extends DocumentFile {
    public File b;

    public a(@Nullable DocumentFile documentFile, File file) {
        super(documentFile);
        this.b = file;
    }

    public static boolean a(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= a(file2);
                }
                if (!file2.delete()) {
                    String str = "Failed to delete " + file2;
                    z = false;
                }
            }
        }
        return z;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canRead() {
        return this.b.canRead();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canWrite() {
        return this.b.canWrite();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public DocumentFile createDirectory(String str) {
        File file = new File(this.b, str);
        if (file.isDirectory() || file.mkdir()) {
            return new a(this, file);
        }
        return null;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public DocumentFile createFile(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = a2.b.a.a.a.e3(str2, ".", extensionFromMimeType);
        }
        File file = new File(this.b, str2);
        try {
            file.createNewFile();
            return new a(this, file);
        } catch (IOException e) {
            String str3 = "Failed to createFile: " + e;
            return null;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean delete() {
        a(this.b);
        return this.b.delete();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean exists() {
        return this.b.exists();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public String getName() {
        return this.b.getName();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public String getType() {
        String mimeTypeFromExtension;
        if (this.b.isDirectory()) {
            return null;
        }
        String name = this.b.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return (lastIndexOf < 0 || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(lastIndexOf + 1).toLowerCase())) == null) ? StringExtensionsKt.APPLICATION_OCTET_STREAM : mimeTypeFromExtension;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public Uri getUri() {
        return Uri.fromFile(this.b);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isDirectory() {
        return this.b.isDirectory();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isFile() {
        return this.b.isFile();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isVirtual() {
        return false;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long lastModified() {
        return this.b.lastModified();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long length() {
        return this.b.length();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile[] listFiles() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.b.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                arrayList.add(new a(this, file));
            }
        }
        return (DocumentFile[]) arrayList.toArray(new DocumentFile[arrayList.size()]);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String str) {
        File file = new File(this.b.getParentFile(), str);
        if (!this.b.renameTo(file)) {
            return false;
        }
        this.b = file;
        return true;
    }
}
