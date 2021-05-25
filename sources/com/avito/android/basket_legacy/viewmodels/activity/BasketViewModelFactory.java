package com.avito.android.basket_legacy.viewmodels.activity;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.basket_legacy.fees.BasketInteractor;
import com.avito.android.basket_legacy.utils.VasType;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerActivity
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/basket_legacy/viewmodels/activity/BasketViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "e", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/basket_legacy/utils/VasType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/basket_legacy/utils/VasType;", "vasType", "Lcom/avito/android/ActivityIntentFactory;", "d", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/basket_legacy/fees/BasketInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/basket_legacy/fees/BasketInteractor;", "interactor", "<init>", "(Lcom/avito/android/basket_legacy/utils/VasType;Lcom/avito/android/basket_legacy/fees/BasketInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class BasketViewModelFactory implements ViewModelProvider.Factory {
    public final VasType a;
    public final BasketInteractor b;
    public final SchedulersFactory c;
    public final ActivityIntentFactory d;
    public final DeepLinkIntentFactory e;

    @Inject
    public BasketViewModelFactory(@NotNull VasType vasType, @NotNull BasketInteractor basketInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(vasType, "vasType");
        Intrinsics.checkNotNullParameter(basketInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        this.a = vasType;
        this.b = basketInteractor;
        this.c = schedulersFactory;
        this.d = activityIntentFactory;
        this.e = deepLinkIntentFactory;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(BasketViewModelImpl.class)) {
            return new BasketViewModelImpl(this.a, this.b, this.c, this.d, this.e);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
