package com.avito.android.messenger.channels.mvi.data;

import arrow.core.Option;
import arrow.syntax.collections.ListKt;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandler;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.DraftDao;
import ru.avito.android.persistence.messenger.DraftEntity;
import t6.n.q;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/DraftRepoImpl;", "Lcom/avito/android/messenger/channels/mvi/data/DraftRepo;", "", ChannelContext.Item.USER_ID, "channelId", "Lio/reactivex/Observable;", "Larrow/core/Option;", "Lru/avito/android/persistence/messenger/DraftEntity;", "getDraft", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "getAllDrafts", "(Ljava/lang/String;)Lio/reactivex/Observable;", "interlocutorId", "text", "Lio/reactivex/Completable;", "putDraft", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "deleteDraft", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "deleteAllDraftsWithInterlocutor", "Lru/avito/android/persistence/messenger/DraftDao;", AuthSource.SEND_ABUSE, "Lru/avito/android/persistence/messenger/DraftDao;", "draftDao", "Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandler;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandler;", "errorHandler", "<init>", "(Lru/avito/android/persistence/messenger/DraftDao;Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandler;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DraftRepoImpl implements DraftRepo {
    public final DraftDao a;
    public final DatabaseErrorHandler b;

    public static final class a<V> implements Callable<Object> {
        public final /* synthetic */ DraftRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(DraftRepoImpl draftRepoImpl, String str, String str2) {
            this.a = draftRepoImpl;
            this.b = str;
            this.c = str2;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            return Integer.valueOf(this.a.a.deleteAllDraftsWithInterlocutor(this.b, this.c));
        }
    }

    public static final class b<V> implements Callable<Object> {
        public final /* synthetic */ DraftRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(DraftRepoImpl draftRepoImpl, String str, String str2) {
            this.a = draftRepoImpl;
            this.b = str;
            this.c = str2;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            return Integer.valueOf(this.a.a.deleteDraft(this.b, this.c));
        }
    }

    public static final class c<T, R> implements Function<List<? extends DraftEntity>, Option<? extends DraftEntity>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends DraftEntity> apply(List<? extends DraftEntity> list) {
            List<? extends DraftEntity> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "draftList");
            return ListKt.firstOption(list2);
        }
    }

    public static final class d<V> implements Callable<Object> {
        public final /* synthetic */ DraftRepoImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public d(DraftRepoImpl draftRepoImpl, String str, String str2, String str3, String str4) {
            this.a = draftRepoImpl;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            return Long.valueOf(this.a.a.insertDraft(new DraftEntity(this.b, this.c, this.d, this.e)));
        }
    }

    @Inject
    public DraftRepoImpl(@NotNull DraftDao draftDao, @NotNull DatabaseErrorHandler databaseErrorHandler) {
        Intrinsics.checkNotNullParameter(draftDao, "draftDao");
        Intrinsics.checkNotNullParameter(databaseErrorHandler, "errorHandler");
        this.a = draftDao;
        this.b = databaseErrorHandler;
    }

    @Override // com.avito.android.messenger.channels.mvi.data.DraftRepoWriter
    @NotNull
    public Completable deleteAllDraftsWithInterlocutor(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "interlocutorId");
        Completable fromCallable = Completable.fromCallable(new a(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…d\n            )\n        }");
        Completable onErrorComplete = fromCallable.retryWhen(new DraftRepoImpl$trackError$1(this, "deleteAllDraftsWithInterlocutor", r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("interlocutorId", str2)))).onErrorComplete();
        Intrinsics.checkNotNullExpressionValue(onErrorComplete, "retryWhen { errors ->\n  …       .onErrorComplete()");
        return onErrorComplete;
    }

    @Override // com.avito.android.messenger.channels.mvi.data.DraftRepoWriter
    @NotNull
    public Completable deleteDraft(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Completable fromCallable = Completable.fromCallable(new b(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…d\n            )\n        }");
        Completable onErrorComplete = fromCallable.retryWhen(new DraftRepoImpl$trackError$1(this, "deleteDraft", r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2)))).onErrorComplete();
        Intrinsics.checkNotNullExpressionValue(onErrorComplete, "retryWhen { errors ->\n  …       .onErrorComplete()");
        return onErrorComplete;
    }

    @Override // com.avito.android.messenger.channels.mvi.data.DraftRepoReader
    @NotNull
    public Observable<List<DraftEntity>> getAllDrafts(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Observable<List<DraftEntity>> distinctUntilChanged = this.a.getAllDrafts(str).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "draftDao.getAllDrafts(us…  .distinctUntilChanged()");
        Observable<List<DraftEntity>> onErrorResumeNext = distinctUntilChanged.retryWhen(new DraftRepoImpl$trackError$2(this, "getAllDrafts", q.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str)))).onErrorResumeNext(Observable.empty());
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "retryWhen { errors ->\n  …eNext(Observable.empty())");
        return onErrorResumeNext;
    }

    @Override // com.avito.android.messenger.channels.mvi.data.DraftRepoReader
    @NotNull
    public Observable<Option<DraftEntity>> getDraft(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Observable<R> map = this.a.getDraft(str, str2).distinctUntilChanged().map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "draftDao.getDraft(userId…rstOption()\n            }");
        Observable<R> onErrorResumeNext = map.retryWhen(new DraftRepoImpl$trackError$2(this, "getDraft", r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2)))).onErrorResumeNext(Observable.empty());
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "retryWhen { errors ->\n  …eNext(Observable.empty())");
        return onErrorResumeNext;
    }

    @Override // com.avito.android.messenger.channels.mvi.data.DraftRepoWriter
    @NotNull
    public Completable putDraft(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "interlocutorId");
        Intrinsics.checkNotNullParameter(str4, "text");
        Completable fromCallable = Completable.fromCallable(new d(this, str, str2, str3, str4));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…)\n            )\n        }");
        Completable onErrorComplete = fromCallable.retryWhen(new DraftRepoImpl$trackError$1(this, "putDraft", r.mapOf(TuplesKt.to(ChannelContext.Item.USER_ID, str), TuplesKt.to("channelId", str2), TuplesKt.to("text", str4)))).onErrorComplete();
        Intrinsics.checkNotNullExpressionValue(onErrorComplete, "retryWhen { errors ->\n  …       .onErrorComplete()");
        return onErrorComplete;
    }
}
