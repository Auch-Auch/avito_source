package com.avito.android.legacy_mvp;

import kotlin.Deprecated;
import kotlin.Metadata;
@Deprecated(message = "Don't use")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/legacy_mvp/Presenter;", "T", "", "subscriber", "", "subscribe", "(Ljava/lang/Object;)V", "unsubscribe", "()V", "legacy-mvp_release"}, k = 1, mv = {1, 4, 2})
public interface Presenter<T> {
    void subscribe(T t);

    void unsubscribe();
}
