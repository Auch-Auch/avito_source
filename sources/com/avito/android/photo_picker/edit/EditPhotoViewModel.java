package com.avito.android.photo_picker.edit;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.analytics.Rotate90PhotoEvent;
import com.avito.android.krop.util.Transformation;
import com.avito.android.photo_picker.SelectedPhoto;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import io.reactivex.rxjava3.kotlin.SinglesKt;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.funktionale.option.Option;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00012B'\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b0\u00101J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0014\u0010\fJ\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\fR\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X.¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/avito/android/photo_picker/edit/EditPhotoViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState;", "screenState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/photo_picker/SelectedPhoto;", "photo", "", "init", "(Lcom/avito/android/photo_picker/SelectedPhoto;)V", "cancelEditProcess", "()V", "Lcom/avito/android/krop/util/Transformation;", "transformation", "Lkotlin/Function0;", "Landroid/graphics/Bitmap;", "bitmapProvider", "saveChanges", "(Lcom/avito/android/krop/util/Transformation;Lkotlin/jvm/functions/Function0;)V", "onCleared", "rotate90", "Lcom/avito/android/photo_picker/edit/ExifProvider;", "i", "Lcom/avito/android/photo_picker/edit/ExifProvider;", "exifProvider", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "h", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "eventTracker", "Landroidx/lifecycle/MutableLiveData;", "e", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "f", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "sharedPhotosStorage", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposable", "d", "Lcom/avito/android/photo_picker/SelectedPhoto;", "editedPhoto", "Lcom/avito/android/util/SchedulersFactory3;", a2.g.r.g.a, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory3", "<init>", "(Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/PhotoPickerEventTracker;Lcom/avito/android/photo_picker/edit/ExifProvider;)V", "ViewState", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class EditPhotoViewModel extends ViewModel {
    public final CompositeDisposable c = new CompositeDisposable();
    public SelectedPhoto d;
    public final MutableLiveData<ViewState> e = new MutableLiveData<>();
    public final SharedPhotosStorage f;
    public final SchedulersFactory3 g;
    public final PhotoPickerEventTracker h;
    public final ExifProvider i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState;", "", "<init>", "()V", "CloseScreen", "OpenError", "Rotate", "SaveAndClosePhoto", "SaveError", "ShowImage", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState$ShowImage;", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState$Rotate;", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState$OpenError;", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState$CloseScreen;", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState$SaveError;", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState$SaveAndClosePhoto;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState$CloseScreen;", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class CloseScreen extends ViewState {
            @NotNull
            public static final CloseScreen INSTANCE = new CloseScreen();

            public CloseScreen() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState$OpenError;", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class OpenError extends ViewState {
            @NotNull
            public static final OpenError INSTANCE = new OpenError();

            public OpenError() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState$Rotate;", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState;", "", "component1", "()I", "byAngle", "copy", "(I)Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState$Rotate;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getByAngle", "<init>", "(I)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class Rotate extends ViewState {
            public final int a;

            public Rotate(int i) {
                super(null);
                this.a = i;
            }

            public static /* synthetic */ Rotate copy$default(Rotate rotate, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = rotate.a;
                }
                return rotate.copy(i);
            }

            public final int component1() {
                return this.a;
            }

            @NotNull
            public final Rotate copy(int i) {
                return new Rotate(i);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Rotate) && this.a == ((Rotate) obj).a;
                }
                return true;
            }

            public final int getByAngle() {
                return this.a;
            }

            public int hashCode() {
                return this.a;
            }

            @NotNull
            public String toString() {
                return a2.b.a.a.a.j(a2.b.a.a.a.L("Rotate(byAngle="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState$SaveAndClosePhoto;", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState;", "Lcom/avito/android/photo_picker/SelectedPhoto;", "component1", "()Lcom/avito/android/photo_picker/SelectedPhoto;", "editedPhoto", "copy", "(Lcom/avito/android/photo_picker/SelectedPhoto;)Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState$SaveAndClosePhoto;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/SelectedPhoto;", "getEditedPhoto", "<init>", "(Lcom/avito/android/photo_picker/SelectedPhoto;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class SaveAndClosePhoto extends ViewState {
            @NotNull
            public final SelectedPhoto a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SaveAndClosePhoto(@NotNull SelectedPhoto selectedPhoto) {
                super(null);
                Intrinsics.checkNotNullParameter(selectedPhoto, "editedPhoto");
                this.a = selectedPhoto;
            }

            public static /* synthetic */ SaveAndClosePhoto copy$default(SaveAndClosePhoto saveAndClosePhoto, SelectedPhoto selectedPhoto, int i, Object obj) {
                if ((i & 1) != 0) {
                    selectedPhoto = saveAndClosePhoto.a;
                }
                return saveAndClosePhoto.copy(selectedPhoto);
            }

            @NotNull
            public final SelectedPhoto component1() {
                return this.a;
            }

            @NotNull
            public final SaveAndClosePhoto copy(@NotNull SelectedPhoto selectedPhoto) {
                Intrinsics.checkNotNullParameter(selectedPhoto, "editedPhoto");
                return new SaveAndClosePhoto(selectedPhoto);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof SaveAndClosePhoto) && Intrinsics.areEqual(this.a, ((SaveAndClosePhoto) obj).a);
                }
                return true;
            }

            @NotNull
            public final SelectedPhoto getEditedPhoto() {
                return this.a;
            }

            public int hashCode() {
                SelectedPhoto selectedPhoto = this.a;
                if (selectedPhoto != null) {
                    return selectedPhoto.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("SaveAndClosePhoto(editedPhoto=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState$SaveError;", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class SaveError extends ViewState {
            @NotNull
            public static final SaveError INSTANCE = new SaveError();

            public SaveError() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState$ShowImage;", "Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState;", "Landroid/net/Uri;", "component1", "()Landroid/net/Uri;", "Lcom/avito/android/krop/util/Transformation;", "component2", "()Lcom/avito/android/krop/util/Transformation;", ShareConstants.MEDIA_URI, "state", "copy", "(Landroid/net/Uri;Lcom/avito/android/krop/util/Transformation;)Lcom/avito/android/photo_picker/edit/EditPhotoViewModel$ViewState$ShowImage;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/krop/util/Transformation;", "getState", AuthSource.SEND_ABUSE, "Landroid/net/Uri;", "getUri", "<init>", "(Landroid/net/Uri;Lcom/avito/android/krop/util/Transformation;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShowImage extends ViewState {
            @NotNull
            public final Uri a;
            @Nullable
            public final Transformation b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ShowImage(@NotNull Uri uri, @Nullable Transformation transformation) {
                super(null);
                Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
                this.a = uri;
                this.b = transformation;
            }

            public static /* synthetic */ ShowImage copy$default(ShowImage showImage, Uri uri, Transformation transformation, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = showImage.a;
                }
                if ((i & 2) != 0) {
                    transformation = showImage.b;
                }
                return showImage.copy(uri, transformation);
            }

            @NotNull
            public final Uri component1() {
                return this.a;
            }

            @Nullable
            public final Transformation component2() {
                return this.b;
            }

            @NotNull
            public final ShowImage copy(@NotNull Uri uri, @Nullable Transformation transformation) {
                Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
                return new ShowImage(uri, transformation);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ShowImage)) {
                    return false;
                }
                ShowImage showImage = (ShowImage) obj;
                return Intrinsics.areEqual(this.a, showImage.a) && Intrinsics.areEqual(this.b, showImage.b);
            }

            @Nullable
            public final Transformation getState() {
                return this.b;
            }

            @NotNull
            public final Uri getUri() {
                return this.a;
            }

            public int hashCode() {
                Uri uri = this.a;
                int i = 0;
                int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
                Transformation transformation = this.b;
                if (transformation != null) {
                    i = transformation.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("ShowImage(uri=");
                L.append(this.a);
                L.append(", state=");
                L.append(this.b);
                L.append(")");
                return L.toString();
            }
        }

        public ViewState() {
        }

        public ViewState(j jVar) {
        }
    }

    public static final class a<T, R> implements Function<Pair<? extends Bitmap, ? extends Option<? extends Map<String, String>>>, Uri> {
        public final /* synthetic */ EditPhotoViewModel a;

        public a(EditPhotoViewModel editPhotoViewModel) {
            this.a = editPhotoViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Uri apply(Pair<? extends Bitmap, ? extends Option<? extends Map<String, String>>> pair) {
            Pair<? extends Bitmap, ? extends Option<? extends Map<String, String>>> pair2 = pair;
            Bitmap bitmap = (Bitmap) pair2.component1();
            SharedPhotosStorage sharedPhotosStorage = this.a.f;
            Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
            return SharedPhotosStorage.DefaultImpls.addImage$default(sharedPhotosStorage, bitmap, null, null, (Map) ((Option) pair2.component2()).orNull(), null, 22, null);
        }
    }

    public static final class b<T> implements Consumer<Uri> {
        public final /* synthetic */ EditPhotoViewModel a;

        public b(EditPhotoViewModel editPhotoViewModel) {
            this.a = editPhotoViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r11v2, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Uri uri) {
            Uri uri2 = uri;
            MutableLiveData mutableLiveData = this.a.e;
            SelectedPhoto access$getEditedPhoto$p = EditPhotoViewModel.access$getEditedPhoto$p(this.a);
            Intrinsics.checkNotNullExpressionValue(uri2, "croppedImage");
            mutableLiveData.setValue(new ViewState.SaveAndClosePhoto(SelectedPhoto.copy$default(access$getEditedPhoto$p, uri2, null, null, EditPhotoViewModel.access$getEditedPhoto$p(this.a).getUri(), null, null, 54, null)));
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ EditPhotoViewModel a;

        public c(EditPhotoViewModel editPhotoViewModel) {
            this.a = editPhotoViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.debug("EditedPhotoViewModel", "Error on result save", th);
            this.a.e.setValue(ViewState.SaveError.INSTANCE);
        }
    }

    public static final class d<V> implements Callable<Maybe<Bitmap>> {
        public final /* synthetic */ Function0 a;

        public d(Function0 function0) {
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Maybe<Bitmap> call() {
            Maybe<Bitmap> just;
            Bitmap bitmap = (Bitmap) this.a.invoke();
            return (bitmap == null || (just = Maybe.just(bitmap)) == null) ? Maybe.empty() : just;
        }
    }

    public static final class e<T, R> implements Function<Maybe<Bitmap>, MaybeSource<? extends Bitmap>> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MaybeSource<? extends Bitmap> apply(Maybe<Bitmap> maybe) {
            return maybe;
        }
    }

    public static final class f<T, R> implements Function<Map<String, String>, Option<? extends Map<String, String>>> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Option<? extends Map<String, String>> apply(Map<String, String> map) {
            return new Option.Some(map);
        }
    }

    public static final class g<T, R> implements Function<Throwable, Option<? extends Map<String, String>>> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Option<? extends Map<String, String>> apply(Throwable th) {
            return Option.Companion.empty();
        }
    }

    public EditPhotoViewModel(@NotNull SharedPhotosStorage sharedPhotosStorage, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull PhotoPickerEventTracker photoPickerEventTracker, @NotNull ExifProvider exifProvider) {
        Intrinsics.checkNotNullParameter(sharedPhotosStorage, "sharedPhotosStorage");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory3");
        Intrinsics.checkNotNullParameter(photoPickerEventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(exifProvider, "exifProvider");
        this.f = sharedPhotosStorage;
        this.g = schedulersFactory3;
        this.h = photoPickerEventTracker;
        this.i = exifProvider;
    }

    public static final /* synthetic */ SelectedPhoto access$getEditedPhoto$p(EditPhotoViewModel editPhotoViewModel) {
        SelectedPhoto selectedPhoto = editPhotoViewModel.d;
        if (selectedPhoto == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editedPhoto");
        }
        return selectedPhoto;
    }

    public final void cancelEditProcess() {
        this.e.setValue(ViewState.CloseScreen.INSTANCE);
    }

    public final void init(@Nullable SelectedPhoto selectedPhoto) {
        if (selectedPhoto != null) {
            this.d = selectedPhoto;
            MutableLiveData<ViewState> mutableLiveData = this.e;
            if (selectedPhoto == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editedPhoto");
            }
            Uri originalUri = selectedPhoto.getOriginalUri();
            if (originalUri == null) {
                originalUri = selectedPhoto.getUri();
            }
            SelectedPhoto selectedPhoto2 = this.d;
            if (selectedPhoto2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editedPhoto");
            }
            mutableLiveData.setValue(new ViewState.ShowImage(originalUri, selectedPhoto2.getState()));
            return;
        }
        this.e.setValue(ViewState.OpenError.INSTANCE);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.c.dispose();
    }

    public final void rotate90() {
        PhotoPickerEventTracker photoPickerEventTracker = this.h;
        SelectedPhoto selectedPhoto = this.d;
        if (selectedPhoto == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editedPhoto");
        }
        photoPickerEventTracker.track(new Rotate90PhotoEvent(selectedPhoto.getUploadId()));
        this.e.setValue(new ViewState.Rotate(-90));
    }

    public final void saveChanges(@NotNull Transformation transformation, @NotNull Function0<Bitmap> function0) {
        Intrinsics.checkNotNullParameter(transformation, "transformation");
        Intrinsics.checkNotNullParameter(function0, "bitmapProvider");
        SelectedPhoto selectedPhoto = this.d;
        if (selectedPhoto == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editedPhoto");
        }
        SelectedPhoto copy$default = SelectedPhoto.copy$default(selectedPhoto, null, null, null, null, transformation, null, 47, null);
        this.d = copy$default;
        ExifProvider exifProvider = this.i;
        if (copy$default == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editedPhoto");
        }
        Uri originalUri = copy$default.getOriginalUri();
        if (originalUri == null) {
            originalUri = copy$default.getUri();
        }
        Single<R> onErrorReturn = exifProvider.getExifFeatures(originalUri).subscribeOn(this.g.io()).map(f.a).toSingle().timeout(5000, TimeUnit.MILLISECONDS, this.g.computation()).onErrorReturn(g.a);
        Single subscribeOn = Maybe.fromCallable(new d(function0)).flatMap(e.a).toSingle().subscribeOn(this.g.computation());
        CompositeDisposable compositeDisposable = this.c;
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "bitmapSingle");
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "exifAttrsSingle");
        Disposable subscribe = SinglesKt.zipWith(subscribeOn, onErrorReturn).observeOn(this.g.io()).map(new a(this)).observeOn(this.g.mainThread()).subscribe(new b(this), new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "bitmapSingle.zipWith(exi….SaveError\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final LiveData<ViewState> screenState() {
        return this.e;
    }
}
