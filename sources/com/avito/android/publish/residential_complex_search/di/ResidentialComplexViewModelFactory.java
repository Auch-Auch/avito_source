package com.avito.android.publish.residential_complex_search.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.publish.residential_complex_search.ResidentialComplexConverter;
import com.avito.android.publish.residential_complex_search.ResidentialComplexViewModel;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.util.SchedulersFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\u0004\b\u001f\u0010 J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\n¨\u0006!"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", "e", "Ljava/lang/Double;", "lng", "Lcom/avito/android/remote/PublishApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/PublishApi;", "publishApi", "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexConverter;", "c", "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexConverter;", "converter", "", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "f", "Ljava/util/List;", ResidentialComplexModuleKt.VALUES, "Lcom/avito/android/util/SchedulersFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "d", "lat", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/PublishApi;Lcom/avito/android/publish/residential_complex_search/ResidentialComplexConverter;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ResidentialComplexViewModelFactory implements ViewModelProvider.Factory {
    public final SchedulersFactory a;
    public final PublishApi b;
    public final ResidentialComplexConverter c;
    public final Double d;
    public final Double e;
    public final List<SelectParameter.Value> f;

    public ResidentialComplexViewModelFactory(@NotNull SchedulersFactory schedulersFactory, @NotNull PublishApi publishApi, @NotNull ResidentialComplexConverter residentialComplexConverter, @Nullable Double d2, @Nullable Double d3, @Nullable List<SelectParameter.Value> list) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(residentialComplexConverter, "converter");
        this.a = schedulersFactory;
        this.b = publishApi;
        this.c = residentialComplexConverter;
        this.d = d2;
        this.e = d3;
        this.f = list;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(ResidentialComplexViewModel.class)) {
            return new ResidentialComplexViewModel(this.a, this.b, this.c, this.d, this.e, this.f);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
