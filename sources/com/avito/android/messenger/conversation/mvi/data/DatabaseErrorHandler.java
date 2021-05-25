package com.avito.android.messenger.conversation.mvi.data;

import com.facebook.applinks.AppLinkData;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J?\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandler;", "", "Lio/reactivex/Observable;", "", "errors", "", "method", "", AppLinkData.ARGUMENTS_EXTRAS_KEY, "", "handleErrors", "(Lio/reactivex/Observable;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface DatabaseErrorHandler {
    @NotNull
    Observable<Unit> handleErrors(@NotNull Observable<Throwable> observable, @NotNull String str, @NotNull Map<String, ? extends Object> map);
}
