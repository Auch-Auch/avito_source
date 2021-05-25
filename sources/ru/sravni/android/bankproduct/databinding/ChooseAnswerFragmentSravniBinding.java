package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IButtonAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ICreditDetailAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ICreditOffersAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IFreeTextAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IGoToDashboardAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IMaskTextAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IOsagoOffersAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IOsagoOrderAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISliderAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISuggestionAnswerViewModel;
public abstract class ChooseAnswerFragmentSravniBinding extends ViewDataBinding {
    @Bindable
    public IButtonAnswerViewModel mButtonAnswerViewModel;
    @Bindable
    public IChatViewModel mChatViewModel;
    @Bindable
    public ICreditDetailAnswerViewModel mCreditDetailAnswerViewModel;
    @Bindable
    public ICreditOffersAnswerViewModel mCreditOffersAnswerViewModel;
    @Bindable
    public IFreeTextAnswerViewModel mFreeTextAnswerViewModel;
    @Bindable
    public IGoToDashboardAnswerViewModel mGoToDashboardAnswerViewModel;
    @Bindable
    public IMaskTextAnswerViewModel mMaskTextAnswerViewModel;
    @Bindable
    public IOsagoOffersAnswerViewModel mOsagoOffersAnswerViewModel;
    @Bindable
    public IOsagoOrderAnswerViewModel mOsagoOrderAnswerViewModel;
    @Bindable
    public IPassportScanAnswerViewModel mPassportScanAnswerViewModel;
    @Bindable
    public ISliderAnswerViewModel mSliderAnswerViewModel;
    @Bindable
    public ISuggestionAnswerViewModel mSuggestionAnswerViewModel;

    public ChooseAnswerFragmentSravniBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChooseAnswerFragmentSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChooseAnswerFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IButtonAnswerViewModel getButtonAnswerViewModel() {
        return this.mButtonAnswerViewModel;
    }

    @Nullable
    public IChatViewModel getChatViewModel() {
        return this.mChatViewModel;
    }

    @Nullable
    public ICreditDetailAnswerViewModel getCreditDetailAnswerViewModel() {
        return this.mCreditDetailAnswerViewModel;
    }

    @Nullable
    public ICreditOffersAnswerViewModel getCreditOffersAnswerViewModel() {
        return this.mCreditOffersAnswerViewModel;
    }

    @Nullable
    public IFreeTextAnswerViewModel getFreeTextAnswerViewModel() {
        return this.mFreeTextAnswerViewModel;
    }

    @Nullable
    public IGoToDashboardAnswerViewModel getGoToDashboardAnswerViewModel() {
        return this.mGoToDashboardAnswerViewModel;
    }

    @Nullable
    public IMaskTextAnswerViewModel getMaskTextAnswerViewModel() {
        return this.mMaskTextAnswerViewModel;
    }

    @Nullable
    public IOsagoOffersAnswerViewModel getOsagoOffersAnswerViewModel() {
        return this.mOsagoOffersAnswerViewModel;
    }

    @Nullable
    public IOsagoOrderAnswerViewModel getOsagoOrderAnswerViewModel() {
        return this.mOsagoOrderAnswerViewModel;
    }

    @Nullable
    public IPassportScanAnswerViewModel getPassportScanAnswerViewModel() {
        return this.mPassportScanAnswerViewModel;
    }

    @Nullable
    public ISliderAnswerViewModel getSliderAnswerViewModel() {
        return this.mSliderAnswerViewModel;
    }

    @Nullable
    public ISuggestionAnswerViewModel getSuggestionAnswerViewModel() {
        return this.mSuggestionAnswerViewModel;
    }

    public abstract void setButtonAnswerViewModel(@Nullable IButtonAnswerViewModel iButtonAnswerViewModel);

    public abstract void setChatViewModel(@Nullable IChatViewModel iChatViewModel);

    public abstract void setCreditDetailAnswerViewModel(@Nullable ICreditDetailAnswerViewModel iCreditDetailAnswerViewModel);

    public abstract void setCreditOffersAnswerViewModel(@Nullable ICreditOffersAnswerViewModel iCreditOffersAnswerViewModel);

    public abstract void setFreeTextAnswerViewModel(@Nullable IFreeTextAnswerViewModel iFreeTextAnswerViewModel);

    public abstract void setGoToDashboardAnswerViewModel(@Nullable IGoToDashboardAnswerViewModel iGoToDashboardAnswerViewModel);

    public abstract void setMaskTextAnswerViewModel(@Nullable IMaskTextAnswerViewModel iMaskTextAnswerViewModel);

    public abstract void setOsagoOffersAnswerViewModel(@Nullable IOsagoOffersAnswerViewModel iOsagoOffersAnswerViewModel);

    public abstract void setOsagoOrderAnswerViewModel(@Nullable IOsagoOrderAnswerViewModel iOsagoOrderAnswerViewModel);

    public abstract void setPassportScanAnswerViewModel(@Nullable IPassportScanAnswerViewModel iPassportScanAnswerViewModel);

    public abstract void setSliderAnswerViewModel(@Nullable ISliderAnswerViewModel iSliderAnswerViewModel);

    public abstract void setSuggestionAnswerViewModel(@Nullable ISuggestionAnswerViewModel iSuggestionAnswerViewModel);

    @Deprecated
    public static ChooseAnswerFragmentSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ChooseAnswerFragmentSravniBinding) ViewDataBinding.bind(obj, view, R.layout.choose_answer_fragment_sravni);
    }

    @NonNull
    @Deprecated
    public static ChooseAnswerFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChooseAnswerFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.choose_answer_fragment_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static ChooseAnswerFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChooseAnswerFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChooseAnswerFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.choose_answer_fragment_sravni, null, false, obj);
    }
}
