package readwrite;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.math.BigInteger;

class ProtectedTree extends Tree{
    Tree tree;
    int r, w;
    static BigInteger counter;
    static Integer syncVariable = 0;
    final Lock lock = new ReentrantLock();
    final Condition notWritten = lock.newCondition();

    ProtectedTree(Tree t){
        tree = t;
        r = 0;
        w = 0;
    }

    public void write(int value) throws InterruptedException {
        lock.lock();
        try {
            System.out.println("WE");
            this.tree.write(value);
            System.out.println("WX");
            w++;
            notWritten.signal();
        } finally {
            lock.unlock();
        }
    }

    private int readUtil(int value) throws InterruptedException {
        int val_out = this.tree.read(value);
        if(val_out == value){
            System.out.println("RS");
            r++;
        }else{
            System.out.println("RF");
        }
        return val_out;
    }

    public int read(int value) throws InterruptedException {
        lock.lock();
        try {
            while(r >= w){
                notWritten.await();
            }
            return readUtil(value);
        } finally {
            lock.unlock();
        }
    }
}