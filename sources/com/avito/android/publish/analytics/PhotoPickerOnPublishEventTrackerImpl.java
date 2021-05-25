package com.avito.android.publish.analytics;

import com.avito.android.analytics.AddPhotoEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.CameraScreenOpenEvent;
import com.avito.android.analytics.DeletePhotoFromListEvent;
import com.avito.android.analytics.OpenPhotoEditScreenEvent;
import com.avito.android.analytics.OpenPhotoListEditEvent;
import com.avito.android.analytics.PhotoUploadToCvEvent;
import com.avito.android.analytics.RemovePhotoEvent;
import com.avito.android.analytics.Rotate90PhotoEvent;
import com.avito.android.analytics.UnhandledPhotoPickerEvent;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.NavigationProvider;
import com.avito.android.publish.analytics.events.AddPhotoOnPublishEvent;
import com.avito.android.publish.analytics.events.DeletePhotoOnPublishFromListEvent;
import com.avito.android.publish.analytics.events.OpenCameraScreenEvent;
import com.avito.android.publish.analytics.events.OpenPhotoEditScreenOnPublishEvent;
import com.avito.android.publish.analytics.events.OpenPhotoListEditScreenOnPublishEvent;
import com.avito.android.publish.analytics.events.RemovePhotoOnPublishEvent;
import com.avito.android.publish.analytics.events.Rotate90PhotoOnPublishEvent;
import com.avito.android.publish.analytics.events.UploadPhotoEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.NavigationKt;
import com.google.gson.Gson;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
import t6.n.r;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010#\u001a\u00020!\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\n*\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\n*\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/publish/analytics/PhotoPickerOnPublishEventTrackerImpl;", "Lcom/avito/android/publish/analytics/PhotoPickerOnPublishEventTracker;", "Lcom/avito/android/publish/NavigationProvider;", "navigationProvider", "", "subscribe", "(Lcom/avito/android/publish/NavigationProvider;)V", "unsubscribe", "()V", "", "", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Ljava/util/Map;", "Lcom/avito/android/remote/model/Navigation;", "", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/remote/model/Navigation;)Ljava/util/Map;", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/analytics/UnhandledPhotoPickerEvent;", "d", "Lio/reactivex/rxjava3/core/Observable;", "eventObservable", "Lcom/google/gson/Gson;", "e", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "c", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lio/reactivex/rxjava3/core/Observable;Lcom/google/gson/Gson;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoPickerOnPublishEventTrackerImpl implements PhotoPickerOnPublishEventTracker {
    public Disposable a;
    public final Analytics b;
    public final PublishAnalyticsDataProvider c;
    public final Observable<UnhandledPhotoPickerEvent> d;
    public final Gson e;

    public static final class a<T> implements Consumer<UnhandledPhotoPickerEvent> {
        public final /* synthetic */ PhotoPickerOnPublishEventTrackerImpl a;
        public final /* synthetic */ NavigationProvider b;

        public a(PhotoPickerOnPublishEventTrackerImpl photoPickerOnPublishEventTrackerImpl, NavigationProvider navigationProvider) {
            this.a = photoPickerOnPublishEventTrackerImpl;
            this.b = navigationProvider;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(UnhandledPhotoPickerEvent unhandledPhotoPickerEvent) {
            UnhandledPhotoPickerEvent unhandledPhotoPickerEvent2 = unhandledPhotoPickerEvent;
            if (unhandledPhotoPickerEvent2 instanceof PhotoUploadToCvEvent) {
                PhotoPickerOnPublishEventTrackerImpl.access$trackPhotoUploadToCv(this.a);
            } else if (unhandledPhotoPickerEvent2 instanceof AddPhotoEvent) {
                PhotoPickerOnPublishEventTrackerImpl.access$trackAddPhoto(this.a, ((AddPhotoEvent) unhandledPhotoPickerEvent2).getPhotoFrom());
            } else if (unhandledPhotoPickerEvent2 instanceof RemovePhotoEvent) {
                PhotoPickerOnPublishEventTrackerImpl.access$trackRemovePhoto(this.a);
            } else if (unhandledPhotoPickerEvent2 instanceof CameraScreenOpenEvent) {
                PhotoPickerOnPublishEventTrackerImpl.access$trackCameraScreenOpen(this.a);
            } else if (unhandledPhotoPickerEvent2 instanceof Rotate90PhotoEvent) {
                PhotoPickerOnPublishEventTrackerImpl.access$trackRotate90(this.a, ((Rotate90PhotoEvent) unhandledPhotoPickerEvent2).getImageId(), this.b.getNavigation());
            } else if (unhandledPhotoPickerEvent2 instanceof OpenPhotoListEditEvent) {
                PhotoPickerOnPublishEventTrackerImpl.access$trackOpenPhotoListEdit(this.a, this.b.getNavigation());
            } else if (unhandledPhotoPickerEvent2 instanceof OpenPhotoEditScreenEvent) {
                PhotoPickerOnPublishEventTrackerImpl.access$trackOpenPhotoEdit(this.a, ((OpenPhotoEditScreenEvent) unhandledPhotoPickerEvent2).getImageId(), this.b.getNavigation());
            } else if (unhandledPhotoPickerEvent2 instanceof DeletePhotoFromListEvent) {
                PhotoPickerOnPublishEventTrackerImpl.access$trackPhotoDeleted(this.a, ((DeletePhotoFromListEvent) unhandledPhotoPickerEvent2).getImageId(), this.b.getNavigation());
            }
        }
    }

    public PhotoPickerOnPublishEventTrackerImpl(@NotNull Analytics analytics, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull Observable<UnhandledPhotoPickerEvent> observable, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(observable, "eventObservable");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.b = analytics;
        this.c = publishAnalyticsDataProvider;
        this.d = observable;
        this.e = gson;
    }

    public static final void access$trackAddPhoto(PhotoPickerOnPublishEventTrackerImpl photoPickerOnPublishEventTrackerImpl, String str) {
        photoPickerOnPublishEventTrackerImpl.b.track(new AddPhotoOnPublishEvent(photoPickerOnPublishEventTrackerImpl.c, str));
    }

    public static final void access$trackCameraScreenOpen(PhotoPickerOnPublishEventTrackerImpl photoPickerOnPublishEventTrackerImpl) {
        photoPickerOnPublishEventTrackerImpl.b.track(new OpenCameraScreenEvent(photoPickerOnPublishEventTrackerImpl.c));
    }

    public static final void access$trackOpenPhotoEdit(PhotoPickerOnPublishEventTrackerImpl photoPickerOnPublishEventTrackerImpl, String str, Navigation navigation) {
        photoPickerOnPublishEventTrackerImpl.b.track(new OpenPhotoEditScreenOnPublishEvent(photoPickerOnPublishEventTrackerImpl.c, r.plus(photoPickerOnPublishEventTrackerImpl.b(navigation), photoPickerOnPublishEventTrackerImpl.a(str))));
    }

    public static final void access$trackOpenPhotoListEdit(PhotoPickerOnPublishEventTrackerImpl photoPickerOnPublishEventTrackerImpl, Navigation navigation) {
        photoPickerOnPublishEventTrackerImpl.b.track(new OpenPhotoListEditScreenOnPublishEvent(photoPickerOnPublishEventTrackerImpl.c, photoPickerOnPublishEventTrackerImpl.b(navigation)));
    }

    public static final void access$trackPhotoDeleted(PhotoPickerOnPublishEventTrackerImpl photoPickerOnPublishEventTrackerImpl, String str, Navigation navigation) {
        photoPickerOnPublishEventTrackerImpl.b.track(new DeletePhotoOnPublishFromListEvent(photoPickerOnPublishEventTrackerImpl.c, r.plus(photoPickerOnPublishEventTrackerImpl.b(navigation), photoPickerOnPublishEventTrackerImpl.a(str))));
    }

    public static final void access$trackPhotoUploadToCv(PhotoPickerOnPublishEventTrackerImpl photoPickerOnPublishEventTrackerImpl) {
        photoPickerOnPublishEventTrackerImpl.b.track(new UploadPhotoEvent(photoPickerOnPublishEventTrackerImpl.c.getSessionIdKeyValue()));
    }

    public static final void access$trackRemovePhoto(PhotoPickerOnPublishEventTrackerImpl photoPickerOnPublishEventTrackerImpl) {
        photoPickerOnPublishEventTrackerImpl.b.track(new RemovePhotoOnPublishEvent(photoPickerOnPublishEventTrackerImpl.c));
    }

    public static final void access$trackRotate90(PhotoPickerOnPublishEventTrackerImpl photoPickerOnPublishEventTrackerImpl, String str, Navigation navigation) {
        photoPickerOnPublishEventTrackerImpl.b.track(new Rotate90PhotoOnPublishEvent(photoPickerOnPublishEventTrackerImpl.c, r.plus(photoPickerOnPublishEventTrackerImpl.b(navigation), photoPickerOnPublishEventTrackerImpl.a(str))));
    }

    public final Map<String, String> a(String str) {
        Long longOrNull;
        Map<String, String> mapOf;
        return (str == null || (longOrNull = l.toLongOrNull(str)) == null || (mapOf = q.mapOf(TuplesKt.to("imgid", String.valueOf(longOrNull.longValue())))) == null) ? r.emptyMap() : mapOf;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0026: APUT  
      (r0v1 kotlin.Pair[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x0021: INVOKE  (r1v5 kotlin.Pair) = ("categories"), (r1v4 java.util.List<java.lang.Integer>) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public final Map<String, Object> b(Navigation navigation) {
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("cid", String.valueOf(navigation.getCategoryId()));
        List<Integer> categoryIds = navigation.getCategoryIds();
        if (categoryIds == null) {
            categoryIds = CollectionsKt__CollectionsKt.emptyList();
        }
        pairArr[1] = TuplesKt.to("categories", categoryIds);
        List<Map<String, String>> attributes = navigation.getAttributes();
        String analyticsFormat = attributes != null ? NavigationKt.toAnalyticsFormat(attributes, this.e) : null;
        if (analyticsFormat == null) {
            analyticsFormat = "";
        }
        pairArr[2] = TuplesKt.to("infm_raw_params", analyticsFormat);
        return r.mapOf(pairArr);
    }

    @Override // com.avito.android.publish.analytics.PhotoPickerOnPublishEventTracker
    public void subscribe(@NotNull NavigationProvider navigationProvider) {
        Intrinsics.checkNotNullParameter(navigationProvider, "navigationProvider");
        Disposable subscribe = this.d.subscribe(new a(this, navigationProvider));
        Intrinsics.checkNotNullExpressionValue(subscribe, "eventObservable.subscrib…)\n            }\n        }");
        this.a = subscribe;
    }

    @Override // com.avito.android.publish.analytics.PhotoPickerOnPublishEventTracker
    public void unsubscribe() {
        Disposable disposable = this.a;
        if (disposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposable");
        }
        disposable.dispose();
    }
}
