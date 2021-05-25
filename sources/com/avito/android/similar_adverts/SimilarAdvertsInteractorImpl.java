package com.avito.android.similar_adverts;

import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.section.SectionResponse;
import com.avito.android.remote.model.section.SectionTypeElement;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/similar_adverts/SimilarAdvertsInteractorImpl;", "Lcom/avito/android/similar_adverts/SimilarAdvertsInteractor;", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/remote/model/section/SectionTypeElement;", "getSimilarAdverts", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/rec/ScreenSource;", "c", "Lcom/avito/android/rec/ScreenSource;", "screenSource", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "<init>", "(Lcom/avito/android/advert_details/remote/AdvertDetailsApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/rec/ScreenSource;)V", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SimilarAdvertsInteractorImpl implements SimilarAdvertsInteractor {
    public final AdvertDetailsApi a;
    public final SchedulersFactory3 b;
    public final ScreenSource c;

    public static final class a<T, R> implements Function<SectionResponse, List<? extends SectionTypeElement>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends SectionTypeElement> apply(SectionResponse sectionResponse) {
            return sectionResponse.getSections();
        }
    }

    @Inject
    public SimilarAdvertsInteractorImpl(@NotNull AdvertDetailsApi advertDetailsApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ScreenSource screenSource) {
        Intrinsics.checkNotNullParameter(advertDetailsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(screenSource, "screenSource");
        this.a = advertDetailsApi;
        this.b = schedulersFactory3;
        this.c = screenSource;
    }

    @Override // com.avito.android.similar_adverts.SimilarAdvertsInteractor
    @NotNull
    public Observable<List<SectionTypeElement>> getSimilarAdverts(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return a2.b.a.a.a.a2(this.b, this.a.getComplementaryItems(str, this.c.getSource()).map(a.a), "request.map { it.section…n(schedulersFactory.io())");
    }
}
