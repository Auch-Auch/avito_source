package a7.c.a.a.o.c.b;

import android.content.DialogInterface;
import ru.sravni.android.bankproduct.presentation.chat.view.ChatFragment;
public final class a implements DialogInterface.OnClickListener {
    public final /* synthetic */ ChatFragment a;

    public a(ChatFragment chatFragment) {
        this.a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ChatFragment.access$getChatViewModel$p(this.a).restartChat();
    }
}
