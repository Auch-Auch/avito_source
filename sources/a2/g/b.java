package a2.g;

import android.content.Context;
import android.view.View;
import com.facebook.FacebookButtonBase;
import com.facebook.appevents.InternalAppEventsLogger;
public class b implements View.OnClickListener {
    public final /* synthetic */ FacebookButtonBase a;

    public b(FacebookButtonBase facebookButtonBase) {
        this.a = facebookButtonBase;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FacebookButtonBase facebookButtonBase = this.a;
        Context context = facebookButtonBase.getContext();
        int i = FacebookButtonBase.i;
        new InternalAppEventsLogger(context).logEventImplicitly(facebookButtonBase.b);
        FacebookButtonBase facebookButtonBase2 = this.a;
        View.OnClickListener onClickListener = facebookButtonBase2.d;
        if (onClickListener != null) {
            onClickListener.onClick(view);
            return;
        }
        View.OnClickListener onClickListener2 = facebookButtonBase2.c;
        if (onClickListener2 != null) {
            onClickListener2.onClick(view);
        }
    }
}
