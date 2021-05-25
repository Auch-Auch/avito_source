package com.avito.android.rating.publish.buyer_info;

import com.avito.android.util.SimpleTextWatcher;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.rxjava3.core.ObservableEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/avito/android/rating/publish/buyer_info/BuyerInfoViewImpl$textChanges$1$watcher$1", "Lcom/avito/android/util/SimpleTextWatcher;", "", "s", "", Tracker.Events.CREATIVE_START, "before", "count", "", "onTextChanged", "(Ljava/lang/CharSequence;III)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class BuyerInfoViewImpl$textChanges$1$watcher$1 extends SimpleTextWatcher {
    public final /* synthetic */ ObservableEmitter a;

    public BuyerInfoViewImpl$textChanges$1$watcher$1(ObservableEmitter observableEmitter) {
        this.a = observableEmitter;
    }

    @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
    public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
        this.a.onNext(charSequence.toString());
    }
}
