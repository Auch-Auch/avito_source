package l6.h.a;

import android.app.Notification;
import android.app.RemoteInput;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class e implements NotificationBuilderWithBuilderAccessor {
    public final Notification.Builder a;
    public final NotificationCompat.Builder b;
    public RemoteViews c;
    public RemoteViews d;
    public final List<Bundle> e = new ArrayList();
    public final Bundle f = new Bundle();
    public int g;
    public RemoteViews h;

    public e(NotificationCompat.Builder builder) {
        Notification.Action.Builder builder2;
        Bundle bundle;
        this.b = builder;
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = new Notification.Builder(builder.mContext, builder.H);
        } else {
            this.a = new Notification.Builder(builder.mContext);
        }
        Notification notification = builder.O;
        this.a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.f).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.b).setContentText(builder.c).setContentInfo(builder.h).setContentIntent(builder.d).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder.e, (notification.flags & 128) != 0).setLargeIcon(builder.g).setNumber(builder.i).setProgress(builder.q, builder.r, builder.s);
        this.a.setSubText(builder.o).setUsesChronometer(builder.l).setPriority(builder.j);
        Iterator<NotificationCompat.Action> it = builder.mActions.iterator();
        while (true) {
            Icon icon = null;
            if (!it.hasNext()) {
                break;
            }
            NotificationCompat.Action next = it.next();
            int i = Build.VERSION.SDK_INT;
            IconCompat iconCompat = next.getIconCompat();
            if (i >= 23) {
                builder2 = new Notification.Action.Builder(iconCompat != null ? iconCompat.toIcon() : icon, next.getTitle(), next.getActionIntent());
            } else {
                builder2 = new Notification.Action.Builder(iconCompat != null ? iconCompat.getResId() : 0, next.getTitle(), next.getActionIntent());
            }
            if (next.getRemoteInputs() != null) {
                for (RemoteInput remoteInput : androidx.core.app.RemoteInput.b(next.getRemoteInputs())) {
                    builder2.addRemoteInput(remoteInput);
                }
            }
            if (next.getExtras() != null) {
                bundle = new Bundle(next.getExtras());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", next.getAllowGeneratedReplies());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                builder2.setAllowGeneratedReplies(next.getAllowGeneratedReplies());
            }
            bundle.putInt("android.support.action.semanticAction", next.getSemanticAction());
            if (i2 >= 28) {
                builder2.setSemanticAction(next.getSemanticAction());
            }
            if (i2 >= 29) {
                builder2.setContextual(next.isContextual());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", next.getShowsUserInterface());
            builder2.addExtras(bundle);
            this.a.addAction(builder2.build());
        }
        Bundle bundle2 = builder.A;
        if (bundle2 != null) {
            this.f.putAll(bundle2);
        }
        this.c = builder.E;
        this.d = builder.F;
        this.a.setShowWhen(builder.k);
        this.a.setLocalOnly(builder.w).setGroup(builder.t).setGroupSummary(builder.u).setSortKey(builder.v);
        this.g = builder.L;
        this.a.setCategory(builder.z).setColor(builder.B).setVisibility(builder.C).setPublicVersion(builder.D).setSound(notification.sound, notification.audioAttributes);
        Iterator<String> it2 = builder.mPeople.iterator();
        while (it2.hasNext()) {
            this.a.addPerson(it2.next());
        }
        this.h = builder.G;
        if (builder.a.size() > 0) {
            Bundle bundle3 = builder.getExtras().getBundle("android.car.EXTENSIONS");
            bundle3 = bundle3 == null ? new Bundle() : bundle3;
            Bundle bundle4 = new Bundle();
            for (int i3 = 0; i3 < builder.a.size(); i3++) {
                bundle4.putBundle(Integer.toString(i3), f.d(builder.a.get(i3)));
            }
            bundle3.putBundle("invisible_actions", bundle4);
            builder.getExtras().putBundle("android.car.EXTENSIONS", bundle3);
            this.f.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 24) {
            this.a.setExtras(builder.A).setRemoteInputHistory(builder.p);
            RemoteViews remoteViews = builder.E;
            if (remoteViews != null) {
                this.a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = builder.F;
            if (remoteViews2 != null) {
                this.a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = builder.G;
            if (remoteViews3 != null) {
                this.a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i4 >= 26) {
            this.a.setBadgeIconType(builder.I).setShortcutId(builder.J).setTimeoutAfter(builder.K).setGroupAlertBehavior(builder.L);
            if (builder.y) {
                this.a.setColorized(builder.x);
            }
            if (!TextUtils.isEmpty(builder.H)) {
                this.a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i4 >= 29) {
            this.a.setAllowSystemGeneratedContextualActions(builder.M);
            this.a.setBubbleMetadata(NotificationCompat.BubbleMetadata.toPlatform(builder.N));
        }
        if (builder.P) {
            if (this.b.u) {
                this.g = 2;
            } else {
                this.g = 1;
            }
            this.a.setVibrate(null);
            this.a.setSound(null);
            int i5 = notification.defaults & -2;
            notification.defaults = i5;
            int i6 = i5 & -3;
            notification.defaults = i6;
            this.a.setDefaults(i6);
            if (i4 >= 26) {
                if (TextUtils.isEmpty(this.b.t)) {
                    this.a.setGroup(NotificationCompat.GROUP_KEY_SILENT);
                }
                this.a.setGroupAlertBehavior(this.g);
            }
        }
    }

    public final void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i = notification.defaults & -2;
        notification.defaults = i;
        notification.defaults = i & -3;
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.a;
    }
}
