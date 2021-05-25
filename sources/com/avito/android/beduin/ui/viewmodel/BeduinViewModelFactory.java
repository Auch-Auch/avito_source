package com.avito.android.beduin.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.beduin.common.BeduinInteractor;
import com.avito.android.beduin.core.ComponentsContext;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.beduin.core.form.ComponentsForm;
import com.avito.android.beduin.core.registry.BeduinRegistry;
import com.avito.android.remote.auth.AuthSource;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BD\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0011\u0010\u0019\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u00160\u0014\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\"\u0010#J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R!\u0010\u0019\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u00160\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/beduin/ui/viewmodel/BeduinViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/beduin/core/registry/BeduinRegistry;", AuthSource.SEND_ABUSE, "Lcom/avito/android/beduin/core/registry/BeduinRegistry;", "registry", "Lcom/avito/android/beduin/core/ComponentsContext;", "f", "Lcom/avito/android/beduin/core/ComponentsContext;", "componentsContext", "Lcom/avito/android/beduin/core/form/ComponentsForm;", "e", "Lcom/avito/android/beduin/core/form/ComponentsForm;", "componentsForm", "", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "Lkotlin/jvm/JvmSuppressWildcards;", "c", "Ljava/util/Set;", "actionHandlers", "Lcom/avito/android/beduin/common/BeduinInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/beduin/common/BeduinInteractor;", "interactor", "", "d", "Ljava/lang/String;", "url", "<init>", "(Lcom/avito/android/beduin/core/registry/BeduinRegistry;Lcom/avito/android/beduin/common/BeduinInteractor;Ljava/util/Set;Ljava/lang/String;Lcom/avito/android/beduin/core/form/ComponentsForm;Lcom/avito/android/beduin/core/ComponentsContext;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinViewModelFactory implements ViewModelProvider.Factory {
    public final BeduinRegistry a;
    public final BeduinInteractor b;
    public final Set<BeduinActionHandler> c;
    public final String d;
    public final ComponentsForm e;
    public final ComponentsContext f;

    @Inject
    public BeduinViewModelFactory(@NotNull BeduinRegistry beduinRegistry, @NotNull BeduinInteractor beduinInteractor, @NotNull Set<BeduinActionHandler> set, @NotNull String str, @NotNull ComponentsForm componentsForm, @NotNull ComponentsContext componentsContext) {
        Intrinsics.checkNotNullParameter(beduinRegistry, "registry");
        Intrinsics.checkNotNullParameter(beduinInteractor, "interactor");
        Intrinsics.checkNotNullParameter(set, "actionHandlers");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(componentsForm, "componentsForm");
        Intrinsics.checkNotNullParameter(componentsContext, "componentsContext");
        this.a = beduinRegistry;
        this.b = beduinInteractor;
        this.c = set;
        this.d = str;
        this.e = componentsForm;
        this.f = componentsContext;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return new BeduinViewModel(this.a, this.b, this.c, this.d, this.e, this.f);
    }
}
