package com.avito.android.home.appending_item.retry;

import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/home/appending_item/retry/AppendingRetryItemPresenterImpl;", "Lcom/avito/android/home/appending_item/retry/AppendingRetryItemPresenter;", "Lcom/avito/android/home/appending_item/retry/AppendingRetryItemView;", "view", "Lcom/avito/android/home/appending_item/retry/AppendingRetryItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/home/appending_item/retry/AppendingRetryItemView;Lcom/avito/android/home/appending_item/retry/AppendingRetryItem;I)V", "Lcom/avito/android/home/appending_item/retry/RetryItemsLoadingListener;", "retryListener", "setRetryListener", "(Lcom/avito/android/home/appending_item/retry/RetryItemsLoadingListener;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/home/appending_item/retry/RetryItemsLoadingListener;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class AppendingRetryItemPresenterImpl implements AppendingRetryItemPresenter {
    public RetryItemsLoadingListener a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AppendingRetryItemPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AppendingRetryItemPresenterImpl appendingRetryItemPresenterImpl) {
            super(0);
            this.a = appendingRetryItemPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            AppendingRetryItemPresenterImpl.access$getRetryListener$p(this.a).retryItemsLoading();
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ RetryItemsLoadingListener access$getRetryListener$p(AppendingRetryItemPresenterImpl appendingRetryItemPresenterImpl) {
        RetryItemsLoadingListener retryItemsLoadingListener = appendingRetryItemPresenterImpl.a;
        if (retryItemsLoadingListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retryListener");
        }
        return retryItemsLoadingListener;
    }

    @Override // com.avito.android.home.appending_item.retry.AppendingRetryItemPresenter
    public void setRetryListener(@NotNull RetryItemsLoadingListener retryItemsLoadingListener) {
        Intrinsics.checkNotNullParameter(retryItemsLoadingListener, "retryListener");
        this.a = retryItemsLoadingListener;
    }

    public void bindView(@NotNull AppendingRetryItemView appendingRetryItemView, @NotNull AppendingRetryItem appendingRetryItem, int i) {
        Intrinsics.checkNotNullParameter(appendingRetryItemView, "view");
        Intrinsics.checkNotNullParameter(appendingRetryItem, "item");
        appendingRetryItemView.setRetryClickListener(new a(this));
    }
}
