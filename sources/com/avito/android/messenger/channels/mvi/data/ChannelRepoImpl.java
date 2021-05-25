package com.avito.android.messenger.channels.mvi.data;

import arrow.core.Option;
import arrow.core.OptionKt;
import arrow.syntax.collections.ListKt;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.RxLogger;
import com.avito.android.util.RxLoggerDelegate;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.ChannelDao;
import ru.avito.android.persistence.messenger.ChannelEntity;
import ru.avito.android.persistence.messenger.ChannelTag;
import ru.avito.android.persistence.messenger.ChannelTagDao;
import ru.avito.android.persistence.messenger.DraftDao;
import ru.avito.android.persistence.messenger.DraftEntity;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.android.persistence.messenger.MessageEntity;
import ru.avito.android.persistence.messenger.UserDao;
import ru.avito.android.persistence.messenger.UserEntity;
import t6.n.q;
import t6.n.r;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B9\b\u0007\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010_\u001a\u00020\\\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010S\u001a\u00020P¢\u0006\u0004\b`\u0010aJ#\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\rJ#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\tJY\u0010\u0019\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016j\u0002`\u00180\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJO\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016¢\u0006\u0004\b!\u0010\"JO\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016¢\u0006\u0004\b!\u0010%JG\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000b0\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u001e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016¢\u0006\u0004\b'\u0010(JG\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016¢\u0006\u0004\b)\u0010\u001aJ+\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b/\u0010.J\u001f\u00101\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0007H\u0016¢\u0006\u0004\b1\u00102J%\u00104\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u00032\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b6\u0010.J'\u00106\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b6\u00108J%\u00109\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0016¢\u0006\u0004\b9\u00105J;\u0010:\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016¢\u0006\u0004\b:\u0010;J;\u0010<\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016¢\u0006\u0004\b<\u0010;J\u001d\u0010?\u001a\u00020,2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u0013H\u0016¢\u0006\u0004\b?\u0010@J\u001c\u0010B\u001a\u00020,*\u00020,2\u0006\u0010A\u001a\u00020\u0003H\u0001¢\u0006\u0004\bB\u0010CJ.\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010A\u001a\u00020\u0003H\u0001¢\u0006\u0004\bB\u0010EJ.\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000F\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u00028\u00000F2\u0006\u0010A\u001a\u00020\u0003H\u0001¢\u0006\u0004\bB\u0010GR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^¨\u0006b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/ChannelRepoImpl;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelRepo;", "Lcom/avito/android/util/RxLogger;", "", ChannelContext.Item.USER_ID, "Lio/reactivex/Observable;", "", "Lcom/avito/android/remote/model/messenger/Channel;", "getAllChannels", "(Ljava/lang/String;)Lio/reactivex/Observable;", "channelId", "Larrow/core/Option;", "getChannel", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "itemId", "getChannelIdByItemId", "getAvitoChannelId", "", "timestamp", "", "tags", "excludeTags", "Lkotlin/Pair;", "Lru/avito/android/persistence/messenger/DraftEntity;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelAndDraft;", "getChannelsAndDraftsStartingFromTimestamp", "(Ljava/lang/String;JLjava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Observable;", "channelIds", "getBareChannels", "(Ljava/lang/String;Ljava/util/Collection;)Lio/reactivex/Observable;", "", "offset", "limit", "getNonEmptyChannelIds", "(Ljava/lang/String;IILjava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Observable;", "olderOrEqualToTimestamp", "newerOrEqualToTimestamp", "(Ljava/lang/String;JJLjava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Observable;", VKApiConst.POSITION, "getTimestampOfNonEmptyChannelAtPosition", "(Ljava/lang/String;ILjava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Observable;", "getEmptyChannelsNewerThanTimestamp", "getIdsOfEmptyChannelsOlderThanTimestamp", "(Ljava/lang/String;J)Lio/reactivex/Observable;", "Lio/reactivex/Completable;", "setChannelIsRead", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "deleteChannelContextActions", "channel", "putChannel", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/Channel;)Lio/reactivex/Completable;", ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS, "putChannels", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Completable;", "deleteChannel", "interlocutorId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "deleteChannelsById", "deleteNonEmptyChannelsOlderThanTimestamp", "(Ljava/lang/String;JLjava/util/Collection;Ljava/util/Collection;)Lio/reactivex/Completable;", "deleteNonEmptyChannelsNewerThatTimestamp", "Lru/avito/android/persistence/messenger/ChannelTag;", "channelTags", "deleteChannelTags", "(Ljava/util/Collection;)Lio/reactivex/Completable;", "message", "log", "(Lio/reactivex/Completable;Ljava/lang/String;)Lio/reactivex/Completable;", "T", "(Lio/reactivex/Observable;Ljava/lang/String;)Lio/reactivex/Observable;", "Lio/reactivex/Single;", "(Lio/reactivex/Single;Ljava/lang/String;)Lio/reactivex/Single;", "Lru/avito/android/persistence/messenger/DraftDao;", AuthSource.BOOKING_ORDER, "Lru/avito/android/persistence/messenger/DraftDao;", "draftDao", "Lru/avito/android/persistence/messenger/ChannelTagDao;", "e", "Lru/avito/android/persistence/messenger/ChannelTagDao;", "channelTagDao", "Lcom/avito/android/messenger/channels/mvi/data/ChannelEntityConverter;", "f", "Lcom/avito/android/messenger/channels/mvi/data/ChannelEntityConverter;", "channelEntityConverter", "Lru/avito/android/persistence/messenger/ChannelDao;", AuthSource.SEND_ABUSE, "Lru/avito/android/persistence/messenger/ChannelDao;", "channelDao", "Lru/avito/android/persistence/messenger/UserDao;", "c", "Lru/avito/android/persistence/messenger/UserDao;", "userDao", "Lru/avito/android/persistence/messenger/MessageDao;", "d", "Lru/avito/android/persistence/messenger/MessageDao;", "messageDao", "<init>", "(Lru/avito/android/persistence/messenger/ChannelDao;Lru/avito/android/persistence/messenger/DraftDao;Lru/avito/android/persistence/messenger/UserDao;Lru/avito/android/persistence/messenger/MessageDao;Lru/avito/android/persistence/messenger/ChannelTagDao;Lcom/avito/android/messenger/channels/mvi/data/ChannelEntityConverter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelRepoImpl implements ChannelRepo, RxLogger {
    public final ChannelDao a;
    public final DraftDao b;
    public final UserDao c;
    public final MessageDao d;
    public final ChannelTagDao e;
    public final ChannelEntityConverter f;
    public final /* synthetic */ RxLoggerDelegate g = new RxLoggerDelegate(false, "ChannelRepo");

    public static final class a<V> implements Callable<Object> {
        public final /* synthetic */ ChannelRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(ChannelRepoImpl channelRepoImpl, String str, String str2) {
            this.a = channelRepoImpl;
            this.b = str;
            this.c = str2;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            this.a.a.deleteChannelAndTags(this.b, this.c);
            return Unit.INSTANCE;
        }
    }

    public static final class b<V> implements Callable<Object> {
        public final /* synthetic */ ChannelRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public b(ChannelRepoImpl channelRepoImpl, String str, String str2, String str3) {
            this.a = channelRepoImpl;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            this.a.a.deleteChannelAndTags(this.b, this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    public static final class c<V> implements Callable<Object> {
        public final /* synthetic */ ChannelRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ List c;

        public c(ChannelRepoImpl channelRepoImpl, String str, List list) {
            this.a = channelRepoImpl;
            this.b = str;
            this.c = list;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            this.a.a.deleteChannelsAndTags(this.b, this.c);
            return Unit.INSTANCE;
        }
    }

    public static final class d<V> implements Callable<Object> {
        public final /* synthetic */ ChannelRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Collection d;
        public final /* synthetic */ Collection e;

        public d(ChannelRepoImpl channelRepoImpl, String str, long j, Collection collection, Collection collection2) {
            this.a = channelRepoImpl;
            this.b = str;
            this.c = j;
            this.d = collection;
            this.e = collection2;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            this.a.a.deleteNonEmptyChannelsAndTagsNewerThatTimestamp(this.b, this.c, this.d, this.e);
            return Unit.INSTANCE;
        }
    }

    public static final class e<V> implements Callable<Object> {
        public final /* synthetic */ ChannelRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Collection d;
        public final /* synthetic */ Collection e;

        public e(ChannelRepoImpl channelRepoImpl, String str, long j, Collection collection, Collection collection2) {
            this.a = channelRepoImpl;
            this.b = str;
            this.c = j;
            this.d = collection;
            this.e = collection2;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            this.a.a.deleteNonEmptyChannelsAndTagsOlderThanTimestamp(this.b, this.c, this.d, this.e);
            return Unit.INSTANCE;
        }
    }

    public static final class f<T, R> implements Function<List<? extends ChannelEntity>, ObservableSource<? extends List<? extends Channel>>> {
        public final /* synthetic */ ChannelRepoImpl a;
        public final /* synthetic */ String b;

        public f(ChannelRepoImpl channelRepoImpl, String str) {
            this.a = channelRepoImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends List<? extends Channel>> apply(List<? extends ChannelEntity> list) {
            List<? extends ChannelEntity> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "channelEntities");
            if (!list2.isEmpty()) {
                ChannelRepoImpl channelRepoImpl = this.a;
                String str = this.b;
                ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getChannelId());
                }
                Observable<R> map = channelRepoImpl.c.getUsersForChannels(str, arrayList).distinctUntilChanged().map(new ChannelRepoImpl$getUsersByChannelId$1(channelRepoImpl));
                Intrinsics.checkNotNullExpressionValue(map, "userDao.getUsersForChann…   usersMap\n            }");
                Observable<R> map2 = channelRepoImpl.e.getChannelsTags(str, arrayList).distinctUntilChanged().map(new ChannelRepoKt$sam$i$io_reactivex_functions_Function$0(new ChannelRepoImpl$getTagsByChannelId$1(channelRepoImpl)));
                Intrinsics.checkNotNullExpressionValue(map2, "channelTagDao.getChannel…        .map(::toTagsMap)");
                Observable<R> map3 = channelRepoImpl.d.getLastMesssagesForChannels(str, arrayList).distinctUntilChanged().map(ChannelRepoImpl$getLastMessagesByChannelId$1.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(map3, "messageDao.getLastMesssa…:channelId)\n            }");
                Observable combineLatest = Observable.combineLatest(map, map2, map3, new ChannelRepoImpl$getAllChannels$1$toListOfChannelsObservable$$inlined$observableCombineLatest$1(channelRepoImpl, list2));
                Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ction(t1, t2, t3) }\n    )");
                return combineLatest;
            }
            Observable just = Observable.just(CollectionsKt__CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        }
    }

    public static final class g<T, R> implements Function<List<? extends String>, Option<? extends String>> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends String> apply(List<? extends String> list) {
            List<? extends String> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "channelIdList");
            return ListKt.firstOption(list2);
        }
    }

    public static final class h<T, R> implements Function<Triple<? extends List<? extends ChannelEntity>, ? extends List<? extends ChannelTag>, ? extends Map<String, ? extends List<UserEntity>>>, List<? extends Channel>> {
        public final /* synthetic */ ChannelRepoImpl a;

        public h(ChannelRepoImpl channelRepoImpl) {
            this.a = channelRepoImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends Channel> apply(Triple<? extends List<? extends ChannelEntity>, ? extends List<? extends ChannelTag>, ? extends Map<String, ? extends List<UserEntity>>> triple) {
            Channel channel;
            Triple<? extends List<? extends ChannelEntity>, ? extends List<? extends ChannelTag>, ? extends Map<String, ? extends List<UserEntity>>> triple2 = triple;
            Intrinsics.checkNotNullParameter(triple2, "<name for destructuring parameter 0>");
            List list = (List) triple2.component1();
            List list2 = (List) triple2.component2();
            Map map = (Map) triple2.component3();
            ChannelRepoImpl channelRepoImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list, "channelEntities");
            Intrinsics.checkNotNullExpressionValue(list2, "tags");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (T t : list2) {
                List list3 = (List) linkedHashMap.get(t.getChannelId());
                if (list3 != null) {
                    list3.add(t);
                } else {
                    linkedHashMap.put(t.getChannelId(), CollectionsKt__CollectionsKt.mutableListOf(t));
                }
            }
            Map emptyMap = r.emptyMap();
            ArrayList arrayList = new ArrayList();
            for (T t2 : list) {
                List<UserEntity> list4 = (List) map.get(t2.getChannelId());
                if (list4 != null) {
                    ChannelEntityConverter channelEntityConverter = channelRepoImpl.f;
                    List list5 = (List) linkedHashMap.get(t2.getChannelId());
                    if (list5 == null) {
                        list5 = CollectionsKt__CollectionsKt.emptyList();
                    }
                    channel = channelEntityConverter.toChannel(t2, list4, list5, (MessageEntity) emptyMap.get(t2.getChannelId()));
                } else {
                    channel = null;
                }
                if (channel != null) {
                    arrayList.add(channel);
                }
            }
            return arrayList;
        }
    }

    public static final class i<T, R> implements Function<List<? extends String>, Option<? extends String>> {
        public static final i a = new i();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends String> apply(List<? extends String> list) {
            List<? extends String> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "channelIdList");
            return ListKt.firstOption(list2);
        }
    }

    public static final class j<T, R> implements Function<List<? extends ChannelEntity>, ObservableSource<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>>> {
        public final /* synthetic */ ChannelRepoImpl a;
        public final /* synthetic */ String b;

        public j(ChannelRepoImpl channelRepoImpl, String str) {
            this.a = channelRepoImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends List<? extends Pair<? extends Channel, ? extends DraftEntity>>> apply(List<? extends ChannelEntity> list) {
            List<? extends ChannelEntity> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "channelEntities");
            if (!list2.isEmpty()) {
                ChannelRepoImpl channelRepoImpl = this.a;
                String str = this.b;
                ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getChannelId());
                }
                Observable<R> map = channelRepoImpl.c.getUsersForChannels(str, arrayList).distinctUntilChanged().map(new ChannelRepoImpl$getUsersByChannelId$1(channelRepoImpl));
                Intrinsics.checkNotNullExpressionValue(map, "userDao.getUsersForChann…   usersMap\n            }");
                Observable<R> map2 = channelRepoImpl.e.getChannelsTags(str, arrayList).distinctUntilChanged().map(new ChannelRepoKt$sam$i$io_reactivex_functions_Function$0(new ChannelRepoImpl$getTagsByChannelId$1(channelRepoImpl)));
                Intrinsics.checkNotNullExpressionValue(map2, "channelTagDao.getChannel…        .map(::toTagsMap)");
                Observable<R> map3 = channelRepoImpl.d.getLastMesssagesForChannels(str, arrayList).distinctUntilChanged().map(ChannelRepoImpl$getLastMessagesByChannelId$1.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(map3, "messageDao.getLastMesssa…:channelId)\n            }");
                Observable combineLatest = Observable.combineLatest(map, map2, map3, new ChannelRepoImpl$getChannelsAndDraftsStartingFromTimestamp$1$toListOfChannelsObservable$$inlined$observableCombineLatest$1(channelRepoImpl, list2));
                Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ction(t1, t2, t3) }\n    )");
                DraftDao draftDao = channelRepoImpl.b;
                ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(it2.next().getChannelId());
                }
                Observable<List<DraftEntity>> distinctUntilChanged = draftDao.getDraftsForChannelIds(str, arrayList2).distinctUntilChanged();
                Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "draftDao.getDraftsForCha…  .distinctUntilChanged()");
                Observable combineLatest2 = Observable.combineLatest(combineLatest, distinctUntilChanged, new ChannelRepoImpl$getChannelsAndDraftsStartingFromTimestamp$1$toListOfChannelsAndDraftsObservable$$inlined$combineLatestWith$1(channelRepoImpl));
                Intrinsics.checkNotNullExpressionValue(combineLatest2, "Observable.combineLatest…ombineFunction(t1, t2) })");
                return combineLatest2;
            }
            Observable just = Observable.just(CollectionsKt__CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        }
    }

    public static final class k<T, R> implements Function<List<? extends ChannelEntity>, ObservableSource<? extends List<? extends Channel>>> {
        public final /* synthetic */ ChannelRepoImpl a;
        public final /* synthetic */ String b;

        public k(ChannelRepoImpl channelRepoImpl, String str) {
            this.a = channelRepoImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends List<? extends Channel>> apply(List<? extends ChannelEntity> list) {
            List<? extends ChannelEntity> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "channelEntities");
            if (!list2.isEmpty()) {
                ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getChannelId());
                }
                ChannelRepoImpl channelRepoImpl = this.a;
                Observable<R> map = channelRepoImpl.c.getUsersForChannels(this.b, arrayList).distinctUntilChanged().map(new ChannelRepoImpl$getUsersByChannelId$1(channelRepoImpl));
                Intrinsics.checkNotNullExpressionValue(map, "userDao.getUsersForChann…   usersMap\n            }");
                ChannelRepoImpl channelRepoImpl2 = this.a;
                Observable<R> map2 = channelRepoImpl2.e.getChannelsTags(this.b, arrayList).distinctUntilChanged().map(new ChannelRepoKt$sam$i$io_reactivex_functions_Function$0(new ChannelRepoImpl$getTagsByChannelId$1(channelRepoImpl2)));
                Intrinsics.checkNotNullExpressionValue(map2, "channelTagDao.getChannel…        .map(::toTagsMap)");
                Observable combineLatest = Observable.combineLatest(map, map2, new ChannelRepoImpl$getEmptyChannelsNewerThanTimestamp$1$$special$$inlined$observableCombineLatest$1(this, list2));
                Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…eFunction(t1, t2) }\n    )");
                return combineLatest;
            }
            Observable just = Observable.just(CollectionsKt__CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(emptyList())");
            return just;
        }
    }

    public static final class l<T, R> implements Function<List<? extends Long>, Option<? extends Long>> {
        public static final l a = new l();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends Long> apply(List<? extends Long> list) {
            List<? extends Long> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "timeStampRes");
            return ListKt.firstOption(list2);
        }
    }

    public static final class m<V> implements Callable<Object> {
        public final /* synthetic */ ChannelRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Channel c;

        public m(ChannelRepoImpl channelRepoImpl, String str, Channel channel) {
            this.a = channelRepoImpl;
            this.b = str;
            this.c = channel;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            ChannelDbEntities channelDbEntities = this.a.f.toChannelDbEntities(this.b, this.c);
            this.a.a.insertChannelWithUsersAndLastMessage(channelDbEntities.component1(), channelDbEntities.component2(), channelDbEntities.component3(), channelDbEntities.component4());
            return Unit.INSTANCE;
        }
    }

    public static final class n<V> implements Callable<Object> {
        public final /* synthetic */ ChannelRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ List c;

        public n(ChannelRepoImpl channelRepoImpl, String str, List list) {
            this.a = channelRepoImpl;
            this.b = str;
            this.c = list;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            ChannelsDbEntities channelsDbEntities = this.a.f.toChannelsDbEntities(this.b, this.c);
            this.a.a.insertChannelsWithUsersAndLastMessages(channelsDbEntities.getChannelEntities(), channelsDbEntities.getUserEntities(), channelsDbEntities.getChannelTags(), channelsDbEntities.getLastMessages());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ChannelRepoImpl(@NotNull ChannelDao channelDao, @NotNull DraftDao draftDao, @NotNull UserDao userDao, @NotNull MessageDao messageDao, @NotNull ChannelTagDao channelTagDao, @NotNull ChannelEntityConverter channelEntityConverter) {
        Intrinsics.checkNotNullParameter(channelDao, "channelDao");
        Intrinsics.checkNotNullParameter(draftDao, "draftDao");
        Intrinsics.checkNotNullParameter(userDao, "userDao");
        Intrinsics.checkNotNullParameter(messageDao, "messageDao");
        Intrinsics.checkNotNullParameter(channelTagDao, "channelTagDao");
        Intrinsics.checkNotNullParameter(channelEntityConverter, "channelEntityConverter");
        this.a = channelDao;
        this.b = draftDao;
        this.c = userDao;
        this.d = messageDao;
        this.e = channelTagDao;
        this.f = channelEntityConverter;
    }

    public static final List access$associateChannelsAndDraftsIntoListOfPairs(ChannelRepoImpl channelRepoImpl, List list, List list2) {
        Objects.requireNonNull(channelRepoImpl);
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(list2, 10)), 16));
        for (Object obj : list2) {
            linkedHashMap.put(((DraftEntity) obj).getChannelId(), obj);
        }
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Channel channel = (Channel) it.next();
            arrayList.add(TuplesKt.to(channel, linkedHashMap.get(channel.getChannelId())));
        }
        return arrayList;
    }

    public static final Observable access$getLastMessagesByChannelId(ChannelRepoImpl channelRepoImpl, String str, List list) {
        Objects.requireNonNull(channelRepoImpl);
        Observable<R> map = channelRepoImpl.d.getLastMesssagesForChannels(str, list).distinctUntilChanged().map(ChannelRepoImpl$getLastMessagesByChannelId$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "messageDao.getLastMesssa…:channelId)\n            }");
        return map;
    }

    public static final Observable access$getTagsByChannelId(ChannelRepoImpl channelRepoImpl, String str, List list) {
        Objects.requireNonNull(channelRepoImpl);
        Observable<R> map = channelRepoImpl.e.getChannelsTags(str, list).distinctUntilChanged().map(new ChannelRepoKt$sam$i$io_reactivex_functions_Function$0(new ChannelRepoImpl$getTagsByChannelId$1(channelRepoImpl)));
        Intrinsics.checkNotNullExpressionValue(map, "channelTagDao.getChannel…        .map(::toTagsMap)");
        return map;
    }

    public static final Observable access$getUsersByChannelId(ChannelRepoImpl channelRepoImpl, String str, Collection collection) {
        Objects.requireNonNull(channelRepoImpl);
        Observable<R> map = channelRepoImpl.c.getUsersForChannels(str, collection).distinctUntilChanged().map(new ChannelRepoImpl$getUsersByChannelId$1(channelRepoImpl));
        Intrinsics.checkNotNullExpressionValue(map, "userDao.getUsersForChann…   usersMap\n            }");
        return map;
    }

    public static final List access$toChannels(ChannelRepoImpl channelRepoImpl, List list, Map map, Map map2, Map map3) {
        Channel channel;
        Objects.requireNonNull(channelRepoImpl);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ChannelEntity channelEntity = (ChannelEntity) it.next();
            List<UserEntity> list2 = (List) map.get(channelEntity.getChannelId());
            if (list2 != null) {
                ChannelEntityConverter channelEntityConverter = channelRepoImpl.f;
                List list3 = (List) map2.get(channelEntity.getChannelId());
                if (list3 == null) {
                    list3 = CollectionsKt__CollectionsKt.emptyList();
                }
                channel = channelEntityConverter.toChannel(channelEntity, list2, list3, (MessageEntity) map3.get(channelEntity.getChannelId()));
            } else {
                channel = null;
            }
            if (channel != null) {
                arrayList.add(channel);
            }
        }
        return arrayList;
    }

    public static final Observable access$toListOfChannelsAndDraftsObservable(ChannelRepoImpl channelRepoImpl, List list, String str) {
        Objects.requireNonNull(channelRepoImpl);
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ChannelEntity) it.next()).getChannelId());
        }
        Observable<R> map = channelRepoImpl.c.getUsersForChannels(str, arrayList).distinctUntilChanged().map(new ChannelRepoImpl$getUsersByChannelId$1(channelRepoImpl));
        Intrinsics.checkNotNullExpressionValue(map, "userDao.getUsersForChann…   usersMap\n            }");
        Observable<R> map2 = channelRepoImpl.e.getChannelsTags(str, arrayList).distinctUntilChanged().map(new ChannelRepoKt$sam$i$io_reactivex_functions_Function$0(new ChannelRepoImpl$getTagsByChannelId$1(channelRepoImpl)));
        Intrinsics.checkNotNullExpressionValue(map2, "channelTagDao.getChannel…        .map(::toTagsMap)");
        Observable<R> map3 = channelRepoImpl.d.getLastMesssagesForChannels(str, arrayList).distinctUntilChanged().map(ChannelRepoImpl$getLastMessagesByChannelId$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map3, "messageDao.getLastMesssa…:channelId)\n            }");
        Observable combineLatest = Observable.combineLatest(map, map2, map3, new Function3<T1, T2, T3, R>(list) { // from class: com.avito.android.messenger.channels.mvi.data.ChannelRepoImpl$toListOfChannelsObservable$$inlined$observableCombineLatest$1
            public final /* synthetic */ List b;

            {
                this.b = r2;
            }

            @Override // io.reactivex.functions.Function3
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3) {
                Channel channel;
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                Intrinsics.checkNotNullParameter(t3, "t3");
                T3 t32 = t3;
                T2 t22 = t2;
                T1 t12 = t1;
                ChannelRepoImpl channelRepoImpl2 = ChannelRepoImpl.this;
                List<ChannelEntity> list2 = this.b;
                R r = (R) new ArrayList();
                for (ChannelEntity channelEntity : list2) {
                    List<UserEntity> list3 = (List) t12.get(channelEntity.getChannelId());
                    if (list3 != null) {
                        ChannelEntityConverter channelEntityConverter = channelRepoImpl2.f;
                        List list4 = (List) t22.get(channelEntity.getChannelId());
                        if (list4 == null) {
                            list4 = CollectionsKt__CollectionsKt.emptyList();
                        }
                        channel = channelEntityConverter.toChannel(channelEntity, list3, list4, (MessageEntity) t32.get(channelEntity.getChannelId()));
                    } else {
                        channel = null;
                    }
                    if (channel != null) {
                        r.add(channel);
                    }
                }
                return r;
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ction(t1, t2, t3) }\n    )");
        DraftDao draftDao = channelRepoImpl.b;
        ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((ChannelEntity) it2.next()).getChannelId());
        }
        Observable<List<DraftEntity>> distinctUntilChanged = draftDao.getDraftsForChannelIds(str, arrayList2).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "draftDao.getDraftsForCha…  .distinctUntilChanged()");
        Observable combineLatest2 = Observable.combineLatest(combineLatest, distinctUntilChanged, new BiFunction<T1, T2, R>() { // from class: com.avito.android.messenger.channels.mvi.data.ChannelRepoImpl$toListOfChannelsAndDraftsObservable$$inlined$combineLatestWith$1
            @Override // io.reactivex.functions.BiFunction
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                T2 t22 = t2;
                T1<Channel> t12 = t1;
                LinkedHashMap linkedHashMap = new LinkedHashMap(e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(t22, 10)), 16));
                for (Object obj : t22) {
                    linkedHashMap.put(((DraftEntity) obj).getChannelId(), obj);
                }
                R r = (R) new ArrayList(t6.n.e.collectionSizeOrDefault(t12, 10));
                for (Channel channel : t12) {
                    r.add(TuplesKt.to(channel, linkedHashMap.get(channel.getChannelId())));
                }
                return r;
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest2, "Observable.combineLatest…ombineFunction(t1, t2) })");
        return combineLatest2;
    }

    public static final Observable access$toListOfChannelsObservable(ChannelRepoImpl channelRepoImpl, List list, String str) {
        Objects.requireNonNull(channelRepoImpl);
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ChannelEntity) it.next()).getChannelId());
        }
        Observable<R> map = channelRepoImpl.c.getUsersForChannels(str, arrayList).distinctUntilChanged().map(new ChannelRepoImpl$getUsersByChannelId$1(channelRepoImpl));
        Intrinsics.checkNotNullExpressionValue(map, "userDao.getUsersForChann…   usersMap\n            }");
        Observable<R> map2 = channelRepoImpl.e.getChannelsTags(str, arrayList).distinctUntilChanged().map(new ChannelRepoKt$sam$i$io_reactivex_functions_Function$0(new ChannelRepoImpl$getTagsByChannelId$1(channelRepoImpl)));
        Intrinsics.checkNotNullExpressionValue(map2, "channelTagDao.getChannel…        .map(::toTagsMap)");
        Observable<R> map3 = channelRepoImpl.d.getLastMesssagesForChannels(str, arrayList).distinctUntilChanged().map(ChannelRepoImpl$getLastMessagesByChannelId$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map3, "messageDao.getLastMesssa…:channelId)\n            }");
        Observable combineLatest = Observable.combineLatest(map, map2, map3, new Function3<T1, T2, T3, R>(list) { // from class: com.avito.android.messenger.channels.mvi.data.ChannelRepoImpl$toListOfChannelsObservable$$inlined$observableCombineLatest$2
            public final /* synthetic */ List b;

            {
                this.b = r2;
            }

            @Override // io.reactivex.functions.Function3
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3) {
                Channel channel;
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                Intrinsics.checkNotNullParameter(t3, "t3");
                T3 t32 = t3;
                T2 t22 = t2;
                T1 t12 = t1;
                ChannelRepoImpl channelRepoImpl2 = ChannelRepoImpl.this;
                List<ChannelEntity> list2 = this.b;
                R r = (R) new ArrayList();
                for (ChannelEntity channelEntity : list2) {
                    List<UserEntity> list3 = (List) t12.get(channelEntity.getChannelId());
                    if (list3 != null) {
                        ChannelEntityConverter channelEntityConverter = channelRepoImpl2.f;
                        List list4 = (List) t22.get(channelEntity.getChannelId());
                        if (list4 == null) {
                            list4 = CollectionsKt__CollectionsKt.emptyList();
                        }
                        channel = channelEntityConverter.toChannel(channelEntity, list3, list4, (MessageEntity) t32.get(channelEntity.getChannelId()));
                    } else {
                        channel = null;
                    }
                    if (channel != null) {
                        r.add(channel);
                    }
                }
                return r;
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ction(t1, t2, t3) }\n    )");
        return combineLatest;
    }

    public static final Observable access$toListOfDraftsObservable(ChannelRepoImpl channelRepoImpl, List list, String str) {
        Objects.requireNonNull(channelRepoImpl);
        DraftDao draftDao = channelRepoImpl.b;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ChannelEntity) it.next()).getChannelId());
        }
        Observable<List<DraftEntity>> distinctUntilChanged = draftDao.getDraftsForChannelIds(str, arrayList).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "draftDao.getDraftsForCha…  .distinctUntilChanged()");
        return distinctUntilChanged;
    }

    public static final Map access$toTagsMap(ChannelRepoImpl channelRepoImpl, List list) {
        Objects.requireNonNull(channelRepoImpl);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ChannelTag channelTag = (ChannelTag) it.next();
            List list2 = (List) linkedHashMap.get(channelTag.getChannelId());
            if (list2 != null) {
                list2.add(channelTag);
            } else {
                linkedHashMap.put(channelTag.getChannelId(), CollectionsKt__CollectionsKt.mutableListOf(channelTag));
            }
        }
        return linkedHashMap;
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter
    @NotNull
    public Completable deleteChannel(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Completable fromCallable = Completable.fromCallable(new a(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…d\n            )\n        }");
        return log(fromCallable, a2.b.a.a.a.e("deleteChannel(userId = ", str, ", channelId = ", str2, ')'));
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter
    @NotNull
    public Completable deleteChannelContextActions(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return log(this.a.deleteChannelContextActions(str, str2), a2.b.a.a.a.e("deleteChannelContextActions(userId = ", str, ", channelId = ", str2, ')'));
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter
    @NotNull
    public Completable deleteChannelTags(@NotNull Collection<ChannelTag> collection) {
        Intrinsics.checkNotNullParameter(collection, "channelTags");
        Completable deleteChannelTags = this.e.deleteChannelTags(collection);
        return log(deleteChannelTags, "deleteChannelTags(channelTags = " + collection + ')');
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter
    @NotNull
    public Completable deleteChannelsById(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(list, "channelIds");
        Completable fromCallable = Completable.fromCallable(new c(this, str, list));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…s\n            )\n        }");
        StringBuilder R = a2.b.a.a.a.R("deleteChannelsById(userId = ", str, ", channelIds = (");
        R.append(list.size());
        R.append(")[...]");
        return log(fromCallable, R.toString());
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter
    @NotNull
    public Completable deleteNonEmptyChannelsNewerThatTimestamp(@NotNull String str, long j2, @NotNull Collection<String> collection, @NotNull Collection<String> collection2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(collection, "tags");
        Intrinsics.checkNotNullParameter(collection2, "excludeTags");
        Completable fromCallable = Completable.fromCallable(new d(this, str, j2, collection, collection2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…s\n            )\n        }");
        return log(fromCallable, "deleteNonEmptyChannelsNewerThatTimestamp(userId = " + str + ", timestamp = " + j2 + ", tags = " + collection + ", excludeTags = " + collection2 + ')');
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter
    @NotNull
    public Completable deleteNonEmptyChannelsOlderThanTimestamp(@NotNull String str, long j2, @NotNull Collection<String> collection, @NotNull Collection<String> collection2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(collection, "tags");
        Intrinsics.checkNotNullParameter(collection2, "excludeTags");
        Completable fromCallable = Completable.fromCallable(new e(this, str, j2, collection, collection2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…s\n            )\n        }");
        return log(fromCallable, "deleteNonEmptyChannelsOlderThanTimestamp(userId = " + str + ", timestamp = " + j2 + ", tags = " + collection + ", excludeTags = " + collection2 + ')');
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoReader
    @NotNull
    public Observable<List<Channel>> getAllChannels(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Observable<R> switchMap = this.a.getAllChannels(str).distinctUntilChanged().switchMap(new f(this, str));
        Intrinsics.checkNotNullExpressionValue(switchMap, "channelDao.getAllChannel…          }\n            }");
        return log(switchMap, "getAllChannels(userId = " + str + ')');
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoReader
    @NotNull
    public Observable<Option<String>> getAvitoChannelId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Observable<R> map = this.a.getAvitoChannelId(str).distinctUntilChanged().map(g.a);
        Intrinsics.checkNotNullExpressionValue(map, "channelDao.getAvitoChann…rstOption()\n            }");
        return log(map, "getAvitoChannelId(userId = " + str + ')');
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoReader
    @NotNull
    public Observable<List<Channel>> getBareChannels(@NotNull String str, @NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(collection, "channelIds");
        Observable<List<ChannelEntity>> distinctUntilChanged = this.a.getChannels(str, collection).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "channelDao.getChannels(u…  .distinctUntilChanged()");
        Observable<List<ChannelTag>> distinctUntilChanged2 = this.e.getChannelsTags(str, collection).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged2, "channelTagDao.getChannel…  .distinctUntilChanged()");
        Observable<R> map = this.c.getUsersForChannels(str, collection).distinctUntilChanged().map(new ChannelRepoImpl$getUsersByChannelId$1(this));
        Intrinsics.checkNotNullExpressionValue(map, "userDao.getUsersForChann…   usersMap\n            }");
        Observable combineLatest = Observable.combineLatest(distinctUntilChanged, distinctUntilChanged2, map, ChannelRepoImpl$getBareChannels$$inlined$observableCombineLatest$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…riple(t1, t2, t3) }\n    )");
        Observable map2 = combineLatest.map(new h(this));
        Intrinsics.checkNotNullExpressionValue(map2, "observableCombineLatest(…          )\n            }");
        StringBuilder R = a2.b.a.a.a.R("getBareChannels(userId = ", str, ", channelIds = (");
        R.append(collection.size());
        R.append(")[...])");
        return log(map2, R.toString());
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoReader
    @NotNull
    public Observable<Option<Channel>> getChannel(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Observable<List<ChannelEntity>> distinctUntilChanged = this.a.getChannel(str, str2).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "channelDao.getChannel(\n …  .distinctUntilChanged()");
        Observable<List<UserEntity>> distinctUntilChanged2 = this.c.getUsersForChannel(str, str2).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged2, "userDao.getUsersForChann…  .distinctUntilChanged()");
        Observable<List<ChannelTag>> distinctUntilChanged3 = this.e.getChannelTags(str, str2).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged3, "channelTagDao.getChannel…  .distinctUntilChanged()");
        Observable<List<MessageEntity>> distinctUntilChanged4 = this.d.getLastMessageForChannel(str, str2).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged4, "messageDao.getLastMessag…  .distinctUntilChanged()");
        Observable combineLatest = Observable.combineLatest(distinctUntilChanged, distinctUntilChanged2, distinctUntilChanged3, distinctUntilChanged4, new Function4<T1, T2, T3, T4, R>(this) { // from class: com.avito.android.messenger.channels.mvi.data.ChannelRepoImpl$getChannel$$inlined$observableCombineLatest$1
            public final /* synthetic */ ChannelRepoImpl a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Function4
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3, @NotNull T4 t4) {
                Intrinsics.checkNotNullParameter(t1, "t1");
                Intrinsics.checkNotNullParameter(t2, "t2");
                Intrinsics.checkNotNullParameter(t3, "t3");
                Intrinsics.checkNotNullParameter(t4, "t4");
                T4 t42 = t4;
                T3 t32 = t3;
                T2 t22 = t2;
                ChannelEntity channelEntity = (ChannelEntity) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) t1);
                if (channelEntity != null) {
                    R r = t22.isEmpty() ^ true ? (R) OptionKt.some(this.a.f.toChannel(channelEntity, t22, t32, (MessageEntity) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) t42))) : (R) Option.Companion.empty();
                    if (r != null) {
                        return r;
                    }
                }
                return (R) Option.Companion.empty();
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…n(t1, t2, t3, t4) }\n    )");
        return log(combineLatest, a2.b.a.a.a.e("getChannel(userId = ", str, ", channelId = ", str2, ')'));
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoReader
    @NotNull
    public Observable<Option<String>> getChannelIdByItemId(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "itemId");
        Observable<R> map = this.a.getChannelIdByItemId(str, str2).distinctUntilChanged().map(i.a);
        Intrinsics.checkNotNullExpressionValue(map, "channelDao.getChannelIdB…rstOption()\n            }");
        return log(map, "getChannelIdByItemId(userId = " + str + ", itemId = " + str2 + ')');
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoReader
    @NotNull
    public Observable<List<Pair<Channel, DraftEntity>>> getChannelsAndDraftsStartingFromTimestamp(@NotNull String str, long j2, @NotNull Collection<String> collection, @NotNull Collection<String> collection2) {
        Observable<List<ChannelEntity>> observable;
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(collection, "tags");
        Intrinsics.checkNotNullParameter(collection2, "excludeTags");
        if (!collection.isEmpty()) {
            observable = this.a.getChannelsStartingFromTimestamp(str, j2, collection, collection2);
        } else if (!collection2.isEmpty()) {
            observable = this.a.getChannelsStartingFromTimestamp(str, j2, collection2);
        } else {
            observable = this.a.getChannelsStartingFromTimestamp(str, j2);
        }
        Observable switchMap = observable.distinctUntilChanged().switchMap(new j(this, str));
        Intrinsics.checkNotNullExpressionValue(switchMap, "when {\n            tags.…          }\n            }");
        StringBuilder T = a2.b.a.a.a.T("getChannelsAndDraftsStartingFromTimestamp(userId = ", str, ", timestamp = ", j2);
        T.append(", tags = ");
        T.append(collection);
        T.append(", excludeTags = ");
        T.append(collection2);
        T.append(')');
        return log(switchMap, T.toString());
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoReader
    @NotNull
    public Observable<List<Channel>> getEmptyChannelsNewerThanTimestamp(@NotNull String str, long j2, @NotNull Collection<String> collection, @NotNull Collection<String> collection2) {
        Observable<List<ChannelEntity>> observable;
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(collection, "tags");
        Intrinsics.checkNotNullParameter(collection2, "excludeTags");
        if (!collection.isEmpty()) {
            observable = this.a.getEmptyChannelsNewerThanTimestamp(str, j2, collection, collection2);
        } else if (!collection2.isEmpty()) {
            observable = this.a.getEmptyChannelsNewerThanTimestamp(str, j2, collection2);
        } else {
            observable = this.a.getEmptyChannelsNewerThanTimestamp(str, j2);
        }
        Observable flatMap = observable.distinctUntilChanged().flatMap(new k(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "when {\n            tags.…          }\n            }");
        StringBuilder T = a2.b.a.a.a.T("getEmptyChannelsNewerThanTimestamp(userId = ", str, ", timestamp = ", j2);
        T.append(", tags = ");
        T.append(collection);
        T.append(", excludeTags = ");
        T.append(collection2);
        T.append(')');
        return log(flatMap, T.toString());
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoReader
    @NotNull
    public Observable<List<String>> getIdsOfEmptyChannelsOlderThanTimestamp(@NotNull String str, long j2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Observable<List<String>> distinctUntilChanged = this.a.getIdsOfEmptyChannelsOlderThanTimestamp(str, j2).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "channelDao.getIdsOfEmpty…  .distinctUntilChanged()");
        StringBuilder T = a2.b.a.a.a.T("getIdsOfEmptyChannelsOlderThanTimestamp(userId = ", str, ", timestamp = ", j2);
        T.append(')');
        return log(distinctUntilChanged, T.toString());
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoReader
    @NotNull
    public Observable<List<String>> getNonEmptyChannelIds(@NotNull String str, int i2, int i3, @NotNull Collection<String> collection, @NotNull Collection<String> collection2) {
        Observable<List<String>> observable;
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(collection, "tags");
        Intrinsics.checkNotNullParameter(collection2, "excludeTags");
        if (!collection.isEmpty()) {
            observable = this.a.getNonEmptyChannelIds(str, i2, i3, collection, collection2);
        } else if (!collection2.isEmpty()) {
            observable = this.a.getNonEmptyChannelIds(str, i2, i3, collection2);
        } else {
            observable = this.a.getNonEmptyChannelIds(str, i2, i3);
        }
        Observable<List<String>> distinctUntilChanged = observable.distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "when {\n            tags.…  .distinctUntilChanged()");
        return log(distinctUntilChanged, "getNonEmptyChannelIds(userId = " + str + ", offset = " + i2 + ", limit = " + i3 + ", tags = " + collection + ", excludeTags = " + collection2 + ')');
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoReader
    @NotNull
    public Observable<Option<Long>> getTimestampOfNonEmptyChannelAtPosition(@NotNull String str, int i2, @NotNull Collection<String> collection, @NotNull Collection<String> collection2) {
        Observable<List<Long>> observable;
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(collection, "tags");
        Intrinsics.checkNotNullParameter(collection2, "excludeTags");
        if (!collection.isEmpty()) {
            observable = this.a.getTimestampOfNonEmptyChannelAtPosition(str, i2, collection, collection2);
        } else if (!collection2.isEmpty()) {
            observable = this.a.getTimestampOfNonEmptyChannelAtPosition(str, i2, collection2);
        } else {
            observable = this.a.getTimestampOfNonEmptyChannelAtPosition(str, i2);
        }
        Observable map = observable.distinctUntilChanged().map(l.a);
        Intrinsics.checkNotNullExpressionValue(map, "when {\n            tags.…rstOption()\n            }");
        return log(map, "getTimestampOfNonEmptyChannelAtPosition(userId = " + str + ", position = " + i2 + ", tags = " + collection + ", excludeTags = " + collection2 + ')');
    }

    @Override // com.avito.android.util.RxLogger
    @NotNull
    public Completable log(@NotNull Completable completable, @NotNull String str) {
        Intrinsics.checkNotNullParameter(completable, "$this$log");
        Intrinsics.checkNotNullParameter(str, "message");
        return this.g.log(completable, str);
    }

    @Override // com.avito.android.util.RxLogger
    @NotNull
    public <T> Observable<T> log(@NotNull Observable<T> observable, @NotNull String str) {
        Intrinsics.checkNotNullParameter(observable, "$this$log");
        Intrinsics.checkNotNullParameter(str, "message");
        return this.g.log(observable, str);
    }

    @Override // com.avito.android.util.RxLogger
    @NotNull
    public <T> Single<T> log(@NotNull Single<T> single, @NotNull String str) {
        Intrinsics.checkNotNullParameter(single, "$this$log");
        Intrinsics.checkNotNullParameter(str, "message");
        return this.g.log(single, str);
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter
    @NotNull
    public Completable putChannel(@NotNull String str, @NotNull Channel channel) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(channel, "channel");
        Completable fromCallable = Completable.fromCallable(new m(this, str, channel));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…              }\n        }");
        StringBuilder R = a2.b.a.a.a.R("putChannel(userId = ", str, ", channel = ");
        R.append(channel.getChannelId());
        R.append(')');
        return log(fromCallable, R.toString());
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter
    @NotNull
    public Completable putChannels(@NotNull String str, @NotNull List<Channel> list) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS);
        Completable fromCallable = Completable.fromCallable(new n(this, str, list));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…              }\n        }");
        StringBuilder R = a2.b.a.a.a.R("putChannel(userId = ", str, ", channels = (");
        R.append(list.size());
        R.append(")[...])");
        return log(fromCallable, R.toString());
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter
    @NotNull
    public Completable setChannelIsRead(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return log(this.a.setChannelIsRead(str, str2), a2.b.a.a.a.e("setChannelIsRead(userId = ", str, ", channelId = ", str2, ')'));
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoWriter
    @NotNull
    public Completable deleteChannel(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "interlocutorId");
        Intrinsics.checkNotNullParameter(str3, "itemId");
        Completable fromCallable = Completable.fromCallable(new b(this, str, str2, str3));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…d\n            )\n        }");
        StringBuilder W = a2.b.a.a.a.W("deleteChannel(userId = ", str, ", interlocutorId = ", str2, ", itemId = ");
        W.append(str3);
        W.append(')');
        return log(fromCallable, W.toString());
    }

    @Override // com.avito.android.messenger.channels.mvi.data.ChannelRepoReader
    @NotNull
    public Observable<List<String>> getNonEmptyChannelIds(@NotNull String str, long j2, long j3, @NotNull Collection<String> collection, @NotNull Collection<String> collection2) {
        Observable<List<String>> observable;
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(collection, "tags");
        Intrinsics.checkNotNullParameter(collection2, "excludeTags");
        if (!collection.isEmpty()) {
            observable = this.a.getNonEmptyChannelIds(str, j2, j3, collection, collection2);
        } else if (!collection2.isEmpty()) {
            observable = this.a.getNonEmptyChannelIds(str, j2, j3, collection2);
        } else {
            observable = this.a.getNonEmptyChannelIds(str, j2, j3);
        }
        Observable<List<String>> distinctUntilChanged = observable.distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "when {\n            tags.…  .distinctUntilChanged()");
        StringBuilder sb = new StringBuilder();
        sb.append("getNonEmptyChannelIds(userId = ");
        sb.append(str);
        sb.append(", olderOrEqualToTimestamp = ");
        sb.append(j2);
        a2.b.a.a.a.l1(sb, ", newerOrEqualToTimestamp = ", j3, ", tags = ");
        sb.append(collection);
        sb.append(", excludeTags = ");
        sb.append(collection2);
        sb.append(')');
        return log(distinctUntilChanged, sb.toString());
    }
}
