package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;
public class NotificationTarget extends CustomTarget<Bitmap> {
    public final RemoteViews d;
    public final Context e;
    public final int f;
    public final String g;
    public final Notification h;
    public final int i;

    public NotificationTarget(Context context, int i2, RemoteViews remoteViews, Notification notification, int i3) {
        this(context, i2, remoteViews, notification, i3, null);
    }

    public final void a(@Nullable Bitmap bitmap) {
        this.d.setImageViewBitmap(this.i, bitmap);
        ((NotificationManager) Preconditions.checkNotNull((NotificationManager) this.e.getSystemService("notification"))).notify(this.g, this.f, this.h);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@Nullable Drawable drawable) {
        a(null);
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
    }

    public NotificationTarget(Context context, int i2, RemoteViews remoteViews, Notification notification, int i3, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, notification, i3, str);
    }

    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
        a(bitmap);
    }

    public NotificationTarget(Context context, int i2, int i3, int i4, RemoteViews remoteViews, Notification notification, int i5, String str) {
        super(i2, i3);
        this.e = (Context) Preconditions.checkNotNull(context, "Context must not be null!");
        this.h = (Notification) Preconditions.checkNotNull(notification, "Notification object can not be null!");
        this.d = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
        this.i = i4;
        this.f = i5;
        this.g = str;
    }
}
