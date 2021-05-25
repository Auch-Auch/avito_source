package com.avito.android.advert_core.teaser;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\tJ1\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert_core/teaser/TeaserObserver;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "kotlin.jvm.PlatformType", "observeTeaser", "()Lio/reactivex/Observable;", "", "reset", "()V", "data", "pushData", "(Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;)V", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "EMPTY", "Lio/reactivex/subjects/BehaviorSubject;", AuthSource.BOOKING_ORDER, "Lio/reactivex/subjects/BehaviorSubject;", "teaserSubject", "<init>", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class TeaserObserver {
    public final Object a;
    public BehaviorSubject<Object> b;

    public static final class a<T> implements Predicate<Object> {
        public final /* synthetic */ TeaserObserver a;

        public a(TeaserObserver teaserObserver) {
            this.a = teaserObserver;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "it");
            return !Intrinsics.areEqual(obj, this.a.a);
        }
    }

    public TeaserObserver() {
        Object obj = new Object();
        this.a = obj;
        BehaviorSubject<Object> createDefault = BehaviorSubject.createDefault(obj);
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorSubject.createDefault(EMPTY)");
        this.b = createDefault;
    }

    public final Observable<AutotekaTeaserGalleryModel> observeTeaser() {
        return this.b.filter(new a(this)).cast(AutotekaTeaserGalleryModel.class);
    }

    public final void pushData(@NotNull AutotekaTeaserGalleryModel autotekaTeaserGalleryModel) {
        Intrinsics.checkNotNullParameter(autotekaTeaserGalleryModel, "data");
        this.b.onNext(autotekaTeaserGalleryModel);
    }

    public final void reset() {
        this.b.onNext(this.a);
    }
}
