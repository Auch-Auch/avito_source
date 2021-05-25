package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatViewModel;
public abstract class CreditOfferItemSravniBinding extends ViewDataBinding {
    @Bindable
    public IChatViewModel mChatViewModel;
    @NonNull
    public final TextView tvInterestRate;
    @NonNull
    public final TextView tvNameBank;
    @NonNull
    public final TextView tvNameCredit;
    @NonNull
    public final TextView tvPayment;
    @NonNull
    public final TextView tvPaymentRub;
    @NonNull
    public final TextView tvRate;

    public CreditOfferItemSravniBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.tvInterestRate = textView;
        this.tvNameBank = textView2;
        this.tvNameCredit = textView3;
        this.tvPayment = textView4;
        this.tvPaymentRub = textView5;
        this.tvRate = textView6;
    }

    public static CreditOfferItemSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CreditOfferItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IChatViewModel getChatViewModel() {
        return this.mChatViewModel;
    }

    public abstract void setChatViewModel(@Nullable IChatViewModel iChatViewModel);

    @Deprecated
    public static CreditOfferItemSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (CreditOfferItemSravniBinding) ViewDataBinding.bind(obj, view, R.layout.credit_offer_item_sravni);
    }

    @NonNull
    @Deprecated
    public static CreditOfferItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CreditOfferItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.credit_offer_item_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static CreditOfferItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CreditOfferItemSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CreditOfferItemSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.credit_offer_item_sravni, null, false, obj);
    }
}
