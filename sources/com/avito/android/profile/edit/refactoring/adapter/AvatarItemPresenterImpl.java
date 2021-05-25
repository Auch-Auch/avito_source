package com.avito.android.profile.edit.refactoring.adapter;

import com.avito.android.profile.edit.adapter.AvatarItemView;
import com.avito.android.profile.edit.refactoring.adapter.item.AvatarItem;
import com.avito.android.profile.edit.refactoring.avatar.ProfileAvatar;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/AvatarItemPresenterImpl;", "Lcom/avito/android/profile/edit/refactoring/adapter/AvatarItemPresenter;", "Lcom/avito/android/profile/edit/adapter/AvatarItemView;", "view", "Lcom/avito/android/profile/edit/refactoring/adapter/item/AvatarItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile/edit/adapter/AvatarItemView;Lcom/avito/android/profile/edit/refactoring/adapter/item/AvatarItem;I)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "valueConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class AvatarItemPresenterImpl implements AvatarItemPresenter {
    public final Consumer<EditProfileItem> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AvatarItemPresenterImpl a;
        public final /* synthetic */ AvatarItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AvatarItemPresenterImpl avatarItemPresenterImpl, AvatarItem avatarItem) {
            super(0);
            this.a = avatarItemPresenterImpl;
            this.b = avatarItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public AvatarItemPresenterImpl(@NotNull Consumer<EditProfileItem> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "valueConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull AvatarItemView avatarItemView, @NotNull AvatarItem avatarItem, int i) {
        Intrinsics.checkNotNullParameter(avatarItemView, "view");
        Intrinsics.checkNotNullParameter(avatarItem, "item");
        ProfileAvatar avatar = avatarItem.getAvatar();
        if (avatar != null) {
            avatarItemView.setAvatar(avatar.getPicture());
        } else {
            avatarItemView.clearAvatar();
        }
        avatarItemView.setOnClickListener(new a(this, avatarItem));
    }
}
