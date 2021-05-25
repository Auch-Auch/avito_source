package com.avito.android.user_adverts.items_search.advert_list.suggests;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_adverts.items_search.SuggestItemListener;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestItemView;", "Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestItemView;Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestItem;I)V", "Lcom/avito/android/user_adverts/items_search/SuggestItemListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_adverts/items_search/SuggestItemListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/avito/android/user_adverts/items_search/SuggestItemListener;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestItemPresenter implements ItemPresenter<SuggestItemView, SuggestItem> {
    public final SuggestItemListener a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SuggestItemPresenter a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SuggestItemPresenter suggestItemPresenter, String str, int i) {
            super(0);
            this.a = suggestItemPresenter;
            this.b = str;
            this.c = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.onSuggestClicked(this.b, this.c);
            return Unit.INSTANCE;
        }
    }

    public SuggestItemPresenter(@NotNull SuggestItemListener suggestItemListener) {
        Intrinsics.checkNotNullParameter(suggestItemListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = suggestItemListener;
    }

    public void bindView(@NotNull SuggestItemView suggestItemView, @NotNull SuggestItem suggestItem, int i) {
        Intrinsics.checkNotNullParameter(suggestItemView, "view");
        Intrinsics.checkNotNullParameter(suggestItem, "item");
        String text = suggestItem.getText();
        suggestItemView.setClickListener(new a(this, text, i));
        suggestItemView.setTitle(text);
    }
}
