package com.avito.android.publish.slots.profile_info.item;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.component.profile_snippet.AvatarRenderer;
import com.avito.android.publish.R;
import com.avito.android.remote.auth.AuthSource;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemView;", "Lcom/avito/android/publish/slots/profile_info/item/UserInfoItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemPresenter;", "getPresenter", "()Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/component/profile_snippet/AvatarRenderer;", "c", "Lcom/avito/android/component/profile_snippet/AvatarRenderer;", "avatarRenderer", "<init>", "(Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemPresenter;Lcom/avito/android/component/profile_snippet/AvatarRenderer;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class UserInfoItemBlueprint implements ItemBlueprint<UserInfoItemView, UserInfoItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<UserInfoItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.publish_contacts_user_info, new a(this));
    @NotNull
    public final UserInfoItemPresenter b;
    public final AvatarRenderer c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, UserInfoItemViewImpl> {
        public final /* synthetic */ UserInfoItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(UserInfoItemBlueprint userInfoItemBlueprint) {
            super(2);
            this.a = userInfoItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public UserInfoItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new UserInfoItemViewImpl(view2, this.a.c);
        }
    }

    @Inject
    public UserInfoItemBlueprint(@NotNull UserInfoItemPresenter userInfoItemPresenter, @NotNull AvatarRenderer avatarRenderer) {
        Intrinsics.checkNotNullParameter(userInfoItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(avatarRenderer, "avatarRenderer");
        this.b = userInfoItemPresenter;
        this.c = avatarRenderer;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<UserInfoItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof UserInfoItem;
    }

    /* Return type fixed from 'com.avito.android.publish.slots.profile_info.item.UserInfoItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<UserInfoItemView, UserInfoItem> getPresenter() {
        return this.b;
    }
}
