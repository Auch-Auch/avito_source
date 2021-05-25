package com.avito.android.location_list;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/location_list/LocationItemSingleLinePresenterImpl;", "Lcom/avito/android/location_list/LocationItemSingleLinePresenter;", "Lcom/avito/android/location_list/LocationItemSingleLineView;", "view", "Lcom/avito/android/location_list/LocationItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/location_list/LocationItemSingleLineView;Lcom/avito/android/location_list/LocationItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/location_list/LocationListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;)V", "location-list_release"}, k = 1, mv = {1, 4, 2})
public final class LocationItemSingleLinePresenterImpl implements LocationItemSingleLinePresenter {
    public final Lazy<? extends LocationListener> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ LocationItemSingleLinePresenterImpl a;
        public final /* synthetic */ LocationItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LocationItemSingleLinePresenterImpl locationItemSingleLinePresenterImpl, LocationItem locationItem) {
            super(0);
            this.a = locationItemSingleLinePresenterImpl;
            this.b = locationItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((LocationListener) this.a.a.get()).onLocationSelected(this.b.getStringId());
            return Unit.INSTANCE;
        }
    }

    public LocationItemSingleLinePresenterImpl(@NotNull Lazy<? extends LocationListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
    }

    public void bindView(@NotNull LocationItemSingleLineView locationItemSingleLineView, @NotNull LocationItem locationItem, int i) {
        Intrinsics.checkNotNullParameter(locationItemSingleLineView, "view");
        Intrinsics.checkNotNullParameter(locationItem, "item");
        locationItemSingleLineView.setTitle(locationItem.getTitle());
        locationItemSingleLineView.setChecked(locationItem.isSelected());
        locationItemSingleLineView.setOnItemClickListener(new a(this, locationItem));
    }
}
