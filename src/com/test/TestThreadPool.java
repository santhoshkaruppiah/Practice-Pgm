package com.test;

import java.util.ArrayList;
import java.util.List;

public class TestThreadPool {

	public static void main(String[] args) {
		try{
		Job job = new Job();
		Job.val valRef1 = job.new val(1,2);
		Job.val valRef2 = job.new val(2,3);
		Job.val valRef3 = job.new val(3,4);
		Job.val valRef4 = job.new val(4,5);
		Job.val valRef5 = job.new val(5,6);
		Job.val valRef6 = job.new val(6,7);
		job.intList = new ArrayList<Job.val>();
		job.intList.add(valRef1);
		job.intList.add(valRef2);
		job.intList.add(valRef3);
		job.intList.add(valRef4);
		job.intList.add(valRef5);
		job.intList.add(valRef6);
		for (int i=0;i<4;i++){
			Thread th = new Thread(new PoolWorker(job));
			th.start();
//			if (job.intList.size()!=0)
				//stmt to be added
			th.join();
		}
		//(1+2)=3+(2,3)=8+(3,4)=15+(4,5)=24+(5,6)=35+(6,7)=48
		System.out.println("Job Status, totalVal="+job.totalVal+",list count="+job.intList.size());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}


class Job {
	
    int totalVal;
	public List<val> intList;
	
	public int add(){
		if (intList.size()<=0) return 0;
		val valRef=intList.get(0);
		totalVal+=valRef.a+valRef.g;
		intList.remove(0);
		System.out.println("Thread Name="+Thread.currentThread().getName()+",tot val="+totalVal);
		return totalVal;
	}
	
	class val{
		int a;
		int g;
		val(int a,int g){
			this.a= a;
			this.g=g;
		}
	}
}

class PoolWorker implements  Runnable {
	
	Object task= null;
	
	PoolWorker(Object task){
		this.task=task;
	}
	
	public void run() {
		synchronized (task) {
			int toBeCompleted=((Job) task).intList.size();
			if (toBeCompleted==0) {
				return;
			}else{
				
				int remainder=0;
				
				if (toBeCompleted % 2==0) {
					remainder=toBeCompleted /2;
				}else{
					remainder=toBeCompleted %2;
				}
				
				while(true){
					if (remainder==0) break;
					((Job) task).add();	
					remainder--;
				}
			}
			
		}
	}
}