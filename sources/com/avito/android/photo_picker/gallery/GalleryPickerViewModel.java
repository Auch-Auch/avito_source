package com.avito.android.photo_picker.gallery;

import a2.a.a.x1.p.c;
import a2.a.a.x1.p.d;
import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.PhotoPickerViewModel;
import com.avito.android.photo_picker.R;
import com.avito.android.photo_picker.gallery.data.Folder;
import com.avito.android.photo_picker.gallery.data.GalleryPickerRepository;
import com.avito.android.photo_picker.gallery.gallery_list.GalleryItemPresenter;
import com.avito.android.photo_picker.gallery.gallery_list.GalleryUriPhotoItem;
import com.avito.android.photo_picker.legacy.PhotoSource;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001CB'\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010<\u001a\u000209¢\u0006\u0004\bA\u0010BJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\fJ\u001d\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\fJ\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\fJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010(R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010!R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u0003068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006D"}, d2 = {"Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState;", "screenState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel;", "photoPickerViewModel", "", "initScreen", "(Lcom/avito/android/photo_picker/PhotoPickerViewModel;)V", "onCleared", "()V", "allowAccessClicked", "cancelButtonClicked", "takePhotoClicked", "", VKApiConst.POSITION, "Lcom/avito/android/photo_picker/gallery/data/Folder;", "folder", "folderSelected", "(ILcom/avito/android/photo_picker/gallery/data/Folder;)V", "loadData", "", "checkCameraPermission", "()Z", "checkStoragePermission", "", "Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryUriPhotoItem;", "c", "()Ljava/util/List;", "", "e", "Ljava/util/List;", "folders", "Lio/reactivex/disposables/CompositeDisposable;", "f", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "", "Ljava/lang/String;", "filter", "d", "photos", "Lcom/avito/android/util/SchedulersFactory;", "j", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "h", "Lcom/avito/android/photo_picker/PhotoPickerViewModel;", "Lcom/avito/android/photo_picker/gallery/data/GalleryPickerRepository;", "k", "Lcom/avito/android/photo_picker/gallery/data/GalleryPickerRepository;", "repository", "Landroidx/lifecycle/MutableLiveData;", g.a, "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemPresenter;", "l", "Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemPresenter;", "galleryItemPresenter", "Lcom/avito/android/permissions/PermissionHelper;", "i", "Lcom/avito/android/permissions/PermissionHelper;", "permissionHelper", "<init>", "(Lcom/avito/android/permissions/PermissionHelper;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/photo_picker/gallery/data/GalleryPickerRepository;Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemPresenter;)V", "ViewState", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryPickerViewModel extends ViewModel {
    public String c = "";
    public List<GalleryUriPhotoItem> d = new ArrayList();
    public final List<Folder> e = new ArrayList();
    public final CompositeDisposable f = new CompositeDisposable();
    public final MutableLiveData<ViewState> g = new MutableLiveData<>();
    public PhotoPickerViewModel h;
    public final PermissionHelper i;
    public final SchedulersFactory j;
    public final GalleryPickerRepository k;
    public final GalleryItemPresenter l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState;", "", "<init>", "()V", "HideNoPermission", "HideNoPhotos", "InitialDataLoaded", "SelectFolder", "ShowNoPermission", "ShowNoPhotos", "UpdatePhotos", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState$UpdatePhotos;", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState$ShowNoPermission;", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState$HideNoPermission;", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState$ShowNoPhotos;", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState$HideNoPhotos;", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState$InitialDataLoaded;", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState$SelectFolder;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState$HideNoPermission;", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class HideNoPermission extends ViewState {
            @NotNull
            public static final HideNoPermission INSTANCE = new HideNoPermission();

            public HideNoPermission() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState$HideNoPhotos;", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class HideNoPhotos extends ViewState {
            @NotNull
            public static final HideNoPhotos INSTANCE = new HideNoPhotos();

            public HideNoPhotos() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState$InitialDataLoaded;", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState;", "", "Lcom/avito/android/photo_picker/gallery/data/Folder;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getFolders", "()Ljava/util/List;", "folders", "Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryUriPhotoItem;", AuthSource.SEND_ABUSE, "getPhotos", "photos", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class InitialDataLoaded extends ViewState {
            @NotNull
            public final List<GalleryUriPhotoItem> a;
            @NotNull
            public final List<Folder> b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public InitialDataLoaded(@NotNull List<GalleryUriPhotoItem> list, @NotNull List<Folder> list2) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "photos");
                Intrinsics.checkNotNullParameter(list2, "folders");
                this.a = list;
                this.b = list2;
            }

            @NotNull
            public final List<Folder> getFolders() {
                return this.b;
            }

            @NotNull
            public final List<GalleryUriPhotoItem> getPhotos() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState$SelectFolder;", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getFolderName", "()Ljava/lang/String;", "folderName", "<init>", "(Ljava/lang/String;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class SelectFolder extends ViewState {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SelectFolder(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "folderName");
                this.a = str;
            }

            @NotNull
            public final String getFolderName() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState$ShowNoPermission;", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState;", "", AuthSource.SEND_ABUSE, "I", "getButtonTextResId", "()I", "buttonTextResId", "<init>", "(I)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShowNoPermission extends ViewState {
            public final int a;

            public ShowNoPermission(int i) {
                super(null);
                this.a = i;
            }

            public final int getButtonTextResId() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState$ShowNoPhotos;", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShowNoPhotos extends ViewState {
            @NotNull
            public static final ShowNoPhotos INSTANCE = new ShowNoPhotos();

            public ShowNoPhotos() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState$UpdatePhotos;", "Lcom/avito/android/photo_picker/gallery/GalleryPickerViewModel$ViewState;", "", "Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryUriPhotoItem;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getPhotos", "()Ljava/util/List;", "photos", "<init>", "(Ljava/util/List;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class UpdatePhotos extends ViewState {
            @NotNull
            public final List<GalleryUriPhotoItem> a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UpdatePhotos(@NotNull List<GalleryUriPhotoItem> list) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "photos");
                this.a = list;
            }

            @NotNull
            public final List<GalleryUriPhotoItem> getPhotos() {
                return this.a;
            }
        }

        public ViewState() {
        }

        public ViewState(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ GalleryPickerViewModel a;

        public a(GalleryPickerViewModel galleryPickerViewModel) {
            this.a = galleryPickerViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            GalleryPickerViewModel galleryPickerViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            GalleryPickerViewModel.access$photoThumbnailClicked(galleryPickerViewModel, str2);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("subscribeToPhotoSelectionObservable", th);
        }
    }

    public GalleryPickerViewModel(@NotNull PermissionHelper permissionHelper, @NotNull SchedulersFactory schedulersFactory, @NotNull GalleryPickerRepository galleryPickerRepository, @NotNull GalleryItemPresenter galleryItemPresenter) {
        Intrinsics.checkNotNullParameter(permissionHelper, "permissionHelper");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(galleryPickerRepository, "repository");
        Intrinsics.checkNotNullParameter(galleryItemPresenter, "galleryItemPresenter");
        this.i = permissionHelper;
        this.j = schedulersFactory;
        this.k = galleryPickerRepository;
        this.l = galleryItemPresenter;
    }

    public static final /* synthetic */ PhotoPickerViewModel access$getPhotoPickerViewModel$p(GalleryPickerViewModel galleryPickerViewModel) {
        PhotoPickerViewModel photoPickerViewModel = galleryPickerViewModel.h;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        return photoPickerViewModel;
    }

    public static final void access$photoThumbnailClicked(GalleryPickerViewModel galleryPickerViewModel, String str) {
        T t;
        Iterator<T> it = galleryPickerViewModel.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getStringId(), str)) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            PhotoPickerViewModel photoPickerViewModel = galleryPickerViewModel.h;
            if (photoPickerViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
            }
            if (photoPickerViewModel.isUriSelected(t2.getImageUri()) > 0) {
                PhotoPickerViewModel photoPickerViewModel2 = galleryPickerViewModel.h;
                if (photoPickerViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
                }
                photoPickerViewModel2.unselectPhotoByUri(t2.getImageUri());
                for (T t3 : galleryPickerViewModel.d) {
                    if (t3.getSelectedPosition() > t2.getSelectedPosition()) {
                        t3.setSelectedPosition(t3.getSelectedPosition() - 1);
                    }
                }
                t2.setSelectedPosition(0);
                galleryPickerViewModel.g.setValue(new ViewState.UpdatePhotos(galleryPickerViewModel.c()));
                return;
            }
            PhotoPickerViewModel photoPickerViewModel3 = galleryPickerViewModel.h;
            if (photoPickerViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
            }
            t2.setSelectedPosition(PhotoPickerViewModel.selectPhotoByUri$default(photoPickerViewModel3, t2.getImageUri(), PhotoSource.GALLERY, str, null, 8, null));
            if (t2.getSelectedPosition() > 0) {
                galleryPickerViewModel.g.setValue(new ViewState.UpdatePhotos(galleryPickerViewModel.c()));
            }
        }
    }

    public final void allowAccessClicked() {
        if (this.i.shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
            this.i.requestPermissions(1000, "android.permission.WRITE_EXTERNAL_STORAGE");
            return;
        }
        PhotoPickerViewModel photoPickerViewModel = this.h;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        photoPickerViewModel.goToSystemSettings();
    }

    public final List<GalleryUriPhotoItem> c() {
        List<GalleryUriPhotoItem> list;
        if (this.c.length() == 0) {
            list = this.d;
        } else {
            List<GalleryUriPhotoItem> list2 = this.d;
            ArrayList arrayList = new ArrayList();
            for (T t : list2) {
                if (Intrinsics.areEqual(t.getFolderName(), this.c)) {
                    arrayList.add(t);
                }
            }
            list = arrayList;
        }
        if (list.isEmpty()) {
            this.g.setValue(ViewState.ShowNoPhotos.INSTANCE);
        } else {
            this.g.setValue(ViewState.HideNoPhotos.INSTANCE);
        }
        return list;
    }

    public final void cancelButtonClicked() {
        PhotoPickerViewModel photoPickerViewModel = this.h;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        photoPickerViewModel.exitPhotoPicker();
    }

    public final boolean checkCameraPermission() {
        return this.i.checkPermission("android.permission.CAMERA");
    }

    public final void checkStoragePermission() {
        if (!this.i.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")) {
            this.i.requestPermissions(1000, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
    }

    public final void folderSelected(int i2, @NotNull Folder folder) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        this.g.setValue(new ViewState.SelectFolder(folder.getFolderName()));
        if (i2 == 0) {
            this.c = "";
        } else if (i2 == this.e.size() - 1) {
            PhotoPickerViewModel photoPickerViewModel = this.h;
            if (photoPickerViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
            }
            photoPickerViewModel.goToSystemGallery();
        } else {
            this.c = folder.getFolderName();
        }
        this.g.setValue(new ViewState.UpdatePhotos(c()));
    }

    public final void initScreen(@NotNull PhotoPickerViewModel photoPickerViewModel) {
        Intrinsics.checkNotNullParameter(photoPickerViewModel, "photoPickerViewModel");
        this.h = photoPickerViewModel;
        CompositeDisposable compositeDisposable = this.f;
        Disposable subscribe = this.l.getPhotoClickObservable().subscribeOn(this.j.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "galleryItemPresenter.pho…ble\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void loadData() {
        int i2;
        if (this.i.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")) {
            this.g.setValue(ViewState.HideNoPermission.INSTANCE);
            CompositeDisposable compositeDisposable = this.f;
            Disposable subscribe = this.k.loadData().subscribeOn(this.j.io()).observeOn(this.j.mainThread()).doOnError(new a2.a.a.x1.p.b(this)).subscribe(new c(this), d.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "repository.loadData()\n  …          }\n            )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        if (this.i.shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
            i2 = R.string.allow_access;
        } else {
            i2 = R.string.go_to_settings;
        }
        this.g.setValue(new ViewState.ShowNoPermission(i2));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.f.clear();
        super.onCleared();
    }

    @NotNull
    public final LiveData<ViewState> screenState() {
        return this.g;
    }

    public final void takePhotoClicked() {
        PhotoPickerViewModel photoPickerViewModel = this.h;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        photoPickerViewModel.goToCamera();
    }
}
