package com.avito.android.serp.ad;

import android.graphics.Bitmap;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "", "Landroid/graphics/Bitmap;", "bitmap", "", "key", "Lio/reactivex/rxjava3/core/Single;", "", "calculateBgColor", "(Landroid/graphics/Bitmap;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "observe", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface MyTargetImageBgProvider {
    @NotNull
    Single<Integer> calculateBgColor(@NotNull Bitmap bitmap, @NotNull String str);

    @NotNull
    Single<Integer> observe(@NotNull String str);
}
