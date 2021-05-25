package com.avito.android.util;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\tJ\u001b\u0010\u0006\u001a\u00020\n*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/util/RxLogger;", "", "T", "Lio/reactivex/Observable;", "", "message", "log", "(Lio/reactivex/Observable;Ljava/lang/String;)Lio/reactivex/Observable;", "Lio/reactivex/Single;", "(Lio/reactivex/Single;Ljava/lang/String;)Lio/reactivex/Single;", "Lio/reactivex/Completable;", "(Lio/reactivex/Completable;Ljava/lang/String;)Lio/reactivex/Completable;", "android_release"}, k = 1, mv = {1, 4, 2})
public interface RxLogger {
    @NotNull
    Completable log(@NotNull Completable completable, @NotNull String str);

    @NotNull
    <T> Observable<T> log(@NotNull Observable<T> observable, @NotNull String str);

    @NotNull
    <T> Single<T> log(@NotNull Single<T> single, @NotNull String str);
}
