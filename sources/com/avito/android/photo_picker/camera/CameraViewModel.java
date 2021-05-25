package com.avito.android.photo_picker.camera;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.TextureView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.ExifExtraData;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.ExifUtilsKt;
import com.avito.android.photo_picker.PhotoPickerViewModel;
import com.avito.android.photo_picker.R;
import com.avito.android.photo_picker.camera.CameraViewport;
import com.avito.android.photo_picker.legacy.CameraInteractor;
import com.avito.android.photo_picker.legacy.CameraOpenInteractor;
import com.avito.android.photo_picker.legacy.CameraType;
import com.avito.android.photo_picker.legacy.FlashMode;
import com.avito.android.photo_picker.legacy.GalleryInteractor;
import com.avito.android.photo_picker.legacy.PhotoResizer;
import com.avito.android.photo_picker.legacy.PhotoSource;
import com.avito.android.photo_picker.legacy.RotationProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Collections;
import com.avito.android.util.Dimension;
import com.avito.android.util.DimensionsKt;
import com.avito.android.util.Logs;
import com.avito.android.util.NormalizedRect;
import com.avito.android.util.Rotation;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.funktionale.option.Option;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002xyBG\u0012\u0006\u0010u\u001a\u00020r\u0012\u0006\u0010f\u001a\u00020c\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010j\u001a\u00020g\u0012\u0006\u0010`\u001a\u00020]\u0012\u0006\u0010Y\u001a\u00020V\u0012\u0006\u0010:\u001a\u000207¢\u0006\u0004\bv\u0010wJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0017\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\r\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\r\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u0004J%\u0010!\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0002¢\u0006\u0004\b#\u0010\u0004J\r\u0010$\u001a\u00020\u0002¢\u0006\u0004\b$\u0010\u0004J\r\u0010%\u001a\u00020\u0002¢\u0006\u0004\b%\u0010\u0004J\r\u0010&\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0004J\r\u0010'\u001a\u00020\u0002¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0002H\u0014¢\u0006\u0004\b(\u0010\u0004R\u0016\u0010+\u001a\u00020\u00108\u0002@\u0002X.¢\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0019\u0010K\u001a\u00020F8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020>0L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010@R\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010\\\u001a\u00020\t8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u001c\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00050L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010NR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010m\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010lR\u0018\u0010p\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010q\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u00105R\u0016\u0010u\u001a\u00020r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010t¨\u0006z"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewModel;", "Landroidx/lifecycle/ViewModel;", "", "d", "()V", "Lcom/avito/android/photo_picker/legacy/FlashMode;", "flashMode", "e", "(Lcom/avito/android/photo_picker/legacy/FlashMode;)V", "Lcom/avito/android/util/Dimension;", "c", "()Lcom/avito/android/util/Dimension;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState;", "screenState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel;", "activityViewModel", "init", "(Lcom/avito/android/photo_picker/PhotoPickerViewModel;)V", "Lio/reactivex/Observable;", "Lcom/avito/android/photo_picker/camera/CameraViewport$FocusArea;", "touchObservable", "subscribeToFocusChanges", "(Lio/reactivex/Observable;)V", "checkCameraPermission", "galleryClicked", "cancelClicked", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "openCamera", "(Landroid/graphics/SurfaceTexture;II)V", "cameraModeClicked", "flashModeClicked", "allowAccessClicked", "closeCamera", "captureClicked", "onCleared", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/photo_picker/PhotoPickerViewModel;", "photoPickerViewModel", "Landroidx/lifecycle/MutableLiveData;", "l", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$FocusMode;", "o", "Lcom/avito/android/photo_picker/camera/CameraViewModel$FocusMode;", "focusMode", "Lio/reactivex/disposables/Disposable;", "f", "Lio/reactivex/disposables/Disposable;", "cameraOpenSubscription", "Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "x", "Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "photoResizer", "Lcom/avito/android/photo_picker/legacy/CameraInteractor;", "Lcom/avito/android/photo_picker/legacy/CameraInteractor;", "cameraInteractor", "Lcom/avito/android/photo_picker/legacy/CameraType;", "i", "Lcom/avito/android/photo_picker/legacy/CameraType;", "currentCamera", "Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "t", "Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "cameraOpenInteractor", "Landroid/view/TextureView$SurfaceTextureListener;", "p", "Landroid/view/TextureView$SurfaceTextureListener;", "getSurfaceTextureListener", "()Landroid/view/TextureView$SurfaceTextureListener;", "surfaceTextureListener", "", "j", "Ljava/util/List;", "availableCameras", "Lcom/avito/android/util/SchedulersFactory;", "s", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "n", "cameraFacing", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "w", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "sharedPhotosStorage", "h", "Lcom/avito/android/util/Dimension;", "previewSize", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", VKApiConst.VERSION, "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "exifExtraDataSerializer", "k", "availableFlashModes", "Lcom/avito/android/permissions/PermissionHelper;", "r", "Lcom/avito/android/permissions/PermissionHelper;", "permissionHelper", "Lcom/avito/android/photo_picker/legacy/RotationProvider;", "u", "Lcom/avito/android/photo_picker/legacy/RotationProvider;", "rotationProvider", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", a2.g.r.g.a, "Landroid/graphics/SurfaceTexture;", "texture", "captureImageDisposable", "Lcom/avito/android/photo_picker/legacy/GalleryInteractor;", VKApiConst.Q, "Lcom/avito/android/photo_picker/legacy/GalleryInteractor;", "galleryInteractor", "<init>", "(Lcom/avito/android/photo_picker/legacy/GalleryInteractor;Lcom/avito/android/permissions/PermissionHelper;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;Lcom/avito/android/photo_picker/legacy/RotationProvider;Lcom/avito/android/photo_picker/ExifExtraDataSerializer;Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;Lcom/avito/android/photo_picker/legacy/PhotoResizer;)V", "FocusMode", "ViewState", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class CameraViewModel extends ViewModel {
    public CameraInteractor c;
    public final CompositeDisposable d = new CompositeDisposable();
    public Disposable e;
    public Disposable f;
    public SurfaceTexture g;
    public Dimension h;
    public CameraType i;
    public final List<CameraType> j;
    public List<? extends FlashMode> k;
    public final MutableLiveData<ViewState> l;
    public PhotoPickerViewModel m;
    public CameraType n;
    public FocusMode o;
    @NotNull
    public final TextureView.SurfaceTextureListener p;
    public final GalleryInteractor q;
    public final PermissionHelper r;
    public final SchedulersFactory s;
    public final CameraOpenInteractor t;
    public final RotationProvider u;
    public final ExifExtraDataSerializer v;
    public final SharedPhotosStorage w;
    public final PhotoResizer x;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewModel$FocusMode;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO_FOCUS", "MANUAL_FOCUS", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public enum FocusMode {
        AUTO_FOCUS,
        MANUAL_FOCUS
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u000b\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState;", "", "<init>", "()V", "ChangeFlashModeIcon", "GalleryButtonSource", "HideNoPermission", "NeedToReopenCamera", "NoImagesFromGalleryAvailable", "PhotoCaptureError", "PhotoCaptureStarted", "PhotoCaptureSuccess", "ShowNoPermission", "StartFocusOnTouch", "UpdateTextureMatrix", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$NoImagesFromGalleryAvailable;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$GalleryButtonSource;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$NeedToReopenCamera;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$HideNoPermission;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$ShowNoPermission;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$UpdateTextureMatrix;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$ChangeFlashModeIcon;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$StartFocusOnTouch;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$PhotoCaptureStarted;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$PhotoCaptureSuccess;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$PhotoCaptureError;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$ChangeFlashModeIcon;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState;", "", AuthSource.SEND_ABUSE, "I", "getImageResId", "()I", "imageResId", "<init>", "(I)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ChangeFlashModeIcon extends ViewState {
            public final int a;

            public ChangeFlashModeIcon(int i) {
                super(null);
                this.a = i;
            }

            public final int getImageResId() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$GalleryButtonSource;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState;", "Landroid/graphics/Bitmap;", AuthSource.SEND_ABUSE, "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "bitmap", "<init>", "(Landroid/graphics/Bitmap;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class GalleryButtonSource extends ViewState {
            @NotNull
            public final Bitmap a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public GalleryButtonSource(@NotNull Bitmap bitmap) {
                super(null);
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                this.a = bitmap;
            }

            @NotNull
            public final Bitmap getBitmap() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$HideNoPermission;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class HideNoPermission extends ViewState {
            @NotNull
            public static final HideNoPermission INSTANCE = new HideNoPermission();

            public HideNoPermission() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$NeedToReopenCamera;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class NeedToReopenCamera extends ViewState {
            @NotNull
            public static final NeedToReopenCamera INSTANCE = new NeedToReopenCamera();

            public NeedToReopenCamera() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$NoImagesFromGalleryAvailable;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class NoImagesFromGalleryAvailable extends ViewState {
            @NotNull
            public static final NoImagesFromGalleryAvailable INSTANCE = new NoImagesFromGalleryAvailable();

            public NoImagesFromGalleryAvailable() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$PhotoCaptureError;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class PhotoCaptureError extends ViewState {
            @NotNull
            public static final PhotoCaptureError INSTANCE = new PhotoCaptureError();

            public PhotoCaptureError() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$PhotoCaptureStarted;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class PhotoCaptureStarted extends ViewState {
            @NotNull
            public static final PhotoCaptureStarted INSTANCE = new PhotoCaptureStarted();

            public PhotoCaptureStarted() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$PhotoCaptureSuccess;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState;", "", "component1", "()Z", "withCameraRestart", "copy", "(Z)Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$PhotoCaptureSuccess;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Z", "getWithCameraRestart", "<init>", "(Z)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class PhotoCaptureSuccess extends ViewState {
            public final boolean a;

            public PhotoCaptureSuccess(boolean z) {
                super(null);
                this.a = z;
            }

            public static /* synthetic */ PhotoCaptureSuccess copy$default(PhotoCaptureSuccess photoCaptureSuccess, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = photoCaptureSuccess.a;
                }
                return photoCaptureSuccess.copy(z);
            }

            public final boolean component1() {
                return this.a;
            }

            @NotNull
            public final PhotoCaptureSuccess copy(boolean z) {
                return new PhotoCaptureSuccess(z);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof PhotoCaptureSuccess) && this.a == ((PhotoCaptureSuccess) obj).a;
                }
                return true;
            }

            public final boolean getWithCameraRestart() {
                return this.a;
            }

            public int hashCode() {
                boolean z = this.a;
                if (z) {
                    return 1;
                }
                return z ? 1 : 0;
            }

            @NotNull
            public String toString() {
                return a2.b.a.a.a.B(a2.b.a.a.a.L("PhotoCaptureSuccess(withCameraRestart="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$ShowNoPermission;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState;", "", AuthSource.SEND_ABUSE, "I", "getButtonTextResId", "()I", "buttonTextResId", "<init>", "(I)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
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

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$StartFocusOnTouch;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState;", "", AuthSource.BOOKING_ORDER, "F", "getY", "()F", "y", AuthSource.SEND_ABUSE, "getX", "x", "<init>", "(FF)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class StartFocusOnTouch extends ViewState {
            public final float a;
            public final float b;

            public StartFocusOnTouch(float f, float f2) {
                super(null);
                this.a = f;
                this.b = f2;
            }

            public final float getX() {
                return this.a;
            }

            public final float getY() {
                return this.b;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState$UpdateTextureMatrix;", "Lcom/avito/android/photo_picker/camera/CameraViewModel$ViewState;", "Landroid/graphics/Matrix;", AuthSource.SEND_ABUSE, "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "matrix", "<init>", "(Landroid/graphics/Matrix;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class UpdateTextureMatrix extends ViewState {
            @NotNull
            public final Matrix a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UpdateTextureMatrix(@NotNull Matrix matrix) {
                super(null);
                Intrinsics.checkNotNullParameter(matrix, "matrix");
                this.a = matrix;
            }

            @NotNull
            public final Matrix getMatrix() {
                return this.a;
            }
        }

        public ViewState() {
        }

        public ViewState(j jVar) {
        }
    }

    public static final class a<T, R> implements Function<byte[], ObservableSource<? extends Uri>> {
        public final /* synthetic */ CameraViewModel a;
        public final /* synthetic */ CameraInteractor b;

        public a(CameraViewModel cameraViewModel, CameraInteractor cameraInteractor) {
            this.a = cameraViewModel;
            this.b = cameraInteractor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Uri> apply(byte[] bArr) {
            byte[] bArr2 = bArr;
            Intrinsics.checkNotNullParameter(bArr2, "photoByteArray");
            return this.a.x.resize(bArr2, this.a.c(), (float) this.b.calculatePictureRotationDegree(this.a.u.getRotation())).map(new a2.a.a.x1.n.c(this, bArr2));
        }
    }

    public static final class b<T> implements Consumer<Uri> {
        public final /* synthetic */ CameraViewModel a;
        public final /* synthetic */ boolean b;

        public b(CameraViewModel cameraViewModel, boolean z) {
            this.a = cameraViewModel;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r8v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Uri uri) {
            Uri uri2 = uri;
            this.a.d();
            this.a.l.setValue(new ViewState.PhotoCaptureSuccess(this.b));
            if (!this.b) {
                CameraViewModel.access$startPreview(this.a);
            }
            PhotoPickerViewModel access$getPhotoPickerViewModel$p = CameraViewModel.access$getPhotoPickerViewModel$p(this.a);
            Intrinsics.checkNotNullExpressionValue(uri2, "it");
            PhotoPickerViewModel.selectPhotoByUri$default(access$getPhotoPickerViewModel$p, uri2, PhotoSource.CAMERA_TEMP, null, null, 12, null);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ CameraViewModel a;

        public c(CameraViewModel cameraViewModel) {
            this.a = cameraViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Photo capture error", th);
            this.a.l.setValue(ViewState.PhotoCaptureError.INSTANCE);
        }
    }

    public static final class d<T> implements Consumer<Option<? extends Bitmap>> {
        public final /* synthetic */ CameraViewModel a;

        public d(CameraViewModel cameraViewModel) {
            this.a = cameraViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Option<? extends Bitmap> option) {
            Object obj;
            Option<? extends Bitmap> option2 = option;
            MutableLiveData mutableLiveData = this.a.l;
            if (option2.isEmpty()) {
                obj = ViewState.NoImagesFromGalleryAvailable.INSTANCE;
            } else {
                obj = new ViewState.GalleryButtonSource((Bitmap) option2.get());
            }
            mutableLiveData.setValue(obj);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ CameraViewModel a;

        public e(CameraViewModel cameraViewModel) {
            this.a = cameraViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.l.setValue(ViewState.NoImagesFromGalleryAvailable.INSTANCE);
            Logs.error("Can't get last image from gallery", th);
        }
    }

    public static final class f<T> implements Consumer<Unit> {
        public final /* synthetic */ CameraViewModel a;
        public final /* synthetic */ FlashMode b;

        public f(CameraViewModel cameraViewModel, FlashMode flashMode) {
            this.a = cameraViewModel;
            this.b = flashMode;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            int i;
            CameraViewModel.access$getPhotoPickerViewModel$p(this.a).setCurrentFlashMode$photo_picker_release(this.b);
            FlashMode currentFlashMode$photo_picker_release = CameraViewModel.access$getPhotoPickerViewModel$p(this.a).getCurrentFlashMode$photo_picker_release();
            if (Intrinsics.areEqual(currentFlashMode$photo_picker_release, FlashMode.Off.INSTANCE)) {
                i = R.drawable.ic_light_off;
            } else if (Intrinsics.areEqual(currentFlashMode$photo_picker_release, FlashMode.ForceOn.INSTANCE)) {
                i = R.drawable.ic_light_on;
            } else if (Intrinsics.areEqual(currentFlashMode$photo_picker_release, FlashMode.Auto.INSTANCE)) {
                i = R.drawable.ic_light_auto;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.a.l.setValue(new ViewState.ChangeFlashModeIcon(i));
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public static final g a = new g();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Flash mode set error", th);
        }
    }

    public static final class h<T> implements Consumer<CameraViewport.FocusArea> {
        public final /* synthetic */ CameraViewModel a;

        public h(CameraViewModel cameraViewModel) {
            this.a = cameraViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(CameraViewport.FocusArea focusArea) {
            CameraViewport.FocusArea focusArea2 = focusArea;
            CameraInteractor cameraInteractor = this.a.c;
            if (cameraInteractor != null && cameraInteractor.getHasAutoFocus() && cameraInteractor.getHasFocusAreas()) {
                this.a.o = FocusMode.MANUAL_FOCUS;
                this.a.l.setValue(new ViewState.StartFocusOnTouch(focusArea2.getFocusRect().centerX(), focusArea2.getFocusRect().centerY()));
                cameraInteractor.focusAuto(focusArea2.getFocusRect(), focusArea2.getMeteringRect());
            }
        }
    }

    public CameraViewModel(@NotNull GalleryInteractor galleryInteractor, @NotNull PermissionHelper permissionHelper, @NotNull SchedulersFactory schedulersFactory, @NotNull CameraOpenInteractor cameraOpenInteractor, @NotNull RotationProvider rotationProvider, @NotNull ExifExtraDataSerializer exifExtraDataSerializer, @NotNull SharedPhotosStorage sharedPhotosStorage, @NotNull PhotoResizer photoResizer) {
        CameraType cameraType;
        Intrinsics.checkNotNullParameter(galleryInteractor, "galleryInteractor");
        Intrinsics.checkNotNullParameter(permissionHelper, "permissionHelper");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(cameraOpenInteractor, "cameraOpenInteractor");
        Intrinsics.checkNotNullParameter(rotationProvider, "rotationProvider");
        Intrinsics.checkNotNullParameter(exifExtraDataSerializer, "exifExtraDataSerializer");
        Intrinsics.checkNotNullParameter(sharedPhotosStorage, "sharedPhotosStorage");
        Intrinsics.checkNotNullParameter(photoResizer, "photoResizer");
        this.q = galleryInteractor;
        this.r = permissionHelper;
        this.s = schedulersFactory;
        this.t = cameraOpenInteractor;
        this.u = rotationProvider;
        this.v = exifExtraDataSerializer;
        this.w = sharedPhotosStorage;
        this.x = photoResizer;
        List<CameraType> availableCameras = cameraOpenInteractor.getAvailableCameras();
        this.j = availableCameras;
        this.k = CollectionsKt__CollectionsKt.emptyList();
        this.l = new MutableLiveData<>();
        CameraType.BackCamera backCamera = CameraType.BackCamera.INSTANCE;
        this.n = backCamera;
        this.o = FocusMode.AUTO_FOCUS;
        if (availableCameras.contains(backCamera)) {
            cameraType = this.n;
        } else {
            cameraType = availableCameras.size() == 0 ? null : backCamera;
        }
        this.i = cameraType;
        this.p = new TextureView.SurfaceTextureListener(this) { // from class: com.avito.android.photo_picker.camera.CameraViewModel$surfaceTextureListener$1
            public final /* synthetic */ CameraViewModel a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surfaceTexture, int i2, int i3) {
                Intrinsics.checkNotNullParameter(surfaceTexture, "texture");
                this.a.openCamera(surfaceTexture, i2, i3);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surfaceTexture) {
                Intrinsics.checkNotNullParameter(surfaceTexture, "texture");
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surfaceTexture, int i2, int i3) {
                Intrinsics.checkNotNullParameter(surfaceTexture, "texture");
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surfaceTexture) {
                Intrinsics.checkNotNullParameter(surfaceTexture, "texture");
            }
        };
    }

    public static final Map access$getExifAttributes(CameraViewModel cameraViewModel, byte[] bArr) {
        Objects.requireNonNull(cameraViewModel);
        Map<String, String> attributes = ExifUtilsKt.getAttributes(new ExifInterface(new ByteArrayInputStream(bArr)));
        ExifUtilsKt.setExtraData(attributes, cameraViewModel.v.serialize(new ExifExtraData(attributes.get(ExifInterface.TAG_IMAGE_WIDTH), attributes.get(ExifInterface.TAG_IMAGE_LENGTH))));
        return attributes;
    }

    public static final /* synthetic */ PhotoPickerViewModel access$getPhotoPickerViewModel$p(CameraViewModel cameraViewModel) {
        PhotoPickerViewModel photoPickerViewModel = cameraViewModel.m;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        return photoPickerViewModel;
    }

    public static final void access$startPreview(CameraViewModel cameraViewModel) {
        CameraInteractor cameraInteractor = cameraViewModel.c;
        if (cameraInteractor != null) {
            SurfaceTexture surfaceTexture = cameraViewModel.g;
            Intrinsics.checkNotNull(surfaceTexture);
            Dimension c2 = cameraViewModel.c();
            Rotation rotation = cameraViewModel.u.getRotation();
            Dimension dimension = cameraViewModel.h;
            if (dimension == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previewSize");
            }
            Dimension startPreview = cameraInteractor.startPreview(surfaceTexture, c2, rotation, dimension);
            if (startPreview != null) {
                Dimension dimension2 = cameraViewModel.h;
                if (dimension2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previewSize");
                }
                Dimension increaseByAspectRatio = DimensionsKt.increaseByAspectRatio(dimension2, DimensionsKt.getAspectRatio(startPreview));
                MutableLiveData<ViewState> mutableLiveData = cameraViewModel.l;
                Matrix matrix = new Matrix();
                float width = (float) increaseByAspectRatio.getWidth();
                Dimension dimension3 = cameraViewModel.h;
                if (dimension3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previewSize");
                }
                float width2 = width / ((float) dimension3.getWidth());
                float height = (float) increaseByAspectRatio.getHeight();
                Dimension dimension4 = cameraViewModel.h;
                if (dimension4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previewSize");
                }
                matrix.setScale(width2, height / ((float) dimension4.getHeight()));
                Dimension dimension5 = cameraViewModel.h;
                if (dimension5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previewSize");
                }
                float width3 = ((float) (dimension5.getWidth() - increaseByAspectRatio.getWidth())) / 2.0f;
                Dimension dimension6 = cameraViewModel.h;
                if (dimension6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previewSize");
                }
                matrix.postTranslate(width3, ((float) (dimension6.getHeight() - increaseByAspectRatio.getHeight())) / 2.0f);
                mutableLiveData.setValue(new ViewState.UpdateTextureMatrix(matrix));
            }
            CameraInteractor cameraInteractor2 = cameraViewModel.c;
            if (cameraInteractor2 != null) {
                NormalizedRect access$getDEFAULT_FOCUS_RECT$p = CameraViewModelKt.access$getDEFAULT_FOCUS_RECT$p();
                if (cameraInteractor2.getHasContinuousFocus()) {
                    cameraInteractor2.focusContinuous(access$getDEFAULT_FOCUS_RECT$p);
                }
            }
            CameraInteractor cameraInteractor3 = cameraViewModel.c;
            if (cameraInteractor3 != null) {
                List<FlashMode> availableFlashModes = cameraInteractor3.getAvailableFlashModes();
                cameraViewModel.k = availableFlashModes;
                PhotoPickerViewModel photoPickerViewModel = cameraViewModel.m;
                if (photoPickerViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
                }
                if (!availableFlashModes.contains(photoPickerViewModel.getCurrentFlashMode$photo_picker_release())) {
                    PhotoPickerViewModel photoPickerViewModel2 = cameraViewModel.m;
                    if (photoPickerViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
                    }
                    photoPickerViewModel2.setCurrentFlashMode$photo_picker_release((FlashMode) CollectionsKt___CollectionsKt.first((List<? extends Object>) cameraViewModel.k));
                }
                PhotoPickerViewModel photoPickerViewModel3 = cameraViewModel.m;
                if (photoPickerViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
                }
                cameraViewModel.e(photoPickerViewModel3.getCurrentFlashMode$photo_picker_release());
            }
        }
    }

    public final void allowAccessClicked() {
        if (this.r.shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
            this.r.requestPermissions(1001, "android.permission.CAMERA");
            return;
        }
        PhotoPickerViewModel photoPickerViewModel = this.m;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        photoPickerViewModel.goToSystemSettings();
    }

    public final Dimension c() {
        Dimension dimension = this.h;
        if (dimension == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewSize");
        }
        int width = dimension.getWidth();
        Dimension dimension2 = this.h;
        if (dimension2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewSize");
        }
        return new Dimension(width, (dimension2.getWidth() * 4) / 3);
    }

    public final void cameraModeClicked() {
        this.i = (CameraType) Collections.getNextItem$default(this.j, this.i, false, 2, null);
        closeCamera();
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f = null;
        this.l.setValue(ViewState.NeedToReopenCamera.INSTANCE);
    }

    public final void cancelClicked() {
        PhotoPickerViewModel photoPickerViewModel = this.m;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        photoPickerViewModel.goToGallery();
    }

    public final void captureClicked() {
        CameraInteractor cameraInteractor = this.c;
        if (cameraInteractor != null) {
            this.l.setValue(ViewState.PhotoCaptureStarted.INSTANCE);
            FocusMode focusMode = this.o;
            boolean z = true;
            boolean z2 = focusMode == FocusMode.AUTO_FOCUS;
            if (focusMode != FocusMode.MANUAL_FOCUS) {
                z = false;
            }
            Disposable disposable = this.e;
            if (disposable != null) {
                disposable.dispose();
            }
            this.e = cameraInteractor.takeShot(z2).concatMap(new a(this, cameraInteractor)).subscribe(new b(this, z), new c(this));
        }
    }

    public final void checkCameraPermission() {
        if (!this.r.checkPermission("android.permission.CAMERA")) {
            this.r.requestPermissions(1001, "android.permission.CAMERA");
        }
    }

    public final void closeCamera() {
        CameraInteractor cameraInteractor = this.c;
        if (cameraInteractor != null) {
            cameraInteractor.stopPreview();
        }
        CameraInteractor cameraInteractor2 = this.c;
        if (cameraInteractor2 != null) {
            cameraInteractor2.destroy();
        }
        this.c = null;
    }

    public final void d() {
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.q.getLastTakenImagePreview().subscribeOn(this.s.computation()).observeOn(this.s.mainThread()).subscribe(new d(this), new e(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "galleryInteractor.getLas…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void e(FlashMode flashMode) {
        CameraInteractor cameraInteractor = this.c;
        if (cameraInteractor != null) {
            CompositeDisposable compositeDisposable = this.d;
            Disposable subscribe = cameraInteractor.setFlashMode(flashMode).subscribe(new f(this, flashMode), g.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.setFlashMode(…\", throwable) }\n        )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void flashModeClicked() {
        List<? extends FlashMode> list = this.k;
        PhotoPickerViewModel photoPickerViewModel = this.m;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        FlashMode flashMode = (FlashMode) Collections.getNextItem$default(list, photoPickerViewModel.getCurrentFlashMode$photo_picker_release(), false, 2, null);
        if (flashMode == null) {
            flashMode = FlashMode.Off.INSTANCE;
        }
        e(flashMode);
    }

    public final void galleryClicked() {
        PhotoPickerViewModel photoPickerViewModel = this.m;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        photoPickerViewModel.selectPhotosFromCamera();
        PhotoPickerViewModel photoPickerViewModel2 = this.m;
        if (photoPickerViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        photoPickerViewModel2.goToGallery();
    }

    @NotNull
    public final TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return this.p;
    }

    public final void init(@NotNull PhotoPickerViewModel photoPickerViewModel) {
        Intrinsics.checkNotNullParameter(photoPickerViewModel, "activityViewModel");
        this.m = photoPickerViewModel;
        d();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.e;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.d.clear();
        super.onCleared();
    }

    public final void openCamera(@NotNull SurfaceTexture surfaceTexture, int i2, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        if (this.r.checkPermission("android.permission.CAMERA")) {
            this.o = FocusMode.AUTO_FOCUS;
            this.g = surfaceTexture;
            this.h = new Dimension(i2, i3);
            this.l.setValue(ViewState.HideNoPermission.INSTANCE);
            CameraType cameraType = this.i;
            if (cameraType != null) {
                Disposable disposable = this.f;
                if (disposable != null) {
                    disposable.dispose();
                }
                this.f = this.t.openCamera(cameraType).doOnSuccess(new g1(0, this)).subscribeOn(this.s.io()).observeOn(this.s.mainThread()).subscribe(new g1(1, this));
                return;
            }
            return;
        }
        if (this.r.shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
            i4 = R.string.allow_access;
        } else {
            i4 = R.string.go_to_settings;
        }
        this.l.setValue(new ViewState.ShowNoPermission(i4));
    }

    @NotNull
    public final LiveData<ViewState> screenState() {
        return this.l;
    }

    public final void subscribeToFocusChanges(@NotNull Observable<CameraViewport.FocusArea> observable) {
        Intrinsics.checkNotNullParameter(observable, "touchObservable");
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = observable.subscribe(new h(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "touchObservable.subscrib…}\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
