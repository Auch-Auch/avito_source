package com.avito.android.express_cv.existed_cv.item;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.component.disclaimer.DisclaimerItem;
import com.avito.android.component.disclaimer.DisclaimerItemPresenter;
import com.avito.android.component.disclaimer.DisclaimerViewHolder;
import com.avito.android.component.disclaimer.DisclaimerViewHolderImpl;
import com.avito.android.express_cv.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/express_cv/existed_cv/item/DisclaimerBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/component/disclaimer/DisclaimerViewHolder;", "Lcom/avito/android/component/disclaimer/DisclaimerItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/component/disclaimer/DisclaimerViewHolderImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/component/disclaimer/DisclaimerItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/component/disclaimer/DisclaimerItemPresenter;", "getPresenter", "()Lcom/avito/android/component/disclaimer/DisclaimerItemPresenter;", "presenter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "c", "Lcom/avito/android/util/text/AttributedTextFormatter;", "formatter", "<init>", "(Lcom/avito/android/component/disclaimer/DisclaimerItemPresenter;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class DisclaimerBlueprint implements ItemBlueprint<DisclaimerViewHolder, DisclaimerItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<DisclaimerViewHolderImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.cv_disclaimer, new a(this));
    @NotNull
    public final DisclaimerItemPresenter b;
    public final AttributedTextFormatter c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, DisclaimerViewHolderImpl> {
        public final /* synthetic */ DisclaimerBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DisclaimerBlueprint disclaimerBlueprint) {
            super(2);
            this.a = disclaimerBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public DisclaimerViewHolderImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new DisclaimerViewHolderImpl(view2, this.a.c);
        }
    }

    public DisclaimerBlueprint(@NotNull DisclaimerItemPresenter disclaimerItemPresenter, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(disclaimerItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "formatter");
        this.b = disclaimerItemPresenter;
        this.c = attributedTextFormatter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<DisclaimerViewHolderImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof DisclaimerItem;
    }

    /* Return type fixed from 'com.avito.android.component.disclaimer.DisclaimerItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<DisclaimerViewHolder, DisclaimerItem> getPresenter() {
        return this.b;
    }
}
