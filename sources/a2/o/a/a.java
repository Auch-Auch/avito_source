package a2.o.a;

import com.shawnlin.numberpicker.NumberPicker;
import java.util.Locale;
public class a implements NumberPicker.Formatter {
    public final /* synthetic */ String a;

    public a(NumberPicker numberPicker, String str) {
        this.a = str;
    }

    @Override // com.shawnlin.numberpicker.NumberPicker.Formatter
    public String format(int i) {
        return String.format(Locale.getDefault(), this.a, Integer.valueOf(i));
    }
}
