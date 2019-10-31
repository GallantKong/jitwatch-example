package org.gallant.jitwatch;

/**
 * -server -XX:+UnlockDiagnosticVMOptions -XX:+TraceClassLoading -XX:+PrintAssembly -XX:+LogCompilation -XX:+DebugNonSafepoints -XX:LogFile=Summary.log
 * @author 会灰翔的灰机
 * @date 2019/10/30
 */
public class Summary {
    private volatile long summary = 0;

    public int add(int a, int b) {
        int temp = a + b;
        summary += temp;
        return temp;
    }

    public static void main(String[] args) {
        Summary summary = new Summary();
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum = summary.add(sum, 1);
        }
        System.out.println("Summary:" + sum);
        System.out.println("Summary.sum:" + summary.summary);
    }
}
