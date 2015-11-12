package test;

import java.lang.instrument.Instrumentation;

public class TestCommit {

	public static void main(String[] args) {
		ICommit obj = new CommitImpl();
		ICommitBase commitBase = obj;
		System.out.println("Part="+commitBase.getPart()+",Option="+commitBase.getOption());
		
		System.out.println("Part="+obj.getPart()+",Option="+obj.getOption()+",LeadTime="+obj.getLeadTime());
		
		System.out.println(ObjectSizeFetcher.getObjectSize(obj));
		System.out.println(ObjectSizeFetcher.getObjectSize(commitBase));
	}
}

class ObjectSizeFetcher {
    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }
}