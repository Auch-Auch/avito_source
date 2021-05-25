package com.avito.android.shop_settings_select;

import com.avito.android.remote.ShopSettingsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ShopSettingsSelections;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.shop_settings_select.di.SelectContext;
import com.avito.android.shop_settings_select.di.SelectedId;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u000f\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/shop_settings_select/ShopSettingsSelectRepositoryImpl;", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectRepository;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/ShopSettingsSelections;", "getShopSettingsSelect", "()Lio/reactivex/Observable;", "Lcom/avito/android/remote/ShopSettingsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ShopSettingsApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "", "c", "Ljava/lang/String;", "selectContext", "d", "selectedId", "<init>", "(Lcom/avito/android/remote/ShopSettingsApi;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Ljava/lang/String;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSelectRepositoryImpl implements ShopSettingsSelectRepository {
    public final ShopSettingsApi a;
    public final SchedulersFactory b;
    public final String c;
    public final String d;

    public static final class a<T, R> implements Function<TypedResult<ShopSettingsSelections>, LoadingState<? super ShopSettingsSelections>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super ShopSettingsSelections> apply(TypedResult<ShopSettingsSelections> typedResult) {
            TypedResult<ShopSettingsSelections> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Inject
    public ShopSettingsSelectRepositoryImpl(@NotNull ShopSettingsApi shopSettingsApi, @NotNull SchedulersFactory schedulersFactory, @SelectContext @NotNull String str, @SelectedId @Nullable String str2) {
        Intrinsics.checkNotNullParameter(shopSettingsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(str, "selectContext");
        this.a = shopSettingsApi;
        this.b = schedulersFactory;
        this.c = str;
        this.d = str2;
    }

    @Override // com.avito.android.shop_settings_select.ShopSettingsSelectRepository
    @NotNull
    public Observable<LoadingState<ShopSettingsSelections>> getShopSettingsSelect() {
        Observable<LoadingState<ShopSettingsSelections>> map = InteropKt.toV2(this.a.getShopSettingsSelections(this.c, this.d)).subscribeOn(this.b.io()).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getShopSettingsSelec…p { it.toLoadingState() }");
        return map;
    }
}
