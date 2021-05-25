package com.avito.android.safedeal.profile_settings.konveyor.list_item;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.remote.model.ProfileDeliverySettings;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/konveyor/list_item/ListItemPresenterImpl;", "Lcom/avito/android/safedeal/profile_settings/konveyor/list_item/ListItemPresenter;", "Lcom/avito/android/safedeal/profile_settings/konveyor/list_item/ListItemView;", "view", "Lcom/avito/android/safedeal/profile_settings/konveyor/list_item/ListItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/safedeal/profile_settings/konveyor/list_item/ListItemView;Lcom/avito/android/safedeal/profile_settings/konveyor/list_item/ListItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "linkClicksConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class ListItemPresenterImpl implements ListItemPresenter {
    public final Consumer<DeepLink> a;

    public ListItemPresenterImpl(@NotNull Consumer<DeepLink> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "linkClicksConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull ListItemView listItemView, @NotNull ListItem listItem, int i) {
        Intrinsics.checkNotNullParameter(listItemView, "view");
        Intrinsics.checkNotNullParameter(listItem, "item");
        listItemView.setTitle(listItem.getTitle());
        listItemView.setSubtitle(listItem.getSubtitle());
        listItemView.setImageDrawable(listItem.getImageRes());
        ProfileDeliverySettings.Service.Content.Link link = listItem.getLink();
        if (link != null) {
            listItemView.setLink(link.getText(), link.getDeepLink(), new Function1<DeepLink, Unit>(this.a) { // from class: com.avito.android.safedeal.profile_settings.konveyor.list_item.ListItemPresenterImpl.a
                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(DeepLink deepLink) {
                    ((Consumer) this.receiver).accept(deepLink);
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
