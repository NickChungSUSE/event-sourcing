package com.neu.eventsourcing.command.adapter.controller;

import com.neu.eventsourcing.command.usecase.ScanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/scan")
public class ScanController {

  private final ScanService scanService;

  public ScanController(ScanService scanService) {
    this.scanService = scanService;
  }

  @PostMapping
  public ResponseEntity<Void> scan() {
    scanService.startScan();
    return ResponseEntity.ok().build();
  }
}
