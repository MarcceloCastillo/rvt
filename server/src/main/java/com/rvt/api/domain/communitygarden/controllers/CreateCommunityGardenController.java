package com.rvt.api.domain.communitygarden.controllers;

import com.rvt.api.domain.communitygarden.dtos.CreateCommunityGardenData;
import com.rvt.api.domain.communitygarden.dtos.CommunityGardenInfo;
import com.rvt.api.domain.communitygarden.services.CreateCommunityGardenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/community-garden")
@AllArgsConstructor
public class CreateCommunityGardenController {
  private final CreateCommunityGardenService service;
  
  @ResponseStatus(CREATED)
  @PostMapping(consumes = MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<CommunityGardenInfo> create(@ModelAttribute @Validated CreateCommunityGardenData data) {
    return ok(service.image(data));
  }
}
