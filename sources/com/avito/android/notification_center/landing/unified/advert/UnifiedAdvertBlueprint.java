package com.avito.android.notification_center.landing.unified.advert;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.notification_center.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertItemView;", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "", AuthSource.SEND_ABUSE, "I", "layoutId", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertItemViewImpl;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertPresenter;", "c", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertPresenter;", "getPresenter", "()Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertPresenter;", "presenter", "Ljava/util/Locale;", "locale", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "<init>", "(Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertPresenter;Ljava/util/Locale;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class UnifiedAdvertBlueprint implements ItemBlueprint<UnifiedAdvertItemView, UnifiedAdvertItem> {
    public final int a;
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<UnifiedAdvertItemViewImpl> b;
    @NotNull
    public final UnifiedAdvertPresenter c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, UnifiedAdvertItemViewImpl> {
        public final /* synthetic */ Locale a;
        public final /* synthetic */ TimeSource b;
        public final /* synthetic */ ConnectivityProvider c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Locale locale, TimeSource timeSource, ConnectivityProvider connectivityProvider) {
            super(2);
            this.a = locale;
            this.b = timeSource;
            this.c = connectivityProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public UnifiedAdvertItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new UnifiedAdvertItemViewImpl(view2, this.a, this.b, this.c);
        }
    }

    @Inject
    public UnifiedAdvertBlueprint(@NotNull UnifiedAdvertPresenter unifiedAdvertPresenter, @NotNull Locale locale, @NotNull TimeSource timeSource, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(unifiedAdvertPresenter, "presenter");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        this.c = unifiedAdvertPresenter;
        int i = R.layout.notification_center_landing_unified_advert;
        this.a = i;
        this.b = new ViewHolderBuilder.ViewHolderProvider<>(i, new a(locale, timeSource, connectivityProvider));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<UnifiedAdvertItemViewImpl> getViewHolderProvider() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof UnifiedAdvertItem;
    }

    /* Return type fixed from 'com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<UnifiedAdvertItemView, UnifiedAdvertItem> getPresenter() {
        return this.c;
    }
}
