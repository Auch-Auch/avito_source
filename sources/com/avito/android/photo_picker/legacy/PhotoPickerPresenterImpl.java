package com.avito.android.photo_picker.legacy;

import android.net.Uri;
import com.avito.android.PublishIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.DeletePhotoFromListEvent;
import com.avito.android.analytics.OpenPhotoListEditEvent;
import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.analytics.events.CropActionEvent;
import com.avito.android.analytics.events.CropSourceEvent;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.krop.util.Transformation;
import com.avito.android.photo_picker.PhotoPickerViewModel;
import com.avito.android.photo_picker.R;
import com.avito.android.photo_picker.SelectedPhoto;
import com.avito.android.photo_picker.legacy.PhotoPickerPresenter;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter;
import com.avito.android.photo_picker.legacy.thumbnail_list.BasePhotoItem;
import com.avito.android.photo_picker.legacy.thumbnail_list.ResourcePhotoItem;
import com.avito.android.photo_picker.legacy.thumbnail_list.UriPhotoItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Flowables;
import com.avito.android.util.Logs;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.Rotation;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.z;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0001\u0012\u0006\u0010\u001a\u00020|\u0012\u0007\u0010\u0001\u001a\u00020|\u0012\u0006\u0010^\u001a\u00020[\u0012\u0006\u0010f\u001a\u00020c\u0012\u0006\u0010o\u001a\u00020l\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0007\u0010\u0001\u001a\u00020\u001f\u0012\u0007\u0010\u0001\u001a\u00020\u001f\u0012\u0006\u0010k\u001a\u00020h\u0012\u0007\u0010\u0001\u001a\u00020\u0003\u0012\u0007\u0010\u0001\u001a\u00020\u0003\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010b\u001a\u00020_\u0012\u0006\u0010V\u001a\u00020S\u0012\t\u0010 \u0001\u001a\u0004\u0018\u00010/¢\u0006\u0006\b¡\u0001\u0010¢\u0001J\u0019\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u0012*\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0016\u001a\u00020\u0015*\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b#\u0010\"J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0019J\u0017\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0005H\u0016¢\u0006\u0004\b-\u0010\u0019J\u000f\u0010.\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010\u0019J\u000f\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b2\u0010\u000eJ\u0017\u00103\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b3\u0010\u000eJ%\u00109\u001a\u00020\u00052\f\u00106\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u001d\u00109\u001a\u00020\u00052\f\u00106\u001a\b\u0012\u0004\u0012\u00020;04H\u0016¢\u0006\u0004\b9\u0010<J\u000f\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0005H\u0016¢\u0006\u0004\b@\u0010\u0019J\u000f\u0010A\u001a\u00020\u0005H\u0016¢\u0006\u0004\bA\u0010\u0019J\u0017\u0010B\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\bB\u0010\u000eJ\u001f\u0010E\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0003H\u0016¢\u0006\u0004\bH\u0010\u0007J\u001f\u0010K\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\u001fH\u0016¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\u0005H\u0016¢\u0006\u0004\bM\u0010\u0019J\u000f\u0010N\u001a\u00020\u0005H\u0016¢\u0006\u0004\bN\u0010\u0019J\u000f\u0010O\u001a\u00020\u0005H\u0016¢\u0006\u0004\bO\u0010\u0019R\u0016\u0010R\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010gR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010q\u001a\u00020\u001b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0018\u0010pR\u001c\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00110r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010w\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010vR&\u0010{\u001a\u0012\u0012\u0004\u0012\u00020\u00150xj\b\u0012\u0004\u0012\u00020\u0015`y8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010zR\u0016\u0010\u001a\u00020|8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u0019\u0010\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0013\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0006\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u00158V@\u0016X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020|8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010~R \u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u001a\u0010\u0001R\u001b\u0010 \u0001\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006£\u0001"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterImpl;", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter;", "Lcom/avito/android/photo_picker/legacy/OnPhotoSourcesAvailableChangeListener;", "", "notifyDetailsList", "", AuthSource.BOOKING_ORDER, "(Z)V", "", "id", "d", "(Ljava/lang/String;Z)V", "c", "e", "(Ljava/lang/String;)V", "Lio/reactivex/Single;", "", "Lcom/avito/android/photo_picker/legacy/PickerPhoto;", "Lio/reactivex/disposables/Disposable;", AuthSource.SEND_ABUSE, "(Lio/reactivex/Single;)Lio/reactivex/disposables/Disposable;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/UriPhotoItem;", a2.g.r.g.a, "(Lcom/avito/android/photo_picker/legacy/PickerPhoto;)Lcom/avito/android/photo_picker/legacy/thumbnail_list/UriPhotoItem;", "h", "()V", "f", "Lcom/avito/android/photo_picker/PhotoPickerViewModel;", "viewModel", "setViewModel", "(Lcom/avito/android/photo_picker/PhotoPickerViewModel;)V", "", VKApiConst.POSITION, "onDetailsListScrolled", "(I)V", "onDetailsListScrollFinished", "Lcom/avito/android/photo_picker/legacy/PhotoPickerView;", "view", "attachView", "(Lcom/avito/android/photo_picker/legacy/PhotoPickerView;)V", "detachView", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter$Router;)V", "detachRouter", "onCancelClicked", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterState;", "getState", "()Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterState;", "setSelectedPhotoId", "onThumbnailClicked", "", "Landroid/net/Uri;", "uris", "Lcom/avito/android/photo_picker/legacy/PhotoSource;", "source", "onNewPhotos", "(Ljava/util/List;Lcom/avito/android/photo_picker/legacy/PhotoSource;)V", "Lcom/avito/android/photo_picker/SelectedPhoto;", "(Ljava/util/List;)V", "Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "getMode", "()Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "removeSelectedPhoto", "editSelectedPhoto", "onRemovePhoto", "Lcom/avito/android/krop/util/Transformation;", "transformation", "onPhotoCropped", "(Ljava/lang/String;Lcom/avito/android/krop/util/Transformation;)V", "isAvailable", "onPhotoSourcesChanged", "fromPosition", "toPosition", "movePhoto", "(II)V", "handleContinueButtonClick", "hideFullScreenLoading", "showFullScreenLoading", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "x", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "eventTracker", "Lcom/avito/android/util/SchedulersFactory;", "p", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;", "l", "Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;", "interactor", "Lcom/avito/android/util/RandomKeyProvider;", "w", "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", "cameraPresenter", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter$Router;", "Lcom/avito/android/analytics/Analytics;", "s", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/photo_picker/legacy/RotationInteractor;", "n", "Lcom/avito/android/photo_picker/legacy/RotationInteractor;", "rotationInteractor", "Lcom/avito/android/photo_picker/PhotoPickerViewModel;", "photoPickerViewModel", "", "i", "Ljava/util/List;", "loadingPhotos", "Lio/reactivex/disposables/Disposable;", "continueClicksDisposable", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "photos", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "j", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "detailsAdapterPresenter", VKApiConst.Q, "I", "minPhotoCount", "Lcom/avito/android/photo_picker/legacy/PhotoPickerView;", "t", "Z", "simplifiedUi", "Ljava/lang/String;", "selectedPhotoId", "u", "withCrop", "r", "maxPhotoCount", "getFirstPhoto", "()Lcom/avito/android/photo_picker/legacy/thumbnail_list/UriPhotoItem;", "firstPhoto", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", VKApiConst.VERSION, "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "cvInteractor", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterResourceProvider;", "o", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterResourceProvider;", "resourceProvider", "k", "thumbnailsAdapterPresenter", "Lcom/avito/konveyor/data_source/ListDataSource;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;", "Lcom/avito/konveyor/data_source/ListDataSource;", "dataSource", "y", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterState;", "state", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/photo_picker/legacy/PhotoPickerInteractor;Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;Lcom/avito/android/photo_picker/legacy/RotationInteractor;Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterResourceProvider;Lcom/avito/android/util/SchedulersFactory;IILcom/avito/android/analytics/Analytics;ZZLcom/avito/android/computer_vision/ComputerVisionInteractor;Lcom/avito/android/util/RandomKeyProvider;Lcom/avito/android/analytics/PhotoPickerEventTracker;Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterState;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoPickerPresenterImpl implements PhotoPickerPresenter, OnPhotoSourcesAvailableChangeListener {
    public PhotoPickerView a;
    public String b;
    public PhotoPickerPresenter.Router c;
    public final CompositeDisposable d;
    public Disposable e;
    public ListDataSource<BasePhotoItem> f;
    public ArrayList<UriPhotoItem> g;
    public PhotoPickerViewModel h;
    public final List<PickerPhoto> i;
    public final AdapterPresenter j;
    public final AdapterPresenter k;
    public final PhotoPickerInteractor l;
    public final CameraItemPresenter m;
    public final RotationInteractor n;
    public final PhotoPickerPresenterResourceProvider o;
    public final SchedulersFactory p;
    public final int q;
    public final int r;
    public final Analytics s;
    public final boolean t;
    public final boolean u;
    public final ComputerVisionInteractor v;
    public final RandomKeyProvider w;
    public final PhotoPickerEventTracker x;
    public final PhotoPickerPresenterState y;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PhotoSource.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            PhotoSource photoSource = PhotoSource.CAMERA;
            iArr[1] = 1;
            PhotoSource photoSource2 = PhotoSource.GALLERY;
            iArr[3] = 2;
        }
    }

    public static final class a<T1, T2> implements BiConsumer<Boolean, Throwable> {
        public final /* synthetic */ PhotoPickerView a;

        public a(PhotoPickerView photoPickerView) {
            this.a = photoPickerView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.functions.BiConsumer
        public void accept(Boolean bool, Throwable th) {
            Boolean bool2 = bool;
            PhotoPickerView photoPickerView = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "shouldWait");
            photoPickerView.setContinueButtonProgress(bool2.booleanValue());
        }
    }

    public static final class b<T, R> implements Function<Boolean, SingleSource<? extends Boolean>> {
        public final /* synthetic */ PhotoPickerPresenterImpl a;

        public b(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
            this.a = photoPickerPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Boolean> apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "it");
            return PhotoPickerPresenterImpl.access$delayIfNeeded(this.a, bool2.booleanValue());
        }
    }

    public static final class c<T, R> implements Function<Boolean, CompletableSource> {
        public final /* synthetic */ PhotoPickerPresenterImpl a;

        public c(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
            this.a = photoPickerPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "it");
            return this.a.l.commit().retry(3);
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PhotoPickerPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
            super(0);
            this.a = photoPickerPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (PhotoPickerPresenterImpl.access$isCropEnabled(this.a)) {
                PhotoPickerPresenterImpl.access$trackCropAccepted(this.a);
            }
            PhotoPickerPresenter.Router router = this.a.c;
            if (router != null) {
                router.onSubmit();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ PhotoPickerPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
            super(1);
            this.a = photoPickerPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            Logs.error("PhotoPickerPresenter", "handleContinueButtonClick", th2);
            PhotoPickerPresenter.Router router = this.a.c;
            if (router != null) {
                router.onCancel();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class f<T> implements Consumer<Iterable<? extends PickerPhoto>> {
        public final /* synthetic */ PhotoPickerPresenterImpl a;

        public f(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
            this.a = photoPickerPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Iterable<? extends PickerPhoto> iterable) {
            Iterable<? extends PickerPhoto> iterable2 = iterable;
            PhotoPickerPresenterImpl photoPickerPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(iterable2, "it");
            PhotoPickerPresenterImpl.access$onNewLoadingPhotos(photoPickerPresenterImpl, iterable2);
        }
    }

    public static final class g<T, R> implements Function<Iterable<? extends PickerPhoto>, ObservableSource<? extends PickerPhoto>> {
        public final /* synthetic */ PhotoPickerPresenterImpl a;

        public g(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
            this.a = photoPickerPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.photo_picker.legacy.PhotoPickerInteractor */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends PickerPhoto> apply(Iterable<? extends PickerPhoto> iterable) {
            Iterable<? extends PickerPhoto> iterable2 = iterable;
            Intrinsics.checkNotNullParameter(iterable2, "it");
            return this.a.l.addPhotos(iterable2);
        }
    }

    public static final class h<T> implements Consumer<PickerPhoto> {
        public final /* synthetic */ PhotoPickerPresenterImpl a;

        public h(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
            this.a = photoPickerPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(PickerPhoto pickerPhoto) {
            PickerPhoto pickerPhoto2 = pickerPhoto;
            PhotoPickerPresenterImpl photoPickerPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(pickerPhoto2, "it");
            PhotoPickerPresenterImpl.access$onPhotoLoaded(photoPickerPresenterImpl, pickerPhoto2);
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public final /* synthetic */ PhotoPickerPresenterImpl a;

        public i(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
            this.a = photoPickerPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            PhotoPickerPresenterImpl.access$onAddPhotoError(this.a);
        }
    }

    public static final class j extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ PhotoPickerPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
            super(1);
            this.a = photoPickerPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Unit unit) {
            if (PhotoPickerPresenterImpl.access$getPhotoPickerViewModel$p(this.a).getMode() == PublishIntentFactory.PhotoPickerMode.MODE_ADD) {
                PhotoPickerPresenterImpl.access$getPhotoPickerViewModel$p(this.a).handleBack(true);
                this.a.f();
            } else {
                this.a.handleContinueButtonClick();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function1<Throwable, Unit> {
        public static final k a = new k();

        public k() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            Logs.error("PhotoPickerPresenter", "subscribeContinueClicks", th2);
            return Unit.INSTANCE;
        }
    }

    public PhotoPickerPresenterImpl(@NotNull AdapterPresenter adapterPresenter, @NotNull AdapterPresenter adapterPresenter2, @NotNull PhotoPickerInteractor photoPickerInteractor, @NotNull CameraItemPresenter cameraItemPresenter, @NotNull RotationInteractor rotationInteractor, @NotNull PhotoPickerPresenterResourceProvider photoPickerPresenterResourceProvider, @NotNull SchedulersFactory schedulersFactory, int i2, int i3, @NotNull Analytics analytics, boolean z, boolean z2, @NotNull ComputerVisionInteractor computerVisionInteractor, @NotNull RandomKeyProvider randomKeyProvider, @NotNull PhotoPickerEventTracker photoPickerEventTracker, @Nullable PhotoPickerPresenterState photoPickerPresenterState) {
        String str;
        Intrinsics.checkNotNullParameter(adapterPresenter, "detailsAdapterPresenter");
        Intrinsics.checkNotNullParameter(adapterPresenter2, "thumbnailsAdapterPresenter");
        Intrinsics.checkNotNullParameter(photoPickerInteractor, "interactor");
        Intrinsics.checkNotNullParameter(cameraItemPresenter, "cameraPresenter");
        Intrinsics.checkNotNullParameter(rotationInteractor, "rotationInteractor");
        Intrinsics.checkNotNullParameter(photoPickerPresenterResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(computerVisionInteractor, "cvInteractor");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        Intrinsics.checkNotNullParameter(photoPickerEventTracker, "eventTracker");
        this.j = adapterPresenter;
        this.k = adapterPresenter2;
        this.l = photoPickerInteractor;
        this.m = cameraItemPresenter;
        this.n = rotationInteractor;
        this.o = photoPickerPresenterResourceProvider;
        this.p = schedulersFactory;
        this.q = i2;
        this.r = i3;
        this.s = analytics;
        this.t = z;
        this.u = z2;
        this.v = computerVisionInteractor;
        this.w = randomKeyProvider;
        this.x = photoPickerEventTracker;
        this.y = photoPickerPresenterState;
        this.b = (photoPickerPresenterState == null || (str = photoPickerPresenterState.getSelectedImageId()) == null) ? "PhotoPickerPresenterImpl_add_photo_id" : str;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.d = compositeDisposable;
        this.f = new ListDataSource<>(CollectionsKt__CollectionsKt.emptyList());
        List<PickerPhoto> loadingPhotos = photoPickerPresenterState != null ? photoPickerPresenterState.getLoadingPhotos() : null;
        this.i = CollectionsKt___CollectionsKt.toMutableList((Collection) (loadingPhotos == null ? CollectionsKt__CollectionsKt.emptyList() : loadingPhotos));
        Flowable<Rotation> filter = rotationInteractor.getRotationFlowable().filter(a2.a.a.x1.q.g.a);
        Intrinsics.checkNotNullExpressionValue(filter, "rotationInteractor.getRo…Rotation.Rotation_180() }");
        DisposableKt.plusAssign(compositeDisposable, Flowables.subscribeOnNext(filter, new a2.a.a.x1.q.h(this)));
        cameraItemPresenter.setPhotoSourcesChangeListener(this);
    }

    public static final void access$continuePhotoProcessing(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
        if (!photoPickerPresenterImpl.i.isEmpty()) {
            DisposableKt.plusAssign(photoPickerPresenterImpl.d, photoPickerPresenterImpl.a(Singles.toSingle(photoPickerPresenterImpl.i)));
        }
    }

    public static final Single access$delayIfNeeded(PhotoPickerPresenterImpl photoPickerPresenterImpl, boolean z) {
        Objects.requireNonNull(photoPickerPresenterImpl);
        if (z) {
            return Singles.toSingle(Boolean.valueOf(z)).delay(3, TimeUnit.SECONDS, photoPickerPresenterImpl.p.computation());
        }
        return Singles.toSingle(Boolean.valueOf(z));
    }

    public static final /* synthetic */ PhotoPickerViewModel access$getPhotoPickerViewModel$p(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
        PhotoPickerViewModel photoPickerViewModel = photoPickerPresenterImpl.h;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        return photoPickerViewModel;
    }

    public static final void access$handleRotation(PhotoPickerPresenterImpl photoPickerPresenterImpl, Rotation rotation) {
        PhotoPickerView photoPickerView = photoPickerPresenterImpl.a;
        if (photoPickerView != null) {
            photoPickerView.rotateUi(rotation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0092, code lost:
        if (r0.size() < r9.r) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0098, code lost:
        if (r9.getMode() != r2) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009a, code lost:
        r0 = r9.g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009c, code lost:
        if (r0 != null) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009e, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("photos");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a1, code lost:
        r0 = (com.avito.android.photo_picker.legacy.thumbnail_list.UriPhotoItem) kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull((java.util.List<? extends java.lang.Object>) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a7, code lost:
        if (r0 == null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a9, code lost:
        r0 = r0.getStringId();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ad, code lost:
        if (r0 == null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b0, code lost:
        r0 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b2, code lost:
        r9.b = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$initialDataLoaded(com.avito.android.photo_picker.legacy.PhotoPickerPresenterImpl r9, java.util.List r10) {
        /*
        // Method dump skipped, instructions count: 263
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.photo_picker.legacy.PhotoPickerPresenterImpl.access$initialDataLoaded(com.avito.android.photo_picker.legacy.PhotoPickerPresenterImpl, java.util.List):void");
    }

    public static final boolean access$isCropEnabled(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
        return photoPickerPresenterImpl.u;
    }

    public static final void access$onAddPhotoError(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
        PhotoPickerView photoPickerView = photoPickerPresenterImpl.a;
        if (photoPickerView != null) {
            photoPickerView.showWarning(photoPickerPresenterImpl.o.getAddPhotoError());
        }
    }

    public static final void access$onNewLoadingPhotos(PhotoPickerPresenterImpl photoPickerPresenterImpl, Iterable iterable) {
        int i2;
        Objects.requireNonNull(photoPickerPresenterImpl);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            photoPickerPresenterImpl.i.add((PickerPhoto) it.next());
        }
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(iterable, 10));
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            arrayList.add(photoPickerPresenterImpl.g((PickerPhoto) it2.next()));
        }
        Iterator it3 = arrayList.iterator();
        while (true) {
            i2 = 0;
            if (!it3.hasNext()) {
                break;
            }
            UriPhotoItem uriPhotoItem = (UriPhotoItem) it3.next();
            ArrayList<UriPhotoItem> arrayList2 = photoPickerPresenterImpl.g;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photos");
            }
            Iterator<UriPhotoItem> it4 = arrayList2.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    i2 = -1;
                    break;
                } else if (Intrinsics.areEqual(it4.next().getStringId(), uriPhotoItem.getStringId())) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                ArrayList<UriPhotoItem> arrayList3 = photoPickerPresenterImpl.g;
                if (arrayList3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photos");
                }
                arrayList3.add(uriPhotoItem);
            } else {
                ArrayList<UriPhotoItem> arrayList4 = photoPickerPresenterImpl.g;
                if (arrayList4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photos");
                }
                arrayList4.set(i2, uriPhotoItem);
            }
        }
        String id = ((PickerPhoto) CollectionsKt___CollectionsKt.last(iterable)).getId();
        ArrayList<UriPhotoItem> arrayList5 = photoPickerPresenterImpl.g;
        if (arrayList5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photos");
        }
        if (arrayList5.size() < photoPickerPresenterImpl.r) {
            PhotoPickerViewModel photoPickerViewModel = photoPickerPresenterImpl.h;
            if (photoPickerViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
            }
            if (photoPickerViewModel.getMode() == PublishIntentFactory.PhotoPickerMode.MODE_LEGACY) {
                id = "PhotoPickerPresenterImpl_add_photo_id";
            }
        }
        photoPickerPresenterImpl.d(id, true);
        int count = photoPickerPresenterImpl.f.getCount();
        photoPickerPresenterImpl.b(true);
        int count2 = photoPickerPresenterImpl.f.getCount();
        Iterator<BasePhotoItem> it5 = photoPickerPresenterImpl.f.iterator();
        int i3 = 0;
        while (true) {
            if (!it5.hasNext()) {
                i3 = -1;
                break;
            }
            BasePhotoItem next = it5.next();
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(next.getStringId(), "PhotoPickerPresenterImpl_add_photo_id")) {
                break;
            }
            i3++;
        }
        if (i3 != -1) {
            i2 = 1;
        }
        int i4 = count - 1;
        int i5 = count2 - count;
        if (i2 != 0) {
            PhotoPickerView photoPickerView = photoPickerPresenterImpl.a;
            if (photoPickerView != null) {
                photoPickerView.onDetailsListRangeChanged(i4, i5);
            }
        } else {
            PhotoPickerView photoPickerView2 = photoPickerPresenterImpl.a;
            if (photoPickerView2 != null) {
                photoPickerView2.onDetailsListRangeChanged(i4, i5 - 1);
            }
            PhotoPickerView photoPickerView3 = photoPickerPresenterImpl.a;
            if (photoPickerView3 != null) {
                photoPickerView3.onDetailsListItemChanged(count2);
            }
        }
        photoPickerPresenterImpl.h();
    }

    public static final void access$onPhotoLoaded(PhotoPickerPresenterImpl photoPickerPresenterImpl, PickerPhoto pickerPhoto) {
        List<PickerPhoto> list = photoPickerPresenterImpl.i;
        for (T t2 : list) {
            if (Intrinsics.areEqual(t2.getId(), pickerPhoto.getId())) {
                list.remove(t2);
                String id = pickerPhoto.getId();
                UriPhotoItem g2 = photoPickerPresenterImpl.g(pickerPhoto);
                ArrayList<UriPhotoItem> arrayList = photoPickerPresenterImpl.g;
                if (arrayList == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photos");
                }
                ArrayList<UriPhotoItem> arrayList2 = photoPickerPresenterImpl.g;
                if (arrayList2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photos");
                }
                ArrayList<UriPhotoItem> arrayList3 = photoPickerPresenterImpl.g;
                if (arrayList3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photos");
                }
                arrayList.set(CollectionsKt___CollectionsKt.indexOf((List<? extends UriPhotoItem>) arrayList2, PhotoPickerPresenterKt.m91access$getByStringId((List) arrayList3, id)), g2);
                photoPickerPresenterImpl.b(true);
                PhotoPickerView photoPickerView = photoPickerPresenterImpl.a;
                if (photoPickerView != null) {
                    ArrayList<UriPhotoItem> arrayList4 = photoPickerPresenterImpl.g;
                    if (arrayList4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("photos");
                    }
                    photoPickerView.onDetailsListItemChanged(arrayList4.indexOf(g2));
                }
                photoPickerPresenterImpl.h();
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final void access$trackCropAccepted(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
        photoPickerPresenterImpl.s.track(new CropActionEvent(2));
    }

    public final Disposable a(Single<? extends Iterable<PickerPhoto>> single) {
        Disposable subscribe = single.doOnSuccess(new f(this)).observeOn(this.p.computation()).flatMapObservable(new g(this)).observeOn(this.p.mainThread()).subscribe(new h(this), new i(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "doOnSuccess { onNewLoadi…}, { onAddPhotoError() })");
        return subscribe;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerPresenter
    public void attachRouter(@NotNull PhotoPickerPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.c = router;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerPresenter
    public void attachView(@NotNull PhotoPickerView photoPickerView) {
        Intrinsics.checkNotNullParameter(photoPickerView, "view");
        if (this.a == null && getMode() == PublishIntentFactory.PhotoPickerMode.MODE_EDIT) {
            this.x.track(OpenPhotoListEditEvent.INSTANCE);
        }
        this.a = photoPickerView;
        h();
        CompositeDisposable compositeDisposable = this.d;
        Single<List<PickerPhoto>> observeOn = this.l.select().observeOn(this.p.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "interactor.select()\n    …(schedulers.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy(observeOn, a2.a.a.x1.q.f.a, new a2.a.a.x1.q.e(this)));
        f();
        photoPickerView.setThumbnailsListVisibility(!this.t);
    }

    public final void b(boolean z) {
        ArrayList<UriPhotoItem> arrayList = this.g;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photos");
        }
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        if (mutableList.size() < this.r) {
            PhotoPickerViewModel photoPickerViewModel = this.h;
            if (photoPickerViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
            }
            if (photoPickerViewModel.getMode() == PublishIntentFactory.PhotoPickerMode.MODE_LEGACY) {
                mutableList.add(new ResourcePhotoItem("PhotoPickerPresenterImpl_add_photo_id", R.drawable.img_camera_thumbnail_48, Intrinsics.areEqual(this.b, "PhotoPickerPresenterImpl_add_photo_id")));
            }
        }
        ListDataSource<BasePhotoItem> listDataSource = new ListDataSource<>(mutableList);
        this.f = listDataSource;
        this.k.onDataSourceChanged(listDataSource);
        PhotoPickerView photoPickerView = this.a;
        if (photoPickerView != null) {
            photoPickerView.onThumbnailsListChanged();
        }
        if (z) {
            this.j.onDataSourceChanged(this.f);
            PhotoPickerView photoPickerView2 = this.a;
            if (photoPickerView2 != null) {
                photoPickerView2.onDetailsListChanged();
            }
        }
    }

    public final void c(String str, boolean z) {
        PhotoPickerView photoPickerView = this.a;
        if (photoPickerView != null) {
            ArrayList<UriPhotoItem> arrayList = this.g;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photos");
            }
            ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList, 10));
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().getStringId());
            }
            int indexOf = CollectionsKt___CollectionsKt.plus((Collection<? extends String>) arrayList2, "PhotoPickerPresenterImpl_add_photo_id").indexOf(str);
            if (indexOf != -1) {
                photoPickerView.ensureThumbnailIsVisible(indexOf);
                if (z) {
                    photoPickerView.scrollDetailsListToPosition(indexOf);
                }
            }
        }
    }

    public final void d(String str, boolean z) {
        ArrayList<UriPhotoItem> arrayList = this.g;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photos");
        }
        UriPhotoItem access$getByStringId = PhotoPickerPresenterKt.m91access$getByStringId((List) arrayList, this.b);
        if (access$getByStringId != null) {
            access$getByStringId.setSelected(false);
        }
        e(str);
        c(str, z);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerPresenter
    public void detachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerPresenter
    public void detachView() {
        PhotoPickerView photoPickerView = this.a;
        if (photoPickerView != null) {
            photoPickerView.onDetach();
        }
        this.a = null;
        this.d.clear();
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.e = null;
    }

    public final void e(String str) {
        if (Intrinsics.areEqual(str, "PhotoPickerPresenterImpl_add_photo_id")) {
            this.b = "PhotoPickerPresenterImpl_add_photo_id";
            return;
        }
        ArrayList<UriPhotoItem> arrayList = this.g;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photos");
        }
        UriPhotoItem access$getByStringId = PhotoPickerPresenterKt.m91access$getByStringId((List) arrayList, str);
        if (access$getByStringId != null) {
            this.b = str;
            Logs.debug$default("PhotoPickerPresenter", "photo set selection with selected true", null, 4, null);
            access$getByStringId.setSelected(true);
            return;
        }
        this.b = "";
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView.Presenter
    public void editSelectedPhoto() {
        PhotoPickerViewModel photoPickerViewModel = this.h;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        photoPickerViewModel.editSelectedPhoto(this.b);
    }

    public final void f() {
        PhotoPickerView photoPickerView = this.a;
        if (photoPickerView != null) {
            Disposable disposable = this.e;
            if (disposable != null) {
                disposable.dispose();
            }
            Single<Unit> observeOn = photoPickerView.continueClicks().firstOrError().observeOn(this.p.mainThread());
            Intrinsics.checkNotNullExpressionValue(observeOn, "view\n            .contin…(schedulers.mainThread())");
            this.e = SubscribersKt.subscribeBy(observeOn, k.a, new j(this));
        }
    }

    public final UriPhotoItem g(PickerPhoto pickerPhoto) {
        Uri uri;
        if (pickerPhoto.isLoaded()) {
            uri = pickerPhoto.getUri();
        } else {
            uri = pickerPhoto.getThumbnail();
        }
        return new UriPhotoItem(pickerPhoto.getId(), uri, pickerPhoto.getSource(), Intrinsics.areEqual(pickerPhoto.getId(), this.b), !pickerPhoto.isLoaded(), null, 32, null);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerPresenter
    @Nullable
    public UriPhotoItem getFirstPhoto() {
        T t2;
        ArrayList<UriPhotoItem> arrayList = this.g;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photos");
        }
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (!t2.isLoading()) {
                break;
            }
        }
        return t2;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView.Presenter
    @NotNull
    public PublishIntentFactory.PhotoPickerMode getMode() {
        PhotoPickerViewModel photoPickerViewModel = this.h;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        return photoPickerViewModel.getMode();
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerPresenter
    @NotNull
    public PhotoPickerPresenterState getState() {
        String str = this.b;
        List<PickerPhoto> list = this.i;
        PhotoPickerViewModel photoPickerViewModel = this.h;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        return new PhotoPickerPresenterState(str, list, photoPickerViewModel.getSelectedPhotos$photo_picker_release());
    }

    public final void h() {
        PhotoPickerView photoPickerView = this.a;
        if (photoPickerView != null) {
            photoPickerView.setContinueButtonEnabled(this.i.isEmpty());
        }
        PhotoPickerView photoPickerView2 = this.a;
        if (photoPickerView2 != null) {
            ArrayList<UriPhotoItem> arrayList = this.g;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photos");
            }
            photoPickerView2.setContinueButtonVisibility(arrayList.size() >= this.q);
        }
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerPresenter
    public void handleContinueButtonClick() {
        PhotoPickerView photoPickerView = this.a;
        if (photoPickerView != null) {
            CompositeDisposable compositeDisposable = this.d;
            Completable observeOn = Singles.toSingle(Boolean.valueOf(this.v.needTimeToUploading())).doOnEvent(new a(photoPickerView)).flatMap(new b(this)).flatMapCompletable(new c(this)).observeOn(this.p.mainThread());
            Intrinsics.checkNotNullExpressionValue(observeOn, "cvInteractor.needTimeToU…(schedulers.mainThread())");
            DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy(observeOn, new e(this), new d(this)));
        }
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerPresenter
    public void hideFullScreenLoading() {
        PhotoPickerView photoPickerView = this.a;
        if (photoPickerView != null) {
            photoPickerView.hideProgress();
        }
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoMover
    public void movePhoto(int i2, int i3) {
        ArrayList<UriPhotoItem> arrayList = this.g;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photos");
        }
        if (i3 < arrayList.size()) {
            this.l.swapPhotos(i3, i2);
            PhotoPickerViewModel photoPickerViewModel = this.h;
            if (photoPickerViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
            }
            photoPickerViewModel.swapPhotosByPosition(i2, i3);
            b(true);
            PhotoPickerView photoPickerView = this.a;
            if (photoPickerView != null) {
                photoPickerView.onDetailsListItemChanged(i2);
            }
            PhotoPickerView photoPickerView2 = this.a;
            if (photoPickerView2 != null) {
                photoPickerView2.onDetailsListItemChanged(i3);
            }
            ArrayList<UriPhotoItem> arrayList2 = this.g;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photos");
            }
            d(arrayList2.get(i3).getStringId(), true);
        }
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView.Presenter
    public void onCancelClicked() {
        PhotoPickerPresenter.Router router = this.c;
        if (router != null) {
            router.onCancel();
        }
        if (this.u) {
            ArrayList<UriPhotoItem> arrayList = this.g;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photos");
            }
            if (!arrayList.isEmpty()) {
                this.s.track(new CropActionEvent(1));
            }
        }
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView.Presenter
    public void onDetailsListScrollFinished(int i2) {
        if (Intrinsics.areEqual(this.f.getItem(i2).getStringId(), "PhotoPickerPresenterImpl_add_photo_id")) {
            this.m.startPreview();
        }
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView.Presenter
    public void onDetailsListScrolled(int i2) {
        if (i2 < this.f.getCount() && i2 >= 0) {
            d(this.f.getItem(i2).getStringId(), false);
            b(false);
        }
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter.Listener
    public void onNewPhotos(@NotNull List<SelectedPhoto> list) {
        Intrinsics.checkNotNullParameter(list, "uris");
        b(true);
        PhotoPickerViewModel photoPickerViewModel = this.h;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        List<SelectedPhoto> filterAddedPhotos = photoPickerViewModel.filterAddedPhotos(list);
        ArrayList<UriPhotoItem> arrayList = this.g;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photos");
        }
        int size = arrayList.size();
        ArrayList<UriPhotoItem> arrayList2 = this.g;
        if (arrayList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photos");
        }
        ArrayList arrayList3 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList2, 10));
        Iterator<T> it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(it.next().getStringId());
        }
        Set set = CollectionsKt___CollectionsKt.toSet(arrayList3);
        ArrayList arrayList4 = new ArrayList(t6.n.e.collectionSizeOrDefault(filterAddedPhotos, 10));
        Iterator<T> it2 = filterAddedPhotos.iterator();
        while (it2.hasNext()) {
            arrayList4.add(it2.next().getId());
        }
        int size2 = z.plus(set, (Iterable) CollectionsKt___CollectionsKt.toSet(arrayList4)).size();
        int i2 = this.r;
        if (size2 > i2) {
            PhotoPickerView photoPickerView = this.a;
            if (photoPickerView != null) {
                photoPickerView.showWarning(this.o.getPhotosExceededLimitMessage(i2));
            }
            filterAddedPhotos = CollectionsKt___CollectionsKt.take(filterAddedPhotos, this.r - size);
        }
        if (!filterAddedPhotos.isEmpty()) {
            CompositeDisposable compositeDisposable = this.d;
            PhotoPickerViewModel photoPickerViewModel2 = this.h;
            if (photoPickerViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
            }
            DisposableKt.plusAssign(compositeDisposable, a(photoPickerViewModel2.createPhotos(filterAddedPhotos)));
            int ordinal = ((SelectedPhoto) CollectionsKt___CollectionsKt.first((List<? extends Object>) list)).getSource().ordinal();
            if (ordinal != 1) {
                if (ordinal == 3 && this.u) {
                    this.s.track(new CropSourceEvent(2));
                }
            } else if (this.u) {
                this.s.track(new CropSourceEvent(1));
            }
        }
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.EditorItemPresenter.Listener
    public void onPhotoCropped(@NotNull String str, @NotNull Transformation transformation) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(transformation, "transformation");
        ArrayList<UriPhotoItem> arrayList = this.g;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photos");
        }
        UriPhotoItem access$getByStringId = PhotoPickerPresenterKt.m91access$getByStringId((List) arrayList, str);
        if (access$getByStringId != null) {
            access$getByStringId.setTransformation(transformation);
        }
    }

    @Override // com.avito.android.photo_picker.legacy.OnPhotoSourcesAvailableChangeListener
    public void onPhotoSourcesChanged(boolean z) {
        PhotoPickerView photoPickerView = this.a;
        if (photoPickerView != null) {
            photoPickerView.setThumbnailsListVisibility(z && !this.t);
        }
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.EditorItemPresenter.Listener
    public void onRemovePhoto(@NotNull String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "id");
        ArrayList<UriPhotoItem> arrayList = this.g;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photos");
        }
        Iterator<UriPhotoItem> it = arrayList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getStringId(), str)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            ArrayList<UriPhotoItem> arrayList2 = this.g;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photos");
            }
            Uri photoUri = arrayList2.get(i2).getPhotoUri();
            if (photoUri != null) {
                PhotoPickerViewModel photoPickerViewModel = this.h;
                if (photoPickerViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
                }
                photoPickerViewModel.unselectPhotoByUri(photoUri);
            }
            List<PickerPhoto> list = this.i;
            PickerPhoto access$getByStringId = PhotoPickerPresenterKt.access$getByStringId((List) list, str);
            Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            TypeIntrinsics.asMutableCollection(list).remove(access$getByStringId);
            ArrayList<UriPhotoItem> arrayList3 = this.g;
            if (arrayList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photos");
            }
            if (!arrayList3.isEmpty()) {
                ArrayList<UriPhotoItem> arrayList4 = this.g;
                if (arrayList4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photos");
                }
                int min = Math.min(i2, CollectionsKt__CollectionsKt.getLastIndex(arrayList4));
                ArrayList<UriPhotoItem> arrayList5 = this.g;
                if (arrayList5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photos");
                }
                str2 = arrayList5.get(min).getStringId();
            } else {
                str2 = "PhotoPickerPresenterImpl_add_photo_id";
            }
            e(str2);
            b(true);
            c(str2, true);
            h();
            if (this.u) {
                this.s.track(new CropActionEvent(1));
            }
            ArrayList<UriPhotoItem> arrayList6 = this.g;
            if (arrayList6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photos");
            }
            if (arrayList6.isEmpty()) {
                PhotoPickerViewModel photoPickerViewModel2 = this.h;
                if (photoPickerViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
                }
                if (photoPickerViewModel2.getMode() == PublishIntentFactory.PhotoPickerMode.MODE_ADD) {
                    PhotoPickerViewModel photoPickerViewModel3 = this.h;
                    if (photoPickerViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
                    }
                    PhotoPickerViewModel.handleBack$default(photoPickerViewModel3, false, 1, null);
                    return;
                }
                PhotoPickerViewModel photoPickerViewModel4 = this.h;
                if (photoPickerViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
                }
                if (photoPickerViewModel4.getMode() == PublishIntentFactory.PhotoPickerMode.MODE_EDIT) {
                    PhotoPickerViewModel photoPickerViewModel5 = this.h;
                    if (photoPickerViewModel5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
                    }
                    photoPickerViewModel5.closeWithSuccess();
                }
            }
        }
    }

    @Override // com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemPresenter.Listener
    public void onThumbnailClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (!Intrinsics.areEqual(str, this.b)) {
            d(str, true);
            b(true);
            if (Intrinsics.areEqual(str, "PhotoPickerPresenterImpl_add_photo_id")) {
                this.m.startPreview();
            }
        } else if (Intrinsics.areEqual(str, "PhotoPickerPresenterImpl_add_photo_id")) {
            this.m.onTakeShotClicked();
        }
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView.Presenter
    public void removeSelectedPhoto() {
        PhotoPickerEventTracker photoPickerEventTracker = this.x;
        PhotoPickerViewModel photoPickerViewModel = this.h;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        photoPickerEventTracker.track(new DeletePhotoFromListEvent(photoPickerViewModel.getUploadImageId(this.b)));
        onRemovePhoto(this.b);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerPresenter
    public void setSelectedPhotoId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.b = str;
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerPresenter
    public void setViewModel(@NotNull PhotoPickerViewModel photoPickerViewModel) {
        Intrinsics.checkNotNullParameter(photoPickerViewModel, "viewModel");
        this.h = photoPickerViewModel;
        PhotoPickerPresenterState photoPickerPresenterState = this.y;
        if (!(photoPickerPresenterState == null || photoPickerPresenterState.getSelectedPhotos() == null)) {
            for (SelectedPhoto selectedPhoto : this.y.getSelectedPhotos()) {
                PhotoPickerViewModel photoPickerViewModel2 = this.h;
                if (photoPickerViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
                }
                if (photoPickerViewModel2.isUriSelected(selectedPhoto.getUri()) == 0) {
                    PhotoPickerViewModel photoPickerViewModel3 = this.h;
                    if (photoPickerViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
                    }
                    PhotoPickerViewModel.selectPhotoByUri$default(photoPickerViewModel3, selectedPhoto.getUri(), selectedPhoto.getSource(), selectedPhoto.getId(), null, 8, null);
                }
            }
        }
        PhotoPickerViewModel photoPickerViewModel4 = this.h;
        if (photoPickerViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        this.g = photoPickerViewModel4.getPhotos$photo_picker_release();
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerPresenter
    public void showFullScreenLoading() {
        PhotoPickerView photoPickerView = this.a;
        if (photoPickerView != null) {
            photoPickerView.showProgress();
        }
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter.Listener
    public void onNewPhotos(@NotNull List<? extends Uri> list, @NotNull PhotoSource photoSource) {
        Intrinsics.checkNotNullParameter(list, "uris");
        Intrinsics.checkNotNullParameter(photoSource, "source");
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new SelectedPhoto(it.next(), photoSource, this.w.generateKey(), null, null, null, 56, null));
        }
        onNewPhotos(arrayList);
    }
}
