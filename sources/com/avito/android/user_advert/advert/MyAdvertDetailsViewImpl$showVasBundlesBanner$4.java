package com.avito.android.user_advert.advert;

import android.animation.Animator;
import android.view.View;
import com.avito.android.util.AnimationUtils;
import com.avito.android.util.Views;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class MyAdvertDetailsViewImpl$showVasBundlesBanner$4 implements View.OnClickListener {
    public final /* synthetic */ MyAdvertDetailsViewImpl a;
    public final /* synthetic */ Function0 b;

    public MyAdvertDetailsViewImpl$showVasBundlesBanner$4(MyAdvertDetailsViewImpl myAdvertDetailsViewImpl, Function0 function0) {
        this.a = myAdvertDetailsViewImpl;
        this.b = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.M.animate().setDuration(150).alpha(0.0f).setListener(new AnimationUtils.SimpleAnimatorListener(this) { // from class: com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl$showVasBundlesBanner$4$listener$1
            public final /* synthetic */ MyAdvertDetailsViewImpl$showVasBundlesBanner$4 a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.util.AnimationUtils.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animation");
                Views.hide(this.a.a.M);
            }
        });
        this.b.invoke();
    }
}
