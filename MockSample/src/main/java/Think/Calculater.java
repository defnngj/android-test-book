package Think;

public class Calculater implements ICalculater{

    private final IMathUtils iMathUtils;

    /**
     * 过构造方法接受IMathUtils实例化对象
     */
    public Calculater(IMathUtils iMathUtils){
        this.iMathUtils = iMathUtils;
    }

    @Override
    public double divide(int a, int b) {
        // 检测被除数是否为0
        if (iMathUtils.checkZero(b)) {
            throw new RuntimeException("dividend is zero");
        }
        return (double) a / b;
    }

}
