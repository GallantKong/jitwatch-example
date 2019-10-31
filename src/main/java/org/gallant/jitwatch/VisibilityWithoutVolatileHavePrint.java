package org.gallant.jitwatch;

/**
 * -server -XX:+UnlockDiagnosticVMOptions -XX:+TraceClassLoading -XX:+PrintAssembly -XX:+LogCompilation -XX:+DebugNonSafepoints -XX:LogFile=VisibilityWithoutVolatileHavePrint.log -Xcomp -XX:CompileCommand=compileonly,*VisibilityWithoutVolatileHavePrint.* -XX:CompileCommand=dontinline,*VisibilityWithoutVolatileHavePrint.*
 * @author 会灰翔的灰机
 * @date 2019/10/30
 */
public class VisibilityWithoutVolatileHavePrint extends Thread {
    private boolean isRun = true;

    @Override
    public void run() {
        while(isRun){
            System.out.println(isRun);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        VisibilityWithoutVolatileHavePrint visibility = new VisibilityWithoutVolatileHavePrint();
        visibility.start();
        Thread.sleep(1000);
        visibility.isRun = false;
        System.out.println("stop thread");
    }
}
