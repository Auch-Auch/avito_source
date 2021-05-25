package l6.l.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.documentfile.provider.DocumentFile;
import java.util.ArrayList;
@RequiresApi(21)
public class c extends DocumentFile {
    public Context b;
    public Uri c;

    public c(@Nullable DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.b = context;
        this.c = uri;
    }

    public static void a(@Nullable AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
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
    @Nullable
    public DocumentFile createDirectory(String str) {
        Uri uri;
        try {
            uri = DocumentsContract.createDocument(this.b.getContentResolver(), this.c, "vnd.android.document/directory", str);
        } catch (Exception unused) {
            uri = null;
        }
        if (uri != null) {
            return new c(this, this.b, uri);
        }
        return null;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public DocumentFile createFile(String str, String str2) {
        Uri uri;
        try {
            uri = DocumentsContract.createDocument(this.b.getContentResolver(), this.c, str, str2);
        } catch (Exception unused) {
            uri = null;
        }
        if (uri != null) {
            return new c(this, this.b, uri);
        }
        return null;
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
        ContentResolver contentResolver = this.b.getContentResolver();
        Uri uri = this.c;
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
            while (cursor.moveToNext()) {
                arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.c, cursor.getString(0)));
            }
        } catch (Exception e) {
            String str = "Failed query: " + e;
        } catch (Throwable th) {
            a(null);
            throw th;
        }
        a(cursor);
        Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
        DocumentFile[] documentFileArr = new DocumentFile[uriArr.length];
        for (int i = 0; i < uriArr.length; i++) {
            documentFileArr[i] = new c(this, this.b, uriArr[i]);
        }
        return documentFileArr;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String str) {
        try {
            Uri renameDocument = DocumentsContract.renameDocument(this.b.getContentResolver(), this.c, str);
            if (renameDocument != null) {
                this.c = renameDocument;
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
