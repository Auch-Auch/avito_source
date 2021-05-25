package a2.a.a.o1.d.a0.b;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandlerImpl;
import com.avito.android.messenger.conversation.mvi.data.MessengerDbException;
import com.avito.android.messenger.util.DbMaintenance;
import com.avito.android.util.LogsT;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import t6.n.r;
public final class a<V> implements Callable<Boolean> {
    public final /* synthetic */ DatabaseErrorHandlerImpl a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Map d;

    public a(DatabaseErrorHandlerImpl databaseErrorHandlerImpl, Throwable th, String str, Map map) {
        this.a = databaseErrorHandlerImpl;
        this.b = th;
        this.c = str;
        this.d = map;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Boolean call() {
        boolean access$isSQLiteDatabaseCorruptException$p = DatabaseErrorHandlerImpl.access$isSQLiteDatabaseCorruptException$p(this.a, this.b);
        StringBuilder L = a2.b.a.a.a.L("Handling error for method = ");
        L.append(this.c);
        L.append(", isCorrupt = ");
        L.append(access$isSQLiteDatabaseCorruptException$p);
        LogsT.verbose("DatabaseErrorHandler", L.toString(), this.b);
        SupportSQLiteOpenHelper openHelper = this.a.c.getOpenHelper();
        Intrinsics.checkNotNullExpressionValue(openHelper, "database.openHelper");
        String databaseName = openHelper.getDatabaseName();
        if (databaseName != null) {
            Context context = this.a.b;
            Intrinsics.checkNotNullExpressionValue(databaseName, "it");
            DbMaintenance dbMaintenance = new DbMaintenance(context, databaseName);
            Map<String, Object> metaData = dbMaintenance.getMetaData(dbMaintenance.getDbIsCorrupt());
            if (dbMaintenance.getFileExists()) {
                ErrorTracker.DefaultImpls.track$default(this.a.a, new MessengerDbException(dbMaintenance.getDbFileDeleted(), "Failed to perform DB query", this.b), null, r.plus(r.plus(r.mapOf(TuplesKt.to("method", this.c), TuplesKt.to("database.isOpen", Boolean.valueOf(this.a.c.isOpen()))), this.d), metaData), 2, null);
            }
            if (!dbMaintenance.getDbFileDeleted()) {
                return Boolean.TRUE;
            }
            throw this.b;
        }
        throw this.b;
    }
}
