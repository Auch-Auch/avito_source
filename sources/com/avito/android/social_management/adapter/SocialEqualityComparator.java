package com.avito.android.social_management.adapter;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.recycler.data_aware.EqualityComparator;
import com.avito.android.social_management.adapter.SocialItem;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/social_management/adapter/SocialEqualityComparator;", "Lcom/avito/android/recycler/data_aware/EqualityComparator;", "Lcom/avito/konveyor/blueprint/Item;", InternalConstsKt.FIRST_IMAGE, "second", "", "isEqual", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Z", "<init>", "()V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public final class SocialEqualityComparator implements EqualityComparator {
    @Override // com.avito.android.recycler.data_aware.EqualityComparator
    public boolean isEqual(@Nullable Item item, @Nullable Item item2) {
        boolean z = item instanceof SocialItem.Available;
        if (z && (item2 instanceof SocialItem.Available)) {
            return Intrinsics.areEqual(((SocialItem.Available) item).getSocial().getType(), ((SocialItem.Available) item2).getSocial().getType());
        }
        boolean z2 = item instanceof SocialItem.Connected;
        if (z2 && (item2 instanceof SocialItem.Connected)) {
            return Intrinsics.areEqual(((SocialItem.Connected) item).getSocial().getType(), ((SocialItem.Connected) item2).getSocial().getType());
        }
        if (z2 && (item2 instanceof SocialItem.Available)) {
            return Intrinsics.areEqual(((SocialItem.Connected) item).getSocial().getType(), ((SocialItem.Available) item2).getSocial().getType());
        }
        if (z && (item2 instanceof SocialItem.Connected)) {
            return Intrinsics.areEqual(((SocialItem.Available) item).getSocial().getType(), ((SocialItem.Connected) item2).getSocial().getType());
        }
        if ((item instanceof SocialItem.Header) && (item2 instanceof SocialItem.Header)) {
            return Intrinsics.areEqual(((SocialItem.Header) item).getTitle(), ((SocialItem.Header) item2).getTitle());
        }
        if (!(item instanceof SocialItem.Notification) || !(item2 instanceof SocialItem.Notification)) {
            return false;
        }
        return Intrinsics.areEqual(((SocialItem.Notification) item).getStringId(), ((SocialItem.Notification) item2).getStringId());
    }
}
