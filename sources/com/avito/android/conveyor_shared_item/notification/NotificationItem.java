package com.avito.android.conveyor_shared_item.notification;

import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u001fB\u001f\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e¨\u0006 "}, d2 = {"Lcom/avito/android/conveyor_shared_item/notification/NotificationItem;", "Lcom/avito/conveyor_item/Item;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "c", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "type", "", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", AuthSource.SEND_ABUSE, "getStringId", "stringId", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;)V", "NotificationType", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public CharSequence b;
    @NotNull
    public String c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/conveyor_shared_item/notification/NotificationItem$NotificationType;", "", "<init>", "()V", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface NotificationType {
    }

    public NotificationItem(@NotNull String str, @NotNull CharSequence charSequence, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(str2, "type");
        this.a = str;
        this.b = charSequence;
        this.c = str2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof NotificationItem) && getId() == ((NotificationItem) obj).getId()) {
            return true;
        }
        return false;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final CharSequence getText() {
        return this.b;
    }

    @NotNull
    public final String getType() {
        return this.c;
    }

    public int hashCode() {
        return c.a(getId());
    }

    public final void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        this.b = charSequence;
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }
}
