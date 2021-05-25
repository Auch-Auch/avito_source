package com.avito.android.bundles.vas_union.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.bundles.vas_union.VasUnionConverter;
import com.avito.android.bundles.vas_union.di.CheckoutContext;
import com.avito.android.bundles.vas_union.repository.VasUnionRepository;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/bundles/vas_union/viewmodel/VasUnionViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/bundles/vas_union/repository/VasUnionRepository;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bundles/vas_union/repository/VasUnionRepository;", "bundlesRepository", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/bundles/vas_union/VasUnionConverter;", "c", "Lcom/avito/android/bundles/vas_union/VasUnionConverter;", "converter", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "checkoutContext", "<init>", "(Ljava/lang/String;Lcom/avito/android/bundles/vas_union/repository/VasUnionRepository;Lcom/avito/android/bundles/vas_union/VasUnionConverter;Lcom/avito/android/util/SchedulersFactory3;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasUnionViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final VasUnionRepository b;
    public final VasUnionConverter c;
    public final SchedulersFactory3 d;

    @Inject
    public VasUnionViewModelFactory(@CheckoutContext @NotNull String str, @NotNull VasUnionRepository vasUnionRepository, @NotNull VasUnionConverter vasUnionConverter, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Intrinsics.checkNotNullParameter(vasUnionRepository, "bundlesRepository");
        Intrinsics.checkNotNullParameter(vasUnionConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = str;
        this.b = vasUnionRepository;
        this.c = vasUnionConverter;
        this.d = schedulersFactory3;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(VasUnionViewModel.class)) {
            return new VasUnionViewModel(this.a, this.c, this.b, this.d);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
