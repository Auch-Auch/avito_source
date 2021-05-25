package com.avito.android.advert.viewed;

import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay3.PublishRelay;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractorImpl;", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "", "id", "", "advertViewed", "(Ljava/lang/String;)V", "Lcom/jakewharton/rxrelay3/PublishRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "getAdvertViewedEvents", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "advertViewedEvents", "<init>", "()V", "viewed-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedAdvertsEventInteractorImpl implements ViewedAdvertsEventInteractor {
    @NotNull
    public final PublishRelay<String> a;

    @Inject
    public ViewedAdvertsEventInteractorImpl() {
        PublishRelay<String> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
    }

    @Override // com.avito.android.advert.viewed.ViewedAdvertsEventInteractor
    public void advertViewed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        getAdvertViewedEvents().accept(str);
    }

    @Override // com.avito.android.advert.viewed.ViewedAdvertsEventInteractor
    @NotNull
    public PublishRelay<String> getAdvertViewedEvents() {
        return this.a;
    }
}
