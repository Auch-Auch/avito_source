package junit.framework;
public class AssertionFailedError extends AssertionError {
    private static final long serialVersionUID = 1;

    public AssertionFailedError() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AssertionFailedError(String str) {
        super(str == null ? "" : str);
    }
}
