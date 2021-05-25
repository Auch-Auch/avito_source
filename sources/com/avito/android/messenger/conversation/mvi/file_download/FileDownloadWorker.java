package com.avito.android.messenger.conversation.mvi.file_download;

import android.app.NotificationChannel;
import android.content.Context;
import android.os.Build;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.rxjava3.RxWorker;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.HasComponentDependencies;
import com.avito.android.lib.design.avito.R;
import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerComponent;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Contexts;
import com.avito.android.util.Logs;
import com.avito.android.util.rx3.Singles;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadWorker;", "Landroidx/work/rxjava3/RxWorker;", "Lio/reactivex/rxjava3/core/Single;", "Landroidx/work/ListenableWorker$Result;", "createWork", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadWorkerDelegate;", "delegate", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadWorkerDelegate;", "getDelegate$messenger_release", "()Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadWorkerDelegate;", "setDelegate$messenger_release", "(Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadWorkerDelegate;)V", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FileDownloadWorker extends RxWorker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "FileDownloadWorker";
    @Inject
    public FileDownloadWorkerDelegate delegate;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b)\u0010*J3\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012JO\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00180\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b#\u0010 R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002XT¢\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010&\u001a\u00020%8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b(\u0010 ¨\u0006+"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadWorker$Companion;", "", "Landroid/content/Context;", "context", "", ChannelContext.Item.USER_ID, "channelId", "localMessageId", "Lio/reactivex/rxjava3/core/Single;", "", "isAlreadyEnqueued", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "", "enqTimestamp", "Lio/reactivex/rxjava3/core/Completable;", "enqueueWork", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lio/reactivex/rxjava3/core/Completable;", "cancelWork", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", "Lio/reactivex/rxjava3/core/Scheduler;", "mainThreadScheduler", "processingScheduler", "startFromTimestamp", "Lio/reactivex/rxjava3/core/Observable;", "", "Ljava/util/UUID;", "Landroidx/work/WorkInfo;", "observeFails", "(Landroid/content/Context;Lio/reactivex/rxjava3/core/Scheduler;Lio/reactivex/rxjava3/core/Scheduler;Ljava/lang/String;Ljava/lang/String;J)Lio/reactivex/rxjava3/core/Observable;", "DEFAULT_ENQ_TIMESTAMP", "J", "KEY_CHANNEL_ID", "Ljava/lang/String;", "KEY_ENQ_TIMESTAMP", "KEY_ERROR", "KEY_LOCAL_MESSAGE_ID", "KEY_USER_ID", "", "NOTIFICATION_ID", "I", "TAG", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a<V> implements Callable<Object> {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ long d;
            public final /* synthetic */ Context e;

            public a(String str, String str2, String str3, long j, Context context) {
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = j;
                this.e = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Data build = new Data.Builder().putString(ChannelContext.Item.USER_ID, this.a).putString("channelId", this.b).putString("localMessageId", this.c).putLong("enqTimestamp", this.d).build();
                Intrinsics.checkNotNullExpressionValue(build, "Data.Builder()\n         …                 .build()");
                WorkRequest build2 = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(FileDownloadWorker.class).setInputData(build)).addTag(FileDownloadWorker.TAG)).build();
                Intrinsics.checkNotNullExpressionValue(build2, "OneTimeWorkRequest.Build…                 .build()");
                WorkManager instance = WorkManager.getInstance(this.e);
                Companion companion = FileDownloadWorker.Companion;
                return instance.beginUniqueWork(a2.b.a.a.a.f(this.a, "||", this.b, "||", this.c), ExistingWorkPolicy.REPLACE, (OneTimeWorkRequest) build2).enqueue();
            }
        }

        public static final class b<T, R> implements Function<List<WorkInfo>, Boolean> {
            public static final b a = new b();

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.functions.Function
            public Boolean apply(List<WorkInfo> list) {
                List<WorkInfo> list2 = list;
                Intrinsics.checkNotNullExpressionValue(list2, "workInfos");
                WorkInfo workInfo = (WorkInfo) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                WorkInfo.State state = workInfo != null ? workInfo.getState() : null;
                return Boolean.valueOf(state != null && !state.isFinished());
            }
        }

        public static final class c<T> implements ObservableOnSubscribe<List<? extends WorkInfo>> {
            public final /* synthetic */ Context a;

            public static final class a implements Cancellable {
                public final /* synthetic */ LiveData a;
                public final /* synthetic */ Observer b;

                public a(LiveData liveData, Observer observer) {
                    this.a = liveData;
                    this.b = observer;
                }

                @Override // io.reactivex.rxjava3.functions.Cancellable
                public final void cancel() {
                    this.a.removeObserver(this.b);
                }
            }

            public static final class b<T> implements Observer<List<? extends WorkInfo>> {
                public final /* synthetic */ ObservableEmitter a;

                public b(ObservableEmitter observableEmitter) {
                    this.a = observableEmitter;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.lifecycle.Observer
                public void onChanged(List<? extends WorkInfo> list) {
                    List<? extends WorkInfo> list2 = list;
                    if (list2 != null) {
                        this.a.onNext(list2);
                    }
                }
            }

            public c(Context context) {
                this.a = context;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.reactivex.rxjava3.core.ObservableEmitter<java.util.List<androidx.work.WorkInfo>>] */
            @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter<List<? extends WorkInfo>> observableEmitter) {
                LiveData<List<WorkInfo>> workInfosByTagLiveData = WorkManager.getInstance(this.a).getWorkInfosByTagLiveData(FileDownloadWorker.TAG);
                Intrinsics.checkNotNullExpressionValue(workInfosByTagLiveData, "WorkManager.getInstance(…rkInfosByTagLiveData(TAG)");
                b bVar = new b(observableEmitter);
                workInfosByTagLiveData.observeForever(bVar);
                observableEmitter.setCancellable(new a(workInfosByTagLiveData, bVar));
            }
        }

        public static final class d<T, R> implements Function<List<? extends WorkInfo>, Map<UUID, ? extends WorkInfo>> {
            public final /* synthetic */ long a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;

            public d(long j, String str, String str2) {
                this.a = j;
                this.b = str;
                this.c = str2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.functions.Function
            public Map<UUID, ? extends WorkInfo> apply(List<? extends WorkInfo> list) {
                List<? extends WorkInfo> list2 = list;
                Intrinsics.checkNotNullExpressionValue(list2, "workInfos");
                ArrayList arrayList = new ArrayList();
                for (T t : list2) {
                    T t2 = t;
                    if (t2.getState() == WorkInfo.State.FAILED && t2.getOutputData().getLong("enqTimestamp", 0) >= this.a && Intrinsics.areEqual(t2.getOutputData().getString(ChannelContext.Item.USER_ID), this.b) && Intrinsics.areEqual(t2.getOutputData().getString("channelId"), this.c)) {
                        arrayList.add(t);
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(arrayList, 10)), 16));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    linkedHashMap.put(((WorkInfo) next).getId(), next);
                }
                return linkedHashMap;
            }
        }

        public Companion() {
        }

        public static final String access$workNameFrom(Companion companion, String str, String str2, String str3) {
            Objects.requireNonNull(companion);
            return str + "||" + str2 + "||" + str3;
        }

        @NotNull
        public final Completable cancelWork(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str2, "channelId");
            Intrinsics.checkNotNullParameter(str3, "localMessageId");
            Operation cancelUniqueWork = WorkManager.getInstance(context).cancelUniqueWork(a2.b.a.a.a.f(str, "||", str2, "||", str3));
            Intrinsics.checkNotNullExpressionValue(cancelUniqueWork, "WorkManager.getInstance(…Id)\n                    )");
            Completable fromFuture = Completable.fromFuture(cancelUniqueWork.getResult());
            Intrinsics.checkNotNullExpressionValue(fromFuture, "Completable.fromFuture(\n…    .result\n            )");
            return fromFuture;
        }

        @NotNull
        public final Completable enqueueWork(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, long j) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str2, "channelId");
            Intrinsics.checkNotNullParameter(str3, "localMessageId");
            Completable fromCallable = Completable.fromCallable(new a(str, str2, str3, j, context));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable… .enqueue()\n            }");
            return fromCallable;
        }

        @NotNull
        public final Single<Boolean> isAlreadyEnqueued(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str2, "channelId");
            Intrinsics.checkNotNullParameter(str3, "localMessageId");
            Single<Boolean> map = Single.fromFuture(WorkManager.getInstance(context).getWorkInfosForUniqueWork(a2.b.a.a.a.f(str, "||", str2, "||", str3))).map(b.a);
            Intrinsics.checkNotNullExpressionValue(map, "Single.fromFuture(\n     …inished\n                }");
            return map;
        }

        @NotNull
        public final Observable<Map<UUID, WorkInfo>> observeFails(@NotNull Context context, @NotNull Scheduler scheduler, @NotNull Scheduler scheduler2, @NotNull String str, @NotNull String str2, long j) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scheduler, "mainThreadScheduler");
            Intrinsics.checkNotNullParameter(scheduler2, "processingScheduler");
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str2, "channelId");
            Observable<Map<UUID, WorkInfo>> distinctUntilChanged = Observable.create(new c(context)).subscribeOn(scheduler).unsubscribeOn(scheduler).observeOn(scheduler2).map(new d(j, str, str2)).distinctUntilChanged();
            Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "Observable.create<List<W…  .distinctUntilChanged()");
            return distinctUntilChanged;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<V> implements Callable<Unit> {
        public final /* synthetic */ FileDownloadWorker a;

        public a(FileDownloadWorker fileDownloadWorker) {
            this.a = fileDownloadWorker;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Unit call() {
            FileDownloadWorker fileDownloadWorker = this.a;
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(fileDownloadWorker.getApplicationContext(), R.style.Theme_DesignSystem_Avito);
            NotificationManagerCompat from = NotificationManagerCompat.from(contextThemeWrapper);
            Intrinsics.checkNotNullExpressionValue(from, "NotificationManagerCompat.from(themeContext)");
            String string = fileDownloadWorker.getApplicationContext().getString(com.avito.android.messenger.R.string.messenger_file_download_notification_channel_id);
            Intrinsics.checkNotNullExpressionValue(string, "applicationContext.getSt…_notification_channel_id)");
            if (Build.VERSION.SDK_INT >= 26) {
                from.createNotificationChannel(new NotificationChannel(string, fileDownloadWorker.getApplicationContext().getString(com.avito.android.messenger.R.string.messenger_file_download_notification_channel_name), 2));
                Logs.debug$default(FileDownloadWorker.TAG, "Created notification channel", null, 4, null);
            }
            fileDownloadWorker.setForegroundAsync(new ForegroundInfo(60, new NotificationCompat.Builder(contextThemeWrapper, string).setAutoCancel(true).setContentTitle(fileDownloadWorker.getApplicationContext().getString(com.avito.android.messenger.R.string.messenger_notification_file_dowload_title)).setContentText(fileDownloadWorker.getApplicationContext().getString(com.avito.android.messenger.R.string.messenger_notification_file_dowload_content)).setColor(Contexts.getColorByAttr(contextThemeWrapper, com.avito.android.lib.design.R.attr.blue)).setSmallIcon(com.avito.android.ui_components.R.drawable.ic_notification).build())).get();
            return Unit.INSTANCE;
        }
    }

    public static final class b<T, R> implements Function<Unit, SingleSource<? extends ListenableWorker.Result>> {
        public final /* synthetic */ FileDownloadWorker a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;

        public b(FileDownloadWorker fileDownloadWorker, String str, String str2, String str3, long j) {
            this.a = fileDownloadWorker;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = j;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends ListenableWorker.Result> apply(Unit unit) {
            FileDownloadWorker fileDownloadWorker = this.a;
            FileDownloadWorkerComponent.Factory factory = DaggerFileDownloadWorkerComponent.factory();
            Context applicationContext = fileDownloadWorker.getApplicationContext();
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.avito.android.di.HasComponentDependencies");
            factory.create((FileDownloadWorkerComponentDependencies) ComponentDependenciesKt.getDependencies(FileDownloadWorkerComponentDependencies.class, (HasComponentDependencies) applicationContext)).inject(fileDownloadWorker);
            return this.a.getDelegate$messenger_release().download(this.b, this.c, this.d).toSingleDefault(ListenableWorker.Result.success()).onErrorReturn(new a2.a.a.o1.d.a0.e.a(this));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileDownloadWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    public static final ForegroundInfo access$createForegroundInfo(FileDownloadWorker fileDownloadWorker) {
        Objects.requireNonNull(fileDownloadWorker);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(fileDownloadWorker.getApplicationContext(), R.style.Theme_DesignSystem_Avito);
        NotificationManagerCompat from = NotificationManagerCompat.from(contextThemeWrapper);
        Intrinsics.checkNotNullExpressionValue(from, "NotificationManagerCompat.from(themeContext)");
        String string = fileDownloadWorker.getApplicationContext().getString(com.avito.android.messenger.R.string.messenger_file_download_notification_channel_id);
        Intrinsics.checkNotNullExpressionValue(string, "applicationContext.getSt…_notification_channel_id)");
        if (Build.VERSION.SDK_INT >= 26) {
            from.createNotificationChannel(new NotificationChannel(string, fileDownloadWorker.getApplicationContext().getString(com.avito.android.messenger.R.string.messenger_file_download_notification_channel_name), 2));
            Logs.debug$default(TAG, "Created notification channel", null, 4, null);
        }
        return new ForegroundInfo(60, new NotificationCompat.Builder(contextThemeWrapper, string).setAutoCancel(true).setContentTitle(fileDownloadWorker.getApplicationContext().getString(com.avito.android.messenger.R.string.messenger_notification_file_dowload_title)).setContentText(fileDownloadWorker.getApplicationContext().getString(com.avito.android.messenger.R.string.messenger_notification_file_dowload_content)).setColor(Contexts.getColorByAttr(contextThemeWrapper, com.avito.android.lib.design.R.attr.blue)).setSmallIcon(com.avito.android.ui_components.R.drawable.ic_notification).build());
    }

    public static final void access$setupDI(FileDownloadWorker fileDownloadWorker) {
        Objects.requireNonNull(fileDownloadWorker);
        FileDownloadWorkerComponent.Factory factory = DaggerFileDownloadWorkerComponent.factory();
        Context applicationContext = fileDownloadWorker.getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.avito.android.di.HasComponentDependencies");
        factory.create((FileDownloadWorkerComponentDependencies) ComponentDependenciesKt.getDependencies(FileDownloadWorkerComponentDependencies.class, (HasComponentDependencies) applicationContext)).inject(fileDownloadWorker);
    }

    @Override // androidx.work.rxjava3.RxWorker
    @NotNull
    public Single<ListenableWorker.Result> createWork() {
        String str;
        String str2;
        String str3;
        String string = getInputData().getString(ChannelContext.Item.USER_ID);
        if (string != null) {
            str = string;
        } else {
            Logs.error$default(TAG, "No userId was passed!", null, 4, null);
            str = null;
        }
        String string2 = getInputData().getString("channelId");
        if (string2 != null) {
            str2 = string2;
        } else {
            Logs.error$default(TAG, "No channelId was passed!", null, 4, null);
            str2 = null;
        }
        String string3 = getInputData().getString("localMessageId");
        if (string3 != null) {
            str3 = string3;
        } else {
            Logs.error$default(TAG, "No localMessageId was passed!", null, 4, null);
            str3 = null;
        }
        long j = getInputData().getLong("enqTimestamp", 0);
        if (str == null || str2 == null || str3 == null) {
            Data build = new Data.Builder().putString(ChannelContext.Item.USER_ID, str).putString("channelId", str2).putString("localMessageId", str3).putLong("enqTimestamp", j).build();
            Intrinsics.checkNotNullExpressionValue(build, "Data.Builder()\n         …\n                .build()");
            ListenableWorker.Result failure = ListenableWorker.Result.failure(build);
            Intrinsics.checkNotNullExpressionValue(failure, "Result.failure(outputData)");
            return Singles.toSingle(failure);
        }
        Single<ListenableWorker.Result> flatMap = Single.fromCallable(new a(this)).flatMap(new b(this, str, str2, str3, j));
        Intrinsics.checkNotNullExpressionValue(flatMap, "Single.fromCallable {\n  …          }\n            }");
        return flatMap;
    }

    @NotNull
    public final FileDownloadWorkerDelegate getDelegate$messenger_release() {
        FileDownloadWorkerDelegate fileDownloadWorkerDelegate = this.delegate;
        if (fileDownloadWorkerDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return fileDownloadWorkerDelegate;
    }

    public final void setDelegate$messenger_release(@NotNull FileDownloadWorkerDelegate fileDownloadWorkerDelegate) {
        Intrinsics.checkNotNullParameter(fileDownloadWorkerDelegate, "<set-?>");
        this.delegate = fileDownloadWorkerDelegate;
    }
}
