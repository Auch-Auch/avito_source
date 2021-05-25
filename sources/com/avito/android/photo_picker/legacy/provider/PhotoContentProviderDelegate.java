package com.avito.android.photo_picker.legacy.provider;

import a2.b.a.a.a;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.avito.android.db.photo.PhotoContract;
import com.avito.android.photo_picker.legacy.provider.PhotoContentProvider;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ContentProviderDelegate;
import com.avito.android.util.Logs;
import com.avito.android.util.Uris;
import com.facebook.share.internal.ShareConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010&\u001a\u00020$\u0012\u0006\u0010-\u001a\u00020+\u0012\u0006\u0010*\u001a\u00020'¢\u0006\u0004\b.\u0010/J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ;\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012JM\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001b\u001a\u00020\u001a*\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010,¨\u00060"}, d2 = {"Lcom/avito/android/photo_picker/legacy/provider/PhotoContentProviderDelegate;", "Lcom/avito/android/util/ContentProviderDelegate;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "getType", "(Landroid/net/Uri;)Ljava/lang/String;", "Landroid/content/ContentValues;", ResidentialComplexModuleKt.VALUES, "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "selection", "", "selectionArgs", "", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", PhoneActionStrings.REMOVE, "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "projection", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", AuthSource.SEND_ABUSE, "(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;", "", AuthSource.BOOKING_ORDER, "(Landroid/net/Uri;)Z", "Landroid/database/sqlite/SQLiteDatabase;", "kotlin.jvm.PlatformType", "c", "()Landroid/database/sqlite/SQLiteDatabase;", "Landroid/content/UriMatcher;", "Landroid/content/UriMatcher;", "uriMatcher", "Landroid/database/sqlite/SQLiteOpenHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "dbHelper", "Landroid/content/ContentResolver;", "d", "Landroid/content/ContentResolver;", "contentResolver", "Lcom/avito/android/util/BuildInfo;", "Lcom/avito/android/util/BuildInfo;", "build", "<init>", "(Landroid/database/sqlite/SQLiteOpenHelper;Lcom/avito/android/util/BuildInfo;Landroid/content/ContentResolver;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoContentProviderDelegate implements ContentProviderDelegate {
    public final UriMatcher a;
    public final SQLiteOpenHelper b;
    public final BuildInfo c;
    public final ContentResolver d;

    public PhotoContentProviderDelegate(@NotNull SQLiteOpenHelper sQLiteOpenHelper, @NotNull BuildInfo buildInfo, @NotNull ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(sQLiteOpenHelper, "dbHelper");
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.b = sQLiteOpenHelper;
        this.c = buildInfo;
        this.d = contentResolver;
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.a = uriMatcher;
        PhotoContentProvider.Companion companion = PhotoContentProvider.Companion;
        uriMatcher.addURI(companion.getAuthority(buildInfo.getApplicationPackageId()), null, 0);
        uriMatcher.addURI(companion.getAuthority(buildInfo.getApplicationPackageId()), "#", 1);
    }

    public final String a(Uri uri, String str) {
        boolean z = true;
        if (this.a.match(uri) != 1) {
            return str;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (str != null && !m.isBlank(str)) {
            z = false;
        }
        if (z) {
            return PhotoContract.ID + '=' + lastPathSegment;
        }
        StringBuilder I = a.I('(');
        I.append(PhotoContract.ID);
        I.append('=');
        I.append(lastPathSegment);
        I.append(") AND (");
        return a.s(I, str, ')');
    }

    public final boolean b(Uri uri) {
        int match = this.a.match(uri);
        return (match == 0 || match == 1) ? false : true;
    }

    public final SQLiteDatabase c() {
        return this.b.getWritableDatabase();
    }

    @Override // com.avito.android.util.ContentProviderDelegate
    public int delete(@NotNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        if (this.c.isDebug()) {
            Logs.debug$default("PhotoContentProviderDelegate", "delete uri=" + uri + " selection=" + str + " selectionArgs=" + Arrays.toString(strArr), null, 4, null);
        }
        if (b(uri)) {
            return 0;
        }
        int delete = c().delete(PhotoContract.TABLE_NAME, a(uri, str), strArr);
        if (delete > 0) {
            this.d.notifyChange(uri, null);
        }
        return delete;
    }

    @Override // com.avito.android.util.ContentProviderDelegate
    @Nullable
    public String getType(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        int match = this.a.match(uri);
        if (match == 0) {
            StringBuilder L = a.L("vnd.android.cursor.dir/");
            L.append(PhotoContract.TABLE_NAME);
            return L.toString();
        } else if (match != 1) {
            return null;
        } else {
            StringBuilder L2 = a.L("vnd.android.cursor.item/");
            L2.append(PhotoContract.TABLE_NAME);
            return L2.toString();
        }
    }

    @Override // com.avito.android.util.ContentProviderDelegate
    @Nullable
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        if (this.c.isDebug()) {
            Logs.debug$default("PhotoContentProviderDelegate", "insert uri=" + uri + " values=" + contentValues, null, 4, null);
        }
        if (contentValues == null || b(uri)) {
            return null;
        }
        long insertWithOnConflict = c().insertWithOnConflict(PhotoContract.TABLE_NAME, null, contentValues, 5);
        if (insertWithOnConflict > 0) {
            Uri withAppendedId = Uris.withAppendedId(uri, insertWithOnConflict);
            this.d.notifyChange(withAppendedId, null);
            return withAppendedId;
        }
        return null;
    }

    @Override // com.avito.android.util.ContentProviderDelegate
    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        if (this.c.isDebug()) {
            StringBuilder sb = new StringBuilder();
            sb.append("query uri=");
            sb.append(uri);
            sb.append(" selection=");
            sb.append(str);
            sb.append(" selectionArgs=");
            Logs.debug$default("PhotoContentProviderDelegate", a.u(sb, Arrays.toString(strArr2), " sortOrder=", str2), null, 4, null);
        }
        if (b(uri)) {
            return null;
        }
        return this.b.getReadableDatabase().query(PhotoContract.TABLE_NAME, strArr, str, strArr2, str2, null, null);
    }

    @Override // com.avito.android.util.ContentProviderDelegate
    public int update(@NotNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        if (this.c.isDebug()) {
            Logs.debug$default("PhotoContentProviderDelegate", "update uri=" + uri + " values=" + contentValues + " selection=" + str + " selectionArgs=" + Arrays.toString(strArr), null, 4, null);
        }
        if (contentValues == null || b(uri)) {
            return 0;
        }
        int update = c().update(PhotoContract.TABLE_NAME, contentValues, a(uri, str), strArr);
        if (update > 0) {
            this.d.notifyChange(uri, null);
        }
        return update;
    }
}
