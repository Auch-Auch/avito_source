package com.avito.android.messenger.conversation.mvi.sync;

import a2.a.a.o1.d.a0.n.b0;
import a2.a.a.o1.d.a0.n.m0;
import a2.a.a.o1.d.a0.n.n0;
import a2.a.a.o1.d.a0.n.o0;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.channels.mvi.common.v4.ActionSingle;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker;
import com.avito.android.messenger.channels.mvi.data.UserRepo;
import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u000510234B?\b\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R:\u0010\u001b\u001a&\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u0017 \u0018*\u0012\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u0017\u0018\u00010\u00160\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u00065"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgentImpl;", "Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent$State;", "", ChannelContext.Item.USER_ID, "channelId", "", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "messages", "", "syncMissingUsers", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "r", "Lru/avito/messenger/MessengerClient;", "client", "Lcom/avito/android/Features;", VKApiConst.VERSION, "Lcom/avito/android/Features;", "features", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgentImpl$RequestMissingUsers;", "kotlin.jvm.PlatformType", "p", "Lcom/jakewharton/rxrelay2/PublishRelay;", "missingUsersRequestRelay", "Lcom/avito/android/messenger/MessengerEntityConverter;", "s", "Lcom/avito/android/messenger/MessengerEntityConverter;", "messengerEntityConverter", "Lio/reactivex/disposables/CompositeDisposable;", VKApiConst.Q, "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lcom/avito/android/account/AccountStateProvider;", "u", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/messenger/channels/mvi/data/UserRepo;", "t", "Lcom/avito/android/messenger/channels/mvi/data/UserRepo;", "userRepo", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/MessengerEntityConverter;Lcom/avito/android/messenger/channels/mvi/data/UserRepo;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory;)V", "Companion", AuthSource.SEND_ABUSE, "RequestMissingUsers", "RequestMissingUsersAction", "ThrottleState", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MissingUsersSyncAgentImpl extends BaseMviEntityWithReducerQueue<MissingUsersSyncAgent.State> implements MissingUsersSyncAgent {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final PublishRelay<RequestMissingUsers> p = PublishRelay.create();
    public final CompositeDisposable q;
    public final MessengerClient<AvitoMessengerApi> r;
    public final MessengerEntityConverter s;
    public final UserRepo t;
    public final AccountStateProvider u;
    public final Features v;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgentImpl$Companion;", "", "", "REQUEST_THROTTLE_MS", "J", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\t¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgentImpl$RequestMissingUsers;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "component3", "()Ljava/util/List;", ChannelContext.Item.USER_ID, "channelId", "messages", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgentImpl$RequestMissingUsers;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getChannelId", AuthSource.SEND_ABUSE, "getUserId", "c", "Ljava/util/List;", "getMessages", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class RequestMissingUsers {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @NotNull
        public final List<LocalMessage> c;

        public RequestMissingUsers(@NotNull String str, @NotNull String str2, @NotNull List<LocalMessage> list) {
            a2.b.a.a.a.c1(str, ChannelContext.Item.USER_ID, str2, "channelId", list, "messages");
            this.a = str;
            this.b = str2;
            this.c = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl$RequestMissingUsers */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RequestMissingUsers copy$default(RequestMissingUsers requestMissingUsers, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = requestMissingUsers.a;
            }
            if ((i & 2) != 0) {
                str2 = requestMissingUsers.b;
            }
            if ((i & 4) != 0) {
                list = requestMissingUsers.c;
            }
            return requestMissingUsers.copy(str, str2, list);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final List<LocalMessage> component3() {
            return this.c;
        }

        @NotNull
        public final RequestMissingUsers copy(@NotNull String str, @NotNull String str2, @NotNull List<LocalMessage> list) {
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str2, "channelId");
            Intrinsics.checkNotNullParameter(list, "messages");
            return new RequestMissingUsers(str, str2, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestMissingUsers)) {
                return false;
            }
            RequestMissingUsers requestMissingUsers = (RequestMissingUsers) obj;
            return Intrinsics.areEqual(this.a, requestMissingUsers.a) && Intrinsics.areEqual(this.b, requestMissingUsers.b) && Intrinsics.areEqual(this.c, requestMissingUsers.c);
        }

        @NotNull
        public final String getChannelId() {
            return this.b;
        }

        @NotNull
        public final List<LocalMessage> getMessages() {
            return this.c;
        }

        @NotNull
        public final String getUserId() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            List<LocalMessage> list = this.c;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("RequestMissingUsers(userId=");
            L.append(this.a);
            L.append(", channelId=");
            L.append(this.b);
            L.append(", messages=");
            return a2.b.a.a.a.w(L, this.c, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u000b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0015\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgentImpl$RequestMissingUsersAction;", "Lcom/avito/android/messenger/channels/mvi/common/v4/ActionSingle;", "Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent$State;", "curState", "Lio/reactivex/Single;", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent$State;)Lio/reactivex/Single;", "", "d", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", ChannelContext.Item.USER_ID, "", "f", "Ljava/util/Set;", "getInterlocutorIds", "()Ljava/util/Set;", "interlocutorIds", "e", "getChannelId", "channelId", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgentImpl;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class RequestMissingUsersAction extends ActionSingle<MissingUsersSyncAgent.State> {
        @NotNull
        public final String d;
        @NotNull
        public final String e;
        @NotNull
        public final Set<String> f;
        public final /* synthetic */ MissingUsersSyncAgentImpl g;

        public static final class a<T, R> implements Function<Set<? extends String>, CompletableSource> {
            public final /* synthetic */ RequestMissingUsersAction a;

            public a(RequestMissingUsersAction requestMissingUsersAction) {
                this.a = requestMissingUsersAction;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public CompletableSource apply(Set<? extends String> set) {
                Set<? extends String> set2 = set;
                Intrinsics.checkNotNullParameter(set2, "missedUsers");
                String tag = this.a.g.getTAG();
                Logs.debug$default(tag, "users that are missed in our db  = " + set2, null, 4, null);
                if (!(!set2.isEmpty())) {
                    return Completable.complete();
                }
                Logs.debug$default(this.a.g.getTAG(), "Requesting missing users...", null, 4, null);
                return this.a.g.r.getUsers(this.a.getChannelId(), CollectionsKt___CollectionsKt.toList(set2)).flatMapCompletable(new b0(this));
            }
        }

        public static final class b<T> implements Consumer<Throwable> {
            public final /* synthetic */ RequestMissingUsersAction a;

            public b(RequestMissingUsersAction requestMissingUsersAction) {
                this.a = requestMissingUsersAction;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Logs.debug(this.a.g.getTAG(), "Something has broken during RequestMissingUsersAction", th);
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public RequestMissingUsersAction(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl r3, @org.jetbrains.annotations.NotNull java.lang.String r4, @org.jetbrains.annotations.NotNull java.lang.String r5, java.util.Set<java.lang.String> r6) {
            /*
                r2 = this;
                java.lang.String r0 = "userId"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "channelId"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "interlocutorIds"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                r2.g = r3
                java.lang.String r3 = "userId = "
                java.lang.String r0 = " channelId = "
                java.lang.String r1 = " messages="
                java.lang.StringBuilder r3 = a2.b.a.a.a.W(r3, r4, r0, r5, r1)
                r3.append(r6)
                java.lang.String r3 = r3.toString()
                java.lang.String r0 = "RequestMissingUsersAction"
                r2.<init>(r0, r3)
                r2.d = r4
                r2.e = r5
                r2.f = r6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl.RequestMissingUsersAction.<init>(com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl, java.lang.String, java.lang.String, java.util.Set):void");
        }

        @NotNull
        public final String getChannelId() {
            return this.e;
        }

        @NotNull
        public final Set<String> getInterlocutorIds() {
            return this.f;
        }

        @NotNull
        public final String getUserId() {
            return this.d;
        }

        @NotNull
        public Single<?> invoke(@NotNull MissingUsersSyncAgent.State state) {
            Intrinsics.checkNotNullParameter(state, "curState");
            String tag = this.g.getTAG();
            StringBuilder L = a2.b.a.a.a.L("users to check avatars for = ");
            L.append(this.f);
            Logs.debug$default(tag, L.toString(), null, 4, null);
            Single<?> singleDefault = this.g.t.getNotExistedUsersFromGivenIds(this.d, this.e, this.f).flatMapCompletable(new a(this)).doOnError(new b(this)).onErrorComplete().toSingleDefault(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(singleDefault, "userRepo.getNotExistedUs…   .toSingleDefault(Unit)");
            return singleDefault;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ:\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\b¨\u0006\""}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgentImpl$ThrottleState;", "", "", "component1", "()J", "", "", "component2", "()Ljava/util/Set;", "component3", "timestamp", "alreadyRequestedIds", "idsToRequest", "copy", "(JLjava/util/Set;Ljava/util/Set;)Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgentImpl$ThrottleState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/Set;", "getAlreadyRequestedIds", AuthSource.SEND_ABUSE, "J", "getTimestamp", "c", "getIdsToRequest", "<init>", "(JLjava/util/Set;Ljava/util/Set;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ThrottleState {
        public final long a;
        @NotNull
        public final Set<String> b;
        @NotNull
        public final Set<String> c;

        public ThrottleState(long j, @NotNull Set<String> set, @NotNull Set<String> set2) {
            Intrinsics.checkNotNullParameter(set, "alreadyRequestedIds");
            Intrinsics.checkNotNullParameter(set2, "idsToRequest");
            this.a = j;
            this.b = set;
            this.c = set2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl$ThrottleState */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ThrottleState copy$default(ThrottleState throttleState, long j, Set set, Set set2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = throttleState.a;
            }
            if ((i & 2) != 0) {
                set = throttleState.b;
            }
            if ((i & 4) != 0) {
                set2 = throttleState.c;
            }
            return throttleState.copy(j, set, set2);
        }

        public final long component1() {
            return this.a;
        }

        @NotNull
        public final Set<String> component2() {
            return this.b;
        }

        @NotNull
        public final Set<String> component3() {
            return this.c;
        }

        @NotNull
        public final ThrottleState copy(long j, @NotNull Set<String> set, @NotNull Set<String> set2) {
            Intrinsics.checkNotNullParameter(set, "alreadyRequestedIds");
            Intrinsics.checkNotNullParameter(set2, "idsToRequest");
            return new ThrottleState(j, set, set2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ThrottleState)) {
                return false;
            }
            ThrottleState throttleState = (ThrottleState) obj;
            return this.a == throttleState.a && Intrinsics.areEqual(this.b, throttleState.b) && Intrinsics.areEqual(this.c, throttleState.c);
        }

        @NotNull
        public final Set<String> getAlreadyRequestedIds() {
            return this.b;
        }

        @NotNull
        public final Set<String> getIdsToRequest() {
            return this.c;
        }

        public final long getTimestamp() {
            return this.a;
        }

        public int hashCode() {
            int a3 = c.a(this.a) * 31;
            Set<String> set = this.b;
            int i = 0;
            int hashCode = (a3 + (set != null ? set.hashCode() : 0)) * 31;
            Set<String> set2 = this.c;
            if (set2 != null) {
                i = set2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ThrottleState(timestamp=");
            L.append(this.a);
            L.append(", alreadyRequestedIds=");
            L.append(this.b);
            L.append(", idsToRequest=");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }
    }

    public static final class a implements ShouldCancelChecker<MissingUsersSyncAgent.State> {
        @NotNull
        public static final a a = new a();

        @Override // com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker
        public boolean aShouldCancelB(@NotNull Reducible<MissingUsersSyncAgent.State> reducible, @NotNull Reducible<MissingUsersSyncAgent.State> reducible2) {
            Intrinsics.checkNotNullParameter(reducible, AuthSource.SEND_ABUSE);
            Intrinsics.checkNotNullParameter(reducible2, AuthSource.BOOKING_ORDER);
            if (!(reducible instanceof RequestMissingUsersAction) || !(reducible2 instanceof RequestMissingUsersAction)) {
                return false;
            }
            return !Intrinsics.areEqual(((RequestMissingUsersAction) reducible).getUserId(), ((RequestMissingUsersAction) reducible2).getUserId());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public MissingUsersSyncAgentImpl(@NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull UserRepo userRepo, @NotNull AccountStateProvider accountStateProvider, @NotNull Features features, @NotNull SchedulersFactory schedulersFactory) {
        super("MissingUsersSyncAgent", MissingUsersSyncAgent.State.INSTANCE, schedulersFactory, a.a, null, null, null, null, 240, null);
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "messengerEntityConverter");
        Intrinsics.checkNotNullParameter(userRepo, "userRepo");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.r = messengerClient;
        this.s = messengerEntityConverter;
        this.t = userRepo;
        this.u = accountStateProvider;
        this.v = features;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.q = compositeDisposable;
        if (features.getRequestMissingUsersForAvatars().invoke().booleanValue()) {
            compositeDisposable.clear();
            Disposable subscribe = InteropKt.toV2(accountStateProvider.userId()).observeOn(getSchedulers().io()).switchMap(new m0(this)).subscribe(new n0(this), new o0(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "accountStateProvider.use…uests\", t)\n            })");
            DisposableKt.addTo(subscribe, compositeDisposable);
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgent
    public void syncMissingUsers(@NotNull String str, @NotNull String str2, @NotNull List<LocalMessage> list) {
        a2.b.a.a.a.c1(str, ChannelContext.Item.USER_ID, str2, "channelId", list, "messages");
        if (this.v.getRequestMissingUsersForAvatars().invoke().booleanValue()) {
            this.p.accept(new RequestMissingUsers(str, str2, list));
        }
    }
}
