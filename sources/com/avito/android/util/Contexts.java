package com.avito.android.util;

import a2.b.a.a.a;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.messaging.Constants;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a9\u0010\u0004\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0018\b\u0004\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00030\u0006H\bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u000b\u001a9\u0010\f\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0018\b\u0004\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00030\u0006H\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000b\u001a\u0019\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u0005\u001a \u0010\u0010\u001a\u00020\u0001\"\n\b\u0000\u0010\u000f\u0018\u0001*\u00020\u000e*\u00020\u0000H\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a<\u0010\u0010\u001a\u00020\u0001\"\n\b\u0000\u0010\u000f\u0018\u0001*\u00020\u000e*\u00020\u00002\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\b\u0012H\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0014\u001a \u0010\u0016\u001a\u00020\u0001\"\n\b\u0000\u0010\u000f\u0018\u0001*\u00020\u0015*\u00020\u0000H\b¢\u0006\u0004\b\u0016\u0010\u0011\u001a\u001d\u0010\u0019\u001a\u00020\u0017*\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001b*\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001b\u0010\u001f\u001a\u00020\u0017*\u00020\u00002\b\b\u0001\u0010\u001e\u001a\u00020\u0017¢\u0006\u0004\b\u001f\u0010\u001a\u001a\u001d\u0010!\u001a\u0004\u0018\u00010 *\u00020\u00002\b\b\u0001\u0010\u001e\u001a\u00020\u0017¢\u0006\u0004\b!\u0010\"\u001a\u001d\u0010$\u001a\u00020\u0017*\u00020\u00002\b\b\u0001\u0010#\u001a\u00020\u0017H\u0007¢\u0006\u0004\b$\u0010\u001a\u001a\u001d\u0010'\u001a\u0004\u0018\u00010&*\u00020\u00002\b\b\u0001\u0010%\u001a\u00020\u0017¢\u0006\u0004\b'\u0010(\u001a\u001b\u0010*\u001a\u00020\n*\u00020\u00002\b\b\u0001\u0010)\u001a\u00020\u0017¢\u0006\u0004\b*\u0010+\u001a#\u0010*\u001a\u00020\n*\u00020\u00002\b\b\u0001\u0010)\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\n¢\u0006\u0004\b*\u0010-\u001a\u001b\u0010.\u001a\u00020\u001b*\u00020\u00002\b\b\u0001\u0010#\u001a\u00020\u0017¢\u0006\u0004\b.\u0010\u001d\u001a\u001d\u00100\u001a\u00020\u0017*\u00020\u00002\b\b\u0002\u0010/\u001a\u00020 H\u0007¢\u0006\u0004\b0\u00101\u001a\u001f\u00102\u001a\u0004\u0018\u00010 *\u00020\u00002\b\b\u0002\u0010/\u001a\u00020 H\u0007¢\u0006\u0004\b2\u00103\u001a\u0013\u00105\u001a\u000204*\u00020\u0000H\u0002¢\u0006\u0004\b5\u00106\u001a\u0011\u00107\u001a\u00020\u0017*\u00020\u0000¢\u0006\u0004\b7\u00108\u001a\u0011\u00109\u001a\u00020\u0017*\u00020\u0000¢\u0006\u0004\b9\u00108\u001a\u0011\u0010:\u001a\u00020\u0017*\u00020\u0000¢\u0006\u0004\b:\u00108\u001a\u0011\u0010;\u001a\u00020\u0017*\u00020\u0000¢\u0006\u0004\b;\u00108\u001a'\u0010>\u001a\u0004\u0018\u00010&*\u00020\u00002\b\b\u0001\u0010<\u001a\u00020\u00172\b\b\u0001\u0010=\u001a\u00020\u0017¢\u0006\u0004\b>\u0010?\u001a#\u0010>\u001a\u0004\u0018\u00010&2\b\u0010@\u001a\u0004\u0018\u00010&2\b\b\u0001\u0010A\u001a\u00020\u0017¢\u0006\u0004\b>\u0010B\u001a\u0013\u0010C\u001a\u00020\n*\u00020\u0000H\u0007¢\u0006\u0004\bC\u0010D\u001a\u0019\u0010F\u001a\u00020\u0017*\u00020\u00002\u0006\u0010E\u001a\u00020\u0017¢\u0006\u0004\bF\u0010\u001a\u001a\u0019\u0010I\u001a\u00020\n2\b\u0010H\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0004\bI\u0010J\u001a'\u0010N\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010K\u001a\u00020\u00172\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L¢\u0006\u0004\bN\u0010O\u001a'\u0010P\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010K\u001a\u00020\u00172\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L¢\u0006\u0004\bP\u0010O\u001a'\u0010Q\u001a\u00020\u0017*\u00020\u00002\b\b\u0002\u0010K\u001a\u00020\u00172\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L¢\u0006\u0004\bQ\u0010R\"\u0017\u0010V\u001a\u00020S*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\bT\u0010U\u0002\u0007\n\u0005\b20\u0001¨\u0006W"}, d2 = {"Landroid/content/Context;", "Landroid/content/Intent;", "intent", "", "startActivitySafely", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorHandler", "", "(Landroid/content/Context;Landroid/content/Intent;Lkotlin/jvm/functions/Function1;)Z", "tryToStartActivity", "startActivityWithNewTask", "Landroid/app/Activity;", "T", "createActivityIntent", "(Landroid/content/Context;)Landroid/content/Intent;", "Lkotlin/ExtensionFunctionType;", "block", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)Landroid/content/Intent;", "Landroid/app/Service;", "createServiceIntent", "", "resId", "getColorCompat", "(Landroid/content/Context;I)I", "Landroid/content/res/ColorStateList;", "getColorStateListCompat", "(Landroid/content/Context;I)Landroid/content/res/ColorStateList;", "themeAttr", "getResourceIdByAttr", "", "getStringByAttr", "(Landroid/content/Context;I)Ljava/lang/String;", "colorAttr", "getColorByAttr", "drawableAttr", "Landroid/graphics/drawable/Drawable;", "getDrawableByAttr", "(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;", "boolAttr", "getBoolByAttr", "(Landroid/content/Context;I)Z", "defValue", "(Landroid/content/Context;IZ)Z", "getColorStateListByAttr", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "getVersionCode", "(Landroid/content/Context;Ljava/lang/String;)I", "getVersionName", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "Landroid/view/Display;", AuthSource.SEND_ABUSE, "(Landroid/content/Context;)Landroid/view/Display;", "getDisplayHeight", "(Landroid/content/Context;)I", "getDisplayWidth", "getRealDisplayHeight", "getRealDisplayWidth", "drawableRes", "tintColorRes", "getTintedDrawable", "(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;", "drawable", "color", "(Landroid/graphics/drawable/Drawable;I)Landroid/graphics/drawable/Drawable;", "isConnectionAvailable", "(Landroid/content/Context;)Z", "px", "pxToDp", "Landroid/net/NetworkInfo;", "networkInfo", AuthSource.BOOKING_ORDER, "(Landroid/net/NetworkInfo;)Z", "mode", "Landroid/os/PowerManager;", "powerManager", "checkTargetDarkTheme", "(Landroid/content/Context;ILandroid/os/PowerManager;)Z", "checkTargetLightTheme", "calculateTargetNightMode", "(Landroid/content/Context;ILandroid/os/PowerManager;)I", "", "getDensity", "(Landroid/content/Context;)F", "density", "android_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Contexts")
public final class Contexts {
    public static final Display a(Context context) {
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "(getSystemService(Contex…owManager).defaultDisplay");
        return defaultDisplay;
    }

    public static final boolean b(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public static final int calculateTargetNightMode(@NotNull Context context, int i, @Nullable PowerManager powerManager) {
        Intrinsics.checkNotNullParameter(context, "$this$calculateTargetNightMode");
        if (i != 1) {
            if (i == 2) {
                return 32;
            }
            if (i != 3) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                Resources resources = applicationContext.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "applicationContext\n        .resources");
                return resources.getConfiguration().uiMode & 48;
            } else if (powerManager != null && powerManager.isPowerSaveMode()) {
                return 32;
            }
        }
        return 16;
    }

    public static /* synthetic */ int calculateTargetNightMode$default(Context context, int i, PowerManager powerManager, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = AppCompatDelegate.getDefaultNightMode();
        }
        if ((i2 & 2) != 0) {
            powerManager = (PowerManager) context.getSystemService("power");
        }
        return calculateTargetNightMode(context, i, powerManager);
    }

    public static final boolean checkTargetDarkTheme(@NotNull Context context, int i, @Nullable PowerManager powerManager) {
        Intrinsics.checkNotNullParameter(context, "$this$checkTargetDarkTheme");
        return calculateTargetNightMode(context, i, powerManager) == 32;
    }

    public static /* synthetic */ boolean checkTargetDarkTheme$default(Context context, int i, PowerManager powerManager, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = AppCompatDelegate.getDefaultNightMode();
        }
        if ((i2 & 2) != 0) {
            powerManager = (PowerManager) context.getSystemService("power");
        }
        return checkTargetDarkTheme(context, i, powerManager);
    }

    public static final boolean checkTargetLightTheme(@NotNull Context context, int i, @Nullable PowerManager powerManager) {
        Intrinsics.checkNotNullParameter(context, "$this$checkTargetLightTheme");
        return calculateTargetNightMode(context, i, powerManager) != 32;
    }

    public static /* synthetic */ boolean checkTargetLightTheme$default(Context context, int i, PowerManager powerManager, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = AppCompatDelegate.getDefaultNightMode();
        }
        if ((i2 & 2) != 0) {
            powerManager = (PowerManager) context.getSystemService("power");
        }
        return checkTargetLightTheme(context, i, powerManager);
    }

    public static final /* synthetic */ <T extends Activity> Intent createActivityIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$createActivityIntent");
        Intrinsics.reifiedOperationMarker(4, "T");
        return new Intent(context, Activity.class);
    }

    public static final /* synthetic */ <T extends Service> Intent createServiceIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$createServiceIntent");
        Intrinsics.reifiedOperationMarker(4, "T");
        return new Intent(context, Service.class);
    }

    public static final boolean getBoolByAttr(@NotNull Context context, @AttrRes int i) {
        Intrinsics.checkNotNullParameter(context, "$this$getBoolByAttr");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i});
        if (obtainStyledAttributes.hasValue(0)) {
            boolean z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
            return z;
        }
        throw new Resources.NotFoundException(a.e3("Resource with name = ", context.getResources().getResourceName(i), " is not defined"));
    }

    @ColorInt
    public static final int getColorByAttr(@NotNull Context context, @AttrRes int i) {
        Intrinsics.checkNotNullParameter(context, "$this$getColorByAttr");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i});
        if (obtainStyledAttributes.hasValue(0)) {
            int color = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
            return color;
        }
        throw new Resources.NotFoundException(a.e3("Resource with name = ", context.getResources().getResourceName(i), " is not defined"));
    }

    @ColorInt
    public static final int getColorCompat(@NotNull Context context, @ColorRes int i) {
        Intrinsics.checkNotNullParameter(context, "$this$getColorCompat");
        return ContextCompat.getColor(context, i);
    }

    @NotNull
    public static final ColorStateList getColorStateListByAttr(@NotNull Context context, @AttrRes int i) {
        Intrinsics.checkNotNullParameter(context, "$this$getColorStateListByAttr");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i});
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
        if (colorStateList != null) {
            obtainStyledAttributes.recycle();
            return colorStateList;
        }
        throw new Resources.NotFoundException(a.e3("Resource with id = ", context.getResources().getResourceName(i), " is not defined"));
    }

    @Nullable
    public static final ColorStateList getColorStateListCompat(@NotNull Context context, @ColorRes int i) {
        Intrinsics.checkNotNullParameter(context, "$this$getColorStateListCompat");
        return ContextCompat.getColorStateList(context, i);
    }

    public static final float getDensity(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$density");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return resources.getDisplayMetrics().density;
    }

    public static final int getDisplayHeight(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$getDisplayHeight");
        Point point = new Point();
        a(context).getSize(point);
        return point.y;
    }

    public static final int getDisplayWidth(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$getDisplayWidth");
        Point point = new Point();
        a(context).getSize(point);
        return point.x;
    }

    @Nullable
    public static final Drawable getDrawableByAttr(@NotNull Context context, @AttrRes int i) {
        Intrinsics.checkNotNullParameter(context, "$this$getDrawableByAttr");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i});
        if (obtainStyledAttributes.hasValue(0)) {
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }
        throw new Resources.NotFoundException(a.e3("Resource with name = ", context.getResources().getResourceName(i), " is not defined"));
    }

    public static final int getRealDisplayHeight(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$getRealDisplayHeight");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        a(context).getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static final int getRealDisplayWidth(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$getRealDisplayWidth");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        a(context).getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static final int getResourceIdByAttr(@NotNull Context context, @AttrRes int i) {
        Intrinsics.checkNotNullParameter(context, "$this$getResourceIdByAttr");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    @Nullable
    public static final String getStringByAttr(@NotNull Context context, @AttrRes int i) {
        Intrinsics.checkNotNullParameter(context, "$this$getStringByAttr");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Nullable
    public static final Drawable getTintedDrawable(@NotNull Context context, @DrawableRes int i, @ColorRes int i2) {
        Intrinsics.checkNotNullParameter(context, "$this$getTintedDrawable");
        Drawable drawable = context.getDrawable(i);
        if (i2 == 0) {
            return drawable;
        }
        if (drawable != null) {
            return DrawablesKt.wrapForTinting(drawable, getColorCompat(context, i2));
        }
        return null;
    }

    @Deprecated(message = "Use BuildInfo.versionCode")
    @JvmOverloads
    public static final int getVersionCode(@NotNull Context context) {
        return getVersionCode$default(context, null, 1, null);
    }

    @Deprecated(message = "Use BuildInfo.versionCode")
    @JvmOverloads
    public static final int getVersionCode(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "$this$getVersionCode");
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_PACKAGE_NAME);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "packageManager.getPackageInfo(packageName, 0)");
            return packageInfo.versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static /* synthetic */ int getVersionCode$default(Context context, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(str, "this.packageName");
        }
        return getVersionCode(context, str);
    }

    @Deprecated(message = "Use BuildInfo.versionName")
    @JvmOverloads
    @Nullable
    public static final String getVersionName(@NotNull Context context) {
        return getVersionName$default(context, null, 1, null);
    }

    @Deprecated(message = "Use BuildInfo.versionName")
    @JvmOverloads
    @Nullable
    public static final String getVersionName(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "$this$getVersionName");
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_PACKAGE_NAME);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "packageManager.getPackageInfo(packageName, 0)");
            return packageInfo.versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ String getVersionName$default(Context context, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(str, "this.packageName");
        }
        return getVersionName(context, str);
    }

    @Deprecated(message = "Use ConnectivityProvider.isConnectionAvailable")
    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static final boolean isConnectionAvailable(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$isConnectionAvailable");
        Object systemService = context.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (!b(connectivityManager.getActiveNetworkInfo()) && !b(connectivityManager.getNetworkInfo(0))) {
            return b(connectivityManager.getNetworkInfo(1));
        }
        return true;
    }

    public static final int pxToDp(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "$this$pxToDp");
        return c.roundToInt(((float) i) / getDensity(context));
    }

    public static final boolean startActivitySafely(@NotNull Context context, @NotNull Intent intent, @NotNull Function1<? super Exception, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "$this$startActivitySafely");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(function1, "errorHandler");
        try {
            context.startActivity(IntentsKt.makeSafeForExternalApps(intent));
            return true;
        } catch (Exception e) {
            function1.invoke(e);
            return false;
        }
    }

    public static final void startActivityWithNewTask(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "$this$startActivityWithNewTask");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static final boolean tryToStartActivity(@NotNull Context context, @NotNull Intent intent, @NotNull Function1<? super Exception, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "$this$tryToStartActivity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(function1, "errorHandler");
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            function1.invoke(e);
            return false;
        }
    }

    public static final /* synthetic */ <T extends Activity> Intent createActivityIntent(Context context, Function1<? super Intent, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "$this$createActivityIntent");
        Intrinsics.checkNotNullParameter(function1, "block");
        Intrinsics.reifiedOperationMarker(4, "T");
        Intent intent = new Intent(context, Activity.class);
        function1.invoke(intent);
        return intent;
    }

    @Nullable
    public static final Drawable getTintedDrawable(@Nullable Drawable drawable, @ColorInt int i) {
        if (i == 0) {
            return drawable;
        }
        if (drawable != null) {
            return DrawablesKt.wrapForTinting(drawable, i);
        }
        return null;
    }

    @Deprecated(message = "Function deprecated", replaceWith = @ReplaceWith(expression = "startActivityForResultSafely(intent, errorHandler)", imports = {}))
    public static final void startActivitySafely(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "$this$startActivitySafely");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            context.startActivity(IntentsKt.makeSafeForExternalApps(intent));
        } catch (Exception e) {
            String name = context.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "javaClass.name");
            Logs.error(name, "", e);
        }
    }

    public static final boolean getBoolByAttr(@NotNull Context context, @AttrRes int i, boolean z) {
        Intrinsics.checkNotNullParameter(context, "$this$getBoolByAttr");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i});
        boolean z2 = obtainStyledAttributes.getBoolean(0, z);
        obtainStyledAttributes.recycle();
        return z2;
    }
}
