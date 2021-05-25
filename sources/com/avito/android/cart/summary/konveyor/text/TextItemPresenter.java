package com.avito.android.cart.summary.konveyor.text;

import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/cart/summary/konveyor/text/TextItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/cart/summary/konveyor/text/TextItemView;", "Lcom/avito/android/cart/summary/konveyor/text/TextItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/cart/summary/konveyor/text/TextItemView;Lcom/avito/android/cart/summary/konveyor/text/TextItem;I)V", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "deepLinksConsumer", "<init>", "(Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class TextItemPresenter implements ItemPresenter<TextItemView, TextItem> {
    public final OnDeepLinkClickListener a;

    @Inject
    public TextItemPresenter(@NotNull OnDeepLinkClickListener onDeepLinkClickListener) {
        Intrinsics.checkNotNullParameter(onDeepLinkClickListener, "deepLinksConsumer");
        this.a = onDeepLinkClickListener;
    }

    public void bindView(@NotNull TextItemView textItemView, @NotNull TextItem textItem, int i) {
        Intrinsics.checkNotNullParameter(textItemView, "view");
        Intrinsics.checkNotNullParameter(textItem, "item");
        textItem.getText().setOnDeepLinkClickListener(this.a);
        textItemView.setText(textItem.getText());
    }
}
