package com.avito.android.safedeal.profile_settings.konveyor.text;

import android.widget.TextView;
import com.avito.android.safedeal.profile_settings.konveyor.text.TextItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/konveyor/text/TextItemViewHolder;", "Lcom/avito/android/safedeal/profile_settings/konveyor/text/TextItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "value", "", "setText", "(Ljava/lang/CharSequence;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "textView", "<init>", "(Landroid/widget/TextView;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class TextItemViewHolder extends BaseViewHolder implements TextItemView {
    public final TextView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextItemViewHolder(@NotNull TextView textView) {
        super(textView);
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.s = textView;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        TextItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.safedeal.profile_settings.konveyor.text.TextItemView
    public void setText(@Nullable CharSequence charSequence) {
        this.s.setText(charSequence);
    }
}
