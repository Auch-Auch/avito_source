package androidx.navigation.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/navigation/NavController;", "navController", "Landroidx/drawerlayout/widget/DrawerLayout;", "drawerLayout", "", "setupActionBarWithNavController", "(Landroidx/appcompat/app/AppCompatActivity;Landroidx/navigation/NavController;Landroidx/drawerlayout/widget/DrawerLayout;)V", "Landroidx/navigation/ui/AppBarConfiguration;", "configuration", "(Landroidx/appcompat/app/AppCompatActivity;Landroidx/navigation/NavController;Landroidx/navigation/ui/AppBarConfiguration;)V", "navigation-ui-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class ActivityKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void setupActionBarWithNavController(@org.jetbrains.annotations.NotNull androidx.appcompat.app.AppCompatActivity r3, @org.jetbrains.annotations.NotNull androidx.navigation.NavController r4, @org.jetbrains.annotations.Nullable androidx.drawerlayout.widget.DrawerLayout r5) {
        /*
            java.lang.String r0 = "$this$setupActionBarWithNavController"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "navController"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            androidx.navigation.NavGraph r0 = r4.getGraph()
            java.lang.String r1 = "navController.graph"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$1 r1 = androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE
            androidx.navigation.ui.AppBarConfiguration$Builder r2 = new androidx.navigation.ui.AppBarConfiguration$Builder
            r2.<init>(r0)
            androidx.navigation.ui.AppBarConfiguration$Builder r5 = r2.setDrawerLayout(r5)
            if (r1 == 0) goto L_0x0026
            androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0 r0 = new androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0
            r0.<init>(r1)
            r1 = r0
        L_0x0026:
            androidx.navigation.ui.AppBarConfiguration$OnNavigateUpListener r1 = (androidx.navigation.ui.AppBarConfiguration.OnNavigateUpListener) r1
            androidx.navigation.ui.AppBarConfiguration$Builder r5 = r5.setFallbackOnNavigateUpListener(r1)
            androidx.navigation.ui.AppBarConfiguration r5 = r5.build()
            java.lang.String r0 = "AppBarConfiguration.Buil…eUpListener)\n    .build()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r0)
            androidx.navigation.ui.NavigationUI.setupActionBarWithNavController(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.ui.ActivityKt.setupActionBarWithNavController(androidx.appcompat.app.AppCompatActivity, androidx.navigation.NavController, androidx.drawerlayout.widget.DrawerLayout):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void setupActionBarWithNavController$default(androidx.appcompat.app.AppCompatActivity r1, androidx.navigation.NavController r2, androidx.navigation.ui.AppBarConfiguration r3, int r4, java.lang.Object r5) {
        /*
            r4 = r4 & 2
            if (r4 == 0) goto L_0x0030
            androidx.navigation.NavGraph r3 = r2.getGraph()
            java.lang.String r4 = "navController.graph"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            r4 = 0
            androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$1 r5 = androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE
            androidx.navigation.ui.AppBarConfiguration$Builder r0 = new androidx.navigation.ui.AppBarConfiguration$Builder
            r0.<init>(r3)
            androidx.navigation.ui.AppBarConfiguration$Builder r3 = r0.setDrawerLayout(r4)
            if (r5 == 0) goto L_0x0021
            androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0 r4 = new androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0
            r4.<init>(r5)
            r5 = r4
        L_0x0021:
            androidx.navigation.ui.AppBarConfiguration$OnNavigateUpListener r5 = (androidx.navigation.ui.AppBarConfiguration.OnNavigateUpListener) r5
            androidx.navigation.ui.AppBarConfiguration$Builder r3 = r3.setFallbackOnNavigateUpListener(r5)
            androidx.navigation.ui.AppBarConfiguration r3 = r3.build()
            java.lang.String r4 = "AppBarConfiguration.Buil…eUpListener)\n    .build()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
        L_0x0030:
            setupActionBarWithNavController(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.ui.ActivityKt.setupActionBarWithNavController$default(androidx.appcompat.app.AppCompatActivity, androidx.navigation.NavController, androidx.navigation.ui.AppBarConfiguration, int, java.lang.Object):void");
    }

    public static final void setupActionBarWithNavController(@NotNull AppCompatActivity appCompatActivity, @NotNull NavController navController, @NotNull AppBarConfiguration appBarConfiguration) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "$this$setupActionBarWithNavController");
        Intrinsics.checkParameterIsNotNull(navController, "navController");
        Intrinsics.checkParameterIsNotNull(appBarConfiguration, "configuration");
        NavigationUI.setupActionBarWithNavController(appCompatActivity, navController, appBarConfiguration);
    }
}
