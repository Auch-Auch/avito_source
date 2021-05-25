package ru.sravni.android.bankproduct.presentation.navigation;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Navigator;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\fJ\u0017\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lru/sravni/android/bankproduct/presentation/navigation/CiceroneHolder;", "Lru/sravni/android/bankproduct/presentation/navigation/ICiceroneHolder;", "Lru/sravni/android/bankproduct/presentation/navigation/SravniCiceroneRouter;", "kotlin.jvm.PlatformType", "getRouter", "()Lru/sravni/android/bankproduct/presentation/navigation/SravniCiceroneRouter;", "Lru/terrakok/cicerone/Navigator;", "navigator", "", "setNavigator", "(Lru/terrakok/cicerone/Navigator;)V", "removeNavigator", "()V", "Lru/terrakok/cicerone/Cicerone;", AuthSource.SEND_ABUSE, "Lru/terrakok/cicerone/Cicerone;", "cicrone", "<init>", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class CiceroneHolder implements ICiceroneHolder {
    public final Cicerone<SravniCiceroneRouter> a;

    public CiceroneHolder() {
        Cicerone<SravniCiceroneRouter> create = Cicerone.create(new SravniCiceroneRouter());
        Intrinsics.checkExpressionValueIsNotNull(create, "Cicerone.create(SravniCiceroneRouter())");
        this.a = create;
    }

    @Override // ru.sravni.android.bankproduct.presentation.navigation.ICiceroneHolder
    public SravniCiceroneRouter getRouter() {
        return this.a.getRouter();
    }

    @Override // ru.sravni.android.bankproduct.presentation.navigation.ICiceroneHolder
    public void removeNavigator() {
        this.a.getNavigatorHolder().removeNavigator();
    }

    @Override // ru.sravni.android.bankproduct.presentation.navigation.ICiceroneHolder
    public void setNavigator(@NotNull Navigator navigator) {
        Intrinsics.checkParameterIsNotNull(navigator, "navigator");
        this.a.getNavigatorHolder().setNavigator(navigator);
    }
}
