package org.gallant.jitwatch;

/**
 * -server -XX:+UnlockDiagnosticVMOptions -XX:+TraceClassLoading -XX:+PrintAssembly -XX:+LogCompilation -XX:+DebugNonSafepoints -XX:LogFile=VisibilityWithoutVolatile.log -Xcomp -XX:CompileCommand=compileonly,*VisibilityWithoutVolatile.* -XX:CompileCommand=dontinline,*VisibilityWithoutVolatile.*
 * @author 会灰翔的灰机
 * @date 2019/10/30
 */
public class VisibilityWithoutVolatile extends Thread {
    private boolean isRun = true;

    @Override
    public void run() {
        while(isRun){
        }
    }
    public static void main(String[] args) throws InterruptedException {
        VisibilityWithoutVolatile visibility = new VisibilityWithoutVolatile();
        visibility.start();
        Thread.sleep(1000);
        visibility.isRun = false;
        System.out.println("stop thread");
    }
}
