package com.avito.android.advert.actions;

import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b$\u0010%J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005JO\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/advert/actions/HiddenAdvertsInteractorImpl;", "Lcom/avito/android/advert/actions/HiddenAdvertsInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "", "advertHiddenEvents", "()Lio/reactivex/rxjava3/core/Observable;", "id", "type", "categoryId", "", "locationId", "feedId", VKApiConst.POSITION, "Lcom/avito/android/remote/model/TypedResult;", "", "markAsHidden", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;I)Lio/reactivex/rxjava3/core/Observable;", "", "isHidden", "(Ljava/lang/String;)Z", "Lcom/jakewharton/rxrelay3/PublishRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "relay", "Lcom/avito/android/advert/actions/HiddenAdvertsStorage;", "c", "Lcom/avito/android/advert/actions/HiddenAdvertsStorage;", "storage", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/SearchApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/SearchApi;", "searchApi", "<init>", "(Lcom/avito/android/remote/SearchApi;Lcom/avito/android/advert/actions/HiddenAdvertsStorage;Lcom/avito/android/util/SchedulersFactory3;)V", "advert-item-actions_release"}, k = 1, mv = {1, 4, 2})
public final class HiddenAdvertsInteractorImpl implements HiddenAdvertsInteractor {
    public final PublishRelay<String> a;
    public final SearchApi b;
    public final HiddenAdvertsStorage c;
    public final SchedulersFactory3 d;

    public static final class a<T> implements Consumer<Disposable> {
        public final /* synthetic */ HiddenAdvertsInteractorImpl a;
        public final /* synthetic */ String b;

        public a(HiddenAdvertsInteractorImpl hiddenAdvertsInteractorImpl, String str) {
            this.a = hiddenAdvertsInteractorImpl;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.jakewharton.rxrelay3.PublishRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.c.put(this.b);
            this.a.a.accept(this.b);
        }
    }

    @Inject
    public HiddenAdvertsInteractorImpl(@NotNull SearchApi searchApi, @NotNull HiddenAdvertsStorage hiddenAdvertsStorage, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(searchApi, "searchApi");
        Intrinsics.checkNotNullParameter(hiddenAdvertsStorage, "storage");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.b = searchApi;
        this.c = hiddenAdvertsStorage;
        this.d = schedulersFactory3;
        PublishRelay<String> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
    }

    @Override // com.avito.android.advert.actions.HiddenAdvertsInteractor
    @NotNull
    public Observable<String> advertHiddenEvents() {
        return this.a;
    }

    @Override // com.avito.android.advert.actions.HiddenAdvertsInteractor
    public boolean isHidden(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return this.c.isHidden(str);
    }

    @Override // com.avito.android.advert.actions.HiddenAdvertsInteractor
    @NotNull
    public Observable<TypedResult<Unit>> markAsHidden(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Integer num, @NotNull String str4, int i) {
        a2.b.a.a.a.Z0(str, "id", str2, "type", str4, "feedId");
        return a2.b.a.a.a.a2(this.d, this.b.hideRecommendation(str, str2, str3, num, i, str4).doOnSubscribe(new a(this, str)), "searchApi.hideRecommenda…scribeOn(schedulers.io())");
    }
}
