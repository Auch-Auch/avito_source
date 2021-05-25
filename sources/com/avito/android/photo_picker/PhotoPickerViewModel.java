package com.avito.android.photo_picker;

import a2.a.a.x1.f;
import a2.a.a.x1.h;
import a2.a.a.x1.i;
import a2.a.a.x1.k;
import a2.a.a.x1.l;
import a2.a.a.x1.m;
import a2.g.r.g;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.PublishIntentFactory;
import com.avito.android.analytics.CameraScreenOpenEvent;
import com.avito.android.analytics.OpenPhotoEditScreenEvent;
import com.avito.android.analytics.OpenPhotoListEditEvent;
import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.photo_picker.legacy.FlashMode;
import com.avito.android.photo_picker.legacy.PhotoPickerInteractor;
import com.avito.android.photo_picker.legacy.PhotoSource;
import com.avito.android.photo_picker.legacy.PickerPhoto;
import com.avito.android.photo_picker.legacy.thumbnail_list.UriPhotoItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0006\u0001\u0001\u0001BF\u0012\u0006\u0010L\u001a\u00020I\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010k\u001a\u00020h\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010x\u001a\u00020u\u0012\u0006\u0010t\u001a\u00020o\u0012\u0007\u0010\u0001\u001a\u00020 ¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0013\u0010\u0004J\r\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\r\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0004J\r\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\r\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\r\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\r\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u0015\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0002¢\u0006\u0004\b#\u0010\u0004J5\u0010(\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u0004\u0018\u00010\u001a2\u0006\u0010&\u001a\u00020\u001a¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0002¢\u0006\u0004\b.\u0010\u0004J!\u00102\u001a\b\u0012\u0004\u0012\u0002000/2\f\u00101\u001a\b\u0012\u0004\u0012\u0002000/¢\u0006\u0004\b2\u00103J'\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060/052\f\u00104\u001a\b\u0012\u0004\u0012\u0002000/¢\u0006\u0004\b7\u00108J\u001d\u0010;\u001a\u00020\u00022\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 ¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b=\u0010\nJ\r\u0010>\u001a\u00020\u0002¢\u0006\u0004\b>\u0010\u0004J\u0017\u0010?\u001a\u0004\u0018\u0001002\u0006\u0010&\u001a\u00020\u001a¢\u0006\u0004\b?\u0010@J\u0015\u0010B\u001a\u00020\u00022\u0006\u0010A\u001a\u000200¢\u0006\u0004\bB\u0010CR:\u0010H\u001a&\u0012\f\u0012\n E*\u0004\u0018\u00010\u00020\u0002 E*\u0012\u0012\f\u0012\n E*\u0004\u0018\u00010\u00020\u0002\u0018\u00010D0D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010NR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010QR,\u00104\u001a\u0012\u0012\u0004\u0012\u00020S0Rj\b\u0012\u0004\u0012\u00020S`T8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR(\u0010`\u001a\b\u0012\u0004\u0012\u0002000Y8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010e\u001a\u00020\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010\u0007\"\u0004\bd\u0010\nR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010jR,\u0010n\u001a\u0012\u0012\u0004\u0012\u00020S0Rj\b\u0012\u0004\u0012\u00020S`T8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bl\u0010V\u001a\u0004\bm\u0010XR\u0019\u0010t\u001a\u00020o8\u0006@\u0006¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010wR#\u0010\u0001\u001a\u00020y8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0003\u0010\u0001R\u0019\u0010\u0001\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R(\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u00018\u0000@\u0000X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020 8B@\u0002X\u0004¢\u0006\u0007\u001a\u0005\bF\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel;", "Landroidx/lifecycle/ViewModel;", "", "c", "()V", "", "f", "()Z", "commitChanges", "e", "(Z)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction;", "routingActions", "()Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState;", "screenState", "()Landroidx/lifecycle/MutableLiveData;", "onCleared", "goToGallery", "goToSystemGallery", "goToSystemSettings", "goToCamera", "goToEdit", "exitPhotoPicker", "", "selectedPhotoId", "editSelectedPhoto", "(Ljava/lang/String;)V", "Landroid/net/Uri;", "contentUri", "", "isUriSelected", "(Landroid/net/Uri;)I", "selectPhotosFromCamera", "Lcom/avito/android/photo_picker/legacy/PhotoSource;", "source", "photoId", "uploadId", "selectPhotoByUri", "(Landroid/net/Uri;Lcom/avito/android/photo_picker/legacy/PhotoSource;Ljava/lang/String;Ljava/lang/String;)I", "unselectPhotoByUri", "(Landroid/net/Uri;)V", "getUploadImageId", "(Ljava/lang/String;)Ljava/lang/String;", "closeWithSuccess", "", "Lcom/avito/android/photo_picker/SelectedPhoto;", "selected", "filterAddedPhotos", "(Ljava/util/List;)Ljava/util/List;", "photos", "Lio/reactivex/Single;", "Lcom/avito/android/photo_picker/legacy/PickerPhoto;", "createPhotos", "(Ljava/util/List;)Lio/reactivex/Single;", "fromPosition", "toPosition", "swapPhotosByPosition", "(II)V", "handleBack", "startModeAdd", "getSelectedPhoto", "(Ljava/lang/String;)Lcom/avito/android/photo_picker/SelectedPhoto;", "editedPhoto", "editPhoto", "(Lcom/avito/android/photo_picker/SelectedPhoto;)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "d", "Lcom/jakewharton/rxrelay2/PublishRelay;", "selectedPhotosChangeStream", "Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;", "n", "Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;", "interactor", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Ljava/util/ArrayList;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/UriPhotoItem;", "Lkotlin/collections/ArrayList;", "h", "Ljava/util/ArrayList;", "getPhotos$photo_picker_release", "()Ljava/util/ArrayList;", "", "j", "Ljava/util/List;", "getSelectedPhotos$photo_picker_release", "()Ljava/util/List;", "setSelectedPhotos$photo_picker_release", "(Ljava/util/List;)V", "selectedPhotos", g.a, "Z", "getHasPreselectedPhotos$photo_picker_release", "setHasPreselectedPhotos$photo_picker_release", "hasPreselectedPhotos", AuthSource.OPEN_CHANNEL_LIST, "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "p", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "eventTracker", "i", "getPhotoOriginals$photo_picker_release", "photoOriginals", "Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "s", "Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "getMode", "()Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "mode", "Lcom/avito/android/util/RandomKeyProvider;", "r", "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "Lcom/avito/android/photo_picker/legacy/FlashMode;", "k", "Lcom/avito/android/photo_picker/legacy/FlashMode;", "getCurrentFlashMode$photo_picker_release", "()Lcom/avito/android/photo_picker/legacy/FlashMode;", "setCurrentFlashMode$photo_picker_release", "(Lcom/avito/android/photo_picker/legacy/FlashMode;)V", "currentFlashMode", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$State;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$State;", "state", "t", "I", "maxPhotos", "Lio/reactivex/Observable;", "l", "Lio/reactivex/Observable;", "getSelectedPhotosChangeObservable$photo_picker_release", "()Lio/reactivex/Observable;", "selectedPhotosChangeObservable", "()I", "selectedPhotosCount", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", VKApiConst.Q, "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "cvInteractor", "Lcom/avito/android/util/SchedulersFactory;", "o", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/PhotoPickerEventTracker;Lcom/avito/android/computer_vision/ComputerVisionInteractor;Lcom/avito/android/util/RandomKeyProvider;Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;I)V", "RoutingAction", "State", "ViewState", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoPickerViewModel extends ViewModel {
    public State c = State.LEGACY;
    public final PublishRelay<Unit> d;
    public final CompositeDisposable e;
    public final SingleLiveEvent<RoutingAction> f;
    public boolean g;
    @NotNull
    public final ArrayList<UriPhotoItem> h;
    @NotNull
    public final ArrayList<UriPhotoItem> i;
    @NotNull
    public List<SelectedPhoto> j;
    @NotNull
    public FlashMode k;
    @NotNull
    public final Observable<Unit> l;
    public final MutableLiveData<ViewState> m;
    public final PhotoPickerInteractor n;
    public final SchedulersFactory o;
    public final PhotoPickerEventTracker p;
    public final ComputerVisionInteractor q;
    public final RandomKeyProvider r;
    @NotNull
    public final PublishIntentFactory.PhotoPickerMode s;
    public final int t;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction;", "", "<init>", "()V", "ToCameraScreen", "ToEdit", "ToEditPhotoScreen", "ToExit", "ToExitWithSuccess", "ToGalleryScreen", "ToSystemGalleryScreen", "ToSystemSettings", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToGalleryScreen;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToSystemGalleryScreen;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToSystemSettings;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToCameraScreen;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToEditPhotoScreen;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToExit;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToExitWithSuccess;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToEdit;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class RoutingAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToCameraScreen;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ToCameraScreen extends RoutingAction {
            @NotNull
            public static final ToCameraScreen INSTANCE = new ToCameraScreen();

            public ToCameraScreen() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToEdit;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction;", "", "Lcom/avito/android/photo_picker/SelectedPhoto;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getPhotos", "()Ljava/util/List;", "photos", "<init>", "(Ljava/util/List;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ToEdit extends RoutingAction {
            @NotNull
            public final List<SelectedPhoto> a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ToEdit(@NotNull List<SelectedPhoto> list) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "photos");
                this.a = list;
            }

            @NotNull
            public final List<SelectedPhoto> getPhotos() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToEditPhotoScreen;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction;", "", "component1", "()Ljava/lang/String;", "photoId", "copy", "(Ljava/lang/String;)Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToEditPhotoScreen;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhotoId", "<init>", "(Ljava/lang/String;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ToEditPhotoScreen extends RoutingAction {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ToEditPhotoScreen(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "photoId");
                this.a = str;
            }

            public static /* synthetic */ ToEditPhotoScreen copy$default(ToEditPhotoScreen toEditPhotoScreen, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = toEditPhotoScreen.a;
                }
                return toEditPhotoScreen.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final ToEditPhotoScreen copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "photoId");
                return new ToEditPhotoScreen(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof ToEditPhotoScreen) && Intrinsics.areEqual(this.a, ((ToEditPhotoScreen) obj).a);
                }
                return true;
            }

            @NotNull
            public final String getPhotoId() {
                return this.a;
            }

            public int hashCode() {
                String str = this.a;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a2.b.a.a.a.t(a2.b.a.a.a.L("ToEditPhotoScreen(photoId="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToExit;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ToExit extends RoutingAction {
            @NotNull
            public static final ToExit INSTANCE = new ToExit();

            public ToExit() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToExitWithSuccess;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ToExitWithSuccess extends RoutingAction {
            @NotNull
            public static final ToExitWithSuccess INSTANCE = new ToExitWithSuccess();

            public ToExitWithSuccess() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToGalleryScreen;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ToGalleryScreen extends RoutingAction {
            @NotNull
            public static final ToGalleryScreen INSTANCE = new ToGalleryScreen();

            public ToGalleryScreen() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToSystemGalleryScreen;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction;", "", AuthSource.SEND_ABUSE, "Z", "getPickMultiple", "()Z", "pickMultiple", "<init>", "(Z)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ToSystemGalleryScreen extends RoutingAction {
            public final boolean a;

            public ToSystemGalleryScreen(boolean z) {
                super(null);
                this.a = z;
            }

            public final boolean getPickMultiple() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction$ToSystemSettings;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$RoutingAction;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ToSystemSettings extends RoutingAction {
            @NotNull
            public static final ToSystemSettings INSTANCE = new ToSystemSettings();

            public ToSystemSettings() {
                super(null);
            }
        }

        public RoutingAction() {
        }

        public RoutingAction(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$State;", "", "<init>", "(Ljava/lang/String;I)V", "LEGACY", "GALLERY", "CAMERA", "EDIT_FROM_GALLERY", "EDIT_FROM_CAMERA", "EDIT_SELECTED", "EDIT_SELECTED_FROM_GALLERY", "EDIT_SELECTED_FROM_CAMERA", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public enum State {
        LEGACY,
        GALLERY,
        CAMERA,
        EDIT_FROM_GALLERY,
        EDIT_FROM_CAMERA,
        EDIT_SELECTED,
        EDIT_SELECTED_FROM_GALLERY,
        EDIT_SELECTED_FROM_CAMERA
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState;", "", "<init>", "()V", "HideChosenPhotoPanel", "HideFullScreenLoading", "ShowChosenPhotoPanel", "ShowFullScreenLoading", "ShowMaxPhotoError", "ShowNothingChosenMessage", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState$ShowChosenPhotoPanel;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState$HideChosenPhotoPanel;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState$ShowNothingChosenMessage;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState$ShowFullScreenLoading;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState$HideFullScreenLoading;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState$ShowMaxPhotoError;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState$HideChosenPhotoPanel;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class HideChosenPhotoPanel extends ViewState {
            @NotNull
            public static final HideChosenPhotoPanel INSTANCE = new HideChosenPhotoPanel();

            public HideChosenPhotoPanel() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState$HideFullScreenLoading;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class HideFullScreenLoading extends ViewState {
            @NotNull
            public static final HideFullScreenLoading INSTANCE = new HideFullScreenLoading();

            public HideFullScreenLoading() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState$ShowChosenPhotoPanel;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShowChosenPhotoPanel extends ViewState {
            @NotNull
            public static final ShowChosenPhotoPanel INSTANCE = new ShowChosenPhotoPanel();

            public ShowChosenPhotoPanel() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState$ShowFullScreenLoading;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShowFullScreenLoading extends ViewState {
            @NotNull
            public static final ShowFullScreenLoading INSTANCE = new ShowFullScreenLoading();

            public ShowFullScreenLoading() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState$ShowMaxPhotoError;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState;", "", AuthSource.SEND_ABUSE, "I", "getMaxPhotos", "()I", "maxPhotos", "<init>", "(I)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShowMaxPhotoError extends ViewState {
            public final int a;

            public ShowMaxPhotoError(int i) {
                super(null);
                this.a = i;
            }

            public final int getMaxPhotos() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState$ShowNothingChosenMessage;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel$ViewState;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShowNothingChosenMessage extends ViewState {
            @NotNull
            public static final ShowNothingChosenMessage INSTANCE = new ShowNothingChosenMessage();

            public ShowNothingChosenMessage() {
                super(null);
            }
        }

        public ViewState() {
        }

        public ViewState(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            State.values();
            int[] iArr = new int[8];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[2] = 2;
            State.values();
            int[] iArr2 = new int[8];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[1] = 1;
            iArr2[2] = 2;
            iArr2[7] = 3;
            iArr2[6] = 4;
            State.values();
            int[] iArr3 = new int[8];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[4] = 1;
            iArr3[3] = 2;
            State.values();
            int[] iArr4 = new int[8];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[1] = 1;
            iArr4[2] = 2;
            iArr4[3] = 3;
            iArr4[4] = 4;
            iArr4[6] = 5;
            iArr4[7] = 6;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<SelectedPhoto, Boolean> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(SelectedPhoto selectedPhoto) {
            int i = this.a;
            if (i == 0) {
                SelectedPhoto selectedPhoto2 = selectedPhoto;
                Intrinsics.checkNotNullParameter(selectedPhoto2, "it");
                return Boolean.valueOf(Intrinsics.areEqual(selectedPhoto2.getUri(), ((UriPhotoItem) this.b).getSourceUri()));
            } else if (i == 1) {
                SelectedPhoto selectedPhoto3 = selectedPhoto;
                Intrinsics.checkNotNullParameter(selectedPhoto3, "it");
                return Boolean.valueOf(Intrinsics.areEqual(selectedPhoto3.getUri(), ((UriPhotoItem) this.b).getImageUri()));
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PhotoPickerViewModel a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(PhotoPickerViewModel photoPickerViewModel) {
            super(0);
            this.a = photoPickerViewModel;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.m.setValue(ViewState.HideFullScreenLoading.INSTANCE);
            this.a.f.setValue(RoutingAction.ToExitWithSuccess.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ PhotoPickerViewModel a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(PhotoPickerViewModel photoPickerViewModel) {
            super(1);
            this.a = photoPickerViewModel;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            this.a.m.setValue(ViewState.HideFullScreenLoading.INSTANCE);
            this.a.f.setValue(RoutingAction.ToExit.INSTANCE);
            Logs.error("Can't save photos to db", th2);
            return Unit.INSTANCE;
        }
    }

    public static final class d<T, R> implements Function<List<? extends PickerPhoto>, SingleSource<? extends List<? extends PickerPhoto>>> {
        public final /* synthetic */ PhotoPickerViewModel a;

        public d(PhotoPickerViewModel photoPickerViewModel) {
            this.a = photoPickerViewModel;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.photo_picker.legacy.PhotoPickerInteractor */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends List<? extends PickerPhoto>> apply(List<? extends PickerPhoto> list) {
            List<? extends PickerPhoto> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            return this.a.n.getThumbnails(list2);
        }
    }

    public PhotoPickerViewModel(@NotNull PhotoPickerInteractor photoPickerInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull PhotoPickerEventTracker photoPickerEventTracker, @NotNull ComputerVisionInteractor computerVisionInteractor, @NotNull RandomKeyProvider randomKeyProvider, @NotNull PublishIntentFactory.PhotoPickerMode photoPickerMode, int i2) {
        Intrinsics.checkNotNullParameter(photoPickerInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(photoPickerEventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(computerVisionInteractor, "cvInteractor");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        Intrinsics.checkNotNullParameter(photoPickerMode, "mode");
        this.n = photoPickerInteractor;
        this.o = schedulersFactory;
        this.p = photoPickerEventTracker;
        this.q = computerVisionInteractor;
        this.r = randomKeyProvider;
        this.s = photoPickerMode;
        this.t = i2;
        PublishRelay<Unit> create = PublishRelay.create();
        this.d = create;
        this.e = new CompositeDisposable();
        this.f = new SingleLiveEvent<>();
        this.h = new ArrayList<>(i2);
        this.i = new ArrayList<>(i2);
        this.j = new ArrayList();
        this.k = FlashMode.Off.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(create, "selectedPhotosChangeStream");
        this.l = create;
        this.m = new MutableLiveData<>();
    }

    public static final Single access$delayIfNeeded(PhotoPickerViewModel photoPickerViewModel, boolean z) {
        Objects.requireNonNull(photoPickerViewModel);
        if (z) {
            return Singles.toSingle(Boolean.valueOf(z)).delay(3, TimeUnit.SECONDS, photoPickerViewModel.o.computation());
        }
        return Singles.toSingle(Boolean.valueOf(z));
    }

    public static final void access$onPhotosLoaded(PhotoPickerViewModel photoPickerViewModel) {
        CompositeDisposable compositeDisposable = photoPickerViewModel.e;
        Completable observeOn = Singles.toSingle(Boolean.valueOf(photoPickerViewModel.q.needTimeToUploading())).flatMap(new a2.a.a.x1.j(photoPickerViewModel)).flatMapCompletable(new k(photoPickerViewModel)).observeOn(photoPickerViewModel.o.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "cvInteractor.needTimeToU…(schedulers.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy(observeOn, new m(photoPickerViewModel), new l(photoPickerViewModel)));
    }

    public static /* synthetic */ void handleBack$default(PhotoPickerViewModel photoPickerViewModel, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        photoPickerViewModel.handleBack(z);
    }

    public static /* synthetic */ int selectPhotoByUri$default(PhotoPickerViewModel photoPickerViewModel, Uri uri, PhotoSource photoSource, String str, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        return photoPickerViewModel.selectPhotoByUri(uri, photoSource, str, str2);
    }

    public final void c() {
        if (d() > 0) {
            this.m.setValue(ViewState.ShowChosenPhotoPanel.INSTANCE);
        }
    }

    public final void closeWithSuccess() {
        if (this.s == PublishIntentFactory.PhotoPickerMode.MODE_EDIT) {
            this.m.setValue(ViewState.ShowFullScreenLoading.INSTANCE);
            CompositeDisposable compositeDisposable = this.e;
            Completable observeOn = this.n.commit().retry(3).observeOn(this.o.mainThread());
            Intrinsics.checkNotNullExpressionValue(observeOn, "interactor.commit().retr…(schedulers.mainThread())");
            DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy(observeOn, new c(this), new b(this)));
            return;
        }
        f();
        CompositeDisposable compositeDisposable2 = this.e;
        Disposable subscribe = createPhotos(filterAddedPhotos(this.j)).observeOn(this.o.computation()).flatMapObservable(new f(this)).observeOn(this.o.mainThread()).subscribe(a2.a.a.x1.g.a, new h(this), new i(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "observeOn(schedulers.com…    { onPhotosLoaded() })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe);
    }

    @NotNull
    public final Single<List<PickerPhoto>> createPhotos(@NotNull List<SelectedPhoto> list) {
        Intrinsics.checkNotNullParameter(list, "photos");
        Single<R> observeOn = this.n.createPhotos(list).flatMap(new d(this)).observeOn(this.o.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "interactor\n            .…(schedulers.mainThread())");
        return observeOn;
    }

    public final int d() {
        return this.j.size();
    }

    public final void e(boolean z) {
        if (z) {
            List<SelectedPhoto> list = this.j;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            for (T t2 : list) {
                arrayList.add(new SelectedPhoto(t2.getUri(), t2.getSource(), t2.getId(), null, null, null, 56, null));
            }
            this.j = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        } else {
            List<SelectedPhoto> list2 = this.j;
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list2, 10));
            for (T t3 : list2) {
                Uri originalUri = t3.getOriginalUri();
                if (originalUri == null) {
                    originalUri = t3.getUri();
                }
                arrayList2.add(new SelectedPhoto(originalUri, t3.getSource(), t3.getId(), null, null, null, 56, null));
            }
            this.j = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
            for (T t4 : this.i) {
                int i2 = 0;
                Iterator<UriPhotoItem> it = this.h.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    } else if (Intrinsics.areEqual(it.next().getStringId(), t4.getStringId())) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 != -1) {
                    this.h.set(i2, t4);
                }
            }
        }
        this.i.clear();
    }

    public final void editPhoto(@NotNull SelectedPhoto selectedPhoto) {
        T t2;
        T t3;
        Intrinsics.checkNotNullParameter(selectedPhoto, "editedPhoto");
        Iterator<SelectedPhoto> it = this.j.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getId(), selectedPhoto.getId())) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            Iterator<T> it2 = this.i.iterator();
            while (true) {
                t2 = null;
                if (!it2.hasNext()) {
                    t3 = null;
                    break;
                }
                t3 = it2.next();
                if (Intrinsics.areEqual(t3.getStringId(), selectedPhoto.getId())) {
                    break;
                }
            }
            T t4 = t3;
            if (t4 == null) {
                this.j.set(i2, selectedPhoto);
                Iterator<T> it3 = this.h.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    T next = it3.next();
                    if (Intrinsics.areEqual(next.getStringId(), selectedPhoto.getId())) {
                        t2 = next;
                        break;
                    }
                }
                T t5 = t2;
                if (t5 != null) {
                    this.i.add(t5);
                    return;
                }
                return;
            }
            List<SelectedPhoto> list = this.j;
            Uri imageUri = t4.getImageUri();
            list.set(i2, SelectedPhoto.copy$default(selectedPhoto, null, null, null, imageUri != null ? imageUri : t4.getSourceUri(), null, null, 55, null));
        }
    }

    public final void editSelectedPhoto(@NotNull String str) {
        State state;
        Intrinsics.checkNotNullParameter(str, "selectedPhotoId");
        int ordinal = this.c.ordinal();
        if (ordinal == 3) {
            state = State.EDIT_SELECTED_FROM_GALLERY;
        } else if (ordinal != 4) {
            state = State.EDIT_SELECTED;
        } else {
            state = State.EDIT_SELECTED_FROM_CAMERA;
        }
        this.c = state;
        this.p.track(new OpenPhotoEditScreenEvent(getUploadImageId(str)));
        this.f.setValue(new RoutingAction.ToEditPhotoScreen(str));
    }

    public final void exitPhotoPicker() {
        this.f.setValue(RoutingAction.ToExit.INSTANCE);
    }

    public final boolean f() {
        if (this.s == PublishIntentFactory.PhotoPickerMode.MODE_LEGACY) {
            return false;
        }
        List<SelectedPhoto> list = this.j;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getId());
        }
        Iterator<UriPhotoItem> it2 = this.h.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "photos.iterator()");
        while (it2.hasNext()) {
            UriPhotoItem next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            UriPhotoItem uriPhotoItem = next;
            if (!arrayList.contains(uriPhotoItem.getStringId())) {
                this.n.removePhoto(uriPhotoItem.getStringId());
                it2.remove();
            }
        }
        return true;
    }

    @NotNull
    public final List<SelectedPhoto> filterAddedPhotos(@NotNull List<SelectedPhoto> list) {
        Intrinsics.checkNotNullParameter(list, "selected");
        if (this.s == PublishIntentFactory.PhotoPickerMode.MODE_LEGACY) {
            return list;
        }
        List<SelectedPhoto> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getUri());
        }
        Iterator<UriPhotoItem> it2 = this.h.iterator();
        while (it2.hasNext()) {
            UriPhotoItem next = it2.next();
            if (arrayList.contains(next.getSourceUri())) {
                t6.n.h.removeAll((List) mutableList, (Function1) new a(0, next));
            } else if (CollectionsKt___CollectionsKt.contains(arrayList, next.getImageUri())) {
                t6.n.h.removeAll((List) mutableList, (Function1) new a(1, next));
            }
        }
        return mutableList;
    }

    @NotNull
    public final FlashMode getCurrentFlashMode$photo_picker_release() {
        return this.k;
    }

    public final boolean getHasPreselectedPhotos$photo_picker_release() {
        return this.g;
    }

    @NotNull
    public final PublishIntentFactory.PhotoPickerMode getMode() {
        return this.s;
    }

    @NotNull
    public final ArrayList<UriPhotoItem> getPhotoOriginals$photo_picker_release() {
        return this.i;
    }

    @NotNull
    public final ArrayList<UriPhotoItem> getPhotos$photo_picker_release() {
        return this.h;
    }

    @Nullable
    public final SelectedPhoto getSelectedPhoto(@NotNull String str) {
        T t2;
        T t3;
        boolean z;
        Intrinsics.checkNotNullParameter(str, "photoId");
        Iterator<T> it = this.h.iterator();
        while (true) {
            t2 = null;
            if (!it.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it.next();
            if (Intrinsics.areEqual(t3.getStringId(), str)) {
                break;
            }
        }
        T t4 = t3;
        if (t4 == null) {
            return null;
        }
        Iterator<T> it2 = this.j.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            T t5 = next;
            if (Intrinsics.areEqual(t5.getUri(), t4.getImageUri()) || Intrinsics.areEqual(t5.getUri(), t4.getSourceUri())) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t2 = next;
                break;
            }
        }
        return t2;
    }

    @NotNull
    public final List<SelectedPhoto> getSelectedPhotos$photo_picker_release() {
        return this.j;
    }

    @NotNull
    public final Observable<Unit> getSelectedPhotosChangeObservable$photo_picker_release() {
        return this.l;
    }

    @Nullable
    public final String getUploadImageId(@NotNull String str) {
        T t2;
        Intrinsics.checkNotNullParameter(str, "photoId");
        Iterator<T> it = this.j.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (Intrinsics.areEqual(t2.getId(), str)) {
                break;
            }
        }
        T t3 = t2;
        if (t3 != null) {
            return t3.getUploadId();
        }
        return null;
    }

    public final void goToCamera() {
        this.c = State.CAMERA;
        this.f.setValue(RoutingAction.ToCameraScreen.INSTANCE);
        this.p.track(CameraScreenOpenEvent.INSTANCE);
    }

    public final void goToEdit() {
        State state;
        int ordinal = this.c.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            this.p.track(OpenPhotoListEditEvent.INSTANCE);
        }
        int ordinal2 = this.c.ordinal();
        if (ordinal2 == 1) {
            state = State.EDIT_FROM_GALLERY;
        } else if (ordinal2 == 2) {
            state = State.EDIT_FROM_CAMERA;
        } else if (ordinal2 == 6) {
            state = State.EDIT_FROM_GALLERY;
        } else if (ordinal2 != 7) {
            state = State.LEGACY;
        } else {
            state = State.EDIT_FROM_CAMERA;
        }
        this.c = state;
        this.f.setValue(new RoutingAction.ToEdit(this.j));
    }

    public final void goToGallery() {
        t6.n.h.removeAll((List) this.j, (Function1) a2.a.a.x1.e.a);
        f();
        this.d.accept(Unit.INSTANCE);
        if (d() == 0 && this.c != State.LEGACY) {
            if (this.g) {
                this.m.setValue(ViewState.ShowNothingChosenMessage.INSTANCE);
            } else {
                this.m.setValue(ViewState.HideChosenPhotoPanel.INSTANCE);
            }
        }
        this.c = State.GALLERY;
        this.f.setValue(RoutingAction.ToGalleryScreen.INSTANCE);
    }

    public final void goToSystemGallery() {
        SingleLiveEvent<RoutingAction> singleLiveEvent = this.f;
        boolean z = true;
        if (this.t <= 1) {
            z = false;
        }
        singleLiveEvent.setValue(new RoutingAction.ToSystemGalleryScreen(z));
    }

    public final void goToSystemSettings() {
        this.f.setValue(RoutingAction.ToSystemSettings.INSTANCE);
    }

    public final void handleBack(boolean z) {
        PublishIntentFactory.PhotoPickerMode photoPickerMode = this.s;
        if (photoPickerMode == PublishIntentFactory.PhotoPickerMode.MODE_ADD) {
            f();
            int ordinal = this.c.ordinal();
            if (ordinal == 1) {
                exitPhotoPicker();
            } else if (ordinal == 2) {
                goToGallery();
            } else if (ordinal == 3) {
                e(z);
                goToGallery();
                c();
            } else if (ordinal == 4) {
                e(z);
                goToCamera();
                c();
            } else if (ordinal == 6 || ordinal == 7) {
                goToEdit();
            } else {
                exitPhotoPicker();
            }
        } else if (photoPickerMode == PublishIntentFactory.PhotoPickerMode.MODE_EDIT && this.c == State.EDIT_SELECTED) {
            goToEdit();
        } else {
            exitPhotoPicker();
        }
    }

    public final int isUriSelected(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        List<SelectedPhoto> list = this.j;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getUri());
        }
        return arrayList.indexOf(uri) + 1;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.e.clear();
        super.onCleared();
    }

    @NotNull
    public final LiveData<RoutingAction> routingActions() {
        return this.f;
    }

    @NotNull
    public final MutableLiveData<ViewState> screenState() {
        return this.m;
    }

    public final int selectPhotoByUri(@NotNull Uri uri, @NotNull PhotoSource photoSource, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        Intrinsics.checkNotNullParameter(photoSource, "source");
        int d2 = d();
        int i2 = this.t;
        if (d2 < i2) {
            List<SelectedPhoto> list = this.j;
            if (str == null) {
                str = this.r.generateKey();
            }
            list.add(new SelectedPhoto(uri, photoSource, str, null, null, str2, 24, null));
            this.d.accept(Unit.INSTANCE);
            if (d() == 1 && this.c != State.LEGACY) {
                this.m.setValue(ViewState.ShowChosenPhotoPanel.INSTANCE);
            }
            return d();
        }
        this.m.setValue(new ViewState.ShowMaxPhotoError(i2));
        return 0;
    }

    public final void selectPhotosFromCamera() {
        List<SelectedPhoto> list = this.j;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t2 : list) {
            if (t2.getSource() == PhotoSource.CAMERA_TEMP) {
                t2 = (T) SelectedPhoto.copy$default(t2, null, PhotoSource.CAMERA, null, null, null, null, 61, null);
            }
            arrayList.add(t2);
        }
        this.j = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
    }

    public final void setCurrentFlashMode$photo_picker_release(@NotNull FlashMode flashMode) {
        Intrinsics.checkNotNullParameter(flashMode, "<set-?>");
        this.k = flashMode;
    }

    public final void setHasPreselectedPhotos$photo_picker_release(boolean z) {
        this.g = z;
    }

    public final void setSelectedPhotos$photo_picker_release(@NotNull List<SelectedPhoto> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.j = list;
    }

    public final void startModeAdd() {
        goToGallery();
        c();
    }

    public final void swapPhotosByPosition(int i2, int i3) {
        Collections.swap(this.h, i2, i3);
        if (this.c != State.LEGACY) {
            Collections.swap(this.j, i2, i3);
        }
    }

    public final void unselectPhotoByUri(@NotNull Uri uri) {
        T t2;
        T t3;
        boolean z;
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        Iterator<T> it = this.j.iterator();
        while (true) {
            t2 = null;
            if (!it.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it.next();
            if (Intrinsics.areEqual(t3.getUri(), uri)) {
                break;
            }
        }
        List<SelectedPhoto> list = this.j;
        Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        TypeIntrinsics.asMutableCollection(list).remove(t3);
        Iterator<T> it2 = this.h.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            T t4 = next;
            if (Intrinsics.areEqual(t4.getImageUri(), uri) || Intrinsics.areEqual(t4.getSourceUri(), uri)) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t2 = next;
                break;
            }
        }
        T t5 = t2;
        if (t5 != null) {
            this.n.removePhoto(t5.getStringId());
        }
        Iterator<UriPhotoItem> it3 = this.h.iterator();
        int i2 = 0;
        while (true) {
            if (!it3.hasNext()) {
                i2 = -1;
                break;
            }
            UriPhotoItem next2 = it3.next();
            if (Intrinsics.areEqual(next2.getImageUri(), uri) || Intrinsics.areEqual(next2.getSourceUri(), uri)) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            this.h.remove(i2);
        }
        this.d.accept(Unit.INSTANCE);
        if (d() == 0 && this.c != State.LEGACY) {
            if (this.g) {
                this.m.setValue(ViewState.ShowNothingChosenMessage.INSTANCE);
            } else {
                this.m.setValue(ViewState.HideChosenPhotoPanel.INSTANCE);
            }
        }
    }
}
