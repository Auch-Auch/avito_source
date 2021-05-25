package com.avito.android.messenger.channels.mvi.data;

import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\b\u0010\tJ1\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f0\u00052\u0006\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00110\u00122\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/UserRepoReader;", "", "", "", "userIds", "Lio/reactivex/Observable;", "", "", "getUserLastActionTimes", "(Ljava/util/Collection;)Lio/reactivex/Observable;", "cutoffTime", "limitToIdsIn", "", "getIdsOfUsersWithLastActionTimeOlderOrEqualTo", "(JLjava/util/Collection;)Lio/reactivex/Observable;", "currentUserId", "channelId", "", "Lio/reactivex/Single;", "getNotExistedUsersFromGivenIds", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)Lio/reactivex/Single;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface UserRepoReader {
    @NotNull
    Observable<List<String>> getIdsOfUsersWithLastActionTimeOlderOrEqualTo(long j, @NotNull Collection<String> collection);

    @NotNull
    Single<Set<String>> getNotExistedUsersFromGivenIds(@NotNull String str, @NotNull String str2, @NotNull Set<String> set);

    @NotNull
    Observable<Map<String, Long>> getUserLastActionTimes(@NotNull Collection<String> collection);
}
