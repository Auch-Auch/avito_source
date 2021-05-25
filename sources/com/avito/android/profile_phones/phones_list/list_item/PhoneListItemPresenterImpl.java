package com.avito.android.profile_phones.phones_list.list_item;

import com.avito.android.profile_phones.phones_list.list_item.PhoneListItem;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItemView;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0010\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\u00040\u000bj\u0002`\f¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR \u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\u00040\u000bj\u0002`\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemPresenterImpl;", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemPresenter;", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemView;", "view", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemView;Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemClickConsumer;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clickConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneListItemPresenterImpl implements PhoneListItemPresenter {
    public final Consumer<PhoneListItem> a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PhoneListItem.Status.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[2] = 2;
            iArr[0] = 3;
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PhoneListItemPresenterImpl a;
        public final /* synthetic */ PhoneListItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PhoneListItemPresenterImpl phoneListItemPresenterImpl, PhoneListItem phoneListItem) {
            super(0);
            this.a = phoneListItemPresenterImpl;
            this.b = phoneListItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public PhoneListItemPresenterImpl(@NotNull Consumer<PhoneListItem> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clickConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull PhoneListItemView phoneListItemView, @NotNull PhoneListItem phoneListItem, int i) {
        PhoneListItemView.StatusType statusType;
        Intrinsics.checkNotNullParameter(phoneListItemView, "view");
        Intrinsics.checkNotNullParameter(phoneListItem, "item");
        phoneListItemView.setPhone(phoneListItem.getPhone());
        phoneListItemView.setUsageText(phoneListItem.getUsageText());
        if (phoneListItem.getStatusText() == null) {
            phoneListItemView.hideStatus();
        } else {
            String statusText = phoneListItem.getStatusText();
            int ordinal = phoneListItem.getStatus().ordinal();
            if (ordinal == 0) {
                statusType = PhoneListItemView.StatusType.ORANGE;
            } else if (ordinal == 1) {
                statusType = PhoneListItemView.StatusType.NONE;
            } else if (ordinal == 2) {
                statusType = PhoneListItemView.StatusType.RED;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            phoneListItemView.setStatus(statusText, statusType);
        }
        phoneListItemView.setClickListener(new a(this, phoneListItem));
        phoneListItemView.setActionsIconVisible(!phoneListItem.getActions().isEmpty());
    }
}
