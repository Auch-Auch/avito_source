package com.avito.android.photo_picker.legacy.details_list;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.TextureView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.permissions.PermissionResultHandler;
import com.avito.android.photo_picker.legacy.CameraInteractor;
import com.avito.android.photo_picker.legacy.CameraOpenInteractor;
import com.avito.android.photo_picker.legacy.CameraPresenterResourceProvider;
import com.avito.android.photo_picker.legacy.CameraPresenterState;
import com.avito.android.photo_picker.legacy.CameraType;
import com.avito.android.photo_picker.legacy.DescriptionProvider;
import com.avito.android.photo_picker.legacy.FlashMode;
import com.avito.android.photo_picker.legacy.GalleryInteractor;
import com.avito.android.photo_picker.legacy.OnPhotoSourcesAvailableChangeListener;
import com.avito.android.photo_picker.legacy.PhotoResizer;
import com.avito.android.photo_picker.legacy.PhotoSource;
import com.avito.android.photo_picker.legacy.RotationInteractor;
import com.avito.android.photo_picker.legacy.RotationProvider;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter;
import com.avito.android.photo_picker.legacy.thumbnail_list.BasePhotoItem;
import com.avito.android.photo_picker.legacy.thumbnail_list.ResourcePhotoItem;
import com.avito.android.recycler.responsive.ResponsiveItemPresenterRegistry;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Collections;
import com.avito.android.util.Dimension;
import com.avito.android.util.DimensionsKt;
import com.avito.android.util.Flowables;
import com.avito.android.util.NormalizedRect;
import com.avito.android.util.Observables;
import com.avito.android.util.Rotation;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.subjects.ReplaySubject;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.funktionale.option.Option;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B¦\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010v\u001a\u00020s\u0012\u0010\u0010\u0001\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u00010\u0012\u0006\u0010W\u001a\u00020T\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0007\u0010\u0001\u001a\u00020\u0017\u0012\u0007\u0010£\u0001\u001a\u00020\n\u0012\u0006\u0010n\u001a\u00020\u000e\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010z\u001a\u00020w\u0012\u0006\u0010~\u001a\u00020{\u0012\u0006\u0010k\u001a\u00020h\u0012\u0006\u0010c\u001a\u00020`\u0012\u0006\u0010P\u001a\u00020M\u0012\t\u0010¤\u0001\u001a\u0004\u0018\u00010,¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\tJ\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\tJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\tJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\tJ\u0017\u0010!\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\u0007J'\u0010!\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b!\u0010&J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\tJ\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\tJ\u000f\u0010)\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010\tJ\u000f\u0010*\u001a\u00020\u0005H\u0016¢\u0006\u0004\b*\u0010\tJ\u000f\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010\tJ\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0005H\u0016¢\u0006\u0004\b3\u0010\tJ\u001f\u00104\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b6\u00105J\u000f\u00107\u001a\u00020\u0005H\u0016¢\u0006\u0004\b7\u0010\tJ\u000f\u00108\u001a\u00020\u0005H\u0016¢\u0006\u0004\b8\u0010\tJ.\u0010?\u001a\u00020\u00052\u0006\u00109\u001a\u00020$2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:2\u0006\u0010>\u001a\u00020=H\u0001¢\u0006\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010IR\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\n0J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010XR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010lR\u0016\u0010n\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010RR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010~\u001a\u00020{8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\"\u0010\u0001\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u000108\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\f\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0018\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020d8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010fR\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130J8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010KR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R!\u0010¢\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001¨\u0006§\u0001"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenterImpl;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", "Lcom/avito/android/permissions/PermissionResultHandler;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView;", "view", "", AuthSource.SEND_ABUSE, "(Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView;)V", "h", "()V", "Lcom/avito/android/photo_picker/legacy/CameraType;", "cameraType", "c", "(Lcom/avito/android/photo_picker/legacy/CameraType;)V", "", "d", "()Z", "f", a2.g.r.g.a, "Lcom/avito/android/photo_picker/legacy/FlashMode;", "flashMode", "e", "(Lcom/avito/android/photo_picker/legacy/FlashMode;)V", "Lcom/avito/android/util/Dimension;", AuthSource.BOOKING_ORDER, "()Lcom/avito/android/util/Dimension;", "startPreview", "onTakeShotClicked", "Lcom/avito/android/photo_picker/legacy/OnPhotoSourcesAvailableChangeListener;", "photoSourcesChangeListener", "setPhotoSourcesChangeListener", "(Lcom/avito/android/photo_picker/legacy/OnPhotoSourcesAvailableChangeListener;)V", "initialize", "bindView", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;", "item", "", VKApiConst.POSITION, "(Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView;Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;I)V", "uninitialize", "onScreenLeaved", "onFlashToggleClicked", "onCameraToggleClicked", "onGalleryClicked", "Lcom/avito/android/photo_picker/legacy/CameraPresenterState;", "getState", "()Lcom/avito/android/photo_picker/legacy/CameraPresenterState;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Router;)V", "detachRouter", "viewAttached", "(Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView;I)V", "viewDetached", "detachViewWithSurface", "onAllowCameraAccessClicked", "requestCode", "", "", "permissions", "", "grantResults", "onPermissionResult", "(I[Ljava/lang/String;[I)V", "Lcom/avito/android/photo_picker/legacy/RotationInteractor;", "r", "Lcom/avito/android/photo_picker/legacy/RotationInteractor;", "rotationInteractor", "Lcom/avito/android/photo_picker/legacy/CameraPresenterResourceProvider;", "y", "Lcom/avito/android/photo_picker/legacy/CameraPresenterResourceProvider;", "resourceProvider", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView;", "", "Ljava/util/List;", "availableCameras", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "D", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "sharedPhotosStorage", "o", "Z", "shotInProgress", "Lcom/avito/android/util/SchedulersFactory;", "u", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Router;", "Landroid/view/TextureView$SurfaceTextureListener;", "k", "Landroid/view/TextureView$SurfaceTextureListener;", "surfaceCallback", "Lcom/avito/android/photo_picker/legacy/CameraInteractor;", "Lcom/avito/android/photo_picker/legacy/CameraInteractor;", "cameraInteractor", "Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "C", "Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "photoResizer", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/disposables/CompositeDisposable;", "permissionSubscriptions", "Lcom/avito/android/photo_picker/legacy/DescriptionProvider;", "B", "Lcom/avito/android/photo_picker/legacy/DescriptionProvider;", "descriptionProvider", "Lcom/avito/android/photo_picker/legacy/OnPhotoSourcesAvailableChangeListener;", "x", "allowMultipleSelection", "Lio/reactivex/disposables/Disposable;", "n", "Lio/reactivex/disposables/Disposable;", "cameraOpenSubscription", "Lcom/avito/android/photo_picker/legacy/RotationProvider;", "s", "Lcom/avito/android/photo_picker/legacy/RotationProvider;", "rotationProvider", "Lcom/avito/android/analytics/Analytics;", "z", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/recycler/responsive/ResponsiveItemPresenterRegistry;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/recycler/responsive/ResponsiveItemPresenterRegistry;", "registry", "Ldagger/Lazy;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Listener;", "t", "Ldagger/Lazy;", "newPhotoListener", "Lcom/avito/android/photo_picker/legacy/FlashMode;", "currentFlashMode", "Lcom/avito/android/util/Rotation;", "i", "Lcom/avito/android/util/Rotation;", "rotation", "Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "p", "Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "cameraOpenInteractor", "Lcom/avito/android/photo_picker/legacy/GalleryInteractor;", VKApiConst.Q, "Lcom/avito/android/photo_picker/legacy/GalleryInteractor;", "galleryInteractor", "Lcom/avito/android/photo_picker/legacy/CameraType;", "currentCamera", "w", "Lcom/avito/android/util/Dimension;", "pictureSize", "l", "subscriptions", "availableFlashModes", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPermissionHandler;", VKApiConst.VERSION, "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPermissionHandler;", "permissionHandler", "Lio/reactivex/subjects/ReplaySubject;", "Landroid/graphics/SurfaceTexture;", "j", "Lio/reactivex/subjects/ReplaySubject;", "surfaceSubject", "startCamera", "state", "<init>", "(Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;Lcom/avito/android/photo_picker/legacy/GalleryInteractor;Lcom/avito/android/photo_picker/legacy/RotationInteractor;Lcom/avito/android/photo_picker/legacy/RotationProvider;Ldagger/Lazy;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPermissionHandler;Lcom/avito/android/util/Dimension;Lcom/avito/android/photo_picker/legacy/CameraType;ZLcom/avito/android/photo_picker/legacy/CameraPresenterResourceProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/recycler/responsive/ResponsiveItemPresenterRegistry;Lcom/avito/android/photo_picker/legacy/DescriptionProvider;Lcom/avito/android/photo_picker/legacy/PhotoResizer;Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;Lcom/avito/android/photo_picker/legacy/CameraPresenterState;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class CameraItemPresenterImpl implements CameraItemPresenter, PermissionResultHandler {
    public final ResponsiveItemPresenterRegistry A;
    public final DescriptionProvider B;
    public final PhotoResizer C;
    public final SharedPhotosStorage D;
    public CameraItemView a;
    public CameraType b;
    public FlashMode c;
    public CameraItemPresenter.Router d;
    public CameraInteractor e;
    public final List<CameraType> f;
    public List<? extends FlashMode> g = CollectionsKt__CollectionsKt.emptyList();
    public OnPhotoSourcesAvailableChangeListener h;
    public Rotation i = new Rotation.Rotation_0();
    public ReplaySubject<SurfaceTexture> j;
    public final TextureView.SurfaceTextureListener k;
    public final CompositeDisposable l;
    public final CompositeDisposable m;
    public Disposable n;
    public boolean o;
    public final CameraOpenInteractor p;
    public final GalleryInteractor q;
    public final RotationInteractor r;
    public final RotationProvider s;
    public final Lazy<? extends CameraItemPresenter.Listener> t;
    public final SchedulersFactory u;
    public final CameraItemPermissionHandler v;
    public final Dimension w;
    public final boolean x;
    public final CameraPresenterResourceProvider y;
    public final Analytics z;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Option<? extends CameraInteractor>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Option<? extends CameraInteractor> option) {
            int i = this.a;
            if (i == 0) {
                CameraInteractor cameraInteractor = (CameraInteractor) option.orNull();
                if (cameraInteractor != null) {
                    cameraInteractor.prepareCamera(((CameraItemPresenterImpl) this.b).s.getRotation(), ((CameraItemPresenterImpl) this.b).b());
                }
            } else if (i == 1) {
                Option<? extends CameraInteractor> option2 = option;
                if (option2.isEmpty()) {
                    CameraItemView cameraItemView = ((CameraItemPresenterImpl) this.b).a;
                    if (cameraItemView != null) {
                        cameraItemView.showNoCameraPlaceHolder();
                    }
                } else {
                    CameraItemView cameraItemView2 = ((CameraItemPresenterImpl) this.b).a;
                    if (cameraItemView2 != null) {
                        cameraItemView2.hideCameraPlaceholders();
                    }
                    ((CameraItemPresenterImpl) this.b).e = (CameraInteractor) option2.orNull();
                }
                CameraItemView cameraItemView3 = ((CameraItemPresenterImpl) this.b).a;
                if (cameraItemView3 != null) {
                    cameraItemView3.ensureKeyboardHidden();
                }
            } else {
                throw null;
            }
        }
    }

    public final class b implements TextureView.SurfaceTextureListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surfaceTexture, int i, int i2) {
            Intrinsics.checkNotNullParameter(surfaceTexture, "surface");
            CameraItemPresenterImpl.this.j.onNext(surfaceTexture);
            CameraItemPresenterImpl.this.j.onComplete();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@Nullable SurfaceTexture surfaceTexture) {
            CameraItemView cameraItemView;
            CameraItemPresenterImpl cameraItemPresenterImpl = CameraItemPresenterImpl.this;
            ReplaySubject create = ReplaySubject.create();
            Intrinsics.checkNotNullExpressionValue(create, "ReplaySubject.create()");
            cameraItemPresenterImpl.j = create;
            if (!(CameraItemPresenterImpl.this.e == null || (cameraItemView = CameraItemPresenterImpl.this.a) == null)) {
                cameraItemView.setPreviewStubImageVisibility(true);
            }
            CameraInteractor cameraInteractor = CameraItemPresenterImpl.this.e;
            if (cameraInteractor != null) {
                cameraInteractor.stopPreview();
            }
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@Nullable SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@Nullable SurfaceTexture surfaceTexture) {
        }
    }

    public static final class c extends Lambda implements Function1<Rotation, Unit> {
        public final /* synthetic */ CameraItemPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(CameraItemPresenterImpl cameraItemPresenterImpl) {
            super(1);
            this.a = cameraItemPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Rotation rotation) {
            Rotation rotation2 = rotation;
            Intrinsics.checkNotNullParameter(rotation2, "rotation");
            CameraItemPresenterImpl.access$onRotationChanged(this.a, rotation2);
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Consumer<SurfaceTexture> {
        public final /* synthetic */ CameraItemPresenterImpl a;

        public d(CameraItemPresenterImpl cameraItemPresenterImpl) {
            this.a = cameraItemPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(SurfaceTexture surfaceTexture) {
            SurfaceTexture surfaceTexture2 = surfaceTexture;
            CameraItemPresenterImpl cameraItemPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(surfaceTexture2, "it");
            CameraItemPresenterImpl.access$startPreview(cameraItemPresenterImpl, surfaceTexture2);
            CameraItemPresenterImpl.access$startFocus(this.a);
        }
    }

    public static final class e extends Lambda implements Function1<SurfaceTexture, Unit> {
        public final /* synthetic */ CameraItemPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(CameraItemPresenterImpl cameraItemPresenterImpl) {
            super(1);
            this.a = cameraItemPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SurfaceTexture surfaceTexture) {
            CameraItemPresenterImpl.access$initFlashModes(this.a);
            CameraItemPresenterImpl.access$updateToggleState(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CameraItemPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(CameraItemPresenterImpl cameraItemPresenterImpl) {
            super(0);
            this.a = cameraItemPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            CameraItemPresenter.Router router = this.a.d;
            if (router != null) {
                router.openAppSettings();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CameraItemPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(CameraItemPresenterImpl cameraItemPresenterImpl) {
            super(0);
            this.a = cameraItemPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            CameraItemView cameraItemView = this.a.a;
            if (cameraItemView != null) {
                cameraItemView.showMessage(this.a.y.getAllowStorage(), this.a.y.getSettingsButton(), new a2.a.a.x1.q.m.d(this));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class h<T> implements Consumer<Unit> {
        public final /* synthetic */ CameraItemPresenterImpl a;
        public final /* synthetic */ FlashMode b;
        public final /* synthetic */ CameraItemView c;

        public h(CameraItemPresenterImpl cameraItemPresenterImpl, FlashMode flashMode, CameraItemView cameraItemView) {
            this.a = cameraItemPresenterImpl;
            this.b = flashMode;
            this.c = cameraItemView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.c = this.b;
            FlashMode flashMode = this.a.c;
            if (Intrinsics.areEqual(flashMode, FlashMode.Off.INSTANCE)) {
                this.c.setFlashToggleButtonSrcOff();
            } else if (Intrinsics.areEqual(flashMode, FlashMode.ForceOn.INSTANCE)) {
                this.c.setFlashToggleButtonSrcOn();
            } else if (Intrinsics.areEqual(flashMode, FlashMode.Auto.INSTANCE)) {
                this.c.setFlashToggleButtonSrcAuto();
            }
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public final /* synthetic */ CameraItemPresenterImpl a;

        public i(CameraItemPresenterImpl cameraItemPresenterImpl) {
            this.a = cameraItemPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.z.track(new NonFatalError("error", th, null, 4, null));
        }
    }

    public static final class j extends Lambda implements Function1<SurfaceTexture, Unit> {
        public final /* synthetic */ CameraItemPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(CameraItemPresenterImpl cameraItemPresenterImpl) {
            super(1);
            this.a = cameraItemPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SurfaceTexture surfaceTexture) {
            SurfaceTexture surfaceTexture2 = surfaceTexture;
            CameraItemPresenterImpl cameraItemPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(surfaceTexture2, "it");
            CameraItemPresenterImpl.access$startPreview(cameraItemPresenterImpl, surfaceTexture2);
            return Unit.INSTANCE;
        }
    }

    public CameraItemPresenterImpl(@NotNull CameraOpenInteractor cameraOpenInteractor, @NotNull GalleryInteractor galleryInteractor, @NotNull RotationInteractor rotationInteractor, @NotNull RotationProvider rotationProvider, @NotNull Lazy<? extends CameraItemPresenter.Listener> lazy, @NotNull SchedulersFactory schedulersFactory, @NotNull CameraItemPermissionHandler cameraItemPermissionHandler, @NotNull Dimension dimension, @NotNull CameraType cameraType, boolean z2, @NotNull CameraPresenterResourceProvider cameraPresenterResourceProvider, @NotNull Analytics analytics, @NotNull ResponsiveItemPresenterRegistry responsiveItemPresenterRegistry, @NotNull DescriptionProvider descriptionProvider, @NotNull PhotoResizer photoResizer, @NotNull SharedPhotosStorage sharedPhotosStorage, @Nullable CameraPresenterState cameraPresenterState) {
        FlashMode flashMode;
        Intrinsics.checkNotNullParameter(cameraOpenInteractor, "cameraOpenInteractor");
        Intrinsics.checkNotNullParameter(galleryInteractor, "galleryInteractor");
        Intrinsics.checkNotNullParameter(rotationInteractor, "rotationInteractor");
        Intrinsics.checkNotNullParameter(rotationProvider, "rotationProvider");
        Intrinsics.checkNotNullParameter(lazy, "newPhotoListener");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(cameraItemPermissionHandler, "permissionHandler");
        Intrinsics.checkNotNullParameter(dimension, "pictureSize");
        Intrinsics.checkNotNullParameter(cameraType, "startCamera");
        Intrinsics.checkNotNullParameter(cameraPresenterResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(responsiveItemPresenterRegistry, "registry");
        Intrinsics.checkNotNullParameter(descriptionProvider, "descriptionProvider");
        Intrinsics.checkNotNullParameter(photoResizer, "photoResizer");
        Intrinsics.checkNotNullParameter(sharedPhotosStorage, "sharedPhotosStorage");
        this.p = cameraOpenInteractor;
        this.q = galleryInteractor;
        this.r = rotationInteractor;
        this.s = rotationProvider;
        this.t = lazy;
        this.u = schedulersFactory;
        this.v = cameraItemPermissionHandler;
        this.w = dimension;
        this.x = z2;
        this.y = cameraPresenterResourceProvider;
        this.z = analytics;
        this.A = responsiveItemPresenterRegistry;
        this.B = descriptionProvider;
        this.C = photoResizer;
        this.D = sharedPhotosStorage;
        FlashMode flashMode2 = FlashMode.Off.INSTANCE;
        this.c = flashMode2;
        List<CameraType> availableCameras = cameraOpenInteractor.getAvailableCameras();
        this.f = availableCameras;
        ReplaySubject<SurfaceTexture> create = ReplaySubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "ReplaySubject.create()");
        this.j = create;
        this.k = new b();
        this.l = new CompositeDisposable();
        this.m = new CompositeDisposable();
        if (cameraPresenterState != null) {
            this.b = cameraPresenterState.getCameraType();
        } else if (availableCameras.contains(cameraType)) {
            this.b = cameraType;
        } else if (availableCameras.size() != 0) {
            this.b = CameraType.BackCamera.INSTANCE;
        } else {
            this.b = null;
        }
        if (!(cameraPresenterState == null || (flashMode = cameraPresenterState.getFlashMode()) == null)) {
            flashMode2 = flashMode;
        }
        this.c = flashMode2;
    }

    public static final void access$initCameraIfFirstTime(CameraItemPresenterImpl cameraItemPresenterImpl) {
        if (cameraItemPresenterImpl.d()) {
            cameraItemPresenterImpl.c(cameraItemPresenterImpl.b);
            if (cameraItemPresenterImpl.B.isEnable()) {
                CameraItemView cameraItemView = cameraItemPresenterImpl.a;
                if (cameraItemView != null) {
                    cameraItemView.setDescription(cameraItemPresenterImpl.B.getDescription());
                }
                CompositeDisposable compositeDisposable = cameraItemPresenterImpl.l;
                Disposable subscribe = cameraItemPresenterImpl.B.hideObservable().subscribeOn(cameraItemPresenterImpl.u.computation()).observeOn(cameraItemPresenterImpl.u.mainThread()).subscribe(new a2.a.a.x1.q.m.a(cameraItemPresenterImpl));
                Intrinsics.checkNotNullExpressionValue(subscribe, "descriptionProvider.hide…view?.hideDescription() }");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            }
        }
    }

    public static final void access$initFlashModes(CameraItemPresenterImpl cameraItemPresenterImpl) {
        CameraInteractor cameraInteractor = cameraItemPresenterImpl.e;
        if (cameraInteractor != null) {
            List<FlashMode> availableFlashModes = cameraInteractor.getAvailableFlashModes();
            cameraItemPresenterImpl.g = availableFlashModes;
            if (!availableFlashModes.contains(cameraItemPresenterImpl.c)) {
                cameraItemPresenterImpl.c = (FlashMode) CollectionsKt___CollectionsKt.first((List<? extends Object>) cameraItemPresenterImpl.g);
            }
            cameraItemPresenterImpl.e(cameraItemPresenterImpl.c);
        }
    }

    public static final void access$initGalleryButton(CameraItemPresenterImpl cameraItemPresenterImpl) {
        CompositeDisposable compositeDisposable = cameraItemPresenterImpl.l;
        Disposable subscribe = cameraItemPresenterImpl.q.getLastTakenImagePreview().subscribeOn(cameraItemPresenterImpl.u.computation()).observeOn(cameraItemPresenterImpl.u.mainThread()).subscribe(new a2.a.a.x1.q.m.b(cameraItemPresenterImpl), new a2.a.a.x1.q.m.c(cameraItemPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "galleryInteractor.getLas…ailable() }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$onRotationChanged(CameraItemPresenterImpl cameraItemPresenterImpl, Rotation rotation) {
        CameraItemView cameraItemView;
        cameraItemPresenterImpl.i = rotation;
        if ((!Intrinsics.areEqual(rotation, new Rotation.Rotation_180())) && (cameraItemView = cameraItemPresenterImpl.a) != null) {
            cameraItemView.rotateUi(rotation);
        }
    }

    public static final void access$onShotCompleted(CameraItemPresenterImpl cameraItemPresenterImpl, Uri uri) {
        CameraItemView cameraItemView = cameraItemPresenterImpl.a;
        if (cameraItemView != null) {
            cameraItemView.startCameraShotAnimation();
        }
        ((CameraItemPresenter.Listener) cameraItemPresenterImpl.t.get()).onNewPhotos(t6.n.d.listOf(uri), PhotoSource.CAMERA);
        cameraItemPresenterImpl.o = false;
        CameraItemView cameraItemView2 = cameraItemPresenterImpl.a;
        if (cameraItemView2 != null) {
            cameraItemView2.setTakeShotButtonAvailability(true);
        }
        cameraItemPresenterImpl.f();
    }

    public static final void access$onShotError(CameraItemPresenterImpl cameraItemPresenterImpl, Throwable th) {
        Objects.requireNonNull(cameraItemPresenterImpl);
        if (th instanceof SharedPhotosStorage.CantSaveToSharedVolumeException) {
            CameraItemView cameraItemView = cameraItemPresenterImpl.a;
            if (cameraItemView != null) {
                cameraItemView.showMessage(cameraItemPresenterImpl.y.getNoPlaceForSnapshot());
            }
        } else {
            CameraItemView cameraItemView2 = cameraItemPresenterImpl.a;
            if (cameraItemView2 != null) {
                cameraItemView2.showMessage(cameraItemPresenterImpl.y.getUnknownError());
            }
        }
        cameraItemPresenterImpl.o = false;
        CameraItemView cameraItemView3 = cameraItemPresenterImpl.a;
        if (cameraItemView3 != null) {
            cameraItemView3.setTakeShotButtonAvailability(true);
        }
        cameraItemPresenterImpl.f();
        cameraItemPresenterImpl.z.track(new NonFatalError("error", th, null, 4, null));
    }

    public static final void access$setPhotoSourcesChanged(CameraItemPresenterImpl cameraItemPresenterImpl, boolean z2) {
        OnPhotoSourcesAvailableChangeListener onPhotoSourcesAvailableChangeListener = cameraItemPresenterImpl.h;
        if (onPhotoSourcesAvailableChangeListener != null) {
            onPhotoSourcesAvailableChangeListener.onPhotoSourcesChanged(z2);
        }
        CameraItemView cameraItemView = cameraItemPresenterImpl.a;
        if (cameraItemView != null) {
            cameraItemView.setPlaceholdersBackground(z2);
        }
    }

    public static final void access$startFocus(CameraItemPresenterImpl cameraItemPresenterImpl) {
        CameraInteractor cameraInteractor = cameraItemPresenterImpl.e;
        if (cameraInteractor != null) {
            NormalizedRect access$getDEFAULT_FOCUS_RECT$p = CameraItemPresenterKt.access$getDEFAULT_FOCUS_RECT$p();
            if (cameraInteractor.getHasContinuousFocus()) {
                cameraInteractor.focusContinuous(access$getDEFAULT_FOCUS_RECT$p);
            }
        }
    }

    public static final void access$startPreview(CameraItemPresenterImpl cameraItemPresenterImpl, SurfaceTexture surfaceTexture) {
        Dimension desiredPreviewSize;
        CameraItemView cameraItemView = cameraItemPresenterImpl.a;
        if (cameraItemView != null && cameraItemView.getPreviewSurface().isAvailable()) {
            if (cameraItemPresenterImpl.d()) {
                cameraItemPresenterImpl.c(cameraItemPresenterImpl.b);
                return;
            }
            Dimension desiredPreviewSize2 = cameraItemView.getDesiredPreviewSize();
            cameraItemView.setPreviewStubImageVisibility(false);
            CameraInteractor cameraInteractor = cameraItemPresenterImpl.e;
            if (cameraInteractor != null) {
                Dimension startPreview = cameraInteractor.startPreview(surfaceTexture, desiredPreviewSize2, cameraItemPresenterImpl.s.getRotation(), cameraItemView.getDesiredPreviewSize());
                CameraItemView cameraItemView2 = cameraItemPresenterImpl.a;
                if (cameraItemView2 != null && (desiredPreviewSize = cameraItemView2.getDesiredPreviewSize()) != null && startPreview != null) {
                    Dimension increaseByAspectRatio = DimensionsKt.increaseByAspectRatio(desiredPreviewSize, DimensionsKt.getAspectRatio(startPreview));
                    CameraItemView cameraItemView3 = cameraItemPresenterImpl.a;
                    if (cameraItemView3 != null) {
                        cameraItemView3.setPreviewSize(increaseByAspectRatio);
                    }
                }
            }
        }
    }

    public static final void access$updateEnablePermissionsButtonText(CameraItemPresenterImpl cameraItemPresenterImpl, boolean z2) {
        if (z2) {
            CameraItemView cameraItemView = cameraItemPresenterImpl.a;
            if (cameraItemView != null) {
                cameraItemView.setEnablePermissionsButtonText(cameraItemPresenterImpl.y.getAllowAccess());
                return;
            }
            return;
        }
        CameraItemView cameraItemView2 = cameraItemPresenterImpl.a;
        if (cameraItemView2 != null) {
            cameraItemView2.setEnablePermissionsButtonText(cameraItemPresenterImpl.y.getGoToSettings());
        }
    }

    public static final void access$updateToggleState(CameraItemPresenterImpl cameraItemPresenterImpl) {
        CameraItemView cameraItemView = cameraItemPresenterImpl.a;
        if (cameraItemView != null) {
            boolean z2 = false;
            cameraItemView.setCameraToggleAvailability(cameraItemPresenterImpl.f.size() > 1);
            if (cameraItemPresenterImpl.g.size() > 1) {
                z2 = true;
            }
            cameraItemView.setFlashToggleAvailability(z2);
        }
    }

    public final void a(CameraItemView cameraItemView) {
        this.a = cameraItemView;
        cameraItemView.getPreviewSurface().setSurfaceTextureListener(this.k);
        if (this.b == null) {
            cameraItemView.setCameraToggleAvailability(false);
            cameraItemView.setFlashToggleAvailability(false);
            cameraItemView.showNoCameraPlaceHolder();
        }
        DisposableKt.plusAssign(this.l, Flowables.subscribeOnNext(this.r.getRotationFlowable(), new c(this)));
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter
    public void attachRouter(@NotNull CameraItemPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.d = router;
    }

    public final Dimension b() {
        Dimension dimension;
        Dimension desiredPreviewSize;
        CameraItemView cameraItemView = this.a;
        Dimension rotate = (cameraItemView == null || (desiredPreviewSize = cameraItemView.getDesiredPreviewSize()) == null) ? null : DimensionsKt.rotate(desiredPreviewSize, this.i.getDegree());
        Dimension dimension2 = this.w;
        Rotation rotation = this.i;
        boolean z2 = (rotation instanceof Rotation.Rotation_90) || (rotation instanceof Rotation.Rotation_270);
        boolean z3 = !z2;
        if ((dimension2.getWidth() <= dimension2.getHeight() || !z3) && (dimension2.getHeight() <= dimension2.getWidth() || !z2)) {
            dimension = new Dimension(dimension2.getWidth(), dimension2.getHeight());
        } else {
            dimension = new Dimension(dimension2.getHeight(), dimension2.getWidth());
        }
        return rotate != null ? DimensionsKt.cutByAspectRatio(dimension, DimensionsKt.getAspectRatio(rotate)) : dimension;
    }

    public final void c(CameraType cameraType) {
        if (cameraType != null) {
            CameraItemView cameraItemView = this.a;
            if (cameraItemView != null) {
                cameraItemView.setFlashToggleAvailability(false);
                cameraItemView.setCameraToggleAvailability(false);
            }
            h();
            Observable<Option<CameraInteractor>> observable = this.p.openCamera(cameraType).doOnSuccess(new a(0, this)).subscribeOn(this.u.io()).observeOn(this.u.mainThread()).doOnSuccess(new a(1, this)).toObservable();
            Intrinsics.checkNotNullExpressionValue(observable, "cameraOpenInteractor.ope…          .toObservable()");
            Observable<R> zipWith = observable.zipWith(this.j, new BiFunction<Option<? extends CameraInteractor>, SurfaceTexture, R>() { // from class: com.avito.android.photo_picker.legacy.details_list.CameraItemPresenterImpl$initializeCamera$$inlined$zipWith$1
                @Override // io.reactivex.functions.BiFunction
                public final R apply(Option<? extends CameraInteractor> option, SurfaceTexture surfaceTexture) {
                    return (R) surfaceTexture;
                }
            });
            Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
            Observable<R> doOnNext = zipWith.observeOn(this.u.mainThread()).doOnNext(new d(this));
            Intrinsics.checkNotNullExpressionValue(doOnNext, "cameraOpenInteractor.ope…tartFocus()\n            }");
            this.n = Observables.subscribeOnNext(doOnNext, new e(this));
        }
    }

    public final boolean d() {
        if (this.e == null) {
            Disposable disposable = this.n;
            if (disposable != null ? disposable.isDisposed() : true) {
                return true;
            }
        }
        return false;
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter
    public void detachRouter() {
        this.d = null;
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter
    public void detachViewWithSurface() {
        TextureView previewSurface;
        this.A.unregister(this);
        CameraItemView cameraItemView = this.a;
        if (!(cameraItemView == null || (previewSurface = cameraItemView.getPreviewSurface()) == null)) {
            previewSurface.setSurfaceTextureListener(null);
        }
        this.o = false;
        h();
        this.l.clear();
        this.m.clear();
        this.a = null;
    }

    public final void e(FlashMode flashMode) {
        CameraInteractor cameraInteractor;
        Observable<Unit> flashMode2;
        CameraItemView cameraItemView = this.a;
        if (cameraItemView != null && (cameraInteractor = this.e) != null && (flashMode2 = cameraInteractor.setFlashMode(flashMode)) != null) {
            flashMode2.subscribe(new h(this, flashMode, cameraItemView), new i(this));
        }
    }

    public final void f() {
        Observables.subscribeOnNext(this.j, new j(this));
    }

    public final void g() {
        CameraInteractor cameraInteractor = this.e;
        if (cameraInteractor != null) {
            cameraInteractor.stopPreview();
        }
        CameraInteractor cameraInteractor2 = this.e;
        if (cameraInteractor2 != null) {
            cameraInteractor2.destroy();
        }
        h();
        this.e = null;
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter
    @NotNull
    public CameraPresenterState getState() {
        return new CameraPresenterState(this.b, this.c);
    }

    public final void h() {
        Disposable disposable = this.n;
        if (disposable != null) {
            disposable.dispose();
        }
        this.n = null;
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter
    public void initialize() {
        if (this.a != null && this.m.size() <= 0) {
            CompositeDisposable compositeDisposable = this.m;
            Observable<Boolean> filter = this.v.getCameraPermissionChanges().filter(z.b);
            Intrinsics.checkNotNullExpressionValue(filter, "permissionHandler.camera…ges.filter { it == true }");
            DisposableKt.plusAssign(compositeDisposable, Observables.subscribeOnNext(filter, new f5(0, this)));
            CompositeDisposable compositeDisposable2 = this.m;
            Observable<Boolean> filter2 = this.v.getStoragePermissionChanges().filter(z.c);
            Intrinsics.checkNotNullExpressionValue(filter2, "permissionHandler.storag…ges.filter { it == true }");
            DisposableKt.plusAssign(compositeDisposable2, Observables.subscribeOnNext(filter2, new f5(1, this)));
            CompositeDisposable compositeDisposable3 = this.m;
            Observable combineLatest = Observable.combineLatest(this.v.getStoragePermissionChanges(), this.v.getCameraPermissionChanges(), new BiFunction<T1, T2, R>() { // from class: com.avito.android.photo_picker.legacy.details_list.CameraItemPresenterImpl$subscribePermissionHandlers$$inlined$combineLatestWith$1
                @Override // io.reactivex.functions.BiFunction
                @NotNull
                public final R apply(@NotNull T1 t1, @NotNull T2 t2) {
                    Intrinsics.checkNotNullParameter(t1, "t1");
                    Intrinsics.checkNotNullParameter(t2, "t2");
                    return (R) new Pair(Boolean.valueOf(t1.booleanValue()), Boolean.valueOf(t2.booleanValue()));
                }
            });
            Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
            DisposableKt.plusAssign(compositeDisposable3, Observables.subscribeOnNext(combineLatest, new a2.a.a.x1.q.m.e(this)));
            DisposableKt.plusAssign(this.m, Observables.subscribeOnNext(this.v.getCanRequestCameraPermissionChanges(), new a2.a.a.x1.q.m.f(this)));
            this.v.checkPermissions();
            this.v.requestUnmetPermissions();
        }
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView.Presenter
    public void onAllowCameraAccessClicked() {
        this.v.requestPermission("android.permission.CAMERA", new f(this));
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView.Presenter
    public void onCameraToggleClicked() {
        this.b = (CameraType) Collections.getNextItem$default(this.f, this.b, false, 2, null);
        g();
        c(this.b);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView.Presenter
    public void onFlashToggleClicked() {
        FlashMode flashMode = (FlashMode) Collections.getNextItem$default(this.g, this.c, false, 2, null);
        if (flashMode == null) {
            flashMode = FlashMode.Off.INSTANCE;
        }
        e(flashMode);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView.Presenter
    public void onGalleryClicked() {
        CameraItemView cameraItemView;
        if (!this.v.isGranted("android.permission.WRITE_EXTERNAL_STORAGE")) {
            this.v.requestPermission("android.permission.WRITE_EXTERNAL_STORAGE", new g(this));
            return;
        }
        CameraItemPresenter.Router router = this.d;
        if (router != null && !router.openGallery(this.x) && (cameraItemView = this.a) != null) {
            cameraItemView.showMessage(this.y.getNoGalleryFound());
        }
    }

    @Override // com.avito.android.permissions.PermissionResultHandler
    public void onPermissionResult(int i2, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        this.v.onPermissionResult(i2, strArr, iArr);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter
    public void onScreenLeaved() {
        g();
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView.Presenter
    public void onTakeShotClicked() {
        CameraInteractor cameraInteractor = this.e;
        if (cameraInteractor != null && !this.o) {
            this.o = true;
            CameraItemView cameraItemView = this.a;
            if (cameraItemView != null) {
                cameraItemView.setTakeShotButtonAvailability(false);
            }
            Dimension b2 = b();
            CompositeDisposable compositeDisposable = this.l;
            Disposable subscribe = CameraInteractor.DefaultImpls.takeShot$default(cameraInteractor, false, 1, null).concatMap(new a2.a.a.x1.q.m.g(this, b2)).map(new a2.a.a.x1.q.m.h(this)).subscribe(new a2.a.a.x1.q.m.i(this), new a2.a.a.x1.q.m.j(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "cameraInteractor.takeSho…Error(it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter
    public void setPhotoSourcesChangeListener(@NotNull OnPhotoSourcesAvailableChangeListener onPhotoSourcesAvailableChangeListener) {
        Intrinsics.checkNotNullParameter(onPhotoSourcesAvailableChangeListener, "photoSourcesChangeListener");
        this.h = onPhotoSourcesAvailableChangeListener;
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter
    public void startPreview() {
        f();
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter
    public void uninitialize() {
        g();
        this.m.clear();
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter
    public void bindView(@NotNull CameraItemView cameraItemView) {
        Intrinsics.checkNotNullParameter(cameraItemView, "view");
        detachViewWithSurface();
        a(cameraItemView);
        this.A.register(CameraItemView.class, this);
        initialize();
    }

    public void viewAttached(@NotNull CameraItemView cameraItemView, int i2) {
        Intrinsics.checkNotNullParameter(cameraItemView, "view");
        a(cameraItemView);
    }

    public void viewDetached(@NotNull CameraItemView cameraItemView, int i2) {
        Intrinsics.checkNotNullParameter(cameraItemView, "view");
        this.o = false;
        h();
        this.l.clear();
        this.m.clear();
        this.a = null;
    }

    public void bindView(@NotNull CameraItemView cameraItemView, @NotNull BasePhotoItem basePhotoItem, int i2) {
        Intrinsics.checkNotNullParameter(cameraItemView, "view");
        Intrinsics.checkNotNullParameter(basePhotoItem, "item");
        if (basePhotoItem instanceof ResourcePhotoItem) {
            bindView(cameraItemView);
        }
    }
}
