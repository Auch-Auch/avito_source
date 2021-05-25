package com.avito.android.tariff.edit_info.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoRepository;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoRepository;", "repository", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoConverter;", "c", "Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoConverter;", "converter", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "checkoutContext", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Ljava/lang/String;Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoRepository;Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoConverter;Lcom/avito/android/util/SchedulersFactory;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class EditInfoViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final EditInfoRepository b;
    public final EditInfoConverter c;
    public final SchedulersFactory d;

    @Inject
    public EditInfoViewModelFactory(@NotNull String str, @NotNull EditInfoRepository editInfoRepository, @NotNull EditInfoConverter editInfoConverter, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Intrinsics.checkNotNullParameter(editInfoRepository, "repository");
        Intrinsics.checkNotNullParameter(editInfoConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = str;
        this.b = editInfoRepository;
        this.c = editInfoConverter;
        this.d = schedulersFactory;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(EditInfoViewModelImpl.class)) {
            return new EditInfoViewModelImpl(this.a, this.b, this.c, this.d);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
