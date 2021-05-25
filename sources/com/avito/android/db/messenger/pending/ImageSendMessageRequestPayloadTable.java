package com.avito.android.db.messenger.pending;

import a2.b.a.a.a;
import com.avito.android.db.photo.PhotoContract;
import com.avito.android.photo_picker.PhotoPickerActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\u0004R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0017\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u001a\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/db/messenger/pending/ImageSendMessageRequestPayloadTable;", "", "", "createSql", "()Ljava/lang/String;", "selectByRequestId", "selectByPhotoId", "d", "Ljava/lang/String;", "getREQUEST_ID", "REQUEST_ID", "e", "getOPERATION_ID", "OPERATION_ID", "Lcom/avito/android/db/messenger/pending/SendMessageRequestTable;", AuthSource.SEND_ABUSE, "Lcom/avito/android/db/messenger/pending/SendMessageRequestTable;", "requestsTable", "c", "getID", "ID", "f", "getPHOTO_ID", "PHOTO_ID", AuthSource.BOOKING_ORDER, "getTABLE", "TABLE", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class ImageSendMessageRequestPayloadTable {
    public final SendMessageRequestTable a = new SendMessageRequestTable();
    @NotNull
    public final String b = "image_send_request_payloads";
    @NotNull
    public final String c = "_id";
    @NotNull
    public final String d = SDKAnalyticsEvents.PARAMETER_REQUEST_ID;
    @NotNull
    public final String e = PhotoPickerActivityKt.EXTRA_OPERATION_ID;
    @NotNull
    public final String f = "photo_id";

    @NotNull
    public final String createSql() {
        StringBuilder L = a.L("CREATE TABLE IF NOT EXISTS ");
        L.append(this.b);
        L.append(" (");
        L.append(this.c);
        L.append(" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        L.append(this.d);
        L.append(" INTEGER UNIQUE NOT NULL, ");
        L.append(this.e);
        L.append(" TEXT NOT NULL, ");
        a.m1(L, this.f, " INTEGER NOT NULL, ", "FOREIGN KEY(");
        L.append(this.f);
        L.append(") REFERENCES ");
        L.append(PhotoContract.TABLE_NAME);
        L.append('(');
        a.m1(L, PhotoContract.ID, ") ON DELETE CASCADE ON UPDATE CASCADE, ", "FOREIGN KEY(");
        L.append(this.d);
        L.append(") REFERENCES ");
        L.append(this.a.getTABLE());
        L.append('(');
        L.append(this.a.getID());
        L.append(") ON DELETE CASCADE ON UPDATE CASCADE");
        L.append(")");
        return L.toString();
    }

    @NotNull
    public final String getID() {
        return this.c;
    }

    @NotNull
    public final String getOPERATION_ID() {
        return this.e;
    }

    @NotNull
    public final String getPHOTO_ID() {
        return this.f;
    }

    @NotNull
    public final String getREQUEST_ID() {
        return this.d;
    }

    @NotNull
    public final String getTABLE() {
        return this.b;
    }

    @NotNull
    public final String selectByPhotoId() {
        StringBuilder L = a.L("SELECT * FROM ");
        L.append(this.b);
        L.append(" WHERE ");
        return a.t(L, this.f, " = ?");
    }

    @NotNull
    public final String selectByRequestId() {
        StringBuilder L = a.L("SELECT * FROM ");
        L.append(this.b);
        L.append(" WHERE ");
        return a.t(L, this.d, " = ?");
    }
}
