package com.avito.android.photo_wizard;

import a2.a.a.z1.c;
import a2.a.a.z1.e;
import a2.a.a.z1.f;
import a2.g.r.g;
import android.graphics.SurfaceTexture;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.camera.CameraViewModel;
import com.avito.android.photo_picker.camera.CameraViewport;
import com.avito.android.photo_picker.legacy.CameraInteractor;
import com.avito.android.photo_picker.legacy.CameraOpenInteractor;
import com.avito.android.photo_picker.legacy.CameraType;
import com.avito.android.photo_picker.legacy.FlashMode;
import com.avito.android.photo_wizard.PhotoWizardViewState;
import com.avito.android.photo_wizard.WizardPhotoPickerPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Collections;
import com.avito.android.util.Dimension;
import com.avito.android.util.Rotation;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.funktionale.option.Option;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010u\u001a\u00020r\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010\u001a\u00020|\u0012\u0006\u0010y\u001a\u00020v\u0012\u0006\u0010c\u001a\u00020`¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010\u0004J\u0017\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0002H\u0016¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0002H\u0016¢\u0006\u0004\b,\u0010\u0004J\u000f\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\u0002H\u0016¢\u0006\u0004\b/\u0010\u0004J\u000f\u00100\u001a\u00020\u0002H\u0016¢\u0006\u0004\b0\u0010\u0004R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u00106R(\u0010<\u001a\u0014\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010I\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u00106R\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u00103R\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010_\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010d\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u00106R\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010o\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010q\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bp\u00106R\u0016\u0010u\u001a\u00020r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010y\u001a\u00020v8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010\u001a\u00020|8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenterImpl;", "Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenter;", "", "d", "()V", "", AuthSource.SEND_ABUSE, "()Z", "c", "Lcom/avito/android/photo_picker/legacy/FlashMode;", "flashMode", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/photo_picker/legacy/FlashMode;)V", "Lcom/avito/android/photo_wizard/WizardPhotoPickerView;", "view", "attachView", "(Lcom/avito/android/photo_wizard/WizardPhotoPickerView;)V", "detachView", "Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenter$Router;)V", "detachRouter", "Lcom/avito/android/photo_wizard/PhotoWizardViewModel;", "viewModel", "setViewModel", "(Lcom/avito/android/photo_wizard/PhotoWizardViewModel;)V", "", "title", "updateTitle", "(Ljava/lang/String;)V", "openCamera", "Lcom/avito/android/photo_wizard/PhotoWizardViewState;", "state", "resolveViewState", "(Lcom/avito/android/photo_wizard/PhotoWizardViewState;)V", "closeCamera", "onPermissionsResult", "allowAccessClicked", "Lcom/avito/android/photo_wizard/DocumentType;", "type", "onDocumentTypeClicked", "(Lcom/avito/android/photo_wizard/DocumentType;)V", "onFlashClicked", "onRetakePhotoClicked", "onTakePhotoClicked", "onPhotoActionClicked", "onRetryClicked", "onCloseClicked", "Lcom/avito/android/util/Dimension;", "o", "Lcom/avito/android/util/Dimension;", "captureSize", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "cameraOpenDisposable", "Lkotlin/Function2;", "", "s", "Lkotlin/jvm/functions/Function2;", "surfaceMeasureListener", "Lcom/avito/android/photo_wizard/ActionsState;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/photo_wizard/ActionsState;", "currentActionState", "", "h", "Ljava/util/List;", "flashModes", "Lcom/avito/android/photo_picker/legacy/CameraType$BackCamera;", "j", "Lcom/avito/android/photo_picker/legacy/CameraType$BackCamera;", "cameraType", "takePhotoDisposable", "Lcom/avito/android/photo_wizard/PictureType;", "l", "Lcom/avito/android/photo_wizard/PictureType;", "currentPictureType", "n", "previewSize", "Lcom/avito/android/photo_picker/camera/CameraViewModel$FocusMode;", g.a, "Lcom/avito/android/photo_picker/camera/CameraViewModel$FocusMode;", "focusMode", "Lcom/avito/android/util/SchedulersFactory3;", "u", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/permissions/PermissionHelper;", VKApiConst.VERSION, "Lcom/avito/android/permissions/PermissionHelper;", "permissionHelper", VKApiConst.Q, "Lcom/avito/android/photo_wizard/PhotoWizardViewModel;", "Z", "isFirstPermissionRequest", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "y", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "sharedPhotosStorage", "flashModeDisposable", "Lcom/avito/android/util/Rotation$Rotation_0;", "k", "Lcom/avito/android/util/Rotation$Rotation_0;", "rotation", "Lcom/avito/android/photo_picker/legacy/CameraInteractor;", "f", "Lcom/avito/android/photo_picker/legacy/CameraInteractor;", "cameraInteractor", "i", "Lcom/avito/android/photo_picker/legacy/FlashMode;", "currentFlashMode", "e", "focusDisposable", "Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "t", "Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "openInteractor", "Lcom/avito/android/photo_wizard/PhotoWizardImageResizer;", "x", "Lcom/avito/android/photo_wizard/PhotoWizardImageResizer;", "imageResizer", "r", "Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenter$Router;", "Lcom/avito/android/photo_wizard/PhotoWizardResourceProvider;", "w", "Lcom/avito/android/photo_wizard/PhotoWizardResourceProvider;", "resourceProvider", "p", "Lcom/avito/android/photo_wizard/WizardPhotoPickerView;", "<init>", "(Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/permissions/PermissionHelper;Lcom/avito/android/photo_wizard/PhotoWizardResourceProvider;Lcom/avito/android/photo_wizard/PhotoWizardImageResizer;Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;)V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public final class WizardPhotoPickerPresenterImpl implements WizardPhotoPickerPresenter {
    public boolean a = true;
    public Disposable b;
    public Disposable c;
    public Disposable d;
    public Disposable e;
    public CameraInteractor f;
    public CameraViewModel.FocusMode g = CameraViewModel.FocusMode.AUTO_FOCUS;
    public List<? extends FlashMode> h = CollectionsKt__CollectionsKt.emptyList();
    public FlashMode i = FlashMode.Off.INSTANCE;
    public final CameraType.BackCamera j = CameraType.BackCamera.INSTANCE;
    public final Rotation.Rotation_0 k = new Rotation.Rotation_0();
    public PictureType l = PictureType.VERTICAL;
    public ActionsState m = ActionsState.NEXT;
    public Dimension n = new Dimension(-1, -1);
    public Dimension o = new Dimension(-1, -1);
    public WizardPhotoPickerView p;
    public PhotoWizardViewModel q;
    public WizardPhotoPickerPresenter.Router r;
    public final Function2<Integer, Integer, Unit> s = new b(this);
    public final CameraOpenInteractor t;
    public final SchedulersFactory3 u;
    public final PermissionHelper v;
    public final PhotoWizardResourceProvider w;
    public final PhotoWizardImageResizer x;
    public final SharedPhotosStorage y;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            ActionsState.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
            ActionsState.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
        }
    }

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ WizardPhotoPickerPresenterImpl a;
        public final /* synthetic */ FlashMode b;

        public a(WizardPhotoPickerPresenterImpl wizardPhotoPickerPresenterImpl, FlashMode flashMode) {
            this.a = wizardPhotoPickerPresenterImpl;
            this.b = flashMode;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            int i;
            this.a.i = this.b;
            FlashMode flashMode = this.a.i;
            if (Intrinsics.areEqual(flashMode, FlashMode.Off.INSTANCE)) {
                i = this.a.w.getFlashIconOffResId();
            } else if (Intrinsics.areEqual(flashMode, FlashMode.ForceOn.INSTANCE)) {
                i = this.a.w.getFlashIconOnResId();
            } else if (Intrinsics.areEqual(flashMode, FlashMode.Auto.INSTANCE)) {
                i = this.a.w.getFlashIconAutoResId();
            } else {
                i = this.a.w.getFlashIconOffResId();
            }
            WizardPhotoPickerView wizardPhotoPickerView = this.a.p;
            if (wizardPhotoPickerView != null) {
                wizardPhotoPickerView.setFlashIcon(i);
            }
        }
    }

    public static final class b extends Lambda implements Function2<Integer, Integer, Unit> {
        public final /* synthetic */ WizardPhotoPickerPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(WizardPhotoPickerPresenterImpl wizardPhotoPickerPresenterImpl) {
            super(2);
            this.a = wizardPhotoPickerPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Integer num, Integer num2) {
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            this.a.n = new Dimension(intValue, intValue2);
            WizardPhotoPickerPresenterImpl wizardPhotoPickerPresenterImpl = this.a;
            wizardPhotoPickerPresenterImpl.o = WizardPhotoPickerPresenterImpl.access$calculateCaptureSize(wizardPhotoPickerPresenterImpl, (float) intValue, (float) intValue2);
            WizardPhotoPickerPresenterImpl.access$openCameraInternal(this.a);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public WizardPhotoPickerPresenterImpl(@NotNull CameraOpenInteractor cameraOpenInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull PermissionHelper permissionHelper, @NotNull PhotoWizardResourceProvider photoWizardResourceProvider, @NotNull PhotoWizardImageResizer photoWizardImageResizer, @NotNull SharedPhotosStorage sharedPhotosStorage) {
        Intrinsics.checkNotNullParameter(cameraOpenInteractor, "openInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(permissionHelper, "permissionHelper");
        Intrinsics.checkNotNullParameter(photoWizardResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(photoWizardImageResizer, "imageResizer");
        Intrinsics.checkNotNullParameter(sharedPhotosStorage, "sharedPhotosStorage");
        this.t = cameraOpenInteractor;
        this.u = schedulersFactory3;
        this.v = permissionHelper;
        this.w = photoWizardResourceProvider;
        this.x = photoWizardImageResizer;
        this.y = sharedPhotosStorage;
    }

    public static final Dimension access$calculateCaptureSize(WizardPhotoPickerPresenterImpl wizardPhotoPickerPresenterImpl, float f2, float f3) {
        Objects.requireNonNull(wizardPhotoPickerPresenterImpl);
        if (f2 > f3) {
            return new Dimension(2000, (int) (((float) 2000) * (f3 / f2)));
        }
        return new Dimension((int) (((float) 2000) * (f2 / f3)), 2000);
    }

    public static final Dimension access$calculateFinalPhotoSize(WizardPhotoPickerPresenterImpl wizardPhotoPickerPresenterImpl) {
        if (wizardPhotoPickerPresenterImpl.l == PictureType.HORIZONTAL) {
            return new Dimension(wizardPhotoPickerPresenterImpl.o.getWidth(), (int) (((float) wizardPhotoPickerPresenterImpl.o.getHeight()) * 0.6f));
        }
        return wizardPhotoPickerPresenterImpl.o;
    }

    public static final void access$openCameraInternal(WizardPhotoPickerPresenterImpl wizardPhotoPickerPresenterImpl) {
        if (wizardPhotoPickerPresenterImpl.a()) {
            wizardPhotoPickerPresenterImpl.g = CameraViewModel.FocusMode.AUTO_FOCUS;
            Disposable disposable = wizardPhotoPickerPresenterImpl.c;
            if (disposable != null) {
                disposable.dispose();
            }
            Single<Option<CameraInteractor>> doOnSuccess = wizardPhotoPickerPresenterImpl.t.openCamera(wizardPhotoPickerPresenterImpl.j).doOnSuccess(new a2.a.a.z1.a(wizardPhotoPickerPresenterImpl));
            Intrinsics.checkNotNullExpressionValue(doOnSuccess, "openInteractor.openCamer…      )\n                }");
            wizardPhotoPickerPresenterImpl.c = InteropKt.toV3(doOnSuccess).subscribeOn(wizardPhotoPickerPresenterImpl.u.io()).observeOn(wizardPhotoPickerPresenterImpl.u.mainThread()).subscribe(new a2.a.a.z1.b(wizardPhotoPickerPresenterImpl));
        }
    }

    public final boolean a() {
        return this.v.checkPermission("android.permission.CAMERA") && this.v.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView.Listener
    public void allowAccessClicked() {
        if (this.v.shouldShowRequestPermissionRationale("android.permission.CAMERA") && this.v.shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
            this.v.requestPermissions(1001, "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE");
            return;
        }
        WizardPhotoPickerPresenter.Router router = this.r;
        if (router != null) {
            router.toAppSettings();
        }
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerPresenter
    public void attachRouter(@NotNull WizardPhotoPickerPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.r = router;
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerPresenter
    public void attachView(@NotNull WizardPhotoPickerView wizardPhotoPickerView) {
        Intrinsics.checkNotNullParameter(wizardPhotoPickerView, "view");
        this.p = wizardPhotoPickerView;
        wizardPhotoPickerView.setPhotoWizardViewListener(this);
        this.e = InteropKt.toV3(wizardPhotoPickerView.getFocusObservable()).subscribe(new c(this));
    }

    public final void b(FlashMode flashMode) {
        CameraInteractor cameraInteractor = this.f;
        if (cameraInteractor != null) {
            this.b = InteropKt.toV3(cameraInteractor.setFlashMode(flashMode)).subscribe(new a(this, flashMode));
        }
    }

    public final void c() {
        String str;
        if (this.v.shouldShowRequestPermissionRationale("android.permission.CAMERA") && this.v.shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
            str = this.w.getAllowButtonText();
        } else {
            str = this.w.getSettingsButtonText();
        }
        WizardPhotoPickerView wizardPhotoPickerView = this.p;
        if (wizardPhotoPickerView != null) {
            wizardPhotoPickerView.showPermissionMessage(str);
        }
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerPresenter
    public void closeCamera() {
        CameraInteractor cameraInteractor = this.f;
        if (cameraInteractor != null) {
            cameraInteractor.stopPreview();
            cameraInteractor.destroy();
            this.f = null;
        }
    }

    public final void d() {
        WizardPhotoPickerView wizardPhotoPickerView;
        CameraViewport preview;
        CameraInteractor cameraInteractor = this.f;
        if (cameraInteractor != null && (wizardPhotoPickerView = this.p) != null && (preview = wizardPhotoPickerView.preview()) != null) {
            SurfaceTexture surfaceTexture = preview.getSurfaceTexture();
            Dimension dimension = this.n;
            cameraInteractor.startPreview(surfaceTexture, dimension, this.k, dimension);
            CameraInteractor cameraInteractor2 = this.f;
            if (cameraInteractor2 != null) {
                List<FlashMode> availableFlashModes = cameraInteractor2.getAvailableFlashModes();
                this.h = availableFlashModes;
                if (availableFlashModes.size() != 1 || !Intrinsics.areEqual((FlashMode) this.h.get(0), FlashMode.Off.INSTANCE)) {
                    FlashMode flashMode = (FlashMode) CollectionsKt___CollectionsKt.first((List<? extends Object>) this.h);
                    this.i = flashMode;
                    b(flashMode);
                    return;
                }
                WizardPhotoPickerView wizardPhotoPickerView2 = this.p;
                if (wizardPhotoPickerView2 != null) {
                    wizardPhotoPickerView2.hideFlashIcon();
                }
            }
        }
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerPresenter
    public void detachRouter() {
        this.r = null;
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerPresenter
    public void detachView() {
        WizardPhotoPickerView wizardPhotoPickerView = this.p;
        if (wizardPhotoPickerView != null) {
            wizardPhotoPickerView.setSurfaceMeasureListener(null);
        }
        WizardPhotoPickerView wizardPhotoPickerView2 = this.p;
        if (wizardPhotoPickerView2 != null) {
            wizardPhotoPickerView2.setPhotoWizardViewListener(null);
        }
        this.p = null;
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.c;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.d;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        Disposable disposable4 = this.e;
        if (disposable4 != null) {
            disposable4.dispose();
        }
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView.Listener
    public void onCloseClicked() {
        PhotoWizardViewModel photoWizardViewModel = this.q;
        if (photoWizardViewModel != null) {
            photoWizardViewModel.onCloseClicked();
        }
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView.Listener
    public void onDocumentTypeClicked(@NotNull DocumentType documentType) {
        Intrinsics.checkNotNullParameter(documentType, "type");
        PhotoWizardViewModel photoWizardViewModel = this.q;
        if (photoWizardViewModel != null) {
            photoWizardViewModel.onTypeClicked(documentType);
        }
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView.Listener
    public void onFlashClicked() {
        FlashMode flashMode = (FlashMode) Collections.getNextItem$default(this.h, this.i, false, 2, null);
        if (flashMode == null) {
            flashMode = FlashMode.Off.INSTANCE;
        }
        b(flashMode);
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerPresenter
    public void onPermissionsResult() {
        this.a = false;
        if (!a()) {
            c();
            return;
        }
        WizardPhotoPickerView wizardPhotoPickerView = this.p;
        if (wizardPhotoPickerView != null) {
            wizardPhotoPickerView.hideNoPermission();
        }
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView.Listener
    public void onPhotoActionClicked() {
        PhotoWizardViewModel photoWizardViewModel = this.q;
        if (photoWizardViewModel != null) {
            int ordinal = this.m.ordinal();
            if (ordinal == 0) {
                photoWizardViewModel.onNextClicked();
            } else if (ordinal == 1) {
                photoWizardViewModel.onDoneClicked();
            }
        }
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView.Listener
    public void onRetakePhotoClicked() {
        PhotoWizardViewModel photoWizardViewModel = this.q;
        if (photoWizardViewModel != null) {
            photoWizardViewModel.onRetakeShotClicked();
        }
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView.Listener
    public void onRetryClicked() {
        PhotoWizardViewModel photoWizardViewModel = this.q;
        if (photoWizardViewModel != null) {
            photoWizardViewModel.onDoneClicked();
        }
        WizardPhotoPickerView wizardPhotoPickerView = this.p;
        if (wizardPhotoPickerView != null) {
            wizardPhotoPickerView.fadeTakenPhoto(false);
        }
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView.Listener
    public void onTakePhotoClicked() {
        CameraInteractor cameraInteractor;
        if (a() && (cameraInteractor = this.f) != null) {
            WizardPhotoPickerView wizardPhotoPickerView = this.p;
            if (wizardPhotoPickerView != null) {
                wizardPhotoPickerView.disablePreviewControls();
            }
            boolean z = this.g == CameraViewModel.FocusMode.AUTO_FOCUS;
            Disposable disposable = this.d;
            if (disposable != null) {
                disposable.dispose();
            }
            this.d = InteropKt.toV3(cameraInteractor.takeShot(z)).flatMap(new e(this)).subscribeOn(this.u.io()).observeOn(this.u.mainThread()).subscribe(new f(this), new a2.a.a.z1.g(this));
        }
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerPresenter
    public void openCamera() {
        WizardPhotoPickerView wizardPhotoPickerView = this.p;
        if (wizardPhotoPickerView == null) {
            return;
        }
        if (a()) {
            wizardPhotoPickerView.hideNoPermission();
            if (wizardPhotoPickerView.preview().isTextureAvailable()) {
                Dimension fullPreviewSize = wizardPhotoPickerView.getFullPreviewSize();
                this.s.invoke(Integer.valueOf(fullPreviewSize.getWidth()), Integer.valueOf(fullPreviewSize.getHeight()));
                return;
            }
            wizardPhotoPickerView.setSurfaceMeasureListener(this.s);
        } else if (this.a) {
            this.v.requestPermissions(1001, "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE");
        } else {
            c();
        }
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerPresenter
    public void resolveViewState(@NotNull PhotoWizardViewState photoWizardViewState) {
        Intrinsics.checkNotNullParameter(photoWizardViewState, "state");
        WizardPhotoPickerView wizardPhotoPickerView = this.p;
        if (wizardPhotoPickerView == null) {
            return;
        }
        if (photoWizardViewState instanceof PhotoWizardViewState.TakePicture) {
            PhotoWizardViewState.TakePicture takePicture = (PhotoWizardViewState.TakePicture) photoWizardViewState;
            this.l = takePicture.getPictureType();
            d();
            wizardPhotoPickerView.showPreview(takePicture.getHint(), takePicture.getMaskResId(), takePicture.getTypes(), takePicture.getPictureType());
        } else if (photoWizardViewState instanceof PhotoWizardViewState.Picture) {
            PhotoWizardViewState.Picture picture = (PhotoWizardViewState.Picture) photoWizardViewState;
            this.m = picture.getActionsState();
            int ordinal = picture.getActionsState().ordinal();
            if (ordinal == 0) {
                wizardPhotoPickerView.showTakenPhoto(picture.getUri(), this.w.getActionNext());
            } else if (ordinal == 1) {
                wizardPhotoPickerView.showTakenPhoto(picture.getUri(), this.w.getActionDone());
            } else if (ordinal == 2) {
                wizardPhotoPickerView.showLoading();
            } else if (ordinal == 3) {
                wizardPhotoPickerView.showError();
                wizardPhotoPickerView.fadeTakenPhoto(true);
            }
        }
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerPresenter
    public void setViewModel(@NotNull PhotoWizardViewModel photoWizardViewModel) {
        Intrinsics.checkNotNullParameter(photoWizardViewModel, "viewModel");
        this.q = photoWizardViewModel;
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerPresenter
    public void updateTitle(@Nullable String str) {
        WizardPhotoPickerView wizardPhotoPickerView = this.p;
        if (wizardPhotoPickerView != null) {
            wizardPhotoPickerView.setTitle(str);
        }
    }
}
