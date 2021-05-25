package com.avito.android.cart.summary.konveyor.text;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.cart.R;
import com.avito.android.lib.design.text_view.AvitoTextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/cart/summary/konveyor/text/TextItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/cart/summary/konveyor/text/TextItemView;", "Lcom/avito/android/cart/summary/konveyor/text/TextItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/util/text/AttributedTextFormatter;", "c", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/cart/summary/konveyor/text/TextItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/cart/summary/konveyor/text/TextItemPresenter;", "getPresenter", "()Lcom/avito/android/cart/summary/konveyor/text/TextItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/cart/summary/konveyor/text/TextItemViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/cart/summary/konveyor/text/TextItemPresenter;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
public final class TextItemBlueprint implements ItemBlueprint<TextItemView, TextItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<TextItemViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.cart_text_item, new a(this));
    @NotNull
    public final TextItemPresenter b;
    public final AttributedTextFormatter c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, TextItemViewHolder> {
        public final /* synthetic */ TextItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TextItemBlueprint textItemBlueprint) {
            super(2);
            this.a = textItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public TextItemViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new TextItemViewHolder((AvitoTextView) view2, this.a.c);
        }
    }

    @Inject
    public TextItemBlueprint(@NotNull TextItemPresenter textItemPresenter, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(textItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.b = textItemPresenter;
        this.c = attributedTextFormatter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<TextItemViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof TextItem;
    }

    /* Return type fixed from 'com.avito.android.cart.summary.konveyor.text.TextItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<TextItemView, TextItem> getPresenter() {
        return this.b;
    }
}
