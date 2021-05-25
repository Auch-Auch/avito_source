package com.squareup.sqlbrite2;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.squareup.sqlbrite2.SqlBrite;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Cancellable;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
public final class BriteContentResolver {
    public final Handler a = new Handler(Looper.getMainLooper());
    public final ContentResolver b;
    public final SqlBrite.Logger c;
    public final Scheduler d;
    public final ObservableTransformer<SqlBrite.Query, SqlBrite.Query> e;
    public volatile boolean f;

    public class a extends SqlBrite.Query {
        public final /* synthetic */ Uri a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String[] d;
        public final /* synthetic */ String e;
        public final /* synthetic */ boolean f;

        public a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, boolean z) {
            this.a = uri;
            this.b = strArr;
            this.c = str;
            this.d = strArr2;
            this.e = str2;
            this.f = z;
        }

        @Override // com.squareup.sqlbrite2.SqlBrite.Query
        public Cursor run() {
            long nanoTime = System.nanoTime();
            Cursor query = BriteContentResolver.this.b.query(this.a, this.b, this.c, this.d, this.e);
            if (BriteContentResolver.this.f) {
                long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
                BriteContentResolver briteContentResolver = BriteContentResolver.this;
                Object[] objArr = {Long.valueOf(millis), this.a, Arrays.toString(this.b), this.c, Arrays.toString(this.d), this.e, Boolean.valueOf(this.f)};
                Objects.requireNonNull(briteContentResolver);
                briteContentResolver.c.log(String.format("QUERY (%sms)\n  uri: %s\n  projection: %s\n  selection: %s\n  selectionArgs: %s\n  sortOrder: %s\n  notifyForDescendents: %s", objArr));
            }
            return query;
        }
    }

    public class b implements ObservableOnSubscribe<SqlBrite.Query> {
        public final /* synthetic */ SqlBrite.Query a;
        public final /* synthetic */ Uri b;
        public final /* synthetic */ boolean c;

        public class a extends ContentObserver {
            public final /* synthetic */ ObservableEmitter a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Handler handler, ObservableEmitter observableEmitter) {
                super(handler);
                this.a = observableEmitter;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                if (!this.a.isDisposed()) {
                    this.a.onNext(b.this.a);
                }
            }
        }

        /* renamed from: com.squareup.sqlbrite2.BriteContentResolver$b$b  reason: collision with other inner class name */
        public class C0314b implements Cancellable {
            public final /* synthetic */ ContentObserver a;

            public C0314b(ContentObserver contentObserver) {
                this.a = contentObserver;
            }

            @Override // io.reactivex.functions.Cancellable
            public void cancel() throws Exception {
                BriteContentResolver.this.b.unregisterContentObserver(this.a);
            }
        }

        public b(SqlBrite.Query query, Uri uri, boolean z) {
            this.a = query;
            this.b = uri;
            this.c = z;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<SqlBrite.Query> observableEmitter) throws Exception {
            a aVar = new a(BriteContentResolver.this.a, observableEmitter);
            BriteContentResolver.this.b.registerContentObserver(this.b, this.c, aVar);
            observableEmitter.setCancellable(new C0314b(aVar));
            if (!observableEmitter.isDisposed()) {
                observableEmitter.onNext(this.a);
            }
        }
    }

    public BriteContentResolver(ContentResolver contentResolver, SqlBrite.Logger logger, Scheduler scheduler, ObservableTransformer<SqlBrite.Query, SqlBrite.Query> observableTransformer) {
        this.b = contentResolver;
        this.c = logger;
        this.d = scheduler;
        this.e = observableTransformer;
    }

    @CheckResult
    @NonNull
    public QueryObservable createQuery(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2, boolean z) {
        return (QueryObservable) Observable.create(new b(new a(uri, strArr, str, strArr2, str2, z), uri, z)).observeOn(this.d).compose(this.e).to(QueryObservable.b);
    }

    public void setLoggingEnabled(boolean z) {
        this.f = z;
    }
}
