package com.avito.android.publish.residential_complex_search.di;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.di.PerActivity;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.publish.residential_complex_search.ResidentialComplexConverter;
import com.avito.android.publish.residential_complex_search.ResidentialComplexConverterImpl;
import com.avito.android.publish.residential_complex_search.ResidentialComplexViewModel;
import com.avito.android.publish.residential_complex_search.adapter.button.di.ResidentialComplexButtonItemModule;
import com.avito.android.publish.residential_complex_search.adapter.title.di.ResidentialComplexSuggestItemModule;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.util.SchedulersFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006JQ\u0010\u0013\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0010\b\u0001\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexModule;", "", "Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexViewModelFactory;", "factory", "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexViewModel;", "provideViewModel", "(Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexViewModelFactory;)Lcom/avito/android/publish/residential_complex_search/ResidentialComplexViewModel;", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/remote/PublishApi;", "publishApi", "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexConverter;", "converter", "", "lat", "lng", "", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", ResidentialComplexModuleKt.VALUES, "provideViewModelFactory", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/PublishApi;Lcom/avito/android/publish/residential_complex_search/ResidentialComplexConverter;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexViewModelFactory;", "Landroidx/appcompat/app/AppCompatActivity;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/app/AppCompatActivity;", "activity", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;)V", "Dependencies", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, ResidentialComplexSuggestItemModule.class, ResidentialComplexButtonItemModule.class, Dependencies.class})
public final class ResidentialComplexModule {
    public final AppCompatActivity a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/di/ResidentialComplexModule$Dependencies;", "", "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexConverterImpl;", "converter", "Lcom/avito/android/publish/residential_complex_search/ResidentialComplexConverter;", "bindsResidentialComplexConverter", "(Lcom/avito/android/publish/residential_complex_search/ResidentialComplexConverterImpl;)Lcom/avito/android/publish/residential_complex_search/ResidentialComplexConverter;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerActivity
        @Binds
        @NotNull
        ResidentialComplexConverter bindsResidentialComplexConverter(@NotNull ResidentialComplexConverterImpl residentialComplexConverterImpl);
    }

    public ResidentialComplexModule(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        this.a = appCompatActivity;
    }

    @Provides
    @PerActivity
    @NotNull
    public final ResidentialComplexViewModel provideViewModel(@NotNull ResidentialComplexViewModelFactory residentialComplexViewModelFactory) {
        Intrinsics.checkNotNullParameter(residentialComplexViewModelFactory, "factory");
        ViewModel viewModel = ViewModelProviders.of(this.a, residentialComplexViewModelFactory).get(ResidentialComplexViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(ac…lexViewModel::class.java)");
        return (ResidentialComplexViewModel) viewModel;
    }

    @Provides
    @NotNull
    @PerActivity
    public final ResidentialComplexViewModelFactory provideViewModelFactory(@NotNull SchedulersFactory schedulersFactory, @NotNull PublishApi publishApi, @NotNull ResidentialComplexConverter residentialComplexConverter, @Named("lat") @Nullable Double d, @Named("lng") @Nullable Double d2, @Named("values") @Nullable List<SelectParameter.Value> list) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(residentialComplexConverter, "converter");
        return new ResidentialComplexViewModelFactory(schedulersFactory, publishApi, residentialComplexConverter, d, d2, list);
    }
}
