package com.avito.android.publish.input_vin;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/publish/input_vin/InputVinViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/publish/PublishParametersInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/PublishParametersInteractor;", "publishParametersInteractor", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "elementConverter", "Lcom/avito/android/publish/input_vin/InputVinResourceProvider;", "e", "Lcom/avito/android/publish/input_vin/InputVinResourceProvider;", "resourceProvider", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "c", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/publish/PublishParametersInteractor;Lcom/avito/android/category_parameters/CategoryParametersElementConverter;Lcom/avito/android/publish/analytics/PublishEventTracker;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/publish/input_vin/InputVinResourceProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class InputVinViewModelFactory implements ViewModelProvider.Factory {
    public final PublishParametersInteractor a;
    public final CategoryParametersElementConverter b;
    public final PublishEventTracker c;
    public final SchedulersFactory d;
    public final InputVinResourceProvider e;

    @Inject
    public InputVinViewModelFactory(@NotNull PublishParametersInteractor publishParametersInteractor, @NotNull CategoryParametersElementConverter categoryParametersElementConverter, @NotNull PublishEventTracker publishEventTracker, @NotNull SchedulersFactory schedulersFactory, @NotNull InputVinResourceProvider inputVinResourceProvider) {
        Intrinsics.checkNotNullParameter(publishParametersInteractor, "publishParametersInteractor");
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "elementConverter");
        Intrinsics.checkNotNullParameter(publishEventTracker, "publishEventTracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(inputVinResourceProvider, "resourceProvider");
        this.a = publishParametersInteractor;
        this.b = categoryParametersElementConverter;
        this.c = publishEventTracker;
        this.d = schedulersFactory;
        this.e = inputVinResourceProvider;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(InputVinViewModel.class)) {
            return new InputVinViewModel(this.a, this.b, this.c, this.d, this.e);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
