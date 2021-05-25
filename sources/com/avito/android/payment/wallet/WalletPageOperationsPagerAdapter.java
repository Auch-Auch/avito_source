package com.avito.android.payment.wallet;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.avito.android.payment.wallet.history.PaymentHistoryFragment;
import com.avito.android.payment.wallet.history.PaymentHistoryFragmentKt;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010$\u001a\u00020#\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/avito/android/payment/wallet/WalletPageOperationsPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", VKApiConst.POSITION, "Landroidx/fragment/app/Fragment;", "getItem", "(I)Landroidx/fragment/app/Fragment;", "Landroid/view/ViewGroup;", "container", "", "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "object", "", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "getCount", "()I", "", "getPageTitle", "(I)Ljava/lang/CharSequence;", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/payment/wallet/TabItem;", "k", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabs", "Landroid/util/SparseArray;", "Lcom/avito/android/payment/wallet/history/PaymentHistoryFragment;", "j", "Landroid/util/SparseArray;", "getFragments", "()Landroid/util/SparseArray;", "setFragments", "(Landroid/util/SparseArray;)V", "fragments", "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Landroidx/fragment/app/FragmentManager;Lcom/avito/android/ui/adapter/tab/TabsDataProvider;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class WalletPageOperationsPagerAdapter extends FragmentStatePagerAdapter {
    @NotNull
    public SparseArray<PaymentHistoryFragment> j = new SparseArray<>();
    public final TabsDataProvider<TabItem> k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletPageOperationsPagerAdapter(@NotNull FragmentManager fragmentManager, @NotNull TabsDataProvider<TabItem> tabsDataProvider) {
        super(fragmentManager);
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabs");
        this.k = tabsDataProvider;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup viewGroup, int i, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(obj, "object");
        this.j.remove(i);
        super.destroyItem(viewGroup, i, obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.k.getCount();
    }

    @NotNull
    public final SparseArray<PaymentHistoryFragment> getFragments() {
        return this.j;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public Fragment getItem(int i) {
        return PaymentHistoryFragmentKt.createPaymentHistoryFragment(this.k.getItem(i).getShortcut());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int i) {
        return this.k.getItem(i).getTitle();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Object instantiateItem = super.instantiateItem(viewGroup, i);
        Objects.requireNonNull(instantiateItem, "null cannot be cast to non-null type com.avito.android.payment.wallet.history.PaymentHistoryFragment");
        PaymentHistoryFragment paymentHistoryFragment = (PaymentHistoryFragment) instantiateItem;
        this.j.put(i, paymentHistoryFragment);
        return paymentHistoryFragment;
    }

    public final void setFragments(@NotNull SparseArray<PaymentHistoryFragment> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "<set-?>");
        this.j = sparseArray;
    }
}
