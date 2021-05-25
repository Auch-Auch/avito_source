package com.my.target;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ap;
import com.my.target.common.MyTargetActivity;
import com.my.target.ej;
import java.lang.ref.WeakReference;
import java.util.Objects;
public class ax extends av {
    @NonNull
    public final cd g;
    @Nullable
    public iq h;
    @Nullable
    public WeakReference<ef> i;

    public static class a implements ej.a {
        @NonNull
        public final ax a;

        public a(@NonNull ax axVar) {
            this.a = axVar;
        }

        @Override // com.my.target.ej.a
        public void a(@NonNull by byVar, @NonNull View view) {
            StringBuilder L = a2.b.a.a.a.L("Ad shown, banner Id = ");
            L.append(byVar.getId());
            ae.a(L.toString());
            ax axVar = this.a;
            iq iqVar = axVar.h;
            if (iqVar != null) {
                iqVar.fj();
            }
            iq a3 = iq.a(axVar.g.getViewability(), axVar.g.getStatHolder());
            axVar.h = a3;
            if (axVar.b) {
                a3.m(view);
            }
            StringBuilder L2 = a2.b.a.a.a.L("Ad shown, banner Id = ");
            L2.append(byVar.getId());
            ae.a(L2.toString());
            im.a(byVar.getStatHolder().K("playbackStarted"), view.getContext());
        }

        @Override // com.my.target.ej.a
        public void b(@Nullable by byVar, @Nullable String str, @NonNull Context context) {
            ax axVar = this.a;
            Objects.requireNonNull(axVar);
            hx.eC().a(axVar.g, context);
            axVar.a.onClick();
            axVar.dismiss();
        }

        @Override // com.my.target.ej.a
        public void p() {
            this.a.dismiss();
        }
    }

    public ax(@NonNull cd cdVar, @NonNull ap.a aVar) {
        super(aVar);
        this.g = cdVar;
    }

    @Override // com.my.target.av
    public boolean al() {
        return this.g.isAllowBackButton();
    }

    @Override // com.my.target.av, com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityCreate(@NonNull MyTargetActivity myTargetActivity, @NonNull Intent intent, @NonNull FrameLayout frameLayout) {
        super.onActivityCreate(myTargetActivity, intent, frameLayout);
        ef y = ef.y(frameLayout.getContext());
        this.i = new WeakReference<>(y);
        y.a(new a(this));
        y.a(this.g);
        frameLayout.addView(y.cZ(), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.my.target.av, com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityDestroy() {
        super.onActivityDestroy();
        iq iqVar = this.h;
        if (iqVar != null) {
            iqVar.fj();
            this.h = null;
        }
    }

    @Override // com.my.target.av, com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityPause() {
        super.onActivityPause();
        iq iqVar = this.h;
        if (iqVar != null) {
            iqVar.fj();
        }
    }

    @Override // com.my.target.av, com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityResume() {
        ef efVar;
        iq iqVar;
        super.onActivityResume();
        WeakReference<ef> weakReference = this.i;
        if (weakReference != null && (efVar = weakReference.get()) != null && (iqVar = this.h) != null) {
            iqVar.m(efVar.cZ());
        }
    }
}
