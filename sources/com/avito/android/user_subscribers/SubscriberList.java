package com.avito.android.user_subscribers;

import a2.b.a.a.a;
import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_subscribers.adapter.UserSubscriberItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/user_subscribers/SubscriberList;", "", "", "Lcom/avito/android/user_subscribers/adapter/UserSubscriberItem;", "component1", "()Ljava/util/List;", "Landroid/net/Uri;", "component2", "()Landroid/net/Uri;", "items", "nextPage", "copy", "(Ljava/util/List;Landroid/net/Uri;)Lcom/avito/android/user_subscribers/SubscriberList;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getItems", AuthSource.BOOKING_ORDER, "Landroid/net/Uri;", "getNextPage", "<init>", "(Ljava/util/List;Landroid/net/Uri;)V", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
public final class SubscriberList {
    @NotNull
    public final List<UserSubscriberItem> a;
    @Nullable
    public final Uri b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.user_subscribers.adapter.UserSubscriberItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public SubscriberList(@NotNull List<? extends UserSubscriberItem> list, @Nullable Uri uri) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.a = list;
        this.b = uri;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.user_subscribers.SubscriberList */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubscriberList copy$default(SubscriberList subscriberList, List list, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            list = subscriberList.a;
        }
        if ((i & 2) != 0) {
            uri = subscriberList.b;
        }
        return subscriberList.copy(list, uri);
    }

    @NotNull
    public final List<UserSubscriberItem> component1() {
        return this.a;
    }

    @Nullable
    public final Uri component2() {
        return this.b;
    }

    @NotNull
    public final SubscriberList copy(@NotNull List<? extends UserSubscriberItem> list, @Nullable Uri uri) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new SubscriberList(list, uri);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriberList)) {
            return false;
        }
        SubscriberList subscriberList = (SubscriberList) obj;
        return Intrinsics.areEqual(this.a, subscriberList.a) && Intrinsics.areEqual(this.b, subscriberList.b);
    }

    @NotNull
    public final List<UserSubscriberItem> getItems() {
        return this.a;
    }

    @Nullable
    public final Uri getNextPage() {
        return this.b;
    }

    public int hashCode() {
        List<UserSubscriberItem> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Uri uri = this.b;
        if (uri != null) {
            i = uri.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SubscriberList(items=");
        L.append(this.a);
        L.append(", nextPage=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
