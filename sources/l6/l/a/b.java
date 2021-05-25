package l6.l.a;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.documentfile.provider.DocumentFile;
@RequiresApi(19)
public class b extends DocumentFile {
    public Context b;
    public Uri c;

    public b(@Nullable DocumentFile documentFile, Context context, Uri uri) {
        super(null);
        this.b = context;
        this.c = uri;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canRead() {
        return AppCompatDelegateImpl.i.q(this.b, this.c);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canWrite() {
        return AppCompatDelegateImpl.i.r(this.b, this.c);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createDirectory(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createFile(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean delete() {
        try {
            return DocumentsContract.deleteDocument(this.b.getContentResolver(), this.c);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean exists() {
        return AppCompatDelegateImpl.i.l0(this.b, this.c);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public String getName() {
        return AppCompatDelegateImpl.i.G1(this.b, this.c, "_display_name", null);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public String getType() {
        String G1 = AppCompatDelegateImpl.i.G1(this.b, this.c, "mime_type", null);
        if ("vnd.android.document/directory".equals(G1)) {
            return null;
        }
        return G1;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public Uri getUri() {
        return this.c;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isDirectory() {
        return "vnd.android.document/directory".equals(AppCompatDelegateImpl.i.G1(this.b, this.c, "mime_type", null));
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isFile() {
        return AppCompatDelegateImpl.i.X0(this.b, this.c);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isVirtual() {
        return AppCompatDelegateImpl.i.a1(this.b, this.c);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long lastModified() {
        return AppCompatDelegateImpl.i.F1(this.b, this.c, "last_modified", 0);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long length() {
        return AppCompatDelegateImpl.i.F1(this.b, this.c, "_size", 0);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile[] listFiles() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String str) {
        throw new UnsupportedOperationException();
    }
}
