package a2.a.a.o1.a.a;

import com.avito.android.messenger.blacklist.mvi.BlacklistInteractorImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.avito.messenger.api.entity.BlockedUser;
public final class a extends Lambda implements Function1<BlockedUser, Boolean> {
    public final /* synthetic */ BlacklistInteractorImpl.UnblockUserComposite.UnblockUserMutator.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(BlacklistInteractorImpl.UnblockUserComposite.UnblockUserMutator.a aVar) {
        super(1);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(BlockedUser blockedUser) {
        BlockedUser blockedUser2 = blockedUser;
        Intrinsics.checkNotNullParameter(blockedUser2, "blockedUser");
        return Boolean.valueOf(Intrinsics.areEqual(blockedUser2.getUser().getId(), BlacklistInteractorImpl.UnblockUserComposite.this.e));
    }
}
