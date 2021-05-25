package com.avito.android.photo_picker.gallery.data;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.avito.android.photo_picker.gallery.gallery_list.GalleryUriPhotoItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.CursorsKt;
import com.avito.android.util.Logs;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\b\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00030\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/photo_picker/gallery/data/GalleryPickerRepositoryImpl;", "Lcom/avito/android/photo_picker/gallery/data/GalleryPickerRepository;", "Lio/reactivex/Single;", "Lkotlin/Pair;", "", "Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryUriPhotoItem;", "", "Lcom/avito/android/photo_picker/gallery/data/Folder;", "loadData", "()Lio/reactivex/Single;", "Landroid/content/ContentResolver;", AuthSource.SEND_ABUSE, "Landroid/content/ContentResolver;", "getContentResolver", "()Landroid/content/ContentResolver;", "contentResolver", "<init>", "(Landroid/content/ContentResolver;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryPickerRepositoryImpl implements GalleryPickerRepository {
    @NotNull
    public final ContentResolver a;

    public static final class a<T> implements SingleOnSubscribe<Pair<? extends List<? extends GalleryUriPhotoItem>, ? extends Set<? extends Folder>>> {
        public final /* synthetic */ GalleryPickerRepositoryImpl a;

        public a(GalleryPickerRepositoryImpl galleryPickerRepositoryImpl) {
            this.a = galleryPickerRepositoryImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.reactivex.SingleEmitter<kotlin.Pair<java.util.List<com.avito.android.photo_picker.gallery.gallery_list.GalleryUriPhotoItem>, java.util.Set<com.avito.android.photo_picker.gallery.data.Folder>>>] */
        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(@NotNull SingleEmitter<Pair<? extends List<? extends GalleryUriPhotoItem>, ? extends Set<? extends Folder>>> singleEmitter) {
            Uri uri;
            Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
            if (Build.VERSION.SDK_INT >= 29) {
                uri = MediaStore.Images.Media.getContentUri("external");
            } else {
                uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            }
            Cursor query = this.a.getContentResolver().query(uri, new String[]{"_id", "bucket_display_name", "_data"}, null, null, "datetaken DESC");
            if (query != null) {
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = query.getColumnIndexOrThrow("bucket_display_name");
                int columnIndexOrThrow3 = query.getColumnIndexOrThrow("_data");
                ArrayList arrayList = new ArrayList();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Exception e = null;
                boolean z = false;
                while (query.moveToNext()) {
                    try {
                        long j = query.getLong(columnIndexOrThrow);
                        Uri fromFile = Uri.fromFile(new File(query.getString(columnIndexOrThrow3)));
                        String valueOf = String.valueOf(j);
                        Intrinsics.checkNotNullExpressionValue(fromFile, "contentUri");
                        String string = query.getString(columnIndexOrThrow2);
                        Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(columnIndexFolderName)");
                        GalleryUriPhotoItem galleryUriPhotoItem = new GalleryUriPhotoItem(valueOf, fromFile, string, 0, false, 24, null);
                        arrayList.add(galleryUriPhotoItem);
                        linkedHashSet.add(new Folder(galleryUriPhotoItem.getFolderName(), galleryUriPhotoItem.getImageUri()));
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                if (CursorsKt.isNotEmpty(query) && e != null) {
                    if (z) {
                        Logs.error("Failed to load some images and folders from device", e);
                    } else {
                        Logs.error("Failed to load all images and folders from device", e);
                    }
                }
                query.close();
                singleEmitter.onSuccess(new Pair<>(arrayList, linkedHashSet));
                return;
            }
            singleEmitter.onError(new Throwable());
        }
    }

    @Inject
    public GalleryPickerRepositoryImpl(@NotNull ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.a = contentResolver;
    }

    @NotNull
    public final ContentResolver getContentResolver() {
        return this.a;
    }

    @Override // com.avito.android.photo_picker.gallery.data.GalleryPickerRepository
    @NotNull
    public Single<Pair<List<GalleryUriPhotoItem>, Set<Folder>>> loadData() {
        Single<Pair<List<GalleryUriPhotoItem>, Set<Folder>>> create = Single.create(new a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create { emitter …)\n            }\n        }");
        return create;
    }
}
