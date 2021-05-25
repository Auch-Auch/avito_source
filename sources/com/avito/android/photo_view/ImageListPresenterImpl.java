package com.avito.android.photo_view;

import a2.g.r.g;
import com.avito.android.lib.design.R;
import com.avito.android.photo_picker.legacy.service.UploadingInteractor;
import com.avito.android.photo_view.ImageData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u0010J\u001a\u00020G\u0012\u0006\u0010d\u001a\u00020a¢\u0006\u0004\bg\u0010hJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\u0011J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\bJ\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\bJ\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0015H\u0016¢\u0006\u0004\b%\u0010\u0018J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0015H\u0016¢\u0006\u0004\b'\u0010\u0018J\u000f\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b(\u0010\bJ\u001d\u0010,\u001a\u00020\u00042\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002¢\u0006\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103Rj\u0010:\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019 7*\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010606 7**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019 7*\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010606\u0018\u000105058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R:\u0010D\u001a&\u0012\f\u0012\n 7*\u0004\u0018\u00010\u00190\u0019 7*\u0012\u0012\f\u0012\n 7*\u0004\u0018\u00010\u00190\u0019\u0018\u00010B0B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010CR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR:\u0010\u001f\u001a&\u0012\f\u0012\n 7*\u0004\u0018\u00010\u00190\u0019 7*\u0012\u0012\f\u0012\n 7*\u0004\u0018\u00010\u00190\u0019\u0018\u000105058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u00109R\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\u00198V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bY\u0010ZR*\u0010`\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020\u00198\u0016@VX\u000e¢\u0006\u0012\n\u0004\b,\u0010<\u001a\u0004\b]\u0010Z\"\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020R8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u0010T¨\u0006i"}, d2 = {"Lcom/avito/android/photo_view/ImageListPresenterImpl;", "Lcom/avito/android/photo_view/ImageListPresenter;", "Lcom/avito/android/photo_view/ImageListView;", "view", "", "attachView", "(Lcom/avito/android/photo_view/ImageListView;)V", "detachView", "()V", "Lcom/avito/android/photo_view/ImageListRouter;", "router", "attachRouter", "(Lcom/avito/android/photo_view/ImageListRouter;)V", "detachRouter", "", "id", "onRemoveClicked", "(Ljava/lang/String;)V", "onRetryClicked", "onRootViewClicked", "hideAllRemoveButtons", "", "success", "onPhotoPickerResult", "(Z)V", "", "fromPosition", "toPosition", "movePhoto", "(II)V", "Lio/reactivex/Observable;", "photoCountChanges", "()Lio/reactivex/Observable;", "showPhotoPicker", "showVideoPicker", "addNewPhoto", "enabled", "setVideoEnabled", "hasError", "setCameraError", AuthSource.BOOKING_ORDER, "", "Lcom/avito/android/photo_view/ImageData;", "newPhotos", AuthSource.SEND_ABUSE, "(Ljava/util/List;)V", "Lio/reactivex/disposables/Disposable;", g.a, "Lio/reactivex/disposables/Disposable;", "photoSubscription", "i", "Z", "isVideoEnabled", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lkotlin/Pair;", "kotlin.jvm.PlatformType", "c", "Lcom/jakewharton/rxrelay2/PublishRelay;", "moveObservable", "h", "I", "loadedPhotosCount", "Lcom/avito/android/photo_view/ImageListInteractor;", "n", "Lcom/avito/android/photo_view/ImageListInteractor;", "interactor", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "maxImageCountObservable", "f", "Lcom/avito/android/photo_view/ImageListRouter;", "Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "o", "Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "uploadInteractor", "e", "Lcom/avito/android/photo_view/ImageListView;", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "d", "Lcom/avito/android/photo_view/PlaceholderImageData;", "k", "Lcom/avito/android/photo_view/PlaceholderImageData;", "appendingVideoView", "l", "Ljava/util/List;", "items", "getCurrentPhotoCount", "()I", "currentPhotoCount", "maxCount", "getMaxImageCount", "setMaxImageCount", "(I)V", "maxImageCount", "Lcom/avito/android/util/SchedulersFactory;", "p", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "j", "appendingPhotoView", "<init>", "(Lcom/avito/android/photo_view/ImageListInteractor;Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;Lcom/avito/android/util/SchedulersFactory;)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public final class ImageListPresenterImpl implements ImageListPresenter {
    public int a;
    public final BehaviorRelay<Integer> b = BehaviorRelay.create();
    public final PublishRelay<Pair<Integer, Integer>> c = PublishRelay.create();
    public final PublishRelay<Integer> d = PublishRelay.create();
    public ImageListView e;
    public ImageListRouter f;
    public Disposable g;
    public int h;
    public boolean i;
    public PlaceholderImageData j;
    public PlaceholderImageData k;
    public List<? extends ImageData> l;
    public final CompositeDisposable m;
    public final ImageListInteractor n;
    public final UploadingInteractor o;
    public final SchedulersFactory p;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<List<? extends ImageData>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.jakewharton.rxrelay2.PublishRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(List<? extends ImageData> list) {
            int i = this.a;
            if (i == 0) {
                List<? extends ImageData> list2 = list;
                ImageListPresenterImpl imageListPresenterImpl = (ImageListPresenterImpl) this.b;
                Intrinsics.checkNotNullExpressionValue(list2, "photos");
                ArrayList arrayList = new ArrayList();
                for (T t : list2) {
                    if (t.getState() instanceof ImageData.State.Completed) {
                        arrayList.add(t);
                    }
                }
                imageListPresenterImpl.h = arrayList.size();
            } else if (i == 1) {
                ((ImageListPresenterImpl) this.b).d.accept(Integer.valueOf(list.size()));
            } else if (i == 2) {
                List<? extends ImageData> list3 = list;
                Intrinsics.checkNotNullExpressionValue(list3, "it");
                ((ImageListPresenterImpl) this.b).a(list3);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Unable to show photos!", th);
        }
    }

    public ImageListPresenterImpl(@NotNull ImageListInteractor imageListInteractor, @NotNull UploadingInteractor uploadingInteractor, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(imageListInteractor, "interactor");
        Intrinsics.checkNotNullParameter(uploadingInteractor, "uploadInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.n = imageListInteractor;
        this.o = uploadingInteractor;
        this.p = schedulersFactory;
        ImageData.State.NotAdded notAdded = ImageData.State.NotAdded.INSTANCE;
        this.j = new PlaceholderImageData(ImageListPresenterKt.PHOTO_CAMERA_ITEM_ID, null, notAdded, Integer.valueOf(R.string.photo_uploader_appending_add), Integer.valueOf(R.drawable.ic_camera_32));
        this.k = new PlaceholderImageData(ImageListPresenterKt.VIDEO_CAMERA_ITEM_ID, null, notAdded, Integer.valueOf(R.string.add_video), Integer.valueOf(R.drawable.ic_video_camera));
        this.l = CollectionsKt__CollectionsKt.emptyList();
        this.m = new CompositeDisposable();
    }

    public final void a(List<? extends ImageData> list) {
        this.l = list;
        if (list.size() < getMaxImageCount()) {
            if (this.i) {
                list = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) CollectionsKt__CollectionsKt.listOf((Object[]) new PlaceholderImageData[]{this.j, this.k}));
            } else {
                list = CollectionsKt___CollectionsKt.plus((Collection<? extends PlaceholderImageData>) list, this.j);
            }
        }
        ImageListView imageListView = this.e;
        if (imageListView != null) {
            imageListView.show(list);
        }
    }

    @Override // com.avito.android.photo_view.ImageListPresenter
    public void addNewPhoto() {
        showPhotoPicker(this.j.getId());
    }

    @Override // com.avito.android.photo_view.ImageListPresenter
    public void attachRouter(@NotNull ImageListRouter imageListRouter) {
        Intrinsics.checkNotNullParameter(imageListRouter, "router");
        this.f = imageListRouter;
    }

    @Override // com.avito.android.photo_view.ImageListPresenter
    public void attachView(@NotNull ImageListView imageListView) {
        Intrinsics.checkNotNullParameter(imageListView, "view");
        this.e = imageListView;
        b();
        CompositeDisposable compositeDisposable = this.m;
        Disposable subscribe = this.c.distinctUntilChanged().subscribe(new a2.a.a.y1.a(this), a2.a.a.y1.b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "moveObservable\n         …move\", t) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void b() {
        Observable<List<ImageData>> select = this.n.select();
        BehaviorRelay<Integer> behaviorRelay = this.b;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay, "maxImageCountObservable");
        Observable<R> withLatestFrom = select.withLatestFrom(behaviorRelay, new BiFunction<List<? extends ImageData>, Integer, R>() { // from class: com.avito.android.photo_view.ImageListPresenterImpl$subscribeToPhotos$$inlined$withLatestFrom$1
            @Override // io.reactivex.functions.BiFunction
            public final R apply(List<? extends ImageData> list, Integer num) {
                int intValue = num.intValue();
                R r = (R) list;
                return r.size() > intValue ? (R) r.subList(0, intValue) : r;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
        this.g = withLatestFrom.subscribeOn(this.p.computation()).observeOn(this.p.mainThread()).doOnNext(new a(0, this)).doOnNext(new a(1, this)).subscribe(new a(2, this), b.a);
    }

    @Override // com.avito.android.photo_view.ImageListPresenter
    public void detachRouter() {
        this.f = null;
    }

    @Override // com.avito.android.photo_view.ImageListPresenter
    public void detachView() {
        this.e = null;
        Disposable disposable = this.g;
        if (disposable != null) {
            disposable.dispose();
        }
        this.g = null;
        this.m.clear();
    }

    @Override // com.avito.android.photo_view.ImageListPresenter
    public int getCurrentPhotoCount() {
        return this.h;
    }

    @Override // com.avito.android.photo_view.ImageListPresenter
    public int getMaxImageCount() {
        return this.a;
    }

    @Override // com.avito.android.photo_view.ImageListPresenter
    public void hideAllRemoveButtons() {
        Disposable disposable = this.g;
        if (disposable != null) {
            disposable.dispose();
        }
        this.g = null;
        b();
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoMover
    public void movePhoto(int i2, int i3) {
        this.c.accept(new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    @Override // com.avito.android.photo_view.ImageListPresenter
    public void onPhotoPickerResult(boolean z) {
        if (z) {
            UploadingInteractor.DefaultImpls.startUpload$default(this.o, null, 1, null);
        }
    }

    @Override // com.avito.android.photo_view.ImageListView.Presenter
    public void onRemoveClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.n.remove(str);
    }

    @Override // com.avito.android.photo_view.ImageListView.Presenter
    public void onRetryClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.o.startUpload(str);
    }

    @Override // com.avito.android.photo_view.ImageListView.Presenter
    public void onRootViewClicked() {
        Disposable disposable = this.g;
        if (disposable != null) {
            disposable.dispose();
        }
        this.g = null;
        b();
    }

    @Override // com.avito.android.photo_view.ImageListPresenter
    @NotNull
    public Observable<Integer> photoCountChanges() {
        PublishRelay<Integer> publishRelay = this.d;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "photoCountChanges");
        return publishRelay;
    }

    @Override // com.avito.android.photo_view.ImageListPresenter
    public void setCameraError(boolean z) {
        PlaceholderImageData placeholderImageData;
        if (z) {
            placeholderImageData = PlaceholderImageData.copy$default(this.j, null, null, new ImageData.State.Error(false), null, null, 27, null);
        } else {
            placeholderImageData = PlaceholderImageData.copy$default(this.j, null, null, ImageData.State.NotAdded.INSTANCE, null, null, 27, null);
        }
        this.j = placeholderImageData;
        a(this.l);
    }

    @Override // com.avito.android.photo_view.ImageListPresenter
    public void setMaxImageCount(int i2) {
        this.a = i2;
        this.b.accept(Integer.valueOf(i2));
    }

    @Override // com.avito.android.photo_view.ImageListPresenter
    public void setVideoEnabled(boolean z) {
        this.i = z;
        this.j.setPlaceholderText(Integer.valueOf(R.string.add_photo));
    }

    @Override // com.avito.android.photo_view.ImageListView.Presenter
    public void showPhotoPicker(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (Intrinsics.areEqual(str, this.j.getId())) {
            str = null;
        }
        ImageListRouter imageListRouter = this.f;
        if (imageListRouter != null) {
            imageListRouter.openPhotoPicker(str, getCurrentPhotoCount());
        }
    }

    @Override // com.avito.android.photo_view.ImageListView.Presenter
    public void showVideoPicker() {
        ImageListRouter imageListRouter = this.f;
        if (imageListRouter != null) {
            imageListRouter.openVideoPicker();
        }
    }
}
