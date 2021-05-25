package com.avito.android.component.circular_action_progress;

import android.graphics.drawable.Drawable;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/component/circular_action_progress/CircularActionProgress;", "", "Landroid/graphics/drawable/Drawable;", "drawable", "", "setBackground", "(Landroid/graphics/drawable/Drawable;)V", "", "cancelable", "setCancelable", "(Z)V", "errorEnabled", "setErrorEnabled", "startProgress", "()V", "stopProgress", "stopProgressWithError", "hide", "show", "Lio/reactivex/rxjava3/core/Observable;", "getErrorActionClicks", "()Lio/reactivex/rxjava3/core/Observable;", "errorActionClicks", "getCancelActionClicks", "cancelActionClicks", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface CircularActionProgress {
    @NotNull
    Observable<Unit> getCancelActionClicks();

    @NotNull
    Observable<Unit> getErrorActionClicks();

    void hide();

    void setBackground(@Nullable Drawable drawable);

    void setCancelable(boolean z);

    void setErrorEnabled(boolean z);

    void show();

    void startProgress();

    void stopProgress();

    void stopProgressWithError();
}
