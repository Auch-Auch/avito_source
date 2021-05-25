package com.avito.android.db.photo;

import a2.b.a.a.a;
import android.provider.BaseColumns;
import com.avito.android.photo_picker.PhotoPickerActivityKt;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/db/photo/PhotoContract;", "Landroid/provider/BaseColumns;", "", "createSql", "()Ljava/lang/String;", "<init>", "()V", "Companion", "core_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoContract implements BaseColumns {
    @JvmField
    @NotNull
    public static final String CONTENT_URI = "content_uri";
    @JvmField
    @NotNull
    public static final String CREATED = "created";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final String ERROR_CODE = "error_code";
    @JvmField
    @NotNull
    public static final String ID = "_id";
    @JvmField
    @NotNull
    public static final String OPERATION_ID = PhotoPickerActivityKt.EXTRA_OPERATION_ID;
    @JvmField
    @NotNull
    public static final String POSITION = VKApiConst.POSITION;
    @JvmField
    @NotNull
    public static final String SOURCE_URI = "source_uri";
    @JvmField
    @NotNull
    public static final String TABLE_NAME = "photos";
    @JvmField
    @NotNull
    public static final String TYPE_ID = "type_id";
    @JvmField
    @NotNull
    public static final String UPLOAD_ID = "upload_id";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\r\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/avito/android/db/photo/PhotoContract$Companion;", "", "", "CONTENT_URI", "Ljava/lang/String;", DebugCoroutineInfoImplKt.CREATED, "ERROR_CODE", "ID", "OPERATION_ID", "POSITION", "SOURCE_URI", "TABLE_NAME", "TYPE_ID", "UPLOAD_ID", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public final String createSql() {
        StringBuilder L = a.L("\n                CREATE TABLE IF NOT EXISTS ");
        L.append(TABLE_NAME);
        L.append("(\n                    ");
        L.append(ID);
        L.append("  INTEGER PRIMARY KEY AUTOINCREMENT,\n                    ");
        L.append(TYPE_ID);
        L.append(" TEXT NOT NULL,\n                    ");
        String str = OPERATION_ID;
        L.append(str);
        L.append(" TEXT NOT NULL,\n                    ");
        L.append(POSITION);
        L.append(" INTEGER NOT NULL DEFAULT 0,\n                    ");
        L.append(CREATED);
        L.append(" INTEGER NOT NULL DEFAULT 0,\n                    ");
        String str2 = UPLOAD_ID;
        L.append(str2);
        L.append(" TEXT,\n                    ");
        L.append(CONTENT_URI);
        L.append(" TEXT,\n                    ");
        L.append(ERROR_CODE);
        L.append(" INTEGER NOT NULL DEFAULT 0,\n                    ");
        a.n1(L, SOURCE_URI, " TEXT,\n                    CONSTRAINT unique_photo_per_operation UNIQUE(", str, ", ");
        return a.t(L, str2, ") ON CONFLICT REPLACE\n                );\n                ");
    }
}
