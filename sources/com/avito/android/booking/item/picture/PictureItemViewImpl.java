package com.avito.android.booking.item.picture;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.avito.android.booking.R;
import com.avito.android.lib.util.DarkThemeManagerKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/booking/item/picture/PictureItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/booking/item/picture/PictureItemView;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class PictureItemViewImpl extends BaseViewHolder implements PictureItemView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PictureItemViewImpl(@NotNull View view) {
        super(view);
        int i;
        Intrinsics.checkNotNullParameter(view, "view");
        ImageView imageView = (ImageView) view.findViewById(R.id.booking_picture);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        if (DarkThemeManagerKt.isDarkTheme(context)) {
            i = R.drawable.booking_picture_dark;
        } else {
            i = R.drawable.booking_picture_light;
        }
        imageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(), i));
    }
}
