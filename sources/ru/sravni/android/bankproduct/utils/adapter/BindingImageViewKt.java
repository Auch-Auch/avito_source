package ru.sravni.android.bankproduct.utils.adapter;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Landroid/widget/ImageView;", "view", "", "srcId", "", "bindDrawableSource", "(Landroid/widget/ImageView;Ljava/lang/Integer;)V", "srcColorDrawable", "bindColorDrawableSource", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingImageViewKt {
    @BindingAdapter({"srcColorDrawable"})
    public static final void bindColorDrawableSource(@NotNull ImageView imageView, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(imageView, "view");
        if (num != null) {
            imageView.setColorFilter(num.intValue());
        }
    }

    @BindingAdapter({"srcDrawable"})
    public static final void bindDrawableSource(@NotNull ImageView imageView, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(imageView, "view");
        if (num != null) {
            imageView.setImageResource(num.intValue());
        }
    }
}
