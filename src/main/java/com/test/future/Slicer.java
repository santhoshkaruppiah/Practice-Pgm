package com.test.future;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class Slicer {
	
	private static final ThreadFactory THREAD_FACTORY_PCI = (r) -> {
		final String name = "PCI" + ":" + 1+ ":" ;
		final Thread thread = new Thread(r, name);
		thread.setPriority(Thread.NORM_PRIORITY);
		thread.setDaemon(true);
		return (thread);
	};
	
	private static final ThreadFactory THREAD_FACTORY_NPCI = (r) -> {
		final String name = "NPCI" + ":" + 1+ ":" ;
		final Thread thread = new Thread(r, name);
		thread.setPriority(Thread.NORM_PRIORITY);
		thread.setDaemon(true);
		return (thread);
	};

	//private static CompletionService<PCICache> pciCompletionService = new ExecutorCompletionService<>(Executors.newFixedThreadPool(1,THREAD_FACTORY_PCI));
	private static CompletionService<Map<String,Object>> pciCompletionService = new ExecutorCompletionService<>(Executors.newFixedThreadPool(1,THREAD_FACTORY_PCI));
	private static CompletionService<NPCICache> nPCICompletionService = new ExecutorCompletionService<>(Executors.newFixedThreadPool(1,THREAD_FACTORY_NPCI));
	
	public static void main(String[] args) {
		
//		Set<Future<PCICache>> pcifutureResults = Sets.newHashSet();
		Set<Future<Map<String,Object>>> pcifutureResults = Sets.newHashSet();
		Set<Future<NPCICache>> nPCIfutureResults = Sets.newHashSet();
		
		for (int i = 0,j=1; i < 10; i++) {
			Map<String,Object> dataMap = new HashMap<>();
			String uuid = UUID.randomUUID().toString();
			dataMap.put(uuid,uuid+"V"+i);	
			if(j==2){
				j=1;//reset
//				pcifutureResults.add(
//										pciCompletionService.submit(new PCICache(dataMap))
//									);
//				nPCIfutureResults.add(
//										nPCICompletionService.submit(new NPCICache(dataMap))
//									);
				
//				pciCompletionService.submit(new Callable<Map<String,Object>>() {
//
//					@Override
//					public Map<String,Object> call() throws Exception {
//						boolean result = DelaySimulator.put();
//						System.out.println("PCICache="+result);
//						if (!result){
//							return dataMap;
//						}
//						return null;
//					}
//					
//					}
//				);
				pcifutureResults.add(
				pciCompletionService.submit(() -> {
					try{
						boolean result = DelaySimulator.put();
						System.out.println("PCICache="+result);
						if (!result){
							return dataMap;
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
			)
			);
				pciCompletionService.submit(Slicer.getCallable(null,null));
			} else {//inc only when not reached 10
				j++;
			}
		}
		System.out.println("Loop-Done, PCI Future Result Size="+pcifutureResults.size()+", NPCI future Result size="+nPCIfutureResults.size());
		//Future<PCICache> completedFuture;
		Future<Map<String,Object>> completedFuture;
//		PCICache PCICache;
		Map<String,Object> PCICache;
		try{
			 while (pcifutureResults.size() > 0) {
				 completedFuture = pciCompletionService.take();
				 pcifutureResults.remove(completedFuture);
				 try {
					 PCICache = completedFuture.get();
					 System.out.println(PCICache);
				} catch (Exception e) {
					e.printStackTrace();
				}
				  
			 }
		}catch(Exception s){
			s.printStackTrace();
		}
	}
	
	
	static <M,I> Callable<M> getCallable(M map,I cacheInterface){
		return ( () -> {
			try{
				boolean s =true;
				if (s) {
					return map;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		);
	}
}
