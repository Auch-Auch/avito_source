package com.avito.android.computer_vision.multiupload;

import android.net.Uri;
import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.analytics.PhotoUploadToCvEvent;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.computer_vision.ComputerVisionInteractorKt;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.photo_picker.legacy.remote.PickerApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParamKeyValue;
import com.avito.android.remote.model.ParamSuggestionsByPhotoResponse;
import com.avito.android.util.Logs;
import com.avito.android.util.RequestUtils;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import com.facebook.share.internal.ShareConstants;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.MultipartBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u001fB/\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u00109\u001a\u000206¢\u0006\u0004\bN\u0010OJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\bJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0010R\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR:\u0010H\u001a&\u0012\f\u0012\n F*\u0004\u0018\u00010\u00110\u0011 F*\u0012\u0012\f\u0012\n F*\u0004\u0018\u00010\u00110\u0011\u0018\u00010E0E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010GR\u0016\u0010J\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010!R\u0016\u0010M\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006P"}, d2 = {"Lcom/avito/android/computer_vision/multiupload/MultiuploadComputerVisionInteractor;", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "", "isEnabled", "", "enable", "(Z)V", "needRecognize", "()Z", "needTimeToUploading", "Lio/reactivex/Observable;", "", "Lcom/avito/android/remote/model/ParamKeyValue;", "recognitionResults", "()Lio/reactivex/Observable;", "reset", "()V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "processPhoto", "(Landroid/net/Uri;)V", "", "photoId", "updateIds", "(Ljava/lang/String;Landroid/net/Uri;)V", "removePhoto", "(Ljava/lang/String;)V", "", "count", "setSuggestMaxImages", "(Ljava/lang/Integer;)V", AuthSource.SEND_ABUSE, "e", "Z", "isRecognitionEnabled", "", "Lcom/avito/android/computer_vision/multiupload/MultiuploadComputerVisionInteractor$a;", "c", "Ljava/util/List;", "nonCvPhotos", AuthSource.BOOKING_ORDER, "cvPhotos", "Lcom/avito/android/photo_picker/legacy/remote/PickerApi;", "i", "Lcom/avito/android/photo_picker/legacy/remote/PickerApi;", "api", "Lcom/avito/android/photo/BitmapFileProvider;", "k", "Lcom/avito/android/photo/BitmapFileProvider;", "converter", "Lcom/avito/android/util/SchedulersFactory;", "l", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsData", a2.g.r.g.a, "Ljava/lang/String;", "sessionId", "Lio/reactivex/disposables/Disposable;", "d", "Lio/reactivex/disposables/Disposable;", "uploadingDisposable", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "j", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "eventTracker", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "Lcom/jakewharton/rxrelay2/PublishRelay;", "addedPhotosRelay", "f", "cvPhotosChanged", "h", "I", "suggestByPhotoMaxImages", "<init>", "(Lcom/avito/android/photo_picker/legacy/remote/PickerApi;Lcom/avito/android/analytics/PhotoPickerEventTracker;Lcom/avito/android/photo/BitmapFileProvider;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class MultiuploadComputerVisionInteractor implements ComputerVisionInteractor {
    public final PublishRelay<Uri> a = PublishRelay.create();
    public List<a> b = new ArrayList();
    public List<a> c = new ArrayList();
    public Disposable d;
    public boolean e;
    public boolean f;
    public String g = "";
    public int h = 5;
    public final PickerApi i;
    public final PhotoPickerEventTracker j;
    public final BitmapFileProvider k;
    public final SchedulersFactory l;
    public final PublishAnalyticsDataProvider m;

    public static final class a {
        @NotNull
        public final Uri a;
        @Nullable
        public String b;
        @Nullable
        public String c;

        public a(Uri uri, String str, String str2, int i) {
            int i2 = i & 2;
            str2 = (i & 4) != 0 ? null : str2;
            Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
            this.a = uri;
            this.b = null;
            this.c = str2;
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ MultiuploadComputerVisionInteractor a;

        public b(MultiuploadComputerVisionInteractor multiuploadComputerVisionInteractor) {
            this.a = multiuploadComputerVisionInteractor;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.a.f = false;
        }
    }

    public static final class c<T, R> implements Function<ParamSuggestionsByPhotoResponse, List<? extends ParamKeyValue>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends ParamKeyValue> apply(ParamSuggestionsByPhotoResponse paramSuggestionsByPhotoResponse) {
            ParamSuggestionsByPhotoResponse paramSuggestionsByPhotoResponse2 = paramSuggestionsByPhotoResponse;
            Intrinsics.checkNotNullParameter(paramSuggestionsByPhotoResponse2, "it");
            return paramSuggestionsByPhotoResponse2.getParams();
        }
    }

    public static final class d extends Lambda implements Function1<a, Boolean> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(a aVar) {
            a aVar2 = aVar;
            Intrinsics.checkNotNullParameter(aVar2, "it");
            return Boolean.valueOf(Intrinsics.areEqual(aVar2.b, this.a));
        }
    }

    public static final class e<T> implements Consumer<Uri> {
        public final /* synthetic */ MultiuploadComputerVisionInteractor a;

        public e(MultiuploadComputerVisionInteractor multiuploadComputerVisionInteractor) {
            this.a = multiuploadComputerVisionInteractor;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Uri uri) {
            this.a.j.track(PhotoUploadToCvEvent.INSTANCE);
        }
    }

    public static final class f<T, R> implements Function<Uri, ObservableSource<? extends a>> {
        public final /* synthetic */ MultiuploadComputerVisionInteractor a;
        public final /* synthetic */ MultipartBody.Part b;

        public f(MultiuploadComputerVisionInteractor multiuploadComputerVisionInteractor, MultipartBody.Part part) {
            this.a = multiuploadComputerVisionInteractor;
            this.b = part;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends a> apply(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, "uploadUri");
            return this.a.k.getConvertedFileForUri(uri2, ComputerVisionInteractorKt.getCV_IMAGE_CONVERT_OPTIONS()).observeOn(this.a.l.io()).map(a2.a.a.f0.a.a.a).flatMap(new a2.a.a.f0.a.b(this)).map(new a2.a.a.f0.a.c(uri2));
        }
    }

    public static final class g<T> implements Consumer<a> {
        public final /* synthetic */ MultiuploadComputerVisionInteractor a;

        public g(MultiuploadComputerVisionInteractor multiuploadComputerVisionInteractor) {
            this.a = multiuploadComputerVisionInteractor;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(a aVar) {
            T t;
            a aVar2 = aVar;
            Iterator<T> it = this.a.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (Intrinsics.areEqual(t.a, aVar2.a)) {
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                t2.c = aVar2.c;
            }
            this.a.f = true;
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public static final h a = new h();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("ComputerVisionInteractor", "Error during image upload for computer vision recognition", th);
        }
    }

    public MultiuploadComputerVisionInteractor(@NotNull PickerApi pickerApi, @NotNull PhotoPickerEventTracker photoPickerEventTracker, @NotNull BitmapFileProvider bitmapFileProvider, @NotNull SchedulersFactory schedulersFactory, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(pickerApi, "api");
        Intrinsics.checkNotNullParameter(photoPickerEventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(bitmapFileProvider, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsData");
        this.i = pickerApi;
        this.j = photoPickerEventTracker;
        this.k = bitmapFileProvider;
        this.l = schedulersFactory;
        this.m = publishAnalyticsDataProvider;
    }

    public final void a() {
        if (this.d == null) {
            this.d = this.a.doOnNext(new e(this)).observeOn(this.l.single()).flatMap(new f(this, MultipartBody.Part.Companion.createFormData("publishSessionId", this.m.getSessionId()))).observeOn(this.l.computation()).subscribe(new g(this), h.a);
        }
    }

    @Override // com.avito.android.computer_vision.ComputerVisionInteractor
    public void enable(boolean z) {
        if (!Intrinsics.areEqual(this.m.getSessionId(), this.g)) {
            this.g = this.m.getSessionId();
            this.b.clear();
            this.c.clear();
        }
        this.e = z;
    }

    @Override // com.avito.android.computer_vision.ComputerVisionInteractor
    public boolean needRecognize() {
        return this.e && (this.b.isEmpty() ^ true) && this.f;
    }

    @Override // com.avito.android.computer_vision.ComputerVisionInteractor
    public boolean needTimeToUploading() {
        if (this.e) {
            List<a> list = this.b;
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                String str = t.c;
                if (str == null || str.length() == 0) {
                    arrayList.add(t);
                }
            }
            if (!arrayList.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.avito.android.computer_vision.ComputerVisionInteractor
    public void processPhoto(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        if (this.e) {
            a();
            if (this.b.size() < this.h) {
                this.b.add(new a(uri, null, null, 6));
                this.a.accept(uri);
                return;
            }
            this.c.add(new a(uri, null, null, 6));
        }
    }

    @Override // com.avito.android.computer_vision.ComputerVisionInteractor
    @NotNull
    public Observable<List<ParamKeyValue>> recognitionResults() {
        List<a> list = this.b;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next().c;
            if (str != null) {
                arrayList.add(str);
            }
        }
        Observable<List<ParamKeyValue>> map = TypedObservablesKt.toTyped(InteropKt.toV2(this.i.getPublishSuggestsByPhotoV3(RequestUtils.INSTANCE.toArrayQueryParams(CollectionsKt___CollectionsKt.toSet(arrayList), "images"), this.m.getSessionId()))).subscribeOn(this.l.computation()).doOnComplete(new b(this)).map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getPublishSuggestsBy…       .map { it.params }");
        return map;
    }

    @Override // com.avito.android.computer_vision.ComputerVisionInteractor
    public void removePhoto(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "photoId");
        if (this.e) {
            List<a> list = this.b;
            boolean z = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (Intrinsics.areEqual(it.next().b, str)) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z) {
                this.f = true;
            }
            t6.n.h.removeAll((List) this.b, (Function1) new d(str));
            if (this.b.size() < this.h && (!this.c.isEmpty())) {
                a();
                Iterator<a> it2 = this.c.iterator();
                while (it2.hasNext()) {
                    a next = it2.next();
                    if (this.b.size() < this.h) {
                        this.b.add(next);
                        this.a.accept(next.a);
                        it2.remove();
                    }
                }
            }
        }
    }

    @Override // com.avito.android.computer_vision.ComputerVisionInteractor
    public void reset() {
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d = null;
        this.e = false;
    }

    @Override // com.avito.android.computer_vision.ComputerVisionInteractor
    public void setSuggestMaxImages(@Nullable Integer num) {
        if (num == null || num.intValue() <= 0) {
            this.h = 5;
        } else {
            this.h = num.intValue();
        }
    }

    @Override // com.avito.android.computer_vision.ComputerVisionInteractor
    public void updateIds(@NotNull String str, @NotNull Uri uri) {
        T t;
        Intrinsics.checkNotNullParameter(str, "photoId");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Iterator<T> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.a, uri)) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            t2.b = str;
        }
    }
}
