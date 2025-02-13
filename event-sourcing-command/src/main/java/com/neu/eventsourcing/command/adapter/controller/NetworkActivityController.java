package com.neu.eventsourcing.command.adapter.controller;

import com.neu.eventsourcing.command.usecase.NetworkActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/network-activities")
public class NetworkActivityController {

  private final NetworkActivityService networkActivityService;

  public NetworkActivityController(NetworkActivityService networkActivityService) {
    this.networkActivityService = networkActivityService;
  }

  @PostMapping
  public ResponseEntity<Void> create() {
    networkActivityService.createNetworkActivities();
    return ResponseEntity.ok().build();
  }

}
