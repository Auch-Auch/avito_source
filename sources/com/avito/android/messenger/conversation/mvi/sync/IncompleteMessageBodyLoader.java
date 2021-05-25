package com.avito.android.messenger.conversation.mvi.sync;

import arrow.core.Option;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import io.reactivex.Completable;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/IncompleteMessageBodyLoader;", "", "", ChannelContext.Item.USER_ID, "channelId", "localId", "Lio/reactivex/Completable;", "loadIncompleteMessageBodies", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "messageRepo", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;", "bodyResolver", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class IncompleteMessageBodyLoader {
    public final MessageRepo a;
    public final MessageBodyResolver b;
    public final SchedulersFactory c;

    public static final class a<T> implements Predicate<List<? extends LocalMessage>> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(List<? extends LocalMessage> list) {
            List<? extends LocalMessage> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "messages");
            return !list2.isEmpty();
        }
    }

    public static final class b<T> implements Consumer<List<? extends LocalMessage>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends LocalMessage> list) {
            StringBuilder sb = new StringBuilder();
            StringBuilder I = a2.b.a.a.a.I('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            I.append(currentThread.getName());
            I.append(']');
            sb.append(I.toString());
            sb.append(" Found ");
            sb.append(list.size());
            sb.append(" incomplete messages (");
            sb.append(this.a);
            sb.append(", ");
            Logs.verbose$default("IncompleteMessageBodyLoader", a2.b.a.a.a.s(sb, this.b, ')'), null, 4, null);
        }
    }

    public static final class c<T, R> implements Function<List<? extends LocalMessage>, MaybeSource<? extends List<? extends LocalMessage>>> {
        public final /* synthetic */ IncompleteMessageBodyLoader a;
        public final /* synthetic */ SharedScheduler b;

        public c(IncompleteMessageBodyLoader incompleteMessageBodyLoader, SharedScheduler sharedScheduler) {
            this.a = incompleteMessageBodyLoader;
            this.b = sharedScheduler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolver */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public MaybeSource<? extends List<? extends LocalMessage>> apply(List<? extends LocalMessage> list) {
            List<? extends LocalMessage> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "messages");
            return this.a.b.resolveMessageBodies(list2).subscribeOn(this.b).toMaybe();
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public e(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            StringBuilder sb = new StringBuilder();
            a2.b.a.a.a.f1("Thread.currentThread()", a2.b.a.a.a.I('['), ']', sb, " Loading of incomplete bodies finished (");
            sb.append(this.a);
            sb.append(", ");
            Logs.verbose$default("IncompleteMessageBodyLoader", a2.b.a.a.a.s(sb, this.b, ')'), null, 4, null);
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public f(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            StringBuilder sb = new StringBuilder();
            a2.b.a.a.a.f1("Thread.currentThread()", a2.b.a.a.a.I('['), ']', sb, " Failed to load incomplete bodies (");
            sb.append(this.a);
            sb.append(", ");
            sb.append(this.b);
            sb.append(')');
            Logs.verbose("IncompleteMessageBodyLoader", sb.toString(), th);
        }
    }

    public static final class g<T, R> implements Function<Option<? extends LocalMessage>, List<? extends LocalMessage>> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends LocalMessage> apply(Option<? extends LocalMessage> option) {
            Option<? extends LocalMessage> option2 = option;
            Intrinsics.checkNotNullParameter(option2, "message");
            return option2.toList();
        }
    }

    @Inject
    public IncompleteMessageBodyLoader(@NotNull MessageRepo messageRepo, @NotNull MessageBodyResolver messageBodyResolver, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(messageRepo, "messageRepo");
        Intrinsics.checkNotNullParameter(messageBodyResolver, "bodyResolver");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = messageRepo;
        this.b = messageBodyResolver;
        this.c = schedulersFactory;
    }

    public static /* synthetic */ Completable loadIncompleteMessageBodies$default(IncompleteMessageBodyLoader incompleteMessageBodyLoader, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        return incompleteMessageBodyLoader.loadIncompleteMessageBodies(str, str2, str3);
    }

    @NotNull
    public final Completable loadIncompleteMessageBodies(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Single<List<LocalMessage>> single;
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        SharedScheduler sharedScheduler = new SharedScheduler(this.c.io());
        if (str3 != null) {
            single = this.a.getMessage(str, str2, str3).map(g.a).firstOrError();
        } else {
            single = this.a.getMessagesWithIncompleteBodies(str, str2);
        }
        Completable doOnError = single.subscribeOn(sharedScheduler).observeOn(sharedScheduler).filter(a.a).doOnSuccess(new b(str2, str)).flatMap(new c(this, sharedScheduler)).observeOn(sharedScheduler).flatMapCompletable(new a2.a.a.o1.d.a0.n.a(new Function1<List<? extends LocalMessage>, Completable>(this.a) { // from class: com.avito.android.messenger.conversation.mvi.sync.IncompleteMessageBodyLoader.d
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.messenger.conversation.mvi.data.MessageRepo */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public Completable invoke(List<? extends LocalMessage> list) {
                List<? extends LocalMessage> list2 = list;
                Intrinsics.checkNotNullParameter(list2, "p1");
                return ((MessageRepo) this.receiver).createMessages(list2);
            }
        })).doOnComplete(new e(str2, str)).doOnError(new f(str2, str));
        Intrinsics.checkNotNullExpressionValue(doOnError, "messagesToLoad\n         …          )\n            }");
        return doOnError;
    }
}
