package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class SharedSQLiteStatement {
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final RoomDatabase b;
    public volatile SupportSQLiteStatement c;

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        this.b = roomDatabase;
    }

    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        if (this.a.compareAndSet(false, true)) {
            if (this.c == null) {
                this.c = this.b.compileStatement(createQuery());
            }
            return this.c;
        }
        return this.b.compileStatement(createQuery());
    }

    public void assertNotMainThread() {
        this.b.assertNotMainThread();
    }

    public abstract String createQuery();

    public void release(SupportSQLiteStatement supportSQLiteStatement) {
        if (supportSQLiteStatement == this.c) {
            this.a.set(false);
        }
    }
}
