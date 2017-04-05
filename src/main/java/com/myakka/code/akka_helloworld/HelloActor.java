package com.myakka.code.akka_helloworld;

import akka.actor.UntypedActor;

public class HelloActor extends UntypedActor{

	@Override
	public void onReceive(Object arg0) throws Exception {
		if(arg0 instanceof HelloMessage){
			System.out.println("My hello world message is" + ((HelloMessage)arg0).getMessage());
		}
	}

}
