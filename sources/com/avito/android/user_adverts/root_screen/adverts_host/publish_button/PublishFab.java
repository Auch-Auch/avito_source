package com.avito.android.user_adverts.root_screen.adverts_host.publish_button;

import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_adverts.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/publish_button/PublishFab;", "", "", "show", "()V", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "fab", "Landroid/view/View;", "view", "Lkotlin/Function0;", "clickListener", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class PublishFab {
    public final FloatingActionButton a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public PublishFab(@NotNull View view, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function0, "clickListener");
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.publish_fab_button);
        this.a = floatingActionButton;
        floatingActionButton.setOnClickListener(new a(function0));
    }

    public final void show() {
        this.a.show();
    }
}
