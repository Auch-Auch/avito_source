package com.avito.android.profile_phones.phones_list.list_item;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.profile_phones.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemView;", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemPresenter;", "getPresenter", "()Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemPresenter;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneListItemBlueprint implements ItemBlueprint<PhoneListItemView, PhoneListItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<PhoneListItemView> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.phone_list_item, a.a);
    @NotNull
    public final PhoneListItemPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, PhoneListItemView> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public PhoneListItemView invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new PhoneListItemView(view2);
        }
    }

    public PhoneListItemBlueprint(@NotNull PhoneListItemPresenter phoneListItemPresenter) {
        Intrinsics.checkNotNullParameter(phoneListItemPresenter, "presenter");
        this.b = phoneListItemPresenter;
    }

    /* Return type fixed from 'com.avito.android.profile_phones.phones_list.list_item.PhoneListItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<PhoneListItemView, PhoneListItem> getPresenter() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<PhoneListItemView> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof PhoneListItem;
    }
}
