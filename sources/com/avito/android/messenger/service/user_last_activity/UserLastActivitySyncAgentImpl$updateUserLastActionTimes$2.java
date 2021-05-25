package com.avito.android.messenger.service.user_last_activity;

import com.avito.android.messenger.channels.mvi.data.UserRepo;
import io.reactivex.Completable;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.UserIdAndLastActionTime;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lru/avito/android/persistence/messenger/UserIdAndLastActionTime;", "p1", "Lio/reactivex/Completable;", "invoke", "(Ljava/util/Collection;)Lio/reactivex/Completable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final /* synthetic */ class UserLastActivitySyncAgentImpl$updateUserLastActionTimes$2 extends FunctionReferenceImpl implements Function1<Collection<? extends UserIdAndLastActionTime>, Completable> {
    public UserLastActivitySyncAgentImpl$updateUserLastActionTimes$2(UserRepo userRepo) {
        super(1, userRepo, UserRepo.class, "updateUserLastActionTimes", "updateUserLastActionTimes(Ljava/util/Collection;)Lio/reactivex/Completable;", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Completable invoke(Collection<? extends UserIdAndLastActionTime> collection) {
        return invoke((Collection<UserIdAndLastActionTime>) collection);
    }

    @NotNull
    public final Completable invoke(@NotNull Collection<UserIdAndLastActionTime> collection) {
        Intrinsics.checkNotNullParameter(collection, "p1");
        return ((UserRepo) this.receiver).updateUserLastActionTimes(collection);
    }
}
