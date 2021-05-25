package com.avito.android.publish.start_publish;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.avito.android.publish.R;
import com.avito.android.publish.new_advert.NewAdvertFragment;
import com.avito.android.ui.activity.BaseActivity;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "getContentLayoutId", "()I", "<init>", "()V", "Companion", "Type", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class StartPublishActivity extends BaseActivity {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishActivity$Companion;", "", "Landroid/content/Context;", "context", "", "calledFrom", "Lcom/avito/android/publish/start_publish/StartPublishActivity$Type;", "type", "Landroid/content/Intent;", "createStartPublishOverlayActivity", "(Landroid/content/Context;Ljava/lang/String;Lcom/avito/android/publish/start_publish/StartPublishActivity$Type;)Landroid/content/Intent;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Intent createStartPublishOverlayActivity(@NotNull Context context, @Nullable String str, @NotNull Type type) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            Intent intent = new Intent(context, StartPublishActivity.class);
            intent.putExtra("key.called_from", str);
            intent.putExtra("key.type", type);
            return intent;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishActivity$Type;", "", "<init>", "(Ljava/lang/String;I)V", "FLOATING_BUTTONS", "SHEET", "publish_release"}, k = 1, mv = {1, 4, 2})
    public enum Type {
        FLOATING_BUTTONS,
        SHEET
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.start_publish_activity;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Fragment fragment;
        super.onCreate(bundle);
        Serializable serializableExtra = getIntent().getSerializableExtra("key.type");
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.avito.android.publish.start_publish.StartPublishActivity.Type");
        int ordinal = ((Type) serializableExtra).ordinal();
        if (ordinal == 0) {
            fragment = NewAdvertFragment.Companion.createFragment(getIntent().getStringExtra("key.called_from"));
        } else if (ordinal == 1) {
            fragment = StartPublishFragment.Companion.createFragment(getIntent().getStringExtra("key.called_from"));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        getSupportFragmentManager().beginTransaction().replace(com.avito.android.ui_components.R.id.fragment_container, fragment, "tag.start_publish").commit();
    }
}
