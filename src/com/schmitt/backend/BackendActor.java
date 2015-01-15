package com.schmitt.backend;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class BackendActor extends UntypedActor {
  LoggingAdapter log = Logging.getLogger(getContext().system(), this);

  @Override
  public void onReceive(Object message) throws Exception {
    if (message instanceof String) {
      String messageString = (String) message;
      switch (messageString) {
        case "Mahlzeit":
          getSender().tell("Bye", getSelf());
          log.error(messageString);
          break;
        default:
          break;
      }
    } else {
      unhandled(message);
    }
  }

}
