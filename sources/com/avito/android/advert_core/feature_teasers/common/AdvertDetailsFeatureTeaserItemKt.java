package com.avito.android.advert_core.feature_teasers.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.text.SpannableString;
import android.text.style.DrawableMarginSpan;
import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItem;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.ViewSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a-\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "drawable", "(Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;Landroid/content/Context;)Landroid/graphics/drawable/Drawable;", "", "text", "icon", "", "drawablePadding", "textWithLeftIcon", "(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;I)Ljava/lang/CharSequence;", "advert-core_release"}, k = 2, mv = {1, 4, 2})
public final class AdvertDetailsFeatureTeaserItemKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            AdvertDetailsFeatureTeaserItem.Icon.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    @Nullable
    public static final Drawable drawable(@Nullable AdvertDetailsFeatureTeaserItem.Icon icon, @NotNull Context context) {
        Drawable drawable;
        Drawable wrapForTinting;
        Intrinsics.checkNotNullParameter(context, "context");
        if (icon == null) {
            return null;
        }
        int ordinal = icon.ordinal();
        if (ordinal == 0) {
            return context.getDrawable(R.drawable.ic_shield_24);
        }
        if (ordinal == 1) {
            Drawable drawable2 = context.getDrawable(com.avito.android.lib.design.R.drawable.ic_checkmark_20);
            if (drawable2 != null) {
                return DrawablesKt.wrapForTinting(drawable2, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.green));
            }
            return null;
        } else if (ordinal != 2 || (drawable = context.getDrawable(com.avito.android.advert_core.R.drawable.ic_status_lock)) == null || (wrapForTinting = DrawablesKt.wrapForTinting(drawable, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28))) == null) {
            return null;
        } else {
            return new InsetDrawable(wrapForTinting, 0, ViewSizeKt.getDp(3), 0, 0);
        }
    }

    @Nullable
    public static final CharSequence textWithLeftIcon(@Nullable CharSequence charSequence, @Nullable Drawable drawable, int i) {
        if (charSequence == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(charSequence);
        if (drawable != null) {
            spannableString.setSpan(new DrawableMarginSpan(drawable, i), 0, 0, 18);
        }
        return spannableString;
    }
}
