package com.avito.android.job.cv_packages.di;

import a2.b.a.a.a;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.di.PerActivity;
import com.avito.android.job.cv_packages.Action;
import com.avito.android.job.cv_packages.JobCvPackagesViewModel;
import com.avito.android.job.cv_packages.item.PackageBlueprint;
import com.avito.android.job.cv_packages.item.PackagePresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/job/cv_packages/di/CvPackagesModule;", "", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "Lcom/avito/android/job/cv_packages/JobCvPackagesViewModel$Factory;", "factory", "Lcom/avito/android/job/cv_packages/JobCvPackagesViewModel;", "provideViewModel", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/avito/android/job/cv_packages/JobCvPackagesViewModel$Factory;)Lcom/avito/android/job/cv_packages/JobCvPackagesViewModel;", "Lcom/avito/android/job/cv_packages/item/PackagePresenter;", "presenter", "viewModel", "Lcom/avito/android/job/cv_packages/item/PackageBlueprint;", "providePackageBlueprint", "(Lcom/avito/android/job/cv_packages/item/PackagePresenter;Lcom/avito/android/job/cv_packages/JobCvPackagesViewModel;)Lcom/avito/android/job/cv_packages/item/PackageBlueprint;", "packageBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Lcom/avito/android/job/cv_packages/item/PackageBlueprint;)Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideSimpleRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "<init>", "()V", "cv-packages_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class CvPackagesModule {
    @NotNull
    public static final CvPackagesModule INSTANCE = new CvPackagesModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ItemBinder provideItemBinder(@NotNull PackageBlueprint packageBlueprint) {
        Intrinsics.checkNotNullParameter(packageBlueprint, "packageBlueprint");
        return new ItemBinder.Builder().registerItem(packageBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PackageBlueprint providePackageBlueprint(@NotNull PackagePresenter packagePresenter, @NotNull JobCvPackagesViewModel jobCvPackagesViewModel) {
        Intrinsics.checkNotNullParameter(packagePresenter, "presenter");
        Intrinsics.checkNotNullParameter(jobCvPackagesViewModel, "viewModel");
        PublishRelay<Action> actions = jobCvPackagesViewModel.getActions();
        Intrinsics.checkNotNullExpressionValue(actions, "viewModel.actions");
        return new PackageBlueprint(packagePresenter, actions);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SimpleRecyclerAdapter provideSimpleRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "presenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final JobCvPackagesViewModel provideViewModel(@NotNull AppCompatActivity appCompatActivity, @NotNull JobCvPackagesViewModel.Factory factory) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(factory, "factory");
        ViewModel viewModel = new ViewModelProvider(appCompatActivity, factory).get(JobCvPackagesViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi…gesViewModel::class.java)");
        return (JobCvPackagesViewModel) viewModel;
    }
}
