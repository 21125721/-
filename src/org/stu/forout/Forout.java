package org.stu.forout;
/**
 * ѭ�����
 * @author zcy12
 *
 */
public class Forout {
	//ѭ�����=����߿�
		public static void ForOut(int index) throws  InterruptedException {
			for(int i=0;i<index;i++) {	
				System.out.print("=");
			}
		}
		//ѭ�����=����߿�
		public static void ForOut(int index,int n) throws  InterruptedException {
			for(int i=0;i<index;i++) {	
				System.out.print("=");
				/*Robot Sleep = new Robot();
				Sleep.delay(100);*/
				
				Thread.currentThread().sleep(n);
			}
		}
		//ѧ����Ϣ����ϵͳ���
		public static void stuprin() throws InterruptedException {
			char a[] = {'ѧ','��','��','Ϣ',' ',' ','��','��','ϵ','ͳ'};
			for(int i=0;i<a.length;i++) {
				System.out.print(a[i]);
			}
		}
		public static void stuprin(int index) throws InterruptedException {
			char a[] = {'ѧ','��','��','Ϣ',' ',' ','��','��','ϵ','ͳ'};
			for(int i=0;i<a.length;i++) {
				System.out.print(a[i]);
				Thread.currentThread().sleep(index);
			}
		}
}
