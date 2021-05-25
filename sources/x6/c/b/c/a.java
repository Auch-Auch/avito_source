package x6.c.b.c;

import java.util.Collections;
import java.util.List;
import org.junit.internal.management.RuntimeMXBean;
public class a implements RuntimeMXBean {
    @Override // org.junit.internal.management.RuntimeMXBean
    public List<String> getInputArguments() {
        return Collections.emptyList();
    }
}
