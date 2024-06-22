package com.rvt.api.domain.communitygarden.services;

import com.rvt.api.domain.communitygarden.dtos.CommunityGardenInfo;
import com.rvt.api.domain.communitygarden.repositories.CommunityGardenRepository;
import com.rvt.api.infra.envs.ImageServerProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindAllCommunityGardensService {
  private final CommunityGardenRepository communityGardenRepository;
  private final ImageServerProperties statics;
  
  public List<CommunityGardenInfo> findAll() {
    var communityGardens = communityGardenRepository.findAll();
    return communityGardens.stream()
      .map(communityGarden -> new CommunityGardenInfo(communityGarden, statics))
      .toList();
  }
}
