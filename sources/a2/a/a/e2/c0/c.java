package a2.a.a.e2.c0;

import androidx.lifecycle.Observer;
import com.avito.android.publish.select.SelectFragment;
import com.avito.android.publish.select.SelectViewModel;
public final class c<T> implements Observer<SelectViewModel.MainActionState> {
    public final /* synthetic */ SelectFragment a;

    public c(SelectFragment selectFragment) {
        this.a = selectFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(SelectViewModel.MainActionState mainActionState) {
        SelectFragment.access$getPublishButton$p(this.a).setVisible(mainActionState == SelectViewModel.MainActionState.VISIBLE);
    }
}
