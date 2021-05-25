package com.avito.android.publish_limits_info.item;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB!\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/avito/android/publish_limits_info/item/LimitsInfoItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemView;", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/util/text/AttributedTextFormatter;", "c", "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenter;", "getPresenter", "()Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemBlueprint$LayoutProvider;", "layoutProvider", "<init>", "(Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenter;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/publish_limits_info/item/LimitsInfoItemBlueprint$LayoutProvider;)V", "LayoutProvider", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class LimitsInfoItemBlueprint implements ItemBlueprint<LimitsInfoItemView, LimitsInfoItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<LimitsInfoItemViewImpl> a;
    @NotNull
    public final LimitsInfoItemPresenter b;
    public final AttributedTextFormatter c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/publish_limits_info/item/LimitsInfoItemBlueprint$LayoutProvider;", "", "", "layout", "()I", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
    public interface LayoutProvider {
        @LayoutRes
        int layout();
    }

    public static final class a extends Lambda implements Function2<ViewGroup, View, LimitsInfoItemViewImpl> {
        public final /* synthetic */ LimitsInfoItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LimitsInfoItemBlueprint limitsInfoItemBlueprint) {
            super(2);
            this.a = limitsInfoItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public LimitsInfoItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new LimitsInfoItemViewImpl(view2, this.a.c);
        }
    }

    @Inject
    public LimitsInfoItemBlueprint(@NotNull LimitsInfoItemPresenter limitsInfoItemPresenter, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull LayoutProvider layoutProvider) {
        Intrinsics.checkNotNullParameter(limitsInfoItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "textFormatter");
        Intrinsics.checkNotNullParameter(layoutProvider, "layoutProvider");
        this.b = limitsInfoItemPresenter;
        this.c = attributedTextFormatter;
        this.a = new ViewHolderBuilder.ViewHolderProvider<>(layoutProvider.layout(), new a(this));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<LimitsInfoItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof LimitsInfoItem;
    }

    /* Return type fixed from 'com.avito.android.publish_limits_info.item.LimitsInfoItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<LimitsInfoItemView, LimitsInfoItem> getPresenter() {
        return this.b;
    }
}
