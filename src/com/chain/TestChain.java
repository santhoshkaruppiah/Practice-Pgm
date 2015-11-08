package com.chain;

public class TestChain {
	
	public static void main(String[] args) {
		AbstractChain chOne=new ChainOne();
		AbstractChain chTwo=new ChainTwo();
		AbstractChain chThree=new ChainThree();
		chOne.setSuccessor(chTwo);
		chTwo.setSuccessor(chThree);
		chOne.handleRequest("handle me");
	}
}
