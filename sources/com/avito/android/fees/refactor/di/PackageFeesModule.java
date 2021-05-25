package com.avito.android.fees.refactor.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerFragment;
import com.avito.android.fees.refactor.MvvmPackageFeeFragment;
import com.avito.android.fees.refactor.PackageApplyInteractor;
import com.avito.android.fees.refactor.PackageClickListener;
import com.avito.android.fees.refactor.PackageFeeViewModel;
import com.avito.android.fees.refactor.PackageFeeViewModelFactory;
import com.avito.android.fees.refactor.PackageFeeViewModelImpl;
import com.avito.android.fees.refactor.PackageItemConverter;
import com.avito.android.fees.refactor.PackageItemConverterImpl;
import com.avito.android.fees.refactor.PackageSelectionListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.OwnedPackage;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010(\u001a\u00020#\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\"\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010(\u001a\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/fees/refactor/di/PackageFeesModule;", "", "Lcom/avito/android/fees/refactor/PackageFeeViewModelFactory;", "factory", "Lcom/avito/android/fees/refactor/PackageFeeViewModel;", "providePackageFeeViewModel", "(Lcom/avito/android/fees/refactor/PackageFeeViewModelFactory;)Lcom/avito/android/fees/refactor/PackageFeeViewModel;", "Lcom/avito/android/fees/refactor/PackageItemConverter;", "converter", "Lcom/avito/android/fees/refactor/PackageApplyInteractor;", "interactor", "providePackageFeeViewModelFactory", "(Lcom/avito/android/fees/refactor/PackageItemConverter;Lcom/avito/android/fees/refactor/PackageApplyInteractor;)Lcom/avito/android/fees/refactor/PackageFeeViewModelFactory;", "providePackageItemConverter", "()Lcom/avito/android/fees/refactor/PackageItemConverter;", "viewModel", "Lcom/avito/android/fees/refactor/PackageClickListener;", "providePackageClickListener", "(Lcom/avito/android/fees/refactor/PackageFeeViewModel;)Lcom/avito/android/fees/refactor/PackageClickListener;", "Lcom/avito/android/fees/refactor/PackageSelectionListener;", "providePackageSelectionListener", "()Lcom/avito/android/fees/refactor/PackageSelectionListener;", "", "Lcom/avito/android/remote/model/OwnedPackage;", "c", "Ljava/util/List;", "getList", "()Ljava/util/List;", "list", "Lcom/avito/android/fees/refactor/MvvmPackageFeeFragment;", AuthSource.SEND_ABUSE, "Lcom/avito/android/fees/refactor/MvvmPackageFeeFragment;", "getFragment", "()Lcom/avito/android/fees/refactor/MvvmPackageFeeFragment;", "fragment", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Lcom/avito/android/fees/refactor/MvvmPackageFeeFragment;Ljava/lang/String;Ljava/util/List;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class})
public final class PackageFeesModule {
    @NotNull
    public final MvvmPackageFeeFragment a;
    @NotNull
    public final String b;
    @NotNull
    public final List<OwnedPackage> c;

    public PackageFeesModule(@NotNull MvvmPackageFeeFragment mvvmPackageFeeFragment, @NotNull String str, @NotNull List<OwnedPackage> list) {
        Intrinsics.checkNotNullParameter(mvvmPackageFeeFragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(list, "list");
        this.a = mvvmPackageFeeFragment;
        this.b = str;
        this.c = list;
    }

    @NotNull
    public final MvvmPackageFeeFragment getFragment() {
        return this.a;
    }

    @NotNull
    public final List<OwnedPackage> getList() {
        return this.c;
    }

    @NotNull
    public final String getMessage() {
        return this.b;
    }

    @Provides
    @PerFragment
    @NotNull
    public final PackageClickListener providePackageClickListener(@NotNull PackageFeeViewModel packageFeeViewModel) {
        Intrinsics.checkNotNullParameter(packageFeeViewModel, "viewModel");
        return packageFeeViewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final PackageFeeViewModel providePackageFeeViewModel(@NotNull PackageFeeViewModelFactory packageFeeViewModelFactory) {
        Intrinsics.checkNotNullParameter(packageFeeViewModelFactory, "factory");
        ViewModel viewModel = ViewModelProviders.of(this.a.requireActivity(), packageFeeViewModelFactory).get(PackageFeeViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (PackageFeeViewModel) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final PackageFeeViewModelFactory providePackageFeeViewModelFactory(@NotNull PackageItemConverter packageItemConverter, @NotNull PackageApplyInteractor packageApplyInteractor) {
        Intrinsics.checkNotNullParameter(packageItemConverter, "converter");
        Intrinsics.checkNotNullParameter(packageApplyInteractor, "interactor");
        return new PackageFeeViewModelFactory(this.b, this.c, packageItemConverter, packageApplyInteractor);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PackageItemConverter providePackageItemConverter() {
        return new PackageItemConverterImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final PackageSelectionListener providePackageSelectionListener() {
        return this.a;
    }
}
