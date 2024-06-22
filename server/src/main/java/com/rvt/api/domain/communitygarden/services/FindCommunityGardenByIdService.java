package com.rvt.api.domain.communitygarden.services;

import com.rvt.api.domain.communitygarden.dtos.CommunityGardenInfo;
import com.rvt.api.domain.communitygarden.repositories.CommunityGardenRepository;
import com.rvt.api.infra.envs.ImageServerProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@Service
@AllArgsConstructor
public class FindCommunityGardenByIdService {
  private final CommunityGardenRepository communityGardenRepository;
  private final ImageServerProperties statics;

  public CommunityGardenInfo find(String id) {
    var communityGarden = communityGardenRepository.findById(id)
      .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "community garden '%s' not found".formatted(id)));   
    return new CommunityGardenInfo(communityGarden, statics);
  }
}
