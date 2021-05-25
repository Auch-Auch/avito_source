package androidx.navigation;

import a2.g.r.g;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.IdRes;
import androidx.navigation.ActivityNavigator;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@NavDestinationDsl
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010+\u001a\u00020*\u0012\b\b\u0001\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR,\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010)\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000f¨\u00060"}, d2 = {"Landroidx/navigation/ActivityNavigatorDestinationBuilder;", "Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/ActivityNavigator$Destination;", "build", "()Landroidx/navigation/ActivityNavigator$Destination;", "Landroid/content/Context;", g.a, "Landroid/content/Context;", "context", "", "h", "Ljava/lang/String;", "getTargetPackage", "()Ljava/lang/String;", "setTargetPackage", "(Ljava/lang/String;)V", "targetPackage", "Lkotlin/reflect/KClass;", "Landroid/app/Activity;", "i", "Lkotlin/reflect/KClass;", "getActivityClass", "()Lkotlin/reflect/KClass;", "setActivityClass", "(Lkotlin/reflect/KClass;)V", "activityClass", "j", "getAction", "setAction", "action", "Landroid/net/Uri;", "k", "Landroid/net/Uri;", "getData", "()Landroid/net/Uri;", "setData", "(Landroid/net/Uri;)V", "data", "l", "getDataPattern", "setDataPattern", "dataPattern", "Landroidx/navigation/ActivityNavigator;", "navigator", "", "id", "<init>", "(Landroidx/navigation/ActivityNavigator;I)V", "navigation-runtime-ktx_release"}, k = 1, mv = {1, 4, 0})
public final class ActivityNavigatorDestinationBuilder extends NavDestinationBuilder<ActivityNavigator.Destination> {
    public final Context g;
    @Nullable
    public String h;
    @Nullable
    public KClass<? extends Activity> i;
    @Nullable
    public String j;
    @Nullable
    public Uri k;
    @Nullable
    public String l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityNavigatorDestinationBuilder(@NotNull ActivityNavigator activityNavigator, @IdRes int i2) {
        super(activityNavigator, i2);
        Intrinsics.checkParameterIsNotNull(activityNavigator, "navigator");
        Context context = activityNavigator.a;
        Intrinsics.checkExpressionValueIsNotNull(context, "navigator.context");
        this.g = context;
    }

    @Nullable
    public final String getAction() {
        return this.j;
    }

    @Nullable
    public final KClass<? extends Activity> getActivityClass() {
        return this.i;
    }

    @Nullable
    public final Uri getData() {
        return this.k;
    }

    @Nullable
    public final String getDataPattern() {
        return this.l;
    }

    @Nullable
    public final String getTargetPackage() {
        return this.h;
    }

    public final void setAction(@Nullable String str) {
        this.j = str;
    }

    public final void setActivityClass(@Nullable KClass<? extends Activity> kClass) {
        this.i = kClass;
    }

    public final void setData(@Nullable Uri uri) {
        this.k = uri;
    }

    public final void setDataPattern(@Nullable String str) {
        this.l = str;
    }

    public final void setTargetPackage(@Nullable String str) {
        this.h = str;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    @NotNull
    public ActivityNavigator.Destination build() {
        ActivityNavigator.Destination destination = (ActivityNavigator.Destination) super.build();
        destination.setTargetPackage(this.h);
        KClass<? extends Activity> kClass = this.i;
        if (kClass != null) {
            destination.setComponentName(new ComponentName(this.g, JvmClassMappingKt.getJavaClass((KClass) kClass)));
        }
        destination.setAction(this.j);
        destination.setData(this.k);
        destination.setDataPattern(this.l);
        return destination;
    }
}
