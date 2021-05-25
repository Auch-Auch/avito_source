package ru.sravni.android.bankproduct.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
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
public class ChatFragmentSravniBindingImpl extends ChatFragmentSravniBinding {
    @Nullable
    public static final ViewDataBinding.IncludedLayouts D;
    @Nullable
    public static final SparseIntArray E;
    @Nullable
    public final SuggestListSravniBinding A;
    @Nullable
    public final ChooseAnswerFragmentSravniBinding B;
    public long C = -1;
    @NonNull
    public final ConstraintLayout y;
    @NonNull
    public final FrameLayout z;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        D = includedLayouts;
        includedLayouts.setIncludes(3, new String[]{"suggest_list_sravni"}, new int[]{5}, new int[]{R.layout.suggest_list_sravni});
        includedLayouts.setIncludes(4, new String[]{"choose_answer_fragment_sravni"}, new int[]{6}, new int[]{R.layout.choose_answer_fragment_sravni});
        SparseIntArray sparseIntArray = new SparseIntArray();
        E = sparseIntArray;
        sparseIntArray.put(R.id.appBarLayout, 7);
        sparseIntArray.put(R.id.vShadow, 8);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChatFragmentSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r12, @androidx.annotation.NonNull android.view.View r13) {
        /*
            r11 = this;
            androidx.databinding.ViewDataBinding$IncludedLayouts r0 = ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBindingImpl.D
            android.util.SparseIntArray r1 = ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBindingImpl.E
            r2 = 9
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r12, r13, r2, r0, r1)
            r1 = 7
            r1 = r0[r1]
            r6 = r1
            com.google.android.material.appbar.AppBarLayout r6 = (com.google.android.material.appbar.AppBarLayout) r6
            r1 = 4
            r1 = r0[r1]
            r7 = r1
            android.widget.FrameLayout r7 = (android.widget.FrameLayout) r7
            r1 = 2
            r1 = r0[r1]
            r8 = r1
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            r1 = 1
            r1 = r0[r1]
            r9 = r1
            com.google.android.material.appbar.MaterialToolbar r9 = (com.google.android.material.appbar.MaterialToolbar) r9
            r1 = 8
            r1 = r0[r1]
            r10 = r1
            android.view.View r10 = (android.view.View) r10
            r5 = 2
            r2 = r11
            r3 = r12
            r4 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = -1
            r11.C = r1
            android.widget.FrameLayout r12 = r11.flAnswer
            r1 = 0
            r12.setTag(r1)
            r12 = 0
            r12 = r0[r12]
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            r11.y = r12
            r12.setTag(r1)
            r12 = 3
            r12 = r0[r12]
            android.widget.FrameLayout r12 = (android.widget.FrameLayout) r12
            r11.z = r12
            r12.setTag(r1)
            r12 = 5
            r12 = r0[r12]
            ru.sravni.android.bankproduct.databinding.SuggestListSravniBinding r12 = (ru.sravni.android.bankproduct.databinding.SuggestListSravniBinding) r12
            r11.A = r12
            r11.setContainedBinding(r12)
            r12 = 6
            r12 = r0[r12]
            ru.sravni.android.bankproduct.databinding.ChooseAnswerFragmentSravniBinding r12 = (ru.sravni.android.bankproduct.databinding.ChooseAnswerFragmentSravniBinding) r12
            r11.B = r12
            r11.setContainedBinding(r12)
            androidx.recyclerview.widget.RecyclerView r12 = r11.rvListMessage
            r12.setTag(r1)
            com.google.android.material.appbar.MaterialToolbar r12 = r11.toolbar
            r12.setTag(r1)
            r11.setRootTag(r13)
            r11.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x015e  */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 371
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.C != 0) {
                return true;
            }
        }
        if (!this.A.hasPendingBindings() && !this.B.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.C = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        this.A.invalidateAll();
        this.B.invalidateAll();
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.C |= 2;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/util/List<Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/SuggestInfo;>;>;I)Z */
    public final boolean l(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.C |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            LiveData liveData = (LiveData) obj;
            return l(i2);
        } else if (i != 1) {
            return false;
        } else {
            LiveData liveData2 = (LiveData) obj;
            return j(i2);
        }
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBinding
    public void setButtonAnswerViewModel(@Nullable IButtonAnswerViewModel iButtonAnswerViewModel) {
        this.mButtonAnswerViewModel = iButtonAnswerViewModel;
        synchronized (this) {
            this.C |= 128;
        }
        notifyPropertyChanged(BR.buttonAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBinding
    public void setChatLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        this.mChatLifecycleOwner = lifecycleOwner;
        synchronized (this) {
            this.C |= 256;
        }
        notifyPropertyChanged(BR.chatLifecycleOwner);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBinding
    public void setChatViewModel(@Nullable IChatViewModel iChatViewModel) {
        this.mChatViewModel = iChatViewModel;
        synchronized (this) {
            this.C |= 8;
        }
        notifyPropertyChanged(BR.chatViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBinding
    public void setCreditDetailAnswerViewModel(@Nullable ICreditDetailAnswerViewModel iCreditDetailAnswerViewModel) {
        this.mCreditDetailAnswerViewModel = iCreditDetailAnswerViewModel;
        synchronized (this) {
            this.C |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(BR.creditDetailAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBinding
    public void setCreditOffersAnswerViewModel(@Nullable ICreditOffersAnswerViewModel iCreditOffersAnswerViewModel) {
        this.mCreditOffersAnswerViewModel = iCreditOffersAnswerViewModel;
        synchronized (this) {
            this.C |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(BR.creditOffersAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBinding
    public void setFreeTextAnswerViewModel(@Nullable IFreeTextAnswerViewModel iFreeTextAnswerViewModel) {
        this.mFreeTextAnswerViewModel = iFreeTextAnswerViewModel;
        synchronized (this) {
            this.C |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        notifyPropertyChanged(BR.freeTextAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBinding
    public void setGoToDashboardAnswerViewModel(@Nullable IGoToDashboardAnswerViewModel iGoToDashboardAnswerViewModel) {
        this.mGoToDashboardAnswerViewModel = iGoToDashboardAnswerViewModel;
        synchronized (this) {
            this.C |= 64;
        }
        notifyPropertyChanged(BR.goToDashboardAnswerViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.A.setLifecycleOwner(lifecycleOwner);
        this.B.setLifecycleOwner(lifecycleOwner);
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBinding
    public void setMaskTextAnswerViewModel(@Nullable IMaskTextAnswerViewModel iMaskTextAnswerViewModel) {
        this.mMaskTextAnswerViewModel = iMaskTextAnswerViewModel;
        synchronized (this) {
            this.C |= 512;
        }
        notifyPropertyChanged(BR.maskTextAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBinding
    public void setOsagoOffersAnswerViewModel(@Nullable IOsagoOffersAnswerViewModel iOsagoOffersAnswerViewModel) {
        this.mOsagoOffersAnswerViewModel = iOsagoOffersAnswerViewModel;
        synchronized (this) {
            this.C |= 4;
        }
        notifyPropertyChanged(BR.osagoOffersAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBinding
    public void setOsagoOrderAnswerViewModel(@Nullable IOsagoOrderAnswerViewModel iOsagoOrderAnswerViewModel) {
        this.mOsagoOrderAnswerViewModel = iOsagoOrderAnswerViewModel;
        synchronized (this) {
            this.C |= 32;
        }
        notifyPropertyChanged(BR.osagoOrderAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBinding
    public void setPassportScanAnswerViewModel(@Nullable IPassportScanAnswerViewModel iPassportScanAnswerViewModel) {
        this.mPassportScanAnswerViewModel = iPassportScanAnswerViewModel;
        synchronized (this) {
            this.C |= 16384;
        }
        notifyPropertyChanged(BR.passportScanAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBinding
    public void setSliderAnswerViewModel(@Nullable ISliderAnswerViewModel iSliderAnswerViewModel) {
        this.mSliderAnswerViewModel = iSliderAnswerViewModel;
        synchronized (this) {
            this.C |= 16;
        }
        notifyPropertyChanged(BR.sliderAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBinding
    public void setSuggestionAnswerViewModel(@Nullable ISuggestionAnswerViewModel iSuggestionAnswerViewModel) {
        this.mSuggestionAnswerViewModel = iSuggestionAnswerViewModel;
        synchronized (this) {
            this.C |= 1024;
        }
        notifyPropertyChanged(BR.suggestionAnswerViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.osagoOffersAnswerViewModel == i) {
            setOsagoOffersAnswerViewModel((IOsagoOffersAnswerViewModel) obj);
        } else if (BR.chatViewModel == i) {
            setChatViewModel((IChatViewModel) obj);
        } else if (BR.sliderAnswerViewModel == i) {
            setSliderAnswerViewModel((ISliderAnswerViewModel) obj);
        } else if (BR.osagoOrderAnswerViewModel == i) {
            setOsagoOrderAnswerViewModel((IOsagoOrderAnswerViewModel) obj);
        } else if (BR.goToDashboardAnswerViewModel == i) {
            setGoToDashboardAnswerViewModel((IGoToDashboardAnswerViewModel) obj);
        } else if (BR.buttonAnswerViewModel == i) {
            setButtonAnswerViewModel((IButtonAnswerViewModel) obj);
        } else if (BR.chatLifecycleOwner == i) {
            setChatLifecycleOwner((LifecycleOwner) obj);
        } else if (BR.maskTextAnswerViewModel == i) {
            setMaskTextAnswerViewModel((IMaskTextAnswerViewModel) obj);
        } else if (BR.suggestionAnswerViewModel == i) {
            setSuggestionAnswerViewModel((ISuggestionAnswerViewModel) obj);
        } else if (BR.creditOffersAnswerViewModel == i) {
            setCreditOffersAnswerViewModel((ICreditOffersAnswerViewModel) obj);
        } else if (BR.creditDetailAnswerViewModel == i) {
            setCreditDetailAnswerViewModel((ICreditDetailAnswerViewModel) obj);
        } else if (BR.freeTextAnswerViewModel == i) {
            setFreeTextAnswerViewModel((IFreeTextAnswerViewModel) obj);
        } else if (BR.passportScanAnswerViewModel != i) {
            return false;
        } else {
            setPassportScanAnswerViewModel((IPassportScanAnswerViewModel) obj);
        }
        return true;
    }
}
