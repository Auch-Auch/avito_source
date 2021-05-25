package com.avito.android.messenger.channels.mvi.data;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.UserDao;
import ru.avito.android.persistence.messenger.UserEntity;
import ru.avito.android.persistence.messenger.UserIdAndLastActionTime;
import t6.n.e;
import t6.n.q;
import t6.n.z;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020'¢\u0006\u0004\b+\u0010,J1\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ1\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f0\u00052\u0006\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J9\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b0\u001c2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010!\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\fH\u0016¢\u0006\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/UserRepoImpl;", "Lcom/avito/android/messenger/channels/mvi/data/UserRepo;", "", "", "userIds", "Lio/reactivex/Observable;", "", "", "getUserLastActionTimes", "(Ljava/util/Collection;)Lio/reactivex/Observable;", "cutoffTime", "limitToIdsIn", "", "getIdsOfUsersWithLastActionTimeOlderOrEqualTo", "(JLjava/util/Collection;)Lio/reactivex/Observable;", ChannelContext.Item.USER_ID, "lastActionTime", "timeDiff", "Lio/reactivex/Completable;", "updateUserLastActionTime", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lio/reactivex/Completable;", "Lru/avito/android/persistence/messenger/UserIdAndLastActionTime;", "userIdAndLastActionTimes", "updateUserLastActionTimes", "(Ljava/util/Collection;)Lio/reactivex/Completable;", "currentUserId", "channelId", "", "Lio/reactivex/Single;", "getNotExistedUsersFromGivenIds", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)Lio/reactivex/Single;", "Lcom/avito/android/remote/model/User;", "users", "insertUsers", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Completable;", "Lru/avito/android/persistence/messenger/UserDao;", AuthSource.SEND_ABUSE, "Lru/avito/android/persistence/messenger/UserDao;", "userDao", "Lcom/avito/android/messenger/channels/mvi/data/UserEntityConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/channels/mvi/data/UserEntityConverter;", "userEntityConverter", "<init>", "(Lru/avito/android/persistence/messenger/UserDao;Lcom/avito/android/messenger/channels/mvi/data/UserEntityConverter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UserRepoImpl implements UserRepo {
    public final UserDao a;
    public final UserEntityConverter b;

    public static final class a<T, R> implements Function<List<? extends UserEntity>, Set<? extends String>> {
        public final /* synthetic */ Set a;

        public a(Set set) {
            this.a = set;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Set<? extends String> apply(List<? extends UserEntity> list) {
            List<? extends UserEntity> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "existedUsers");
            Set set = this.a;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getUserId());
            }
            return z.minus(set, (Iterable) CollectionsKt___CollectionsKt.toSet(arrayList));
        }
    }

    public static final class b<T, R> implements Function<List<? extends UserIdAndLastActionTime>, Map<String, ? extends Long>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Map<String, ? extends Long> apply(List<? extends UserIdAndLastActionTime> list) {
            List<? extends UserIdAndLastActionTime> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "userIdAndLastActionTimes");
            LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(e.collectionSizeOrDefault(list2, 10)), 16));
            for (T t : list2) {
                Pair pair = TuplesKt.to(t.component1(), t.component2());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    public static final class c<V> implements Callable<Object> {
        public final /* synthetic */ UserRepoImpl a;
        public final /* synthetic */ List b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public c(UserRepoImpl userRepoImpl, List list, String str, String str2) {
            this.a = userRepoImpl;
            this.b = list;
            this.c = str;
            this.d = str2;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            List<User> list = this.b;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            for (User user : list) {
                arrayList.add(this.a.b.toUserEntity(this.c, this.d, user));
            }
            return this.a.a.insertUsers(arrayList);
        }
    }

    public static final class d<V> implements Callable<Object> {
        public final /* synthetic */ UserRepoImpl a;
        public final /* synthetic */ Collection b;

        public d(UserRepoImpl userRepoImpl, Collection collection) {
            this.a = userRepoImpl;
            this.b = collection;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            this.a.a.updateUserLastActionTimes(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public UserRepoImpl(@NotNull UserDao userDao, @NotNull UserEntityConverter userEntityConverter) {
        Intrinsics.checkNotNullParameter(userDao, "userDao");
        Intrinsics.checkNotNullParameter(userEntityConverter, "userEntityConverter");
        this.a = userDao;
        this.b = userEntityConverter;
    }

    @Override // com.avito.android.messenger.channels.mvi.data.UserRepoReader
    @NotNull
    public Observable<List<String>> getIdsOfUsersWithLastActionTimeOlderOrEqualTo(long j, @NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(collection, "limitToIdsIn");
        return this.a.getIdsOfUsersWithLastActionTimeOlderOrEqualTo(j, collection);
    }

    @Override // com.avito.android.messenger.channels.mvi.data.UserRepoReader
    @NotNull
    public Single<Set<String>> getNotExistedUsersFromGivenIds(@NotNull String str, @NotNull String str2, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(set, "userIds");
        Single<R> map = this.a.getUsersExistedInDbFromGivenIds(str, str2, set).map(new a(set));
        Intrinsics.checkNotNullExpressionValue(map, "userDao.getUsersExistedI…userId).toSet()\n        }");
        return map;
    }

    @Override // com.avito.android.messenger.channels.mvi.data.UserRepoReader
    @NotNull
    public Observable<Map<String, Long>> getUserLastActionTimes(@NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(collection, "userIds");
        Observable<R> map = this.a.getUserLastActionTimes(collection).distinctUntilChanged().map(b.a);
        Intrinsics.checkNotNullExpressionValue(map, "userDao.getUserLastActio…          }\n            }");
        return map;
    }

    @Override // com.avito.android.messenger.channels.mvi.data.UserRepoWriter
    @NotNull
    public Completable insertUsers(@NotNull String str, @NotNull String str2, @NotNull List<User> list) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(list, "users");
        Completable fromCallable = Completable.fromCallable(new c(this, list, str, str2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…s(userEntities)\n        }");
        return fromCallable;
    }

    @Override // com.avito.android.messenger.channels.mvi.data.UserRepoWriter
    @NotNull
    public Completable updateUserLastActionTime(@NotNull String str, @Nullable Long l, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        return this.a.updateUserLastActionTime(str, l, l2);
    }

    @Override // com.avito.android.messenger.channels.mvi.data.UserRepoWriter
    @NotNull
    public Completable updateUserLastActionTimes(@NotNull Collection<UserIdAndLastActionTime> collection) {
        Intrinsics.checkNotNullParameter(collection, "userIdAndLastActionTimes");
        Completable fromCallable = Completable.fromCallable(new d(this, collection));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…astActionTimes)\n        }");
        return fromCallable;
    }
}
