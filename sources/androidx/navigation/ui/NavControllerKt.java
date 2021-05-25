package androidx.navigation.ui;

import androidx.navigation.NavController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Landroidx/navigation/NavController;", "Landroidx/drawerlayout/widget/DrawerLayout;", "drawerLayout", "", "navigateUp", "(Landroidx/navigation/NavController;Landroidx/drawerlayout/widget/DrawerLayout;)Z", "Landroidx/navigation/ui/AppBarConfiguration;", "appBarConfiguration", "(Landroidx/navigation/NavController;Landroidx/navigation/ui/AppBarConfiguration;)Z", "navigation-ui-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class NavControllerKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean navigateUp(@org.jetbrains.annotations.NotNull androidx.navigation.NavController r3, @org.jetbrains.annotations.Nullable androidx.drawerlayout.widget.DrawerLayout r4) {
        /*
            java.lang.String r0 = "$this$navigateUp"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            androidx.navigation.NavGraph r0 = r3.getGraph()
            java.lang.String r1 = "graph"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$1 r1 = androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE
            androidx.navigation.ui.AppBarConfiguration$Builder r2 = new androidx.navigation.ui.AppBarConfiguration$Builder
            r2.<init>(r0)
            androidx.navigation.ui.AppBarConfiguration$Builder r4 = r2.setDrawerLayout(r4)
            if (r1 == 0) goto L_0x0021
            androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0 r0 = new androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0
            r0.<init>(r1)
            r1 = r0
        L_0x0021:
            androidx.navigation.ui.AppBarConfiguration$OnNavigateUpListener r1 = (androidx.navigation.ui.AppBarConfiguration.OnNavigateUpListener) r1
            androidx.navigation.ui.AppBarConfiguration$Builder r4 = r4.setFallbackOnNavigateUpListener(r1)
            androidx.navigation.ui.AppBarConfiguration r4 = r4.build()
            java.lang.String r0 = "AppBarConfiguration.Buil…eUpListener)\n    .build()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r0)
            boolean r3 = androidx.navigation.ui.NavigationUI.navigateUp(r3, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.ui.NavControllerKt.navigateUp(androidx.navigation.NavController, androidx.drawerlayout.widget.DrawerLayout):boolean");
    }

    public static final boolean navigateUp(@NotNull NavController navController, @NotNull AppBarConfiguration appBarConfiguration) {
        Intrinsics.checkParameterIsNotNull(navController, "$this$navigateUp");
        Intrinsics.checkParameterIsNotNull(appBarConfiguration, "appBarConfiguration");
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }
}
