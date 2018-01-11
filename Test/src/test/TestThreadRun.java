package test;

public class TestThreadRun {
	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest("t1");
		synchronized (t1) {
			// �������߳�1��
			System.out.println(Thread.currentThread().getName() + " start t1");
			t1.start();
			// ���̵߳ȴ�t1ͨ��notify() ����
			System.out.println(Thread.currentThread().getName() + " wait");
			try {
				t1.wait();
				System.out.println(Thread.currentThread().getName()
						+ " continue");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
