package l6.w;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
public class e implements SupportSQLiteOpenHelper.Factory {
    @Nullable
    public final String a;
    @Nullable
    public final File b;
    @NonNull
    public final SupportSQLiteOpenHelper.Factory c;

    public e(@Nullable String str, @Nullable File file, @NonNull SupportSQLiteOpenHelper.Factory factory) {
        this.a = str;
        this.b = file;
        this.c = factory;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new d(configuration.context, this.a, this.b, configuration.callback.version, this.c.create(configuration));
    }
}
