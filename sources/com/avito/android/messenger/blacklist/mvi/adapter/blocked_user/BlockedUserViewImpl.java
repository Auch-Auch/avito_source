package com.avito.android.messenger.blacklist.mvi.adapter.blocked_user;

import android.view.View;
import android.widget.TextView;
import com.avito.android.messenger.R;
import com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.BlockedUserView;
import com.avito.android.remote.model.Sort;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010.\u001a\u00020\u001d¢\u0006\u0004\b/\u00100J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010 \u001a\n \u0019*\u0004\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010\"\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u001e\u0010$\u001a\n \u0019*\u0004\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001fR\u001e\u0010&\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001bR\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010+\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010\u001bR\u001e\u0010-\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010\u001b¨\u00061"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/adapter/blocked_user/BlockedUserViewImpl;", "Lcom/avito/android/messenger/blacklist/mvi/adapter/blocked_user/BlockedUserView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", Sort.DATE, "", "setDate", "(Ljava/lang/CharSequence;)V", "name", "setUserName", "title", "setItemTitle", "category", "setItemCategory", "price", "setItemPrice", "", "inProgress", "setInProgress", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnUnblockClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "t", "Landroid/widget/TextView;", "userNameView", "Landroid/view/View;", "y", "Landroid/view/View;", "progressView", "s", "dateView", "x", "unblockButton", "w", "itemPriceView", "z", "Lkotlin/jvm/functions/Function0;", "onUnblockClickListener", VKApiConst.VERSION, "itemCategoryView", "u", "itemTitleView", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlockedUserViewImpl extends BaseViewHolder implements BlockedUserView {
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final View x;
    public final View y;
    public Function0<Unit> z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BlockedUserViewImpl a;

        public a(BlockedUserViewImpl blockedUserViewImpl) {
            this.a = blockedUserViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a.z;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlockedUserViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view.findViewById(R.id.blocked_user_date);
        this.t = (TextView) view.findViewById(R.id.blocked_user_name);
        this.u = (TextView) view.findViewById(R.id.blocked_user_item_title);
        this.v = (TextView) view.findViewById(R.id.blocked_user_item_category);
        this.w = (TextView) view.findViewById(R.id.blocked_user_item_price);
        View findViewById = view.findViewById(R.id.blocked_user_unblock_button);
        this.x = findViewById;
        this.y = view.findViewById(R.id.blocked_user_unblocking_progress);
        findViewById.setOnClickListener(new a(this));
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        BlockedUserView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.BlockedUserView
    public void setDate(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, Sort.DATE);
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "dateView");
        textView.setText(charSequence);
    }

    @Override // com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.BlockedUserView
    public void setInProgress(boolean z2) {
        if (z2) {
            Views.hide(this.x);
            Views.show(this.y);
            return;
        }
        Views.hide(this.y);
        Views.show(this.x);
    }

    @Override // com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.BlockedUserView
    public void setItemCategory(@Nullable CharSequence charSequence) {
        TextView textView = this.v;
        Intrinsics.checkNotNullExpressionValue(textView, "itemCategoryView");
        TextViews.bindText$default(textView, charSequence, false, 2, null);
    }

    @Override // com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.BlockedUserView
    public void setItemPrice(@Nullable CharSequence charSequence) {
        TextView textView = this.w;
        Intrinsics.checkNotNullExpressionValue(textView, "itemPriceView");
        TextViews.bindText$default(textView, charSequence, false, 2, null);
    }

    @Override // com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.BlockedUserView
    public void setItemTitle(@Nullable CharSequence charSequence) {
        TextView textView = this.u;
        Intrinsics.checkNotNullExpressionValue(textView, "itemTitleView");
        TextViews.bindText$default(textView, charSequence, false, 2, null);
    }

    @Override // com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.BlockedUserView
    public void setOnUnblockClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.z = function0;
    }

    @Override // com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.BlockedUserView
    public void setUserName(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "name");
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "userNameView");
        textView.setText(charSequence);
    }
}
