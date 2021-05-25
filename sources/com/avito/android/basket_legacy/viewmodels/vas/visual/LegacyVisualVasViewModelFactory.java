package com.avito.android.basket_legacy.viewmodels.vas.visual;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_performance.StringProvider;
import com.avito.android.vas_performance.VisualVasConverter;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b$\u0010%J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/basket_legacy/viewmodels/vas/visual/LegacyVisualVasViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory;", "e", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "c", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "basketRepository", "Lcom/avito/android/vas_performance/VisualVasConverter;", "d", "Lcom/avito/android/vas_performance/VisualVasConverter;", "converter", "Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", g.a, "Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "tracker", "Lcom/avito/android/vas_performance/StringProvider;", "f", "Lcom/avito/android/vas_performance/StringProvider;", "stringProvider", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/vas_performance/repository/VasRepository;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/vas_performance/repository/VasRepository;", "vasRepository", "<init>", "(Ljava/lang/String;Lcom/avito/android/vas_performance/repository/VasRepository;Lcom/avito/android/basket_legacy/repositories/BasketRepository;Lcom/avito/android/vas_performance/VisualVasConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/vas_performance/StringProvider;Lcom/avito/android/vas_performance/tracker/VisualVasTracker;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyVisualVasViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final VasRepository b;
    public final BasketRepository c;
    public final VisualVasConverter d;
    public final SchedulersFactory e;
    public final StringProvider f;
    public final VisualVasTracker g;

    public LegacyVisualVasViewModelFactory(@NotNull String str, @NotNull VasRepository vasRepository, @NotNull BasketRepository basketRepository, @NotNull VisualVasConverter visualVasConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull StringProvider stringProvider, @NotNull VisualVasTracker visualVasTracker) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(vasRepository, "vasRepository");
        Intrinsics.checkNotNullParameter(basketRepository, "basketRepository");
        Intrinsics.checkNotNullParameter(visualVasConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(visualVasTracker, "tracker");
        this.a = str;
        this.b = vasRepository;
        this.c = basketRepository;
        this.d = visualVasConverter;
        this.e = schedulersFactory;
        this.f = stringProvider;
        this.g = visualVasTracker;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(LegacyVisualVasViewModelImpl.class)) {
            return new LegacyVisualVasViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
