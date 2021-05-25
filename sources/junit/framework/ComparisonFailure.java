package junit.framework;
public class ComparisonFailure extends AssertionFailedError {
    private static final long serialVersionUID = 1;
    public String a;
    public String b;

    public ComparisonFailure(String str, String str2, String str3) {
        super(str);
        this.a = str2;
        this.b = str3;
    }

    public String getActual() {
        return this.b;
    }

    public String getExpected() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return new ComparisonCompactor(20, this.a, this.b).compact(super.getMessage());
    }
}
