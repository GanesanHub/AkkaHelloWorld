package com.myakka.code.akka_helloworld;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class AkkaActivator implements BundleActivator {
	
	@Override
	public void start(BundleContext arg0) throws Exception {
		System.out.println("Starting the Akka test bundle");
		ActorSystem actorSystem = ActorSystem.create( "MySystem" );
        ActorRef actorRef = actorSystem.actorOf( new Props( HelloActor.class ), "myActor" );
        actorRef.tell( new HelloMessage( "Hello, Akka! My First APP" ) );

        try
        {
            Thread.sleep( 1000 );
        }
        catch( Exception e ) {}

        actorSystem.stop( actorRef );
        actorSystem.shutdown();

		
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		System.out.println("Stopping the Akka test bundle");
		
	}
}
