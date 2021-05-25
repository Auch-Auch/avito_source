package com.avito.android.suggest_locations;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0003H&¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0006H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsToolbar;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "queryEmits", "()Lio/reactivex/rxjava3/core/Observable;", "", "backPressed", "donePressed", "query", "updateText", "(Ljava/lang/String;)V", "hint", "setHint", "showKeyboard", "()V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public interface SuggestLocationsToolbar {
    @NotNull
    Observable<Unit> backPressed();

    @NotNull
    Observable<String> donePressed();

    @NotNull
    Observable<String> queryEmits();

    void setHint(@NotNull String str);

    void showKeyboard();

    void updateText(@NotNull String str);
}
