package com.avito.android.extended_profile.adapter.header;

import android.view.View;
import com.avito.android.extended_profile.R;
import com.avito.android.public_profile.remote.model.ProfileCounter;
import com.avito.android.public_profile.ui.SubscriptionsCounterView;
import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/avito/android/extended_profile/adapter/header/SubscriptionsCounterViewImpl;", "Lcom/avito/android/public_profile/ui/SubscriptionsCounterView;", "Lcom/avito/android/public_profile/remote/model/ProfileCounter;", "counter", "", "bindSubscribersCounter", "(Lcom/avito/android/public_profile/remote/model/ProfileCounter;)V", "bindSubscriptionsCounter", "Lcom/avito/android/extended_profile/adapter/header/HeaderCounterView;", AuthSource.SEND_ABUSE, "Lcom/avito/android/extended_profile/adapter/header/HeaderCounterView;", "subscribersView", AuthSource.BOOKING_ORDER, "subscriptionsView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class SubscriptionsCounterViewImpl implements SubscriptionsCounterView {
    public final HeaderCounterView a;
    public final HeaderCounterView b;

    public SubscriptionsCounterViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.subscribers);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = new HeaderCounterViewImpl(findViewById);
        View findViewById2 = view.findViewById(R.id.subscriptions);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = new HeaderCounterViewImpl(findViewById2);
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsCounterView
    public void bindSubscribersCounter(@Nullable ProfileCounter profileCounter) {
        this.a.bindCounter(profileCounter);
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsCounterView
    public void bindSubscriptionsCounter(@Nullable ProfileCounter profileCounter) {
        this.b.bindCounter(profileCounter);
    }
}
