package com.avito.android.advert_core.contactbar;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertAction;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactoryImpl;", "Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;", "Lcom/avito/android/remote/model/AdvertAction;", "action", "Lkotlin/Pair;", "", "getActionIconRes", "(Lcom/avito/android/remote/model/AdvertAction;)Lkotlin/Pair;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", AuthSource.BOOKING_ORDER, "Z", "isInPhotoGallery", "<init>", "(Landroid/content/Context;Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertActionIconFactoryImpl implements AdvertActionIconFactory {
    @NotNull
    public final Context a;
    public final boolean b;

    public AdvertActionIconFactoryImpl(@NotNull Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        this.b = z;
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertActionIconFactory
    @NotNull
    public Pair<Integer, Integer> getActionIconRes(@NotNull AdvertAction advertAction) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(advertAction, "action");
        if (this.b) {
            if (advertAction instanceof AdvertAction.Messenger) {
                i2 = R.drawable.ic_message_24;
            } else if (advertAction instanceof AdvertAction.Phone) {
                i2 = R.drawable.ic_call_24;
            } else if (advertAction instanceof AdvertAction.Access) {
                i2 = R.drawable.ic_rouble_24;
            } else {
                i2 = R.drawable.ic_rouble_24;
            }
            return new Pair<>(Integer.valueOf(i2), Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_constant_white));
        }
        if (advertAction instanceof AdvertAction.Messenger) {
            i = R.drawable.ic_rds_message_20;
        } else if (advertAction instanceof AdvertAction.Phone) {
            i = com.avito.android.lib.design.avito.R.drawable.avito_ic_call_16;
        } else if (advertAction instanceof AdvertAction.Access) {
            i = R.drawable.ic_rds_buy_contact_20;
        } else {
            i = R.drawable.ic_rds_buy_contact_20;
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(com.avito.android.lib.design.avito.R.color.avito_constant_white));
    }

    @NotNull
    public final Context getContext() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertActionIconFactoryImpl(Context context, boolean z, int i, j jVar) {
        this(context, (i & 2) != 0 ? false : z);
    }
}
