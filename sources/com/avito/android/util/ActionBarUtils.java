package com.avito.android.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.StringRes;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ!\u0010\f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/util/ActionBarUtils;", "", "Landroidx/appcompat/app/ActionBar;", "bar", "", "title", MessengerShareContentUtility.SUBTITLE, "", "showDefaultActionBar", "(Landroidx/appcompat/app/ActionBar;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "actionBar", "", "setActionBarTitle", "(Landroidx/appcompat/app/ActionBar;I)V", "(Landroidx/appcompat/app/ActionBar;Ljava/lang/CharSequence;)V", "Landroid/content/Context;", "context", "getActionBarSize", "(Landroid/content/Context;)I", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "setSupportActionBar", "(Landroidx/appcompat/app/AppCompatActivity;Landroidx/appcompat/widget/Toolbar;)V", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class ActionBarUtils {
    @NotNull
    public static final ActionBarUtils INSTANCE = new ActionBarUtils();

    public static /* synthetic */ void showDefaultActionBar$default(ActionBarUtils actionBarUtils, ActionBar actionBar, CharSequence charSequence, CharSequence charSequence2, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence = null;
        }
        if ((i & 4) != 0) {
            charSequence2 = null;
        }
        actionBarUtils.showDefaultActionBar(actionBar, charSequence, charSequence2);
    }

    @SuppressLint({"PrivateResource"})
    public final int getActionBarSize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
            return 0;
        }
        int i = typedValue.data;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return TypedValue.complexToDimensionPixelSize(i, resources.getDisplayMetrics());
    }

    public final void setActionBarTitle(@Nullable ActionBar actionBar, @StringRes int i) {
        if (actionBar != null) {
            setActionBarTitle(actionBar, actionBar.getThemedContext().getString(i));
        }
    }

    public final void setSupportActionBar(@NotNull AppCompatActivity appCompatActivity, @Nullable Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        if (toolbar != null) {
            try {
                appCompatActivity.setSupportActionBar(toolbar);
            } catch (Throwable th) {
                Logs.error("ActionBarUtils", "setSupportActionBar", th);
            }
        }
    }

    @JvmOverloads
    public final void showDefaultActionBar(@Nullable ActionBar actionBar) {
        showDefaultActionBar$default(this, actionBar, null, null, 6, null);
    }

    @JvmOverloads
    public final void showDefaultActionBar(@Nullable ActionBar actionBar, @Nullable CharSequence charSequence) {
        showDefaultActionBar$default(this, actionBar, charSequence, null, 4, null);
    }

    @JvmOverloads
    public final void showDefaultActionBar(@Nullable ActionBar actionBar, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if (actionBar != null) {
            setActionBarTitle(actionBar, charSequence);
            if (TextUtils.isEmpty(charSequence2)) {
                actionBar.setSubtitle((CharSequence) null);
                return;
            }
            Context themedContext = actionBar.getThemedContext();
            Intrinsics.checkNotNullExpressionValue(themedContext, "actionBar.themedContext");
            Intrinsics.checkNotNull(charSequence2);
            actionBar.setSubtitle(Typefaces.getTypefaceSpannable(themedContext, charSequence2, TypefaceType.Regular));
        }
    }

    public final void setActionBarTitle(@Nullable ActionBar actionBar, @Nullable CharSequence charSequence) {
        if (actionBar != null) {
            if (charSequence != null) {
                Context themedContext = actionBar.getThemedContext();
                Intrinsics.checkNotNullExpressionValue(themedContext, "actionBar.themedContext");
                actionBar.setTitle(Typefaces.getTypefaceSpannable(themedContext, charSequence, TypefaceType.Medium));
                return;
            }
            actionBar.setTitle((CharSequence) null);
        }
    }
}
