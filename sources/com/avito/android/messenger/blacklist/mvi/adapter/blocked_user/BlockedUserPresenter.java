package com.avito.android.messenger.blacklist.mvi.adapter.blocked_user;

import com.avito.android.messenger.blacklist.mvi.adapter.BlacklistItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/adapter/blocked_user/BlockedUserPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/blacklist/mvi/adapter/blocked_user/BlockedUserView;", "Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem$BlockedUser;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/blacklist/mvi/adapter/blocked_user/BlockedUserView;Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem$BlockedUser;I)V", "Ldagger/Lazy;", "Lcom/avito/android/messenger/blacklist/mvi/adapter/blocked_user/UnblockClickListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", "unblockClickListener", "<init>", "(Ldagger/Lazy;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlockedUserPresenter implements ItemPresenter<BlockedUserView, BlacklistItem.BlockedUser> {
    public final Lazy<UnblockClickListener> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ BlockedUserPresenter a;
        public final /* synthetic */ BlacklistItem.BlockedUser b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BlockedUserPresenter blockedUserPresenter, BlacklistItem.BlockedUser blockedUser) {
            super(0);
            this.a = blockedUserPresenter;
            this.b = blockedUser;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((UnblockClickListener) this.a.a.get()).onUnblockClick(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public BlockedUserPresenter(@NotNull Lazy<UnblockClickListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "unblockClickListener");
        this.a = lazy;
    }

    public void bindView(@NotNull BlockedUserView blockedUserView, @NotNull BlacklistItem.BlockedUser blockedUser, int i) {
        Intrinsics.checkNotNullParameter(blockedUserView, "view");
        Intrinsics.checkNotNullParameter(blockedUser, "item");
        blockedUserView.setDate(blockedUser.getCreated());
        String userName = blockedUser.getUserName();
        if (userName == null) {
            userName = blockedUser.getUserId();
        }
        blockedUserView.setUserName(userName);
        blockedUserView.setItemTitle(blockedUser.getItemTitle());
        blockedUserView.setItemCategory(blockedUser.getItemCategory());
        blockedUserView.setItemPrice(blockedUser.getItemPrice());
        blockedUserView.setInProgress(blockedUser.getUnblockingInProgress());
        blockedUserView.setOnUnblockClickListener(new a(this, blockedUser));
    }
}
