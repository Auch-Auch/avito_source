package com.avito.android.beduin_test;

import android.os.Bundle;
import android.os.Handler;
import com.avito.android.beduin.ui.fragment.BeduinFragment;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/beduin_test/BeduinTestActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "()V", "onPause", "Landroid/os/Handler;", "k", "Landroid/os/Handler;", "handler", "<init>", "beduin-test_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinTestActivity extends BaseActivity {
    public final Handler k = new Handler();

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.beduin_test_container);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.k.removeCallbacksAndMessages(null);
        super.onPause();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.k.post(new Runnable(this) { // from class: com.avito.android.beduin_test.BeduinTestActivity$onResume$runnable$1
            public final /* synthetic */ BeduinTestActivity a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, BeduinFragment.Companion.create(new BeduinFragment.Params("https://www.avito.ru/api/beduin-test", Integer.valueOf(R.drawable.ic_back_24)))).commit();
                BeduinTestActivity.access$getHandler$p(this.a).postDelayed(this, SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
            }
        });
    }
}
