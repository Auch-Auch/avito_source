package ru.sravni.android.bankproduct.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerCardTypeDomain;
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
public class ChooseAnswerFragmentSravniBindingImpl extends ChooseAnswerFragmentSravniBinding {
    @Nullable
    public static final ViewDataBinding.IncludedLayouts L;
    @Nullable
    public final CloseChatAnswerLayoutSravniBinding A;
    @Nullable
    public final CreditDetailAnswerLayoutSravniBinding B;
    @Nullable
    public final SliderAnswerLayoutSravniBinding C;
    @Nullable
    public final FreeTextAnswerLayoutSravniBinding D;
    @Nullable
    public final SuggestTextAnswerSravniBinding E;
    @Nullable
    public final MaskTextAnswerLayoutSravniBinding F;
    @Nullable
    public final PassportAnswerLayoutSravniBinding G;
    @Nullable
    public final CreditOffersAnswerLayoutSravniBinding H;
    @Nullable
    public final OsagoOffersAnswerLayoutSravniBinding I;
    @Nullable
    public final OsagoOrderAnswerLayoutSravniBinding J;
    public long K = -1;
    @Nullable
    public final ButtonAnswerLayoutSravniBinding y;
    @NonNull
    public final FrameLayout z;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(12);
        L = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"button_answer_layout_sravni", "slider_answer_layout_sravni", "free_text_answer_layout_sravni", "suggest_text_answer_sravni", "mask_text_answer_layout_sravni", "passport_answer_layout_sravni", "credit_offers_answer_layout_sravni", "osago_offers_answer_layout_sravni", "osago_order_answer_layout_sravni", "close_chat_answer_layout_sravni", "credit_detail_answer_layout_sravni"}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, new int[]{R.layout.button_answer_layout_sravni, R.layout.slider_answer_layout_sravni, R.layout.free_text_answer_layout_sravni, R.layout.suggest_text_answer_sravni, R.layout.mask_text_answer_layout_sravni, R.layout.passport_answer_layout_sravni, R.layout.credit_offers_answer_layout_sravni, R.layout.osago_offers_answer_layout_sravni, R.layout.osago_order_answer_layout_sravni, R.layout.close_chat_answer_layout_sravni, R.layout.credit_detail_answer_layout_sravni});
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChooseAnswerFragmentSravniBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        super(dataBindingComponent, view, 1);
        Object[] mapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 12, L, (SparseIntArray) null);
        ButtonAnswerLayoutSravniBinding buttonAnswerLayoutSravniBinding = (ButtonAnswerLayoutSravniBinding) mapBindings[1];
        this.y = buttonAnswerLayoutSravniBinding;
        setContainedBinding(buttonAnswerLayoutSravniBinding);
        FrameLayout frameLayout = (FrameLayout) mapBindings[0];
        this.z = frameLayout;
        frameLayout.setTag(null);
        CloseChatAnswerLayoutSravniBinding closeChatAnswerLayoutSravniBinding = (CloseChatAnswerLayoutSravniBinding) mapBindings[10];
        this.A = closeChatAnswerLayoutSravniBinding;
        setContainedBinding(closeChatAnswerLayoutSravniBinding);
        CreditDetailAnswerLayoutSravniBinding creditDetailAnswerLayoutSravniBinding = (CreditDetailAnswerLayoutSravniBinding) mapBindings[11];
        this.B = creditDetailAnswerLayoutSravniBinding;
        setContainedBinding(creditDetailAnswerLayoutSravniBinding);
        SliderAnswerLayoutSravniBinding sliderAnswerLayoutSravniBinding = (SliderAnswerLayoutSravniBinding) mapBindings[2];
        this.C = sliderAnswerLayoutSravniBinding;
        setContainedBinding(sliderAnswerLayoutSravniBinding);
        FreeTextAnswerLayoutSravniBinding freeTextAnswerLayoutSravniBinding = (FreeTextAnswerLayoutSravniBinding) mapBindings[3];
        this.D = freeTextAnswerLayoutSravniBinding;
        setContainedBinding(freeTextAnswerLayoutSravniBinding);
        SuggestTextAnswerSravniBinding suggestTextAnswerSravniBinding = (SuggestTextAnswerSravniBinding) mapBindings[4];
        this.E = suggestTextAnswerSravniBinding;
        setContainedBinding(suggestTextAnswerSravniBinding);
        MaskTextAnswerLayoutSravniBinding maskTextAnswerLayoutSravniBinding = (MaskTextAnswerLayoutSravniBinding) mapBindings[5];
        this.F = maskTextAnswerLayoutSravniBinding;
        setContainedBinding(maskTextAnswerLayoutSravniBinding);
        PassportAnswerLayoutSravniBinding passportAnswerLayoutSravniBinding = (PassportAnswerLayoutSravniBinding) mapBindings[6];
        this.G = passportAnswerLayoutSravniBinding;
        setContainedBinding(passportAnswerLayoutSravniBinding);
        CreditOffersAnswerLayoutSravniBinding creditOffersAnswerLayoutSravniBinding = (CreditOffersAnswerLayoutSravniBinding) mapBindings[7];
        this.H = creditOffersAnswerLayoutSravniBinding;
        setContainedBinding(creditOffersAnswerLayoutSravniBinding);
        OsagoOffersAnswerLayoutSravniBinding osagoOffersAnswerLayoutSravniBinding = (OsagoOffersAnswerLayoutSravniBinding) mapBindings[8];
        this.I = osagoOffersAnswerLayoutSravniBinding;
        setContainedBinding(osagoOffersAnswerLayoutSravniBinding);
        OsagoOrderAnswerLayoutSravniBinding osagoOrderAnswerLayoutSravniBinding = (OsagoOrderAnswerLayoutSravniBinding) mapBindings[9];
        this.J = osagoOrderAnswerLayoutSravniBinding;
        setContainedBinding(osagoOrderAnswerLayoutSravniBinding);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        IChatViewModel iChatViewModel;
        IGoToDashboardAnswerViewModel iGoToDashboardAnswerViewModel;
        ICreditDetailAnswerViewModel iCreditDetailAnswerViewModel;
        ISliderAnswerViewModel iSliderAnswerViewModel;
        IFreeTextAnswerViewModel iFreeTextAnswerViewModel;
        ISuggestionAnswerViewModel iSuggestionAnswerViewModel;
        IMaskTextAnswerViewModel iMaskTextAnswerViewModel;
        IPassportScanAnswerViewModel iPassportScanAnswerViewModel;
        ICreditOffersAnswerViewModel iCreditOffersAnswerViewModel;
        IOsagoOffersAnswerViewModel iOsagoOffersAnswerViewModel;
        IOsagoOrderAnswerViewModel iOsagoOrderAnswerViewModel;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z2;
        int i6;
        int i7;
        int i8;
        AnswerCardTypeDomain answerCardTypeDomain;
        int i9;
        int i10;
        int i11;
        LiveData<AnswerCardTypeDomain> liveData;
        synchronized (this) {
            j = this.K;
            this.K = 0;
        }
        ISliderAnswerViewModel iSliderAnswerViewModel2 = this.mSliderAnswerViewModel;
        ICreditOffersAnswerViewModel iCreditOffersAnswerViewModel2 = this.mCreditOffersAnswerViewModel;
        IFreeTextAnswerViewModel iFreeTextAnswerViewModel2 = this.mFreeTextAnswerViewModel;
        IPassportScanAnswerViewModel iPassportScanAnswerViewModel2 = this.mPassportScanAnswerViewModel;
        IOsagoOffersAnswerViewModel iOsagoOffersAnswerViewModel2 = this.mOsagoOffersAnswerViewModel;
        IChatViewModel iChatViewModel2 = this.mChatViewModel;
        IOsagoOrderAnswerViewModel iOsagoOrderAnswerViewModel2 = this.mOsagoOrderAnswerViewModel;
        IGoToDashboardAnswerViewModel iGoToDashboardAnswerViewModel2 = this.mGoToDashboardAnswerViewModel;
        IButtonAnswerViewModel iButtonAnswerViewModel = this.mButtonAnswerViewModel;
        IMaskTextAnswerViewModel iMaskTextAnswerViewModel2 = this.mMaskTextAnswerViewModel;
        ISuggestionAnswerViewModel iSuggestionAnswerViewModel2 = this.mSuggestionAnswerViewModel;
        ICreditDetailAnswerViewModel iCreditDetailAnswerViewModel2 = this.mCreditDetailAnswerViewModel;
        int i12 = 8;
        boolean z3 = true;
        int i13 = ((j & 8257) > 0 ? 1 : ((j & 8257) == 0 ? 0 : -1));
        if (i13 != 0) {
            if (iChatViewModel2 != null) {
                iOsagoOrderAnswerViewModel = iOsagoOrderAnswerViewModel2;
                liveData = iChatViewModel2.getTypeAnswer();
            } else {
                iOsagoOrderAnswerViewModel = iOsagoOrderAnswerViewModel2;
                liveData = null;
            }
            updateLiveDataRegistration(0, liveData);
            AnswerCardTypeDomain value = liveData != null ? liveData.getValue() : null;
            iOsagoOffersAnswerViewModel = iOsagoOffersAnswerViewModel2;
            boolean z4 = value == AnswerCardTypeDomain.MASK_TEXT;
            iCreditOffersAnswerViewModel = iCreditOffersAnswerViewModel2;
            boolean z5 = value == AnswerCardTypeDomain.CREDIT_DETAIL;
            iPassportScanAnswerViewModel = iPassportScanAnswerViewModel2;
            boolean z7 = value == AnswerCardTypeDomain.FREE_TEXT;
            iMaskTextAnswerViewModel = iMaskTextAnswerViewModel2;
            boolean z8 = value == AnswerCardTypeDomain.FINISHED;
            iSuggestionAnswerViewModel = iSuggestionAnswerViewModel2;
            boolean z9 = value == AnswerCardTypeDomain.SLIDER;
            iFreeTextAnswerViewModel = iFreeTextAnswerViewModel2;
            boolean z10 = value == AnswerCardTypeDomain.GO_TO_DASHBOARD;
            iSliderAnswerViewModel = iSliderAnswerViewModel2;
            boolean z11 = value == AnswerCardTypeDomain.PASSPORT_SCAN;
            iCreditDetailAnswerViewModel = iCreditDetailAnswerViewModel2;
            boolean z12 = value == AnswerCardTypeDomain.OSAGO_ORDER;
            iGoToDashboardAnswerViewModel = iGoToDashboardAnswerViewModel2;
            boolean z13 = value == AnswerCardTypeDomain.OSAGO_OFFERS;
            iChatViewModel = iChatViewModel2;
            boolean z14 = value == AnswerCardTypeDomain.SUGGESTION_TEXT;
            boolean z15 = value == AnswerCardTypeDomain.BUTTON;
            if (i13 != 0) {
                j |= z4 ? 8388608 : 4194304;
            }
            if ((j & 8257) != 0) {
                j |= z5 ? 33554432 : 16777216;
            }
            if ((j & 8257) != 0) {
                j |= z7 ? 134217728 : 67108864;
            }
            if ((j & 8257) != 0) {
                j = z8 ? j | 34359738368L : j | 17179869184L;
            }
            if ((j & 8257) != 0) {
                j |= z9 ? 2147483648L : 1073741824;
            }
            if ((j & 8257) != 0) {
                j |= z10 ? 536870912 : 268435456;
            }
            if ((j & 8257) != 0) {
                j |= z11 ? 8589934592L : 4294967296L;
            }
            if ((j & 8257) != 0) {
                j |= z12 ? 137438953472L : 68719476736L;
            }
            if ((j & 8257) != 0) {
                j |= z13 ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : 16384;
            }
            if ((j & 8257) != 0) {
                j |= z14 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            if ((j & 8257) != 0) {
                j |= z15 ? PlaybackStateCompat.ACTION_PREPARE_FROM_URI : PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            int i14 = z4 ? 0 : 8;
            int i15 = z5 ? 0 : 8;
            int i16 = z7 ? 0 : 8;
            i2 = z9 ? 0 : 8;
            i = z10 ? 0 : 8;
            int i17 = z11 ? 0 : 8;
            i10 = z12 ? 0 : 8;
            i9 = z13 ? 0 : 8;
            i3 = z14 ? 0 : 8;
            i8 = i14;
            answerCardTypeDomain = value;
            i4 = z15 ? 0 : 8;
            i5 = i15;
            z2 = z8;
            i6 = i17;
            i7 = i16;
        } else {
            iSliderAnswerViewModel = iSliderAnswerViewModel2;
            iCreditDetailAnswerViewModel = iCreditDetailAnswerViewModel2;
            iCreditOffersAnswerViewModel = iCreditOffersAnswerViewModel2;
            iFreeTextAnswerViewModel = iFreeTextAnswerViewModel2;
            iPassportScanAnswerViewModel = iPassportScanAnswerViewModel2;
            iOsagoOffersAnswerViewModel = iOsagoOffersAnswerViewModel2;
            iChatViewModel = iChatViewModel2;
            iOsagoOrderAnswerViewModel = iOsagoOrderAnswerViewModel2;
            iGoToDashboardAnswerViewModel = iGoToDashboardAnswerViewModel2;
            iMaskTextAnswerViewModel = iMaskTextAnswerViewModel2;
            iSuggestionAnswerViewModel = iSuggestionAnswerViewModel2;
            i10 = 0;
            i9 = 0;
            answerCardTypeDomain = null;
            i8 = 0;
            i7 = 0;
            i6 = 0;
            z2 = false;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        boolean z16 = (j & 17179869184L) != 0 && answerCardTypeDomain == AnswerCardTypeDomain.CREDIT_OFFERS;
        int i18 = ((j & 8257) > 0 ? 1 : ((j & 8257) == 0 ? 0 : -1));
        if (i18 != 0) {
            if (!z2) {
                z3 = z16;
            }
            if (i18 != 0) {
                j |= z3 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            if (z3) {
                i12 = 0;
            }
            i11 = i12;
        } else {
            i11 = 0;
        }
        if ((j & 8257) != 0) {
            this.y.getRoot().setVisibility(i4);
            this.A.getRoot().setVisibility(i);
            this.B.getRoot().setVisibility(i5);
            this.C.getRoot().setVisibility(i2);
            this.D.getRoot().setVisibility(i7);
            this.E.getRoot().setVisibility(i3);
            this.F.getRoot().setVisibility(i8);
            this.G.getRoot().setVisibility(i6);
            this.H.getRoot().setVisibility(i11);
            this.I.getRoot().setVisibility(i9);
            this.J.getRoot().setVisibility(i10);
        }
        if ((8704 & j) != 0) {
            this.y.setButtonAnswerViewModel(iButtonAnswerViewModel);
        }
        if ((8256 & j) != 0) {
            this.y.setNextContentCard(iChatViewModel);
            this.B.setNextContentCard(iChatViewModel);
            this.C.setNextContentCard(iChatViewModel);
            this.D.setNextContentCard(iChatViewModel);
            this.E.setNextContentCard(iChatViewModel);
            this.F.setNextContentCard(iChatViewModel);
            this.G.setNextContentCard(iChatViewModel);
            this.H.setNextContentCard(iChatViewModel);
            this.I.setNextContentCard(iChatViewModel);
            this.J.setNextContentCard(iChatViewModel);
        }
        if ((8448 & j) != 0) {
            this.A.setGoToDashboardAnswerViewModel(iGoToDashboardAnswerViewModel);
        }
        if ((12288 & j) != 0) {
            this.B.setCreditDetailAnswerViewModel(iCreditDetailAnswerViewModel);
        }
        if ((8194 & j) != 0) {
            this.C.setSliderAnswerViewModel(iSliderAnswerViewModel);
        }
        if ((8200 & j) != 0) {
            this.D.setFreeTextAnswerViewModel(iFreeTextAnswerViewModel);
        }
        if ((10240 & j) != 0) {
            this.E.setSuggestionAnswerViewModel(iSuggestionAnswerViewModel);
        }
        if ((9216 & j) != 0) {
            this.F.setMaskTextAnswerViewModel(iMaskTextAnswerViewModel);
        }
        if ((8208 & j) != 0) {
            this.G.setPassportScanAnswerViewModel(iPassportScanAnswerViewModel);
        }
        if ((8196 & j) != 0) {
            this.H.setCreditOffersAnswerViewModel(iCreditOffersAnswerViewModel);
        }
        if ((8224 & j) != 0) {
            this.I.setOsagoOffersAnswerViewModel(iOsagoOffersAnswerViewModel);
        }
        if ((j & 8320) != 0) {
            this.J.setOsagoOrderAnswerViewModel(iOsagoOrderAnswerViewModel);
        }
        ViewDataBinding.executeBindingsOn(this.y);
        ViewDataBinding.executeBindingsOn(this.C);
        ViewDataBinding.executeBindingsOn(this.D);
        ViewDataBinding.executeBindingsOn(this.E);
        ViewDataBinding.executeBindingsOn(this.F);
        ViewDataBinding.executeBindingsOn(this.G);
        ViewDataBinding.executeBindingsOn(this.H);
        ViewDataBinding.executeBindingsOn(this.I);
        ViewDataBinding.executeBindingsOn(this.J);
        ViewDataBinding.executeBindingsOn(this.A);
        ViewDataBinding.executeBindingsOn(this.B);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.K != 0) {
                return true;
            }
        }
        if (!this.y.hasPendingBindings() && !this.C.hasPendingBindings() && !this.D.hasPendingBindings() && !this.E.hasPendingBindings() && !this.F.hasPendingBindings() && !this.G.hasPendingBindings() && !this.H.hasPendingBindings() && !this.I.hasPendingBindings() && !this.J.hasPendingBindings() && !this.A.hasPendingBindings() && !this.B.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.K = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        this.y.invalidateAll();
        this.C.invalidateAll();
        this.D.invalidateAll();
        this.E.invalidateAll();
        this.F.invalidateAll();
        this.G.invalidateAll();
        this.H.invalidateAll();
        this.I.invalidateAll();
        this.J.invalidateAll();
        this.A.invalidateAll();
        this.B.invalidateAll();
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.K |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        LiveData liveData = (LiveData) obj;
        return j(i2);
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChooseAnswerFragmentSravniBinding
    public void setButtonAnswerViewModel(@Nullable IButtonAnswerViewModel iButtonAnswerViewModel) {
        this.mButtonAnswerViewModel = iButtonAnswerViewModel;
        synchronized (this) {
            this.K |= 512;
        }
        notifyPropertyChanged(BR.buttonAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChooseAnswerFragmentSravniBinding
    public void setChatViewModel(@Nullable IChatViewModel iChatViewModel) {
        this.mChatViewModel = iChatViewModel;
        synchronized (this) {
            this.K |= 64;
        }
        notifyPropertyChanged(BR.chatViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChooseAnswerFragmentSravniBinding
    public void setCreditDetailAnswerViewModel(@Nullable ICreditDetailAnswerViewModel iCreditDetailAnswerViewModel) {
        this.mCreditDetailAnswerViewModel = iCreditDetailAnswerViewModel;
        synchronized (this) {
            this.K |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(BR.creditDetailAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChooseAnswerFragmentSravniBinding
    public void setCreditOffersAnswerViewModel(@Nullable ICreditOffersAnswerViewModel iCreditOffersAnswerViewModel) {
        this.mCreditOffersAnswerViewModel = iCreditOffersAnswerViewModel;
        synchronized (this) {
            this.K |= 4;
        }
        notifyPropertyChanged(BR.creditOffersAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChooseAnswerFragmentSravniBinding
    public void setFreeTextAnswerViewModel(@Nullable IFreeTextAnswerViewModel iFreeTextAnswerViewModel) {
        this.mFreeTextAnswerViewModel = iFreeTextAnswerViewModel;
        synchronized (this) {
            this.K |= 8;
        }
        notifyPropertyChanged(BR.freeTextAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChooseAnswerFragmentSravniBinding
    public void setGoToDashboardAnswerViewModel(@Nullable IGoToDashboardAnswerViewModel iGoToDashboardAnswerViewModel) {
        this.mGoToDashboardAnswerViewModel = iGoToDashboardAnswerViewModel;
        synchronized (this) {
            this.K |= 256;
        }
        notifyPropertyChanged(BR.goToDashboardAnswerViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.y.setLifecycleOwner(lifecycleOwner);
        this.C.setLifecycleOwner(lifecycleOwner);
        this.D.setLifecycleOwner(lifecycleOwner);
        this.E.setLifecycleOwner(lifecycleOwner);
        this.F.setLifecycleOwner(lifecycleOwner);
        this.G.setLifecycleOwner(lifecycleOwner);
        this.H.setLifecycleOwner(lifecycleOwner);
        this.I.setLifecycleOwner(lifecycleOwner);
        this.J.setLifecycleOwner(lifecycleOwner);
        this.A.setLifecycleOwner(lifecycleOwner);
        this.B.setLifecycleOwner(lifecycleOwner);
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChooseAnswerFragmentSravniBinding
    public void setMaskTextAnswerViewModel(@Nullable IMaskTextAnswerViewModel iMaskTextAnswerViewModel) {
        this.mMaskTextAnswerViewModel = iMaskTextAnswerViewModel;
        synchronized (this) {
            this.K |= 1024;
        }
        notifyPropertyChanged(BR.maskTextAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChooseAnswerFragmentSravniBinding
    public void setOsagoOffersAnswerViewModel(@Nullable IOsagoOffersAnswerViewModel iOsagoOffersAnswerViewModel) {
        this.mOsagoOffersAnswerViewModel = iOsagoOffersAnswerViewModel;
        synchronized (this) {
            this.K |= 32;
        }
        notifyPropertyChanged(BR.osagoOffersAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChooseAnswerFragmentSravniBinding
    public void setOsagoOrderAnswerViewModel(@Nullable IOsagoOrderAnswerViewModel iOsagoOrderAnswerViewModel) {
        this.mOsagoOrderAnswerViewModel = iOsagoOrderAnswerViewModel;
        synchronized (this) {
            this.K |= 128;
        }
        notifyPropertyChanged(BR.osagoOrderAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChooseAnswerFragmentSravniBinding
    public void setPassportScanAnswerViewModel(@Nullable IPassportScanAnswerViewModel iPassportScanAnswerViewModel) {
        this.mPassportScanAnswerViewModel = iPassportScanAnswerViewModel;
        synchronized (this) {
            this.K |= 16;
        }
        notifyPropertyChanged(BR.passportScanAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChooseAnswerFragmentSravniBinding
    public void setSliderAnswerViewModel(@Nullable ISliderAnswerViewModel iSliderAnswerViewModel) {
        this.mSliderAnswerViewModel = iSliderAnswerViewModel;
        synchronized (this) {
            this.K |= 2;
        }
        notifyPropertyChanged(BR.sliderAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChooseAnswerFragmentSravniBinding
    public void setSuggestionAnswerViewModel(@Nullable ISuggestionAnswerViewModel iSuggestionAnswerViewModel) {
        this.mSuggestionAnswerViewModel = iSuggestionAnswerViewModel;
        synchronized (this) {
            this.K |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(BR.suggestionAnswerViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.sliderAnswerViewModel == i) {
            setSliderAnswerViewModel((ISliderAnswerViewModel) obj);
        } else if (BR.creditOffersAnswerViewModel == i) {
            setCreditOffersAnswerViewModel((ICreditOffersAnswerViewModel) obj);
        } else if (BR.freeTextAnswerViewModel == i) {
            setFreeTextAnswerViewModel((IFreeTextAnswerViewModel) obj);
        } else if (BR.passportScanAnswerViewModel == i) {
            setPassportScanAnswerViewModel((IPassportScanAnswerViewModel) obj);
        } else if (BR.osagoOffersAnswerViewModel == i) {
            setOsagoOffersAnswerViewModel((IOsagoOffersAnswerViewModel) obj);
        } else if (BR.chatViewModel == i) {
            setChatViewModel((IChatViewModel) obj);
        } else if (BR.osagoOrderAnswerViewModel == i) {
            setOsagoOrderAnswerViewModel((IOsagoOrderAnswerViewModel) obj);
        } else if (BR.goToDashboardAnswerViewModel == i) {
            setGoToDashboardAnswerViewModel((IGoToDashboardAnswerViewModel) obj);
        } else if (BR.buttonAnswerViewModel == i) {
            setButtonAnswerViewModel((IButtonAnswerViewModel) obj);
        } else if (BR.maskTextAnswerViewModel == i) {
            setMaskTextAnswerViewModel((IMaskTextAnswerViewModel) obj);
        } else if (BR.suggestionAnswerViewModel == i) {
            setSuggestionAnswerViewModel((ISuggestionAnswerViewModel) obj);
        } else if (BR.creditDetailAnswerViewModel != i) {
            return false;
        } else {
            setCreditDetailAnswerViewModel((ICreditDetailAnswerViewModel) obj);
        }
        return true;
    }
}
