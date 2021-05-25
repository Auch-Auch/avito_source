package l6.w;

import a2.b.a.a.a;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.room.DatabaseConfiguration;
import androidx.room.util.CopyLock;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
public class d implements SupportSQLiteOpenHelper {
    @NonNull
    public final Context a;
    @Nullable
    public final String b;
    @Nullable
    public final File c;
    public final int d;
    @NonNull
    public final SupportSQLiteOpenHelper e;
    @Nullable
    public DatabaseConfiguration f;
    public boolean g;

    public d(@NonNull Context context, @Nullable String str, @Nullable File file, int i, @NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        this.a = context;
        this.b = str;
        this.c = file;
        this.d = i;
        this.e = supportSQLiteOpenHelper;
    }

    public final void a(File file) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.b != null) {
            readableByteChannel = Channels.newChannel(this.a.getAssets().open(this.b));
        } else if (this.c != null) {
            readableByteChannel = new FileInputStream(this.c).getChannel();
        } else {
            throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
        }
        File createTempFile = File.createTempFile("room-copy-helper", DefaultDiskStorage.FileType.TEMP, this.a.getCacheDir());
        createTempFile.deleteOnExit();
        FileUtil.copy(readableByteChannel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            StringBuilder L = a.L("Failed to create directories for ");
            L.append(file.getAbsolutePath());
            throw new IOException(L.toString());
        } else if (!createTempFile.renameTo(file)) {
            StringBuilder L2 = a.L("Failed to move intermediate file (");
            L2.append(createTempFile.getAbsolutePath());
            L2.append(") to destination (");
            L2.append(file.getAbsolutePath());
            L2.append(").");
            throw new IOException(L2.toString());
        }
    }

    public final void b() {
        String databaseName = getDatabaseName();
        File databasePath = this.a.getDatabasePath(databaseName);
        DatabaseConfiguration databaseConfiguration = this.f;
        CopyLock copyLock = new CopyLock(databaseName, this.a.getFilesDir(), databaseConfiguration == null || databaseConfiguration.multiInstanceInvalidation);
        try {
            copyLock.lock();
            if (!databasePath.exists()) {
                try {
                    a(databasePath);
                } catch (IOException e2) {
                    throw new RuntimeException("Unable to copy database file.", e2);
                }
            } else if (this.f == null) {
                copyLock.unlock();
            } else {
                try {
                    int readVersion = DBUtil.readVersion(databasePath);
                    int i = this.d;
                    if (readVersion == i) {
                        copyLock.unlock();
                    } else if (this.f.isMigrationRequired(readVersion, i)) {
                        copyLock.unlock();
                    } else {
                        if (this.a.deleteDatabase(databaseName)) {
                            try {
                                a(databasePath);
                            } catch (IOException unused) {
                            }
                        }
                        copyLock.unlock();
                    }
                } catch (IOException unused2) {
                    copyLock.unlock();
                }
            }
        } finally {
            copyLock.unlock();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.e.close();
        this.g = false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.e.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase getReadableDatabase() {
        if (!this.g) {
            b();
            this.g = true;
        }
        return this.e.getReadableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase getWritableDatabase() {
        if (!this.g) {
            b();
            this.g = true;
        }
        return this.e.getWritableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.e.setWriteAheadLoggingEnabled(z);
    }
}
