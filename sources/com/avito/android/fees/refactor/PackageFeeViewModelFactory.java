package com.avito.android.fees.refactor;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.OwnedPackage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/fees/refactor/PackageFeeViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/fees/refactor/PackageItemConverter;", "c", "Lcom/avito/android/fees/refactor/PackageItemConverter;", "converter", "", "Lcom/avito/android/remote/model/OwnedPackage;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "packages", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "message", "Lcom/avito/android/fees/refactor/PackageApplyInteractor;", "d", "Lcom/avito/android/fees/refactor/PackageApplyInteractor;", "interactor", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/fees/refactor/PackageItemConverter;Lcom/avito/android/fees/refactor/PackageApplyInteractor;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class PackageFeeViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final List<OwnedPackage> b;
    public final PackageItemConverter c;
    public final PackageApplyInteractor d;

    public PackageFeeViewModelFactory(@NotNull String str, @NotNull List<OwnedPackage> list, @NotNull PackageItemConverter packageItemConverter, @NotNull PackageApplyInteractor packageApplyInteractor) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(list, "packages");
        Intrinsics.checkNotNullParameter(packageItemConverter, "converter");
        Intrinsics.checkNotNullParameter(packageApplyInteractor, "interactor");
        this.a = str;
        this.b = list;
        this.c = packageItemConverter;
        this.d = packageApplyInteractor;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(PackageFeeViewModelImpl.class)) {
            return new PackageFeeViewModelImpl(this.a, this.b, this.c, this.d);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
