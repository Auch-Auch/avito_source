package com.avito.android.abuse.auth;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/abuse/auth/AuthQueryView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "backClicks", "()Lio/reactivex/rxjava3/core/Observable;", "authClicks", "sendClicks", "abuse_release"}, k = 1, mv = {1, 4, 2})
public interface AuthQueryView {
    @NotNull
    Observable<Unit> authClicks();

    @NotNull
    Observable<Unit> backClicks();

    @NotNull
    Observable<Unit> sendClicks();
}
