package com.avito.android.advert_core.short_term_rent;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.advert_core.di.module.AdvertSellerShortTermRentObservable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertSellerShortTermRent;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.jakewharton.rxrelay3.PublishRelay;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u000e\b\u0001\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b!\u0010\"J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/text/AttributedTextFormatter;", "c", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/remote/model/AdvertSellerShortTermRent;", "f", "Lcom/jakewharton/rxrelay3/PublishRelay;", "termRentObservable", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockAnalyticsInteractor;", "e", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewResourceProvider;", "d", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewResourceProvider;Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockAnalyticsInteractor;Lcom/jakewharton/rxrelay3/PublishRelay;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStrBlockViewModelFactory implements ViewModelProvider.Factory {
    public final AdvertStrBlockInteractor a;
    public final SchedulersFactory3 b;
    public final AttributedTextFormatter c;
    public final AdvertStrBlockViewResourceProvider d;
    public final AdvertStrBlockAnalyticsInteractor e;
    public final PublishRelay<AdvertSellerShortTermRent> f;

    @Inject
    public AdvertStrBlockViewModelFactory(@NotNull AdvertStrBlockInteractor advertStrBlockInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull AdvertStrBlockViewResourceProvider advertStrBlockViewResourceProvider, @NotNull AdvertStrBlockAnalyticsInteractor advertStrBlockAnalyticsInteractor, @AdvertSellerShortTermRentObservable @NotNull PublishRelay<AdvertSellerShortTermRent> publishRelay) {
        Intrinsics.checkNotNullParameter(advertStrBlockInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(advertStrBlockViewResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(advertStrBlockAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(publishRelay, "termRentObservable");
        this.a = advertStrBlockInteractor;
        this.b = schedulersFactory3;
        this.c = attributedTextFormatter;
        this.d = advertStrBlockViewResourceProvider;
        this.e = advertStrBlockAnalyticsInteractor;
        this.f = publishRelay;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(AdvertStrBlockViewModelImpl.class)) {
            return new AdvertStrBlockViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
