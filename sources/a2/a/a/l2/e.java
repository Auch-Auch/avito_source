package a2.a.a.l2;

import com.avito.android.section.SectionItemViewHolder;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class e<T> implements Consumer<Unit> {
    public final /* synthetic */ SectionItemViewHolder a;

    public e(SectionItemViewHolder sectionItemViewHolder) {
        this.a = sectionItemViewHolder;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        this.a.sendCurrentPositionToPresenter();
    }
}
