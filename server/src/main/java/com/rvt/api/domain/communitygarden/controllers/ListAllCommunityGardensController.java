package com.rvt.api.domain.communitygarden.controllers;

import com.rvt.api.domain.communitygarden.dtos.CommunityGardenInfo;
import com.rvt.api.domain.communitygarden.services.FindAllCommunityGardensService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/community-garden")
@AllArgsConstructor
public class ListAllCommunityGardensController {
  private final FindAllCommunityGardensService service;
  
  @GetMapping
  public List<CommunityGardenInfo> index() {
    return service.findAll();
  }
}
