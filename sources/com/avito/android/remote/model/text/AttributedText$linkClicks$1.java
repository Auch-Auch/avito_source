package com.avito.android.remote.model.text;

import com.avito.android.deep_linking.links.DeepLink;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/reactivex/ObservableEmitter;", "Lcom/avito/android/deep_linking/links/DeepLink;", "kotlin.jvm.PlatformType", "emitter", "", "subscribe", "(Lio/reactivex/ObservableEmitter;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class AttributedText$linkClicks$1<T> implements ObservableOnSubscribe<DeepLink> {
    public final /* synthetic */ AttributedText this$0;

    public AttributedText$linkClicks$1(AttributedText attributedText) {
        this.this$0 = attributedText;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(@NotNull ObservableEmitter<DeepLink> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
        final AttributedText$linkClicks$1$listener$1 attributedText$linkClicks$1$listener$1 = new AttributedText$linkClicks$1$listener$1(observableEmitter);
        observableEmitter.setCancellable(new Cancellable(this) { // from class: com.avito.android.remote.model.text.AttributedText$linkClicks$1.1
            public final /* synthetic */ AttributedText$linkClicks$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // io.reactivex.functions.Cancellable
            public final void cancel() {
                if (Intrinsics.areEqual(this.this$0.this$0.getOnDeepLinkClickListener(), attributedText$linkClicks$1$listener$1)) {
                    this.this$0.this$0.setOnDeepLinkClickListener(null);
                }
            }
        });
        this.this$0.setOnDeepLinkClickListener(attributedText$linkClicks$1$listener$1);
    }
}
