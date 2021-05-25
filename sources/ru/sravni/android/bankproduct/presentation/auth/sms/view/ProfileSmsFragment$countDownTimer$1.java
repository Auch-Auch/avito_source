package ru.sravni.android.bankproduct.presentation.auth.sms.view;

import android.os.CountDownTimer;
import java.text.DecimalFormat;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"ru/sravni/android/bankproduct/presentation/auth/sms/view/ProfileSmsFragment$countDownTimer$1", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", "onTick", "(J)V", "onFinish", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileSmsFragment$countDownTimer$1 extends CountDownTimer {
    public final /* synthetic */ ProfileSmsFragment a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProfileSmsFragment$countDownTimer$1(ProfileSmsFragment profileSmsFragment, long j, long j2) {
        super(j, j2);
        this.a = profileSmsFragment;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        ProfileSmsFragment.access$getViewModel$p(this.a).setTime(null);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        long j2 = (j / ((long) 1000)) % ((long) 60);
        if (j2 < 1) {
            onFinish();
        }
        ProfileSmsFragment.access$getViewModel$p(this.a).setTime(decimalFormat.format(j2));
    }
}
