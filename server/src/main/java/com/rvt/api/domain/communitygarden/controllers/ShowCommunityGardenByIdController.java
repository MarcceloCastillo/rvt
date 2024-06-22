package com.rvt.api.domain.communitygarden.controllers;

import com.rvt.api.domain.communitygarden.dtos.CommunityGardenInfo;
import com.rvt.api.domain.communitygarden.services.FindCommunityGardenByIdService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/community-garden")
@AllArgsConstructor
public class ShowCommunityGardenByIdController {
  private final FindCommunityGardenByIdService service;

  @GetMapping("/{community_garden_id}")
  public ResponseEntity<CommunityGardenInfo> index(@PathVariable(name = "community_garden_id") String id) {
    return ok(service.find(id));
  }
}
