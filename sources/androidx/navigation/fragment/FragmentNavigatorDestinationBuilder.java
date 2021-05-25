package androidx.navigation.fragment;

import a2.g.r.g;
import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.NavDestinationDsl;
import androidx.navigation.fragment.FragmentNavigator;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
@NavDestinationDsl
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0001\u0010\r\u001a\u00020\f\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigatorDestinationBuilder;", "Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/fragment/FragmentNavigator$Destination;", "build", "()Landroidx/navigation/fragment/FragmentNavigator$Destination;", "Lkotlin/reflect/KClass;", "Landroidx/fragment/app/Fragment;", g.a, "Lkotlin/reflect/KClass;", "fragmentClass", "Landroidx/navigation/fragment/FragmentNavigator;", "navigator", "", "id", "<init>", "(Landroidx/navigation/fragment/FragmentNavigator;ILkotlin/reflect/KClass;)V", "navigation-fragment-ktx_release"}, k = 1, mv = {1, 4, 0})
public final class FragmentNavigatorDestinationBuilder extends NavDestinationBuilder<FragmentNavigator.Destination> {
    public final KClass<? extends Fragment> g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentNavigatorDestinationBuilder(@NotNull FragmentNavigator fragmentNavigator, @IdRes int i, @NotNull KClass<? extends Fragment> kClass) {
        super(fragmentNavigator, i);
        Intrinsics.checkParameterIsNotNull(fragmentNavigator, "navigator");
        Intrinsics.checkParameterIsNotNull(kClass, "fragmentClass");
        this.g = kClass;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    @NotNull
    public FragmentNavigator.Destination build() {
        FragmentNavigator.Destination destination = (FragmentNavigator.Destination) super.build();
        destination.setClassName(JvmClassMappingKt.getJavaClass((KClass) this.g).getName());
        return destination;
    }
}
