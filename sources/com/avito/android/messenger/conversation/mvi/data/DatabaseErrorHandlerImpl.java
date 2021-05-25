package com.avito.android.messenger.conversation.mvi.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.facebook.applinks.AppLinkData;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessengerDatabase;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J?\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007H\u0017¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandlerImpl;", "Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandler;", "Lio/reactivex/Observable;", "", "errors", "", "method", "", "", AppLinkData.ARGUMENTS_EXTRAS_KEY, "", "handleErrors", "(Lio/reactivex/Observable;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lru/avito/android/persistence/messenger/MessengerDatabase;", "c", "Lru/avito/android/persistence/messenger/MessengerDatabase;", "database", "Landroid/content/Context;", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "context", "Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "tracker", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/content/Context;Lru/avito/android/persistence/messenger/MessengerDatabase;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DatabaseErrorHandlerImpl implements DatabaseErrorHandler {
    public final MessengerErrorTracker a;
    public final Context b;
    public final MessengerDatabase c;
    public final SchedulersFactory d;

    public static final class a<T, R> implements Function<Throwable, SingleSource<? extends Boolean>> {
        public final /* synthetic */ DatabaseErrorHandlerImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;

        public a(DatabaseErrorHandlerImpl databaseErrorHandlerImpl, String str, Map map) {
            this.a = databaseErrorHandlerImpl;
            this.b = str;
            this.c = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Boolean> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return DatabaseErrorHandlerImpl.access$handleError(this.a, th2, this.b, this.c);
        }
    }

    public static final class b<T> implements Predicate<Boolean> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "shouldRetry");
            return !bool2.booleanValue();
        }
    }

    public static final class c<T, R> implements Function<Boolean, Unit> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "it");
            return Unit.INSTANCE;
        }
    }

    @Inject
    public DatabaseErrorHandlerImpl(@NotNull Context context, @NotNull MessengerDatabase messengerDatabase, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(messengerDatabase, "database");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = context;
        this.c = messengerDatabase;
        this.d = schedulersFactory;
        this.a = new MessengerErrorTracker(analytics);
    }

    public static final Single access$handleError(DatabaseErrorHandlerImpl databaseErrorHandlerImpl, Throwable th, String str, Map map) {
        Objects.requireNonNull(databaseErrorHandlerImpl);
        return a2.b.a.a.a.V1(databaseErrorHandlerImpl.d, Single.fromCallable(new a2.a.a.o1.d.a0.b.a(databaseErrorHandlerImpl, th, str, map)).delay(500, TimeUnit.MILLISECONDS, databaseErrorHandlerImpl.d.computation()), "Single.fromCallable {\n  …scribeOn(schedulers.io())");
    }

    public static final boolean access$isSQLiteDatabaseCorruptException$p(DatabaseErrorHandlerImpl databaseErrorHandlerImpl, Throwable th) {
        Objects.requireNonNull(databaseErrorHandlerImpl);
        if (!(th instanceof SQLiteDatabaseCorruptException)) {
            if (!((th != null ? th.getCause() : null) instanceof SQLiteDatabaseCorruptException)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandler
    @ExperimentalUnsignedTypes
    @NotNull
    public Observable<Unit> handleErrors(@NotNull Observable<Throwable> observable, @NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(observable, "errors");
        Intrinsics.checkNotNullParameter(str, "method");
        Intrinsics.checkNotNullParameter(map, AppLinkData.ARGUMENTS_EXTRAS_KEY);
        Observable<R> map2 = observable.flatMapSingle(new a(this, str, map)).takeUntil(b.a).take(1).map(c.a);
        Intrinsics.checkNotNullExpressionValue(map2, "errors.flatMapSingle { e…            .map { Unit }");
        return map2;
    }
}
