package com.avito.android.short_term_rent.hotels.dialogs.location;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.hotels.HotelsLocation;
import com.avito.android.short_term_rent.hotels.data.HotelsRepository;
import com.avito.android.util.SchedulersFactory3;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", "Lcom/avito/android/remote/model/hotels/HotelsLocation;", "c", "Ljava/util/List;", "defaultLocations", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/short_term_rent/hotels/data/HotelsRepository;", AuthSource.SEND_ABUSE, "Lcom/avito/android/short_term_rent/hotels/data/HotelsRepository;", "repository", "<init>", "(Lcom/avito/android/short_term_rent/hotels/data/HotelsRepository;Lcom/avito/android/util/SchedulersFactory3;Ljava/util/List;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsLocationViewModelFactory implements ViewModelProvider.Factory {
    public final HotelsRepository a;
    public final SchedulersFactory3 b;
    public final List<HotelsLocation> c;

    @Inject
    public HotelsLocationViewModelFactory(@NotNull HotelsRepository hotelsRepository, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull List<HotelsLocation> list) {
        Intrinsics.checkNotNullParameter(hotelsRepository, "repository");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(list, "defaultLocations");
        this.a = hotelsRepository;
        this.b = schedulersFactory3;
        this.c = list;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(HotelsLocationViewModel.class)) {
            return new HotelsLocationViewModel(this.a, this.b, this.c);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
