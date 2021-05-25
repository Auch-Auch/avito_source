package com.avito.android.shop_settings;

import com.avito.android.remote.ShopSettingsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ShopSettings;
import com.avito.android.remote.model.ShopSettingsSave;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.shop_settings.blueprints.ShopSettingsItem;
import com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItem;
import com.avito.android.shop_settings.blueprints.input.multi_line_input.ShopSettingsMultiLineInputItem;
import com.avito.android.shop_settings.blueprints.input.single_line_input.ShopSettingsSingleLineInputItem;
import com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItem;
import com.avito.android.shop_settings.blueprints.switcher.ShopSettingsSwitcherItem;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/shop_settings/ShopSettingsInteractorImpl;", "Lcom/avito/android/shop_settings/ShopSettingsInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/ShopSettings;", "getShopSettings", "()Lio/reactivex/Observable;", "", "Lcom/avito/android/shop_settings/blueprints/ShopSettingsItem;", "items", "Lcom/avito/android/remote/model/ShopSettingsSave;", "saveShopSettings", "(Ljava/util/List;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/ShopSettingsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ShopSettingsApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Lcom/avito/android/remote/ShopSettingsApi;Lcom/avito/android/util/SchedulersFactory;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsInteractorImpl implements ShopSettingsInteractor {
    public final ShopSettingsApi a;
    public final SchedulersFactory b;

    public static final class a<T, R> implements Function<TypedResult<ShopSettings>, LoadingState<? super ShopSettings>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super ShopSettings> apply(TypedResult<ShopSettings> typedResult) {
            TypedResult<ShopSettings> typedResult2 = typedResult;
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

    public static final class b<T, R> implements Function<TypedResult<ShopSettingsSave>, LoadingState<? super ShopSettingsSave>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super ShopSettingsSave> apply(TypedResult<ShopSettingsSave> typedResult) {
            TypedResult<ShopSettingsSave> typedResult2 = typedResult;
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
    public ShopSettingsInteractorImpl(@NotNull ShopSettingsApi shopSettingsApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(shopSettingsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = shopSettingsApi;
        this.b = schedulersFactory;
    }

    @Override // com.avito.android.shop_settings.ShopSettingsInteractor
    @NotNull
    public Observable<LoadingState<ShopSettings>> getShopSettings() {
        Observable<LoadingState<ShopSettings>> map = InteropKt.toV2(this.a.getShopSettings()).subscribeOn(this.b.io()).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.getShopSettings().to…p { it.toLoadingState() }");
        return map;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x008f: APUT  
      (r2v9 kotlin.Pair[])
      (0 ??[int, short, byte, char])
      (wrap: kotlin.Pair : 0x008a: INVOKE  (r5v2 kotlin.Pair) = (r5v1 java.lang.String), (r6v3 java.lang.String) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    @Override // com.avito.android.shop_settings.ShopSettingsInteractor
    @NotNull
    public Observable<LoadingState<ShopSettingsSave>> saveShopSettings(@NotNull List<? extends ShopSettingsItem> list) {
        List list2;
        ArrayList i0 = a2.b.a.a.a.i0(list, "items");
        for (T t : list) {
            if (t instanceof ShopSettingsSingleLineInputItem) {
                T t2 = t;
                list2 = d.listOf(TuplesKt.to(t2.getStringId(), t2.getCurrentText()));
            } else if (t instanceof ShopSettingsMultiLineInputItem) {
                T t3 = t;
                list2 = d.listOf(TuplesKt.to(t3.getStringId(), t3.getCurrentText()));
            } else {
                String str = "";
                if (t instanceof ShopSettingsSelectItem) {
                    T t4 = t;
                    String stringId = t4.getStringId();
                    String value = t4.getValue();
                    if (value != null) {
                        str = value;
                    }
                    list2 = d.listOf(TuplesKt.to(stringId, str));
                } else if (t instanceof ShopSettingsAddressItem) {
                    T t5 = t;
                    Pair[] pairArr = new Pair[3];
                    String str2 = t5.getStringId() + "[latitude]";
                    String latitude = t5.getLatitude();
                    if (latitude == null) {
                        latitude = str;
                    }
                    pairArr[0] = TuplesKt.to(str2, latitude);
                    String str3 = t5.getStringId() + "[longitude]";
                    String longitude = t5.getLongitude();
                    if (longitude != null) {
                        str = longitude;
                    }
                    pairArr[1] = TuplesKt.to(str3, str);
                    pairArr[2] = TuplesKt.to(t5.getStringId() + "[text]", t5.getCurrentText());
                    list2 = CollectionsKt__CollectionsKt.listOf((Object[]) pairArr);
                } else if (t instanceof ShopSettingsSwitcherItem) {
                    T t7 = t;
                    boolean isEnabled = t7.isEnabled();
                    if (isEnabled) {
                        list2 = d.listOf(TuplesKt.to(t7.getStringId(), "1"));
                    } else if (!isEnabled) {
                        list2 = d.listOf(TuplesKt.to(t7.getStringId(), "0"));
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    list2 = null;
                }
            }
            if (list2 != null) {
                i0.add(list2);
            }
        }
        Observable<LoadingState<ShopSettingsSave>> map = InteropKt.toV2(this.a.saveShopSettings(r.toMap(e.flatten(i0)))).subscribeOn(this.b.io()).map(b.a);
        Intrinsics.checkNotNullExpressionValue(map, "api.saveShopSettings(par…p { it.toLoadingState() }");
        return map;
    }
}
