package com.avito.android.advert_core.discount.item.contact;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.Features;
import com.avito.android.advert_core.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.adapter.BaseViewHolder;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert_core/discount/item/contact/ContactItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert_core/discount/item/contact/ContactItemView;", "Lcom/avito/android/advert_core/discount/item/contact/ContactItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/advert_core/discount/item/contact/ContactItemPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/discount/item/contact/ContactItemPresenter;", "getPresenter", "()Lcom/avito/android/advert_core/discount/item/contact/ContactItemPresenter;", "presenter", "<init>", "(Lcom/avito/android/advert_core/discount/item/contact/ContactItemPresenter;Lcom/avito/android/Features;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class ContactItemBlueprint implements ItemBlueprint<ContactItemView, ContactItem> {
    @NotNull
    public final ContactItemPresenter a;
    public final Features b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, ContactItemViewImpl> {
        public final /* synthetic */ ContactItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ContactItemBlueprint contactItemBlueprint) {
            super(2);
            this.a = contactItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public ContactItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new ContactItemViewImpl(view2, this.a.b);
        }
    }

    @Inject
    public ContactItemBlueprint(@NotNull ContactItemPresenter contactItemPresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(contactItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = contactItemPresenter;
        this.b = features;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider() {
        return new ViewHolderBuilder.ViewHolderProvider<>(R.layout.advert_discount_item_contact, new a(this));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ContactItem;
    }

    /* Return type fixed from 'com.avito.android.advert_core.discount.item.contact.ContactItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<ContactItemView, ContactItem> getPresenter() {
        return this.a;
    }
}
