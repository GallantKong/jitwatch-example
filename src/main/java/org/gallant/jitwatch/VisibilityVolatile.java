package org.gallant.jitwatch;

/**
 * -server -XX:+UnlockDiagnosticVMOptions -XX:+TraceClassLoading -XX:+PrintAssembly -XX:+LogCompilation -XX:+DebugNonSafepoints -XX:LogFile=VisibilityVolatile.log -Xcomp -XX:CompileCommand=compileonly,*VisibilityVolatile.* -XX:CompileCommand=dontinline,*VisibilityVolatile.*
 * @author 会灰翔的灰机
 * @date 2019/10/30
 */
public class VisibilityVolatile extends Thread {
    private volatile boolean isRun = true;

    @Override
    public void run() {
        while(isRun){
        }
    }
    public static void main(String[] args) throws InterruptedException {
        VisibilityVolatile visibility = new VisibilityVolatile();
        visibility.start();
        Thread.sleep(1000);
        visibility.isRun = false;
        System.out.println("stop thread");
    }
}
