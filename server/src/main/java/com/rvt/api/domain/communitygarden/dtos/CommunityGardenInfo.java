package com.rvt.api.domain.communitygarden.dtos;

import com.rvt.api.domain.communitygarden.models.CommunityGarden;
import com.rvt.api.infra.envs.ImageServerProperties;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

@Getter
public class CommunityGardenInfo {
  private final String id;
  private final String name;
  private final BigDecimal latitude;
  private final BigDecimal longitude;
  private final String about;
  private final String instructions;
  private final String opening_hours;
  private final Boolean open_on_weekends;
  private final List<Map<String, String>> images;

  public CommunityGardenInfo(CommunityGarden communityGarden, ImageServerProperties staticFilesServer) {
    this.id = communityGarden.getId();
    this.name = communityGarden.getName();
    this.latitude = communityGarden.getLatitude();
    this.longitude = communityGarden.getLongitude();
    this.about = communityGarden.getAbout();
    this.instructions = communityGarden.getInstructions();
    this.opening_hours = communityGarden.getOpeningHours();
    this.open_on_weekends = communityGarden.getOpenOnWeekends();
    this.images = communityGarden.getImages().stream()
      .map(image -> Map.of("url", format("%s/%s", staticFilesServer.getHost(), image.getPath())))
        .toList();
  }
}
