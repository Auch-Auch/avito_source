package com.avito.android.user_subscribers;

import a2.b.a.a.a;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.subscriber.UserSubscribersResult;
import com.avito.android.remote.model.subscriber.UserSubscribersResultItem;
import com.avito.android.user_subscribers.adapter.subscriber.SubscriberItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/user_subscribers/UserSubscribersConverterImpl;", "Lcom/avito/android/user_subscribers/UserSubscribersConverter;", "Lcom/avito/android/remote/model/subscriber/UserSubscribersResult;", "result", "Lcom/avito/android/user_subscribers/SubscriberList;", "convert", "(Lcom/avito/android/remote/model/subscriber/UserSubscribersResult;)Lcom/avito/android/user_subscribers/SubscriberList;", "<init>", "()V", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
public final class UserSubscribersConverterImpl implements UserSubscribersConverter {
    @Override // com.avito.android.user_subscribers.UserSubscribersConverter
    @NotNull
    public SubscriberList convert(@NotNull UserSubscribersResult userSubscribersResult) {
        SubscriberItem subscriberItem;
        Intrinsics.checkNotNullParameter(userSubscribersResult, "result");
        List<UserSubscribersResultItem> list = userSubscribersResult.getList();
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if (t2 instanceof com.avito.android.remote.model.subscriber.SubscriberItem) {
                String M2 = a.M2("subscriber_item_", i);
                T t3 = t2;
                String name = t3.getName();
                Image avatar = t3.getAvatar();
                String description = t3.getDescription();
                Boolean isShop = t3.isShop();
                subscriberItem = new SubscriberItem(M2, name, avatar, description, isShop != null ? isShop.booleanValue() : false, t3.getDeepLink());
            } else {
                subscriberItem = null;
            }
            if (subscriberItem != null) {
                arrayList.add(subscriberItem);
            }
            i = i2;
        }
        return new SubscriberList(arrayList, userSubscribersResult.getNextPage());
    }
}
