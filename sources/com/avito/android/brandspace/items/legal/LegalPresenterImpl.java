package com.avito.android.brandspace.items.legal;

import com.avito.android.brandspace.R;
import com.avito.android.brandspace.items.text.TextItemView;
import com.avito.android.brandspace.items.text.TextItemViewStyle;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/brandspace/items/legal/LegalPresenterImpl;", "Lcom/avito/android/brandspace/items/legal/LegalPresenter;", "Lcom/avito/android/brandspace/items/text/TextItemView;", "view", "Lcom/avito/android/brandspace/items/legal/LegalItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/brandspace/items/text/TextItemView;Lcom/avito/android/brandspace/items/legal/LegalItem;I)V", "<init>", "()V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class LegalPresenterImpl implements LegalPresenter {
    public void bindView(@NotNull TextItemView textItemView, @NotNull LegalItem legalItem, int i) {
        Intrinsics.checkNotNullParameter(textItemView, "view");
        Intrinsics.checkNotNullParameter(legalItem, "item");
        textItemView.setText(legalItem.getText(), TextItemViewStyle.LegalStyle.INSTANCE, R.dimen.brandspace_title_padding_bottom);
    }
}
