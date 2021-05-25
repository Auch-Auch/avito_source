package a2.a.a.c2.a;

import com.avito.android.profile_phones.add_phone.AddPhoneFragment;
public final class i implements Runnable {
    public final /* synthetic */ AddPhoneFragment a;

    public i(AddPhoneFragment addPhoneFragment) {
        this.a = addPhoneFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AddPhoneFragment.access$getAppBarLayout$p(this.a).setExpanded(true);
    }
}
