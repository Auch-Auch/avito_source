package com.avito.android.messenger.channels.mvi.view;

import com.avito.android.lib.design.snackbar.Snackbar;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsListViewImpl$showSnackbar$1 implements Runnable {
    public final /* synthetic */ ChannelsListViewImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public ChannelsListViewImpl$showSnackbar$1(ChannelsListViewImpl channelsListViewImpl, String str, String str2) {
        this.a = channelsListViewImpl;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.r.isAttachedToWindow()) {
            Snackbar snackbar = this.a.i;
            if (snackbar != null) {
                snackbar.dismiss();
            }
            ChannelsListViewImpl channelsListViewImpl = this.a;
            channelsListViewImpl.i = SnackbarExtensionsKt.showSnackbar$default(channelsListViewImpl.h, this.b, 0, this.c, 0, new Function0<Unit>(this) { // from class: com.avito.android.messenger.channels.mvi.view.ChannelsListViewImpl$showSnackbar$1.1
                public final /* synthetic */ ChannelsListViewImpl$showSnackbar$1 a;

                {
                    this.a = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    this.a.a.getSnackbarRefreshClicks().accept(Unit.INSTANCE);
                    this.a.a.i = null;
                }
            }, Integer.MAX_VALUE, SnackbarPosition.ABOVE_VIEW, SnackbarType.DEFAULT, 10, (Object) null);
        }
    }
}
