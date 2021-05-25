package com.avito.android.util;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import androidx.annotation.MainThread;
import androidx.core.content.res.ResourcesCompat;
import com.avito.android.util.preferences.db_preferences.Types;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/util/Typefaces;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/util/TypefaceType;", "typeface", "Landroid/graphics/Typeface;", "getTypeface", "(Landroid/content/Context;Lcom/avito/android/util/TypefaceType;)Landroid/graphics/Typeface;", "Lcom/avito/android/util/TypefaceSpan;", "getSpan", "(Landroid/content/Context;Lcom/avito/android/util/TypefaceType;)Lcom/avito/android/util/TypefaceSpan;", "", "text", "Landroid/text/SpannableString;", "getTypefaceSpannable", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/avito/android/util/TypefaceType;)Landroid/text/SpannableString;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class Typefaces {
    @NotNull
    public static final Typefaces INSTANCE = new Typefaces();

    @JvmStatic
    @MainThread
    @NotNull
    public static final TypefaceSpan getSpan(@NotNull Context context, @NotNull TypefaceType typefaceType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(typefaceType, "typeface");
        return new TypefaceSpan(ResourcesCompat.getFont(context, typefaceType.getFontResId()));
    }

    @JvmStatic
    @MainThread
    @Nullable
    public static final Typeface getTypeface(@NotNull Context context, @NotNull TypefaceType typefaceType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(typefaceType, "typeface");
        return Typeface.createFromAsset(context.getAssets(), typefaceType.getPath());
    }

    @JvmStatic
    @MainThread
    @NotNull
    public static final SpannableString getTypefaceSpannable(@NotNull Context context, @NotNull CharSequence charSequence, @NotNull TypefaceType typefaceType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(typefaceType, "typeface");
        SpannableString valueOf = SpannableString.valueOf(charSequence);
        valueOf.setSpan(getSpan(context, typefaceType), 0, valueOf.length(), 33);
        Intrinsics.checkNotNullExpressionValue(valueOf, Types.STRING);
        return valueOf;
    }
}
