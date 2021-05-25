package com.avito.android.user_advert.soa_with_price;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseReason;
import com.avito.android.util.SchedulersFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceResourceProvider;", "c", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceResourceProvider;", "resourceProvider", "", "Lcom/avito/android/remote/model/CloseReason;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "reasonsList", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Ljava/util/List;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceResourceProvider;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class SoaWithPriceViewModelFactory implements ViewModelProvider.Factory {
    public final List<CloseReason> a;
    public final SchedulersFactory b;
    public final SoaWithPriceResourceProvider c;

    public SoaWithPriceViewModelFactory(@NotNull List<CloseReason> list, @NotNull SchedulersFactory schedulersFactory, @NotNull SoaWithPriceResourceProvider soaWithPriceResourceProvider) {
        Intrinsics.checkNotNullParameter(list, "reasonsList");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(soaWithPriceResourceProvider, "resourceProvider");
        this.a = list;
        this.b = schedulersFactory;
        this.c = soaWithPriceResourceProvider;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(SoaWithPriceViewModel.class)) {
            return new SoaWithPriceViewModel(this.a, this.b, this.c);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
