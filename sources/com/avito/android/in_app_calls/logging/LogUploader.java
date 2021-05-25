package com.avito.android.in_app_calls.logging;

import a2.a.a.f1.e.b;
import a2.a.a.f1.e.c;
import a2.a.a.f1.e.d;
import a2.a.a.f1.e.e;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.io.File;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/in_app_calls/logging/LogUploader;", "", "Ljava/io/File;", "logFile", "Lio/reactivex/rxjava3/core/Completable;", "uploadLogs", "(Ljava/io/File;)Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/calls/remote/CallsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls/remote/CallsApi;", "callsApi", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/calls/remote/CallsApi;Lcom/avito/android/util/SchedulersFactory3;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class LogUploader {
    public final CallsApi a;
    public final SchedulersFactory3 b;

    public static final class a<T, R> implements Function<File, CompletableSource> {
        public final /* synthetic */ LogUploader a;

        public a(LogUploader logUploader) {
            this.a = logUploader;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(File file) {
            File file2 = file;
            LogUploader logUploader = this.a;
            Intrinsics.checkNotNullExpressionValue(file2, "file");
            return LogUploader.access$compress(logUploader, file2).subscribeOn(this.a.b.io()).flatMapCompletable(new e(this));
        }
    }

    @Inject
    public LogUploader(@NotNull CallsApi callsApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(callsApi, "callsApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = callsApi;
        this.b = schedulersFactory3;
    }

    public static final Single access$compress(LogUploader logUploader, File file) {
        Objects.requireNonNull(logUploader);
        Single fromCallable = Single.fromCallable(new a2.a.a.f1.e.a(file));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …e\n            }\n        }");
        return fromCallable;
    }

    public static final Completable access$uploadAndDelete(LogUploader logUploader, File file) {
        Objects.requireNonNull(logUploader);
        RequestBody create = RequestBody.Companion.create(file, LogUploaderKt.access$getFILE_CONTENT_TYPE$p());
        MultipartBody.Part.Companion companion = MultipartBody.Part.Companion;
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        Single<R> flatMap = logUploader.a.uploadLogs(companion.createFormData("uploadID", StringsKt__StringsKt.substringBefore$default(name, ".", (String) null, 2, (Object) null)), companion.createFormData("File", file.getName(), create)).flatMap(LogUploader$uploadAndDelete$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        Completable doOnComplete = flatMap.doOnError(new b(file)).ignoreElement().andThen(Completable.fromCallable(new c(file))).doOnComplete(d.a);
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "callsApi.uploadLogs(uplo… deleted!\")\n            }");
        return doOnComplete;
    }

    @NotNull
    public final Completable uploadLogs(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "logFile");
        Completable flatMapCompletable = Single.just(file).flatMapCompletable(new a(this));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "Single.just(logFile)\n   …          }\n            }");
        return flatMapCompletable;
    }
}
