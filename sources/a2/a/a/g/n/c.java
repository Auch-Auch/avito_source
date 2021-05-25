package a2.a.a.g.n;

import android.view.View;
import com.avito.android.social.button.SocialButton;
public final class c implements View.OnClickListener {
    public final /* synthetic */ SocialButton a;

    public c(SocialButton socialButton) {
        this.a = socialButton;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getClickListener().invoke();
    }
}
