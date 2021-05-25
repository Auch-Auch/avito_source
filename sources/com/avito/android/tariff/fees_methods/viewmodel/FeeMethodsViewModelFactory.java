package com.avito.android.tariff.fees_methods.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b \u0010!J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsRepository;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsRepository;", "repository", "Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "f", "Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "limitAnalyticsTracker", "", "e", "Z", "isClosable", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "checkoutContext", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsConverter;", "c", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsConverter;", "converter", "<init>", "(Ljava/lang/String;Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsRepository;Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsConverter;Lcom/avito/android/util/SchedulersFactory;ZLcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class FeeMethodsViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final FeeMethodsRepository b;
    public final FeeMethodsConverter c;
    public final SchedulersFactory d;
    public final boolean e;
    public final PublishLimitsEventTracker f;

    @Inject
    public FeeMethodsViewModelFactory(@NotNull String str, @NotNull FeeMethodsRepository feeMethodsRepository, @NotNull FeeMethodsConverter feeMethodsConverter, @NotNull SchedulersFactory schedulersFactory, boolean z, @NotNull PublishLimitsEventTracker publishLimitsEventTracker) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Intrinsics.checkNotNullParameter(feeMethodsRepository, "repository");
        Intrinsics.checkNotNullParameter(feeMethodsConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(publishLimitsEventTracker, "limitAnalyticsTracker");
        this.a = str;
        this.b = feeMethodsRepository;
        this.c = feeMethodsConverter;
        this.d = schedulersFactory;
        this.e = z;
        this.f = publishLimitsEventTracker;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(FeeMethodsViewModelImpl.class)) {
            return new FeeMethodsViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
