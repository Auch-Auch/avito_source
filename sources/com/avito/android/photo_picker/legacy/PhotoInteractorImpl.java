package com.avito.android.photo_picker.legacy;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.db.SqlQuery;
import com.avito.android.db.photo.PhotoContentValues;
import com.avito.android.db.photo.PhotoContract;
import com.avito.android.db.photo.PhotoCursor;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.photo_picker.PhotoUploadImpl;
import com.avito.android.photo_picker.legacy.provider.PhotoContentProvider;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.CursorsKt;
import com.avito.android.util.Uris;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB+\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010:\u001a\u00020(\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010;¢\u0006\u0004\bA\u0010BJ\u001d\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\nJE\u0010\u0016\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0016¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b%\u0010&J8\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00022\u0019\u0010+\u001a\u0015\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010)0'¢\u0006\u0002\b*H\u0002¢\u0006\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006D"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoInteractorImpl;", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/CloseableDataSource;", "Lcom/avito/android/photo_picker/PhotoUpload;", "selectAll", "()Lio/reactivex/Observable;", "", "typeId", "selectUploadsOfType", "(Ljava/lang/String;)Lio/reactivex/Observable;", "operationId", "", "photoId", "select", "(Ljava/lang/String;J)Lio/reactivex/Observable;", "uploadId", "", VKApiConst.POSITION, "Landroid/net/Uri;", "contentUri", "sourceUri", ProductAction.ACTION_ADD, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/net/Uri;Landroid/net/Uri;)J", "photo", "", "update", "(Ljava/lang/String;Lcom/avito/android/photo_picker/PhotoUpload;)Z", "", "deleteAll", "(Ljava/lang/String;)V", PhoneActionStrings.REMOVE, "(Ljava/lang/String;)Z", "fromPosition", "toPosition", "move", "(II)Z", "updatePosition", "(Landroid/net/Uri;I)Z", "Lkotlin/Function1;", "Landroid/content/ContentResolver;", "Landroid/database/Cursor;", "Lkotlin/ExtensionFunctionType;", "queryAction", AuthSource.SEND_ABUSE, "(Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Landroid/net/Uri;", "baseUri", "Landroid/os/Handler;", "Landroid/os/Handler;", "contentObserverHandler", "Lcom/avito/android/util/BuildInfo;", "c", "Lcom/avito/android/util/BuildInfo;", "build", "d", "Landroid/content/ContentResolver;", "contentResolver", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "e", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "cVInteractor", "Landroid/os/Looper;", "looper", "<init>", "(Landroid/os/Looper;Lcom/avito/android/util/BuildInfo;Landroid/content/ContentResolver;Lcom/avito/android/computer_vision/ComputerVisionInteractor;)V", "PhotoDataSource", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoInteractorImpl implements PhotoInteractor {
    public final Handler a;
    public final Uri b;
    public final BuildInfo c;
    public final ContentResolver d;
    public ComputerVisionInteractor e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0004¢\u0006\u0004\b\u000e\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001d\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoInteractorImpl$PhotoDataSource;", "Lcom/avito/android/remote/model/CloseableDataSource;", "Lcom/avito/android/photo_picker/PhotoUpload;", "", "isEmpty", "()Z", "", VKApiConst.POSITION, "Lcom/avito/android/photo_picker/PhotoUploadImpl;", "getItem", "(I)Lcom/avito/android/photo_picker/PhotoUploadImpl;", "", "close", "()V", "finalize", "getCount", "()I", "count", "Lcom/avito/android/db/photo/PhotoCursor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/db/photo/PhotoCursor;", "getCursor", "()Lcom/avito/android/db/photo/PhotoCursor;", "cursor", "Lcom/avito/android/util/BuildInfo;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/BuildInfo;", "getBuild", "()Lcom/avito/android/util/BuildInfo;", "build", "<init>", "(Lcom/avito/android/util/BuildInfo;Lcom/avito/android/db/photo/PhotoCursor;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class PhotoDataSource implements CloseableDataSource<PhotoUpload> {
        @NotNull
        public final BuildInfo a;
        @NotNull
        public final PhotoCursor b;

        public PhotoDataSource(@NotNull BuildInfo buildInfo, @NotNull PhotoCursor photoCursor) {
            Intrinsics.checkNotNullParameter(buildInfo, "build");
            Intrinsics.checkNotNullParameter(photoCursor, "cursor");
            this.a = buildInfo;
            this.b = photoCursor;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.b.close();
        }

        @Override // java.lang.Object
        public final void finalize() {
            if (this.a.isDebug() && (!this.b.isClosed())) {
                throw new IllegalStateException("DataSource not closed");
            }
        }

        @NotNull
        public final BuildInfo getBuild() {
            return this.a;
        }

        @Override // com.avito.konveyor.data_source.DataSource
        public int getCount() {
            return this.b.getCount();
        }

        @NotNull
        public final PhotoCursor getCursor() {
            return this.b;
        }

        @Override // com.avito.konveyor.data_source.DataSource
        public boolean isEmpty() {
            return CursorsKt.isEmpty(this.b);
        }

        @Override // com.avito.konveyor.data_source.DataSource
        @NotNull
        public PhotoUploadImpl getItem(int i) {
            if (this.b.moveToPosition(i)) {
                String contentUri = this.b.getContentUri();
                boolean z = false;
                Uri uri = null;
                Uri parse = contentUri == null || contentUri.length() == 0 ? null : Uri.parse(contentUri);
                String sourceUri = this.b.getSourceUri();
                if (sourceUri == null || sourceUri.length() == 0) {
                    z = true;
                }
                if (!z) {
                    uri = Uri.parse(sourceUri);
                }
                return new PhotoUploadImpl(this.b.getId(), this.b.getTypeId(), this.b.getPhotoPosition(), this.b.getCreated(), this.b.getUploadId(), parse, this.b.getErrorCode(), uri);
            }
            StringBuilder M = a2.b.a.a.a.M("Unreachable position ", i, ". Count was ");
            M.append(this.b.getCount());
            throw new IndexOutOfBoundsException(M.toString());
        }
    }

    public static final class a<T, R> implements Function<SqlQuery, ObservableSource<? extends CloseableDataSource<? extends PhotoUpload>>> {
        public final /* synthetic */ PhotoInteractorImpl a;

        public a(PhotoInteractorImpl photoInteractorImpl) {
            this.a = photoInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends CloseableDataSource<? extends PhotoUpload>> apply(SqlQuery sqlQuery) {
            SqlQuery sqlQuery2 = sqlQuery;
            Intrinsics.checkNotNullParameter(sqlQuery2, "query");
            Cursor run = sqlQuery2.run();
            if (run != null) {
                Observable just = Observable.just(new PhotoDataSource(this.a.c, new PhotoCursor(run)));
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            }
            Observable error = Observable.error(new Throwable("Photos content resolver query returns null cursor"));
            Intrinsics.checkNotNullExpressionValue(error, "Observable.error(Throwab…ry returns null cursor\"))");
            return error;
        }
    }

    public static final class b extends Lambda implements Function1<ContentResolver, Cursor> {
        public final /* synthetic */ PhotoInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(PhotoInteractorImpl photoInteractorImpl, String str, long j) {
            super(1);
            this.a = photoInteractorImpl;
            this.b = str;
            this.c = j;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Cursor invoke(ContentResolver contentResolver) {
            Intrinsics.checkNotNullParameter(contentResolver, "$receiver");
            ContentResolver contentResolver2 = this.a.d;
            Uri uri = this.a.b;
            StringBuilder sb = new StringBuilder();
            sb.append(PhotoContract.OPERATION_ID);
            sb.append("=? AND ");
            return contentResolver2.query(uri, null, a2.b.a.a.a.t(sb, PhotoContract.ID, "=?"), new String[]{this.b, String.valueOf(this.c)}, null);
        }
    }

    public static final class c extends Lambda implements Function1<ContentResolver, Cursor> {
        public final /* synthetic */ PhotoInteractorImpl a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(PhotoInteractorImpl photoInteractorImpl, String str) {
            super(1);
            this.a = photoInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Cursor invoke(ContentResolver contentResolver) {
            Intrinsics.checkNotNullParameter(contentResolver, "$receiver");
            return this.a.d.query(this.a.b, null, a2.b.a.a.a.t(new StringBuilder(), PhotoContract.OPERATION_ID, "=?"), new String[]{this.b}, PhotoContract.POSITION);
        }
    }

    public static final class d extends Lambda implements Function1<ContentResolver, Cursor> {
        public final /* synthetic */ PhotoInteractorImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(PhotoInteractorImpl photoInteractorImpl) {
            super(1);
            this.a = photoInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Cursor invoke(ContentResolver contentResolver) {
            Intrinsics.checkNotNullParameter(contentResolver, "$receiver");
            return this.a.d.query(this.a.b, null, null, null, PhotoContract.ID);
        }
    }

    public static final class e extends Lambda implements Function1<ContentResolver, Cursor> {
        public final /* synthetic */ PhotoInteractorImpl a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(PhotoInteractorImpl photoInteractorImpl, String str) {
            super(1);
            this.a = photoInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Cursor invoke(ContentResolver contentResolver) {
            Intrinsics.checkNotNullParameter(contentResolver, "$receiver");
            return this.a.d.query(this.a.b, null, a2.b.a.a.a.t(new StringBuilder(), PhotoContract.TYPE_ID, "=?"), new String[]{this.b}, PhotoContract.ID);
        }
    }

    public PhotoInteractorImpl(@NotNull Looper looper, @NotNull BuildInfo buildInfo, @NotNull ContentResolver contentResolver, @Nullable ComputerVisionInteractor computerVisionInteractor) {
        Intrinsics.checkNotNullParameter(looper, "looper");
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.c = buildInfo;
        this.d = contentResolver;
        this.e = computerVisionInteractor;
        this.a = new Handler(looper);
        this.b = PhotoContentProvider.Companion.getBaseUri(buildInfo.getApplicationPackageId());
    }

    public final Observable<CloseableDataSource<? extends PhotoUpload>> a(Function1<? super ContentResolver, ? extends Cursor> function1) {
        Observable<CloseableDataSource<? extends PhotoUpload>> flatMap = new Observable<SqlQuery>() { // from class: com.avito.android.photo_picker.legacy.PhotoInteractorImpl$createObservableQuery$1
            @Override // io.reactivex.Observable
            public void subscribeActual(@NotNull Observer<? super SqlQuery> observer) {
                Intrinsics.checkNotNullParameter(observer, "observer");
                Observable.this.subscribe(observer);
            }
        }.flatMap(new a(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "createObservableQuery(ba…          }\n            }");
        return flatMap;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoInteractor
    public long add(@NotNull String str, @NotNull String str2, @Nullable String str3, int i, @Nullable Uri uri, @Nullable Uri uri2) {
        String lastPathSegment;
        Intrinsics.checkNotNullParameter(str, "typeId");
        Intrinsics.checkNotNullParameter(str2, "operationId");
        String str4 = null;
        PhotoContentValues photoContentValues = new PhotoContentValues(null, 1, null);
        photoContentValues.setOperationId(str2);
        photoContentValues.setUploadId(str3);
        photoContentValues.setTypeId(str);
        photoContentValues.setPosition(Integer.valueOf(i));
        photoContentValues.setCreated(Long.valueOf(System.currentTimeMillis()));
        photoContentValues.setContentUri(uri != null ? uri.toString() : null);
        if (uri2 != null) {
            str4 = uri2.toString();
        }
        photoContentValues.setSourceUri(str4);
        Uri insert = this.d.insert(this.b, photoContentValues.getValues());
        if (insert == null || (lastPathSegment = insert.getLastPathSegment()) == null) {
            return -1;
        }
        return Long.parseLong(lastPathSegment);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoInteractor
    public boolean delete(@NotNull String str) {
        Throwable th;
        Cursor query;
        boolean z;
        Throwable th2;
        Intrinsics.checkNotNullParameter(str, "photoId");
        ComputerVisionInteractor computerVisionInteractor = this.e;
        if (computerVisionInteractor != null) {
            computerVisionInteractor.removePhoto(str);
        }
        ContentResolver contentResolver = this.d;
        Uri uri = this.b;
        boolean z2 = true;
        String str2 = PhotoContract.POSITION;
        StringBuilder sb = new StringBuilder();
        String str3 = PhotoContract.ID;
        Cursor query2 = contentResolver.query(uri, new String[]{str2}, a2.b.a.a.a.t(sb, str3, "=?"), new String[]{str}, str2);
        if (query2 != null) {
            try {
                if (query2.moveToFirst()) {
                    int i = query2.getInt(query2.getColumnIndex(str2));
                    query = this.d.query(this.b, new String[]{str3, str2}, str2 + " > ?", new String[]{String.valueOf(i)}, str3);
                    if (query != null) {
                        while (query.moveToNext()) {
                            try {
                                long j = query.getLong(query.getColumnIndex(PhotoContract.ID));
                                int i2 = query.getInt(query.getColumnIndex(PhotoContract.POSITION));
                                Uri withAppendedId = Uris.withAppendedId(this.b, j);
                                PhotoContentValues photoContentValues = new PhotoContentValues(null, 1, null);
                                photoContentValues.setPosition(Integer.valueOf(i2 - 1));
                                this.d.update(withAppendedId, photoContentValues.getValues(), null, null);
                            } catch (Exception e2) {
                                try {
                                    query.close();
                                } catch (Exception unused) {
                                }
                                throw e2;
                            } catch (Throwable th3) {
                                th2 = th3;
                                z = true;
                            }
                        }
                        query.close();
                    }
                }
                query2.close();
            } catch (Exception e3) {
                try {
                    query2.close();
                } catch (Exception unused2) {
                }
                throw e3;
            } catch (Throwable th4) {
                th = th4;
            }
        }
        if (this.d.delete(Uris.withAppendedId(this.b, str, true), null, null) > 0) {
            return true;
        }
        return false;
        if (!z) {
            query.close();
        }
        throw th2;
        if (!z2) {
            query2.close();
        }
        throw th;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoInteractor
    public void deleteAll(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "typeId");
        this.d.delete(this.b, a2.b.a.a.a.t(new StringBuilder(), PhotoContract.TYPE_ID, "=?"), new String[]{str});
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoInteractor
    public boolean move(int i, int i2) {
        int i3;
        Throwable th;
        Cursor query;
        boolean z;
        Throwable th2;
        boolean z2 = false;
        boolean z3 = i2 > i;
        ContentResolver contentResolver = this.d;
        Uri uri = this.b;
        String str = PhotoContract.ID;
        StringBuilder sb = new StringBuilder();
        String str2 = PhotoContract.POSITION;
        Cursor query2 = contentResolver.query(uri, new String[]{str}, a2.b.a.a.a.t(sb, str2, "=?"), new String[]{String.valueOf(i)}, str2);
        if (query2 != null) {
            try {
                if (query2.moveToFirst()) {
                    long j = query2.getLong(query2.getColumnIndex(str));
                    Comparable min = ArraysKt___ArraysKt.min(new Integer[]{Integer.valueOf(i2), Integer.valueOf(i)});
                    Intrinsics.checkNotNull(min);
                    Comparable max = ArraysKt___ArraysKt.max(new Integer[]{Integer.valueOf(i2), Integer.valueOf(i)});
                    Intrinsics.checkNotNull(max);
                    query = this.d.query(this.b, new String[]{str, str2}, str2 + " >= ? AND " + str2 + " <= ? AND " + str + " != ?", new String[]{String.valueOf(((Number) min).intValue()), String.valueOf(((Number) max).intValue()), String.valueOf(j)}, str2);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                do {
                                    long j2 = query.getLong(query.getColumnIndex(PhotoContract.ID));
                                    int i4 = query.getInt(query.getColumnIndex(PhotoContract.POSITION));
                                    PhotoContentValues photoContentValues = new PhotoContentValues(null, 1, null);
                                    photoContentValues.setPosition(z3 ? Integer.valueOf(i4 - 1) : Integer.valueOf(i4 + 1));
                                    this.d.update(Uris.withAppendedId(this.b, j2), photoContentValues.getValues(), null, null);
                                } while (query.moveToNext());
                            }
                            query.close();
                        } catch (Exception e2) {
                            try {
                                query.close();
                            } catch (Exception unused) {
                            }
                            throw e2;
                        } catch (Throwable th3) {
                            th2 = th3;
                            z = true;
                        }
                    }
                    PhotoContentValues photoContentValues2 = new PhotoContentValues(null, 1, null);
                    photoContentValues2.setPosition(Integer.valueOf(i2));
                    i3 = this.d.update(Uris.withAppendedId(this.b, j), photoContentValues2.getValues(), null, null);
                    query2.close();
                } else {
                    throw new RuntimeException("Cannot update position as cursor is empty");
                }
            } catch (Exception e3) {
                try {
                    query2.close();
                } catch (Exception unused2) {
                }
                throw e3;
            } catch (Throwable th4) {
                th = th4;
                z2 = true;
            }
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            return true;
        }
        return false;
        if (!z) {
            query.close();
        }
        throw th2;
        if (!z2) {
            query2.close();
        }
        throw th;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoInteractor
    @NotNull
    public Observable<CloseableDataSource<? extends PhotoUpload>> select(@NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        return a(new b(this, str, j));
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoInteractor
    @NotNull
    public Observable<CloseableDataSource<? extends PhotoUpload>> selectAll() {
        return a(new d(this));
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoInteractor
    @NotNull
    public Observable<CloseableDataSource<? extends PhotoUpload>> selectUploadsOfType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "typeId");
        return a(new e(this, str));
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoInteractor
    public boolean update(@NotNull String str, @NotNull PhotoUpload photoUpload) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        Intrinsics.checkNotNullParameter(photoUpload, "photo");
        PhotoContentValues photoContentValues = new PhotoContentValues(null, 1, null);
        photoContentValues.setOperationId(str);
        photoContentValues.setUploadId(photoUpload.getUploadId());
        Uri contentUri = photoUpload.getContentUri();
        photoContentValues.setContentUri(contentUri != null ? contentUri.toString() : null);
        photoContentValues.setErrorCode(Integer.valueOf(photoUpload.getError().getCode()));
        photoContentValues.setCreated(Long.valueOf(System.currentTimeMillis()));
        photoContentValues.setSourceUri(String.valueOf(photoUpload.getSourceUri()));
        if (this.d.update(Uris.withAppendedId(this.b, photoUpload.getId()), photoContentValues.getValues(), null, null) > 0) {
            return true;
        }
        return false;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoInteractor
    public boolean updatePosition(@NotNull Uri uri, int i) {
        int i2;
        Throwable th;
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        boolean z = true;
        Cursor query = this.d.query(this.b, null, a2.b.a.a.a.t(new StringBuilder(), PhotoContract.CONTENT_URI, "=?"), new String[]{uri.toString()}, PhotoContract.POSITION);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    long j = query.getLong(query.getColumnIndex(PhotoContract.ID));
                    PhotoContentValues photoContentValues = new PhotoContentValues(null, 1, null);
                    photoContentValues.setPosition(Integer.valueOf(i));
                    i2 = this.d.update(Uris.withAppendedId(this.b, j), photoContentValues.getValues(), null, null);
                    query.close();
                } else {
                    throw new RuntimeException("Cannot update position as cursor is empty");
                }
            } catch (Exception e2) {
                try {
                    query.close();
                } catch (Exception unused) {
                }
                throw e2;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            return true;
        }
        return false;
        if (!z) {
            query.close();
        }
        throw th;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoInteractor
    @NotNull
    public Observable<CloseableDataSource<? extends PhotoUpload>> select(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        return a(new c(this, str));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoInteractorImpl(Looper looper, BuildInfo buildInfo, ContentResolver contentResolver, ComputerVisionInteractor computerVisionInteractor, int i, j jVar) {
        this(looper, buildInfo, contentResolver, (i & 8) != 0 ? null : computerVisionInteractor);
    }
}
