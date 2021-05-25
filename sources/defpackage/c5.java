package defpackage;

import android.app.AlertDialog;
import com.avito.android.lastclick.LastClick;
import com.avito.android.notifications_settings.NotificationsSettingsActivity;
import com.jakewharton.rxrelay2.Relay;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: c5  reason: default package */
public final class c5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c5(int i, Object obj, Object obj2) {
        super(0);
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            ((NotificationsSettingsActivity) this.b).k = null;
            Relay<Unit> consumer = ((NotificationsSettingsActivity) this.b).getConsumer();
            Unit unit = Unit.INSTANCE;
            consumer.accept(unit);
            LastClick.Updater.update();
            ((AlertDialog) this.c).dismiss();
            return unit;
        } else if (i == 1) {
            ((NotificationsSettingsActivity) this.b).k = null;
            LastClick.Updater.update();
            ((AlertDialog) this.c).dismiss();
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
