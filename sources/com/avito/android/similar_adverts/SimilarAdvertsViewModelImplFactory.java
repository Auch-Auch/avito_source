package com.avito.android.similar_adverts;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.section.SectionItemConverter;
import com.avito.android.similar_adverts.di.qualifier.ShopFlag;
import com.avito.android.util.SchedulersFactory3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B[\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b0\u00101J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/avito/android/similar_adverts/SimilarAdvertsViewModelImplFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/ActivityIntentFactory;", "f", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/analytics/Analytics;", "j", "Lcom/avito/android/analytics/Analytics;", "analytics", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "", AuthSource.BOOKING_ORDER, "Z", "isShop", "Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProvider;", "h", "Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProvider;", "resourceProvider", "Lcom/avito/android/similar_adverts/SimilarAdvertsInteractor;", "d", "Lcom/avito/android/similar_adverts/SimilarAdvertsInteractor;", "similarAdvertsInteractor", "Lcom/avito/android/rec/ScreenSource;", "i", "Lcom/avito/android/rec/ScreenSource;", "screenSource", "Lcom/avito/android/section/SectionItemConverter;", "e", "Lcom/avito/android/section/SectionItemConverter;", "similarAdvertsItemConverter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", g.a, "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "<init>", "(Ljava/lang/String;ZLcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/similar_adverts/SimilarAdvertsInteractor;Lcom/avito/android/section/SectionItemConverter;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProvider;Lcom/avito/android/rec/ScreenSource;Lcom/avito/android/analytics/Analytics;)V", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SimilarAdvertsViewModelImplFactory implements ViewModelProvider.Factory {
    public final String a;
    public final boolean b;
    public final SchedulersFactory3 c;
    public final SimilarAdvertsInteractor d;
    public final SectionItemConverter e;
    public final ActivityIntentFactory f;
    public final FavoriteAdvertsPresenter g;
    public final SimilarAdvertsResourceProvider h;
    public final ScreenSource i;
    public final Analytics j;

    @Inject
    public SimilarAdvertsViewModelImplFactory(@NotNull String str, @ShopFlag boolean z, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SimilarAdvertsInteractor similarAdvertsInteractor, @NotNull SectionItemConverter sectionItemConverter, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull SimilarAdvertsResourceProvider similarAdvertsResourceProvider, @NotNull ScreenSource screenSource, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(similarAdvertsInteractor, "similarAdvertsInteractor");
        Intrinsics.checkNotNullParameter(sectionItemConverter, "similarAdvertsItemConverter");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(similarAdvertsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(screenSource, "screenSource");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = str;
        this.b = z;
        this.c = schedulersFactory3;
        this.d = similarAdvertsInteractor;
        this.e = sectionItemConverter;
        this.f = activityIntentFactory;
        this.g = favoriteAdvertsPresenter;
        this.h = similarAdvertsResourceProvider;
        this.i = screenSource;
        this.j = analytics;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(SimilarAdvertsViewModelImpl.class)) {
            return new SimilarAdvertsViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
