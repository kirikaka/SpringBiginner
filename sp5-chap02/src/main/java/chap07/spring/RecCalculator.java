package chap07.spring;

public class RecCalculator implements Calculator {
    @Override
    public long factorial(long num) {
        if(num == 0)
            return 1;
        else
            return num * factorial(num-1);
    }
}
