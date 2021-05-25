package com.avito.android.remote.notification;

import a2.a.a.h2.a.a;
import a2.g.r.g;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.ServiceIntentFactory;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.deep_linking.links.AdvertAutoPublishLink;
import com.avito.android.deep_linking.links.ChannelDetailsLink;
import com.avito.android.deep_linking.links.ChannelsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.FavoriteSellerMuteLink;
import com.avito.android.deep_linking.links.MyAdvertLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.notification.Payload;
import com.avito.android.remote.notification.NotificationParameters;
import com.avito.android.ui_components.R;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010>\u001a\u00020<\u0012\u0006\u0010)\u001a\u00020'\u0012\u0006\u00108\u001a\u000206\u0012\u0006\u0010I\u001a\u00020G\u0012\u0006\u0010;\u001a\u000209\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010-\u001a\u00020*¢\u0006\u0004\bJ\u0010KJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0017JI\u0010 \u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b \u0010!J#\u0010\"\u001a\u00020\u0004*\u00020\u00152\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u0004*\u00020\u00152\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b&\u0010\u0010R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\"\u00105\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000203028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u00107R\u0016\u0010;\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010:R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010H¨\u0006L"}, d2 = {"Lcom/avito/android/remote/notification/NotificationInteractorImpl;", "Lcom/avito/android/remote/notification/NotificationInteractor;", "Lcom/avito/android/remote/notification/NotificationParameters;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "showNotification", "(Lcom/avito/android/remote/notification/NotificationParameters;)V", "", "channelId", "cancelChannelIdNotification", "(Ljava/lang/String;)V", "id", "cancelNotificationCenterNotification", "Lcom/avito/android/remote/notification/NotificationIdentifier;", "identifier", "cancelNotification", "(Lcom/avito/android/remote/notification/NotificationIdentifier;)V", "Landroidx/core/app/NotificationCompat$Action;", "overrideAction", "e", "(Lcom/avito/android/remote/notification/NotificationIdentifier;Lcom/avito/android/remote/notification/NotificationParameters;Landroidx/core/app/NotificationCompat$Action;)V", "Landroidx/core/app/NotificationCompat$Builder;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/notification/NotificationIdentifier;Lcom/avito/android/remote/notification/NotificationParameters;)Landroidx/core/app/NotificationCompat$Builder;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/remote/model/notification/Payload;", "payload", "", "analytics", "actionName", "Landroid/app/PendingIntent;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/notification/NotificationIdentifier;Lcom/avito/android/remote/model/notification/Payload;Ljava/util/Map;Ljava/lang/String;)Landroid/app/PendingIntent;", "d", "(Landroidx/core/app/NotificationCompat$Builder;Lcom/avito/android/remote/notification/NotificationIdentifier;Lcom/avito/android/remote/notification/NotificationParameters;)V", "c", "(Landroidx/core/app/NotificationCompat$Builder;Lcom/avito/android/remote/notification/NotificationIdentifier;)V", "f", "Landroidx/core/app/NotificationManagerCompat;", "Landroidx/core/app/NotificationManagerCompat;", "notificationManager", "Lcom/avito/android/util/BuildInfo;", "j", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/ActivityIntentFactory;", g.a, "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Ljava/util/HashMap;", "Lio/reactivex/disposables/Disposable;", "Ljava/util/HashMap;", "disposables", "Lcom/avito/android/remote/notification/NotificationBitmapInteractor;", "Lcom/avito/android/remote/notification/NotificationBitmapInteractor;", "notificationBitmapInteractor", "Lcom/avito/android/remote/notification/NotificationResourceProvider;", "Lcom/avito/android/remote/notification/NotificationResourceProvider;", "notificationResourceProvider", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/avito/android/ServiceIntentFactory;", "h", "Lcom/avito/android/ServiceIntentFactory;", "serviceIntentFactory", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/remote/notification/NotificationCounterStorage;", "Lcom/avito/android/remote/notification/NotificationCounterStorage;", "notificationCounterStorage", "<init>", "(Landroid/content/Context;Landroidx/core/app/NotificationManagerCompat;Lcom/avito/android/remote/notification/NotificationBitmapInteractor;Lcom/avito/android/remote/notification/NotificationCounterStorage;Lcom/avito/android/remote/notification/NotificationResourceProvider;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/ServiceIntentFactory;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/BuildInfo;)V", "notification_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationInteractorImpl implements NotificationInteractor {
    public final HashMap<NotificationIdentifier, Disposable> a = new HashMap<>();
    public final Context b;
    public final NotificationManagerCompat c;
    public final NotificationBitmapInteractor d;
    public final NotificationCounterStorage e;
    public final NotificationResourceProvider f;
    public final ActivityIntentFactory g;
    public final ServiceIntentFactory h;
    public final SchedulersFactory i;
    public final BuildInfo j;

    public NotificationInteractorImpl(@NotNull Context context, @NotNull NotificationManagerCompat notificationManagerCompat, @NotNull NotificationBitmapInteractor notificationBitmapInteractor, @NotNull NotificationCounterStorage notificationCounterStorage, @NotNull NotificationResourceProvider notificationResourceProvider, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull ServiceIntentFactory serviceIntentFactory, @NotNull SchedulersFactory schedulersFactory, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationManagerCompat, "notificationManager");
        Intrinsics.checkNotNullParameter(notificationBitmapInteractor, "notificationBitmapInteractor");
        Intrinsics.checkNotNullParameter(notificationCounterStorage, "notificationCounterStorage");
        Intrinsics.checkNotNullParameter(notificationResourceProvider, "notificationResourceProvider");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(serviceIntentFactory, "serviceIntentFactory");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.b = context;
        this.c = notificationManagerCompat;
        this.d = notificationBitmapInteractor;
        this.e = notificationCounterStorage;
        this.f = notificationResourceProvider;
        this.g = activityIntentFactory;
        this.h = serviceIntentFactory;
        this.i = schedulersFactory;
        this.j = buildInfo;
    }

    public static final void access$showWithBigImage(NotificationInteractorImpl notificationInteractorImpl, NotificationImages notificationImages, NotificationIdentifier notificationIdentifier, NotificationParameters notificationParameters, NotificationCompat.Action action) {
        Objects.requireNonNull(notificationInteractorImpl);
        NotificationCompat.Builder style = notificationInteractorImpl.a(notificationIdentifier, notificationParameters).setLargeIcon(notificationImages.getSmall()).setStyle(new NotificationCompat.BigPictureStyle().bigPicture(notificationImages.getBig()).setSummaryText(notificationParameters.getBody()));
        if (action != null) {
            style.addAction(action);
        }
        Intrinsics.checkNotNullExpressionValue(style, "createBuilder(identifier…dAction(overrideAction) }");
        notificationInteractorImpl.d(style, notificationIdentifier, notificationParameters);
        notificationImages.getBig().recycle();
        notificationImages.getSmall().recycle();
    }

    public final NotificationCompat.Builder a(NotificationIdentifier notificationIdentifier, NotificationParameters notificationParameters) {
        PendingIntent pendingIntent;
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(this.b, this.f.getChannelId()).setContentTitle(notificationParameters.getTitle()).setContentText(notificationParameters.getBody()).setSmallIcon(R.drawable.ic_notification).setColor(this.f.getColor()).setContentIntent(b(notificationParameters.getLink(), notificationIdentifier, notificationParameters.getPayload(), notificationParameters.getAnalytics(), null)).setAutoCancel(true);
        Intrinsics.checkNotNullExpressionValue(autoCancel, "NotificationCompat.Build…     .setAutoCancel(true)");
        List<Action> actions = notificationParameters.getActions();
        if (actions != null) {
            for (T t : actions) {
                DeepLink deepLink = t.getDeepLink();
                String title = t.getTitle();
                if (deepLink instanceof FavoriteSellerMuteLink) {
                    Intent favoriteSellerServiceMuteIntent = this.h.favoriteSellerServiceMuteIntent(((FavoriteSellerMuteLink) deepLink).getUserKey(), notificationIdentifier.getId(), notificationIdentifier.getTag(), title, notificationParameters.getAnalytics());
                    pendingIntent = PendingIntent.getService(this.b, this.e.generateNext(), favoriteSellerServiceMuteIntent, 134217728);
                } else if (deepLink instanceof MyAdvertLink.DeactivateBySoa) {
                    ServiceIntentFactory serviceIntentFactory = this.h;
                    MyAdvertLink.DeactivateBySoa deactivateBySoa = (MyAdvertLink.DeactivateBySoa) deepLink;
                    String itemId = deactivateBySoa.getItemId();
                    String reasonId = deactivateBySoa.getReasonId();
                    int id = notificationIdentifier.getId();
                    String tag = notificationIdentifier.getTag();
                    Map<String, String> analytics = notificationParameters.getAnalytics();
                    if (analytics == null) {
                        analytics = r.emptyMap();
                    }
                    Intent userAdvertCloseServiceIntent = serviceIntentFactory.userAdvertCloseServiceIntent(itemId, reasonId, id, tag, title, analytics);
                    pendingIntent = PendingIntent.getService(this.b, this.e.generateNext(), userAdvertCloseServiceIntent, 134217728);
                } else if (deepLink instanceof AdvertAutoPublishLink) {
                    ServiceIntentFactory serviceIntentFactory2 = this.h;
                    AdvertAutoPublishLink advertAutoPublishLink = (AdvertAutoPublishLink) deepLink;
                    String itemId2 = advertAutoPublishLink.getItemId();
                    boolean enabled = advertAutoPublishLink.getEnabled();
                    int id2 = notificationIdentifier.getId();
                    String tag2 = notificationIdentifier.getTag();
                    Map<String, String> analytics2 = notificationParameters.getAnalytics();
                    if (analytics2 == null) {
                        analytics2 = r.emptyMap();
                    }
                    Intent userAdvertAutoPublishServiceIntent = serviceIntentFactory2.userAdvertAutoPublishServiceIntent(itemId2, enabled, id2, tag2, title, analytics2);
                    pendingIntent = PendingIntent.getService(this.b, this.e.generateNext(), userAdvertAutoPublishServiceIntent, 134217728);
                } else {
                    if (deepLink instanceof MyAdvertLink.Activate) {
                        MyAdvertLink.Activate activate = (MyAdvertLink.Activate) deepLink;
                        if (!activate.getShouldOpenApp()) {
                            ServiceIntentFactory serviceIntentFactory3 = this.h;
                            String itemId3 = activate.getItemId();
                            int id3 = notificationIdentifier.getId();
                            String tag3 = notificationIdentifier.getTag();
                            Map<String, String> analytics3 = notificationParameters.getAnalytics();
                            if (analytics3 == null) {
                                analytics3 = r.emptyMap();
                            }
                            Intent userAdvertActivateServiceIntent = serviceIntentFactory3.userAdvertActivateServiceIntent(itemId3, id3, tag3, title, analytics3);
                            pendingIntent = PendingIntent.getService(this.b, this.e.generateNext(), userAdvertActivateServiceIntent, 134217728);
                        }
                    }
                    pendingIntent = null;
                }
                if (pendingIntent == null) {
                    pendingIntent = b(deepLink, notificationIdentifier, null, null, title);
                }
                autoCancel.addAction(0, t.getTitle(), pendingIntent);
            }
        }
        return autoCancel;
    }

    public final PendingIntent b(DeepLink deepLink, NotificationIdentifier notificationIdentifier, Payload payload, Map<String, String> map, String str) {
        Intent notificationDeepLinkActivityIntent = this.g.notificationDeepLinkActivityIntent(deepLink, notificationIdentifier.getTag(), notificationIdentifier.getId(), payload, map, str);
        PendingIntent activity = PendingIntent.getActivity(this.b, this.e.generateNext(), notificationDeepLinkActivityIntent, 134217728);
        Intrinsics.checkNotNullExpressionValue(activity, "PendingIntent.getActivit…_UPDATE_CURRENT\n        )");
        return activity;
    }

    public final void c(NotificationCompat.Builder builder, NotificationIdentifier notificationIdentifier) {
        this.c.notify(notificationIdentifier.getTag(), notificationIdentifier.getId(), builder.build());
    }

    @Override // com.avito.android.remote.notification.NotificationInteractor
    public void cancelChannelIdNotification(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        cancelNotification(new NotificationIdentifier("tag_channel", str.hashCode()));
    }

    @Override // com.avito.android.remote.notification.NotificationInteractor
    public void cancelNotification(@NotNull NotificationIdentifier notificationIdentifier) {
        Intrinsics.checkNotNullParameter(notificationIdentifier, "identifier");
        this.c.cancel(notificationIdentifier.getTag(), notificationIdentifier.getId());
        f(notificationIdentifier);
    }

    @Override // com.avito.android.remote.notification.NotificationInteractor
    public void cancelNotificationCenterNotification(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        cancelNotification(new NotificationIdentifier("tag_nc", str.hashCode()));
    }

    public final void d(NotificationCompat.Builder builder, NotificationIdentifier notificationIdentifier, NotificationParameters notificationParameters) {
        if (notificationParameters.getSoundAndVibrateEnabled()) {
            try {
                builder.setDefaults(3);
                c(builder, notificationIdentifier);
            } catch (SecurityException unused) {
                builder.setDefaults(0);
                c(builder, notificationIdentifier);
            }
        } else {
            builder.setDefaults(0);
            c(builder, notificationIdentifier);
        }
    }

    public final void e(NotificationIdentifier notificationIdentifier, NotificationParameters notificationParameters, NotificationCompat.Action action) {
        NotificationCompat.Builder style = a(notificationIdentifier, notificationParameters).setStyle(new NotificationCompat.BigTextStyle().bigText(notificationParameters.getBody()));
        if (action != null) {
            style.addAction(action);
        }
        Intrinsics.checkNotNullExpressionValue(style, "createBuilder(identifier…rideAction)\n            }");
        d(style, notificationIdentifier, notificationParameters);
    }

    public final void f(NotificationIdentifier notificationIdentifier) {
        Disposable remove = this.a.remove(notificationIdentifier);
        if (remove != null) {
            Intrinsics.checkNotNullExpressionValue(remove, "disposables.remove(identifier) ?: return");
            remove.dispose();
        }
    }

    @Override // com.avito.android.remote.notification.NotificationInteractor
    public void showNotification(@NotNull NotificationParameters notificationParameters) {
        NotificationIdentifier notificationIdentifier;
        Intrinsics.checkNotNullParameter(notificationParameters, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        Payload payload = notificationParameters.getPayload();
        boolean z = false;
        NotificationCompat.Action action = null;
        if (payload instanceof Payload.NotificationCenter) {
            notificationIdentifier = new NotificationIdentifier("tag_nc", ((Payload.NotificationCenter) payload).getId().hashCode());
        } else {
            DeepLink link = notificationParameters.getLink();
            if (link instanceof ChannelsLink) {
                String advertId = ((ChannelsLink) link).getAdvertId();
                notificationIdentifier = new NotificationIdentifier("tag_channels", advertId != null ? advertId.hashCode() : 0);
            } else if (link instanceof ChannelDetailsLink) {
                notificationIdentifier = new NotificationIdentifier("tag_channel", ((ChannelDetailsLink) link).getChannelId().hashCode());
            } else {
                notificationIdentifier = new NotificationIdentifier(null, notificationParameters.getBody().hashCode() + ((link.getPath().hashCode() + (notificationParameters.getTitle().hashCode() * 31)) * 31));
            }
        }
        NotificationParameters.Style style = notificationParameters.getStyle();
        DeepLink link2 = notificationParameters.getLink();
        boolean z2 = link2 instanceof ChannelDetailsLink;
        if (z2) {
            this.h.channelSyncOnPushServiceEnqueueWork(((ChannelDetailsLink) link2).getChannelId());
        }
        if (this.j.getSdkVersion() >= 24) {
            z = true;
        }
        if (z && z2) {
            PendingIntent service = PendingIntent.getService(this.b, notificationIdentifier.getId(), this.h.sendMessageServiceIntent(((ChannelDetailsLink) link2).getChannelId(), "direct_reply", notificationIdentifier.getId(), notificationIdentifier.getTag()), 134217728);
            String directReplyLabel = this.f.getDirectReplyLabel();
            RemoteInput build = new RemoteInput.Builder("direct_reply").setLabel(directReplyLabel).build();
            Intrinsics.checkNotNullExpressionValue(build, "RemoteInput.Builder(KEY_…\n                .build()");
            action = new NotificationCompat.Action.Builder(R.drawable.ic_send_24, directReplyLabel, service).addRemoteInput(build).setAllowGeneratedReplies(true).build();
        }
        if (style instanceof NotificationParameters.Style.BigImage) {
            Image image = ((NotificationParameters.Style.BigImage) style).getImage();
            f(notificationIdentifier);
            HashMap<NotificationIdentifier, Disposable> hashMap = this.a;
            Disposable subscribe = this.d.load(image).observeOn(this.i.mainThread()).subscribe(new a(this, notificationIdentifier, notificationParameters, action));
            Intrinsics.checkNotNullExpressionValue(subscribe, "notificationBitmapIntera…          }\n            }");
            hashMap.put(notificationIdentifier, subscribe);
        } else if (style instanceof NotificationParameters.Style.BigText) {
            e(notificationIdentifier, notificationParameters, action);
        } else {
            e(notificationIdentifier, notificationParameters, action);
        }
    }
}
