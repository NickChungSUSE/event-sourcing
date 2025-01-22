package com.neu.eventsourcing.command.adapter.controller;

import com.neu.eventsourcing.command.usecase.ScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/scan")
public class ScanController {

  @Autowired
  private ScanService scanService;

  @PostMapping
  public ResponseEntity<Void> scan() {
    scanService.scan();
    return ResponseEntity.ok().build();
  }
}
