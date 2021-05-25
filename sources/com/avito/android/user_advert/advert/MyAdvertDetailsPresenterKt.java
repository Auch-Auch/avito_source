package com.avito.android.user_advert.advert;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"user-advert_release"}, k = 2, mv = {1, 4, 2})
public final class MyAdvertDetailsPresenterKt {
    public static final Observable access$throttleExtraClicks(Observable observable) {
        return observable.throttleFirst(1, TimeUnit.SECONDS);
    }
}
