package com.avito.android.photo_picker.legacy.service;

import a2.a.a.x1.q.n.a;
import a2.a.a.x1.q.n.b;
import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.avito.android.app.core.R;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.component.DaggerImageUploadServiceComponent;
import com.avito.android.di.component.ImageUploadServiceComponent;
import com.avito.android.di.component.ImageUploadServiceDependencies;
import com.avito.android.di.module.ImageUploadServiceModule;
import com.avito.android.photo_picker.PhotoPickerActivityKt;
import com.avito.android.photo_picker.legacy.service.ImageUploadServiceDelegate;
import com.avito.android.service.ServiceCountdownHandler;
import com.avito.android.util.Contexts;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/avito/android/photo_picker/legacy/service/ImageUploadService;", "Landroid/app/Service;", "Lcom/avito/android/service/ServiceCountdownHandler$Listener;", "", "onCreate", "()V", "Landroid/content/Intent;", "intent", "", "onBind", "(Landroid/content/Intent;)Ljava/lang/Void;", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onStart", "lastStartId", "onStop", "(I)V", "Lcom/avito/android/service/ServiceCountdownHandler;", "countdownHandler", "Lcom/avito/android/service/ServiceCountdownHandler;", "getCountdownHandler", "()Lcom/avito/android/service/ServiceCountdownHandler;", "setCountdownHandler", "(Lcom/avito/android/service/ServiceCountdownHandler;)V", "Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate;", "delegate", "Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate;", "getDelegate", "()Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate;", "setDelegate", "(Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate;)V", "<init>", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ImageUploadService extends Service implements ServiceCountdownHandler.Listener {
    @Inject
    public ServiceCountdownHandler countdownHandler;
    @Inject
    public ImageUploadServiceDelegate delegate;

    public static final void access$onError(ImageUploadService imageUploadService, Throwable th) {
        ServiceCountdownHandler serviceCountdownHandler = imageUploadService.countdownHandler;
        if (serviceCountdownHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countdownHandler");
        }
        serviceCountdownHandler.onActionDone();
    }

    public static final void access$processEvent(ImageUploadService imageUploadService, ImageUploadServiceDelegate.UploadingEvent uploadingEvent) {
        Objects.requireNonNull(imageUploadService);
        if (uploadingEvent instanceof ImageUploadServiceDelegate.UploadingEvent.Success) {
            ServiceCountdownHandler serviceCountdownHandler = imageUploadService.countdownHandler;
            if (serviceCountdownHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("countdownHandler");
            }
            serviceCountdownHandler.onActionDone();
        } else if (uploadingEvent instanceof Error) {
            ((Error) uploadingEvent).getCause();
            ServiceCountdownHandler serviceCountdownHandler2 = imageUploadService.countdownHandler;
            if (serviceCountdownHandler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("countdownHandler");
            }
            serviceCountdownHandler2.onActionDone();
        }
    }

    @NotNull
    public final ServiceCountdownHandler getCountdownHandler() {
        ServiceCountdownHandler serviceCountdownHandler = this.countdownHandler;
        if (serviceCountdownHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countdownHandler");
        }
        return serviceCountdownHandler;
    }

    @NotNull
    public final ImageUploadServiceDelegate getDelegate() {
        ImageUploadServiceDelegate imageUploadServiceDelegate = this.delegate;
        if (imageUploadServiceDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return imageUploadServiceDelegate;
    }

    @Override // android.app.Service
    @Nullable
    public Void onBind(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ImageUploadServiceComponent.Builder module = DaggerImageUploadServiceComponent.builder().dependencies((ImageUploadServiceDependencies) ComponentDependenciesKt.getDependencies(ImageUploadServiceDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Service) this))).module(ImageUploadServiceModule.INSTANCE);
        Gson create = new GsonBuilder().create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder().create()");
        module.withGson(create).build().inject(this);
        ServiceCountdownHandler serviceCountdownHandler = this.countdownHandler;
        if (serviceCountdownHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countdownHandler");
        }
        serviceCountdownHandler.setListener(this);
    }

    @Override // com.avito.android.service.ServiceCountdownHandler.Listener
    public void onStart() {
        String string = getString(R.string.notification_channel_id_default);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.avito.andr…ation_channel_id_default)");
        Notification build = new NotificationCompat.Builder(this, string).setAutoCancel(true).setContentTitle(getString(com.avito.android.photo_picker.R.string.legacy_photo_picker_uploading_notification_title)).setContentText(getString(com.avito.android.photo_picker.R.string.legacy_photo_picker_uploading_notification_description)).setColor(Contexts.getColorCompat(this, com.avito.android.lib.design.avito.R.color.avito_blue)).setSmallIcon(com.avito.android.ui_components.R.drawable.ic_notification).build();
        Intrinsics.checkNotNullExpressionValue(build, "NotificationCompat.Build…ion)\n            .build()");
        startForeground(13, build);
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        ServiceCountdownHandler serviceCountdownHandler = this.countdownHandler;
        if (serviceCountdownHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countdownHandler");
        }
        serviceCountdownHandler.onStartAction(i2);
        Boolean bool = null;
        String stringExtra = intent != null ? intent.getStringExtra(PhotoPickerActivityKt.EXTRA_OPERATION_ID) : null;
        String stringExtra2 = intent != null ? intent.getStringExtra("photo_id") : null;
        if (intent != null) {
            bool = Boolean.valueOf(intent.getBooleanExtra("upload_after_non_restorable_error", false));
        }
        if (stringExtra == null || bool == null) {
            ServiceCountdownHandler serviceCountdownHandler2 = this.countdownHandler;
            if (serviceCountdownHandler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("countdownHandler");
            }
            serviceCountdownHandler2.onActionDone();
            return 3;
        }
        boolean booleanValue = bool.booleanValue();
        ImageUploadServiceDelegate imageUploadServiceDelegate = this.delegate;
        if (imageUploadServiceDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        imageUploadServiceDelegate.start(stringExtra, stringExtra2, booleanValue).subscribe(new a(this), new b(this));
        return 3;
    }

    @Override // com.avito.android.service.ServiceCountdownHandler.Listener
    public void onStop(int i) {
        stopForeground(true);
        stopSelf(i);
    }

    public final void setCountdownHandler(@NotNull ServiceCountdownHandler serviceCountdownHandler) {
        Intrinsics.checkNotNullParameter(serviceCountdownHandler, "<set-?>");
        this.countdownHandler = serviceCountdownHandler;
    }

    public final void setDelegate(@NotNull ImageUploadServiceDelegate imageUploadServiceDelegate) {
        Intrinsics.checkNotNullParameter(imageUploadServiceDelegate, "<set-?>");
        this.delegate = imageUploadServiceDelegate;
    }
}
