package com.schmitt.backend;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.FromConfig;


public class BackendSupervisor extends UntypedActor {

  ActorRef backendRouter = getContext().actorOf(
      FromConfig.getInstance().props(Props.create(BackendActor.class)), "backendRouter");

  @Override
  public void onReceive(Object message) throws Exception {
    // TODO Auto-generated method stub
    backendRouter.forward(message, getContext());
  }
}
