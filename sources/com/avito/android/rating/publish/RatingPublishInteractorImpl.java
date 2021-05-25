package com.avito.android.rating.publish;

import com.avito.android.Features;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.publish.AddRatingResult;
import com.avito.android.remote.model.publish.RatingPublishResult;
import com.avito.android.util.CloseableDatasourcesKt;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/rating/publish/RatingPublishInteractorImpl;", "Lcom/avito/android/rating/publish/RatingPublishInteractor;", "Lcom/avito/android/ratings/RatingPublishData;", "data", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/publish/AddRatingResult;", "sendRating", "(Lcom/avito/android/ratings/RatingPublishData;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/publish/RatingPublishResult;", "sendRatingForm", "", "operationId", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "photoInteractor", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/rating/remote/RatingApi;", "Lcom/avito/android/rating/remote/RatingApi;", "api", "<init>", "(Lcom/avito/android/rating/remote/RatingApi;Lcom/avito/android/photo_picker/legacy/PhotoInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/Features;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingPublishInteractorImpl implements RatingPublishInteractor {
    public final RatingApi a;
    public final PhotoInteractor b;
    public final SchedulersFactory3 c;
    public final Features d;

    public static final class a<T, R> implements Function<CloseableDataSource<? extends PhotoUpload>, List<? extends PhotoUpload>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends PhotoUpload> apply(CloseableDataSource<? extends PhotoUpload> closeableDataSource) {
            CloseableDataSource<? extends PhotoUpload> closeableDataSource2 = closeableDataSource;
            Intrinsics.checkNotNullExpressionValue(closeableDataSource2, "it");
            return CloseableDatasourcesKt.readAllAndClose(closeableDataSource2);
        }
    }

    public static final class b<T, R> implements Function<List<? extends PhotoUpload>, String> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(List<? extends PhotoUpload> list) {
            List<? extends PhotoUpload> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            return CollectionsKt___CollectionsKt.joinToString$default(list2, ",", null, null, 0, null, a2.a.a.g2.b.a.a, 30, null);
        }
    }

    public static final class c<T1, T2, R> implements BiFunction<String, String, Pair<? extends String, ? extends String>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.BiFunction
        public Pair<? extends String, ? extends String> apply(String str, String str2) {
            return new Pair<>(str, str2);
        }
    }

    public static final class d<T, R> implements Function<Pair<? extends String, ? extends String>, ObservableSource<? extends TypedResult<AddRatingResult>>> {
        public final /* synthetic */ RatingPublishInteractorImpl a;
        public final /* synthetic */ RatingPublishData b;

        public d(RatingPublishInteractorImpl ratingPublishInteractorImpl, RatingPublishData ratingPublishData) {
            this.a = ratingPublishInteractorImpl;
            this.b = ratingPublishData;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends TypedResult<AddRatingResult>> apply(Pair<? extends String, ? extends String> pair) {
            Pair<? extends String, ? extends String> pair2 = pair;
            RatingApi ratingApi = this.a.a;
            String userKey = this.b.getUserKey();
            String itemId = this.b.getItemId();
            Long stageId = this.b.getStageId();
            Integer score = this.b.getScore();
            String comment = this.b.getComment();
            Object first = pair2.getFirst();
            String str = (String) first;
            Intrinsics.checkNotNullExpressionValue(str, "it");
            boolean z = false;
            Object obj = null;
            if (!(str.length() > 0)) {
                first = null;
            }
            String str2 = (String) first;
            Object second = pair2.getSecond();
            String str3 = (String) second;
            Intrinsics.checkNotNullExpressionValue(str3, "it");
            if (str3.length() > 0) {
                z = true;
            }
            if (z) {
                obj = second;
            }
            return ratingApi.addRating(userKey, itemId, stageId, score, comment, str2, (String) obj, this.b.getBuyerInfo(), this.b.getContextId());
        }
    }

    public static final class e<T1, T2, R> implements BiFunction<String, String, Pair<? extends String, ? extends String>> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.BiFunction
        public Pair<? extends String, ? extends String> apply(String str, String str2) {
            return new Pair<>(str, str2);
        }
    }

    public static final class f<T, R> implements Function<Pair<? extends String, ? extends String>, ObservableSource<? extends TypedResult<RatingPublishResult>>> {
        public final /* synthetic */ RatingPublishInteractorImpl a;
        public final /* synthetic */ RatingPublishData b;

        public f(RatingPublishInteractorImpl ratingPublishInteractorImpl, RatingPublishData ratingPublishData) {
            this.a = ratingPublishInteractorImpl;
            this.b = ratingPublishData;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x007b  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00b3  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00b6  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00cb  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00cd  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00d0  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00e0  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0161  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0186  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0199  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x019c  */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x01b0  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x01b3  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x01b8  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x021f  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x0244  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0257  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x025a  */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x026e  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0271  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0276  */
        @Override // io.reactivex.rxjava3.functions.Function
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.reactivex.rxjava3.core.ObservableSource<? extends com.avito.android.remote.model.TypedResult<com.avito.android.remote.model.publish.RatingPublishResult>> apply(kotlin.Pair<? extends java.lang.String, ? extends java.lang.String> r21) {
            /*
            // Method dump skipped, instructions count: 639
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.rating.publish.RatingPublishInteractorImpl.f.apply(java.lang.Object):java.lang.Object");
        }
    }

    @Inject
    public RatingPublishInteractorImpl(@NotNull RatingApi ratingApi, @NotNull PhotoInteractor photoInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(ratingApi, "api");
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = ratingApi;
        this.b = photoInteractor;
        this.c = schedulersFactory3;
        this.d = features;
    }

    public final Observable<String> a(String str) {
        Observable<String> map;
        if (str != null && (map = InteropKt.toV3(this.b.select(str)).map(a.a).map(b.a)) != null) {
            return map;
        }
        Observable<String> just = Observable.just("");
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(emptyString())");
        return just;
    }

    @Override // com.avito.android.rating.publish.RatingPublishInteractor
    @NotNull
    public Single<AddRatingResult> sendRating(@NotNull RatingPublishData ratingPublishData) {
        Intrinsics.checkNotNullParameter(ratingPublishData, "data");
        Observable flatMap = Observable.zip(a(ratingPublishData.getFilesOperationId()), a(ratingPublishData.getImagesOperationId()), c.a).subscribeOn(this.c.io()).flatMap(new d(this, ratingPublishData));
        Intrinsics.checkNotNullExpressionValue(flatMap, "Observable.zip(\n        …          )\n            }");
        Single<AddRatingResult> firstOrError = TypedObservablesKt.toTyped(flatMap).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "Observable.zip(\n        …          .firstOrError()");
        return firstOrError;
    }

    @Override // com.avito.android.rating.publish.RatingPublishInteractor
    @NotNull
    public Single<RatingPublishResult> sendRatingForm(@NotNull RatingPublishData ratingPublishData) {
        Intrinsics.checkNotNullParameter(ratingPublishData, "data");
        Observable flatMap = Observable.zip(a(ratingPublishData.getFilesOperationId()), a(ratingPublishData.getImagesOperationId()), e.a).subscribeOn(this.c.io()).flatMap(new f(this, ratingPublishData));
        Intrinsics.checkNotNullExpressionValue(flatMap, "Observable.zip(\n        …         }\n\n            }");
        Single<RatingPublishResult> firstOrError = TypedObservablesKt.toTyped(flatMap).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "Observable.zip(\n        …          .firstOrError()");
        return firstOrError;
    }
}
