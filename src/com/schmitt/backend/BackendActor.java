package com.schmitt.backend;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class BackendActor extends UntypedActor {
  LoggingAdapter log = Logging.getLogger(getContext().system(), this);

  @Override
  public void preStart() throws Exception {

  }

  @Override
  public void onReceive(Object message) throws Exception {
    if (message instanceof String) {
      if (((String) message).startsWith("Hallo")) {
        log.info(getSender() + " " + message.toString() + " " + getSelf());
        getSender().tell("ok", getSelf());
      }
    }
  }
}
