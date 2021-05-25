package com.avito.android.publish.premoderation;

import com.avito.android.image_loader.Picture;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0006J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0013\u0010\u0006J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H&¢\u0006\u0004\b\u0017\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H&¢\u0006\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/publish/premoderation/AdvertDuplicateView;", "", "", "title", "", "showTitle", "(Ljava/lang/String;)V", "description", "showDescription", "hint", "showHint", "setActionTitle", "setSkipActionTitle", "Lcom/avito/android/image_loader/Picture;", "picture", "showAdvertImage", "(Lcom/avito/android/image_loader/Picture;)V", "showAdvertTitle", "price", "showAdvertPrice", "Lio/reactivex/Observable;", "actionClicks", "()Lio/reactivex/Observable;", "skipActionClicks", "upClicks", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDuplicateView {
    @NotNull
    Observable<Unit> actionClicks();

    void setActionTitle(@NotNull String str);

    void setSkipActionTitle(@NotNull String str);

    void showAdvertImage(@NotNull Picture picture);

    void showAdvertPrice(@Nullable String str);

    void showAdvertTitle(@NotNull String str);

    void showDescription(@NotNull String str);

    void showHint(@Nullable String str);

    void showTitle(@NotNull String str);

    @NotNull
    Observable<Unit> skipActionClicks();

    @NotNull
    Observable<Unit> upClicks();
}
