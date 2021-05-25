package ru.sravni.android.bankproduct.presentation.offer.product.status.adapter;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.databinding.OfferProductItemStatusTextSravniBinding;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/status/adapter/OfferProductStatusTextViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "text", "", "bind", "(Ljava/lang/String;)V", "Lru/sravni/android/bankproduct/databinding/OfferProductItemStatusTextSravniBinding;", "s", "Lru/sravni/android/bankproduct/databinding/OfferProductItemStatusTextSravniBinding;", "itemBinding", "<init>", "(Lru/sravni/android/bankproduct/databinding/OfferProductItemStatusTextSravniBinding;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductStatusTextViewHolder extends RecyclerView.ViewHolder {
    public final OfferProductItemStatusTextSravniBinding s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferProductStatusTextViewHolder(@NotNull OfferProductItemStatusTextSravniBinding offerProductItemStatusTextSravniBinding) {
        super(offerProductItemStatusTextSravniBinding.getRoot());
        Intrinsics.checkParameterIsNotNull(offerProductItemStatusTextSravniBinding, "itemBinding");
        this.s = offerProductItemStatusTextSravniBinding;
    }

    public final void bind(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        TextView textView = this.s.tvText;
        Intrinsics.checkExpressionValueIsNotNull(textView, "itemBinding.tvText");
        textView.setText(str);
    }
}
